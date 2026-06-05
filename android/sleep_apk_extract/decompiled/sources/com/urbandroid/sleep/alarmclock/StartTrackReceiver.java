package com.urbandroid.sleep.alarmclock;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.Sleep;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class StartTrackReceiver extends LoggingReceiver {
    private static SleepRecord fetchIntentRecord(Intent intent) {
        SleepRecord sleepRecordCreateFromParcel;
        byte[] byteArrayExtra = intent.getByteArrayExtra("SleepRecord");
        if (byteArrayExtra != null) {
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
            parcelObtain.setDataPosition(0);
            sleepRecordCreateFromParcel = SleepRecord.CREATOR.createFromParcel(parcelObtain);
        } else {
            sleepRecordCreateFromParcel = null;
        }
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("Restarter: Has some record on restart: "), sleepRecordCreateFromParcel != null);
        return sleepRecordCreateFromParcel;
    }

    private static boolean isSameAsLastFinishedRecord(SleepRecord sleepRecord) {
        SleepRecord lastSleepRecord;
        return sleepRecord != null && (lastSleepRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().getLastSleepRecord()) != null && lastSleepRecord.isFinished() && lastSleepRecord.getFrom().getTime() == sleepRecord.getFrom().getTime();
    }

    public static void restartFromIntent(Context context, Intent intent) {
        Intent intent2 = new Intent(context, (Class<?>) Sleep.class);
        intent2.setFlags(872415232);
        if (intent != null && intent.hasExtra("START_AIRPLANE")) {
            intent2.putExtra("START_AIRPLANE", true);
        }
        if (intent != null && intent.hasExtra("NOTIFICATION_STARTED")) {
            intent2.putExtra("NOTIFICATION_STARTED", true);
        }
        if (intent != null && intent.hasExtra("MANUALY_STARTED")) {
            intent2.putExtra("MANUALY_STARTED", true);
        }
        if (intent != null && intent.hasExtra("START_IN_BATTERY_SAVING_MODE")) {
            intent2.putExtra("START_IN_BATTERY_SAVING_MODE", true);
        }
        if (intent != null && intent.hasExtra("SCHEDULED_AUTO_START")) {
            intent2.putExtra("SCHEDULED_AUTO_START", true);
        }
        SleepRecord sleepRecordFetchIntentRecord = fetchIntentRecord(intent);
        try {
            SleepRecord lastSleepRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().getLastSleepRecord();
            if (lastSleepRecord != null && sleepRecordFetchIntentRecord != null) {
                if (lastSleepRecord.getFrom().getTime() > sleepRecordFetchIntentRecord.getFrom().getTime()) {
                    Logger.logDebug("Restarter: Ignoring stale restart. There is already later record after record being restored.");
                    return;
                } else if (isSameAsLastFinishedRecord(sleepRecordFetchIntentRecord)) {
                    Logger.logInfo("Restarter: Ignored due to match with last record");
                    return;
                }
            }
            if (SharedApplicationContext.getSettings().canStartScreensFromBackground()) {
                Logger.logSevere("Restarter: starting sleep on pre-Q or with draw over permission");
                new SleepStarter().startSleep(context, intent2, sleepRecordFetchIntentRecord);
            } else {
                Intent intent3 = new Intent(context, (Class<?>) SleepService.getServiceClass(context));
                intent3.putExtra("MANUALY_STARTED", false);
                Logger.logSevere("Restarter: starting sleep on Android Q");
                new SleepStarter().startSleep(context, intent3, sleepRecordFetchIntentRecord, false, true);
            }
        } catch (ActivityNotFoundException e) {
            Logger.logSevere("Restarter: Sleep tracking activity not found", e);
        } catch (Exception e2) {
            Logger.logSevere("Restarter: Failed to restart recording", e2);
            ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "Failed to restart recording");
        }
    }

    @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        GlobalInitializator.initializeIfRequired(context);
        if ("com.urbandroid.sleep.alarmclock.START_SLEEP_TRACK".equals(intent.getAction())) {
            Logger.logInfo("Restarter: Start track intent received: " + ContextExtKt.stringify(intent));
            restartFromIntent(context, intent);
            return;
        }
        if ("com.urbandroid.sleep.alarmclock.START_SLEEP_WEARABLE_TRACK".equals(intent.getAction())) {
            Logger.logInfo("Restarter: Start track with wearable intent received");
            if (SharedApplicationContext.getSettings().canStartScreensFromBackground()) {
                new SleepStarter().startSleep(context.getApplicationContext());
                return;
            } else {
                new SleepStarter().startSleepSkipUi(context.getApplicationContext());
                return;
            }
        }
        if ("com.urbandroid.sleep.alarmclock.START_SLEEP_WIDGET_TRACK".equals(intent.getAction())) {
            Logger.logInfo("Restarter: Start track with widget intent received");
            new SleepStarter().startSleep(context.getApplicationContext());
            return;
        }
        if ("com.urbandroid.sleep.alarmclock.START_SLEEP_TRACK_WITH_IDEAL_ALARM_ACTION".equals(intent.getAction()) || "com.urbandroid.sleep.alarmclock.START_SLEEP_TRACK_WITH_IDEAL_ALARM_PLUS_BEDTIME_BEFORE_ACTION".equals(intent.getAction())) {
            int idealSleepMinutes = SharedApplicationContext.getSettings().getIdealSleepMinutes();
            int smartWakeupMinutes = SharedApplicationContext.getSettings().getSmartWakeupMinutes() != 59 ? SharedApplicationContext.getSettings().getSmartWakeupMinutes() / 2 : 0;
            if ("com.urbandroid.sleep.alarmclock.START_SLEEP_TRACK_WITH_IDEAL_ALARM_PLUS_BEDTIME_BEFORE_ACTION".equals(intent.getAction())) {
                smartWakeupMinutes *= 2;
            }
            int trackingDelay = SharedApplicationContext.getSettings().getTrackingDelay();
            Alarms.addQuickAlarm(context, idealSleepMinutes + smartWakeupMinutes + (trackingDelay > 60000 ? trackingDelay / 60000 : 0), context.getString(R.string.ideal_alarm_label), false);
            if (intent.getBooleanExtra("SKIP_UI", true)) {
                new SleepStarter().startSleepSkipUi(context);
            } else {
                new SleepStarter().startSleep(context);
            }
        }
    }
}
