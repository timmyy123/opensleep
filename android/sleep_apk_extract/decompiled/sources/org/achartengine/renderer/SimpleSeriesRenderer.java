package org.achartengine.renderer;

import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.io.Serializable;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SimpleSeriesRenderer implements Serializable {
    private NumberFormat mChartValuesFormat;
    private int mGradientStartColor;
    private double mGradientStartValue;
    private int mGradientStopColor;
    private double mGradientStopValue;
    private int mColor = Color.BLUE;
    private boolean mGradientEnabled = false;
    private boolean mShowLegendItem = true;
    private boolean mDisplayBoundingPoints = true;

    public NumberFormat getChartValuesFormat() {
        return this.mChartValuesFormat;
    }

    public int getColor() {
        return this.mColor;
    }

    public int getGradientStartColor() {
        return this.mGradientStartColor;
    }

    public double getGradientStartValue() {
        return this.mGradientStartValue;
    }

    public int getGradientStopColor() {
        return this.mGradientStopColor;
    }

    public double getGradientStopValue() {
        return this.mGradientStopValue;
    }

    public BasicStroke getStroke() {
        return null;
    }

    public boolean isDisplayBoundingPoints() {
        return this.mDisplayBoundingPoints;
    }

    public boolean isGradientEnabled() {
        return this.mGradientEnabled;
    }

    public boolean isShowLegendItem() {
        return this.mShowLegendItem;
    }

    public void setColor(int i) {
        this.mColor = i;
    }
}
