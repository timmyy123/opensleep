package com.urbandroid.sleep.alarmclock.settings;

import android.preference.ListPreference;
import android.preference.PreferenceScreen;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.pref.LamerPreferenceCategory;
import com.urbandroid.sleep.service.Settings;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class SnoozeSettingsActivity extends SimpleSettingsActivity {
    public static void removeLastUsedEntry(ListPreference listPreference) {
        if (listPreference == null) {
            return;
        }
        CharSequence[] entries = listPreference.getEntries();
        ArrayList arrayList = new ArrayList(Arrays.asList(listPreference.getEntryValues()));
        if (((CharSequence) arrayList.get(1)).equals("-1")) {
            arrayList.remove(1);
            ArrayList arrayList2 = new ArrayList(Arrays.asList(entries));
            arrayList2.remove(1);
            listPreference.setEntries((CharSequence[]) arrayList2.toArray(new CharSequence[arrayList2.size()]));
            listPreference.setEntryValues((CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]));
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//alarms/snooze.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_snooze;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.alarm_alert_snooze_text;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean z) {
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        ListPreference listPreference = (ListPreference) preferenceScreen.findPreference("snooze_duration");
        if (listPreference != null) {
            listPreference.setSummary(listPreference.getEntry());
            listPreference.setOnPreferenceChangeListener(this);
        }
        ListPreference listPreference2 = (ListPreference) preferenceScreen.findPreference("snooze_after_alarm");
        if (listPreference2 != null) {
            listPreference2.setSummary(listPreference2.getEntry());
            listPreference2.setOnPreferenceChangeListener(this);
        }
        removeLastUsedEntry((ListPreference) preferenceScreen.findPreference("snooze_max_time_limit"));
        LamerPreferenceCategory.init(preferenceActivity, preferenceScreen, z || new Settings(preferenceActivity).isExpandAllSettings(), "settings_category_control");
    }
}
