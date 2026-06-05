package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdli implements zzimu {
    private final zzind zza;

    private zzdli(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdli zza(zzind zzindVar) {
        return new zzdli(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdlh(((zzing) this.zza).zzb());
    }
}
