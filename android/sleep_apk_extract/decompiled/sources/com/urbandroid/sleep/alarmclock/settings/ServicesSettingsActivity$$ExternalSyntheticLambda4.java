package com.urbandroid.sleep.alarmclock.settings;

import android.content.Context;
import android.preference.Preference;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ServicesSettingsActivity$$ExternalSyntheticLambda4 implements Preference.OnPreferenceChangeListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ PreferenceActivity f$1;
    public final /* synthetic */ Settings f$2;
    public final /* synthetic */ ServicesSettingsActivity f$3;

    public /* synthetic */ ServicesSettingsActivity$$ExternalSyntheticLambda4(ServicesSettingsActivity servicesSettingsActivity, Settings settings, PreferenceActivity preferenceActivity, PreferenceActivity preferenceActivity2, int i) {
        this.$r8$classId = i;
        this.f$3 = servicesSettingsActivity;
        this.f$2 = settings;
        switch (i) {
            case 2:
                this.f$0 = preferenceActivity;
                this.f$1 = preferenceActivity2;
                break;
            default:
                this.f$1 = preferenceActivity;
                this.f$0 = preferenceActivity2;
                break;
        }
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference preference, Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return ServicesSettingsActivity.refresh$lambda$4(this.f$0, this.f$1, this.f$2, this.f$3, preference, obj);
            case 1:
                PreferenceActivity preferenceActivity = this.f$1;
                Context context = this.f$0;
                return ServicesSettingsActivity.refresh$lambda$7(this.f$3, this.f$2, preferenceActivity, context, preference, obj);
            default:
                Context context2 = this.f$0;
                PreferenceActivity preferenceActivity2 = this.f$1;
                return ServicesSettingsActivity.refresh$lambda$8$0(this.f$3, this.f$2, context2, preferenceActivity2, preference, obj);
        }
    }

    public /* synthetic */ ServicesSettingsActivity$$ExternalSyntheticLambda4(PreferenceActivity preferenceActivity, PreferenceActivity preferenceActivity2, Settings settings, ServicesSettingsActivity servicesSettingsActivity) {
        this.$r8$classId = 0;
        this.f$0 = preferenceActivity;
        this.f$1 = preferenceActivity2;
        this.f$2 = settings;
        this.f$3 = servicesSettingsActivity;
    }
}
