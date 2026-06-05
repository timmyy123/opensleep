package org.achartengine.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes5.dex */
public class Zoom extends AbstractTool {
    private boolean limitsReachedX;
    private boolean limitsReachedY;
    private boolean mZoomIn;
    private List<Object> mZoomListeners;
    private float mZoomRate;

    public Zoom(AbstractChart abstractChart, boolean z, float f) {
        super(abstractChart);
        this.mZoomListeners = new ArrayList();
        this.limitsReachedX = false;
        this.limitsReachedY = false;
        this.mZoomIn = z;
        setZoomRate(f);
    }

    private synchronized void notifyZoomListeners(ZoomEvent zoomEvent) {
        try {
            Iterator<Object> it = this.mZoomListeners.iterator();
            if (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                throw null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void apply(int i) {
        int i2;
        double d;
        double zoomInLimitX;
        double zoomInLimitY;
        float f;
        AbstractChart abstractChart = this.mChart;
        if (abstractChart instanceof XYChart) {
            int scalesCount = this.mRenderer.getScalesCount();
            char c = 0;
            int i3 = 0;
            while (i3 < scalesCount) {
                double[] range = getRange(i3);
                checkRange(range, i3);
                double[] zoomLimits = this.mRenderer.getZoomLimits();
                double d2 = range[c];
                double d3 = range[1];
                double d4 = (d2 + d3) / 2.0d;
                char c2 = c;
                double d5 = range[2];
                double d6 = range[3];
                double d7 = (d5 + d6) / 2.0d;
                double d8 = d3 - d2;
                double d9 = d6 - d5;
                double d10 = d8 / 2.0d;
                double d11 = d4 - d10;
                double d12 = d10 + d4;
                double d13 = d9 / 2.0d;
                double d14 = d7 - d13;
                double d15 = d7 + d13;
                if (i3 == 0) {
                    this.limitsReachedX = (zoomLimits == null || (d11 > zoomLimits[c2] && d12 < zoomLimits[1])) ? c2 : 1;
                    this.limitsReachedY = (zoomLimits == null || (d14 > zoomLimits[2] && d15 < zoomLimits[3])) ? c2 : 1;
                }
                boolean z = this.mZoomIn;
                XYMultipleSeriesRenderer xYMultipleSeriesRenderer = this.mRenderer;
                if (z) {
                    if (!xYMultipleSeriesRenderer.isZoomXEnabled() || (!(i == 1 || i == 0) || (this.limitsReachedX && this.mZoomRate < 1.0f))) {
                        f = 1.0f;
                    } else {
                        f = 1.0f;
                        d8 /= (double) this.mZoomRate;
                    }
                    if (this.mRenderer.isZoomYEnabled() && ((i == 2 || i == 0) && (!this.limitsReachedY || this.mZoomRate >= f))) {
                        d9 /= (double) this.mZoomRate;
                    }
                } else {
                    if (xYMultipleSeriesRenderer.isZoomXEnabled() && !this.limitsReachedX && (i == 1 || i == 0)) {
                        d8 *= (double) this.mZoomRate;
                    }
                    if (this.mRenderer.isZoomYEnabled() && !this.limitsReachedY && (i == 2 || i == 0)) {
                        d9 *= (double) this.mZoomRate;
                    }
                }
                double d16 = d9;
                XYMultipleSeriesRenderer xYMultipleSeriesRenderer2 = this.mRenderer;
                if (zoomLimits != null) {
                    d = 2.0d;
                    i2 = 2;
                    zoomInLimitX = Math.min(xYMultipleSeriesRenderer2.getZoomInLimitX(), zoomLimits[1] - zoomLimits[c2]);
                    zoomInLimitY = Math.min(this.mRenderer.getZoomInLimitY(), zoomLimits[3] - zoomLimits[2]);
                } else {
                    i2 = 2;
                    d = 2.0d;
                    zoomInLimitX = xYMultipleSeriesRenderer2.getZoomInLimitX();
                    zoomInLimitY = this.mRenderer.getZoomInLimitY();
                }
                double dMax = Math.max(d8, zoomInLimitX);
                double dMax2 = Math.max(d16, zoomInLimitY);
                if (this.mRenderer.isZoomXEnabled() && (i == 1 || i == 0)) {
                    double d17 = dMax / d;
                    setXRange(d4 - d17, d4 + d17, i3);
                }
                if (this.mRenderer.isZoomYEnabled() && (i == i2 || i == 0)) {
                    double d18 = dMax2 / d;
                    setYRange(d7 - d18, d7 + d18, i3);
                }
                i3++;
                c = c2;
            }
        } else {
            DefaultRenderer renderer = ((RoundChart) abstractChart).getRenderer();
            if (this.mZoomIn) {
                renderer.setScale(renderer.getScale() * this.mZoomRate);
            } else {
                renderer.setScale(renderer.getScale() / this.mZoomRate);
            }
        }
        notifyZoomListeners(new ZoomEvent(this.mZoomIn, this.mZoomRate));
    }

    public synchronized void notifyZoomResetListeners() {
        try {
            Iterator<Object> it = this.mZoomListeners.iterator();
            if (it.hasNext()) {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                throw null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setZoomRate(float f) {
        this.mZoomRate = f;
    }
}
