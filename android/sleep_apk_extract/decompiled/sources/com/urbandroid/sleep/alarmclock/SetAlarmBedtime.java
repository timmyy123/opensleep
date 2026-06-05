package com.urbandroid.sleep.alarmclock;

import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.ButtonPreference;
import com.urbandroid.sleep.gui.DefaultValueListPreference;
import com.urbandroid.sleep.gui.SeekBarPreference;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class SetAlarmBedtime extends SetAlarmSubcategory {
    private Preference bedtimeNotificationSegment;
    private ListPreference bedtimePref;
    private Preference goalSegment;
    private ButtonPreference targetSleepDefault;
    private SeekBarPreference targetSleepMinutes;
    private Runnable updateGoalRunnable = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.SetAlarmBedtime.1
        @Override // java.lang.Runnable
        public void run() {
            if (SetAlarmBedtime.this.targetSleepMinutes != null) {
                int currentValue = SetAlarmBedtime.this.targetSleepMinutes.getCurrentValue();
                SetAlarmBedtime.this.updateGoal(currentValue);
                SetAlarmBedtime.this.updateTargetSleepDefaultVisibility(currentValue);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initPrefs$0(Preference preference, Object obj) {
        updateBedtime(obj.toString());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$initPrefs$1(int i) {
        return DateUtil.formatMinutesInHumanLanguage(this, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initPrefs$2(Preference preference, Object obj) {
        this.h.removeCallbacks(this.updateGoalRunnable);
        this.h.postDelayed(this.updateGoalRunnable, 1000L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initPrefs$3(Preference preference) {
        getPreferenceScreen().removePreference(this.targetSleepDefault);
        this.targetSleepMinutes.setCurrentValue(SharedApplicationContext.getSettings().getIdealSleepMinutes());
        this.h.removeCallbacks(this.updateGoalRunnable);
        this.h.postDelayed(this.updateGoalRunnable, 1000L);
        return false;
    }

    private void updateBedtime(String str) {
        int timeToBedBefore;
        try {
            timeToBedBefore = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            timeToBedBefore = 0;
        }
        if (timeToBedBefore < 0) {
            timeToBedBefore = SharedApplicationContext.getSettings().getTimeToBedBefore();
        }
        Preference preference = this.bedtimeNotificationSegment;
        if (timeToBedBefore <= 0) {
            preference.setSummary(getString(R.string.bedtime_notification_expl));
            return;
        }
        preference.setSummary(getString(R.string.bedtime_notification_expl) + ": " + DateUtil.formatMinutesInHumanLanguage(this, Integer.valueOf(timeToBedBefore)) + ".");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGoal(int i) {
        Preference preference = this.goalSegment;
        if (preference != null) {
            preference.setSummary(getString(R.string.settings_category_sleep) + ": " + DateUtil.formatMinutesInHumanLanguage(this, Integer.valueOf(i)) + ".");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTargetSleepDefaultVisibility(int i) {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        if (preferenceScreen != null) {
            int idealSleepMinutes = SharedApplicationContext.getSettings().getIdealSleepMinutes();
            ButtonPreference buttonPreference = this.targetSleepDefault;
            if (i == idealSleepMinutes) {
                preferenceScreen.removePreference(buttonPreference);
            } else {
                preferenceScreen.addPreference(buttonPreference);
            }
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.SetAlarmSubcategory
    public String getDocUrl() {
        return "https://sleep.urbandroid.org/docs//alarms/snooze.html";
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    public int getPreferenceResource() {
        return R.xml.alarm_prefs_bedtime;
    }

    @Override // com.urbandroid.sleep.alarmclock.SetAlarmSubcategory
    public void initPrefs(Alarm alarm) {
        Logger.logInfo("SetAlarm: initPrefs");
        Settings settings = SharedApplicationContext.getSettings();
        ListPreference listPreference = (ListPreference) findPreference("alarm_target_sleep_time_notify_before");
        this.bedtimePref = listPreference;
        ((DefaultValueListPreference) listPreference).addDefaultValue(String.valueOf(settings.getTimeToBedBefore()));
        initValue(this.bedtimePref, Integer.valueOf(alarm.extendedConfig.getTimeToBed()));
        this.bedtimePref.setOnPreferenceChangeListener(new SetAlarmGentle$$ExternalSyntheticLambda0(this, 1));
        this.targetSleepDefault = (ButtonPreference) findPreference("target_sleep_default");
        this.bedtimeNotificationSegment = findPreference("timeline_segment_bedtime");
        this.goalSegment = findPreference("timeline_segment_wake_up");
        this.targetSleepMinutes = (SeekBarPreference) findPreference("target_sleep_minutes");
        int perAlarmIdealSleepMinutes = SharedApplicationContext.getSettings().getPerAlarmIdealSleepMinutes(alarm);
        this.targetSleepMinutes.setCurrentValue(perAlarmIdealSleepMinutes);
        this.targetSleepMinutes.setMajorInterval(30);
        this.targetSleepMinutes.setFormatter(new UnlockFlow$1$$ExternalSyntheticLambda2(this));
        this.targetSleepDefault.setSummary(getString(R.string.default_ringtone_name) + ": " + DateUtil.formatMinutesInHumanLanguage(this, Integer.valueOf(SharedApplicationContext.getSettings().getIdealSleepMinutes())));
        updateTargetSleepDefaultVisibility(perAlarmIdealSleepMinutes);
        updateBedtime(String.valueOf(alarm.extendedConfig.getTimeToBed()));
        updateGoal(alarm.extendedConfig.getIdealSleepMinutes() == null ? SharedApplicationContext.getSettings().getIdealSleepMinutes() : alarm.extendedConfig.getIdealSleepMinutes().intValue());
        this.targetSleepMinutes.setOnPreferenceChangeListener(new SetAlarmGentle$$ExternalSyntheticLambda0(this, 2));
        this.targetSleepDefault.setOnPreferenceClickListener(new SetAlarm$$ExternalSyntheticLambda7(this, 7));
    }

    @Override // com.urbandroid.sleep.alarmclock.SetAlarmSubcategory
    public Alarm mapToAlarm(Alarm alarm) {
        if (this.targetSleepMinutes.getCurrentValue() == SharedApplicationContext.getSettings().getIdealSleepMinutes()) {
            Logger.logInfo("SetAlarm: Ideal saving null");
            alarm.extendedConfig.setIdealSleepMinutes(null);
        } else {
            Logger.logInfo("SetAlarm: Ideal saving " + this.targetSleepMinutes.getCurrentValue());
            alarm.extendedConfig.setIdealSleepMinutes(Integer.valueOf(this.targetSleepMinutes.getCurrentValue()));
        }
        try {
            ListPreference listPreference = this.bedtimePref;
            if (listPreference == null || listPreference.getValue() == null) {
                return alarm;
            }
            alarm.extendedConfig.setTimeToBed(Integer.parseInt(this.bedtimePref.getValue()));
            return alarm;
        } catch (NumberFormatException e) {
            Logger.logWarning("SetAlarm: Failed to parse time to bed data", e);
            return alarm;
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.SetAlarmSubcategory, android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        return true;
    }
}
