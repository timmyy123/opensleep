package com.urbandroid.sleep.alarmclock.settings;

import android.preference.Preference;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MiscSettingsActivity$$ExternalSyntheticLambda0 implements Preference.OnPreferenceClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SimpleSettingsActivity f$0;

    public /* synthetic */ MiscSettingsActivity$$ExternalSyntheticLambda0(SimpleSettingsActivity simpleSettingsActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = simpleSettingsActivity;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public final boolean onPreferenceClick(Preference preference) {
        int i = this.$r8$classId;
        SimpleSettingsActivity simpleSettingsActivity = this.f$0;
        switch (i) {
            case 0:
                return ((MiscSettingsActivity) simpleSettingsActivity).lambda$refresh$0(preference);
            case 1:
                return ((AlarmSettingsActivity) simpleSettingsActivity).lambda$refresh$3(preference);
            case 2:
                return CaptchaWakeUpCheckSettingsActivity.refresh$lambda$2((CaptchaWakeUpCheckSettingsActivity) simpleSettingsActivity, preference);
            case 3:
                return ((GentleSettingsActivity) simpleSettingsActivity).lambda$refresh$0(preference);
            case 4:
                return ((LucidSettingsActivity) simpleSettingsActivity).lambda$refresh$0(preference);
            case 5:
                return ((PairSettingsActivity) simpleSettingsActivity).lambda$refresh$0(preference);
            case 6:
                return simpleSettingsActivity.lambda$refresh$2(preference);
            case 7:
                return ((SmartLightSettingsActivity) simpleSettingsActivity).lambda$refresh$1(preference);
            case 8:
                return ((SmartSettingsActivity) simpleSettingsActivity).lambda$refresh$0(preference);
            case 9:
                return ((StatsSettingsActivity) simpleSettingsActivity).lambda$refresh$0(preference);
            case 10:
                return ((TrackAutoSettingsActivity) simpleSettingsActivity).lambda$refresh$0(preference);
            default:
                return ((TrackSettingsActivity) simpleSettingsActivity).lambda$refresh$0(preference);
        }
    }
}
