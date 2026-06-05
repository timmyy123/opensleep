package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzgzx {
    public static long zza(double d) {
        zzgtj.zzb(zzb(d), "not a normal value");
        int exponent = Math.getExponent(d);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d) & 4503599627370495L;
        return exponent == -1023 ? jDoubleToRawLongBits + jDoubleToRawLongBits : jDoubleToRawLongBits | 4503599627370496L;
    }

    public static boolean zzb(double d) {
        return Math.getExponent(d) <= 1023;
    }
}
