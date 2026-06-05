package com.urbandroid.util;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ForceLocale {
    public static void force(Context context) {
        StringBuilder sb = new StringBuilder("LOCALE default ");
        sb.append(Locale.getDefault());
        sb.append(" ");
        Locale.Category category = Locale.Category.DISPLAY;
        sb.append(Locale.getDefault(category));
        sb.append(" ");
        sb.append(Locale.getDefault(Locale.Category.FORMAT));
        Logger.logInfo(sb.toString());
        if (Build.VERSION.SDK_INT < 33) {
            if (SharedApplicationContext.getSettings().isForceEnglish()) {
                force(context, new Locale.Builder().setLocale(Locale.getDefault()).setLanguage(Locale.ENGLISH.getLanguage()).build());
                return;
            }
            Logger.logInfo("LOCALE force default " + Locale.getDefault() + " " + Locale.getDefault(category));
            force(context, Locale.getDefault(category));
        }
    }

    private static void force(Context context, Locale locale) {
        Logger.logInfo("LOCALE " + locale + " default " + Locale.getDefault() + " " + Locale.getDefault(Locale.Category.DISPLAY) + " " + Locale.getDefault(Locale.Category.FORMAT));
        if (Build.VERSION.SDK_INT < 33) {
            if (locale == null) {
                Logger.logInfo("LOCALE null");
                return;
            }
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration == null || locale.equals(configuration.locale)) {
                return;
            }
            Logger.logDebug("LOCALE force " + locale);
            Locale.setDefault(locale);
            configuration.setLayoutDirection(locale);
            configuration.locale = locale;
            context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        }
    }
}
