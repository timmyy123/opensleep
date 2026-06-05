package com.urbandroid.sleep.alarmclock.settings;

import android.content.Intent;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.JetLagPreviewActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.SleepPermissionCompat;

/* JADX INFO: loaded from: classes4.dex */
public class JetLagSettingsActivity extends SimpleSettingsActivity {
    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/jetlag.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_jetlag;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.jetlag;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 972) {
            return;
        }
        if (iArr[0] == 0) {
            SharedApplicationContext.getSettings().setJetLagPrevention(true);
            ((CheckBoxPreference) findPreference("jetlag")).setChecked(true);
        } else {
            SharedApplicationContext.getSettings().setJetLagPrevention(false);
            ((CheckBoxPreference) findPreference("jetlag")).setChecked(false);
            ViewIntent.getPermissionDenyDialogBuilder(this, "android.permission.CAMERA", R.string.jetlag).show();
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(final PreferenceActivity preferenceActivity, boolean z) {
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        if (new Settings(preferenceActivity).isJetLagPrevention()) {
            SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
            if (!sleepPermissionCompat.isPermissionGranted(preferenceActivity, "android.permission.CAMERA")) {
                Logger.logInfo("Permissions: CAMERA Request ");
                sleepPermissionCompat.requestPermissions(preferenceActivity, new String[]{"android.permission.CAMERA"}, 972);
            }
        }
        Preference preferenceFindPreference = preferenceScreen.findPreference("jetlag_tutorial");
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.JetLagSettingsActivity.1
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    preferenceActivity.startActivity(new Intent(preferenceActivity, (Class<?>) JetLagPreviewActivity.class));
                    return false;
                }
            });
        }
        Preference preferenceFindPreference2 = preferenceScreen.findPreference("smartlight_mask_purchase");
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setTitle(preferenceActivity.getResources().getString(R.string.smartlight_mask_purchase, preferenceActivity.getResources().getString(R.string.addons_mask_title)));
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.JetLagSettingsActivity.2
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    ViewIntent.urlCustomTab(JetLagSettingsActivity.this, "https://sleepmask.urbandroid.org");
                    return false;
                }
            });
        }
        Preference preferenceFindPreference3 = preferenceScreen.findPreference("smartlight_phaser_purchase");
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setTitle(preferenceActivity.getResources().getString(R.string.smartlight_mask_purchase, preferenceActivity.getResources().getString(R.string.sleep_phaser)));
            preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.JetLagSettingsActivity.3
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    ViewIntent.urlCustomTab(JetLagSettingsActivity.this, "https://sleepphaser.urbandroid.org");
                    return false;
                }
            });
        }
    }
}
