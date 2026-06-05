package com.urbandroid.sleep.shortcut;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import com.urbandroid.sleep.alarmclock.settings.AlarmSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.AutomationSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.GoogleHomeAutomationSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.LullabySettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.PairSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity;
import com.urbandroid.sleep.domain.shortcut.ShortcutSleep;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AddShortcutActivity$$ExternalSyntheticLambda4 implements Preference.OnPreferenceChangeListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ AddShortcutActivity$$ExternalSyntheticLambda4(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference preference, Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (i) {
            case 0:
                return AddShortcutActivity.refresh$lambda$1$1((AddShortcutActivity) obj3, (ShortcutSleep) obj2, preference, obj);
            case 1:
                return ((AlarmSettingsActivity) obj3).lambda$refresh$6((PreferenceActivity) obj2, preference, obj);
            case 2:
                return AutomationSettingsActivity.refresh$lambda$1$4((MultiSelectListPreference) obj3, (AutomationSettingsActivity) obj2, preference, obj);
            case 3:
                return AutomationSettingsActivity.refresh$lambda$8((AutomationSettingsActivity) obj3, (EditTextPreference) obj2, preference, obj);
            case 4:
                return AutomationSettingsActivity.refresh$lambda$9((Settings) obj3, (AutomationSettingsActivity) obj2, preference, obj);
            case 5:
                return GoogleHomeAutomationSettingsActivity.refresh$lambda$0((Context) obj3, (GoogleHomeAutomationSettingsActivity) obj2, preference, obj);
            case 6:
                return ((LullabySettingsActivity) obj3).lambda$refresh$2((Preference) obj2, preference, obj);
            case 7:
                return LullabySettingsActivity.lambda$refresh$6((PreferenceActivity) obj3, (CheckBoxPreference) obj2, preference, obj);
            case 8:
                return ((NoiseSettingsActivity) obj3).lambda$refresh$2((PreferenceActivity) obj2, preference, obj);
            case 9:
                return ((PairSettingsActivity) obj3).lambda$configurePairTrackingEnabledPreference$1((PreferenceActivity) obj2, preference, obj);
            case 10:
                return ((SmartLightSettingsActivity) obj3).lambda$refresh$0((SmartLightSettingsActivity) obj2, preference, obj);
            default:
                return AddShortcutActivity.refresh$lambda$1$2((AddShortcutActivity) obj3, (AddShortcutActivity$$ExternalSyntheticLambda4) obj2, preference, obj);
        }
    }
}
