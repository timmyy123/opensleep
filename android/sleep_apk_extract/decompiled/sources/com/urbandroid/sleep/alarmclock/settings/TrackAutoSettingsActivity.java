package com.urbandroid.sleep.alarmclock.settings;

import android.content.Intent;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.app.NotificationManagerCompat;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.hecz.common.logging.Log;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionInitializer;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionPermission;
import com.urbandroid.sleep.activityrecognition.SleepTimeSuggestionManager;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.autostart.AutoTrackingScheduler;
import com.urbandroid.sleep.gui.MaterialDialogListPreference;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.Wearable;

/* JADX INFO: loaded from: classes4.dex */
public class TrackAutoSettingsActivity extends SimpleSettingsActivity {
    private MaterialDialogListPreference sleepSuggestionPreference;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestPermissionsResult$2() {
        if (SharedApplicationContext.getSettings().getAutoStartMode() == 1) {
            highlightPref(getPreferenceScreen(), "auto_start_track_smart", getListView(), 0);
        } else {
            highlightPref(getPreferenceScreen(), "sleep_time_suggestion_selected_mode", getListView(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$0(Preference preference) {
        ViewIntent.url(this, "https://sleep.urbandroid.org/docs//sleep/automatic_sleep_tracking.html");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$1(Settings settings, PreferenceActivity preferenceActivity, Preference preference, Object obj) {
        int autoStartMode = settings.getAutoStartMode();
        int i = Integer.parseInt(obj.toString());
        zza$$ExternalSyntheticOutline0.m(autoStartMode, i, "AutoTracking: Changing settings ", " -> ");
        if (autoStartMode == 1 && i != 1) {
            AutoTrackingScheduler.cancelNextAlarm(preferenceActivity);
            AutoTrackingScheduler.cancelSchedule(preferenceActivity);
        }
        if (i == 2 || i == 3 || i == 0) {
            Alarms.setNextAlert(preferenceActivity);
        } else if (i == 1) {
            AutoTrackingScheduler.schedule(preferenceActivity);
        }
        if (i == 1) {
            ActivityRecognitionPermission.request(preferenceActivity);
        }
        if (i > 0) {
            AlarmSettingsActivity.askOverlay(this, 30, R.string.automatic_sleep_tracking, R.string.overlay_permission_mic_android11);
        }
        preference.setSummary(((ListPreference) preference).getEntries()[i]);
        return true;
    }

    private void updateAutoStartPrefSummaryIfNeeded(boolean z, int i) {
        Preference preferenceFindPreference = findPreference("auto_start_track_smart");
        if (preferenceFindPreference == null) {
            return;
        }
        boolean z2 = i == 1 && z && new Settings(getApplicationContext()).getSelectedWearable() == Wearable.NONE;
        String string = preferenceFindPreference.getSummary().toString();
        String str = "\n" + getString(R.string.sensor_sonar) + ": " + getString(R.string.auto_tracking_warning_charging);
        if (z2 && !string.endsWith(str)) {
            preferenceFindPreference.setSummary(string.concat(str));
        } else {
            if (z2 || !string.endsWith(str)) {
                return;
            }
            preferenceFindPreference.setSummary(string.substring(0, string.length() - str.length()));
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/automatic_sleep_tracking.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_track_auto;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.automatic_sleep_tracking;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Settings settings = new Settings(getApplicationContext());
        if (settings.getSleepTimeSuggestionMode() != SleepTimeSuggestionManager.Mode.DISABLED || settings.getAutoStartMode() == 1) {
            ActivityRecognitionPermission.request(this);
        }
        if (settings.getAutoStartMode() > 0) {
            AlarmSettingsActivity.askOverlay(this, 30, R.string.automatic_sleep_tracking, R.string.overlay_permission_mic_android11);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public void onCreatePreference(Bundle bundle) {
        super.onCreatePreference(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 229) {
            return;
        }
        if (iArr[0] == -1) {
            ViewIntent.getPermissionDenyDialogBuilder(this, strArr[0], R.string.automatic_sleep_tracking).show();
        }
        this.handler.postDelayed(new ActivityCompat$$ExternalSyntheticLambda0(this, 27), 1000L);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(final PreferenceActivity preferenceActivity, boolean z) {
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        final Settings settings = new Settings(preferenceActivity);
        Preference preferenceFindPreference = preferenceScreen.findPreference("auto_start_read_more");
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda0(this, 10));
        }
        Preference preferenceFindPreference2 = preferenceScreen.findPreference("estimate_read_more");
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackAutoSettingsActivity.1
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    ViewIntent.url(TrackAutoSettingsActivity.this, "https://sleep.urbandroid.org/docs//sleep/sleep_time_estimation.html");
                    return true;
                }
            });
        }
        Preference preferenceFindPreference3 = findPreference("auto_start_track_smart");
        if (preferenceFindPreference3 != null) {
            updateAutoStartPrefSummaryIfNeeded(settings.isUltrasonicTracking(), settings.getAutoStartMode());
            preferenceFindPreference3.setOnPreferenceChangeListener(new TrackSettingsActivity$$ExternalSyntheticLambda7(this, settings, preferenceActivity, 3));
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) preferenceScreen.findPreference("settings_category_auto_start");
        MaterialDialogListPreference materialDialogListPreference = (MaterialDialogListPreference) preferenceScreen.findPreference("sleep_time_suggestion_selected_mode");
        this.sleepSuggestionPreference = materialDialogListPreference;
        if (materialDialogListPreference != null) {
            boolean zIsActivitySensorBatchingSupported = ContextExtKt.isActivitySensorBatchingSupported(preferenceActivity.getApplicationContext());
            MaterialDialogListPreference materialDialogListPreference2 = this.sleepSuggestionPreference;
            if (zIsActivitySensorBatchingSupported) {
                preferenceCategory.addPreference(materialDialogListPreference2);
                if (this.sleepSuggestionPreference.getValue() == null) {
                    this.sleepSuggestionPreference.setValue("" + settings.getSleepTimeSuggestionMode().getCode());
                    this.sleepSuggestionPreference.setSummary(((Object) this.sleepSuggestionPreference.getEntry()) + "\n" + ((Object) this.sleepSuggestionPreference.getSummary()));
                }
                this.sleepSuggestionPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackAutoSettingsActivity.2
                    @Override // android.preference.Preference.OnPreferenceChangeListener
                    public boolean onPreferenceChange(Preference preference, Object obj) {
                        Log.info("Settings: Permissions Sleep suggestion " + obj);
                        ActivityRecognitionInitializer.Transition transitionTransitions = ActivityRecognitionInitializer.transitions(preferenceActivity.getApplicationContext());
                        if (Integer.parseInt(obj.toString()) == SleepTimeSuggestionManager.Mode.DISABLED.getCode()) {
                            transitionTransitions.destroy();
                        } else {
                            transitionTransitions.initialize();
                            ActivityRecognitionPermission.request(preferenceActivity);
                        }
                        SimpleSettingsActivity.fillSummaryWithValue(TrackAutoSettingsActivity.this.sleepSuggestionPreference, obj);
                        return true;
                    }
                });
                Intent intent = getIntent();
                if (intent != null && intent.getBooleanExtra("SHOW_SLEEP_SUGGESTION_MODES", false)) {
                    intent.putExtra("SHOW_SLEEP_SUGGESTION_MODES", false);
                    this.sleepSuggestionPreference.show();
                    int intExtra = intent.getIntExtra("notification_id", -1);
                    if (intExtra != -1) {
                        NotificationManagerCompat.from(preferenceActivity.getApplicationContext()).cancel(intExtra);
                    }
                }
            } else {
                preferenceCategory.removePreference(materialDialogListPreference2);
            }
        }
        Preference preferenceFindPreference4 = preferenceScreen.findPreference("key_use_google_sleep_api");
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackAutoSettingsActivity.3
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    settings.setGoogleSleepApiEnabledByUser(((Boolean) obj).booleanValue());
                    ActivityRecognitionInitializer.Transition transitionTransitions = ActivityRecognitionInitializer.transitions(preferenceActivity.getApplicationContext());
                    transitionTransitions.destroy();
                    transitionTransitions.initialize();
                    ActivityRecognitionPermission.request(preferenceActivity);
                    return true;
                }
            });
        }
    }
}
