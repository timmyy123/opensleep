package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzczt implements com.google.android.gms.ads.internal.client.zza {
    private final zzczx zza;
    private final zzfky zzb;

    public zzczt(zzczx zzczxVar, zzfky zzfkyVar) {
        this.zza = zzczxVar;
        this.zzb = zzfkyVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zza.zza(this.zzb.zzg);
    }
}
