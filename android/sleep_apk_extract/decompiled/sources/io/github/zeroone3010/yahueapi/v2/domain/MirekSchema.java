package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class MirekSchema {

    @JsonProperty("mirek_maximum")
    private int mirekMaximum;

    @JsonProperty("mirek_minimum")
    private int mirekMinimum;

    public int getMirekMaximum() {
        return this.mirekMaximum;
    }

    public int getMirekMinimum() {
        return this.mirekMinimum;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
