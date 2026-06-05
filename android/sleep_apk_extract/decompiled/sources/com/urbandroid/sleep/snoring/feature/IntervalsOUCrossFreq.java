package com.urbandroid.sleep.snoring.feature;

import com.urbandroid.sleep.snoring.record.Function;
import com.urbandroid.sleep.snoring.record.MonoSample;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class IntervalsOUCrossFreq implements Function<MonoSample, IntervalsOverUnder> {
    private final double amplitudeThreshold;
    private final double crossFreqThreshold;
    private final int intermediateDownsample;
    private final double maxSequenceLen;
    private final double minSequenceLen;
    private final double movingWindowLen;

    public IntervalsOUCrossFreq(double d, double d2, double d3, double d4, double d5, int i) {
        this.amplitudeThreshold = d;
        this.crossFreqThreshold = d2;
        this.movingWindowLen = d3;
        this.minSequenceLen = d4;
        this.maxSequenceLen = d5;
        this.intermediateDownsample = i;
    }

    private float avg(float[] fArr) {
        double d = 0.0d;
        for (float f : fArr) {
            d += (double) f;
        }
        return (float) (d / ((double) fArr.length));
    }

    private float avgAbs(float[] fArr) {
        double dAbs = 0.0d;
        for (float f : fArr) {
            dAbs += (double) Math.abs(f);
        }
        return (float) (dAbs / ((double) fArr.length));
    }

    private boolean crossedThreshold(double d, float[] fArr, int i) {
        return Math.signum(((double) Math.abs(fArr[i])) - d) != Math.signum(((double) Math.abs(fArr[i - 1])) - d);
    }

    private Interval interval(int i, int i2, int i3) {
        int i4 = i3 / 2;
        int iMax = Math.max(0, i - i4);
        int i5 = this.intermediateDownsample;
        return new Interval(iMax * i5, (i2 - i4) * i5);
    }

    @Override // com.urbandroid.sleep.snoring.record.Function
    public IntervalsOverUnder apply(MonoSample monoSample) {
        MonoSample monoSampleDownSample = monoSample.downSample(this.intermediateDownsample);
        float[] sample = monoSampleDownSample.getSample();
        double dAvgAbs = ((double) avgAbs(sample)) * this.amplitudeThreshold;
        int length = sample.length;
        float[] fArr = new float[length];
        int i = 1;
        for (int i2 = 1; i2 < length; i2++) {
            fArr[i2] = crossedThreshold(dAvgAbs, sample, i2) ? 1.0f : 0.0f;
        }
        double dAvg = ((double) avg(fArr)) * this.crossFreqThreshold;
        double sampleRate = monoSampleDownSample.getSampleRate();
        int i3 = (int) (this.movingWindowLen * sampleRate);
        int i4 = (int) (this.minSequenceLen * sampleRate);
        int i5 = (int) (sampleRate * this.maxSequenceLen);
        FloatFunction floatFunctionAvg = Moving.avg(i3);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i6 = 0;
        double d = 0.0d;
        int i7 = 0;
        while (i < length) {
            double d2 = dAvg;
            double dApply = floatFunctionAvg.apply(fArr[i]);
            if (dApply < d2) {
                int i8 = i - i7;
                if (i8 >= i4 && i8 <= i5) {
                    arrayList.add(interval(i7, i + 1, i3));
                }
                i7 = i + 1;
            } else {
                if (i - i6 >= i4) {
                    arrayList2.add(interval(i6, i + 1, i3));
                }
                i6 = i + 1;
            }
            i++;
            d = dApply;
            dAvg = d2;
        }
        if (d > dAvg) {
            int i9 = (length - 1) - i7;
            if (i9 >= i4 && i9 <= i5) {
                arrayList.add(interval(i7, length, i3));
            }
        } else if ((length - 1) - i6 >= i4) {
            arrayList2.add(interval(i6, length, i3));
        }
        return new IntervalsOverUnder(monoSampleDownSample, arrayList, arrayList2);
    }
}
