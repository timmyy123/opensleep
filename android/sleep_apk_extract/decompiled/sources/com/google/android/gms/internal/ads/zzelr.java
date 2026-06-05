package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzelr implements zzimu {
    private final zzind zza;

    private zzelr(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzelr zzc(zzind zzindVar) {
        return new zzelr(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzelq zzb() {
        return new zzelq(((zzcns) this.zza).zza());
    }
}
