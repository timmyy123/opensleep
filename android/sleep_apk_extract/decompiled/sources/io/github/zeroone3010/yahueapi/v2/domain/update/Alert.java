package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.domain.JsonStringUtil;

/* JADX INFO: loaded from: classes5.dex */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Alert {

    @JsonProperty("action")
    private AlertType action;

    public AlertType getAction() {
        return this.action;
    }

    public Alert setAction(AlertType alertType) {
        this.action = alertType;
        return this;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
