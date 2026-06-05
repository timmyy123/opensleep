package com.urbandroid.util;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ScienceUtil {
    public static void aggregateAndAdd(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        int length2 = fArr2.length;
        if (length > length2) {
            Events$$ExternalSyntheticBUOutline0.m$1(length, length2, " > ");
            return;
        }
        if (length2 % length != 0) {
            Events$$ExternalSyntheticBUOutline0.m$1(length2, length, " not divisible by ");
            return;
        }
        int i = length2 / length;
        for (int i2 = 0; i2 < length2; i2++) {
            int i3 = i2 / i;
            fArr[i3] = fArr[i3] + fArr2[i2];
        }
    }

    public static int argmax(float[] fArr) {
        int length = fArr.length;
        float f = Float.NEGATIVE_INFINITY;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr[i2];
            if (f2 >= f) {
                i = i2;
                f = f2;
            }
        }
        return i;
    }

    public static int argmin(float[] fArr) {
        int length = fArr.length;
        float f = Float.POSITIVE_INFINITY;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr[i2];
            if (f2 <= f) {
                i = i2;
                f = f2;
            }
        }
        return i;
    }

    public static float avg(float[] fArr, int i, int i2) {
        if (i2 - i == 0) {
            return 0.0f;
        }
        int i3 = 0;
        float f = 0.0f;
        while (i < i2) {
            float f2 = fArr[i];
            if (f2 != Float.NaN) {
                f += f2;
                i3++;
            }
            i++;
        }
        if (i3 == 0) {
            return 0.0f;
        }
        return f / i3;
    }

    public static float[] convertArray(Float[] fArr) {
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i = 0; i < length; i++) {
            Float f = fArr[i];
            fArr2[i] = f == null ? Float.NaN : f.floatValue();
        }
        return fArr2;
    }

    public static double[] convertArrayToDouble(float[] fArr) {
        double[] dArr = new double[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            dArr[i] = fArr[i];
        }
        return dArr;
    }

    public static List<Float> convertArrayToList(float[] fArr) {
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    public static float[] decimate(float[] fArr, int i) {
        if (i == 1) {
            return fArr;
        }
        int length = fArr.length / i;
        float[] fArr2 = new float[length];
        for (int i2 = 0; i2 < length; i2++) {
            fArr2[i2] = fArr[i2 * i];
        }
        return fArr2;
    }

    public static float deltaSum(float[] fArr, float[] fArr2) {
        float fAbs = 0.0f;
        for (int i = 0; i < fArr.length; i++) {
            fAbs += Math.abs(fArr[i] - fArr2[i]);
        }
        return fAbs;
    }

    public static void detectPeaksAdvance(float[] fArr, int i, List<Integer> list, List<Float> list2, float f) {
        int iFindMaxPeakIndex = findMaxPeakIndex(fArr);
        if (iFindMaxPeakIndex <= -1 || fArr[iFindMaxPeakIndex] <= f) {
            return;
        }
        if (list != null) {
            list.add(Integer.valueOf(iFindMaxPeakIndex));
        }
        if (list2 != null) {
            list2.add(Float.valueOf(fArr[iFindMaxPeakIndex]));
        }
        int i2 = i / 2;
        int iMin = Math.min(iFindMaxPeakIndex + i2, fArr.length - 1);
        for (int iMax = Math.max(iFindMaxPeakIndex - i2, 0); iMax <= iMin; iMax++) {
            fArr[iMax] = 0.0f;
        }
        detectPeaksAdvance(fArr, i, list, list2, f);
    }

    public static double div0(double d, double d2) {
        if (d2 == 0.0d) {
            return 0.0d;
        }
        return d / d2;
    }

    public static int findMaxPeakIndex(float[] fArr) {
        double d = 0.0d;
        int i = -1;
        for (int i2 = 1; i2 < fArr.length - 1; i2++) {
            float f = fArr[i2];
            if (f > 0.0f) {
                float f2 = fArr[i2 - 1];
                if (f2 > 0.0f) {
                    float f3 = fArr[i2 + 1];
                    if (f3 > 0.0f && f > d && f > f2 && f3 < f) {
                        d = f;
                        i = i2;
                    }
                }
            }
        }
        return i;
    }

    public static void inPlaceMovingAverage(float[] fArr, int i) {
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = avg(fArr, i2, Math.min(i2 + i, fArr.length));
        }
    }

    public static void inPlaceMovingMax(float[] fArr, int i) {
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = max(fArr, i2, Math.min(i2 + i, fArr.length));
        }
    }

    public static float max(float[] fArr, int i, int i2) {
        float f = Float.NEGATIVE_INFINITY;
        while (i < i2) {
            float f2 = fArr[i];
            if (f2 != Float.NaN && f2 > f) {
                f = f2;
            }
            i++;
        }
        return f;
    }

    public static float min(float[] fArr) {
        float f = Float.POSITIVE_INFINITY;
        for (float f2 : fArr) {
            if (f2 != Float.NaN && f2 < f) {
                f = f2;
            }
        }
        return f;
    }

    public static float[] movingAverage(float[] fArr, int i) {
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        inPlaceMovingAverage(fArrCopyOf, i);
        return fArrCopyOf;
    }

    public static float[] movingMax(float[] fArr, int i) {
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        inPlaceMovingMax(fArrCopyOf, i);
        return fArrCopyOf;
    }

    public static float percentile(float[] fArr, float f) {
        return (float) new org.apache.commons.math3.stat.descriptive.rank.Percentile(f).evaluate(convertArrayToDouble(fArr));
    }

    public static int prevPowerOf2(int i) {
        int i2 = ClientDefaults.MAX_MSG_SIZE;
        while (i2 > i && i2 > 1) {
            i2 >>= 1;
        }
        return i2;
    }

    public static double round(double d, int i) {
        return Math.round(d * r0) / ((int) Math.pow(10.0d, i));
    }

    public static void shiftRight(float[] fArr) {
        for (int length = fArr.length - 1; length > 0; length--) {
            fArr[length] = fArr[length - 1];
        }
        fArr[0] = 0.0f;
    }

    public static float stddev(float[] fArr) {
        return (float) Math.sqrt(var(fArr));
    }

    public static float sum(float[] fArr) {
        float f = 0.0f;
        if (fArr.length == 0) {
            return 0.0f;
        }
        for (float f2 : fArr) {
            if (f2 != Float.NaN) {
                f += f2;
            }
        }
        return f;
    }

    public static double[] toDoubleArray(Collection<Double> collection) {
        return convertArray((Double[]) collection.toArray(new Double[collection.size()]));
    }

    public static float[] toFloatArray(Collection<Float> collection) {
        return convertArray((Float[]) collection.toArray(new Float[collection.size()]));
    }

    public static float var(float[] fArr, int i, int i2) {
        if (fArr == null || fArr.length <= 1) {
            return Float.NaN;
        }
        int i3 = i2 - i;
        float f = 0.0f;
        if (i3 == 0) {
            return 0.0f;
        }
        float fAvg = avg(fArr, i, i2);
        while (i < i2) {
            float f2 = fArr[i] - fAvg;
            f += f2 * f2;
            i++;
        }
        return f / i3;
    }

    public static double percentile(Double[] dArr, float f) {
        return percentile(convertArray(dArr), f);
    }

    public static double percentile(double[] dArr, float f) {
        return new org.apache.commons.math3.stat.descriptive.rank.Percentile(f).evaluate(dArr);
    }

    public static float percentile(Float[] fArr, float f) {
        return percentile(convertArray(fArr), f);
    }

    public static long[] decimate(long[] jArr, int i) {
        if (i == 1) {
            return jArr;
        }
        int length = jArr.length / i;
        long[] jArr2 = new long[length];
        for (int i2 = 0; i2 < length; i2++) {
            jArr2[i2] = jArr[i2 * i];
        }
        return jArr2;
    }

    public static float max(float[] fArr) {
        return max(fArr, 0, fArr.length);
    }

    public static double[] convertArray(Double[] dArr) {
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = dArr[i].doubleValue();
        }
        return dArr2;
    }

    public static double sum(Float[] fArr) {
        return sum(convertArray(fArr));
    }

    public static double avg(Double[] dArr) {
        return avg(convertArray(dArr));
    }

    public static float avg(float[] fArr) {
        return avg(fArr, 0, fArr.length);
    }

    public static double avg(double[] dArr) {
        return avg(dArr, 0, dArr.length);
    }

    public static float var(float[] fArr) {
        return var(fArr, 0, fArr.length);
    }

    public static double avg(double[] dArr, int i, int i2) {
        int i3 = i2 - i;
        double d = 0.0d;
        if (i3 == 0) {
            return 0.0d;
        }
        while (i < i2) {
            double d2 = dArr[i];
            if (d2 != Double.NaN) {
                d += d2;
            }
            i++;
        }
        return d / ((double) i3);
    }

    public static float avg(Float[] fArr) {
        return avg(convertArray(fArr));
    }
}
