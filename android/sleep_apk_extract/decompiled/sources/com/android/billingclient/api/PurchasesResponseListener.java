package com.android.billingclient.api;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface PurchasesResponseListener {
    void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list);
}
