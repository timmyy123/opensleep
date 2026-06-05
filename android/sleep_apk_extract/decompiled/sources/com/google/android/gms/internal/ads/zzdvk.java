package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdvk implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdvk(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdvk zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdvk(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdvj((zzddy) this.zza.zzb(), ((zzcyk) this.zzb).zza());
    }
}
