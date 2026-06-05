package com.urbandroid.sleep.alarmclock.settings;

import android.preference.Preference;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BedtimeSettingsActivity$$ExternalSyntheticLambda1 implements Preference.OnPreferenceChangeListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ BedtimeSettingsActivity$$ExternalSyntheticLambda1(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference preference, Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                return BedtimeSettingsActivity.refresh$lambda$1((BedtimeSettingsActivity) obj2, preference, obj);
            case 1:
                return BedtimeNoAlarmSettingsActivity.refresh$lambda$1((BedtimeNoAlarmSettingsActivity) obj2, preference, obj);
            case 2:
                return CaptchaCheatingSettingsActivity.refresh$lambda$2$0((CaptchaCheatingSettingsActivity) obj2, preference, obj);
            case 3:
                return CaptchaSettingsActivity.lambda$refresh$5((Settings) obj2, preference, obj);
            case 4:
                return CaptchaWakeUpCheckSettingsActivity.refresh$lambda$1((CaptchaWakeUpCheckSettingsActivity) obj2, preference, obj);
            case 5:
                return ((LullabySettingsActivity) obj2).lambda$refresh$7(preference, obj);
            default:
                return SmartwatchSettingsActivity.lambda$refresh$5((PreferenceActivity) obj2, preference, obj);
        }
    }
}
