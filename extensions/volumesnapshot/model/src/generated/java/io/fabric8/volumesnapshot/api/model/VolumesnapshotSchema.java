
package io.fabric8.volumesnapshot.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshot",
    "github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotClass",
    "github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotClassList",
    "github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContent",
    "github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentList",
    "github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentSource",
    "github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentSpec",
    "github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentStatus",
    "github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotError",
    "github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotList",
    "github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotSource",
    "github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotSpec",
    "github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotStatus"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class VolumesnapshotSchema {

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshot")
    private VolumeSnapshot githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshot;
    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotClass")
    private VolumeSnapshotClass githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClass;
    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotClassList")
    private VolumeSnapshotClassList githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClassList;
    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContent")
    private VolumeSnapshotContent githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContent;
    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentList")
    private VolumeSnapshotContentList githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentList;
    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentSource")
    private VolumeSnapshotContentSource githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSource;
    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentSpec")
    private VolumeSnapshotContentSpec githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSpec;
    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentStatus")
    private VolumeSnapshotContentStatus githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentStatus;
    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotError")
    private VolumeSnapshotError githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotError;
    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotList")
    private VolumeSnapshotList githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotList;
    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotSource")
    private VolumeSnapshotSource githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSource;
    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotSpec")
    private VolumeSnapshotSpec githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSpec;
    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotStatus")
    private VolumeSnapshotStatus githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotStatus;

    /**
     * No args constructor for use in serialization
     * 
     */
    public VolumesnapshotSchema() {
    }

    /**
     * 
     * @param githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSource
     * @param githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClassList
     * @param githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSpec
     * @param githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentStatus
     * @param githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContent
     * @param githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSource
     * @param githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClass
     * @param githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotStatus
     * @param githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshot
     * @param githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotError
     * @param githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotList
     * @param githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentList
     * @param githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSpec
     */
    public VolumesnapshotSchema(VolumeSnapshot githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshot, VolumeSnapshotClass githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClass, VolumeSnapshotClassList githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClassList, VolumeSnapshotContent githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContent, VolumeSnapshotContentList githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentList, VolumeSnapshotContentSource githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSource, VolumeSnapshotContentSpec githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSpec, VolumeSnapshotContentStatus githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentStatus, VolumeSnapshotError githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotError, VolumeSnapshotList githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotList, VolumeSnapshotSource githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSource, VolumeSnapshotSpec githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSpec, VolumeSnapshotStatus githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotStatus) {
        super();
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshot = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshot;
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClass = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClass;
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClassList = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClassList;
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContent = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContent;
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentList = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentList;
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSource = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSource;
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSpec = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSpec;
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentStatus = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentStatus;
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotError = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotError;
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotList = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotList;
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSource = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSource;
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSpec = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSpec;
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotStatus = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotStatus;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshot")
    public VolumeSnapshot getGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshot() {
        return githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshot;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshot")
    public void setGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshot(VolumeSnapshot githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshot) {
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshot = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshot;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotClass")
    public VolumeSnapshotClass getGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClass() {
        return githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClass;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotClass")
    public void setGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClass(VolumeSnapshotClass githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClass) {
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClass = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClass;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotClassList")
    public VolumeSnapshotClassList getGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClassList() {
        return githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClassList;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotClassList")
    public void setGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClassList(VolumeSnapshotClassList githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClassList) {
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClassList = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotClassList;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContent")
    public VolumeSnapshotContent getGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContent() {
        return githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContent;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContent")
    public void setGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContent(VolumeSnapshotContent githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContent) {
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContent = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContent;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentList")
    public VolumeSnapshotContentList getGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentList() {
        return githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentList;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentList")
    public void setGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentList(VolumeSnapshotContentList githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentList) {
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentList = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentList;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentSource")
    public VolumeSnapshotContentSource getGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSource() {
        return githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSource;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentSource")
    public void setGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSource(VolumeSnapshotContentSource githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSource) {
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSource = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSource;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentSpec")
    public VolumeSnapshotContentSpec getGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSpec() {
        return githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSpec;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentSpec")
    public void setGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSpec(VolumeSnapshotContentSpec githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSpec) {
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSpec = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentSpec;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentStatus")
    public VolumeSnapshotContentStatus getGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentStatus() {
        return githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentStatus;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotContentStatus")
    public void setGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentStatus(VolumeSnapshotContentStatus githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentStatus) {
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentStatus = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotContentStatus;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotError")
    public VolumeSnapshotError getGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotError() {
        return githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotError;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotError")
    public void setGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotError(VolumeSnapshotError githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotError) {
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotError = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotError;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotList")
    public VolumeSnapshotList getGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotList() {
        return githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotList;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotList")
    public void setGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotList(VolumeSnapshotList githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotList) {
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotList = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotList;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotSource")
    public VolumeSnapshotSource getGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSource() {
        return githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSource;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotSource")
    public void setGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSource(VolumeSnapshotSource githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSource) {
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSource = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSource;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotSpec")
    public VolumeSnapshotSpec getGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSpec() {
        return githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSpec;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotSpec")
    public void setGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSpec(VolumeSnapshotSpec githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSpec) {
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSpec = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotSpec;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotStatus")
    public VolumeSnapshotStatus getGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotStatus() {
        return githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotStatus;
    }

    @JsonProperty("github_com_kubernetes-csi_external-snapshotter_client_v4_apis_volumesnapshot_v1_VolumeSnapshotStatus")
    public void setGithubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotStatus(VolumeSnapshotStatus githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotStatus) {
        this.githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotStatus = githubComKubernetesCsiExternalSnapshotterClientV4ApisVolumesnapshotV1VolumeSnapshotStatus;
    }

}
