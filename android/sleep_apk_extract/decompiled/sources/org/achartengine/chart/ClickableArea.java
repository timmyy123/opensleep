package org.achartengine.chart;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes5.dex */
public class ClickableArea {
    private RectF rect;
    private double x;
    private double y;

    public ClickableArea(RectF rectF, double d, double d2) {
        this.rect = rectF;
        this.x = d;
        this.y = d2;
    }

    public RectF getRect() {
        return this.rect;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
