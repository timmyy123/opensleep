package com.urbandroid.sleep.snoring.newfftresult;

/* JADX INFO: loaded from: classes5.dex */
public class FftResultRaw extends FftResult {
    private final float[] complexData;
    private final int size;

    public FftResultRaw(float[] fArr, float f, boolean z) {
        super(f, z);
        this.complexData = fArr;
        this.size = fArr.length / 2;
    }

    @Override // com.urbandroid.sleep.snoring.newfftresult.FftResult
    public float getEnergy(int i) {
        float[] fArr = this.complexData;
        int i2 = i * 2;
        float f = fArr[i2];
        float f2 = fArr[i2 + 1];
        return (float) Math.sqrt((f2 * f2) + (f * f));
    }

    @Override // com.urbandroid.sleep.snoring.newfftresult.FftResult
    public int size() {
        return this.size;
    }

    public FftResultRaw(float[] fArr, float f) {
        this(fArr, f, true);
    }
}
