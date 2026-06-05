package com.urbandroid.sleep.captcha.domain;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;

/* JADX INFO: loaded from: classes4.dex */
public class BaseCaptchaInfo implements CaptchaInfo {
    private final String activityName;
    private String configActivityName;
    private transient String forCaptcha;
    private final boolean hasDifficulty;
    private final int id;
    private final boolean isExternal;
    private final String label;
    private final int order;
    private final String packageName;

    private BaseCaptchaInfo(Context context, ActivityInfo activityInfo, String str) {
        Bundle bundle;
        String str2 = activityInfo.packageName;
        this.packageName = str2;
        String str3 = activityInfo.name;
        this.activityName = str3;
        this.label = str;
        boolean zEquals = context.getPackageName().equals(str2);
        this.isExternal = !zEquals;
        boolean zEquals2 = "com.urbandroid.sleep".equals(str2);
        if ((zEquals || zEquals2) && (bundle = activityInfo.metaData) != null && bundle.containsKey("com.urbandroid.sleep.captcha.meta.id")) {
            this.id = activityInfo.metaData.getInt("com.urbandroid.sleep.captcha.meta.id");
        } else {
            this.id = (str2 + str3).hashCode();
        }
        Bundle bundle2 = activityInfo.metaData;
        this.hasDifficulty = bundle2 != null && bundle2.getBoolean("com.urbandroid.sleep.captcha.meta.has_difficulty");
        Bundle bundle3 = activityInfo.metaData;
        int i = Integer.MAX_VALUE;
        int iAbs = bundle3 != null ? Math.abs(bundle3.getInt("com.urbandroid.sleep.captcha.meta.order")) : Integer.MAX_VALUE;
        Bundle bundle4 = activityInfo.metaData;
        this.forCaptcha = bundle4 != null ? bundle4.getString("com.urbandroid.sleep.captcha.meta.for_captcha") : null;
        if (zEquals && iAbs != 0) {
            i = iAbs;
        }
        this.order = i;
    }

    public static BaseCaptchaInfo build(Context context, ActivityInfo activityInfo, String str) {
        return new BaseCaptchaInfo(context, activityInfo, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.id == ((BaseCaptchaInfo) obj).id;
    }

    @Override // com.urbandroid.sleep.captcha.domain.CaptchaInfo
    public String getActivityName() {
        return this.activityName;
    }

    @Override // com.urbandroid.sleep.captcha.domain.CaptchaInfo
    public String getConfigActivityName() {
        return this.configActivityName;
    }

    public String getForCaptcha() {
        return this.forCaptcha;
    }

    @Override // com.urbandroid.sleep.captcha.domain.CaptchaInfo
    public int getId() {
        return this.id;
    }

    @Override // com.urbandroid.sleep.captcha.domain.CaptchaInfo
    public String getLabel() {
        return this.label;
    }

    @Override // com.urbandroid.sleep.captcha.domain.CaptchaInfo
    public int getOrder() {
        return this.order;
    }

    @Override // com.urbandroid.sleep.captcha.domain.CaptchaInfo
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.urbandroid.sleep.captcha.domain.CaptchaInfo
    public boolean hasDifficulty() {
        return this.hasDifficulty;
    }

    public int hashCode() {
        return this.id;
    }

    @Override // com.urbandroid.sleep.captcha.domain.CaptchaInfo
    public boolean isConfigurable() {
        return this.configActivityName != null;
    }

    public void setConfigActivityName(String str) {
        this.configActivityName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Captcha Info{id=");
        sb.append(this.id);
        sb.append(", packageName='");
        sb.append(this.packageName);
        sb.append("', activityName='");
        sb.append(this.activityName);
        sb.append("', label='");
        sb.append(this.label);
        sb.append("', configActivityName='");
        sb.append(this.configActivityName);
        sb.append("', hasDifficulty='");
        sb.append(this.hasDifficulty);
        sb.append("', isExternal=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.isExternal, '}');
    }
}
