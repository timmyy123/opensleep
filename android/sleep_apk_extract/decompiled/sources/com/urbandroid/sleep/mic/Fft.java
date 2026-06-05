package com.urbandroid.sleep.mic;

import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class Fft {

    public static class FftResult {

        /* JADX INFO: renamed from: data, reason: collision with root package name */
        private float[] f71data;
        private double powerSum;

        public FftResult(float[] fArr, double d) {
            this.f71data = fArr;
            this.powerSum = d;
        }

        public float[] getData() {
            return this.f71data;
        }

        public double getPowerSum() {
            return this.powerSum;
        }

        public void setData(float[] fArr) {
            this.f71data = fArr;
        }

        public void setPowerSum(double d) {
            this.powerSum = d;
        }
    }

    private static int bitreverseReference(int i, int i2) {
        int i3 = 0;
        int i4 = 1;
        while (i4 <= i2) {
            int i5 = i / 2;
            i3 = ((i3 * 2) + i) - (i5 * 2);
            i4++;
            i = i5;
        }
        return i3;
    }

    public static FftResult fft(float[] fArr, float[] fArr2, boolean z) {
        int length = fArr.length;
        double d = length;
        double dLog = Math.log(d) / Math.log(2.0d);
        int i = (int) dLog;
        if (((double) i) - dLog != 0.0d) {
            Logger.logInfo("The number of elements is not a power of 2.");
            System.out.println("The number of elements is not a power of 2.");
            return null;
        }
        int i2 = length / 2;
        int i3 = i - 1;
        float[] fArr3 = new float[length];
        float[] fArr4 = new float[length];
        double d2 = z ? -6.283185307179586d : 6.283185307179586d;
        for (int i4 = 0; i4 < length; i4++) {
            fArr3[i4] = fArr[i4];
            fArr4[i4] = fArr2[i4];
        }
        int i5 = 1;
        while (i5 <= i) {
            int i6 = 0;
            while (i6 < length) {
                int i7 = 1;
                while (i7 <= i2) {
                    double dBitreverseReference = (((float) d2) * bitreverseReference(i6 >> i3, i)) / length;
                    int i8 = i5;
                    float fCos = (float) Math.cos(dBitreverseReference);
                    float fSin = (float) Math.sin(dBitreverseReference);
                    int i9 = i6 + i2;
                    float f = fArr3[i9];
                    float f2 = fArr4[i9];
                    float f3 = (f2 * fSin) + (f * fCos);
                    float f4 = (f2 * fCos) - (f * fSin);
                    fArr3[i9] = fArr3[i6] - f3;
                    fArr4[i9] = fArr4[i6] - f4;
                    fArr3[i6] = fArr3[i6] + f3;
                    fArr4[i6] = fArr4[i6] + f4;
                    i6++;
                    i7++;
                    i5 = i8;
                }
                i6 += i2;
            }
            i3--;
            i2 /= 2;
            i5++;
        }
        for (int i10 = 0; i10 < length; i10++) {
            int iBitreverseReference = bitreverseReference(i10, i);
            if (iBitreverseReference > i10) {
                float f5 = fArr3[i10];
                float f6 = fArr4[i10];
                fArr3[i10] = fArr3[iBitreverseReference];
                fArr4[i10] = fArr4[iBitreverseReference];
                fArr3[iBitreverseReference] = f5;
                fArr4[iBitreverseReference] = f6;
            }
        }
        float[] fArr5 = new float[length];
        float fSqrt = (float) (1.0d / Math.sqrt(d));
        double dSqrt = 0.0d;
        for (int i11 = 0; i11 < length; i11 += 2) {
            int i12 = i11 / 2;
            fArr5[i11] = fArr3[i12] * fSqrt;
            fArr5[i11 + 1] = fArr4[i12] * fSqrt;
            float f7 = fArr5[i11];
            dSqrt += Math.sqrt((r3 * r3) + (f7 * f7));
        }
        return new FftResult(fArr5, dSqrt);
    }
}
