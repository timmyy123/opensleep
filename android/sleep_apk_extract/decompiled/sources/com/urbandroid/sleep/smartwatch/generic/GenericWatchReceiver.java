package com.urbandroid.sleep.smartwatch.generic;

import android.content.Context;
import android.content.Intent;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.alarmclock.SleepStarter;
import com.urbandroid.sleep.sensor.extra.HrDataProducer;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.AbstractConnectivityCallback;
import com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver;
import com.urbandroid.sleep.smartwatch.MultiSmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class GenericWatchReceiver extends AbstractStartSmartwatchReceiver {
    public GenericWatchReceiver() {
        Logger.addFilter(Filters.filter("GenericWatch: DATA", 600));
    }

    public GenericWatch getGenericWatch(Context context) {
        SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(context);
        if (smartWatch instanceof GenericWatch) {
            return (GenericWatch) smartWatch;
        }
        if (smartWatch instanceof MultiSmartWatch) {
            for (SmartWatch smartWatch2 : ((MultiSmartWatch) smartWatch).getWatches()) {
                if (smartWatch2 instanceof GenericWatch) {
                    return (GenericWatch) smartWatch2;
                }
            }
        }
        Logger.logWarning("Something got wrong. We expect generic watch, but we have: " + smartWatch);
        return null;
    }

    @Override // com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver
    public String getName() {
        return "Generic watch";
    }

    @Override // com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver
    public void handleIntent(Context context, Intent intent, boolean z) {
        float[] floatArrayExtra;
        GenericWatch genericWatch;
        String action = intent != null ? intent.getAction() : null;
        if (!SleepService.isRunning() && z) {
            Logger.logWarning("GenericWatch: Intent but no tracking " + action);
            if ("com.urbandroid.sleep.watch.STARTED_ON_WATCH".equals(action)) {
                SmartWatchProvider.setSmartwatchInstanceIfNotTrackingYet(new GenericWatch(context.getApplicationContext()));
                Logger.logInfo("GenericWatch: Starting watch tracking received");
                if (!SleepService.isRunning()) {
                    if (SharedApplicationContext.getSettings().canStartScreensFromBackground()) {
                        new SleepStarter().startSleep(context);
                    } else {
                        new SleepStarter().startSleepSkipUiButStartManually(context);
                    }
                }
            } else {
                GenericWatch genericWatch2 = getGenericWatch(context);
                if (genericWatch2 != null) {
                    Logger.logWarning("GenericWatch: Auto start protection, stopping tracking " + action);
                    genericWatch2.stopTracking();
                    return;
                }
                if (genericWatch2 == null) {
                    new GenericWatch(context).asyncConnectionCheck(new AbstractConnectivityCallback() { // from class: com.urbandroid.sleep.smartwatch.generic.GenericWatchReceiver.1
                        @Override // com.urbandroid.sleep.smartwatch.AbstractConnectivityCallback
                        public void doStatus(SmartWatch smartWatch, boolean z2) {
                            if (smartWatch == null || !z2) {
                                return;
                            }
                            Logger.logWarning("GenericWatch: Auto start protection, stopping tracking delayed");
                            smartWatch.stopTracking();
                        }
                    }, 20000L);
                    return;
                }
            }
        }
        if (SleepService.isRunning() && "com.urbandroid.sleep.watch.STARTED_ON_WATCH".equals(action) && (genericWatch = getGenericWatch(context)) != null) {
            genericWatch.startTracking(null);
            return;
        }
        if (!"com.urbandroid.sleep.watch.DATA_UPDATE".equals(action)) {
            if ("com.urbandroid.sleep.watch.HR_DATA_UPDATE".equals(action)) {
                if (getGenericWatch(context) == null || (floatArrayExtra = intent.getFloatArrayExtra("DATA")) == null) {
                    return;
                }
                HrDataProducer.produce(context, floatArrayExtra, 10000L);
                return;
            }
            if ("com.urbandroid.sleep.watch.PAUSE_FROM_WATCH".equals(action)) {
                ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.ACTION_PAUSE_TRACKING"));
                Logger.logInfo("GenericWatch: Pause received");
                return;
            }
            if ("com.urbandroid.sleep.watch.RESUME_FROM_WATCH".equals(action)) {
                ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.ACTION_RESUME_TRACKING"));
                Logger.logInfo("GenericWatch: Resume received");
                return;
            } else if ("com.urbandroid.sleep.watch.SNOOZE_FROM_WATCH".equals(action)) {
                Logger.logInfo("GenericWatch: Snooze received");
                ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE"));
                return;
            } else {
                if ("com.urbandroid.sleep.watch.DISMISS_FROM_WATCH".equals(action)) {
                    ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CAPTCHA"));
                    Logger.logInfo("GenericWatch: Dismiss received");
                    return;
                }
                return;
            }
        }
        GenericWatch genericWatch3 = getGenericWatch(context);
        if (genericWatch3 == null) {
            return;
        }
        if (genericWatch3.isTrackingStarted()) {
            genericWatch3.rescheduleRestart();
        } else {
            genericWatch3.stopRestart();
        }
        float[] floatArrayExtra2 = intent.getFloatArrayExtra("MAX_DATA");
        if (intent.hasExtra("MAX_RAW_DATA")) {
            floatArrayExtra2 = intent.getFloatArrayExtra("MAX_RAW_DATA");
        }
        if (floatArrayExtra2 == null) {
            Logger.logWarning("GenericWatch: Values are null");
            return;
        }
        genericWatch3.onReceivedBatchSize(floatArrayExtra2.length);
        Logger.logInfo("GenericWatch: DATA " + Arrays.toString(floatArrayExtra2));
        boolean z2 = floatArrayExtra2.length > 0 && floatArrayExtra2[0] > 0.0f;
        for (float f : floatArrayExtra2) {
            if ((!z2 || f != 0.0f) && f >= 0.0f) {
                genericWatch3.getAccelManager().pushNewData(f);
            }
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver
    public boolean isBlocked() {
        return GenericWatch.isStartingDisabled();
    }

    @Override // com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver
    public boolean isTrackingStartAllowed(Context context, Intent intent) {
        GenericWatch genericWatch;
        if (!SleepService.isRunning() || ((genericWatch = getGenericWatch(context)) != null && genericWatch.getClass().equals(GenericWatch.class))) {
            return super.isTrackingStartAllowed(context, intent);
        }
        return false;
    }
}
