package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class ButtonSpecifics {

    @JsonProperty("last_event")
    private String lastEvent;

    public String getLastEvent() {
        return this.lastEvent;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
