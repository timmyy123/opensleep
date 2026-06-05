package com.urbandroid.sleep.trial;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/trial/PurchaseResult;", "", "Lcom/android/billingclient/api/BillingResult;", "billingResult", "Lcom/android/billingclient/api/Purchase;", "purchase", "<init>", "(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/Purchase;)V", "component1", "()Lcom/android/billingclient/api/BillingResult;", "component2", "()Lcom/android/billingclient/api/Purchase;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/android/billingclient/api/BillingResult;", "getBillingResult", "Lcom/android/billingclient/api/Purchase;", "getPurchase", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PurchaseResult {
    private final BillingResult billingResult;
    private final Purchase purchase;

    public PurchaseResult(BillingResult billingResult, Purchase purchase) {
        billingResult.getClass();
        this.billingResult = billingResult;
        this.purchase = purchase;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BillingResult getBillingResult() {
        return this.billingResult;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Purchase getPurchase() {
        return this.purchase;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurchaseResult)) {
            return false;
        }
        PurchaseResult purchaseResult = (PurchaseResult) other;
        return Intrinsics.areEqual(this.billingResult, purchaseResult.billingResult) && Intrinsics.areEqual(this.purchase, purchaseResult.purchase);
    }

    public int hashCode() {
        int iHashCode = this.billingResult.hashCode() * 31;
        Purchase purchase = this.purchase;
        return iHashCode + (purchase == null ? 0 : purchase.hashCode());
    }

    public String toString() {
        return "PurchaseResult(billingResult=" + this.billingResult + ", purchase=" + this.purchase + ")";
    }

    public /* synthetic */ PurchaseResult(BillingResult billingResult, Purchase purchase, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(billingResult, (i & 2) != 0 ? null : purchase);
    }
}
