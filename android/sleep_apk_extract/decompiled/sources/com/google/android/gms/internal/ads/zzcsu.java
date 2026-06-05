package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcsu implements zzimu {
    private final zzind zza;

    private zzcsu(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcsu zza(zzind zzindVar) {
        return new zzcsu(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcst(((zzcnm) this.zza).zzb());
    }
}
