package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class On {

    @JsonProperty("on")
    private boolean on;

    public boolean isOn() {
        return this.on;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
