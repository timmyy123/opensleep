package com.urbandroid.sleep.captcha.finder;

import com.urbandroid.sleep.captcha.domain.CaptchaGroup;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface CaptchaFinder {
    CaptchaInfo findById(int i);

    List<CaptchaGroup> findGroups(CaptchaInfoFilter captchaInfoFilter);

    List<CaptchaInfo> lookup(CaptchaInfoFilter captchaInfoFilter);
}
