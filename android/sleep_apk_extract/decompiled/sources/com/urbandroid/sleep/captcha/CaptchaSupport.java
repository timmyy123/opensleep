package com.urbandroid.sleep.captcha;

import com.urbandroid.sleep.captcha.launcher.CaptchaLauncher;

/* JADX INFO: loaded from: classes4.dex */
public interface CaptchaSupport {
    void alive();

    void destroy();

    int getDifficulty();

    CaptchaLauncher getLauncher();

    int getMode();

    boolean isConfigurationMode();

    boolean isOperationalMode();

    boolean isPreviewMode();

    CaptchaSupport setRemainingTimeListener(RemainingTimeListener remainingTimeListener);

    void solved();

    void unsolved();
}
