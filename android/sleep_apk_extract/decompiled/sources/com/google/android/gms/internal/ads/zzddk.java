package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzddk implements zzimu {
    private final zzind zza;

    private zzddk(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzddk zza(zzind zzindVar) {
        return new zzddk(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzddj(((zzing) this.zza).zzb());
    }
}
