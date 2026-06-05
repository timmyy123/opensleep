package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdua implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdua(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdua zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdua(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdtz((zzdpo) this.zza.zzb(), ((zzdql) this.zzb).zza());
    }
}
