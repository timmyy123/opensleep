package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcnm implements zzimu {
    private final zzind zza;

    private zzcnm(zzcnl zzcnlVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcnm zzc(zzcnl zzcnlVar, zzind zzindVar) {
        return new zzcnm(zzcnlVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final com.google.android.gms.ads.internal.util.zzg zzb() {
        return ((zzcfd) this.zza.zzb()).zzo();
    }
}
