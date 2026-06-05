package io.github.zeroone3010.yahueapi.v2.domain;

import com.facebook.internal.AnalyticsEvents;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Dynamics {

    @JsonProperty("speed")
    private float speed;

    @JsonProperty("speed_valid")
    private boolean speedValid;

    @JsonProperty(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)
    private String status;

    @JsonProperty("status_values")
    private List<String> statusValues;

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
