package com.urbandroid.sleep.audio.transform;

/* JADX INFO: loaded from: classes4.dex */
public class FftResult {
    private final float[] complexData;
    private final double maxFrequency;
    private final float sampleRate;
    private final int size;
    private double totalEnergy = Double.NaN;

    public FftResult(float[] fArr, float f) {
        this.complexData = fArr;
        this.sampleRate = f;
        this.size = fArr.length / 2;
        this.maxFrequency = ((double) f) / 2.0d;
    }

    public int getBinByFrequency(double d) {
        int size = (int) ((((double) (size() * 2)) * d) / ((double) this.sampleRate));
        if (size >= 0 && size < size()) {
            return size;
        }
        throw new IllegalArgumentException("Frequency out of bounds: " + d + " " + getMaxFrequency());
    }

    public float getEnergy(int i) {
        float[] fArr = this.complexData;
        int i2 = i * 2;
        float f = fArr[i2];
        float f2 = fArr[i2 + 1];
        return (float) Math.sqrt((f2 * f2) + (f * f));
    }

    public double getMaxFrequency() {
        return this.maxFrequency;
    }

    public int size() {
        return this.size;
    }
}
