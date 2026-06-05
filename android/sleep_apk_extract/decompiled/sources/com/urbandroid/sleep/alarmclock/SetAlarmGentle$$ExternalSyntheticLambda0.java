package com.urbandroid.sleep.alarmclock;

import android.preference.Preference;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SetAlarmGentle$$ExternalSyntheticLambda0 implements Preference.OnPreferenceChangeListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SetAlarmSubcategory f$0;

    public /* synthetic */ SetAlarmGentle$$ExternalSyntheticLambda0(SetAlarmSubcategory setAlarmSubcategory, int i) {
        this.$r8$classId = i;
        this.f$0 = setAlarmSubcategory;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference preference, Object obj) {
        int i = this.$r8$classId;
        SetAlarmSubcategory setAlarmSubcategory = this.f$0;
        switch (i) {
            case 0:
                return ((SetAlarmGentle) setAlarmSubcategory).lambda$initPrefs$0(preference, obj);
            case 1:
                return ((SetAlarmBedtime) setAlarmSubcategory).lambda$initPrefs$0(preference, obj);
            default:
                return ((SetAlarmBedtime) setAlarmSubcategory).lambda$initPrefs$2(preference, obj);
        }
    }
}
