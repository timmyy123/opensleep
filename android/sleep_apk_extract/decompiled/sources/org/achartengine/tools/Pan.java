package org.achartengine.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;

/* JADX INFO: loaded from: classes5.dex */
public class Pan extends AbstractTool {
    private boolean limitsReachedX;
    private boolean limitsReachedY;
    private List<Object> mPanListeners;

    public Pan(AbstractChart abstractChart) {
        super(abstractChart);
        this.mPanListeners = new ArrayList();
        this.limitsReachedX = false;
        this.limitsReachedY = false;
    }

    private double getAxisRatio(double[] dArr) {
        return Math.abs(dArr[1] - dArr[0]) / Math.abs(dArr[3] - dArr[2]);
    }

    private synchronized void notifyPanListeners() {
        try {
            Iterator<Object> it = this.mPanListeners.iterator();
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
    public void apply(float f, float f2, float f3, float f4) {
        double[] dArr;
        boolean z;
        boolean z2;
        char c;
        AbstractChart abstractChart = this.mChart;
        if (abstractChart instanceof XYChart) {
            int scalesCount = this.mRenderer.getScalesCount();
            double[] panLimits = this.mRenderer.getPanLimits();
            char c2 = 1;
            boolean z3 = panLimits != null && panLimits.length == 4;
            XYChart xYChart = (XYChart) this.mChart;
            boolean z4 = true;
            boolean z5 = true;
            boolean z6 = true;
            boolean z7 = true;
            int i = 0;
            while (i < scalesCount) {
                double[] range = getRange(i);
                double[] calcRange = xYChart.getCalcRange(i);
                if (this.limitsReachedX && this.limitsReachedY) {
                    if (range[0] == range[c2] && calcRange[0] == calcRange[c2]) {
                        return;
                    }
                    if (range[2] == range[3] && calcRange[2] == calcRange[3]) {
                        return;
                    }
                }
                checkRange(range, i);
                double[] realPoint = xYChart.toRealPoint(f, f2, i);
                double[] realPoint2 = xYChart.toRealPoint(f3, f4, i);
                double d = realPoint[0] - realPoint2[0];
                double d2 = realPoint[c2];
                double d3 = realPoint2[c2];
                boolean z8 = c2;
                boolean z9 = z3;
                double d4 = d2 - d3;
                double axisRatio = getAxisRatio(range);
                if (xYChart.isVertical(this.mRenderer)) {
                    double d5 = d / axisRatio;
                    d = (-d4) * axisRatio;
                    d4 = d5;
                }
                z4 = z4;
                if (this.mRenderer.isPanXEnabled()) {
                    if (panLimits != null) {
                        if (z4) {
                            z4 = panLimits[0] <= range[0] + d ? z8 ? 1 : 0 : false;
                        }
                        if (z5) {
                            z5 = panLimits[z8 ? 1 : 0] >= range[z8 ? 1 : 0] + d ? z8 ? 1 : 0 : false;
                        }
                    }
                    boolean z10 = z4;
                    boolean z11 = z5;
                    if (!z9 || (z10 && z11)) {
                        double d6 = range[0] + d;
                        double d7 = range[z8 ? 1 : 0] + d;
                        dArr = range;
                        setXRange(d6, d7, i);
                        this.limitsReachedX = false;
                        z = z10;
                        z2 = z11;
                    } else {
                        this.limitsReachedX = z8;
                        dArr = range;
                        z = z10;
                        z2 = z11;
                    }
                } else {
                    dArr = range;
                    z = z4 ? 1 : 0;
                    z2 = z5 ? 1 : 0;
                }
                if (this.mRenderer.isPanYEnabled()) {
                    if (panLimits != null) {
                        if (z6) {
                            z6 = panLimits[2] <= dArr[2] + d4;
                        }
                        if (z7) {
                            z7 = panLimits[3] >= dArr[3] + d4;
                        }
                    }
                    if (!z9 || (z6 && z7)) {
                        c = 1;
                        setYRange(dArr[2] + d4, dArr[3] + d4, i);
                        this.limitsReachedY = false;
                    } else {
                        c = 1;
                        this.limitsReachedY = true;
                    }
                } else {
                    c = 1;
                }
                i++;
                c2 = c;
                z4 = z;
                z5 = z2;
                z3 = z9;
            }
        } else {
            RoundChart roundChart = (RoundChart) abstractChart;
            roundChart.setCenterX(roundChart.getCenterX() + ((int) (f3 - f)));
            roundChart.setCenterY(roundChart.getCenterY() + ((int) (f4 - f2)));
        }
        notifyPanListeners();
    }
}
