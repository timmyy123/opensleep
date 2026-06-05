package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeiw implements zzimu {
    private final zzind zza;

    private zzeiw(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzeiw zzc(zzind zzindVar) {
        return new zzeiw(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeiv zzb() {
        return new zzeiv(((zzcns) this.zza).zza());
    }
}
