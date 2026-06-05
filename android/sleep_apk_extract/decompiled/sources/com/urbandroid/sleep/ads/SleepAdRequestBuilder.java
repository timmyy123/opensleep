package com.urbandroid.sleep.ads;

import android.content.Context;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SleepAdRequestBuilder {
    public static AdRequest build(Context context) {
        Settings settings = new Settings(context);
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.addKeyword("Dream");
        builder.addKeyword("Bed");
        builder.addKeyword("Alarm");
        builder.addKeyword("Smart");
        builder.addKeyword("Geek");
        builder.addKeyword("Sleep");
        builder.addKeyword("Health");
        builder.addKeyword("Medicine");
        builder.addKeyword("Snoring");
        builder.addKeyword("Quantified self");
        builder.addKeyword("Fitness");
        builder.addKeyword("Wellness");
        if (settings.isOptOutAds() || (!settings.isUserAdsAgreed() && settings.isEuCountry())) {
            Bundle bundle = new Bundle();
            bundle.putString("npa", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        }
        return builder.build();
    }
}
