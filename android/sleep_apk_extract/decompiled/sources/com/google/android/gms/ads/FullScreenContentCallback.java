package com.google.android.gms.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FullScreenContentCallback {
    public void onAdClicked() {
    }

    public abstract void onAdDismissedFullScreenContent();

    public void onAdFailedToShowFullScreenContent(AdError adError) {
    }

    public void onAdImpression() {
    }

    public abstract void onAdShowedFullScreenContent();
}
