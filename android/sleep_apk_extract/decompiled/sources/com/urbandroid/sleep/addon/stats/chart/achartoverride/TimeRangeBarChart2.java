package com.urbandroid.sleep.addon.stats.chart.achartoverride;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.RoundRangeBarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes5.dex */
public class TimeRangeBarChart2 extends RoundRangeBarChart {
    private String mDateFormat;

    public TimeRangeBarChart2(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, BarChart.Type type, String str) {
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
        TimeRangeBarChart2 timeRangeBarChart2 = this;
        Paint paint2 = paint;
        int size = list.size();
        boolean zIsShowLabels = timeRangeBarChart2.mRenderer.isShowLabels();
        boolean zIsShowGridX = timeRangeBarChart2.mRenderer.isShowGridX();
        if (size > 0) {
            DateFormat dateFormat = timeRangeBarChart2.getDateFormat(list.get(0).doubleValue(), list.get(size - 1).doubleValue());
            Iterator<Double> it = list.iterator();
            while (it.hasNext()) {
                long jRound = Math.round(it.next().doubleValue());
                float f = (float) (((jRound - d2) * d) + ((double) i));
                if (zIsShowLabels) {
                    paint2.setColor(timeRangeBarChart2.mRenderer.getLabelsColor());
                    float f2 = i3;
                    canvas.drawLine(f, f2, f, (timeRangeBarChart2.mRenderer.getLabelsTextSize() / 3.0f) + f2, paint2);
                    paint2 = paint;
                    timeRangeBarChart2.drawText(canvas, dateFormat.format(new Date(jRound)), f, ((timeRangeBarChart2.mRenderer.getLabelsTextSize() * 4.0f) / 3.0f) + f2, paint2, timeRangeBarChart2.mRenderer.getXLabelsAngle());
                    f = f;
                }
                TimeRangeBarChart2 timeRangeBarChart22 = timeRangeBarChart2;
                if (zIsShowGridX) {
                    paint2.setColor(timeRangeBarChart22.mRenderer.getGridColor(0));
                    float f3 = f;
                    canvas.drawLine(f3, i3, f3, i2, paint2);
                }
                paint2 = paint;
                timeRangeBarChart2 = timeRangeBarChart22;
            }
        }
    }
}
