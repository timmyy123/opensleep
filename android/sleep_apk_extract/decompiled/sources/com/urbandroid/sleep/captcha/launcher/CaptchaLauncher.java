package com.urbandroid.sleep.captcha.launcher;

import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.captcha.intent.IntentExtraSetter;

/* JADX INFO: loaded from: classes4.dex */
public interface CaptchaLauncher {
    CaptchaLauncher addFlags(int i);

    CaptchaLauncher difficulty(int i);

    CaptchaLauncher extraSetter(IntentExtraSetter intentExtraSetter);

    CaptchaLauncher mode(int i);

    CaptchaLauncher operation(String str);

    void start(CaptchaInfo captchaInfo);
}
