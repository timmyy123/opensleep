package com.google.android.gms.internal.ads;

import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdm {
    private final zzdz zza;
    private final zzdz zzb;
    private final zzdl zzc;
    private Object zzd;
    private Object zze;
    private int zzf;

    public zzdm(Object obj, Looper looper, Looper looper2, zzdo zzdoVar, zzdl zzdlVar) {
        this.zza = zzdoVar.zzd(looper, null);
        this.zzb = zzdoVar.zzd(looper2, null);
        this.zzd = obj;
        this.zze = obj;
        this.zzc = zzdlVar;
    }

    private final void zzh(Runnable runnable) {
        zzdz zzdzVar = this.zzb;
        if (zzdzVar.zza().getThread().isAlive()) {
            zzdzVar.zzm(runnable);
        }
    }

    private final void zzi(Object obj) {
        Object obj2 = this.zzd;
        this.zzd = obj;
        if (obj2.equals(obj)) {
            return;
        }
        this.zzc.zza(obj2, obj);
    }

    public final Object zza() {
        zzdz zzdzVar = this.zzb;
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == zzdzVar.zza()) {
            return this.zzd;
        }
        zzgtj.zzi(looperMyLooper == this.zza.zza());
        return this.zze;
    }

    public final void zzb(zzgta zzgtaVar, final zzgta zzgtaVar2) {
        zzgtj.zzi(Looper.myLooper() == this.zzb.zza());
        this.zzf++;
        zzd(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdk
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zze(zzgtaVar2);
            }
        });
        zzi(zzgtaVar.apply(this.zzd));
    }

    public final void zzc(final Object obj) {
        this.zze = obj;
        zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdi
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzf(obj);
            }
        });
    }

    public final void zzd(Runnable runnable) {
        zzdz zzdzVar = this.zza;
        if (zzdzVar.zza().getThread().isAlive()) {
            zzdzVar.zzm(runnable);
        }
    }

    public final /* synthetic */ void zze(zzgta zzgtaVar) {
        final Object objApply = zzgtaVar.apply(this.zze);
        this.zze = objApply;
        zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdj
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzg(objApply);
            }
        });
    }

    public final /* synthetic */ void zzf(Object obj) {
        if (this.zzf == 0) {
            zzi(obj);
        }
    }

    public final /* synthetic */ void zzg(Object obj) {
        int i = this.zzf - 1;
        this.zzf = i;
        if (i == 0) {
            zzi(obj);
        }
    }
}
