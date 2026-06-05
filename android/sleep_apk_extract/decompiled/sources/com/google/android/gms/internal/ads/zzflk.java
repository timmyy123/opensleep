package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzflk implements zzhbt {
    final /* synthetic */ zzfll zza;
    final /* synthetic */ int zzb;

    public zzflk(zzfll zzfllVar, int i) {
        this.zzb = i;
        Objects.requireNonNull(zzfllVar);
        this.zza = zzfllVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "BufferingUrlPinger.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zza.zzc((String) obj, this.zzb, null);
    }
}
