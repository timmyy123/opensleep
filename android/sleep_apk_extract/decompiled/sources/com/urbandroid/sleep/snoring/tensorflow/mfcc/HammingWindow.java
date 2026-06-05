package com.urbandroid.sleep.snoring.tensorflow.mfcc;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class HammingWindow {
    private final int size;
    private final float[] window;

    public HammingWindow(int i) {
        this.size = i;
        this.window = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.window[i2] = (float) (0.54d - (Math.cos((((double) i2) * 6.283185307179586d) / ((double) (i - 1))) * 0.46d));
        }
    }

    public float[] process(float[] fArr) {
        int length = fArr.length;
        int i = this.size;
        if (length != i) {
            Events$$ExternalSyntheticBUOutline0.m(fArr.length, this.size, " ");
            return null;
        }
        float[] fArr2 = new float[i];
        for (int i2 = 0; i2 < this.size; i2++) {
            fArr2[i2] = fArr[i2] * this.window[i2];
        }
        return fArr2;
    }
}
