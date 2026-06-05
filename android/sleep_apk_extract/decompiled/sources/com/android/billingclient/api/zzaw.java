package com.android.billingclient.api;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzkg;

/* JADX INFO: loaded from: classes.dex */
final class zzaw extends ResultReceiver {
    final /* synthetic */ BillingClientImpl zzb;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
        builderNewBuilder.setResponseCode(i);
        if (i != 0) {
            if (bundle == null) {
                this.zzb.zzbc(null, zzcj.zzk, 73, null);
                return;
            } else {
                builderNewBuilder.setDebugMessage(zze.zzh(bundle, "BillingClient"));
                int i2 = bundle.getInt("INTERNAL_LOG_ERROR_REASON");
                this.zzb.zzaF(zzcg.zzc(i2 != 0 ? zzkg.zza(i2) : 23, 16, builderNewBuilder.build(), bundle.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS")));
            }
        }
        builderNewBuilder.build();
        throw null;
    }
}
