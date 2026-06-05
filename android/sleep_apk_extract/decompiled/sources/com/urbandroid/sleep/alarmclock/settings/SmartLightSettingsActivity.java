package com.urbandroid.sleep.alarmclock.settings;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import com.ftdi.j2xx.D2xxManager;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.RootUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.common.wifi.WifiEnabler;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.async.AbstractProgressAsyncTask;
import com.urbandroid.sleep.async.ProgressContext;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.pref.LamerPreferenceCategory;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.google.home.GoogleHomeClient;
import com.urbandroid.sleep.service.google.home.GoogleHomeLightActivity;
import com.urbandroid.sleep.service.google.home.GoogleHomePermission;
import com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda4;
import com.urbandroid.sleep.smartlight.DiscoveryActivity;
import com.urbandroid.sleep.smartlight.LightActivity;
import com.urbandroid.sleep.smartlight.UnifiedSmartLight;
import com.urbandroid.sleep.smartwatch.phaser.SleepPhaserLookup;
import com.urbandroid.sleep.smartwatch.phaser.SleepPhaserProvider;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.util.SleepPermissionCompat;

/* JADX INFO: loaded from: classes4.dex */
public class SmartLightSettingsActivity extends SimpleSettingsActivity implements Preference.OnPreferenceChangeListener, GoogleHomePermission {
    private UnifiedSmartLight smartLight;

    /* JADX INFO: renamed from: -$$Nest$mcheckPermissionBt, reason: not valid java name */
    public static /* bridge */ /* synthetic */ boolean m1507$$Nest$mcheckPermissionBt(SmartLightSettingsActivity smartLightSettingsActivity, Activity activity) {
        return smartLightSettingsActivity.checkPermissionBt(activity, 376);
    }

    private boolean checkPermissionBt(Activity activity, int i) {
        return !SleepPermissionCompat.INSTANCE.requestLocationPermissionForBt(activity, i, true);
    }

    private String formatPurchaseText(Context context, int i) {
        return context.getString(R.string.smartlight_mask_purchase, context.getString(i));
    }

