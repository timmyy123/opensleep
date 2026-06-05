package com.urbandroid.sleep.alarmclock.settings;

import android.content.DialogInterface;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.fragment.MeasureOrderDialogFragment;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.SeekBarPreference;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public class StatsSettingsActivity extends SimpleSettingsActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$0(Preference preference) {
        new MeasureOrderDialogFragment().show(getSupportFragmentManager(), "sort");
        return false;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/statistics.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_stats;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.stats;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(final PreferenceActivity preferenceActivity, boolean z) {
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        final Settings settings = new Settings(preferenceActivity);
        SeekBarPreference seekBarPreference = (SeekBarPreference) preferenceScreen.findPreference("target_sleep_time_minutes");
        if (seekBarPreference != null) {
            seekBarPreference.setCurrentValue(settings.getIdealSleepMinutes());
            seekBarPreference.setMajorInterval(30);
            seekBarPreference.setFormatter(new SeekBarPreference.IFormatter() { // from class: com.urbandroid.sleep.alarmclock.settings.StatsSettingsActivity.1
                @Override // com.urbandroid.sleep.gui.SeekBarPreference.IFormatter
                public String format(int i) {
                    return DateUtil.formatMinutesInHumanLanguage(preferenceActivity, Integer.valueOf(i));
                }
            });
            seekBarPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.StatsSettingsActivity.2
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    Logger.logDebug("Ideal time settings changed.");
                    Alarms.setNextAlert(preferenceActivity);
                    settings.setIdealSleepLegacy(((Integer) obj).intValue() / 60.0f);
                    return true;
                }
            });
        }
        Preference preferenceFindPreference = preferenceActivity.findPreference("key_measure_order");
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda0(this, 9));
        }
        Preference preferenceFindPreference2 = preferenceActivity.findPreference("profile_birthdate");
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.StatsSettingsActivity.3
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    preference.setSummary(obj.toString());
                    settings.setBirthYear(obj.toString());
                    SleepScore sleepScore = new SleepScore();
                    sleepScore.setAge(settings.getAge());
                    float idealSleepMinutes = settings.getIdealSleepMinutes();
                    String string = idealSleepMinutes < sleepScore.getDurationLimitFrom() ? preferenceActivity.getResources().getString(R.string.advice_text_measure_less, preferenceActivity.getString(R.string.target_sleep_time_title), DateUtil.formatMinutesInHumanLanguage(preferenceActivity, Integer.valueOf(Math.round(sleepScore.getDurationLimitFrom())))) : null;
                    if (idealSleepMinutes > sleepScore.getDurationLimitTo()) {
                        string = preferenceActivity.getResources().getString(R.string.advice_text_measure_more, preferenceActivity.getString(R.string.target_sleep_time_title), DateUtil.formatMinutesInHumanLanguage(preferenceActivity, Integer.valueOf(Math.round(sleepScore.getDurationLimitTo()))));
                    }
                    if (string == null) {
                        return true;
                    }
                    new MaterialAlertDialogBuilder(preferenceActivity).setTitle(R.string.advice_caution).setMessage((CharSequence) string).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null).show();
                    return true;
                }
            });
        }
    }
}
