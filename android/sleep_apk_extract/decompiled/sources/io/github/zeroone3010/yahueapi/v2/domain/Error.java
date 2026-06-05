package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class Error {

    @JsonProperty("description")
    private String description;

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
