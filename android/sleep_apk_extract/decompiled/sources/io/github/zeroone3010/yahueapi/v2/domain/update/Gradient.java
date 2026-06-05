package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.domain.JsonStringUtil;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Gradient {

    @JsonProperty("points")
    private List<GradientPoint> points;

    public List<GradientPoint> getPoints() {
        return this.points;
    }

    public Gradient setPoints(List<GradientPoint> list) {
        this.points = list;
        return this;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
