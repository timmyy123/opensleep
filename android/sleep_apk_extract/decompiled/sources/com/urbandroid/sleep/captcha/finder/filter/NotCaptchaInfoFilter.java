package com.urbandroid.sleep.captcha.finder.filter;

import com.urbandroid.sleep.captcha.domain.CaptchaGroup;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.captcha.finder.CaptchaInfoFilter;

/* JADX INFO: loaded from: classes4.dex */
public class NotCaptchaInfoFilter implements CaptchaInfoFilter {
    private final CaptchaInfoFilter filter;

    public NotCaptchaInfoFilter(CaptchaInfoFilter captchaInfoFilter) {
        this.filter = captchaInfoFilter;
    }

    @Override // com.urbandroid.sleep.captcha.finder.CaptchaInfoFilter
    public boolean apply(CaptchaGroup captchaGroup, CaptchaInfo captchaInfo) {
        return !this.filter.apply(captchaGroup, captchaInfo);
    }
}
