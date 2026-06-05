package com.urbandroid.sleep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/SkipNextAlarmActivity;", "Landroid/app/Activity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SkipNextAlarmActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        Intent intent = getIntent();
        if (intent != null) {
            Alarm fromIntent = Alarm.parseFromIntent(intent);
            if (fromIntent != null) {
                if (Intrinsics.areEqual("com.urbandroid.sleep.alarmclock.cancel_snooze", intent.getAction())) {
                    CaptchaInfo captchaInfo = SharedApplicationContext.getSettings().getCaptchaInfo(fromIntent);
                    Logger.logInfo("AlarmReceiver: SkipNextAlarmActivity Cancelling snooze alarm. Captcha mode: " + captchaInfo);
                    if (captchaInfo == null) {
                        Alarms.saveSnoozeAlert(this, -1, -1L);
                        Logger.logInfo("SnoozeRepeat: SkipNextAlarmActivity reset alarm receiver");
                        SharedApplicationContext.getSettings().resetWakeUpCheckRepeat();
                        SharedApplicationContext.getSettings().resetSnoozeRepeat();
                        Intent intent2 = new Intent("com.urbandroid.sleep.alarmclock.cancel_snooze_finished");
                        intent2.putExtra("alarm_id", fromIntent.id);
                        ContextExtKt.sendExplicitBroadcast$default(this, intent2, null, 2, null);
                    } else {
                        SharedApplicationContext.getCaptchaManager().getLauncher(fromIntent).operation("snooze_cancel").start(captchaInfo);
                    }
                } else if (Intrinsics.areEqual("com.urbandroid.sleep.alarmclock.SKIP_NEXT_ALARM_ACTION", intent.getAction())) {
                    Logger.logInfo("AlarmReceiver: SkipNextAlarmActivity Skipping next alarm");
                    Alarm alarmCalculateNextAlert = Alarms.calculateNextAlert(this);
                    if (alarmCalculateNextAlert == null || alarmCalculateNextAlert.time != fromIntent.time) {
                        Logger.logInfo("AlarmReceiver: SkipNextAlarmActivity Not skipping as next alarm date differs from what we thing it should be: " + alarmCalculateNextAlert + " vs " + new Date(fromIntent.time));
                        finish();
                        return;
                    }
                    Alarms.skipAlarmOrShowCaptcha(this, fromIntent);
                }
            }
            finish();
        }
    }
}
