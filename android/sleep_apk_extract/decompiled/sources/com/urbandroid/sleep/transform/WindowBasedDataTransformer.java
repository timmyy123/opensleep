package com.urbandroid.sleep.transform;

/* JADX INFO: loaded from: classes5.dex */
public abstract class WindowBasedDataTransformer {
    private boolean enableUseOfPartialLastWindow = true;
    private int maxWindowSize;
    private boolean nonOverlappingWindows;

    public WindowBasedDataTransformer(int i, boolean z) {
        this.maxWindowSize = i;
        this.nonOverlappingWindows = z;
    }

    public final float[] getInitialWindow(float[] fArr) {
        float[] fArr2 = new float[Math.min(this.maxWindowSize, fArr.length)];
        for (int i = 0; i < this.maxWindowSize && i < fArr.length; i++) {
            fArr2[i] = fArr[i];
        }
        return fArr2;
    }

    public abstract float getValueFromWindow(float[] fArr);

    public final float[] moveWindow(float[] fArr, float[] fArr2, int i) {
        int i2;
        int length = fArr2.length - i;
        if (length <= 0) {
            return new float[0];
        }
        if (length < fArr.length) {
            fArr = new float[length];
        }
        for (int i3 = 0; i3 < this.maxWindowSize && (i2 = i3 + i) < fArr2.length; i3++) {
            fArr[i3] = fArr2[i2];
        }
        return fArr;
    }

    public final float[] transform(float[] fArr) {
        float[] fArr2 = this.nonOverlappingWindows ? new float[(fArr.length / this.maxWindowSize) + ((!this.enableUseOfPartialLastWindow || fArr.length % this.maxWindowSize == 0) ? 0 : 1)] : new float[Math.max((fArr.length - this.maxWindowSize) + 1, 0)];
        float[] initialWindow = getInitialWindow(fArr);
        int i = this.nonOverlappingWindows ? this.maxWindowSize : 1;
        float[] fArrMoveWindow = initialWindow;
        int i2 = 0;
        for (int i3 = 0; i3 < fArr2.length; i3++) {
            fArr2[i3] = getValueFromWindow(fArrMoveWindow);
            i2 += i;
            fArrMoveWindow = moveWindow(fArrMoveWindow, fArr, i2);
        }
        return fArr2;
    }
}
