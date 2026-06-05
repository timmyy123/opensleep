package com.urbandroid.common.util;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.Signature;
import android.database.Cursor;
import android.media.AudioManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import com.urbandroid.common.error.IAdditionalDataProvider;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filter;
import com.urbandroid.sleep.SleeprecordExtKt;
import com.urbandroid.sleep.SuspensionSupportDetector;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.persistence.SleepRecordCsvMapper;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.phaser.SleepPhaser;
import com.urbandroid.sleep.smartwatch.phaser.SleepPhaserProvider;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.MemoryStats;
import java.io.File;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class CustomCrashInfoProvider implements IAdditionalDataProvider {
    public static String[] SECURED_PREFS = {"> ", "key_pebble_timeline_token", "key_location_lat", "key_location_lon", "spotify_token", "google_calendar_account_name", "health_user_profile_height", "health_user_profile_weight", "health_user_profile_gender", "health_user_profile_birthdate"};
    private final Context context;

    public CustomCrashInfoProvider(Context context) {
        this.context = context;
    }

    private void addAttachmentFiles(Map<String, String> map) {
        List<File> lastFiles = new ActivityFiles(this.context).getLastFiles(3);
        if (lastFiles.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < lastFiles.size(); i++) {
            sb.append(lastFiles.get(i).getAbsolutePath());
            if (i < lastFiles.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        map.put("extra_attachment_files", sb.toString());
    }

    private void addLogFiltersInfo(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        Set<Filter> filters = Logger.getFilters();
        if (filters.isEmpty()) {
            sb.append("Empty");
        } else {
            for (Filter filter : filters) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(filter);
            }
        }
        map.put("Logger filters", sb.toString());
    }

    private long browseFiles(File file, Map<String, String> map) {
        map.put(file.getAbsolutePath(), "");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd yyyy HH:mm");
        long j = 0;
        for (File file2 : file.listFiles()) {
            long length = file2.length() + j;
            map.put(file2.getAbsolutePath() + " uses: ", file2.length() + " bytes, lastMod: " + simpleDateFormat.format(new Date(file2.lastModified())));
            if (file2.isDirectory()) {
                length += browseFiles(file2, map);
            } else if (file2.getName().startsWith("BrowserMetrics") && file2.getName().endsWith("pma")) {
                map.put(file2.getAbsolutePath(), "DELETED " + file2.delete());
            }
            j = length;
        }
        map.put(file.getAbsolutePath() + " uses: ", j + " bytes");
        return j;
    }

    private String getLastNamePart(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    private List<String> getSignatureHashes() {
        LinkedList linkedList = new LinkedList();
        try {
            for (Signature signature : this.context.getPackageManager().getPackageInfo("com.urbandroid.sleep", 64).signatures) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                linkedList.add(Base64.encodeToString(messageDigest.digest(), 0));
            }
        } catch (Exception unused) {
        }
        return linkedList;
    }

    private String resolveAppStandByBucket() {
        UsageStatsManager usageStatsManager;
        if (Build.VERSION.SDK_INT < 28 || (usageStatsManager = (UsageStatsManager) this.context.getSystemService(UsageStatsManager.class)) == null) {
            return "";
        }
        int appStandbyBucket = usageStatsManager.getAppStandbyBucket();
        if (appStandbyBucket == 5) {
            return "EXEMPTED";
        }
        if (appStandbyBucket == 10) {
            return "ACTIVE";
        }
        if (appStandbyBucket == 20) {
            return "WORKING_SET";
        }
        if (appStandbyBucket == 30) {
            return "FREQUENT";
        }
        if (appStandbyBucket == 40) {
            return "RARE";
        }
        return appStandbyBucket + "";
    }

    private void serializeAlarms(Map<String, String> map) {
        try {
            Cursor alarmsCursor = Alarms.getAlarmsCursor(this.context);
            int i = 0;
            while (alarmsCursor.moveToNext()) {
                Alarm alarm = new Alarm(alarmsCursor);
                if (alarm.enabled) {
                    map.put("Alarm-" + alarm.id, Alarm.toDebugString(alarm));
                }
                i++;
                if (i > 20) {
                    return;
                }
            }
        } catch (Exception e) {
            Logger.logWarning("Failed to fetch last 14 days for error report.", e);
        }
    }

    private void serializeBackgroundRestrictions(Map<String, String> map) {
        ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
        if (Build.VERSION.SDK_INT < 28 || !activityManager.isBackgroundRestricted()) {
            return;
        }
        map.put("BACKGROUND RESTRICTION", "ENABLED!!!!!");
    }

    private void serializeExitReasons(Map<String, String> map) {
        if (Build.VERSION.SDK_INT >= 30) {
            map.put("EXIT REASONS:", "");
            ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
            if (activityManager != null) {
                Iterator<ApplicationExitInfo> it = activityManager.getHistoricalProcessExitReasons(this.context.getPackageName(), 0, 20).iterator();
                while (it.hasNext()) {
                    ApplicationExitInfo applicationExitInfoM263m = FacebookSdk$$ExternalSyntheticLambda1.m263m((Object) it.next());
                    map.put("EXIT: ", "Time: " + new Date(applicationExitInfoM263m.getTimestamp()) + " Reason: '" + applicationExitInfoM263m.getReason() + "' Status: '" + applicationExitInfoM263m.getStatus() + "' Memory: " + applicationExitInfoM263m.getPss() + MqttTopic.TOPIC_LEVEL_SEPARATOR + applicationExitInfoM263m.getRss() + " Importance: '" + applicationExitInfoM263m.getImportance() + "' Desc: '" + applicationExitInfoM263m.getDescription() + "' ");
                }
            }
            map.put("", "");
        }
    }

    private void serializeExperiments(Map<String, String> map) {
        map.put("Exp", Experiments.getInstance().getActiveExperiments().toString());
        map.put("Exp seed", String.valueOf(Experiments.getInstance().getCachedSeed()));
    }

    private void serializeImportantSettings(Map<String, String> map) {
        map.put("BETA", String.valueOf(Experiments.getInstance().isBeta()));
        map.put("Force screen off", String.valueOf(SharedApplicationContext.getSettings().isForceScreenOff()));
        map.put("Dim mode", String.valueOf(SharedApplicationContext.getSettings().getDimMode()));
        map.put("Stand-by mode", String.valueOf(SharedApplicationContext.getSettings().getWakeLockSettings()));
        map.put("Suspension support", SuspensionSupportDetector.getSuspendSupportMode(this.context).name());
        map.put("Screen timeout", String.valueOf(Settings.System.getInt(this.context.getContentResolver(), "screen_off_timeout", -42)));
        map.put("Gradual volume", PreferenceManager.getDefaultSharedPreferences(this.context).getString("alarm_increasing_volume_duration", "60000"));
        map.put("Gradual volume vibration", PreferenceManager.getDefaultSharedPreferences(this.context).getString("gradual_vibration_new", "80"));
        map.put("Noise master switch", String.valueOf(SharedApplicationContext.getSettings().isRecordingMasterSwitchEnabled()));
        map.put("Noise recording", String.valueOf(SharedApplicationContext.getSettings().isRecordingEnabled() || SharedApplicationContext.getSettings().isExperimentalNoiseRecoringEnabled()));
        map.put("Noise recording threshold", String.valueOf(SharedApplicationContext.getSettings().getRecordingThreshold()));
        map.put("First day of week", String.valueOf(Calendar.getInstance().getFirstDayOfWeek()));
        try {
            AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
            map.put("Ultrasound MIC", audioManager.getProperty("android.media.property.SUPPORT_MIC_NEAR_ULTRASOUND"));
            map.put("Ultrasound SPEAKER", audioManager.getProperty("android.media.property.SUPPORT_SPEAKER_NEAR_ULTRASOUND"));
        } catch (Exception unused) {
        }
        Map<String, ?> all = PreferenceManager.getDefaultSharedPreferences(this.context).getAll();
        ArrayList<String> arrayList = new ArrayList(all.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            if (!Arrays.asList(SECURED_PREFS).contains(str)) {
                map.put(str, String.valueOf(all.get(str)));
            }
        }
    }

    private void serializeLast14DaysRecordsOverview(Map<String, String> map) {
        try {
            List<SleepRecord> sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(System.currentTimeMillis() - 1209600000, System.currentTimeMillis(), false);
            if (sleepRecords != null) {
                int i = 1;
                for (SleepRecord sleepRecord : sleepRecords) {
                    map.put("Record-" + i, sleepRecord.getFrom() + " - " + sleepRecord.getTo() + " (" + sleepRecord.getLastestTo() + ")-> Rating: " + sleepRecord.getRating() + " Cycles: " + sleepRecord.getCycles() + " Quality: " + sleepRecord.getQuality() + " Len adj: " + sleepRecord.getLenAdjust());
                    String asciiHypnogram = SleeprecordExtKt.toAsciiHypnogram(sleepRecord, 10);
                    if (asciiHypnogram != null) {
                        map.put("Hypnogram-" + i, asciiHypnogram);
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            Logger.logWarning("Failed to fetch last 14 days for error report.", e);
        }
    }

    private void serializePermissions(Map<String, String> map) {
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"android.permission.RECORD_AUDIO", "android.permission.BODY_SENSORS", "android.permission.READ_PHONE_STATE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR", "android.permission.RECEIVE_BOOT_COMPLETED", "com.google.android.gms.permission.ACTIVITY_RECOGNITION", "android.permission.ACTIVITY_RECOGNITION", "android.permission.ACCESS_WIFI_STATE", "android.permission.CHANGE_WIFI_STATE", "android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.BLUETOOTH_CONNECT", "android.permission.VIBRATE", "android.permission.WRITE_SETTINGS", "android.permission.DISABLE_KEYGUARD", "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.NFC", "android.permission.SYSTEM_ALERT_WINDOW"};
            for (int i = 0; i < 24; i++) {
                String str = strArr[i];
                if (!PermissionCompat.isPermissionGranted(this.context, str)) {
                    sb.append(getLastNamePart(str));
                    sb.append(" ");
                }
            }
            if (Build.VERSION.SDK_INT >= 29 && !PermissionCompat.isPermissionGranted(this.context, "android.permission.ACCESS_FINE_LOCATION")) {
                sb.append(getLastNamePart("android.permission.ACCESS_FINE_LOCATION"));
                sb.append(" ");
            }
            if (!Settings.canDrawOverlays(this.context)) {
                sb.append("CAN_DRAW_OVERLAY ");
            }
            map.put("Permission missing", sb.toString());
        } catch (Exception unused) {
        }
    }

    private void serializeSleepPhaserInfo(Map<String, String> map) {
        SleepPhaser sleepPhaser = SleepPhaserProvider.getSleepPhaser(this.context);
        map.put("SleepPhaser", sleepPhaser == null ? "Not installed" : sleepPhaser.getInfo().toString());
    }

    private void serializeVolumeStreams(Map<String, String> map) {
        try {
            AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
            map.put("Volume of STREAM_ALARM", String.valueOf(audioManager.getStreamVolume(4)));
            map.put("Volume of STREAM_DTMF", String.valueOf(audioManager.getStreamVolume(8)));
            map.put("Volume of STREAM_MUSIC", String.valueOf(audioManager.getStreamVolume(3)));
            map.put("Volume of STREAM_NOTIFICATION", String.valueOf(audioManager.getStreamVolume(5)));
            map.put("Volume of STREAM_RING", String.valueOf(audioManager.getStreamVolume(2)));
            map.put("Volume of STREAM_SYSTEM", String.valueOf(audioManager.getStreamVolume(1)));
            map.put("Volume of STREAM_VOICE_CALL", String.valueOf(audioManager.getStreamVolume(0)));
        } catch (Exception e) {
            Logger.logDebug("Streams serialization has failed.", e);
        }
    }

    public void analyseStorage(Map<String, String> map) {
        File parentFile = this.context.getFilesDir().getParentFile();
        map.put("STORAGE", ":");
        map.put("TOTAL app usage ", browseFiles(parentFile, map) + " bytes.");
    }

    @Override // com.urbandroid.common.error.IAdditionalDataProvider
    public Map<String, String> getAdditionalData() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        serializeExitReasons(linkedHashMap);
        serializeBackgroundRestrictions(linkedHashMap);
        serializeExperiments(linkedHashMap);
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        linkedHashMap.put("Last record size", String.valueOf(record != null ? record.getRecordCount() : -1));
        linkedHashMap.put("Is trial", String.valueOf(TrialFilter.getInstance().isTrial()));
        linkedHashMap.put("Sleep records count", String.valueOf(SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecordsCount()));
        linkedHashMap.put("Signatures", TextUtils.join(", ", getSignatureHashes()));
        linkedHashMap.put("SSAID", Settings.Secure.getString(this.context.getApplicationContext().getContentResolver(), "android_id"));
        serializeImportantSettings(linkedHashMap);
        serializeVolumeStreams(linkedHashMap);
        serializePermissions(linkedHashMap);
        serializeLastSleepRecord(linkedHashMap);
        serializeLast14DaysRecordsOverview(linkedHashMap);
        linkedHashMap.put("\n", "");
        serializeAlarms(linkedHashMap);
        linkedHashMap.put("", "\n");
        linkedHashMap.put("App StandBy Bucket", resolveAppStandByBucket());
        linkedHashMap.put("Memory statistics", new MemoryStats(this.context).getStats());
        serializeSleepPhaserInfo(linkedHashMap);
        addLogFiltersInfo(linkedHashMap);
        addAttachmentFiles(linkedHashMap);
        analyseStorage(linkedHashMap);
        return linkedHashMap;
    }

    @Override // com.urbandroid.common.error.IAdditionalDataProvider
    public Set<Logger.LogConfig> getAdditionalLogs() {
        HashSet hashSet = new HashSet();
        hashSet.add(new Logger.LogConfig("AntiDozeService", "logbuffer_com.urbandroid.sleep:antidoze", false, 1000, 3, 1000, 1));
        return hashSet;
    }

    public String getMissingPermissions() {
        HashMap map = new HashMap();
        serializePermissions(map);
        return (String) map.get("Permission missing");
    }

    @Override // com.urbandroid.common.error.IAdditionalDataProvider
    public void logThrowable(Throwable th) {
        if (th != null) {
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventError(th);
        }
    }

    public void serializeLastSleepRecord(Map<String, String> map) {
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (record == null) {
            List<SleepRecord> sleepRecords = SharedApplicationContext.getInstance().getSleepRecordRepository().getSleepRecords(0, 1, true);
            record = sleepRecords.size() > 0 ? sleepRecords.iterator().next() : null;
        }
        if (record != null) {
            List<Float> history = record.getHistory();
            ListIterator<Float> listIterator = history.listIterator(history.size());
            for (int i = 0; listIterator.hasPrevious() && i < 40; i++) {
                Objects.toString(listIterator.previous());
            }
            map.put("Last record:", SleepRecordCsvMapper.sleepRecordToCsv(record));
        }
    }
}
