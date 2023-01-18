/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fabric8.openshift.client.internal;

import com.fasterxml.jackson.databind.JsonNode;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReview;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.http.BasicBuilder;
import io.fabric8.kubernetes.client.http.HttpClient;
import io.fabric8.kubernetes.client.http.HttpHeaders;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.HttpResponse;
import io.fabric8.kubernetes.client.http.Interceptor;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.TokenRefreshInterceptor;
import io.fabric8.kubernetes.client.utils.URLUtils;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.LocalResourceAccessReview;
import io.fabric8.openshift.api.model.LocalSubjectAccessReview;
import io.fabric8.openshift.api.model.ResourceAccessReview;
import io.fabric8.openshift.api.model.SelfSubjectRulesReview;
import io.fabric8.openshift.api.model.SubjectAccessReview;
import io.fabric8.openshift.api.model.SubjectRulesReview;
import io.fabric8.openshift.client.OpenShiftConfig;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import static java.net.HttpURLConnection.HTTP_FORBIDDEN;
import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

public class OpenShiftOAuthInterceptor implements Interceptor {

  private static final String AUTHORIZATION = "Authorization";
  private static final String LOCATION = "Location";
  private static final String AUTHORIZATION_SERVER_PATH = ".well-known/oauth-authorization-server";
  private static final String AUTHORIZE_QUERY = "?response_type=token&client_id=openshift-challenging-client";

  private static final String BEFORE_TOKEN = "access_token=";
  private static final String AFTER_TOKEN = "&expires";
  private static final Set<String> RETRIABLE_RESOURCES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
    HasMetadata.getPlural(LocalSubjectAccessReview.class),
    HasMetadata.getPlural(LocalResourceAccessReview.class),
    HasMetadata.getPlural(ResourceAccessReview.class),
    HasMetadata.getPlural(SelfSubjectRulesReview.class),
    HasMetadata.getPlural(SubjectRulesReview.class),
    HasMetadata.getPlural(SubjectAccessReview.class),
    HasMetadata.getPlural(SelfSubjectAccessReview.class)
    )));

  private final HttpClient client;
  private final OpenShiftConfig config;
  private final AtomicReference<String> oauthToken = new AtomicReference<>();

  public OpenShiftOAuthInterceptor(HttpClient client, OpenShiftConfig config) {
    this.client = client;
    this.config = config;
  }

  @Override
  public void before(BasicBuilder builder, HttpHeaders headers) {
    String token = oauthToken.get();
    // avoid overwriting basic auth token with stale bearer token
    if (Utils.isNotNullOrEmpty(token) && (headers.headers(AUTHORIZATION).isEmpty() || Utils.isNullOrEmpty(headers.headers(AUTHORIZATION).get(0)))) {
      setAuthHeader(builder, token);
    }
  }

  @Override
  public boolean afterFailure(BasicBuilder builder, HttpResponse<?> response) {
    if (shouldProceed(response.request(), response)) {
      return false;
    }

    String token = oauthToken.get();

    if (Utils.isNotNullOrEmpty(config.getUsername()) && Utils.isNotNullOrEmpty(config.getPassword())) {
      synchronized (client) {
        // current token (if exists) is borked, don't resend
        oauthToken.set(null);
        token = authorize();
        if (token != null) {
          oauthToken.set(token);
        }
      }
    } else if (Utils.isNotNullOrEmpty(config.getOauthToken())) {
      token = config.getOauthToken();
      oauthToken.set(token);
    }

    //If token was obtained, then retry request using the obtained token.
    if (Utils.isNotNullOrEmpty(token)) {
      setAuthHeader(builder, token);
      return true;
    }

    return false;
  }

  private void setAuthHeader(BasicBuilder builder, String token) {
    if (token != null) {
      builder.setHeader(AUTHORIZATION, String.format("Bearer %s", token));
    }
  }

  private  String authorize() {
    try {
      HttpClient.Builder builder = client.newBuilder();
      builder.addOrReplaceInterceptor(TokenRefreshInterceptor.NAME, null);
      HttpClient clone = builder.build();

      URL url = new URL(URLUtils.join(config.getMasterUrl(), AUTHORIZATION_SERVER_PATH));
      HttpResponse<String> response = clone.send(clone.newHttpRequestBuilder().url(url).build(), String.class);

      if (!response.isSuccessful() || response.body() == null) {
        throw new KubernetesClientException("Unexpected response (" + response.code() + " " + response.message() + ")");
      }

      String body = response.body();
      JsonNode jsonResponse = Serialization.jsonMapper().readTree(body);
      String authorizationServer = jsonResponse.get("authorization_endpoint").asText();

      url = new URL(authorizationServer + AUTHORIZE_QUERY);

      String credential = HttpClientUtils.basicCredentials(config.getUsername(), config.getPassword());
      response = clone.send(client.newHttpRequestBuilder().url(url).setHeader(AUTHORIZATION, credential).build(), String.class);

      response = response.previousResponse().isPresent() ? response.previousResponse().get() : response;

      List<String> location = response.headers(LOCATION);
      String token = !location.isEmpty() ? location.get(0) : null;
      if (token == null || token.isEmpty()) {
        throw new KubernetesClientException("Unexpected response (" + response.code() + " " + response.message() + "), to the authorization request. Missing header:[" + LOCATION + "]!");
      }
      token = token.substring(token.indexOf(BEFORE_TOKEN) + BEFORE_TOKEN.length());
      token = token.substring(0, token.indexOf(AFTER_TOKEN));
      return token;
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  private boolean shouldProceed(HttpRequest request, HttpResponse<?> response) {
    String url = request.uri().toString();
    String method = request.method();
    // always retry in case of authorization endpoints; since they also return 200 when no
    // authorization header is provided
    if (method.equals("POST") && RETRIABLE_RESOURCES.stream().anyMatch(url::endsWith)) {
      return false;
    }
    return response.code() != HTTP_UNAUTHORIZED && response.code() != HTTP_FORBIDDEN;
  }
}
