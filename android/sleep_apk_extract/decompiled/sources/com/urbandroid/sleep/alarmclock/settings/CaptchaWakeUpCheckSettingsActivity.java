package com.urbandroid.sleep.alarmclock.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.VolumeUtil$$ExternalSyntheticLambda0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000e8\u0016X\u0096D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0010R\u0017\u0010\u001e\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u000b\u0010 ¨\u0006!"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/CaptchaWakeUpCheckSettingsActivity;", "Lcom/urbandroid/sleep/alarmclock/settings/SimpleSettingsActivity;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "Landroid/os/Bundle;", "paramBundle", "", "onCreatePreference", "(Landroid/os/Bundle;)V", "", "getSettings", "()I", "getTitleResource", "", "getDocumentationUrl", "()Ljava/lang/String;", "Lcom/urbandroid/sleep/gui/PreferenceActivity;", "preferenceActivity", "", "searchMode", "refresh", "(Lcom/urbandroid/sleep/gui/PreferenceActivity;Z)V", "enabled", "checkNotification", "(Z)V", "tag", "Ljava/lang/String;", "getTag", "Lcom/urbandroid/sleep/service/Settings;", "settings", "Lcom/urbandroid/sleep/service/Settings;", "()Lcom/urbandroid/sleep/service/Settings;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CaptchaWakeUpCheckSettingsActivity extends SimpleSettingsActivity implements FeatureLogger {
    private final String tag = "CaptchaWakeUpCheck";
    private final Settings settings = new Settings(this);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkNotification$lambda$0(CaptchaWakeUpCheckSettingsActivity captchaWakeUpCheckSettingsActivity, DialogInterface dialogInterface, int i) {
        Context applicationContext = captchaWakeUpCheckSettingsActivity.getApplicationContext();
        applicationContext.getClass();
        NotificationsKt.showSettings(applicationContext, !NotificationManagerCompat.from(captchaWakeUpCheckSettingsActivity).areNotificationsEnabled() ? null : "wakeupCheckChannel2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$0(PreferenceActivity preferenceActivity, Preference preference) {
        ViewIntent.urlCustomTab(preferenceActivity, "https://sleep.urbandroid.org/docs//alarms/captcha.html");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$1(CaptchaWakeUpCheckSettingsActivity captchaWakeUpCheckSettingsActivity, Preference preference, Object obj) {
        obj.getClass();
        if (((Boolean) obj).booleanValue()) {
            captchaWakeUpCheckSettingsActivity.checkNotification(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$2(CaptchaWakeUpCheckSettingsActivity captchaWakeUpCheckSettingsActivity, Preference preference) {
        if (Build.VERSION.SDK_INT <= 26) {
            Toast.makeText(captchaWakeUpCheckSettingsActivity, R.string.general_unspecified_error, 0).show();
            return true;
        }
        Context applicationContext = captchaWakeUpCheckSettingsActivity.getApplicationContext();
        applicationContext.getClass();
        NotificationsKt.showSettings(applicationContext, "wakeupCheckChannel2");
        return true;
    }

    public final void checkNotification(boolean enabled) {
        if (!enabled || NotificationsKt.isNotificationChannelEnabled(this, "wakeupCheckChannel2")) {
            return;
        }
        new MaterialAlertDialogBuilder(this).setTitle(R.string.settings_wake_up_check).setMessage(R.string.wake_up_check_notification_warning).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setPositiveButton((CharSequence) getString(R.string.advice_enable_feature, getString(R.string.settings_wake_up_check)), (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(this, 5)).show();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//alarms/captcha.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_captcha_wake_up_check;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.settings_wake_up_check;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public void onCreatePreference(Bundle paramBundle) {
        super.onCreatePreference(paramBundle);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean searchMode) {
        preferenceActivity.getClass();
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        Preference preferenceFindPreference = preferenceScreen != null ? preferenceScreen.findPreference("capctha_expl") : null;
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 11));
        }
        Preference preferenceFindPreference2 = preferenceScreen != null ? preferenceScreen.findPreference("captcha_wake_up_check") : null;
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceChangeListener(new BedtimeSettingsActivity$$ExternalSyntheticLambda1(this, 4));
        }
        Preference preferenceFindPreference3 = preferenceScreen != null ? preferenceScreen.findPreference("notification_channel") : null;
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda0(this, 2));
        }
        checkNotification(this.settings.isWakeUpCheck());
    }
}
