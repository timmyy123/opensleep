package com.philips.lighting.hue.sdk.utilities.impl;

/* JADX INFO: loaded from: classes4.dex */
public class PointF {
    public float x;
    public float y;

    public PointF(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public final boolean equals(float f, float f2) {
        return this.x == f && this.y == f2;
    }

    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
    }

    public final void offset(float f, float f2) {
        this.x += f;
        this.y += f2;
    }

    public final void set(PointF pointF) {
        this.x = pointF.x;
        this.y = pointF.y;
    }

    public PointF() {
    }

    public final void set(float f, float f2) {
        this.x = f;
        this.y = f2;
    }
}
