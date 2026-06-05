package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class Color {

    @JsonProperty("gamut")
    private Gamut gamut;

    @JsonProperty("gamut_type")
    private String gamutType;

    @JsonProperty("xy")
    private Xy xy;

    public Gamut getGamut() {
        return this.gamut;
    }

    public String getGamutType() {
        return this.gamutType;
    }

    public Xy getXy() {
        return this.xy;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
