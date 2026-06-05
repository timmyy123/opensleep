package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleColor {

    @JsonProperty("xy")
    private Xy xy;

    public Xy getXy() {
        return this.xy;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
