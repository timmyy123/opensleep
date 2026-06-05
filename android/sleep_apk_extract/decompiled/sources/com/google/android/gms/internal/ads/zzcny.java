package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcny implements zzimu {
    private final zzind zza;

    private zzcny(zzcnl zzcnlVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcny zzc(zzcnl zzcnlVar, zzind zzindVar) {
        return new zzcny(zzcnlVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final String zzb() {
        return zzflu.zza(((zzcns) this.zza).zza()).zze();
    }
}
