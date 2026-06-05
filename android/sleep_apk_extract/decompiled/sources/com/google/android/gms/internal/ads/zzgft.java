package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzgft implements zzhbe {
    final /* synthetic */ zzgfy zza;

    public zzgft(zzgfy zzgfyVar) {
        Objects.requireNonNull(zzgfyVar);
        this.zza = zzgfyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) {
        zzgfr zzgfrVar = (zzgfr) obj;
        if (zzgfrVar != null) {
            return zzhbw.zza(zzgfrVar);
        }
        zzgfy zzgfyVar = this.zza;
        zzgfyVar.zza().zzb(51);
        return zzgfyVar.zzd(zzgfyVar.zze());
    }
}
