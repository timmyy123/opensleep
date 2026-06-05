package com.urbandroid.sleep.alarmclock.settings;

import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.PreferenceActivity;

/* JADX INFO: loaded from: classes4.dex */
public class MorningScreenSettingsActivity extends SimpleSettingsActivity {
    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/statistics.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_morning_screen;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.morning_screen;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean z) {
    }
}
