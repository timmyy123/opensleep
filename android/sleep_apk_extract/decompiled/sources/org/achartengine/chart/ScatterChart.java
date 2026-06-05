package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* JADX INFO: loaded from: classes5.dex */
public class ScatterChart extends XYChart {
    private static final int SHAPE_WIDTH = 10;
    private static final float SIZE = 3.0f;
    public static final String TYPE = "Scatter";
    private float size;

    /* JADX INFO: renamed from: org.achartengine.chart.ScatterChart$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$achartengine$chart$PointStyle;

        static {
            int[] iArr = new int[PointStyle.values().length];
            $SwitchMap$org$achartengine$chart$PointStyle = iArr;
            try {
                iArr[PointStyle.X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$achartengine$chart$PointStyle[PointStyle.CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$achartengine$chart$PointStyle[PointStyle.TRIANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$achartengine$chart$PointStyle[PointStyle.SQUARE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$achartengine$chart$PointStyle[PointStyle.DIAMOND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$achartengine$chart$PointStyle[PointStyle.POINT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ScatterChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        this.size = SIZE;
        this.size = xYMultipleSeriesRenderer.getPointSize();
    }

    private void drawCircle(Canvas canvas, Paint paint, float f, float f2) {
        canvas.drawCircle(f, f2, this.size, paint);
    }

    private void drawDiamond(Canvas canvas, Paint paint, float[] fArr, float f, float f2) {
        fArr[0] = f;
        float f3 = this.size;
        fArr[1] = f2 - f3;
        fArr[2] = f - f3;
        fArr[3] = f2;
        fArr[4] = f;
        fArr[5] = f2 + f3;
        fArr[6] = f + f3;
        fArr[7] = f2;
        drawPath(canvas, fArr, paint, true);
    }

    private void drawSquare(Canvas canvas, Paint paint, float f, float f2) {
        float f3 = this.size;
        canvas.drawRect(f - f3, f2 - f3, f + f3, f2 + f3, paint);
    }

    private void drawTriangle(Canvas canvas, Paint paint, float[] fArr, float f, float f2) {
        fArr[0] = f;
        float f3 = this.size;
        fArr[1] = (f2 - f3) - (f3 / 2.0f);
        fArr[2] = f - f3;
        float f4 = f2 + f3;
        fArr[3] = f4;
        fArr[4] = f + f3;
        fArr[5] = f4;
        drawPath(canvas, fArr, paint, true);
    }

    private void drawX(Canvas canvas, Paint paint, float f, float f2) {
        float f3 = this.size;
        canvas.drawLine(f - f3, f2 - f3, f + f3, f2 + f3, paint);
        float f4 = this.size;
        canvas.drawLine(f + f4, f2 - f4, f - f4, f2 + f4, paint);
    }

    @Override // org.achartengine.chart.XYChart
    public ClickableArea[] clickableAreasForPoints(List<Float> list, List<Double> list2, float f, int i, int i2) {
        int size = list.size();
        ClickableArea[] clickableAreaArr = new ClickableArea[size / 2];
        for (int i3 = 0; i3 < size; i3 += 2) {
            float selectableBuffer = this.mRenderer.getSelectableBuffer();
            int i4 = i3 + 1;
            clickableAreaArr[i3 / 2] = new ClickableArea(new RectF(list.get(i3).floatValue() - selectableBuffer, list.get(i4).floatValue() - selectableBuffer, list.get(i3).floatValue() + selectableBuffer, list.get(i4).floatValue() + selectableBuffer), list2.get(i3).doubleValue(), list2.get(i4).doubleValue());
        }
        return clickableAreaArr;
    }

    @Override // org.achartengine.chart.AbstractChart
    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint) {
        XYSeriesRenderer xYSeriesRenderer = (XYSeriesRenderer) simpleSeriesRenderer;
        if (xYSeriesRenderer.isFillPoints()) {
            paint.setStyle(Paint.Style.FILL);
        } else {
            paint.setStyle(Paint.Style.STROKE);
        }
        switch (AnonymousClass1.$SwitchMap$org$achartengine$chart$PointStyle[xYSeriesRenderer.getPointStyle().ordinal()]) {
            case 1:
                drawX(canvas, paint, f + 10.0f, f2);
                break;
            case 2:
                drawCircle(canvas, paint, f + 10.0f, f2);
                break;
            case 3:
                drawTriangle(canvas, paint, new float[6], f + 10.0f, f2);
                break;
            case 4:
                drawSquare(canvas, paint, f + 10.0f, f2);
                break;
            case 5:
                drawDiamond(canvas, paint, new float[8], f + 10.0f, f2);
                break;
            case 6:
                canvas.drawPoint(f + 10.0f, f2, paint);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.achartengine.chart.XYChart
    public void drawSeries(Canvas canvas, Paint paint, List<Float> list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        paint.setColor(xYSeriesRenderer.getColor());
        float strokeWidth = paint.getStrokeWidth();
        if (xYSeriesRenderer.isFillPoints()) {
            paint.setStyle(Paint.Style.FILL);
        } else {
            paint.setStrokeWidth(xYSeriesRenderer.getPointStrokeWidth());
            paint.setStyle(Paint.Style.STROKE);
        }
        int size = list.size();
        int i3 = 0;
        switch (AnonymousClass1.$SwitchMap$org$achartengine$chart$PointStyle[xYSeriesRenderer.getPointStyle().ordinal()]) {
            case 1:
                paint.setStrokeWidth(xYSeriesRenderer.getPointStrokeWidth());
                while (i3 < size) {
                    drawX(canvas, paint, list.get(i3).floatValue(), list.get(i3 + 1).floatValue());
                    i3 += 2;
                }
                break;
            case 2:
                while (i3 < size) {
                    drawCircle(canvas, paint, list.get(i3).floatValue(), list.get(i3 + 1).floatValue());
                    i3 += 2;
                }
                break;
            case 3:
                float[] fArr = new float[6];
                int i4 = 0;
                while (i4 < size) {
                    float[] fArr2 = fArr;
                    drawTriangle(canvas, paint, fArr2, list.get(i4).floatValue(), list.get(i4 + 1).floatValue());
                    i4 += 2;
                    fArr = fArr2;
                }
                break;
            case 4:
                while (i3 < size) {
                    drawSquare(canvas, paint, list.get(i3).floatValue(), list.get(i3 + 1).floatValue());
                    i3 += 2;
                }
                break;
            case 5:
                float[] fArr3 = new float[8];
                int i5 = 0;
                while (i5 < size) {
                    float[] fArr4 = fArr3;
                    drawDiamond(canvas, paint, fArr4, list.get(i5).floatValue(), list.get(i5 + 1).floatValue());
                    i5 += 2;
                    fArr3 = fArr4;
                }
                break;
            case 6:
                while (i3 < size) {
                    canvas.drawPoint(list.get(i3).floatValue(), list.get(i3 + 1).floatValue(), paint);
                    i3 += 2;
                }
                break;
        }
        paint.setStrokeWidth(strokeWidth);
    }

    @Override // org.achartengine.chart.XYChart
    public String getChartType() {
        return TYPE;
    }

    @Override // org.achartengine.chart.AbstractChart
    public int getLegendShapeWidth(int i) {
        return 10;
    }

    @Override // org.achartengine.chart.XYChart
    public void setDatasetRenderer(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        super.setDatasetRenderer(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        this.size = xYMultipleSeriesRenderer.getPointSize();
    }

    public ScatterChart() {
        this.size = SIZE;
    }
}
