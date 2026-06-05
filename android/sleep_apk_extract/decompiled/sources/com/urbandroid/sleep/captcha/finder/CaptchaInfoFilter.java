package com.urbandroid.sleep.captcha.finder;

import com.urbandroid.sleep.captcha.domain.CaptchaGroup;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;

/* JADX INFO: loaded from: classes4.dex */
public interface CaptchaInfoFilter {
    boolean apply(CaptchaGroup captchaGroup, CaptchaInfo captchaInfo);
}
