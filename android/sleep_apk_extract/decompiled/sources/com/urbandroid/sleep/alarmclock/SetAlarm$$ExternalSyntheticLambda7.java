package com.urbandroid.sleep.alarmclock;

import android.preference.Preference;
import com.urbandroid.sleep.gui.PreferenceActivity;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SetAlarm$$ExternalSyntheticLambda7 implements Preference.OnPreferenceClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ PreferenceActivity f$0;

    public /* synthetic */ SetAlarm$$ExternalSyntheticLambda7(PreferenceActivity preferenceActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = preferenceActivity;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public final boolean onPreferenceClick(Preference preference) {
        int i = this.$r8$classId;
        PreferenceActivity preferenceActivity = this.f$0;
        switch (i) {
            case 0:
                return ((SetAlarm) preferenceActivity).lambda$onCreatePreference$13(preference);
            case 1:
                return ((SetAlarm) preferenceActivity).lambda$onCreatePreference$5(preference);
            case 2:
                return ((SetAlarm) preferenceActivity).lambda$onCreatePreference$8(preference);
            case 3:
                return ((SetAlarm) preferenceActivity).lambda$onCreatePreference$11(preference);
            case 4:
                return ((SetAlarm) preferenceActivity).lambda$onCreatePreference$12(preference);
            case 5:
                return ((SetAlarm) preferenceActivity).lambda$onCreatePreference$15(preference);
            case 6:
                return ((SetAlarm) preferenceActivity).lambda$onCreatePreference$16(preference);
            default:
                return ((SetAlarmBedtime) preferenceActivity).lambda$initPrefs$3(preference);
        }
    }
}
