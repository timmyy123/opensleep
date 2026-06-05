package com.urbandroid.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.PowerManager;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PowerManagerCompat {
    public static boolean isIgnoringBatteryOptimizations(Context context) {
        if (!Environment.isMOrGreater()) {
            return true;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        try {
            Boolean bool = (Boolean) powerManager.getClass().getMethod("isIgnoringBatteryOptimizations", String.class).invoke(powerManager, context.getPackageName());
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        } catch (Exception e) {
            Logger.logSevere(e);
            return true;
        }
    }

    public static void requestIgnoreBatteryOptimizations(Activity activity) {
        if (Environment.isMOrGreater()) {
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + activity.getPackageName()));
            activity.startActivityForResult(intent, 312);
        }
    }
}
