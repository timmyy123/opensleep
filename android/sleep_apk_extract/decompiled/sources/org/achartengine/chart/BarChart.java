package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* JADX INFO: loaded from: classes5.dex */
public class BarChart extends XYChart {
    private static final int SHAPE_WIDTH = 12;
    public static final String TYPE = "Bar";
    private List<Float> mPreviousSeriesPoints;
    protected Type mType;

    public enum Type {
        DEFAULT,
        STACKED,
        HEAPED
    }

    public BarChart() {
        this.mType = Type.DEFAULT;
    }

    @Override // org.achartengine.chart.XYChart
    public ClickableArea[] clickableAreasForPoints(List<Float> list, List<Double> list2, float f, int i, int i2) {
        BarChart barChart = this;
        int seriesCount = barChart.mDataset.getSeriesCount();
        int size = list.size();
        ClickableArea[] clickableAreaArr = new ClickableArea[size / 2];
        float halfDiffX = barChart.getHalfDiffX(list, size, seriesCount);
        int i3 = 0;
        while (i3 < size) {
            float fFloatValue = list.get(i3).floatValue();
            int i4 = i3 + 1;
            float fFloatValue2 = list.get(i4).floatValue();
            Type type = barChart.mType;
            if (type == Type.STACKED || type == Type.HEAPED) {
                clickableAreaArr[i3 / 2] = new ClickableArea(new RectF(fFloatValue - halfDiffX, Math.min(fFloatValue2, f), fFloatValue + halfDiffX, Math.max(fFloatValue2, f)), list2.get(i3).doubleValue(), list2.get(i4).doubleValue());
            } else {
                float f2 = (i * 2 * halfDiffX) + (fFloatValue - (seriesCount * halfDiffX));
                clickableAreaArr[i3 / 2] = new ClickableArea(new RectF(f2, Math.min(fFloatValue2, f), (2.0f * halfDiffX) + f2, Math.max(fFloatValue2, f)), list2.get(i3).doubleValue(), list2.get(i4).doubleValue());
            }
            i3 += 2;
            barChart = this;
        }
        return clickableAreaArr;
    }

    public void drawBar(Canvas canvas, float f, float f2, float f3, float f4, int i, int i2, Paint paint) {
        float f5;
        float f6;
        float f7;
        float f8;
        int gradientPartialColor;
        if (f > f3) {
            f6 = f;
            f5 = f3;
        } else {
            f5 = f;
            f6 = f3;
        }
        if (f2 > f4) {
            f8 = f2;
            f7 = f4;
        } else {
            f7 = f2;
            f8 = f4;
        }
        SimpleSeriesRenderer seriesRendererAt = this.mRenderer.getSeriesRendererAt(i2);
        if (!seriesRendererAt.isGradientEnabled()) {
            if (Math.abs(f7 - f8) < 1.0f) {
                f8 = f7 < f8 ? f7 + 1.0f : f7 - 1.0f;
            }
            canvas.drawRect(Math.round(f5), Math.round(f7), Math.round(f6), Math.round(f8), paint);
            return;
        }
        float f9 = (float) toScreenPoint(new double[]{0.0d, seriesRendererAt.getGradientStopValue()}, i)[1];
        float f10 = (float) toScreenPoint(new double[]{0.0d, seriesRendererAt.getGradientStartValue()}, i)[1];
        float fMax = Math.max(f9, Math.min(f7, f8));
        float fMin = Math.min(f10, Math.max(f7, f8));
        int gradientStopColor = seriesRendererAt.getGradientStopColor();
        int gradientStartColor = seriesRendererAt.getGradientStartColor();
        if (f7 < f9) {
            paint.setColor(gradientStopColor);
            canvas.drawRect(Math.round(f5), Math.round(f7), Math.round(f6), Math.round(fMax), paint);
            gradientPartialColor = gradientStopColor;
        } else {
            gradientPartialColor = getGradientPartialColor(gradientStopColor, gradientStartColor, (f10 - fMax) / (f10 - f9));
        }
        if (f8 > f10) {
            paint.setColor(gradientStartColor);
            canvas.drawRect(Math.round(f5), Math.round(fMin), Math.round(f6), Math.round(f8), paint);
        } else {
            gradientStartColor = getGradientPartialColor(gradientStartColor, gradientStopColor, (fMin - f9) / (f10 - f9));
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{gradientStartColor, gradientPartialColor});
        gradientDrawable.setBounds(Math.round(f5), Math.round(fMax), Math.round(f6), Math.round(fMin));
        gradientDrawable.draw(canvas);
    }

