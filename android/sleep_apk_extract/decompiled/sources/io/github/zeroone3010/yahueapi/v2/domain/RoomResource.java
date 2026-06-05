package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@JsonTypeName("room")
public class RoomResource extends Resource implements GroupResource {

    @JsonProperty("children")
    private List<ResourceIdentifier> children;

    @JsonProperty("metadata")
    private Metadata metadata;

    @JsonProperty("services")
    private List<ResourceIdentifier> services;

    @Override // io.github.zeroone3010.yahueapi.v2.domain.GroupResource
    public List<ResourceIdentifier> getChildren() {
        return this.children;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.domain.GroupResource
    public Metadata getMetadata() {
        return this.metadata;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.domain.GroupResource
    public List<ResourceIdentifier> getServices() {
        return this.services;
    }

    public void setChildren(List<ResourceIdentifier> list) {
        this.children = list;
    }
}
