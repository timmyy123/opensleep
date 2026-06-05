package com.urbandroid.sleep;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.os.PowerManager;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class AutoStartTrackReceiver extends LoggingReceiver {
    private void startTrack(Context context) {
        Logger.logInfo("Auto start: Starting tracking");
        Intent intent = new Intent("com.urbandroid.sleep.alarmclock.START_SLEEP_TRACK");
        intent.putExtra("SCHEDULED_AUTO_START", true);
        ContextExtKt.sendExplicitBroadcast(context, intent);
        ((PowerManager) context.getSystemService("power")).newWakeLock(1, SleepLockManager.getWakeLockTag(context, "AutoStartLock")).acquire(10000L);
    }

    @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent == null) {
            return;
        }
        GlobalInitializator.initializeIfRequired(context);
        Logger.logInfo("Auto start: intent received");
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        if (SleepService.isRunning() && "com.urbandroid.sleep.alarmclock.AUTO_START_SLEEP_TRACK".equals(intent.getAction())) {
            Logger.logInfo("Auto start: Tracking is running ");
            Logger.logInfo("Auto start: Stop disable mode");
            ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.alarmclock.SLEEP_TRACKING_ENABLE"));
            return;
        }
        if (SharedApplicationContext.getSettings().getAutoStartMode() != 2 || !"com.urbandroid.sleep.alarmclock.AUTO_START_SLEEP_TRACK_BEDTIME".equals(intent.getAction())) {
            if (SharedApplicationContext.getSettings().getAutoStartMode() == 3 && "com.urbandroid.sleep.alarmclock.AUTO_START_SLEEP_TRACK".equals(intent.getAction())) {
                if (!SharedApplicationContext.getSettings().shouldBeOnChargerWhenAutoStart() || batteryManager.isCharging()) {
                    startTrack(context);
                    return;
                }
                Logger.logInfo("Auto start: Not starting (smart period) phone not charging, should " + SharedApplicationContext.getSettings().shouldBeOnChargerWhenAutoStart() + " charging " + batteryManager.isCharging());
                return;
            }
            return;
        }
        if (new Settings(context).getAutoStartMode() == 2) {
            if (!SharedApplicationContext.getSettings().shouldBeOnChargerWhenAutoStart() || batteryManager.isCharging()) {
                startTrack(context);
                return;
            }
            Logger.logInfo("Auto start: Not starting (smart period) phone not charging, should " + SharedApplicationContext.getSettings().shouldBeOnChargerWhenAutoStart() + " charging " + batteryManager.isCharging());
            int intExtra = intent.getIntExtra("snooze", 0);
            if (intExtra <= 5) {
                Intent intent2 = new Intent("com.urbandroid.sleep.alarmclock.AUTO_START_SLEEP_TRACK_BEDTIME");
                intent2.putExtra("snooze", intExtra + 1);
                intent2.putExtra("SCHEDULED_AUTO_START", true);
                PendingIntentBuilder pendingIntentBuilder = PendingIntentBuilder.get(context, 2, intent2, Alarms.getPendingIntentFlags());
                PendingIntentBuilder pendingIntentBuilder2 = PendingIntentBuilder.get(context, 2, intent2, Alarms.getPendingIntentFlagsLegacy());
                AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                long jCurrentTimeMillis = System.currentTimeMillis() + 900000;
                pendingIntentBuilder.cancelAlarmBroadcast();
                pendingIntentBuilder2.cancelAlarmBroadcast();
                Logger.logInfo("Auto start: Snoozing bedtime auto start (not charging) to " + new Date(jCurrentTimeMillis));
                Alarms.setAlarmCompat(alarmManager, 0, jCurrentTimeMillis, pendingIntentBuilder.getExplicitBroadcast());
            }
        }
    }
}
