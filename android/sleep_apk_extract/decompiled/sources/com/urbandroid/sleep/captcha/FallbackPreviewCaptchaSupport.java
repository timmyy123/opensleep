package com.urbandroid.sleep.captcha;

import android.app.Activity;

/* JADX INFO: loaded from: classes4.dex */
public class FallbackPreviewCaptchaSupport extends AbstractCaptchaSupport {
    public FallbackPreviewCaptchaSupport(Activity activity, int i) {
        super(activity, null, i);
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaSupport
    public void doAlive() {
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaSupport, com.urbandroid.sleep.captcha.CaptchaSupport
    public boolean isOperationalMode() {
        return false;
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaSupport
    public void solved() {
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaSupport
    public void unsolved() {
    }
}
