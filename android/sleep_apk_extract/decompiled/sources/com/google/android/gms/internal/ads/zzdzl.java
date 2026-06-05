package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdzl {
    private final zzdzq zza;
    private final Executor zzb;
    private final Map zzc;

    public zzdzl(zzdzq zzdzqVar, Executor executor) {
        this.zza = zzdzqVar;
        this.zzc = zzdzqVar.zza();
        this.zzb = executor;
    }

    public final zzdzk zza() {
        zzdzk zzdzkVar = new zzdzk(this);
        zzdzkVar.zzj();
        return zzdzkVar;
    }

    public final void zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznc)).booleanValue()) {
            zzdzk zzdzkVarZza = zza();
            zzdzkVarZza.zzc("action", "pecr");
            zzdzkVarZza.zzd();
        }
    }

    public final /* synthetic */ zzdzq zzc() {
        return this.zza;
    }

    public final /* synthetic */ Executor zzd() {
        return this.zzb;
    }

    public final /* synthetic */ Map zze() {
        return this.zzc;
    }
}
