package com.urbandroid.sleep.ads;

import android.content.Context;
import android.provider.Settings;
import com.facebook.internal.ServerProtocol;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.privacy.Consent;
import com.urbandroid.sleep.TrialFilter;

/* JADX INFO: loaded from: classes4.dex */
public interface IAdsController {
    static boolean isEligibleForAds(Context context) {
        boolean z = TrialFilter.getInstance().isShowAds() && TrialFilter.getInstance().isTimeToShowAds() && (TrialFilter.getInstance().isTrialExpired() || TrialFilter.getInstance().getVersion() == TrialFilter.Version.FULLAD);
        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(Settings.System.getString(context.getContentResolver(), "firebase.test.lab"))) {
            Logger.logDebug("ADS ADMOB: test lab ");
            return false;
        }
        boolean zCanServeAds = Consent.INSTANCE.canServeAds(context);
        Logger.logDebug("ADS ADMOB: Eligible for ads " + z + " canServeAds " + zCanServeAds);
        return z && zCanServeAds;
    }

    void destroy();

    void hide();

    void load(String str, String str2);

    void pause();

    void resume();
}
