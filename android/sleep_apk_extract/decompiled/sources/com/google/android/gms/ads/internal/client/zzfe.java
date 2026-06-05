package com.google.android.gms.ads.internal.client;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzfe extends zzbm {
    final /* synthetic */ zzff zza;

    public /* synthetic */ zzfe(zzff zzffVar, byte[] bArr) {
        Objects.requireNonNull(zzffVar);
        this.zza = zzffVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zze(zzm zzmVar) {
        zzi(zzmVar, 1);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final String zzf() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final boolean zzg() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final String zzh() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzi(zzm zzmVar, int i) {
        com.google.android.gms.ads.internal.util.client.zzo.zzf("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzfd(this));
    }
}
