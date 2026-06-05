package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdko implements zzimu {
    private final zzind zza;

    private zzdko(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdko zza(zzind zzindVar) {
        return new zzdko(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkn(((zzing) this.zza).zzb());
    }
}
