package com.urbandroid.sleep.captcha.domain;

import java.util.Comparator;

/* JADX INFO: loaded from: classes4.dex */
public interface CaptchaInfo {
    public static final Comparator<CaptchaInfo> ORDER_COMPARATOR = new Comparator<CaptchaInfo>() { // from class: com.urbandroid.sleep.captcha.domain.CaptchaInfo.1
        @Override // java.util.Comparator
        public int compare(CaptchaInfo captchaInfo, CaptchaInfo captchaInfo2) {
            if (captchaInfo == captchaInfo2) {
                return 0;
            }
            if (captchaInfo == null) {
                return 1;
            }
            if (captchaInfo2 == null) {
                return -1;
            }
            return Integer.valueOf(captchaInfo.getOrder()).compareTo(Integer.valueOf(captchaInfo2.getOrder()));
        }
    };

    String getActivityName();

    String getConfigActivityName();

    int getId();

    String getLabel();

    int getOrder();

    String getPackageName();

    boolean hasDifficulty();

    boolean isConfigurable();
}
