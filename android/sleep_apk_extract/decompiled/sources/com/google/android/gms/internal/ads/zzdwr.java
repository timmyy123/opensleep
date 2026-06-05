package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdwr implements zzimu {
    private final zzind zza;

    private zzdwr(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdwr zzc(zzind zzindVar) {
        return new zzdwr(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdwq zzb() {
        return new zzdwq((zzcku) this.zza.zzb());
    }
}
