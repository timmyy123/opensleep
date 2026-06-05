package com.urbandroid.sleep.alarmclock.settings;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.view.View;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.service.SettingKeys;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartlight.DiscoveryActivity$$ExternalSyntheticLambda5;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u000e8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u000b\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/BedtimeNoAlarmSettingsActivity;", "Lcom/urbandroid/sleep/alarmclock/settings/SimpleSettingsActivity;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "Landroid/os/Bundle;", "paramBundle", "", "onCreatePreference", "(Landroid/os/Bundle;)V", "", "getSettings", "()I", "getTitleResource", "", "getDocumentationUrl", "()Ljava/lang/String;", "Lcom/urbandroid/sleep/gui/PreferenceActivity;", "preferenceActivity", "", "searchMode", "refresh", "(Lcom/urbandroid/sleep/gui/PreferenceActivity;Z)V", "tag", "Ljava/lang/String;", "getTag", "Lcom/urbandroid/sleep/service/Settings;", "settings", "Lcom/urbandroid/sleep/service/Settings;", "()Lcom/urbandroid/sleep/service/Settings;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BedtimeNoAlarmSettingsActivity extends SimpleSettingsActivity implements FeatureLogger {
    private final String tag = "BedtimeNoAlarm";
    private final Settings settings = new Settings(this);

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$0(PreferenceActivity preferenceActivity, Preference preference) {
        ViewIntent.urlCustomTab(preferenceActivity, "https://sleep.urbandroid.org/docs//alarms/bedtime_notification.html");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$1(BedtimeNoAlarmSettingsActivity bedtimeNoAlarmSettingsActivity, Preference preference, Object obj) {
        Logger.logInfo("No Bedtime " + obj);
        bedtimeNoAlarmSettingsActivity.h.postDelayed(new ActivityCompat$$ExternalSyntheticLambda0(bedtimeNoAlarmSettingsActivity, 23), 1L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$2$0(BedtimeNoAlarmSettingsActivity bedtimeNoAlarmSettingsActivity, String str, Preference preference, Preference preference2) {
        MaterialTimePicker materialTimePickerBuild = new MaterialTimePicker.Builder().setHour(bedtimeNoAlarmSettingsActivity.settings.getNoAlarmBedtimeHourByKey(str)).setMinute(bedtimeNoAlarmSettingsActivity.settings.getNoAlarmBedtimeminuteByKey(str)).setInputMode(0).setTimeFormat(Alarms.get24HourMode(bedtimeNoAlarmSettingsActivity) ? 1 : 0).build();
        materialTimePickerBuild.getClass();
        materialTimePickerBuild.addOnPositiveButtonClickListener(new DiscoveryActivity$$ExternalSyntheticLambda5(bedtimeNoAlarmSettingsActivity, str, materialTimePickerBuild, preference, 1));
        materialTimePickerBuild.show(bedtimeNoAlarmSettingsActivity.getSupportFragmentManager(), str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$2$0$0(BedtimeNoAlarmSettingsActivity bedtimeNoAlarmSettingsActivity, String str, MaterialTimePicker materialTimePicker, Preference preference, View view) {
        bedtimeNoAlarmSettingsActivity.settings.saveNoAlarmBedtimeByKey(str, materialTimePicker.getHour(), materialTimePicker.getMinute());
        if (preference != null) {
            preference.setSummary(DateUtil.formatTime(bedtimeNoAlarmSettingsActivity, bedtimeNoAlarmSettingsActivity.settings.getNoAlarmBedtimeTimeByKey(str)));
        }
        Alarms.setNextAlert(bedtimeNoAlarmSettingsActivity);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//alarms/bedtime_notification.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_bedtime_no_alarm;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.bedtime_no_alarm;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public void onCreatePreference(Bundle paramBundle) {
        super.onCreatePreference(paramBundle);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean searchMode) {
        preferenceActivity.getClass();
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        Preference preferenceFindPreference = preferenceScreen != null ? preferenceScreen.findPreference("bedtime_expl") : null;
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 8));
        }
        Preference preferenceFindPreference2 = preferenceScreen != null ? preferenceScreen.findPreference("no_alarm_bedtime") : null;
        int i = 1;
        if (preferenceFindPreference2 != null) {
            Logger.logInfo("No Bedtime");
            preferenceFindPreference2.setOnPreferenceChangeListener(new BedtimeSettingsActivity$$ExternalSyntheticLambda1(this, i));
        }
        String[] strArr = SettingKeys.NO_ALARM_BEDTIME_ARRAY;
        strArr.getClass();
        for (String str : strArr) {
            Preference preferenceFindPreference3 = preferenceScreen != null ? preferenceScreen.findPreference(str) : null;
            if (preferenceFindPreference3 != null) {
                preferenceFindPreference3.setSummary(DateUtil.formatTime(this, this.settings.getNoAlarmBedtimeTimeByKey(str)));
            }
            if (preferenceFindPreference3 != null) {
                preferenceFindPreference3.setOnPreferenceClickListener(new ServicesSettingsActivity$$ExternalSyntheticLambda11(this, str, preferenceFindPreference3, i));
            }
        }
    }
}
