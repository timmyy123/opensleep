package com.urbandroid.sleep.alarmclock.settings;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.preference.Preference;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AutomationSettingsActivity$$ExternalSyntheticLambda7 implements Preference.OnPreferenceChangeListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SimpleSettingsActivity f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ AutomationSettingsActivity$$ExternalSyntheticLambda7(SimpleSettingsActivity simpleSettingsActivity, Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = simpleSettingsActivity;
        this.f$1 = obj;
        this.f$2 = obj2;
        this.f$3 = obj3;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference preference, Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$3;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        SimpleSettingsActivity simpleSettingsActivity = this.f$0;
        switch (i) {
            case 0:
                return AutomationSettingsActivity.refresh$lambda$7((AutomationSettingsActivity) simpleSettingsActivity, (Settings) obj4, (PreferenceActivity) obj3, (Context) obj2, preference, obj);
            case 1:
                return CaptchaCheatingSettingsActivity.refresh$lambda$0((CaptchaCheatingSettingsActivity) simpleSettingsActivity, (DevicePolicyManager) obj4, (ComponentName) obj3, (Preference) obj2, preference, obj);
            default:
                return CaptchaCheatingSettingsActivity.refresh$lambda$1((CaptchaCheatingSettingsActivity) simpleSettingsActivity, (Preference) obj4, (DevicePolicyManager) obj3, (ComponentName) obj2, preference, obj);
        }
    }
}
