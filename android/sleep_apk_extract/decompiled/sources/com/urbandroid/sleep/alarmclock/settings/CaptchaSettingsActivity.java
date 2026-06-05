package com.urbandroid.sleep.alarmclock.settings;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.view.View;
import android.widget.Toast;
import androidx.work.WorkerKt$$ExternalSyntheticLambda0;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.captcha.BaseCaptchaManager;
import com.urbandroid.sleep.captcha.CaptchaDrawableUtil;
import com.urbandroid.sleep.captcha.CaptchaManager;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.captcha.list.AbstractCaptchaDialogFragment;
import com.urbandroid.sleep.captcha.list.CaptchaTileListActivity;
import com.urbandroid.sleep.fragment.NoiseFragment$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.gui.MaterialDialogListPreference;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.pref.LamerPreferenceCategory;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.SleepPermissionCompat;

/* JADX INFO: loaded from: classes4.dex */
public class CaptchaSettingsActivity extends SimpleSettingsActivity implements AbstractCaptchaDialogFragment.OnCloseListener {
    private Preference captchaListPref;
    private CaptchaManager captchaManager;
    private Preference configPref;
    private ListPreference difficultyPref;

    private CaptchaInfo getCurrent(CaptchaManager captchaManager) {
        return captchaManager.getFinder().findById(SharedApplicationContext.getSettings().getDefaultCaptchaId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refresh$0(PreferenceActivity preferenceActivity, View view) {
        if (this.captchaManager == null) {
            this.captchaManager = new BaseCaptchaManager(preferenceActivity);
        }
        CaptchaInfo current = getCurrent(this.captchaManager);
        if (current != null) {
            this.captchaManager.getLauncher().difficulty(SharedApplicationContext.getSettings().getCaptchaDifficulty(current)).mode(2).start(current);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refresh$1(PreferenceActivity preferenceActivity) {
        MaterialButton materialButton = (MaterialButton) ((MaterialDialogListPreference) this.difficultyPref).getActionButton();
        if (materialButton != null) {
            materialButton.setVisibility(0);
            materialButton.setText(R.string.button_preview);
            materialButton.setIconResource(R.drawable.ic_eye);
            materialButton.setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(this, preferenceActivity, 8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$2(Preference preference) {
        ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//alarms/captcha.html");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$3(Preference preference) {
        long wakeUpCheckScheduled = SharedApplicationContext.getSettings().getWakeUpCheckScheduled();
        if (wakeUpCheckScheduled == -1 || System.currentTimeMillis() - wakeUpCheckScheduled > 0) {
            startActivity(new Intent(this, (Class<?>) CaptchaWakeUpCheckSettingsActivity.class));
            return false;
        }
        try {
            Toast.makeText(this, getString(R.string.settings_wake_up_check) + " " + getString(R.string.in_progress).toLowerCase() + "\n" + getString(R.string.trial_unlock) + ": " + DateUtil.formatTime(this, wakeUpCheckScheduled), 1).show();
            return false;
        } catch (Exception unused) {
            Toast.makeText(this, getString(R.string.settings_wake_up_check) + " " + getString(R.string.in_progress).toLowerCase(), 1).show();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$4(Preference preference) {
        startActivityForResult(new Intent(this, (Class<?>) CaptchaTileListActivity.class), 39488);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$5(Settings settings, Preference preference, Object obj) {
        int defaultCaptchaId = settings.getDefaultCaptchaId();
        if (defaultCaptchaId == 0) {
            return true;
        }
        CaptchaInfo captchaInfo = settings.getCaptchaInfo(defaultCaptchaId);
        if (captchaInfo != null) {
            settings.setCaptchaDifficulty(captchaInfo, Integer.parseInt(obj.toString()));
        } else {
            Logger.logWarning("difficultyPref - No Captcha info found for id: " + defaultCaptchaId);
        }
        SimpleSettingsActivity.fillSummaryWithValue((ListPreference) preference, obj);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$refresh$6(PreferenceActivity preferenceActivity, Preference preference) {
        if (this.captchaManager == null) {
            this.captchaManager = new BaseCaptchaManager(preferenceActivity);
        }
        CaptchaInfo current = getCurrent(this.captchaManager);
        if (current == null) {
            return false;
        }
        this.captchaManager.getLauncher().difficulty(SharedApplicationContext.getSettings().getCaptchaDifficulty(current)).mode(3).start(current);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showCaptchaPreviewDialog$7(DialogInterface dialogInterface, int i) {
        SharedApplicationContext.getSettings().addShowCaseShown("captcha_preview");
    }

    public static void requestCaptchaPermissions(Activity activity, int i) {
        if (i == 9) {
            SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
            if (sleepPermissionCompat.isPermissionGranted(activity, "android.permission.RECORD_AUDIO")) {
                return;
            }
            Logger.logInfo("CaptchaSettingsActivity: LOLCaptcha: Permissions: RECORD_AUDIO Request");
            sleepPermissionCompat.requestPermission(activity, "android.permission.RECORD_AUDIO", 972);
        }
    }

    private void setSelectedCaptchaId(int i) {
        this.captchaListPref.setIcon(CaptchaDrawableUtil.getDrawable(this, i));
        showCaptchaPreviewDialog(this, this.captchaManager, i);
        refresh();
    }

    public static void showCaptchaPreviewDialog(Activity activity, final CaptchaManager captchaManager, int i) {
        final CaptchaInfo captchaInfoFindById = captchaManager.getFinder().findById(i);
        if (captchaInfoFindById != null) {
            if ((captchaInfoFindById.getId() == 3 && SharedApplicationContext.getSettings().getQRCaptcha().length == 0) || (i == 6 && SharedApplicationContext.getSettings().getNFCCaptcha().length == 0)) {
                captchaManager.getLauncher().mode(3).start(captchaInfoFindById);
            } else if (!SharedApplicationContext.getSettings().isShowCaseShown("captcha_preview")) {
                new MaterialAlertDialogBuilder(activity).setTitle(R.string.button_preview).setMessage(R.string.captcha_preview_recommendation).setPositiveButton(R.string.button_preview, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.settings.CaptchaSettingsActivity.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        captchaManager.getLauncher().mode(2).start(captchaInfoFindById);
                    }
                }).setNegativeButton(R.string.button_captcha_cancel, (DialogInterface.OnClickListener) null).setNeutralButton(R.string.never_rate, (DialogInterface.OnClickListener) new NoiseFragment$$ExternalSyntheticLambda6(2)).show();
            }
            requestCaptchaPermissions(activity, i);
        }
    }

    private void updateState(CaptchaInfo captchaInfo, PreferenceScreen preferenceScreen) {
        Settings settings = SharedApplicationContext.getSettings();
        Preference preference = this.configPref;
        if (captchaInfo == null) {
            if (preference != null) {
                ((PreferenceGroup) preferenceScreen.findPreference("settings_category_captcha")).removePreference(this.configPref);
            }
            if (this.difficultyPref != null) {
                ((PreferenceGroup) preferenceScreen.findPreference("settings_category_captcha")).removePreference(this.difficultyPref);
                return;
            }
            return;
        }
        if (preference != null) {
            if (captchaInfo.isConfigurable()) {
                ((PreferenceGroup) preferenceScreen.findPreference("settings_category_captcha")).addPreference(this.configPref);
            } else {
                ((PreferenceGroup) preferenceScreen.findPreference("settings_category_captcha")).removePreference(this.configPref);
            }
        }
        if (this.difficultyPref != null) {
            if (!captchaInfo.hasDifficulty()) {
                ((PreferenceGroup) preferenceScreen.findPreference("settings_category_captcha")).removePreference(this.difficultyPref);
                return;
            }
            ((PreferenceGroup) preferenceScreen.findPreference("settings_category_captcha")).addPreference(this.difficultyPref);
            String strValueOf = String.valueOf(settings.getCaptchaDifficulty(captchaInfo));
            this.difficultyPref.setValue(strValueOf);
            SimpleSettingsActivity.fillSummaryWithValue(this.difficultyPref, strValueOf);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//alarms/captcha.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_captcha;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.settings_category_captcha;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 39488 && i2 == -1) {
            setSelectedCaptchaId(intent.getIntExtra("captchaId", -1));
        }
    }

    @Override // com.urbandroid.sleep.captcha.list.AbstractCaptchaDialogFragment.OnCloseListener
    public void onClose(int i) {
        setSelectedCaptchaId(i);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.captchaManager = new BaseCaptchaManager(getApplicationContext());
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean z) {
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        if (this.configPref == null) {
            this.configPref = preferenceScreen.findPreference("captcha_config");
        }
        if (this.difficultyPref == null) {
            ListPreference listPreference = (ListPreference) preferenceScreen.findPreference("captcha_difficulty");
            this.difficultyPref = listPreference;
            ((MaterialDialogListPreference) listPreference).setBindListener(new WorkerKt$$ExternalSyntheticLambda0(this, preferenceActivity, 17));
        }
        if (preferenceScreen != null) {
            Preference preferenceFindPreference = preferenceScreen.findPreference("capctha_expl");
            Object[] objArr = 0;
            if (preferenceFindPreference != null) {
                final Object[] objArr2 = objArr == true ? 1 : 0;
                preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.CaptchaSettingsActivity$$ExternalSyntheticLambda1
                    public final /* synthetic */ CaptchaSettingsActivity f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // android.preference.Preference.OnPreferenceClickListener
                    public final boolean onPreferenceClick(Preference preference) {
                        int i = objArr2;
                        CaptchaSettingsActivity captchaSettingsActivity = this.f$0;
                        switch (i) {
                            case 0:
                                return captchaSettingsActivity.lambda$refresh$2(preference);
                            case 1:
                                return captchaSettingsActivity.lambda$refresh$3(preference);
                            default:
                                return captchaSettingsActivity.lambda$refresh$4(preference);
                        }
                    }
                });
            }
            Preference preferenceFindPreference2 = findPreference("settings_category_wake_up_check");
            final int i = 1;
            if (preferenceFindPreference2 != null) {
                preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.CaptchaSettingsActivity$$ExternalSyntheticLambda1
                    public final /* synthetic */ CaptchaSettingsActivity f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // android.preference.Preference.OnPreferenceClickListener
                    public final boolean onPreferenceClick(Preference preference) {
                        int i2 = i;
                        CaptchaSettingsActivity captchaSettingsActivity = this.f$0;
                        switch (i2) {
                            case 0:
                                return captchaSettingsActivity.lambda$refresh$2(preference);
                            case 1:
                                return captchaSettingsActivity.lambda$refresh$3(preference);
                            default:
                                return captchaSettingsActivity.lambda$refresh$4(preference);
                        }
                    }
                });
            }
            Preference preferenceFindPreference3 = preferenceScreen.findPreference("captcha_mode");
            this.captchaListPref = preferenceFindPreference3;
            if (preferenceFindPreference3 != null) {
                final int i2 = 2;
                preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.CaptchaSettingsActivity$$ExternalSyntheticLambda1
                    public final /* synthetic */ CaptchaSettingsActivity f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // android.preference.Preference.OnPreferenceClickListener
                    public final boolean onPreferenceClick(Preference preference) {
                        int i22 = i2;
                        CaptchaSettingsActivity captchaSettingsActivity = this.f$0;
                        switch (i22) {
                            case 0:
                                return captchaSettingsActivity.lambda$refresh$2(preference);
                            case 1:
                                return captchaSettingsActivity.lambda$refresh$3(preference);
                            default:
                                return captchaSettingsActivity.lambda$refresh$4(preference);
                        }
                    }
                });
            }
            Settings settings = SharedApplicationContext.getSettings();
            int defaultCaptchaId = settings.getDefaultCaptchaId();
            CaptchaInfo captchaInfo = settings.getCaptchaInfo(defaultCaptchaId);
            ListPreference listPreference2 = this.difficultyPref;
            int i3 = 3;
            if (listPreference2 != null && captchaInfo != null) {
                listPreference2.setOnPreferenceChangeListener(new BedtimeSettingsActivity$$ExternalSyntheticLambda1(settings, i3));
            }
            updateState(captchaInfo, preferenceScreen);
            Preference preference = this.captchaListPref;
            if (preference != null) {
                if (defaultCaptchaId == 0) {
                    preference.setSummary(preferenceActivity.getString(R.string.disabled));
                } else {
                    preference.setSummary(CaptchaPreferenceUtil.getSummary(preferenceActivity, captchaInfo == null ? 1 : defaultCaptchaId));
                }
                this.captchaListPref.setIcon(CaptchaDrawableUtil.getDrawable(this, defaultCaptchaId));
            }
            Preference preference2 = this.configPref;
            if (preference2 != null) {
                preference2.setOnPreferenceClickListener(new AlarmSettingsActivity$$ExternalSyntheticLambda4(this, preferenceActivity, i3));
            }
            LamerPreferenceCategory.init(preferenceActivity, preferenceScreen, z || new Settings(preferenceActivity).isExpandAllSettings(), "settings_category_advanced");
        }
    }
}
