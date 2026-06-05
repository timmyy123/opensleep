package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/* JADX INFO: loaded from: classes5.dex */
@JsonTypeName("grouped_light")
public class GroupedLightResource extends Resource {

    @JsonProperty("alert")
    private Alert alert;

    @JsonProperty("on")
    private On on;

    public Alert getAlert() {
        return this.alert;
    }

    public On getOn() {
        return this.on;
    }
}
