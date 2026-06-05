package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class Dimming {

    @JsonProperty("brightness")
    private int brightness;

    @JsonProperty("min_dim_level")
    private Integer minDimLevel;

    public int getBrightness() {
        return this.brightness;
    }

    public Integer getMinDimLevel() {
        return this.minDimLevel;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
