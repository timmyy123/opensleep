package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbtm implements zzcga {
    final /* synthetic */ zzbto zza;

    public zzbtm(zzbto zzbtoVar) {
        Objects.requireNonNull(zzbtoVar);
        this.zza = zzbtoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcga
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("Releasing engine reference.");
        this.zza.zzb().zzb();
    }
}
