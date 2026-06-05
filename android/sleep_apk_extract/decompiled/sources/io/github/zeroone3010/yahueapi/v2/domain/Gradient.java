package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Gradient {

    @JsonProperty("points")
    private List<GradientPointGet> points;

    @JsonProperty("points_capable")
    private int pointsCapable;

    public List<GradientPointGet> getPoints() {
        return this.points;
    }

    public int getPointsCapable() {
        return this.pointsCapable;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
