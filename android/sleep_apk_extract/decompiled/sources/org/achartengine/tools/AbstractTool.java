package org.achartengine.tools;

import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.XYChart;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractTool {
    protected AbstractChart mChart;
    protected XYMultipleSeriesRenderer mRenderer;

    public AbstractTool(AbstractChart abstractChart) {
        this.mChart = abstractChart;
        if (abstractChart instanceof XYChart) {
            this.mRenderer = ((XYChart) abstractChart).getRenderer();
        }
    }

    public void checkRange(double[] dArr, int i) {
        double[] calcRange;
        AbstractChart abstractChart = this.mChart;
        if (!(abstractChart instanceof XYChart) || (calcRange = ((XYChart) abstractChart).getCalcRange(i)) == null) {
            return;
        }
        if (!this.mRenderer.isMinXSet(i)) {
            double d = calcRange[0];
            dArr[0] = d;
            this.mRenderer.setXAxisMin(d, i);
        }
        if (!this.mRenderer.isMaxXSet(i)) {
            double d2 = calcRange[1];
            dArr[1] = d2;
            this.mRenderer.setXAxisMax(d2, i);
        }
        if (!this.mRenderer.isMinYSet(i)) {
            double d3 = calcRange[2];
            dArr[2] = d3;
            this.mRenderer.setYAxisMin(d3, i);
        }
        if (this.mRenderer.isMaxYSet(i)) {
            return;
        }
        double d4 = calcRange[3];
        dArr[3] = d4;
        this.mRenderer.setYAxisMax(d4, i);
    }

    public double[] getRange(int i) {
        return new double[]{this.mRenderer.getXAxisMin(i), this.mRenderer.getXAxisMax(i), this.mRenderer.getYAxisMin(i), this.mRenderer.getYAxisMax(i)};
    }

    public void setXRange(double d, double d2, int i) {
        this.mRenderer.setXAxisMin(d, i);
        this.mRenderer.setXAxisMax(d2, i);
    }

    public void setYRange(double d, double d2, int i) {
        this.mRenderer.setYAxisMin(d, i);
        this.mRenderer.setYAxisMax(d2, i);
    }
}
