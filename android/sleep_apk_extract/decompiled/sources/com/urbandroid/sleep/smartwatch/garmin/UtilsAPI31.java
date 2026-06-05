package com.urbandroid.sleep.smartwatch.garmin;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UtilsAPI31 {
    public static void startForegroundService(Context context, Intent intent) {
        try {
            Logger.logSevere("Garmin: Starting service");
            ContextCompat.startForegroundService(context, intent);
        } catch (ForegroundServiceStartNotAllowedException e) {
            Logger.logSevere("Garmin: Starting service failed ", e);
            Utils.showUnrestrictedBatteryNeededNotificationIfNeeded(context);
        }
    }
}
