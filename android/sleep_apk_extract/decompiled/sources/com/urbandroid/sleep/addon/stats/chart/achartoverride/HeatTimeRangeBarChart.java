package com.urbandroid.sleep.addon.stats.chart.achartoverride;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import com.urbandroid.common.logging.Logger;
import java.util.List;
import org.achartengine.chart.BarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes5.dex */
public class HeatTimeRangeBarChart extends IndexedTimeRangeBarChart {
    private List<float[]> heatMap;

    public HeatTimeRangeBarChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, BarChart.Type type, String str, List<float[]> list) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer, type, str);
        this.heatMap = list;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.achartoverride.IndexedTimeRangeBarChart
    public void drawBar(Canvas canvas, float f, float f2, float f3, float f4, int i, int i2, int i3, Paint paint) {
        int i4;
        int i5;
        Canvas canvas2;
        SimpleSeriesRenderer seriesRendererAt = this.mRenderer.getSeriesRendererAt(i2);
        if (!seriesRendererAt.isGradientEnabled()) {
            int color = paint.getColor();
            paint.setStyle(Paint.Style.FILL);
            float[] fArr = new float[0];
            try {
                fArr = this.heatMap.get(i3);
            } catch (Exception e) {
                Logger.logSevere(e);
            }
            if (fArr == null || fArr.length <= 5) {
                paint.setColor(Color.argb(200, 0, 0, 100));
                canvas.drawRect(Math.round(f), Math.round(f2), Math.round(f3), Math.round(f4), paint);
            } else {
                float f5 = fArr[0];
                float f6 = fArr[1];
                int length = fArr.length - 2;
                int[] iArr = new int[length];
                for (int i6 = 0; i6 < length; i6++) {
                    iArr[i6] = Color.argb(200, 0, (int) (((fArr[i6 + 2] - f5) / f6) * 254.0f), 100);
                }
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, iArr);
                gradientDrawable.setBounds(Math.round(f), Math.round(f2), Math.round(f3), Math.round(f4));
                gradientDrawable.draw(canvas);
            }
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(color);
            canvas.drawRect(Math.round(f), Math.round(f2), Math.round(f3), Math.round(f4), paint);
            paint.setStyle(Paint.Style.FILL);
            return;
        }
        float f7 = (float) toScreenPoint(new double[]{0.0d, seriesRendererAt.getGradientStopValue()}, i)[1];
        float f8 = (float) toScreenPoint(new double[]{0.0d, seriesRendererAt.getGradientStartValue()}, i)[1];
        float fMax = Math.max(f7, f2);
        float fMin = Math.min(f8, f4);
        int gradientStopColor = seriesRendererAt.getGradientStopColor();
        int gradientStartColor = seriesRendererAt.getGradientStartColor();
        if (f2 < f7) {
            paint.setColor(gradientStopColor);
            i5 = gradientStartColor;
            i4 = gradientStopColor;
            canvas.drawRect(Math.round(f), Math.round(f2), Math.round(f3), Math.round(fMax), paint);
        } else {
            i4 = gradientStopColor;
            i5 = gradientStartColor;
            getGradientPartialColor(i4, i5, (f8 - fMax) / (f8 - f7));
        }
        if (f4 > f8) {
            paint.setColor(i5);
            canvas2 = canvas;
            canvas2.drawRect(Math.round(f), Math.round(fMin), Math.round(f3), Math.round(f4), paint);
        } else {
            canvas2 = canvas;
            getGradientPartialColor(i5, i4, (fMin - f7) / (f8 - f7));
        }
        if (i3 < this.heatMap.size()) {
            float[] fArr2 = this.heatMap.get(i3);
            if (fArr2.length > 30) {
                int length2 = fArr2.length;
                int[] iArr2 = new int[length2];
                for (int i7 = 0; i7 < length2; i7++) {
                    iArr2[i7] = Color.argb(200, 0, (int) (fArr2[i7] * 50.0f), 50);
                }
            }
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{com.philips.lighting.hue.sdk.utilities.impl.Color.BLUE, com.philips.lighting.hue.sdk.utilities.impl.Color.CYAN});
        gradientDrawable2.setBounds(Math.round(f), Math.round(fMax), Math.round(f3), Math.round(fMin));
        gradientDrawable2.draw(canvas2);
    }
}
