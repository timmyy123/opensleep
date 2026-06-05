package com.urbandroid.sleep.alarmclock.settings;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Handler;
import android.preference.Preference;
import android.view.View;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.Settings;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SettingsShowCaseManager {
    private PreferenceActivity preferenceActivity;
    private Settings settings;
    private List<String> showCaseShown;
    private Map<String, String> rules = new HashMap();
    private Runnable currentRunnable = null;
    private Handler h = new Handler();

    public SettingsShowCaseManager(PreferenceActivity preferenceActivity) {
        this.preferenceActivity = preferenceActivity;
        this.showCaseShown = new Settings(preferenceActivity.getApplicationContext()).getShowCaseShown();
        this.settings = new Settings(preferenceActivity.getApplicationContext());
        putRule(preferenceActivity, "settings_category_captcha");
        putRule(preferenceActivity, "settings_category_alarm");
        putRule(preferenceActivity, "settings_category_track");
        putRule(preferenceActivity, "settings_category_lullaby");
        putRule(preferenceActivity, "settings_category_noise");
        putRule(preferenceActivity, "settings_category_services");
        putRule(preferenceActivity, "settings_category_misc");
        putRule(preferenceActivity, "settings_category_time_to_bed");
        putRule(preferenceActivity, "non_deep_sleep_method");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeRule(String str, View view, String str2) {
        str.getClass();
        switch (str) {
            case "settings_category_services":
                showShowCase(str, view, s(R.string.addons_backup_title), s(R.string.addons_backup_desc), R.color.t3, R.drawable.ic_cloud_upload);
                break;
            case "settings_category_smartlight":
                showShowCase(str, view, s(R.string.smartlight_title), s(R.string.purchase_hue_advocate), R.color.t3, R.drawable.ic_action_bedtime);
                break;
            case "settings_category_misc":
                showShowCase(str, view, s(R.string.text_to_speech_title), s(R.string.text_to_speech_summary), R.color.t4, R.drawable.ic_dots_horizontal);
                break;
            case "settings_category_lullaby":
                showShowCase(str, view, s(R.string.advice_issues_lullaby), s(R.string.settings_category_lullaby_summary), R.color.t0, R.drawable.ic_action_lullaby);
                break;
            case "settings_category_captcha":
                showShowCase(str, view, str2, s(R.string.advice_issues_wake), R.color.t2a, R.drawable.ic_qrcode);
                break;
            case "settings_category_time_to_bed":
                showShowCase(str, view, s(R.string.time_to_bed_smart_title), s(R.string.time_to_bed_smart_summary), R.color.t1a, R.drawable.ic_action_bedtime);
                break;
            case "settings_category_snooze":
                showShowCase(str, view, s(R.string.stop_oversleeping), s(R.string.snooze_limit_title) + ". " + s(R.string.snooze_halve_summary), R.color.t2, R.drawable.ic_action_snooze);
                break;
            case "non_deep_sleep_method":
                showShowCase(str, view, s(R.string.non_deep_sleep_method_title) + ": " + s(R.string.sensor_sonar), s(R.string.step_sonar), R.color.t2a, R.drawable.ic_eye);
                break;
            case "settings_category_alarm":
                String string = this.preferenceActivity.getResources().getString(R.string.use, s(R.string.ringtone_nature_ALL).toLowerCase());
                StringBuilder sb = new StringBuilder();
                sb.append(s(R.string.ringtone_nature_BIRDS));
                sb.append(", ");
                sb.append(s(R.string.ringtone_nature_SEA));
                sb.append(", ");
                sb.append(s(R.string.ringtone_nature_CRICKETS));
                sb.append(", ");
                sb.append(s(R.string.ringtone_nature_CUCKCOO));
                sb.append(", ");
                sb.append(s(R.string.ringtone_nature_STORM));
                sb.append(", ");
                showShowCase(str, view, string, FileInsert$$ExternalSyntheticOutline0.m(sb, s(R.string.ringtone_nature_WHALE), "..."), R.color.t0, R.drawable.ic_action_time);
                break;
            case "settings_category_noise":
                showShowCase(str, view, s(R.string.sleep_recording_summary), s(R.string.anti_snoring_title) + ": " + s(R.string.anti_snoring_summary).toLowerCase(), R.color.t2, R.drawable.ic_action_noise);
                break;
            case "settings_category_track":
                showShowCase(str, view, s(R.string.sonar_try), s(R.string.sonar_explanation) + " " + s(R.string.sonar_sensitivity), R.color.t2a, R.drawable.ic_action_track);
                break;
        }
    }

    private boolean isRuleApplicable(String str) {
        str.getClass();
        switch (str) {
            case "settings_category_services":
                if (!TrialFilter.getInstance().daysUsed(14, 40) || TrialFilter.getInstance().isAddonImport()) {
                }
                break;
            case "settings_category_smartlight":
                if (!TrialFilter.getInstance().daysUsed(60) || this.settings.isSmartlightEnabled() || !Locale.US.getCountry().equals(Locale.getDefault().getCountry())) {
                }
                break;
            case "settings_category_misc":
                if (!TrialFilter.getInstance().daysUsed(40, 60) || this.settings.isTextToSpeech()) {
                }
                break;
            case "settings_category_lullaby":
                if (!TrialFilter.getInstance().daysUsed(10, 40) || this.settings.getUsedLullabies().size() != 0) {
                }
                break;
            case "settings_category_captcha":
                if (!TrialFilter.getInstance().daysUsed(2, 30) || this.settings.getDefaultCaptchaId() != 0) {
                }
                break;
            case "settings_category_time_to_bed":
                if (!TrialFilter.getInstance().daysUsed(26, 50) || this.settings.getTimeToBed(null) == -1 || this.settings.isTimeToBedSmart()) {
                }
                break;
            case "settings_category_snooze":
                if (!TrialFilter.getInstance().daysUsed(18, 40) || this.settings.getDefaultCaptchaId() == 0 || this.settings.isHalveSnooze() || this.settings.getSnoozeLimit(null) != 0) {
                }
                break;
            case "non_deep_sleep_method":
                if (!TrialFilter.getInstance().daysUsed(7) || this.settings.isSonarSupported() != null || this.settings.isUltrasonicTracking()) {
                }
                break;
            case "settings_category_alarm":
                if (!TrialFilter.getInstance().daysUsed(0, 30) || this.settings.hasDefaultRingtone()) {
                }
                break;
            case "settings_category_noise":
                if (!TrialFilter.getInstance().daysUsed(5, 30) || this.settings.isRecordingMasterSwitchEnabled()) {
                }
                break;
            case "settings_category_track":
                if (!TrialFilter.getInstance().daysUsed(7) || this.settings.isSonarSupported() != null || this.settings.isUltrasonicTracking()) {
                }
                break;
        }
        return true;
    }

    private void putRule(PreferenceActivity preferenceActivity, String str) {
        if (this.showCaseShown.contains(str) || !isRuleApplicable(str)) {
            return;
        }
        Logger.logInfo("ShowCase: rule applicable " + str);
        Preference preferenceFindPreference = preferenceActivity.findPreference(str);
        if (preferenceFindPreference == null || preferenceFindPreference.getTitle() == null) {
            return;
        }
        this.rules.put(preferenceFindPreference.getTitle().toString(), str);
    }

    private String s(int i) {
        return this.preferenceActivity.getResources().getString(i);
    }

    private void showShowCase(final String str, View view, String str2, String str3, int i, int i2) {
        if (view == null) {
            Logger.logWarning("Not showing showcase");
            return;
        }
        this.rules.clear();
        view.getLocationOnScreen(new int[2]);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            TapTargetView.showFor(this.preferenceActivity, TapTarget.forView(view, str2, str3).dimColor(R.color.transparent_black).outerCircleColor(R.color.tap_target_color).targetCircleColor(R.color.bg_main).icon(this.preferenceActivity.getResources().getDrawable(i2)).tintTarget(false).cancelable(true).textColor(R.color.white), new TapTargetView.Listener() { // from class: com.urbandroid.sleep.alarmclock.settings.SettingsShowCaseManager.2
                @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
                public void onTargetCancel(TapTargetView tapTargetView) {
                    super.onTargetCancel(tapTargetView);
                }

                @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
                public void onTargetClick(TapTargetView tapTargetView) {
                    super.onTargetClick(tapTargetView);
                }

                @Override // com.getkeepsafe.taptargetview.TapTargetView.Listener
                public void onTargetDismissed(TapTargetView tapTargetView, boolean z) {
                    super.onTargetDismissed(tapTargetView, z);
                    Logger.logInfo("ShowCase: Dismissed in " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                    if (System.currentTimeMillis() - jCurrentTimeMillis > 1000) {
                        SettingsShowCaseManager.this.settings.addShowCaseShown(str);
                    }
                }
            });
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    public void update(final View view, final String str) {
        final String str2;
        if (this.currentRunnable != null || view == null || (str2 = this.rules.get(str)) == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.settings.SettingsShowCaseManager.1
            @Override // java.lang.Runnable
            public void run() {
                SettingsShowCaseManager.this.executeRule(str2, view, str);
                SettingsShowCaseManager.this.currentRunnable = null;
            }
        };
        this.currentRunnable = runnable;
        this.h.postDelayed(runnable, 100L);
    }
}
