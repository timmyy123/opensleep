package com.urbandroid.sleep.shortcut;

import com.urbandroid.sleep.alarmclock.settings.BedtimeSettingsActivity;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.SeekBarPreference;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AddShortcutActivity$$ExternalSyntheticLambda6 implements SeekBarPreference.IFormatter {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ PreferenceActivity f$0;

    public /* synthetic */ AddShortcutActivity$$ExternalSyntheticLambda6(PreferenceActivity preferenceActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = preferenceActivity;
    }

    @Override // com.urbandroid.sleep.gui.SeekBarPreference.IFormatter
    public final String format(int i) {
        int i2 = this.$r8$classId;
        PreferenceActivity preferenceActivity = this.f$0;
        switch (i2) {
            case 0:
                return AddShortcutActivity.refresh$lambda$1$3(preferenceActivity, i);
            case 1:
                return BedtimeSettingsActivity.refresh$lambda$3(preferenceActivity, i);
            default:
                return AddShortcutActivity.refresh$lambda$1$4(preferenceActivity, i);
        }
    }
}
