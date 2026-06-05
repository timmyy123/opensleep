package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/* JADX INFO: loaded from: classes5.dex */
@JsonTypeName("bridge")
public class BridgeResource extends Resource {

    @JsonProperty("bridge_id")
    private String bridgeId;

    public String getBridgeId() {
        return this.bridgeId;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.domain.Resource
    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
