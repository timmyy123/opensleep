package com.android.billingclient.api;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzat implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ PurchasesResponseListener zzb;
    final /* synthetic */ BillingClientImpl zzc;

    public zzat(BillingClientImpl billingClientImpl, String str, PurchasesResponseListener purchasesResponseListener) {
        this.zza = str;
        this.zzb = purchasesResponseListener;
        this.zzc = billingClientImpl;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        zzcv zzcvVarZzaR = this.zzc.zzaR(this.zza, 9);
        List listZzb = zzcvVarZzaR.zzb();
        PurchasesResponseListener purchasesResponseListener = this.zzb;
        if (listZzb != null) {
            purchasesResponseListener.onQueryPurchasesResponse(zzcvVarZzaR.zza(), zzcvVarZzaR.zzb());
            return null;
        }
        purchasesResponseListener.onQueryPurchasesResponse(zzcvVarZzaR.zza(), com.google.android.gms.internal.play_billing.zzco.zzl());
        return null;
    }
}
