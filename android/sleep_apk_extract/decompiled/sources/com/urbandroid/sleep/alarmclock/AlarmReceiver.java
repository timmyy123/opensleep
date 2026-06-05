package com.urbandroid.sleep.alarmclock;

import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.urbandroid.common.LoggingWakefulReceiver;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.Sleep;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.achievement.Achievement;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.WakefulForegroundBroadcastReceiver;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.Experiments;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class AlarmReceiver extends LoggingWakefulReceiver {
    private void collapseNotifications(Context context) {
        try {
            context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (Exception unused) {
        }
    }

    private void snoozeAfterKill(Context context, Alarm alarm) {
        int snoozeMinutes = Alarm.getSnoozeMinutes(alarm, true);
        if (snoozeMinutes < 10) {
            snoozeMinutes = 10;
        }
        Alarm.performSnooze(context, alarm, snoozeMinutes, true);
    }

    private void updateNotification(Context context, Alarm alarm, int i) {
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        if (alarm == null) {
            Logger.logDebug("AlarmReceiver: Cannot update notification for killer callback");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) SetAlarm.class);
        intent.putExtra("alarm_id", alarm.id);
        PendingIntent activity = PendingIntentBuilder.get(context, alarm.id, intent, 0).getActivity();
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(context, "alarmNormalChannel").setContentIntent(activity).setContentTitle(alarm.getLabelOrDefault(context)).setColor(ColorUtil.i(context, R.color.tint_notification)).setAutoCancel(true).setContentText(context.getString(R.string.alarm_alert_alert_silenced, Integer.valueOf(i)));
        contentText.setSmallIcon(R.drawable.ic_alarm_white);
        notificationManagerCompatFrom.cancel(alarm.id);
        NotificationsKt.notify(context, alarm.id, contentText.build());
    }

    public static boolean useHeadupsNotification(Context context, Settings settings, Alarm alarm) {
        if (!settings.canStartScreensFromBackground()) {
            Logger.logInfo("Headups: Always on Android Q+");
            return true;
        }
        if (!Environment.isLollipopOrGreater()) {
            return false;
        }
        if (settings.isCaptchaNoEscape()) {
            Logger.logInfo("Headups: No escape");
            return false;
        }
        if (Experiments.getInstance().isPhoneWithDisappearingAlarmDialog()) {
            Logger.logInfo("Headups: Bad phone");
            return false;
        }
        if (!NotificationsKt.isNotificationEnabled(context, "alarmChannel")) {
            Logger.logInfo("Headups: Notification disabled");
            return false;
        }
        if (Sleep.RUNNING) {
            Logger.logInfo("Headups: Tracking");
            return false;
        }
        if (AlarmKlaxon.isRunning()) {
            Logger.logInfo("Headups: Ongoing alarm");
            return false;
        }
        if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            Logger.logInfo("Headups: keyguard");
            return false;
        }
        if (settings.isAlarmFullscreen()) {
            Logger.logInfo("Headups: settings full screen");
            return false;
        }
        if (((PowerManager) context.getSystemService("power")).isScreenOn()) {
            return settings.getCaptchaId(alarm) != 6;
        }
        Logger.logInfo("Headups: Screen off");
        return false;
    }

    @Override // com.urbandroid.common.LoggingWakefulReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Class<AlarmAlertFullScreen> cls;
        super.onReceive(context, intent);
        AlarmBackgroundRestrictionChecker.showNotificationIfBackgroundRestricted(context);
        GlobalInitializator.initializeIfRequired(context);
        Settings settings = new Settings(context);
        if (intent == null) {
            Logger.logWarning("AlarmReceiver: no intent");
            return;
        }
        Logger.logInfo("AlarmReceiver: action: " + intent.getAction());
        if ("com.urbandroid.sleep.alarmclock.RANDOM_ALARM_DIAGNOSTICS".equals(intent.getAction())) {
            return;
        }
        Alarm fromIntent = Alarm.parseFromIntent(intent);
        if (fromIntent == null && ("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE".equals(intent.getAction()) || "com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CAPTCHA".equals(intent.getAction()))) {
            fromIntent = AlarmKlaxon.currentAlarm;
        }
        if ("com.urbandroid.sleep.alarmclock.SKIP_NEXT_ALARM_ACTION".equals(intent.getAction())) {
            Logger.logInfo("AlarmReceiver: Skipping next alarm");
            Alarm alarmCalculateNextAlert = Alarms.calculateNextAlert(context);
            if (alarmCalculateNextAlert != null) {
                Alarms.skipAlarmOrShowCaptcha(context, alarmCalculateNextAlert);
                return;
            }
            Logger.logInfo("AlarmReceiver: Not skipping as next alarm date differs from what we thing it should be: " + alarmCalculateNextAlert + " vs " + new Date(fromIntent.time));
            return;
        }
        if ("com.urbandroid.sleep.alarmclock.RATE_SLEEP_LATER".equals(intent.getAction())) {
            Logger.logInfo("RateLate: show notification");
            Alarms.showRateSleepLaterNotification(context, (SleepRecord) intent.getParcelableExtra("SleepRecord"));
            return;
        }
        if (fromIntent == null) {
            Logger.logInfo("AlarmReceiver: failed to parse the alarm from the intent");
            return;
        }
        if ("com.urbandroid.sleep.alarmclock.SHOW_SKIP_NEXT_ALARM_ACTION".equals(intent.getAction())) {
            Alarms.showAlarmSoonNotificationIfRequired(context, fromIntent);
            return;
        }
        if ("com.urbandroid.sleep.alarmclock.ALARM_NOTIF_SNOOZE".equals(intent.getAction())) {
            collapseNotifications(context);
            Alarm.performSnooze(context, fromIntent, Alarm.getSnoozeMinutes(fromIntent, false), false);
            return;
        }
        Class<AlarmAlertFullScreen> cls2 = AlarmAlertFullScreen.class;
        if ("com.urbandroid.sleep.alarmclock.ALARM_NOTIF_DISMISS".equals(intent.getAction())) {
            collapseNotifications(context);
            if (!AlarmKlaxon.isRunning()) {
                Logger.logDebug("AlarmReceiver: Ignoring stale heads-up notification click.");
                return;
            }
            boolean z = Experiments.getInstance().isNewDismissHeadsUpExperiment() && !TrialFilter.getInstance().isTrial() && settings.getCaptchaInfo(fromIntent) == null && CurrentSleepRecord.getInstance().getRecord() == null;
            Logger.logDebug("AlarmReceiver: Heads up notification dismiss clicked. Skip activity: " + z);
            if (z) {
                Alarm.performDismiss(context, fromIntent, null, false);
                return;
            }
            Intent intent2 = new Intent(context, cls2);
            intent2.putExtra("intent.extra.alarm", (Serializable) fromIntent);
            intent2.putExtra("dissmis_or_captcha_extra", true);
            intent2.putExtra("CREATION_SOURCE", "AlarmReceiver-NOTIF-DISMISS");
            intent2.setFlags(872579072);
            context.startActivity(intent2);
            return;
        }
        if ("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE".equals(intent.getAction())) {
            Logger.logInfo("AlarmReceiver: ALARM_SNOOZE_ACTION");
            if (Alarm.isSnoozeEnabled(fromIntent)) {
                collapseNotifications(context);
                settings.resetAutoSnoozeRepeat();
                if (!settings.isAllowSnoozeTimeChange() || !intent.hasExtra("extra_snooze_time")) {
                    Alarm.performSnooze(context, fromIntent, Alarm.getSnoozeMinutes(fromIntent, false), false);
                    return;
                }
                int intExtra = intent.getIntExtra("extra_snooze_time", 3);
                if (intExtra > 60) {
                    intExtra = 60;
                }
                Alarm.performSnooze(context, fromIntent, intExtra >= 1 ? intExtra : 1, false);
                return;
            }
            return;
        }
        if ("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CAPTCHA".equals(intent.getAction())) {
            Logger.logInfo("AlarmReceiver: ALARM_DISMISS_CAPTCHA_ACTION");
            Intent intent3 = new Intent(context, cls2);
            intent3.putExtra("intent.extra.alarm", (Serializable) fromIntent);
            intent3.putExtra("dissmis_or_captcha_extra", true);
            intent3.putExtra("CREATION_SOURCE", "AlarmReceiver-NOTIF-DISMISS-STANDARD");
            intent3.setFlags(872546304);
            Logger.logDebug("AlarmReceiver: Normal notification dismiss clicked.");
            if (Build.VERSION.SDK_INT < 29) {
                context.startActivity(intent3);
                return;
            }
            if (AlarmAlertFullScreen.SHOWN) {
                context.startActivity(intent3);
                return;
            }
            if (settings.getCaptchaInfo(fromIntent) != null) {
                context.startActivity(intent3);
                return;
            }
            Logger.logDebug("AlarmReceiver: No captcha required, handle dismiss on Android Q without activity");
            new Settings(context).cleanLastNonSnoozeAlarm();
            ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CLICKED_ACTION"));
            Alarm.performDismiss(context, fromIntent, CurrentSleepRecord.getInstance().getRecord(), false);
            return;
        }
        if ("com.urbandroid.sleep.alarmclock.cancel_snooze".equals(intent.getAction())) {
            CaptchaInfo captchaInfo = settings.getCaptchaInfo(fromIntent);
            Logger.logInfo("AlarmReceiver: Cancelling snooze alarm. Captcha mode: " + captchaInfo);
            if (captchaInfo != null) {
                SharedApplicationContext.getCaptchaManager().getLauncher(fromIntent).operation("snooze_cancel").start(captchaInfo);
                return;
            }
            Alarms.saveSnoozeAlert(context, -1, -1L);
            Logger.logInfo("SnoozeRepeat: reset alarm receiver");
            settings.setWakeUpCheckScheduledAlarmId(-1L);
            settings.resetSnoozeRepeat();
            settings.resetWakeUpCheckRepeat();
            Intent intent4 = new Intent("com.urbandroid.sleep.alarmclock.cancel_snooze_finished");
            intent4.putExtra("alarm_id", fromIntent.id);
            ContextExtKt.sendExplicitBroadcast(context, intent4);
            return;
        }
        if ("com.urbandroid.sleep.alarmclock.cancel_snooze_no_captcha".equals(intent.getAction())) {
            Logger.logInfo("AlarmReceiver: WakeUpCheck: cancel snooze no captcha");
            Alarms.saveSnoozeAlert(context, -1, -1L);
            settings.setWakeUpCheckScheduledAlarmId(fromIntent.id);
            settings.resetWakeUpCheckRepeat();
            settings.resetSnoozeRepeat();
            Intent intent5 = new Intent("com.urbandroid.sleep.alarmclock.cancel_snooze_finished");
            intent5.putExtra("alarm_id", fromIntent.id);
            ContextExtKt.sendExplicitBroadcast(context, intent5);
            NotificationsKt.cancel(context, 28777382);
            settings.addAchievement(Achievement.Type.WAKE_UP_CHECK, 1);
            AlarmExtendedConfig alarmExtendedConfig = fromIntent.extendedConfig;
            if (alarmExtendedConfig == null || !alarmExtendedConfig.isSelfDisposable().booleanValue()) {
                return;
            }
            Logger.logInfo("WakeUpCheck: delayed alarm delete after wake up check");
            Alarms.deleteAlarm(context, fromIntent.id);
            return;
        }
        if ("com.urbandroid.sleep.alarmclock.ALARM_WAKE_UP_CHECK".equals(intent.getAction())) {
            Logger.logInfo("WakeUpCheck: show notification");
            Alarms.showWakeUpCheck(context, fromIntent, settings.getWakeUpCheckAfterNotification());
            return;
        }
        if ("com.urbandroid.sleep.alarmclock.alarm_killed".equals(intent.getAction())) {
            Logger.logDebug("AlarmReceiver: Received killed. Auto snooze repeat: " + settings.getAutoSnoozeRepeat() + " Max: " + settings.getAutoKillSnoozeMaxCount());
            settings.increaseAutoSnoozeRepeat();
            if (settings.getAutoSnoozeRepeat() <= settings.getAutoKillSnoozeMaxCount()) {
                Logger.logInfo("AlarmReceiver: SNOOZE after KILL");
                snoozeAfterKill(context, fromIntent);
            } else {
                settings.resetAutoSnoozeRepeat();
                Alarm.performDismiss(context, fromIntent, CurrentSleepRecord.getInstance().getRecord(), true);
            }
            updateNotification(context, fromIntent, intent.getIntExtra("alarm_killed_timeout", -1));
            return;
        }
        if (!Experiments.getInstance().isReliableAlarmExperiment() || !settings.isReliableAlarmScheduled()) {
            fromIntent.recompteOffsetOnAlarmFired(context);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Logger.logDebug("AlarmReceiver: onReceive() id " + fromIntent.id + " setFor " + new SimpleDateFormat("HH:mm:ss.SSS aaa").format(new Date(fromIntent.time)));
        if (jCurrentTimeMillis > fromIntent.time + 1800000) {
            Logger.logDebug("AlarmReceiver: ignoring stale alarm");
            return;
        }
        settings.updateLastNonSnoozeAlarm(System.currentTimeMillis());
        if (Experiments.getInstance().isReliableAlarmExperiment() && settings.isReliableAlarmScheduled()) {
            AlarmAlertWakeLock.acquireCpuWakeLock(context, 10000);
            return;
        }
        AlarmAlertWakeLock.acquireCpuWakeLock(context);
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (record != null) {
            record.addEventLabel(EventLabel.ALARM_STARTED, System.currentTimeMillis());
        }
        if (Build.VERSION.SDK_INT < 31) {
            try {
                context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            } catch (Exception unused) {
            }
        }
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        boolean zUseHeadupsNotification = useHeadupsNotification(context, settings, fromIntent);
        if (zUseHeadupsNotification) {
            Logger.logDebug("AlarmReceiver: Do not show AlarmActivity with headsup");
        } else {
            keyguardManager.inKeyguardRestrictedInputMode();
            if (AlarmKlaxon.isRunning() && (cls = AlarmAlertFullScreen.currentClass) != null) {
                cls2 = cls;
            }
            Intent intent6 = new Intent(context, cls2);
            intent6.putExtra("intent.extra.alarm", (Serializable) fromIntent);
            intent6.putExtra("CREATION_SOURCE", "AlarmReceiver-Main-Code");
            intent6.setFlags(268697600);
            Logger.logDebug("AlarmReceiver: Starting alarm alert service of class: " + cls2);
            context.startActivity(intent6);
            Logger.logDebug("AlarmReceiver: Starting alarm alert service of class: " + cls2 + " - Finished ");
        }
        Alarms.disableSnoozeAlert(context, fromIntent.id);
        Alarms.scheduleNewAlertAfterOldFinished(context, fromIntent);
        if (!intent.hasExtra("intent.extra.alarm_restarted") || !intent.getBooleanExtra("intent.extra.alarm_restarted", false)) {
            Intent intent7 = new Intent(context, (Class<?>) AlarmKlaxon.class);
            intent7.setAction("com.urbandroid.sleep.alarmclock.ALARM_ALERT");
            intent7.setPackage(context.getPackageName());
            intent7.putExtra("intent.extra.alarm", (Serializable) fromIntent);
            if (zUseHeadupsNotification) {
                intent7.putExtra("use_headsup_extra", true);
            }
            Logger.logInfo("AlarmReceiver: starting AlarmKlaxon");
            WakefulForegroundBroadcastReceiver.INSTANCE.startWakefulService(context, intent7);
        }
        Logger.logInfo("AlarmReceiver: ALARM START");
        ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.alarmclock.ALARM_ALERT_START"));
        Intent intent8 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_ALERT_START_INTERNAL");
        intent8.putExtra("intent.extra.alarm", (Serializable) fromIntent);
        ContextExtKt.sendExplicitBroadcast(context, intent8);
        AlarmStatusReceiver.alarmIsRinging = true;
    }
}
