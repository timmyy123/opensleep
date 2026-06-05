package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzelt implements zzels {
    public final zzels zza;
    private final zzgta zzb;

    public zzelt(zzels zzelsVar, zzgta zzgtaVar) {
        this.zza = zzelsVar;
        this.zzb = zzgtaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final boolean zza(zzfkq zzfkqVar, zzfkf zzfkfVar) {
        return this.zza.zza(zzfkqVar, zzfkfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final ListenableFuture zzb(zzfkq zzfkqVar, zzfkf zzfkfVar) {
        return zzhbw.zzk(this.zza.zzb(zzfkqVar, zzfkfVar), this.zzb, zzcfr.zza);
    }
}
