package com.urbandroid.sleep.captcha.domain;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface CaptchaGroup {
    CaptchaGroup add(CaptchaInfo captchaInfo);

    List<CaptchaInfo> getCaptchaInfos();
}
