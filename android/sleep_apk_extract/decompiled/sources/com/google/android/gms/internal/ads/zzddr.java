package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzddr implements zzimu {
    private final zzind zza;

    private zzddr(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzddr zza(zzind zzindVar) {
        return new zzddr(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzddq(((zzing) this.zza).zzb());
    }
}
