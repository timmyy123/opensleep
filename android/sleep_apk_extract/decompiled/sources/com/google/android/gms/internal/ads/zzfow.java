package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzfow implements zzhbt {
    final /* synthetic */ zzfor zza;
    final /* synthetic */ zzfpb zzb;

    public zzfow(zzfpb zzfpbVar, zzfor zzforVar) {
        this.zza = zzforVar;
        Objects.requireNonNull(zzfpbVar);
        this.zzb = zzfpbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        this.zzb.zza.zzg().zzc(this.zza, th);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        this.zzb.zza.zzg().zzd(this.zza);
    }
}
