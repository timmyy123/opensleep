package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdpz implements zzimu {
    private final zzind zza;

    private zzdpz(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdpz zza(zzind zzindVar) {
        return new zzdpz(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdpy(((zzcyk) this.zza).zza());
    }
}
