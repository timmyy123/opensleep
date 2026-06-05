package com.urbandroid.sleep.domain;

import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;
import com.urbandroid.util.Percentile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AdaptiveNormalizationFilter {

    public static class ANFResult {
        public final double exponent;
        public final float[] input;
        public final double max;
        public final double median;
        public final float[] output;

        public ANFResult(float[] fArr, float[] fArr2, double d, double d2, double d3) {
            this.input = fArr;
            this.output = fArr2;
            this.median = d;
            this.max = d2;
            this.exponent = d3;
        }

        public float[] aggregateOutput(int i) {
            int length = this.output.length;
            FloatFunction floatFunctionMax = Moving.max(i);
            int iCeil = (int) Math.ceil(((double) length) / ((double) i));
            float[] fArr = new float[iCeil];
            float fApply = 0.0f;
            for (int i2 = 0; i2 < length; i2++) {
                fApply = floatFunctionMax.apply(this.output[i2]);
                if (i2 % i == i - 1) {
                    fArr[i2 / i] = fApply;
                }
            }
            fArr[iCeil - 1] = fApply;
            return fArr;
        }

        public BitSet getHighActivityFlags(float f) {
            BitSet bitSet = new BitSet();
            int i = 0;
            while (true) {
                float[] fArr = this.output;
                if (i >= fArr.length) {
                    return bitSet;
                }
                if (fArr[i] > f) {
                    bitSet.set(i);
                }
                i++;
            }
        }

        public float[] getHighActivityFlagsFloat(float f) {
            float[] fArr = new float[this.output.length];
            int i = 0;
            while (true) {
                float[] fArr2 = this.output;
                if (i >= fArr2.length) {
                    return fArr;
                }
                if (fArr2[i] > f) {
                    fArr[i] = 1.0f;
                }
                i++;
            }
        }
    }

    private static float getConservativeUpperBound(float[] fArr, BitSet bitSet) {
        int length = fArr.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length);
        int i = 0;
        while (true) {
            int iNextSetBit = bitSet.nextSetBit(i);
            if (iNextSetBit < 0) {
                break;
            }
            if (iNextSetBit < length) {
                fArrCopyOf[iNextSetBit] = 1.0f;
            }
            i = iNextSetBit + 1;
        }
        return new Percentile().evaluate(fArrCopyOf, length < 1000 ? 99.7f : length < 2500 ? 99.8f : 99.9f);
    }

    private static float getNoiseAmplitudeEstimate(float[] fArr, BitSet bitSet) {
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            if (fArr[i] >= 0.0f && !bitSet.get(i)) {
                arrayList.add(Float.valueOf(fArr[i]));
            }
        }
        if (arrayList.size() < 3) {
            return 0.0f;
        }
        float fEvaluate = new Percentile().evaluate(arrayList, 50);
        if (fEvaluate > 0.0f) {
            return fEvaluate;
        }
        float fEvaluate2 = new Percentile().evaluate(arrayList, 70);
        if (fEvaluate2 > 0.0f) {
            return fEvaluate2;
        }
        float fEvaluate3 = new Percentile().evaluate(arrayList, 90);
        if (fEvaluate3 > 0.0f) {
            return fEvaluate3;
        }
        float fEvaluate4 = new Percentile().evaluate(arrayList, 95);
        if (fEvaluate4 > 0.0f) {
            return fEvaluate4;
        }
        return 0.0f;
    }

    public static ANFResult normalizeAmplitudes(float[] fArr, BitSet bitSet) {
        int length = fArr.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length);
        float noiseAmplitudeEstimate = getNoiseAmplitudeEstimate(fArr, bitSet);
        if (noiseAmplitudeEstimate == 0.0f) {
            return new ANFResult(fArr, fArrCopyOf, 0.0d, 0.0d, 1.0d);
        }
        for (int i = 0; i < length; i++) {
            float f = fArrCopyOf[i];
            if (f >= 0.0f) {
                f /= noiseAmplitudeEstimate;
            }
            fArrCopyOf[i] = f;
        }
        float conservativeUpperBound = getConservativeUpperBound(fArrCopyOf, bitSet);
        if (conservativeUpperBound <= 1.0f) {
            return new ANFResult(fArr, fArrCopyOf, 0.0d, 0.0d, 1.0d);
        }
        double d = conservativeUpperBound;
        double dLog10 = 1.0d / Math.log10(d);
        for (int i2 = 0; i2 < length; i2++) {
            float fPow = fArrCopyOf[i2];
            float fMin = Math.min(conservativeUpperBound, fPow);
            if (fPow >= 0.0f) {
                fPow = (float) Math.pow(fMin, dLog10);
            }
            fArrCopyOf[i2] = fPow;
        }
        return new ANFResult(fArr, fArrCopyOf, noiseAmplitudeEstimate, d, dLog10);
    }

    public static ANFResult normalizeAmplitudes(float[] fArr) {
        return normalizeAmplitudes(fArr, new BitSet());
    }
}
