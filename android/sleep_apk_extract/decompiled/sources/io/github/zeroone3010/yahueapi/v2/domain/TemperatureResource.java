package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class TemperatureResource extends Resource {

    @JsonProperty("enabled")
    private boolean enabled;

    @JsonProperty("temperature")
    private Temperature temperature;

    public Temperature getTemperature() {
        return this.temperature;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.domain.Resource
    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
