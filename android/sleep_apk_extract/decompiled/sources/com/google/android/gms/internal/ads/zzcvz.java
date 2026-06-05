package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcvz implements zzimu {
    private final zzind zza;

    private zzcvz(zzcvs zzcvsVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcvz zza(zzcvs zzcvsVar, zzind zzindVar) {
        return new zzcvz(zzcvsVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq(((zzcwo) this.zza).zzb(), zzcfr.zza);
    }
}