    @Override // org.achartengine.chart.XYChart
    public void drawChartValuesText(Canvas canvas, XYSeries xYSeries, XYSeriesRenderer xYSeriesRenderer, Paint paint, List<Float> list, int i, int i2) {
        int seriesCount = this.mDataset.getSeriesCount();
        int size = list.size();
        float halfDiffX = getHalfDiffX(list, size, seriesCount);
        for (int i3 = 0; i3 < size; i3 += 2) {
            double y = xYSeries.getY((i3 / 2) + i2);
            if (!isNullValue(y)) {
                float fFloatValue = list.get(i3).floatValue();
                if (this.mType == Type.DEFAULT) {
                    fFloatValue += ((i * 2) * halfDiffX) - ((seriesCount - 1.5f) * halfDiffX);
                }
                if (y >= 0.0d) {
                    drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), y), fFloatValue, list.get(i3 + 1).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, 0.0f);
                } else {
                    drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), y), fFloatValue, (xYSeriesRenderer.getChartValuesSpacing() + (xYSeriesRenderer.getChartValuesTextSize() + list.get(i3 + 1).floatValue())) - 3.0f, paint, 0.0f);
                }
            }
        }
    }

    @Override // org.achartengine.chart.AbstractChart
    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint) {
        canvas.drawRect(f, f2 - 6.0f, 12.0f + f, f2 + 6.0f, paint);
    }

    @Override // org.achartengine.chart.XYChart
    public void drawSeries(Canvas canvas, Paint paint, List<Float> list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        int seriesCount = this.mDataset.getSeriesCount();
        int size = list.size();
        paint.setColor(xYSeriesRenderer.getColor());
        paint.setStyle(Paint.Style.FILL);
        float halfDiffX = getHalfDiffX(list, size, seriesCount);
        for (int i3 = 0; i3 < size; i3 += 2) {
            float fFloatValue = list.get(i3).floatValue();
            int i4 = i3 + 1;
            float fFloatValue2 = list.get(i4).floatValue();
            if (this.mType != Type.HEAPED || i <= 0) {
                drawBar(canvas, fFloatValue, f, fFloatValue, fFloatValue2, halfDiffX, seriesCount, i, paint);
            } else {
                float fFloatValue3 = this.mPreviousSeriesPoints.get(i4).floatValue();
                float f2 = fFloatValue2 + (fFloatValue3 - f);
                list.set(i4, Float.valueOf(f2));
                drawBar(canvas, fFloatValue, fFloatValue3, fFloatValue, f2, halfDiffX, seriesCount, i, paint);
            }
        }
        paint.setColor(xYSeriesRenderer.getColor());
        this.mPreviousSeriesPoints = list;
    }

    @Override // org.achartengine.chart.XYChart
    public String getChartType() {
        return TYPE;
    }

    public float getCoeficient() {
        return 1.0f;
    }

    @Override // org.achartengine.chart.XYChart
    public double getDefaultMinimum() {
        return 0.0d;
    }

    public int getGradientPartialColor(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i2) * f2) + (Color.alpha(i) * f)), Math.round((Color.red(i2) * f2) + (Color.red(i) * f)), Math.round((Color.green(i2) * f2) + (Color.green(i) * f)), Math.round((f2 * Color.blue(i2)) + (f * Color.blue(i))));
    }

    public float getHalfDiffX(List<Float> list, int i, int i2) {
        float barWidth = this.mRenderer.getBarWidth();
        if (barWidth > 0.0f) {
            return barWidth / 2.0f;
        }
        float fFloatValue = (list.get(i - 2).floatValue() - list.get(0).floatValue()) / (i > 2 ? i - 2 : i);
        if (fFloatValue == 0.0f) {
            fFloatValue = 10.0f;
        }
        Type type = this.mType;
        if (type != Type.STACKED && type != Type.HEAPED) {
            fFloatValue /= i2;
        }
        return (float) (((double) fFloatValue) / ((this.mRenderer.getBarSpacing() + 1.0d) * ((double) getCoeficient())));
    }

    @Override // org.achartengine.chart.AbstractChart
    public int getLegendShapeWidth(int i) {
        return 12;
    }

    @Override // org.achartengine.chart.XYChart
    public boolean isRenderNullValues() {
        return true;
    }

    public BarChart(Type type) {
        Type type2 = Type.DEFAULT;
        this.mType = type;
    }

    public BarChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, Type type) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        Type type2 = Type.DEFAULT;
        this.mType = type;
    }

    public void drawBar(Canvas canvas, float f, float f2, float f3, float f4, float f5, int i, int i2, Paint paint) {
        int scaleNumber = this.mDataset.getSeriesAt(i2).getScaleNumber();
        Type type = this.mType;
        if (type != Type.STACKED && type != Type.HEAPED) {
            float f6 = (f - (i * f5)) + (i2 * 2 * f5);
            drawBar(canvas, f6, f4, (f5 * 2.0f) + f6, f2, scaleNumber, i2, paint);
        } else {
            drawBar(canvas, f - f5, f4, f3 + f5, f2, scaleNumber, i2, paint);
        }
    }
}
