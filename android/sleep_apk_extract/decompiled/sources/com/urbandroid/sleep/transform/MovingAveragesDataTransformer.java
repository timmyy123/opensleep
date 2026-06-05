package com.urbandroid.sleep.transform;

/* JADX INFO: loaded from: classes5.dex */
public class MovingAveragesDataTransformer extends WindowBasedDataTransformer {
    private float powerFactor;
    private float weightDecay;

    public MovingAveragesDataTransformer(int i, float f) {
        super(i, false);
        this.weightDecay = 1.0f;
        this.powerFactor = f;
    }

    @Override // com.urbandroid.sleep.transform.WindowBasedDataTransformer
    public float getValueFromWindow(float[] fArr) {
        if (this.weightDecay != 1.0f) {
            return getValueFromWindowWithDecay(fArr);
        }
        int length = fArr.length;
        float fPow = 0.0f;
        for (int i = 0; i < length; i++) {
            float f = fArr[i];
            fPow = (float) (((double) fPow) + (f >= 0.0f ? Math.pow(f, this.powerFactor) : f));
        }
        float length2 = fPow / fArr.length;
        return length2 >= 0.0f ? (float) Math.pow(length2, 1.0f / this.powerFactor) : length2;
    }

    public float getValueFromWindowWithDecay(float[] fArr) {
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < fArr.length; i++) {
            float f3 = fArr[i];
            double dPow = Math.pow(this.weightDecay, Math.floor(Math.abs(i - (fArr.length / 2.0f))));
            double d = f;
            double dPow2 = f3;
            if (f3 >= 0.0f) {
                dPow2 = Math.pow(dPow2, this.powerFactor) * dPow;
            }
            f = (float) (d + dPow2);
            f2 = (float) (((double) f2) + dPow);
        }
        float f4 = f / f2;
        return f4 >= 0.0f ? (float) Math.pow(f4, 1.0f / this.powerFactor) : f4;
    }
}
