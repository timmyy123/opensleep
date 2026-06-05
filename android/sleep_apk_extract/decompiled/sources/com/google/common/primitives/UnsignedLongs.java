package com.google.common.primitives;

import com.facebook.appevents.AppEventsConstants;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes4.dex */
public abstract class UnsignedLongs {
    public static int compare(long j, long j2) {
        return Longs.compare(flip(j), flip(j2));
    }

    public static long divide(long j, long j2) {
        if (j2 < 0) {
            return compare(j, j2) < 0 ? 0L : 1L;
        }
        if (j >= 0) {
            return j / j2;
        }
        long j3 = ((j >>> 1) / j2) << 1;
        return j3 + ((long) (compare(j - (j3 * j2), j2) < 0 ? 0 : 1));
    }

    private static long flip(long j) {
        return j ^ Long.MIN_VALUE;
    }

    public static String toString(long j, int i) {
        Preconditions.checkArgument(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        if (j == 0) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        if (j > 0) {
            return Long.toString(j, i);
        }
        int i2 = 64;
        char[] cArr = new char[64];
        int i3 = i - 1;
        if ((i & i3) == 0) {
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i2--;
                cArr[i2] = Character.forDigit(((int) j) & i3, i);
                j >>>= iNumberOfTrailingZeros;
            } while (j != 0);
        } else {
            long jDivide = (i & 1) == 0 ? (j >>> 1) / ((long) (i >>> 1)) : divide(j, i);
            long j2 = i;
            int i4 = 63;
            cArr[63] = Character.forDigit((int) (j - (jDivide * j2)), i);
            while (jDivide > 0) {
                i4--;
                cArr[i4] = Character.forDigit((int) (jDivide % j2), i);
                jDivide /= j2;
            }
            i2 = i4;
        }
        return new String(cArr, i2, 64 - i2);
    }

    public static String toString(long j) {
        return toString(j, 10);
    }
}
