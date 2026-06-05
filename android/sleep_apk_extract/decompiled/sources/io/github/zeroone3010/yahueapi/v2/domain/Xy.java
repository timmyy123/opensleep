package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class Xy {

    @JsonProperty("x")
    private float x;

    @JsonProperty("y")
    private float y;

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public Xy setX(float f) {
        this.x = f;
        return this;
    }

    public Xy setY(float f) {
        this.y = f;
        return this;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
