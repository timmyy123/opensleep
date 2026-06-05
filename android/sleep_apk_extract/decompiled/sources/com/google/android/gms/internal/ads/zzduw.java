package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzduw implements zzbpq {
    final /* synthetic */ zzdux zza;
    private final WeakReference zzb;
    private final String zzc;
    private final zzbpq zzd;

    public /* synthetic */ zzduw(zzdux zzduxVar, WeakReference weakReference, String str, zzbpq zzbpqVar, byte[] bArr) {
        Objects.requireNonNull(zzduxVar);
        this.zza = zzduxVar;
        this.zzb = weakReference;
        this.zzc = str;
        this.zzd = zzbpqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        Object obj2 = this.zzb.get();
        if (obj2 == null) {
            this.zza.zze(this.zzc, this);
        } else {
            this.zzd.zza(obj2, map);
        }
    }
}
