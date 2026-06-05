package com.urbandroid.sleep.captcha;

import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.captcha.finder.CaptchaFinder;
import com.urbandroid.sleep.captcha.launcher.CaptchaLauncher;

/* JADX INFO: loaded from: classes4.dex */
public interface CaptchaManager {
    CaptchaFinder getFinder();

    CaptchaLauncher getLauncher();

    CaptchaLauncher getLauncher(Alarm alarm);
}
