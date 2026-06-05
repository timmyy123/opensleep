package com.urbandroid.sleep.captcha;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CaptchaSupportHolder {
    private static CaptchaSupport captchaSupport;

    public static CaptchaSupport get() {
        return captchaSupport;
    }

    public static void set(CaptchaSupport captchaSupport2) {
        captchaSupport = captchaSupport2;
    }
}
