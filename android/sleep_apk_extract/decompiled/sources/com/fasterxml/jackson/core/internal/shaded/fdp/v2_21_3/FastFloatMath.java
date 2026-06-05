package com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3;

/* JADX INFO: loaded from: classes.dex */
abstract class FastFloatMath {
    private static final float[] FLOAT_POWER_OF_TEN = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f};

    public static float fastScalb(float f, int i) {
        return Float.intBitsToFloat((i + 127) << 23) * f;
    }

    public static float tryDecFloatToFloatTruncated(boolean z, long j, int i, boolean z2, int i2) {
        if (j == 0) {
            return z ? -0.0f : 0.0f;
        }
        if (!z2) {
            if (-45 > i || i > 38) {
                return Float.NaN;
            }
            return tryDecToFloatWithFastAlgorithm(z, j, i);
        }
        if (-45 <= i2 && i2 <= 38) {
            float fTryDecToFloatWithFastAlgorithm = tryDecToFloatWithFastAlgorithm(z, j, i2);
            if (tryDecToFloatWithFastAlgorithm(z, j + 1, i2) == fTryDecToFloatWithFastAlgorithm) {
                return fTryDecToFloatWithFastAlgorithm;
            }
        }
        return Float.NaN;
    }

    public static float tryDecToFloatWithFastAlgorithm(boolean z, long j, int i) {
        if (-10 <= i && i <= 10 && Long.compare(Long.MIN_VALUE ^ j, -9223372036837998593L) <= 0) {
            float f = j;
            float f2 = i < 0 ? f / FLOAT_POWER_OF_TEN[-i] : f * FLOAT_POWER_OF_TEN[i];
            return z ? -f2 : f2;
        }
        long j2 = FastDoubleMath.MANTISSA_64[i + 325];
        long j3 = ((((long) i) * 217706) >> 16) + 191;
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j);
        long jUnsignedMultiplyHigh = FastIntegerMath.unsignedMultiplyHigh(j << iNumberOfLeadingZeros, j2);
        long j4 = jUnsignedMultiplyHigh >>> 63;
        long j5 = jUnsignedMultiplyHigh >>> ((int) (38 + j4));
        int i2 = iNumberOfLeadingZeros + ((int) (j4 ^ 1));
        long j6 = jUnsignedMultiplyHigh & 274877906943L;
        if (j6 != 274877906943L) {
            if (j6 != 0 || (3 & j5) != 1) {
                long j7 = (j5 + 1) >>> 1;
                if (j7 >= 16777216) {
                    i2--;
                    j7 = 8388608;
                }
                long j8 = j7 & (-8388609);
                long j9 = j3 - ((long) i2);
                if (j9 >= 1 && j9 <= 254) {
                    return Float.intBitsToFloat((int) (j8 | (j9 << 23) | (z ? 2147483648L : 0L)));
                }
            }
        }
        return Float.NaN;
    }

    public static float tryHexFloatToFloatTruncated(boolean z, long j, int i, boolean z2, int i2) {
        if (z2) {
            i = i2;
        }
        if (-126 > i || i > 127) {
            return Float.NaN;
        }
        float fFastScalb = fastScalb(j + (j < 0 ? 1.8446744E19f : 0.0f), i);
        return z ? -fFastScalb : fFastScalb;
    }
}
