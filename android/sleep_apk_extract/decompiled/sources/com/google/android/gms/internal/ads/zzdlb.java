package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdlb implements zzimu {
    private final zzind zza;

    private zzdlb(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdlb zza(zzind zzindVar) {
        return new zzdlb(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdla(((zzing) this.zza).zzb());
    }
}
