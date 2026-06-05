package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import org.achartengine.chart.BarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes5.dex */
public class RoundBarChart extends BarChart {
    private static final int roundX = 330;

    public RoundBarChart() {
        this.mType = BarChart.Type.DEFAULT;
    }

    @Override // org.achartengine.chart.BarChart
    public void drawBar(Canvas canvas, float f, float f2, float f3, float f4, int i, int i2, Paint paint) {
        float f5;
        float barWidth;
        float f6;
        float f7;
        float f8;
        int gradientPartialColor;
        Canvas canvas2 = canvas;
        if (f > f3) {
            barWidth = f;
            f5 = f3;
        } else {
            f5 = f;
            barWidth = f3;
        }
        if (f2 > f4) {
            f7 = f2;
            f6 = f4;
        } else {
            f6 = f2;
            f7 = f4;
        }
        SimpleSeriesRenderer seriesRendererAt = this.mRenderer.getSeriesRendererAt(i2);
        if (!seriesRendererAt.isGradientEnabled()) {
            if (Math.abs(f6 - f7) < 1.0f) {
                f7 = f6 < f7 ? f6 + 1.0f : f6 - 1.0f;
            }
            if (Math.abs(barWidth - f5) > this.mRenderer.getBarWidth() && this.mRenderer.getBarWidth() > 0.0f) {
                barWidth = this.mRenderer.getBarWidth() + f5;
            }
            canvas2.drawRoundRect(Math.round(f5), Math.round(f6), Math.round(barWidth), Math.round(f7), 330.0f, 330.0f, paint);
            return;
        }
        float f9 = (float) toScreenPoint(new double[]{0.0d, seriesRendererAt.getGradientStopValue()}, i)[1];
        float f10 = (float) toScreenPoint(new double[]{0.0d, seriesRendererAt.getGradientStartValue()}, i)[1];
        float fMax = Math.max(f9, Math.min(f6, f7));
        float fMin = Math.min(f10, Math.max(f6, f7));
        int gradientStopColor = seriesRendererAt.getGradientStopColor();
        int gradientStartColor = seriesRendererAt.getGradientStartColor();
        if (f6 < f9) {
            paint.setColor(gradientStopColor);
            f8 = f10;
            canvas2.drawRoundRect(new RectF(Math.round(f5), Math.round(f6), Math.round(barWidth), Math.round(fMax)), 330.0f, 330.0f, paint);
            gradientPartialColor = gradientStopColor;
        } else {
            f8 = f10;
            gradientPartialColor = getGradientPartialColor(gradientStopColor, gradientStartColor, (f8 - fMax) / (f8 - f9));
        }
        if (f7 > f8) {
            paint.setColor(gradientStartColor);
            canvas2.drawRoundRect(Math.round(f5), Math.round(fMin), Math.round(barWidth), Math.round(f7), 330.0f, 330.0f, paint);
            canvas2 = canvas2;
        } else {
            gradientStartColor = getGradientPartialColor(gradientStartColor, gradientStopColor, (fMin - f9) / (f8 - f9));
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{gradientStartColor, gradientPartialColor});
        gradientDrawable.setBounds(Math.round(f5), Math.round(fMax), Math.round(barWidth), Math.round(fMin));
        gradientDrawable.draw(canvas2);
    }

    public RoundBarChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, BarChart.Type type) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer, type);
    }

    @Override // org.achartengine.chart.BarChart
    public void drawBar(Canvas canvas, float f, float f2, float f3, float f4, float f5, int i, int i2, Paint paint) {
        if (Math.abs(f4 - f2) < 4.0f) {
            return;
        }
        int scaleNumber = this.mDataset.getSeriesAt(i2).getScaleNumber();
        BarChart.Type type = this.mType;
        if (type != BarChart.Type.STACKED && type != BarChart.Type.HEAPED) {
            float f6 = (f - (i * f5)) + (i2 * 2 * f5);
            drawBar(canvas, f6, f4, (f5 * 2.0f) + f6, f2, scaleNumber, i2, paint);
        } else {
            drawBar(canvas, f - f5, f4, f3 + f5, f2, scaleNumber, i2, paint);
        }
    }
}
