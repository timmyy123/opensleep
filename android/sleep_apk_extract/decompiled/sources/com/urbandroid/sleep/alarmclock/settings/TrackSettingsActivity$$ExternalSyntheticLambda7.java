package com.urbandroid.sleep.alarmclock.settings;

import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.google.calendar.GoogleCalendarSettingActivity;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class TrackSettingsActivity$$ExternalSyntheticLambda7 implements Preference.OnPreferenceChangeListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SimpleSettingsActivity f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ TrackSettingsActivity$$ExternalSyntheticLambda7(PreferenceActivity preferenceActivity, Settings settings, BedtimeSettingsActivity bedtimeSettingsActivity) {
        this.$r8$classId = 1;
        this.f$2 = preferenceActivity;
        this.f$1 = settings;
        this.f$0 = bedtimeSettingsActivity;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference preference, Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        SimpleSettingsActivity simpleSettingsActivity = this.f$0;
        switch (i) {
            case 0:
                return ((TrackSettingsActivity) simpleSettingsActivity).lambda$refresh$6((Settings) obj3, (PreferenceActivity) obj2, preference, obj);
            case 1:
                return BedtimeSettingsActivity.refresh$lambda$4((PreferenceActivity) obj2, (Settings) obj3, (BedtimeSettingsActivity) simpleSettingsActivity, preference, obj);
            case 2:
                return ((GentleSettingsActivity) simpleSettingsActivity).lambda$refresh$3((PreferenceScreen) obj3, (ListPreference) obj2, preference, obj);
            case 3:
                return ((TrackAutoSettingsActivity) simpleSettingsActivity).lambda$refresh$1((Settings) obj3, (PreferenceActivity) obj2, preference, obj);
            default:
                return GoogleCalendarSettingActivity.refresh$lambda$4((GoogleCalendarSettingActivity) simpleSettingsActivity, (String) obj3, (CheckBoxPreference) obj2, preference, obj);
        }
    }

    public /* synthetic */ TrackSettingsActivity$$ExternalSyntheticLambda7(SimpleSettingsActivity simpleSettingsActivity, Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = simpleSettingsActivity;
        this.f$1 = obj;
        this.f$2 = obj2;
    }
}
