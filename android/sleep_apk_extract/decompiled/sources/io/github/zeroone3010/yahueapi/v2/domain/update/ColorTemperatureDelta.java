package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.domain.JsonStringUtil;

/* JADX INFO: loaded from: classes5.dex */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColorTemperatureDelta {

    @JsonProperty("action")
    private DeltaAction action;

    @JsonProperty("brightness_delta")
    private int mirekDelta;

    public DeltaAction getAction() {
        return this.action;
    }

    public int getMirekDelta() {
        return this.mirekDelta;
    }

    public ColorTemperatureDelta setAction(DeltaAction deltaAction) {
        this.action = deltaAction;
        return this;
    }

    public ColorTemperatureDelta setMirekDelta(int i) {
        this.mirekDelta = i;
        return this;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
