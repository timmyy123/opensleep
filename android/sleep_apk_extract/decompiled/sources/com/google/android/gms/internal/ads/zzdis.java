package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdis implements zzimu {
    private final zzdir zza;
    private final zzind zzb;

    private zzdis(zzdir zzdirVar, zzind zzindVar) {
        this.zza = zzdirVar;
        this.zzb = zzindVar;
    }

    public static zzdis zza(zzdir zzdirVar, zzind zzindVar) {
        return new zzdis(zzdirVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdct zzdctVarZzp = this.zza.zzp(((zzing) this.zzb).zzb());
        zzinc.zzb(zzdctVarZzp);
        return zzdctVarZzp;
    }
}
