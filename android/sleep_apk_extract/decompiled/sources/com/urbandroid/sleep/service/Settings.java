package com.urbandroid.sleep.service;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.ump.UserMessagingPlatform;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.polar.sdk.api.model.PolarDeviceInfo;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.PermissionCompat;
import com.urbandroid.common.util.RandUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.urbandroid.common.util.string.Joiner;
import com.urbandroid.common.util.string.PrependSizeTokenizer;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.activityrecognition.SleepTimeSuggestionManager;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.model.Measure;
import com.urbandroid.sleep.addon.taskerplugin.TaskerPlugin;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import com.urbandroid.sleep.alarmclock.AlarmStatusReceiver;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.domain.Sensitivity;
import com.urbandroid.sleep.domain.achievement.Achievement;
import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.domain.promo.PromoEvent;
import com.urbandroid.sleep.domain.shortcut.Shortcut;
import com.urbandroid.sleep.domain.shortcut.ShortcutSleep;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.media.NoiseDirectory;
import com.urbandroid.sleep.media.OnlineRadioRingtones;
import com.urbandroid.sleep.media.lullaby.LullabyPlayer;
import com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor;
import com.urbandroid.sleep.sensor.sonar.SonarConfig;
import com.urbandroid.sleep.service.SyncShowcaseViewAsyncTask;
import com.urbandroid.sleep.service.automation.AutomationEventMapping;
import com.urbandroid.sleep.service.health.api.BaseHealthUserProfile;
import com.urbandroid.sleep.service.health.api.HealthUserProfile;
import com.urbandroid.sleep.smartwatch.Wearable;
import com.urbandroid.smartlight.common.ConfigurationKt;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.MultiprocessPreferences;
import com.urbandroid.util.SleepPermissionCompat;
import j$.util.DesugarTimeZone;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.achartengine.chart.TimeChart;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class Settings implements SettingKeys {
    public static AtomicBoolean flipDetectionRunning = new AtomicBoolean(false);
    public static boolean goodTimeToRate = false;
    private final Context context;
    public int deepSleepCounter;
    private boolean remoteProcess;
    private String[] tabs;

    public Settings(Context context, boolean z) {
        this.tabs = new String[]{"tab_dashboard", "tab_stats", "tab_graphs", "tab_noise"};
        this.deepSleepCounter = 0;
        this.context = context;
        this.remoteProcess = z;
        zza$$ExternalSyntheticOutline0.m("Multiprocess init remote = ", z);
    }

    private void addCodeCaptcha(String str, String str2) {
        if (str2.contains(";")) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Illegal captcha string: ".concat(str2));
            return;
        }
        String codeCaptchaRaw = getCodeCaptchaRaw(str);
        if (codeCaptchaRaw.contains(str2)) {
            return;
        }
        if (codeCaptchaRaw.length() > 0) {
            codeCaptchaRaw = codeCaptchaRaw.concat(";");
        }
        String strConcat = codeCaptchaRaw.concat(str2);
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString(str, strConcat);
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    private void addToLastNaps(int i) {
        List<String> listLoadList = loadList("key_nap_minutes_multi", "-");
        listLoadList.remove(String.valueOf(i));
        listLoadList.add(0, String.valueOf(i));
        if (listLoadList.size() > 3) {
            listLoadList.remove(listLoadList.size() - 1);
        }
        saveList("key_nap_minutes_multi", listLoadList, "-");
    }

    private String buildRadioString(String str, String str2) {
        return FileInsert$$ExternalSyntheticOutline0.m$1(str, ";;;", str2);
    }

    private void clear(String str) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    public static Settings from(Context context) {
        return new Settings(context);
    }

    private String getCaptchaDifficultyKey(String str) {
        Logger.logInfo("Captcha difficulty key captcha_difficulty-" + str);
        return "captcha_difficulty-" + str;
    }

    private String[] getCodeCaptcha(String str) {
        String strTrim = getCodeCaptchaRaw(str).trim();
        return strTrim.length() == 0 ? new String[0] : strTrim.split(";");
    }

    private String getCodeCaptchaRaw(String str) {
        return getPrefString(str, "");
    }

    private long getCountryUpdatedTimestamp() {
        return getPrefLong("country_update_time", 0L);
    }

    private Date getDate(String str) {
        long prefLong = getPrefLong(str, -1L);
        if (prefLong > -1) {
            return new Date(prefLong);
        }
        return null;
    }

    private String getDeviceSpecificKey(String str) {
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(str, "_");
        sbM.append(Build.DEVICE);
        return sbM.toString();
    }

    private String getLastActionKey(String str) {
        return FileInsert$$ExternalSyntheticOutline0.m("key_last_action_time_", str);
    }

    private int getLastNapMinutesLegacy() {
        return getDefaultSharedPreferences(this.context).getInt("key_nap_minutes", 30);
    }

    private String getPolarSdkDeviceString(PolarDeviceInfo polarDeviceInfo) {
        return polarDeviceInfo.getDeviceId() + ";;;" + polarDeviceInfo.getAddress() + ";;;" + polarDeviceInfo.getName();
    }

    private double getPrefDoubleAsString(String str, double d) {
        String string = getDefaultSharedPreferences(this.context).getString(str, "" + d);
        try {
            return Double.parseDouble(string);
        } catch (NumberFormatException unused) {
            Logger.logSevere("Cannot convert property " + str + " to number, value: " + string);
            return d;
        }
    }

    private float getPrefFloatAsString(String str, float f) {
        String string = getDefaultSharedPreferences(this.context).getString(str, "" + f);
        try {
            return Float.parseFloat(string);
        } catch (NumberFormatException unused) {
            Logger.logSevere("Cannot convert property " + str + " to number, value: " + string);
            return f;
        }
    }

    private int getPrefInt(String str, int i) {
        return getDefaultSharedPreferences(this.context).getInt(str, i);
    }

    private long getPrefLong(String str, long j) {
        return getDefaultSharedPreferences(this.context).getLong(str, j);
    }

    private int getPrefStringAsInt(String str, int i) {
        String string = null;
        try {
            string = getDefaultSharedPreferences(this.context).getString(str, "" + i);
            return Integer.parseInt(string);
        } catch (ClassCastException | NumberFormatException unused) {
            Logger.logSevere("Cannot convert property " + str + " to number, value: " + string);
            return i;
        }
    }

    private long getPrefStringLong(String str, long j) {
        String string = getDefaultSharedPreferences(this.context).getString(str, "" + j);
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            Logger.logSevere("Cannot convert property " + str + " to number, value: " + string);
            return j;
        }
    }

    private int getSmartlightLightUpAfter() {
        return getPrefStringAsInt("smartlight_light_up_after", 2);
    }

    public static boolean isGoodTimeToRate() {
        return goodTimeToRate;
    }

    public static boolean isSensorBatchingSupported(Context context) {
        SensorManager sensorManager;
        Sensor defaultSensor;
        if (!Environment.isKitKatOrGreater() || (sensorManager = (SensorManager) context.getSystemService("sensor")) == null || (defaultSensor = sensorManager.getDefaultSensor(1)) == null) {
            return false;
        }
        Logger.logInfo("SensorBatching: getFifoReservedEventCount() " + defaultSensor.getFifoReservedEventCount() + " getFifoMaxEventCount() " + defaultSensor.getFifoMaxEventCount());
        return defaultSensor.getFifoReservedEventCount() > 100 || defaultSensor.getFifoMaxEventCount() > 500;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getOnlineRadios$0(OnlineRadioRingtones.Radio radio, OnlineRadioRingtones.Radio radio2) {
        if (radio2 == null || radio == null) {
            return 0;
        }
        String str = radio.title;
        if (str == null && radio2.title == null) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        return str.compareTo(radio2.title);
    }

    private List<String> loadList(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        String prefString = getPrefString(str, null);
        if (prefString != null) {
            String[] strArrSplit = prefString.split(str2);
            for (String str3 : strArrSplit) {
                if (str3 != null && str3.length() > 0) {
                    arrayList.add(str3);
                }
            }
        }
        return arrayList;
    }

    private OnlineRadioRingtones.Radio parseRadio(String str) {
        if (str == null || !str.contains(";;;")) {
            return null;
        }
        return new OnlineRadioRingtones.Radio(str.split(";;;")[0], "", str.split(";;;")[1]);
    }

    private void resetEmptyString(String str) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString(str, "");
        editorEdit.apply();
    }

    private void save(String str, int i, boolean z) {
        if (str == null) {
            Logger.logWarning("Settings: Null key");
            return;
        }
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putInt(str, i);
        if (z) {
            editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        }
        editorEdit.apply();
    }

    private void saveList(String str, List<String> list, String str2) {
        if (list == null || list.size() == 0) {
            save(str, (String) null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(str2);
            }
        }
        save(str, sb.toString());
    }

    private void setBackupDone() {
        save("key_last_backup", System.currentTimeMillis());
    }

    private void setCountryUpdatedTimestamp() {
        save("country_update_time", System.currentTimeMillis());
    }

    private void setDate(String str, Date date) {
        long time = date != null ? date.getTime() : -1L;
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putLong(str, time);
        editorEdit.apply();
    }

    public static void setGoodTimeToRate(boolean z) {
        if (z) {
            Logger.logInfo("Rating: good time");
        }
        goodTimeToRate = z;
    }

    public void addAchievement(Achievement.Type type, int i) {
        if (type == null) {
            return;
        }
        addAchievementQuantity(type, i, true);
    }

    public void addAchievementQuantity(Achievement.Type type, int i, boolean z) {
        if (type == null) {
            return;
        }
        List<Achievement> listLoadAchievements = loadAchievements();
        Achievement achievement = new Achievement(type, i);
        if (listLoadAchievements.contains(achievement)) {
            Achievement achievement2 = listLoadAchievements.get(listLoadAchievements.indexOf(achievement));
            if (z) {
                if (achievement2.addQuantity(i)) {
                    listLoadAchievements.remove(achievement2);
                    listLoadAchievements.add(achievement2);
                }
            } else if (achievement2.getQuantity() < i && achievement2.setFixedQuantity(i)) {
                listLoadAchievements.remove(achievement2);
                listLoadAchievements.add(achievement2);
            }
        } else {
            listLoadAchievements.add(achievement);
        }
        saveAchievements(listLoadAchievements);
    }

    public void addAnalyticsEvent() {
        long prefLong = getPrefLong("key_ana_events", 0L);
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putLong("key_ana_events", prefLong + 1);
        editorEdit.apply();
    }

    public void addExtendTrialHours(int i) {
        long j;
        if (i < 0) {
            return;
        }
        int iMin = Math.min(Math.max(i, 12), 168);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long extendTrialTime = getExtendTrialTime();
        long jTimeToExpire = TrialFilter.getInstance().timeToExpire();
        long j2 = (((long) iMin) * 3600000) + 3600000;
        if (jTimeToExpire < 0) {
            if (extendTrialTime > jCurrentTimeMillis) {
                j = extendTrialTime + j2;
            }
            Logger.logInfo("Reward: extended till " + new Date(j));
            save("key_reward_extend_trial_count", getExtendTrialCount() + 1);
            save("key_reward_extend_trial_days", j);
        }
        jCurrentTimeMillis += jTimeToExpire;
        j = jCurrentTimeMillis + j2;
        Logger.logInfo("Reward: extended till " + new Date(j));
        save("key_reward_extend_trial_count", getExtendTrialCount() + 1);
        save("key_reward_extend_trial_days", j);
    }

    public void addNFCCaptcha(String str) {
        addCodeCaptcha("nfc_captcha_code_new", str);
    }

    public synchronized void addOnlineRadio(String str, String str2, String str3) {
        try {
            List<OnlineRadioRingtones.Radio> onlineRadios = getOnlineRadios(str3);
            OnlineRadioRingtones.Radio radio = new OnlineRadioRingtones.Radio(str, null, str2);
            onlineRadios.remove(radio);
            onlineRadios.add(radio);
            ArrayList arrayList = new ArrayList();
            for (OnlineRadioRingtones.Radio radio2 : onlineRadios) {
                arrayList.add(buildRadioString(radio2.title, radio2.url));
            }
            saveList(str3, arrayList, ConfigurationKt.DELIMITER);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void addQRCaptcha(String str) {
        addCodeCaptcha("qr_captcha_code_new", str);
    }

    public void addShortcut(Shortcut shortcut) {
        ArrayList arrayList = new ArrayList(loadShortcuts());
        arrayList.add(shortcut);
        saveShortcut(arrayList);
    }

    public void addShowCaseShown(String str) {
        zza$$ExternalSyntheticOutline0.m("AlarmClock: addShowCaseShown ", str);
        if (str == null) {
            return;
        }
        List<String> listLoadList = loadList("showcase_settings_shown2", ConfigurationKt.DELIMITER);
        if (listLoadList.contains(str)) {
            return;
        }
        listLoadList.add(str);
        saveList("showcase_settings_shown2", listLoadList, ConfigurationKt.DELIMITER);
    }

    public boolean canStartScreensFromBackground() {
        return Build.VERSION.SDK_INT < 29 || android.provider.Settings.canDrawOverlays(this.context);
    }

    public void cleanLastNonSnoozeAlarm() {
        clear("key_settings_last_non_snooze_alarm");
    }

    public void clearActiveAlarm() {
        clear("active_alarm_id");
        clear("active_alarm_text");
    }

    public void clearCaptchaAvoidedPurchase() {
        save("captcha_avoided_sku", (String) null);
        save("captcha_avoided_order_id", (String) null);
        save("captcha_avoided_token", (String) null);
        save("captcha_avoided_price", (String) null);
    }

    public void clearFirstUsage(SyncShowcaseViewAsyncTask.IntegrationApp integrationApp) {
        clear("key_first_use_" + integrationApp.name());
    }

    public void clearNextAlarm() {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putLong("key_settings_next_scheduled_alarm", -1L);
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
        clearNextDirectBootAlarm();
    }

    public void clearNextDirectBootAlarm() {
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = this.context.createDeviceProtectedStorageContext().openFileOutput("next_alarm", 0);
            fileOutputStreamOpenFileOutput.write("".getBytes());
            fileOutputStreamOpenFileOutput.flush();
            fileOutputStreamOpenFileOutput.close();
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    public void clearNoiseDirUri() {
        clear(getDeviceSpecificKey("key_noise_dir_uri"));
    }

    public void decRecordsCount() {
        if (getRecordsCount() > 0) {
            setRecordsCount(getRecordsCount() - 1);
        }
    }

    public boolean detectCaptchaAvoided() {
        Logger.logInfo("AvoidCaptcha: detectCaptchaAvoided " + hasPendingActiveAlarm());
        if (!hasPendingActiveAlarm() || AlarmKlaxon.isRunning()) {
            return false;
        }
        setCaptchaAvoided(true);
        Logger.logInfo("AvoidCaptcha: setCaptchaAvoided(true)");
        return true;
    }

    public void disableAnyKindOfRecording() {
        setRecordingMasterSwitchEnabled(false);
    }

    public boolean doSensorBatching(Context context) {
        return Environment.isKitKatOrGreater() && isBatteryOptimized() && isSensorBatchingSupported(context) && !isDoingMicrophoneRecordingAndPermissionGranted() && !isJetLagPrevention();
    }

    public void forceTimeToBedBeforeIfDisabled() {
        if (getTimeToBedBefore() == -1) {
            save("target_sleep_time_notify_before", "5");
        }
    }

    public void forgetAllNFCCaptcha() {
        resetEmptyString("nfc_captcha_code_new");
    }

    public void forgetAllQRCaptcha() {
        resetEmptyString("qr_captcha_code_new");
    }

    public long getActiveAlarmId() {
        return getPrefInt("active_alarm_id", -1);
    }

    public String getActiveAlarmText() {
        return getPrefString("active_alarm_text", null);
    }

    public int getActiveTab() {
        return getPrefInt("active_tab", 0);
    }

    public String getActualDefaultRingtoneUri() {
        return getDefaultSharedPreferences(this.context).getString("actual_default_ringtone_uri", null);
    }

    public int getAge() {
        Date birthDate = getBirthDate();
        if (birthDate == null) {
            return -1;
        }
        Calendar.getInstance().setTime(birthDate);
        return DateUtil.getAgeFromBirthYear(birthDate);
    }

    public int getAirplaneMode() {
        return Integer.parseInt(getDefaultSharedPreferences(this.context).getString("airplane_mode", AppEventsConstants.EVENT_PARAM_VALUE_NO));
    }

    public int getAlarmOutput() {
        return getPrefStringAsInt("alarm_output", 0);
    }

    public int getAlarmTimeout() {
        return Integer.parseInt(getDefaultSharedPreferences(this.context).getString("alarm_kill_time", Integer.toString(1200)));
    }

    public int getAntiSnoringLoop() {
        return getPrefStringAsInt("antisnoring_loop", 3);
    }

    public String getAntisnoringRingtone() {
        String string = getDefaultSharedPreferences(this.context).getString("snoring_ringtone", null);
        return string == null ? "android.resource://com.urbandroid.sleep/raw/antisnore" : string;
    }

    public int getAntisnoringVolume() {
        return getDefaultSharedPreferences(this.context).getInt("antisnoring_volume", 50);
    }

    public int getApneaAlarmRepeat() {
        return getPrefStringAsInt("apnea_alarm_repeat", 5);
    }

    public String getApneaAlarmRingtone() {
        return getPrefString("apnea_alarm_ringtone", "android.resource://com.urbandroid.sleep/raw/apnea");
    }

    public Sensitivity getApneaAlarmSensitivity() {
        return Sensitivity.values()[getPrefStringAsInt("apnea_alarm_sensitivity", 1)];
    }

    public int getAutoKillSnoozeMaxCount() {
        try {
            return getPrefStringAsInt("alarm_kill_snooze_count", 3);
        } catch (NumberFormatException unused) {
            return 3;
        }
    }

    public int getAutoSharingMode() {
        return getPrefStringAsInt("facebook_mode", 0);
    }

    public int getAutoSnoozeRepeat() {
        try {
            return getPrefStringAsInt("key_auto_kill_snooze_counter", 0);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public int getAutoStartMode() {
        if (isAlarmOnly()) {
            return 0;
        }
        return getPrefStringAsInt("auto_start_track_smart", isAutoStartLegacy() ? 3 : 0);
    }

    public int getAutoStartWhenChargingMode() {
        return getPrefStringAsInt("auto_start_track_smart_charge", 0);
    }

    public Set<String> getAutomationEvents() {
        return getDefaultSharedPreferences(this.context).getStringSet("automation_events_list", AutomationEventMapping.getActionSet());
    }

    public String getAutoplayLullabyName() {
        return getPrefString("key_auto_lullaby_name", "");
    }

    public int getAwakeDetectionHighActivitySensitivity() {
        String prefString = getPrefString("key_awake_detection_internal2", "enabled");
        return getPrefInt("awake_activity_sensitivity", prefString != null && prefString.equals("enabled") ? 2 : 0);
    }

    public int getAwakeDetectionHrSensitivity() {
        return getPrefInt("awake_hr_sensitivity", getPrefBoolean("key_awake_detection_hr", true) ? 2 : 0);
    }

    public int getAwakeDetectionLightSensitivity() {
        return getPrefInt("awake_light_sensitivity", getPrefBoolean("key_awake_detection_light", true) ? 2 : 0);
    }

    public float getAwakeDetectionSensitivityAvg() {
        return (getAwakeDetectionWhenUsingPhoneSensitivity() + (getAwakeDetectionTalkSensitivity() + (getAwakeDetectionLightSensitivity() + (getAwakeDetectionHrSensitivity() + getAwakeDetectionHighActivitySensitivity())))) / 5.0f;
    }

    public int getAwakeDetectionTalkSensitivity() {
        return getPrefInt("awake_sound_sensitivity", getPrefBoolean("key_awake_detection_talk", true) ? 2 : 0);
    }

    public int getAwakeDetectionWhenUsingPhoneSensitivity() {
        String prefString = getPrefString("key_awake_detection_internal", "disable");
        return getPrefInt("awake_phone_use_sensitivity", (prefString == null || !prefString.equals("enabled")) ? 0 : 1);
    }

    public Uri getBackupDirUri() {
        String deviceSpecificKey = getDeviceSpecificKey("key_backup_dir_uri");
        String prefString = getPrefString(deviceSpecificKey, null);
        if (prefString == null && (prefString = getPrefString("key_backup_dir_uri", null)) != null) {
            save(deviceSpecificKey, prefString);
            clear("key_backup_dir_uri");
        }
        if (prefString == null) {
            return null;
        }
        return Uri.parse(prefString);
    }

    public int getBedtimeSunsetTheme() {
        int i;
        try {
            Location location = getLocation();
            Calendar calendar = Calendar.getInstance();
            if (location != null) {
                Calendar officialSunriseCalendarForDate = new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(location.getLat(), location.getLon()), TimeZone.getDefault()).getOfficialSunriseCalendarForDate(calendar);
                Calendar officialSunsetCalendarForDate = new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(location.getLat(), location.getLon()), TimeZone.getDefault()).getOfficialSunsetCalendarForDate(calendar);
                Date nextTimeToBed = getNextTimeToBed();
                if (nextTimeToBed != null && Math.abs(nextTimeToBed.getTime() - officialSunsetCalendarForDate.getTimeInMillis()) < 7200000) {
                    officialSunsetCalendarForDate.setTime(nextTimeToBed);
                }
                if (!calendar.before(officialSunriseCalendarForDate) && !calendar.after(officialSunsetCalendarForDate)) {
                    Logger.logInfo("Theme: before sunset DAY");
                    return 2;
                }
                Logger.logInfo("Theme: after sunset NIGHT");
                return 1;
            }
            Date nextTimeToBed2 = getNextTimeToBed();
            Calendar calendar2 = Calendar.getInstance();
            if (nextTimeToBed2 != null) {
                calendar2.setTime(nextTimeToBed2);
                i = calendar2.get(11);
            } else {
                i = 18;
            }
            Date nextAlarm = getNextAlarm();
            if (nextTimeToBed2 != null && nextAlarm != null && nextAlarm.getTime() - calendar.getTimeInMillis() < TimeChart.DAY && (i > 15 || i < 5)) {
                if (calendar.before(nextAlarm) && calendar.after(nextTimeToBed2)) {
                    Logger.logInfo("Theme: after bedtime NIGHT");
                    return 1;
                }
                Logger.logInfo("Theme: before bedtime DAY");
                return 2;
            }
            int i2 = calendar.get(11);
            if (i2 <= 18 && i2 >= 7) {
                Logger.logInfo("Theme: fallback 7-18 DAY");
                return 2;
            }
            Logger.logInfo("Theme: fallback 0-7 18-0 NIGHT");
            return 1;
        } catch (Exception e) {
            Logger.logSevere(e);
            Logger.logInfo("Theme: fallback auto");
            return 0;
        }
    }

    public int getBinaural() {
        return getPrefStringAsInt("binaural", 0);
    }

    public int getBinauralAlarm() {
        return getPrefStringAsInt("binaural_alarm2", 0);
    }

    public int getBinauralVolume() {
        return getDefaultSharedPreferences(this.context).getInt("binaural_volume", 40);
    }

    public Date getBirthDate() {
        int prefStringAsInt = getPrefStringAsInt("profile_birthdate", -1);
        if (prefStringAsInt < 1900) {
            long prefLong = getPrefLong("health_user_profile_birthdate", -1L);
            if (prefLong > 0) {
                return new Date(prefLong);
            }
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, prefStringAsInt);
        calendar.set(6, 1);
        calendar.set(2, 0);
        calendar.set(10, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTime();
    }

    public String getBleDevicePresentation(String str, String str2) {
        return str == null ? "" : (str2 == null || str2.equals(str)) ? str : FileInsert$$ExternalSyntheticOutline0.m(str2, "\n", str, "");
    }

    public String getBleHrDeviceAddress() {
        return getPrefString("btle_device_address", null);
    }

    public String getBleHrDeviceName() {
        return getPrefString("btle_device_name", null);
    }

    public String getBleHrDevicePresentation() {
        return getBleDevicePresentation(getBleHrDeviceAddress(), getBleHrDeviceName());
    }

    public String getBleTrackingDeviceAddress() {
        return getPrefString("btle_tracking_device_address", null);
    }

    public String getBleTrackingDeviceName() {
        return getPrefString("btle_tracking_device_name", null);
    }

    public String getBleTrackingDevicePresentation() {
        return getBleDevicePresentation(getBleTrackingDeviceAddress(), getBleTrackingDeviceName());
    }

    public String getCaptchaAvoidedOrderId() {
        return getPrefString("captcha_avoided_order_id", null);
    }

    public String getCaptchaAvoidedPrice() {
        return getPrefString("captcha_avoided_price", null);
    }

    public String getCaptchaAvoidedSku() {
        return getPrefString("captcha_avoided_sku", null);
    }

    public String getCaptchaAvoidedText() {
        return getPrefString("captcha_avoided_text", null);
    }

    public String getCaptchaAvoidedToken() {
        return getPrefString("captcha_avoided_token", null);
    }

    public int getCaptchaDifficulty(CaptchaInfo captchaInfo) {
        long prefStringLong = getPrefStringLong(getCaptchaDifficultyKey(captchaInfo), -1L);
        Logger.logInfo("Captcha difficulty key get " + prefStringLong);
        return prefStringLong == -1 ? (int) getPrefStringLong("captcha_difficulty", 1L) : (int) prefStringLong;
    }

    public int getCaptchaId(Alarm alarm) {
        int i;
        return (alarm == null || (i = alarm.captcha) == -1) ? getDefaultCaptchaId() : i;
    }

    public CaptchaInfo getCaptchaInfo(Alarm alarm) {
        int i;
        return (alarm == null || (i = alarm.captcha) == -1) ? getCaptchaInfo(getDefaultCaptchaId()) : getCaptchaInfo(i);
    }

    public int getCaptchaSuppressMode() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        try {
            return Integer.parseInt(defaultSharedPreferences.getString("suppress_alarm_mode_when_captcha_active", defaultSharedPreferences.getBoolean("suppress_alarm_when_captcha_active", true) ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO));
        } catch (NumberFormatException e) {
            Logger.logWarning("Captcha: Suppress mode resolving failed.", e);
            return 1;
        }
    }

    public String getChartTrendLastSelectedGraphTitle() {
        return getDefaultSharedPreferences(this.context).getString("chart_trend_last_selected_title", null);
    }

    public String getChartTrendLastSelectedGraphTitleFromCard() {
        return getDefaultSharedPreferences(this.context).getString("chart_trend_last_selected_title_2", null);
    }

    public float getChronotype() {
        return getDefaultSharedPreferences(this.context).getFloat("chronotype", -1.0f);
    }

    public String getCountry() {
        return getPrefString("country", Locale.getDefault().getCountry());
    }

    public String getCountryNull() {
        return getPrefString("country", null);
    }

    public int getCurrentAlarm() {
        return getPrefStringAsInt("key_current_alarm", -1);
    }

    public long getCurrentAlarmTime() {
        return getPrefLong("key_current_alarm_time", -1L);
    }

    public float getCurrentAvgMidSleep() {
        return getPrefFloatAsString("current_avg_mid_sleep", -1.0f);
    }

    public float getCurrentAvgSleepLength() {
        return getPrefFloatAsString("current_avg_sleep_length", -1.0f);
    }

    public Goal getCurrentGoal() {
        String prefString = getPrefString("current_goal", null);
        if (prefString == null) {
            return null;
        }
        Logger.logInfo("Goal: load ".concat(prefString));
        return Goal.fromSerialized(prefString);
    }

    public String getCurrentGoalPrice() {
        return getPrefString("current_goal_price", null);
    }

    public String getCustomWearablePackageName() {
        return getPrefString("custom_wearable_addon_package", null);
    }

    public int getDayCutOffHour() {
        return getPrefStringAsInt("day_incidence_hour", 0);
    }

    public Sensitivity getDeepSleepSensitivity() {
        double prefDoubleAsString = getPrefDoubleAsString("non_deep_sleep_sensitivity", 2.0d);
        if (prefDoubleAsString == 6.0d) {
            return Sensitivity.VERY_LOW;
        }
        if (prefDoubleAsString == 3.0d) {
            return Sensitivity.LOW;
        }
        if (prefDoubleAsString == 2.0d) {
            return Sensitivity.MEDIUM;
        }
        if (prefDoubleAsString == 1.5d) {
            return Sensitivity.HIGH;
        }
        Logger.logWarning("Unknown DeepSleepSensitivity value: " + prefDoubleAsString);
        return Sensitivity.MEDIUM;
    }

    public CaptchaInfo getDefaultCaptcha() {
        return getCaptchaInfo(getDefaultCaptchaId());
    }

    public int getDefaultCaptchaId() {
        if (getDefaultSharedPreferences(this.context).contains("captcha_mode")) {
            return Integer.parseInt(getDefaultSharedPreferences(this.context).getString("captcha_mode", String.valueOf(0)));
        }
        return 0;
    }

    public Uri getDefaultPhoneRingtone() {
        try {
            return RingtoneManager.getActualDefaultRingtoneUri(this.context, 4);
        } catch (Exception e) {
            Logger.logSevere(e);
            return null;
        }
    }

    public Set<String> getDefaultPlaylists() {
        return getDefaultSharedPreferences(this.context).getStringSet("selected_playlists_pref", new HashSet());
    }

    public String getDefaultRingtone() {
        String string = getDefaultSharedPreferences(this.context).getString("ringtone_pref", null);
        if (string == null) {
            try {
                return RingtoneManager.getActualDefaultRingtoneUri(this.context, 4) == null ? "" : RingtoneManager.getActualDefaultRingtoneUri(this.context, 4).toString();
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        return string;
    }

    public String getDefaultRingtoneName(String str) {
        String prefString = getPrefString("ringtone_name", str);
        return prefString == null ? this.context.getString(R.string.device_default) : prefString;
    }

    public Uri getDefaultRingtoneUri() {
        try {
            String string = getDefaultSharedPreferences(this.context).getString("ringtone_pref", null);
            return string == null ? RingtoneManager.getActualDefaultRingtoneUri(this.context, 4) : Uri.parse(string);
        } catch (Exception e) {
            Logger.logSevere(e);
            return null;
        }
    }

    public SharedPreferences getDefaultSharedPreferences(Context context) {
        return this.remoteProcess ? MultiprocessPreferences.getDefaultSharedPreferences(context) : PreferenceManager.getDefaultSharedPreferences(context);
    }

    public int getDimMode() {
        int i = Integer.parseInt(getDefaultSharedPreferences(this.context).getString("dimm", "-1"));
        Logger.logDebug("Dim property " + i);
        if (i == -1 || i == 3) {
            return 4;
        }
        return i;
    }

    public String[] getEligibleAddonPackages() {
        String str;
        Wearable selectedWearable = getSelectedWearable();
        if (selectedWearable == Wearable.CUSTOM && getCustomWearablePackageName() != null) {
            return new String[]{getCustomWearablePackageName()};
        }
        if (selectedWearable != null && (str = selectedWearable.addonPackageName) != null) {
            return new String[]{str};
        }
        HashSet hashSet = new HashSet();
        for (Wearable wearable : Wearable.values()) {
            String str2 = wearable.addonPackageName;
            if (str2 != null) {
                hashSet.add(str2);
            }
        }
        if (getCustomWearablePackageName() != null) {
            hashSet.add(getCustomWearablePackageName());
        }
        return (String[]) hashSet.toArray(new String[0]);
    }

    public long getExtendTrialCount() {
        return getPrefLong("key_reward_extend_trial_count", 0L);
    }

    public long getExtendTrialTime() {
        return getPrefLong("key_reward_extend_trial_days", -1L);
    }

    public int getFirstDayOfWeek() {
        int prefStringAsInt = getPrefStringAsInt("week_start", -1);
        return prefStringAsInt == -1 ? Calendar.getInstance().getFirstDayOfWeek() : prefStringAsInt;
    }

    public long getGeoTimeFrom() {
        return getPrefLong("geo_from_time", -1L);
    }

    public List<String> getGeos() {
        return loadList("key_geo", ";");
    }

    public int getGoalDetailsSelectedTab() {
        return getPrefInt("goal_details_selected_tab", 1);
    }

    public String getGoogleCalendarAccount() {
        return getPrefString("google_calendar_account_name", null);
    }

    public String getGoogleCalendarAccountPrevious() {
        return getPrefString("google_calendar_account_name_previous", null);
    }

    public int getGoogleCalendarAlarmAdvanceInMinutes() {
        return getPrefInt("google_calendar_alarm_advance", 60);
    }

    public int getGoogleCalendarRecordCount() {
        return getPrefInt("google_calendar_record_count", 0);
    }

    public int getGoogleFitRecordCount() {
        return getPrefInt("google_fit_record_count", 0);
    }

    public int getGoogleFitSyncManualDays(int i) {
        return getPrefInt("google_fit_sync_manual_days", i);
    }

    public int getGoogleFitSyncServiceDays(int i) {
        return getPrefInt("google_fit_sync_service_days", i);
    }

    public String getGoogleHomeAutomation(String str, int i) {
        String prefString = getPrefString(str, null);
        if (prefString != null) {
            String[] strArrSplit = prefString.split(";;;");
            if (strArrSplit.length == 2) {
                return strArrSplit[i];
            }
        }
        return null;
    }

    public String getGoogleHomeAutomationId(String str) {
        return getGoogleHomeAutomation(str, 0);
    }

    public String getGoogleHomeAutomationName(String str) {
        return getGoogleHomeAutomation(str, 1);
    }

    public int getGradualVibration() {
        return getPrefStringAsInt("gradual_vibration_new", 60000);
    }

    public int getGradualVibrationLegacy() {
        return getPrefStringAsInt("gradual_vibration", -100);
    }

    public int getGradualVibrationSmartwatch() {
        return getPrefStringAsInt("gradual_vibration_smartwatch_new", 60000);
    }

    public int getGradualVibrationSmartwatchLegacy() {
        return getPrefStringAsInt("gradual_vibration_smartwatch", -100);
    }

    public int getGradualVolumeIncreaseDuration() {
        return getPrefStringAsInt("alarm_increasing_volume_duration", 60000);
    }

    public int getGraphColorTheme() {
        return getPrefStringAsInt("graph_color_theme", 0);
    }

    public int getHomeScreenIcon(int i) {
        return i != 0 ? i != 1 ? i != 2 ? isDashboard() ? R.drawable.ic_dashboard : isAlarmOnly() ? R.drawable.ic_alarm : R.drawable.ic_tab : R.drawable.ic_alarm : R.drawable.ic_tab : R.drawable.ic_dashboard;
    }

    public float getIdealSleepLegacy() {
        return getPrefFloatAsString("target_sleep_time", 7.0f);
    }

    public int getIdealSleepMinutes() {
        return getPrefInt("target_sleep_time_minutes", Math.round(getIdealSleepLegacy() * 60.0f));
    }

    public String getIftttKey() {
        return getPrefString("> ", "");
    }

    public TimeZone getJetLagTargetTimezone() {
        try {
            String prefString = getPrefString("jetlag_tz", null);
            if (prefString != null) {
                return DesugarTimeZone.getTimeZone(prefString);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public long getLastActionTime(String str) {
        return getPrefLong(getLastActionKey(str), -1L);
    }

    public long getLastCaptchaSolvedTimestamp() {
        return getPrefLong("key_last_captcha_solved", 0L);
    }

    public int getLastDndMode() {
        return getDefaultSharedPreferences(this.context).getInt("key_last_dnd_mode", -1);
    }

    public List<Integer> getLastNapMinutes() {
        String string = getDefaultSharedPreferences(this.context).getString("key_nap_minutes_multi", "");
        if (string.isEmpty()) {
            string = String.valueOf(getLastNapMinutesLegacy());
        }
        String[] strArrSplit = string.split("-");
        LinkedList linkedList = new LinkedList();
        for (String str : strArrSplit) {
            linkedList.add(Integer.valueOf(str));
        }
        int[] iArr = {15, 30, 60};
        for (int i = 0; i < 3; i++) {
            int i2 = iArr[i];
            if (linkedList.size() >= 3) {
                break;
            }
            linkedList.remove(new Integer(i2));
            linkedList.add(Integer.valueOf(i2));
        }
        return linkedList;
    }

    public long getLastNoisesDelete() {
        return getDefaultSharedPreferences(this.context).getLong("key_last_recording_delete", -1L);
    }

    public long getLastNonSnoozeAlarm() {
        return getDefaultSharedPreferences(this.context).getLong("key_settings_last_non_snooze_alarm", -1L);
    }

    public int getLastRingerMode() {
        return getDefaultSharedPreferences(this.context).getInt("key_last_ringer_mode", 2);
    }

    public int getLastSnoozeMinutes() {
        return getDefaultSharedPreferences(this.context).getInt("key_snooze_minutes", 10);
    }

    public int getLatestNapMinutes() {
        String string = getDefaultSharedPreferences(this.context).getString("key_nap_minutes_multi", "");
        if (string == null || string.equals("")) {
            string = String.valueOf(getLastNapMinutesLegacy());
        }
        return Integer.parseInt(string.split("-")[0]);
    }

    public int getLegacyRecordingThreshold() {
        return getPrefStringAsInt("sleep_recording_threshold", 2);
    }

    public int getLicenseChecker() {
        return getPrefInt("key_lc", 0);
    }

    public Location getLocation() {
        float f = getDefaultSharedPreferences(this.context).getFloat("key_location_lat", -1.0f);
        float f2 = getDefaultSharedPreferences(this.context).getFloat("key_location_lon", -1.0f);
        if (f == -1.0f || f2 == -1.0f) {
            return null;
        }
        return new Location(f, f2);
    }

    public int getLoggingLevel() {
        return getPrefStringAsInt("logging_level", 0);
    }

    public int getLucidAfterHours() {
        return getPrefStringAsInt("lucid_after", 0);
    }

    public boolean getLucidEnabled() {
        String prefString = getPrefString("lucid_enabled2", "");
        if (prefString != null) {
            return prefString.equals("enabled") || prefString.equals("enable");
        }
        return false;
    }

    public int getLucidLoop() {
        return getPrefStringAsInt("lucid_loop", 3);
    }

    public String getLucidRingtone() {
        String string = getDefaultSharedPreferences(this.context).getString("lucid_ringtone", null);
        return string == null ? "android.resource://com.urbandroid.sleep/raw/dreaming" : string;
    }

    public int getLucidSensitivity() {
        return getPrefStringAsInt("lucid_sensitivity", 2);
    }

    public int getLucidVolume() {
        return getDefaultSharedPreferences(this.context).getInt("lucid_volume", 50);
    }

    public int getLullabyAutoPlaylist() {
        return getPrefStringAsInt("lullaby_auto_playlist", 600000);
    }

    public int getLullabyAutoPlaylistSize() {
        return getPrefStringAsInt("lullaby_auto_playlist_size", 1);
    }

    public LullabyPlayer.Lullaby[] getLullabyByUsed() {
        List<String> listLoadList = loadList("lullaby_popchart", ";");
        LullabyPlayer.Lullaby[] lullabyArrValues = LullabyPlayer.Lullaby.values();
        if (!listLoadList.isEmpty()) {
            Iterator<String> it = listLoadList.iterator();
            int i = 0;
            while (it.hasNext()) {
                try {
                    lullabyArrValues[i] = LullabyPlayer.Lullaby.valueOf(it.next());
                    i++;
                } catch (Exception unused) {
                }
            }
        }
        return lullabyArrValues;
    }

    public int getLullabyRandomVolume() {
        return getDefaultSharedPreferences(this.context).getInt("lullaby_random_volume", 80);
    }

    public int getLullabyVolume() {
        return getDefaultSharedPreferences(this.context).getInt("lullaby_volume", 90);
    }

    public int getLullabyVolumeDownAfter() {
        int lullabyVolumeDownAfterOneTime = getLullabyVolumeDownAfterOneTime();
        if (lullabyVolumeDownAfterOneTime == -1) {
            return getPrefStringAsInt("media_decreasing_volume_after", -1);
        }
        setLullabyVolumeDownAfterOneTime(-1);
        return lullabyVolumeDownAfterOneTime;
    }

    public int getLullabyVolumeDownAfterOneTime() {
        return getPrefStringAsInt("media_decreasing_volume_after_one_time", -1);
    }

    public String getMarketingCampaign() {
        return getPrefString("key_mark_campaign", null);
    }

    public String getMarketingMedium() {
        return getPrefString("key_mark_medium", null);
    }

    public int getMarketingScore() {
        return getPrefInt("key_mark_score", -1);
    }

    public String getMarketingSegment() {
        return getPrefString("key_mark_segment", null);
    }

    public String getMarketingSource() {
        return getPrefString("key_mark_source", null);
    }

    public int getMaxGeoFreq() {
        return getPrefInt("key_max_geo_freq", 0);
    }

    public int getMeasuresPosition(SleepScore.ScoreMeasure scoreMeasure) {
        if (scoreMeasure == null) {
            return 0;
        }
        try {
            List<String> listLoadList = loadList("key_measure_order4", ";;;");
            if (listLoadList.isEmpty()) {
                return scoreMeasure.ordinal();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = listLoadList.iterator();
            while (it.hasNext()) {
                arrayList.add(SleepScore.ScoreMeasure.valueOf(it.next()));
            }
            int iIndexOf = arrayList.indexOf(scoreMeasure);
            return iIndexOf >= 0 ? iIndexOf : scoreMeasure.ordinal();
        } catch (Exception e) {
            Logger.logSevere(e);
            return scoreMeasure.ordinal();
        }
    }

    public int getMediaListExpandedMask() {
        return 0;
    }

    public Long getMeditationSessionId() {
        return Long.valueOf(getDefaultSharedPreferences(this.context).getLong("key_meditation_session_id", -1L));
    }

    public String getMeditationSessionName() {
        return getDefaultSharedPreferences(this.context).getString("key_meditation_session_name", null);
    }

    public long getMinutesToAlarm() {
        Date nextAlarm = getNextAlarm();
        if (nextAlarm != null) {
            return ((nextAlarm.getTime() - new Date().getTime()) / 60000) + 1;
        }
        return 10080L;
    }

    public int getMorningScreen() {
        return getPrefStringAsInt("morning_screen", 1);
    }

    public String getMqttClientId() {
        return getPrefString("mqtt_client_id", "SleepAsAndroid");
    }

    public String getMqttServerUrl() {
        return getPrefString("mqtt_server_url", "");
    }

    public String getMqttTopic() {
        return getPrefString("mqtt_topic", "SleepAsAndroid");
    }

    public String[] getNFCCaptcha() {
        return getCodeCaptcha("nfc_captcha_code_new");
    }

    public int getNewsShown() {
        return getPrefInt("news_card_shown", 0);
    }

    public Date getNextAlarm() {
        return getDate("key_settings_next_scheduled_alarm");
    }

    public long getNextMediaStoreJob() {
        return getDefaultSharedPreferences(this.context).getLong("key_next_media_store_job", -1L);
    }

    public PromoEvent getNextPromo() {
        PromoEvent promoEventFromString = PromoEvent.fromString(getPrefString("key_next_promo", null));
        return ((promoEventFromString == null || !promoEventFromString.getInterval().isIn(System.currentTimeMillis())) && isSpecialPromoActive()) ? new PromoEvent(new Interval(getSpecialPromoStartTime(), getSpecialPromoEndTime()), 50) : promoEventFromString;
    }

    public long getNextSleepTrackingRestartTimestamp() {
        return getPrefLong("next_sleep_tracking_restart_timestamp", -1L);
    }

    public Date getNextTimeToBed() {
        return getDate("key_settings_next_time_to_bed");
    }

    public int getNoAlarmBedtime(Calendar calendar) {
        return getPrefInt(SettingKeys.NO_ALARM_BEDTIME_ARRAY[calendar.get(7) - 1], 1200);
    }

    public int getNoAlarmBedtimeHour(Calendar calendar) {
        return getNoAlarmBedtime(calendar) / 60;
    }

    public int getNoAlarmBedtimeHourByKey(String str) {
        return getPrefInt(str, 1200) / 60;
    }

    public int getNoAlarmBedtimeMinute(Calendar calendar) {
        return getNoAlarmBedtime(calendar) % 60;
    }

    public long getNoAlarmBedtimeTime(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.add(12, -1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j);
        calendar2.set(11, getNoAlarmBedtimeHour(calendar2));
        calendar2.set(12, getNoAlarmBedtimeMinute(calendar2));
        if (calendar2.before(calendar)) {
            calendar2.add(5, 1);
            calendar2.set(11, getNoAlarmBedtimeHour(calendar2));
            calendar2.set(12, getNoAlarmBedtimeMinute(calendar2));
        }
        return calendar2.getTimeInMillis();
    }

    public long getNoAlarmBedtimeTimeByKey(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, getNoAlarmBedtimeHourByKey(str));
        calendar.set(12, getNoAlarmBedtimeminuteByKey(str));
        return calendar.getTimeInMillis();
    }

    public int getNoAlarmBedtimeminuteByKey(String str) {
        return getPrefInt(str, 1200) % 60;
    }

    public Uri getNoiseDirUri() {
        String deviceSpecificKey = getDeviceSpecificKey("key_noise_dir_uri");
        String prefString = getPrefString(deviceSpecificKey, null);
        if (prefString == null && (prefString = getPrefString("key_noise_dir_uri", null)) != null) {
            save(deviceSpecificKey, prefString);
            clear("key_noise_dir_uri");
        }
        if (prefString == null) {
            return null;
        }
        return Uri.parse(prefString);
    }

    public int getNoiseInput() {
        return getPrefStringAsInt("noise_input", 0);
    }

    public int getNoiseOutput() {
        return getPrefStringAsInt("noise_output", 0);
    }

    public String getNoiseStoragePath() {
        return getPrefString("noise_storage_path", NoiseDirectory.getDefaultStoragePath(this.context));
    }

    public String getNoiseWritableStoragePath() {
        File file = new File(getNoiseStoragePath());
        return !Environment.isWritable(file) ? NoiseDirectory.getDefaultStoragePath(this.context) : file.getAbsolutePath();
    }

    public String getOldNoiseStoragePath() {
        return getPrefString("noise_storage_path", Environment.getExternalPublicWriteableStorage().getAbsolutePath());
    }

    public synchronized List<OnlineRadioRingtones.Radio> getOnlineRadios(String str) {
        ArrayList arrayList;
        try {
            List<String> listLoadList = loadList(str, ConfigurationKt.DELIMITER);
            arrayList = new ArrayList();
            Iterator<String> it = listLoadList.iterator();
            while (it.hasNext()) {
                arrayList.add(parseRadio(it.next()));
            }
            Collections.sort(arrayList, new Settings$$ExternalSyntheticLambda0(0));
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public String getPairTrackingToken() {
        return getPrefString("pair_tracking_token", null);
    }

    public int getPerAlarmIdealSleepMinutes(Alarm alarm) {
        return (alarm == null || alarm.extendedConfig.getIdealSleepMinutes() == null) ? getIdealSleepMinutes() : alarm.extendedConfig.getIdealSleepMinutes().intValue();
    }

    public String getPlayStoreReferrer() {
        return getPrefString("play_store_referrer_url", null);
    }

    public long getPlaylistPosition() {
        return getPrefLong("playlist_position", 0L);
    }

    public PolarDeviceInfo getPolarSdkDevice() {
        try {
            String[] strArrSplit = getPrefString("polar_sdk_device", null).split(";;;");
            return new PolarDeviceInfo(strArrSplit[0], strArrSplit[1], 0, strArrSplit[2], true, true, false);
        } catch (Exception e) {
            Logger.logSevere(e);
            return null;
        }
    }

    public boolean getPrefBoolean(String str, boolean z) {
        return getDefaultSharedPreferences(this.context).getBoolean(str, z);
    }

    public String getPrefString(String str, String str2) {
        return getDefaultSharedPreferences(this.context).getString(str, str2);
    }

    public long getPromoAttemptTime() {
        return getPrefLong("key_next_promo_attempt", -1L);
    }

    public int getPromoShown() {
        return getPrefInt("promo_card_shown", 0);
    }

    public String[] getQRCaptcha() {
        return getCodeCaptcha("qr_captcha_code_new");
    }

    public synchronized OnlineRadioRingtones.Radio getRadioByName(String str) {
        ArrayList<OnlineRadioRingtones.Radio> arrayList = new ArrayList();
        arrayList.addAll(getOnlineRadios("key_online_radios"));
        arrayList.addAll(getOnlineRadios("key_online_radios_featured"));
        for (OnlineRadioRingtones.Radio radio : arrayList) {
            if (radio.title.equals(str)) {
                return radio;
            }
        }
        return null;
    }

    public long getRateDoneTs() {
        return getPrefLong("rate_done_ts_e", -1L);
    }

    public long getRateLater() {
        return getDefaultSharedPreferences(this.context).getLong("rate_later_b", -1L);
    }

    public long getRateLaterPlayStore() {
        return getDefaultSharedPreferences(this.context).getLong("rate_later_play_store", -1L);
    }

    public int getRateShownCount() {
        return getPrefInt("rate_shown_count_g", 0);
    }

    public int getRateSleepLater() {
        return getPrefStringAsInt("rate_sleep_later", 0);
    }

    public boolean getRecordingAntisnore() {
        return getRecordingAntisnoreResponse() > 0;
    }

    public int getRecordingAntisnoreResponse() {
        return getPrefStringAsInt("anti_snoring_response", 0);
    }

    public int getRecordingThreshold() {
        return getDefaultSharedPreferences(this.context).getInt("sleep_recording_threshold2", 15);
    }

    public int getRecordsCount() {
        return getDefaultSharedPreferences(this.context).getInt("records_count", -1);
    }

    public int getSamsungSHealthRecordCount() {
        return getPrefInt("samsung_shealth_record_count", 0);
    }

    public int getSelectedHomeScreen() {
        if (isDashboard()) {
            return 0;
        }
        return isAlarmOnly() ? 2 : 1;
    }

    public Wearable getSelectedWearable() {
        String prefString = getPrefString("selected_wearable", null);
        if (prefString != null) {
            return Wearable.valueOf(prefString);
        }
        return null;
    }

    public List<String> getShowCaseShown() {
        return loadList("showcase_settings_shown2", ConfigurationKt.DELIMITER);
    }

    public String getSirenRingtone() {
        String string = getDefaultSharedPreferences(this.context).getString("siren_ringtone", null);
        return string == null ? "android.resource://com.urbandroid.sleep/raw/classic" : string;
    }

    public long getSleepApiLastSuggestion() {
        return getDefaultSharedPreferences(this.context).getLong("key_use_google_sleep_last_suggestion", -1L);
    }

    public String getSleepMaskBtAddress() {
        return getPrefString("sleep_mask_bt_address", null);
    }

    public String getSleepPhaserAddress() {
        return getPrefString("smartlight_sleep_phaser_address", null);
    }

    public SleepScore getSleepScore() {
        return new SleepScore(getPrefInt("sleep_score", -1), getPrefInt("sleep_score_max", 0));
    }

    public long getSleepTimeSuggestionLastNotificationTime() {
        return getPrefLong("sleep_time_suggestion_last_notification_time", -1L);
    }

    public SleepTimeSuggestionManager.Mode getSleepTimeSuggestionMode() {
        if (isAlarmOnly()) {
            return SleepTimeSuggestionManager.Mode.DISABLED;
        }
        String prefString = getPrefString("sleep_time_suggestion_selected_mode", null);
        boolean zIsActivitySensorBatchingSupported = ContextExtKt.isActivitySensorBatchingSupported(this.context);
        if (prefString != null) {
            SleepTimeSuggestionManager.Mode modeFindOrNull = SleepTimeSuggestionManager.Mode.findOrNull(Integer.valueOf(prefString).intValue());
            return modeFindOrNull == null ? zIsActivitySensorBatchingSupported ? SleepTimeSuggestionManager.Mode.MANUAL : SleepTimeSuggestionManager.Mode.DISABLED : modeFindOrNull;
        }
        SleepTimeSuggestionManager.Mode mode = (isSleepTimeSuggestion() && zIsActivitySensorBatchingSupported) ? SleepTimeSuggestionManager.Mode.MANUAL : SleepTimeSuggestionManager.Mode.DISABLED;
        setSleepTimeSuggestionMode(mode);
        return mode;
    }

    public long getSleepTimeSuggestionScheduledNotificationTime() {
        return getPrefLong("sleep_time_suggestion_scheduled_notification_time", -1L);
    }

    public int getSmartWakeupMinutes() {
        return getPrefStringAsInt("non_deep_sleep_window", 30);
    }

    public int getSmartWakeupNapMinutes() {
        return getPrefStringAsInt("non_deep_sleep_window_nap", 5);
    }

    public int getSmartWakeupSensitivityChecks() {
        return getPrefInt("non_deep_sleep_sensitivity_checks_new", -1) == -1 ? getSmartWakeupSensitivityChecksLegacy() : getPrefInt("non_deep_sleep_sensitivity_checks_new", 1);
    }

    public int getSmartWakeupSensitivityChecksLegacy() {
        return getPrefStringAsInt("non_deep_sleep_sensitivity_checks", 1);
    }

    public int getSmartlightMaskIntensity() {
        return getDefaultSharedPreferences(this.context).getInt("smartlight_mask_intensity", 80);
    }

    public float getSmartlightMaxIntensity() {
        return getPrefInt("smartlight_max_intensity", 100) / 100.0f;
    }

    public synchronized int getSmartlightPeelightTime() {
        try {
        } catch (Exception e) {
            Logger.logSevere(e);
            return 30;
        }
        return getPrefStringAsInt("smartlight_peelight_time", isSmartlightPeelightEnabled() ? 30 : -1);
    }

    public int getSmartwatchAlarmDelay(Alarm alarm, boolean z, Context context, boolean z2) {
        int smartWatchVibrationDelay = alarm.getSmartWatchVibrationDelay(context);
        if (z2 && smartWatchVibrationDelay == -20000) {
            smartWatchVibrationDelay = 0;
        }
        if (smartWatchVibrationDelay > 0 && Experiments.getInstance().isNoDelayInSnooze() && z) {
            return 0;
        }
        return smartWatchVibrationDelay;
    }

    public long getSnoozeAllowedTill() {
        return getPrefLong("key_snooze_allowed_till", -1L);
    }

    public int getSnoozeDuration(Alarm alarm) {
        if (alarm == null || alarm.extendedConfig.getSnoozeDuration().intValue() == -2) {
            int prefStringAsInt = 10;
            try {
                prefStringAsInt = getPrefStringAsInt("snooze_duration", 10);
            } catch (NumberFormatException unused) {
            }
            return prefStringAsInt == -1 ? getLastSnoozeMinutes() : prefStringAsInt;
        }
        if (alarm.extendedConfig.getSnoozeDuration().intValue() != -1) {
            return alarm.extendedConfig.getSnoozeDuration().intValue();
        }
        int lastSnoozeMinutes = getLastSnoozeMinutes();
        if (lastSnoozeMinutes <= 0) {
            return 5;
        }
        return lastSnoozeMinutes;
    }

    public String getSnoozeDurationValue() {
        return getPrefString("snooze_duration", "10");
    }

    public int getSnoozeDurationValueInt() {
        return getPrefStringAsInt("snooze_duration", 10);
    }

    public int getSnoozeLimit(Alarm alarm) {
        if (alarm != null && alarm.extendedConfig.getSnoozeLimit().intValue() != -2) {
            return alarm.extendedConfig.getSnoozeLimit().intValue();
        }
        try {
            return getPrefStringAsInt("snooze_limit", 0);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public int getSnoozeRepeat() {
        int prefStringAsInt = 0;
        try {
            prefStringAsInt = getPrefStringAsInt("snooze_repeat", 0);
        } catch (NumberFormatException unused) {
        }
        zza$$ExternalSyntheticOutline0.m(prefStringAsInt, "SnoozeRepeat: get repeat ");
        return prefStringAsInt;
    }

    public int getSnoozeTotalTimeLimit(Alarm alarm) {
        if (alarm != null) {
            Integer snoozeTotalTimeLimit = alarm.extendedConfig.getSnoozeTotalTimeLimit();
            if (snoozeTotalTimeLimit.intValue() == 0) {
                return Integer.MAX_VALUE;
            }
            if (snoozeTotalTimeLimit.intValue() == -1) {
                return getLastSnoozeMinutes();
            }
            if (snoozeTotalTimeLimit.intValue() != -2) {
                return snoozeTotalTimeLimit.intValue();
            }
        }
        int prefStringAsInt = 0;
        try {
            prefStringAsInt = getPrefStringAsInt("snooze_max_time_limit", Integer.MAX_VALUE);
            if (prefStringAsInt == -1) {
                return getLastSnoozeMinutes();
            }
            if (prefStringAsInt == 0 || prefStringAsInt == -2) {
                return Integer.MAX_VALUE;
            }
            return prefStringAsInt;
        } catch (NumberFormatException unused) {
            return prefStringAsInt;
        }
    }

    public SonarConfig.SonarMethod getSonarMethod() {
        try {
            return SonarConfig.SonarMethod.valueOf(getPrefString(getDeviceSpecificKey("sonar_method"), SonarConfig.SonarMethod.CHIRP_18_20.name()));
        } catch (IllegalArgumentException unused) {
            return SonarConfig.SonarMethod.CHIRP_18_20;
        }
    }

    public int getSonarRevertVolume() {
        return getPrefInt("sonar_revert_volume", -1);
    }

    public int getSonarSignalStrength() {
        int prefInt = getPrefInt(getDeviceSpecificKey("sonar_signal_strength2"), -1);
        return prefInt == -1 ? getPrefInt("sonar_signal_strength2", -1) : prefInt;
    }

    public int getSonarStream() {
        return 3;
    }

    public int getSonarVolume(int i) {
        int streamMaxVolume = ((AudioManager) this.context.getSystemService("audio")).getStreamMaxVolume(i);
        int prefInt = getPrefInt(getDeviceSpecificKey("sonar_volume_offset"), 1);
        int iMin = Math.min(streamMaxVolume, Math.max(streamMaxVolume / 4, streamMaxVolume - prefInt));
        zza$$ExternalSyntheticOutline0.m(iMin, prefInt, "Sonar: volume ", " offset ");
        return iMin;
    }

    public int getSoundDelay() {
        return getPrefStringAsInt("alarm_sound_delay", 0);
    }

    public String getSoundRecognitionEnabledNames() {
        if (!isSnoringDetection()) {
            return this.context.getResources().getString(R.string.disabled);
        }
        StringBuilder sb = new StringBuilder();
        if (getSoundRecognitionSensitivitySnoring() > 0) {
            sb.append(this.context.getResources().getString(R.string.stats_caption_snore));
            sb.append(", ");
        }
        if (getSoundRecognitionSensitivityTalk() > 0) {
            sb.append(this.context.getResources().getString(R.string.talk));
            sb.append(", ");
        }
        if (getSoundRecognitionSensitivityBabyCry() > 0) {
            sb.append(this.context.getResources().getString(R.string.sound_baby_cry));
            sb.append(", ");
        }
        if (getSoundRecognitionSensitivityLaughter() > 0) {
            sb.append(this.context.getResources().getString(R.string.sound_laughter));
            sb.append(", ");
        }
        if (getSoundRecognitionSensitivitySick() > 0) {
            sb.append(this.context.getResources().getString(R.string.sound_sick));
            sb.append(", ");
        }
        if (sb.length() <= 0) {
            return this.context.getResources().getString(R.string.disabled);
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public String getSoundRecognitionEnabledNamesForAwake() {
        if (isSnoringDetection()) {
            StringBuilder sb = new StringBuilder();
            if (getSoundRecognitionSensitivityTalk() > 0) {
                sb.append(this.context.getResources().getString(R.string.talk));
                sb.append(", ");
            }
            if (getSoundRecognitionSensitivityBabyCry() > 0) {
                sb.append(this.context.getResources().getString(R.string.sound_baby_cry));
                sb.append(", ");
            }
            if (getSoundRecognitionSensitivitySick() > 0) {
                sb.append(this.context.getResources().getString(R.string.sound_sick));
                sb.append(", ");
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 2, sb.length());
                return sb.toString();
            }
        }
        return "";
    }

    public int getSoundRecognitionSensitivityBabyCry() {
        return getPrefInt("sound_recognition_baby_cry", 2);
    }

    public int getSoundRecognitionSensitivityLaughter() {
        return getPrefInt("sound_recognition_laughter", 2);
    }

    public int getSoundRecognitionSensitivitySick() {
        return getPrefInt("sound_recognition_sick", 2);
    }

    public int getSoundRecognitionSensitivitySnoring() {
        return getPrefInt("sound_recognition_snoring", 2);
    }

    public int getSoundRecognitionSensitivityTalk() {
        return getPrefInt("sound_recognition_talk", 2);
    }

    public long getSpecialPromoEndTime() {
        long prefLong = getPrefLong("special_promo", -1L);
        return prefLong > 0 ? prefLong + TimeChart.DAY : prefLong;
    }

    public long getSpecialPromoStartTime() {
        return getPrefLong("special_promo", -1L);
    }

    public List<SpotifyServiceExecutor.SpotifyUri> getSpotifyAlbums() {
        String string = this.context.getSharedPreferences("spotify", 0).getString("spotify_albums", null);
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            PrependSizeTokenizer prependSizeTokenizer = new PrependSizeTokenizer(string);
            while (prependSizeTokenizer.hasToken()) {
                SpotifyServiceExecutor.SpotifyUri spotifyUriDeserialize = SpotifyServiceExecutor.SpotifyUri.INSTANCE.deserialize(prependSizeTokenizer.nextToken());
                if (spotifyUriDeserialize != null) {
                    arrayList.add(spotifyUriDeserialize);
                }
            }
        }
        return arrayList;
    }

    public String getSpotifyProduct() {
        return getPrefString("spotify_product", null);
    }

    public String getSpotifyToken() {
        return getPrefString("spotify_token", null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public int getTabCount() {
        ?? IsTabDashboard = isTabDashboard();
        int i = IsTabDashboard;
        if (isTabStats()) {
            i = IsTabDashboard + 1;
        }
        int i2 = i;
        if (isTabGraphs()) {
            i2 = i + 1;
        }
        return isTabNoise() ? i2 + 1 : i2;
    }

    public int getTemperature() {
        return getPrefStringAsInt("settings_temperature", -1);
    }

    public int getTheme(int i) {
        if (SharedApplicationContext.isManufacturer("kyocera")) {
            return 2;
        }
        return i == 3 ? getBedtimeSunsetTheme() : i;
    }

    public int getThemeValue() {
        return getPrefStringAsInt("theme", Build.VERSION.SDK_INT >= 30 ? 4 : 0);
    }

    public long getTimeDifference() {
        return getPrefLong("key_time_diff_internal", 0L);
    }

    public int getTimeToBed(Alarm alarm) {
        int timeToBed;
        if (alarm != null && (timeToBed = alarm.extendedConfig.getTimeToBed()) != -2 && timeToBed != 0) {
            return timeToBed;
        }
        int prefStringAsInt = getPrefStringAsInt("target_sleep_time_notify_before", -3);
        return prefStringAsInt == -3 ? getPrefBoolean("target_sleep_time_notify", true) ? 15 : -1 : prefStringAsInt;
    }

    public int getTimeToBedBefore() {
        return getPrefStringAsInt("target_sleep_time_notify_before", 15);
    }

    public int getTimeToBedRepeat() {
        return getPrefStringAsInt("time_to_bed_repeat", -1);
    }

    public String getTimeToBedRingtone() {
        return getDefaultSharedPreferences(this.context).getString("time_to_bed_ringtone", null);
    }

    public int getTrackingDelay() {
        return getPrefStringAsInt("delay_tracking", 0);
    }

    public int getTutorialPage() {
        return getPrefInt("tutorial_page", 0);
    }

    public List<String> getUsedLullabies() {
        return loadList("lullaby_popchart", ";");
    }

    public HealthUserProfile getUserProfile() {
        long prefLong = getPrefLong("health_user_profile_birthdate", 0L);
        Date date = prefLong == 0 ? null : new Date(prefLong);
        HealthUserProfile.Gender gender = HealthUserProfile.Gender.UNKNOWN;
        HealthUserProfile.Gender genderValueOf = HealthUserProfile.Gender.valueOf(getPrefString("health_user_profile_gender", gender.name()));
        SharedPreferences defaultSharedPreferences = getDefaultSharedPreferences(this.context);
        float f = defaultSharedPreferences.getFloat("health_user_profile_height", 0.0f);
        float f2 = defaultSharedPreferences.getFloat("health_user_profile_weight", 0.0f);
        if (date == null && genderValueOf == gender && f == 0.0f && f2 == 0.0f) {
            return null;
        }
        return new BaseHealthUserProfile(date, genderValueOf, f, f2);
    }

    public float getVolume(int i) {
        if (i < 100) {
            return 1.0f - (((float) Math.log(100 - i)) / ((float) Math.log(100.0d)));
        }
        return 1.0f;
    }

    public int getVolumeButtonBehavior() {
        return getPrefStringAsInt("volume_button_setting", 2);
    }

    public int getWakeLockSettings() {
        int i;
        try {
            i = Integer.parseInt(getDefaultSharedPreferences(this.context).getString("wake_lock", "4"));
        } catch (NumberFormatException e) {
            Logger.logWarning("Failed to parse wake lock settings", e);
            i = 4;
        }
        if (i == 6 || i == 2) {
            return 4;
        }
        return i;
    }

    public synchronized long getWakeUpCheckAfterAlarm() {
        return getPrefStringAsInt("captcha_wake_up_check_after_alarm", 300000);
    }

    public synchronized long getWakeUpCheckAfterNotification() {
        return getPrefStringAsInt("captcha_wake_up_check_after_notification", 600000);
    }

    public int getWakeUpCheckRepeat() {
        int prefStringAsInt = getPrefStringAsInt("captcha_wake_up_check_repeat", 1);
        zza$$ExternalSyntheticOutline0.m(prefStringAsInt, "WakeUpCheck: repeat settings ");
        return prefStringAsInt;
    }

    public int getWakeUpCheckRepeatCount() {
        int prefInt = getPrefInt("captcha_wake_up_check_repeat_counter", 0);
        zza$$ExternalSyntheticOutline0.m(prefInt, "WakeUpCheck: counter ");
        return prefInt;
    }

    public long getWakeUpCheckScheduled() {
        long prefLong = getPrefLong("captcha_wake_up_check_scheduled", -1L);
        Logger.logInfo("WakeUpCheck: get scheduled " + prefLong);
        return prefLong;
    }

    public long getWakeUpCheckScheduledAlarmId() {
        return getPrefLong("captcha_wake_up_check_scheduled_alarm_id", -1L);
    }

    public String getWebhooksUrl() {
        return getPrefString("webhooks_url", "");
    }

    public boolean hasBackupDirUri() {
        if (Environment.isLollipopOrGreater()) {
            return (getPrefString(getDeviceSpecificKey("key_backup_dir_uri"), null) == null && getPrefString("key_backup_dir_uri", null) == null) ? false : true;
        }
        return false;
    }

    public boolean hasDefaultCaptcha() {
        return getDefaultCaptchaId() != 0;
    }

    public boolean hasDefaultRingtone() {
        return getDefaultSharedPreferences(this.context).getString("ringtone_pref", null) == null;
    }

    public boolean hasNoiseDirUri() {
        if (Environment.isLollipopOrGreater()) {
            return (getPrefString(getDeviceSpecificKey("key_noise_dir_uri"), null) == null && getPrefString("key_noise_dir_uri", null) == null) ? false : true;
        }
        return false;
    }

    public synchronized boolean hasOnlineRadiosForUrl(String str, String str2) {
        return getOnlineRadios(str2).contains(new OnlineRadioRingtones.Radio(null, null, str));
    }

    public boolean hasPendingActiveAlarm() {
        return getActiveAlarmId() != -1;
    }

    public boolean hasPlayStoreReferrer() {
        return getPrefString("play_store_referrer_url", null) != null;
    }

    public boolean hasRequiredSampleRateForUltrasonicTracking() {
        int[] iArr = {48000, 44100};
        for (int i = 0; i < 2; i++) {
            int i2 = iArr[i];
            short s = new short[]{2}[0];
            short s2 = new short[]{16}[0];
            if (AudioRecord.getMinBufferSize(i2, 16, 2) != -2 && new AudioRecord(SonarConfig.RECORDING_INPUT, i2, s2, s, 16384).getState() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSleepPhaserOrSleepMask() {
        return getSleepPhaserAddress() != null ? isSleepPhaserSleepTracking() || isSleepPhaserSmartLight() || isSleepPhaserAutoStart() : getSleepMaskBtAddress() != null;
    }

    public void incRateShownCount() {
        save("rate_shown_count_g", getRateShownCount() + 1);
    }

    public void incRecordsCount() {
        setRecordsCount(getRecordsCount() + 1);
    }

    public void increaseAutoSnoozeRepeat() {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString("key_auto_kill_snooze_counter", "" + (getAutoSnoozeRepeat() + 1));
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public void increaseSnoozeRepeat() {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString("snooze_repeat", "" + (getSnoozeRepeat() + 1));
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
        Logger.logInfo("SnoozeRepeat: increase repeat ");
    }

    public void increaseWakeUpCheckRepeatCount() {
        int wakeUpCheckRepeatCount = getWakeUpCheckRepeatCount() + 1;
        save("captcha_wake_up_check_repeat_counter", wakeUpCheckRepeatCount);
        zza$$ExternalSyntheticOutline0.m(wakeUpCheckRepeatCount, "WakeUpCheck: inc ");
    }

    public boolean installWearableAddon(Wearable wearable) {
        if (wearable.isVendorInstalled(this.context)) {
            if (wearable.isAddonInstalled(this.context)) {
                return true;
            }
            ViewIntent.market(this.context, wearable.addonPackageName);
            return false;
        }
        String vendorDownloadLink = wearable.getVendorDownloadLink();
        Context context = this.context;
        if (vendorDownloadLink != null) {
            ViewIntent.url(context, wearable.getVendorDownloadLink());
        } else {
            ViewIntent.market(context, wearable.vendorPackageName);
        }
        return false;
    }

    public boolean is24HourFormat() {
        int prefStringAsInt = getPrefStringAsInt("hour_format", -1);
        return prefStringAsInt == -1 ? DateFormat.is24HourFormat(this.context) : prefStringAsInt == 24;
    }

    public boolean isActivityRecognitionNewSleepApi() {
        return getPrefBoolean("activity_recognition_new_sleep_api", false);
    }

    public boolean isAirplaneChanged() {
        return getPrefBoolean("key_airplane_changed", false);
    }

    public boolean isAirplaneModeAutomatic() {
        return getAirplaneMode() >= 1;
    }

    public boolean isAirplaneModeOn() {
        boolean zIsNewJellyBeanOrGreater = Environment.isNewJellyBeanOrGreater();
        Context context = this.context;
        return zIsNewJellyBeanOrGreater ? Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0 : Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public boolean isAlarmFullscreen() {
        return isAlarmFullscreenEnabled() || isFlipToSnooze();
    }

    public boolean isAlarmFullscreenEnabled() {
        return getPrefBoolean("alarm_fullscreen", false);
    }

    public boolean isAlarmInSilent() {
        return getDefaultSharedPreferences(this.context).getBoolean("alarm_in_silent_mode", true);
    }

    public boolean isAlarmInSilentResetNeeded() {
        boolean zEquals = "yes".equals(getPrefString("alarm_in_silent_reset", "yes"));
        if (zEquals) {
            Logger.logInfo("isAlarmInSilentResetNeeded");
            save("alarm_in_silent_reset", "no");
        }
        return zEquals;
    }

    public boolean isAlarmOnly() {
        return getPrefBoolean("alarm_only", false);
    }

    public boolean isAlarmPlaylistLooping() {
        return getPrefStringAsInt("playlist_mode", 0) == 2;
    }

    public boolean isAlarmPlaylistOrdered() {
        return getPrefStringAsInt("playlist_mode", 0) == 1;
    }

    public boolean isAlarmPlaylistShuffle() {
        return getPrefStringAsInt("playlist_mode", 0) == 0;
    }

    public boolean isAlarmSortByDay() {
        return getPrefStringAsInt("settings_alarm_sorting", 0) == 0;
    }

    public boolean isAllowSnoozeTimeChange() {
        return getDefaultSharedPreferences(this.context).getBoolean("snooze_time_change", true);
    }

    public boolean isAntiSnoringNotification() {
        return getPrefStringAsInt("anti_snoring_response", 0) == 4;
    }

    public boolean isAnyAwakeDetectionEnabled() {
        return isAwakeDetectionWhenUsingPhone() || isAwakeDetectionHighActivity() || isAwakeDetectionHr() || isAwakeDetectionLight() || isAwakeDetectionSnooze() || isAwakeDetectionTalk();
    }

    public boolean isAnyRecordingFeatureEnabled() {
        return isNoiseStatsCollectingEnabled() || isRecordingEnabled() || isSnoringDetection() || getRecordingAntisnoreResponse() > 0 || isUltrasonicTracking();
    }

    public boolean isAnyRecordingFeatureNonDefault() {
        SharedPreferences defaultSharedPreferences = getDefaultSharedPreferences(this.context);
        return defaultSharedPreferences.contains("key_experimental_noise") || defaultSharedPreferences.contains("sleep_recording") || defaultSharedPreferences.contains("snoring_detection") || defaultSharedPreferences.contains("anti_snoring_response");
    }

    public boolean isAnySoundRecognitionEnabled() {
        if (isSnoringDetection()) {
            return getSoundRecognitionSensitivitySnoring() > 0 || getSoundRecognitionSensitivityTalk() > 0 || getSoundRecognitionSensitivitySick() > 0 || getSoundRecognitionSensitivityLaughter() > 0 || getSoundRecognitionSensitivityBabyCry() > 0;
        }
        return false;
    }

    public boolean isAssholeManufacturer() {
        return SharedApplicationContext.isManufacturer("oneplus") || SharedApplicationContext.isManufacturer("huawei") || SharedApplicationContext.isManufacturer("oppo") || SharedApplicationContext.isManufacturer("meizu") || SharedApplicationContext.isManufacturer("wiko") || SharedApplicationContext.isManufacturer("xiaomi");
    }

    public boolean isAutoAirplaneMode() {
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("WiFi is airplane "), getPrefStringAsInt("airplane_mode", 0));
        return getPrefStringAsInt("airplane_mode", 0) > 0;
    }

    public boolean isAutoDeleteNoise() {
        return getDefaultSharedPreferences(this.context).getBoolean("delete_noise_auto", true);
    }

    public boolean isAutoSharingEnabled() {
        return getPrefStringAsInt("facebook_mode", 0) > 0;
    }

    public boolean isAutoStartLegacy() {
        String prefString = getPrefString("auto_start_track_internal", "");
        if (prefString != null) {
            return prefString.equals("enabled") || prefString.equals("enable");
        }
        return false;
    }

    public boolean isAutoplayLullaby() {
        return getPrefBoolean("key_auto_lullaby2", false);
    }

    public boolean isAwakeDetectionHighActivity() {
        String prefString = getPrefString("key_awake_detection_internal2", "enabled");
        return getPrefInt("awake_activity_sensitivity", prefString != null && prefString.equals("enabled") ? 2 : 0) > 0;
    }

    public boolean isAwakeDetectionHr() {
        return getPrefInt("awake_hr_sensitivity", getPrefBoolean("key_awake_detection_hr", true) ? 2 : 0) > 0;
    }

    public boolean isAwakeDetectionLight() {
        return getPrefInt("awake_light_sensitivity", getPrefBoolean("key_awake_detection_light", true) ? 2 : 0) > 0;
    }

    public boolean isAwakeDetectionSnooze() {
        return getPrefBoolean("key_awake_detection_snooze", true);
    }

    public boolean isAwakeDetectionTalk() {
        return getPrefInt("awake_sound_sensitivity", getPrefBoolean("key_awake_detection_talk", true) ? 2 : 0) > 0;
    }

    public boolean isAwakeDetectionWhenUsingPhone() {
        String prefString = getPrefString("key_awake_detection_internal", "disable");
        return getPrefInt("awake_phone_use_sensitivity", (prefString == null || !prefString.equals("enabled")) ? 0 : 1) > 0 && getDimMode() != 5;
    }

    public boolean isBackup() {
        return getDefaultSharedPreferences(this.context).getBoolean("backup", true);
    }

    public boolean isBackupLocal() {
        if (TrialFilter.getInstance().isAddonImport()) {
            return true;
        }
        return getDefaultSharedPreferences(this.context).getBoolean("backup_local", true);
    }

    public boolean isBatteryOptimized() {
        String prefString = getPrefString("key_sensor_batching_internal", "");
        if (prefString != null) {
            return prefString.equals("enabled") || prefString.equals("enable");
        }
        return false;
    }

    public boolean isBeta() {
        return getPrefBoolean("beta", false);
    }

    public boolean isBoolPrefInitialized(String str) {
        return getPrefBoolean(str, false) || !getPrefBoolean(str, true);
    }

    public boolean isCaptchaAvoided() {
        return getPrefBoolean("captcha_avoided", false);
    }

    public boolean isCaptchaAvoidedPurchased() {
        return getCaptchaAvoidedOrderId() != null;
    }

    public boolean isCaptchaNoEscape() {
        return isCaptchaNoEscapeForceStop() || isCaptchaNoEscapeUninstall();
    }

    public boolean isCaptchaNoEscapeForceStop() {
        return getPrefBoolean("captcha_no_escape", false);
    }

    public boolean isCaptchaNoEscapeNever() {
        return getPrefBoolean("captcha_no_escape_dialog_never", false);
    }

    public boolean isCaptchaNoEscapeUninstall() {
        return getPrefBoolean("captcha_no_escape_uninstall", false);
    }

    public boolean isCodeCaptchaFallback() {
        return getPrefBoolean("settings_code_captcha_fallback", true);
    }

    public boolean isDashboard() {
        return getPrefBoolean("dashboard", true);
    }

    public boolean isDashboardUninitialized() {
        return getPrefBoolean("dashboard", true) && !getPrefBoolean("dashboard", false);
    }

    public boolean isDefaultLegacyRecordingThreshold() {
        return getPrefStringAsInt("sleep_recording_threshold", 66666) == 66666;
    }

    public boolean isDirectBleWearableSelectedForTracking() {
        Wearable selectedWearable = getSelectedWearable();
        return selectedWearable != null && selectedWearable.isDirectBleWearable();
    }

    public boolean isDisableScreenRotate() {
        return getDefaultSharedPreferences(this.context).getBoolean("alarm_orientation2", true);
    }

    public boolean isDismissLongPress() {
        return getDefaultSharedPreferences(this.context).getBoolean("settings_dismiss_long_press", false);
    }

    public boolean isDoingMicrophoneRecording() {
        return isRecordingMasterSwitchEnabled() && isAnyRecordingFeatureEnabled();
    }

    public boolean isDoingMicrophoneRecordingAndPermissionGranted() {
        if (SleepPermissionCompat.INSTANCE.isPermissionGranted(this.context, "android.permission.RECORD_AUDIO")) {
            return isDoingMicrophoneRecording();
        }
        return false;
    }

    public boolean isEuCountry() {
        String country = getCountry();
        return country != null && SettingKeys.EU_COUNTRIES.contains(country);
    }

    public boolean isExpandAllSettings() {
        return getPrefBoolean("expand_all_settings", false);
    }

    public boolean isExperimentalNoiseRecoringEnabled() {
        if ("HTC".equals(Build.MANUFACTURER)) {
            return true;
        }
        String prefString = getPrefString("key_experimental_noise", "enable");
        if (prefString != null) {
            return prefString.equals("enabled") || prefString.equals("enable");
        }
        return false;
    }

    public boolean isFailedToInitRecording() {
        return getPrefBoolean("failed_to_initialize_recording", false);
    }

    public boolean isFirstUsage(SyncShowcaseViewAsyncTask.IntegrationApp integrationApp) {
        String str = "key_first_use_" + integrationApp.name();
        "yes".equals(getPrefString(str, "yes"));
        return "yes".equals(getPrefString(str, "yes"));
    }

    public boolean isFirstUsageNFCCaptcha() {
        boolean zEquals = "yes".equals(getPrefString("key_first_use_nfc_capctha", "yes"));
        if (zEquals) {
            save("key_first_use_nfc_capctha", "no");
        }
        return zEquals;
    }

    public boolean isFirstUsageOnce() {
        boolean zEquals = "yes".equals(getPrefString("key_first_use", "yes"));
        if (zEquals) {
            save("key_first_use", "no");
        }
        return zEquals;
    }

    public boolean isFirstUsageQRCaptcha() {
        boolean zEquals = "yes".equals(getPrefString("key_first_use_qr_capctha", "yes"));
        if (zEquals) {
            save("key_first_use_qr_capctha", "no");
        }
        return zEquals;
    }

    public boolean isFlipDetectionRunning() {
        return flipDetectionRunning.get();
    }

    public boolean isFlipToPause() {
        return getDefaultSharedPreferences(this.context).getBoolean("flip_to_pause", false);
    }

    public synchronized boolean isFlipToSnooze() {
        return getDefaultSharedPreferences(this.context).getBoolean("flip_to_snooze", false);
    }

    public boolean isForceEnglish() {
        return getDefaultSharedPreferences(this.context).getBoolean("force_english", false);
    }

    public boolean isForceScreenOff() {
        String prefString = getPrefString("key_force_screen_off", "");
        return prefString != null && prefString.equals("force");
    }

    public boolean isGaplessFix() {
        return getPrefBoolean("settings_use_gapless_fix", true);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isGeoOptOut() {
        boolean z;
        if (!getDefaultSharedPreferences(this.context).getBoolean("geo_opt_out", false)) {
            z = PermissionCompat.isPermissionGranted(this.context, "android.permission.ACCESS_COARSE_LOCATION") ? false : true;
        }
        return z;
    }

    public boolean isGoogleCalendar() {
        String prefString = getPrefString("google_calendar_internal", "");
        if (prefString != null) {
            return prefString.equals("enabled") || prefString.equals("enable");
        }
        return false;
    }

    public boolean isGoogleCalendarEvent() {
        return isGoogleCalendar() && getPrefBoolean("google_calendar_event", false);
    }

    public boolean isGoogleCalendarHoliday() {
        return isGoogleCalendar() && getPrefBoolean("google_calendar_holiday", false);
    }

    public boolean isGoogleCalendarSync() {
        return getPrefBoolean("google_calendar_backup", false);
    }

    public boolean isGoogleFit() {
        String prefString = getPrefString("google_fit_internal", "");
        if (prefString != null) {
            return prefString.equals("enabled") || prefString.equals("enable");
        }
        return false;
    }

    public boolean isGoogleFitSyncNeeded() {
        if (isGoogleFit()) {
            return System.currentTimeMillis() - getPrefLong("google_fit_last_sync", 0L) > TimeChart.DAY;
        }
        return false;
    }

    public boolean isGoogleHomeAutomation() {
        return getPrefBoolean("settings_google_home_automation", false);
    }

    public boolean isGoogleHomeSmartlight() {
        return getPrefBoolean("settings_google_home_smartlight", false);
    }

    public boolean isGoogleSleepApiEnabledByUser() {
        return getPrefBoolean("key_use_google_sleep_api", true);
    }

    public boolean isGraphColorThemeDefault() {
        return getPrefStringAsInt("graph_color_theme", 0) == 0;
    }

    public boolean isHalveSnooze() {
        return getDefaultSharedPreferences(this.context).getBoolean("snooze_halve", false);
    }

    public boolean isHealthConnect() {
        return getPrefBoolean("health_connect", false);
    }

    public boolean isHideDroid() {
        return getPrefBoolean("hide_droid", true);
    }

    public boolean isHideMorningStats() {
        return getPrefBoolean("settings_hide_morning_stats", false);
    }

    public synchronized boolean isHintHeadphonesOnly() {
        return getPrefBoolean("hint_headphones_only", false);
    }

    public synchronized boolean isHrBt() {
        return getDefaultSharedPreferences(this.context).getBoolean("hr_bt", false);
    }

    public synchronized boolean isHrWear() {
        return getDefaultSharedPreferences(this.context).getBoolean("hr_wear", false);
    }

    public boolean isHypnogramOverActigraph() {
        return true;
    }

    public boolean isIfttt() {
        String prefString = getPrefString("ifttt_internal", "");
        if (prefString != null) {
            return prefString.equals("enabled") || prefString.equals("enable");
        }
        return false;
    }

    public boolean isIgnoreAssholeManufacturerWarning() {
        return getPrefBoolean(getDeviceSpecificKey("key_ignore_asshole_manufacturer_warning2"), false);
    }

    public boolean isIgnoreBackgroundRestrictedWarning() {
        return getPrefBoolean(getDeviceSpecificKey("key_ignore_background_restricted_warning"), false);
    }

    public boolean isImplicitTagsEnabled() {
        return getPrefBoolean("implicit_tags_enabled", true);
    }

    public boolean isInitializedCaptchaNoEscapeUninstall() {
        return isBoolPrefInitialized("captcha_no_escape_uninstall");
    }

    public boolean isIntentApi() {
        return getPrefBoolean("intent_api", true);
    }

    public boolean isJetLagPrevention() {
        boolean prefBoolean = getPrefBoolean("jetlag", false);
        TimeZone jetLagTargetTimezone = getJetLagTargetTimezone();
        if (jetLagTargetTimezone == null) {
            return false;
        }
        if (prefBoolean && TimeZone.getDefault().getID().equals(jetLagTargetTimezone.getID())) {
            Logger.logInfo("JetLag: reached target TZ - disabling " + jetLagTargetTimezone);
            setJetLagPrevention(false);
            return false;
        }
        Logger.logInfo("JetLag: enabled " + prefBoolean + " for target " + jetLagTargetTimezone + " current " + TimeZone.getDefault().getID());
        return prefBoolean;
    }

    public boolean isLastRecordingStartedWithWatch() {
        return getDefaultSharedPreferences(this.context).getBoolean("key_last_recording_with_watch", false);
    }

    public boolean isLegacyGradualVolumeIncrease() {
        return getPrefBoolean("alarm_increasing_volume", true);
    }

    public boolean isLegacyPublicComment() {
        return getPrefStringAsInt("sleep_rating_mode2", 0) != 1;
    }

    public boolean isLucidMaskReserved() {
        return System.currentTimeMillis() < getPrefLong("smartlight_mask_block_time", -1L);
    }

    public boolean isLucidVibrate() {
        return getDefaultSharedPreferences(this.context).getBoolean("lucid_vibrate", false);
    }

    public boolean isLullabyAutoPlaylist() {
        return getLullabyAutoPlaylist() > 0 && getLullabyAutoPlaylistSize() > 1;
    }

    public boolean isLullabyNoHighPitch() {
        return getDefaultSharedPreferences(this.context).getBoolean("lullaby_low_pitch_only", false);
    }

    public boolean isLullabyTurnOffWiFi() {
        return getPrefBoolean("settings_lullaby_turn_off_wifi", false);
    }

    public boolean isLullabyUsed() {
        return !loadList("lullaby_popchart", ";").isEmpty();
    }

    public boolean isMediaStoreAlbum() {
        return getPrefBoolean("media_store_album", true);
    }

    public boolean isMeditationLullaby() {
        return getDefaultSharedPreferences(this.context).getBoolean("key_meditation", false);
    }

    public int isMeditationOneTime() {
        return getPrefInt("key_meditation_one_time_nullable", -1);
    }

    public boolean isMorningScreenDark() {
        return getPrefBoolean("morning_screen_dark", false);
    }

    public boolean isMqtt() {
        return getPrefBoolean("mqtt", false);
    }

    public boolean isMuteAlerts() {
        return getDefaultSharedPreferences(this.context).getBoolean("mute_alerts", false);
    }

    public boolean isNFCCaptchaHomeOnly() {
        return getDefaultSharedPreferences(this.context).getBoolean("settings_nfc_captcha_home_only", false);
    }

    public boolean isNFCCaptchaMultiscan() {
        return getDefaultSharedPreferences(this.context).getBoolean("settings_nfc_captcha_multiscan", false);
    }

    public boolean isNewSelectWearableBehavior() {
        return getSelectedWearable() != null;
    }

    public boolean isNewTimepicker() {
        return getPrefBoolean("timepicker", true) && Environment.isIcsOrGreater();
    }

    public boolean isNoAlarmBedtime() {
        return getPrefBoolean("no_alarm_bedtime", false);
    }

    public boolean isNoiseStatsCollectingEnabled() {
        String prefString = getPrefString("key_noise_stats", "enable");
        if (prefString != null) {
            return prefString.equals("enabled") || prefString.equals("enable");
        }
        return false;
    }

    public boolean isNotBeforeIdeal() {
        return getPrefBoolean("act_on_target_sleep_time2", false);
    }

    public boolean isOptOutAds() {
        return getPrefBoolean("ads_opt_out", false);
    }

    public boolean isOptOutAnalytics() {
        return getPrefBoolean("analytics_opt_out", false);
    }

    public boolean isOptedOutFromExperiments() {
        return getDefaultSharedPreferences(this.context).getBoolean("experiments_optout", false);
    }

    public boolean isOximeter() {
        return getPrefBoolean("oximeter", false);
    }

    public boolean isOximeterAlarm() {
        return getPrefBoolean("oximeter_alarm", false);
    }

    public boolean isOximeterWatch() {
        return getPrefBoolean("oximeter_watch", false);
    }

    public boolean isPairTracking() {
        return getPrefBoolean("pair_tracking_enabled", false);
    }

    public boolean isPhilipsOffer() {
        return false;
    }

    public boolean isPrefMigrationNeeded() {
        boolean zEquals = "yes".equals(getPrefString("pref_migration_needed", "yes"));
        if (zEquals) {
            save("pref_migration_needed", "no");
        }
        return zEquals;
    }

    public boolean isPriorityMode() {
        return getDefaultSharedPreferences(this.context).getBoolean("mute_alerts_priority", Build.VERSION.SDK_INT >= 29);
    }

    public boolean isPublicComment() {
        return getPrefBoolean("share_comments", true);
    }

    public boolean isQRCaptchaHomeOnly() {
        return getDefaultSharedPreferences(this.context).getBoolean("settings_qr_captcha_home_only", false);
    }

    public boolean isQRCaptchaMultiscan() {
        return getDefaultSharedPreferences(this.context).getBoolean("settings_qr_captcha_multiscan", false);
    }

    public boolean isRateDislike() {
        return getPrefBoolean("rate_dislike_d", false);
    }

    public boolean isRateDone() {
        boolean z = false;
        if (getPrefBoolean("rate_done_beta_b", false)) {
            return false;
        }
        boolean prefBoolean = getPrefBoolean("rate_done_h", false);
        boolean prefBoolean2 = getPrefBoolean("rate_done_i", false);
        long rateDoneTs = getRateDoneTs();
        if (!prefBoolean) {
            return false;
        }
        if (prefBoolean2) {
            return true;
        }
        if ((rateDoneTs == -1 || System.currentTimeMillis() - rateDoneTs > 446400000) && System.currentTimeMillis() % 10 == 0) {
            z = true;
        }
        return true ^ z;
    }

    public boolean isRateNever() {
        return getDefaultSharedPreferences(this.context).getBoolean("rate_never_f", false);
    }

    public boolean isRateSleepLater() {
        return getRateSleepLater() != 0;
    }

    public boolean isRateWearableDone() {
        return getDefaultSharedPreferences(this.context).getBoolean("rate_wearable_done", false);
    }

    public boolean isRateWearableNever() {
        return getDefaultSharedPreferences(this.context).getBoolean("rate_wearable_never", false);
    }

    public boolean isRecordingEnabled() {
        return getDefaultSharedPreferences(this.context).getBoolean("sleep_recording", true) && isRecordingMasterSwitchEnabled();
    }

    public boolean isRecordingMasterSwitchEnabled() {
        return getPrefBoolean("noise_recording_master_switch", isAnyRecordingFeatureNonDefault());
    }

    public boolean isRecordingRequiresStorage() {
        return isRecordingMasterSwitchEnabled() && isRecordingEnabled();
    }

    public boolean isReliableAlarmScheduled() {
        return getPrefBoolean("reliable_alarm_scheduled", false);
    }

    public boolean isRevertDnd() {
        return getPrefBoolean("key_dnd_enabled", false);
    }

    public boolean isSamsungSHealth() {
        String prefString = getPrefString("samsung_shealth_internal", "");
        if (prefString != null) {
            return prefString.equals("enabled") || prefString.equals("enable");
        }
        return false;
    }

    public boolean isSamsungSHealthSyncNeeded() {
        if (!isSamsungSHealth()) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - getPrefLong("samsung_shealth_last_sync", 0L);
        Logger.logInfo("Samsung S Health last sync before " + (jCurrentTimeMillis / 3600000) + " hour(s)");
        return jCurrentTimeMillis > TimeChart.DAY;
    }

    public boolean isScopedStorage() {
        return getPrefBoolean("scoped_storage", Build.VERSION.SDK_INT >= 33);
    }

    public boolean isScreenLight() {
        return getPrefBoolean("screenlight", true);
    }

    public boolean isShareSnoringDetectionErrors() {
        Experiments.initializeIfRequired(this.context);
        return getPrefBoolean("key_share_snoring_detection_errors_v4", true) && Experiments.getInstance().isTensorflowV4();
    }

    public boolean isShowAmPm() {
        return getPrefStringAsInt("hour_format", -1) == 13;
    }

    public boolean isShowCaseShown(String str) {
        Iterator<String> it = loadList("showcase_settings_shown2", ConfigurationKt.DELIMITER).iterator();
        while (it.hasNext()) {
            zza$$ExternalSyntheticOutline0.m("AlarmClock: Shown ", it.next());
        }
        return loadList("showcase_settings_shown2", ConfigurationKt.DELIMITER).contains(str);
    }

    public boolean isShowRatingScreen() {
        return getMorningScreen() == 1;
    }

    public boolean isShowReleaseNotes() {
        return getDefaultSharedPreferences(this.context).getBoolean("release_notes", true);
    }

    public boolean isSleepPhaserAutoStart() {
        return getPrefBoolean("smartlight_sleep_phaser_auto_start", false);
    }

    public boolean isSleepPhaserSleepTracking() {
        return getPrefBoolean("smartlight_sleep_phaser_sleep_tracking", false);
    }

    public boolean isSleepPhaserSmartLight() {
        return getPrefBoolean("smartlight_sleep_phaser_smartlight", false);
    }

    public boolean isSleepScoreColored() {
        return getPrefBoolean("sleep_score_colored", false);
    }

    @Deprecated
    public boolean isSleepTimeSuggestion() {
        return Environment.isMOrGreater() && getPrefBoolean("sleep_time_suggestion", true) && !isAlarmOnly();
    }

    public boolean isSmartLightAntiSnoring() {
        return getPrefBoolean("smartlight_anti_snoring", false);
    }

    public boolean isSmartLightLucidDreaming() {
        return getPrefBoolean("smartlight_lucid_dreaming", false);
    }

    public synchronized boolean isSmartlightEnabled() {
        return getDefaultSharedPreferences(this.context).getBoolean("smartlight", false);
    }

    public boolean isSmartlightLightUpAfterDismiss() {
        int smartlightLightUpAfter = getSmartlightLightUpAfter();
        return smartlightLightUpAfter == 2 || smartlightLightUpAfter == 3;
    }

    public boolean isSmartlightLightUpAfterSnooze() {
        int smartlightLightUpAfter = getSmartlightLightUpAfter();
        return smartlightLightUpAfter == 1 || smartlightLightUpAfter == 3;
    }

    public boolean isSmartlightMaskEnabled() {
        return getDefaultSharedPreferences(this.context).getBoolean("smartlight_mask_enabled", false);
    }

    public synchronized boolean isSmartlightPeelightEnabled() {
        return getDefaultSharedPreferences(this.context).getBoolean("smartlight_peelight", false);
    }

    public synchronized boolean isSmartwatchEnabled() {
        if (isStringPrefInitialized("selected_wearable")) {
            return getSelectedWearable() != Wearable.NONE;
        }
        return getPrefBoolean("smartwatch", false);
    }

    public boolean isSnoozeAfterAlarmEnabled(Alarm alarm) {
        int snoozeAfterAlarm;
        return (alarm == null || (snoozeAfterAlarm = alarm.extendedConfig.getSnoozeAfterAlarm()) == -2) ? getPrefStringAsInt("snooze_after_alarm", 1) != 0 : snoozeAfterAlarm != 0;
    }

    public boolean isSnoringDetection() {
        return getPrefBoolean("snoring_detection", true) && isRecordingMasterSwitchEnabled();
    }

    public Boolean isSonarSupported() {
        SharedPreferences defaultSharedPreferences = getDefaultSharedPreferences(this.context);
        int i = hasRequiredSampleRateForUltrasonicTracking() ? 0 : 2;
        int i2 = defaultSharedPreferences.getInt(getDeviceSpecificKey("sonar_supported"), -1);
        if (i2 == -1) {
            defaultSharedPreferences.getInt("sonar_supported", -1);
        }
        if (i2 != -1) {
            i = i2;
        }
        if (i > 0) {
            return Boolean.valueOf(i == 1);
        }
        return null;
    }

    public boolean isSoundDelayAfterSnooze() {
        return getPrefBoolean("alarm_sound_delay_after_snooze", true);
    }

    public boolean isSoundRecognitionNoiseMixin() {
        return getPrefBoolean("sound_recognition_noise_mixin", false);
    }

    public boolean isSpecialPromoActive() {
        return getPrefLong("special_promo", -1L) != -1 && System.currentTimeMillis() < getSpecialPromoEndTime();
    }

    public boolean isSpotify() {
        String prefString = getPrefString("spotify_internal", "disable");
        if (prefString != null) {
            return prefString.equals("enabled") || prefString.equals("enable");
        }
        return false;
    }

    public boolean isSpotifyAppRemoteScopeAllowed() {
        return getPrefBoolean("spotify_app_remote_scope_allowed", false);
    }

    public boolean isSpotifyPremium() {
        return getPrefBoolean("spotify_premium", false);
    }

    public boolean isStatusBarIcon() {
        return true;
    }

    public boolean isStringPrefInitialized(String str) {
        return !"NA".equals(getPrefString(str, "NA"));
    }

    public boolean isTabAddon() {
        return false;
    }

    public boolean isTabDashboard() {
        if (isAlarmOnly()) {
            return false;
        }
        return getPrefBoolean("tab_dashboard", true);
    }

    public boolean isTabGraphs() {
        if (isAlarmOnly()) {
            return false;
        }
        return getPrefBoolean("tab_graphs", true);
    }

    public boolean isTabNoise() {
        if (isAlarmOnly()) {
            return false;
        }
        return getPrefBoolean("tab_noise", false);
    }

    public boolean isTabStats() {
        if (isAlarmOnly()) {
            return false;
        }
        return getPrefBoolean("tab_stats", false);
    }

    public boolean isTabTune() {
        return false;
    }

    public boolean isTabs() {
        return (isDashboard() || isAlarmOnly()) ? false : true;
    }

    public boolean isTasker() {
        String prefString = getPrefString("tasker_internal2", "disable");
        if (prefString != null) {
            return prefString.equals("enabled") || prefString.equals("enable");
        }
        return false;
    }

    public boolean isTextToSpeech() {
        return getDefaultSharedPreferences(this.context).getBoolean("text_to_speech", false);
    }

    public boolean isThemeValueSet() {
        return getPrefStringAsInt("theme", -1) != -1;
    }

    public boolean isTimeForAction(String str, long j) {
        long lastActionTime = getLastActionTime(str);
        if (System.currentTimeMillis() - lastActionTime <= j && lastActionTime != -1) {
            return false;
        }
        save(getLastActionKey(str), System.currentTimeMillis(), false);
        return true;
    }

    public boolean isTimeForMediaStoreJob() {
        return getNextMediaStoreJob() == -1 || System.currentTimeMillis() > getNextMediaStoreJob();
    }

    public boolean isTimeToAskAds() {
        long prefLong = getPrefLong("ads_opt_out_last_asked", -1L);
        return prefLong == -1 || System.currentTimeMillis() - prefLong > 187200000;
    }

    public boolean isTimeToAskAnalytics() {
        long prefLong = getPrefLong("analytics_opt_out_last_asked", -1L);
        return prefLong == -1 || System.currentTimeMillis() - prefLong > 374400000;
    }

    public boolean isTimeToBackup() {
        if (!isBackup()) {
            return false;
        }
        long prefLong = getPrefLong("key_last_backup", -1L);
        boolean z = prefLong == -1 || prefLong + 172800000 < System.currentTimeMillis();
        if (z) {
            setBackupDone();
        }
        return z;
    }

    public boolean isTimeToBedLed() {
        return getDefaultSharedPreferences(this.context).getBoolean("time_to_bed_led", false);
    }

    public boolean isTimeToBedSmart() {
        return getDefaultSharedPreferences(this.context).getBoolean("time_to_bed_smart", false);
    }

    public boolean isTimeToBedVibrating() {
        return getDefaultSharedPreferences(this.context).getBoolean("time_to_bed_vibrating", true);
    }

    public boolean isTimeToCalculateChronotype() {
        long prefLong = getPrefLong("chronotype_last_calculated", -1L);
        if (prefLong != -1 && System.currentTimeMillis() - prefLong <= CalculateChronotypeService.CALCULATE_CHRONOTYPE_INTERVAL) {
            return false;
        }
        save("chronotype_last_calculated", System.currentTimeMillis(), false);
        return true;
    }

    public boolean isTimeToDeleteOldNoises() {
        if (System.currentTimeMillis() - getLastNoisesDelete() <= 14400000) {
            return false;
        }
        save("key_last_recording_delete", System.currentTimeMillis(), false);
        return true;
    }

    public boolean isTimeToRateAgain() {
        return getRateLater() == -1 || System.currentTimeMillis() - getRateLater() > 446400000;
    }

    public boolean isTimeToRateAgainPlayStore() {
        return getRateLaterPlayStore() == -1 || System.currentTimeMillis() - getRateLaterPlayStore() > 619200000;
    }

    public boolean isTimeToRateAgainSoonerPlayStore() {
        return getRateLaterPlayStore() == -1 || System.currentTimeMillis() - getRateLaterPlayStore() > 180000000;
    }

    public boolean isTimeToRefreshActualDefaultRingtoneUri() {
        long prefLong = getPrefLong("actual_default_ringtone_uri_refresh", -1L);
        return prefLong == -1 || System.currentTimeMillis() - prefLong > 28800000;
    }

    public boolean isTimeToRefreshPurchases() {
        return true;
    }

    public boolean isTimeToSuggestNoEscape() {
        long prefLong = getPrefLong("captcha_no_escape_suggest_time", -1L);
        Logger.logInfo("noescape time " + prefLong);
        return prefLong == -1 || System.currentTimeMillis() - prefLong > 1224000000;
    }

    public boolean isTimeToUpdateCountry() {
        if (getCountry() == null) {
            return true;
        }
        long countryUpdatedTimestamp = getCountryUpdatedTimestamp();
        return countryUpdatedTimestamp != 0 && System.currentTimeMillis() - countryUpdatedTimestamp > -1702967296;
    }

    public boolean isTransitionAnimation() {
        return getPrefBoolean("transition_animations", true);
    }

    public boolean isUltrasonicTracking() {
        return getPrefStringAsInt("non_deep_sleep_method", 0) == 2;
    }

    public boolean isUseFlashlight() {
        String prefString = getPrefString("alarm_with_flashlight_internal", "");
        if (prefString != null) {
            return prefString.equals("enabled") || prefString.equals("enable");
        }
        return false;
    }

    public boolean isUseFlashlightLegacy() {
        return getDefaultSharedPreferences(this.context).getBoolean("alarm_with_flashlight", false);
    }

    public boolean isUseLocalTimeForSleepIrregularity() {
        return getPrefBoolean("use_local_time_for_sleep_irregularity", false);
    }

    public boolean isUserAdsAgreed() {
        return "yes".equals(getPrefString("key_user_ads_agreed_gdpr", "no"));
    }

    public boolean isUserAnalyticsAgreed() {
        return "yes".equals(getPrefString("key_user_analytics_agreed_gdpr", "no")) || UserMessagingPlatform.getConsentInformation(this.context).canRequestAds();
    }

    public boolean isVibeWhenConnected() {
        return getPrefBoolean("smartwatch_vibe_when_connected", true);
    }

    public boolean isVolumePermissionNeeded() {
        return getPrefBoolean("volume_permission_needed", false);
    }

    public synchronized boolean isWakeUpCheck(Alarm alarm) {
        Integer wakeUpCheck = alarm.extendedConfig.getWakeUpCheck();
        if (wakeUpCheck != null && wakeUpCheck.intValue() == 0) {
            return false;
        }
        if (wakeUpCheck != null && wakeUpCheck.intValue() == 1) {
            return true;
        }
        return getPrefBoolean("captcha_wake_up_check", false);
    }

    public boolean isWearableEligibleForTracking(Wearable wearable) {
        return isWearableSelected(wearable) || isWearableSelected(Wearable.AUTO) || !isNewSelectWearableBehavior();
    }

    public boolean isWearableSelected(Wearable wearable) {
        return getSelectedWearable() == wearable;
    }

    public boolean isWeather() {
        return getPrefBoolean("weather", true);
    }

    public boolean isWebhooks() {
        return getPrefBoolean("webhooks_enabled", false);
    }

    public List<Achievement> loadAchievements() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = loadList("key_achievement", ConfigurationKt.DELIMITER).iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(new Achievement(it.next()));
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        Achievement achievement = new Achievement(Achievement.Type.PREMIUM, 1);
        if (!TrialFilter.getInstance().isTrial() && !arrayList.contains(achievement)) {
            arrayList.add(achievement);
        } else if (TrialFilter.getInstance().isTrial() && arrayList.contains(achievement)) {
            arrayList.remove(achievement);
        }
        return arrayList;
    }

    public List<Shortcut> loadShortcuts() {
        ArrayList arrayList = new ArrayList();
        List<String> listLoadList = loadList("key_shortcuts12", ConfigurationKt.DELIMITER);
        if (listLoadList.isEmpty()) {
            return ShortcutSleep.INSTANCE.getDefaults(this.context);
        }
        Iterator<String> it = listLoadList.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(ShortcutSleep.INSTANCE.fromString(it.next()));
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        return arrayList;
    }

    public void markSamsungSHealthSleepStageRequested() {
        save("samsung_shealth_sleep_stages_requested", true);
    }

    public List<SleepScore.ScoreMeasure> orderMeasures(List<SleepScore.ScoreMeasure> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    List<String> listLoadList = loadList("key_measure_order4", ";;;");
                    if (listLoadList.isEmpty()) {
                        return list;
                    }
                    SleepScore.ScoreMeasure scoreMeasure = SleepScore.ScoreMeasure.SCORE;
                    if (!listLoadList.contains(scoreMeasure.name())) {
                        listLoadList.add(0, scoreMeasure.name());
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> it = listLoadList.iterator();
                    while (it.hasNext()) {
                        SleepScore.ScoreMeasure scoreMeasureValueOf = SleepScore.ScoreMeasure.valueOf(it.next());
                        if (list.contains(scoreMeasureValueOf)) {
                            arrayList.add(scoreMeasureValueOf);
                        }
                    }
                    return arrayList;
                }
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        return list;
    }

    public synchronized void removeAllOnlineRadios(String str) {
        saveList(str, null, ConfigurationKt.DELIMITER);
    }

    public void removeGoogleHomeAutomation(String str) {
        save(str, (String) null);
    }

    public synchronized void removeOnlineRadio(String str, String str2, String str3) {
        String strBuildRadioString = buildRadioString(str, str2);
        List<String> listLoadList = loadList(str3, ConfigurationKt.DELIMITER);
        listLoadList.remove(strBuildRadioString);
        saveList(str3, listLoadList, ConfigurationKt.DELIMITER);
    }

    public void removeShortcut(Shortcut shortcut) {
        ArrayList arrayList = new ArrayList(loadShortcuts());
        arrayList.remove(shortcut);
        saveShortcut(arrayList);
    }

    public void reportLullabyUsed(LullabyPlayer.Lullaby lullaby) throws CloneNotSupportedException {
        if (lullaby == LullabyPlayer.Lullaby.NONE) {
            return;
        }
        addAchievement(Achievement.Type.LULLABY, 1);
        List<String> listLoadList = loadList("lullaby_popchart", ";");
        if (listLoadList.isEmpty()) {
            for (LullabyPlayer.Lullaby lullaby2 : LullabyPlayer.Lullaby.values()) {
                listLoadList.add(lullaby2.name());
            }
        }
        listLoadList.remove(lullaby.name());
        if (listLoadList.size() > 1) {
            listLoadList.add(1, lullaby.name());
        } else {
            listLoadList.add(lullaby.name());
        }
        saveList("lullaby_popchart", listLoadList, ";");
    }

    public void reserveLucidMask(long j) {
        save("smartlight_mask_block_time", j);
    }

    public void resetAutoSnoozeRepeat() {
        Logger.logInfo("SnoozeRepeat: reseting auto snooze counter");
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString("key_auto_kill_snooze_counter", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public void resetAutomationEvents() {
        if (getDefaultSharedPreferences(this.context).getStringSet("automation_events_list", null) == null) {
            getDefaultSharedPreferences(this.context).edit().putStringSet("automation_events_list", AutomationEventMapping.getActionSet()).apply();
        }
    }

    public void resetDeepSleepCounter() {
        this.deepSleepCounter = 0;
    }

    public void resetGeoTimeFrom() {
        save("geo_from_time", System.currentTimeMillis());
    }

    public void resetGoogleCalendarOptions() {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putBoolean("google_calendar_holiday", false);
        editorEdit.putBoolean("google_calendar_event", false);
        editorEdit.putBoolean("google_calendar_backup", false);
        editorEdit.apply();
    }

    public void resetGoogleFitConnectFailureCount() {
        save("google_fit_connect_failure_count", 0, false);
    }

    public void resetNextSleepTrackingRestartTimestamp() {
        setNextSleepTrackingRestartTimestamp(-1L);
    }

    public void resetScopedStorage() {
        save("scoped_storage", Build.VERSION.SDK_INT >= 33);
    }

    public void resetSnoozeRepeat() {
        Logger.logInfo("SnoozeRepeat: reset");
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString("snooze_repeat", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public void resetSnoozeRepeatIfNoSnoozeScheduled() {
        try {
            if (Alarms.isSnoozing(this.context) || AlarmStatusReceiver.alarmIsRinging) {
                return;
            }
            SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
            editorEdit.putString("snooze_repeat", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
            editorEdit.apply();
        } catch (Exception e) {
            Logger.logSevere("Cannot reset snooze, exception occurred " + e.getMessage() + " " + e.getClass());
        }
    }

    public void resetVibrationLegacy() {
        save("gradual_vibration", "-100");
    }

    public void resetVibrationSmartwtchLegacy() {
        save("gradual_vibration_smartwatch", "-100");
    }

    public void resetWakeUpCheckRepeat() {
        Logger.logInfo("WakeUpCheck: counter reset ");
        setWakeUpCheckScheduledAlarmId(-1L);
        save("captcha_wake_up_check_repeat_counter", 0);
    }

    public void resetWakeUpCheckRepeatIfExpired() {
        if (getWakeUpCheckRepeatCount() > 0) {
            long wakeUpCheckScheduled = getWakeUpCheckScheduled();
            long wakeUpCheckAfterNotification = getWakeUpCheckAfterNotification() + wakeUpCheckScheduled + 7500000;
            if (wakeUpCheckScheduled == -1 || System.currentTimeMillis() - wakeUpCheckAfterNotification > 0) {
                Logger.logInfo("WakeUpCheck: counter expired " + wakeUpCheckAfterNotification);
                resetWakeUpCheckRepeat();
            }
        }
    }

    public void revertRateDone() {
        save("rate_done_h", false);
    }

    public void saveAchievements(List<Achievement> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Achievement> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        saveList("key_achievement", arrayList, ConfigurationKt.DELIMITER);
    }

    public void saveCaptchaAvoidedPurchase(String str, String str2, String str3) {
        save("captcha_avoided_sku", str);
        save("captcha_avoided_order_id", str2);
        save("captcha_avoided_token", str3);
    }

    public void saveNextPromo(PromoEvent promoEvent) {
        save("key_next_promo", promoEvent == null ? null : promoEvent.toString());
    }

    public void saveNoAlarmBedtimeByKey(String str, int i, int i2) {
        save(str, (i * 60) + i2);
    }

    public void saveScoreMeasureOrder(List<SleepScore.ScoreMeasure> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<SleepScore.ScoreMeasure> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().name());
        }
        saveList("key_measure_order4", arrayList, ";;;");
    }

    public void saveShortcut(List<Shortcut> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Shortcut> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        saveList("key_shortcuts12", arrayList, ConfigurationKt.DELIMITER);
    }

    public void setAchievement(Achievement.Type type, int i) {
        if (type == null) {
            return;
        }
        addAchievementQuantity(type, i, false);
    }

    public void setActiveAlarm(Alarm alarm) {
        if (alarm != null) {
            save("active_alarm_id", alarm.id);
            save("active_alarm_text", Alarm.getAlarmHumanReadableText(this.context, alarm));
        }
    }

    public void setActiveTab(int i) {
        save("active_tab", i);
    }

    public void setActivityRecognitionNewSleepApi(boolean z) {
        save("activity_recognition_new_sleep_api", z);
    }

    public void setActualDefaultRingtoneUri(String str) {
        save("actual_default_ringtone_uri", str);
        setActualDefaultRingtoneUriLastRefresh();
    }

    public void setActualDefaultRingtoneUriLastRefresh() {
        save("actual_default_ringtone_uri_refresh", System.currentTimeMillis());
    }

    public void setAdsAsked() {
        save("ads_opt_out_last_asked", System.currentTimeMillis());
    }

    public void setAirplaneChanged(boolean z) {
        Logger.logInfo("WifiEnabler: airplane mode changed " + z);
        save("key_airplane_changed", z);
    }

    public boolean setAirplaneMode(boolean z) {
        if (isAirplaneModeOn() == z) {
            return false;
        }
        try {
            if (!Environment.isNewJellyBeanOrGreater() || TrialFilter.getInstance().tryAirplaneRootHack()) {
                Settings.System.putInt(this.context.getContentResolver(), "airplane_mode_on", z ? 1 : 0);
            } else {
                Settings.System.putInt(this.context.getContentResolver(), "airplane_mode_on", z ? 1 : 0);
            }
            Intent intent = new Intent("android.intent.action.AIRPLANE_MODE");
            intent.putExtra(ServerProtocol.DIALOG_PARAM_STATE, z);
            this.context.sendBroadcast(intent);
            return true;
        } catch (Exception e) {
            Logger.logWarning("Cannot switch airplane mode.", e);
            return false;
        }
    }

    public void setAlarmInSilent(boolean z) {
        save("alarm_in_silent_mode", z);
    }

    public void setAlarmOnly(boolean z) {
        save("alarm_only", z);
    }

    public void setAlarmPlaylistLooping() {
        save("playlist_mode", "2");
    }

    public void setAlarmPlaylistOrdered() {
        save("playlist_mode", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    }

    public void setAlarmPlaylistShuffle() {
        save("playlist_mode", AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public synchronized void setAlarmRunningForDirectBoot(boolean z) {
        try {
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = this.context.createDeviceProtectedStorageContext().openFileOutput("running_alarm", 0);
                fileOutputStreamOpenFileOutput.write((z ? String.valueOf(System.currentTimeMillis()) : "").getBytes());
                fileOutputStreamOpenFileOutput.flush();
                fileOutputStreamOpenFileOutput.close();
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setAnalyticsAsked() {
        save("analytics_opt_out_last_asked", System.currentTimeMillis());
    }

    public void setAntisnoringRingtone(String str) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString("snoring_ringtone", str);
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public void setApneaAlarmRingtone(String str) {
        save("apnea_alarm_ringtone", str);
    }

    public void setAutoAirplaneMode(boolean z) {
        save("airplane_mode", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public void setAutoStartLegacy(boolean z) {
        save("auto_start_track_internal", z ? "enabled" : "disable");
    }

    public void setAutoplayLullaby(String str) {
        save("key_auto_lullaby_name", str);
    }

    public void setBackupDirUri(Uri uri) {
        save(getDeviceSpecificKey("key_backup_dir_uri"), uri.toString());
    }

    public synchronized void setBackupLocal(boolean z) {
        save("backup_local", z);
    }

    public void setBatteryOptimized(boolean z) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putBoolean("sensor_batching", z);
        editorEdit.putString("key_sensor_batching_internal", z ? "enabled" : "");
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public void setBeta(boolean z) {
        save("beta", z);
    }

    public void setBirthYear(String str) {
        save("profile_birthdate", str);
    }

    public void setBleHrDevice(String str, String str2) {
        save("btle_device_address", str);
        save("btle_device_name", str2);
    }

    public void setBleTrackingDevice(String str, String str2) {
        save("btle_tracking_device_address", str);
        save("btle_tracking_device_name", str2);
    }

    public void setCaptchaAvoided(boolean z) {
        save("captcha_avoided", z);
        save("captcha_avoided_text", z ? getActiveAlarmText() : null);
        if (!z) {
            clearActiveAlarm();
            return;
        }
        resetAutoSnoozeRepeat();
        resetSnoozeRepeat();
        resetWakeUpCheckRepeat();
    }

    public void setCaptchaAvoidedPrice(String str) {
        save("captcha_avoided_price", str);
    }

    public void setCaptchaDifficulty(CaptchaInfo captchaInfo, int i) {
        save("captcha_difficulty", FileInsert$$ExternalSyntheticOutline0.m(i, ""));
        save(getCaptchaDifficultyKey(captchaInfo), FileInsert$$ExternalSyntheticOutline0.m(i, ""));
        zza$$ExternalSyntheticOutline0.m(i, "Captcha difficulty key set ");
    }

    public void setCaptchaNoEscapeNever() {
        save("captcha_no_escape_dialog_never", true);
    }

    public void setCaptchaNoEscapeUninstall(Boolean bool) {
        save("captcha_no_escape_uninstall", bool.booleanValue());
    }

    public void setChartTrendLastSelectedGraphTitle(String str) {
        save("chart_trend_last_selected_title", str);
    }

    public void setChartTrendLastSelectedGraphTitleFromCard(String str) {
        save("chart_trend_last_selected_title_2", str);
    }

    public void setChronotype(float f) {
        save("chronotype", f);
    }

    public void setCodeCaptchaFallback(boolean z) {
        save("settings_code_captcha_fallback", z);
    }

    public void setCountry(String str) {
        if (str != null && str.trim().equals("")) {
            str = null;
        }
        save("country", str.trim());
        setCountryUpdatedTimestamp();
    }

    public void setCurrentAlarm(int i, long j) {
        save("key_current_alarm", FileInsert$$ExternalSyntheticOutline0.m(i, ""));
        save("key_current_alarm_time", j);
    }

    public void setCurrentAvgMidSleep(float f) {
        save("current_avg_mid_sleep", String.valueOf(f));
    }

    public void setCurrentAvgSleepLength(float f) {
        save("current_avg_sleep_length", String.valueOf(f));
    }

    public void setCurrentGoal(Goal goal) {
        if (goal == null) {
            save("current_goal", (String) null);
            return;
        }
        Logger.logInfo("Goal: save " + goal.toString());
        save("current_goal", goal.toString());
    }

    public void setCurrentGoalPrice(String str) {
        save("current_goal_price", str);
    }

    public void setCustomWearableAddonPackage(String str) {
        save("custom_wearable_addon_package", str);
    }

    public void setDashboard(boolean z) {
        save("dashboard", z);
    }

    public void setDefaultCaptchaId(int i) {
        save("captcha_mode", String.valueOf(i));
    }

    public void setDefaultPlaylists(Set<String> set) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putStringSet("selected_playlists_pref", set);
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public void setDefaultRingtone(String str) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString("ringtone_pref", str);
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public void setDefaultRingtoneName(String str) {
        save("ringtone_name", str);
    }

    public void setFailedToInitRecording(boolean z) {
        save("failed_to_initialize_recording", z);
    }

    public synchronized void setFlipDetectionRunning(boolean z) {
        flipDetectionRunning.set(z);
    }

    public void setForceScreenOff(boolean z) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString("key_force_screen_off", z ? "force" : "");
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public void setGeoOptOut(boolean z) {
        save("geo_opt_out", z);
    }

    public void setGeos(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        saveList("key_geo", list, ";");
    }

    public void setGoalDetailsSelectedTab(int i) {
        save("goal_details_selected_tab", i);
    }

    public void setGoogleCalendar(boolean z) {
        zza$$ExternalSyntheticOutline0.m("Google Calendar: set enabled: ", z);
        save("google_calendar_internal", z ? "enabled" : "disable");
        save("google_calendar", z);
    }

    public void setGoogleCalendarAccount(String str) {
        zza$$ExternalSyntheticOutline0.m("Set Google Calendar Account: ", str);
        save("google_calendar_account_name", str);
    }

    public void setGoogleCalendarAccountPrevious(String str) {
        save("google_calendar_account_name_previous", str);
    }

    public void setGoogleCalendarRecordCount(int i) {
        save("google_calendar_record_count", i, false);
    }

    public void setGoogleFit(boolean z) {
        zza$$ExternalSyntheticOutline0.m("fit-prefs: set fit enabled: ", z);
        save("google_fit_internal", z ? "enabled" : "disable");
        save("google_fit", z);
    }

    public void setGoogleFitRecordCount(int i) {
        save("google_fit_record_count", i, false);
    }

    public void setGoogleFitSyncLastTimestamp(long j) {
        save("google_fit_last_sync", j);
    }

    public void setGoogleHomeAutomation(String str, String str2, String str3) {
        save(str, FileInsert$$ExternalSyntheticOutline0.m$1(str2, ";;;", str3));
    }

    public void setGoogleSleepApiEnabledByUser(boolean z) {
        save("key_use_google_sleep_api", z);
    }

    public void setGradualVibration(int i) {
        save("gradual_vibration_new", String.valueOf(i));
    }

    public void setGradualVibrationSmartwatch(int i) {
        save("gradual_vibration_smartwatch_new", String.valueOf(i));
    }

    public void setGradualVolumeIncreaseDuration(int i) {
        save("alarm_increasing_volume_duration", FileInsert$$ExternalSyntheticOutline0.m(i, ""));
    }

    public void setHealthConnect(boolean z) {
        save("health_connect", z);
    }

    public void setHealthConnectRecordCount(int i) {
        save("health_connect_record_count", i, false);
    }

    public synchronized void setHrBt(boolean z) {
        save("hr_bt", z);
    }

    public synchronized void setHrWear(boolean z) {
        save("hr_wear", z);
    }

    public void setIdealSleepLegacy(float f) {
        save("target_sleep_time", String.valueOf(f));
    }

    public void setIdealSleepMinutes(int i) {
        save("target_sleep_time_minutes", i);
    }

    public void setIfttt(boolean z) {
        zza$$ExternalSyntheticOutline0.m("IFTTT: set enabled: ", z);
        save("ifttt_internal", z ? "enabled" : "disable");
        save("ifttt", z);
    }

    public void setIftttKey(String str) {
        if (str == null || "".equals(str.trim())) {
            setIfttt(false);
        }
        save("> ", str);
    }

    public void setIgnoreAssholeManufacturerWarning() {
        save(getDeviceSpecificKey("key_ignore_asshole_manufacturer_warning2"), true);
    }

    public void setIgnoreBackgroundRestrictedWarning() {
        save(getDeviceSpecificKey("key_ignore_background_restricted_warning"), true);
    }

    public void setJetLagPrevention(boolean z) {
        save("jetlag", z);
    }

    public void setLastCaptchaSolvedTimestampNow() {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putLong("key_last_captcha_solved", System.currentTimeMillis());
        editorEdit.apply();
    }

    public void setLastDndMode(int i) {
        save("key_last_dnd_mode", i);
    }

    public void setLastNapMinutes(int i) {
        addToLastNaps(i);
    }

    public void setLastRecordingStartedWithWatch(boolean z) {
        save("key_last_recording_with_watch", z);
    }

    public void setLastRingerMode(int i) {
        save("key_last_ringer_mode", i);
    }

    public void setLastSnooze(int i) {
        save("key_snooze_minutes", i);
    }

    public void setLicenseChecker(int i) {
        if (getLicenseChecker() != 256) {
            save("key_lc", i);
        }
    }

    public void setLocation(Location location) {
        if (location == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putFloat("key_location_lat", (float) location.getLat());
        editorEdit.putFloat("key_location_lon", (float) location.getLon());
        editorEdit.apply();
    }

    public void setLucidEnabled(boolean z) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString("lucid_enabled2", z ? "enabled" : "");
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public void setLucidRingtone(String str) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString("lucid_ringtone", str);
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public void setLullabyVolumeDownAfter(int i) {
        save("media_decreasing_volume_after", String.valueOf(i));
    }

    public void setLullabyVolumeDownAfterOneTime(int i) {
        save("media_decreasing_volume_after_one_time", String.valueOf(i));
    }

    public void setMarketingCampaign(String str) {
        save("key_mark_campaign", str);
    }

    public void setMarketingMedium(String str) {
        save("key_mark_medium", str);
    }

    public void setMarketingScore(int i) {
        save("key_mark_score", i);
    }

    public void setMarketingSegment(String str) {
        save("key_mark_segment", str);
    }

    public void setMarketingSource(String str) {
        save("key_mark_source", str);
    }

    public void setMatterDevices(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        saveList("matter_devices", list, ";;;");
    }

    public void setMaxGeoFreq(int i) {
        save("key_max_geo_freq", i);
    }

    public void setMediaListExpandedMask(int i) {
        save("key_media_list_expanded_mask", i);
    }

    public void setMeditationOneTime(int i) {
        save("key_meditation_one_time_nullable", i);
    }

    public void setMeditationSessionId(Long l) {
        save("key_meditation_session_id", l.longValue());
    }

    public void setMeditationSessionName(String str) {
        save("key_meditation_session_name", str);
    }

    public void setNFCCaptchaHomeOnly(boolean z) {
        save("settings_nfc_captcha_home_only", z);
    }

    public void setNFCCaptchaMultiscan(boolean z) {
        save("settings_nfc_captcha_multiscan", z);
    }

    public void setNewsShown(int i) {
        save("news_card_shown", i);
    }

    public void setNextAlarm(Date date) {
        String strValueOf;
        setDate("key_settings_next_scheduled_alarm", date);
        Context contextCreateDeviceProtectedStorageContext = this.context.createDeviceProtectedStorageContext();
        if (date == null) {
            strValueOf = "";
        } else {
            try {
                strValueOf = String.valueOf(date.getTime());
            } catch (Exception e) {
                Logger.logSevere(e);
                return;
            }
        }
        Log.i("SleepAsAndroidDB", "DB: Saving alarm " + date + " string " + strValueOf);
        FileOutputStream fileOutputStreamOpenFileOutput = contextCreateDeviceProtectedStorageContext.openFileOutput("next_alarm", 0);
        fileOutputStreamOpenFileOutput.write(strValueOf.getBytes());
        fileOutputStreamOpenFileOutput.flush();
        fileOutputStreamOpenFileOutput.close();
    }

    public void setNextMediaStoreJob(long j) {
        save("key_next_media_store_job", j);
    }

    public void setNextSleepTrackingRestartTimestamp(long j) {
        save("next_sleep_tracking_restart_timestamp", j);
    }

    public void setNextTimeToBed(Date date) {
        setDate("key_settings_next_time_to_bed", date);
    }

    public void setNoEscapeSuggestTime() {
        save("captcha_no_escape_suggest_time", System.currentTimeMillis());
    }

    public void setNoiseDirUri(Uri uri) {
        save(getDeviceSpecificKey("key_noise_dir_uri"), uri.toString());
    }

    public void setNoiseStatsCollecting(boolean z) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString("key_noise_stats", z ? "enabled" : "");
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public void setNoiseStoragePath(String str) {
        save("noise_storage_path", str);
    }

    public void setOximeter(boolean z) {
        save("oximeter", z);
    }

    public void setPairTracking(boolean z) {
        save("pair_tracking_enabled", z);
    }

    public void setPairTrackingToken(String str) {
        save("pair_tracking_token", str);
    }

    public void setPebbleTimelineToken(String str) {
        save("key_pebble_timeline_token", str);
    }

    public void setPhoneCall(boolean z) {
        save("phone_call", z);
    }

    public void setPlayStoreReferrer(String str) {
        save("play_store_referrer_url", str);
    }

    public void setPlayStoreReferrerInstallTime(long j) {
        save("play_store_referrer_install_time", j);
    }

    public void setPlaylistPosition(long j) {
        save("playlist_position", j);
    }

    public void setPolarSdkDevice(PolarDeviceInfo polarDeviceInfo) {
        if (polarDeviceInfo == null) {
            save("polar_sdk_device", (String) null);
        } else {
            save("polar_sdk_device", getPolarSdkDeviceString(polarDeviceInfo));
        }
    }

    public synchronized void setPriorityMode(boolean z) {
        save("mute_alerts_priority", z);
    }

    public void setPromoAttemptTime(long j) {
        save("key_next_promo_attempt", j);
    }

    public void setPromoShown(int i) {
        save("promo_card_shown", i);
    }

    public void setPublicComment(boolean z) {
        save("share_comments", z);
    }

    public void setQRCaptchaHomeOnly(boolean z) {
        save("settings_qr_captcha_home_only", z);
    }

    public void setQRCaptchaMultiscan(boolean z) {
        save("settings_qr_captcha_multiscan", z);
    }

    public void setRateDislike(boolean z) {
        save("rate_dislike_d", z);
    }

    public void setRateDone() {
        save("rate_done_h", true);
        save("rate_done_i", true);
        save("rate_done_beta_b", false);
        save("rate_done_ts_e", System.currentTimeMillis());
    }

    public void setRateLater(long j) {
        if (getRateShownCount() >= 4) {
            setRateNever();
        } else {
            save("rate_later_b", j);
            incRateShownCount();
        }
    }

    public void setRateLaterCancel() {
        setRateLater(System.currentTimeMillis() + 864000000);
    }

    public void setRateLaterDislike() {
        setRateLater(System.currentTimeMillis() + 2592000000L);
        save("rate_dislike_d", true);
    }

    public void setRateLaterPlayStore() {
        setRateLaterPlayStore(System.currentTimeMillis());
        setRateDone();
    }

    public void setRateNever() {
        save("rate_never_f", true);
        save("rate_never_ts_e", System.currentTimeMillis());
    }

    public void setRateWearableDone() {
        save("rate_wearable_done", true);
    }

    public void setRateWearableNever() {
        save("rate_wearable_never", true);
    }

    public void setRecordingMasterSwitchEnabled(boolean z) {
        save("noise_recording_master_switch", z);
    }

    public void setRecordingThreshold(int i) {
        save("sleep_recording_threshold2", i);
    }

    public void setRecordsCount(int i) {
        setAchievement(Achievement.Type.TRACK, i);
        save("records_count", i);
    }

    public void setRefreshPurchasesTime() {
        save("last_purchases_update", System.currentTimeMillis());
    }

    public void setReliableAlarmScheduled(boolean z) {
        save("reliable_alarm_scheduled", z);
    }

    public void setRevertDnd(boolean z) {
        Logger.logInfo("DND: will revert " + z);
        save("key_dnd_enabled", z);
    }

    public void setSamsungSHealth(boolean z) {
        zza$$ExternalSyntheticOutline0.m("S-HEALTH: set S HEALTH enabled: ", z);
        save("samsung_shealth_internal", z ? "enabled" : "disable");
        save("samsung_shealth", z);
    }

    public void setSamsungSHealthRecordCount(int i) {
        save("samsung_shealth_record_count", i, false);
    }

    public void setSamsungSHealthSyncLastTimestamp(long j) {
        save("samsung_shealth_last_sync", j);
    }

    public void setSelectedWearable(Wearable wearable) {
        save("selected_wearable", wearable.name());
    }

    public void setShareSnoringDetectionErrors(boolean z) {
        save("key_share_snoring_detection_errors_v4", z);
    }

    public void setShowReleaseNotes(boolean z) {
        save("release_notes", z);
    }

    public void setSireneRingtone(String str) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString("siren_ringtone", str);
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public void setSleepApiLastSuggestion(long j) {
        save("key_use_google_sleep_last_suggestion", j);
    }

    public void setSleepMaskBtAddress(String str) {
        save("sleep_mask_bt_address", str);
    }

    public void setSleepPhaserAddress(String str) {
        save("smartlight_sleep_phaser_address", str);
    }

    public void setSleepScore(int i, int i2) {
        save("sleep_score", i);
        save("sleep_score_max", i2);
    }

    @Deprecated
    public void setSleepTimeSuggestionLastDay(int i) {
        save("sleep_time_suggestion_last_notify_day", i);
    }

    public void setSleepTimeSuggestionLastNotificationTime(long j) {
        save("sleep_time_suggestion_last_notification_time", j);
    }

    public void setSleepTimeSuggestionMode(SleepTimeSuggestionManager.Mode mode) {
        save("sleep_time_suggestion_selected_mode", "" + mode.getCode());
    }

    public void setSleepTimeSuggestionScheduledNotificationTime(long j) {
        save("sleep_time_suggestion_scheduled_notification_time", j);
    }

    public void setSmartwatchEnabled(boolean z) {
        save("smartwatch", z);
    }

    public void setSnoozeAllowedTill(long j) {
        save("key_snooze_allowed_till", j);
    }

    public void setSnoringDetection(boolean z) {
        save("snoring_detection", z);
    }

    public void setSonarMethod(SonarConfig.SonarMethod sonarMethod) {
        save(getDeviceSpecificKey("sonar_method"), sonarMethod.name());
        Logger.logInfo("Sonar: set sonar method " + sonarMethod);
    }

    public void setSonarRevertVolume(int i) {
        save("sonar_revert_volume", i);
    }

    public void setSonarSignalStrength(int i) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putInt(getDeviceSpecificKey("sonar_signal_strength2"), i);
        editorEdit.apply();
    }

    public void setSonarStream(int i) {
        save(getDeviceSpecificKey("sonar_audio_stream"), i);
    }

    public void setSonarSupported(boolean z) {
        save(getDeviceSpecificKey("sonar_supported"), z ? 1 : 2);
    }

    public void setSonarVolumeOffset(int i) {
        save(getDeviceSpecificKey("sonar_volume_offset"), i);
        zza$$ExternalSyntheticOutline0.m(i, "Sonar: set offset ");
    }

    public void setSoundDelay(int i) {
        save("alarm_sound_delay", String.valueOf(i));
    }

    public void setSpotify(boolean z) {
        zza$$ExternalSyntheticOutline0.m("Spotify: set enabled: ", z);
        save("spotify_internal", z ? "enabled" : "disable");
        save("spotify", z);
    }

    public void setSpotifyAppRemoteScopeAllowed(boolean z) {
        Logger.logInfo("Spotify: set AppRemote scope allowed: " + z);
        save("spotify_app_remote_scope_allowed", z);
    }

    public void setSpotifyPremium(boolean z) {
        Logger.logInfo("Spotify: set premium: " + z);
        save("spotify_premium", z);
    }

    public void setSpotifyProduct(String str) {
        zza$$ExternalSyntheticOutline0.m("Spotify: set product: ", str);
        save("spotify_product", str);
    }

    public void setSpotifyToken(String str) {
        save("spotify_token", str);
    }

    public void setTabNoise(boolean z) {
        save("tab_noise", z);
    }

    public void setTasker(boolean z) {
        zza$$ExternalSyntheticOutline0.m("Tasker: set enabled: ", z);
        save("tasker_internal2", z ? "enabled" : "disable");
        save("tasker2", z);
        TaskerPlugin.enable(this.context, z);
    }

    public void setTermsAgreed() {
        save("terms_agreed", true);
    }

    public void setTextToSpeech(boolean z) {
        save("text_to_speech", z);
    }

    public void setThemeLastSet(int i) {
        save("theme_last_set", i);
    }

    public long setTimeDifference() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - System.currentTimeMillis();
        save("key_time_diff_internal", jElapsedRealtime, false);
        return jElapsedRealtime;
    }

    public void setTimeToBedRingtone(String str) {
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString("time_to_bed_ringtone", str);
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public void setTutorialPage(int i) {
        save("tutorial_page", i);
    }

    public void setUltrasonicTracking(boolean z) {
        save("non_deep_sleep_method", z ? String.valueOf(2) : AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public void setUnlockPrice(float f) {
        if (f > 0.0f) {
            save("unlock_app_clicked", System.currentTimeMillis());
            save("unlock_app_price", f);
        }
    }

    public void setUseFlashlight(boolean z) {
        save("alarm_with_flashlight_internal", z ? "enabled" : "disable");
    }

    public void setUserAdsAgreed() {
        save("key_user_ads_agreed_gdpr", "yes");
    }

    public void setUserAnalyticsAgreed() {
        save("key_user_analytics_agreed_gdpr", "yes");
    }

    public void setVolumePermissionNeeded(boolean z) {
        save(getDeviceSpecificKey("volume_permission_needed"), z);
    }

    public void setWakeUpCheckScheduled(long j) {
        Logger.logInfo("WakeUpCheck: save scheduled " + j);
        save("captcha_wake_up_check_scheduled", j);
    }

    public void setWakeUpCheckScheduledAlarmId(long j) {
        save("captcha_wake_up_check_scheduled_alarm_id", j);
    }

    public boolean setWearableOrInstallAddon(Wearable wearable) {
        if (!wearable.isVendorInstalled(this.context)) {
            String vendorDownloadLink = wearable.getVendorDownloadLink();
            Context context = this.context;
            if (vendorDownloadLink != null) {
                ViewIntent.url(context, wearable.getVendorDownloadLink());
            } else {
                ViewIntent.market(context, wearable.vendorPackageName);
            }
            return false;
        }
        if ("com.urbandroid.sleep.garmin".equals(wearable.vendorPackageName)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://apps.garmin.com/en-US/apps/a20548cf-647d-4171-b4b0-68ea002748b4"));
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            try {
                this.context.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
            }
        }
        if (wearable.isAddonInstalled(this.context)) {
            setSelectedWearable(wearable);
            return true;
        }
        ViewIntent.market(this.context, wearable.addonPackageName);
        return false;
    }

    public boolean shouldAskForRating() {
        int i = TrialFilter.getInstance().isTrial() ? 10 : 5;
        if (isGoodTimeToRate()) {
            i /= 2;
        }
        boolean z = (!Experiments.getInstance().isBeta() || TrialFilter.getInstance().hasUnlock()) && isTimeToRateAgain() && !isRateNever() && !isRateDone() && !isRateDislike() && TrialFilter.getInstance().daysUsed(i);
        if (z) {
            setGoodTimeToRate(false);
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldAskForRatingPlayStore() {
        boolean z;
        if (Experiments.getInstance().isBeta() || isRateDislike()) {
            return false;
        }
        int i = TrialFilter.getInstance().isTrial() ? 20 : 10;
        if (isAssholeManufacturer()) {
            i *= 2;
        }
        if (isGoodTimeToRate()) {
            i /= 2;
        }
        if (isTimeToRateAgainPlayStore() || (isGoodTimeToRate() && isTimeToRateAgainSoonerPlayStore())) {
            int i2 = i * 3;
            z = true;
            if ((!TrialFilter.getInstance().daysUsed(i2) || (RandUtil.range(1, 1000) <= 970 && !isGoodTimeToRate())) && !TrialFilter.getInstance().daysUsed(i, i2)) {
                z = false;
            }
        }
        if (z) {
            setGoodTimeToRate(false);
        }
        return z;
    }

    public boolean shouldAskForWearableAddonRating() {
        if ((Experiments.getInstance().isBeta() && !TrialFilter.getInstance().hasUnlock()) || isRateWearableNever() || isRateWearableDone()) {
            return false;
        }
        if (TrialFilter.getInstance().isTrial() || !TrialFilter.getInstance().daysUsed(3)) {
            return TrialFilter.getInstance().isTrial() && TrialFilter.getInstance().daysUsed(12);
        }
        return true;
    }

    public boolean shouldBeOnChargerWhenAutoStart() {
        if (getAutoStartWhenChargingMode() == 1) {
            return true;
        }
        return getAutoStartWhenChargingMode() != 2 && isUltrasonicTracking() && (getSelectedWearable() == null || getSelectedWearable() == Wearable.NONE) && getAutoStartWhenChargingMode() == 0;
    }

    public boolean shouldWakeUpCheckRepeat() {
        return getWakeUpCheckRepeatCount() < getWakeUpCheckRepeat();
    }

    public boolean showShowCaseIfNotShown(String str) {
        if (isShowCaseShown(str)) {
            return false;
        }
        addShowCaseShown(str);
        return true;
    }

    public void storeSpotifyAlbums(List<SpotifyServiceExecutor.SpotifyUri> list) {
        Logger.logInfo("Spotify: storing albums: " + list);
        if (list == null || list.size() == 0) {
            clear("spotify_albums");
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<SpotifyServiceExecutor.SpotifyUri> it = list.iterator();
        while (it.hasNext()) {
            sb.append(Joiner.PREPEND_SIZE_ITEM_MAPPER.map(it.next().serialize()));
        }
        this.context.getSharedPreferences("spotify", 0).edit().putString("spotify_albums", sb.toString()).apply();
        Logger.logInfo("Spotify: stored albums: ".concat(sb.toString()));
    }

    public long updateLastAppStartedTime(long j) {
        long prefLong = getPrefLong("key_last_app_started", 0L);
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putLong("key_last_app_started", j);
        editorEdit.apply();
        return prefLong;
    }

    public void updateLastNonSnoozeAlarm(long j) {
        long lastNonSnoozeAlarm = getLastNonSnoozeAlarm();
        if (lastNonSnoozeAlarm == -1 || (j > lastNonSnoozeAlarm && (j - lastNonSnoozeAlarm) / 3600000 >= 2)) {
            Logger.logDebug("updateLastNonSnoozeAlarm:" + j);
            save("key_settings_last_non_snooze_alarm", j);
        }
    }

    public void updateUserProfile(HealthUserProfile healthUserProfile) {
        if (healthUserProfile == null) {
            return;
        }
        Date birthDate = healthUserProfile.getBirthDate();
        if (birthDate != null) {
            save("health_user_profile_birthdate", birthDate.getTime());
        }
        HealthUserProfile.Gender gender = healthUserProfile.getGender();
        if (gender != HealthUserProfile.Gender.UNKNOWN) {
            save("health_user_profile_gender", gender.name());
        }
        if (healthUserProfile.getHeightInCentimeters() > 0.0f) {
            save("health_user_profile_height", healthUserProfile.getHeightInCentimeters());
        }
        if (healthUserProfile.getWeightInKilograms() > 0.0f) {
            save("health_user_profile_weight", healthUserProfile.getWeightInKilograms());
        }
        Logger.logInfo("User Profile updated: " + getUserProfile());
    }

    public boolean wereSamsungSHealthSleepStageRequested() {
        return getDefaultSharedPreferences(this.context).getBoolean("samsung_shealth_sleep_stages_requested", false);
    }

    public void setRateLaterPlayStore(long j) {
        save("rate_later_play_store", j);
    }

    public int getTheme() {
        return getTheme(getThemeValue());
    }

    public void setRateLater() {
        setRateLater(System.currentTimeMillis());
    }

    public CaptchaInfo getCaptchaInfo(int i) {
        return SharedApplicationContext.getCaptchaManager().getFinder().findById(i);
    }

    private String getCaptchaDifficultyKey(CaptchaInfo captchaInfo) {
        return getCaptchaDifficultyKey(captchaInfo.getActivityName());
    }

    public Settings(Context context) {
        this.remoteProcess = false;
        this.tabs = new String[]{"tab_dashboard", "tab_stats", "tab_graphs", "tab_noise"};
        this.deepSleepCounter = 0;
        this.context = context;
    }

    private void save(String str, int i) {
        if (str == null) {
            Logger.logWarning("Settings: Null key");
        } else {
            save(str, i, true);
        }
    }

    public boolean isFirstUsage() {
        return "yes".equals(getPrefString("key_first_use", "yes"));
    }

    private void save(String str, float f) {
        if (str == null) {
            Logger.logWarning("Settings: Null key");
            return;
        }
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putFloat(str, f);
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public int getCaptchaSuppressMode(Alarm alarm) {
        return getCaptchaSuppressMode(getCaptchaInfo(alarm));
    }

    public int getCaptchaSuppressMode(CaptchaInfo captchaInfo) {
        if (captchaInfo == null || captchaInfo.getActivityName() == null || !captchaInfo.getActivityName().contains("LOLCaptcha")) {
            return getCaptchaSuppressMode();
        }
        return 2;
    }

    private void save(String str, String str2) {
        if (str == null) {
            Logger.logWarning("Settings: Null key");
            return;
        }
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putString(str, str2);
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    private void save(String str, long j) {
        if (str == null) {
            Logger.logWarning("Settings: Null key");
        } else {
            save(str, j, true);
        }
    }

    private void save(String str, long j, boolean z) {
        if (str == null) {
            Logger.logWarning("Settings: Null key");
            return;
        }
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putLong(str, j);
        if (z) {
            editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        }
        editorEdit.apply();
    }

    public synchronized boolean isWakeUpCheck() {
        return getPrefBoolean("captcha_wake_up_check", false);
    }

    public void save(String str, boolean z) {
        if (str == null) {
            Logger.logWarning("Settings: Null key");
            return;
        }
        SharedPreferences.Editor editorEdit = getDefaultSharedPreferences(this.context).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.putLong("key_last_setting_modification", System.currentTimeMillis());
        editorEdit.apply();
    }

    public Measure[] orderMeasures(Measure[] measureArr) {
        Measure measure;
        ArrayList arrayList = new ArrayList();
        for (Measure measure2 : measureArr) {
            SleepScore.ScoreMeasure scoreMeasureMapToScoreMeasure = measure2.mapToScoreMeasure();
            if (scoreMeasureMapToScoreMeasure != null) {
                arrayList.add(scoreMeasureMapToScoreMeasure);
            }
        }
        List<SleepScore.ScoreMeasure> listOrderMeasures = orderMeasures(arrayList);
        Measure[] measureArr2 = new Measure[listOrderMeasures.size()];
        for (int i = 0; i < listOrderMeasures.size(); i++) {
            SleepScore.ScoreMeasure scoreMeasure = listOrderMeasures.get(i);
            if (scoreMeasure != null && (measure = scoreMeasure.getMeasure()) != null) {
                measureArr2[i] = measure;
            }
        }
        return measureArr2;
    }
}
