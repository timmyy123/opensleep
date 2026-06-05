package com.urbandroid.sleep.alarmclock;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.AuthenticationTokenClaims;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.TtsService;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class BedtimeReceiver extends LoggingReceiver {
    public static void cancelRepeatNotification(Context context) {
        try {
            NotificationManagerCompat.from(context).cancel(33434343);
            PendingIntentBuilder.get(context, 380229328, new Intent("com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALERT_REPEAT_ACTION"), 134217728).cancelAlarmBroadcast();
        } catch (Throwable th) {
            Logger.logSevere(th);
        }
    }

    private static void scheduleNotification(Context context, String str, String str2, String str3, long j, int i) {
        Logger.logInfo("Bedtime: scheduling snooze or repeat " + str + " in " + j);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(str);
        intent.putExtra("time_to_bed_message", str2);
        intent.putExtra("time_to_bed_content_info", str3);
        alarmManager.set(0, System.currentTimeMillis() + j, PendingIntentBuilder.get(context, i, intent, 134217728).getExplicitBroadcast());
    }

    public static void scheduleRepeat(Context context, String str, String str2, long j) {
        scheduleNotification(context, "com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALERT_REPEAT_ACTION", str, str2, j, 380229328);
    }

    public static void scheduleSnooze(Context context, String str, String str2, long j) {
        scheduleNotification(context, "com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALARM_ALERT", str, str2, j, 472937);
    }

    @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        PendingIntent activity;
        super.onReceive(context, intent);
        GlobalInitializator.initializeIfRequired(context);
        Logger.logInfo("BedtimeReceiver:onReceive " + intent);
        Settings settings = new Settings(context);
        Alarm alarmCalculateNextAlert = Alarms.calculateNextAlert(context);
        if (CurrentSleepRecord.getInstance() != null && CurrentSleepRecord.getInstance().getRecord() != null && !CurrentSleepRecord.getInstance().getRecord().isFinished()) {
            Logger.logDebug("BedtimeReceiver:Ignored go to bed. Next alarm: " + Alarm.toDebugString(alarmCalculateNextAlert));
            return;
        }
        int timeToBedRepeat = settings.getTimeToBedRepeat();
        if ("com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALERT_SNOOZE_ACTION".equals(intent.getAction())) {
            cancelRepeatNotification(context);
            Logger.logDebug("BedtimeReceiver:Time to bed snoozed");
            scheduleSnooze(context, intent.getStringExtra("time_to_bed_message"), intent.getStringExtra("time_to_bed_content_info"), AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED);
            return;
        }
        if ("com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALERT_DISMISS_ACTION".equals(intent.getAction())) {
            Logger.logDebug("BedtimeReceiver:Time to bed dismissed");
            cancelRepeatNotification(context);
            return;
        }
        if ("com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALERT_REPEAT_ACTION".equals(intent.getAction())) {
            try {
                activity = PendingIntentBuilder.get(context, 472937, new Intent(context, (Class<?>) AlarmClock.class), 536870912).getActivity();
            } catch (Exception e) {
                Logger.logSevere(e);
                activity = null;
            }
            if (activity == null) {
                Logger.logInfo("BedtimeReceiver:Notification was already dismissed");
                return;
            }
        }
        if (intent.getExtras() == null || intent.getExtras().getString("time_to_bed_message") == null || (alarmCalculateNextAlert == null && !settings.isNoAlarmBedtime())) {
            if (alarmCalculateNextAlert == null) {
                Logger.logWarning("Bedtime: alarm is NULL, not showing notification");
                return;
            }
            return;
        }
        Logger.logDebug("BedtimeReceiver:Bedtime notification");
        Intent intent2 = new Intent(context, (Class<?>) AlarmClock.class);
        intent2.putExtra("notification_tapped", true);
        PendingIntent activity2 = PendingIntentBuilder.get(context, 472937, intent2, ClientDefaults.MAX_MSG_SIZE).getActivity();
        String string = context.getString(R.string.time_to_bed_title);
        String stringExtra = intent.getStringExtra("time_to_bed_message");
        Intent intent3 = new Intent("com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALERT_SNOOZE_ACTION");
        intent3.putExtra("time_to_bed_message", intent.getStringExtra("time_to_bed_message"));
        intent3.putExtra("time_to_bed_content_info", intent.getStringExtra("time_to_bed_content_info"));
        PendingIntent explicitBroadcast = PendingIntentBuilder.get(context, 878202189, intent3, 134217728).getExplicitBroadcast();
        Intent intent4 = new Intent(context, (Class<?>) DummyBroadcastActivity.class);
        intent4.setAction("com.urbandroid.sleep.alarmclock.START_SLEEP_WIDGET_TRACK");
        intent4.putExtra("extra_broadcast_action", "com.urbandroid.sleep.alarmclock.START_SLEEP_WIDGET_TRACK");
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(context, "bedtimeChannel").setContentIntent(activity2).setAutoCancel(true).setContentTitle(string).setColor(ColorUtil.i(context, R.color.tint_notification)).addAction(R.drawable.ic_action_snooze, context.getString(R.string.alarm_alert_snooze_text), explicitBroadcast).setDeleteIntent(PendingIntentBuilder.get(context, 3284879, new Intent("com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALERT_DISMISS_ACTION"), 134217728).getExplicitBroadcast()).addAction(R.drawable.ic_action_track, context.getString(R.string.settings_category_track), PendingIntentBuilder.get(context.getApplicationContext(), 9277632, intent4, 134217728).getActivity()).setContentText(stringExtra);
        contentText.setSmallIcon(R.drawable.ic_action_bedtime_white);
        if (intent.hasExtra("time_to_bed_content_info")) {
            if (Build.VERSION.SDK_INT > 24) {
                contentText.setSubText(intent.getStringExtra("time_to_bed_content_info"));
            } else {
                contentText.setContentInfo(intent.getStringExtra("time_to_bed_content_info"));
            }
        }
        if (Build.VERSION.SDK_INT < 26) {
            String timeToBedRingtone = SharedApplicationContext.getSettings().getTimeToBedRingtone();
            if (timeToBedRingtone != null) {
                Logger.logDebug("BedtimeReceiver:Ringtone selected: ".concat(timeToBedRingtone));
                try {
                    if (Environment.isNOrGreater() && timeToBedRingtone.startsWith("file://")) {
                        timeToBedRingtone = timeToBedRingtone.substring(7);
                        Logger.logInfo("Bedtime: stripping URI ".concat(timeToBedRingtone));
                    }
                    contentText.setSound(Uri.parse(timeToBedRingtone));
                } catch (Exception e2) {
                    Logger.logWarning("BedtimeReceiver:Failed to set ringtone.", e2);
                    contentText.setDefaults(1);
                }
            } else {
                contentText.setDefaults(1);
            }
            if (SharedApplicationContext.getSettings().isTimeToBedLed()) {
                contentText.setDefaults(4);
                contentText.setLights(Color.RED, 200, 200);
            }
            if (SharedApplicationContext.getSettings().isTimeToBedVibrating()) {
                contentText.setVibrate(new long[]{0, 1000, 1000, 1000, 1000, 1000});
            }
        }
        Notification notificationBuild = contentText.build();
        NotificationManagerCompat.from(context);
        NotificationsKt.notify(context, 33434343, notificationBuild);
        Logger.logDebug("BedtimeReceiver:Go to bed notification being displayed. Alarm: " + Alarm.toDebugString(alarmCalculateNextAlert));
        if (timeToBedRepeat > -1) {
            scheduleRepeat(context, intent.getStringExtra("time_to_bed_message"), intent.getStringExtra("time_to_bed_content_info"), timeToBedRepeat);
        }
        TtsService.speak(context, string + ". " + stringExtra);
        if (settings.getNextAlarm() != null) {
            TtsService.speak(context, R.string.time_to_bed_message, DateUtil.formatTimeShortHumanTts(context, settings.getNextAlarm().getTime()));
        }
    }
}
