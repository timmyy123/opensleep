package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzdsk implements zzhbt {
    final /* synthetic */ zzdyu zza;
    final /* synthetic */ zzdsn zzb;

    public zzdsk(zzdsn zzdsnVar, zzdyu zzdyuVar) {
        this.zza = zzdyuVar;
        Objects.requireNonNull(zzdsnVar);
        this.zzb = zzdsnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        this.zzb.zzd().zzf(this.zza.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
    }
}
