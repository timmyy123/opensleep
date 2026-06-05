package com.urbandroid.sleep.captcha.finder.filter;

import android.content.Context;
import com.urbandroid.sleep.captcha.domain.CaptchaGroup;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.captcha.finder.CaptchaInfoFilter;

/* JADX INFO: loaded from: classes4.dex */
public class PackageCaptchaInfoFilter implements CaptchaInfoFilter {
    private final String packageName;

    public PackageCaptchaInfoFilter(Context context) {
        this.packageName = context.getPackageName();
    }

    @Override // com.urbandroid.sleep.captcha.finder.CaptchaInfoFilter
    public boolean apply(CaptchaGroup captchaGroup, CaptchaInfo captchaInfo) {
        return captchaInfo != null && this.packageName.equals(captchaInfo.getPackageName());
    }

    public PackageCaptchaInfoFilter(String str) {
        this.packageName = str;
    }
}
