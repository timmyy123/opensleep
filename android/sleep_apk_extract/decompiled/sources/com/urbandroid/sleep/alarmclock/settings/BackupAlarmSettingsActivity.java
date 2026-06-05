package com.urbandroid.sleep.alarmclock.settings;

import android.content.Intent;
import android.preference.Preference;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class BackupAlarmSettingsActivity extends SimpleSettingsActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$0(PreferenceActivity preferenceActivity, Preference preference) {
        Intent intent = new Intent(preferenceActivity, (Class<?>) MediaListActivity.class);
        intent.putExtra("extra_alert_multiple", false);
        intent.putExtra("extra_allow_playlist", true);
        intent.putExtra("extra_integration", false);
        intent.putExtra("extra_hide_app_settings", false);
        intent.putExtra("extra_silent", true);
        intent.putExtra("extra_alert_uri", SharedApplicationContext.getSettings().getSirenRingtone());
        preferenceActivity.startActivityForResult(intent, 456);
        return true;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//alarms/backup.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_backup_alarm;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.siren_ringtone_title;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 456 && i2 == -1) {
            findPreference("siren_ringtone").setSummary(intent.getStringExtra("extra_alert_title"));
            SharedApplicationContext.getSettings().setSireneRingtone(intent.getStringExtra("extra_alert_uri"));
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean z) {
        preferenceActivity.getPreferenceScreen().findPreference("siren_ringtone").setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 7));
    }
}
