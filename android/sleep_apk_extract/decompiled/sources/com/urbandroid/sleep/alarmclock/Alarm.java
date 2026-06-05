package com.urbandroid.sleep.alarmclock;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.material.snackbar.Snackbar;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.DbEncodingUtils;
import com.urbandroid.common.util.string.StringUtil;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SkipNextAlarmActivity;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.Experiments;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public final class Alarm implements Parcelable, Externalizable {
    public static final Parcelable.Creator<Alarm> CREATOR = new Parcelable.Creator<Alarm>() { // from class: com.urbandroid.sleep.alarmclock.Alarm.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Alarm createFromParcel(Parcel parcel) {
            return new Alarm(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Alarm[] newArray(int i) {
            return new Alarm[i];
        }
    };
    static final long serialVersionUID = 42;
    public Uri alert;
    public int captcha;
    private DaysOfWeek daysOfWeek;
    public boolean enabled;
    public AlarmExtendedConfig extendedConfig;
    public int hour;
    public int id;
    public String label;
    public boolean legacyVibrate;
    public int minutes;
    public int nonDeepsleepWakeupWindow;
    public boolean silent;
    public long suspendTime;
    public long time;

    public static class Columns implements BaseColumns, AlarmColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.urbandroid.sleep.alarmclock/alarm");
    }

    public Alarm(Parcel parcel) {
        this.extendedConfig = new AlarmExtendedConfig();
        try {
            this.id = parcel.readInt();
            this.enabled = parcel.readInt() == 1;
            this.hour = parcel.readInt();
            this.minutes = parcel.readInt();
            this.daysOfWeek = new DaysOfWeek(parcel.readInt());
            this.time = parcel.readLong();
            this.suspendTime = parcel.readLong();
            this.nonDeepsleepWakeupWindow = parcel.readInt();
            this.captcha = parcel.readInt();
            this.legacyVibrate = parcel.readInt() == 1;
            this.label = parcel.readString();
            this.alert = (Uri) parcel.readParcelable(null);
            this.silent = parcel.readInt() == 1;
            AlarmExtendedConfig alarmExtendedConfig = (AlarmExtendedConfig) parcel.readSerializable();
            this.extendedConfig = alarmExtendedConfig;
            if (alarmExtendedConfig != null && alarmExtendedConfig.isNonWeekly()) {
                this.daysOfWeek.setNonWeekly(this.extendedConfig.getNonWeeklyFrom().longValue(), this.extendedConfig.getNonWeeklyRepeat().intValue());
            }
        } catch (BadParcelableException unused) {
            parcel.setDataPosition(0);
            this.id = parcel.readInt();
            this.enabled = parcel.readInt() == 1;
            this.hour = parcel.readInt();
            this.minutes = parcel.readInt();
            this.daysOfWeek = new DaysOfWeek(parcel.readInt());
            this.time = parcel.readLong();
            this.suspendTime = parcel.readLong();
            this.nonDeepsleepWakeupWindow = parcel.readInt();
            this.captcha = -1;
            this.legacyVibrate = parcel.readInt() == 1;
            this.label = parcel.readString();
            this.alert = (Uri) parcel.readParcelable(null);
            this.silent = parcel.readInt() == 1;
        }
        if (this.extendedConfig == null) {
            this.extendedConfig = new AlarmExtendedConfig();
        }
    }

    public static int calculateCurrentRemainingSnoozeTime(Alarm alarm) {
        Logger.logInfo("Alarm: calculateCurrentRemainingSnoozeTime");
        Settings settings = SharedApplicationContext.getSettings();
        if (settings.getSnoozeTotalTimeLimit(alarm) == Integer.MAX_VALUE) {
            Logger.logInfo("Alarm: no snooze remaining time limit");
            return Integer.MAX_VALUE;
        }
        long lastNonSnoozeAlarm = settings.getLastNonSnoozeAlarm();
        Logger.logDebug("calculateCurrentRemainingSnoozeTime: nextLastSnoozeAlarm " + lastNonSnoozeAlarm);
        if (lastNonSnoozeAlarm == -1) {
            return Integer.MAX_VALUE;
        }
        int snoozeTotalTimeLimit = settings.getSnoozeTotalTimeLimit(alarm);
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i = snoozeTotalTimeLimit - ((int) ((jCurrentTimeMillis - lastNonSnoozeAlarm) / 60000));
        Logger.logDebug("calculateCurrentRemainingSnoozeTime: now: " + jCurrentTimeMillis + " timeLimit: " + snoozeTotalTimeLimit + " remainingTime: " + i);
        if (i < 0) {
            return 0;
        }
        Logger.logInfo("Alarm: snooze remaining time " + i + " minutes");
        return i;
    }

    public static Alarm createDefaultAlarm(int i, int i2) {
        Alarm alarm = new Alarm();
        alarm.enabled = true;
        alarm.hour = i;
        alarm.minutes = i2;
        alarm.label = "";
        alarm.alert = Uri.parse("android.resource://com.urbandroid.sleep/raw/default");
        alarm.silent = false;
        alarm.nonDeepsleepWakeupWindow = -1;
        alarm.captcha = -1;
        alarm.extendedConfig.setVibrationStart(-2);
        alarm.extendedConfig.setVibrationStartSmartWatch(-2);
        alarm.extendedConfig.setSoundDelay(-2);
        alarm.extendedConfig.setTimeToBed(-2);
        alarm.extendedConfig.setSnoozeAfterAlarm(-2);
        alarm.extendedConfig.setSelfDisposable(Boolean.TRUE);
        return alarm;
    }

    public static Alarm deserializeFromArray(byte[] bArr) {
        try {
            return (Alarm) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
        } catch (Exception e) {
            Logger.logWarning("Failed to deserialize an alarm.", e);
            return null;
        }
    }

    public static String getAlarmHumanReadableText(Context context, Alarm alarm) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(DateUtil.formatDay(alarm.time));
        sb.append(" ");
        sb.append(DateUtil.formatTime(context, alarm.time));
        sb.append(" ");
        sb.append(context.getString(R.string.default_label));
        String str2 = alarm.label;
        if (str2 == null || str2.trim().isEmpty()) {
            str = "";
        } else {
            str = " - " + alarm.label;
        }
        sb.append(str);
        return sb.toString();
    }

    public static long getCurrentRecordAlarmTime(Alarm alarm) {
        SleepRecord record;
        Date lastestTo;
        if (alarm == null || (record = CurrentSleepRecord.getInstance().getRecord()) == null || (lastestTo = record.getLastestTo()) == null) {
            return 0L;
        }
        return lastestTo.getTime();
    }

    private Calendar getOffsetCalendar(Context context, long j) {
        int nextAlarm;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        if (getDaysOfWeek() != null && (nextAlarm = getDaysOfWeek().getNextAlarm(context, calendar)) > 0) {
            calendar.add(5, nextAlarm);
        }
        calendar.set(11, this.hour);
        calendar.set(12, this.minutes);
        if (calendar.getTime().before(new Date(j))) {
            calendar.add(5, 1);
        }
        calendar.set(11, this.hour);
        calendar.add(12, getOffset(j));
        return calendar;
    }

    public static String getSnoozeDisableReason(Context context, Alarm alarm) {
        String string = context.getString(R.string.disabled);
        if (new Settings(context).getSnoozeDuration(alarm) <= 0) {
            return context.getString(R.string.alarm_alert_snooze_text) + " " + string;
        }
        int snoozeMinutes = getSnoozeMinutes(alarm, false);
        if (maxSnoozeMinutes(alarm) > 0) {
            if (snoozeMinutes <= 0) {
                return context.getString(R.string.snooze_total_time_limit_title);
            }
            return SharedApplicationContext.getSettings().getSnoozeLimit(alarm) > SharedApplicationContext.getSettings().getSnoozeRepeat() ? context.getString(R.string.snooze_limit_title) : context.getString(R.string.snooze_limit_title);
        }
        return context.getString(R.string.alarm_snooze_after_alert_title) + " " + string;
    }

    public static int getSnoozeMinutes(Alarm alarm, boolean z) {
        Settings settings = SharedApplicationContext.getSettings();
        int snoozeDuration = settings.getSnoozeDuration(alarm);
        int i = 0;
        if (settings.isHalveSnooze() && snoozeDuration != 0) {
            for (int i2 = 0; i2 < settings.getSnoozeRepeat(); i2++) {
                snoozeDuration /= 2;
            }
            snoozeDuration = Math.max(snoozeDuration, 1);
        }
        if (z) {
            i = Integer.MAX_VALUE;
        } else {
            int iMaxSnoozeMinutes = maxSnoozeMinutes(alarm);
            if (iMaxSnoozeMinutes >= 0) {
                i = iMaxSnoozeMinutes;
            }
        }
        return Math.min(Math.min(snoozeDuration, i), calculateCurrentRemainingSnoozeTime(alarm));
    }

    public static boolean isPowerNap(Alarm alarm) {
        int i = alarm.nonDeepsleepWakeupWindow;
        if (i != 59) {
            return i == -1 && SharedApplicationContext.getSettings().getSmartWakeupMinutes() == 59;
        }
        return true;
    }

    public static boolean isSnoozeEnabled(Alarm alarm) {
        int snoozeRepeat = SharedApplicationContext.getSettings().getSnoozeRepeat();
        int snoozeLimit = SharedApplicationContext.getSettings().getSnoozeLimit(alarm);
        boolean z = false;
        int snoozeMinutes = getSnoozeMinutes(alarm, false);
        int iMaxSnoozeMinutes = maxSnoozeMinutes(alarm);
        if (alarm != null && snoozeMinutes > 0 && iMaxSnoozeMinutes > 0 && (snoozeLimit == 0 || snoozeLimit > snoozeRepeat)) {
            z = true;
        }
        StringBuilder sb = new StringBuilder("SNOOZE enabled: ");
        sb.append(z);
        sb.append(" Alarm id: ");
        Fragment$$ExternalSyntheticOutline1.m(sb, alarm != null ? alarm.id : -1, " Snooze minutes ", snoozeMinutes, " Max snooze minutes: ");
        Fragment$$ExternalSyntheticOutline1.m(sb, iMaxSnoozeMinutes, " Limit ", snoozeLimit, " Counter ");
        zza$$ExternalSyntheticOutline0.m(sb, snoozeRepeat);
        return z;
    }

    public static int maxSnoozeMinutes(Alarm alarm) {
        if (SharedApplicationContext.getSettings().isSnoozeAfterAlarmEnabled(alarm)) {
            return Integer.MAX_VALUE;
        }
        if (alarm == null) {
            Logger.logInfo("Disabling snooze as we have no alarm.");
            return -1;
        }
        long snoozeAllowedTill = SharedApplicationContext.getSettings().getSnoozeAllowedTill();
        if (snoozeAllowedTill == -1) {
            return 0;
        }
        Logger.logInfo("Snooze after alarm? alarm time " + new Date(alarm.time) + " allowed till " + new Date(snoozeAllowedTill));
        int iCurrentTimeMillis = (int) (((snoozeAllowedTill - System.currentTimeMillis()) / 60000) + 1);
        StringBuilder sb = new StringBuilder("Snooze after alarm? Allow snooze: ");
        sb.append(iCurrentTimeMillis > 2);
        sb.append(" allowed till: ");
        sb.append(new Date(snoozeAllowedTill));
        sb.append(" maxMin ");
        sb.append(iCurrentTimeMillis);
        Logger.logInfo(sb.toString());
        if (iCurrentTimeMillis > 2) {
            return iCurrentTimeMillis;
        }
        return 0;
    }

    private void parseAlertFromString(String str) {
        if ("silent".equals(str)) {
            this.silent = true;
            return;
        }
        if (str != null && str.length() != 0) {
            this.alert = Uri.parse(str);
        }
        if (this.alert == null) {
            this.alert = RingtoneManager.getDefaultUri(4);
        }
    }

    public static Alarm parseFromBundle(Bundle bundle) {
        Alarm alarmDeserializeFromArray;
        byte[] byteArray = bundle.getByteArray("intent.extra.alarm_raw");
        if (byteArray != null) {
            alarmDeserializeFromArray = deserializeFromArray(byteArray);
            if (alarmDeserializeFromArray == null) {
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(byteArray, 0, byteArray.length);
                parcelObtain.setDataPosition(0);
                alarmDeserializeFromArray = CREATOR.createFromParcel(parcelObtain);
            }
        } else {
            alarmDeserializeFromArray = null;
        }
        if (alarmDeserializeFromArray == null) {
            try {
                alarmDeserializeFromArray = (Alarm) bundle.getParcelable("intent.extra.alarm");
            } catch (Exception e) {
                Logger.logDebug("Failed to parse alarm from extra intent: " + e.getMessage());
            }
            if (alarmDeserializeFromArray == null) {
                Logger.logDebug("Failed to parse the alarm from the intent");
                return null;
            }
        }
        return alarmDeserializeFromArray;
    }

    public static Alarm parseFromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        if (intent.hasExtra("intent.extra.alarm_raw") || intent.hasExtra("intent.extra.alarm")) {
            return parseFromBundle(intent.getExtras());
        }
        return null;
    }

    public static void performDismiss(Context context, Alarm alarm, SleepRecord sleepRecord, boolean z) {
        try {
            Logger.logInfo("SnoozeRepeat: reset alarm ");
            Settings settings = SharedApplicationContext.getSettings();
            Logger.logInfo("Snooze after alarm? reset till time ");
            settings.setSnoozeAllowedTill(-1L);
            settings.resetSnoozeRepeat();
            Logger.logInfo(z ? "Alarm: Alarm killed" : "Alarm: Alarm dismissed by user");
            requestAlarmSoundStop(context);
            if (!z) {
                Logger.logDebug("Stopping alarm service");
                if (alarm != null && shouldDeleteAlarm(alarm) && !settings.isWakeUpCheck(alarm)) {
                    Logger.logInfo("Deleting sleep alarm " + alarm.label + " ID: " + alarm.id);
                    Alarms.deleteAlarm(context, alarm.id);
                }
                if (sleepRecord == null || !(alarm == null || alarm.extendedConfig.isTerminatesTracking().booleanValue())) {
                    Logger.logInfo("Null record in alarm alert");
                } else {
                    RatingActivity.showRatingIfEnabled(context, sleepRecord);
                }
                if (alarm != null && SharedApplicationContext.getSettings().isWakeUpCheck(alarm)) {
                    Logger.logInfo("WakeUpCheck: dismiss " + alarm.id);
                    Alarms.scheduleWakeUpCheck(context, alarm, SharedApplicationContext.getSettings().getWakeUpCheckAfterAlarm());
                }
            }
            Intent intent = new Intent("com.urbandroid.sleep.alarmclock.ALARM_ALERT_DISMISS");
            if (alarm != null) {
                intent.putExtra("alarm_id", alarm.id);
            }
            ContextExtKt.sendExplicitBroadcast(context, intent);
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventAlarmRings(context, alarm, sleepRecord);
            Logger.logInfo("SmartLight: on AlarmKlaxon " + AlarmKlaxon.smartLight);
            if (AlarmKlaxon.smartLight != null) {
                Logger.logInfo("SmartLight: off? " + AlarmKlaxon.smartLight);
                if (SharedApplicationContext.getSettings().isSmartlightLightUpAfterDismiss()) {
                    Logger.logInfo("SmartLight: sunriseFull ");
                    AlarmKlaxon.smartLight.sunriseFull();
                } else {
                    Logger.logInfo("SmartLight: off ");
                    AlarmKlaxon.smartLight.off(true);
                }
            }
        } catch (Throwable th) {
            Intent intent2 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_ALERT_DISMISS");
            if (alarm != null) {
                intent2.putExtra("alarm_id", alarm.id);
            }
            ContextExtKt.sendExplicitBroadcast(context, intent2);
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventAlarmRings(context, alarm, sleepRecord);
            Logger.logInfo("SmartLight: on AlarmKlaxon " + AlarmKlaxon.smartLight);
            if (AlarmKlaxon.smartLight != null) {
                Logger.logInfo("SmartLight: off? " + AlarmKlaxon.smartLight);
                if (SharedApplicationContext.getSettings().isSmartlightLightUpAfterDismiss()) {
                    Logger.logInfo("SmartLight: sunriseFull ");
                    AlarmKlaxon.smartLight.sunriseFull();
                } else {
                    Logger.logInfo("SmartLight: off ");
                    AlarmKlaxon.smartLight.off(true);
                }
            }
            throw th;
        }
    }

    public static void performSnooze(Context context, Alarm alarm, int i, boolean z) {
        Logger.logDebug("Alarm: performSnooze() " + i + " autoKill " + z);
        if (i == -39837) {
            long currentRecordAlarmTime = getCurrentRecordAlarmTime(alarm);
            if (currentRecordAlarmTime == 0 || System.currentTimeMillis() >= currentRecordAlarmTime - 60000) {
                Logger.logInfo("Alarm: Ignoring snooze till alarm.. no alarm or less then a minute to alarm fire time");
                return;
            }
            Logger.logInfo("Alarm: Snooze till alarm: " + i);
            i = (int) ((currentRecordAlarmTime - System.currentTimeMillis()) / 60000);
        }
        if (i <= 0) {
            Logger.logInfo("Alarm: Adjusting snooze time to min: 1");
            i = 1;
        }
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (record != null) {
            if (z) {
                record.addEventLabel(EventLabel.ALARM_SNOOZE_AFTER_KILL, System.currentTimeMillis());
            } else {
                record.addEventLabel(EventLabel.ALARM_SNOOZE, System.currentTimeMillis());
            }
        }
        long jCurrentTimeMillis = (60000 * ((long) i)) + System.currentTimeMillis();
        if (alarm == null) {
            Logger.logSevere("Alarm: cannot perform snooze alarm NULL");
            return;
        }
        Alarms.saveSnoozeAlert(context, alarm.id, jCurrentTimeMillis);
        Calendar.getInstance().setTimeInMillis(jCurrentTimeMillis);
        String string = context.getString(R.string.alarm_alert_snooze_set, Integer.valueOf(i));
        showSnoozeNotification(context, alarm, i);
        Toast.makeText(context, string, 1).show();
        Intent intent = new Intent(context, (Class<?>) AlarmKlaxon.class);
        intent.setAction("com.urbandroid.sleep.alarmclock.ALARM_ALERT");
        context.stopService(intent);
        Intent intent2 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE_CLICKED_ACTION");
        intent2.putExtra("alarm_id", alarm.id);
        ContextExtKt.sendExplicitBroadcast(context, intent2);
        Logger.logInfo("Dim: Alarm send broadcast ALARM_SNOOZE_CLICKED_ACTION ");
        SharedApplicationContext.getSettings().increaseSnoozeRepeat();
        Logger.logInfo("SmartLight: on AlarmKlaxon " + AlarmKlaxon.smartLight);
        if (AlarmKlaxon.smartLight != null) {
            Logger.logInfo("SmartLight: off? " + AlarmKlaxon.smartLight);
            if (SharedApplicationContext.getSettings().isSmartlightLightUpAfterSnooze()) {
                Logger.logInfo("SmartLight: sunriseFull ");
                AlarmKlaxon.smartLight.sunriseFull();
            } else {
                Logger.logInfo("SmartLight: off ");
                AlarmKlaxon.smartLight.off(true);
            }
        }
        SharedApplicationContext.getSettings().setLastSnooze(i);
    }

    private static void requestAlarmSoundStop(Context context) {
        Intent intent = new Intent(context.getApplicationContext(), (Class<?>) AlarmKlaxon.class);
        intent.setAction("com.urbandroid.sleep.alarmclock.ALARM_ALERT");
        context.stopService(intent);
    }

    public static int resolveSmartPeriod(Context context, Alarm alarm) {
        int i = alarm.nonDeepsleepWakeupWindow;
        return i >= 0 ? i : new Settings(context).getSmartWakeupMinutes();
    }

    public static int resolveSoundDelay(Context context, Alarm alarm, boolean z) {
        Settings settings = new Settings(context);
        if (!settings.isSoundDelayAfterSnooze() && z) {
            return 0;
        }
        if (alarm == null) {
            return settings.getSoundDelay();
        }
        Integer soundDelay = alarm.extendedConfig.getSoundDelay();
        return soundDelay.intValue() == -2 ? new Settings(context).getSoundDelay() : soundDelay.intValue();
    }

    public static int resolveVibrationSetting(Context context, Alarm alarm, boolean z) {
        int iResolveVibrationSettingIgnoreSnooze = resolveVibrationSettingIgnoreSnooze(context, alarm);
        if (iResolveVibrationSettingIgnoreSnooze > 0 && Experiments.getInstance().isNoDelayInSnooze() && z) {
            return 0;
        }
        return iResolveVibrationSettingIgnoreSnooze;
    }

    public static int resolveVibrationSettingIgnoreSnooze(Context context, Alarm alarm) {
        if (alarm == null) {
            return new Settings(context).getGradualVibration();
        }
        Integer vibrationStart = alarm.extendedConfig.getVibrationStart();
        if (vibrationStart == null && !alarm.legacyVibrate) {
            vibrationStart = -1;
        }
        return (vibrationStart == null || vibrationStart.intValue() == -2) ? new Settings(context).getGradualVibration() : vibrationStart.intValue();
    }

    private static boolean shouldDeleteAlarm(Alarm alarm) {
        if (alarm == null || alarm.id == -1) {
            return false;
        }
        return alarm.extendedConfig.isSelfDisposable().booleanValue();
    }

    public static void showSnoozeNotification(Context context, Alarm alarm, int i) {
        String string = context.getString(R.string.alarm_notify_snooze_label, alarm.getLabelOrDefault(context));
        Intent intent = new Intent(context, (Class<?>) AlarmReceiver.class);
        intent.setAction("com.urbandroid.sleep.alarmclock.cancel_snooze");
        intent.putExtra("alarm_id", alarm.id);
        intent.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        String string2 = context.getString(R.string.alarm_alert_snooze_set, Integer.valueOf(i));
        PendingIntent explicitBroadcast = PendingIntentBuilder.get(context, alarm.id, intent, ClientDefaults.MAX_MSG_SIZE).getExplicitBroadcast();
        if (Build.VERSION.SDK_INT >= 29) {
            Logger.logInfo("CancelSnooze: Fix for Android Q background activity");
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            intent.setComponent(new ComponentName(context.getPackageName(), SkipNextAlarmActivity.class.getName()));
            explicitBroadcast = PendingIntentBuilder.get(context, alarm.id, intent, ClientDefaults.MAX_MSG_SIZE).getActivity();
        }
        NotificationManagerCompat.from(context);
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(context, "alarmNormalChannel").setContentIntent(explicitBroadcast).setContentTitle(string).setColor(ColorUtil.i(context, R.color.tint_notification)).addAction(new NotificationCompat.Action(R.drawable.ic_action_cancel, context.getResources().getString(R.string.alarm_alert_dismiss_text), explicitBroadcast)).setContentTitle(string2).setContentText(context.getString(R.string.touch_to_stop));
        contentText.setSmallIcon(R.drawable.ic_action_snooze_white);
        if (SharedApplicationContext.getSettings().getCaptchaInfo(alarm) == null) {
            contentText.setAutoCancel(true);
        }
        NotificationsKt.notify(context, alarm.id, contentText.build());
    }

    public static Snackbar showSnoozeSnackbar(ViewGroup viewGroup, final Context context) {
        Alarm alarm;
        long snoozeTime = Alarms.getSnoozeTime(context);
        int snoozeAlarmId = Alarms.getSnoozeAlarmId(context);
        if (snoozeTime == -1 || snoozeAlarmId == -1 || snoozeTime <= System.currentTimeMillis() || (alarm = Alarms.getAlarm(context.getContentResolver(), snoozeAlarmId)) == null) {
            return null;
        }
        String string = context.getString(R.string.step_alarm_snoozing, DateUtil.formatTime(context, snoozeTime));
        final Intent intent = new Intent(context, (Class<?>) AlarmReceiver.class);
        intent.setAction("com.urbandroid.sleep.alarmclock.cancel_snooze");
        intent.putExtra("alarm_id", alarm.id);
        intent.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        Snackbar action = Snackbar.make(viewGroup, string, -2).setAction(R.string.alarm_alert_dismiss_text, new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.Alarm.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ContextExtKt.sendExplicitBroadcast(context, intent);
            }
        });
        action.show();
        return action;
    }

    public static String toDebugString(Alarm alarm) {
        if (alarm == null) {
            return "NULL alarm";
        }
        return "Alarm: " + alarm.id + " T: " + alarm.time + " D: " + new Date(alarm.time) + " H: " + alarm.hour + " M: " + alarm.minutes + " Vibe: " + alarm.extendedConfig.getVibrationStart() + " SoundDelay: " + alarm.extendedConfig.getSoundDelay() + " WatchVibeDelay: " + alarm.extendedConfig.getVibrationStartSmartWatch() + " Bedtime: " + alarm.extendedConfig.getTimeToBed() + " Ideal: " + alarm.extendedConfig.getIdealSleepMinutes() + " Snooze(duration: " + alarm.extendedConfig.getSnoozeDuration() + "  limit: " + alarm.extendedConfig.getSnoozeLimit() + " total time: " + alarm.extendedConfig.getSnoozeTotalTimeLimit() + " after alarm: " + alarm.extendedConfig.getSnoozeAfterAlarm() + ") SmartWindow: " + alarm.nonDeepsleepWakeupWindow + " NonWeekly: " + alarm.extendedConfig.getNonWeeklyFrom() + " " + alarm.extendedConfig.getNonWeeklyRepeat() + " Days " + alarm.getDaysOfWeek() + " Suspend: " + alarm.suspendTime + " Offset: " + alarm.extendedConfig.getOffsetInMinutes() + " Terminate: " + alarm.extendedConfig.isTerminatesTracking() + " Captcha: " + alarm.captcha + " WakeUpCheck: " + alarm.extendedConfig.getWakeUpCheck() + " Disp: " + alarm.extendedConfig.isSelfDisposable();
    }

    public void addOffset(int i, long j) {
        if (this.extendedConfig == null) {
            this.extendedConfig = new AlarmExtendedConfig();
        }
        StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i, "Alarm: addOffset min ", " valid till ");
        sbM65m.append(new Date(j));
        Logger.logInfo(sbM65m.toString());
        this.extendedConfig.setOffsetInMinutes(Integer.valueOf(i));
        this.extendedConfig.setOffsetValidTill(Long.valueOf(j));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DaysOfWeek getDaysOfWeek() {
        return this.daysOfWeek;
    }

    public long getEarliesWakeTime(SleepRecord sleepRecord) {
        boolean zIsNotBeforeIdeal = SharedApplicationContext.getSettings().isNotBeforeIdeal();
        int idealSleepMinutes = SharedApplicationContext.getSettings().getIdealSleepMinutes();
        int smartWakeupMinutes = this.nonDeepsleepWakeupWindow;
        if (smartWakeupMinutes == -1) {
            smartWakeupMinutes = SharedApplicationContext.getSettings().getSmartWakeupMinutes();
        }
        long j = this.time;
        if (smartWakeupMinutes == 0) {
            return j;
        }
        long j2 = j - ((long) (smartWakeupMinutes * 60000));
        if (!zIsNotBeforeIdeal || sleepRecord == null) {
            return j2;
        }
        long j3 = idealSleepMinutes * 60000;
        long jMin = Math.min(Math.max(j2, sleepRecord.getFromTime() + j3), this.time);
        Logger.logInfo("Earliest: SMART " + new Date(jMin) + " ACT " + new Date(sleepRecord.getFromTime() + j3) + " ALARM " + new Date(this.time));
        return jMin;
    }

    public int getGradualVolumeIncrease(Context context) {
        Integer gradualVolumeIncrease = this.extendedConfig.getGradualVolumeIncrease();
        return (gradualVolumeIncrease == null || gradualVolumeIncrease.intValue() == -2) ? new Settings(context).getGradualVolumeIncreaseDuration() : gradualVolumeIncrease.intValue();
    }

    public String getLabelOrDefault(Context context) {
        String str = this.label;
        return (str == null || str.length() == 0) ? context.getString(R.string.default_label) : this.label;
    }

    public int getOffset(long j) {
        AlarmExtendedConfig alarmExtendedConfig = this.extendedConfig;
        if (alarmExtendedConfig == null || alarmExtendedConfig.getOffsetInMinutes() == null || this.extendedConfig.getOffsetInMinutes().intValue() == 0 || this.extendedConfig.getOffsetValidTill() == null || this.extendedConfig.getOffsetValidTill().longValue() <= j) {
            return 0;
        }
        return this.extendedConfig.getOffsetInMinutes().intValue();
    }

    public int getOffsetHour(Context context, long j) {
        return getOffsetCalendar(context, j).get(11);
    }

    public int getOffsetMinutes(Context context, long j) {
        return getOffsetCalendar(context, j).get(12);
    }

    public int getSmartWatchVibrationDelay(Context context) {
        Integer vibrationStartSmartWatch = this.extendedConfig.getVibrationStartSmartWatch();
        return (vibrationStartSmartWatch == null || vibrationStartSmartWatch.intValue() == -2) ? new Settings(context).getGradualVibrationSmartwatch() : vibrationStartSmartWatch.intValue();
    }

    public String getTimeWithOffsetAsString(Context context) {
        return DateUtil.formatTimeNeverAmPm(context, getOffsetCalendar(context, System.currentTimeMillis()).getTimeInMillis());
    }

    public String getTimeWithoutOffsetAsString() {
        return this.hour + ":" + this.minutes;
    }

    public int getWeekRepeat() {
        AlarmExtendedConfig alarmExtendedConfig = this.extendedConfig;
        if (alarmExtendedConfig == null || alarmExtendedConfig.getWeekRepeat() == null) {
            return 0;
        }
        return this.extendedConfig.getWeekRepeat().intValue();
    }

    public boolean isFixedSystemVolume(Context context) {
        return getGradualVolumeIncrease(context) <= 30000;
    }

    public boolean isGradualVolumeIncrease(Context context) {
        return getGradualVolumeIncrease(context) >= 30000;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        this.id = objectInput.readInt();
        this.enabled = objectInput.readInt() == 1;
        this.hour = objectInput.readInt();
        this.minutes = objectInput.readInt();
        this.daysOfWeek = new DaysOfWeek(objectInput.readInt());
        this.time = objectInput.readLong();
        this.suspendTime = objectInput.readLong();
        this.nonDeepsleepWakeupWindow = objectInput.readInt();
        this.captcha = objectInput.readInt();
        this.legacyVibrate = objectInput.readInt() == 1;
        this.label = objectInput.readUTF();
        String utf = objectInput.readUTF();
        this.silent = objectInput.readInt() == 1;
        parseAlertFromString(utf);
        try {
            this.extendedConfig = (AlarmExtendedConfig) objectInput.readObject();
        } catch (Exception unused) {
            Logger.logDebug("Extended config cannot be loaded.");
        }
        if (this.extendedConfig == null) {
            this.extendedConfig = new AlarmExtendedConfig();
        }
        this.daysOfWeek.setWeekRepeat(getWeekRepeat());
        if (this.extendedConfig.isNonWeekly()) {
            this.daysOfWeek.setNonWeekly(this.extendedConfig.getNonWeeklyFrom().longValue(), this.extendedConfig.getNonWeeklyRepeat().intValue());
        }
    }

    public void recompteOffsetOnAlarmFired(Context context) {
        Date time;
        if (this.extendedConfig.getOffsetInMinutes() == null || this.extendedConfig.getOffsetInMinutes().intValue() == 0 || this.extendedConfig.getOffsetInMinutes().intValue() >= 0 || (time = Alarms.calculateAlarm(context, this.hour, this.minutes, getDaysOfWeek()).getTime()) == null) {
            return;
        }
        long time2 = time.getTime() - System.currentTimeMillis();
        if (time2 <= 0 || time2 > 10800001) {
            return;
        }
        Logger.logInfo("Alarm: Offset maybe correction - skip next " + time);
        long time3 = time.getTime() + 1;
        if (time3 > this.suspendTime) {
            Logger.logInfo("Alarm: Correcting -> " + this.suspendTime);
            this.suspendTime = time3;
            Alarms.suspendAlarm(context, this, time3);
        }
    }

    public void resetOffset() {
        AlarmExtendedConfig alarmExtendedConfig = this.extendedConfig;
        if (alarmExtendedConfig == null || alarmExtendedConfig.getOffsetInMinutes() == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("Alarm: resetOffset min ");
        sb.append(this.minutes);
        sb.append(" valid till ");
        sb.append(this.extendedConfig.getOffsetValidTill() != null ? new Date(this.extendedConfig.getOffsetValidTill().longValue()) : "");
        Logger.logInfo(sb.toString());
        this.extendedConfig.setOffsetInMinutes(null);
        this.extendedConfig.setOffsetValidTill(null);
    }

    public void resetoffsetIfExpired(long j) {
        AlarmExtendedConfig alarmExtendedConfig = this.extendedConfig;
        if (alarmExtendedConfig == null || alarmExtendedConfig.getOffsetValidTill() == null || this.extendedConfig.getOffsetValidTill().longValue() >= j) {
            return;
        }
        resetOffset();
    }

    public byte[] serializeToArray() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(this);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            Logger.logWarning("Failed to serialize alarm", e);
            ErrorReporter.getInstance().generateAssertionError(AssertionType.ALARM_SERIALIZATION_FAILED, "Failed to serialize alarm");
            return new byte[0];
        }
    }

    public void setDaysOfWeek(DaysOfWeek daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public boolean shouldVibrate(Context context) {
        return resolveVibrationSettingIgnoreSnooze(context, this) != -1;
    }

    public String toString() {
        return "Alarm[" + this.id + "] " + DateUtil.formatShortTimeDate(new Date(this.time)) + " " + this.hour + ":" + this.minutes + ",R:" + getDaysOfWeek() + ",S:" + this.suspendTime;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.id);
        objectOutput.writeInt(this.enabled ? 1 : 0);
        objectOutput.writeInt(this.hour);
        objectOutput.writeInt(this.minutes);
        objectOutput.writeInt(getDaysOfWeek().getCoded());
        objectOutput.writeLong(this.time);
        objectOutput.writeLong(this.suspendTime);
        objectOutput.writeInt(this.nonDeepsleepWakeupWindow);
        objectOutput.writeInt(this.captcha);
        objectOutput.writeInt(this.legacyVibrate ? 1 : 0);
        String str = this.label;
        if (str == null) {
            str = "";
        }
        objectOutput.writeUTF(str);
        Uri uri = this.alert;
        objectOutput.writeUTF(uri == null ? "silent" : uri.toString());
        objectOutput.writeInt(this.silent ? 1 : 0);
        objectOutput.writeObject(this.extendedConfig);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.enabled ? 1 : 0);
        parcel.writeInt(this.hour);
        parcel.writeInt(this.minutes);
        parcel.writeInt(getDaysOfWeek().getCoded());
        parcel.writeLong(this.time);
        parcel.writeLong(this.suspendTime);
        parcel.writeInt(this.nonDeepsleepWakeupWindow);
        parcel.writeInt(this.captcha);
        parcel.writeInt(this.legacyVibrate ? 1 : 0);
        parcel.writeString(this.label);
        parcel.writeParcelable(this.alert, i);
        parcel.writeInt(this.silent ? 1 : 0);
        parcel.writeSerializable(this.extendedConfig);
    }

    public int getOffsetHour(Context context) {
        return getOffsetHour(context, System.currentTimeMillis());
    }

    public int getOffsetMinutes(Context context) {
        return getOffsetMinutes(context, System.currentTimeMillis());
    }

    public void resetoffsetIfExpired() {
        resetoffsetIfExpired(System.currentTimeMillis());
    }

    public int getOffset() {
        return getOffset(System.currentTimeMillis());
    }

    public static class DaysOfWeek {
        public static int[] DAY_MAP = {2, 3, 4, 5, 6, 7, 1};
        public static long NON_WEEKLY_START_OF_MONTH = -2;
        private int BITMASK_FRIDAY;
        private int BITMASK_MONDAY;
        private int BITMASK_SATURDAY;
        private int BITMASK_SUNDAY;
        private int BITMASK_THURSDAY;
        private int BITMASK_TUESDAY;
        private int BITMASK_WEDNESDAY;
        private int days;
        private final int defaultStashDays;
        private long nonWeeklyFrom;
        private int nonWeeklyRepeat;
        private int stashDays;
        private int weekRepeat;

        public DaysOfWeek(DaysOfWeek daysOfWeek) {
            this.BITMASK_MONDAY = 1;
            this.BITMASK_TUESDAY = 2;
            this.BITMASK_WEDNESDAY = 4;
            this.BITMASK_THURSDAY = 8;
            this.BITMASK_FRIDAY = 22;
            this.BITMASK_SATURDAY = 50;
            this.BITMASK_SUNDAY = 100;
            this.defaultStashDays = 1 | 2 | 30;
            this.weekRepeat = 0;
            this.nonWeeklyFrom = -1L;
            this.nonWeeklyRepeat = -1;
            this.days = daysOfWeek.days;
            this.weekRepeat = daysOfWeek.weekRepeat;
            this.nonWeeklyFrom = daysOfWeek.nonWeeklyFrom;
            this.nonWeeklyRepeat = daysOfWeek.nonWeeklyRepeat;
        }

        private String getRepeatString(Context context, int i, long j) {
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(context.getString(R.string.alarm_repeat) + " " + context.getString(R.string.every).toLowerCase(), " ");
            sbM.append(StringUtil.countOrder(context, i));
            sbM.append(" ");
            sbM.append(context.getString(j == NON_WEEKLY_START_OF_MONTH ? R.string.day_of_month : R.string.stats_caption_day).toLowerCase());
            return sbM.toString();
        }

        public static int[] getWeekDayPositionIndex(Context context) {
            int firstDayOfWeek = new Settings(context).getFirstDayOfWeek();
            return firstDayOfWeek == 1 ? new int[]{6, 0, 1, 2, 3, 4, 5} : firstDayOfWeek == 7 ? new int[]{5, 6, 0, 1, 2, 3, 4} : firstDayOfWeek == 6 ? new int[]{4, 5, 6, 0, 1, 2, 3} : new int[]{0, 1, 2, 3, 4, 5, 6};
        }

        public static boolean isWeekOdd(Context context, Calendar calendar) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
            calendar2.setFirstDayOfWeek(new Settings(context).getFirstDayOfWeek());
            return calendar2.get(3) % 2 == 1;
        }

        public void clearDays() {
            this.days = 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                DaysOfWeek daysOfWeek = (DaysOfWeek) obj;
                if (this.days == daysOfWeek.days && this.nonWeeklyRepeat == daysOfWeek.nonWeeklyRepeat && this.nonWeeklyFrom == daysOfWeek.nonWeeklyFrom && this.weekRepeat == daysOfWeek.weekRepeat) {
                    return true;
                }
            }
            return false;
        }

        public int getCoded() {
            return this.days;
        }

        public int getNextAlarm(Context context, Calendar calendar) {
            int i = 0;
            if (!isNonWeekly()) {
                if (this.days == 0) {
                    return -1;
                }
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(calendar.getTime());
                while (i < 14) {
                    int i2 = (calendar2.get(7) + 5) % 7;
                    if (isThisWeek(context, calendar2) && isSet(i2)) {
                        break;
                    }
                    calendar2.add(6, 1);
                    i++;
                }
                return i;
            }
            Calendar calendar3 = Calendar.getInstance();
            Calendar calendar4 = Calendar.getInstance();
            calendar4.setTimeInMillis(this.nonWeeklyFrom);
            calendar4.set(11, 0);
            calendar4.set(12, 0);
            calendar4.set(13, 0);
            calendar4.set(14, 0);
            calendar3.setTime(calendar.getTime());
            if (this.nonWeeklyFrom == NON_WEEKLY_START_OF_MONTH) {
                while (true) {
                    if (calendar3.get(5) == this.nonWeeklyRepeat) {
                        break;
                    }
                    calendar3.add(5, 1);
                    i++;
                    if (i > 31) {
                        Logger.logSevere("Repeat: failed to find day of month " + this.nonWeeklyFrom + " " + this.nonWeeklyRepeat + " " + calendar3.getTime());
                        break;
                    }
                }
                zza$$ExternalSyntheticOutline0.m(i, "Repeat: day of month ");
                return i;
            }
            while (true) {
                if (!calendar4.before(calendar3)) {
                    break;
                }
                if (this.nonWeeklyRepeat < 1) {
                    Logger.logSevere("Repeat: this should never happen nonweeklyrepeat is < 1 ");
                    break;
                }
                if (com.urbandroid.sleep.addon.stats.util.DateUtil.isSameDate(calendar4.getTime(), calendar3.getTime())) {
                    return 0;
                }
                calendar4.add(5, this.nonWeeklyRepeat);
            }
            while (!com.urbandroid.sleep.addon.stats.util.DateUtil.isSameDate(calendar4.getTime(), calendar3.getTime())) {
                calendar4.add(5, -1);
                i++;
                if (i > this.nonWeeklyRepeat) {
                    Logger.logWarning("Repeat NonWeekly: Something is wrong with non-weekly " + toString() + " " + i);
                    return -1;
                }
            }
            Logger.logInfo("Repeat: every " + i + " days");
            return i;
        }

        public long getNonWeeklyFrom() {
            return this.nonWeeklyFrom;
        }

        public int getNonWeeklyRepeat() {
            return this.nonWeeklyRepeat;
        }

        public int getWeekRepeat() {
            return this.weekRepeat;
        }

        public int hashCode() {
            return this.days;
        }

        public boolean isCalendarDaySet(int i) {
            int i2 = 0;
            while (true) {
                int[] iArr = DAY_MAP;
                if (i2 >= iArr.length) {
                    return false;
                }
                if (iArr[i2] == i) {
                    return isSet(i2);
                }
                i2++;
            }
        }

        public boolean isNonWeekly() {
            return (this.nonWeeklyFrom == -1 || this.nonWeeklyRepeat == -1) ? false : true;
        }

        public boolean isNonWeeklyDayOfMonth() {
            return this.nonWeeklyFrom == NON_WEEKLY_START_OF_MONTH;
        }

        public boolean isRepeatSet() {
            return this.days != 0 || isNonWeekly();
        }

        public boolean isSet(int i) {
            return (this.days & (1 << i)) > 0;
        }

        public boolean isThisWeek(Context context, Calendar calendar) {
            Settings settings = new Settings(context);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
            calendar2.setFirstDayOfWeek(settings.getFirstDayOfWeek());
            return this.weekRepeat == 0 || calendar2.get(3) % 2 == (this.weekRepeat + (-2)) * (-1);
        }

        public void resetNonWeekly() {
            this.nonWeeklyFrom = -1L;
            this.nonWeeklyRepeat = -1;
        }

        public void set(int i, boolean z) {
            int i2 = this.days;
            if (z) {
                this.days = (1 << i) | i2;
            } else {
                this.days = (~(1 << i)) & i2;
            }
        }

        public void setCalendarDay(int i, boolean z) {
            int i2 = 0;
            while (true) {
                int[] iArr = DAY_MAP;
                if (i2 >= iArr.length) {
                    return;
                }
                if (iArr[i2] == i) {
                    set(i2, z);
                }
                i2++;
            }
        }

        public void setNonWeekly(long j, int i) {
            this.nonWeeklyFrom = j;
            this.nonWeeklyRepeat = i;
        }

        public void setNonWeeklyFrom(long j) {
            this.nonWeeklyFrom = j;
        }

        public void setNonWeeklyRepeat(int i) {
            this.nonWeeklyRepeat = i;
        }

        public void setWeekRepeat(int i) {
            this.weekRepeat = i;
        }

        public void stashDays() {
            int i = this.days;
            if (i <= 0) {
                i = this.defaultStashDays;
            }
            this.stashDays = i;
        }

        public Spannable toSpanneble(Context context, int i, int i2) {
            String str;
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(new Settings(context).getFirstDayOfWeek());
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int[] iArr = DAY_MAP;
                if (i4 >= iArr.length) {
                    i4 = i;
                    break;
                }
                if (iArr[i4] == i) {
                    break;
                }
                i4++;
            }
            if (isNonWeekly()) {
                return new SpannableString("" + toString(context, true));
            }
            if (this.days == 127) {
                isThisWeek(context, calendar);
                SpannableString spannableString = new SpannableString(context.getText(R.string.every_day).toString().toUpperCase());
                int length = spannableString.length();
                if (this.weekRepeat > 0 && !isThisWeek(context, calendar)) {
                    spannableString = new SpannableString(context.getString(R.string.next_week).toUpperCase() + " " + context.getText(R.string.every_day).toString().toUpperCase());
                    i3 = -1;
                }
                if (i3 > -1) {
                    spannableString.setSpan(new ForegroundColorSpan(i2), i3, length, 33);
                }
                return spannableString;
            }
            StringBuilder sb = new StringBuilder();
            int i5 = 0;
            for (int i6 = this.days; i6 > 0; i6 >>= 1) {
                if ((i6 & 1) == 1) {
                    i5++;
                }
            }
            String[] shortWeekdayNames = i5 > 1 ? DateUtil.getShortWeekdayNames() : DateUtil.getLongWeekdayNames();
            int[] weekDayPositionIndex = getWeekDayPositionIndex(context);
            int length2 = -1;
            int length3 = -1;
            for (int i7 = 0; i7 < 7; i7++) {
                int i8 = weekDayPositionIndex[i7];
                if ((this.days & (1 << i8)) != 0) {
                    if (i8 == i4) {
                        str = shortWeekdayNames[DAY_MAP[i8]];
                        length2 = sb.length();
                        length3 = str.length() + sb.length();
                    } else {
                        str = shortWeekdayNames[DAY_MAP[i8]];
                    }
                    sb.append(str);
                    i5--;
                    if (i5 > 0) {
                        sb.append(context.getText(R.string.day_concat));
                    }
                }
            }
            sb.toString().toUpperCase();
            if (this.weekRepeat > 0 && !isThisWeek(context, calendar)) {
                String str2 = context.getString(R.string.next_week).toUpperCase() + ": ";
                sb.insert(0, str2);
                length2 += str2.length();
                length3 = str2.length() + length3;
            }
            int i9 = length3;
            SpannableString spannableString2 = new SpannableString(sb.toString().toUpperCase());
            if (length2 > -1) {
                spannableString2.setSpan(new ForegroundColorSpan(i2), length2, i9, 33);
                spannableString2.setSpan(new StyleSpan(1), length2, i9, 33);
            }
            return spannableString2;
        }

        public String toString(Context context, boolean z) {
            StringBuilder sb = new StringBuilder();
            if (isNonWeekly()) {
                return getRepeatString(context, this.nonWeeklyRepeat, this.nonWeeklyFrom);
            }
            int i = this.days;
            String string = "";
            if (i == 0) {
                return z ? context.getText(R.string.one_time).toString() : "";
            }
            int i2 = R.string.next_week;
            if (i == 127) {
                if (this.weekRepeat > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    if (isThisWeek(context, Calendar.getInstance())) {
                        i2 = R.string.this_week;
                    }
                    sb2.append(context.getString(i2));
                    sb2.append(": ");
                    string = sb2.toString();
                }
                StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(string);
                sbM.append(context.getText(R.string.every_day).toString());
                return sbM.toString();
            }
            int i3 = 0;
            while (i > 0) {
                if ((i & 1) == 1) {
                    i3++;
                }
                i >>= 1;
            }
            String[] shortWeekdayNames = i3 > 1 ? DateUtil.getShortWeekdayNames() : DateUtil.getLongWeekdayNames();
            int[] weekDayPositionIndex = getWeekDayPositionIndex(context);
            for (int i4 = 0; i4 < 7; i4++) {
                int i5 = weekDayPositionIndex[i4];
                if ((this.days & (1 << i5)) != 0) {
                    sb.append(shortWeekdayNames[DAY_MAP[i5]]);
                    i3--;
                    if (i3 > 0) {
                        sb.append(context.getText(R.string.day_concat));
                    }
                }
            }
            if (this.weekRepeat > 0) {
                StringBuilder sb3 = new StringBuilder();
                if (isThisWeek(context, Calendar.getInstance())) {
                    i2 = R.string.this_week;
                }
                sb3.append(context.getString(i2).toUpperCase());
                sb3.append(": ");
                sb.insert(0, sb3.toString());
            }
            return sb.toString().toUpperCase();
        }

        public void unstashDays() {
            int i = this.stashDays;
            if (i <= 0) {
                i = this.defaultStashDays;
            }
            this.days = i;
        }

        public DaysOfWeek(int i, int i2) {
            this.BITMASK_MONDAY = 1;
            this.BITMASK_TUESDAY = 2;
            this.BITMASK_WEDNESDAY = 4;
            this.BITMASK_THURSDAY = 8;
            this.BITMASK_FRIDAY = 22;
            this.BITMASK_SATURDAY = 50;
            this.BITMASK_SUNDAY = 100;
            this.defaultStashDays = 1 | 2 | 30;
            this.nonWeeklyFrom = -1L;
            this.nonWeeklyRepeat = -1;
            this.days = i;
            this.weekRepeat = i2;
        }

        public DaysOfWeek(int i) {
            this(i, 0);
        }

        public String toString() {
            String strM;
            StringBuilder sb = new StringBuilder();
            sb.append(this.days);
            String strM2 = "";
            if (this.weekRepeat > 0) {
                strM = FileInsert$$ExternalSyntheticOutline0.m(this.weekRepeat, "", new StringBuilder(" WEEK: "));
            } else {
                strM = "";
            }
            sb.append(strM);
            if (isNonWeekly()) {
                StringBuilder sb2 = new StringBuilder(" NON WEEKLY: from ");
                sb2.append(new Date(this.nonWeeklyFrom));
                sb2.append(" repeat ");
                strM2 = FileInsert$$ExternalSyntheticOutline0.m(this.nonWeeklyRepeat, "", sb2);
            }
            sb.append(strM2);
            return sb.toString();
        }
    }

    public Alarm(Cursor cursor) {
        this.extendedConfig = new AlarmExtendedConfig();
        this.id = cursor.getInt(0);
        this.enabled = cursor.getInt(5) == 1;
        this.hour = cursor.getInt(1);
        this.minutes = cursor.getInt(2);
        long j = cursor.getLong(4);
        this.time = j;
        if (j != 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(this.time));
            if (calendar.get(1) > 2050) {
                Logger.logSevere("Weird alarm time.. " + calendar + " Resetting down to 2050.");
                calendar.set(1, 2050);
                this.time = calendar.getTimeInMillis();
            }
        }
        this.legacyVibrate = cursor.getInt(6) == 1;
        this.label = cursor.getString(7);
        this.suspendTime = cursor.isNull(9) ? -1L : cursor.getLong(9);
        this.nonDeepsleepWakeupWindow = cursor.isNull(10) ? -1 : cursor.getInt(10);
        this.captcha = cursor.isNull(11) ? -1 : cursor.getInt(11);
        parseAlertFromString(cursor.getString(8));
        this.extendedConfig = (AlarmExtendedConfig) DbEncodingUtils.decodeSerializableIntoByteArray(cursor.getBlob(12));
        this.daysOfWeek = new DaysOfWeek(cursor.getInt(3), getWeekRepeat());
        if (this.extendedConfig == null) {
            this.extendedConfig = new AlarmExtendedConfig();
        }
        if (this.extendedConfig.isNonWeekly()) {
            this.daysOfWeek.setNonWeekly(this.extendedConfig.getNonWeeklyFrom().longValue(), this.extendedConfig.getNonWeeklyRepeat().intValue());
        }
    }

    public Alarm() {
        this.extendedConfig = new AlarmExtendedConfig();
        this.id = -1;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        this.hour = calendar.get(11);
        this.minutes = calendar.get(12);
        this.legacyVibrate = true;
        this.daysOfWeek = new DaysOfWeek(0);
        this.nonDeepsleepWakeupWindow = -1;
        this.captcha = -1;
        this.suspendTime = -1L;
        this.extendedConfig = new AlarmExtendedConfig();
    }
}
