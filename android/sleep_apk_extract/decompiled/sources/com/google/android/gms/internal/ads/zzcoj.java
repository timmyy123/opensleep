package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcoj implements zzimu {
    private final zzcnl zza;

    private zzcoj(zzcnl zzcnlVar) {
        this.zza = zzcnlVar;
    }

    public static zzcoj zza(zzcnl zzcnlVar) {
        return new zzcoj(zzcnlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return Long.valueOf(this.zza.zzi());
    }
}
