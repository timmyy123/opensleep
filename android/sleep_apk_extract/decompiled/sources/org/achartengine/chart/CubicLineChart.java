package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import java.util.List;
import org.achartengine.model.Point;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* JADX INFO: loaded from: classes5.dex */
public class CubicLineChart extends LineChart {
    public static final String TYPE = "Cubic";
    private float mFirstMultiplier;
    private PathMeasure mPathMeasure;
    private float mSecondMultiplier;

    public CubicLineChart() {
        this.mFirstMultiplier = 0.33f;
        this.mSecondMultiplier = 1.0f - 0.33f;
    }

    private void calc(List<Float> list, Point point, int i, int i2, float f) {
        float fFloatValue = list.get(i).floatValue();
        float fFloatValue2 = list.get(i + 1).floatValue();
        float fFloatValue3 = list.get(i2).floatValue();
        float fFloatValue4 = list.get(i2 + 1).floatValue() - fFloatValue2;
        point.setX(((fFloatValue3 - fFloatValue) * f) + fFloatValue);
        point.setY((fFloatValue4 * f) + fFloatValue2);
    }

    @Override // org.achartengine.chart.AbstractChart
    public void drawPath(Canvas canvas, List<Float> list, Paint paint, boolean z) {
        CubicLineChart cubicLineChart = this;
        List<Float> list2 = list;
        Path path = new Path();
        path.moveTo(list2.get(0).floatValue(), list2.get(1).floatValue());
        int size = list2.size();
        if (z) {
            size -= 4;
        }
        int i = size;
        Point point = new Point();
        Point point2 = new Point();
        Point point3 = new Point();
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 2;
            int i4 = i3 < i ? i3 : i2;
            int i5 = i2 + 4;
            int i6 = i5 < i ? i5 : i4;
            cubicLineChart.calc(list2, point, i2, i4, cubicLineChart.mSecondMultiplier);
            Point point4 = point;
            int i7 = i4;
            point2.setX(list2.get(i7).floatValue());
            point2.setY(list2.get(i7 + 1).floatValue());
            Point point5 = point3;
            cubicLineChart.calc(list2, point5, i7, i6, cubicLineChart.mFirstMultiplier);
            CubicLineChart cubicLineChart2 = cubicLineChart;
            Path path2 = path;
            path2.cubicTo(point4.getX(), point4.getY(), point2.getX(), point2.getY(), point5.getX(), point5.getY());
            path = path2;
            cubicLineChart = cubicLineChart2;
            i2 = i3;
            list2 = list2;
            point = point4;
            point3 = point5;
        }
        CubicLineChart cubicLineChart3 = cubicLineChart;
        List<Float> list3 = list2;
        Path path3 = path;
        cubicLineChart3.mPathMeasure = new PathMeasure(path3, false);
        if (z) {
            for (int i8 = i; i8 < i + 4; i8 += 2) {
                path3.lineTo(list3.get(i8).floatValue(), list3.get(i8 + 1).floatValue());
            }
            path3.lineTo(list3.get(0).floatValue(), list3.get(1).floatValue());
        }
        canvas.drawPath(path3, paint);
    }

    @Override // org.achartengine.chart.XYChart
    public void drawPoints(Canvas canvas, Paint paint, List<Float> list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        ScatterChart pointsChart;
        if (!isRenderPoints(xYSeriesRenderer) || (pointsChart = getPointsChart()) == null) {
            return;
        }
        int length = (int) this.mPathMeasure.getLength();
        int size = list.size();
        float[] fArr = new float[2];
        for (int i3 = 0; i3 < length; i3++) {
            this.mPathMeasure.getPosTan(i3, fArr, null);
            double d = Double.MAX_VALUE;
            boolean z = true;
            for (int i4 = 0; i4 < size && z; i4 += 2) {
                double dAbs = Math.abs(list.get(i4).floatValue() - fArr[0]);
                if (dAbs < 1.0d) {
                    list.set(i4 + 1, Float.valueOf(fArr[1]));
                    d = dAbs;
                }
                z = d > dAbs;
            }
        }
        pointsChart.drawSeries(canvas, paint, list, xYSeriesRenderer, f, i, i2);
    }

    @Override // org.achartengine.chart.LineChart, org.achartengine.chart.XYChart
    public String getChartType() {
        return TYPE;
    }

    public CubicLineChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, float f) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        this.mFirstMultiplier = f;
        this.mSecondMultiplier = 1.0f - f;
    }
}
