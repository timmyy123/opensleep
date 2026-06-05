package com.urbandroid.sleep.alarmclock.settings;

import android.preference.Preference;
import com.urbandroid.sleep.gui.PreferenceActivity;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MiscSettingsActivity$$ExternalSyntheticLambda1 implements Preference.OnPreferenceClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ PreferenceActivity f$0;

    public /* synthetic */ MiscSettingsActivity$$ExternalSyntheticLambda1(PreferenceActivity preferenceActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = preferenceActivity;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public final boolean onPreferenceClick(Preference preference) {
        int i = this.$r8$classId;
        PreferenceActivity preferenceActivity = this.f$0;
        switch (i) {
            case 0:
                return MiscSettingsActivity.lambda$refresh$1(preferenceActivity, preference);
            case 1:
                return AlarmSettingsActivity.lambda$refresh$8(preferenceActivity, preference);
            case 2:
                return AlarmSettingsActivity.lambda$refresh$9(preferenceActivity, preference);
            case 3:
                return AlarmSettingsActivity.lambda$refresh$5(preferenceActivity, preference);
            case 4:
                return AlarmSettingsActivity.lambda$refresh$7(preferenceActivity, preference);
            case 5:
                return AutomationSettingsActivity.refresh$lambda$0(preferenceActivity, preference);
            case 6:
                return AutomationSettingsActivity.refresh$lambda$2(preferenceActivity, preference);
            case 7:
                return BackupAlarmSettingsActivity.lambda$refresh$0(preferenceActivity, preference);
            case 8:
                return BedtimeNoAlarmSettingsActivity.refresh$lambda$0(preferenceActivity, preference);
            case 9:
                return BedtimeSettingsActivity.refresh$lambda$5(preferenceActivity, preference);
            case 10:
                return CaptchaCheatingSettingsActivity.refresh$lambda$3(preferenceActivity, preference);
            case 11:
                return CaptchaWakeUpCheckSettingsActivity.refresh$lambda$0(preferenceActivity, preference);
            case 12:
                return GentleSettingsActivity.lambda$refresh$1(preferenceActivity, preference);
            case 13:
                return LullabySettingsActivity.lambda$refresh$1(preferenceActivity, preference);
            case 14:
                return LullabySettingsActivity.lambda$refresh$5(preferenceActivity, preference);
            case 15:
                return PrivacySettingsActivity.lambda$refresh$5(preferenceActivity, preference);
            case 16:
                return ServicesSettingsActivity.refresh$lambda$2(preferenceActivity, preference);
            case 17:
                return SmartLightSettingsActivity.lambda$refresh$3(preferenceActivity, preference);
            case 18:
                return SmartwatchSettingsActivity.lambda$refresh$10(preferenceActivity, preference);
            case 19:
                return TrackSettingsActivity.lambda$refresh$1(preferenceActivity, preference);
            case 20:
                return TrackSettingsActivity.lambda$refresh$3(preferenceActivity, preference);
            case 21:
                return TrackSettingsActivity.lambda$refresh$4(preferenceActivity, preference);
            default:
                return TrackSettingsActivity.lambda$refresh$5(preferenceActivity, preference);
        }
    }
}
