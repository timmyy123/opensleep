package com.urbandroid.sleep.addon.stats.chart.achartoverride;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.urbandroid.sleep.addon.stats.util.DateUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.RoundRangeBarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes5.dex */
public class TimeRangeBarChart extends RoundRangeBarChart {
    private String mDateFormat;

    public TimeRangeBarChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, BarChart.Type type, String str) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer, type);
        this.mDateFormat = str;
    }

    private DateFormat getDateFormat(double d, double d2) {
        if (this.mDateFormat != null) {
            try {
                return new SimpleDateFormat(this.mDateFormat);
            } catch (Exception unused) {
            }
        }
        double d3 = d2 - d;
        return (d3 <= 8.64E7d || d3 >= 4.32E8d) ? d3 < 8.64E7d ? DateFormat.getTimeInstance(2) : DateFormat.getDateInstance(2) : DateFormat.getDateTimeInstance(3, 3);
    }

    @Override // org.achartengine.chart.XYChart
    public void drawXLabels(List<Double> list, Double[] dArr, Canvas canvas, Paint paint, int i, int i2, int i3, double d, double d2, double d3) {
        TimeRangeBarChart timeRangeBarChart = this;
        Paint paint2 = paint;
        int size = list.size();
        boolean zIsShowLabels = timeRangeBarChart.mRenderer.isShowLabels();
        boolean zIsShowGridX = timeRangeBarChart.mRenderer.isShowGridX();
        if (size > 0) {
            DateFormat dateFormat = timeRangeBarChart.getDateFormat(list.get(0).doubleValue(), list.get(size - 1).doubleValue());
            Iterator<Double> it = list.iterator();
            while (it.hasNext()) {
                long jRound = Math.round(it.next().doubleValue());
                float f = (float) (((jRound - d2) * d) + ((double) i));
                if (zIsShowLabels) {
                    paint2.setColor(timeRangeBarChart.mRenderer.getLabelsColor());
                    float f2 = i3;
                    canvas.drawLine(f, f2, f, (timeRangeBarChart.mRenderer.getLabelsTextSize() / 3.0f) + f2, paint2);
                    paint2 = paint;
                    timeRangeBarChart.drawText(canvas, dateFormat.format(DateUtil.getDateSince(jRound)), f, ((timeRangeBarChart.mRenderer.getLabelsTextSize() * 4.0f) / 3.0f) + f2, paint2, timeRangeBarChart.mRenderer.getXLabelsAngle());
                    f = f;
                }
                TimeRangeBarChart timeRangeBarChart2 = timeRangeBarChart;
                if (zIsShowGridX) {
                    paint2.setColor(timeRangeBarChart2.mRenderer.getGridColor(0));
                    float f3 = f;
                    canvas.drawLine(f3, i3, f3, i2, paint2);
                }
                paint2 = paint;
                timeRangeBarChart = timeRangeBarChart2;
            }
        }
    }
}
