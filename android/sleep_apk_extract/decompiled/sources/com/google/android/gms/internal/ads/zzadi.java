package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadi {
    private final Context zza;
    private final zzadu zzb;
    private zzbs zzc;
    private boolean zzd;
    private boolean zzf;
    private long zzg = 15000;
    private final zzadv zzh = new zzadv(1.0f);
    private zzdo zze = zzdo.zza;

    public zzadi(Context context, zzadu zzaduVar) {
        this.zza = context.getApplicationContext();
        this.zzb = zzaduVar;
    }

    public final zzadi zza(boolean z) {
        this.zzd = true;
        return this;
    }

    public final zzadi zzb(zzdo zzdoVar) {
        this.zze = zzdoVar;
        return this;
    }

    public final zzadi zzc(long j) {
        this.zzg = j;
        return this;
    }

    public final zzadq zzd() {
        zzgtj.zzi(!this.zzf);
        if (this.zzc == null) {
            this.zzc = new zzado(false);
        }
        zzadq zzadqVar = new zzadq(this, null);
        this.zzf = true;
        return zzadqVar;
    }

    public final /* synthetic */ Context zze() {
        return this.zza;
    }

    public final /* synthetic */ zzadu zzf() {
        return this.zzb;
    }

    public final /* synthetic */ zzbs zzg() {
        return this.zzc;
    }

    public final /* synthetic */ boolean zzh() {
        return this.zzd;
    }

    public final /* synthetic */ zzdo zzi() {
        return this.zze;
    }

    public final /* synthetic */ long zzj() {
        return this.zzg;
    }

    public final /* synthetic */ zzadv zzk() {
        return this.zzh;
    }
}
