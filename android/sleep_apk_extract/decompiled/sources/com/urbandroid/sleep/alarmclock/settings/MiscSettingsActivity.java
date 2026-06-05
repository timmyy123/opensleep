package com.urbandroid.sleep.alarmclock.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.fragment.TabTuneActivity;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.pref.LamerPreferenceCategory;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ThemeUtil;
import com.urbandroid.util.TtsService;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class MiscSettingsActivity extends SimpleSettingsActivity {
    private Preference tuneTabPref = null;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$0(Preference preference) {
        Intent intent = new Intent("android.settings.APP_LOCALE_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        startActivity(intent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$1(PreferenceActivity preferenceActivity, Preference preference) {
        Intent intent = new Intent("com.android.settings.TTS_SETTINGS");
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        preferenceActivity.startActivity(intent);
        return true;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//ux/personalize.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return Build.VERSION.SDK_INT >= 30 ? R.xml.settings_misc_30 : R.xml.settings_misc;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.settings_category_ux;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 72) {
            if (i2 == 1) {
                ((CheckBoxPreference) findPreference("text_to_speech")).setChecked(true);
                SharedApplicationContext.getSettings().setTextToSpeech(true);
                TtsService.speak(this, R.string.text_to_speech_title);
                TtsService.speak(this, R.string.enabled);
                return;
            }
            Intent intent2 = new Intent();
            intent2.setAction("android.speech.tts.engine.INSTALL_TTS_DATA");
            try {
                startActivity(intent2);
            } catch (Exception unused) {
                Toast.makeText(this, "To make this working, please install the Google TTS engine from the Play Store.", 0).show();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(final PreferenceActivity preferenceActivity, final boolean z) {
        Preference preferenceFindPreference;
        final PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        final Settings settings = new Settings(preferenceActivity);
        Preference preferenceFindPreference2 = preferenceScreen.findPreference("settings_entry_tune_tabs");
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setTitle(preferenceActivity.getString(R.string.tab_show_title, ""));
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.MiscSettingsActivity.1
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    preferenceActivity.startActivity(new Intent(preferenceActivity, (Class<?>) TabTuneActivity.class));
                    return false;
                }
            });
        }
        Preference preferenceFindPreference3 = preferenceScreen.findPreference("home_screen");
        if (preferenceFindPreference3 != null) {
            ListPreference listPreference = (ListPreference) preferenceFindPreference3;
            CharSequence[] entries = listPreference.getEntries();
            entries[2] = getString(R.string.alarms_only) + " (" + getString(R.string.no_history_records) + ")";
            listPreference.setEntries(entries);
            preferenceFindPreference3.setSummary(settings.isDashboard() ? R.string.dashboard : settings.isAlarmOnly() ? R.string.alarm_list_title : R.string.tabs);
            Preference preferenceFindPreference4 = preferenceScreen.findPreference("settings_entry_tune_tabs");
            this.tuneTabPref = preferenceFindPreference4;
            if (preferenceFindPreference4 != null) {
                if (settings.isDashboard() || settings.isAlarmOnly()) {
                    ((PreferenceCategory) preferenceScreen.findPreference("settings_category_misc")).removePreference(this.tuneTabPref);
                } else {
                    ((PreferenceCategory) preferenceScreen.findPreference("settings_category_misc")).addPreference(this.tuneTabPref);
                }
            }
            listPreference.setValue(settings.isDashboard() ? AppEventsConstants.EVENT_PARAM_VALUE_NO : settings.isAlarmOnly() ? "2" : AppEventsConstants.EVENT_PARAM_VALUE_YES);
            preferenceFindPreference3.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.MiscSettingsActivity.2
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    int i = Integer.parseInt(obj.toString());
                    if (i == 0) {
                        settings.setDashboard(true);
                        settings.setAlarmOnly(false);
                    } else if (i == 1) {
                        settings.setDashboard(false);
                        settings.setAlarmOnly(false);
                    } else if (i == 2) {
                        settings.setDashboard(false);
                        settings.setAlarmOnly(true);
                    }
                    preference.setSummary(settings.isDashboard() ? R.string.dashboard : settings.isAlarmOnly() ? R.string.alarm_list_title : R.string.tabs);
                    if (MiscSettingsActivity.this.tuneTabPref != null) {
                        if ((settings.isDashboard() || settings.isAlarmOnly()) && MiscSettingsActivity.this.tuneTabPref != null) {
                            ((PreferenceCategory) preferenceScreen.findPreference("settings_category_misc")).removePreference(MiscSettingsActivity.this.tuneTabPref);
                        } else {
                            ((PreferenceCategory) preferenceScreen.findPreference("settings_category_misc")).addPreference(MiscSettingsActivity.this.tuneTabPref);
                        }
                    }
                    AlarmClock.refreshAfterResume = true;
                    return true;
                }
            });
        }
        Preference preferenceFindPreference5 = preferenceScreen.findPreference("status_bar_icon");
        if (preferenceFindPreference5 != null) {
            ((PreferenceCategory) preferenceScreen.findPreference("settings_category_alarm_misc")).removePreference(preferenceFindPreference5);
        }
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (Build.VERSION.SDK_INT >= 33 && (preferenceFindPreference = preferenceScreen.findPreference("language")) != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda0(this, objArr2 == true ? 1 : 0));
        }
        Preference preferenceFindPreference6 = preferenceScreen.findPreference("theme");
        if (preferenceFindPreference6 != null) {
            ListPreference listPreference2 = (ListPreference) preferenceFindPreference6;
            CharSequence[] entries2 = listPreference2.getEntries();
            entries2[0] = preferenceActivity.getResources().getString(R.string.automatic) + " (" + preferenceActivity.getResources().getString(R.string.android_os) + ")";
            entries2[1] = preferenceActivity.getResources().getString(R.string.automatic) + " (" + preferenceActivity.getResources().getString(R.string.time_to_bed_title) + ")";
            listPreference2.setEntries(entries2);
            preferenceFindPreference6.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.MiscSettingsActivity.3
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    ThemeUtil.setThemeFromSetting(preferenceActivity, settings.getTheme(Integer.parseInt(obj.toString())));
                    if (!ThemeUtil.isBrokenNightMode(preferenceActivity)) {
                        preferenceActivity.recreate();
                        return true;
                    }
                    MiscSettingsActivity.this.finish();
                    preferenceActivity.startActivity(new Intent(preferenceActivity, (Class<?>) MiscSettingsActivity.class));
                    return true;
                }
            });
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preferenceScreen.findPreference("text_to_speech");
        if (checkBoxPreference != null) {
            checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.MiscSettingsActivity.4
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    if (!((Boolean) obj).booleanValue()) {
                        return true;
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.speech.tts.engine.CHECK_TTS_DATA");
                    try {
                        preferenceActivity.startActivityForResult(intent, 72);
                    } catch (Exception unused) {
                        Toast.makeText(preferenceActivity, "Please install Google TTS from Play Store", 1).show();
                    }
                    return z;
                }
            });
        }
        Preference preferenceFindPreference7 = preferenceScreen.findPreference("key_voice_setup");
        if (preferenceFindPreference7 != null) {
            preferenceFindPreference7.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, objArr == true ? 1 : 0));
        }
        LamerPreferenceCategory.init(preferenceActivity, preferenceScreen, z || new Settings(preferenceActivity).isExpandAllSettings(), "settings_category_control");
    }
}
