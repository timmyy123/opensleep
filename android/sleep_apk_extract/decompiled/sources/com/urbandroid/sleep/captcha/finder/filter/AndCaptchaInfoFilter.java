package com.urbandroid.sleep.captcha.finder.filter;

import com.urbandroid.sleep.captcha.domain.CaptchaGroup;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.captcha.finder.CaptchaInfoFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AndCaptchaInfoFilter implements CaptchaInfoFilter {
    private final List<CaptchaInfoFilter> filters;

    public AndCaptchaInfoFilter(CaptchaInfoFilter... captchaInfoFilterArr) {
        ArrayList arrayList = new ArrayList();
        this.filters = arrayList;
        arrayList.addAll(Arrays.asList(captchaInfoFilterArr));
    }

    @Override // com.urbandroid.sleep.captcha.finder.CaptchaInfoFilter
    public boolean apply(CaptchaGroup captchaGroup, CaptchaInfo captchaInfo) {
        Iterator<CaptchaInfoFilter> it = this.filters.iterator();
        while (it.hasNext()) {
            if (!it.next().apply(captchaGroup, captchaInfo)) {
                return false;
            }
        }
        return true;
    }
}
