package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzerq implements zzimu {
    private final zzind zza;

    private zzerq(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzerq zzc(zzind zzindVar) {
        return new zzerq(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzerp zzb() {
        return new zzerp((zzdng) this.zza.zzb());
    }
}
