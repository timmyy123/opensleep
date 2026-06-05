package com.urbandroid.sleep.alarmclock;

import android.preference.ListPreference;
import com.facebook.appevents.AppEventsConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.settings.SnoozeSettingsActivity;
import com.urbandroid.sleep.gui.DefaultValueListPreference;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class SetAlarmSnooze extends SetAlarmSubcategory {
    private ListPreference mSnoozeAfterAlarm;
    private ListPreference mSnoozeDuration;
    private ListPreference mSnoozeLimit;
    private ListPreference mSnoozeTotalTimeLimit;

    @Override // com.urbandroid.sleep.alarmclock.SetAlarmSubcategory
    public String getDocUrl() {
        return "https://sleep.urbandroid.org/docs//alarms/snooze.html";
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    public int getPreferenceResource() {
        return R.xml.alarm_prefs_snooze;
    }

    @Override // com.urbandroid.sleep.alarmclock.SetAlarmSubcategory
    public void initPrefs(Alarm alarm) {
        Settings settings = SharedApplicationContext.getSettings();
        ListPreference listPreference = (ListPreference) findPreference("alarm_snooze_duration");
        this.mSnoozeDuration = listPreference;
        ((DefaultValueListPreference) listPreference).addDefaultValue(String.valueOf(settings.getSnoozeDuration(null)));
        ListPreference listPreference2 = (ListPreference) findPreference("alarm_snooze_limit");
        this.mSnoozeLimit = listPreference2;
        ((DefaultValueListPreference) listPreference2).addDefaultValue(String.valueOf(settings.getSnoozeLimit(null)));
        ListPreference listPreference3 = (ListPreference) findPreference("alarm_snooze_total_time_limit");
        this.mSnoozeTotalTimeLimit = listPreference3;
        SnoozeSettingsActivity.removeLastUsedEntry(listPreference3);
        ((DefaultValueListPreference) this.mSnoozeTotalTimeLimit).addDefaultValue(String.valueOf(settings.getSnoozeTotalTimeLimit(null) == Integer.MAX_VALUE ? 0 : settings.getSnoozeTotalTimeLimit(null)));
        ListPreference listPreference4 = (ListPreference) findPreference("alarm_snooze_after_alarm");
        this.mSnoozeAfterAlarm = listPreference4;
        ((DefaultValueListPreference) listPreference4).addDefaultValue(settings.isSnoozeAfterAlarmEnabled(null) ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        initValue(this.mSnoozeDuration, alarm.extendedConfig.getSnoozeDuration());
        initValue(this.mSnoozeTotalTimeLimit, alarm.extendedConfig.getSnoozeTotalTimeLimit());
        initValue(this.mSnoozeLimit, alarm.extendedConfig.getSnoozeLimit());
        initValue(this.mSnoozeAfterAlarm, Integer.valueOf(alarm.extendedConfig.getSnoozeAfterAlarm()));
        this.mSnoozeDuration.setOnPreferenceChangeListener(this);
        this.mSnoozeLimit.setOnPreferenceChangeListener(this);
        this.mSnoozeTotalTimeLimit.setOnPreferenceChangeListener(this);
        this.mSnoozeAfterAlarm.setOnPreferenceChangeListener(this);
    }

    @Override // com.urbandroid.sleep.alarmclock.SetAlarmSubcategory
    public Alarm mapToAlarm(Alarm alarm) {
        try {
            ListPreference listPreference = this.mSnoozeDuration;
            if (listPreference != null && listPreference.getValue() != null) {
                alarm.extendedConfig.setSnoozeDuration(Integer.valueOf(Integer.parseInt(this.mSnoozeDuration.getValue())));
            }
        } catch (NumberFormatException e) {
            Logger.logWarning("SetAlarm: Failed to parse snooze duration data", e);
        }
        try {
            ListPreference listPreference2 = this.mSnoozeLimit;
            if (listPreference2 != null && listPreference2.getValue() != null) {
                alarm.extendedConfig.setSnoozeLimit(Integer.valueOf(Integer.parseInt(this.mSnoozeLimit.getValue())));
            }
        } catch (NumberFormatException e2) {
            Logger.logWarning("SetAlarm: Failed to parse snooze limit data", e2);
        }
        try {
            ListPreference listPreference3 = this.mSnoozeTotalTimeLimit;
            if (listPreference3 != null && listPreference3.getValue() != null) {
                alarm.extendedConfig.setSnoozeTotalTimeLimit(Integer.valueOf(Integer.parseInt(this.mSnoozeTotalTimeLimit.getValue())));
            }
        } catch (NumberFormatException e3) {
            Logger.logWarning("SetAlarm: Failed to parse snooze total time limit data", e3);
        }
        try {
            ListPreference listPreference4 = this.mSnoozeAfterAlarm;
            if (listPreference4 != null && listPreference4.getValue() != null) {
                alarm.extendedConfig.setSnoozeAfterAlarm(Integer.parseInt(this.mSnoozeAfterAlarm.getValue()));
            }
        } catch (NumberFormatException e4) {
            Logger.logWarning("SetAlarm: Failed to parse snooze after alarm data", e4);
        }
        return alarm;
    }
}
