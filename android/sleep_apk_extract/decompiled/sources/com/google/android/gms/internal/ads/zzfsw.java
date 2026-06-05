package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfsw {
    private final long zza;
    private final long zzb;
    private final Clock zzf;
    private long zzg;
    private long zzd = 5;
    private long zze = 0;
    private final Random zzh = new Random();
    private long zzc = 0;

    public zzfsw(long j, double d, long j2, double d2, Clock clock) {
        this.zza = j;
        this.zzb = j2;
        this.zzf = clock;
        zza();
    }

    public final synchronized void zza() {
        this.zzg = this.zza;
        this.zzc = 0L;
        this.zze = 0L;
    }

    public final synchronized long zzb() {
        double d;
        double d2;
        long j;
        d = this.zzg;
        d2 = 0.2d * d;
        j = (long) (d + d2);
        return ((long) (d - d2)) + ((long) (this.zzh.nextDouble() * ((j - r0) + 1)));
    }

    public final synchronized void zzc() {
        this.zze = this.zzf.currentTimeMillis() + zzb();
        double d = this.zzg;
        this.zzg = Math.min((long) (d + d), this.zzb);
        this.zzc++;
    }

    public final synchronized boolean zzd() {
        return this.zzf.currentTimeMillis() < this.zze;
    }

    public final synchronized boolean zze() {
        if (((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzI)).intValue() < 0) {
            return false;
        }
        if (this.zzc > Math.max(this.zzd, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(r0)).intValue())) {
            if (this.zzg >= this.zzb) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void zzf(int i) {
        Preconditions.checkArgument(i > 0);
        this.zzd = i;
    }
}
