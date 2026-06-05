package com.urbandroid.sleep.alarmclock.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.SeekBarPreference;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.shortcut.AddShortcutActivity$$ExternalSyntheticLambda6;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/BedtimeSettingsActivity;", "Lcom/urbandroid/sleep/alarmclock/settings/SimpleSettingsActivity;", "<init>", "()V", "", "bedtime", "", "updateBedtime", "(I)V", "", "minutes", "(Ljava/lang/String;)V", "updateGoal", "getTitleResource", "()I", "getSettings", "Lcom/urbandroid/sleep/gui/PreferenceActivity;", "preferenceActivity", "", "searchMode", "refresh", "(Lcom/urbandroid/sleep/gui/PreferenceActivity;Z)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "getDocumentationUrl", "()Ljava/lang/String;", "Landroid/preference/Preference;", "bedtimeNotificationSegment", "Landroid/preference/Preference;", "goalSegment", "Landroid/preference/ListPreference;", "bedtimePref", "Landroid/preference/ListPreference;", "getBedtimePref", "()Landroid/preference/ListPreference;", "setBedtimePref", "(Landroid/preference/ListPreference;)V", "Lcom/urbandroid/sleep/gui/SeekBarPreference;", "targetSleepMinutes", "Lcom/urbandroid/sleep/gui/SeekBarPreference;", "getTargetSleepMinutes", "()Lcom/urbandroid/sleep/gui/SeekBarPreference;", "setTargetSleepMinutes", "(Lcom/urbandroid/sleep/gui/SeekBarPreference;)V", "Ljava/lang/Runnable;", "updateGoalRunnable", "Ljava/lang/Runnable;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BedtimeSettingsActivity extends SimpleSettingsActivity {
    private static final int RINGTONE_RESULT = 6543;
    private Preference bedtimeNotificationSegment;
    private ListPreference bedtimePref;
    private Preference goalSegment;
    private SeekBarPreference targetSleepMinutes;
    private final Runnable updateGoalRunnable = new ActivityCompat$$ExternalSyntheticLambda0(this, 24);

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$0(BedtimeSettingsActivity bedtimeSettingsActivity, Preference preference) {
        bedtimeSettingsActivity.startActivity(new Intent(bedtimeSettingsActivity, (Class<?>) BedtimeNoAlarmSettingsActivity.class));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$1(BedtimeSettingsActivity bedtimeSettingsActivity, Preference preference, Object obj) {
        obj.getClass();
        super.onPreferenceChange(preference, obj);
        bedtimeSettingsActivity.updateBedtime(obj.toString());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$2(BedtimeSettingsActivity bedtimeSettingsActivity, Preference preference) {
        ViewIntent.url(bedtimeSettingsActivity, "https://sleep.urbandroid.org/docs//alarms/bedtime_notification.html");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String refresh$lambda$3(PreferenceActivity preferenceActivity, int i) {
        return DateUtil.formatMinutesInHumanLanguage(preferenceActivity, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$4(PreferenceActivity preferenceActivity, Settings settings, BedtimeSettingsActivity bedtimeSettingsActivity, Preference preference, Object obj) {
        Logger.logDebug("Ideal time settings changed.");
        Alarms.setNextAlert(preferenceActivity);
        obj.getClass();
        settings.setIdealSleepLegacy(((Integer) obj).intValue() / 60.0f);
        bedtimeSettingsActivity.h.removeCallbacks(bedtimeSettingsActivity.updateGoalRunnable);
        bedtimeSettingsActivity.h.postDelayed(bedtimeSettingsActivity.updateGoalRunnable, 1000L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$5(PreferenceActivity preferenceActivity, Preference preference) {
        Intent intent = new Intent(preferenceActivity, (Class<?>) MediaListActivity.class);
        intent.putExtra("extra_alert_multiple", false);
        intent.putExtra("extra_stream", 5);
        intent.putExtra("extra_hide_app_settings", true);
        intent.putExtra("extra_alert_radio", false);
        intent.putExtra("extra_alert_uri", SharedApplicationContext.getSettings().getTimeToBedRingtone());
        preferenceActivity.startActivityForResult(intent, RINGTONE_RESULT);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$6(BedtimeSettingsActivity bedtimeSettingsActivity, Preference preference) {
        Context applicationContext = bedtimeSettingsActivity.getApplicationContext();
        applicationContext.getClass();
        NotificationsKt.showSettings(applicationContext, "bedtimeChannel");
        return true;
    }

    private final void updateBedtime(int bedtime) {
        Preference preference = this.bedtimeNotificationSegment;
        if (bedtime <= 0) {
            if (preference != null) {
                preference.setSummary(getString(R.string.bedtime_notification_expl));
            }
        } else if (preference != null) {
            preference.setSummary(getString(R.string.bedtime_notification_expl) + ": " + DateUtil.formatMinutesInHumanLanguage(this, Integer.valueOf(bedtime)) + ".");
        }
    }

    private final void updateGoal(int minutes) {
        Preference preference = this.goalSegment;
        if (preference != null) {
            preference.setSummary(getString(R.string.settings_category_sleep) + ": " + DateUtil.formatMinutesInHumanLanguage(this, Integer.valueOf(minutes)) + ".");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateGoalRunnable$lambda$0(BedtimeSettingsActivity bedtimeSettingsActivity) {
        SeekBarPreference seekBarPreference = bedtimeSettingsActivity.targetSleepMinutes;
        bedtimeSettingsActivity.updateGoal(seekBarPreference != null ? seekBarPreference.getCurrentValue() : 0);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//alarms/bedtime_notification.html";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_bedtime;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.time_to_bed_title;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data2) {
        if (data2 != null && requestCode == RINGTONE_RESULT && resultCode == -1) {
            Preference preferenceFindPreference = findPreference("time_to_bed_ringtone");
            if (preferenceFindPreference != null) {
                preferenceFindPreference.setSummary(data2.getStringExtra("extra_alert_title"));
            }
            SharedApplicationContext.getSettings().setTimeToBedRingtone(data2.getStringExtra("extra_alert_uri"));
        }
        super.onActivityResult(requestCode, resultCode, data2);
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean searchMode) {
        preferenceActivity.getClass();
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        Preference preferenceFindPreference = preferenceScreen != null ? preferenceScreen.findPreference("target_sleep_time_notify_before") : null;
        this.bedtimePref = preferenceFindPreference instanceof ListPreference ? (ListPreference) preferenceFindPreference : null;
        Preference preferenceFindPreference2 = preferenceScreen != null ? preferenceScreen.findPreference("time_to_bed_channel") : null;
        Preference preferenceFindPreference3 = preferenceScreen != null ? preferenceScreen.findPreference("time_to_bed_ringtone") : null;
        Preference preferenceFindPreference4 = preferenceScreen != null ? preferenceScreen.findPreference("time_to_bed_vibrating") : null;
        Preference preferenceFindPreference5 = preferenceScreen != null ? preferenceScreen.findPreference("time_to_bed_led") : null;
        Preference preferenceFindPreference6 = preferenceScreen != null ? preferenceScreen.findPreference("settings_category_no_alarm_bedtime") : null;
        final int i = 0;
        if (preferenceFindPreference6 != null) {
            preferenceFindPreference6.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.BedtimeSettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ BedtimeSettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i2 = i;
                    BedtimeSettingsActivity bedtimeSettingsActivity = this.f$0;
                    switch (i2) {
                        case 0:
                            return BedtimeSettingsActivity.refresh$lambda$0(bedtimeSettingsActivity, preference);
                        case 1:
                            return BedtimeSettingsActivity.refresh$lambda$2(bedtimeSettingsActivity, preference);
                        default:
                            return BedtimeSettingsActivity.refresh$lambda$6(bedtimeSettingsActivity, preference);
                    }
                }
            });
        }
        Preference preferenceFindPreference7 = preferenceScreen != null ? preferenceScreen.findPreference("settings_category_time_to_bed_notification") : null;
        preferenceFindPreference7.getClass();
        PreferenceGroup preferenceGroup = (PreferenceGroup) preferenceFindPreference7;
        ListPreference listPreference = this.bedtimePref;
        if (listPreference != null) {
            listPreference.setSummary(listPreference.getEntry());
        }
        ListPreference listPreference2 = this.bedtimePref;
        if (listPreference2 != null) {
            listPreference2.setOnPreferenceChangeListener(this);
        }
        ListPreference listPreference3 = this.bedtimePref;
        if (listPreference3 != null) {
            listPreference3.setOnPreferenceChangeListener(new BedtimeSettingsActivity$$ExternalSyntheticLambda1(this, i));
        }
        Settings settings = new Settings(preferenceActivity);
        Preference preferenceFindPreference8 = preferenceScreen.findPreference("bedtime_expl");
        final int i2 = 1;
        if (preferenceFindPreference8 != null) {
            preferenceFindPreference8.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.BedtimeSettingsActivity$$ExternalSyntheticLambda0
                public final /* synthetic */ BedtimeSettingsActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i22 = i2;
                    BedtimeSettingsActivity bedtimeSettingsActivity = this.f$0;
                    switch (i22) {
                        case 0:
                            return BedtimeSettingsActivity.refresh$lambda$0(bedtimeSettingsActivity, preference);
                        case 1:
                            return BedtimeSettingsActivity.refresh$lambda$2(bedtimeSettingsActivity, preference);
                        default:
                            return BedtimeSettingsActivity.refresh$lambda$6(bedtimeSettingsActivity, preference);
                    }
                }
            });
        }
        this.bedtimeNotificationSegment = findPreference("timeline_segment_bedtime");
        this.goalSegment = findPreference("timeline_segment_wake_up");
        Preference preferenceFindPreference9 = preferenceScreen.findPreference("target_sleep_time_minutes");
        SeekBarPreference seekBarPreference = preferenceFindPreference9 instanceof SeekBarPreference ? (SeekBarPreference) preferenceFindPreference9 : null;
        this.targetSleepMinutes = seekBarPreference;
        if (seekBarPreference != null) {
            seekBarPreference.setCurrentValue(settings.getIdealSleepMinutes());
        }
        SeekBarPreference seekBarPreference2 = this.targetSleepMinutes;
        if (seekBarPreference2 != null) {
            seekBarPreference2.setMajorInterval(30);
        }
        SeekBarPreference seekBarPreference3 = this.targetSleepMinutes;
        if (seekBarPreference3 != null) {
            seekBarPreference3.setFormatter(new AddShortcutActivity$$ExternalSyntheticLambda6(preferenceActivity, i2));
        }
        SeekBarPreference seekBarPreference4 = this.targetSleepMinutes;
        if (seekBarPreference4 != null) {
            seekBarPreference4.setOnPreferenceChangeListener(new TrackSettingsActivity$$ExternalSyntheticLambda7(preferenceActivity, settings, this));
        }
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 9));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (preferenceFindPreference4 != null) {
                preferenceGroup.removePreference(preferenceFindPreference4);
            }
            if (preferenceFindPreference5 != null) {
                preferenceGroup.removePreference(preferenceFindPreference5);
            }
            if (preferenceFindPreference3 != null) {
                preferenceGroup.removePreference(preferenceFindPreference3);
            }
            if (preferenceFindPreference2 != null) {
                final int i3 = 2;
                preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.BedtimeSettingsActivity$$ExternalSyntheticLambda0
                    public final /* synthetic */ BedtimeSettingsActivity f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // android.preference.Preference.OnPreferenceClickListener
                    public final boolean onPreferenceClick(Preference preference) {
                        int i22 = i3;
                        BedtimeSettingsActivity bedtimeSettingsActivity = this.f$0;
                        switch (i22) {
                            case 0:
                                return BedtimeSettingsActivity.refresh$lambda$0(bedtimeSettingsActivity, preference);
                            case 1:
                                return BedtimeSettingsActivity.refresh$lambda$2(bedtimeSettingsActivity, preference);
                            default:
                                return BedtimeSettingsActivity.refresh$lambda$6(bedtimeSettingsActivity, preference);
                        }
                    }
                });
            }
        } else if (preferenceFindPreference2 != null) {
            preferenceGroup.removePreference(preferenceFindPreference2);
        }
        updateBedtime(SharedApplicationContext.getSettings().getTimeToBedBefore());
        updateGoal(SharedApplicationContext.getSettings().getIdealSleepMinutes());
    }

    private final void updateBedtime(String minutes) {
        int i;
        try {
            i = Integer.parseInt(minutes);
        } catch (NumberFormatException unused) {
            i = 0;
        }
        updateBedtime(i);
    }
}
