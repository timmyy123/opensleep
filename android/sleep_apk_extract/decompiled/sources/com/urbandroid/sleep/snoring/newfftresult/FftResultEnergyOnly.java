package com.urbandroid.sleep.snoring.newfftresult;

/* JADX INFO: loaded from: classes5.dex */
public class FftResultEnergyOnly extends FftResult {
    private final float[] energy;
    private final int size;

    public FftResultEnergyOnly(float[] fArr, float f) {
        super(f);
        this.energy = fArr;
        this.size = fArr.length;
    }

    @Override // com.urbandroid.sleep.snoring.newfftresult.FftResult
    public float getEnergy(int i) {
        return this.energy[i];
    }

    @Override // com.urbandroid.sleep.snoring.newfftresult.FftResult
    public int size() {
        return this.size;
    }
}
