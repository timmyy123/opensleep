package com.urbandroid.sleep.alarmclock;

import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.UnlockFlow;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class UnlockFlow$1$$ExternalSyntheticLambda0 implements OnPaidEventListener, ActivityResultCallback, AudienceNetworkAds.InitListener {
    @Override // androidx.view.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        CountriesActivity.onCreate$lambda$2((ActivityResult) obj);
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitListener
    public void onInitialized(AudienceNetworkAds.InitResult initResult) {
        Logger.logInfo("FAN: initialized");
    }

    @Override // com.google.android.gms.ads.OnPaidEventListener
    public void onPaidEvent(AdValue adValue) {
        UnlockFlow.AnonymousClass1.lambda$onAdLoaded$0(adValue);
    }
}
