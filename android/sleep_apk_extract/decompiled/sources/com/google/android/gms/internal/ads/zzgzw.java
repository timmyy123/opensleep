package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgzw {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        Math.log(2.0d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long zza(double d, RoundingMode roundingMode) {
        double dRint;
        long j;
        long j2;
        if (!zzgzx.zzb(d)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (zzgzv.zza[roundingMode.ordinal()]) {
            case 1:
                zzhac.zzb(zzd(d));
                dRint = d;
                if (!((-9.223372036854776E18d) - dRint >= 1.0d) || !(dRint < 9.223372036854776E18d)) {
                    return (long) dRint;
                }
                String strValueOf = String.valueOf(roundingMode);
                StringBuilder sb = new StringBuilder(String.valueOf(d).length() + 59 + strValueOf.length());
                sb.append("rounded value is out of range for input ");
                sb.append(d);
                sb.append(" and rounding mode ");
                sb.append(strValueOf);
                throw new ArithmeticException(sb.toString());
            case 2:
                if (d < 0.0d && !zzd(d)) {
                    j = (long) d;
                    j2 = -1;
                    dRint = j + j2;
                    if (!(((-9.223372036854776E18d) - dRint >= 1.0d) & (dRint < 9.223372036854776E18d))) {
                    }
                }
                dRint = d;
                if (!(((-9.223372036854776E18d) - dRint >= 1.0d) & (dRint < 9.223372036854776E18d))) {
                }
                break;
            case 3:
                if (d > 0.0d && !zzd(d)) {
                    j = (long) d;
                    j2 = 1;
                    dRint = j + j2;
                    if (!(((-9.223372036854776E18d) - dRint >= 1.0d) & (dRint < 9.223372036854776E18d))) {
                    }
                }
                dRint = d;
                if (!(((-9.223372036854776E18d) - dRint >= 1.0d) & (dRint < 9.223372036854776E18d))) {
                }
                break;
            case 4:
                dRint = d;
                if (!(((-9.223372036854776E18d) - dRint >= 1.0d) & (dRint < 9.223372036854776E18d))) {
                }
                break;
            case 5:
                if (!zzd(d)) {
                    dRint = ((long) d) + ((long) (d > 0.0d ? 1 : -1));
                }
                if (!(((-9.223372036854776E18d) - dRint >= 1.0d) & (dRint < 9.223372036854776E18d))) {
                }
                break;
            case 6:
                dRint = Math.rint(d);
                if (!(((-9.223372036854776E18d) - dRint >= 1.0d) & (dRint < 9.223372036854776E18d))) {
                }
                break;
            case 7:
                dRint = Math.rint(d);
                if (Math.abs(d - dRint) == 0.5d) {
                    dRint = Math.copySign(0.5d, d) + d;
                }
                if (!(((-9.223372036854776E18d) - dRint >= 1.0d) & (dRint < 9.223372036854776E18d))) {
                }
                break;
            case 8:
                dRint = Math.rint(d);
                if (Math.abs(d - dRint) == 0.5d) {
                }
                if (!(((-9.223372036854776E18d) - dRint >= 1.0d) & (dRint < 9.223372036854776E18d))) {
                }
                break;
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$1();
                return 0L;
        }
    }

    public static boolean zzb(double d) {
        if (d > 0.0d && zzgzx.zzb(d)) {
            long jZza = zzgzx.zza(d);
            if ((jZza & ((-1) + jZza)) == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zzc(double d, RoundingMode roundingMode) {
        boolean zZzb;
        zzgtj.zzb(d > 0.0d && zzgzx.zzb(d), "x must be positive and finite");
        int exponent = Math.getExponent(d);
        if (Math.getExponent(d) < -1022) {
            return zzc(d * 4.503599627370496E15d, roundingMode) - 52;
        }
        switch (zzgzv.zza[roundingMode.ordinal()]) {
            case 1:
                zzhac.zzb(zzb(d));
                return exponent;
            case 2:
                return exponent;
            case 3:
                z = !zzb(d);
                return !z ? exponent + 1 : exponent;
            case 4:
                z = exponent < 0;
                zZzb = zzb(d);
                z &= !zZzb;
                if (!z) {
                }
                break;
            case 5:
                z = exponent >= 0;
                zZzb = zzb(d);
                z &= !zZzb;
                if (!z) {
                }
                break;
            case 6:
            case 7:
            case 8:
                double dLongBitsToDouble = Double.longBitsToDouble((Double.doubleToRawLongBits(d) & 4503599627370495L) | 4607182418800017408L);
                if (dLongBitsToDouble * dLongBitsToDouble > 2.0d) {
                    z = true;
                }
                if (!z) {
                }
                break;
            default:
                Utf8$$ExternalSyntheticBUOutline0.m$1();
                return 0;
        }
    }

    public static boolean zzd(double d) {
        if (zzgzx.zzb(d)) {
            return d == 0.0d || 52 - Long.numberOfTrailingZeros(zzgzx.zza(d)) <= Math.getExponent(d);
        }
        return false;
    }
}
