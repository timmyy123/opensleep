package com.facebook.appevents.iap;

import com.facebook.appevents.iap.InAppPurchaseUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&R\u0012\u0010\u0002\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", "", "billingClient", "getBillingClient", "()Ljava/lang/Object;", "queryPurchaseHistory", "", "productType", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;", "completionHandler", "Ljava/lang/Runnable;", InAppPurchaseConstants.METHOD_QUERY_PURCHASES, "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface InAppPurchaseBillingClientWrapper {
    Object getBillingClient();

    void queryPurchaseHistory(InAppPurchaseUtils.IAPProductType productType, Runnable completionHandler);

    void queryPurchases(InAppPurchaseUtils.IAPProductType productType, Runnable completionHandler);
}
