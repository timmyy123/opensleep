package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcyp implements zzimu {
    private final zzind zza;

    private zzcyp(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcyp zza(zzind zzindVar) {
        return new zzcyp(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcyo((zzddy) this.zza.zzb());
    }
}
