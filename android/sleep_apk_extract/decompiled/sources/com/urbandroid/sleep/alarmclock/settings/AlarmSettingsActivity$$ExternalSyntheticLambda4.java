package com.urbandroid.sleep.alarmclock.settings;

import android.content.Context;
import android.preference.Preference;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.share.IShareService;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AlarmSettingsActivity$$ExternalSyntheticLambda4 implements Preference.OnPreferenceClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ AlarmSettingsActivity$$ExternalSyntheticLambda4(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public final boolean onPreferenceClick(Preference preference) {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                return ((AlarmSettingsActivity) obj2).lambda$refresh$2((Preference) obj, preference);
            case 1:
                return ((AlarmSettingsActivity) obj2).lambda$refresh$4((PreferenceActivity) obj, preference);
            case 2:
                return AutomationSettingsActivity.refresh$lambda$4((AutomationSettingsActivity) obj2, (Context) obj, preference);
            case 3:
                return ((CaptchaSettingsActivity) obj2).lambda$refresh$6((PreferenceActivity) obj, preference);
            case 4:
                return GoogleHomeAutomationSettingsActivity.refresh$lambda$1$0((String) obj2, (GoogleHomeAutomationSettingsActivity) obj, preference);
            case 5:
                return ((LullabySettingsActivity) obj2).lambda$refresh$8((PreferenceActivity) obj, preference);
            case 6:
                return ((NoiseSettingsActivity) obj2).lambda$refresh$4((Settings) obj, preference);
            case 7:
                return ((NoiseSettingsActivity) obj2).lambda$refresh$10((PreferenceActivity) obj, preference);
            case 8:
                return ((SmartLightSettingsActivity) obj2).lambda$refresh$2((PreferenceActivity) obj, preference);
            case 9:
                return ((SmartwatchSettingsActivity) obj2).lambda$refresh$3((PreferenceActivity) obj, preference);
            case 10:
                return SocialSettingsActivity.lambda$initSharePreference$0((IShareService) obj2, (Preference) obj, preference);
            default:
                return ((TrackSettingsActivity) obj2).lambda$refresh$2((PreferenceActivity) obj, preference);
        }
    }
}
