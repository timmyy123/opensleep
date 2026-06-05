package com.urbandroid.sleep.alarmclock.settings;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.text.Html;
import android.widget.Toast;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.PreferencesUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.media.mode.RingerModeUtil;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.SleepPermissionCompat;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class GentleSettingsActivity extends SimpleSettingsActivity {
    private CheckBoxPreference delayAfterSnooze;
    private Handler h;

    private void hideShowDelayAfterPreference(PreferenceScreen preferenceScreen, CheckBoxPreference checkBoxPreference, int i) {
        Logger.logSevere("Delay " + i + " - " + checkBoxPreference);
        if (checkBoxPreference != null) {
            if (i > 0) {
                ((PreferenceGroup) preferenceScreen.findPreference("settings_category_gentle")).addPreference(checkBoxPreference);
            } else {
                ((PreferenceGroup) preferenceScreen.findPreference("settings_category_gentle")).removePreference(checkBoxPreference);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$0(Preference preference) {
        Intent intent = new Intent(this, (Class<?>) SmartLightSettingsActivity.class);
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        startActivity(intent);
        Logger.logInfo("CLICK Start");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$1(PreferenceActivity preferenceActivity, Preference preference) {
        if (!((CheckBoxPreference) preference).isChecked()) {
            SharedApplicationContext.getSettings().setUseFlashlight(false);
            return true;
        }
        SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
        if (sleepPermissionCompat.isPermissionGranted(preferenceActivity, "android.permission.CAMERA")) {
            SharedApplicationContext.getSettings().setUseFlashlight(true);
        } else {
            Logger.logInfo("Permissions: CAMERA Request ");
            sleepPermissionCompat.requestPermission(preferenceActivity, "android.permission.CAMERA", 113);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refresh$2() {
        highlightPref("alarm_sound_delay_after_snooze");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$3(PreferenceScreen preferenceScreen, ListPreference listPreference, Preference preference, Object obj) {
        if (Integer.parseInt(obj.toString()) <= SharedApplicationContext.getSettings().getAlarmTimeout() * 1000) {
            try {
                hideShowDelayAfterPreference(preferenceScreen, this.delayAfterSnooze, Integer.parseInt(obj.toString()));
                this.h.postDelayed(new ActivityCompat$$ExternalSyntheticLambda0(this, 25), 500L);
            } catch (NumberFormatException e) {
                Logger.logSevere(e);
            }
            SimpleSettingsActivity.fillSummaryWithValue(listPreference, obj);
            return true;
        }
        Toast.makeText(this, getString(R.string.advice_caution) + ": " + getString(R.string.alarm_sound_delay) + " > " + getString(R.string.alarm_kill_time_title), 1).show();
        return false;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//alarms/alarm_settings.html#gentle_alarm";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_gentle;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.gentle_wake_up;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public void onCreatePreference(Bundle bundle) {
        super.onCreatePreference(bundle);
        ListPreference listPreference = (ListPreference) findPreference("gradual_vibration_new");
        PreferencesUtils.expandVibrationsPreference(this, listPreference);
        listPreference.setSummary(listPreference.getEntry());
        ListPreference listPreference2 = (ListPreference) findPreference("gradual_vibration_smartwatch_new");
        PreferencesUtils.expandVibrationsPreference(this, listPreference2);
        listPreference2.setSummary(listPreference2.getEntry());
        this.delayAfterSnooze = (CheckBoxPreference) ((PreferenceGroup) getPreferenceScreen().findPreference("settings_category_gentle")).findPreference("alarm_sound_delay_after_snooze");
        this.h = new Handler();
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (!"alarm_in_silent_mode".equals(preference.getKey())) {
            return super.onPreferenceTreeClick(preferenceScreen, preference);
        }
        RingerModeUtil.setStreamInSilent(this, ((CheckBoxPreference) preference).isChecked(), 4);
        return true;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean z) {
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        hideShowDelayAfterPreference(preferenceScreen, this.delayAfterSnooze, new Settings(this).getSoundDelay());
        Preference preferenceFindPreference = preferenceScreen.findPreference("alarm_increasing_volume_duration");
        if (preferenceFindPreference != null) {
            ListPreference listPreference = (ListPreference) preferenceFindPreference;
            CharSequence[] entries = listPreference.getEntries();
            entries[0] = Html.fromHtml(getResources().getString(R.string.disabled) + "<br><small><i>" + getResources().getString(R.string.device_volume) + "</i></small>");
            entries[1] = Html.fromHtml(getResources().getStringArray(R.array.alarm_increasing_volume_duration_entries)[1] + "<br><small><i>" + getResources().getString(R.string.device_volume) + "</i></small>");
            listPreference.setEntries(entries);
        }
        Preference preferenceFindPreference2 = preferenceScreen.findPreference("settings_category_smartlight_link");
        Logger.logInfo("CLICK Start " + preferenceFindPreference2);
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda0(this, 3));
        }
        Preference preferenceFindPreference3 = preferenceScreen.findPreference("alarm_with_flashlight");
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 12));
        }
        Preference preferenceFindPreference4 = preferenceScreen.findPreference("gradual_vibration_smartwatch_new");
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.setTitle(getString(R.string.vibration) + " " + getString(R.string.smartwatch).toLowerCase());
        }
        ListPreference listPreference2 = (ListPreference) findPreference("alarm_sound_delay");
        if (listPreference2 != null) {
            listPreference2.setOnPreferenceChangeListener(new TrackSettingsActivity$$ExternalSyntheticLambda7(this, preferenceScreen, listPreference2, 2));
        }
    }
}
