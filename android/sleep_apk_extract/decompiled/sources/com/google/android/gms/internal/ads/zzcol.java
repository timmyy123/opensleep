package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcol implements zzimu {
    private final zzind zza;

    private zzcol(zzcnl zzcnlVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcol zzc(zzcnl zzcnlVar, zzind zzindVar) {
        return new zzcol(zzcnlVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcfi zzb() {
        return ((zzcfd) this.zza.zzb()).zzr();
    }
}
