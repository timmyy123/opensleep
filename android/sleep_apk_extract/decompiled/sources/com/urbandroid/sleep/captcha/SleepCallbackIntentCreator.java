package com.urbandroid.sleep.captcha;

import android.content.Context;
import android.content.Intent;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen;
import com.urbandroid.sleep.captcha.intent.CallbackIntentCreator;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class SleepCallbackIntentCreator implements CallbackIntentCreator {
    private final Alarm alarm;

    public SleepCallbackIntentCreator(Alarm alarm) {
        this.alarm = alarm;
    }

    private Intent prepareIntent(Context context, String str, boolean z) {
        boolean zEquals = "no_operation".equals(str);
        Intent intent = new Intent(context, (Class<?>) (zEquals ? AlarmAlertFullScreen.class : CaptchaCallbackReceiver.class));
        if (zEquals) {
            intent.addFlags(131072);
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        }
        Alarm alarm = this.alarm;
        if (alarm != null) {
            intent.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        } else {
            Logger.logWarning("Captcha: No alarm in captcha");
        }
        if (zEquals) {
            intent.putExtra(z ? "captcha_result_success" : "captcha_result_left", true);
        }
        return intent;
    }

    @Override // com.urbandroid.sleep.captcha.intent.CallbackIntentCreator
    public Intent createSolvedIntent(Context context, String str) {
        return prepareIntent(context, str, true);
    }

    @Override // com.urbandroid.sleep.captcha.intent.CallbackIntentCreator
    public Intent createUnsolvedIntent(Context context, String str) {
        return prepareIntent(context, str, false);
    }
}
