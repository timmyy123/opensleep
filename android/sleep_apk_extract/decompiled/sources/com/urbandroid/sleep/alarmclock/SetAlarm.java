package com.urbandroid.sleep.alarmclock;

import android.app.backup.BackupManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$RequestPermission;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.PermissionCompat;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.settings.AlarmSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.CaptchaPreferenceUtil;
import com.urbandroid.sleep.alarmclock.settings.CaptchaSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.CaptchaWakeUpCheckSettingsActivity;
import com.urbandroid.sleep.alarmclock.timepicker.MaterialTimePicker;
import com.urbandroid.sleep.alarmclock.timepicker.RoundTimePicker;
import com.urbandroid.sleep.alarmclock.timepicker.TimePicker;
import com.urbandroid.sleep.alarmclock.timepicker.TimePickerActivity;
import com.urbandroid.sleep.captcha.CaptchaDrawableUtil;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.captcha.intent.IntentExtraSetter;
import com.urbandroid.sleep.captcha.list.AbstractCaptchaDialogFragment;
import com.urbandroid.sleep.captcha.list.CaptchaTileListActivity;
import com.urbandroid.sleep.gui.AlarmTimePreference;
import com.urbandroid.sleep.gui.DefaultValueListPreference;
import com.urbandroid.sleep.gui.DefaultValuePreference;
import com.urbandroid.sleep.gui.MarginPaddingSpan;
import com.urbandroid.sleep.gui.NextAlarmPreference;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.fab.ElevantionAnimator;
import com.urbandroid.sleep.gui.pref.LamerPreferenceCategory;
import com.urbandroid.sleep.gui.toolbar.AppBarStateChangeListener;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.location.LocationActivity;
import com.urbandroid.sleep.location.LocationService;
import com.urbandroid.sleep.media.InternalRingtones;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.media.MultipleMediaUriUtil;
import com.urbandroid.sleep.media.spotify.ISpotifyPlayer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import com.urbandroid.util.SleepPermissionCompat;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.mp4parser.boxes.iso14496.part12.FreeSpaceBox;

/* JADX INFO: loaded from: classes4.dex */
public class SetAlarm extends PreferenceActivity implements Preference.OnPreferenceChangeListener, AbstractCaptchaDialogFragment.OnCloseListener, TimePickerActivity {
    private static final Handler sHandler = new Handler();
    private AppBarStateChangeListener.State appbarState;
    private DefaultValuePreference bedtimePref;
    private ElevantionAnimator elevantionAnimator;
    private Preference feedbackPref;
    private DefaultValuePreference gentlePref;
    private Preference globalPreferences;
    private Preference mCaptcha;
    private PreferenceCategory mNextAlarmCategory;
    private ListPreference mNonDeepSleepWindowPref;
    private Alarm mOriginalAlarm;
    private RepeatChipPreference mRepeatPref;
    private CheckBoxPreference mSelfDisposablePref;
    private CheckBoxPreference mTerminateTrackingPref;
    private boolean mTimePickerCancelled;
    private AlarmTimePreference mTimePref;
    private NextAlarmPreference nextAlarmPref;
    private Preference ringtonePreferences;
    private Set<String> selectedPlaylists;
    private String selectedRingtoneName;
    private String selectedRingtoneUri;
    private Preference skipPref;
    private DefaultValuePreference snoozePref;
    private TimePicker timePickerFragment;
    private DefaultValueListPreference wakeUpCheckPref;
    private int mId = -1;
    private int mHour = -1;
    private int mMinutes = -1;
    private boolean defaultModeAlarm = true;
    private boolean modeAlarm = true;
    private boolean modeChangeClicked = false;
    private boolean initialClick = true;
    private boolean closeOnSet = false;
    private boolean suspendNextInitialized = false;
    private boolean suspendNext = false;
    private long suspendNextTime = -1;
    private boolean showDialog = true;
    private int selectedCaptchaId = -1;
    private int verticalOffset = -1;
    private final ActivityResultLauncher<String> requestFullscreenPermissionLauncher = registerForActivityResult(new ActivityResultContracts$RequestPermission(), new SetAlarm$$ExternalSyntheticLambda2(this, 0));

