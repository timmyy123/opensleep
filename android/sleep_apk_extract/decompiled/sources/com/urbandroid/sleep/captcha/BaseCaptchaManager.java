package com.urbandroid.sleep.captcha;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.captcha.finder.CachedCaptchaFinder;
import com.urbandroid.sleep.captcha.finder.CaptchaFinder;
import com.urbandroid.sleep.captcha.launcher.BaseCaptchaLauncher;
import com.urbandroid.sleep.captcha.launcher.CaptchaLauncher;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class BaseCaptchaManager implements CaptchaManager {
    private final Context context;
    private final CaptchaFinder finder;

    public BaseCaptchaManager(Context context) {
        this.context = context;
        this.finder = new CachedCaptchaFinder(context);
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaManager
    public CaptchaFinder getFinder() {
        return this.finder;
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaManager
    public CaptchaLauncher getLauncher(final Alarm alarm) {
        return new BaseCaptchaLauncher(this.context, AlarmAlertFullScreen.class.getName(), null) { // from class: com.urbandroid.sleep.captcha.BaseCaptchaManager.2
            @Override // com.urbandroid.sleep.captcha.launcher.BaseCaptchaLauncher
            public Intent prepareIntent(CaptchaInfo captchaInfo) {
                int captchaSuppressMode = SharedApplicationContext.getSettings().getCaptchaSuppressMode(captchaInfo);
                callbackIntentCreator(new SleepCallbackIntentCreator(alarm));
                suppressAlarmMode(captchaSuppressMode);
                return super.prepareIntent(captchaInfo);
            }

            @Override // com.urbandroid.sleep.captcha.launcher.BaseCaptchaLauncher, com.urbandroid.sleep.captcha.launcher.CaptchaLauncher
            public void start(CaptchaInfo captchaInfo) {
                difficulty(SharedApplicationContext.getSettings().getCaptchaDifficulty(captchaInfo));
                super.start(captchaInfo);
                Log.i("captcha-support", "suppressAlarmMode: " + this.suppressAlarmMode);
                if (this.mode == 1 && this.suppressAlarmMode > 0 && "no_operation".equals(this.operation)) {
                    Log.i("captcha-support", "Starting service ALARM_ALERT_SUSPEND ...");
                    zza$$ExternalSyntheticOutline0.m(this.context, "com.urbandroid.sleep.alarmclock.ALARM_SUSPEND");
                }
            }
        };
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaManager
    public CaptchaLauncher getLauncher() {
        return new BaseCaptchaLauncher(this.context, AlarmAlertFullScreen.class.getName(), null) { // from class: com.urbandroid.sleep.captcha.BaseCaptchaManager.1
            @Override // com.urbandroid.sleep.captcha.launcher.BaseCaptchaLauncher
            public Intent prepareIntent(CaptchaInfo captchaInfo) {
                suppressAlarmMode(SharedApplicationContext.getSettings().getCaptchaSuppressMode(captchaInfo));
                return super.prepareIntent(captchaInfo);
            }

            @Override // com.urbandroid.sleep.captcha.launcher.BaseCaptchaLauncher, com.urbandroid.sleep.captcha.launcher.CaptchaLauncher
            public void start(CaptchaInfo captchaInfo) {
                difficulty(SharedApplicationContext.getSettings().getCaptchaDifficulty(captchaInfo));
                super.start(captchaInfo);
            }
        };
    }
}
