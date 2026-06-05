package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Alert {

    @JsonProperty("action_values")
    private List<String> actionValues;

    public List<String> getActionValues() {
        return this.actionValues;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
