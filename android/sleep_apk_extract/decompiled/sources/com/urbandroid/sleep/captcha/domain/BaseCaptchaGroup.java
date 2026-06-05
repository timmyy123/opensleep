package com.urbandroid.sleep.captcha.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BaseCaptchaGroup implements CaptchaGroup {
    private final List<CaptchaInfo> captchaInfos;
    private final boolean externalStorage;
    private final String id;
    private final String label;

    public BaseCaptchaGroup(String str, String str2, List<CaptchaInfo> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        this.captchaInfos = arrayList;
        this.id = str;
        this.label = str2;
        this.externalStorage = z;
        arrayList.addAll(list);
    }

    @Override // com.urbandroid.sleep.captcha.domain.CaptchaGroup
    public BaseCaptchaGroup add(CaptchaInfo captchaInfo) {
        this.captchaInfos.add(captchaInfo);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.id.equals(((BaseCaptchaGroup) obj).id);
    }

    @Override // com.urbandroid.sleep.captcha.domain.CaptchaGroup
    public List<CaptchaInfo> getCaptchaInfos() {
        return this.captchaInfos;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public BaseCaptchaGroup(String str, String str2, boolean z) {
        this(str, str2, Collections.EMPTY_LIST, z);
    }
}
