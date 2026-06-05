package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.domain.JsonStringUtil;

/* JADX INFO: loaded from: classes5.dex */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DimmingDelta {

    @JsonProperty("action")
    private DeltaAction action;

    @JsonProperty("brightness_delta")
    private int brightnessDelta;

    public DeltaAction getAction() {
        return this.action;
    }

    public int getBrightnessDelta() {
        return this.brightnessDelta;
    }

    public DimmingDelta setAction(DeltaAction deltaAction) {
        this.action = deltaAction;
        return this;
    }

    public DimmingDelta setBrightnessDelta(int i) {
        this.brightnessDelta = i;
        return this;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
