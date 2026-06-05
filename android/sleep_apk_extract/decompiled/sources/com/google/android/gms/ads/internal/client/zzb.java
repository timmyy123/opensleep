package com.google.android.gms.ads.internal.client;

/* JADX INFO: loaded from: classes3.dex */
public final class zzb extends zzbd {
    private final zza zza;

    public zzb(zza zzaVar) {
        this.zza = zzaVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbe
    public final void zzb() {
        this.zza.onAdClicked();
    }
}
