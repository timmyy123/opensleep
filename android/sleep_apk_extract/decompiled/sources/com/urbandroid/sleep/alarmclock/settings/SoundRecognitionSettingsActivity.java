package com.urbandroid.sleep.alarmclock.settings;

import android.preference.CheckBoxPreference;
import android.preference.Preference;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.SleepPermissionCompat;

/* JADX INFO: loaded from: classes4.dex */
public class SoundRecognitionSettingsActivity extends SimpleSettingsActivity {
    private CheckBoxPreference enablePref = null;

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/sound_recognition.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_sound_recognition;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.sound_recognition;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr.length != 0 && i == 972 && iArr[0] == 0) {
            new Settings(getApplicationContext()).setSnoringDetection(true);
            CheckBoxPreference checkBoxPreference = this.enablePref;
            if (checkBoxPreference != null) {
                checkBoxPreference.setChecked(true);
            }
            Logger.logInfo("Permissions: RECORD AUDIO Granted ");
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean z) {
        addSensitivitySummary(findPreference("sound_recognition_snoring"));
        addSensitivitySummary(findPreference("sound_recognition_talk"));
        addSensitivitySummary(findPreference("sound_recognition_sick"));
        addSensitivitySummary(findPreference("sound_recognition_laughter"));
        addSensitivitySummary(findPreference("sound_recognition_baby_cry"));
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("snoring_detection");
        this.enablePref = checkBoxPreference;
        if (checkBoxPreference != null) {
            checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SoundRecognitionSettingsActivity.1
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    if (!((Boolean) obj).booleanValue()) {
                        return true;
                    }
                    SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
                    if (sleepPermissionCompat.isPermissionGranted(SoundRecognitionSettingsActivity.this, "android.permission.RECORD_AUDIO")) {
                        return true;
                    }
                    Logger.logInfo("Permissions: RECORD AUDIO Request ");
                    sleepPermissionCompat.requestPermissions(SoundRecognitionSettingsActivity.this, new String[]{"android.permission.RECORD_AUDIO"}, 972);
                    return false;
                }
            });
        }
    }
}
