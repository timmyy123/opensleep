package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzejd {
    private long zza = 0;
    private int zzb = 0;
    private long zzc = 0;
    private long zzd = 0;
    private long zze = 0;
    private final Object zzf = new Object();
    private final Object zzg = new Object();
    private final Object zzh = new Object();
    private final Object zzi = new Object();
    private final Object zzj = new Object();

    public final synchronized void zza(long j) {
        synchronized (this.zzf) {
            this.zza = j;
        }
    }

    public final synchronized long zzb() {
        long j;
        synchronized (this.zzf) {
            j = this.zza;
        }
        return j;
    }

    public final void zzc(int i) {
        synchronized (this.zzg) {
            this.zzb = i;
        }
    }

    public final int zzd() {
        int i;
        synchronized (this.zzg) {
            i = this.zzb;
        }
        return i;
    }

    public final void zze(long j) {
        synchronized (this.zzh) {
            this.zzc = j;
        }
    }

    public final long zzf() {
        long j;
        synchronized (this.zzh) {
            j = this.zzc;
        }
        return j;
    }

    public final synchronized void zzg(long j) {
        synchronized (this.zzi) {
            this.zzd = j;
        }
    }

    public final synchronized long zzh() {
        long j;
        synchronized (this.zzi) {
            j = this.zzd;
        }
        return j;
    }

    public final synchronized void zzi(long j) {
        synchronized (this.zzj) {
            this.zze = j;
        }
    }

    public final synchronized long zzj() {
        long j;
        synchronized (this.zzj) {
            j = this.zze;
        }
        return j;
    }
}