    public static boolean isSerialConnected(Context context) {
        try {
            return D2xxManager.getInstance(context).createDeviceInfoList(context) > 0;
        } catch (Exception e) {
            Logger.logSevere(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$0(Context context, Preference preference, Object obj) {
        Logger.logInfo("Home: settings " + obj);
        if (!((Boolean) obj).booleanValue()) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 27) {
            GoogleHomeClient.getInstance(context).requestPermissionsIfNeeded(this);
            return true;
        }
        Toast.makeText(context, getString(R.string.not_supported, getString(R.string.service_google_home)), 0).show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$1(Preference preference) {
        startActivity(new Intent(this, (Class<?>) GoogleHomeLightActivity.class));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$2(PreferenceActivity preferenceActivity, Preference preference) {
        Logger.logInfo("SmartLight connected: " + this.smartLight.isConnected() + " " + AuthenticatedGateway.load(preferenceActivity));
        if (this.smartLight.isConnected()) {
            preferenceActivity.startActivity(new Intent(preferenceActivity, (Class<?>) LightActivity.class));
            return true;
        }
        if (WifiEnabler.getInstance().isWifiConnected()) {
            preferenceActivity.startActivity(new Intent(preferenceActivity, (Class<?>) DiscoveryActivity.class));
            return true;
        }
        wifiDisconnectToast();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$3(PreferenceActivity preferenceActivity, Preference preference) {
        if (!((CheckBoxPreference) preference).isChecked()) {
            SharedApplicationContext.getSettings().setUseFlashlight(false);
            return true;
        }
        SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
        if (sleepPermissionCompat.isPermissionGranted(preferenceActivity, "android.permission.CAMERA")) {
            SharedApplicationContext.getSettings().setUseFlashlight(true);
        } else {
            Logger.logInfo("Permissions: CAMERA Request ");
            sleepPermissionCompat.requestPermission(preferenceActivity, "android.permission.CAMERA", 113);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wifiDisconnectToast() {
        Toast.makeText(getApplicationContext(), getString(R.string.share_disconnected, getString(R.string.wifi)), 0).show();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//devices/smart_light.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_smartlight;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.settings_category_smartlight;
    }

    @Override // com.urbandroid.sleep.service.google.home.GoogleHomePermission
    public void hasPermission(boolean z) {
        zza$$ExternalSyntheticOutline0.m("Home: has permission ", z);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 27) {
            GoogleHomeClient.getInstance(this).getClient().registerActivityResultCallerForPermissions(this);
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        UnifiedSmartLight unifiedSmartLight = this.smartLight;
        if (unifiedSmartLight != null) {
            unifiedSmartLight.close();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 113) {
            if (i == 376 && iArr[0] != 0) {
                new MaterialAlertDialogBuilder(this).setTitle(R.string.no_permission).setMessage((CharSequence) ViewIntent.getNoPermissionText(this, SleepPermissionCompat.INSTANCE.getRequiredLocationPermissionForBluetoothLe(), R.string.sleep_phaser)).setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity.10
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        ViewIntent.showPermissionsSettings(SmartLightSettingsActivity.this);
                    }
                }).setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null).show();
                return;
            }
            return;
        }
        if (iArr[0] == 0) {
            Logger.logInfo("Permissions: CAMERA Granted ");
            SharedApplicationContext.getSettings().setUseFlashlight(true);
            ((CheckBoxPreference) findPreference("alarm_with_flashlight")).setChecked(true);
        } else {
            Logger.logInfo("Permissions: CAMERA Denied ");
            SharedApplicationContext.getSettings().setUseFlashlight(false);
            ((CheckBoxPreference) findPreference("alarm_with_flashlight")).setChecked(false);
            ViewIntent.getPermissionDenyDialogBuilder(this, "android.permission.CAMERA", R.string.alarm_with_flashlight_title).show();
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(final PreferenceActivity preferenceActivity, boolean z) {
        this.smartLight = new UnifiedSmartLight(preferenceActivity);
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        Preference preferenceFindPreference = preferenceScreen.findPreference("settings_google_home_smartlight");
        if (preferenceFindPreference != null) {
            Logger.logInfo("Home: pref " + preferenceFindPreference);
            preferenceFindPreference.setOnPreferenceChangeListener(new AddShortcutActivity$$ExternalSyntheticLambda4(this, this, 10));
        }
        Preference preferenceFindPreference2 = preferenceScreen.findPreference("settings_google_home_smartlight_select");
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda0(this, 7));
        }
        Preference preferenceFindPreference3 = preferenceScreen.findPreference("smartlight_hue");
        if (preferenceFindPreference3 != null) {
            AuthenticatedGateway authenticatedGatewayLoad = AuthenticatedGateway.load(preferenceActivity);
            if (this.smartLight.isConnected()) {
                int i = R.string.smartlight_ikea_tradfri;
                preferenceFindPreference3.setTitle(preferenceActivity.getString((authenticatedGatewayLoad == null || (authenticatedGatewayLoad instanceof AuthenticatedGateway.Tradfri)) ? R.string.smartlight_ikea_tradfri : authenticatedGatewayLoad instanceof AuthenticatedGateway.YaHue ? R.string.smartlight_philips_hue_new : R.string.smartlight_hue));
                if (authenticatedGatewayLoad != null && !(authenticatedGatewayLoad instanceof AuthenticatedGateway.Tradfri)) {
                    i = authenticatedGatewayLoad instanceof AuthenticatedGateway.YaHue ? R.string.smartlight_philips_hue_new : R.string.smartlight_hue;
                }
                preferenceFindPreference3.setSummary(preferenceActivity.getString(R.string.share_connected, preferenceActivity.getString(i)));
            } else {
                preferenceFindPreference3.setSummary(preferenceActivity.getString(R.string.share_disconnected, preferenceActivity.getString(R.string.smartlight_all)));
                preferenceFindPreference3.setTitle(preferenceActivity.getString(R.string.smartlight_all_desc));
            }
            preferenceFindPreference3.setOnPreferenceClickListener(new AlarmSettingsActivity$$ExternalSyntheticLambda4(this, preferenceActivity, 8));
        }
        Preference preferenceFindPreference4 = preferenceScreen.findPreference("screenlight");
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.setSummary(preferenceActivity.getString(R.string.use, preferenceActivity.getString(R.string.screenlight).toLowerCase()));
        }
        Preference preferenceFindPreference5 = preferenceScreen.findPreference("smartlight_test");
        if (preferenceFindPreference5 != null) {
            preferenceFindPreference5.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity.1
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    boolean zIsWifiConnected = WifiEnabler.getInstance().isWifiConnected();
                    SmartLightSettingsActivity smartLightSettingsActivity = SmartLightSettingsActivity.this;
                    if (!zIsWifiConnected) {
                        smartLightSettingsActivity.wifiDisconnectToast();
                        return false;
                    }
                    if (!smartLightSettingsActivity.smartLight.isConnected()) {
                        return true;
                    }
                    SmartLightSettingsActivity.this.smartLight.hint();
                    return true;
                }
            });
        }
        Preference preferenceFindPreference6 = preferenceScreen.findPreference("smartlight_off");
        if (preferenceFindPreference6 != null) {
            preferenceFindPreference6.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity.2
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    boolean zIsWifiConnected = WifiEnabler.getInstance().isWifiConnected();
                    SmartLightSettingsActivity smartLightSettingsActivity = SmartLightSettingsActivity.this;
                    if (!zIsWifiConnected) {
                        smartLightSettingsActivity.wifiDisconnectToast();
                        return false;
                    }
                    if (smartLightSettingsActivity.smartLight.isConnected()) {
                        SmartLightSettingsActivity.this.smartLight.off(true);
                    }
                    return true;
                }
            });
        }
        Preference preferenceFindPreference7 = preferenceScreen.findPreference("purchase_hue");
        if (preferenceFindPreference7 != null) {
            preferenceFindPreference7.setTitle(formatPurchaseText(preferenceActivity, R.string.smartlight_philips_hue));
            if (SharedApplicationContext.getSettings().isPhilipsOffer()) {
                preferenceFindPreference7.setSummary(TrialFilter.getInstance().isTrial() ? R.string.philips_hue_offer : R.string.philips_hue_offer_unlocked);
                preferenceFindPreference7.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity.3
                    @Override // android.preference.Preference.OnPreferenceClickListener
                    public boolean onPreferenceClick(Preference preference) {
                        Logger.logInfo("Pref HUE clicked");
                        ViewIntent.url(preferenceActivity, preferenceActivity.getString(TrialFilter.getInstance().isTrial() ? R.string.philips_hue_offer_link : R.string.philips_hue_offer_link_unlocked));
                        return true;
                    }
                });
            } else {
                Logger.logInfo("Pref HUE remove");
                preferenceScreen.removePreference(preferenceFindPreference7);
            }
        }
        Preference preferenceFindPreference8 = preferenceScreen.findPreference("alarm_with_flashlight");
        if (preferenceFindPreference8 != null) {
            preferenceFindPreference8.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 17));
        }
        PackageManager packageManager = preferenceActivity.getPackageManager();
        if (!z && !packageManager.hasSystemFeature("android.hardware.usb.host") && !new RootUtil().isDeviceRooted()) {
            if (preferenceScreen.findPreference("smartlight_mask_category") != null) {
                preferenceScreen.removePreference(findPreference("smartlight_mask_category"));
            }
            if (preferenceScreen.findPreference("smartlight_mask_enabled") != null) {
                preferenceScreen.removePreference(findPreference("smartlight_mask_enabled"));
            }
            if (preferenceScreen.findPreference("smartlight_mask_intensity") != null) {
                preferenceScreen.removePreference(findPreference("smartlight_mask_intensity"));
            }
            if (preferenceScreen.findPreference("smartlight_mask_purchase") != null) {
                preferenceScreen.removePreference(findPreference("smartlight_mask_purchase"));
            }
        }
        if (preferenceScreen.findPreference("smartlight_mask_enabled") != null) {
            preferenceScreen.findPreference("smartlight_mask_enabled").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity.4
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    if (!(obj instanceof Boolean) || !obj.equals(Boolean.TRUE)) {
                        return true;
                    }
                    SmartLightSettingsActivity.isSerialConnected(preference.getContext());
                    return true;
                }
            });
        }
        if (preferenceScreen.findPreference("smartlight_mask_purchase") != null) {
            preferenceScreen.findPreference("smartlight_mask_purchase").setTitle(formatPurchaseText(preferenceActivity, R.string.addons_mask_title));
            preferenceScreen.findPreference("smartlight_mask_purchase").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity.5
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    ViewIntent.url(preferenceActivity, "http://sleepmask.urbandroid.org");
                    return true;
                }
            });
        }
        if (preferenceScreen.findPreference("sleep_phaser_purchase") != null) {
            preferenceScreen.findPreference("sleep_phaser_purchase").setTitle(formatPurchaseText(preferenceActivity, R.string.sleep_phaser));
            preferenceScreen.findPreference("sleep_phaser_purchase").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity.6
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    ViewIntent.url(preferenceActivity, "http://sleepphaser.urbandroid.org");
                    return true;
                }
            });
        }
        if (preferenceScreen.findPreference("smartlight_sleep_phaser_auto_start") != null) {
            preferenceScreen.findPreference("smartlight_sleep_phaser_auto_start").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity.7
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    return true;
                }
            });
        }
        final Preference preferenceFindPreference9 = preferenceScreen.findPreference("sleep_phaser_connect");
        String sleepPhaserAddress = new Settings(preferenceActivity).getSleepPhaserAddress();
        if (preferenceFindPreference9 != null) {
            if (sleepPhaserAddress != null) {
                preferenceFindPreference9.setTitle(preferenceActivity.getString(R.string.share_connected, preferenceActivity.getString(R.string.sleep_phaser)));
                preferenceFindPreference9.setSummary(sleepPhaserAddress);
            } else {
                preferenceFindPreference9.setTitle(preferenceActivity.getString(R.string.share_disconnected, preferenceActivity.getString(R.string.sleep_phaser)));
                preferenceFindPreference9.setSummary("");
            }
            preferenceFindPreference9.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity.8
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    if (new Settings(preferenceActivity).getSleepPhaserAddress() != null) {
                        new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity.8.2
                            @Override // android.os.AsyncTask
                            public void onPreExecute() {
                                super.onPreExecute();
                                new Settings(preferenceActivity).setSleepPhaserAddress(null);
                                AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                                preferenceFindPreference9.setTitle(preferenceActivity.getResources().getString(R.string.share_disconnected, preferenceActivity.getResources().getString(R.string.sleep_phaser)));
                                preferenceFindPreference9.setSummary("");
                            }

                            @Override // android.os.AsyncTask
                            public Void doInBackground(Void... voidArr) {
                                SleepPhaserProvider.discardSleepPhaser();
                                return null;
                            }
                        }.execute(new Void[0]);
                        return true;
                    }
                    if (SmartLightSettingsActivity.m1507$$Nest$mcheckPermissionBt(SmartLightSettingsActivity.this, preferenceActivity)) {
                        LocationManager locationManager = (LocationManager) preferenceActivity.getSystemService("location");
                        if (Build.VERSION.SDK_INT < 31 && (locationManager == null || (!locationManager.isProviderEnabled("gps") && !locationManager.isProviderEnabled("network")))) {
                            new MaterialAlertDialogBuilder(preferenceActivity).setMessage(R.string.warning_location_bt).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null).show();
                            return true;
                        }
                        new AbstractProgressAsyncTask<Void, Void, BluetoothDevice>(new ProgressContext(preferenceActivity, true), preferenceActivity) { // from class: com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity.8.1
                            @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
                            public String getMessage() {
                                return preferenceActivity.getString(R.string.search_may_take_a_while);
                            }

                            @Override // android.os.AsyncTask
                            public void onCancelled() {
                                super.onCancelled();
                                Logger.logInfo("SleepPhaser: lookup cancelled");
                                new Settings(preferenceActivity).setSleepPhaserAddress(null);
                                SleepPhaserProvider.discardSleepPhaser();
                            }

                            @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask, android.os.AsyncTask
                            public void onPostExecute(BluetoothDevice bluetoothDevice) {
                                super.onPostExecute(bluetoothDevice);
                                Logger.logInfo("SleepPhaser: lookup " + bluetoothDevice);
                                if (bluetoothDevice == null || bluetoothDevice.getAddress() == null) {
                                    Toast.makeText(preferenceActivity, R.string.general_unspecified_error, 0).show();
                                    return;
                                }
                                preferenceFindPreference9.setSummary(bluetoothDevice.getAddress());
                                AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                                preferenceFindPreference9.setTitle(preferenceActivity.getResources().getString(R.string.share_connected, preferenceActivity.getResources().getString(R.string.sleep_phaser)));
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
                            public BluetoothDevice performInBackground() {
                                try {
                                    BluetoothDevice bluetoothDeviceFind = SleepPhaserLookup.find(preferenceActivity.getApplicationContext(), 10000L);
                                    if (bluetoothDeviceFind != null) {
                                        Logger.logInfo("SleepPhaser: found, saving " + bluetoothDeviceFind.getAddress());
                                        new Settings(preferenceActivity).setSleepPhaserAddress(bluetoothDeviceFind.getAddress());
                                        SleepPhaserProvider.getSleepPhaser(preferenceActivity).synchronousHint(20000L);
                                        Logger.logInfo("SleepPhaser: connection test passed.");
                                    } else {
                                        Logger.logInfo("SleepPhaser: not found.");
                                    }
                                    return bluetoothDeviceFind;
                                } catch (Exception e) {
                                    Logger.logSevere("SleepPhaser: lookup/connect failed, un-saving.", e);
                                    new Settings(preferenceActivity).setSleepPhaserAddress(null);
                                    return null;
                                } finally {
                                    SleepPhaserProvider.discardSleepPhaser();
                                }
                            }
                        }.execute(new Void[0]);
                    }
                    return true;
                }
            });
        }
        final Preference preferenceFindPreference10 = preferenceScreen.findPreference("sleep_mask_bt_connect");
        String sleepMaskBtAddress = new Settings(preferenceActivity).getSleepMaskBtAddress();
        if (preferenceFindPreference10 != null) {
            if (sleepMaskBtAddress != null) {
                preferenceFindPreference10.setTitle(preferenceActivity.getString(R.string.share_connected, preferenceActivity.getString(R.string.addons_mask_title) + " " + preferenceActivity.getString(R.string.bluetooth)));
                preferenceFindPreference10.setSummary(sleepMaskBtAddress);
            } else {
                preferenceFindPreference10.setTitle(preferenceActivity.getString(R.string.connect) + " " + preferenceActivity.getString(R.string.addons_mask_title) + " " + preferenceActivity.getString(R.string.bluetooth));
                preferenceFindPreference10.setSummary("");
            }
            preferenceFindPreference10.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity.9
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    if (new Settings(preferenceActivity).getSleepMaskBtAddress() != null) {
                        new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity.9.2
                            @Override // android.os.AsyncTask
                            public void onPreExecute() {
                                super.onPreExecute();
                                new Settings(preferenceActivity).setSleepMaskBtAddress(null);
                                AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                preferenceFindPreference10.setTitle(preferenceActivity.getResources().getString(R.string.share_disconnected, preferenceActivity.getResources().getString(R.string.addons_mask_title) + " " + preferenceActivity.getResources().getString(R.string.bluetooth)));
                                preferenceFindPreference10.setSummary("");
                            }

                            @Override // android.os.AsyncTask
                            public Void doInBackground(Void... voidArr) {
                                SleepPhaserProvider.discardSleepPhaser();
                                return null;
                            }
                        }.execute(new Void[0]);
                        return true;
                    }
                    if (SmartLightSettingsActivity.m1507$$Nest$mcheckPermissionBt(SmartLightSettingsActivity.this, preferenceActivity)) {
                        LocationManager locationManager = (LocationManager) preferenceActivity.getSystemService("location");
                        if (Build.VERSION.SDK_INT < 31 && (locationManager == null || (!locationManager.isProviderEnabled("gps") && !locationManager.isProviderEnabled("network")))) {
                            new MaterialAlertDialogBuilder(preferenceActivity).setMessage(R.string.warning_location_bt).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null).show();
                            return true;
                        }
                        new AbstractProgressAsyncTask<Void, Void, BluetoothDevice>(new ProgressContext(preferenceActivity, true), preferenceActivity) { // from class: com.urbandroid.sleep.alarmclock.settings.SmartLightSettingsActivity.9.1
                            @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
                            public String getMessage() {
                                return preferenceActivity.getString(R.string.search_may_take_a_while);
                            }

                            @Override // android.os.AsyncTask
                            public void onCancelled() {
                                super.onCancelled();
                                Logger.logInfo("SleepMaskBt: lookup cancelled");
                                new Settings(preferenceActivity).setSleepMaskBtAddress(null);
                                SleepPhaserProvider.discardSleepPhaser();
                            }

                            @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask, android.os.AsyncTask
                            public void onPostExecute(BluetoothDevice bluetoothDevice) {
                                super.onPostExecute(bluetoothDevice);
                                Logger.logInfo("SleepMaskBt: lookup " + bluetoothDevice);
                                if (bluetoothDevice == null || bluetoothDevice.getAddress() == null) {
                                    Toast.makeText(preferenceActivity, R.string.general_unspecified_error, 0).show();
                                    return;
                                }
                                preferenceFindPreference10.setSummary(bluetoothDevice.getAddress());
                                AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                preferenceFindPreference10.setTitle(preferenceActivity.getResources().getString(R.string.share_connected, preferenceActivity.getResources().getString(R.string.addons_mask_title) + " " + preferenceActivity.getResources().getString(R.string.bluetooth)));
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
                            public BluetoothDevice performInBackground() {
                                try {
                                    BluetoothDevice bluetoothDeviceFind = SleepPhaserLookup.find(preferenceActivity.getApplicationContext(), 10000L);
                                    if (bluetoothDeviceFind != null) {
                                        Logger.logInfo("SleepMaskBt: found, saving " + bluetoothDeviceFind.getAddress());
                                        new Settings(preferenceActivity).setSleepMaskBtAddress(bluetoothDeviceFind.getAddress());
                                        SleepPhaserProvider.getSleepPhaser(preferenceActivity).synchronousHint(20000L);
                                        Logger.logInfo("SleepMaskBt: connection test passed.");
                                    } else {
                                        Logger.logInfo("SleepMaskBt: not found.");
                                    }
                                    return bluetoothDeviceFind;
                                } catch (Exception e) {
                                    Logger.logSevere("SleepMaskBt: lookup/connect failed, un-saving.", e);
                                    new Settings(preferenceActivity).setSleepMaskBtAddress(null);
                                    return null;
                                } finally {
                                    SleepPhaserProvider.discardSleepPhaser();
                                }
                            }
                        }.execute(new Void[0]);
                    }
                    return true;
                }
            });
        }
        LamerPreferenceCategory.init(preferenceActivity, preferenceScreen, z || new Settings(preferenceActivity).isExpandAllSettings(), "settings_category_sl_hue", "settings_category_sl_phaser", "settings_category_sl_mask");
    }
}
