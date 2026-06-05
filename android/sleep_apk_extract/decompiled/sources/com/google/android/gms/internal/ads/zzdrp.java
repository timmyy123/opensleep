package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdrp implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdrp(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdrp zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdrp(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdro((zzdwi) this.zza.zzb(), ((zzdou) this.zzb).zza());
    }
}
