package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcqu implements zzimu {
    private final zzind zza;

    private zzcqu(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcqu zzc(zzind zzindVar) {
        return new zzcqu(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcds zzb() {
        return zzcds.zza(((zzcns) this.zza).zza());
    }
}
