package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdhs implements zzimu {
    private final zzind zza;

    private zzdhs(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdhs zza(zzind zzindVar) {
        return new zzdhs(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdhr(((zzing) this.zza).zzb());
    }
}
