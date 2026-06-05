package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes5.dex */
public class TemperatureReport {

    @JsonProperty("changed")
    private String changed;

    @JsonProperty("temperature")
    private BigDecimal temperature;

    public String getChanged() {
        return this.changed;
    }

    public BigDecimal getTemperature() {
        return this.temperature;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
