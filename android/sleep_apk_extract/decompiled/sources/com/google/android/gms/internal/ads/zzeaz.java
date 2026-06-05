package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeaz implements zzimu {
    private final zzind zza;

    private zzeaz(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzeaz zzc(zzind zzindVar) {
        return new zzeaz(zzindVar);
    }

    public static zzeay zzd(zzbqq zzbqqVar) {
        return new zzeay(zzbqqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeay zzb() {
        return new zzeay((zzbqq) this.zza.zzb());
    }
}
