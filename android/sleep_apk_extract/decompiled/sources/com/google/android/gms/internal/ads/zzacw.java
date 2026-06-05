package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class zzacw {
    private long zza;
    private long zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private long zzf;
    private final boolean[] zzg = new boolean[15];
    private int zzh;

    public final void zza() {
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzh = 0;
        Arrays.fill(this.zzg, false);
    }

    public final boolean zzb() {
        return this.zzd > 15 && this.zzh == 0;
    }

    public final boolean zzc() {
        long j = this.zzd;
        if (j == 0) {
            return false;
        }
        return this.zzg[(int) ((j - 1) % 15)];
    }

    public final long zzd() {
        return this.zzf;
    }

    public final long zze() {
        long j = this.zze;
        if (j == 0) {
            return 0L;
        }
        return this.zzf / j;
    }

    public final void zzf(long j) {
        long j2 = this.zzd;
        if (j2 == 0) {
            this.zza = j;
        } else if (j2 == 1) {
            long j3 = j - this.zza;
            this.zzb = j3;
            this.zzf = j3;
            this.zze = 1L;
        } else {
            long j4 = j - this.zzc;
            int i = (int) (j2 % 15);
            if (Math.abs(j4 - this.zzb) <= 1000000) {
                this.zze++;
                this.zzf += j4;
                boolean[] zArr = this.zzg;
                if (zArr[i]) {
                    zArr[i] = false;
                    this.zzh--;
                }
            } else {
                boolean[] zArr2 = this.zzg;
                if (!zArr2[i]) {
                    zArr2[i] = true;
                    this.zzh++;
                }
            }
        }
        this.zzd++;
        this.zzc = j;
    }
}
