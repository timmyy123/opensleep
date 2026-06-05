package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class Metadata {

    @JsonProperty("archetype")
    private String archetype;

    @JsonProperty("name")
    private String name;

    public String getArchetype() {
        return this.archetype;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
