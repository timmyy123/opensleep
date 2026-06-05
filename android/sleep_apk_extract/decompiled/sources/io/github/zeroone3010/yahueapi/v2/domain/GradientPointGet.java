package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class GradientPointGet {

    @JsonProperty("color")
    private SimpleColor color;

    public SimpleColor getColor() {
        return this.color;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
