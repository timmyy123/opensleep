package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class zzcgd {
    private final zzcfw zza;
    private final AtomicInteger zzb;

    public zzcgd() {
        zzcfw zzcfwVar = new zzcfw();
        this.zza = zzcfwVar;
        this.zzb = new AtomicInteger(0);
        zzhbw.zzr(zzcfwVar, new zzcgb(this), zzcfr.zzh);
    }

    @Deprecated
    public final void zze(zzcga zzcgaVar, zzcfy zzcfyVar) {
        zzhbw.zzr(this.zza, new zzcgc(this, zzcgaVar, zzcfyVar), zzcfr.zzh);
    }

    @Deprecated
    public final void zzf(Object obj) {
        this.zza.zzc(obj);
    }

    @Deprecated
    public final void zzg() {
        this.zza.zzd(new Exception());
    }

    @Deprecated
    public final void zzh(Throwable th, String str) {
        this.zza.zzd(th);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zziF)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzh().zzh(th, str);
        }
    }

    @Deprecated
    public final int zzi() {
        return this.zzb.get();
    }

    public final /* synthetic */ AtomicInteger zzj() {
        return this.zzb;
    }
}
