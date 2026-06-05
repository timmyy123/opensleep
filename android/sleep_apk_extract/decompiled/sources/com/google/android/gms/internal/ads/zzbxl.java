package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbxl implements MediationAdLoadCallback {
    final /* synthetic */ zzbwm zza;
    final /* synthetic */ zzbvi zzb;
    final /* synthetic */ zzbxo zzc;

    public zzbxl(zzbxo zzbxoVar, zzbwm zzbwmVar, zzbvi zzbviVar) {
        this.zza = zzbwmVar;
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
