package com.urbandroid.sleep.alarmclock.settings;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.login.widget.ToolTipPopup;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.hecz.common.logging.Log;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.PermissionCompat;
import com.urbandroid.common.util.PowerManagerCompat;
import com.urbandroid.common.util.RootUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.common.wifi.WifiEnabler;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SensorPreviewActivity;
import com.urbandroid.sleep.SleepTest;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionInitializer;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionPermission;
import com.urbandroid.sleep.activityrecognition.SleepTimeSuggestionManager;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.autostart.AutoTrackingScheduler;
import com.urbandroid.sleep.gui.MaterialDialogListPreference;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.pref.LamerPreferenceCategory;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.Wearable;
import com.urbandroid.util.SleepPermissionCompat;

/* JADX INFO: loaded from: classes4.dex */
public class TrackSettingsActivity extends SimpleSettingsActivity {
    private CheckBoxPreference priorityPreference;
    private ListPreference sensorPref;
    private MaterialDialogListPreference sleepSuggestionPreference;

    private void initiateAccelSensorTest(Context context) {
        context.startActivity(new Intent(context, (Class<?>) SleepTest.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initiateSonarSensorTest(Activity activity) {
        new MaterialAlertDialogBuilder(this).setTitle(R.string.sensor_sonar).setMessage(R.string.step_sonar_headphones).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setPositiveButton((CharSequence) getString(R.string.agree), (DialogInterface.OnClickListener) new TrackSettingsActivity$$ExternalSyntheticLambda8(activity, 0)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initiateSonarSensorTest$7(Activity activity, DialogInterface dialogInterface, int i) {
        Logger.logInfo("TrackSettingsActivity: start sensor for result");
        Intent intent = new Intent(activity, (Class<?>) SleepTest.class);
        intent.putExtra("check_sonar_support", true);
        activity.startActivityForResult(intent, 885);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestPermissionsResult$8() {
        if (SharedApplicationContext.getSettings().getAutoStartMode() == 1) {
            highlightPref(getPreferenceScreen(), "auto_start_track_smart", getListView(), 0);
        } else {
            highlightPref(getPreferenceScreen(), "sleep_time_suggestion_selected_mode", getListView(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$0(Preference preference) {
        ViewIntent.url(this, "https://sleep.urbandroid.org/docs//sleep/sleep_tracking.html");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$1(PreferenceActivity preferenceActivity, Preference preference) {
        preferenceActivity.startActivity(new Intent(preferenceActivity, (Class<?>) TrackAutoSettingsActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$2(PreferenceActivity preferenceActivity, Preference preference) {
        if (SharedApplicationContext.getSettings().isUltrasonicTracking()) {
            initiateSonarSensorTest(preferenceActivity);
            return true;
        }
        initiateAccelSensorTest(preferenceActivity);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$3(PreferenceActivity preferenceActivity, Preference preference) {
        preferenceActivity.startActivity(new Intent(preferenceActivity, (Class<?>) SensorPreviewActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$4(PreferenceActivity preferenceActivity, Preference preference) {
        preferenceActivity.startActivity(new Intent(preferenceActivity, (Class<?>) SmartwatchSettingsActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$5(PreferenceActivity preferenceActivity, Preference preference) {
        preferenceActivity.startActivity(new Intent(preferenceActivity, (Class<?>) PairSettingsActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$6(Settings settings, PreferenceActivity preferenceActivity, Preference preference, Object obj) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoStartPrefSummaryIfNeeded(boolean z, int i) {
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
        return "https://sleep.urbandroid.org/docs//sleep/sleep_tracking.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return Build.VERSION.SDK_INT >= 29 ? R.xml.settings_track_29 : R.xml.settings_track;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.settings_category_track;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        zza$$ExternalSyntheticOutline0.m(i2, i, "TrackSettingsActivity: result ", " ");
        if (i == 312) {
            if (PowerManagerCompat.isIgnoringBatteryOptimizations(this)) {
                SharedApplicationContext.getSettings().setBatteryOptimized(true);
                return;
            }
            log("TrackSettingsActivity: Still not ignoring battery opts");
            SharedApplicationContext.getSettings().setBatteryOptimized(false);
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("sensor_batching");
            if (checkBoxPreference != null) {
                checkBoxPreference.setChecked(false);
                return;
            }
            return;
        }
        if (i == 885) {
            zza$$ExternalSyntheticOutline0.m(i2, "TrackSettingsActivity: sonar support result ");
            if (i2 == 6) {
                SharedApplicationContext.getSettings().setSonarSupported(false);
                SharedApplicationContext.getSettings().setUltrasonicTracking(false);
                ListPreference listPreference = this.sensorPref;
                if (listPreference != null) {
                    listPreference.setSummary(listPreference.getContext().getResources().getStringArray(R.array.non_deep_sleep_method_entries)[0]);
                    this.sensorPref.setValue(String.valueOf(0));
                    return;
                }
                return;
            }
            if (i2 != 5) {
                if (i2 == 7) {
                    Toast.makeText(this, R.string.please_wait, 1).show();
                    new Handler().postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.14
                        @Override // java.lang.Runnable
                        public void run() {
                            TrackSettingsActivity trackSettingsActivity = TrackSettingsActivity.this;
                            trackSettingsActivity.initiateSonarSensorTest(trackSettingsActivity);
                        }
                    }, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
                    return;
                }
                return;
            }
            SharedApplicationContext.getSettings().setSonarSupported(true);
            SharedApplicationContext.getSettings().setUltrasonicTracking(true);
            ListPreference listPreference2 = this.sensorPref;
            if (listPreference2 != null) {
                listPreference2.setSummary(listPreference2.getContext().getString(R.string.sensor_sonar));
                this.sensorPref.setValue(String.valueOf(2));
            }
        }
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

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i != 2) {
            return super.onCreateDialog(i);
        }
        final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("offscreen_tracking_force");
        return new MaterialAlertDialogBuilder(this).setTitle(R.string.offscreen_tracking_force_title).setMessage(R.string.offscreen_tracking_force_summary_approve).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (!checkBoxPreference.isChecked()) {
                    Logger.logWarning("Inconsistent isCheck with assumed state. The checkbox should be checked when we show this dialog.");
                    ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "Inconsistent checkbox state.");
                } else {
                    Logger.logInfo("Enabling force-screen on.");
                    SharedApplicationContext.getSettings().setForceScreenOff(true);
                    TrackSettingsActivity.this.dismissDialog(2);
                }
            }
        }).setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                checkBoxPreference.setChecked(false);
                TrackSettingsActivity.this.dismissDialog(2);
            }
        }).create();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public void onCreatePreference(Bundle bundle) {
        super.onCreatePreference(bundle);
        this.priorityPreference = (CheckBoxPreference) ((PreferenceGroup) getPreferenceScreen().findPreference("settings_category_dnd")).findPreference("mute_alerts_priority");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 228) {
            if (i == 229) {
                if (iArr[0] == -1) {
                    ViewIntent.getPermissionDenyDialogBuilder(this, strArr[0], R.string.automatic_sleep_tracking).show();
                }
                this.handler.postDelayed(new ActivityCompat$$ExternalSyntheticLambda0(this, 28), 1000L);
                return;
            } else {
                if (i != 972) {
                    return;
                }
                SharedApplicationContext.getSettings().setPriorityMode(iArr[0] == 0);
                CheckBoxPreference checkBoxPreference = this.priorityPreference;
                if (checkBoxPreference != null) {
                    checkBoxPreference.setChecked(iArr[0] == 0);
                    return;
                }
                return;
            }
        }
        if (iArr[0] != 0) {
            ViewIntent.getPermissionDenyDialogBuilder(this, "android.permission.RECORD_AUDIO", R.string.sensor_sonar).show();
            return;
        }
        if (SharedApplicationContext.getSettings().isSonarSupported() == null || !SharedApplicationContext.getSettings().isSonarSupported().booleanValue()) {
            initiateSonarSensorTest(this);
            return;
        }
        ListPreference listPreference = this.sensorPref;
        if (listPreference != null) {
            listPreference.setSummary(listPreference.getContext().getString(R.string.sensor_sonar));
            this.sensorPref.setValue(String.valueOf(2));
            SharedApplicationContext.getSettings().setUltrasonicTracking(true);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(final PreferenceActivity preferenceActivity, boolean z) {
        final PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        Preference preferenceFindPreference = findPreference("track_expl");
        int i = 11;
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda0(this, i));
        }
        Preference preferenceFindPreference2 = preferenceScreen.findPreference("settings_category_automagic");
        if (preferenceFindPreference2 != null) {
            try {
                preferenceFindPreference2.setSummary(getResources().getStringArray(R.array.auto_start_entries)[SharedApplicationContext.getSettings().getAutoStartMode()]);
            } catch (Exception e) {
                Logger.logSevere(e);
            }
            preferenceFindPreference2.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 19));
        }
        Preference preferenceFindPreference3 = preferenceScreen.findPreference("test_sensors");
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new AlarmSettingsActivity$$ExternalSyntheticLambda4(this, preferenceActivity, i));
        }
        Preference preferenceFindPreference4 = preferenceScreen.findPreference("tutorial");
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 20));
        }
        Preference preferenceFindPreference5 = preferenceScreen.findPreference("selected_wearable");
        if (preferenceFindPreference5 != null) {
            Wearable selectedWearable = SharedApplicationContext.getSettings().getSelectedWearable();
            if (selectedWearable != null) {
                preferenceFindPreference5.setSummary(selectedWearable.getName(this));
            }
            preferenceFindPreference5.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 21));
        }
        Preference preferenceFindPreference6 = preferenceScreen.findPreference("settings_category_pair_tracking");
        if (preferenceFindPreference6 != null) {
            if (SharedApplicationContext.getSettings().getPairTrackingToken() != null) {
                preferenceFindPreference6.setSummary(R.string.paired_successfully);
            } else {
                preferenceFindPreference6.setSummary(R.string.pair_tracking_summary);
            }
            preferenceFindPreference6.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 22));
        }
        Preference preferenceFindPreference7 = preferenceScreen.findPreference("settings_category_awake");
        if (preferenceFindPreference7 != null) {
            float awakeDetectionSensitivityAvg = SharedApplicationContext.getSettings().getAwakeDetectionSensitivityAvg();
            preferenceFindPreference7.setSummary(getString(awakeDetectionSensitivityAvg >= 2.5f ? R.string.high_sensitivity : awakeDetectionSensitivityAvg >= 1.5f ? R.string.medium_sensitivity : R.string.low_sensitivity));
            preferenceFindPreference7.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.1
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    preferenceActivity.startActivity(new Intent(preferenceActivity, (Class<?>) AwakeSettingsActivity.class));
                    return true;
                }
            });
        }
        Preference preferenceFindPreference8 = preferenceScreen.findPreference("auto_start_read_more");
        if (preferenceFindPreference8 != null) {
            preferenceFindPreference8.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.2
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    ViewIntent.url(TrackSettingsActivity.this, "https://sleep.urbandroid.org/docs//sleep/automatic_sleep_tracking.html");
                    return true;
                }
            });
        }
        Preference preferenceFindPreference9 = preferenceScreen.findPreference("estimate_read_more");
        if (preferenceFindPreference9 != null) {
            preferenceFindPreference9.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.3
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    ViewIntent.url(TrackSettingsActivity.this, "https://sleep.urbandroid.org/docs//sleep/sleep_time_estimation.html");
                    return true;
                }
            });
        }
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preferenceScreen.findPreference("offscreen_tracking_force");
        if (checkBoxPreference != null) {
            checkBoxPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.4
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    if (((CheckBoxPreference) preference).isChecked()) {
                        preferenceActivity.showDialog(2);
                        return true;
                    }
                    Logger.logInfo("Disabling force screen off..");
                    SharedApplicationContext.getSettings().setForceScreenOff(false);
                    return true;
                }
            });
        }
        final Settings settings = new Settings(preferenceActivity);
        CheckBoxPreference checkBoxPreference2 = this.priorityPreference;
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.5
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    if (!((Boolean) obj).booleanValue() || ((NotificationManager) preferenceActivity.getSystemService("notification")).isNotificationPolicyAccessGranted()) {
                        return true;
                    }
                    Logger.logInfo("Settings: Request ACCESS_NOTIFICATION_POLICY permission");
                    try {
                        preferenceActivity.startActivity(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"));
                        return true;
                    } catch (Exception unused) {
                        Logger.logSevere("Cannot start notification policy settings..");
                        return true;
                    }
                }
            });
        }
        Preference preferenceFindPreference10 = ((PreferenceGroup) preferenceScreen.findPreference("settings_category_dnd")).findPreference("mute_alerts");
        if (preferenceFindPreference10 != null) {
            preferenceFindPreference10.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.6
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    Boolean bool = (Boolean) obj;
                    if (bool.booleanValue() && !((NotificationManager) preferenceActivity.getSystemService("notification")).isNotificationPolicyAccessGranted()) {
                        Logger.logInfo("Settings: Request ACCESS_NOTIFICATION_POLICY permission");
                        try {
                            preferenceActivity.startActivity(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"));
                        } catch (Exception unused) {
                        }
                    }
                    Logger.logInfo("DND Priority " + TrackSettingsActivity.this.priorityPreference);
                    if (TrackSettingsActivity.this.priorityPreference == null || !Environment.isMOrGreater()) {
                        return true;
                    }
                    if (!bool.booleanValue()) {
                        ((PreferenceGroup) preferenceScreen.findPreference("settings_category_dnd")).removePreference(TrackSettingsActivity.this.priorityPreference);
                        return true;
                    }
                    Logger.logInfo("DND Priority adding " + TrackSettingsActivity.this.priorityPreference);
                    ((PreferenceGroup) preferenceScreen.findPreference("settings_category_dnd")).addPreference(TrackSettingsActivity.this.priorityPreference);
                    return true;
                }
            });
        }
        ListPreference listPreference = (ListPreference) preferenceScreen.findPreference("non_deep_sleep_method");
        this.sensorPref = listPreference;
        if (listPreference != null) {
            listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.7
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    int i2 = Integer.parseInt(obj.toString());
                    if (i2 == 2) {
                        if (!SleepPermissionCompat.INSTANCE.isPermissionGranted(preferenceActivity, "android.permission.RECORD_AUDIO")) {
                            PermissionCompat.requestPermission(preferenceActivity, "android.permission.RECORD_AUDIO", 228);
                            return false;
                        }
                        if (settings.isSonarSupported() == null || !settings.isSonarSupported().booleanValue()) {
                            TrackSettingsActivity.this.initiateSonarSensorTest(preferenceActivity);
                            return false;
                        }
                    }
                    SimpleSettingsActivity.fillSummaryWithValue((ListPreference) preference, obj);
                    TrackSettingsActivity.this.updateAutoStartPrefSummaryIfNeeded(i2 == 2, settings.getAutoStartMode());
                    return true;
                }
            });
        }
        Preference preferenceFindPreference11 = preferenceScreen.findPreference("sensor_batching");
        PreferenceGroup preferenceGroup = (PreferenceGroup) preferenceScreen.findPreference("settings_category_track");
        if (!Settings.isSensorBatchingSupported(preferenceActivity)) {
            log("Removing sensor batching preference.");
            if (preferenceFindPreference11 != null) {
                preferenceGroup.removePreference(preferenceFindPreference11);
            }
        } else if (preferenceFindPreference11 != null) {
            log("Keeping sensor batching preference.");
            preferenceFindPreference11.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.8
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    SharedApplicationContext.getSettings().setBatteryOptimized(((Boolean) obj).booleanValue());
                    TrackSettingsActivity.this.log("SensorBatching: " + obj);
                    return true;
                }
            });
        }
        if (preferenceScreen.findPreference("airplane_mode") != null) {
            preferenceScreen.findPreference("airplane_mode").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.9
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    if (obj.toString().equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) && Environment.isNewJellyBeanOrGreater() && !new RootUtil().isDeviceRooted() && !TrialFilter.getInstance().isDozzzer()) {
                        new MaterialAlertDialogBuilder(preferenceActivity).setTitle(R.string.airplane_preference_title).setMessage(R.string.airplane_explain).setPositiveButton(R.string.install_button, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.9.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                ViewIntent.market(preferenceActivity, "com.urbandroid.dozzzer");
                            }
                        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.9.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        }).show();
                    }
                    WifiEnabler.getInstance().setForceClose(Integer.valueOf(obj.toString()).intValue() > 0);
                    SimpleSettingsActivity.fillSummaryWithValue((ListPreference) preference, obj);
                    return true;
                }
            });
        }
        int i2 = 0;
        LamerPreferenceCategory.init(preferenceActivity, preferenceScreen, z || new Settings(preferenceActivity).isExpandAllSettings(), "settings_category_control", "settings_category_dnd", "settings_category_auto_start");
        Preference preferenceFindPreference12 = findPreference("auto_start_track_smart");
        if (preferenceFindPreference12 != null) {
            updateAutoStartPrefSummaryIfNeeded(settings.isUltrasonicTracking(), settings.getAutoStartMode());
            preferenceFindPreference12.setOnPreferenceChangeListener(new TrackSettingsActivity$$ExternalSyntheticLambda7(this, settings, preferenceActivity, i2));
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
                this.sleepSuggestionPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.10
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
                        SimpleSettingsActivity.fillSummaryWithValue(TrackSettingsActivity.this.sleepSuggestionPreference, obj);
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
        Preference preferenceFindPreference13 = preferenceScreen.findPreference("key_use_google_sleep_api");
        if (preferenceFindPreference13 != null) {
            preferenceFindPreference13.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity.11
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
