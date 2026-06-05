package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public final class zzjd {
    private final long zza;
    private final long zzb;
    private long zzc = -9223372036854775807L;
    private long zzd = -9223372036854775807L;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private float zzj = 0.97f;
    private float zzi = 1.03f;
    private float zzk = 1.0f;
    private long zzl = -9223372036854775807L;
    private long zze = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private long zzm = -9223372036854775807L;
    private long zzn = -9223372036854775807L;

    public /* synthetic */ zzjd(float f, float f2, long j, float f3, long j2, long j3, float f4, byte[] bArr) {
        this.zza = j2;
        this.zzb = j3;
    }

    private final void zzf() {
        long j;
        long j2 = this.zzc;
        if (j2 != -9223372036854775807L) {
            j = this.zzd;
            if (j == -9223372036854775807L) {
                long j3 = this.zzf;
                if (j3 != -9223372036854775807L && j2 < j3) {
                    j2 = j3;
                }
                j = this.zzg;
                if (j == -9223372036854775807L || j2 <= j) {
                    j = j2;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.zze == j) {
            return;
        }
        this.zze = j;
        this.zzh = j;
        this.zzm = -9223372036854775807L;
        this.zzn = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
    }

    private static long zzg(long j, long j2, float f) {
        return (long) ((j2 * 9.999871E-4f) + (j * 0.999f));
    }

    public final void zza(zzaf zzafVar) {
        long j = zzafVar.zza;
        this.zzc = zzfl.zzs(-9223372036854775807L);
        this.zzf = zzfl.zzs(-9223372036854775807L);
        this.zzg = zzfl.zzs(-9223372036854775807L);
        this.zzj = 0.97f;
        this.zzi = 1.03f;
        zzf();
    }

    public final void zzb(long j) {
        this.zzd = j;
        zzf();
    }

    public final void zzc() {
        long j = this.zzh;
        if (j == -9223372036854775807L) {
            return;
        }
        long j2 = j + this.zzb;
        this.zzh = j2;
        long j3 = this.zzg;
        if (j3 != -9223372036854775807L && j2 > j3) {
            this.zzh = j3;
        }
        this.zzl = -9223372036854775807L;
    }

    public final float zzd(long j, long j2) {
        long jMax;
        if (this.zzc == -9223372036854775807L) {
            return 1.0f;
        }
        long j3 = j - j2;
        long j4 = this.zzm;
        if (j4 == -9223372036854775807L) {
            this.zzm = j3;
            this.zzn = 0L;
        } else {
            long jMax2 = Math.max(j3, zzg(j4, j3, 0.999f));
            this.zzm = jMax2;
            this.zzn = zzg(this.zzn, Math.abs(j3 - jMax2), 0.999f);
        }
        if (this.zzl != -9223372036854775807L && SystemClock.elapsedRealtime() - this.zzl < 1000) {
            return this.zzk;
        }
        this.zzl = SystemClock.elapsedRealtime();
        long j5 = (this.zzn * 3) + this.zzm;
        if (this.zzh > j5) {
            long jZzs = zzfl.zzs(1000L);
            float f = this.zzk - 1.0f;
            float f2 = this.zzi - 1.0f;
            long j6 = this.zze;
            float f3 = jZzs;
            long j7 = this.zzh - (((long) (f * f3)) + ((long) (f2 * f3)));
            long[] jArr = {j5, j6, j7};
            jMax = jArr[0];
            for (int i = 1; i < 3; i++) {
                long j8 = jArr[i];
                if (j8 > jMax) {
                    jMax = j8;
                }
            }
            this.zzh = jMax;
        } else {
            long jMax3 = j - ((long) (Math.max(0.0f, this.zzk - 1.0f) / 1.0E-7f));
            long j9 = this.zzh;
            String str = zzfl.zza;
            jMax = Math.max(j9, Math.min(jMax3, j5));
            this.zzh = jMax;
            long j10 = this.zzg;
            if (j10 != -9223372036854775807L && jMax > j10) {
                this.zzh = j10;
                jMax = j10;
            }
        }
        long j11 = j - jMax;
        if (Math.abs(j11) < this.zza) {
            this.zzk = 1.0f;
            return 1.0f;
        }
        float fMax = Math.max(this.zzj, Math.min((j11 * 1.0E-7f) + 1.0f, this.zzi));
        this.zzk = fMax;
        return fMax;
    }

    public final long zze() {
        return this.zzh;
    }
}
