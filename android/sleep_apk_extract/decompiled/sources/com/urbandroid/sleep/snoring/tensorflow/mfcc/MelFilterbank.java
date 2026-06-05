package com.urbandroid.sleep.snoring.tensorflow.mfcc;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.snoring.newfftresult.FftResult;
import com.urbandroid.sleep.snoring.newfftresult.FftResultZero;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class MelFilterbank {
    private final int[] centerBins;
    private final int fftSize;
    private final float maxFreq;
    private final float minFreq;
    private final int noMelBands;
    private final int sampleRate;

    public MelFilterbank(int i, int i2, int i3, float f, float f2) {
        if (i < 1 || i > i2) {
            Events$$ExternalSyntheticBUOutline0.m$1(i, i2, " ");
            throw null;
        }
        if (i2 < 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i2, ""));
            throw null;
        }
        if (i3 < 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i3, ""));
            throw null;
        }
        if (f < 0.0f) {
            Events$$ExternalSyntheticBUOutline0.m("", f);
            throw null;
        }
        if (f2 <= f || f2 > i3 / 2) {
            throw new IllegalArgumentException(f2 + " " + f + " " + i3);
        }
        this.noMelBands = i;
        this.fftSize = i2;
        this.sampleRate = i3;
        this.minFreq = f;
        this.maxFreq = f2;
        this.centerBins = calculateCenterBins();
    }

    private int[] calculateCenterBins() {
        FftResultZero fftResultZero = new FftResultZero(this.fftSize, this.sampleRate);
        int i = this.noMelBands;
        int[] iArr = new int[i + 2];
        iArr[0] = fftResultZero.getBinByFrequency(this.minFreq);
        iArr[i + 1] = fftResultZero.getBinByFrequency(this.maxFreq);
        float fFreqToMel = (float) ((((double) freqToMel(this.maxFreq)) - freqToMel(this.minFreq)) / ((double) (this.noMelBands + 1)));
        for (int i2 = 1; i2 <= this.noMelBands; i2++) {
            iArr[i2] = fftResultZero.getBinByFrequency(melToFreq(((double) (i2 * fFreqToMel)) + r4));
        }
        return iArr;
    }

    public static float freqToMel(float f) {
        return (float) (Math.log((f / 700.0f) + 1.0f) * 1125.0d);
    }

    public static float melToFreq(double d) {
        return (float) ((Math.exp(d / 1125.0d) - 1.0d) * 700.0d);
    }

    public float[] process(FftResult fftResult) {
        if (fftResult.size() != this.fftSize) {
            Events$$ExternalSyntheticBUOutline0.m(fftResult.size(), this.fftSize, " ");
            return null;
        }
        float[] fArr = new float[this.noMelBands];
        int i = 0;
        while (i < this.noMelBands) {
            int[] iArr = this.centerBins;
            int i2 = iArr[i];
            int i3 = i + 1;
            int i4 = iArr[i3];
            int i5 = iArr[i + 2];
            float energy = 0.0f;
            float energy2 = 0.0f;
            for (int i6 = i2; i6 <= i4; i6++) {
                energy2 += fftResult.getEnergy(i6) * ((i6 - i2) + 1);
            }
            float f = energy2 / ((i4 - i2) + 1);
            for (int i7 = i4 + 1; i7 <= i5; i7++) {
                energy += fftResult.getEnergy(i7) * ((i5 - i7) + 1);
            }
            if (i5 > i4) {
                energy /= i5 - i4;
            }
            fArr[i] = f + energy;
            i = i3;
        }
        return fArr;
    }
}
