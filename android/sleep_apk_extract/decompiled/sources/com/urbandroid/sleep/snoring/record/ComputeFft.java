package com.urbandroid.sleep.snoring.record;

import com.urbandroid.sleep.snoring.newfftresult.FFT;

/* JADX INFO: loaded from: classes5.dex */
public class ComputeFft implements Function {
    private final String srcKey;
    private final String targetKey;

    public ComputeFft(String str, String str2) {
        this.srcKey = str;
        this.targetKey = str2;
    }

    @Override // com.urbandroid.sleep.snoring.record.Function
    public Record apply(Record record) {
        record.set(this.targetKey, FFT.fft((MonoSample) record.get(this.srcKey)));
        return record;
    }

    public ComputeFft(String str) {
        this("SAMPLE", str);
    }
}
