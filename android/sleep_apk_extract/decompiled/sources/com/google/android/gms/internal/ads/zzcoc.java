package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcoc implements zzimu {
    private final zzind zza;

    private zzcoc(zzcnl zzcnlVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcoc zza(zzcnl zzcnlVar, zzind zzindVar) {
        return new zzcoc(zzcnlVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzepx((zzdxc) this.zza.zzb());
    }
}
