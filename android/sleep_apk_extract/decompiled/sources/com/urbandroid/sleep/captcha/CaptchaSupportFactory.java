package com.urbandroid.sleep.captcha;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.sleep.captcha.util.IntentUtil;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CaptchaSupportFactory {
    public static CaptchaSupport create(Activity activity, Intent intent, int i) {
        String localClassName = activity.getLocalClassName();
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(localClassName, ": ");
        sbM.append(IntentUtil.traceIntent(intent));
        Log.d("captcha-support", sbM.toString());
        if (CaptchaSupportHolder.get() != null) {
            CaptchaSupportHolder.get().destroy();
        }
        if (intent != null) {
            Log.d("captcha-support", "Child Captcha Id:" + intent.getIntExtra("captchaInfo", -1));
        }
        boolean z = false;
        boolean z2 = intent != null && "com.urbandroid.sleep.captcha.intent.action.OPEN".equals(intent.getAction());
        boolean z3 = intent != null && "com.urbandroid.sleep.captcha.intent.action.CONFIG".equals(intent.getAction());
        if (intent != null && intent.hasExtra("originIntent")) {
            z = true;
        }
        if (z2 || z3 || z) {
            if (z) {
                intent = (Intent) intent.getParcelableExtra("originIntent");
            }
            BaseCaptchaSupport baseCaptchaSupport = new BaseCaptchaSupport(activity, intent, i);
            baseCaptchaSupport.alive();
            CaptchaSupportHolder.set(baseCaptchaSupport);
            Log.i("captcha-support", localClassName + ": Captcha support created (alive timeout:" + i + ")");
            return baseCaptchaSupport;
        }
        Log.w("captcha-support", localClassName + ": Creating FAKE PREVIEW captcha support since it is activity with no captcha launch action (com.urbandroid.sleep.captcha.intent.action.OPEN)");
        FallbackPreviewCaptchaSupport fallbackPreviewCaptchaSupport = new FallbackPreviewCaptchaSupport(activity, i);
        CaptchaSupportHolder.set(fallbackPreviewCaptchaSupport);
        Log.i("captcha-support", localClassName + ": Captcha support created (alive timeout:" + i + ")");
        return fallbackPreviewCaptchaSupport;
    }

    public static CaptchaSupport create(Activity activity) {
        return create(activity, activity.getIntent(), IntentUtil.resolveTimeout(activity.getIntent()));
    }
}
