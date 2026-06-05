package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbqa implements com.google.android.gms.ads.internal.overlay.zzaa {
    final /* synthetic */ zzbqd zza;

    public zzbqa(zzbqd zzbqdVar) {
        Objects.requireNonNull(zzbqdVar);
        this.zza = zzbqdVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzaa
    public final void zza(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzaa
    public final void zzb(int i) {
        this.zza.zzg(i);
    }
}
