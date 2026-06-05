package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzczu implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzczu(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzczu zza(zzind zzindVar, zzind zzindVar2) {
        return new zzczu(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzczt((zzczx) this.zza.zzb(), ((zzdci) this.zzb).zza());
    }
}
