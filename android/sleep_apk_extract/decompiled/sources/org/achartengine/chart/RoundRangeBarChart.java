package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.List;
import org.achartengine.chart.BarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* JADX INFO: loaded from: classes5.dex */
public class RoundRangeBarChart extends RoundBarChart {
    public static final String TYPE = "RangeBar";

    public RoundRangeBarChart() {
        this.mType = BarChart.Type.DEFAULT;
    }

    @Override // org.achartengine.chart.BarChart, org.achartengine.chart.XYChart
    public void drawChartValuesText(Canvas canvas, XYSeries xYSeries, XYSeriesRenderer xYSeriesRenderer, Paint paint, List<Float> list, int i, int i2) {
        int i3;
        int i4;
        int seriesCount = this.mDataset.getSeriesCount();
        float halfDiffX = getHalfDiffX(list, list.size(), seriesCount);
        for (int i5 = i2 > 0 ? 2 : 0; i5 < list.size(); i5 += 4) {
            int i6 = (i5 / 2) + i2;
            float fFloatValue = list.get(i5).floatValue();
            if (this.mType == BarChart.Type.DEFAULT) {
                fFloatValue += ((i * 2) * halfDiffX) - ((seriesCount - 1.5f) * halfDiffX);
            }
            float f = fFloatValue;
            int i7 = i6 + 1;
            if (!isNullValue(xYSeries.getY(i7)) && list.size() > (i4 = i5 + 3)) {
                drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY(i7)), f, list.get(i4).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, 0.0f);
            }
            if (!isNullValue(xYSeries.getY(i6)) && list.size() > (i3 = i5 + 1)) {
                drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY(i6)), f, (xYSeriesRenderer.getChartValuesSpacing() + (xYSeriesRenderer.getChartValuesTextSize() + list.get(i3).floatValue())) - 3.0f, paint, 0.0f);
            }
        }
    }

    @Override // org.achartengine.chart.BarChart, org.achartengine.chart.XYChart
    public void drawSeries(Canvas canvas, Paint paint, List<Float> list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        int seriesCount = this.mDataset.getSeriesCount();
        int size = list.size();
        paint.setColor(xYSeriesRenderer.getColor());
        paint.setStyle(Paint.Style.FILL);
        float halfDiffX = getHalfDiffX(list, size, seriesCount);
        for (int i3 = i2 > 0 ? 2 : 0; i3 < size; i3 += 4) {
            int i4 = i3 + 3;
            if (list.size() > i4) {
                drawBar(canvas, list.get(i3).floatValue(), list.get(i3 + 1).floatValue(), list.get(i3 + 2).floatValue(), list.get(i4).floatValue(), halfDiffX, seriesCount, i, paint);
            }
        }
        paint.setColor(xYSeriesRenderer.getColor());
    }

    @Override // org.achartengine.chart.BarChart, org.achartengine.chart.XYChart
    public String getChartType() {
        return "RangeBar";
    }

    @Override // org.achartengine.chart.BarChart
    public float getCoeficient() {
        return 0.5f;
    }

    public RoundRangeBarChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, BarChart.Type type) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer, type);
    }
}
