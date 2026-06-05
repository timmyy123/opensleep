package org.achartengine.chart;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class PieSegment implements Serializable {
    private int mDataIndex;
    private float mEndAngle;
    private float mStartAngle;
    private float mValue;

    public PieSegment(int i, float f, float f2, float f3) {
        this.mStartAngle = f2;
        this.mEndAngle = f3 + f2;
        this.mDataIndex = i;
        this.mValue = f;
    }

    public int getDataIndex() {
        return this.mDataIndex;
    }

    public float getEndAngle() {
        return this.mEndAngle;
    }

    public float getStartAngle() {
        return this.mStartAngle;
    }

    public float getValue() {
        return this.mValue;
    }

    public boolean isInSegment(double d) {
        float f = this.mStartAngle;
        if (d >= f && d <= this.mEndAngle) {
            return true;
        }
        double d2 = d % 360.0d;
        double d3 = f;
        double d4 = this.mEndAngle;
        while (d4 > 360.0d) {
            d3 -= 360.0d;
            d4 -= 360.0d;
        }
        return d2 >= d3 && d2 <= d4;
    }

    public String toString() {
        return "mDataIndex=" + this.mDataIndex + ",mValue=" + this.mValue + ",mStartAngle=" + this.mStartAngle + ",mEndAngle=" + this.mEndAngle;
    }
}
