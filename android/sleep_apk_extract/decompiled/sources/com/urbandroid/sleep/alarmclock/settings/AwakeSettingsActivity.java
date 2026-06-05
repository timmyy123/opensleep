package com.urbandroid.sleep.alarmclock.settings;

import android.preference.Preference;
import android.preference.PreferenceScreen;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes5.dex */
public class AwakeSettingsActivity extends SimpleSettingsActivity {
    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/awake_detection.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_awake;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.awake_detection;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean z) {
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        addSensitivitySummary(findPreference("awake_activity_sensitivity"));
        addSensitivitySummary(findPreference("awake_hr_sensitivity"));
        addSensitivitySummary(findPreference("awake_light_sensitivity"));
        addSensitivitySummary(findPreference("awake_sound_sensitivity"));
        addSensitivitySummary(findPreference("awake_phone_use_sensitivity"));
        Preference preferenceFindPreference = preferenceScreen.findPreference("key_awake_detection_talk");
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setSummary(new Settings(preferenceActivity).getSoundRecognitionEnabledNamesForAwake());
        }
    }
}
