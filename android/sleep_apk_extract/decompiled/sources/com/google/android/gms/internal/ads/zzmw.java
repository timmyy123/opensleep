package com.google.android.gms.internal.ads;

import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public final class zzmw {
    private final zzmv zza;
    private final zzmu zzb;
    private final zzbf zzc;
    private int zzd;
    private Object zze;
    private final Looper zzf;
    private final int zzg;
    private boolean zzh;
    private boolean zzi;

    public zzmw(zzmu zzmuVar, zzmv zzmvVar, zzbf zzbfVar, int i, zzdo zzdoVar, Looper looper) {
        this.zzb = zzmuVar;
        this.zza = zzmvVar;
        this.zzc = zzbfVar;
        this.zzf = looper;
        this.zzg = i;
    }

    public final zzmv zza() {
        return this.zza;
    }

    public final zzmw zzb(int i) {
        zzgtj.zzi(!this.zzh);
        this.zzd = i;
        return this;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzmw zzd(Object obj) {
        zzgtj.zzi(!this.zzh);
        this.zze = obj;
        return this;
    }

    public final Object zze() {
        return this.zze;
    }

    public final Looper zzf() {
        return this.zzf;
    }

    public final zzmw zzg() {
        zzgtj.zzi(!this.zzh);
        this.zzh = true;
        this.zzb.zzk(this);
        return this;
    }

    public final synchronized boolean zzh() {
        return false;
    }

    public final synchronized void zzi(boolean z) {
        this.zzi = z | this.zzi;
        notifyAll();
    }
}
