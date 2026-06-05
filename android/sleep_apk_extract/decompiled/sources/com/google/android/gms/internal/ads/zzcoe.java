package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcoe implements zzimu {
    private final zzind zza;

    private zzcoe(zzcnl zzcnlVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcoe zzc(zzcnl zzcnlVar, zzind zzindVar) {
        return new zzcoe(zzcnlVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcrq zzb() {
        zzcnj zzcnjVar = (zzcnj) this.zza.zzb();
        zzinc.zzb(zzcnjVar);
        return zzcnjVar;
    }
}
