package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdry implements zzimu {
    private final zzind zza;

    private zzdry(zzdrx zzdrxVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdry zza(zzdrx zzdrxVar, zzind zzindVar) {
        return new zzdry(zzdrxVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdrv zzdrvVar = (zzdrv) this.zza.zzb();
        zzinc.zzb(zzdrvVar);
        return zzdrvVar;
    }
}
