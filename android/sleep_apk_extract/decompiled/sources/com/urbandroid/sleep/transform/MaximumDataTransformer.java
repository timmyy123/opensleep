package com.urbandroid.sleep.transform;

/* JADX INFO: loaded from: classes5.dex */
public class MaximumDataTransformer extends WindowBasedDataTransformer {
    public MaximumDataTransformer(int i, boolean z) {
        super(i, z);
    }

    @Override // com.urbandroid.sleep.transform.WindowBasedDataTransformer
    public float getValueFromWindow(float[] fArr) {
        float f = Float.NEGATIVE_INFINITY;
        for (float f2 : fArr) {
            if (f2 > f) {
                f = f2;
            }
        }
        return f;
    }
}
