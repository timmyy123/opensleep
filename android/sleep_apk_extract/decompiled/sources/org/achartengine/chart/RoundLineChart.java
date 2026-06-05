package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class RoundLineChart extends LineChart {

    /* JADX INFO: renamed from: org.achartengine.chart.RoundLineChart$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine$Type;

        static {
            int[] iArr = new int[XYSeriesRenderer.FillOutsideLine.Type.values().length];
            $SwitchMap$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine$Type = iArr;
            try {
                iArr[XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine$Type[XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine$Type[XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine$Type[XYSeriesRenderer.FillOutsideLine.Type.BELOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine$Type[XYSeriesRenderer.FillOutsideLine.Type.ABOVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public RoundLineChart() {
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x022d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c5  */
    @Override // org.achartengine.chart.LineChart, org.achartengine.chart.XYChart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drawSeries(Canvas canvas, Paint paint, List<Float> list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        XYSeriesRenderer.FillOutsideLine[] fillOutsideLineArr;
        int i3;
        int i4;
        int i5;
        float height;
        XYSeriesRenderer.FillOutsideLine.Type type;
        XYSeriesRenderer.FillOutsideLine.Type type2;
        int size;
        boolean z;
        int i6;
        int i7;
        boolean z2;
        int size2;
        float strokeWidth = paint.getStrokeWidth();
        paint.setStrokeWidth(xYSeriesRenderer.getLineWidth());
        XYSeriesRenderer.FillOutsideLine[] fillOutsideLine = xYSeriesRenderer.getFillOutsideLine();
        paint.setStrokeCap(Paint.Cap.ROUND);
        int length = fillOutsideLine.length;
        int i8 = 0;
        int i9 = 0;
        while (i9 < length) {
            XYSeriesRenderer.FillOutsideLine fillOutsideLine2 = fillOutsideLine[i9];
            if (fillOutsideLine2.getType() != XYSeriesRenderer.FillOutsideLine.Type.NONE) {
                paint.setColor(fillOutsideLine2.getColor());
                ArrayList arrayList = new ArrayList();
                int[] fillRange = fillOutsideLine2.getFillRange();
                if (fillRange == null) {
                    arrayList.addAll(list);
                } else {
                    if (list.size() > fillRange[i8] * 2) {
                        int size3 = list.size();
                        int i10 = fillRange[1];
                        i4 = i8;
                        if (size3 > i10 * 2) {
                            arrayList.addAll(list.subList(fillRange[i4] * 2, i10 * 2));
                        }
                    }
                    i5 = AnonymousClass1.$SwitchMap$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine$Type[fillOutsideLine2.getType().ordinal()];
                    if (i5 != 1 || i5 == 2 || i5 == 3) {
                        height = f;
                    } else if (i5 == 4) {
                        height = canvas.getHeight();
                    } else {
                        if (i5 != 5) {
                            Types$$ExternalSyntheticBUOutline0.m$2("You have added a new type of filling but have not implemented.");
                            return;
                        }
                        height = 0.0f;
                    }
                    type = fillOutsideLine2.getType();
                    type2 = XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE;
                    if (type != type2 || fillOutsideLine2.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW) {
                        ArrayList arrayList2 = new ArrayList();
                        size = arrayList.size();
                        if ((size > 0 || fillOutsideLine2.getType() != type2 || ((Float) arrayList.get(1)).floatValue() >= height) && (fillOutsideLine2.getType() != XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW || ((Float) arrayList.get(1)).floatValue() <= height)) {
                            z = false;
                        } else {
                            arrayList2.add((Float) arrayList.get(i4));
                            arrayList2.add((Float) arrayList.get(1));
                            z = true;
                        }
                        i6 = 3;
                        while (i6 < size) {
                            float fFloatValue = ((Float) arrayList.get(i6 - 2)).floatValue();
                            XYSeriesRenderer.FillOutsideLine[] fillOutsideLineArr2 = fillOutsideLine;
                            Float f2 = (Float) arrayList.get(i6);
                            float fFloatValue2 = f2.floatValue();
                            if ((fFloatValue >= height || fFloatValue2 <= height) && (fFloatValue <= height || fFloatValue2 >= height)) {
                                i7 = length;
                                if (z || ((fillOutsideLine2.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE && fFloatValue2 < height) || (fillOutsideLine2.getType() == XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW && fFloatValue2 > height))) {
                                    arrayList2.add((Float) arrayList.get(i6 - 1));
                                    arrayList2.add(f2);
                                }
                            } else {
                                float fFloatValue3 = ((Float) arrayList.get(i6 - 3)).floatValue();
                                i7 = length;
                                Float f3 = (Float) arrayList.get(i6 - 1);
                                arrayList2.add(Float.valueOf((((height - fFloatValue) * (f3.floatValue() - fFloatValue3)) / (fFloatValue2 - fFloatValue)) + fFloatValue3));
                                arrayList2.add(Float.valueOf(height));
                                if ((fillOutsideLine2.getType() != XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE || fFloatValue2 <= height) && (fillOutsideLine2.getType() != XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_BELOW || fFloatValue2 >= height)) {
                                    arrayList2.add(f3);
                                    arrayList2.add(f2);
                                    z2 = true;
                                } else {
                                    i6 += 2;
                                    z2 = false;
                                }
                                z = z2;
                            }
                            i6 += 2;
                            fillOutsideLine = fillOutsideLineArr2;
                            length = i7;
                        }
                        fillOutsideLineArr = fillOutsideLine;
                        i3 = length;
                        arrayList.clear();
                        arrayList.addAll(arrayList2);
                    } else {
                        fillOutsideLineArr = fillOutsideLine;
                        i3 = length;
                    }
                    size2 = arrayList.size();
                    if (size2 > 0) {
                        arrayList.set(0, Float.valueOf(((Float) arrayList.get(0)).floatValue() + 1.0f));
                        arrayList.add((Float) arrayList.get(size2 - 2));
                        arrayList.add(Float.valueOf(height));
                        arrayList.add((Float) arrayList.get(0));
                        arrayList.add((Float) arrayList.get(size2 + 1));
                        for (int i11 = 0; i11 < size2 + 4; i11 += 2) {
                            int i12 = i11 + 1;
                            if (((Float) arrayList.get(i12)).floatValue() < 0.0f) {
                                arrayList.set(i12, Float.valueOf(0.0f));
                            }
                        }
                        paint.setStyle(Paint.Style.FILL);
                        drawPath(canvas, (List<Float>) arrayList, paint, true);
                    }
                }
                i4 = i8;
                i5 = AnonymousClass1.$SwitchMap$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine$Type[fillOutsideLine2.getType().ordinal()];
                if (i5 != 1) {
                    height = f;
                    type = fillOutsideLine2.getType();
                    type2 = XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ABOVE;
                    if (type != type2) {
                    }
                    ArrayList arrayList22 = new ArrayList();
                    size = arrayList.size();
                    if (size > 0) {
                        z = false;
                        i6 = 3;
                        while (i6 < size) {
                        }
                        fillOutsideLineArr = fillOutsideLine;
                        i3 = length;
                        arrayList.clear();
                        arrayList.addAll(arrayList22);
                        size2 = arrayList.size();
                        if (size2 > 0) {
                        }
                    } else {
                        z = false;
                        i6 = 3;
                        while (i6 < size) {
                        }
                        fillOutsideLineArr = fillOutsideLine;
                        i3 = length;
                        arrayList.clear();
                        arrayList.addAll(arrayList22);
                        size2 = arrayList.size();
                        if (size2 > 0) {
                        }
                    }
                }
            } else {
                fillOutsideLineArr = fillOutsideLine;
                i3 = length;
            }
            i9++;
            fillOutsideLine = fillOutsideLineArr;
            length = i3;
            i8 = 0;
        }
        paint.setColor(xYSeriesRenderer.getColor());
        paint.setStyle(Paint.Style.STROKE);
        drawPath(canvas, list, paint, false);
        paint.setStrokeWidth(strokeWidth);
    }

    public RoundLineChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
    }
}
