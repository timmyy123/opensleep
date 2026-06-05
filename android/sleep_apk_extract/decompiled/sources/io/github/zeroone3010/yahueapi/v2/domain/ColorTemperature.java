package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class ColorTemperature {

    @JsonProperty("mirek")
    private int mirek;

    @JsonProperty("mirek_schema")
    private MirekSchema mirekSchema;

    @JsonProperty("mirek_valid")
    private boolean mirekValid;

    public int getMirek() {
        return this.mirek;
    }

    public MirekSchema getMirekSchema() {
        return this.mirekSchema;
    }

    public boolean isMirekValid() {
        return this.mirekValid;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
