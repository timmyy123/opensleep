package com.urbandroid.sleep.alarmclock.settings;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.PreferencesUtils;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepTest;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.pref.LamerPreferenceCategory;
import com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.Wearable;
import com.urbandroid.sleep.smartwatch.WearablesDialogFragment;
import com.urbandroid.sleep.smartwatch.polar.PolarDeviceLookupDialogFragment;
import com.urbandroid.util.BetaDialogFragment;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.SleepPermissionCompat;
import com.urbandroid.util.VolumeUtil$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes4.dex */
public class SmartwatchSettingsActivity extends SimpleSettingsActivity implements BleDeviceLookupDialogFragment.BleDeviceSelectionListener, WearablesDialogFragment.OnCloseListener {
    private Runnable runIfBlePermissionsGranted;
    private Preference smsTestPreference = null;

    private boolean checkPermission(Activity activity) {
        SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
        if (sleepPermissionCompat.isPermissionGranted(activity, "android.permission.BODY_SENSORS")) {
            return true;
        }
        Logger.logInfo("Permissions: BODY SENSORS Request ");
        sleepPermissionCompat.requestPermission(activity, "android.permission.BODY_SENSORS", 440);
        return false;
    }

    private boolean checkPermissionBt(Activity activity, String str) {
        return !SleepPermissionCompat.INSTANCE.requestLocationPermissionForBt(activity, "oximeter".equals(str) ? 339 : "selected_wearable".equals(str) ? 340 : 376, true);
    }

