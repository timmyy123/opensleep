package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzddf implements zzimu {
    private final zzind zza;

    private zzddf(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzddf zzc(zzind zzindVar) {
        return new zzddf(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdda zzb() {
        return new zzdda(((zzing) this.zza).zzb());
    }
}
