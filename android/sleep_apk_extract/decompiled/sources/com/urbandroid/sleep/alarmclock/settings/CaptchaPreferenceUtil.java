package com.urbandroid.sleep.alarmclock.settings;

import android.content.Context;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.gui.DefaultValueListPreference;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CaptchaPreferenceUtil {
    public static String getSummary(Context context, int i, int i2) {
        String string;
        Settings settings = new Settings(context);
        int defaultCaptchaId = settings.getDefaultCaptchaId();
        if (i == -1 && defaultCaptchaId != -1) {
            return getSummary(context, settings.getDefaultCaptchaId(), i2);
        }
        if (i == 0) {
            string = context.getString(R.string.disabled);
        } else {
            CaptchaInfo captchaInfo = settings.getCaptchaInfo(i);
            if (captchaInfo == null) {
                captchaInfo = settings.getCaptchaInfo(1);
            }
            string = captchaInfo == null ? context.getString(R.string.disabled) : captchaInfo.getLabel();
        }
        if (i != defaultCaptchaId) {
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(string, "   ");
            sbM.append(DefaultValueListPreference.getDefaultPrefix(context));
            sbM.append(" ");
            sbM.append(getSummary(context, settings.getDefaultCaptchaId(), i2));
            return sbM.toString();
        }
        if (i2 == -1) {
            return string;
        }
        StringBuilder sbM2 = Fragment$$ExternalSyntheticOutline1.m(string, "\n\n");
        sbM2.append(context.getString(R.string.captcha_preference_summary));
        return sbM2.toString();
    }

    public static String getSummary(Context context, int i) {
        return getSummary(context, i, -1);
    }
}
