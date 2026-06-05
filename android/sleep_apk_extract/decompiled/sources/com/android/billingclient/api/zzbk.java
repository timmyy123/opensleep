package com.android.billingclient.api;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzbk {
    private final List zza;
    private final BillingResult zzb;

    public zzbk(BillingResult billingResult, List list) {
        this.zza = list;
        this.zzb = billingResult;
    }

    public final BillingResult zza() {
        return this.zzb;
    }

    public final List zzb() {
        return this.zza;
    }
}
