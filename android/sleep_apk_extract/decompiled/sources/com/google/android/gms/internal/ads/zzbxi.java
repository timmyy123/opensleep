package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbxi implements MediationAdLoadCallback {
    final /* synthetic */ zzbws zza;
    final /* synthetic */ zzbvi zzb;
    final /* synthetic */ zzbxo zzc;

    public zzbxi(zzbxo zzbxoVar, zzbws zzbwsVar, zzbvi zzbviVar) {
        this.zza = zzbwsVar;
        this.zzb = zzbviVar;
        Objects.requireNonNull(zzbxoVar);
        this.zzc = zzbxoVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            this.zza.zzg(adError.zza());
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
        }
    }
}