    /* JADX INFO: renamed from: com.urbandroid.sleep.alarmclock.SetAlarm$9, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$com$urbandroid$sleep$gui$toolbar$AppBarStateChangeListener$State;

        static {
            int[] iArr = new int[AppBarStateChangeListener.State.values().length];
            $SwitchMap$com$urbandroid$sleep$gui$toolbar$AppBarStateChangeListener$State = iArr;
            try {
                iArr[AppBarStateChangeListener.State.EXPANDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$gui$toolbar$AppBarStateChangeListener$State[AppBarStateChangeListener.State.COLLAPSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$gui$toolbar$AppBarStateChangeListener$State[AppBarStateChangeListener.State.IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private long calculateNextAlarmTime() {
        return Alarms.calculateAlarm(this, mapToAlarm());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteAlarm() {
        new MaterialAlertDialogBuilder(this).setTitle((CharSequence) getString(R.string.delete_alarm)).setMessage((CharSequence) getString(R.string.delete_alarm_confirm)).setPositiveButton(R.string.delete, (DialogInterface.OnClickListener) new SetAlarm$$ExternalSyntheticLambda3(this, 2)).setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null).show();
    }

    public static String formatToast(Context context, long j) {
        long jCurrentTimeMillis = j - System.currentTimeMillis();
        long j2 = jCurrentTimeMillis / 3600000;
        long j3 = (jCurrentTimeMillis / 60000) % 60;
        long j4 = j2 / 24;
        long j5 = j2 % 24;
        return String.format(context.getResources().getStringArray(R.array.alarm_set)[((j5 > 0L ? 1 : (j5 == 0L ? 0 : -1)) > 0 ? (char) 2 : (char) 0) | (j4 > 0 ? (char) 1 : (char) 0) | (j3 > 0 ? (char) 4 : (char) 0)], j4 == 0 ? "" : j4 == 1 ? context.getString(R.string.day) : context.getString(R.string.days, Long.toString(j4)), j5 != 0 ? j5 == 1 ? context.getString(R.string.hour) : context.getString(R.string.hours, Long.toString(j5)) : "", j3 == 0 ? "" : j3 == 1 ? context.getString(R.string.minute) : context.getString(R.string.minutes, Long.toString(j3)));
    }

    private String getDefaultCaptchaName() {
        CaptchaInfo defaultCaptcha = SharedApplicationContext.getSettings().getDefaultCaptcha();
        return defaultCaptcha != null ? defaultCaptcha.getLabel() : getResources().getString(R.string.disabled);
    }

    private String getSmartPeriodDesc(int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, i2);
        if (i3 == 59) {
            return DateUtil.formatTimeNoAmPm(this, calendar.getTimeInMillis()) + " - " + DateUtil.formatTimeNoAmPm(this, calendar.getTimeInMillis() + 3600000) + "\n" + getString(R.string.powernap_warning_text);
        }
        if (i3 == 0) {
            return getString(R.string.smart_period_disabled);
        }
        return DateUtil.formatTimeNoAmPm(this, calendar.getTimeInMillis() - TimeUnit.MINUTES.toMillis(i3)) + " - " + DateUtil.formatTimeNoAmPm(this, calendar.getTimeInMillis()) + "\n" + getString(R.string.smart_period_summary);
    }

    private boolean isPowerNap() {
        ListPreference listPreference = this.mNonDeepSleepWindowPref;
        boolean z = false;
        if (listPreference != null && listPreference.getValue() != null && (this.mNonDeepSleepWindowPref.getValue().equals("59") || (this.mNonDeepSleepWindowPref.getValue().equals("-1") && ((!this.modeAlarm && SharedApplicationContext.getSettings().getSmartWakeupNapMinutes() == 59) || (this.modeAlarm && SharedApplicationContext.getSettings().getSmartWakeupMinutes() == 59))))) {
            z = true;
        }
        if (z) {
            Logger.logInfo("SetAlarm: Power nap");
        }
        return z;
    }

    private boolean isRepeating() {
        return this.mRepeatPref.isRepeating();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteAlarm$24(DialogInterface dialogInterface, int i) {
        Alarms.deleteAlarm(this, mapToAlarm().id);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$19(Boolean bool) {
        AlarmSettingsActivity.askOverlay(this, AlarmSettingsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreatePreference$1(View view, MotionEvent motionEvent) {
        TextInputEditText textInputEditText;
        if (this.appbarState != AppBarStateChangeListener.State.COLLAPSED || (textInputEditText = (TextInputEditText) findViewById(R.id.label)) == null) {
            return true;
        }
        textInputEditText.dispatchTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreatePreference$10() {
        View actionButton = ((DefaultValuePreference) this.mCaptcha).getActionButton();
        if (actionButton != null) {
            actionButton.setOnClickListener(new SetAlarm$$ExternalSyntheticLambda10(this, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreatePreference$11(Preference preference) {
        Intent intent = new Intent(this, (Class<?>) SetAlarmSnooze.class);
        intent.putExtra("alarm", (Parcelable) mapToAlarm());
        startActivityForResult(intent, 231);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreatePreference$12(Preference preference) {
        Intent intent = new Intent(this, (Class<?>) SetAlarmGentle.class);
        Alarm alarmMapToAlarm = mapToAlarm();
        Logger.logInfo("GentleWake: PARCEL " + alarmMapToAlarm.extendedConfig.getGradualVolumeIncrease());
        intent.putExtra("alarm", (Parcelable) alarmMapToAlarm);
        startActivityForResult(intent, 389);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreatePreference$13(Preference preference) {
        Intent intent = new Intent(this, (Class<?>) SetAlarmBedtime.class);
        intent.putExtra("alarm", (Parcelable) mapToAlarm());
        startActivityForResult(intent, 132);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreatePreference$14(DialogInterface dialogInterface, int i) {
        this.suspendNextTime = -1L;
        setSkipNextState(true);
        updateSkipNextAlarmTime(calculateNextAlarmTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreatePreference$15(Preference preference) {
        boolean zIsSkipped = Alarms.isSkipped(mapToAlarm());
        zza$$ExternalSyntheticOutline0.m("SetAlarm: Set skipped on button clicked: ", zIsSkipped);
        if (zIsSkipped) {
            setSkipNextState(false);
            updateAlarmDay(calculateNextAlarmTime());
            return false;
        }
        MaterialAlertDialogBuilder negativeButton = new MaterialAlertDialogBuilder(this).setTitle((CharSequence) getResources().getString(R.string.disable_alarm_for_today)).setMessage((CharSequence) getResources().getString(R.string.are_you_sure)).setPositiveButton(R.string.disable_alarm_for_today, (DialogInterface.OnClickListener) new SetAlarm$$ExternalSyntheticLambda3(this, 1)).setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null);
        negativeButton.setNeutralButton(R.string.skip_more, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.SetAlarm.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                SetAlarm.this.showDatePicker(R.string.skip_more);
            }
        });
        negativeButton.show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreatePreference$16(Preference preference) {
        showDatePicker(R.string.stats_caption_day);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreatePreference$17(View view) {
        Logger.logInfo("SetAlarm: DONE BUTTON pressed ");
        saveAlarmAndFinish();
        try {
            Logger.logInfo("SetAlarm: DONE BUTTON backup ");
            if (SharedApplicationContext.getSettings().isTimeToBackup()) {
                Logger.logInfo("SetAlarm: DONE BUTTON backup done ");
                new BackupManager(this).dataChanged();
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreatePreference$18(Button button, View view) {
        int i = this.mId;
        Logger.logInfo("SetAlarm: revert " + this.mOriginalAlarm.getDaysOfWeek());
        Alarms.fixPowerNapRealSchedule(this.mOriginalAlarm);
        updatePrefs(this.mOriginalAlarm);
        if (this.mOriginalAlarm.id == -1) {
            Alarms.deleteAlarm(this, i);
            finish();
        } else {
            saveAlarm();
        }
        button.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreatePreference$2(TextInputEditText textInputEditText, View view, boolean z) {
        if (z) {
            textInputEditText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            textInputEditText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_pencil, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$onCreatePreference$3(TextInputEditText textInputEditText, TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            textInputEditText.clearFocus();
            textInputEditText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_pencil, 0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreatePreference$4(boolean z) {
        if (z) {
            popAlarmSetToast(this, mapToAlarm(), isPowerNap());
        }
        saveAlarm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreatePreference$5(Preference preference) {
        SharedApplicationContext.getSettings().addShowCaseShown("new_alarm_feedback");
        ViewIntent.url(this, "https://docs.google.com/forms/d/e/1FAIpQLSfCfcpsVSnl7ilWtJAJbFlTr1AKUTpC5Oy_uzszJGGbHsQa-A/viewform");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreatePreference$6(View view) {
        startActivity(new Intent(this, (Class<?>) CaptchaWakeUpCheckSettingsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreatePreference$7() {
        View actionButton = this.wakeUpCheckPref.getActionButton();
        if (actionButton != null) {
            actionButton.setOnClickListener(new SetAlarm$$ExternalSyntheticLambda10(this, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreatePreference$8(Preference preference) {
        Intent intent = new Intent(this, (Class<?>) CaptchaTileListActivity.class);
        intent.putExtra("perAlarm", true);
        startActivityForResult(intent, 39488);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreatePreference$9(View view) {
        startActivity(new Intent(this, (Class<?>) CaptchaSettingsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPreferenceChange$21() {
        setSwitchEnabled(true);
        saveAlarmAndEnableRevert();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRequestPermissionsResult$25(DialogInterface dialogInterface, int i) {
        ViewIntent.showPermissionsSettings(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshRepeating$0() {
        if (getPreferenceScreen() != null) {
            if (isRepeating()) {
                this.nextAlarmPref.setAdjustTimeVisible(true);
                Logger.logInfo("SetAlarm: offset onResume add ");
            } else {
                Logger.logInfo("SetAlarm: offset onResume remove ");
                this.nextAlarmPref.setAdjustTimeVisible(false);
            }
            updateSkipNextAlarmTime(calculateNextAlarmTime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveAlarmAndFinish$23(DialogInterface dialogInterface, int i) {
        saveAlarm();
        showAdIfRequiredAndFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDatePicker$20(Long l) {
        Calendar calendar = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(l.longValue());
        int i = calendar.get(5);
        int i2 = calendar.get(2);
        int i3 = calendar.get(1);
        Logger.logInfo("SetAlarm: selected day " + calendar.getTime());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(5, i);
        calendar2.set(2, i2);
        calendar2.set(1, i3);
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        Logger.logInfo("SetAlarm: selected day adjust " + calendar2.getTime());
        long timeInMillis = calendar2.getTimeInMillis();
        this.suspendNextTime = timeInMillis;
        if (timeInMillis >= System.currentTimeMillis() + 31536000000L) {
            Toast.makeText(this, R.string.generic_invalid_input, 1).show();
        } else {
            setSkipNextState(this.suspendNextTime > System.currentTimeMillis());
            updateSkipNextAlarmTime(calculateNextAlarmTime());
        }
    }

    public static void popAlarmSetToast(Context context, long j, boolean z) {
        if (z) {
            j -= 3540000;
        }
        Toast toastMakeText = Toast.makeText(context, formatToast(context, Alarms.fixDayLiteSavingRemove(j)), 1);
        ToastMaster.setToast(toastMakeText);
        toastMakeText.show();
    }

    private void refreshRepeating() {
        Logger.logInfo("SetAlarm: offset refresh");
        new Handler().post(new SetAlarm$$ExternalSyntheticLambda0(this, 1));
    }

    private void restore(Bundle bundle) {
        if (bundle == null || bundle.getParcelable("alarm") == null) {
            return;
        }
        Alarm alarm = (Alarm) bundle.getParcelable("alarm");
        this.mOriginalAlarm = alarm;
        if (alarm != null) {
            this.mId = alarm.id;
            Logger.logInfo("SetAlarm: Restoring alarm id " + this.mId + " days " + this.mOriginalAlarm.getDaysOfWeek());
        }
    }

    private long saveAlarm() {
        long alarm;
        Alarm alarmMapToAlarm = mapToAlarm();
        if (!alarmMapToAlarm.getDaysOfWeek().isRepeatSet()) {
            alarmMapToAlarm.resetOffset();
        }
        if (alarmMapToAlarm.id == -1) {
            alarm = Alarms.addAlarm(this, alarmMapToAlarm);
            this.mId = alarmMapToAlarm.id;
        } else {
            alarm = Alarms.setAlarm(this, alarmMapToAlarm);
        }
        Logger.logInfo("SetAlarm: Saving alarm " + Alarm.toDebugString(alarmMapToAlarm));
        return alarm;
    }

    private long saveAlarmAndEnableRevert() {
        if (this.mOriginalAlarm.id != -1) {
            ((Button) findViewById(R.id.alarm_revert)).setVisibility(0);
        }
        return saveAlarm();
    }

    private void saveAlarmAndFinish() {
        Alarm alarmMapToAlarm = mapToAlarm();
        if (this.mOriginalAlarm.getOffset() == this.nextAlarmPref.getOffsetMinutes() || this.nextAlarmPref.getOffsetMinutes() == 0) {
            Logger.logInfo("SetAlarm: DONE BUTTON save ");
            saveAlarm();
            showAdIfRequiredAndFinish();
        } else {
            setSkipNextState(false);
            long jCalculateAlarm = Alarms.calculateAlarm(this, alarmMapToAlarm);
            Logger.logInfo("SetAlarm: alarm " + alarmMapToAlarm.getOffset() + " h " + alarmMapToAlarm.getOffsetHour(this) + " m " + alarmMapToAlarm.getOffsetMinutes(this) + " suspend " + new Date(alarmMapToAlarm.suspendTime));
            StringBuilder sb = new StringBuilder("SetAlarm: Postpone  time ");
            sb.append(new Date(jCalculateAlarm));
            sb.append(" offset ");
            sb.append(this.mOriginalAlarm.getOffset());
            sb.append(" -> ");
            sb.append(this.nextAlarmPref.getOffsetMinutes());
            Logger.logInfo(sb.toString());
            Logger.logInfo("SetAlarm: DONE BUTTON offset ");
            new MaterialAlertDialogBuilder(this).setTitle(R.string.alarm_offset_title).setMessage((CharSequence) (getResources().getString(R.string.adjust_next_time_expl, DateUtil.formatTimeNoAmPm(this, jCalculateAlarm)) + "\n\n" + getResources().getString(R.string.are_you_sure))).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new SetAlarm$$ExternalSyntheticLambda3(this, 0)).setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null).show();
        }
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventAlarmSet(this, alarmMapToAlarm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleLocationBasedAlarm() {
        try {
            Location location = SharedApplicationContext.getSettings().getLocation();
            if (location != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(Alarms.calculateAlarm(getApplicationContext(), mapToAlarm()));
                Calendar officialSunriseCalendarForDate = new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(location.getLat(), location.getLon()), TimeZone.getDefault()).getOfficialSunriseCalendarForDate(calendar);
                if (officialSunriseCalendarForDate.before(new Date())) {
                    calendar.add(5, 1);
                    officialSunriseCalendarForDate = new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(location.getLat(), location.getLon()), TimeZone.getDefault()).getOfficialSunriseCalendarForDate(calendar);
                }
                if (officialSunriseCalendarForDate != null) {
                    this.timePickerFragment.setState(officialSunriseCalendarForDate.get(11), officialSunriseCalendarForDate.get(12), Alarms.get24HourMode(this));
                }
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    private void setSelectedCaptchaId(int i) {
        Preference preference = this.mCaptcha;
        if (preference != null) {
            this.selectedCaptchaId = i;
            preference.setIcon(CaptchaDrawableUtil.getDrawable(this, i));
            this.mCaptcha.setSummary(CaptchaPreferenceUtil.getSummary(this, i));
            CaptchaSettingsActivity.showCaptchaPreviewDialog(this, SharedApplicationContext.getCaptchaManager(), i);
        }
    }

    private void setSkipNextState(boolean z) {
        Preference preference = this.skipPref;
        if (z) {
            if (preference != null) {
                preference.setTitle(R.string.enable_alarm_for_today);
            }
            this.nextAlarmPref.setAdjustTimeVisible(false);
            Alarm alarmMapToAlarm = mapToAlarm();
            Alarms.fixPowerNapDisplayTime(alarmMapToAlarm);
            this.nextAlarmPref.resetOffset(alarmMapToAlarm);
            this.suspendNext = true;
        } else {
            if (preference != null) {
                preference.setTitle(R.string.disable_alarm_for_today);
            }
            if (isRepeating()) {
                this.nextAlarmPref.setAdjustTimeVisible(true);
            }
            this.suspendNext = false;
            this.suspendNextTime = -1L;
            Logger.logDebug("SetAlarm:Skip next not set");
        }
        this.suspendNextInitialized = true;
    }

    private void setSwitchEnabled(boolean z) {
        this.mTimePref.setAlarmIsEnabled(Boolean.valueOf(z));
    }

    private void showAdIfRequiredAndFinish() {
        Logger.logInfo("SetAlarm: DONE BUTTON finish ");
        Intent intent = new Intent("com.urbandroid.sleep.alarmclock.ALARM_RESCHEDULED");
        int i = this.mId;
        if (i != -1) {
            intent.putExtra("alarm_id", i);
        }
        ContextExtKt.sendExplicitBroadcast(this, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDatePicker(int i) {
        MaterialDatePicker.Builder<Long> builderDatePicker = MaterialDatePicker.Builder.datePicker();
        builderDatePicker.setTitleText(i);
        MaterialDatePicker<Long> materialDatePickerBuild = builderDatePicker.build();
        materialDatePickerBuild.addOnPositiveButtonClickListener(new SetAlarm$$ExternalSyntheticLambda22(this, 0));
        materialDatePickerBuild.show(getSupportFragmentManager(), builderDatePicker.toString());
    }

    public static void showSetAlarmActivity(Context context, long j, final boolean z) {
        if (j < 0) {
            return;
        }
        int i = (int) j;
        Alarm alarm = Alarms.getAlarm(context.getContentResolver(), i);
        if (Alarms.isAlarmDisablingLimitedByCaptcha(context, alarm)) {
            CaptchaInfo captchaInfo = SharedApplicationContext.getSettings().getCaptchaInfo(alarm);
            SharedApplicationContext.getCaptchaManager().getLauncher(alarm).operation("edit_alarm").addFlags(131072).difficulty(SharedApplicationContext.getSettings().getCaptchaDifficulty(captchaInfo)).extraSetter(new IntentExtraSetter() { // from class: com.urbandroid.sleep.alarmclock.SetAlarm.7
                @Override // com.urbandroid.sleep.captcha.intent.IntentExtraSetter
                public void setExtras(Intent intent) {
                    if (z) {
                        intent.putExtra("edit_alarm_time_extra", true);
                    }
                }
            }).start(captchaInfo);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) SetAlarm.class);
        intent.putExtra("alarm_id", i);
        if (z) {
            intent.putExtra("set_time_extra", true);
        }
        context.startActivity(intent);
    }

    private void showTimePicker(boolean z, boolean z2) {
        Logger.logInfo("SetAlarm: showTimePicker");
        this.initialClick = z;
        this.closeOnSet = z2;
        createTimePickerDialog();
    }

    private void startRingtoneChooser() {
        Intent intent = new Intent(this, (Class<?>) MediaListActivity.class);
        intent.putExtra("extra_integration", true);
        intent.putExtra("extra_hide_app_settings", true);
        intent.putExtra("extra_alert_title", this.selectedRingtoneName);
        if (this.selectedPlaylists != null) {
            intent.putExtra("extra_playlists", new ArrayList(this.selectedPlaylists));
        }
        String str = this.selectedRingtoneUri;
        if (str != null) {
            intent.putExtra("extra_alert_uri", str);
        }
        startActivityForResult(intent, 5678);
    }

    private void updateAlarmDay(long j) {
        Logger.logInfo("SetAlarm: updateAlarmDay " + new Date(j));
        Calendar calendar = Calendar.getInstance();
        int datestampNumber = DateUtil.getDatestampNumber(calendar.getTime());
        calendar.add(5, 1);
        int datestampNumber2 = DateUtil.getDatestampNumber(calendar.getTime());
        calendar.setTimeInMillis(j);
        int datestampNumber3 = DateUtil.getDatestampNumber(calendar.getTime());
        String string = DateUtil.getShortDateLongWeekInstanceWithoutYears(this).format(new Date(j));
        if (datestampNumber3 == datestampNumber) {
            string = getString(R.string.today);
        } else if (datestampNumber3 == datestampNumber2) {
            string = getString(R.string.tomorrow);
        }
        Preference preferenceFindPreference = findPreference("alarm_next");
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setTitle(string);
            Calendar calendar2 = Calendar.getInstance();
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTimeInMillis(j);
            if (calendar3.get(3) == calendar2.get(3) + 1) {
                preferenceFindPreference.setSummary(getString(R.string.next_week));
            } else {
                preferenceFindPreference.setSummary((CharSequence) null);
            }
        }
    }

    private void updateBedtimePrefSummary(Preference preference) {
        String string;
        if (SharedApplicationContext.getSettings().getTimeToBed(null) == -1) {
            string = getString(R.string.disabled);
        } else {
            string = DateUtil.formatHoursMinutes(this, SharedApplicationContext.getSettings().getTimeToBed(null)) + " " + getString(R.string.before).toLowerCase();
        }
        String str = "   " + DefaultValueListPreference.getDefaultPrefix(this) + " " + string;
        if (this.mOriginalAlarm.extendedConfig.getTimeToBed() == -2) {
            preference.setSummary(string);
            return;
        }
        if (this.mOriginalAlarm.extendedConfig.getTimeToBed() == -1) {
            preference.setSummary(getString(R.string.disabled) + str);
            return;
        }
        preference.setSummary(DateUtil.formatHoursMinutes(this, this.mOriginalAlarm.extendedConfig.getTimeToBed()) + " " + getString(R.string.before).toLowerCase() + str);
    }

    private void updateGentlePrefSummary(Preference preference) {
        String string = SharedApplicationContext.getSettings().getGradualVolumeIncreaseDuration() == -1 ? getString(R.string.disabled) : DateUtil.formatMinutesAndSecondsFromMs(this, SharedApplicationContext.getSettings().getGradualVolumeIncreaseDuration());
        String str = " " + DefaultValueListPreference.getDefaultPrefix(this) + " " + string;
        if (this.mOriginalAlarm.extendedConfig.getGradualVolumeIncrease() == null || this.mOriginalAlarm.extendedConfig.getGradualVolumeIncrease().intValue() == -2) {
            preference.setSummary(getString(R.string.alarm_increasing_volume_title) + ": " + string + "\n\n" + getString(R.string.alarm_increasing_volume_duration_summary));
            return;
        }
        if (this.mOriginalAlarm.extendedConfig.getGradualVolumeIncrease().intValue() == -1) {
            preference.setSummary(getString(R.string.alarm_increasing_volume_title) + ": " + getString(R.string.disabled) + str);
            return;
        }
        preference.setSummary(getString(R.string.alarm_increasing_volume_title) + ": " + DateUtil.formatMinutesAndSecondsFromMs(this, this.mOriginalAlarm.extendedConfig.getGradualVolumeIncrease().intValue()) + str);
    }

    private void updateOffsetPref() {
        if (this.nextAlarmPref != null) {
            Alarm alarmMapToAlarm = mapToAlarm();
            Alarms.fixPowerNapDisplayTime(alarmMapToAlarm);
            this.nextAlarmPref.setOffset(alarmMapToAlarm);
        }
    }

    private void updatePrefs(Alarm alarm) {
        this.mId = alarm.id;
        if (this.mTimePref.getSwitch() != null) {
            zza$$ExternalSyntheticOutline0.m(new StringBuilder("SetAlarm: switch update "), alarm.enabled);
            setSwitchEnabled(alarm.enabled);
        }
        ((EditText) findViewById(R.id.label)).setText(alarm.label);
        if (alarm.id != -1) {
            Alarms.fixPowerNapDisplayTime(alarm);
        }
        this.mHour = alarm.hour;
        this.mMinutes = alarm.minutes;
        this.nextAlarmPref.setOffset(alarm);
        this.mRepeatPref.setDaysOfWeek(alarm.getDaysOfWeek());
        if (this.mId == -1) {
            boolean z = false;
            this.mNonDeepSleepWindowPref.setValueIndex(0);
            this.selectedCaptchaId = -1;
            CheckBoxPreference checkBoxPreference = this.mSelfDisposablePref;
            if (!this.modeAlarm && !isRepeating()) {
                z = true;
            }
            checkBoxPreference.setChecked(z);
            this.mTerminateTrackingPref.setChecked(true);
            this.selectedPlaylists = new HashSet();
            this.wakeUpCheckPref.setValue("-2");
        } else {
            this.selectedPlaylists = new HashSet(alarm.extendedConfig.getSelectedPlaylists());
            ((DefaultValueListPreference) this.mNonDeepSleepWindowPref).setLongDesc(getSmartPeriodDesc(this.mHour, this.mMinutes, alarm.nonDeepsleepWakeupWindow));
            this.mNonDeepSleepWindowPref.setValue(String.valueOf(alarm.nonDeepsleepWakeupWindow));
            this.wakeUpCheckPref.setValue(alarm.extendedConfig.getWakeUpCheck() != null ? String.valueOf(alarm.extendedConfig.getWakeUpCheck()) : "-2");
            if (alarm.captcha != -1) {
                zza$$ExternalSyntheticOutline0.m(new StringBuilder("SetAlarm: CAPTCHA "), alarm.captcha);
                this.mCaptcha.setSummary(CaptchaPreferenceUtil.getSummary(this, alarm.captcha, R.string.captcha_preference_summary));
                int i = alarm.captcha;
                this.selectedCaptchaId = i;
                this.mCaptcha.setIcon(CaptchaDrawableUtil.getDrawable(this, i));
            }
            this.mSelfDisposablePref.setChecked(alarm.extendedConfig.isSelfDisposable().booleanValue());
            this.mTerminateTrackingPref.setChecked(alarm.extendedConfig.isTerminatesTracking().booleanValue());
        }
        updateTime();
    }

    private void updateRingtonePref(Context context, final String str, boolean z, String str2) {
        Settings settings = new Settings(context);
        if (str2 != null) {
            str2 = str2.replace('%', ' ');
        }
        final String str3 = "   " + DefaultValueListPreference.getDefaultPrefix(context) + " " + settings.getDefaultRingtoneName("");
        if (str2 == null || str2.trim().isEmpty()) {
            str2 = context.getString(R.string.device_default);
            this.ringtonePreferences.setSummary(getString(R.string.silent_alarm_summary) + str3);
        }
        this.selectedRingtoneName = str2;
        if (z) {
            this.ringtonePreferences.setSummary(getString(R.string.silent_alarm_summary) + str3);
            this.selectedRingtoneUri = "silent";
            this.ringtonePreferences.setIcon(R.drawable.ic_sound_silent);
            return;
        }
        if (str == null || str.equals("android.resource://com.urbandroid.sleep/raw/default")) {
            this.ringtonePreferences.setSummary(settings.getDefaultRingtoneName(null));
            this.selectedRingtoneUri = "android.resource://com.urbandroid.sleep/raw/default";
            this.ringtonePreferences.setIcon(settings.getDefaultRingtoneUri() == null ? R.drawable.ic_sound_alarm_defaults : InternalRingtones.getRingtoneIcon(settings.getDefaultRingtoneUri().toString()));
            return;
        }
        if (str.equals("android.resource://com.urbandroid.sleep/raw/phone")) {
            this.ringtonePreferences.setSummary(R.string.phone_preference);
            this.selectedRingtoneUri = "android.resource://com.urbandroid.sleep/raw/phone";
            this.ringtonePreferences.setIcon(R.drawable.ic_sound_all);
            return;
        }
        this.selectedRingtoneUri = str;
        boolean zIsMultipleUri = MultipleMediaUriUtil.isMultipleUri(str);
        Preference preference = this.ringtonePreferences;
        if (zIsMultipleUri) {
            preference.setSummary(getString(R.string.alert_playlist_size, Integer.valueOf(MultipleMediaUriUtil.size(str))) + str3);
            this.ringtonePreferences.setIcon(R.drawable.ic_sound_playlist);
            return;
        }
        preference.setIcon(InternalRingtones.getRingtoneIcon(str));
        InternalRingtones.InternalRingtone internalRingtone = InternalRingtones.getInternalRingtone(str);
        if (internalRingtone != null) {
            this.ringtonePreferences.setIcon(internalRingtone.getDrawableRes());
        } else if (this.selectedRingtoneUri.startsWith("http://") || this.selectedRingtoneUri.startsWith("https://")) {
            this.ringtonePreferences.setIcon(R.drawable.ic_lullaby_radio);
        } else {
            boolean zIsSpotifyUri = ISpotifyPlayer.INSTANCE.isSpotifyUri(str);
            Preference preference2 = this.ringtonePreferences;
            if (zIsSpotifyUri) {
                preference2.setIcon(R.drawable.ic_lullaby_spotify_color);
            } else {
                preference2.setSummary(str2 + str3);
                this.ringtonePreferences.setIcon(R.drawable.ic_sound_tone_color);
            }
        }
        if (str2 != null) {
            this.selectedRingtoneName = str2;
            this.ringtonePreferences.setSummary(str2.concat(str3));
            return;
        }
        if (this.selectedRingtoneUri.startsWith("http://") || this.selectedRingtoneUri.startsWith("https://")) {
            this.ringtonePreferences.setSummary(getString(R.string.online_radio) + str3);
            return;
        }
        int titleRes = InternalRingtones.getTitleRes(str);
        if (titleRes == -1) {
            new AsyncTask<Void, Void, Ringtone>() { // from class: com.urbandroid.sleep.alarmclock.SetAlarm.6
                @Override // android.os.AsyncTask
                public Ringtone doInBackground(Void... voidArr) {
                    try {
                        return RingtoneManager.getRingtone(SetAlarm.this, Uri.parse(str));
                    } catch (Exception unused) {
                        return null;
                    }
                }

                @Override // android.os.AsyncTask
                public void onPostExecute(Ringtone ringtone) {
                    if (ringtone == null) {
                        int iIndexOf = str.toString().indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                        SetAlarm setAlarm = SetAlarm.this;
                        if (iIndexOf > 0) {
                            Preference preference3 = setAlarm.ringtonePreferences;
                            StringBuilder sb = new StringBuilder();
                            String str4 = str;
                            sb.append(str4.substring(str4.toString().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR)));
                            sb.append(str3);
                            preference3.setSummary(sb.toString());
                        } else {
                            setAlarm.ringtonePreferences.setSummary(str + str3);
                        }
                    } else {
                        try {
                            SetAlarm.this.ringtonePreferences.setSummary(ringtone.getTitle(SetAlarm.this) + str3);
                        } catch (Exception unused) {
                            SetAlarm.this.ringtonePreferences.setSummary(str + str3);
                        }
                    }
                    Logger.logInfo("SetAlarm: 10 ringtone setName=" + ((Object) SetAlarm.this.ringtonePreferences.getSummary()));
                }
            }.execute(new Void[0]);
            return;
        }
        this.ringtonePreferences.setSummary(getString(titleRes) + str3);
    }

    private void updateSkipNextAlarmTime(long j) {
        if (this.suspendNext && j > System.currentTimeMillis() && this.skipPref != null) {
            String str = getString(R.string.enable_alarm_for_today) + "\n" + getString(R.string.next) + ": " + DateUtil.getShortDateLongerWeekInstanceWithoutYears(this).format(new Date(j));
            String string = getString(R.string.enable_alarm_for_today);
            Logger.logInfo("SetAlarm: ".concat(str));
            this.skipPref.setTitle(string);
        }
        updateAlarmDay(j);
    }

    private void updateSnoozePrefSummary(Preference preference) {
        int snoozeDurationValueInt = SharedApplicationContext.getSettings().getSnoozeDurationValueInt();
        String string = snoozeDurationValueInt == 0 ? getString(R.string.disabled) : snoozeDurationValueInt == -1 ? getString(R.string.last_used) : DateUtil.formatHoursMinutes(this, snoozeDurationValueInt);
        String str = "   " + DefaultValueListPreference.getDefaultPrefix(this) + " " + string;
        if (this.mOriginalAlarm.extendedConfig.getSnoozeDuration().intValue() == -2) {
            preference.setSummary(string);
            return;
        }
        if (this.mOriginalAlarm.extendedConfig.getSnoozeDuration().intValue() == -1) {
            preference.setSummary(getString(R.string.last_used) + str);
            return;
        }
        if (this.mOriginalAlarm.extendedConfig.getSnoozeDuration().intValue() == 0) {
            preference.setSummary(getString(R.string.disabled) + str);
            return;
        }
        preference.setSummary(DateUtil.formatHoursMinutes(this, this.mOriginalAlarm.extendedConfig.getSnoozeDuration().intValue()) + str);
    }

    private void updateTime() {
        String time = Alarms.formatTime(this, this.mHour, this.mMinutes, this.mRepeatPref.getDaysOfWeek());
        String[] strArrSplit = time.split(" ", 2);
        if (strArrSplit.length > 1) {
            SpannableString spannableString = new SpannableString(strArrSplit[0]);
            SpannableString spannableString2 = new SpannableString(strArrSplit[1]);
            spannableString2.setSpan(new TextAppearanceSpan(this, android.R.style.TextAppearance.Small), 0, spannableString2.length(), 0);
            spannableString2.setSpan(new StyleSpan(1), 0, spannableString2.length(), 0);
            spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.primary)), 0, spannableString2.length(), 0);
            spannableString2.setSpan(new MarginPaddingSpan(0, 0, 20, 0), 0, spannableString2.length(), 0);
            this.mTimePref.setTitle(TextUtils.concat(spannableString, spannableString2));
        } else {
            this.mTimePref.setTitle(time);
        }
        try {
            ListPreference listPreference = this.mNonDeepSleepWindowPref;
            ((DefaultValueListPreference) listPreference).setLongDesc(getSmartPeriodDesc(this.mHour, this.mMinutes, Integer.parseInt(listPreference.getValue()) == -1 ? SharedApplicationContext.getSettings().getSmartWakeupMinutes() : Integer.parseInt(this.mNonDeepSleepWindowPref.getValue())));
        } catch (NumberFormatException e) {
            Logger.logSevere(e);
        }
        try {
            ListPreference listPreference2 = this.mNonDeepSleepWindowPref;
            ((DefaultValueListPreference) listPreference2).syncValueWithSummary(listPreference2.getValue());
        } catch (Exception e2) {
            Logger.logSevere(e2);
        }
    }

    public void createTimePickerDialog() {
        TimePicker timePicker = this.timePickerFragment;
        if (timePicker != null) {
            timePicker.dismiss();
        }
        Settings settings = new Settings(this);
        if (this.modeAlarm && settings.isNewTimepicker()) {
            MaterialTimePicker materialTimePicker = new MaterialTimePicker(this, this);
            this.timePickerFragment = materialTimePicker;
            materialTimePicker.show(this);
        } else {
            RoundTimePicker roundTimePicker = new RoundTimePicker();
            this.timePickerFragment = roundTimePicker;
            roundTimePicker.show(this);
        }
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    public int getContentLayout() {
        return R.layout.activity_set_alarm;
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePickerActivity
    public int getHour() {
        return this.mHour;
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePickerActivity
    public int getMinute() {
        return this.mMinutes;
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    public int getPreferenceResource() {
        return R.xml.alarm_prefs;
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePickerActivity
    public boolean isAlarmMode() {
        return this.modeAlarm;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0143 A[Catch: NumberFormatException -> 0x00f2, TRY_ENTER, TryCatch #0 {NumberFormatException -> 0x00f2, blocks: (B:25:0x00d7, B:27:0x00dc, B:36:0x00f5, B:38:0x00f9, B:40:0x00ff, B:41:0x0112, B:44:0x0118, B:47:0x0143, B:49:0x0147, B:54:0x015b, B:32:0x00ee, B:29:0x00e2, B:51:0x014d), top: B:83:0x00d7, inners: #1, #2 }] */
    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePickerActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Alarm mapToAlarm() {
        int i;
        DefaultValueListPreference defaultValueListPreference;
        ListPreference listPreference;
        Context applicationContext = getApplicationContext();
        Alarm alarm = new Alarm();
        alarm.id = this.mId;
        AlarmTimePreference alarmTimePreference = this.mTimePref;
        if (alarmTimePreference == null || alarmTimePreference.getSwitch() == null) {
            alarm.enabled = this.mOriginalAlarm.enabled;
        } else {
            alarm.enabled = this.mTimePref.getAlarmIsEnabled().booleanValue();
        }
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("SetAlarm: Saving alarm "), alarm.enabled);
        alarm.hour = this.mHour;
        alarm.minutes = this.mMinutes;
        alarm.setDaysOfWeek(this.mRepeatPref.getDaysOfWeek());
        NextAlarmPreference nextAlarmPreference = this.nextAlarmPref;
        if (nextAlarmPreference != null) {
            Alarms.addOffset(applicationContext, alarm, nextAlarmPreference.getOffsetMinutes());
            Logger.logInfo("SetAlarm: mapAlarm offset " + this.nextAlarmPref.getOffsetMinutes());
        }
        Set<String> set = this.selectedPlaylists;
        if (set != null) {
            alarm.extendedConfig.setSelectedPlaylists(set);
        }
        String strTrim = ((EditText) findViewById(R.id.label)).getText().toString().trim();
        if (strTrim != null && !strTrim.isEmpty()) {
            alarm.label = ((EditText) findViewById(R.id.label)).getText().toString();
        }
        String str = this.selectedRingtoneUri;
        if (str != null) {
            if (str.equals("silent")) {
                alarm.alert = null;
                alarm.silent = true;
            } else {
                alarm.alert = Uri.parse(this.selectedRingtoneUri);
                Logger.logInfo("SetAlarm: set ringtone name " + this.selectedRingtoneName);
                alarm.extendedConfig.setRingtoneName(this.selectedRingtoneName);
            }
        }
        try {
            ListPreference listPreference2 = this.mNonDeepSleepWindowPref;
            if (listPreference2 == null || listPreference2.getValue() == null) {
                i = -1;
                defaultValueListPreference = this.wakeUpCheckPref;
                if (defaultValueListPreference != null && defaultValueListPreference.getValue() != null) {
                    alarm.extendedConfig.setWakeUpCheck(Integer.valueOf(Integer.parseInt(this.wakeUpCheckPref.getValue())));
                }
                if (this.modeAlarm && i == -1) {
                    alarm.nonDeepsleepWakeupWindow = new Settings(applicationContext).getSmartWakeupNapMinutes();
                    try {
                        this.mNonDeepSleepWindowPref.setValue(new Settings(applicationContext).getSmartWakeupNapMinutes() + "");
                    } catch (Exception unused) {
                    }
                } else {
                    listPreference = this.mNonDeepSleepWindowPref;
                    if (listPreference != null && listPreference.getValue() != null) {
                        try {
                            alarm.nonDeepsleepWakeupWindow = Integer.parseInt(this.mNonDeepSleepWindowPref.getValue());
                        } catch (NumberFormatException e) {
                            Logger.logSevere(e);
                        }
                    }
                }
            } else {
                try {
                    i = Integer.parseInt(this.mNonDeepSleepWindowPref.getValue());
                } catch (NumberFormatException e2) {
                    Logger.logWarning("SetAlarm: Failed to parse non-deep-sleep data", e2);
                    i = -1;
                }
                defaultValueListPreference = this.wakeUpCheckPref;
                if (defaultValueListPreference != null) {
                    alarm.extendedConfig.setWakeUpCheck(Integer.valueOf(Integer.parseInt(this.wakeUpCheckPref.getValue())));
                }
                if (this.modeAlarm) {
                    listPreference = this.mNonDeepSleepWindowPref;
                    if (listPreference != null) {
                        alarm.nonDeepsleepWakeupWindow = Integer.parseInt(this.mNonDeepSleepWindowPref.getValue());
                    }
                }
            }
        } catch (NumberFormatException e3) {
            Logger.logWarning("SetAlarm: Failed to parse non-deep-sleep data", e3);
        }
        alarm.captcha = this.selectedCaptchaId;
        Alarm alarm2 = this.mOriginalAlarm;
        if (alarm2 != null) {
            alarm.extendedConfig.setSnoozeDuration(alarm2.extendedConfig.getSnoozeDuration());
            alarm.extendedConfig.setSnoozeLimit(this.mOriginalAlarm.extendedConfig.getSnoozeLimit());
            alarm.extendedConfig.setSnoozeAfterAlarm(this.mOriginalAlarm.extendedConfig.getSnoozeAfterAlarm());
            alarm.extendedConfig.setSnoozeTotalTimeLimit(this.mOriginalAlarm.extendedConfig.getSnoozeTotalTimeLimit());
            alarm.extendedConfig.setTimeToBed(this.mOriginalAlarm.extendedConfig.getTimeToBed());
            alarm.extendedConfig.setIdealSleepMinutes(this.mOriginalAlarm.extendedConfig.getIdealSleepMinutes());
            alarm.extendedConfig.setGradualVolumeIncrease(this.mOriginalAlarm.extendedConfig.getGradualVolumeIncrease());
            alarm.extendedConfig.setVibrationStart(this.mOriginalAlarm.extendedConfig.getVibrationStart());
            alarm.extendedConfig.setVibrationStartSmartWatch(this.mOriginalAlarm.extendedConfig.getVibrationStartSmartWatch());
            alarm.extendedConfig.setSoundDelay(this.mOriginalAlarm.extendedConfig.getSoundDelay());
        }
        alarm.extendedConfig.setSelfDisposable(Boolean.valueOf(this.mSelfDisposablePref.isChecked()));
        alarm.extendedConfig.setTerminatesTracking(Boolean.valueOf(this.mTerminateTrackingPref.isChecked()));
        Alarm alarm3 = this.mOriginalAlarm;
        if (alarm3 != null && alarm3.getDaysOfWeek().equals(alarm.getDaysOfWeek())) {
            Alarm alarm4 = this.mOriginalAlarm;
            if (alarm4.hour == alarm.hour && alarm4.minutes == alarm.minutes && alarm4.getOffsetHour(applicationContext) == alarm.getOffsetHour(applicationContext) && this.mOriginalAlarm.getOffsetMinutes(applicationContext) == alarm.getOffsetMinutes(applicationContext)) {
                Logger.logInfo("SetAlarm: Keeping old alarm time suspension time: " + new Date(this.mOriginalAlarm.suspendTime));
                alarm.suspendTime = this.mOriginalAlarm.suspendTime;
            }
        }
        Logger.logInfo("SetAlarm: suspend next: " + this.suspendNext);
        Alarms.fixPowerNapRealSchedule(alarm);
        if (this.suspendNext) {
            alarm.resetOffset();
            Alarms.cancelSnooze(this, alarm);
            long j = this.suspendNextTime;
            if (j == -1) {
                alarm.suspendTime = Alarms.calculateAlarm(applicationContext, alarm.getOffsetHour(applicationContext), alarm.getOffsetMinutes(applicationContext), alarm.getDaysOfWeek()).getTimeInMillis() + 1;
            } else {
                alarm.suspendTime = j;
            }
            Logger.logInfo("SetAlarm: Suspended till: " + alarm.suspendTime + " .. " + new Date(alarm.suspendTime));
        } else {
            alarm.suspendTime = -1L;
            Alarms.addOffset(applicationContext, alarm, this.nextAlarmPref.getOffsetMinutes());
        }
        return alarm;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        new Settings(getApplicationContext());
        zza$$ExternalSyntheticOutline0.m(i, i2, "SetAlarm: Snooze: onActivityResult ", " ");
        if (i == 1234 && i2 == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
            if (stringArrayListExtra != null) {
                Matcher matcher = Pattern.compile("([0-2]?[0-9]).*?([0-5]?[0-9])").matcher(stringArrayListExtra.get(0));
                if (matcher.matches()) {
                    if (matcher.group(1) == null || matcher.group(2) == null) {
                        return;
                    }
                    try {
                        this.timePickerFragment.setState(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Alarms.get24HourMode(this));
                    } catch (NumberFormatException unused) {
                        return;
                    }
                }
            }
        } else if (i == 231 && i2 == -1) {
            Alarm alarm = (Alarm) intent.getParcelableExtra("alarm");
            Logger.logInfo("Snooze: result " + alarm.extendedConfig.getSnoozeDuration());
            this.mOriginalAlarm.extendedConfig.setSnoozeDuration(alarm.extendedConfig.getSnoozeDuration());
            this.mOriginalAlarm.extendedConfig.setSnoozeAfterAlarm(alarm.extendedConfig.getSnoozeAfterAlarm());
            this.mOriginalAlarm.extendedConfig.setSnoozeLimit(alarm.extendedConfig.getSnoozeLimit());
            this.mOriginalAlarm.extendedConfig.setSnoozeTotalTimeLimit(alarm.extendedConfig.getSnoozeTotalTimeLimit());
            updateSnoozePrefSummary(this.snoozePref);
        } else if (i == 389 && i2 == -1) {
            Alarm alarm2 = (Alarm) intent.getParcelableExtra("alarm");
            Logger.logInfo("GentleWake: RESULT " + alarm2.extendedConfig.getGradualVolumeIncrease());
            this.mOriginalAlarm.extendedConfig.setGradualVolumeIncrease(alarm2.extendedConfig.getGradualVolumeIncrease());
            this.mOriginalAlarm.extendedConfig.setVibrationStart(alarm2.extendedConfig.getVibrationStart());
            this.mOriginalAlarm.extendedConfig.setVibrationStartSmartWatch(alarm2.extendedConfig.getVibrationStartSmartWatch());
            this.mOriginalAlarm.extendedConfig.setSoundDelay(alarm2.extendedConfig.getSoundDelay());
            updateGentlePrefSummary(this.gentlePref);
        } else if (i == 132 && i2 == -1) {
            Alarm alarm3 = (Alarm) intent.getParcelableExtra("alarm");
            Logger.logInfo("Snooze: result " + alarm3.extendedConfig.getSnoozeDuration());
            this.mOriginalAlarm.extendedConfig.setTimeToBed(alarm3.extendedConfig.getTimeToBed());
            this.mOriginalAlarm.extendedConfig.setIdealSleepMinutes(alarm3.extendedConfig.getIdealSleepMinutes());
            updateBedtimePrefSummary(this.bedtimePref);
        } else if (i == 5678 && i2 == -1) {
            String stringExtra = intent.getStringExtra("extra_alert_title");
            String stringExtra2 = intent.getStringExtra("extra_alert_uri");
            ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("extra_playlists");
            this.selectedPlaylists = stringArrayListExtra2 != null ? new HashSet(stringArrayListExtra2) : new HashSet();
            Logger.logInfo("SetAlarm: ringtone uri " + stringExtra2 + " name " + stringExtra);
            Uri.parse(stringExtra2);
            this.selectedRingtoneUri = stringExtra2;
            this.selectedRingtoneName = stringExtra;
            updateRingtonePref(this, stringExtra2, stringExtra2.equals("silent"), stringExtra);
        } else if (i == 39487 && i2 == -1) {
            Logger.logInfo("SetAlarm: Location granted");
        } else if (i == 39488 && i2 == -1) {
            Logger.logInfo("CaptchaResult");
            setSelectedCaptchaId(intent.getIntExtra("captchaId", -1));
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.mTimePickerCancelled) {
            finish();
        } else {
            saveAlarmAndFinish();
        }
    }

    @Override // com.urbandroid.sleep.captcha.list.AbstractCaptchaDialogFragment.OnCloseListener
    public void onClose(int i) {
        setSelectedCaptchaId(i);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.view.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Logger.logInfo("SetAlarm: timepicker onConfigurationChanged " + this.timePickerFragment);
        TimePicker timePicker = this.timePickerFragment;
        if (timePicker == null || !timePicker.isShown()) {
            return;
        }
        this.timePickerFragment.dismiss();
        this.mHour = this.timePickerFragment.getHour();
        this.mMinutes = this.timePickerFragment.getMinute();
        showTimePicker(this.initialClick, this.closeOnSet);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.set_alarm_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0116 A[Catch: Exception -> 0x010a, TRY_LEAVE, TryCatch #0 {Exception -> 0x010a, blocks: (B:8:0x00a6, B:10:0x00b0, B:12:0x00bc, B:14:0x00c9, B:16:0x00dd, B:18:0x00f6, B:21:0x010c, B:22:0x0116), top: B:116:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0406  */
    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreatePreference(Bundle bundle) {
        RepeatChipPreference repeatChipPreference;
        Alarm alarm;
        Alarm alarm2;
        DefaultValuePreference defaultValuePreference;
        DefaultValuePreference defaultValuePreference2;
        DefaultValuePreference defaultValuePreference3;
        NextAlarmPreference nextAlarmPreference;
        Preference preferenceFindPreference;
        Preference preferenceFindPreference2;
        Logger.logInfo("SetAlarm: onCreate");
        GlobalInitializator.initializeIfRequired(this);
        TintUtil.tint(this);
        ToolbarUtil.apply(this);
        int i = 1;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_accept);
        toolbar.setTitle("");
        toolbar.setOnTouchListener(new View.OnTouchListener() { // from class: com.urbandroid.sleep.alarmclock.SetAlarm$$ExternalSyntheticLambda6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$onCreatePreference$1(view, motionEvent);
            }
        });
        EdgeToEdgeUtil.insetsBottom(findViewById(R.id.button_panel));
        final TextInputEditText textInputEditText = (TextInputEditText) findViewById(R.id.label);
        int i2 = 0;
        textInputEditText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_pencil, 0);
        textInputEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.urbandroid.sleep.alarmclock.SetAlarm$$ExternalSyntheticLambda12
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                SetAlarm.lambda$onCreatePreference$2(textInputEditText, view, z);
            }
        });
        textInputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.urbandroid.sleep.alarmclock.SetAlarm$$ExternalSyntheticLambda13
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                return SetAlarm.lambda$onCreatePreference$3(textInputEditText, textView, i3, keyEvent);
            }
        });
        getWindow().setNavigationBarColor(ColorUtil.i(this, R.color.surface_variant));
        Settings settings = new Settings(getApplicationContext());
        getApplicationContext().getResources();
        if (getIntent() != null && getIntent().hasExtra("alarm_mode_extra")) {
            this.defaultModeAlarm = false;
            this.modeAlarm = false;
        }
        restore(bundle);
        AlarmTimePreference alarmTimePreference = (AlarmTimePreference) findPreference("time");
        this.mTimePref = alarmTimePreference;
        alarmTimePreference.setListener(new SetAlarm$$ExternalSyntheticLambda2(this, i));
        try {
            preferenceFindPreference2 = findPreference("feedback");
            this.feedbackPref = preferenceFindPreference2;
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        if (preferenceFindPreference2 != null) {
            if (!TrialFilter.getInstance().daysUsed(60) || SharedApplicationContext.getSettings().isShowCaseShown("new_alarm_feedback")) {
                getPreferenceScreen().removePreference(this.feedbackPref);
            } else {
                Locale locale = Locale.ENGLISH;
                if (locale.getLanguage().equals(Locale.getDefault().getLanguage())) {
                    if (System.currentTimeMillis() < new SimpleDateFormat("MMM dd yyyy HH:mm", locale).parse("Feb 10 2023 12:00").getTime()) {
                        getPreferenceScreen().addPreference(this.feedbackPref);
                        this.feedbackPref.setOnPreferenceClickListener(new SetAlarm$$ExternalSyntheticLambda7(this, i));
                    } else {
                        getPreferenceScreen().removePreference(this.feedbackPref);
                    }
                }
            }
            repeatChipPreference = (RepeatChipPreference) findPreference("setRepeat");
            this.mRepeatPref = repeatChipPreference;
            if (repeatChipPreference != null) {
                repeatChipPreference.setOnPreferenceChangeListener(this);
            }
            ListPreference listPreference = (ListPreference) findPreference("alarm_non_deep_sleep_window");
            this.mNonDeepSleepWindowPref = listPreference;
            listPreference.setOnPreferenceChangeListener(this);
            ((DefaultValueListPreference) this.mNonDeepSleepWindowPref).addDefaultValue(String.valueOf(!this.modeAlarm ? settings.getSmartWakeupMinutes() : settings.getSmartWakeupNapMinutes()), -1);
            DefaultValueListPreference defaultValueListPreference = (DefaultValueListPreference) findPreference("wake_up_check");
            this.wakeUpCheckPref = defaultValueListPreference;
            defaultValueListPreference.addDefaultValue(!settings.isWakeUpCheck() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            int i3 = 2;
            this.wakeUpCheckPref.setBindListener(new SetAlarm$$ExternalSyntheticLambda2(this, i3));
            Preference preferenceFindPreference3 = findPreference("alarm_captcha");
            this.mCaptcha = preferenceFindPreference3;
            preferenceFindPreference3.setOnPreferenceClickListener(new SetAlarm$$ExternalSyntheticLambda7(this, i3));
            int i4 = 3;
            ((DefaultValuePreference) this.mCaptcha).setBindListener(new SetAlarm$$ExternalSyntheticLambda2(this, i4));
            this.mCaptcha.setSummary(getDefaultCaptchaName());
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("alarm_self_dispose");
            this.mSelfDisposablePref = checkBoxPreference;
            checkBoxPreference.setOnPreferenceChangeListener(this);
            CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference("alarm_terminate_tracking");
            this.mTerminateTrackingPref = checkBoxPreference2;
            checkBoxPreference2.setOnPreferenceChangeListener(this);
            alarm = this.mOriginalAlarm;
            Preference preference = this.mCaptcha;
            if (alarm == null) {
                preference.setSummary(CaptchaPreferenceUtil.getSummary(this, alarm.captcha, R.string.captcha_preference_summary));
                int i5 = this.mOriginalAlarm.captcha;
                this.selectedCaptchaId = i5;
                this.mCaptcha.setIcon(CaptchaDrawableUtil.getDrawable(this, i5));
            } else {
                preference.setSummary(CaptchaPreferenceUtil.getSummary(this, settings.getDefaultCaptchaId(), R.string.captcha_preference_summary));
                this.mCaptcha.setIcon(CaptchaDrawableUtil.getDrawable(this, settings.getDefaultCaptchaId()));
            }
            this.globalPreferences = findPreference("global_preference");
            this.ringtonePreferences = findPreference("ringtone_preference");
            Intent intent = getIntent();
            if (this.mId == -1) {
                this.mId = intent.getIntExtra("alarm_id", -1);
            }
            if (this.mId != -1) {
                alarm2 = new Alarm();
            } else {
                alarm2 = Alarms.getAlarm(getContentResolver(), this.mId);
                if (alarm2 == null) {
                    finish();
                    return;
                }
            }
            Logger.logInfo("SetAlarm: alarm from DB " + alarm2.getDaysOfWeek());
            if (this.mOriginalAlarm != null) {
                Logger.logInfo("SetAlarm: alarm original " + this.mOriginalAlarm.getDaysOfWeek());
            }
            this.mOriginalAlarm = alarm2;
            defaultValuePreference = (DefaultValuePreference) findPreference("alarm_snooze");
            this.snoozePref = defaultValuePreference;
            if (defaultValuePreference != null) {
                updateSnoozePrefSummary(defaultValuePreference);
                this.snoozePref.setOnPreferenceClickListener(new SetAlarm$$ExternalSyntheticLambda7(this, i4));
            }
            defaultValuePreference2 = (DefaultValuePreference) findPreference("gentle_alarm");
            this.gentlePref = defaultValuePreference2;
            if (defaultValuePreference2 != null) {
                updateGentlePrefSummary(defaultValuePreference2);
                this.gentlePref.setOnPreferenceClickListener(new SetAlarm$$ExternalSyntheticLambda7(this, 4));
            }
            defaultValuePreference3 = (DefaultValuePreference) findPreference("alarm_bedtime");
            this.bedtimePref = defaultValuePreference3;
            if (defaultValuePreference3 != null) {
                updateBedtimePrefSummary(defaultValuePreference3);
                this.bedtimePref.setOnPreferenceClickListener(new SetAlarm$$ExternalSyntheticLambda7(this, i2));
            }
            this.selectedPlaylists = new HashSet(alarm2.extendedConfig.getSelectedPlaylists());
            Uri uri = this.mOriginalAlarm.alert;
            String string = uri != null ? null : uri.toString();
            Alarm alarm3 = this.mOriginalAlarm;
            updateRingtonePref(this, string, alarm3.silent, alarm3.extendedConfig.getRingtoneName());
            this.mNextAlarmCategory = (PreferenceCategory) findPreference("settings_category_next_alarm");
            nextAlarmPreference = (NextAlarmPreference) findPreference("alarm_next");
            this.nextAlarmPref = nextAlarmPreference;
            if (nextAlarmPreference != null) {
                nextAlarmPreference.setOffset(alarm2);
                this.nextAlarmPref.setOnPreferenceChangeListener(this);
            }
            Logger.logInfo("SetAlarm: onBind offset listener");
            preferenceFindPreference = findPreference(FreeSpaceBox.TYPE);
            this.skipPref = preferenceFindPreference;
            if (preferenceFindPreference != null) {
                boolean zIsSkipped = this.suspendNextInitialized ? this.suspendNext : Alarms.isSkipped(this.mOriginalAlarm);
                zza$$ExternalSyntheticOutline0.m("SetAlarm: Set skipped initial: ", zIsSkipped);
                this.suspendNextTime = this.mOriginalAlarm.suspendTime;
                setSkipNextState(zIsSkipped);
                if (zIsSkipped) {
                    updateSkipNextAlarmTime(this.mOriginalAlarm.time);
                }
                this.skipPref.setOnPreferenceClickListener(new SetAlarm$$ExternalSyntheticLambda7(this, 5));
            }
            Logger.logInfo("SetAlarm: ALARM " + alarm2.id + " " + alarm2);
            updateAlarmDay(alarm2.time);
            findPreference("alarm_next").setOnPreferenceClickListener(new SetAlarm$$ExternalSyntheticLambda7(this, 6));
            updatePrefs(this.mOriginalAlarm);
            if (this.mOriginalAlarm != null) {
                zza$$ExternalSyntheticOutline0.m(new StringBuilder("SetAlarm: switch menu "), this.mOriginalAlarm.enabled);
                setSwitchEnabled(this.mOriginalAlarm.enabled);
            }
            ((Button) findViewById(R.id.alarm_save)).setOnClickListener(new SetAlarm$$ExternalSyntheticLambda10(this, i2));
            Button button = (Button) findViewById(R.id.alarm_revert);
            button.setVisibility(8);
            button.setOnClickListener(new SetAlarm$$ExternalSyntheticLambda11(this, button, i2));
            Button button2 = (Button) findViewById(R.id.alarm_delete);
            if (this.mId != -1) {
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.SetAlarm.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (SetAlarm.this.mId > -1) {
                            SetAlarm setAlarm = SetAlarm.this;
                            Alarms.deleteAlarm(setAlarm, setAlarm.mId);
                        }
                        SetAlarm.this.finish();
                    }
                });
            } else {
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.SetAlarm.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SetAlarm.this.deleteAlarm();
                    }
                });
            }
            getListView().setItemsCanFocus(true);
            getListView().setNestedScrollingEnabled(true);
            final View viewFindViewById = findViewById(R.id.label_parent);
            ((AppBarLayout) findViewById(R.id.appbar)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarStateChangeListener() { // from class: com.urbandroid.sleep.alarmclock.SetAlarm.4
                @Override // com.urbandroid.sleep.gui.toolbar.AppBarStateChangeListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public void onOffsetChanged(AppBarLayout appBarLayout, int i6) {
                    super.onOffsetChanged(appBarLayout, i6);
                    if (SetAlarm.this.verticalOffset != i6) {
                        SetAlarm.this.verticalOffset = i6;
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewFindViewById.getLayoutParams();
                        layoutParams.leftMargin = ActivityUtils.getDip(this, Math.min(48, Math.abs(SetAlarm.this.verticalOffset / 2)));
                        layoutParams.rightMargin = ActivityUtils.getDip(this, Math.min(48, Math.abs(SetAlarm.this.verticalOffset / 2)));
                        viewFindViewById.setLayoutParams(layoutParams);
                    }
                }

                @Override // com.urbandroid.sleep.gui.toolbar.AppBarStateChangeListener
                public void onStateChanged(AppBarLayout appBarLayout, AppBarStateChangeListener.State state) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewFindViewById.getLayoutParams();
                    int i6 = AnonymousClass9.$SwitchMap$com$urbandroid$sleep$gui$toolbar$AppBarStateChangeListener$State[state.ordinal()];
                    if (i6 == 1) {
                        SetAlarm.this.appbarState = state;
                        layoutParams.leftMargin = 0;
                        layoutParams.rightMargin = 0;
                        viewFindViewById.setLayoutParams(layoutParams);
                        return;
                    }
                    if (i6 == 2) {
                        SetAlarm.this.appbarState = state;
                    } else {
                        if (i6 != 3) {
                            return;
                        }
                        SetAlarm.this.appbarState = state;
                    }
                }
            });
            if (this.mId != -1) {
                this.mTimePickerCancelled = true;
                Logger.logInfo("SetAlarm: New alarm: Show timepicker");
                if (getSupportFragmentManager().findFragmentByTag("timepicker") == null) {
                    showTimePicker(true, false);
                }
            } else if (bundle == null && getIntent() != null && getIntent().hasExtra("set_time_extra")) {
                Logger.logInfo("SetAlarm:Asked to show timepicker");
                if (getSupportFragmentManager().findFragmentByTag("timepicker") == null) {
                    showTimePicker(true, true);
                }
            }
            if ((getResources().getConfiguration().screenLayout & 15) < 2) {
                findViewById(R.id.button_panel).setVisibility(8);
            }
            StringBuilder sb = new StringBuilder("SetAlarm: original alarm ");
            Alarm alarm4 = this.mOriginalAlarm;
            sb.append(alarm4 == null ? Alarm.toDebugString(alarm4) : "null");
            Logger.logInfo(sb.toString());
            LamerPreferenceCategory.init(this, getPreferenceScreen(), "settings_category_alarm_snooze", "settings_category_bedtime", "settings_category_alarm_misc");
            getListView().setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.urbandroid.sleep.alarmclock.SetAlarm.5
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i6, int i7, int i8) {
                    if (SetAlarm.this.elevantionAnimator == null) {
                        SetAlarm.this.elevantionAnimator = new ElevantionAnimator(absListView.getContext(), SetAlarm.this.findViewById(R.id.toolbar), absListView);
                    }
                    SetAlarm.this.elevantionAnimator.scroll();
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i6) {
                }
            });
            if (settings.isAlarmFullscreen()) {
                AlarmSettingsActivity.onboardFullscreen(this, "set_alarm_fullscreen_onboard");
            } else if (ContextCompat.checkSelfPermission(this, "android.permission.USE_FULL_SCREEN_INTENT") != 0) {
                this.requestFullscreenPermissionLauncher.launch("android.permission.USE_FULL_SCREEN_INTENT");
            } else {
                AlarmSettingsActivity.askOverlay(this, AlarmSettingsActivity.class);
            }
            DefaultRingtoneResolveService.start(this);
        }
        repeatChipPreference = (RepeatChipPreference) findPreference("setRepeat");
        this.mRepeatPref = repeatChipPreference;
        if (repeatChipPreference != null) {
        }
        ListPreference listPreference2 = (ListPreference) findPreference("alarm_non_deep_sleep_window");
        this.mNonDeepSleepWindowPref = listPreference2;
        listPreference2.setOnPreferenceChangeListener(this);
        ((DefaultValueListPreference) this.mNonDeepSleepWindowPref).addDefaultValue(String.valueOf(!this.modeAlarm ? settings.getSmartWakeupMinutes() : settings.getSmartWakeupNapMinutes()), -1);
        DefaultValueListPreference defaultValueListPreference2 = (DefaultValueListPreference) findPreference("wake_up_check");
        this.wakeUpCheckPref = defaultValueListPreference2;
        defaultValueListPreference2.addDefaultValue(!settings.isWakeUpCheck() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        int i32 = 2;
        this.wakeUpCheckPref.setBindListener(new SetAlarm$$ExternalSyntheticLambda2(this, i32));
        Preference preferenceFindPreference32 = findPreference("alarm_captcha");
        this.mCaptcha = preferenceFindPreference32;
        preferenceFindPreference32.setOnPreferenceClickListener(new SetAlarm$$ExternalSyntheticLambda7(this, i32));
        int i42 = 3;
        ((DefaultValuePreference) this.mCaptcha).setBindListener(new SetAlarm$$ExternalSyntheticLambda2(this, i42));
        this.mCaptcha.setSummary(getDefaultCaptchaName());
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) findPreference("alarm_self_dispose");
        this.mSelfDisposablePref = checkBoxPreference3;
        checkBoxPreference3.setOnPreferenceChangeListener(this);
        CheckBoxPreference checkBoxPreference22 = (CheckBoxPreference) findPreference("alarm_terminate_tracking");
        this.mTerminateTrackingPref = checkBoxPreference22;
        checkBoxPreference22.setOnPreferenceChangeListener(this);
        alarm = this.mOriginalAlarm;
        Preference preference2 = this.mCaptcha;
        if (alarm == null) {
        }
        this.globalPreferences = findPreference("global_preference");
        this.ringtonePreferences = findPreference("ringtone_preference");
        Intent intent2 = getIntent();
        if (this.mId == -1) {
        }
        if (this.mId != -1) {
        }
        Logger.logInfo("SetAlarm: alarm from DB " + alarm2.getDaysOfWeek());
        if (this.mOriginalAlarm != null) {
        }
        this.mOriginalAlarm = alarm2;
        defaultValuePreference = (DefaultValuePreference) findPreference("alarm_snooze");
        this.snoozePref = defaultValuePreference;
        if (defaultValuePreference != null) {
        }
        defaultValuePreference2 = (DefaultValuePreference) findPreference("gentle_alarm");
        this.gentlePref = defaultValuePreference2;
        if (defaultValuePreference2 != null) {
        }
        defaultValuePreference3 = (DefaultValuePreference) findPreference("alarm_bedtime");
        this.bedtimePref = defaultValuePreference3;
        if (defaultValuePreference3 != null) {
        }
        this.selectedPlaylists = new HashSet(alarm2.extendedConfig.getSelectedPlaylists());
        Uri uri2 = this.mOriginalAlarm.alert;
        if (uri2 != null) {
        }
        Alarm alarm32 = this.mOriginalAlarm;
        updateRingtonePref(this, string, alarm32.silent, alarm32.extendedConfig.getRingtoneName());
        this.mNextAlarmCategory = (PreferenceCategory) findPreference("settings_category_next_alarm");
        nextAlarmPreference = (NextAlarmPreference) findPreference("alarm_next");
        this.nextAlarmPref = nextAlarmPreference;
        if (nextAlarmPreference != null) {
        }
        Logger.logInfo("SetAlarm: onBind offset listener");
        preferenceFindPreference = findPreference(FreeSpaceBox.TYPE);
        this.skipPref = preferenceFindPreference;
        if (preferenceFindPreference != null) {
        }
        Logger.logInfo("SetAlarm: ALARM " + alarm2.id + " " + alarm2);
        updateAlarmDay(alarm2.time);
        findPreference("alarm_next").setOnPreferenceClickListener(new SetAlarm$$ExternalSyntheticLambda7(this, 6));
        updatePrefs(this.mOriginalAlarm);
        if (this.mOriginalAlarm != null) {
        }
        ((Button) findViewById(R.id.alarm_save)).setOnClickListener(new SetAlarm$$ExternalSyntheticLambda10(this, i2));
        Button button3 = (Button) findViewById(R.id.alarm_revert);
        button3.setVisibility(8);
        button3.setOnClickListener(new SetAlarm$$ExternalSyntheticLambda11(this, button3, i2));
        Button button22 = (Button) findViewById(R.id.alarm_delete);
        if (this.mId != -1) {
        }
        getListView().setItemsCanFocus(true);
        getListView().setNestedScrollingEnabled(true);
        final View viewFindViewById2 = findViewById(R.id.label_parent);
        ((AppBarLayout) findViewById(R.id.appbar)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AppBarStateChangeListener() { // from class: com.urbandroid.sleep.alarmclock.SetAlarm.4
            @Override // com.urbandroid.sleep.gui.toolbar.AppBarStateChangeListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public void onOffsetChanged(AppBarLayout appBarLayout, int i6) {
                super.onOffsetChanged(appBarLayout, i6);
                if (SetAlarm.this.verticalOffset != i6) {
                    SetAlarm.this.verticalOffset = i6;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewFindViewById2.getLayoutParams();
                    layoutParams.leftMargin = ActivityUtils.getDip(this, Math.min(48, Math.abs(SetAlarm.this.verticalOffset / 2)));
                    layoutParams.rightMargin = ActivityUtils.getDip(this, Math.min(48, Math.abs(SetAlarm.this.verticalOffset / 2)));
                    viewFindViewById2.setLayoutParams(layoutParams);
                }
            }

            @Override // com.urbandroid.sleep.gui.toolbar.AppBarStateChangeListener
            public void onStateChanged(AppBarLayout appBarLayout, AppBarStateChangeListener.State state) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewFindViewById2.getLayoutParams();
                int i6 = AnonymousClass9.$SwitchMap$com$urbandroid$sleep$gui$toolbar$AppBarStateChangeListener$State[state.ordinal()];
                if (i6 == 1) {
                    SetAlarm.this.appbarState = state;
                    layoutParams.leftMargin = 0;
                    layoutParams.rightMargin = 0;
                    viewFindViewById2.setLayoutParams(layoutParams);
                    return;
                }
                if (i6 == 2) {
                    SetAlarm.this.appbarState = state;
                } else {
                    if (i6 != 3) {
                        return;
                    }
                    SetAlarm.this.appbarState = state;
                }
            }
        });
        if (this.mId != -1) {
        }
        if ((getResources().getConfiguration().screenLayout & 15) < 2) {
        }
        StringBuilder sb2 = new StringBuilder("SetAlarm: original alarm ");
        Alarm alarm42 = this.mOriginalAlarm;
        sb2.append(alarm42 == null ? Alarm.toDebugString(alarm42) : "null");
        Logger.logInfo(sb2.toString());
        LamerPreferenceCategory.init(this, getPreferenceScreen(), "settings_category_alarm_snooze", "settings_category_bedtime", "settings_category_alarm_misc");
        getListView().setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.urbandroid.sleep.alarmclock.SetAlarm.5
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i6, int i7, int i8) {
                if (SetAlarm.this.elevantionAnimator == null) {
                    SetAlarm.this.elevantionAnimator = new ElevantionAnimator(absListView.getContext(), SetAlarm.this.findViewById(R.id.toolbar), absListView);
                }
                SetAlarm.this.elevantionAnimator.scroll();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i6) {
            }
        });
        if (settings.isAlarmFullscreen()) {
        }
        DefaultRingtoneResolveService.start(this);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.menu_doc) {
                return true;
            }
            ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//alarms/alarm_settings.html");
            return true;
        }
        saveAlarmAndFinish();
        try {
            if (SharedApplicationContext.getSettings().isTimeToBackup()) {
                new BackupManager(this).dataChanged();
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        return true;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        int i = 0;
        sHandler.post(new SetAlarm$$ExternalSyntheticLambda0(this, i));
        if (preference != null && obj != null && preference.equals(this.mCaptcha)) {
            try {
                i = Integer.parseInt((String) obj);
            } catch (NumberFormatException e) {
                Logger.logSevere(e);
            }
            if (i >= 0) {
                CaptchaInfo captchaInfo = SharedApplicationContext.getSettings().getCaptchaInfo(i);
                if (captchaInfo != null) {
                    this.mCaptcha.setSummary(captchaInfo.getLabel() + "  " + DefaultValueListPreference.getDefaultPrefix(this) + " " + getDefaultCaptchaName());
                }
            } else {
                this.mCaptcha.setSummary(getDefaultCaptchaName());
            }
        } else if (preference == null || !preference.equals(this.mRepeatPref)) {
            if (preference != null && preference.equals(this.mSelfDisposablePref) && !this.defaultModeAlarm && !((Boolean) obj).booleanValue()) {
                this.defaultModeAlarm = true;
            }
            if (preference.equals(this.mNonDeepSleepWindowPref)) {
                if (obj.toString().equals("59")) {
                    AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(this).create();
                    alertDialogCreate.setTitle(getResources().getString(R.string.powernap_warning_title));
                    alertDialogCreate.setMessage(getResources().getString(R.string.powernap_warning_text2));
                    alertDialogCreate.setButton(-1, "OK", new SetAlarm$$ExternalSyntheticLambda1(i));
                    alertDialogCreate.show();
                }
                try {
                    ((DefaultValueListPreference) this.mNonDeepSleepWindowPref).setLongDesc(getSmartPeriodDesc(this.mHour, this.mMinutes, Integer.parseInt(obj.toString()) < 0 ? SharedApplicationContext.getSettings().getSmartWakeupMinutes() : Integer.parseInt(obj.toString())));
                } catch (NumberFormatException e2) {
                    Logger.logSevere(e2);
                }
                updateOffsetPref();
            }
            if (preference.equals(this.nextAlarmPref)) {
                Alarm alarmMapToAlarm = mapToAlarm();
                Alarms.fixPowerNapDisplayTime(alarmMapToAlarm);
                Alarms.addOffset(this, alarmMapToAlarm, this.nextAlarmPref.getOffsetMinutes());
                this.nextAlarmPref.setOffset(alarmMapToAlarm);
            }
        } else if (obj != null) {
            if (this.mRepeatPref.isRepeating()) {
                Logger.logInfo("SetAlarm: disposable FALSE");
                this.mSelfDisposablePref.setChecked(false);
            } else {
                setSkipNextState(false);
            }
            refreshRepeating();
            return true;
        }
        return true;
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == this.mTimePref) {
            showTimePicker(false, false);
        } else if (preference == this.globalPreferences) {
            startActivity(new Intent(this, (Class<?>) AlarmSettingsActivity.class));
        } else if (preference == this.ringtonePreferences) {
            if (Build.VERSION.SDK_INT >= 33 && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.READ_MEDIA_AUDIO")) {
                PermissionCompat.requestPermission(this, "android.permission.READ_MEDIA_AUDIO", 736);
            } else if (PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.READ_EXTERNAL_STORAGE")) {
                startRingtoneChooser();
            } else {
                PermissionCompat.requestPermission(this, "android.permission.READ_EXTERNAL_STORAGE", 736);
            }
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 376) {
            if (i != 736) {
                return;
            }
            startRingtoneChooser();
        } else if (iArr[0] != 0) {
            new MaterialAlertDialogBuilder(this).setTitle(R.string.no_permission).setMessage((CharSequence) ViewIntent.getNoPermissionText(this, "android.permission-group.LOCATION", R.string.sunrise)).setPositiveButton(R.string.settings, (DialogInterface.OnClickListener) new SetAlarm$$ExternalSyntheticLambda3(this, 3)).setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null).show();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Logger.logInfo("onRestoreInstanceState");
        restore(bundle);
    }

    @Override // com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        refreshRepeating();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Alarm alarmMapToAlarm = mapToAlarm();
        Logger.logInfo("SetAlarm: saving alarm " + alarmMapToAlarm.id + " " + alarmMapToAlarm.getDaysOfWeek());
        bundle.putParcelable("alarm", alarmMapToAlarm);
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePickerActivity
    public void scheduleSunrise() {
        Location location = SharedApplicationContext.getSettings().getLocation();
        Logger.logInfo("SetAlarm: Schedule sunrise " + location);
        if (location != null) {
            scheduleLocationBasedAlarm();
            return;
        }
        if (!PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") && !PermissionCompat.isPermissionGranted(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION")) {
            Logger.logInfo("SetAlarm: Schedule sunrise: needs permission ");
            SleepPermissionCompat.INSTANCE.requestPermission(this, "android.permission.ACCESS_COARSE_LOCATION", 1);
        } else {
            if (LocationService.getLocation(this, new LocationService.LocationCallback() { // from class: com.urbandroid.sleep.alarmclock.SetAlarm.8
                @Override // com.urbandroid.sleep.location.LocationService.LocationCallback
                public void updateLocation(Location location2) {
                    Logger.logInfo("SetAlarm: Schedule sunrise: getLocation " + location2);
                    if (location2 != null) {
                        SharedApplicationContext.getSettings().setLocation(location2);
                    }
                    SetAlarm.this.scheduleLocationBasedAlarm();
                }
            }) || location != null) {
                return;
            }
            Toast.makeText(this, R.string.enable_location_from_network, 0).show();
            startActivityForResult(new Intent(this, (Class<?>) LocationActivity.class), 39487);
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePickerActivity
    public void startSpeechRecognition() {
        try {
            Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
            intent.putExtra("android.speech.extra.PROMPT", R.string.text_to_speech_title);
            startActivityForResult(intent, 1234);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, getString(R.string.speech_recognizer_not_present), 0).show();
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePickerActivity
    public void switchMode() {
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("SetAlarm: switch mode, alarm: "), this.modeAlarm);
        boolean z = this.modeAlarm;
        this.modeAlarm = !z;
        this.modeChangeClicked = true;
        if (this.initialClick) {
            this.mSelfDisposablePref.setChecked(z && !isRepeating());
        }
        TimePicker timePicker = this.timePickerFragment;
        if (timePicker != null) {
            timePicker.dismiss();
        }
        if (this.modeChangeClicked) {
            this.modeChangeClicked = false;
            createTimePickerDialog();
        }
    }

    public static void popAlarmSetToast(Context context, Alarm alarm, boolean z) {
        popAlarmSetToast(context, Alarms.calculateAlarm(context, alarm), z);
    }

    @Override // com.urbandroid.sleep.alarmclock.timepicker.TimePickerActivity
    public void updateTime(int i, int i2) {
        this.mTimePickerCancelled = false;
        boolean z = (this.mHour == i && this.mMinutes == i2) ? false : true;
        this.mHour = i;
        this.mMinutes = i2;
        updateTime();
        if (this.mTimePref.getSwitch() != null) {
            Logger.logInfo("SetAlarm: switch TRUE 1");
            setSwitchEnabled(true);
        }
        if (z) {
            setSkipNextState(false);
            updateAlarmDay(calculateNextAlarmTime());
        }
        popAlarmSetToast(this, saveAlarmAndEnableRevert(), isPowerNap());
        updateOffsetPref();
        if (this.closeOnSet) {
            finish();
        }
    }
}
