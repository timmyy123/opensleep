package com.urbandroid.sleep.snoring.newfftresult;

/* JADX INFO: loaded from: classes5.dex */
public class FftResultZero extends FftResult {
    private final int size;

    public FftResultZero(int i, float f) {
        super(f);
        this.size = i;
    }

    @Override // com.urbandroid.sleep.snoring.newfftresult.FftResult
    public float getEnergy(int i) {
        return 0.0f;
    }

    @Override // com.urbandroid.sleep.snoring.newfftresult.FftResult
    public int size() {
        return this.size;
    }
}
