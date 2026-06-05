package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class Gamut {

    @JsonProperty("blue")
    private Xy blue;

    @JsonProperty("green")
    private Xy green;

    @JsonProperty("red")
    private Xy red;

    public Xy getBlue() {
        return this.blue;
    }

    public Xy getGreen() {
        return this.green;
    }

    public Xy getRed() {
        return this.red;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
