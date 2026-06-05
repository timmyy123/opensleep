package com.urbandroid.sleep.smartwatch;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.SleepTest;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractStartSmartwatchReceiver extends LoggingReceiver {
    public static boolean isTrackingStartAllowed(Context context, String str) {
        if (AlarmKlaxon.isRunning() || AlarmKlaxon.LAST_FINISHED_TIME > System.currentTimeMillis() - 5000) {
            StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Ignoring ", str, " broadcast due to running or recent alarm. Last finish time: ");
            sbM5m.append(AlarmKlaxon.LAST_FINISHED_TIME);
            Logger.logInfo(sbM5m.toString());
            return false;
        }
        if (SleepTest.isSensorTestRunning()) {
            Logger.logInfo("Ignoring " + str + " broadcast due running sensor test.");
            return false;
        }
        if (SleepService.LAST_FINISHED_TIME > System.currentTimeMillis() - 10000) {
            StringBuilder sbM5m2 = FileInsert$$ExternalSyntheticOutline0.m5m("Ignoring ", str, " broadcast, because sleep service finished recently: ");
            sbM5m2.append(SleepService.LAST_FINISHED_TIME);
            Logger.logInfo(sbM5m2.toString());
            return false;
        }
        if (new Settings(context).isSmartwatchEnabled()) {
            return true;
        }
        Logger.logInfo("Ignoring " + str + " broadcast due to smart watch not enabled.");
        return false;
    }

    public abstract String getName();

    public abstract void handleIntent(Context context, Intent intent, boolean z);

    public abstract boolean isBlocked();

    public boolean isMessageForSleep(Context context, Intent intent) {
        return true;
    }

    @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        GlobalInitializator.initializeIfRequired(context);
        if (isMessageForSleep(context, intent)) {
            if (!SharedApplicationContext.getSettings().isSmartwatchEnabled() && !SleepService.isRunning()) {
                Logger.logWarning("Getting messages from " + getName() + " but smartwatch tracking not enabled, enabling! " + intent.getAction());
                SharedApplicationContext.getSettings().setSmartwatchEnabled(true);
            }
            handleIntent(context, intent, isTrackingStartAllowed(context, intent));
        }
    }

    public boolean isTrackingStartAllowed(Context context, Intent intent) {
        if (!isTrackingStartAllowed(context, getName())) {
            return false;
        }
        if (!isBlocked()) {
            return true;
        }
        Logger.logInfo("Ignoring " + getName() + " broadcast due block.");
        return false;
    }
}
