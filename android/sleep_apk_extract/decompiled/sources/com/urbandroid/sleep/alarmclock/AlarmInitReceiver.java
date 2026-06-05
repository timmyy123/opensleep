package com.urbandroid.sleep.alarmclock;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.Sleep;
import com.urbandroid.sleep.alarmclock.lockedboot.LockedBootReceiver;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.Wearable;
import com.urbandroid.sleep.smartwatch.fitbit.FitbitHttpServerService;
import com.urbandroid.sleep.smartwatch.zepp.ZeppHttpServerService;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.ThemeUtil;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class AlarmInitReceiver extends LoggingReceiver {
    private static final long RESCHEDULE_ALARM_LOOKBACK = 7200000;
    private static final long RESCHEDULE_ALARM_NEAR_IGNORE_LOOKBACK = 360000;
    private static final long RESCHEDULE_ALARM_NEAR_IGNORE_MAX_DIFF = 30000;

    private void handleAlarmReschedulingOnTimeChange(Context context, long j, long j2) {
        long j3 = j - RESCHEDULE_ALARM_NEAR_IGNORE_LOOKBACK;
        Alarm alarmCalculateNextAlert = Alarms.calculateNextAlert(context, j3);
        if (j2 > j && alarmCalculateNextAlert != null) {
            long j4 = alarmCalculateNextAlert.time;
            if (j4 > j3 && j4 <= j2 && j2 - j < RESCHEDULE_ALARM_NEAR_IGNORE_MAX_DIFF) {
                Logger.logInfo("AlarmInitReceiver: ignoring time change, near alarm " + alarmCalculateNextAlert);
                return;
            }
        }
        Alarm nextAlert = Alarms.setNextAlert(context, j);
        Alarm nextAlert2 = Alarms.setNextAlert(context);
        if (nextAlert == null) {
            Logger.logInfo("AlarmInitReceiver: ignore time change no previous ");
            return;
        }
        long j5 = nextAlert.time;
        if (RESCHEDULE_ALARM_LOOKBACK + j5 < j) {
            Logger.logInfo("AlarmInitReceiver: ignore time change previous > 2h in past");
            return;
        }
        if (nextAlert2 != null && nextAlert2.time == j5) {
            long snoozeTime = Alarms.getSnoozeTime(context);
            if (snoozeTime != 0 && Alarms.getSnoozeAlarmId(context) == nextAlert.id && j2 < j) {
                long j6 = j - j2;
                Logger.logInfo("AlarmInitReceiver: Moving snooze of alarm " + nextAlert.id + " by " + j6 + " millis.");
                Alarms.saveSnoozeAlert(context, nextAlert.id, snoozeTime - j6);
            }
            Logger.logInfo("AlarmInitReceiver: ignore time charge not moving snooze");
            return;
        }
        if (j2 < j) {
            Logger.logInfo("AlarmInitReceiver: ignore time change, move to past");
            return;
        }
        boolean z = nextAlert2 != null && nextAlert2.id == nextAlert.id && Math.abs(nextAlert2.time - j5) < 10800000;
        if (z) {
            zza$$ExternalSyntheticOutline0.m("AlarmInitReceiver: ignore time, small change ", z);
            return;
        }
        StringBuilder sb = new StringBuilder("Firing old alarm ");
        sb.append(nextAlert.id);
        sb.append(" originally scheduled to ring at ");
        sb.append(new Date(nextAlert.time));
        sb.append(" Newly scheduled at ");
        sb.append(nextAlert2 != null ? new Date(nextAlert2.time) : "NULL");
        Logger.logInfo(sb.toString());
        nextAlert.time = j2;
        Intent intent = new Intent("com.urbandroid.sleep.alarmclock.ALARM_ALERT");
        intent.putExtra("intent.extra.alarm_raw", nextAlert.serializeToArray());
        ContextExtKt.sendExplicitBroadcast(context, intent);
    }

    public static void restartTrackOnRebootIfRequired(Context context) {
        SleepRecord lastRecoverableRecord;
        if (CurrentSleepRecord.getInstance().getRecord() == null && (lastRecoverableRecord = CurrentSleepRecord.getLastRecoverableRecord()) != null) {
            Logger.logInfo("AlarmInitReceiver: Restarting old sleep track on reboot: " + lastRecoverableRecord.getFrom());
            Intent intent = new Intent(context, (Class<?>) Sleep.class);
            intent.setFlags(872415232);
            new SleepStarter().startSleep(context, intent, lastRecoverableRecord);
        }
    }

    @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int currentAlarm;
        super.onReceive(context, intent);
        String action = intent.getAction();
        GlobalInitializator.initializeIfRequired(context);
        Logger.logDebug("AlarmInitReceiver " + action);
        if (context.getContentResolver() == null) {
            Logger.logSevere("AlarmInitReceiver: FAILURE unable to get content resolver.  Alarms inactive.");
            return;
        }
        Settings settings = new Settings(context);
        if (!"android.intent.action.BOOT_COMPLETED".equals(action)) {
            if ("com.urbandroid.sleep.alarmclock.DELAYED_BOOT_COMPLETED".equals(action)) {
                Alarms.setNextAlert(context);
                return;
            }
            if (!"android.intent.action.TIME_SET".equals(action)) {
                if (!"android.app.action.SCHEDULE_EXACT_ALARM_PERMISSION_STATE_CHANGED".equals(action)) {
                    Alarms.setNextAlert(context);
                    return;
                } else {
                    Logger.logInfo("AlarmInitReceiver: Yahoo! We can schedule EXACT alarms again!");
                    Alarms.setNextAlert(context);
                    return;
                }
            }
            long timeDifference = settings.getTimeDifference();
            long timeDifference2 = settings.setTimeDifference();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = (timeDifference2 - timeDifference) + jCurrentTimeMillis;
            long j2 = jCurrentTimeMillis - j;
            if (Math.abs(j2) > TimeUnit.SECONDS.toMillis(RESCHEDULE_ALARM_NEAR_IGNORE_MAX_DIFF)) {
                Logger.logInfo("AlarmInitReceiver: Bigger time changed clearing alarm cache.");
                Alarms.resetLastScheduledAlarmData();
            }
            Logger.logInfo("AlarmInitReceiver: Time changed from " + new Date(j) + " to " + new Date(jCurrentTimeMillis) + " diff " + j2 + " ms");
            handleAlarmReschedulingOnTimeChange(context, j, jCurrentTimeMillis);
            Intent intent2 = new Intent("com.urbandroid.sleep.alarmclock.TIME_CHANGED");
            intent2.putExtra("com.urbandroid.sleep.alarmclock.TIME_CHANGED_EXTRA", j2);
            ContextExtKt.sendExplicitBroadcast(context, intent2);
            return;
        }
        Logger.logInfo("Boot completed");
        if (Environment.isNOrGreater()) {
            LockedBootReceiver.cancelBackupAlarm(context);
        }
        Logger.logInfo("Boot completed");
        Alarms.saveSnoozeAlert(context, -1, -1L);
        Alarms.disableExpiredAlarms(context);
        try {
            settings.setTimeDifference();
            settings.resetSnoozeRepeatIfNoSnoozeScheduled();
            settings.resetAutoSnoozeRepeat();
        } catch (Exception e) {
            Logger.logWarning("Failed to set settings", e);
        }
        try {
            Alarms.setNextAlert(context);
            restartTrackOnRebootIfRequired(context);
            if (SharedApplicationContext.getSettings().getSelectedWearable() == Wearable.FITBIT) {
                ContextExtKt.startForegroundServiceWithLog(context, new Intent(context, (Class<?>) FitbitHttpServerService.class));
            } else if (SharedApplicationContext.getSettings().getSelectedWearable() == Wearable.ZEPP) {
                ContextExtKt.startForegroundServiceWithLog(context, new Intent(context, (Class<?>) ZeppHttpServerService.class));
            }
            ((AlarmManager) context.getSystemService("alarm")).set(0, System.currentTimeMillis() + 180000, PendingIntentBuilder.get(context, 0, new Intent("com.urbandroid.sleep.alarmclock.DELAYED_BOOT_COMPLETED"), 134217728).getExplicitBroadcast());
        } catch (Exception e2) {
            Logger.logSevere(e2);
            ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "Failed to set delayed boot.");
        }
        if (Experiments.getInstance().isRebootRestarting() && (currentAlarm = settings.getCurrentAlarm()) > -1) {
            long currentAlarmTime = settings.getCurrentAlarmTime();
            boolean z = currentAlarmTime == 0 || System.currentTimeMillis() - currentAlarmTime > ((long) settings.getAlarmTimeout()) * 1000;
            if (z) {
                StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("AlarmInitReceiver: Alarm on reboot too old.. Alarm time: ", " Now: ", currentAlarmTime);
                sbM.append(System.currentTimeMillis());
                Logger.logInfo(sbM.toString());
                settings.setCurrentAlarm(-1, 0L);
            }
            Alarm alarm = Alarms.getAlarm(context.getContentResolver(), currentAlarm);
            if (alarm != null && !z) {
                settings.clearActiveAlarm();
                Logger.logInfo("AlarmInitReceiver: Firing alarm on reboot: " + Alarm.toDebugString(alarm));
                Alarms.fireSmartAlarm(context, alarm);
            }
        }
        ThemeUtil.setTheme(context);
    }
}
