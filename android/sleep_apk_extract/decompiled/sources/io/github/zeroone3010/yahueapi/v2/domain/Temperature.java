package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes5.dex */
public class Temperature {

    @JsonProperty("temperature")
    private BigDecimal temperature;

    @JsonProperty("temperature_report")
    private TemperatureReport temperatureReport;

    @JsonProperty("temperature_valid")
    private boolean temperatureValid;

    public BigDecimal getTemperature() {
        return this.temperature;
    }

    public TemperatureReport getTemperatureReport() {
        return this.temperatureReport;
    }

    public boolean isTemperatureValid() {
        return this.temperatureValid;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
