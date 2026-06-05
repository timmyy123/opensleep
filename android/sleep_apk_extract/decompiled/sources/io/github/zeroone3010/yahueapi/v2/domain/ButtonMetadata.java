package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class ButtonMetadata {

    @JsonProperty("control_id")
    private int controlId;

    public int getControlId() {
        return this.controlId;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
