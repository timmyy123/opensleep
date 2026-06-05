package com.urbandroid.sleep.alarmclock.settings;

import android.preference.Preference;
import android.preference.PreferenceScreen;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.SettingKeys;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ServicesSettingsActivity$$ExternalSyntheticLambda11 implements Preference.OnPreferenceClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SettingKeys f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ ServicesSettingsActivity$$ExternalSyntheticLambda11(SmartwatchSettingsActivity smartwatchSettingsActivity, PreferenceScreen preferenceScreen, PreferenceActivity preferenceActivity) {
        this.$r8$classId = 2;
        this.f$0 = smartwatchSettingsActivity;
        this.f$2 = preferenceScreen;
        this.f$1 = preferenceActivity;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public final boolean onPreferenceClick(Preference preference) {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$2;
        SettingKeys settingKeys = this.f$0;
        switch (i) {
            case 0:
                return ServicesSettingsActivity.refreshSyncNow$lambda$0((Settings) settingKeys, (PreferenceActivity) obj, (ServicesSettingsActivity) obj2, preference);
            case 1:
                return BedtimeNoAlarmSettingsActivity.refresh$lambda$2$0((BedtimeNoAlarmSettingsActivity) settingKeys, (String) obj, (Preference) obj2, preference);
            default:
                return ((SmartwatchSettingsActivity) settingKeys).lambda$refresh$4((PreferenceScreen) obj2, (PreferenceActivity) obj, preference);
        }
    }

    public /* synthetic */ ServicesSettingsActivity$$ExternalSyntheticLambda11(SettingKeys settingKeys, Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = settingKeys;
        this.f$1 = obj;
        this.f$2 = obj2;
    }
}
