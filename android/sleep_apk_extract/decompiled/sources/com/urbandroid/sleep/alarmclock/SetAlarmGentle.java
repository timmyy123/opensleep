package com.urbandroid.sleep.alarmclock;

import android.preference.ListPreference;
import android.preference.Preference;
import android.text.Html;
import android.widget.Toast;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.PreferencesUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.settings.SnoozeSettingsActivity;
import com.urbandroid.sleep.gui.DefaultValueListPreference;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class SetAlarmGentle extends SetAlarmSubcategory {
    private ListPreference alarmVibration;
    private ListPreference gentleVolumeIncrease;
    private ListPreference soundDelay;
    private ListPreference vibrationWatch;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initPrefs$0(Preference preference, Object obj) {
        if (Integer.parseInt(obj.toString()) <= SharedApplicationContext.getSettings().getAlarmTimeout() * 1000) {
            return true;
        }
        Toast.makeText(this, getString(R.string.advice_caution) + ": " + getString(R.string.alarm_sound_delay) + " > " + getString(R.string.alarm_kill_time_title), 1).show();
        return false;
    }

    @Override // com.urbandroid.sleep.alarmclock.SetAlarmSubcategory
    public String getDocUrl() {
        return "https://sleep.urbandroid.org/docs//alarms/alarm_settings.html#gentle_alarm";
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    public int getPreferenceResource() {
        return R.xml.alarm_prefs_gentle;
    }

    @Override // com.urbandroid.sleep.alarmclock.SetAlarmSubcategory
    public void initPrefs(Alarm alarm) {
        Settings settings = SharedApplicationContext.getSettings();
        ListPreference listPreference = (ListPreference) findPreference("per_alarm_increasing_volume_duration");
        this.gentleVolumeIncrease = listPreference;
        ((DefaultValueListPreference) listPreference).setLongDesc(getString(R.string.alarm_increasing_volume_duration_summary));
        ((DefaultValueListPreference) this.gentleVolumeIncrease).addDefaultValue(String.valueOf(settings.getGradualVolumeIncreaseDuration()));
        ListPreference listPreference2 = this.gentleVolumeIncrease;
        if (listPreference2 != null) {
            CharSequence[] entries = listPreference2.getEntries();
            entries[1] = Html.fromHtml(getResources().getString(R.string.disabled) + "<br><small><i>" + getResources().getString(R.string.device_volume) + "</i></small>");
            entries[2] = Html.fromHtml(getResources().getStringArray(R.array.alarm_increasing_volume_duration_entries)[1] + "<br><small><i>" + getResources().getString(R.string.device_volume) + "</i></small>");
            this.gentleVolumeIncrease.setEntries(entries);
        }
        ListPreference listPreference3 = (ListPreference) findPreference("alarm_vibration");
        this.alarmVibration = listPreference3;
        PreferencesUtils.expandVibrationsPreference(this, listPreference3);
        ((DefaultValueListPreference) this.alarmVibration).addDefaultValue(String.valueOf(settings.getGradualVibration()));
        ListPreference listPreference4 = (ListPreference) findPreference("sound_delay");
        this.soundDelay = listPreference4;
        SnoozeSettingsActivity.removeLastUsedEntry(listPreference4);
        ((DefaultValueListPreference) this.soundDelay).addDefaultValue(String.valueOf(settings.getSoundDelay() == 0 ? -1 : settings.getSoundDelay()));
        this.soundDelay.setOnPreferenceChangeListener(new SetAlarmGentle$$ExternalSyntheticLambda0(this, 0));
        ListPreference listPreference5 = (ListPreference) findPreference("alarm_vibration_watch");
        this.vibrationWatch = listPreference5;
        PreferencesUtils.expandVibrationsPreference(this, listPreference5);
        this.vibrationWatch.setTitle(getString(R.string.vibration) + " " + getString(R.string.smartwatch).toLowerCase());
        ((DefaultValueListPreference) this.vibrationWatch).addDefaultValue(String.valueOf(settings.getGradualVibrationSmartwatch()));
        initValue(this.gentleVolumeIncrease, alarm.extendedConfig.getGradualVolumeIncrease());
        initValue(this.soundDelay, alarm.extendedConfig.getSoundDelay());
        initValue(this.alarmVibration, alarm.extendedConfig.getVibrationStart());
        initValue(this.vibrationWatch, alarm.extendedConfig.getVibrationStartSmartWatch());
        this.gentleVolumeIncrease.setOnPreferenceChangeListener(this);
        this.alarmVibration.setOnPreferenceChangeListener(this);
        this.soundDelay.setOnPreferenceChangeListener(this);
        this.vibrationWatch.setOnPreferenceChangeListener(this);
    }

    @Override // com.urbandroid.sleep.alarmclock.SetAlarmSubcategory
    public Alarm mapToAlarm(Alarm alarm) {
        try {
            ListPreference listPreference = this.gentleVolumeIncrease;
            if (listPreference != null && listPreference.getValue() != null) {
                alarm.extendedConfig.setGradualVolumeIncrease(Integer.valueOf(Integer.parseInt(this.gentleVolumeIncrease.getValue())));
            }
        } catch (NumberFormatException e) {
            Logger.logWarning("SetAlarm: Failed to parse " + this.gentleVolumeIncrease.getKey(), e);
        }
        try {
            ListPreference listPreference2 = this.alarmVibration;
            if (listPreference2 != null && listPreference2.getValue() != null) {
                alarm.extendedConfig.setVibrationStart(Integer.valueOf(Integer.parseInt(this.alarmVibration.getValue())));
            }
        } catch (NumberFormatException e2) {
            Logger.logWarning("SetAlarm: Failed to parse " + this.alarmVibration.getKey(), e2);
        }
        try {
            ListPreference listPreference3 = this.soundDelay;
            if (listPreference3 != null && listPreference3.getValue() != null) {
                alarm.extendedConfig.setSoundDelay(Integer.valueOf(Integer.parseInt(this.soundDelay.getValue())));
            }
        } catch (NumberFormatException e3) {
            Logger.logWarning("SetAlarm: Failed to parse " + this.soundDelay.getKey(), e3);
        }
        try {
            ListPreference listPreference4 = this.vibrationWatch;
            if (listPreference4 != null && listPreference4.getValue() != null) {
                alarm.extendedConfig.setVibrationStartSmartWatch(Integer.valueOf(Integer.parseInt(this.vibrationWatch.getValue())));
            }
        } catch (NumberFormatException e4) {
            Logger.logWarning("SetAlarm: Failed to parse " + this.vibrationWatch.getKey(), e4);
        }
        return alarm;
    }
}
