package com.android.billingclient.api;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzcv {
    private final List zza;
    private final BillingResult zzb;

    public zzcv(BillingResult billingResult, List list) {
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
