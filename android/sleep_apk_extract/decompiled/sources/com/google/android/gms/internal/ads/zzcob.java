package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcob implements zzimu {
    private final zzind zza;

    private zzcob(zzcnl zzcnlVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcob zza(zzcnl zzcnlVar, zzind zzindVar) {
        return new zzcob(zzcnlVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzenx((zzdxc) this.zza.zzb());
    }
}
