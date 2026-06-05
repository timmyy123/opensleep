package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface MediationInterstitialAdapter extends MediationAdapter {
    /* synthetic */ void onDestroy();

    /* synthetic */ void onPause();

    /* synthetic */ void onResume();

    void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2);

    void showInterstitial();
}
