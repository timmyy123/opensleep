package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzddz implements zzimu {
    private final zzind zza;

    private zzddz(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzddz zza(zzind zzindVar) {
        return new zzddz(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzddy(((zzing) this.zza).zzb());
    }
}
