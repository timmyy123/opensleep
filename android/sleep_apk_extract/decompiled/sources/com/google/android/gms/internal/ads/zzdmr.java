package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdmr implements zzimu {
    private final zzdmd zza;
    private final zzind zzb;

    private zzdmr(zzdmd zzdmdVar, zzind zzindVar) {
        this.zza = zzdmdVar;
        this.zzb = zzindVar;
    }

    public static zzdmr zza(zzdmd zzdmdVar, zzind zzindVar) {
        return new zzdmr(zzdmdVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZze = this.zza.zze((zzdbk) this.zzb.zzb());
        zzinc.zzb(setZze);
        return setZze;
    }
}
