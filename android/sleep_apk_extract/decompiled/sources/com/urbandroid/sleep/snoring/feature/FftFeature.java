package com.urbandroid.sleep.snoring.feature;

import com.facebook.appevents.UserDataStore;
import com.urbandroid.sleep.snoring.newfftresult.FftResult;
import com.urbandroid.sleep.snoring.record.Function;
import com.urbandroid.sleep.snoring.record.Record;

/* JADX INFO: loaded from: classes5.dex */
public class FftFeature implements Function {
    private final Function<FftResult, Double> featureCalculator;
    private final String fftArtifactName;
    private final String header;

    private FftFeature(String str, String str2, Function<FftResult, Double> function) {
        this.fftArtifactName = str;
        this.header = str2;
        this.featureCalculator = function;
    }

    public static FftFeature energyMaxFreq(String str, final double d, final double d2) {
        return new FftFeature(str, "emf" + d + "-" + d2, new Function<FftResult, Double>() { // from class: com.urbandroid.sleep.snoring.feature.FftFeature.10
            @Override // com.urbandroid.sleep.snoring.record.Function
            public Double apply(FftResult fftResult) {
                return Double.valueOf(fftResult.getFrequency(fftResult.getMaxEnergyBin(d, d2)));
            }
        });
    }

    public static FftFeature energyMaxRel(String str, final double d, final double d2) {
        return new FftFeature(str, UserDataStore.EMAIL + d + "-" + d2 + "/all", new Function<FftResult, Double>() { // from class: com.urbandroid.sleep.snoring.feature.FftFeature.8
            @Override // com.urbandroid.sleep.snoring.record.Function
            public Double apply(FftResult fftResult) {
                return Double.valueOf(fftResult.getMaxEnergy(d, d2) / fftResult.getEnergySum());
            }
        });
    }

    @Override // com.urbandroid.sleep.snoring.record.Function
    public Record apply(Record record) {
        Double dApply = this.featureCalculator.apply((FftResult) record.get(this.fftArtifactName));
        dApply.doubleValue();
        record.addFeature(this.header, dApply);
        return record;
    }
}
