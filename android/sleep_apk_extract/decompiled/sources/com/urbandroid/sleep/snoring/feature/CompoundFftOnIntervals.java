package com.urbandroid.sleep.snoring.feature;

import com.urbandroid.sleep.snoring.newfftresult.FFT;
import com.urbandroid.sleep.snoring.newfftresult.FftResult;
import com.urbandroid.sleep.snoring.newfftresult.FftResultEnergyOnly;
import com.urbandroid.sleep.snoring.record.MonoSample;
import com.urbandroid.util.ScienceUtil;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CompoundFftOnIntervals {
    public static FftResult get(MonoSample monoSample, List<Interval> list, int i) {
        int sampleRate = monoSample.getSampleRate();
        float[] fArr = new float[i];
        for (Interval interval : list) {
            int iPrevPowerOf2 = ScienceUtil.prevPowerOf2(interval.length());
            if (iPrevPowerOf2 >= i) {
                int i2 = interval.start;
                ScienceUtil.aggregateAndAdd(fArr, FFT.fft(monoSample.fragment(i2, iPrevPowerOf2 + i2)).getEnergies());
            }
        }
        return new FftResultEnergyOnly(fArr, sampleRate);
    }

    public static FftResult over(MonoSample monoSample, IntervalsOverUnder intervalsOverUnder) {
        return get(monoSample, intervalsOverUnder.over, 1024);
    }

    public static FftResult under(MonoSample monoSample, IntervalsOverUnder intervalsOverUnder) {
        return get(monoSample, intervalsOverUnder.under, 1024);
    }
}
