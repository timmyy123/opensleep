package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class MotionResource extends Resource {

    @JsonProperty("enabled")
    private boolean enabled;

    @JsonProperty("motion")
    private Motion motion;

    @JsonProperty("sensitivity")
    private Sensitivity sensitivity;

    public Motion getMotion() {
        return this.motion;
    }

    public Sensitivity getSensitivity() {
        return this.sensitivity;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.domain.Resource
    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
