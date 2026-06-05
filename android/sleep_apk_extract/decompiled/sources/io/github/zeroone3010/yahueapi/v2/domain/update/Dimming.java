package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.domain.JsonStringUtil;

/* JADX INFO: loaded from: classes5.dex */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dimming {

    @JsonProperty("brightness")
    private int brightness;

    public int getBrightness() {
        return this.brightness;
    }

    public Dimming setBrightness(int i) {
        this.brightness = i;
        return this;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
