package com.urbandroid.sleep.alarmclock;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.format.DateFormat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.AppEventsConstants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.DbEncodingUtils;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SkipNextAlarmActivity;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.SetAlarmCache;
import com.urbandroid.sleep.alarmclock.lockedboot.LockedBootReceiver;
import com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecords;
import com.urbandroid.sleep.domain.achievement.Achievement;
import com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailActivity;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.google.calendar.JavahelpersKt;
import com.urbandroid.sleep.service.google.calendar.LastCalendarAlarmChecker;
import com.urbandroid.util.AlarmManagerCompat;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.Experiments;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.achartengine.chart.TimeChart;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Alarms {
    private static final SetAlarmCache cache = new SetAlarmCache();

    public static long addAlarm(Context context, Alarm alarm, boolean z) {
        if (alarm.enabled) {
            alarm.extendedConfig.setLastEnableTimestamp(Long.valueOf(System.currentTimeMillis()));
        }
        Uri uriInsert = context.getContentResolver().insert(Alarm.Columns.CONTENT_URI, createContentValues(context, alarm, !z));
        if (z) {
            alarm.id = (int) ContentUris.parseId(uriInsert);
        }
        long jCalculateAlarm = calculateAlarm(context, alarm);
        if (alarm.enabled) {
            clearSnoozeIfNeeded(context, jCalculateAlarm);
        }
        setNextAlert(context);
        return jCalculateAlarm;
    }

    public static void addOffset(Context context, Alarm alarm, int i, long j) {
        if (i == 0) {
            Logger.logInfo("Alarms: reset offset because set to 0");
            alarm.resetOffset();
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        Calendar calendarCalculateAlarm = calculateAlarm(context, alarm.hour, alarm.minutes, alarm.getDaysOfWeek(), calendar);
        Logger.logInfo("Alarms: offset valid till " + calendarCalculateAlarm);
        long timeInMillis = (((long) i) * 60000) + calendarCalculateAlarm.getTimeInMillis();
        Logger.logInfo("Alarms: offset valid till " + new Date(timeInMillis) + " from " + new Date(j) + " now " + new Date(System.currentTimeMillis()));
        alarm.addOffset(i, timeInMillis);
        Calendar calendarCalculateAlarm2 = calculateAlarm(context, alarm.getOffsetHour(context), alarm.getOffsetMinutes(context), alarm.getDaysOfWeek());
        Logger.logInfo("Alarms: addOffset next alarm " + calendarCalculateAlarm.getTime() + " next offset alarm " + calendarCalculateAlarm2.getTime());
        if (i > 0) {
            if (calendarCalculateAlarm2.getTimeInMillis() >= calendarCalculateAlarm.getTimeInMillis()) {
                setSuspendTime(alarm, -1L);
                return;
            }
            setSuspendTime(alarm, calendarCalculateAlarm2.getTimeInMillis() + 1);
            Logger.logInfo("Alarms: addOffset adding suspend time " + new Date(alarm.suspendTime));
        }
    }

    public static void addQuickAlarm(Context context, int i, String str, boolean z) {
        Settings settings = new Settings(context);
        Calendar calendar = Calendar.getInstance();
        calendar.add(12, i);
        Alarm alarm = new Alarm();
        alarm.enabled = true;
        alarm.extendedConfig.setSelfDisposable(Boolean.TRUE);
        alarm.extendedConfig.setVibrationStart(-2);
        alarm.extendedConfig.setVibrationStartSmartWatch(-2);
        alarm.extendedConfig.setSoundDelay(-2);
        alarm.hour = calendar.get(11);
        alarm.label = str;
        alarm.minutes = calendar.get(12);
        if (z) {
            alarm.nonDeepsleepWakeupWindow = settings.getSmartWakeupNapMinutes();
        }
        alarm.time = calendar.getTimeInMillis();
        alarm.alert = Uri.parse("android.resource://com.urbandroid.sleep/raw/default");
        alarm.silent = false;
        fixPowerNapRealSchedule(alarm);
        addAlarm(context, alarm);
    }

    public static void allInOneDismissWithCaptcha(Context context) {
        Alarm alarmCalculateNextAlertIncludingSnooze = calculateNextAlertIncludingSnooze(context);
        boolean z = isSnoozing(context) && getSnoozeTime(context) > System.currentTimeMillis();
        if (alarmCalculateNextAlertIncludingSnooze != null) {
            if (!z) {
                if (alarmCalculateNextAlertIncludingSnooze.enabled) {
                    skipAlarmOrShowCaptcha(context, alarmCalculateNextAlertIncludingSnooze);
                }
            } else {
                Intent intent = new Intent(context, (Class<?>) AlarmReceiver.class);
                intent.setAction("com.urbandroid.sleep.alarmclock.cancel_snooze");
                intent.putExtra("alarm_id", alarmCalculateNextAlertIncludingSnooze.id);
                intent.putExtra("intent.extra.alarm_raw", alarmCalculateNextAlertIncludingSnooze.serializeToArray());
                ContextExtKt.sendExplicitBroadcast(context, intent);
            }
        }
    }

    private static Calendar calculateAlarm(Context context, int i, int i2, Alarm.DaysOfWeek daysOfWeek, Calendar calendar) {
        TimeZone.getDefault();
        int i3 = calendar.get(11);
        int i4 = calendar.get(12);
        if (i < i3 || (i == i3 && i2 <= i4)) {
            calendar.add(6, 1);
        }
        calendar.set(11, i);
        calendar.set(12, i2);
        calendar.set(13, 0);
        calendar.set(14, 0);
        int nextAlarm = daysOfWeek.getNextAlarm(context, calendar);
        if (nextAlarm > 0) {
            calendar.add(7, nextAlarm);
        }
        calendar.set(11, i);
        return calendar;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Alarm calculateNextAlert(Context context, long j) {
        Logger.logDebug("Alarms: calculateNextAlert() " + j);
        StringBuilder sb = new StringBuilder("Alarms: Candidates: ");
        Cursor enabledAlarmsCursor = getEnabledAlarmsCursor(context.getContentResolver());
        Alarm alarm = null;
        if (enabledAlarmsCursor != null) {
            if (enabledAlarmsCursor.moveToFirst()) {
                long j2 = Long.MAX_VALUE;
                Alarm alarm2 = null;
                do {
                    Alarm alarm3 = new Alarm(enabledAlarmsCursor);
                    boolean zIsRepeatSet = alarm3.getDaysOfWeek().isRepeatSet();
                    long j3 = alarm3.time;
                    if (zIsRepeatSet) {
                        long jCalculateAlarm = calculateAlarm(context, alarm3);
                        alarm3.time = jCalculateAlarm;
                        if (jCalculateAlarm != j3) {
                            Logger.logDebug("Alarms: has changed " + alarm3.id + " TIME: " + alarm3.time + " Date: " + new Date(alarm3.time));
                            context.getContentResolver().update(ContentUris.withAppendedId(Alarm.Columns.CONTENT_URI, (long) alarm3.id), createContentValues(context, alarm3), null, null);
                        }
                    } else if (j3 < j) {
                        sb.append("[PAST]");
                        sb.append(alarm3);
                        sb.append(";");
                        enableAlarmInternal(context, alarm3, false);
                    }
                    long j4 = alarm3.suspendTime;
                    if (j4 == -1 || j4 < alarm3.time) {
                        if (alarm3.time < j2) {
                            Logger.logDebug("Alarms:This alarm is better (" + alarm3 + " vs " + new Date(j2) + ")");
                            j2 = alarm3.time;
                            alarm2 = alarm3;
                        }
                        sb.append("[A]");
                        sb.append(alarm3);
                        sb.append(";");
                    } else if (alarm3.getDaysOfWeek().isRepeatSet()) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(Math.max(j, alarm3.suspendTime + 1));
                        Logger.logDebug("Alarms:Ignoring suspended alarm: " + Alarm.toDebugString(alarm3));
                        alarm3.time = calculateAlarm(context, alarm3, calendar);
                        Logger.logDebug("Alarms:Next time: " + alarm3);
                        if (alarm3.time < j2) {
                        }
                        sb.append("[A]");
                        sb.append(alarm3);
                        sb.append(";");
                    } else {
                        sb.append("[SR]");
                        sb.append(alarm3);
                        sb.append(";");
                    }
                } while (enabledAlarmsCursor.moveToNext());
                alarm = alarm2;
            }
            enabledAlarmsCursor.close();
        }
        Logger.logDebug(sb.toString());
        Logger.logDebug("Alarms: nextAlert " + Alarm.toDebugString(alarm));
        try {
            Settings settings = SharedApplicationContext.getSettings();
            if (settings != null) {
                settings.resetWakeUpCheckRepeatIfExpired();
            }
        } catch (Exception unused) {
        }
        return alarm;
    }

    public static Alarm calculateNextAlertIncludingSnooze(Context context) {
        Alarm snoozeAlarm = getSnoozeAlarm(context, System.currentTimeMillis());
        return snoozeAlarm != null ? snoozeAlarm : calculateNextAlert(context, System.currentTimeMillis());
    }

    private static void cancelAlarmAllIntents(Context context, String str, int i) {
        Intent intent = new Intent(str);
        PendingIntentBuilder pendingIntentBuilder = PendingIntentBuilder.get(context, i, intent, getPendingIntentFlags());
        pendingIntentBuilder.cancelAlarmBroadcast();
        pendingIntentBuilder.cancelAlarmService();
        PendingIntentBuilder pendingIntentBuilder2 = PendingIntentBuilder.get(context, i, intent, getPendingIntentFlagsLegacy());
        pendingIntentBuilder2.cancelAlarmBroadcast();
        pendingIntentBuilder2.cancelAlarmService();
        Logger.logDebug("Alarms: cancel " + intent.toUri(0));
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        PendingIntentBuilder pendingIntentBuilder3 = PendingIntentBuilder.get(context, i, intent2, getPendingIntentFlags());
        pendingIntentBuilder3.cancelAlarmBroadcast();
        pendingIntentBuilder3.cancelAlarmService();
        PendingIntentBuilder pendingIntentBuilder4 = PendingIntentBuilder.get(context, i, intent2, getPendingIntentFlagsLegacy());
        pendingIntentBuilder4.cancelAlarmBroadcast();
        pendingIntentBuilder4.cancelAlarmService();
        Logger.logDebug("Alarms: cancel " + intent2.toUri(0));
    }

    public static void cancelAntiSnoringNotification(Context context) {
        NotificationsKt.cancel(context, 32937834);
    }

    public static boolean cancelSnooze(Context context, Alarm alarm) {
        int snoozeAlarmId = getSnoozeAlarmId(context);
        if (snoozeAlarmId == -1 || snoozeAlarmId != alarm.id) {
            return false;
        }
        saveSnoozeAlert(context, -1, -1L);
        Logger.logInfo("SnoozeRepeat: reset alarms");
        SharedApplicationContext.getSettings().resetSnoozeRepeat();
        SharedApplicationContext.getSettings().resetWakeUpCheckRepeat();
        Intent intent = new Intent("com.urbandroid.sleep.alarmclock.cancel_snooze_finished");
        intent.putExtra("alarm_id", snoozeAlarmId);
        ContextExtKt.sendExplicitBroadcast(context, intent);
        return true;
    }

    public static void clearExpiredSnooze(Context context, long j) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("AlarmClock", 0);
        if (sharedPreferences.getLong("snooze_time", 0L) < j - 300000) {
            clearSnoozePreference(context, sharedPreferences);
            saveNextAlarm(context, "");
        }
    }

    public static void clearSnoozeIfNeeded(Context context, long j) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("AlarmClock", 0);
        long j2 = sharedPreferences.getLong("snooze_time", 0L);
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("Alarms:Cancel snooze time? ", " <? ", j);
        sbM.append(j2);
        Logger.logDebug(sbM.toString());
        if (j < j2) {
            clearSnoozePreference(context, sharedPreferences);
            saveNextAlarm(context, "");
        }
    }

    private static void clearSnoozePreference(Context context, SharedPreferences sharedPreferences) {
        int i = sharedPreferences.getInt("snooze_id", -1);
        if (i != -1) {
            NotificationManagerCompat.from(context).cancel(i);
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove("snooze_id");
        editorEdit.remove("snooze_time");
        editorEdit.apply();
    }

    private static ContentValues createContentValues(Context context, Alarm alarm, long j, boolean z) {
        ContentValues contentValues = new ContentValues(8);
        long jCalculateAlarm = calculateAlarm(context, alarm, j);
        if (z) {
            contentValues.put("_id", Integer.valueOf(alarm.id));
        }
        contentValues.put("enabled", Integer.valueOf(alarm.enabled ? 1 : 0));
        contentValues.put("hour", Integer.valueOf(alarm.hour));
        contentValues.put("minutes", Integer.valueOf(alarm.minutes));
        contentValues.put("alarmtime", Long.valueOf(jCalculateAlarm));
        contentValues.put("daysofweek", Integer.valueOf(alarm.getDaysOfWeek().getCoded()));
        contentValues.put("vibrate", Boolean.valueOf(alarm.legacyVibrate));
        contentValues.put("message", alarm.label);
        contentValues.put("suspendtime", Long.valueOf(alarm.suspendTime));
        contentValues.put("ndswakeupwindow", Integer.valueOf(alarm.nonDeepsleepWakeupWindow));
        contentValues.put("captcha", Integer.valueOf(alarm.captcha));
        alarm.extendedConfig.setWeekRepeat(Integer.valueOf(alarm.getDaysOfWeek().getWeekRepeat()));
        if (alarm.getDaysOfWeek().isNonWeekly()) {
            alarm.extendedConfig.setNonWeeklyFrom(Long.valueOf(alarm.getDaysOfWeek().getNonWeeklyFrom()));
            alarm.extendedConfig.setNonWeeklyRepeat(Integer.valueOf(alarm.getDaysOfWeek().getNonWeeklyRepeat()));
        }
        alarm.resetoffsetIfExpired(j);
        contentValues.put("generic_extension", DbEncodingUtils.encodeSerializableIntoByteArray(alarm.extendedConfig));
        Uri uri = alarm.alert;
        contentValues.put("alert", uri == null ? "silent" : uri.toString());
        return contentValues;
    }

    public static void deleteAlarm(Context context, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        Logger.logInfo("Alarms:deleteAlarm: " + i);
        disableSnoozeAlert(context, i);
        contentResolver.delete(ContentUris.withAppendedId(Alarm.Columns.CONTENT_URI, (long) i), "", null);
        setNextAlert(context);
    }

    public static void deleteAlarmOrShowCaptcha(Context context, Alarm alarm) {
        if (!isAlarmDisablingLimitedByCaptcha(context, alarm)) {
            deleteAlarm(context, alarm.id);
            return;
        }
        CaptchaInfo captchaInfo = SharedApplicationContext.getSettings().getCaptchaInfo(alarm);
        SharedApplicationContext.getCaptchaManager().getLauncher(alarm).operation("delete_alarm").start(captchaInfo);
        trackCaptchaAchievement(captchaInfo);
    }

    public static boolean disableAlarmOrShowCaptcha(Context context, Alarm alarm) {
        if (!isAlarmDisablingLimitedByCaptcha(context, alarm)) {
            enableAlarmInternal(context, alarm.id, false);
            setNextAlert(context);
            return true;
        }
        CaptchaInfo captchaInfo = SharedApplicationContext.getSettings().getCaptchaInfo(alarm);
        SharedApplicationContext.getCaptchaManager().getLauncher(alarm).operation("disable_alarm").start(captchaInfo);
        trackCaptchaAchievement(captchaInfo);
        return false;
    }

    public static void disableAlert(Context context) {
        Logger.logDebug("Alarms:Disabling alarm");
        cancelAlarmAllIntents(context, "com.urbandroid.sleep.alarmclock.ALARM_ALERT", 72849);
        resetLastScheduledAlarmData();
        setStatusBarIcon(context, false);
        saveNextAlarm(context, "");
        hideAlarmSoonNotification(context, null);
        PendingIntentBuilder.get(context, 0, new Intent("com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALARM_ALERT"), getPendingIntentFlags()).cancelAlarmBroadcast();
        PendingIntentBuilder.get(context, 2, new Intent("com.urbandroid.sleep.alarmclock.AUTO_START_SLEEP_TRACK"), getPendingIntentFlags()).cancelAlarmBroadcast();
        PendingIntentBuilder.get(context, 2, new Intent("com.urbandroid.sleep.alarmclock.AUTO_START_SLEEP_TRACK_BEDTIME"), getPendingIntentFlags()).cancelAlarmBroadcast();
        PendingIntentBuilder.get(context, 0, new Intent("com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALARM_ALERT"), getPendingIntentFlagsLegacy()).cancelAlarmBroadcast();
        PendingIntentBuilder.get(context, 2, new Intent("com.urbandroid.sleep.alarmclock.AUTO_START_SLEEP_TRACK"), getPendingIntentFlagsLegacy()).cancelAlarmBroadcast();
        PendingIntentBuilder.get(context, 2, new Intent("com.urbandroid.sleep.alarmclock.AUTO_START_SLEEP_TRACK_BEDTIME"), getPendingIntentFlagsLegacy()).cancelAlarmBroadcast();
    }

    public static void disableExpiredAlarms(Context context) {
        Cursor enabledAlarmsCursor = getEnabledAlarmsCursor(context.getContentResolver());
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (enabledAlarmsCursor != null) {
            if (enabledAlarmsCursor.moveToFirst()) {
                do {
                    Alarm alarm = new Alarm(enabledAlarmsCursor);
                    if (!alarm.getDaysOfWeek().isRepeatSet() && alarm.time < jCurrentTimeMillis) {
                        enableAlarmInternal(context, alarm, false);
                    }
                } while (enabledAlarmsCursor.moveToNext());
            }
            enabledAlarmsCursor.close();
        }
    }

    public static void disableSnoozeAlert(Context context, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("AlarmClock", 0);
        int i2 = sharedPreferences.getInt("snooze_id", -1);
        if (i2 != -1 && i2 == i) {
            clearSnoozePreference(context, sharedPreferences);
        }
    }

    public static void disableSnoozeAlertHandleCaptcha(Context context, Alarm alarm) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("AlarmClock", 0);
        int i = sharedPreferences.getInt("snooze_id", -1);
        if (i == -1) {
            return;
        }
        if (i == alarm.id) {
            CaptchaInfo captchaInfo = SharedApplicationContext.getSettings().getCaptchaInfo(alarm);
            if (captchaInfo == null) {
                clearSnoozePreference(context, sharedPreferences);
            } else {
                SharedApplicationContext.getCaptchaManager().getLauncher(alarm).operation("snooze_cancel").start(captchaInfo);
                trackCaptchaAchievement(captchaInfo);
            }
        }
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("Alarms:DISABLE "), alarm.id);
    }

    public static void enableAlarm(Context context, int i, boolean z) {
        enableAlarmInternal(context, i, z);
        setNextAlert(context);
    }

    private static void enableAlarmInternal(Context context, Alarm alarm, boolean z) {
        if (alarm == null) {
            return;
        }
        Logger.logDebug("Alarms:Enable int: " + alarm.id + ", " + alarm.time + " -> " + z);
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("enabled", Integer.valueOf(z ? 1 : 0));
        if (!z) {
            contentValues.put("suspendtime", (Integer) (-1));
            alarm.resetOffset();
        }
        if (z) {
            alarm.resetoffsetIfExpired();
            contentValues.put("alarmtime", Long.valueOf(!alarm.getDaysOfWeek().isRepeatSet() ? calculateAlarm(context, alarm) : 0L));
            alarm.extendedConfig.setLastEnableTimestamp(Long.valueOf(System.currentTimeMillis()));
        } else {
            disableSnoozeAlertHandleCaptcha(context, alarm);
            Logger.logInfo("Alarms:SNOOZE DISABLE enableAlarmInternal");
        }
        contentValues.put("generic_extension", DbEncodingUtils.encodeSerializableIntoByteArray(alarm.extendedConfig));
        contentResolver.update(ContentUris.withAppendedId(Alarm.Columns.CONTENT_URI, alarm.id), contentValues, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0236  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void enableAlert(final Context context, final Alarm alarm, long j) {
        Alarm alarm2;
        long j2;
        final int i;
        AlarmManager alarmManager;
        Alarm alarm3;
        Context context2;
        PendingIntentBuilder pendingIntentBuilder;
        PendingIntentBuilder pendingIntentBuilder2;
        long j3;
        final AlarmManager alarmManager2 = (AlarmManager) context.getSystemService("alarm");
        long jFixDayLiteSavingRemove = fixDayLiteSavingRemove(j);
        Logger.logInfo("Alarms:** setAlert id " + alarm.id + " atTime " + new Date(jFixDayLiteSavingRemove));
        Intent intent = new Intent("com.urbandroid.sleep.alarmclock.ALARM_ALERT");
        intent.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        if (Environment.isKitKatOrGreater()) {
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        }
        if (Experiments.getInstance().isLessAlarmReschedulingExperiment()) {
            boolean zShouldSetAlarmNow = cache.shouldSetAlarmNow(SetAlarmCache.SetAlarmType.ALARM, alarm, jFixDayLiteSavingRemove, ContextExtKt.canScheduleExactAlarmsCompat(alarmManager2));
            alarm2 = alarm;
            jFixDayLiteSavingRemove = jFixDayLiteSavingRemove;
            if (!zShouldSetAlarmNow) {
                Logger.logInfo("Skipping setAlarm for alarm id " + alarm2.id + " time " + jFixDayLiteSavingRemove + " (" + new Date(jFixDayLiteSavingRemove) + ")");
                j2 = jFixDayLiteSavingRemove;
            }
            int timeToBed = SharedApplicationContext.getSettings().getTimeToBed(alarm2);
            int i2 = timeToBed >= 0 ? -1 : timeToBed * 60000;
            int iResolveSmartPeriod = Alarm.resolveSmartPeriod(context, alarm);
            Logger.logInfo("Alarms:Enabling alarm: " + new Date(j2) + " Do Bed: " + timeToBed + " Alert: " + alarm2.alert);
            final long perAlarmIdealSleepMinutes = j2 - ((long) (SharedApplicationContext.getSettings().getPerAlarmIdealSleepMinutes(alarm2) * 60000));
            if (SharedApplicationContext.getSettings().isTimeToBedSmart()) {
                long j4 = i2;
                Alarm alarm4 = alarm2;
                scheduleTimeToBed(context, alarmManager2, alarm4, perAlarmIdealSleepMinutes, j4, alarm4.time);
                context2 = context;
                alarm3 = alarm;
                alarmManager = alarmManager2;
                i = iResolveSmartPeriod;
            } else {
                Logger.logInfo("Alarms:Doing smart bedtime");
                final int i3 = i2;
                i = iResolveSmartPeriod;
                AsyncTask<Void, Void, Long> asyncTask = new AsyncTask<Void, Void, Long>() { // from class: com.urbandroid.sleep.alarmclock.Alarms.1
                    @Override // android.os.AsyncTask
                    public Long doInBackground(Void... voidArr) {
                        long trackingDelay = perAlarmIdealSleepMinutes - ((long) SharedApplicationContext.getSettings().getTrackingDelay());
                        int i4 = i;
                        if (i4 > -1) {
                            trackingDelay -= (long) (i4 * 60000);
                        }
                        int iCalculateLastDaysAverageDeficit = new SleepRecords().calculateLastDaysAverageDeficit();
                        if (iCalculateLastDaysAverageDeficit > 0) {
                            int iMin = Math.min(2700000, 60000 * iCalculateLastDaysAverageDeficit);
                            zza$$ExternalSyntheticOutline0.m(iCalculateLastDaysAverageDeficit, iMin, "Alarms:Smart bedtime: 5days avg deficit ", "min, ajdustment ");
                            trackingDelay -= (long) iMin;
                        }
                        return Long.valueOf(trackingDelay);
                    }

                    @Override // android.os.AsyncTask
                    public void onPostExecute(Long l) {
                        Alarms.scheduleTimeToBed(context, alarmManager2, alarm, l.longValue(), i3, alarm.time);
                    }
                };
                alarmManager = alarmManager2;
                alarm3 = alarm;
                context2 = context;
                asyncTask.execute(new Void[0]);
            }
            long j5 = j2 - ((long) ((i + 45) * 60000));
            long jCurrentTimeMillis = System.currentTimeMillis();
            Intent intent2 = new Intent("com.urbandroid.sleep.alarmclock.AUTO_START_SLEEP_TRACK");
            intent2.putExtra("SCHEDULED_AUTO_START", true);
            intent2.putExtra("alarm_id", alarm3.id);
            pendingIntentBuilder = PendingIntentBuilder.get(context2, 2, intent2, getPendingIntentFlags());
            pendingIntentBuilder2 = PendingIntentBuilder.get(context2, 2, intent2, getPendingIntentFlagsLegacy());
            if (i > 0 || 100 + jCurrentTimeMillis >= j5) {
                pendingIntentBuilder.cancelAlarmBroadcast();
                pendingIntentBuilder2.cancelAlarmBroadcast();
                cache.reset(SetAlarmCache.SetAlarmType.AUTO_START);
            } else {
                StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("Alarms:Auto start: at ", " TRACK ", j2);
                sbM.append(new Date(j5));
                sbM.append(" CURRENT ");
                sbM.append(jCurrentTimeMillis);
                Logger.logInfo(sbM.toString());
                if (Experiments.getInstance().isLessAlarmReschedulingExperiment()) {
                    j3 = j5;
                    if (!cache.shouldSetAlarmNow(SetAlarmCache.SetAlarmType.AUTO_START, alarm3, j3, ContextExtKt.canScheduleExactAlarmsCompat(alarmManager))) {
                        Logger.logInfo("Skipping set auto start (cached).");
                    }
                } else {
                    j3 = j5;
                }
                pendingIntentBuilder.cancelAlarmBroadcast();
                pendingIntentBuilder2.cancelAlarmBroadcast();
                setAlarmCompat(alarmManager, 0, j3, pendingIntentBuilder.getExplicitBroadcast());
            }
            setStatusBarIcon(context2, true);
            if (!showAlarmSoonNotificationIfRequired(context, alarm)) {
                hideAlarmSoonNotification(context, alarm);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2);
            saveNextAlarm(context2, formatDayAndTime(context2, calendar));
            SharedApplicationContext.getSettings().setNextAlarm(calendar.getTime());
        }
        alarm2 = alarm;
        Settings settings = new Settings(context);
        if (Experiments.getInstance().isReliableAlarmExperiment()) {
            intent.setPackage(context.getPackageName());
            Intent intent3 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_ALERT");
            intent3.putExtra("intent.extra.alarm_raw", alarm2.serializeToArray());
            intent3.setPackage(context.getPackageName());
            PendingIntentBuilder pendingIntentBuilder3 = PendingIntentBuilder.get(context, 72849, intent3, getPendingIntentFlags());
            pendingIntentBuilder3.cancelAlarmService();
            PendingIntentBuilder.get(context, 72849, intent3, getPendingIntentFlagsLegacy()).cancelAlarmService();
            setAlarmClockCompat(alarmManager2, context, alarm2.id, 0, jFixDayLiteSavingRemove, pendingIntentBuilder3.getForegroundService());
            settings.setReliableAlarmScheduled(true);
        } else {
            settings.setReliableAlarmScheduled(false);
        }
        PendingIntentBuilder pendingIntentBuilder4 = PendingIntentBuilder.get(context, 72849, intent, getPendingIntentFlags());
        pendingIntentBuilder4.cancelAlarmBroadcast();
        PendingIntentBuilder.get(context, 72849, intent, getPendingIntentFlagsLegacy()).cancelAlarmBroadcast();
        setAlarmClockCompat(alarmManager2, context, alarm2.id, 0, jFixDayLiteSavingRemove, pendingIntentBuilder4.getExplicitBroadcast());
        j2 = jFixDayLiteSavingRemove;
        if (Environment.isNOrGreater()) {
            LockedBootReceiver.cancelBackupAlarm(context);
        }
        int timeToBed2 = SharedApplicationContext.getSettings().getTimeToBed(alarm2);
        if (timeToBed2 >= 0) {
        }
        int iResolveSmartPeriod2 = Alarm.resolveSmartPeriod(context, alarm);
        Logger.logInfo("Alarms:Enabling alarm: " + new Date(j2) + " Do Bed: " + timeToBed2 + " Alert: " + alarm2.alert);
        final long perAlarmIdealSleepMinutes2 = j2 - ((long) (SharedApplicationContext.getSettings().getPerAlarmIdealSleepMinutes(alarm2) * 60000));
        if (SharedApplicationContext.getSettings().isTimeToBedSmart()) {
        }
        long j52 = j2 - ((long) ((i + 45) * 60000));
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        Intent intent22 = new Intent("com.urbandroid.sleep.alarmclock.AUTO_START_SLEEP_TRACK");
        intent22.putExtra("SCHEDULED_AUTO_START", true);
        intent22.putExtra("alarm_id", alarm3.id);
        pendingIntentBuilder = PendingIntentBuilder.get(context2, 2, intent22, getPendingIntentFlags());
        pendingIntentBuilder2 = PendingIntentBuilder.get(context2, 2, intent22, getPendingIntentFlagsLegacy());
        if (i > 0) {
            pendingIntentBuilder.cancelAlarmBroadcast();
            pendingIntentBuilder2.cancelAlarmBroadcast();
            cache.reset(SetAlarmCache.SetAlarmType.AUTO_START);
        }
        setStatusBarIcon(context2, true);
        if (!showAlarmSoonNotificationIfRequired(context, alarm)) {
        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        saveNextAlarm(context2, formatDayAndTime(context2, calendar2));
        SharedApplicationContext.getSettings().setNextAlarm(calendar2.getTime());
    }

    private static Alarm enableSnoozeAlert(Context context, long j) {
        Alarm snoozeAlarm = getSnoozeAlarm(context, j);
        if (snoozeAlarm == null) {
            return null;
        }
        Alarm.showSnoozeNotification(context, snoozeAlarm, SharedApplicationContext.getSettings().getLastSnoozeMinutes());
        enableAlert(context, snoozeAlarm, snoozeAlarm.time);
        return snoozeAlarm;
    }

    public static void fireSmartAlarm(Context context, Alarm alarm) {
        Logger.logDebug("Alarms: Firing smart alarm");
        SharedApplicationContext.getInstance().getSleepRestarter().disableRestarting();
        if (!Experiments.getInstance().isReliableAlarmExperiment()) {
            resetLastScheduledAlarmData();
            Logger.logDebug("Alarms:Broadcasting ALARM_ALERT intent");
            Intent intent = new Intent("com.urbandroid.sleep.alarmclock.ALARM_ALERT");
            intent.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
            if (Environment.isKitKatOrGreater()) {
                intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            }
            ContextExtKt.sendExplicitBroadcast(context, intent);
            cancelAlarmAllIntents(context, "com.urbandroid.sleep.alarmclock.ALARM_ALERT", 72849);
            return;
        }
        Intent intent2 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_ALERT");
        intent2.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        intent2.setPackage(context.getPackageName());
        if (Environment.isKitKatOrGreater()) {
            intent2.addFlags(ClientDefaults.MAX_MSG_SIZE);
        }
        Logger.logInfo("Alarms:Broadcasting ALARM_ALERT intent");
        ContextExtKt.startForegroundServiceWithLog(context, intent2);
        cancelAlarmAllIntents(context, "com.urbandroid.sleep.alarmclock.ALARM_ALERT", 72849);
        resetLastScheduledAlarmData();
    }

    public static long fixDayLiteSavingRemove(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        try {
            CharSequence charSequence = DateFormat.format("yyyyMMddhhmm", calendar.getTimeInMillis());
            calendar.add(11, -1);
            CharSequence charSequence2 = DateFormat.format("yyyyMMddhhmm", calendar.getTimeInMillis());
            if (!charSequence.equals(charSequence2)) {
                return j;
            }
            Logger.logSevere("Fixing DLS hour " + ((Object) charSequence) + " " + ((Object) charSequence2) + " " + j + " " + calendar.getTimeInMillis());
            return calendar.getTimeInMillis();
        } catch (Exception unused) {
            return j;
        }
    }

    private static void fixPowerNap(Alarm alarm, boolean z) {
        if (Alarm.isPowerNap(alarm)) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, alarm.hour);
            calendar.set(12, alarm.minutes);
            calendar.add(12, z ? 59 : -59);
            alarm.hour = calendar.get(11);
            alarm.minutes = calendar.get(12);
        }
    }

    public static void fixPowerNapDisplayTime(Alarm alarm) {
        fixPowerNap(alarm, false);
    }

    public static void fixPowerNapRealSchedule(Alarm alarm) {
        fixPowerNap(alarm, true);
    }

    public static String formatAlarmText(Context context, Alarm alarm, Long l) {
        if (alarm == null && l == null) {
            return context.getString(R.string.instructions_no_alarm);
        }
        if (l != null) {
            return context.getString(R.string.step_alarm_snoozing, DateUtil.formatTime(context, l.longValue()));
        }
        long earliesWakeTime = alarm.getEarliesWakeTime(CurrentSleepRecord.getInstance().getRecord());
        long j = alarm.time;
        String time = earliesWakeTime >= j ? DateUtil.formatTime(context, j) : context.getString(R.string.notrans_step_alarm_wake_at_range, DateUtil.formatTime(context, earliesWakeTime).replaceAll(" AM", "am").replaceAll(" PM", "pm"), DateUtil.formatTime(context, alarm.time).replaceAll(" AM", "am").replaceAll(" PM", "pm"));
        if (earliesWakeTime - System.currentTimeMillis() <= TimeChart.DAY) {
            return time;
        }
        return context.getString(R.string.instructions_no_alarm) + " (" + context.getString(R.string.next) + ": " + DateUtil.formatDay(alarm.time) + " " + time + ")";
    }

    private static String formatDayAndTime(Context context, Calendar calendar) {
        return calendar == null ? "" : (String) DateFormat.format(get24HourMode(context) ? "E k:mm" : "E h:mm aa", calendar);
    }

    public static String formatTime(Context context, long j) {
        return DateFormat.format(new Settings(context).is24HourFormat() ? "k:mm" : "h:mm aa", new Date(j)).toString();
    }

    public static boolean get24HourMode(Context context) {
        return new Settings(context).is24HourFormat();
    }

    public static Alarm getAlarm(ContentResolver contentResolver, int i) {
        Cursor cursorQuery = contentResolver.query(ContentUris.withAppendedId(Alarm.Columns.CONTENT_URI, i), AlarmColumns.ALARM_QUERY_COLUMNS, null, null, null);
        if (cursorQuery != null) {
            alarm = cursorQuery.moveToFirst() ? new Alarm(cursorQuery) : null;
            cursorQuery.close();
        }
        return alarm;
    }

    public static Alarm getAlarmByLabel(ContentResolver contentResolver, String str, boolean z) {
        Uri uri = Alarm.Columns.CONTENT_URI;
        String[] strArr = AlarmColumns.ALARM_QUERY_COLUMNS;
        StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("message = \"", str, "\" AND enabled = ");
        sbM5m.append(z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Cursor cursorQuery = contentResolver.query(uri, strArr, sbM5m.toString(), null, null);
        if (cursorQuery != null) {
            alarm = cursorQuery.moveToFirst() ? new Alarm(cursorQuery) : null;
            cursorQuery.close();
        }
        return alarm;
    }

    public static Cursor getAlarmsCursor(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("message like ? ");
        arrayList.add("%" + str + "%");
        for (Integer num : parseNumberFromString(str)) {
            sb.append("or hour = ? or minutes= ?");
            arrayList.add(String.valueOf(num));
            arrayList.add(String.valueOf(num));
            if (num.intValue() < 13) {
                sb.append("or hour = ?");
                arrayList.add(String.valueOf(num.intValue() + 12));
            }
        }
        return context.getContentResolver().query(Alarm.Columns.CONTENT_URI, AlarmColumns.ALARM_QUERY_COLUMNS, sb.toString(), (String[]) arrayList.toArray(new String[0]), new Settings(context).isAlarmSortByDay() ? "enabled DESC, CASE enabled WHEN 1 THEN alarmtime ELSE (hour* 60 + minutes) END" : "hour, minutes ASC");
    }

    public static Cursor getEnabledAlarmsCursor(ContentResolver contentResolver) {
        return contentResolver.query(Alarm.Columns.CONTENT_URI, AlarmColumns.ALARM_QUERY_COLUMNS, "enabled=1", null, null);
    }

    private static long getLastShownSoonAlarmTime(Context context) {
        return context.getSharedPreferences("AlarmClock", 0).getLong("last_shown_soon_alarm", -1L);
    }

    public static int getPendingIntentFlags() {
        return 201326592;
    }

    public static int getPendingIntentFlagsLegacy() {
        return 134217728;
    }

    private static Alarm getSnoozeAlarm(Context context, long j) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("AlarmClock", 0);
        int i = sharedPreferences.getInt("snooze_id", -1);
        if (i == -1) {
            return null;
        }
        long j2 = sharedPreferences.getLong("snooze_time", -1L);
        Alarm alarm = getAlarm(context.getContentResolver(), i);
        if (alarm == null || j2 < j - 60000) {
            return null;
        }
        alarm.time = j2;
        return alarm;
    }

    public static int getSnoozeAlarmId(Context context) {
        return context.getSharedPreferences("AlarmClock", 0).getInt("snooze_id", -1);
    }

    public static long getSnoozeTime(Context context) {
        return context.getSharedPreferences("AlarmClock", 0).getLong("snooze_time", -1L);
    }

    private static String getStackTrace(int i) {
        return "";
    }

    public static boolean hasCaptcha(Context context, Alarm alarm) {
        return ((alarm == null || alarm.captcha == -1) && new Settings(context).getDefaultCaptchaId() == 0) ? false : true;
    }

    public static void hideAlarmSoonNotification(Context context, Alarm alarm) {
        try {
            NotificationManagerCompat.from(context).cancel(993273701);
        } catch (Exception e) {
            Logger.logSevere("hideAlarmSoonNotification: ", e);
        }
        if (alarm == null) {
            PendingIntentBuilder.get(context, 993273703, new Intent("com.urbandroid.sleep.alarmclock.SHOW_SKIP_NEXT_ALARM_ACTION"), getPendingIntentFlags()).cancelAlarmBroadcast();
            PendingIntentBuilder.get(context, 993273703, new Intent("com.urbandroid.sleep.alarmclock.SHOW_SKIP_NEXT_ALARM_ACTION"), getPendingIntentFlagsLegacy()).cancelAlarmBroadcast();
            cache.reset(SetAlarmCache.SetAlarmType.SHOW_SKIP);
        }
    }

    public static boolean isAlarmDisablingLimitedByCaptcha(Context context, Alarm alarm) {
        boolean z = false;
        if (SharedApplicationContext.getSettings().getCaptchaInfo(alarm) == null) {
            return false;
        }
        long lastCaptchaSolvedTimestamp = SharedApplicationContext.getSettings().getLastCaptchaSolvedTimestamp();
        if (lastCaptchaSolvedTimestamp != 0 && lastCaptchaSolvedTimestamp > System.currentTimeMillis() - AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED && !Experiments.getInstance().isOurExperimentalPhone()) {
            Logger.logInfo("CAPTCHA: no need for captcha, solved lately");
            return false;
        }
        Logger.logInfo("CAPTCHA: not solved lately");
        if (alarm == null) {
            Logger.logInfo("CAPTCHA: null alarm");
            return false;
        }
        if (alarm.id != -1 && getSnoozeAlarmId(context) == alarm.id) {
            Logger.logInfo("CAPTCHA: alarm snoozed");
            return true;
        }
        if (!alarm.enabled) {
            Logger.logInfo("CAPTCHA: alarm disabled");
            return false;
        }
        if (alarm.extendedConfig.getLastEnableTimestamp() != null && alarm.extendedConfig.getLastEnableTimestamp().longValue() != 0 && alarm.extendedConfig.getLastEnableTimestamp().longValue() > System.currentTimeMillis() - 1800000 && !Experiments.getInstance().isOurExperimentalPhone()) {
            Logger.logInfo("CAPTCHA: alarm enabled recently");
            return false;
        }
        long jCalculateAlarm = calculateAlarm(context, alarm);
        if (jCalculateAlarm > System.currentTimeMillis() && jCalculateAlarm - 1800000 < System.currentTimeMillis()) {
            z = true;
        }
        zza$$ExternalSyntheticOutline0.m("CAPTCHA: alarm ringing soon ", z);
        return z;
    }

    public static boolean isSkipped(Alarm alarm) {
        return alarm.suspendTime > System.currentTimeMillis();
    }

    public static boolean isSnoozing(Context context) {
        return context.getSharedPreferences("AlarmClock", 0).getInt("snooze_id", -1) != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showAntiSnoringNotification$1(Context context, Handler handler, int i) {
        showAntiSnoringNotification(context, handler, i - 1);
    }

    public static List<Integer> parseNumberFromString(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("\\d+").matcher(str);
        while (matcher.find()) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt(matcher.group())));
            } catch (NumberFormatException e) {
                Logger.logSevere(e);
                return arrayList;
            }
        }
        return arrayList;
    }

    public static void removeSleepTrackStartIntent(Context context) {
        PendingIntentBuilder.get(context, 1, new Intent("com.urbandroid.sleep.alarmclock.START_SLEEP_TRACK"), getPendingIntentFlags()).cancelAlarmBroadcast();
        PendingIntentBuilder.get(context, 1, new Intent("com.urbandroid.sleep.alarmclock.START_SLEEP_TRACK"), getPendingIntentFlagsLegacy()).cancelAlarmBroadcast();
    }

    public static void resetLastScheduledAlarmData() {
        Logger.logInfo("Alarms: Resetting in memory last scheduled alarm");
        cache.reset();
    }

    public static Uri resolveAlarmAlert(Alarm alarm) {
        String actualDefaultRingtoneUri;
        Settings settings = SharedApplicationContext.getSettings();
        Uri uri = alarm.alert;
        if (uri != null && uri.toString().equals("android.resource://com.urbandroid.sleep/raw/default")) {
            Uri defaultRingtoneUri = settings.getDefaultRingtoneUri();
            return (defaultRingtoneUri == null || !defaultRingtoneUri.toString().equals("android.resource://com.urbandroid.sleep/raw/phone") || (actualDefaultRingtoneUri = settings.getActualDefaultRingtoneUri()) == null) ? defaultRingtoneUri : Uri.parse(actualDefaultRingtoneUri);
        }
        Uri uri2 = alarm.alert;
        if (uri2 != null && uri2.toString().equals("android.resource://com.urbandroid.sleep/raw/phone")) {
            return settings.getDefaultPhoneRingtone();
        }
        Uri uri3 = alarm.alert;
        return (uri3 == null && alarm.silent) ? Uri.parse("silent") : uri3;
    }

    public static void saveNextAlarm(Context context, String str) {
        try {
            if (Environment.isLollipopOrGreater()) {
                return;
            }
            Settings.System.putString(context.getContentResolver(), "next_alarm_formatted", str);
        } catch (SecurityException unused) {
            Logger.logSevere("This phone's firmware does not allow setting the system alarm property from init receiver .");
        }
    }

    public static void saveSnoozeAlert(Context context, int i, long j) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("AlarmClock", 0);
        if (i == -1) {
            clearSnoozePreference(context, sharedPreferences);
        } else {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt("snooze_id", i);
            editorEdit.putLong("snooze_time", j);
            editorEdit.apply();
        }
        setNextAlert(context);
    }

    public static void scheduleNewAlertAfterOldFinished(Context context, Alarm alarm) {
        if (alarm == null || alarm.getDaysOfWeek().isRepeatSet()) {
            setNextAlert(context);
        } else {
            enableAlarm(context, alarm.id, false);
        }
    }

    public static void scheduleRateSleepLater(Context context, SleepRecord sleepRecord, long j) {
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("RateLate: after ", " sleep length ", j);
        sbM.append(sleepRecord.getMeasurementLength());
        Logger.logInfo(sbM.toString());
        if (sleepRecord.getMeasurementLength() <= 50) {
            Logger.logInfo("RateLate: ignoring short sleep");
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent("com.urbandroid.sleep.alarmclock.RATE_SLEEP_LATER");
        intent.putExtra("SleepRecord", (Parcelable) sleepRecord);
        PendingIntentBuilder pendingIntentBuilder = PendingIntentBuilder.get(context, 3462, intent, getPendingIntentFlags());
        pendingIntentBuilder.cancelAlarmBroadcast();
        setAlarmCompat(alarmManager, 0, TimeUnit.HOURS.toMillis(j) + System.currentTimeMillis(), pendingIntentBuilder.getExplicitBroadcast());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void scheduleTimeToBed(Context context, AlarmManager alarmManager, Alarm alarm, long j, long j2, long j3) {
        scheduleTimeToBedBedtime(context, alarmManager, alarm, j, j2, j3);
        scheduleTimeToBedAutoStart(context, alarmManager, alarm, j);
    }

    private static void scheduleTimeToBedAutoStart(Context context, AlarmManager alarmManager, Alarm alarm, long j) {
        long j2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (new com.urbandroid.sleep.service.Settings(context).getAutoStartMode() == 2) {
            Intent intent = new Intent("com.urbandroid.sleep.alarmclock.AUTO_START_SLEEP_TRACK_BEDTIME");
            intent.putExtra("SCHEDULED_AUTO_START", true);
            PendingIntentBuilder pendingIntentBuilder = PendingIntentBuilder.get(context, 2, intent, getPendingIntentFlags());
            PendingIntentBuilder pendingIntentBuilder2 = PendingIntentBuilder.get(context, 2, intent, getPendingIntentFlagsLegacy());
            if (jCurrentTimeMillis + 100 >= j) {
                pendingIntentBuilder.cancelAlarmBroadcast();
                pendingIntentBuilder2.cancelAlarmBroadcast();
                cache.reset(SetAlarmCache.SetAlarmType.AUTO_START_BEDTIME);
                return;
            }
            StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("Alarms:Auto start: at bedtime ", " TRACK ", j);
            sbM.append(new Date(j));
            Logger.logInfo(sbM.toString());
            if (Experiments.getInstance().isLessAlarmReschedulingExperiment()) {
                j2 = j;
                if (!cache.shouldSetAlarmNow(SetAlarmCache.SetAlarmType.AUTO_START_BEDTIME, alarm, j2, ContextExtKt.canScheduleExactAlarmsCompat(alarmManager))) {
                    Logger.logInfo("Skipping set auto start bedtime (cached).");
                    return;
                }
            } else {
                j2 = j;
            }
            pendingIntentBuilder.cancelAlarmBroadcast();
            pendingIntentBuilder2.cancelAlarmBroadcast();
            setAlarmCompat(alarmManager, 0, j2, pendingIntentBuilder.getExplicitBroadcast());
        }
    }

    private static void scheduleTimeToBedBedtime(Context context, AlarmManager alarmManager, Alarm alarm, long j, long j2, long j3) {
        Logger.logInfo("Alarms:Scheduling bedtime: " + new Date(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent("com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALARM_ALERT");
        if (alarm != null) {
            intent.putExtra("alarm_id", alarm.id);
        }
        StringBuilder sb = new StringBuilder();
        if (j3 != -1) {
            sb.append(context.getString(R.string.time_to_bed_message, formatTime(context, j3)));
        }
        if (alarm != null && alarm.label != null) {
            sb.append(". ");
            sb.append(alarm.label);
        }
        if (sb.length() == 0) {
            sb.append(context.getString(R.string.bedtime_notification_expl));
        }
        intent.putExtra("time_to_bed_message", sb.toString());
        intent.putExtra("time_to_bed_content_info", formatTime(context, j));
        PendingIntentBuilder pendingIntentBuilder = PendingIntentBuilder.get(context, 0, intent, getPendingIntentFlags());
        PendingIntentBuilder pendingIntentBuilder2 = PendingIntentBuilder.get(context, 0, intent, getPendingIntentFlagsLegacy());
        long j4 = j - j2;
        if (j2 < 0) {
            Logger.logInfo("Alarms:Canceling bedtime -> Not enabled ( " + j2 + ")");
            pendingIntentBuilder.cancelAlarmBroadcast();
            pendingIntentBuilder2.cancelAlarmBroadcast();
            cache.reset(SetAlarmCache.SetAlarmType.TIME_TO_BED);
        } else if (jCurrentTimeMillis + 100 < j4) {
            StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("Alarms:Scheduling bedtime: ", " Date: ", j4);
            sbM.append(new Date(j4));
            Logger.logInfo(sbM.toString());
            if (alarm == null || !Experiments.getInstance().isLessAlarmReschedulingExperiment() || cache.shouldSetAlarmNow(SetAlarmCache.SetAlarmType.TIME_TO_BED, alarm, j4, ContextExtKt.canScheduleExactAlarmsCompat(alarmManager))) {
                pendingIntentBuilder.cancelAlarmBroadcast();
                pendingIntentBuilder2.cancelAlarmBroadcast();
                setAlarmCompat(alarmManager, 0, j4, pendingIntentBuilder.getExplicitBroadcast());
            } else {
                Logger.logInfo("Alarms:Skipping setting bedtime (cached)");
            }
        } else {
            Logger.logInfo("Alarms:Canceling bedtime -> Past: " + j2 + ")");
            pendingIntentBuilder.cancelAlarmBroadcast();
            pendingIntentBuilder2.cancelAlarmBroadcast();
            cache.reset(SetAlarmCache.SetAlarmType.TIME_TO_BED);
        }
        Date nextTimeToBed = SharedApplicationContext.getSettings().getNextTimeToBed();
        if (nextTimeToBed != null && nextTimeToBed.getTime() != j) {
            Logger.logInfo("Alarms:Time to bed changed. Reseting repeat");
            BedtimeReceiver.cancelRepeatNotification(context);
        }
        Date date = new Date(j);
        Logger.logInfo("Alarms: bedtime SET " + date);
        SharedApplicationContext.getSettings().setNextTimeToBed(date);
        ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.alarmclock.ALARM_TIME_TO_BED_UPDATE"));
    }

    public static void scheduleWakeUpCheck(Context context, Alarm alarm, long j) {
        Logger.logInfo("WakeUpCheck: scheduleWakeUpCheck " + alarm.id + " after " + j);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent("com.urbandroid.sleep.alarmclock.ALARM_WAKE_UP_CHECK");
        intent.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        PendingIntentBuilder pendingIntentBuilder = PendingIntentBuilder.get(context, 3, intent, getPendingIntentFlags());
        pendingIntentBuilder.cancelAlarmBroadcast();
        long jCurrentTimeMillis = System.currentTimeMillis() + j;
        setAlarmClockCompat(alarmManager, context, alarm.id, 0, System.currentTimeMillis() + j, pendingIntentBuilder.getExplicitBroadcast());
        SharedApplicationContext.getSettings().setWakeUpCheckScheduled(jCurrentTimeMillis);
    }

    public static long setAlarm(Context context, Alarm alarm, long j) {
        if (alarm.enabled) {
            alarm.extendedConfig.setLastEnableTimestamp(Long.valueOf(j));
        }
        ContentValues contentValuesCreateContentValues = createContentValues(context, alarm, j);
        ContentResolver contentResolver = context.getContentResolver();
        contentResolver.update(ContentUris.withAppendedId(Alarm.Columns.CONTENT_URI, alarm.id), contentValuesCreateContentValues, null, null);
        getAlarm(contentResolver, alarm.id);
        long jCalculateAlarm = calculateAlarm(context, alarm, j);
        if (alarm.enabled) {
            clearSnoozeIfNeeded(context, jCalculateAlarm);
        }
        setNextAlert(context);
        return jCalculateAlarm;
    }

    public static void setAlarmClockCompat(AlarmManager alarmManager, Context context, int i, int i2, long j, PendingIntent pendingIntent) {
        if (!Environment.isLollipopOrGreater() || !SharedApplicationContext.getSettings().isStatusBarIcon()) {
            setAlarmCompat(alarmManager, i2, j, pendingIntent);
            return;
        }
        if (Build.VERSION.SDK_INT >= 31 && !alarmManager.canScheduleExactAlarms()) {
            Logger.logSevere("Cannot set EXACT alarms");
            alarmManager.setAndAllowWhileIdle(0, j, pendingIntent);
            return;
        }
        Intent intent = new Intent(context, (Class<?>) SetAlarm.class);
        intent.putExtra("alarm_id", i);
        intent.putExtra("set_time_extra", true);
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        Logger.logInfo("Alarms: setAlarmClock " + new Date(j));
        alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(j, PendingIntentBuilder.get(context, i, intent, 134217728).getActivity()), pendingIntent);
    }

    public static void setAlarmCompat(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        Logger.logInfo("Alarms: setAlarmCompat " + new Date(j));
        if (Environment.isMOrGreater()) {
            AlarmManagerCompat.setExactAndAllowWhileIdle(alarmManager, i, j, pendingIntent);
        } else if (Environment.isKitKatOrGreater()) {
            alarmManager.setExact(i, j, pendingIntent);
        } else {
            alarmManager.set(i, j, pendingIntent);
        }
    }

    private static void setLastShownSoonAlarmTime(Context context, long j) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("AlarmClock", 0).edit();
        editorEdit.putLong("last_shown_soon_alarm", j);
        editorEdit.apply();
    }

    public static Alarm setNextAlert(Context context, long j) {
        String googleCalendarAccount;
        Alarm alarmEnableSnoozeAlert = enableSnoozeAlert(context, j);
        if (alarmEnableSnoozeAlert != null) {
            return alarmEnableSnoozeAlert;
        }
        com.urbandroid.sleep.service.Settings settings = new com.urbandroid.sleep.service.Settings(context);
        Date nextAlarm = settings.getNextAlarm();
        long time = nextAlarm != null ? nextAlarm.getTime() : 0L;
        Alarm alarmCalculateNextAlert = calculateNextAlert(context, j);
        if (alarmCalculateNextAlert != null) {
            Logger.logInfo("Alarms:Next alarm " + alarmCalculateNextAlert.getOffsetHour(context) + ":" + alarmCalculateNextAlert.getOffsetMinutes(context) + " Window: " + alarmCalculateNextAlert.nonDeepsleepWakeupWindow + " Vibrate: " + alarmCalculateNextAlert.legacyVibrate + " Now: " + new Date());
            enableAlert(context, alarmCalculateNextAlert, alarmCalculateNextAlert.time);
            if (Experiments.getInstance().isGoogleCalendarExperiment() && (googleCalendarAccount = settings.getGoogleCalendarAccount()) != null) {
                LastCalendarAlarmChecker lastCalendarAlarmChecker = LastCalendarAlarmChecker.INSTANCE;
                if (!lastCalendarAlarmChecker.wasRecentlyChecked(alarmCalculateNextAlert)) {
                    JavahelpersKt.checkCalendarEvents(context, googleCalendarAccount, alarmCalculateNextAlert);
                    lastCalendarAlarmChecker.checked(alarmCalculateNextAlert);
                }
            }
        } else {
            Logger.logDebug("Alarms:No next alarm");
            disableAlert(context);
            settings.setNextTimeToBed(null);
            settings.clearNextAlarm();
            Logger.logDebug("Alarms:No next alarm, no alarm bedtime? " + settings.isNoAlarmBedtime());
        }
        long noAlarmBedtimeTime = settings.getNoAlarmBedtimeTime(j);
        Logger.logDebug("Alarms:no alarm bedtime for today " + new Date(noAlarmBedtimeTime) + " bedtime " + settings.getNextTimeToBed());
        if (settings.isNoAlarmBedtime() && noAlarmBedtimeTime > j && (settings.getNextTimeToBed() == null || settings.getNextTimeToBed().getTime() - noAlarmBedtimeTime > 43200000)) {
            Logger.logDebug("Alarms:Scheduling no alarm bedtime for today " + new Date(noAlarmBedtimeTime));
            scheduleTimeToBedBedtime(context, (AlarmManager) context.getSystemService("alarm"), null, noAlarmBedtimeTime, SharedApplicationContext.getSettings().getTimeToBedBefore() < 0 ? -1 : r2 * 60000, -1L);
        }
        Date nextAlarm2 = settings.getNextAlarm();
        if (time != (nextAlarm2 != null ? nextAlarm2.getTime() : 0L)) {
            Intent intent = new Intent("com.urbandroid.sleep.alarmclock.ALARM_RESCHEDULED");
            if (alarmCalculateNextAlert != null) {
                intent.putExtra("alarm_id", alarmCalculateNextAlert.id);
                intent.putExtra("alarm_label", alarmCalculateNextAlert.label);
                intent.putExtra("alarm_time", alarmCalculateNextAlert.time);
            }
            ContextExtKt.sendExplicitBroadcast(context, intent);
        }
        return alarmCalculateNextAlert;
    }

    public static void setSkipNext(Context context, Alarm alarm, boolean z) {
        if (z) {
            skipAlarmOrShowCaptcha(context, alarm);
        } else {
            setSuspendTime(alarm, -1L);
            setAlarm(context, alarm);
        }
    }

    private static void setStatusBarIcon(Context context, boolean z) {
        try {
            Intent intent = new Intent("android.intent.action.ALARM_CHANGED");
            intent.putExtra("alarmSet", z && SharedApplicationContext.getSettings().isStatusBarIcon());
            context.sendBroadcast(intent);
        } catch (SecurityException e) {
            Logger.logSevere(e);
        }
    }

    public static void setSuspendTime(Alarm alarm, long j) {
        Logger.logDebug("Alarms: setSuspend skip next  " + j + " " + alarm);
        alarm.suspendTime = j;
    }

    public static boolean showAlarmSoonNotificationIfRequired(Context context, Alarm alarm) {
        if (SleepService.isRunning() || !SharedApplicationContext.getSettings().isStatusBarIcon() || alarm.time == getSnoozeTime(context)) {
            return false;
        }
        if (alarm.time == getLastShownSoonAlarmTime(context)) {
            return true;
        }
        if (alarm.time > System.currentTimeMillis() + 3600000) {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            long j = alarm.time - 3600000;
            if (!Experiments.getInstance().isLessAlarmReschedulingExperiment() || cache.shouldSetAlarmNow(SetAlarmCache.SetAlarmType.SHOW_SKIP, alarm, j, ContextExtKt.canScheduleExactAlarmsCompat(alarmManager))) {
                Intent intent = new Intent("com.urbandroid.sleep.alarmclock.SHOW_SKIP_NEXT_ALARM_ACTION");
                intent.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
                PendingIntentBuilder pendingIntentBuilder = PendingIntentBuilder.get(context, 993273703, intent, getPendingIntentFlags());
                PendingIntentBuilder pendingIntentBuilder2 = PendingIntentBuilder.get(context, 993273703, intent, getPendingIntentFlagsLegacy());
                pendingIntentBuilder.cancelAlarmBroadcast();
                pendingIntentBuilder2.cancelAlarmBroadcast();
                setAlarmCompat(alarmManager, 0, j, pendingIntentBuilder.getExplicitBroadcast());
            } else {
                Logger.logInfo("Skipping set alarm for show skip (cached).");
            }
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(alarm.time);
        String dayAndTime = formatDayAndTime(context, calendar);
        Intent intent2 = new Intent(context, (Class<?>) AlarmClock.class);
        intent2.setFlags(268566528);
        PendingIntent activity = PendingIntentBuilder.get(context, 0, intent2, 0).getActivity();
        Intent intent3 = new Intent("com.urbandroid.sleep.alarmclock.SKIP_NEXT_ALARM_ACTION");
        Intent intent4 = new Intent(context, (Class<?>) DummyBroadcastActivity.class);
        intent4.setFlags(ClientDefaults.MAX_MSG_SIZE);
        intent4.putExtra("extra_broadcast_action", intent3.getAction());
        intent4.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        intent4.putExtra("alarm_id", alarm.id);
        intent3.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        intent3.putExtra("alarm_id", alarm.id);
        PendingIntent explicitBroadcast = PendingIntentBuilder.get(context, 993273702, intent3, getPendingIntentFlags()).getExplicitBroadcast();
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            explicitBroadcast = PendingIntentBuilder.get(context, 993273702, intent4, getPendingIntentFlags()).getActivity();
        }
        if (i >= 29) {
            Logger.logInfo("SkipNext: Fix for Android Q background activity");
            intent3.addFlags(ClientDefaults.MAX_MSG_SIZE);
            intent3.setComponent(new ComponentName(context.getPackageName(), SkipNextAlarmActivity.class.getName()));
            explicitBroadcast = PendingIntentBuilder.get(context, 993273702, intent3, getPendingIntentFlags()).getActivity();
        }
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(context, "beforeAlarmChannel").setContentIntent(activity).setColor(ColorUtil.i(context, R.color.tint_notification)).addAction(R.drawable.ic_action_cancel, context.getString(R.string.alarm_alert_dismiss_text), explicitBroadcast).setContentTitle(context.getString(R.string.default_label)).setContentText(dayAndTime);
        contentText.setSmallIcon(R.drawable.ic_alarm_white);
        NotificationsKt.notify(context, 993273701, contentText.build());
        setLastShownSoonAlarmTime(context, alarm.time);
        return true;
    }

    public static void showAntiSnoringNotification(Context context) {
        if (SharedApplicationContext.getSettings().isAntiSnoringNotification()) {
            PendingIntent activity = PendingIntentBuilder.get(context, 1, SimpleSettingsActivity.createHighlightIntent(context, NoiseSettingsActivity.class, "anti_snoring_response"), getPendingIntentFlags()).getActivity();
            NotificationCompat.Builder contentText = new NotificationCompat.Builder(context, "antiSnoringChannel").setContentIntent(activity).setAutoCancel(true).setColor(ColorUtil.i(context, R.color.tint_notification)).addAction(R.drawable.ic_cog, context.getString(R.string.settings), activity).setContentTitle(context.getString(R.string.anti_snoring_title)).setDeleteIntent(activity).setContentText(context.getString(R.string.stop_snoring));
            contentText.setSmallIcon(R.drawable.ic_anti_snoring);
            NotificationsKt.cancel(context, 32937834);
            NotificationsKt.notify(context, 32937834, contentText.build());
        }
    }

    public static boolean showRateSleepLaterNotification(Context context, SleepRecord sleepRecord) {
        if (SleepService.isRunning()) {
            return false;
        }
        Intent intent = new Intent(context, (Class<?>) SleepDetailActivity.class);
        intent.putExtra("SleepRecord", (Parcelable) sleepRecord);
        intent.setPackage(context.getPackageName());
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(context, "reteLateAlarmChannel").setContentIntent(new PendingIntentBuilder(context, 3462, intent, 134217728).getActivity()).setColor(ColorUtil.i(context, R.color.tint_notification)).setContentTitle(context.getString(R.string.how_do_you_feel)).setAutoCancel(true).setContentText(context.getString(R.string.rate_sleep_dialog));
        contentText.setSmallIcon(R.drawable.ic_star_outline);
        NotificationsKt.notify(context, 38739230, contentText.build());
        return true;
    }

    public static void showWakeUpCheck(Context context, Alarm alarm, long j) {
        com.urbandroid.sleep.service.Settings settings = new com.urbandroid.sleep.service.Settings(context);
        if (!settings.shouldWakeUpCheckRepeat()) {
            Logger.logInfo("WakeUpCheck: limit reached");
            settings.resetWakeUpCheckRepeat();
            return;
        }
        if (!NotificationsKt.isNotificationChannelEnabled(context, "wakeupCheckChannel2")) {
            Logger.logInfo("WakeUpCheck: skipping wake up check as notification is OFF");
            settings.resetWakeUpCheckRepeat();
            return;
        }
        Logger.logInfo("WakeUpCheck: showWakeUpCheck " + alarm.id + " after " + j);
        Intent intent = new Intent("com.urbandroid.sleep.alarmclock.cancel_snooze_no_captcha");
        intent.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        PendingIntent explicitBroadcast = PendingIntentBuilder.get(context, 4, intent, getPendingIntentFlags()).getExplicitBroadcast();
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(context, "wakeupCheckChannel2").setContentIntent(explicitBroadcast).setAutoCancel(true).setColor(ColorUtil.i(context, R.color.tint_notification)).addAction(R.drawable.ic_action_accept_white, context.getString(R.string.wake_up_check_notification_confirm), explicitBroadcast).setContentTitle(context.getString(R.string.settings_wake_up_check)).setDeleteIntent(explicitBroadcast).setContentText(context.getString(R.string.wake_up_check_notification));
        contentText.setSmallIcon(R.drawable.ic_eye_white);
        NotificationsKt.notify(context, 28777382, contentText.build());
        saveSnoozeAlert(context, alarm.id, Math.max(j, 9000L) + System.currentTimeMillis());
        settings.setWakeUpCheckScheduledAlarmId(alarm.id);
        settings.increaseWakeUpCheckRepeatCount();
        NotificationsKt.cancel(context, alarm.id);
    }

    public static boolean skipAlarmOrShowCaptcha(Context context, Alarm alarm) {
        Logger.logInfo("Alarms:skipAlarmOrShowCaptcha() alarm: " + alarm);
        if (!isAlarmDisablingLimitedByCaptcha(context, alarm)) {
            skipNextAlarm(context, alarm);
            return true;
        }
        CaptchaInfo captchaInfo = SharedApplicationContext.getSettings().getCaptchaInfo(alarm);
        SharedApplicationContext.getCaptchaManager().getLauncher(alarm).operation("should_skip").start(captchaInfo);
        trackCaptchaAchievement(captchaInfo);
        return false;
    }

    public static void skipNextAlarm(Context context, Alarm alarm) {
        Logger.logInfo("Alarms:skipAlarm() alarm: " + alarm + " called by: " + getStackTrace(5));
        if (cancelSnooze(context, alarm)) {
            setNextAlert(context);
        } else {
            suspendNextAlarm(context, alarm);
        }
    }

    public static void suspendAlarm(Context context, Alarm alarm, long j) {
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("Alarms: Suspending alarm till: ", " Alarm: ", j);
        sbM.append(Alarm.toDebugString(alarm));
        Logger.logInfo(sbM.toString());
        setSuspendTime(alarm, j);
        setAlarm(context, alarm);
    }

    public static void suspendNextAlarm(Context context, Alarm alarm) {
        com.urbandroid.sleep.service.Settings settings = new com.urbandroid.sleep.service.Settings(context);
        if (alarm.getDaysOfWeek().isRepeatSet()) {
            Logger.logInfo("Alarms:suspendNextAlarm() alarm: " + alarm + " called by: " + getStackTrace(5));
            Calendar calendar = Calendar.getInstance();
            if (alarm.suspendTime > -1) {
                long time = calendar.getTime().getTime();
                long j = alarm.suspendTime;
                if (time < j) {
                    calendar.setTimeInMillis(j);
                }
            }
            long timeInMillis = calculateAlarm(context, alarm.getOffsetHour(context, calendar.getTime().getTime()), alarm.getOffsetMinutes(context, calendar.getTime().getTime()), alarm.getDaysOfWeek(), (Calendar) calendar.clone()).getTimeInMillis();
            alarm.resetOffset();
            long timeInMillis2 = calculateAlarm(context, alarm.getOffsetHour(context, calendar.getTime().getTime()), alarm.getOffsetMinutes(context, calendar.getTime().getTime()), alarm.getDaysOfWeek(), calendar).getTimeInMillis();
            long j2 = 1 + timeInMillis2;
            if (timeInMillis == j2 || Math.abs(timeInMillis - j2) / 60000 <= 181) {
                setSuspendTime(alarm, timeInMillis2 + 2);
            }
        } else {
            alarm.enabled = false;
            AlarmExtendedConfig alarmExtendedConfig = alarm.extendedConfig;
            if (alarmExtendedConfig != null && alarmExtendedConfig.isSelfDisposable().booleanValue() && !settings.isWakeUpCheck(alarm)) {
                deleteAlarm(context, alarm.id);
                return;
            }
        }
        if (alarm.id > -1) {
            setAlarm(context, alarm);
        }
    }

    public static void trackCaptchaAchievement(CaptchaInfo captchaInfo) {
        Logger.logInfo("Achievement: CAPCTHA " + captchaInfo.getActivityName());
        Achievement.Type type = captchaInfo.getActivityName().endsWith("ZombieWalkCaptcha") ? Achievement.Type.CAPTCHA_ZOMBIE : captchaInfo.getActivityName().endsWith("SimpleMathCaptcha") ? Achievement.Type.CAPTCHA_MATH : captchaInfo.getActivityName().endsWith("SmileCaptcha") ? Achievement.Type.CAPTCHA_SMILE : captchaInfo.getActivityName().endsWith("SleepingSheepsCaptcha") ? Achievement.Type.CAPTCHA_SHEEP : captchaInfo.getActivityName().endsWith("QRCaptcha") ? Achievement.Type.CAPTCHA_CODE : null;
        if (type != null) {
            SharedApplicationContext.getSettings().addAchievement(type, 1);
        }
    }

    public static String formatTime(Context context, Calendar calendar) {
        return calendar == null ? "" : (String) DateFormat.format(get24HourMode(context) ? "kk:mm" : "h:mm aa", calendar);
    }

    public static String formatTime(Context context, int i, int i2, Alarm.DaysOfWeek daysOfWeek) {
        return formatTime(context, calculateAlarm(context, i, i2, daysOfWeek));
    }

    public static long setAlarm(Context context, Alarm alarm) {
        return setAlarm(context, alarm, System.currentTimeMillis());
    }

    public static long addAlarm(Context context, Alarm alarm) {
        return addAlarm(context, alarm, true);
    }

    public static long calculateAlarm(Context context, Alarm alarm, long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        long jCalculateAlarm = calculateAlarm(context, alarm, calendar);
        long j2 = alarm.suspendTime;
        if (j2 <= jCalculateAlarm) {
            return jCalculateAlarm;
        }
        calendar.setTimeInMillis(j2);
        return calculateAlarm(context, alarm, calendar);
    }

    public static long calculateAlarm(Context context, Alarm alarm, Calendar calendar) {
        return calculateAlarm(context, alarm.getOffsetHour(context, calendar.getTimeInMillis()), alarm.getOffsetMinutes(context, calendar.getTimeInMillis()), alarm.getDaysOfWeek(), calendar).getTimeInMillis();
    }

    public static Calendar calculateAlarm(Context context, int i, int i2, Alarm.DaysOfWeek daysOfWeek) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return calculateAlarm(context, i, i2, daysOfWeek, calendar);
    }

    public static long calculateAlarm(Context context, Alarm alarm) {
        return calculateAlarm(context, alarm, System.currentTimeMillis());
    }

    public static void showAntiSnoringNotification(final Context context, final Handler handler, final int i) {
        zza$$ExternalSyntheticOutline0.m(i, "Antisnore: notification loop ");
        if (i > 0) {
            showAntiSnoringNotification(context);
            final int i2 = 0;
            handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.Alarms$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    int i3 = i2;
                    Context context2 = context;
                    switch (i3) {
                        case 0:
                            Alarms.cancelAntiSnoringNotification(context2);
                            break;
                        default:
                            Alarms.cancelAntiSnoringNotification(context2);
                            break;
                    }
                }
            }, 2000L);
            handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.Alarms$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Alarms.lambda$showAntiSnoringNotification$1(context, handler, i);
                }
            }, 4000L);
            return;
        }
        if (i == -1) {
            showAntiSnoringNotification(context);
            final int i3 = 1;
            handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.Alarms$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    int i32 = i3;
                    Context context2 = context;
                    switch (i32) {
                        case 0:
                            Alarms.cancelAntiSnoringNotification(context2);
                            break;
                        default:
                            Alarms.cancelAntiSnoringNotification(context2);
                            break;
                    }
                }
            }, 2000L);
        }
    }

    public static Cursor getAlarmsCursor(Context context) {
        return context.getContentResolver().query(Alarm.Columns.CONTENT_URI, AlarmColumns.ALARM_QUERY_COLUMNS, null, null, new com.urbandroid.sleep.service.Settings(context).isAlarmSortByDay() ? "enabled DESC, CASE enabled WHEN 1 THEN alarmtime ELSE (hour* 60 + minutes) END" : "hour, minutes ASC");
    }

    private static void enableAlarmInternal(Context context, int i, boolean z) {
        enableAlarmInternal(context, getAlarm(context.getContentResolver(), i), z);
    }

    public static void addOffset(Context context, Alarm alarm, int i) {
        addOffset(context, alarm, i, System.currentTimeMillis());
    }

    private static ContentValues createContentValues(Context context, Alarm alarm, boolean z) {
        return createContentValues(context, alarm, System.currentTimeMillis(), z);
    }

    private static ContentValues createContentValues(Context context, Alarm alarm, long j) {
        return createContentValues(context, alarm, j, false);
    }

    private static ContentValues createContentValues(Context context, Alarm alarm) {
        return createContentValues(context, alarm, System.currentTimeMillis(), false);
    }

    public static Alarm setNextAlert(Context context) {
        return setNextAlert(context, System.currentTimeMillis());
    }

    public static Alarm calculateNextAlert(Context context) {
        return calculateNextAlert(context, System.currentTimeMillis());
    }
}
