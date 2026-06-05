package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/* JADX INFO: loaded from: classes5.dex */
@JsonTypeName("scene")
public class SceneResource extends Resource {

    @JsonProperty("group")
    private ResourceIdentifier group;

    @JsonProperty("metadata")
    private Metadata metadata;

    public ResourceIdentifier getGroup() {
        return this.group;
    }

    public Metadata getMetadata() {
        return this.metadata;
    }
}
