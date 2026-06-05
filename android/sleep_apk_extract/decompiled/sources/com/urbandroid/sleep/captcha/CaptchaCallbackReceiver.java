package com.urbandroid.sleep.captcha;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.SetAlarm;
import com.urbandroid.sleep.captcha.util.IntentUtil;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class CaptchaCallbackReceiver extends BroadcastReceiver {
    public static String CAPTCHA_ACTION_START = "com.urbandroid.sleep.captcha.intent.action.START";
    public static String CAPTCHA_ACTION_STOP = "com.urbandroid.sleep.captcha.intent.action.STOP";
    public static String CAPTCHA_ACTION_UPDATE = "com.urbandroid.sleep.captcha.intent.action.UPDATE";

    private NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService("notification");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        GlobalInitializator.initializeIfRequired(context);
        Logger.logInfo("captcha-support: Captcha back call:" + IntentUtil.traceIntent(intent));
        String action = intent.getAction();
        if (CAPTCHA_ACTION_STOP.equals(action)) {
            Logger.logInfo("captcha-support: Captcha STOP");
            AlarmAlertFullScreen.CAPTCHA_IN_PROGRESS = false;
            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(CAPTCHA_ACTION_UPDATE));
            return;
        }
        if (CAPTCHA_ACTION_START.equals(action)) {
            Logger.logInfo("captcha-support: Captcha START");
            AlarmAlertFullScreen.CAPTCHA_IN_PROGRESS = true;
            LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(CAPTCHA_ACTION_UPDATE));
            return;
        }
        int captchaSuppressMode = SharedApplicationContext.getSettings().getCaptchaSuppressMode();
        if ("com.urbandroid.sleep.captcha.intent.action.ALIVE".equals(action)) {
            if (captchaSuppressMode > 0) {
                Logger.logInfo("captcha-support: current suppressAlarmMode: " + captchaSuppressMode);
                ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.ACTION_DELAY_RESUMER").putExtras(intent));
                return;
            }
            return;
        }
        if (!"com.urbandroid.sleep.captcha.intent.action.ALIVE".equals(action)) {
            Logger.logInfo("SnoozeRepeat: reset captcha callback");
            Settings settings = SharedApplicationContext.getSettings();
            settings.resetSnoozeRepeat();
            Logger.logInfo("captcha-support: reset captcha solved time");
            settings.setLastCaptchaSolvedTimestampNow();
        }
        Alarm fromIntent = Alarm.parseFromIntent(intent);
        Logger.logInfo("captcha-support: Alarm:" + Alarm.toDebugString(fromIntent));
        if (intent.hasExtra("snooze_cancel")) {
            Alarms.saveSnoozeAlert(context, -1, -1L);
            SharedApplicationContext.getSettings().resetWakeUpCheckRepeat();
            if (fromIntent != null) {
                if (fromIntent.extendedConfig.isSelfDisposable().booleanValue()) {
                    Alarms.deleteAlarm(context, fromIntent.id);
                }
                getNotificationManager(context).cancel(fromIntent.id);
            }
            Intent intent2 = new Intent("com.urbandroid.sleep.alarmclock.cancel_snooze_finished");
            if (fromIntent != null) {
                intent2.putExtra("alarm_id", fromIntent.id);
            }
            ContextExtKt.sendExplicitBroadcast(context, intent2);
        }
        if (intent.hasExtra("delete_alarm")) {
            Alarms.saveSnoozeAlert(context, -1, -1L);
            if (fromIntent != null) {
                Alarms.deleteAlarm(context, fromIntent.id);
                getNotificationManager(context).cancel(fromIntent.id);
            }
            Intent intent3 = new Intent("com.urbandroid.sleep.alarmclock.cancel_snooze_finished");
            if (fromIntent != null) {
                intent3.putExtra("alarm_id", fromIntent.id);
            }
            ContextExtKt.sendExplicitBroadcast(context, intent3);
        }
        if (intent.hasExtra("edit_alarm") && fromIntent != null) {
            Intent intent4 = new Intent(context, (Class<?>) SetAlarm.class);
            intent4.putExtra("alarm_id", fromIntent.id);
            if (intent.hasExtra("edit_alarm_time_extra")) {
                intent4.putExtra("set_time_extra", true);
            }
            intent4.addFlags(ClientDefaults.MAX_MSG_SIZE);
            Logger.logInfo("captcha-support: EDIT_ALARM call:" + IntentUtil.traceIntent(intent4));
            context.startActivity(intent4);
        }
        if (intent.hasExtra("disable_alarm")) {
            Alarms.saveSnoozeAlert(context, -1, -1L);
            if (fromIntent != null) {
                Alarms.enableAlarm(context, fromIntent.id, true ^ fromIntent.enabled);
                getNotificationManager(context).cancel(fromIntent.id);
            }
            Intent intent5 = new Intent("com.urbandroid.sleep.alarmclock.cancel_snooze_finished");
            if (fromIntent != null) {
                intent5.putExtra("alarm_id", fromIntent.id);
            }
            ContextExtKt.sendExplicitBroadcast(context, intent5);
        }
        if (intent.hasExtra("should_skip")) {
            Alarms.skipNextAlarm(context, fromIntent);
        }
    }
}
