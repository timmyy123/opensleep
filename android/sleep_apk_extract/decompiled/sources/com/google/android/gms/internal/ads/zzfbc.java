package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfbc implements zzimu {
    private final zzind zza;

    private zzfbc(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzfbc zza(zzind zzindVar) {
        return new zzfbc(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfba(((zzdce) this.zza).zza());
    }
}
