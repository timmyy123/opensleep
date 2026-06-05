package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class MotionReport {

    @JsonProperty("changed")
    private String changed;

    @JsonProperty("motion")
    private boolean motion;

    public String getChanged() {
        return this.changed;
    }

    public boolean isMotion() {
        return this.motion;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
