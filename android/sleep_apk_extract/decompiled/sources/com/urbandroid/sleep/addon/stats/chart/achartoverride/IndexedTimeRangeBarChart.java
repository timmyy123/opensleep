package com.urbandroid.sleep.addon.stats.chart.achartoverride;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.List;
import kotlin.Metadata;
import org.achartengine.chart.BarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJH\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016JZ\u0010\u001b\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011JT\u0010\u001b\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006$"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/chart/achartoverride/IndexedTimeRangeBarChart;", "Lcom/urbandroid/sleep/addon/stats/chart/achartoverride/TimeRangeBarChart;", "dataset", "Lorg/achartengine/model/XYMultipleSeriesDataset;", "renderer", "Lorg/achartengine/renderer/XYMultipleSeriesRenderer;", "type", "Lorg/achartengine/chart/BarChart$Type;", "mDateFormat", "", "<init>", "(Lorg/achartengine/model/XYMultipleSeriesDataset;Lorg/achartengine/renderer/XYMultipleSeriesRenderer;Lorg/achartengine/chart/BarChart$Type;Ljava/lang/String;)V", "drawSeries", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "points", "", "", "seriesRenderer", "Lorg/achartengine/renderer/XYSeriesRenderer;", "yAxisValue", "seriesIndex", "", "startIndex", "drawBar", "xMin", "yMin", "xMax", "yMax", "halfDiffX", "seriesNr", "index", "scale", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class IndexedTimeRangeBarChart extends TimeRangeBarChart {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndexedTimeRangeBarChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, BarChart.Type type, String str) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer, type, str);
        xYMultipleSeriesDataset.getClass();
        xYMultipleSeriesRenderer.getClass();
        type.getClass();
        str.getClass();
    }

    public final void drawBar(Canvas canvas, float xMin, float yMin, float xMax, float yMax, float halfDiffX, int seriesNr, int seriesIndex, int index, Paint paint) {
        int scaleNumber = this.mDataset.getSeriesAt(seriesIndex).getScaleNumber();
        BarChart.Type type = this.mType;
        if (type == BarChart.Type.STACKED || type == BarChart.Type.HEAPED) {
            drawBar(canvas, xMin - halfDiffX, yMax, xMax + halfDiffX, yMin, scaleNumber, seriesIndex, index, paint);
        } else {
            float f = (xMin - (seriesNr * halfDiffX)) + (seriesIndex * 2 * halfDiffX);
            drawBar(canvas, f, yMax, (halfDiffX * 2.0f) + f, yMin, scaleNumber, seriesIndex, index, paint);
        }
    }

    public abstract void drawBar(Canvas canvas, float xMin, float yMin, float xMax, float yMax, int scale, int seriesIndex, int index, Paint paint);

    @Override // org.achartengine.chart.RoundRangeBarChart, org.achartengine.chart.BarChart, org.achartengine.chart.XYChart
    public void drawSeries(Canvas canvas, Paint paint, List<Float> points, XYSeriesRenderer seriesRenderer, float yAxisValue, int seriesIndex, int startIndex) {
        paint.getClass();
        points.getClass();
        seriesRenderer.getClass();
        int seriesCount = this.mDataset.getSeriesCount();
        int size = points.size();
        paint.setColor(seriesRenderer.getColor());
        paint.setStyle(Paint.Style.FILL);
        float halfDiffX = getHalfDiffX(points, size, seriesCount);
        int i = startIndex > 0 ? 2 : 0;
        int i2 = seriesIndex;
        this.mDataset.getSeriesAt(i2).getXYMap().size();
        int i3 = i;
        while (i3 < size) {
            int i4 = (i3 / 4) + (startIndex / 2) + 1;
            int i5 = i3 + 3;
            if (points.size() > i5) {
                drawBar(canvas, points.get(i3).floatValue(), points.get(i3 + 1).floatValue(), points.get(i3 + 2).floatValue(), points.get(i5).floatValue(), halfDiffX, seriesCount, i2, i4, paint);
            }
            i3 += 4;
            i2 = seriesIndex;
        }
        paint.setColor(seriesRenderer.getColor());
    }
}
