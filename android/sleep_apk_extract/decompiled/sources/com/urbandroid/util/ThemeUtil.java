package com.urbandroid.util;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ThemeUtil {
    private static int getModeForSetting(int i) {
        if (i == 4) {
            return -1;
        }
        if (i == 1) {
            return 2;
        }
        return i == 2 ? 1 : 0;
    }

    private static int getNightMode(Context context, int i) {
        int modeForSetting = getModeForSetting(i);
        if (modeForSetting == 0 && isBrokenNightMode(context)) {
            return getModeForSetting(new Settings(context).getBedtimeSunsetTheme());
        }
        zza$$ExternalSyntheticOutline0.m(modeForSetting, "Theme: mode ");
        return modeForSetting;
    }

    public static int getSetNightMode(Context context) {
        return getNightMode(context, new Settings(context).getTheme());
    }

    public static boolean isBrokenNightMode(Context context) {
        return false;
    }

    public static void setTheme(Context context, int i) {
        Log.i("SleepAsAndroid", "SleepApplication Setting theme " + i);
        Settings settings = new Settings(context);
        Logger.logInfo("Theme: setTheme(" + i + ")");
        if (!settings.isThemeValueSet()) {
            try {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 30) {
                    i = -1;
                } else if (i2 >= 27) {
                    Logger.logInfo("Theme DARK, not set in settings");
                    int i3 = Settings.Secure.getInt(context.getContentResolver(), "ui_night_mode", 0);
                    Logger.logInfo("Theme DARK System wide " + i3);
                    if (i3 == 2) {
                        Logger.logInfo("Theme DARK System wide forcing night");
                        i = 2;
                    }
                }
            } catch (Exception unused) {
            }
        }
        settings.setThemeLastSet(i);
        AppCompatDelegate.setDefaultNightMode(i);
    }

    public static void setThemeFromSetting(Context context, int i) {
        setTheme(context, getModeForSetting(i));
    }

    public static void setTheme(Context context) {
        setTheme(context, getSetNightMode(context));
    }
}
