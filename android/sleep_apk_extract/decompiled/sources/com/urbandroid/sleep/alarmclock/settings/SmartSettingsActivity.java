package com.urbandroid.sleep.alarmclock.settings;

import android.content.DialogInterface;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.pref.LamerPreferenceCategory;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public class SmartSettingsActivity extends SimpleSettingsActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$0(Preference preference) {
        ViewIntent.url(this, "https://sleep.urbandroid.org/docs//sleep/smart_wake_up.html");
        return false;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/smart_wake_up.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_smart;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.settings_category_smart;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        super.onPreferenceChange(preference, obj);
        if (!"non_deep_sleep_window".equals(preference.getKey()) || obj == null || !obj.equals("59")) {
            return true;
        }
        AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(this).create();
        alertDialogCreate.setTitle(getResources().getString(R.string.powernap_warning_title));
        alertDialogCreate.setMessage(getResources().getString(R.string.powernap_warning_text2));
        alertDialogCreate.setButton(-3, "OK", new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartSettingsActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialogCreate.show();
        return true;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean z) {
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        Preference preferenceFindPreference = findPreference("smart_expl");
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda0(this, 8));
        }
        Preference preferenceFindPreference2 = findPreference("non_deep_sleep_sensitivity_checks_new");
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setSummary(getString(R.string.settings_category_smart) + " + " + getString(R.string.awake_detection) + " + " + getString(R.string.settings_category_lucid_title));
        }
        addSensitivitySummary(findPreference("non_deep_sleep_sensitivity_checks_new"));
        LamerPreferenceCategory.init(preferenceActivity, preferenceScreen, z || new Settings(preferenceActivity).isExpandAllSettings(), "settings_category_advanced");
    }
}
