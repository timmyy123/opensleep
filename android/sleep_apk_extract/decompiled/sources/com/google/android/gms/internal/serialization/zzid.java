package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzid {
    public static long zza(long j, long j2) {
        long j3 = j + j2;
        zzie.zza(((j ^ j2) < 0) | ((j ^ j3) >= 0), "checkedAdd", j, j2);
        return j3;
    }

    public static long zzb(long j, long j2) {
        long j3 = (-1) + j;
        zzie.zza(((1 ^ j) >= 0) | ((j ^ j3) >= 0), "checkedSubtract", j, 1L);
        return j3;
    }

    public static long zzc(long j, long j2) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(-1001L) + Long.numberOfLeadingZeros(1000L) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
        long j3 = j * 1000;
        if (iNumberOfLeadingZeros > 65) {
            return j3;
        }
        zzie.zza(iNumberOfLeadingZeros >= 64, "checkedMultiply", j, 1000L);
        zzie.zza(true, "checkedMultiply", j, 1000L);
        zzie.zza(j == 0 || j3 / j == 1000, "checkedMultiply", j, 1000L);
        return j3;
    }
}
