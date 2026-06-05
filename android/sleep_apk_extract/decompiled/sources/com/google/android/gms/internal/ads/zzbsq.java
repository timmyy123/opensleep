package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbsq implements zzbpq {
    final /* synthetic */ zzbsx zza;
    private final zzbpq zzb;

    public zzbsq(zzbsx zzbsxVar, zzbpq zzbpqVar) {
        Objects.requireNonNull(zzbsxVar);
        this.zza = zzbsxVar;
        this.zzb = zzbpqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        this.zzb.zza(this.zza, map);
    }

    public final /* synthetic */ zzbpq zzb() {
        return this.zzb;
    }
}
