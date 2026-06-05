package com.urbandroid.sleep.trial;

import com.android.billingclient.api.BillingResult;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/trial/ConsumeResult;", "", "Lcom/android/billingclient/api/BillingResult;", "billingResult", "", "outToken", "<init>", "(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/android/billingclient/api/BillingResult;", "getBillingResult", "()Lcom/android/billingclient/api/BillingResult;", "Ljava/lang/String;", "getOutToken", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ConsumeResult {
    private final BillingResult billingResult;
    private final String outToken;

    public ConsumeResult(BillingResult billingResult, String str) {
        billingResult.getClass();
        str.getClass();
        this.billingResult = billingResult;
        this.outToken = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsumeResult)) {
            return false;
        }
        ConsumeResult consumeResult = (ConsumeResult) other;
        return Intrinsics.areEqual(this.billingResult, consumeResult.billingResult) && Intrinsics.areEqual(this.outToken, consumeResult.outToken);
    }

    public final BillingResult getBillingResult() {
        return this.billingResult;
    }

    public int hashCode() {
        return this.outToken.hashCode() + (this.billingResult.hashCode() * 31);
    }

    public String toString() {
        return "ConsumeResult(billingResult=" + this.billingResult + ", outToken=" + this.outToken + ")";
    }
}
