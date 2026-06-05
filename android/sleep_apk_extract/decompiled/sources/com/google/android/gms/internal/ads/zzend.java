package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzend implements zzdno {
    final /* synthetic */ zzcfw zza;
    final /* synthetic */ zzfkf zzb;
    final /* synthetic */ zzenf zzc;

    public zzend(zzenf zzenfVar, zzcfw zzcfwVar, zzfkf zzfkfVar) {
        this.zza = zzcfwVar;
        this.zzb = zzfkfVar;
        Objects.requireNonNull(zzenfVar);
        this.zzc = zzenfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final void zza(boolean z, Context context, zzdde zzddeVar) {
        try {
            com.google.android.gms.ads.internal.zzt.zzb();
            com.google.android.gms.ads.internal.overlay.zzn.zza(context, (AdOverlayInfoParcel) this.zza.get(), true, this.zzc.zzd());
        } catch (Exception unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final zzfkf zzb() {
        return this.zzb;
    }
}
