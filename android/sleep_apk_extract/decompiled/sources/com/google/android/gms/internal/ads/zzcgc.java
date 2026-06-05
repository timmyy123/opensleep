package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcgc implements zzhbt {
    final /* synthetic */ zzcga zza;
    final /* synthetic */ zzcfy zzb;

    public zzcgc(zzcgd zzcgdVar, zzcga zzcgaVar, zzcfy zzcfyVar) {
        this.zza = zzcgaVar;
        this.zzb = zzcfyVar;
        Objects.requireNonNull(zzcgdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        this.zza.zza(obj);
    }
}
