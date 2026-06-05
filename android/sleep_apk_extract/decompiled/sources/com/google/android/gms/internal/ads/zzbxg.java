package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzbxg implements MediationAdLoadCallback {
    final /* synthetic */ zzbwp zza;
    final /* synthetic */ zzbvi zzb;

    public zzbxg(zzbxo zzbxoVar, zzbwp zzbwpVar, zzbvi zzbviVar) {
        this.zza = zzbwpVar;
        this.zzb = zzbviVar;
        Objects.requireNonNull(zzbxoVar);
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
