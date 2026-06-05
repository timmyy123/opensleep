package com.urbandroid.sleep.smartwatch.garmin;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartwatch.Wearable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Utils {
    public static void dumpIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Logger.logDebug("---- Dumping Intent start");
            for (String str : extras.keySet()) {
                StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("[", str, "=");
                sbM5m.append(extras.get(str));
                sbM5m.append("]");
                Logger.logDebug(sbM5m.toString());
            }
            Logger.logDebug("---- Dumping Intent end");
        }
    }

    public static Long getLongOrIntExtraAsLong(Intent intent, String str, Long l) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey(str) && (obj = extras.get(str)) != null) {
            if (obj instanceof Integer) {
                return Long.valueOf(((Integer) obj).longValue());
            }
            if (obj instanceof Long) {
                return (Long) obj;
            }
        }
        return l;
    }

    public static boolean isUnrestrictedBatteryNotificationNeeded(Context context) {
        PowerManager powerManager;
        int i = Build.VERSION.SDK_INT;
        return i >= 31 && i < 34 && ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled() && (powerManager = (PowerManager) context.getSystemService("power")) != null && !powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
    }

    public static void showUnrestrictedBatteryNeededNotificationIfNeeded(Context context) {
        if (isUnrestrictedBatteryNotificationNeeded(context)) {
            Notifications.showUnrestrictedBatteryNeededNotification(context);
        }
    }

    public static void startForegroundService(Context context, Intent intent) {
        if (new Settings(context).isWearableSelected(Wearable.ADDON_URBANDROID_GARMIN)) {
            Logger.logDebug("Utils.startForegroundService");
            if (Build.VERSION.SDK_INT >= 31) {
                UtilsAPI31.startForegroundService(context, intent);
            } else {
                Logger.logDebug("Utils.startForegroundService alert");
                ContextCompat.startForegroundService(context, intent);
            }
        }
    }

    public static float[] stringArrayToFloatArray(String[] strArr) {
        float[] fArr = new float[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            try {
                fArr[i] = Float.parseFloat(strArr[i]);
            } catch (NumberFormatException unused) {
                fArr[i] = 0.0f;
            }
        }
        return fArr;
    }
}