    private String getDescription(Wearable wearable) {
        return wearable == null ? "" : wearable.isDirectBleWearable() ? FileInsert$$ExternalSyntheticOutline0.m$1(wearable.getName(this), " - ", new Settings(this).getBleTrackingDevicePresentation()) : wearable.getName(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$10(PreferenceActivity preferenceActivity, Preference preference) {
        Intent intent = new Intent(preferenceActivity, (Class<?>) MediaListActivity.class);
        intent.putExtra("extra_alert_multiple", false);
        intent.putExtra("extra_allow_playlist", true);
        intent.putExtra("extra_alert_radio", false);
        intent.putExtra("extra_integration", false);
        intent.putExtra("extra_silent", true);
        intent.putExtra("extra_alert_uri", SharedApplicationContext.getSettings().getApneaAlarmRingtone());
        preferenceActivity.startActivityForResult(intent, 2634);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$2(Preference preference) {
        ViewIntent.url(this, "https://sleep.urbandroid.org/docs//devices/wearables.html");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$3(PreferenceActivity preferenceActivity, Preference preference) {
        showWearablesDialog(preferenceActivity);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$4(PreferenceScreen preferenceScreen, PreferenceActivity preferenceActivity, Preference preference) {
        if (SharedApplicationContext.getSettings().getSelectedWearable() != Wearable.NONE) {
            SleepTest.start(preferenceActivity);
            return true;
        }
        Toast.makeText(this, R.string.select_wearable, 0).show();
        highlightPref(preferenceScreen, "selected_wearable", getListView(), 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$5(PreferenceActivity preferenceActivity, Preference preference, Object obj) {
        if (((Boolean) obj).booleanValue()) {
            Toast.makeText(preferenceActivity, R.string.button_preview, 1).show();
            zza$$ExternalSyntheticOutline0.m(preferenceActivity.getApplicationContext(), "com.urbandroid.sleep.ACTION_APNEA_ALARM");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$6(PreferenceActivity preferenceActivity, Preference preference, Object obj) {
        if ((obj != null && !((Boolean) obj).booleanValue()) || !TrialFilter.getInstance().isAndroidWear()) {
            return true;
        }
        if (!Experiments.getInstance().showBetaDialogBecauseOfPermission()) {
            return checkPermission(preferenceActivity);
        }
        try {
            new BetaDialogFragment().show(preferenceActivity.getSupportFragmentManager(), "beta");
            return false;
        } catch (Exception e) {
            Logger.logSevere(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$7(final PreferenceActivity preferenceActivity, Preference preference, Object obj) {
        if (!((Boolean) obj).booleanValue()) {
            return true;
        }
        final String bleHrDevicePresentation = new Settings(preferenceActivity).getBleHrDevicePresentation();
        Runnable runnable = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartwatchSettingsActivity.2
            @Override // java.lang.Runnable
            public void run() {
                String str = bleHrDevicePresentation;
                if (str != null && !str.isEmpty()) {
                    new MaterialAlertDialogBuilder(preferenceActivity).setMessage((CharSequence) (preferenceActivity.getString(R.string.use, bleHrDevicePresentation) + "?")).setPositiveButton(R.string.yes, (DialogInterface.OnClickListener) null).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartwatchSettingsActivity.2.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (preferenceActivity.isFinishing()) {
                                return;
                            }
                            new Settings(preferenceActivity).setBleHrDevice(null, null);
                            BleDeviceLookupDialogFragment.INSTANCE.newInstance(BleDeviceLookupDialogFragment.Mode.HR_OR_OXIMETER).show(SmartwatchSettingsActivity.this.getSupportFragmentManager(), "btle");
                        }
                    }).show();
                    return;
                }
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null && !defaultAdapter.isEnabled()) {
                    preferenceActivity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 99);
                }
                if (preferenceActivity.isFinishing()) {
                    return;
                }
                try {
                    BleDeviceLookupDialogFragment.INSTANCE.newInstance(BleDeviceLookupDialogFragment.Mode.HR_OR_OXIMETER).show(preferenceActivity.getSupportFragmentManager(), "btle");
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
            }
        };
        if (checkPermissionBt(preferenceActivity, preference.getKey())) {
            runnable.run();
            return true;
        }
        this.runIfBlePermissionsGranted = runnable;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$8(Preference preference) {
        ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//devices/oximeter.html");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$9(Preference preference) {
        ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//devices/oximeter.html");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$regularWearableSelected$0(ViewGroup viewGroup, DialogInterface dialogInterface, int i) {
        String strTrim = ((EditText) viewGroup.findViewById(R.id.edit)).getText().toString().trim();
        if (strTrim.isEmpty()) {
            strTrim = null;
        }
        SharedApplicationContext.getSettings().setCustomWearableAddonPackage(strTrim);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$regularWearableSelected$1(PreferenceActivity preferenceActivity) {
        try {
            PolarDeviceLookupDialogFragment.INSTANCE.newInstance().show(preferenceActivity.getSupportFragmentManager(), "polar");
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    private void showWearablesDialog(PreferenceActivity preferenceActivity) {
        new WearablesDialogFragment().show(preferenceActivity.getSupportFragmentManager(), "wearableAddons");
    }

    @Override // com.urbandroid.sleep.smartwatch.WearablesDialogFragment.OnCloseListener
    public void bleWearableSelected(Activity activity, Wearable wearable) {
        if (wearable == null) {
            Logger.logWarning("SmartwatchSettingsActivity.bleWearableSelected: selectedWearable == null");
            return;
        }
        if (!(activity instanceof PreferenceActivity)) {
            Logger.logWarning("SmartwatchSettingsActivity.bleWearableSelected: ! (activity instanceof PreferenceActivity)");
            return;
        }
        if (activity.isFinishing()) {
            Logger.logWarning("SmartwatchSettingsActivity.bleWearableSelected: activity.isFinishing()");
        }
        final PreferenceActivity preferenceActivity = (PreferenceActivity) activity;
        Runnable runnable = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartwatchSettingsActivity.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BleDeviceLookupDialogFragment.INSTANCE.newInstance(BleDeviceLookupDialogFragment.Mode.FULL_TRACKING).show(preferenceActivity.getSupportFragmentManager(), "btle");
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
            }
        };
        if (checkPermissionBt(preferenceActivity, "selected_wearable")) {
            runnable.run();
        } else {
            this.runIfBlePermissionsGranted = runnable;
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//devices/wearables.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_smartwatch;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.smartwatch;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 2634 && i2 == -1) {
            findPreference("apnea_alarm_ringtone").setSummary(intent.getStringExtra("extra_alert_title"));
            SharedApplicationContext.getSettings().setApneaAlarmRingtone(intent.getStringExtra("extra_alert_uri"));
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.urbandroid.sleep.hr.BleDeviceLookupDialogFragment.BleDeviceSelectionListener
    public void onBleDeviceSelectionResult(BleDeviceLookupDialogFragment.Mode mode, BluetoothDevice bluetoothDevice) {
        boolean zEquals;
        Logger.logInfo("BTLE settings: mode=" + mode + ", device=" + bluetoothDevice);
        Settings settings = new Settings(this);
        if (mode == BleDeviceLookupDialogFragment.Mode.HR_OR_OXIMETER) {
            if (bluetoothDevice == null) {
                settings.setHrBt(false);
                settings.setOximeter(false);
            } else {
                settings.setBleHrDevice(bluetoothDevice.getAddress(), bluetoothDevice.getName() == null ? bluetoothDevice.getAddress() : bluetoothDevice.getName());
            }
            Preference preferenceFindPreference = findPreference("hr_bt");
            if (preferenceFindPreference != null) {
                preferenceFindPreference.setSummary(settings.getBleHrDevicePresentation());
                if (bluetoothDevice == null) {
                    ((CheckBoxPreference) preferenceFindPreference).setChecked(false);
                }
            }
            Preference preferenceFindPreference2 = findPreference("oximeter");
            if (preferenceFindPreference2 == null || bluetoothDevice != null) {
                return;
            }
            ((CheckBoxPreference) preferenceFindPreference2).setChecked(false);
            return;
        }
        if (mode != BleDeviceLookupDialogFragment.Mode.FULL_TRACKING) {
            Logger.logSevere("BTLE settings: invalid mode: " + mode);
            return;
        }
        if (bluetoothDevice == null) {
            settings.setSelectedWearable(Wearable.NONE);
            settings.setBleTrackingDevice(null, null);
        } else {
            try {
                zEquals = "InfiniTime".equals(bluetoothDevice.getName());
            } catch (Exception e) {
                Logger.logSevere(e);
                zEquals = true;
            }
            if (zEquals) {
                settings.setSelectedWearable(Wearable.PINE_TIME_INFINI_TIME);
            } else {
                settings.setSelectedWearable(Wearable.POLAR);
            }
            settings.setBleTrackingDevice(bluetoothDevice.getAddress(), bluetoothDevice.getName() == null ? bluetoothDevice.getAddress() : bluetoothDevice.getName());
        }
        Preference preferenceFindPreference3 = findPreference("selected_wearable");
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setSummary(getDescription(settings.getSelectedWearable()));
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Settings settings = new Settings(this);
        if (settings.getSelectedWearable() != Wearable.NONE) {
            AlarmSettingsActivity.askOverlay(this, 30, R.string.wearable_start, R.string.overlay_permission_mic_android11, "SmartwatchSettingsActivity");
        }
        if (TrialFilter.getInstance().isAddonGarmin() && settings.isWearableSelected(Wearable.ADDON_URBANDROID_GARMIN)) {
            AlarmClock.showGarminDialog(this);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public void onCreatePreference(Bundle bundle) {
        super.onCreatePreference(bundle);
        ListPreference listPreference = (ListPreference) findPreference("gradual_vibration_smartwatch_new");
        PreferencesUtils.expandVibrationsPreference(this, listPreference);
        listPreference.setSummary(listPreference.getEntry());
        Preference preferenceFindPreference = findPreference("sms_test");
        this.smsTestPreference = preferenceFindPreference;
        if (preferenceFindPreference != null) {
            LamerPreferenceCategory lamerPreferenceCategory = (LamerPreferenceCategory) getPreferenceScreen().findPreference("settings_category_apnea");
            lamerPreferenceCategory.removePreference(this.smsTestPreference);
            lamerPreferenceCategory.setExpanded(4);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i, "Permissions: result ", " ");
        sbM65m.append(iArr[0]);
        sbM65m.append(" ");
        Logger.logInfo(sbM65m.toString());
        int i2 = R.string.warning_location_bt;
        if (i == 339) {
            if (iArr[0] == 0) {
                Logger.logInfo("Permissions: LOCATION Granted ");
                SharedApplicationContext.getSettings().setOximeter(true);
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("oximeter");
                if (checkBoxPreference != null) {
                    checkBoxPreference.setChecked(true);
                }
                Runnable runnable = this.runIfBlePermissionsGranted;
                if (runnable != null) {
                    runnable.run();
                }
            } else {
                Logger.logInfo("Permissions: LOCATION Denied ");
                try {
                    String requiredLocationPermissionForBluetoothLe = SleepPermissionCompat.INSTANCE.getRequiredLocationPermissionForBluetoothLe();
                    Resources resources = getResources();
                    if (Build.VERSION.SDK_INT >= 31) {
                        i2 = R.string.warning_location_bt_android12;
                    }
                    ViewIntent.getPermissionDenyDialogBuilder(this, requiredLocationPermissionForBluetoothLe, resources.getString(i2)).show();
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
            }
            this.runIfBlePermissionsGranted = null;
            return;
        }
        if (i == 340) {
            if (iArr[0] == 0) {
                Logger.logInfo("Permissions: LOCATION Granted ");
                Runnable runnable2 = this.runIfBlePermissionsGranted;
                if (runnable2 != null) {
                    runnable2.run();
                }
            } else {
                Logger.logInfo("Permissions: LOCATION Denied ");
                try {
                    String requiredLocationPermissionForBluetoothLe2 = SleepPermissionCompat.INSTANCE.getRequiredLocationPermissionForBluetoothLe();
                    Resources resources2 = getResources();
                    if (Build.VERSION.SDK_INT >= 31) {
                        i2 = R.string.warning_location_bt_android12;
                    }
                    ViewIntent.getPermissionDenyDialogBuilder(this, requiredLocationPermissionForBluetoothLe2, resources2.getString(i2)).show();
                } catch (Exception e2) {
                    Logger.logSevere(e2);
                }
                Settings settings = new Settings(this);
                settings.setSelectedWearable(Wearable.NONE);
                settings.setBleTrackingDevice(null, null);
                Preference preferenceFindPreference = findPreference("selected_wearable");
                if (preferenceFindPreference != null) {
                    preferenceFindPreference.setSummary(getDescription(settings.getSelectedWearable()));
                }
            }
            this.runIfBlePermissionsGranted = null;
            return;
        }
        if (i != 376) {
            if (i != 440) {
                return;
            }
            if (iArr[0] != 0) {
                Logger.logInfo("Permissions: BODY SENSORS Denied ");
                try {
                    ViewIntent.getPermissionDenyDialogBuilder(this, "android.permission.BODY_SENSORS", R.string.hr).show();
                    return;
                } catch (Exception e3) {
                    Logger.logSevere(e3);
                    return;
                }
            }
            Logger.logInfo("Permissions: BODY SENSORS Granted ");
            SharedApplicationContext.getSettings().setHrWear(true);
            CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) getPreferenceScreen().findPreference("hr_wear");
            if (checkBoxPreference2 != null) {
                checkBoxPreference2.setChecked(true);
                return;
            }
            return;
        }
        if (iArr[0] == 0) {
            Logger.logInfo("Permissions: LOCATION Granted ");
            SharedApplicationContext.getSettings().setHrBt(true);
            CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) findPreference("hr_bt");
            if (checkBoxPreference3 != null) {
                checkBoxPreference3.setChecked(true);
            }
            Runnable runnable3 = this.runIfBlePermissionsGranted;
            if (runnable3 != null) {
                runnable3.run();
            }
        } else {
            Logger.logInfo("Permissions: LOCATION Denied ");
            try {
                String requiredLocationPermissionForBluetoothLe3 = SleepPermissionCompat.INSTANCE.getRequiredLocationPermissionForBluetoothLe();
                Resources resources3 = getResources();
                if (Build.VERSION.SDK_INT >= 31) {
                    i2 = R.string.warning_location_bt_android12;
                }
                ViewIntent.getPermissionDenyDialogBuilder(this, requiredLocationPermissionForBluetoothLe3, resources3.getString(i2)).show();
            } catch (Exception e4) {
                Logger.logSevere(e4);
            }
        }
        this.runIfBlePermissionsGranted = null;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("clickPreference") && intent.getStringExtra("clickPreference").equals("selected_wearable")) {
            showWearablesDialog(this);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(final PreferenceActivity preferenceActivity, boolean z) {
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        Preference preferenceFindPreference = findPreference("smartwatch_expl");
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if (preferenceFindPreference != null) {
            final Object[] objArr3 = objArr2 == true ? 1 : 0;
            preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.SmartwatchSettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ SmartwatchSettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i = objArr3;
                    SmartwatchSettingsActivity smartwatchSettingsActivity = this.f$0;
                    switch (i) {
                        case 0:
                            return smartwatchSettingsActivity.lambda$refresh$2(preference);
                        case 1:
                            return smartwatchSettingsActivity.lambda$refresh$8(preference);
                        default:
                            return smartwatchSettingsActivity.lambda$refresh$9(preference);
                    }
                }
            });
        }
        Preference preferenceFindPreference2 = preferenceScreen.findPreference("selected_wearable");
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setSummary(getDescription(SharedApplicationContext.getSettings().getSelectedWearable()));
            preferenceFindPreference2.setOnPreferenceClickListener(new AlarmSettingsActivity$$ExternalSyntheticLambda4(this, preferenceActivity, 9));
        }
        Preference preferenceFindPreference3 = preferenceScreen.findPreference("test_sensors");
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new ServicesSettingsActivity$$ExternalSyntheticLambda11(this, preferenceScreen, preferenceActivity));
        }
        Preference preferenceFindPreference4 = preferenceScreen.findPreference("oximeter_alarm");
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.setOnPreferenceChangeListener(new BedtimeSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 6));
        }
        Preference preferenceFindPreference5 = preferenceScreen.findPreference("hr_wear");
        Preference preferenceFindPreference6 = preferenceScreen.findPreference("hr_bt");
        if (preferenceFindPreference6 != null) {
            if (Environment.isJellyBean43OrGreater() && preferenceActivity.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                preferenceFindPreference6.setSummary(new Settings(preferenceActivity).getBleHrDevicePresentation());
            } else {
                ((PreferenceGroup) preferenceScreen.findPreference("settings_category_smartwatch")).removePreference(preferenceFindPreference6);
            }
        }
        if (preferenceFindPreference5 != null) {
            final Object[] objArr4 = objArr == true ? 1 : 0;
            preferenceFindPreference5.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.SmartwatchSettingsActivity$$ExternalSyntheticLambda4
                public final /* synthetic */ SmartwatchSettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    int i = objArr4;
                    PreferenceActivity preferenceActivity2 = preferenceActivity;
                    SmartwatchSettingsActivity smartwatchSettingsActivity = this.f$0;
                    switch (i) {
                        case 0:
                            return smartwatchSettingsActivity.lambda$refresh$6(preferenceActivity2, preference, obj);
                        default:
                            return smartwatchSettingsActivity.lambda$refresh$7(preferenceActivity2, preference, obj);
                    }
                }
            });
        }
        final int i = 1;
        Preference.OnPreferenceChangeListener onPreferenceChangeListener = new Preference.OnPreferenceChangeListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.SmartwatchSettingsActivity$$ExternalSyntheticLambda4
            public final /* synthetic */ SmartwatchSettingsActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.preference.Preference.OnPreferenceChangeListener
            public final boolean onPreferenceChange(Preference preference, Object obj) {
                int i2 = i;
                PreferenceActivity preferenceActivity2 = preferenceActivity;
                SmartwatchSettingsActivity smartwatchSettingsActivity = this.f$0;
                switch (i2) {
                    case 0:
                        return smartwatchSettingsActivity.lambda$refresh$6(preferenceActivity2, preference, obj);
                    default:
                        return smartwatchSettingsActivity.lambda$refresh$7(preferenceActivity2, preference, obj);
                }
            }
        };
        if (preferenceFindPreference6 != null) {
            preferenceFindPreference6.setOnPreferenceChangeListener(onPreferenceChangeListener);
        }
        Preference preferenceFindPreference7 = preferenceScreen.findPreference("oximeter");
        if (preferenceFindPreference7 != null) {
            preferenceFindPreference7.setOnPreferenceChangeListener(onPreferenceChangeListener);
        }
        Preference preferenceFindPreference8 = preferenceScreen.findPreference("oximeter_read_more_2");
        if (preferenceFindPreference8 != null) {
            preferenceFindPreference8.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.SmartwatchSettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ SmartwatchSettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i2 = i;
                    SmartwatchSettingsActivity smartwatchSettingsActivity = this.f$0;
                    switch (i2) {
                        case 0:
                            return smartwatchSettingsActivity.lambda$refresh$2(preference);
                        case 1:
                            return smartwatchSettingsActivity.lambda$refresh$8(preference);
                        default:
                            return smartwatchSettingsActivity.lambda$refresh$9(preference);
                    }
                }
            });
        }
        Preference preferenceFindPreference9 = preferenceScreen.findPreference("oximeter_read_more");
        if (preferenceFindPreference9 != null) {
            final int i2 = 2;
            preferenceFindPreference9.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.SmartwatchSettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ SmartwatchSettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i22 = i2;
                    SmartwatchSettingsActivity smartwatchSettingsActivity = this.f$0;
                    switch (i22) {
                        case 0:
                            return smartwatchSettingsActivity.lambda$refresh$2(preference);
                        case 1:
                            return smartwatchSettingsActivity.lambda$refresh$8(preference);
                        default:
                            return smartwatchSettingsActivity.lambda$refresh$9(preference);
                    }
                }
            });
        }
        Preference preferenceFindPreference10 = preferenceScreen.findPreference("apnea_alarm_ringtone");
        if (preferenceFindPreference10 != null) {
            preferenceFindPreference10.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 18));
        }
        LamerPreferenceCategory.init(preferenceActivity, preferenceScreen, z || new Settings(preferenceActivity).isExpandAllSettings(), "settings_category_hr", "settings_category_apnea");
    }

    @Override // com.urbandroid.sleep.smartwatch.WearablesDialogFragment.OnCloseListener
    public void regularWearableSelected(Activity activity, Wearable wearable) {
        Preference preferenceFindPreference;
        if (getPreferenceScreen() == null || (preferenceFindPreference = getPreferenceScreen().findPreference("selected_wearable")) == null || wearable == null) {
            return;
        }
        preferenceFindPreference.setSummary(wearable.getName(getApplicationContext()));
        if (!(activity instanceof PreferenceActivity)) {
            Logger.logWarning("SmartwatchSettingsActivity.bleWearableSelected: ! (activity instanceof PreferenceActivity)");
            return;
        }
        if (activity.isFinishing()) {
            Logger.logWarning("SmartwatchSettingsActivity.bleWearableSelected: activity.isFinishing()");
        }
        PreferenceActivity preferenceActivity = (PreferenceActivity) activity;
        refresh(preferenceActivity, false);
        if (wearable == Wearable.CUSTOM) {
            ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.dialog_simple_edit, (ViewGroup) null);
            if (SharedApplicationContext.getSettings().getCustomWearablePackageName() != null) {
                ((EditText) viewGroup.findViewById(R.id.edit)).setText(SharedApplicationContext.getSettings().getCustomWearablePackageName());
            }
            new MaterialAlertDialogBuilder(this).setTitle((CharSequence) "Package name of your add-on app").setView((View) viewGroup).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(viewGroup, 7)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
            return;
        }
        if (wearable == Wearable.POLAR_SDK) {
            ActivityCompat$$ExternalSyntheticLambda0 activityCompat$$ExternalSyntheticLambda0 = new ActivityCompat$$ExternalSyntheticLambda0(preferenceActivity, 26);
            if (checkPermissionBt(preferenceActivity, "selected_wearable")) {
                activityCompat$$ExternalSyntheticLambda0.run();
            } else {
                this.runIfBlePermissionsGranted = activityCompat$$ExternalSyntheticLambda0;
            }
        }
    }
}
