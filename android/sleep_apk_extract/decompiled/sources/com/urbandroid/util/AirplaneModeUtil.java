package com.urbandroid.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.wifi.WifiEnabler;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AirplaneModeUtil {
    public static void disableAirplaneMode(Context context) {
        Settings settings = new Settings(context);
        if (!Environment.isNewJellyBeanOrGreater() || TrialFilter.getInstance().tryAirplaneRootHack()) {
            settings.setAirplaneMode(false);
        } else {
            openAirplaneSettings(context);
        }
    }

    public static void enableAirplaneMode(Context context, boolean z) {
        Logger.logInfo("Wifi: enable airplane mode");
        Settings settings = new Settings(context);
        if (!Environment.isNewJellyBeanOrGreater() || TrialFilter.getInstance().tryAirplaneRootHack()) {
            if (settings.setAirplaneMode(true)) {
                settings.setAirplaneChanged(true);
            }
        } else {
            if (z) {
                openAirplaneSettings(context);
            }
            try {
                settings.setAirplaneChanged(WifiEnabler.getInstance().setWifi(context, false));
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
    }

    public static void openAirplaneSettings(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.AIRPLANE_MODE_SETTINGS");
            intent.addFlags(335544320);
            context.startActivity(intent);
        } catch (Exception e) {
            Logger.logInfo("No activity to handle airplane mode", e);
            try {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.WIRELESS_SETTINGS");
                intent2.addFlags(335544320);
                context.startActivity(intent2);
            } catch (Exception e2) {
                if (context instanceof Activity) {
                    Toast.makeText(context, R.string.no_airplane_activity, 1).show();
                }
                Logger.logInfo("No activity to handle wireless mode", e2);
            }
        }
    }

    public static boolean revertAirplaneMode(Context context) {
        Settings settings = new Settings(context);
        try {
            if (settings.isAirplaneChanged()) {
                return (!Environment.isNewJellyBeanOrGreater() || TrialFilter.getInstance().tryAirplaneRootHack()) ? settings.setAirplaneMode(false) : WifiEnabler.getInstance().setWifi(context, true);
            }
            return false;
        } finally {
            settings.setAirplaneChanged(false);
        }
    }
}
