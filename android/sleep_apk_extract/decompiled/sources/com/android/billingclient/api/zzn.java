package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
final class zzn {
    private final Context zza;
    private final PurchasesUpdatedListener zzb;
    private final zzch zze;
    private final zzm zzf = new zzm(this, true);
    private final zzm zzg = new zzm(this, false);
    private boolean zzh;

    public zzn(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzco zzcoVar, zzb zzbVar, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar) {
        this.zza = context;
        this.zzb = purchasesUpdatedListener;
        this.zze = zzchVar;
    }

    public static /* bridge */ /* synthetic */ zzb zza(zzn zznVar) {
        zznVar.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ UserChoiceBillingListener zze(zzn zznVar) {
        zznVar.getClass();
        return null;
    }

    public final PurchasesUpdatedListener zzd() {
        return this.zzb;
    }

    public final void zzf() {
        this.zzf.zzc(this.zza);
        this.zzg.zzc(this.zza);
    }

    public final void zzg(boolean z) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.zzh = z;
        this.zzg.zza(this.zza, intentFilter2);
        boolean z2 = this.zzh;
        zzm zzmVar = this.zzf;
        if (z2) {
            zzmVar.zzb(this.zza, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST");
        } else {
            zzmVar.zza(this.zza, intentFilter);
        }
    }
}
