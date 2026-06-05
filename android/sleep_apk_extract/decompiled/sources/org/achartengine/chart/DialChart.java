package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DialRenderer;

/* JADX INFO: loaded from: classes5.dex */
public class DialChart extends RoundChart {
    private static final int NEEDLE_RADIUS = 10;
    private DialRenderer mRenderer;

    public DialChart(CategorySeries categorySeries, DialRenderer dialRenderer) {
        super(categorySeries, dialRenderer);
    }

    private void drawNeedle(Canvas canvas, double d, int i, int i2, double d2, boolean z, Paint paint) {
        float[] fArr;
        double radians = d - Math.toRadians(90.0d);
        int iSin = (int) (Math.sin(radians) * 10.0d);
        int iCos = (int) (Math.cos(radians) * 10.0d);
        int iSin2 = ((int) (Math.sin(d) * d2)) + i;
        int iCos2 = ((int) (Math.cos(d) * d2)) + i2;
        if (z) {
            double d3 = 0.85d * d2;
            int iSin3 = ((int) (Math.sin(d) * d3)) + i;
            int iCos3 = ((int) (d3 * Math.cos(d))) + i2;
            float f = iSin2;
            float f2 = iCos2;
            fArr = new float[]{iSin3 - iSin, iCos3 - iCos, f, f2, iSin3 + iSin, iCos3 + iCos};
            float strokeWidth = paint.getStrokeWidth();
            paint.setStrokeWidth(5.0f);
            canvas.drawLine(i, i2, f, f2, paint);
            paint.setStrokeWidth(strokeWidth);
        } else {
            fArr = new float[]{i - iSin, i2 - iCos, iSin2, iCos2, i + iSin, i2 + iCos};
        }
        drawPath(canvas, fArr, paint, true);
    }

    private void drawTicks(Canvas canvas, double d, double d2, double d3, double d4, int i, int i2, double d5, double d6, double d7, Paint paint, boolean z) {
        double d8 = d;
        while (d8 <= d2) {
            double angleForValue = getAngleForValue(d8, d3, d4, d, d2);
            double d9 = d8;
            double dSin = Math.sin(angleForValue);
            double dCos = Math.cos(angleForValue);
            float f = i;
            int iRound = Math.round(((float) (d6 * dSin)) + f);
            float f2 = i2;
            int iRound2 = Math.round(((float) (d6 * dCos)) + f2);
            int iRound3 = Math.round(f + ((float) (dSin * d5)));
            int iRound4 = Math.round(f2 + ((float) (dCos * d5)));
            float f3 = iRound;
            float f4 = iRound2;
            canvas.drawLine(f3, f4, iRound3, iRound4, paint);
            if (z) {
                paint.setTextAlign(Paint.Align.LEFT);
                if (iRound <= iRound3) {
                    paint.setTextAlign(Paint.Align.RIGHT);
                }
                String str = d9 + "";
                long j = (long) d9;
                if (Math.round(d9) == j) {
                    str = j + "";
                }
                canvas.drawText(str, f3, f4, paint);
            }
            d8 = d9 + d7;
        }
    }

    private double getAngleForValue(double d, double d2, double d3, double d4, double d5) {
        return Math.toRadians((((d - d4) * (d3 - d2)) / (d5 - d4)) + d2);
    }

    @Override // org.achartengine.chart.AbstractChart
    public void draw(Canvas canvas, int i, int i2, int i3, int i4, Paint paint) {
        throw null;
    }
}
