package com.philips.lighting.hue.sdk.utilities.impl;

/* JADX INFO: loaded from: classes4.dex */
public class RectangleD {
    private PointD origin;
    private PointD size;

    public RectangleD(double d, double d2, double d3, double d4) {
        this.origin = new PointD(d, d2);
        this.size = new PointD(d3, d4);
    }

    public double getHeight() {
        return this.size.getY();
    }

    public PointD getOrigin() {
        return this.origin;
    }

    public PointD getSize() {
        return this.size;
    }

    public double getWidth() {
        return this.size.getX();
    }

    public double getX() {
        return this.origin.getX();
    }

    public double getY() {
        return this.origin.getY();
    }

    public RectangleD(PointD pointD, PointD pointD2) {
        this.origin = pointD;
        this.size = pointD2;
    }
}
