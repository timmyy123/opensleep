package com.urbandroid.sleep.alarmclock.settings;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.directorypicker.DirectoryPicker;
import com.urbandroid.sleep.gui.GraphListClickHandler$$ExternalSyntheticLambda2;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.pref.LamerPreferenceCategory;
import com.urbandroid.sleep.media.InternalRingtones;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.media.NoiseDirectory;
import com.urbandroid.sleep.mic.AntiSnorer;
import com.urbandroid.sleep.mic.BaseRecordingWriter;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda4;
import com.urbandroid.sleep.smartlight.SmartLight;
import com.urbandroid.sleep.smartlight.SmartLightProvider;
import com.urbandroid.sleep.smartwatch.IConnectivityCallback;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import com.urbandroid.util.SleepPermissionCompat;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class NoiseSettingsActivity extends SimpleSettingsActivity {
    private Preference antisnoringHeadphonesPref;
    private Preference antisnoringLoopPref;
    private Preference antisnoringPreviewPref;
    private Preference antisnoringRingtonePref;
    private Preference antisnoringVolumePref;
    private boolean permissionDenied = false;
    private Set<Preference> removedPreferences = new HashSet();

    private void addListenerToPreference(Preference preference, Preference.OnPreferenceChangeListener onPreferenceChangeListener) {
        if (preference != null) {
            preference.setOnPreferenceChangeListener(onPreferenceChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkPermission(PreferenceActivity preferenceActivity) {
        ArrayList arrayList = new ArrayList();
        SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
        if (!sleepPermissionCompat.isPermissionGranted(preferenceActivity, "android.permission.RECORD_AUDIO") && SharedApplicationContext.getSettings().isDoingMicrophoneRecording() && !this.permissionDenied) {
            Logger.logInfo("Permissions: RECORD AUDIO Request ");
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (Build.VERSION.SDK_INT < 33) {
            if (!sleepPermissionCompat.isPermissionGranted(preferenceActivity, "android.permission.WRITE_EXTERNAL_STORAGE") && ((SharedApplicationContext.getSettings().isRecordingEnabled() || SharedApplicationContext.getSettings().isExperimentalNoiseRecoringEnabled()) && !this.permissionDenied)) {
                Logger.logInfo("Permissions: STORAGE Request ");
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (!sleepPermissionCompat.isPermissionGranted(preferenceActivity, "android.permission.READ_EXTERNAL_STORAGE") && ((SharedApplicationContext.getSettings().isRecordingEnabled() || SharedApplicationContext.getSettings().isExperimentalNoiseRecoringEnabled()) && !this.permissionDenied)) {
                Logger.logInfo("Permissions: STORAGE Request ");
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            }
        } else if (!sleepPermissionCompat.isPermissionGranted(preferenceActivity, "android.permission.READ_MEDIA_AUDIO") && ((SharedApplicationContext.getSettings().isRecordingEnabled() || SharedApplicationContext.getSettings().isExperimentalNoiseRecoringEnabled()) && !this.permissionDenied)) {
            Logger.logInfo("Permissions: STORAGE Request ");
            arrayList.add("android.permission.READ_MEDIA_AUDIO");
        }
        if (arrayList.size() <= 0) {
            return true;
        }
        sleepPermissionCompat.requestPermissions(preferenceActivity, (String[]) arrayList.toArray(new String[arrayList.size()]), 972);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$0(Preference preference) {
        ViewIntent.url(this, "https://sleep.urbandroid.org/docs//sleep/sleep_noise_recording.html");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refresh$1() {
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$10(PreferenceActivity preferenceActivity, Preference preference) {
        Intent intent = new Intent(preferenceActivity, (Class<?>) MediaListActivity.class);
        intent.putExtra("extra_alert_multiple", false);
        intent.putExtra("extra_allow_playlist", true);
        intent.putExtra("extra_alert_radio", false);
        intent.putExtra("extra_integration", false);
        intent.putExtra("extra_silent", true);
        intent.putExtra("extra_alert_uri", SharedApplicationContext.getSettings().getAntisnoringRingtone());
        startActivityForResult(intent, 36444);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$2(PreferenceActivity preferenceActivity, Preference preference, Object obj) {
        new Handler().post(new NoiseSettingsActivity$$ExternalSyntheticLambda9(this, 1));
        this.permissionDenied = false;
        checkPermission(preferenceActivity);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refresh$3() {
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$4(Settings settings, Preference preference) {
        new Handler().post(new NoiseSettingsActivity$$ExternalSyntheticLambda9(this, 0));
        settings.clearNoiseDirUri();
        settings.resetScopedStorage();
        Logger.logInfo("Noise: storage reset " + settings.getNoiseStoragePath());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$5(final Settings settings, PreferenceActivity preferenceActivity, Preference preference) {
        SmartLight smartLight;
        if (settings.isAntiSnoringNotification()) {
            Alarms.showAntiSnoringNotification(preferenceActivity, this.h, settings.getAntiSnoringLoop());
            return true;
        }
        new AntiSnorer(preferenceActivity, false).performResponse();
        int recordingAntisnoreResponse = SharedApplicationContext.getSettings().getRecordingAntisnoreResponse();
        if (settings.isSmartwatchEnabled() && (recordingAntisnoreResponse == 3 || recordingAntisnoreResponse == 2)) {
            SmartWatchProvider.asyncSmartwatchConnect(preferenceActivity, new IConnectivityCallback() { // from class: com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity.1
                @Override // com.urbandroid.sleep.smartwatch.IConnectivityCallback
                public void cancel() {
                    Logger.logInfo("NoiseSettings: preview cancel()");
                }

                @Override // com.urbandroid.sleep.smartwatch.IConnectivityCallback
                public boolean isCancelled() {
                    return false;
                }

                @Override // com.urbandroid.sleep.smartwatch.IConnectivityCallback
                public void status(SmartWatch smartWatch, boolean z) {
                    Logger.logInfo("NoiseSettings: preview " + z + " " + smartWatch);
                    if (!z || smartWatch == null) {
                        return;
                    }
                    smartWatch.hint(settings.getAntiSnoringLoop());
                }
            }, 15000L, false);
        }
        if (!settings.isSmartLightAntiSnoring() || (smartLight = SmartLightProvider.getSmartLight(preferenceActivity)) == null) {
            return true;
        }
        smartLight.hint();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$6(Preference preference) {
        startActivity(new Intent(this, (Class<?>) SoundRecognitionSettingsActivity.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$7(Settings settings, PreferenceActivity preferenceActivity, Preference preference) {
        if (((CheckBoxPreference) preference).isChecked()) {
            settings.setNoiseStatsCollecting(true);
            checkPermission(preferenceActivity);
        } else {
            settings.setNoiseStatsCollecting(false);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$refresh$8(Settings settings, Preference preference, DialogInterface dialogInterface, int i) {
        settings.clearNoiseDirUri();
        preference.setSummary(settings.getNoiseStoragePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$9(Settings settings, final PreferenceActivity preferenceActivity, Preference preference, Preference preference2) {
        if (settings.hasNoiseDirUri()) {
            new MaterialAlertDialogBuilder(preferenceActivity).setTitle(R.string.storage_path).setMessage((CharSequence) NoiseDirectory.getHumanReadablePath(settings.getNoiseDirUri())).setPositiveButton(R.string.set_time, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DirectoryPicker.open(preferenceActivity, 111);
                }
            }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setNeutralButton(R.string.reset, (DialogInterface.OnClickListener) new GraphListClickHandler$$ExternalSyntheticLambda2(settings, preference, 3)).show();
            return true;
        }
        DirectoryPicker.open(preferenceActivity, 111);
        return true;
    }

    private void setNoisePathSummary(Uri uri) {
        Preference preferenceFindPreference;
        if (uri == null || (preferenceFindPreference = findPreference("noise_storage_lollipop_path")) == null) {
            return;
        }
        preferenceFindPreference.setSummary(NoiseDirectory.getHumanReadablePath(uri));
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/sleep_noise_recording.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_noise;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.sleep_recording_title;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Settings settings = SharedApplicationContext.getSettings();
        if (Environment.isLollipopOrGreater() && i == 111 && i2 == -1) {
            Uri directoryPicked = DirectoryPicker.parseDirectoryPicked(SharedApplicationContext.getInstance().getContext(), intent);
            if (NoiseDirectory.checkReadWriteAccessUri(SharedApplicationContext.getInstance().getContext(), directoryPicked)) {
                Logger.logInfo("Noise record directory set to: " + directoryPicked);
                setNoisePathSummary(directoryPicked);
                settings.setNoiseDirUri(directoryPicked);
            }
        }
        if (i == 36444 && i2 == -1) {
            try {
                findPreference("snoring_ringtone").setSummary(intent.getStringExtra("extra_alert_title"));
            } catch (Exception unused) {
            }
            settings.setAntisnoringRingtone(intent.getStringExtra("extra_alert_uri"));
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public void onCreatePreference(Bundle bundle) {
        super.onCreatePreference(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length != 0 && i == 972) {
            if (iArr[0] == 0) {
                Logger.logInfo("Permissions: RECORD AUDIO Granted ");
                return;
            }
            Logger.logInfo("Permissions: RECORD AUDIO Denied ");
            this.permissionDenied = true;
            new Settings(getApplicationContext()).setRecordingMasterSwitchEnabled(false);
            ((CheckBoxPreference) findPreference("noise_recording_master_switch")).setChecked(false);
            ViewIntent.getPermissionDenyDialogBuilder(this, "android.permission.RECORD_AUDIO", getString(R.string.deny_permission_recording)).show();
            new Handler().post(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    NoiseSettingsActivity.this.refresh();
                }
            });
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(final PreferenceActivity preferenceActivity, final boolean z) {
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        final Settings settings = new Settings(preferenceActivity);
        Preference preferenceFindPreference = preferenceScreen.findPreference("noise_expl");
        final int i = 0;
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ NoiseSettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i2 = i;
                    NoiseSettingsActivity noiseSettingsActivity = this.f$0;
                    switch (i2) {
                        case 0:
                            return noiseSettingsActivity.lambda$refresh$0(preference);
                        default:
                            return noiseSettingsActivity.lambda$refresh$6(preference);
                    }
                }
            });
        }
        Preference preferenceFindPreference2 = preferenceActivity.findPreference("noise_recording_master_switch");
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceChangeListener(new AddShortcutActivity$$ExternalSyntheticLambda4(this, preferenceActivity, 8));
        }
        Preference preferenceFindPreference3 = preferenceActivity.findPreference("noise_storage_path_reset");
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new AlarmSettingsActivity$$ExternalSyntheticLambda4(this, settings, 6));
        }
        if (!settings.isRecordingMasterSwitchEnabled()) {
            while (i < preferenceScreen.getPreferenceCount()) {
                Preference preference = preferenceScreen.getPreference(i);
                if (preference.getKey() != null && !"settings_category_noise_master_switch".equals(preference.getKey())) {
                    this.removedPreferences.add(preference);
                }
                i++;
            }
            Iterator<Preference> it = this.removedPreferences.iterator();
            while (it.hasNext()) {
                preferenceScreen.removePreference(it.next());
            }
            return;
        }
        if (this.removedPreferences.size() > 0) {
            Iterator<Preference> it2 = this.removedPreferences.iterator();
            while (it2.hasNext()) {
                preferenceScreen.addPreference(it2.next());
            }
            this.removedPreferences.clear();
        }
        checkPermission(preferenceActivity);
        PreferenceCategory preferenceCategory = (PreferenceCategory) preferenceScreen.findPreference("snoring_category");
        if (this.antisnoringPreviewPref == null) {
            this.antisnoringPreviewPref = preferenceActivity.findPreference("antisnoring_preview");
        }
        if (this.antisnoringPreviewPref != null) {
            if (preferenceCategory == null || !settings.getRecordingAntisnore()) {
                preferenceCategory.removePreference(this.antisnoringPreviewPref);
            } else {
                preferenceCategory.addPreference(this.antisnoringPreviewPref);
            }
            this.antisnoringPreviewPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity$$ExternalSyntheticLambda3
                public final /* synthetic */ NoiseSettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference2) {
                    int i2 = i;
                    PreferenceActivity preferenceActivity2 = preferenceActivity;
                    Settings settings2 = settings;
                    NoiseSettingsActivity noiseSettingsActivity = this.f$0;
                    switch (i2) {
                        case 0:
                            return noiseSettingsActivity.lambda$refresh$5(settings2, preferenceActivity2, preference2);
                        default:
                            return noiseSettingsActivity.lambda$refresh$7(settings2, preferenceActivity2, preference2);
                    }
                }
            });
        }
        final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preferenceScreen.findPreference("noise_stats");
        final CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) preferenceScreen.findPreference("sleep_recording");
        Preference.OnPreferenceChangeListener onPreferenceChangeListener = new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity.2
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference2, Object obj) {
                if (preference2 == null) {
                    return false;
                }
                if (preference2 instanceof ListPreference) {
                    SimpleSettingsActivity.fillSummaryWithValue((ListPreference) preference2, obj);
                }
                if (!NoiseSettingsActivity.this.checkPermission(preferenceActivity)) {
                    return false;
                }
                if (NoiseSettingsActivity.this.handler == null || !"anti_snoring_response".equals(preference2.getKey())) {
                    return true;
                }
                NoiseSettingsActivity.this.handler.post(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        NoiseSettingsActivity.this.refresh(preferenceActivity, z);
                    }
                });
                return true;
            }
        };
        addListenerToPreference(preferenceScreen.findPreference("snoring_detection"), onPreferenceChangeListener);
        addListenerToPreference(preferenceScreen.findPreference("anti_snoring_response"), onPreferenceChangeListener);
        Preference preferenceFindPreference4 = preferenceScreen.findPreference("sound_recognition");
        final int i2 = 1;
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.setSummary(settings.getSoundRecognitionEnabledNames());
            preferenceFindPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ NoiseSettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference2) {
                    int i22 = i2;
                    NoiseSettingsActivity noiseSettingsActivity = this.f$0;
                    switch (i22) {
                        case 0:
                            return noiseSettingsActivity.lambda$refresh$0(preference2);
                        default:
                            return noiseSettingsActivity.lambda$refresh$6(preference2);
                    }
                }
            });
        }
        if (checkBoxPreference != null) {
            checkBoxPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity$$ExternalSyntheticLambda3
                public final /* synthetic */ NoiseSettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference2) {
                    int i22 = i2;
                    PreferenceActivity preferenceActivity2 = preferenceActivity;
                    Settings settings2 = settings;
                    NoiseSettingsActivity noiseSettingsActivity = this.f$0;
                    switch (i22) {
                        case 0:
                            return noiseSettingsActivity.lambda$refresh$5(settings2, preferenceActivity2, preference2);
                        default:
                            return noiseSettingsActivity.lambda$refresh$7(settings2, preferenceActivity2, preference2);
                    }
                }
            });
            checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity.3
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference2, Object obj) {
                    if (checkBoxPreference2.isChecked()) {
                        return false;
                    }
                    return NoiseSettingsActivity.this.checkPermission(preferenceActivity);
                }
            });
        }
        if (checkBoxPreference2 != null) {
            if (checkBoxPreference2.isChecked() && checkBoxPreference != null) {
                checkBoxPreference.setChecked(true);
            }
            checkBoxPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity.4
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference2, Object obj) {
                    if (((obj instanceof Boolean) && obj.equals(Boolean.TRUE)) || ((obj instanceof String) && Integer.parseInt(obj.toString()) > 0)) {
                        settings.setNoiseStatsCollecting(true);
                        CheckBoxPreference checkBoxPreference3 = checkBoxPreference;
                        if (checkBoxPreference3 != null) {
                            checkBoxPreference3.setChecked(true);
                        }
                    }
                    return NoiseSettingsActivity.this.checkPermission(preferenceActivity);
                }
            });
        }
        final EditTextPreference editTextPreference = (EditTextPreference) preferenceScreen.findPreference("noise_storage_path");
        final Preference preferenceFindPreference5 = preferenceScreen.findPreference("noise_storage_lollipop_path");
        PreferenceCategory preferenceCategory2 = (PreferenceCategory) preferenceActivity.findPreference("settings_category_advanced");
        if (Environment.isLollipopOrGreater() && DirectoryPicker.isOpenDocumentTreeAvailable(preferenceActivity)) {
            Logger.logInfo("NoiseSettingsActivity: open document available");
            if (editTextPreference != null && preferenceCategory2 != null) {
                ((PreferenceGroup) preferenceCategory2.findPreference("settings_category_advanced")).removePreference(editTextPreference);
            }
            if (preferenceFindPreference5 != null) {
                if (settings.hasNoiseDirUri()) {
                    setNoisePathSummary(settings.getNoiseDirUri());
                } else {
                    preferenceFindPreference5.setSummary(settings.getNoiseStoragePath());
                }
                Logger.logInfo("Storage: " + settings.getNoiseStoragePath());
                preferenceFindPreference5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity$$ExternalSyntheticLambda6
                    @Override // android.preference.Preference.OnPreferenceClickListener
                    public final boolean onPreferenceClick(Preference preference2) {
                        return this.f$0.lambda$refresh$9(settings, preferenceActivity, preferenceFindPreference5, preference2);
                    }
                });
            }
        } else {
            Logger.logInfo("NoiseSettingsActivity: open document NOT available");
            if (preferenceFindPreference5 != null && preferenceCategory2 != null) {
                zza$$ExternalSyntheticOutline0.m("", ((PreferenceGroup) preferenceCategory2.findPreference("settings_category_advanced")).removePreference(preferenceFindPreference5));
            }
            if (editTextPreference != null) {
                String noiseStoragePath = settings.getNoiseStoragePath();
                editTextPreference.setText(noiseStoragePath);
                editTextPreference.setSummary(noiseStoragePath);
                editTextPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity.6
                    @Override // android.preference.Preference.OnPreferenceChangeListener
                    public boolean onPreferenceChange(Preference preference2, Object obj) {
                        File file = new File(obj.toString());
                        if (obj.toString().trim().length() == 0) {
                            file = new File(NoiseDirectory.getDefaultStoragePath(NoiseSettingsActivity.this));
                        }
                        if (Environment.isWritable(file)) {
                            settings.setNoiseStoragePath(file.getAbsolutePath());
                            editTextPreference.setSummary(file.getAbsolutePath());
                            return true;
                        }
                        Toast.makeText(preferenceActivity, NoiseSettingsActivity.this.getString(R.string.export_failed) + obj.toString() + BaseRecordingWriter.RECORD_PATH, 1).show();
                        return false;
                    }
                });
            }
        }
        if (this.antisnoringVolumePref == null) {
            this.antisnoringVolumePref = preferenceScreen.findPreference("antisnoring_volume");
        }
        if (this.antisnoringVolumePref != null) {
            if (preferenceCategory == null || !(settings.getRecordingAntisnoreResponse() == 1 || settings.getRecordingAntisnoreResponse() == 3)) {
                preferenceCategory.removePreference(this.antisnoringVolumePref);
            } else {
                preferenceCategory.addPreference(this.antisnoringVolumePref);
            }
        }
        if (this.antisnoringLoopPref == null) {
            this.antisnoringLoopPref = preferenceScreen.findPreference("antisnoring_loop");
        }
        if (this.antisnoringLoopPref != null) {
            if (preferenceCategory == null || !settings.getRecordingAntisnore()) {
                preferenceCategory.removePreference(this.antisnoringLoopPref);
            } else {
                preferenceCategory.addPreference(this.antisnoringLoopPref);
            }
        }
        if (this.antisnoringHeadphonesPref == null) {
            this.antisnoringHeadphonesPref = preferenceScreen.findPreference("hint_headphones_only");
        }
        if (this.antisnoringHeadphonesPref != null) {
            if (preferenceCategory == null || !(settings.getRecordingAntisnoreResponse() == 1 || settings.getRecordingAntisnoreResponse() == 3)) {
                preferenceCategory.removePreference(this.antisnoringHeadphonesPref);
            } else {
                preferenceCategory.addPreference(this.antisnoringHeadphonesPref);
            }
        }
        if (this.antisnoringRingtonePref == null) {
            this.antisnoringRingtonePref = preferenceScreen.findPreference("snoring_ringtone");
        }
        if (this.antisnoringRingtonePref != null) {
            if (preferenceCategory == null || !(settings.getRecordingAntisnoreResponse() == 1 || settings.getRecordingAntisnoreResponse() == 3)) {
                preferenceCategory.removePreference(this.antisnoringRingtonePref);
            } else {
                preferenceCategory.addPreference(this.antisnoringRingtonePref);
            }
            this.antisnoringRingtonePref.setOnPreferenceClickListener(new AlarmSettingsActivity$$ExternalSyntheticLambda4(this, preferenceActivity, 7));
            String antisnoringRingtone = settings.getAntisnoringRingtone();
            if (antisnoringRingtone != null) {
                int titleRes = InternalRingtones.getTitleRes(antisnoringRingtone);
                if (titleRes == -1) {
                    int iLastIndexOf = antisnoringRingtone.lastIndexOf(47);
                    if (iLastIndexOf != -1) {
                        antisnoringRingtone = antisnoringRingtone.substring(iLastIndexOf + 1);
                    }
                    int iLastIndexOf2 = antisnoringRingtone.lastIndexOf(46);
                    if (iLastIndexOf2 != -1) {
                        antisnoringRingtone = antisnoringRingtone.substring(0, iLastIndexOf2);
                    }
                    this.antisnoringRingtonePref.setSummary(antisnoringRingtone.replaceAll("[%][0-9A-F][0-9A-F]", " ").replaceAll("[_]", " "));
                } else {
                    this.antisnoringRingtonePref.setSummary(titleRes);
                }
            }
        }
        LamerPreferenceCategory.init(preferenceActivity, preferenceScreen, z || new Settings(preferenceActivity).isExpandAllSettings(), "settings_category_advanced");
    }
}
