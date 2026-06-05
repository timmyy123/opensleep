package com.facebook.appevents.iap;

import com.facebook.appevents.iap.InAppPurchaseUtils;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class InAppPurchaseBillingClientWrapperV2V4$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ InAppPurchaseBillingClientWrapperV2V4 f$0;
    public final /* synthetic */ InAppPurchaseUtils.IAPProductType f$1;
    public final /* synthetic */ Runnable f$2;

    public /* synthetic */ InAppPurchaseBillingClientWrapperV2V4$$ExternalSyntheticLambda0(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V4, InAppPurchaseUtils.IAPProductType iAPProductType, Runnable runnable, int i) {
        this.$r8$classId = i;
        this.f$0 = inAppPurchaseBillingClientWrapperV2V4;
        this.f$1 = iAPProductType;
        this.f$2 = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Runnable runnable = this.f$2;
        InAppPurchaseUtils.IAPProductType iAPProductType = this.f$1;
        InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V4 = this.f$0;
        switch (i) {
            case 0:
                InAppPurchaseBillingClientWrapperV2V4.queryPurchaseHistory$lambda$2(inAppPurchaseBillingClientWrapperV2V4, iAPProductType, runnable);
                break;
            default:
                InAppPurchaseBillingClientWrapperV2V4.queryPurchases$lambda$0(inAppPurchaseBillingClientWrapperV2V4, iAPProductType, runnable);
                break;
        }
    }
}
