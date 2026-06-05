package com.urbandroid.sleep.share.analytics;

import android.content.Context;
import android.os.Bundle;
import com.urbandroid.sleep.marketing.MonetizationSegmentation;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.share.analytics.FirebaseAnalyticsManager;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FirebaseAnalyticsManager$31$$ExternalSyntheticLambda0 implements MonetizationSegmentation.Callback {
    public final /* synthetic */ Settings f$0;
    public final /* synthetic */ Bundle f$1;
    public final /* synthetic */ Context f$2;

    public /* synthetic */ FirebaseAnalyticsManager$31$$ExternalSyntheticLambda0(Context context, Settings settings, Bundle bundle) {
        this.f$0 = settings;
        this.f$1 = bundle;
        this.f$2 = context;
    }

    public final void onResult(MonetizationSegmentation.Result result) {
        FirebaseAnalyticsManager.AnonymousClass31.lambda$doSend$0(this.f$0, this.f$1, this.f$2, result);
    }
}
