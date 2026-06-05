package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.domain.JsonStringUtil;

/* JADX INFO: loaded from: classes5.dex */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GradientPoint {

    @JsonProperty("color")
    private Color color;

    public Color getColor() {
        return this.color;
    }

    public GradientPoint setColor(Color color) {
        this.color = color;
        return this;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
