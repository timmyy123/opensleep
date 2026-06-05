package io.github.zeroone3010.yahueapi.v2.domain;

import com.facebook.internal.AnalyticsEvents;
import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class Sensitivity {

    @JsonProperty("sensitivity_max")
    private int maxSensitivity;

    @JsonProperty("sensitivity")
    private int sensitivity;

    @JsonProperty(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)
    private String status;

    public int getSensitivity() {
        return this.sensitivity;
    }

    public int getSensitivityMax() {
        return this.maxSensitivity;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
