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
package io.fabric8.openshift.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.AppliedClusterResourceQuota;
import io.fabric8.openshift.api.model.AppliedClusterResourceQuotaList;
import io.fabric8.openshift.api.model.ClusterResourceQuota;
import io.fabric8.openshift.api.model.ClusterResourceQuotaList;
import io.fabric8.openshift.client.dsl.OpenShiftQuotaAPIGroupDSL;
import io.fabric8.openshift.client.dsl.internal.AppliedClusterResourceQuotaOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ClusterResourceQuotaOperationsImpl;
import okhttp3.OkHttpClient;

public class OpenShiftQuotaAPIGroupClient extends BaseClient implements OpenShiftQuotaAPIGroupDSL {
  public OpenShiftQuotaAPIGroupClient() {
    super();
  }

  public OpenShiftQuotaAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<AppliedClusterResourceQuota, AppliedClusterResourceQuotaList, Resource<AppliedClusterResourceQuota>> appliedClusterResourceQuotas() {
    return new AppliedClusterResourceQuotaOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<ClusterResourceQuota, ClusterResourceQuotaList, Resource<ClusterResourceQuota>> clusterResourceQuotas() {
    return new ClusterResourceQuotaOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }
}
