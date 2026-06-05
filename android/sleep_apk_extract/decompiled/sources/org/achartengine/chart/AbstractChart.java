package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractChart implements Serializable {
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052 A[PHI: r6
      0x0052: PHI (r6v4 float) = (r6v1 float), (r6v5 float) binds: [B:33:0x006f, B:24:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 float) = (r3v0 float), (r3v5 float) binds: [B:14:0x0035, B:5:0x0013] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001e A[PHI: r0 r3 r4
      0x001e: PHI (r0v6 float) = (r0v4 float), (r0v13 float) binds: [B:17:0x003b, B:8:0x001c] A[DONT_GENERATE, DONT_INLINE]
      0x001e: PHI (r3v1 float) = (r3v0 float), (r3v5 float) binds: [B:17:0x003b, B:8:0x001c] A[DONT_GENERATE, DONT_INLINE]
      0x001e: PHI (r4v2 float) = (r4v1 float), (r4v4 float) binds: [B:17:0x003b, B:8:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static float[] calculateDrawPoints(float f, float f2, float f3, float f4, int i, int i2) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11 = i;
        if (f2 > f11) {
            f7 = (f4 - f2) / (f3 - f);
            f8 = f7 * f;
            f5 = ((f11 - f2) + f8) / f7;
            if (f5 < 0.0f) {
                f6 = f2 - f8;
                f5 = 0.0f;
            } else {
                f9 = i2;
                if (f5 > f9) {
                    f6 = ((f7 * f9) + f2) - f8;
                    f5 = f9;
                } else {
                    f6 = f11;
                }
            }
        } else if (f2 < 0.0f) {
            f7 = (f4 - f2) / (f3 - f);
            f8 = f7 * f;
            f5 = ((-f2) + f8) / f7;
            if (f5 >= 0.0f) {
                f9 = i2;
                if (f5 <= f9) {
                    f6 = 0.0f;
                }
            }
        } else {
            f5 = f;
            f6 = f2;
        }
        if (f4 > f11) {
            float f12 = (f4 - f2) / (f3 - f);
            f10 = f * f12;
            f3 = ((f11 - f2) + f10) / f12;
            if (f3 < 0.0f) {
                f4 = f2 - f10;
                f3 = 0.0f;
            } else {
                float f13 = i2;
                if (f3 > f13) {
                    f4 = ((f12 * f13) + f2) - f10;
                    f3 = f13;
                } else {
                    f4 = f11;
                }
            }
        } else if (f4 < 0.0f) {
            float f14 = (f4 - f2) / (f3 - f);
            f10 = f * f14;
            f3 = ((-f2) + f10) / f14;
            if (f3 >= 0.0f) {
                float f15 = i2;
                if (f3 > f15) {
                    f4 = ((f14 * f15) + f2) - f10;
                    f3 = f15;
                } else {
                    f4 = 0.0f;
                }
            }
        }
        return new float[]{f5, f6, f3, f4};
    }

    private String getFitText(String str, float f, Paint paint) {
        int length = str.length();
        String strConcat = str;
        int i = 0;
        while (paint.measureText(strConcat) > f && i < length) {
            i++;
            strConcat = str.substring(0, length - i).concat("...");
        }
        return i == length ? "..." : strConcat;
    }

    public abstract void draw(Canvas canvas, int i, int i2, int i3, int i4, Paint paint);

    public void drawBackground(DefaultRenderer defaultRenderer, Canvas canvas, int i, int i2, int i3, int i4, Paint paint, boolean z, int i5) {
        if (defaultRenderer.isApplyBackgroundColor() || z) {
            if (z) {
                paint.setColor(i5);
            } else {
                paint.setColor(defaultRenderer.getBackgroundColor());
            }
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(i, i2, i + i3, i2 + i4, paint);
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public void drawLabel(android.graphics.Canvas r17, java.lang.String r18, org.achartengine.renderer.DefaultRenderer r19, java.util.List<android.graphics.RectF> r20, int r21, int r22, float r23, float r24, float r25, float r26, int r27, int r28, int r29, android.graphics.Paint r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.achartengine.chart.AbstractChart.drawLabel(android.graphics.Canvas, java.lang.String, org.achartengine.renderer.DefaultRenderer, java.util.List, int, int, float, float, float, float, int, int, int, android.graphics.Paint, boolean, boolean):void");
    }

    public int drawLegend(Canvas canvas, DefaultRenderer defaultRenderer, String[] strArr, int i, int i2, int i3, int i4, int i5, int i6, Paint paint, boolean z) {
        int i7;
        float legendTextSize;
        int i8;
        float f;
        float f2;
        float f3;
        float f4;
        AbstractChart abstractChart = this;
        Paint paint2 = paint;
        float f5 = 32.0f;
        if (defaultRenderer.isShowLegend()) {
            float f6 = i;
            float f7 = ((i3 + i5) - i6) + 32.0f;
            paint2.setTextAlign(Paint.Align.LEFT);
            paint2.setTextSize(defaultRenderer.getLegendTextSize());
            int iMin = Math.min(strArr.length, defaultRenderer.getSeriesRendererCount());
            float f8 = f6;
            int i9 = 0;
            while (true) {
                float f9 = f5;
                if (i9 >= iMin) {
                    break;
                }
                SimpleSeriesRenderer seriesRendererAt = defaultRenderer.getSeriesRendererAt(i9);
                float legendShapeWidth = abstractChart.getLegendShapeWidth(i9);
                if (seriesRendererAt.isShowLegendItem()) {
                    String strConcat = strArr[i9];
                    float f10 = f7;
                    if (strArr.length == defaultRenderer.getSeriesRendererCount()) {
                        paint2.setColor(seriesRendererAt.getColor());
                    } else {
                        paint2.setColor(Color.LTGRAY);
                    }
                    int length = strConcat.length();
                    float[] fArr = new float[length];
                    paint2.getTextWidths(strConcat, fArr);
                    float f11 = 0.0f;
                    for (int i10 = 0; i10 < length; i10++) {
                        f11 += fArr[i10];
                    }
                    float f12 = legendShapeWidth + 10.0f + f11;
                    float f13 = f8 + f12;
                    if (i9 <= 0 || !abstractChart.getExceed(f13, defaultRenderer, i2, i4)) {
                        legendTextSize = f9;
                        i8 = i9;
                        f = f8;
                        f2 = f10;
                    } else {
                        float legendTextSize2 = defaultRenderer.getLegendTextSize() + f10;
                        legendTextSize = defaultRenderer.getLegendTextSize() + f9;
                        f2 = legendTextSize2;
                        f13 = f6 + f12;
                        i8 = i9;
                        f = f6;
                    }
                    if (abstractChart.getExceed(f13, defaultRenderer, i2, i4)) {
                        float f14 = ((i2 - f) - legendShapeWidth) - 10.0f;
                        if (abstractChart.isVertical(defaultRenderer)) {
                            f14 = ((i4 - f) - legendShapeWidth) - 10.0f;
                        }
                        strConcat = strConcat.substring(0, paint2.breakText(strConcat, true, f14, fArr)).concat("...");
                    }
                    if (z) {
                        f3 = f2;
                        i7 = i8;
                        f4 = f;
                    } else {
                        int i11 = i8;
                        abstractChart.drawLegendShape(canvas, seriesRendererAt, f, f2, i11, paint2);
                        f4 = f;
                        f3 = f2;
                        i7 = i11;
                        drawString(canvas, strConcat, f4 + legendShapeWidth + 5.0f, f3 + 5.0f, paint);
                    }
                    f8 = f4 + f12;
                    f5 = legendTextSize;
                    f7 = f3;
                } else {
                    i7 = i9;
                    f5 = f9;
                }
                i9 = i7 + 1;
                abstractChart = this;
                paint2 = paint;
            }
        }
        return Math.round(defaultRenderer.getLegendTextSize() + f5);
    }

    public abstract void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint);

    public void drawPath(Canvas canvas, List<Float> list, Paint paint, boolean z) {
        Path path = new Path();
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        if (list.size() < 4) {
            return;
        }
        float[] fArrCalculateDrawPoints = calculateDrawPoints(list.get(0).floatValue(), list.get(1).floatValue(), list.get(2).floatValue(), list.get(3).floatValue(), height, width);
        path.moveTo(fArrCalculateDrawPoints[0], fArrCalculateDrawPoints[1]);
        path.lineTo(fArrCalculateDrawPoints[2], fArrCalculateDrawPoints[3]);
        int size = list.size();
        for (int i = 4; i < size; i += 2) {
            int i2 = i - 1;
            if (list.get(i2).floatValue() >= 0.0f || list.get(i + 1).floatValue() >= 0.0f) {
                float f = height;
                if (list.get(i2).floatValue() <= f || list.get(i + 1).floatValue() <= f) {
                    float[] fArrCalculateDrawPoints2 = calculateDrawPoints(list.get(i - 2).floatValue(), list.get(i2).floatValue(), list.get(i).floatValue(), list.get(i + 1).floatValue(), height, width);
                    if (!z) {
                        path.moveTo(fArrCalculateDrawPoints2[0], fArrCalculateDrawPoints2[1]);
                    }
                    path.lineTo(fArrCalculateDrawPoints2[2], fArrCalculateDrawPoints2[3]);
                }
            }
        }
        if (z) {
            path.lineTo(list.get(0).floatValue(), list.get(1).floatValue());
        }
        canvas.drawPath(path, paint);
    }

    public void drawString(Canvas canvas, String str, float f, float f2, Paint paint) {
        if (str != null) {
            String[] strArrSplit = str.split("\n");
            Rect rect = new Rect();
            int iHeight = 0;
            for (int i = 0; i < strArrSplit.length; i++) {
                canvas.drawText(strArrSplit[i], f, iHeight + f2, paint);
                String str2 = strArrSplit[i];
                paint.getTextBounds(str2, 0, str2.length(), rect);
                iHeight = rect.height() + iHeight + 5;
            }
        }
    }

    public boolean getExceed(float f, DefaultRenderer defaultRenderer, int i, int i2) {
        return isVertical(defaultRenderer) ? f > ((float) i2) : f > ((float) i);
    }

    public String getLabel(NumberFormat numberFormat, double d) {
        if (numberFormat != null) {
            return numberFormat.format(d);
        }
        if (d == Math.round(d)) {
            return Math.round(d) + "";
        }
        return d + "";
    }

    public abstract int getLegendShapeWidth(int i);

    public int getLegendSize(DefaultRenderer defaultRenderer, int i, float f) {
        int legendHeight = defaultRenderer.getLegendHeight();
        if (!defaultRenderer.isShowLegend() || legendHeight != 0) {
            i = legendHeight;
        }
        return (defaultRenderer.isShowLegend() || !defaultRenderer.isShowXLabels()) ? i : (int) (((defaultRenderer.getLabelsTextSize() * 4.0f) / 3.0f) + f);
    }

    public SeriesSelection getSeriesAndPointForScreenCoordinate(Point point) {
        return null;
    }

    public boolean isNullValue(double d) {
        return Double.isNaN(d) || Double.isInfinite(d) || d == Double.MAX_VALUE;
    }

    public boolean isVertical(DefaultRenderer defaultRenderer) {
        return (defaultRenderer instanceof XYMultipleSeriesRenderer) && ((XYMultipleSeriesRenderer) defaultRenderer).getOrientation() == XYMultipleSeriesRenderer.Orientation.VERTICAL;
    }

    public void drawPath(Canvas canvas, float[] fArr, Paint paint, boolean z) {
        Path path = new Path();
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        if (fArr.length < 4) {
            return;
        }
        float[] fArrCalculateDrawPoints = calculateDrawPoints(fArr[0], fArr[1], fArr[2], fArr[3], height, width);
        path.moveTo(fArrCalculateDrawPoints[0], fArrCalculateDrawPoints[1]);
        path.lineTo(fArrCalculateDrawPoints[2], fArrCalculateDrawPoints[3]);
        int length = fArr.length;
        for (int i = 4; i < length; i += 2) {
            float f = fArr[i - 1];
            if (f >= 0.0f || fArr[i + 1] >= 0.0f) {
                float f2 = height;
                if (f <= f2 || fArr[i + 1] <= f2) {
                    float[] fArrCalculateDrawPoints2 = calculateDrawPoints(fArr[i - 2], f, fArr[i], fArr[i + 1], height, width);
                    if (!z) {
                        path.moveTo(fArrCalculateDrawPoints2[0], fArrCalculateDrawPoints2[1]);
                    }
                    path.lineTo(fArrCalculateDrawPoints2[2], fArrCalculateDrawPoints2[3]);
                }
            }
        }
        if (z) {
            path.lineTo(fArr[0], fArr[1]);
        }
        canvas.drawPath(path, paint);
    }
}
