package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class Motion {

    @JsonProperty("motion")
    private boolean motion;

    @JsonProperty("motion_report")
    private MotionReport motionReport;

    @JsonProperty("motion_valid")
    private boolean motionValid;

    public MotionReport getMotionReport() {
        return this.motionReport;
    }

    public boolean isMotion() {
        return this.motion;
    }

    public boolean isMotionValid() {
        return this.motionValid;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
