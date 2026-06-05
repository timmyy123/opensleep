package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzegj implements zzimu {
    private final zzind zza;

    private zzegj(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzegj zzc(zzind zzindVar) {
        return new zzegj(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzegi zzb() {
        return new zzegi(((zzcns) this.zza).zza());
    }
}
