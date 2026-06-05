package com.urbandroid.sleep.gui.pref;

import android.preference.Preference;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LamerPreferenceCategory$$ExternalSyntheticLambda0 implements Preference.OnPreferenceClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LamerPreferenceCategory f$0;

    public /* synthetic */ LamerPreferenceCategory$$ExternalSyntheticLambda0(LamerPreferenceCategory lamerPreferenceCategory, int i) {
        this.$r8$classId = i;
        this.f$0 = lamerPreferenceCategory;
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public final boolean onPreferenceClick(Preference preference) {
        int i = this.$r8$classId;
        LamerPreferenceCategory lamerPreferenceCategory = this.f$0;
        switch (i) {
            case 0:
                return lamerPreferenceCategory.lambda$collapse$0(preference);
            default:
                return lamerPreferenceCategory.lambda$expand$1(preference);
        }
    }
}
