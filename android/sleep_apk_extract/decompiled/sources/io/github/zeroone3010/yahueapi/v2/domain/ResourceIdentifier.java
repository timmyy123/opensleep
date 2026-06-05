package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public class ResourceIdentifier {
    private UUID rid;
    private ResourceType rtype;

    @JsonProperty("rid")
    public UUID getResourceId() {
        return this.rid;
    }

    @JsonProperty("rtype")
    public ResourceType getResourceType() {
        return this.rtype;
    }

    @JsonProperty("rid")
    public void setResourceId(UUID uuid) {
        this.rid = uuid;
    }

    @JsonProperty("rtype")
    public void setResourceType(ResourceType resourceType) {
        this.rtype = resourceType;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
