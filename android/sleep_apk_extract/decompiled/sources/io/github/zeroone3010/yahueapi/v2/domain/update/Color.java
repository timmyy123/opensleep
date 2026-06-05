package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.domain.JsonStringUtil;
import io.github.zeroone3010.yahueapi.v2.domain.Xy;

/* JADX INFO: loaded from: classes5.dex */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Color {

    @JsonProperty("xy")
    private Xy xy;

    public Xy getXy() {
        return this.xy;
    }

    public Color setXy(Xy xy) {
        this.xy = xy;
        return this;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
