package com.urbandroid.sleep.snoring.newfftresult;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FftResult {
    private final double maxFrequency;
    private final float sampleRate;

    public FftResult(float f, boolean z) {
        double d;
        double d2;
        this.sampleRate = f;
        if (z) {
            d = f - 1.0f;
            d2 = 2.0d;
        } else {
            d = f;
            d2 = 2.000001d;
        }
        this.maxFrequency = d / d2;
    }

    public int getBinByFrequency(double d) {
        int size = (int) ((((double) (size() * 2)) * d) / ((double) this.sampleRate));
        if (size >= 0 && size < size()) {
            return size;
        }
        StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(size, "Frequency out of bounds: ", " ");
        sbM65m.append(size());
        sbM65m.append(" ");
        sbM65m.append(d);
        sbM65m.append(" ");
        sbM65m.append(getMaxFrequency());
        throw new IllegalArgumentException(sbM65m.toString());
    }

    public float[] getEnergies() {
        float[] fArr = new float[size()];
        for (int i = 0; i < size(); i++) {
            fArr[i] = getEnergy(i);
        }
        return fArr;
    }

    public abstract float getEnergy(int i);

    public double getEnergySum(double d, double d2) {
        if (d > d2) {
            throw new IllegalArgumentException(d + " > " + d2);
        }
        int binByFrequency = getBinByFrequency(d2);
        double energy = 0.0d;
        for (int binByFrequency2 = getBinByFrequency(d); binByFrequency2 <= binByFrequency; binByFrequency2++) {
            energy += (double) getEnergy(binByFrequency2);
        }
        return energy;
    }

    public double getEnergySumNorm(double d, double d2) {
        return getEnergySumNorm(d, d2, 0.0d, getMaxFrequency());
    }

    public double getFrequency(int i) {
        if (i >= 0 && i < size()) {
            return ((((double) i) * 0.5d) * ((double) this.sampleRate)) / ((double) size());
        }
        StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i, "Bin out of bounds: ", " ");
        sbM65m.append(size());
        throw new IllegalArgumentException(sbM65m.toString());
    }

    public double getMaxEnergy(double d, double d2) {
        return getEnergy(getMaxEnergyBin(d, d2));
    }

    public int getMaxEnergyBin(double d, double d2) {
        if (d > d2) {
            throw new IllegalArgumentException(d + " > " + d2);
        }
        int binByFrequency = getBinByFrequency(d);
        int binByFrequency2 = getBinByFrequency(d2);
        double energy = Double.NEGATIVE_INFINITY;
        int i = binByFrequency;
        while (binByFrequency <= binByFrequency2) {
            if (getEnergy(binByFrequency) > energy) {
                energy = getEnergy(binByFrequency);
                i = binByFrequency;
            }
            binByFrequency++;
        }
        return i;
    }

    public double getMaxFrequency() {
        return this.maxFrequency;
    }

    public abstract int size();

    public double getEnergySumNorm(double d, double d2, double d3, double d4) {
        return getEnergySum(d, d2) / getEnergySum(d3, d4);
    }

    public FftResult(float f) {
        this.sampleRate = f;
        this.maxFrequency = ((double) (f - 1.0f)) / 2.0d;
    }

    public double getEnergySum() {
        return getEnergySum(0.0d, getMaxFrequency());
    }
}
