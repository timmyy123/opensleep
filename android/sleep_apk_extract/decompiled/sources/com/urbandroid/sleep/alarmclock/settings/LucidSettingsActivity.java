package com.urbandroid.sleep.alarmclock.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.pref.LamerPreferenceCategory;
import com.urbandroid.sleep.lucid.LucidPlayer;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartlight.SmartLight;
import com.urbandroid.sleep.smartlight.SmartLightProvider;
import com.urbandroid.sleep.smartwatch.AbstractConnectivityCallback;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import com.urbandroid.util.Experiments;

/* JADX INFO: loaded from: classes4.dex */
public class LucidSettingsActivity extends SimpleSettingsActivity {
    private LucidPlayer player = new LucidPlayer();
    private Vibrator vibrator;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$0(Preference preference) {
        ViewIntent.url(this, "https://sleep.urbandroid.org/docs//sleep/lucid_dreaming.html");
        return false;
    }

    private void setPreferenceListener(PreferenceScreen preferenceScreen, String str) {
        ListPreference listPreference = (ListPreference) preferenceScreen.findPreference(str);
        if (listPreference != null) {
            listPreference.setSummary(listPreference.getEntry());
            listPreference.setOnPreferenceChangeListener(this);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/lucid_dreaming.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return Experiments.getInstance().isActigraphyImprovementsExperiment1() ? R.xml.settings_lucid : R.xml.settings_lucid_without_sensitivity;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.settings_category_lucid_title;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 36451 && i2 == -1) {
            findPreference("lucid_ringtone").setSummary(intent.getStringExtra("extra_alert_title"));
            SharedApplicationContext.getSettings().setLucidRingtone(intent.getStringExtra("extra_alert_uri"));
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        LucidPlayer lucidPlayer = this.player;
        if (lucidPlayer != null) {
            lucidPlayer.stop(this);
        }
        Vibrator vibrator = this.vibrator;
        if (vibrator != null) {
            vibrator.cancel();
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(final PreferenceActivity preferenceActivity, boolean z) {
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        setPreferenceListener(preferenceScreen, "lucid_loop");
        Preference preferenceFindPreference = findPreference("lucid_expl");
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda0(this, 4));
        }
        Preference preferenceFindPreference2 = preferenceScreen.findPreference("lucid_enabled");
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.LucidSettingsActivity.1
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    if (((CheckBoxPreference) preference).isChecked()) {
                        SharedApplicationContext.getSettings().setLucidEnabled(true);
                    } else {
                        SharedApplicationContext.getSettings().setLucidEnabled(false);
                    }
                    return true;
                }
            });
        }
        Preference preferenceFindPreference3 = preferenceScreen.findPreference("lucid_ringtone");
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.LucidSettingsActivity.2
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    Intent intent = new Intent(preferenceActivity, (Class<?>) MediaListActivity.class);
                    intent.putExtra("extra_alert_multiple", false);
                    intent.putExtra("extra_allow_playlist", true);
                    intent.putExtra("extra_alert_radio", false);
                    intent.putExtra("extra_integration", false);
                    intent.putExtra("extra_silent", true);
                    intent.putExtra("extra_alert_uri", SharedApplicationContext.getSettings().getLucidRingtone());
                    preferenceActivity.startActivityForResult(intent, 36451);
                    return true;
                }
            });
        }
        Preference preferenceFindPreference4 = preferenceScreen.findPreference("lucid_after");
        if (preferenceFindPreference4 != null) {
            ListPreference listPreference = (ListPreference) preferenceFindPreference4;
            CharSequence[] entries = listPreference.getEntries();
            for (int i = 0; i < entries.length; i++) {
                if (i == 0) {
                    entries[i] = getString(R.string.from_start);
                } else if (i == 1) {
                    entries[i] = getString(R.string.after_time, getString(R.string.hour));
                } else {
                    entries[i] = getString(R.string.after_time, getString(R.string.hours, String.valueOf(i)));
                }
                if ((i + "").equals(listPreference.getValue())) {
                    preferenceFindPreference4.setSummary(entries[i]);
                }
            }
            listPreference.setEntries(entries);
        }
        Preference preferenceFindPreference5 = preferenceScreen.findPreference("lucid_preview");
        if (preferenceFindPreference5 != null) {
            preferenceFindPreference5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.LucidSettingsActivity.3
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    SmartLight smartLight;
                    Settings settings = new Settings(preferenceActivity);
                    try {
                        LucidSettingsActivity.this.player.stop(LucidSettingsActivity.this);
                        final int lucidLoop = settings.getLucidLoop();
                        LucidSettingsActivity.this.player.play(preferenceActivity, !settings.isHintHeadphonesOnly() ? 4 : 3, SharedApplicationContext.getSettings().getLucidVolume(), Uri.parse(SharedApplicationContext.getSettings().getLucidRingtone()), lucidLoop);
                        new Handler();
                        if (settings.isSmartLightLucidDreaming() && (smartLight = SmartLightProvider.getSmartLight(preferenceActivity.getApplicationContext())) != null) {
                            smartLight.hint(lucidLoop);
                        }
                        if (!settings.isLucidVibrate()) {
                            return true;
                        }
                        SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(preferenceActivity);
                        if (smartWatch != null) {
                            Logger.logInfo("GenericWatch: hint");
                            smartWatch.hint(lucidLoop);
                            return true;
                        }
                        int i2 = lucidLoop * 2;
                        final long[] jArr = new long[i2];
                        for (int i3 = 0; i3 < i2; i3 += 2) {
                            jArr[i3] = 3000;
                            jArr[i3 + 1] = 500;
                        }
                        if (settings.getSelectedWearable() != null) {
                            SmartWatchProvider.asyncSmartwatchConnect(preferenceActivity, new AbstractConnectivityCallback() { // from class: com.urbandroid.sleep.alarmclock.settings.LucidSettingsActivity.3.1
                                @Override // com.urbandroid.sleep.smartwatch.AbstractConnectivityCallback
                                public void doStatus(SmartWatch smartWatch2, boolean z2) {
                                    Logger.logInfo("Async connect");
                                    if (smartWatch2 != null && z2) {
                                        smartWatch2.hint(lucidLoop);
                                        return;
                                    }
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    LucidSettingsActivity.this.vibrator = (Vibrator) preferenceActivity.getSystemService("vibrator");
                                    Logger.logInfo("LucidSettingsActivity: vibrate()");
                                    LucidSettingsActivity.this.vibrator.vibrate(jArr, -1);
                                }
                            }, 2000L, false);
                            return true;
                        }
                        LucidSettingsActivity.this.vibrator = (Vibrator) preferenceActivity.getSystemService("vibrator");
                        Logger.logInfo("LucidSettingsActivity: vibrate()");
                        LucidSettingsActivity.this.vibrator.vibrate(jArr, -1);
                        return true;
                    } catch (Exception e) {
                        Logger.logSevere(e);
                        return true;
                    }
                }
            });
        }
        LamerPreferenceCategory.init(preferenceActivity, preferenceScreen, z || new Settings(preferenceActivity).isExpandAllSettings(), "settings_category_ringtone");
    }
}
