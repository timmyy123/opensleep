package com.urbandroid.sleep.smartwatch.samsung;

import android.content.Context;
import android.content.Intent;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.alarmclock.SleepStarter;
import com.urbandroid.sleep.smartwatch.AbstractConnectivityCallback;
import com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;

/* JADX INFO: loaded from: classes5.dex */
public class SamsungReceiver extends AbstractStartSmartwatchReceiver {
    private SamsungSmartWatch getSamsungWatch(Context context) {
        SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(context);
        if (smartWatch != null && smartWatch.getClass().equals(SamsungSmartWatch.class)) {
            return (SamsungSmartWatch) smartWatch;
        }
        Logger.logWarning("Something got wrong. We expect samsung watch, but we have: " + smartWatch);
        return null;
    }

    @Override // com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver
    public String getName() {
        return "Samsung";
    }

    @Override // com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver
    public void handleIntent(Context context, Intent intent, boolean z) {
        if (!SleepService.isRunning() && z) {
            if (intent == null || "com.urbandroid.sleep.samsung.STARTED_ON_WATCH".equals(intent.getAction())) {
                SmartWatchProvider.setSmartwatchInstanceIfNotTrackingYet(new SamsungSmartWatch(context.getApplicationContext()));
                Logger.logInfo("Starting Samsung tracking");
                new SleepStarter().startSleepSkipUiButStartManually(context);
            } else {
                SamsungSmartWatch samsungWatch = getSamsungWatch(context);
                if (samsungWatch != null) {
                    samsungWatch.stopTracking();
                    return;
                } else if (samsungWatch == null) {
                    new SamsungSmartWatch(context).asyncConnectionCheck(new AbstractConnectivityCallback() { // from class: com.urbandroid.sleep.smartwatch.samsung.SamsungReceiver.1
                        @Override // com.urbandroid.sleep.smartwatch.AbstractConnectivityCallback
                        public void doStatus(SmartWatch smartWatch, boolean z2) {
                            if (smartWatch == null || !z2) {
                                return;
                            }
                            smartWatch.stopTracking();
                        }
                    }, 20000L);
                    return;
                }
            }
        }
        int i = 0;
        if (intent.getAction() != null && intent.getAction().equals("com.urbandroid.sleep.samsung.DATA_UPDATE")) {
            SamsungSmartWatch samsungWatch2 = getSamsungWatch(context);
            if (samsungWatch2 == null) {
                return;
            }
            samsungWatch2.rescheduleRestart();
            float[] floatArrayExtra = intent.getFloatArrayExtra("DATA");
            samsungWatch2.onReceivedBatchSize(floatArrayExtra.length);
            int length = floatArrayExtra.length;
            while (i < length) {
                samsungWatch2.getAccelManager().pushNewData(floatArrayExtra[i]);
                i++;
            }
            return;
        }
        if (intent.getAction().equals("com.urbandroid.sleep.samsung.HR_DATA_UPDATE")) {
            SamsungSmartWatch samsungWatch3 = getSamsungWatch(context);
            if (samsungWatch3 == null) {
                return;
            }
            float[] floatArrayExtra2 = intent.getFloatArrayExtra("DATA");
            int length2 = floatArrayExtra2.length;
            while (i < length2) {
                samsungWatch3.pushHRData(floatArrayExtra2[i]);
                i++;
            }
            return;
        }
        if (intent.getAction().equals("com.urbandroid.sleep.samsung.PAUSE_FROM_WATCH")) {
            Logger.logInfo("Samsung pause received.");
            ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.ACTION_PAUSE_TRACKING"));
            return;
        }
        if (intent.getAction().equals("com.urbandroid.sleep.samsung.RESUME_FROM_WATCH")) {
            Logger.logInfo("Samsung resume received.");
            ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.ACTION_RESUME_TRACKING"));
        } else if (intent.getAction().equals("com.urbandroid.sleep.samsung.SNOOZE_FROM_WATCH")) {
            Logger.logInfo("Samsung snooze received.");
            ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE"));
        } else if (intent.getAction().equals("com.urbandroid.sleep.samsung.DISMISS_FROM_WATCH")) {
            Logger.logInfo("Samsung dismiss received.");
            ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CAPTCHA"));
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver
    public boolean isBlocked() {
        return SamsungSmartWatch.isStartingDisabled();
    }

    @Override // com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver
    public boolean isTrackingStartAllowed(Context context, Intent intent) {
        SmartWatch smartWatch;
        if (!SleepService.isRunning() || ((smartWatch = SmartWatchProvider.getSmartWatch(context)) != null && smartWatch.getClass().equals(SamsungSmartWatch.class))) {
            return super.isTrackingStartAllowed(context, intent);
        }
        return false;
    }
}
