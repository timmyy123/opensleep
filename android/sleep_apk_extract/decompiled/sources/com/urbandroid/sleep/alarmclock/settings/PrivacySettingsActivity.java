package com.urbandroid.sleep.alarmclock.settings;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.privacy.Consent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.FrequentGeoService;
import com.urbandroid.sleep.alarmclock.directorypicker.DirectoryPicker;
import com.urbandroid.sleep.async.AbstractProgressAsyncTask;
import com.urbandroid.sleep.async.ProgressContext;
import com.urbandroid.sleep.fragment.NoiseFragment$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.gui.pref.LamerPreferenceCategory;
import com.urbandroid.sleep.media.NoiseDirectory;
import com.urbandroid.sleep.persistence.Export;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.SleepPermissionCompat;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class PrivacySettingsActivity extends SimpleSettingsActivity {

    /* JADX INFO: renamed from: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements Preference.OnPreferenceClickListener {
        final /* synthetic */ PreferenceActivity val$preferenceActivity;

        public AnonymousClass5(PreferenceActivity preferenceActivity) {
            this.val$preferenceActivity = preferenceActivity;
        }

        @Override // android.preference.Preference.OnPreferenceClickListener
        public boolean onPreferenceClick(Preference preference) {
            new MaterialAlertDialogBuilder(this.val$preferenceActivity).setTitle(R.string.are_you_sure).setMessage(R.string.restore_settings_warn).setPositiveButton(R.string.restore_settings, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.5.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    new AbstractProgressAsyncTask<Void, Void, Void>(new ProgressContext(AnonymousClass5.this.val$preferenceActivity), AnonymousClass5.this.val$preferenceActivity) { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.5.1.1
                        @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
                        public String getMessage() {
                            return null;
                        }

                        @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
                        public Void performInBackground() {
                            new Export();
                            Export.importPrefs(AnonymousClass5.this.val$preferenceActivity);
                            return null;
                        }
                    }.execute(new Void[0]);
                }
            }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$0(Preference preference) {
        Consent.INSTANCE.loadAndShowConsent(this, true, false);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$1(Preference preference) {
        ViewIntent.url(this, "https://sleep.urbandroid.org/docs/general/privacy.html");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$2(Preference preference) {
        ViewIntent.url(this, getString(R.string.privacy_policy_link));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$refresh$3(DialogInterface dialogInterface, int i) {
        SharedApplicationContext.getSettings().setTermsAgreed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$4(Preference preference) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
        TextView textView = new TextView(this);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        int dip = ActivityUtils.getDip(this, 24);
        scrollView.setPadding(dip, dip, dip, dip);
        scrollView.addView(textView);
        textView.setText(R.string.terms_text);
        materialAlertDialogBuilder.setView((View) scrollView);
        materialAlertDialogBuilder.setTitle(R.string.terms);
        materialAlertDialogBuilder.setPositiveButton(R.string.agree, (DialogInterface.OnClickListener) new NoiseFragment$$ExternalSyntheticLambda6(3));
        materialAlertDialogBuilder.show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$5(PreferenceActivity preferenceActivity, Preference preference) {
        Intent launchIntentForPackage;
        try {
            launchIntentForPackage = preference.getContext().getPackageManager().getLaunchIntentForPackage("com.urbandroid.sleep.addon.port");
        } catch (Exception unused) {
            ViewIntent.market(preferenceActivity, "com.urbandroid.sleep.addon.port");
        }
        if (launchIntentForPackage == null) {
            ViewIntent.market(preferenceActivity, "com.urbandroid.sleep.addon.port");
            return true;
        }
        launchIntentForPackage.addFlags(ClientDefaults.MAX_MSG_SIZE);
        launchIntentForPackage.putExtra("TS", TrialFilter.getCloudTimestamp(preference.getContext()));
        preferenceActivity.startActivity(launchIntentForPackage);
        return true;
    }

    private void performRefresh(final PreferenceActivity preferenceActivity, PreferenceScreen preferenceScreen) {
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preferenceScreen.findPreference("experiments_optout");
        if (checkBoxPreference != null) {
            checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.11
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    Logger.logInfo("EXPERIMENTS OPT-OUT SETTINGS CHANGED: " + obj);
                    return true;
                }
            });
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) preferenceScreen.findPreference("analytics_opt_out");
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.12
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    if (((CheckBoxPreference) preference).isChecked()) {
                        preferenceActivity.showDialog(3);
                        return true;
                    }
                    Logger.logInfo("Opting in back to analytics..");
                    return true;
                }
            });
        }
    }

    private void setBackupPathSummary(Uri uri) {
        Preference preferenceFindPreference;
        if (uri == null || (preferenceFindPreference = findPreference("backup_storage_path")) == null) {
            return;
        }
        preferenceFindPreference.setSummary(NoiseDirectory.getHumanReadablePath(uri));
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//general/privacy.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_privacy;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.privacy;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (Environment.isLollipopOrGreater() && i == 111 && i2 == -1) {
            Uri directoryPicked = DirectoryPicker.parseDirectoryPicked(SharedApplicationContext.getInstance().getContext(), intent);
            if (NoiseDirectory.checkReadWriteAccessUri(SharedApplicationContext.getInstance().getContext(), directoryPicked)) {
                Logger.logInfo("Backup directory set to: " + directoryPicked);
                setBackupPathSummary(directoryPicked);
                SharedApplicationContext.getSettings().setBackupDirUri(directoryPicked);
            }
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i != 3) {
            return super.onCreateDialog(i);
        }
        final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("analytics_opt_out");
        return new MaterialAlertDialogBuilder(this).setTitle(R.string.analytics_opt_out).setMessage(R.string.analytics_opt_out_confirm).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (checkBoxPreference.isChecked()) {
                    Logger.logInfo("Opting out from analytics.");
                    PrivacySettingsActivity.this.dismissDialog(3);
                } else {
                    Logger.logWarning("Inconsistent isCheck with assumed state. The checkbox should be checked when we show this dialog.");
                    ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "Inconsistent checkbox state.");
                }
            }
        }).setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                checkBoxPreference.setChecked(false);
                PrivacySettingsActivity.this.dismissDialog(3);
            }
        }).create();
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        super.onPrepareDialog(i, dialog);
        DialogUtil.fixDivider(dialog);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 376) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("geo_opt_out");
            if (iArr[0] == 0) {
                SharedApplicationContext.getSettings().setGeoOptOut(false);
                if (checkBoxPreference != null) {
                    checkBoxPreference.setChecked(false);
                    return;
                }
                return;
            }
            ViewIntent.getPermissionDenyDialogBuilder(this, "android.permission.ACCESS_COARSE_LOCATION", R.string.settings_geo_opt_in).show();
            SharedApplicationContext.getSettings().setGeoOptOut(true);
            if (checkBoxPreference != null) {
                checkBoxPreference.setChecked(true);
                return;
            }
            return;
        }
        if (i == 782) {
            CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference("backup_local");
            if (iArr[0] == 0) {
                SharedApplicationContext.getSettings().setBackupLocal(true);
                if (checkBoxPreference2 != null) {
                    checkBoxPreference2.setChecked(true);
                    return;
                }
                return;
            }
            ViewIntent.getPermissionDenyDialogBuilder(this, "android.permission.READ_EXTERNAL_STORAGE", R.string.settings_backup_local).show();
            SharedApplicationContext.getSettings().setBackupLocal(false);
            if (checkBoxPreference2 != null) {
                checkBoxPreference2.setChecked(false);
                return;
            }
            return;
        }
        if (i != 892) {
            return;
        }
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) findPreference("phone_call");
        if (iArr[0] == 0) {
            SharedApplicationContext.getSettings().setPhoneCall(true);
            if (checkBoxPreference3 != null) {
                checkBoxPreference3.setChecked(true);
                return;
            }
            return;
        }
        SharedApplicationContext.getSettings().setPhoneCall(false);
        if (checkBoxPreference3 != null) {
            checkBoxPreference3.setChecked(false);
        }
        ViewIntent.getPermissionDenyDialogBuilder(this, "android.permission.READ_PHONE_STATE", R.string.phone_call_summary).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(final PreferenceActivity preferenceActivity, boolean z) {
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        final Settings settings = new Settings(preferenceActivity);
        if (!SearchSettingsActivity.class.equals(getClass())) {
            if (Build.VERSION.SDK_INT < 33 && settings.isBackupLocal()) {
                SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
                if (!sleepPermissionCompat.isPermissionGranted(preferenceActivity, "android.permission.WRITE_EXTERNAL_STORAGE") || !sleepPermissionCompat.isPermissionGranted(preferenceActivity, "android.permission.READ_EXTERNAL_STORAGE")) {
                    Logger.logInfo("Permissions: STORAGE Request ");
                    sleepPermissionCompat.requestPermissions(preferenceActivity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 782);
                }
            }
            if (!settings.isGeoOptOut()) {
                Logger.logInfo("Permissions: LOCATION Request ");
                SleepPermissionCompat.INSTANCE.requestLocationPermission(preferenceActivity, 376);
            }
        }
        Preference preferenceFindPreference = preferenceScreen.findPreference("gdpr_consent");
        Object[] objArr = 0;
        if (preferenceFindPreference != null) {
            final Object[] objArr2 = objArr == true ? 1 : 0;
            preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ PrivacySettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i = objArr2;
                    PrivacySettingsActivity privacySettingsActivity = this.f$0;
                    switch (i) {
                        case 0:
                            return privacySettingsActivity.lambda$refresh$0(preference);
                        case 1:
                            return privacySettingsActivity.lambda$refresh$1(preference);
                        case 2:
                            return privacySettingsActivity.lambda$refresh$2(preference);
                        default:
                            return privacySettingsActivity.lambda$refresh$4(preference);
                    }
                }
            });
        }
        Preference preferenceFindPreference2 = preferenceScreen.findPreference("privacy_policy_summary");
        final int i = 1;
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ PrivacySettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i2 = i;
                    PrivacySettingsActivity privacySettingsActivity = this.f$0;
                    switch (i2) {
                        case 0:
                            return privacySettingsActivity.lambda$refresh$0(preference);
                        case 1:
                            return privacySettingsActivity.lambda$refresh$1(preference);
                        case 2:
                            return privacySettingsActivity.lambda$refresh$2(preference);
                        default:
                            return privacySettingsActivity.lambda$refresh$4(preference);
                    }
                }
            });
        }
        Preference preferenceFindPreference3 = preferenceScreen.findPreference("privacy_policy");
        if (preferenceFindPreference3 != null) {
            final int i2 = 2;
            preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ PrivacySettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i22 = i2;
                    PrivacySettingsActivity privacySettingsActivity = this.f$0;
                    switch (i22) {
                        case 0:
                            return privacySettingsActivity.lambda$refresh$0(preference);
                        case 1:
                            return privacySettingsActivity.lambda$refresh$1(preference);
                        case 2:
                            return privacySettingsActivity.lambda$refresh$2(preference);
                        default:
                            return privacySettingsActivity.lambda$refresh$4(preference);
                    }
                }
            });
        }
        Preference preferenceFindPreference4 = preferenceScreen.findPreference("terms");
        if (preferenceFindPreference4 != null) {
            final int i3 = 3;
            preferenceFindPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ PrivacySettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i22 = i3;
                    PrivacySettingsActivity privacySettingsActivity = this.f$0;
                    switch (i22) {
                        case 0:
                            return privacySettingsActivity.lambda$refresh$0(preference);
                        case 1:
                            return privacySettingsActivity.lambda$refresh$1(preference);
                        case 2:
                            return privacySettingsActivity.lambda$refresh$2(preference);
                        default:
                            return privacySettingsActivity.lambda$refresh$4(preference);
                    }
                }
            });
        }
        Preference preferenceFindPreference5 = preferenceScreen.findPreference("sleepcloud");
        if (preferenceFindPreference5 != null) {
            preferenceFindPreference5.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 15));
        }
        Preference preferenceFindPreference6 = preferenceScreen.findPreference("backup_local");
        if (preferenceFindPreference6 != null) {
            preferenceFindPreference6.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.1
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    if (!((Boolean) obj).booleanValue() || Build.VERSION.SDK_INT >= 33) {
                        return true;
                    }
                    SleepPermissionCompat sleepPermissionCompat2 = SleepPermissionCompat.INSTANCE;
                    if (sleepPermissionCompat2.isPermissionGranted(preferenceActivity, "android.permission.WRITE_EXTERNAL_STORAGE") && sleepPermissionCompat2.isPermissionGranted(preferenceActivity, "android.permission.READ_EXTERNAL_STORAGE")) {
                        return true;
                    }
                    Logger.logInfo("Permissions: STORAGE Request ");
                    sleepPermissionCompat2.requestPermissions(preferenceActivity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 782);
                    return false;
                }
            });
        }
        Preference preferenceFindPreference7 = preferenceScreen.findPreference("phone_call");
        if (preferenceFindPreference7 != null) {
            preferenceFindPreference7.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.2
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    if (!((Boolean) obj).booleanValue()) {
                        return true;
                    }
                    SleepPermissionCompat sleepPermissionCompat2 = SleepPermissionCompat.INSTANCE;
                    if (sleepPermissionCompat2.isPermissionGranted(preferenceActivity, "android.permission.READ_PHONE_STATE")) {
                        return true;
                    }
                    Logger.logInfo("Permissions: PHONE Request ");
                    sleepPermissionCompat2.requestPermissions(preferenceActivity, new String[]{"android.permission.READ_PHONE_STATE"}, 892);
                    return false;
                }
            });
        }
        Preference preferenceFindPreference8 = preferenceScreen.findPreference("ads_opt_out");
        Logger.logInfo("Privacy " + preferenceFindPreference8);
        if (preferenceFindPreference8 != null) {
            preferenceFindPreference8.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.3
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    try {
                        preferenceActivity.startActivity(new Intent("com.google.android.gms.settings.ADS_PRIVACY"));
                        return true;
                    } catch (Exception unused) {
                        ViewIntent.url(preferenceActivity, "https://www.facebook.com/ads/preferences");
                        return true;
                    }
                }
            });
        }
        Preference preferenceFindPreference9 = preferenceScreen.findPreference("ads_settings");
        Logger.logInfo("Privacy " + preferenceFindPreference9);
        if (preferenceFindPreference9 != null) {
            preferenceFindPreference9.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.4
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    ViewIntent.url(preferenceActivity, "https://www.facebook.com/ads/preferences");
                    return true;
                }
            });
        }
        Preference preferenceFindPreference10 = preferenceScreen.findPreference("restore_settings");
        if (preferenceFindPreference10 != null) {
            preferenceFindPreference10.setOnPreferenceClickListener(new AnonymousClass5(preferenceActivity));
        }
        performRefresh(preferenceActivity, preferenceScreen);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preferenceScreen.findPreference("geo_opt_out");
        if (checkBoxPreference != null) {
            checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.6
                @Override // android.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    if (((Boolean) obj).booleanValue()) {
                        return true;
                    }
                    return !SleepPermissionCompat.INSTANCE.requestLocationPermission(preferenceActivity, 376);
                }
            });
        }
        Preference preferenceFindPreference11 = preferenceActivity.findPreference("reset_home");
        if (preferenceFindPreference11 != null) {
            preferenceFindPreference11.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.7
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    new MaterialAlertDialogBuilder(preferenceActivity).setMessage(R.string.are_you_sure).setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.7.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i4) {
                            SharedApplicationContext.getSettings().resetGeoTimeFrom();
                            FrequentGeoService.start(preferenceActivity);
                        }
                    }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
                    return false;
                }
            });
        }
        final Preference preferenceFindPreference12 = preferenceScreen.findPreference("backup_storage_path");
        Logger.logInfo("PrivacySettingsActivity: open document available");
        if (Environment.isLollipopOrGreater() && DirectoryPicker.isOpenDocumentTreeAvailable(preferenceActivity)) {
            Logger.logInfo("PrivacySettingsActivity: open document available");
            if (preferenceFindPreference12 != null) {
                if (settings.hasNoiseDirUri()) {
                    setBackupPathSummary(settings.getBackupDirUri());
                } else {
                    preferenceFindPreference12.setSummary("");
                }
                Logger.logInfo("PrivacySettingsActivity: Storage: " + settings.getBackupDirUri());
                preferenceFindPreference12.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.8
                    @Override // android.preference.Preference.OnPreferenceClickListener
                    public boolean onPreferenceClick(Preference preference) {
                        if (settings.hasNoiseDirUri()) {
                            new MaterialAlertDialogBuilder(preferenceActivity).setTitle(R.string.storage_path).setMessage((CharSequence) NoiseDirectory.getHumanReadablePath(settings.getBackupDirUri())).setPositiveButton(R.string.set_time, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.8.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i4) {
                                    DirectoryPicker.open(preferenceActivity, 111);
                                }
                            }).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setNeutralButton(R.string.reset, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.PrivacySettingsActivity.8.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i4) {
                                    settings.clearNoiseDirUri();
                                    preferenceFindPreference12.setSummary("");
                                }
                            }).show();
                            return true;
                        }
                        DirectoryPicker.open(preferenceActivity, 111);
                        return true;
                    }
                });
            }
        }
        LamerPreferenceCategory.init(preferenceActivity, preferenceScreen, z || new Settings(preferenceActivity).isExpandAllSettings(), "settings_category_advanced", "settings_category_backup");
    }
}
