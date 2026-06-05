package com.facebook.appevents.iap;

import android.content.Context;
import com.facebook.appevents.iap.InAppPurchaseUtils;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class InAppPurchaseAutoLogger$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ InAppPurchaseUtils.BillingClientVersion f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ InAppPurchaseAutoLogger$$ExternalSyntheticLambda0(InAppPurchaseUtils.BillingClientVersion billingClientVersion, Context context, int i) {
        this.$r8$classId = i;
        this.f$0 = billingClientVersion;
        this.f$1 = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                InAppPurchaseAutoLogger.startIapLogging$lambda$1$lambda$0(this.f$0, this.f$1);
                break;
            default:
                InAppPurchaseAutoLogger.startIapLogging$lambda$2(this.f$0, this.f$1);
                break;
        }
    }
}
