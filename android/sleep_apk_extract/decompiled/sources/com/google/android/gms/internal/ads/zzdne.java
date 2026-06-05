package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdne implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdne(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdne zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdne(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdnd((zzdfc) this.zza.zzb(), (zzdkk) this.zzb.zzb());
    }
}
