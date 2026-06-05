package io.github.zeroone3010.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.zeroone3010.yahueapi.v2.domain.JsonStringUtil;

/* JADX INFO: loaded from: classes5.dex */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dynamics {

    @JsonProperty("duration")
    private int duration;

    @JsonProperty("speed")
    private float speed;

    public int getDuration() {
        return this.duration;
    }

    public float getSpeed() {
        return this.speed;
    }

    public Dynamics setDuration(int i) {
        this.duration = i;
        return this;
    }

    public Dynamics setSpeed(float f) {
        this.speed = f;
        return this;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
