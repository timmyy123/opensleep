package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdos implements zzimu {
    private final zzind zza;

    private zzdos(zzdop zzdopVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdos zzc(zzdop zzdopVar, zzind zzindVar) {
        return new zzdos(zzdopVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdpy zzb() {
        zzdpx zzdpxVar = (zzdpx) this.zza.zzb();
        zzinc.zzb(zzdpxVar);
        return zzdpxVar;
    }
}
