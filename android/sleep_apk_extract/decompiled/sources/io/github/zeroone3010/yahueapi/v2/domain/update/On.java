package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.domain.JsonStringUtil;

/* JADX INFO: loaded from: classes5.dex */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class On {

    @JsonProperty("on")
    private boolean on;
    public static final On ON = new On(true);
    public static final On OFF = new On(false);

    public On(boolean z) {
        this.on = z;
    }

    public boolean isOn() {
        return this.on;
    }

    public On setOn(boolean z) {
        this.on = z;
        return this;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
