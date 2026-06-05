package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgzz {
    public static int zza(int i, RoundingMode roundingMode) {
        if (i <= 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("x (0) must be > 0");
            return 0;
        }
        switch (zzgzy.zza[roundingMode.ordinal()]) {
            case 1:
                zzhac.zzb(((i + (-1)) & i) == 0);
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - iNumberOfLeadingZeros) + ((((-1257966797) >>> iNumberOfLeadingZeros) - i) >>> 31);
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$1();
                return 0;
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static int zzb(int i, int i2, RoundingMode roundingMode) {
        roundingMode.getClass();
        if (i2 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i3 = i / i2;
        int i4 = i - (i2 * i3);
        if (i4 == 0) {
            return i3;
        }
        int i5 = ((i ^ i2) >> 31) | 1;
        switch (zzgzy.zza[roundingMode.ordinal()]) {
            case 1:
                zzhac.zzb(false);
                return i3;
            case 2:
                return i3;
            case 3:
                if (i5 >= 0) {
                    return i3;
                }
                break;
            case 4:
                break;
            case 5:
                if (i5 <= 0) {
                    return i3;
                }
                break;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i4);
                int iAbs2 = iAbs - (Math.abs(i2) - iAbs);
                if (iAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if ((i3 & 1 & (roundingMode != RoundingMode.HALF_EVEN ? 0 : 1)) == 0) {
                            return i3;
                        }
                    }
                } else if (iAbs2 <= 0) {
                    return i3;
                }
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$1();
                return 0;
        }
        return i3 + i5;
    }
}
