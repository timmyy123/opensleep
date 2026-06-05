package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdqa implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdqa(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdqa zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdqa(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdpx(((zzcyk) this.zza).zza(), ((zzdor) this.zzb).zza());
    }
}
