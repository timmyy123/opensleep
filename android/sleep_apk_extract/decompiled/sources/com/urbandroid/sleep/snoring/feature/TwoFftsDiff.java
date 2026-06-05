package com.urbandroid.sleep.snoring.feature;

import com.urbandroid.sleep.snoring.newfftresult.FftResult;
import com.urbandroid.sleep.snoring.record.Function;
import com.urbandroid.sleep.snoring.record.Record;
import com.urbandroid.util.ScienceUtil;

/* JADX INFO: loaded from: classes5.dex */
public class TwoFftsDiff implements Function {
    private final String fft1Name;
    private final String fft2Name;
    private final double fromFreq;
    private final String name;
    private final double toFreq;

    public TwoFftsDiff(String str, String str2, double d, double d2) {
        this.fft1Name = str;
        this.fft2Name = str2;
        this.fromFreq = d;
        this.toFreq = d2;
        this.name = "FFTOU" + d + "-" + d2;
    }

    @Override // com.urbandroid.sleep.snoring.record.Function
    public Record apply(Record record) {
        FftResult fftResult = (FftResult) record.get(this.fft1Name);
        FftResult fftResult2 = (FftResult) record.get(this.fft2Name);
        double energySumNorm = fftResult.getEnergySumNorm(this.fromFreq, this.toFreq);
        double energySumNorm2 = fftResult2.getEnergySumNorm(this.fromFreq, this.toFreq);
        record.addFeature(this.name, Double.valueOf(ScienceUtil.div0(energySumNorm - energySumNorm2, energySumNorm + energySumNorm2)));
        return record;
    }
}
