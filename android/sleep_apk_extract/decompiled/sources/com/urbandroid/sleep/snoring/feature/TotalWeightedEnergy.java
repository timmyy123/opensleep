package com.urbandroid.sleep.snoring.feature;

import com.urbandroid.sleep.snoring.newfftresult.FftResult;
import com.urbandroid.sleep.snoring.record.Function;
import com.urbandroid.sleep.snoring.record.MonoSample;
import com.urbandroid.sleep.snoring.record.Record;

/* JADX INFO: loaded from: classes5.dex */
public class TotalWeightedEnergy implements Function {
    @Override // com.urbandroid.sleep.snoring.record.Function
    public Record apply(Record record) {
        record.addFeature("TWE", Double.valueOf(Math.log((((FftResult) record.get("FFT")).getEnergySum() / ((MonoSample) record.get("SAMPLE")).getDurationSeconds()) + 1.0d)));
        return record;
    }
}
