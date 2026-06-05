package com.urbandroid.sleep.captcha.finder.filter;

import com.urbandroid.sleep.captcha.domain.CaptchaGroup;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.captcha.finder.CaptchaInfoFilter;

/* JADX INFO: loaded from: classes4.dex */
public class IdCaptchaInfoFilter implements CaptchaInfoFilter {
    private final int id;

    public IdCaptchaInfoFilter(int i) {
        this.id = i;
    }

    @Override // com.urbandroid.sleep.captcha.finder.CaptchaInfoFilter
    public boolean apply(CaptchaGroup captchaGroup, CaptchaInfo captchaInfo) {
        return captchaInfo != null && captchaInfo.getId() == this.id;
    }
}
