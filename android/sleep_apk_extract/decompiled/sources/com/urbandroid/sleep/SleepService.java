package com.urbandroid.sleep;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.backup.BackupManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.AnalyticsEvents;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.ForegroundService;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.PowerManagerCompat;
import com.urbandroid.sleep.SuspensionSupportDetector;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.RatingActivity;
import com.urbandroid.sleep.alarmclock.volume.LullabyVolumeDown;
import com.urbandroid.sleep.appwidget.DroidWidget;
import com.urbandroid.sleep.audio.AudioRecorder;
import com.urbandroid.sleep.audio.consumer.RecordingAudioConsumer;
import com.urbandroid.sleep.audio.consumer.SnoringDetectionAudioConsumer;
import com.urbandroid.sleep.audio.consumer.TensorflowAudioConsumerV3;
import com.urbandroid.sleep.audio.consumer.TensorflowAudioConsumerV4;
import com.urbandroid.sleep.autostart.AutoTrackingProcessor;
import com.urbandroid.sleep.autostart.AutoTrackingSoundReceiver;
import com.urbandroid.sleep.autostart.ExpectedTrackingRange;
import com.urbandroid.sleep.domain.AccelSleepRecorder;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.achievement.Achievement;
import com.urbandroid.sleep.domain.interval.EventPair;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.hr.BluetoothHrService;
import com.urbandroid.sleep.jetlag.JetLagService;
import com.urbandroid.sleep.media.lullaby.LullabyService;
import com.urbandroid.sleep.mic.SleepRecordNoiseLevelRecorder;
import com.urbandroid.sleep.mic.SnoringReceiver;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.sensor.extra.EnsembleExtraDataCollector;
import com.urbandroid.sleep.sensor.sonar.SonarConsumer;
import com.urbandroid.sleep.sensor.sonar.SonarConsumerFactory;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.awake.AwakeDetector;
import com.urbandroid.sleep.service.awake.AwakeWhenHighActivity;
import com.urbandroid.sleep.service.awake.AwakeWhenHighActivityFrequency;
import com.urbandroid.sleep.service.awake.AwakeWhenLightsOn;
import com.urbandroid.sleep.service.awake.AwakeWhenUsingPhoneDetector;
import com.urbandroid.sleep.service.awake.EnsembleAwakeDetector;
import com.urbandroid.sleep.smartlight.SmartLight;
import com.urbandroid.sleep.smartlight.SmartLightProvider;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import com.urbandroid.sleep.smartwatch.phaser.SleepPhaser;
import com.urbandroid.util.AirplaneModeUtil;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.MemoryStats;
import com.urbandroid.util.SleepPermissionCompat;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class SleepService extends ForegroundService implements ISleepService {
    public static int FRAMERATE = 10000;
    public static int FRAMERATE_SONAR = 10000;
    public static long LAST_FINISHED_TIME = 0;
    private static boolean RUNNING = false;
    private static boolean RUNNING_TIMELY = false;
    public static int SONAR_INITIAL_VOLUME = -1;
    public static int WATCHER_RATE = 30000;
    private static AudioRecorder audioRecorder = null;
    private static volatile boolean awake = true;
    private static volatile boolean awakeFired = false;
    private static boolean started = false;
    private static boolean startedManually = false;
    private static boolean withoutWatch = false;
    private boolean accelerometerRestartedAfterScreenOff;
    private boolean actOnTargetSleepTime;
    private Alarm alarm;
    private int alarmStartedRingingId;
    private long alarmStartedRingingTs;
    private AutoTrackingSoundReceiver autoTrackingSoundReceiver;
    private EnsembleAwakeDetector awakeDetector;
    private int count;
    private int counter;
    private EnsembleExtraDataCollector dataCollector;
    private ExpectedTrackingRange expectedTrackingRage;
    private boolean firstStart;
    private Handler h;
    private int idealSleepDurationMin;
    private boolean ignoreScreenOffSupport;
    private boolean isActivityRunning;
    private boolean isAlarmRinging;
    private boolean isInOffScreenTrackingMode;
    private boolean isScreenOff;
    private boolean isSmartPeriod;
    private JetLagService jetLagService;
    private long lastKnownTimestamp;
    private SleepLockManager lockManager;
    private boolean lowBatteryFired;
    private LullabyVolumeDown lullabyVolumeDown;
    private Runnable mainThreadLoggingRunnable;
    private SleepRecordNoiseLevelRecorder noiseLevelRecorder;
    private int originalSystemVolume;
    private Thread otherThreadLoggingRunnable;
    private boolean pauseRecordingWithoutResumeCalled;
    private SleepServicePhoneStateListener phoneStateListener;
    private BroadcastReceiver receiver;
    private AccelSleepRecorder recorder;
    private Alarm ringingAlarm;
    private ScreenStateBroadcastReceiver screenStateBroadcastReceiver;
    private IBinder serviceBinder;
    private Runnable sleepWatcher;
    public SmartLight smartLight;
    public boolean smartLightOn;
    private SmartWatch smartWatch;
    private SonarConsumer sonarConsumer;
    private boolean startedInWorksMode;

    public class ScreenStateBroadcastReceiver extends BroadcastReceiver {
        public ScreenStateBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                Logger.logInfo("SleepService: Screen off detected");
                SleepService.this.onScreenOff();
                SleepService.this.awakeDetector.onScreenOff();
                SleepService.this.counter = 0;
                return;
            }
            if (!intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                Logger.logSevere("Unexpected intent: " + intent);
            } else {
                Logger.logInfo("SleepService: Screen on detected");
                SleepService.this.onScreenOn();
                SleepService.this.awakeDetector.onScreenOn();
                SleepService.this.counter = 0;
            }
        }
    }

    public class SleepServiceBinder extends Binder {
        public SleepServiceBinder() {
        }

        public SleepService getService() {
            return SleepService.this;
        }
    }

    public SleepService() {
        super("sleepTrackingChannel", 34321266, R.drawable.ic_action_track_white);
        this.firstStart = false;
        this.awakeDetector = new EnsembleAwakeDetector();
        this.counter = 0;
        this.actOnTargetSleepTime = false;
        this.idealSleepDurationMin = -1;
        this.sleepWatcher = new Runnable() { // from class: com.urbandroid.sleep.SleepService.1
            private void fireSmartAlarm(Alarm alarm) {
                Logger.logInfo("SleepService:FLUSH last value into graph after smart fire");
                SleepService.this.recorder.flush();
                SharedApplicationContext.getSettings().setSnoozeAllowedTill(alarm.time);
                Logger.logInfo("Snooze after alarm? set till time " + alarm.time);
                SleepService.this.alarmStartedRingingTs = System.currentTimeMillis();
                SleepService.this.alarmStartedRingingId = alarm.id;
                Logger.logInfo("Smart: SET (fireSmartAlarm) [" + SleepService.this.alarmStartedRingingId + "] " + new Date(SleepService.this.alarmStartedRingingTs));
                Alarms.fireSmartAlarm(SleepService.this, alarm);
                new Settings(SleepService.this).addAchievement(Achievement.Type.SMART_WAKE, 1);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SleepService sleepService = SleepService.this;
                    new Settings(sleepService);
                    SleepService.this.lastKnownTimestamp = System.currentTimeMillis();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date());
                    if (SleepService.this.pauseRecordingWithoutResumeCalled && !SleepService.this.isPausedTracking()) {
                        Logger.logInfo("SleepService:Automatically calling resumeTracking().");
                        SleepService.this.resumeTracking();
                    }
                    if (SleepService.this.smartWatch == null && SleepService.this.recorder != null && !SharedApplicationContext.getSettings().isForceScreenOff() && !SleepService.this.ignoreScreenOffSupport && !Environment.isIcsOrGreater() && SleepService.this.isScreenOff) {
                        if (SleepService.this.recorder.getCountOfZeroValuesInRow() <= 8 || SleepService.this.accelerometerRestartedAfterScreenOff) {
                            if (SleepService.this.recorder.getCountOfZeroValuesInRow() > 10 && SleepService.this.isInOffScreenTrackingMode) {
                                SleepService.this.disableOffScreenTrackingDueToLargeNumberOfZeros();
                            }
                        } else if (SleepService.this.isInOffScreenTrackingMode) {
                            SleepService.this.autoProbeWorksWithStartAfterScreenOff();
                        }
                    }
                    if (SleepService.this.alarm != null && SleepService.this.alarmStartedRingingId != SleepService.this.alarm.id && (SleepService.this.alarmStartedRingingTs == -1 || System.currentTimeMillis() - SleepService.this.alarmStartedRingingTs > 3600000)) {
                        if (calendar.get(11) == SleepService.this.alarm.getOffsetHour(sleepService) && calendar.get(12) == SleepService.this.alarm.getOffsetMinutes(sleepService)) {
                            Logger.logInfo("Smart: alarm starts soon no need to trigger");
                        } else if (SleepService.this.isInSmartPeriod() && SleepService.this.recorder.getSleepPhase().isLightSleep() && SleepService.this.isActOnTargetSleepFullFilled()) {
                            if (CurrentSleepRecord.getInstance().getRecord() == null || (CurrentSleepRecord.getInstance().getRecord() != null && TrialFilter.getInstance().isTrackingEnabledForRecord(CurrentSleepRecord.getInstance().getRecord()))) {
                                Logger.logInfo("SleepService: Light sleep detected, firing smart alarm");
                                fireSmartAlarm(SleepService.this.alarm);
                                SleepService sleepService2 = SleepService.this;
                                Alarms.suspendAlarm(sleepService2, sleepService2.alarm, SleepService.this.alarm.time + 1);
                                if (SleepService.this.lullabyVolumeDown != null) {
                                    SleepService.this.lullabyVolumeDown.finish();
                                }
                            } else {
                                Logger.logInfo("SleepService:Ignoring smart alarm due to trial expired.");
                            }
                        }
                    }
                    if (SleepService.this.lullabyVolumeDown != null) {
                        boolean zIsPausedTracking = SleepService.this.isPausedTracking();
                        SleepService sleepService3 = SleepService.this;
                        if (zIsPausedTracking) {
                            sleepService3.lullabyVolumeDown.reset();
                        } else {
                            sleepService3.lullabyVolumeDown.update(SleepService.this.recorder.getSleepPhase().isDeepSleep());
                        }
                    }
                    SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
                    if (SleepService.this.awakeDetector.isAwake()) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (SleepService.this.expectedTrackingRage != null && !Experiments.getInstance().isShowEstimateEvenTracking()) {
                            AutoTrackingProcessor.addActivityAndProcessStages(sleepService, SleepService.WATCHER_RATE, SleepService.this.expectedTrackingRage);
                        }
                        if (record != null) {
                            record.addEventLabel(EventLabel.AWAKE_START, jCurrentTimeMillis - ((long) SleepService.WATCHER_RATE));
                            record.addEventLabel(EventLabel.AWAKE_END, jCurrentTimeMillis);
                        }
                        if (!SleepService.awake) {
                            Logger.logInfo("SleepService: IS Awake");
                            SleepService.awake = true;
                            SleepService.awakeFired = true;
                            LocalBroadcastManager.getInstance(SleepService.this).sendBroadcast(new Intent("com.urbandroid.sleep.AWAKE"));
                            ContextExtKt.sendExplicitBroadcast(sleepService, new Intent("com.urbandroid.sleep.AWAKE"));
                        }
                    } else if (SleepService.awake) {
                        Logger.logInfo("SleepService: NOT Awake");
                        SleepService.awake = false;
                        if (SleepService.awakeFired) {
                            LocalBroadcastManager.getInstance(SleepService.this).sendBroadcast(new Intent("com.urbandroid.sleep.NOT_AWAKE"));
                            ContextExtKt.sendExplicitBroadcast(sleepService, new Intent("com.urbandroid.sleep.NOT_AWAKE"));
                            SleepService.awakeFired = false;
                        }
                    }
                    if (SleepService.this.dataCollector != null && record != null) {
                        SleepService.this.dataCollector.process(record);
                    }
                    if (Experiments.getInstance().useNokiaWakeScreenHack() && TrialFilter.getInstance().isNokiaEvenwell() && SharedApplicationContext.getSettings().getDimMode() < 5 && SleepService.this.counter > 0 && SleepService.this.counter % 18 == 0 && SleepService.this.isScreenOff) {
                        Logger.logInfo("LockManager: restarting screen on Nokia");
                        SleepService.this.lockManager.turnScreenOn();
                        Intent intent = new Intent(SleepService.this, (Class<?>) Sleep.class);
                        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
                        intent.addFlags(67108864);
                        SleepService.this.startActivity(intent);
                    }
                    SleepService.this.counter++;
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        };
        this.count = 0;
        this.serviceBinder = new SleepServiceBinder();
        this.isInOffScreenTrackingMode = false;
        this.lockManager = null;
        this.startedInWorksMode = false;
        this.ignoreScreenOffSupport = false;
        this.isScreenOff = false;
        this.isActivityRunning = true;
        this.isAlarmRinging = false;
        this.alarmStartedRingingTs = -1L;
        this.alarmStartedRingingId = -1;
        this.accelerometerRestartedAfterScreenOff = false;
        this.lowBatteryFired = false;
        this.pauseRecordingWithoutResumeCalled = false;
        this.smartLightOn = false;
        this.lullabyVolumeDown = null;
        this.isSmartPeriod = false;
        this.receiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.SleepService.5
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                SleepRecord record;
                SleepRecord record2;
                String action = intent.getAction();
                if (action.equals("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE")) {
                    Logger.logInfo("SleepService:Ignoring snooze action");
                    return;
                }
                if (action.equals("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE_CLICKED_ACTION")) {
                    LullabyService.resume(SleepService.this.getApplicationContext());
                    return;
                }
                if ("com.urbandroid.sleep.alarmclock.ALARM_DONE".equals(action)) {
                    Logger.logInfo("SleepService:Alarm Done");
                    SleepService.this.isAlarmRinging = false;
                    if (SleepService.audioRecorder != null) {
                        SleepService.audioRecorder.resume(AudioRecorder.PauseReason.ALARM);
                        return;
                    }
                    return;
                }
                if ("com.urbandroid.sleep.alarmclock.ALARM_ALERT_START_INTERNAL".equals(action)) {
                    Logger.logInfo("SleepService:Alarm Start");
                    SleepService.this.isAlarmRinging = true;
                    SleepService.this.ringingAlarm = Alarm.parseFromIntent(intent);
                    Logger.logInfo("SleepService:Setting ringing alarm: " + Alarm.toDebugString(SleepService.this.ringingAlarm));
                    if (SleepService.audioRecorder != null) {
                        SleepService.audioRecorder.pause(AudioRecorder.PauseReason.ALARM);
                    }
                    SleepService.this.stopJetLag();
                    LullabyService.pause(SleepService.this.getApplicationContext());
                    return;
                }
                if ("com.urbandroid.sleep.alarmclock.ALARM_ALERT".equals(action)) {
                    Alarm fromIntent = Alarm.parseFromIntent(intent);
                    if (fromIntent != null) {
                        Logger.logInfo("SleepService: ALARM_ALERT " + Alarm.toDebugString(fromIntent));
                        SleepService.this.alarmStartedRingingTs = System.currentTimeMillis();
                        SleepService.this.alarmStartedRingingId = fromIntent.id;
                        Logger.logInfo("Smart: SET (ALARM ALERT)  [" + SleepService.this.alarmStartedRingingId + "] " + new Date(SleepService.this.alarmStartedRingingTs));
                        return;
                    }
                    return;
                }
                if ("com.urbandroid.sleep.ACTION_CHECK_TRACKING_IS_AWAKE".equals(action)) {
                    SleepService.this.restartSleepActivity();
                    return;
                }
                if ("com.urbanroid.sleep.SLEEP_LOW_BATTERY".equals(action)) {
                    SleepRecord record3 = CurrentSleepRecord.getInstance().getRecord();
                    if (record3 != null && !SleepService.this.lowBatteryFired) {
                        SleepService.this.lowBatteryFired = true;
                        record3.addEventLabel(EventLabel.LOW_BATTERY, System.currentTimeMillis());
                        SleepService.this.setDisabled(true);
                    }
                    if (SleepService.audioRecorder != null) {
                        Logger.logInfo("SleepService:Low battery event -> stopping noise recording.");
                        SleepService.audioRecorder.pause(AudioRecorder.PauseReason.TERMINATING);
                        SleepService.audioRecorder.stop();
                        SleepService.audioRecorder = null;
                        return;
                    }
                    return;
                }
                if ("com.urbandroid.sleep.ACTION_TRACKING_PAUSED".equals(action)) {
                    SleepService.this.isActivityRunning = false;
                    Logger.logInfo("SleepService:Sleep activity paused");
                    return;
                }
                if ("com.urbandroid.sleep.ACTION_TRACKING_RESUMED".equals(action)) {
                    SleepService.this.isActivityRunning = true;
                    Logger.logInfo("SleepService:Sleep activity resumed");
                    if (SleepService.this.isInOffScreenTrackingMode || Experiments.getInstance().isKeepLockWithScreenOnTracking()) {
                        return;
                    }
                    SleepService.this.lockManager.acquireLockOnResume();
                    return;
                }
                if ("com.urbandroid.sleep.ACTION_TRACKING_STARTED".equals(action)) {
                    Logger.logInfo("SleepService:Sleep activity started");
                    boolean unused = SleepService.this.isInOffScreenTrackingMode;
                    return;
                }
                if ("com.urbandroid.sleep.LUCID_CUE_ACTION".equals(action)) {
                    if (!SharedApplicationContext.getSettings().getLucidEnabled() || (record2 = CurrentSleepRecord.getInstance().getRecord()) == null) {
                        return;
                    }
                    record2.addEventLabel(EventLabel.LUCID_CUE, System.currentTimeMillis());
                    return;
                }
                if (SnoringReceiver.ANTISNORING_ACTION.equals(action)) {
                    if (SharedApplicationContext.getSettings().getRecordingAntisnoreResponse() <= 0 || (record = CurrentSleepRecord.getInstance().getRecord()) == null) {
                        return;
                    }
                    record.addEventLabel(EventLabel.ANTISNORE, System.currentTimeMillis());
                    return;
                }
                if ("com.urbandroid.sleep.ACTION_TRACKING_STOPPED".equals(action)) {
                    Logger.logInfo("SleepService:Sleep activity stopped");
                    if (SleepService.this.isInOffScreenTrackingMode || Experiments.getInstance().isKeepLockWithScreenOnTracking()) {
                        return;
                    }
                    SleepService.this.lockManager.releaseOnStop();
                    return;
                }
                if ("com.urbandroid.sleep.ACTION_PAUSE_RECORDING".equals(action)) {
                    SleepService.this.pauseNoiseRecording((AudioRecorder.PauseReason) intent.getSerializableExtra("extra_pause_reason"));
                    return;
                }
                if ("com.urbandroid.sleep.alarmclock.SLEEP_TRACKING_ENABLE".equals(action)) {
                    if (SleepService.this.isDisabled()) {
                        SleepService.this.setDisabled(false);
                        return;
                    }
                    return;
                }
                if ("com.urbandroid.sleep.ACTION_RESUME_RECORDING".equals(action)) {
                    SleepService.this.resumeNoiseRecording((AudioRecorder.PauseReason) intent.getSerializableExtra("extra_pause_reason"));
                    return;
                }
                if ("com.urbandroid.sleep.alarmclock.ALARM_RESCHEDULED".equals(action)) {
                    SleepService sleepService = SleepService.this;
                    sleepService.alarm = Alarms.calculateNextAlert(sleepService);
                    Logger.logInfo("SleepService: Smart: SET alarm " + Alarm.toDebugString(SleepService.this.alarm));
                    SleepRecord record4 = CurrentSleepRecord.getInstance().getRecord();
                    if (record4 != null) {
                        record4.setOrUpdateAlarmTimeLabels(SleepService.this.alarm);
                        return;
                    }
                    return;
                }
                if ("com.urbandroid.sleep.ACTION_LULLABY_START_PLAYBACK".equals(action)) {
                    Logger.logInfo("LullabyVolumeDown: playlist offset " + intent.getIntExtra("extra_lullaby_offset", -1));
                    if (intent.hasExtra("extra_lullaby_offset") && intent.getIntExtra("extra_lullaby_offset", -1) >= 0) {
                        Logger.logInfo("LullabyVolumeDown: ignore reset after new lullaby - reason: playlist offset " + intent.getIntExtra("extra_lullaby_offset", 0));
                        return;
                    }
                    Logger.logInfo("LullabyVolumeDown: reset after new lullaby start");
                    if (SleepService.this.lullabyVolumeDown != null) {
                        SleepService.this.lullabyVolumeDown.finish();
                    }
                    if (SleepService.this.sonarConsumer == null || SharedApplicationContext.getSettings().getSonarStream() != 3) {
                        SleepService sleepService2 = SleepService.this;
                        sleepService2.lullabyVolumeDown = new LullabyVolumeDown(sleepService2, 3, SharedApplicationContext.getSettings().getLullabyVolumeDownAfter());
                        return;
                    }
                    return;
                }
                if ("com.urbandroid.sleep.ACTION_PAUSE_TRACKING".equals(action) || "com.urbandroid.sleep.ACCEL_GESTURE_FLIP_ACTION".equals(action)) {
                    Logger.logInfo("SleepService:PAUSE TRACKING RECEIVED");
                    if (!"com.urbandroid.sleep.ACCEL_GESTURE_FLIP_ACTION".equals(action) || SharedApplicationContext.getSettings().isFlipToPause()) {
                        SleepService.this.pauseTracking(300000L);
                        return;
                    }
                    return;
                }
                if ("com.urbandroid.sleep.ACTION_PAUSE_TRACKING_CAP".equals(action)) {
                    Logger.logInfo("SleepService:PAUSE TRACKING CAP RECEIVED");
                    if (!SleepService.this.isPausedTracking() || SleepService.this.recorder.getRemainingPauseMillis() < 10000) {
                        SleepService.this.pauseTracking(300000L);
                        return;
                    }
                    return;
                }
                if ("com.urbandroid.sleep.ACTION_RESUME_TRACKING".equals(action)) {
                    SleepService.this.resumeTracking();
                    return;
                }
                if ("com.urbandroid.sleep.USER_AWAKE".equals(action)) {
                    SleepService.this.handleUserAwakeUsingPausing();
                    return;
                }
                if ("android.os.action.DEVICE_IDLE_MODE_CHANGED".equals(action)) {
                    Logger.logInfo("SleepService DOZE mode changed, doze " + ((PowerManager) context.getSystemService("power")).isDeviceIdleMode());
                    return;
                }
                if ("com.urbandroid.sleep.alarmclock.TIME_CHANGED".equals(action)) {
                    SleepService.this.timeChanged(intent.getLongExtra("com.urbandroid.sleep.alarmclock.TIME_CHANGED_EXTRA", 0L));
                    return;
                }
                if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                    SleepService.this.handleBatteryUpdate(intent.getIntExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, 1), intent.getIntExtra("plugged", -1), intent.getIntExtra("level", 0), intent.getIntExtra("temperature", 0));
                    if (SleepService.this.lockManager.shouldBeInStandByMode()) {
                        return;
                    }
                    SleepService.this.unscheduleAlarm();
                    SleepService.this.scheduleAlarm();
                    return;
                }
                if (action.equals("com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK")) {
                    SleepService.this.terminateTracking(context, action);
                    return;
                }
                if (action.equals("com.urbandroid.sleep.alarmclock.ALARM_DISMISS") || action.equals("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CLICKED_ACTION") || action.equals("com.urbandroid.sleep.alarmclock.cancel_snooze_finished")) {
                    if (SleepService.this.ringingAlarm == null || SleepService.this.ringingAlarm.extendedConfig.isTerminatesTracking().booleanValue()) {
                        SleepService.this.terminateTracking(context, action);
                    } else {
                        Logger.logInfo("Tracking keeps going, alarm does not terminate it.");
                    }
                    LullabyService.stop(SleepService.this.getApplicationContext());
                }
            }
        };
        this.originalSystemVolume = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoProbeWorksWithStartAfterScreenOff() {
        if (!isDisabled() && this.smartWatch == null && this.isInOffScreenTrackingMode && !this.accelerometerRestartedAfterScreenOff) {
            Logger.logInfo("SleepService:Going to auto-probe screen off accel restart.");
            initiateAccelerometerScreenOffRestart(1);
        }
    }

    private SnoringDetectionAudioConsumer createOldSnoringDetector() {
        return SnoringDetectionAudioConsumer.from(getApplicationContext()).bufferSizeInSeconds(20).decimateFactor(4);
    }

    private PendingIntentBuilder createPendingIntent() {
        return PendingIntentBuilder.get(this, 0, new Intent("com.urbandroid.sleep.ACTION_CHECK_TRACKING_IS_AWAKE"), 134217728);
    }

    private AudioRecorder.Consumer createSoundClassificationAudioConsumer() {
        if (!Experiments.getInstance().isAnyTensorflow()) {
            Logger.logInfo("SleepService: using the old snoring detector");
            return createOldSnoringDetector();
        }
        try {
            if (Experiments.getInstance().isTensorflowV3()) {
                Logger.logInfo("SleepService: using tensorflow classifier V3");
                return new TensorflowAudioConsumerV3(getApplicationContext());
            }
            if (Experiments.getInstance().isTensorflowV4()) {
                Logger.logInfo("SleepService: using tensorflow classifier V4");
                return new TensorflowAudioConsumerV4(getApplicationContext());
            }
            Logger.logSevere("SleepService: invalid Tensorflow config, falling back to the old snoring detection.");
            return createOldSnoringDetector();
        } catch (Exception e) {
            return recoverFromTensorflowLiteInitializationError(e);
        } catch (LinkageError e2) {
            return recoverFromTensorflowLiteInitializationError(e2);
        }
    }

    private void deregisterScreenStateMonitor() {
        Logger.logInfo("SleepService:Unregistering screen state reciever.");
        ScreenStateBroadcastReceiver screenStateBroadcastReceiver = this.screenStateBroadcastReceiver;
        if (screenStateBroadcastReceiver != null) {
            unregisterReceiver(screenStateBroadcastReceiver);
        }
        this.screenStateBroadcastReceiver = null;
    }

    public static AudioRecorder getAudioRecorder() {
        return audioRecorder;
    }

    public static Class getServiceClass(Context context) {
        return SleepService.class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBatteryUpdate(int i, int i2, int i3, int i4) {
        this.lockManager.onBatteryUpdate(i, i2, i3);
        boolean zIsPluggedIn = this.lockManager.isPluggedIn();
        if (this.lowBatteryFired && this.lockManager.isDisabled() && zIsPluggedIn) {
            Logger.logInfo("SleepService:Cancelling disabled mode as phone is plugged to battery");
            setDisabled(false);
            if (this.isInOffScreenTrackingMode) {
                return;
            }
            this.lockManager.turnScreenOn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUserAwakeUsingPausing() {
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (record == null || record.getHistory().size() < 2) {
            return;
        }
        long remainingPauseMillis = getRemainingPauseMillis();
        if (remainingPauseMillis < 240000) {
            StringBuilder sb = new StringBuilder("Awake: pausing ");
            long j = 300000 - remainingPauseMillis;
            sb.append(j);
            Logger.logInfo(sb.toString());
            pauseTracking(j);
        }
    }

    private void initiateAccelerometerScreenOffRestart(final int i) {
        StringBuilder sb = new StringBuilder("SleepService:Scheduling accel manager restart. Recorder: ");
        sb.append(this.recorder);
        sb.append(" Already restarted: ");
        sb.append(this.accelerometerRestartedAfterScreenOff);
        sb.append(" SOFF: ");
        zza$$ExternalSyntheticOutline0.m(sb, this.isScreenOff);
        if (this.accelerometerRestartedAfterScreenOff || !this.isScreenOff) {
            return;
        }
        if (this.recorder != null) {
            Logger.logDebug("SleepService:Stopping accelerometer.");
            this.recorder.stop();
        }
        this.h.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.SleepService.7
            @Override // java.lang.Runnable
            public void run() {
                if (!SleepService.this.accelerometerRestartedAfterScreenOff && SleepService.this.isScreenOff) {
                    if (SleepService.this.recorder == null || SleepService.this.recorder.isStarted()) {
                        return;
                    }
                    Logger.logInfo("SleepService:Recorder restarted on screen off.");
                    SleepService.this.recorder.start(i);
                    SleepService.this.accelerometerRestartedAfterScreenOff = true;
                    return;
                }
                Logger.logInfo("SleepService:Belated restart. ScreenOff: " + SleepService.this.isScreenOff + " Accel rest: " + SleepService.this.accelerometerRestartedAfterScreenOff);
                if (SleepService.this.recorder == null || SleepService.this.recorder.isStarted()) {
                    return;
                }
                Logger.logInfo("SleepService:Recorder restarted, but screen is still (again) on...");
                SleepService.this.recorder.start(i);
            }
        }, 2000L);
    }

    private void initiateAccelerometerScreenOnRestart() {
        if (this.isInOffScreenTrackingMode) {
            return;
        }
        if (this.recorder != null) {
            Logger.logDebug("SleepService:Stopping accelerometer on screen on.");
            this.recorder.stop();
        }
        this.h.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.SleepService.6
            @Override // java.lang.Runnable
            public void run() {
                if (SleepService.this.recorder == null || SleepService.this.recorder.isStarted()) {
                    return;
                }
                Logger.logInfo("SleepService:Recorder restarted on screen on.");
                SleepService.this.recorder.start(1);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isActOnTargetSleepFullFilled() {
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (!this.actOnTargetSleepTime || this.idealSleepDurationMin == -1 || record == null) {
            return true;
        }
        boolean z = record.getSleepLengthMinutes() >= this.idealSleepDurationMin;
        if (!z) {
            StringBuilder sb = new StringBuilder("SleepService: Ignoring smart wake due to act on ideal ");
            sb.append(record.getSleepLengthMinutes());
            sb.append(" >= ");
            zza$$ExternalSyntheticOutline0.m(sb, this.idealSleepDurationMin);
            return z;
        }
        if (!Experiments.getInstance().isBeta()) {
            return z;
        }
        Logger.logInfo("SleepService: act on ideal NOT YET " + record.getSleepLengthMinutes() + " < " + this.idealSleepDurationMin + ", trying to count in awake");
        record.mergeAwakeOverlaps();
        record.computeLenAdjust();
        boolean z2 = record.getSleepLengthMinutes() >= this.idealSleepDurationMin;
        if (!z2) {
            StringBuilder sb2 = new StringBuilder("SleepService: Ignoring smart wake due to act on ideal ");
            sb2.append(record.getSleepLengthMinutes());
            sb2.append(" >= ");
            zza$$ExternalSyntheticOutline0.m(sb2, this.idealSleepDurationMin);
        }
        return z2;
    }

    public static boolean isAwake() {
        return awake;
    }

    public static synchronized boolean isRunning() {
        return RUNNING;
    }

    public static synchronized boolean isRunningTimely() {
        return RUNNING_TIMELY;
    }

    public static boolean isStartedManually() {
        return startedManually;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0104 A[Catch: Exception -> 0x00fb, TRY_LEAVE, TryCatch #0 {Exception -> 0x00fb, blocks: (B:26:0x00b9, B:28:0x00bf, B:32:0x00d3, B:34:0x00ec, B:37:0x00f4, B:40:0x00fd, B:41:0x0104), top: B:50:0x00b9, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void muteAlerts() {
        try {
            Settings settings = new Settings(this);
            if (settings.isMuteAlerts()) {
                if (settings.isRevertDnd()) {
                    Logger.logSevere("SleepService: DND mute already waiting for revert");
                    return;
                }
                NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
                Logger.logInfo("SleepService: mute, permission " + (notificationManager != null && notificationManager.isNotificationPolicyAccessGranted()));
                AudioManager audioManager = (AudioManager) getSystemService("audio");
                this.originalSystemVolume = audioManager.getStreamVolume(1);
                Logger.logInfo("SleepService:Original system volume:" + this.originalSystemVolume);
                int ringerMode = audioManager.getRingerMode();
                if (!settings.isPriorityMode() && !Experiments.getInstance().isNewDndExperiment()) {
                    Logger.logInfo("SleepService:Saving ringer mode, current mode " + ringerMode);
                    settings.setLastRingerMode(ringerMode);
                    if (ringerMode != 0) {
                        Logger.logInfo("SleepService:Muting ringer, current mode " + ringerMode);
                        audioManager.setRingerMode(0);
                        settings.setRevertDnd(true);
                    }
                }
                if (SharedApplicationContext.getSettings().isPriorityMode() || Experiments.getInstance().isNewDndExperiment()) {
                    if (notificationManager != null) {
                        try {
                            if (notificationManager.isNotificationPolicyAccessGranted()) {
                                int currentInterruptionFilter = notificationManager.getCurrentInterruptionFilter();
                                SharedApplicationContext.getSettings().setLastDndMode(currentInterruptionFilter);
                                int i = settings.isPriorityMode() ? 2 : 4;
                                Logger.logInfo("SleepService: Saving last DND mode: " + currentInterruptionFilter + " target mode " + i);
                                if (i != currentInterruptionFilter && (Build.VERSION.SDK_INT < 29 || currentInterruptionFilter == 1)) {
                                    settings.setRevertDnd(true);
                                    notificationManager.setInterruptionFilter(i);
                                }
                            } else {
                                Logger.logInfo("SleepService: Cannot set DND mode, permission not granted");
                            }
                        } catch (Exception e) {
                            Logger.logSevere("SleepService: Cannot set DND mode", e);
                        }
                    }
                }
                int ringerMode2 = audioManager.getRingerMode();
                Logger.logInfo("SleepService:Saved ringer mode " + SharedApplicationContext.getSettings().getLastRingerMode() + " current mode " + ringerMode2);
            }
        } catch (Exception unused) {
            Logger.logSevere("SleepService: cannot turn on silent or DND");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScreenOff() {
        Logger.logInfo("SleepService:Screen off");
        this.accelerometerRestartedAfterScreenOff = false;
        this.isScreenOff = true;
        if (this.smartWatch != null || isDisabled()) {
            return;
        }
        if (SuspensionSupportDetector.getSuspendSupportMode(this) == SuspensionSupportDetector.SuspendSupport.WORKS_WITH_START_AFTER_SCREEN_OFF) {
            initiateAccelerometerScreenOffRestart(1);
        }
        if (SuspensionSupportDetector.getSuspendSupportMode(this) == SuspensionSupportDetector.SuspendSupport.WORKS_WITH_DELAY_NORMAL) {
            initiateAccelerometerScreenOffRestart(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScreenOn() {
        Logger.logInfo("SleepService:Screen on");
        AccelSleepRecorder accelSleepRecorder = this.recorder;
        if (accelSleepRecorder != null) {
            accelSleepRecorder.resetZerosCount();
        }
        this.isScreenOff = false;
        if (isDisabled()) {
            return;
        }
        initiateAccelerometerScreenOnRestart();
    }

    private Notification prepareNotification() {
        Intent intent = new Intent("com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK");
        intent.putExtra("NOTIFICATION_STARTED", true);
        PendingIntent explicitBroadcast = PendingIntentBuilder.get(this, 34321266, intent, 134217728).getExplicitBroadcast();
        Intent intent2 = new Intent(this, (Class<?>) Sleep.class);
        intent2.setFlags(872415232);
        intent2.putExtra("NOTIFICATION_STARTED", true);
        PendingIntent activity = new PendingIntentBuilder(this, 34321266, intent2, 0).getActivity();
        Intent intent3 = new Intent(this, (Class<?>) getServiceClass(this));
        if (isPausedTracking()) {
            intent3.setAction("com.urbandroid.sleep.ACTION_RESUME_TRACKING");
        } else {
            intent3.setAction("com.urbandroid.sleep.ACTION_PAUSE_TRACKING");
        }
        PendingIntent foregroundService = PendingIntentBuilder.get(this, 34321266, intent3, 134217728).getForegroundService();
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(this, "sleepTrackingChannel").setContentIntent(activity).setColor(ColorUtil.i(this, R.color.tint_notification)).setOngoing(true).setContentTitle(getString(R.string.settings_category_track)).setContentText(getString(R.string.tracking_in_progress_battery_warning)).addAction(R.drawable.ic_action_stop, getString(R.string.player_stop), explicitBroadcast).setSmallIcon(R.drawable.ic_action_track_white);
        if (isPausedTracking()) {
            smallIcon.addAction(R.drawable.ic_action_play, getString(R.string.button_tracking_resume), foregroundService);
            Logger.logDebug("SleepServiceNotification: isPausedTracking");
        } else {
            smallIcon.addAction(R.drawable.ic_action_pause, getString(R.string.pause), foregroundService);
            Logger.logDebug("SleepServiceNotification: isPausedTracking NOT");
        }
        return smallIcon.build();
    }

    private SnoringDetectionAudioConsumer recoverFromTensorflowLiteInitializationError(Throwable th) {
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setPlainEvent("Tensorflow_initialization_failed");
        Logger.logSevere("SleepService: Tensorflow classifier initialization failed, falling back to the old snoring detection.", th);
        return createOldSnoringDetector();
    }

    private void registerScreenStateMonitor() {
        Logger.logInfo("SleepService:Registering screen state reciever.");
        this.screenStateBroadcastReceiver = new ScreenStateBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.screenStateBroadcastReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleAlarm() {
        if (this.isInOffScreenTrackingMode || this.lockManager.shouldBeInStandByMode()) {
            return;
        }
        ((AlarmManager) getApplicationContext().getSystemService("alarm")).setRepeating(0, System.currentTimeMillis(), 30000L, createPendingIntent().getExplicitBroadcast());
    }

    public static synchronized void setRunning(boolean z) {
        RUNNING = z;
    }

    public static synchronized void setRunningTimely(boolean z) {
        RUNNING_TIMELY = z;
    }

    private static synchronized void setStarted(boolean z) {
        started = z;
    }

    private void startJetLag() {
        TimeZone jetLagTargetTimezone = SharedApplicationContext.getSettings().getJetLagTargetTimezone();
        if (this.jetLagService == null && SharedApplicationContext.getSettings().isJetLagPrevention() && jetLagTargetTimezone != null) {
            JetLagService jetLagService = new JetLagService(getApplicationContext());
            this.jetLagService = jetLagService;
            jetLagService.start(jetLagTargetTimezone);
        }
    }

    private boolean startTracking() {
        Logger.logInfo("SleepService:Starting track");
        Logger.logInfo("DVP:Starting track");
        Settings settings = SharedApplicationContext.getSettings();
        SuspensionSupportDetector.interruptSuspensionDetection();
        this.alarm = Alarms.calculateNextAlert(this);
        this.lockManager.acquireLockOnResume();
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (record == null) {
            SleepRecord lastRecoverableRecord = CurrentSleepRecord.getLastRecoverableRecord();
            if (lastRecoverableRecord == null) {
                Logger.logInfo("SleepService:Starting with no record -> None recovered -> terminate");
                return false;
            }
            CurrentSleepRecord.getInstance().restoreRecord(lastRecoverableRecord);
            Logger.logInfo("SleepService:Starting with no record -> Recovered one.");
        }
        setStarted(true);
        startForegroundOnce(prepareNotification(), true);
        Logger.logInfo("SleepService:Sleep service is being started ");
        if (this.smartWatch == null && !withoutWatch) {
            SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(this);
            this.smartWatch = smartWatch;
            if (smartWatch != null) {
                settings.addAchievement(Achievement.Type.WEARABLE, 1);
                SmartWatch smartWatch2 = this.smartWatch;
                Logger.logInfo("SleepService: SmartWatch start tracking, watch: ".concat(smartWatch2 != null ? smartWatch2.getClass().getSimpleName() : "NULL"));
                this.smartWatch.startTracking(new SleepService$$ExternalSyntheticLambda0());
                Logger.logSevere("Starting with wearable/smartwatch " + settings.getSelectedWearable());
                forceOffScreenTrackingForSmartWatch();
                Alarm alarm = this.alarm;
                if (alarm != null) {
                    this.smartWatch.updateAlarm(alarm.time);
                }
                SleepRecord record2 = CurrentSleepRecord.getInstance().getRecord();
                if (this.smartWatch instanceof SleepPhaser) {
                    Tag.addTagToComment(record2, Tag.PHASER);
                } else {
                    Tag.addTagToComment(record2, Tag.WATCH);
                }
            }
        }
        settings.setLastRecordingStartedWithWatch(this.smartWatch != null);
        boolean zIsRecordingMasterSwitchEnabled = settings.isRecordingMasterSwitchEnabled();
        Logger.logInfo("SleepService: Recording master switch " + zIsRecordingMasterSwitchEnabled);
        if (!settings.isSnoringDetection() && !settings.isUltrasonicTracking() && !settings.getRecordingAntisnore() && Experiments.getInstance().useAndroidMDozeHackWakeLock(this)) {
            SleepPermissionCompat.INSTANCE.isPermissionGranted(this, "android.permission.RECORD_AUDIO");
        }
        boolean z = (zIsRecordingMasterSwitchEnabled && settings.isNoiseStatsCollectingEnabled()) || (Experiments.getInstance().useAndroidMDozeHackWakeLock(this) && SleepPermissionCompat.INSTANCE.isPermissionGranted(this, "android.permission.RECORD_AUDIO")) || settings.isUltrasonicTracking();
        zza$$ExternalSyntheticOutline0.m("SleepService: Recording collect stats  ", z);
        if (this.noiseLevelRecorder == null) {
            this.noiseLevelRecorder = new SleepRecordNoiseLevelRecorder(CurrentSleepRecord.getInstance().getRecord());
        }
        boolean z2 = zIsRecordingMasterSwitchEnabled && settings.isRecordingEnabled();
        boolean z3 = audioRecorder == null && (zIsRecordingMasterSwitchEnabled || settings.isUltrasonicTracking()) && (z2 || z);
        boolean zIsPermissionGranted = SleepPermissionCompat.INSTANCE.isPermissionGranted(this, "android.permission.RECORD_AUDIO");
        if (z2 && zIsPermissionGranted && this.autoTrackingSoundReceiver == null) {
            AutoTrackingSoundReceiver autoTrackingSoundReceiver = new AutoTrackingSoundReceiver(getApplicationContext(), this.expectedTrackingRage);
            this.autoTrackingSoundReceiver = autoTrackingSoundReceiver;
            autoTrackingSoundReceiver.init();
            if (settings.isAwakeDetectionTalk() || settings.getAutoStartMode() == 1) {
                Logger.logInfo("Awake: sound class ENABLED");
                this.awakeDetector.add(this.autoTrackingSoundReceiver);
            }
        }
        Logger.logInfo("SleepService: Recording enabled " + z2);
        Logger.logInfo("SleepService: NeedsNewAudioRecorder " + z3);
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("SleepService: Recording permitted "), zIsPermissionGranted);
        if (zIsPermissionGranted && z3) {
            if (settings.isUltrasonicTracking() && this.smartWatch == null) {
                settings.addAchievement(Achievement.Type.SONAR, 1);
                if (settings.isImplicitTagsEnabled()) {
                    Tag.addTagToComment(record, Tag.SONAR);
                }
                try {
                    RecordingAudioConsumer recordingAudioConsumer = new RecordingAudioConsumer(getApplicationContext(), record, z2);
                    Logger.logInfo("SleepService: using new Sonar enabled AudioRecorder");
                    audioRecorder = new AudioRecorder(getApplicationContext()).addNoiseLevelRecorder(this.noiseLevelRecorder);
                    SonarConsumer sonarConsumerCreateSonarConsumer = new SonarConsumerFactory(getApplicationContext()).createSonarConsumer(settings.getSonarMethod());
                    this.sonarConsumer = sonarConsumerCreateSonarConsumer;
                    audioRecorder.addConsumer((AudioRecorder.Consumer) sonarConsumerCreateSonarConsumer);
                    if (settings.isSnoringDetection()) {
                        audioRecorder.addConsumer(createSoundClassificationAudioConsumer());
                    }
                    if (settings.isRecordingRequiresStorage()) {
                        audioRecorder.addNoiseLevelRecorder(recordingAudioConsumer);
                        audioRecorder.addConsumer(recordingAudioConsumer);
                    }
                } catch (IOException e) {
                    Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
                    return false;
                }
            } else {
                try {
                    RecordingAudioConsumer recordingAudioConsumer2 = new RecordingAudioConsumer(getApplicationContext(), record, z2);
                    Logger.logInfo("SleepService: using new AudioRecorder");
                    audioRecorder = new AudioRecorder(getApplicationContext()).addNoiseLevelRecorder(this.noiseLevelRecorder);
                    if (settings.isSnoringDetection()) {
                        audioRecorder.addConsumer(createSoundClassificationAudioConsumer());
                    }
                    if (settings.isRecordingRequiresStorage()) {
                        audioRecorder.addNoiseLevelRecorder(recordingAudioConsumer2);
                        audioRecorder.addConsumer(recordingAudioConsumer2);
                    }
                } catch (IOException e2) {
                    Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e2);
                    return false;
                }
            }
            new Thread(audioRecorder).start();
        }
        if (audioRecorder == null) {
            Logger.logInfo("SleepService: recording DISABLED");
            this.noiseLevelRecorder = null;
        }
        if (this.recorder == null) {
            AccelSleepRecorder accelSleepRecorder = new AccelSleepRecorder(getApplicationContext(), CurrentSleepRecord.getInstance().getRecord(), settings.isUltrasonicTracking() ? FRAMERATE_SONAR : FRAMERATE, this.smartWatch, this.expectedTrackingRage);
            this.recorder = accelSleepRecorder;
            accelSleepRecorder.setSonarConsumer(this.sonarConsumer);
            if (!this.recorder.isStarted()) {
                this.recorder.start(1);
            }
        }
        this.h.removeCallbacks(this.sleepWatcher);
        this.h.post(this.sleepWatcher);
        startJetLag();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopJetLag() {
        JetLagService jetLagService = this.jetLagService;
        if (jetLagService != null) {
            jetLagService.stop();
            this.jetLagService = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void terminateTracking(Context context, String str) {
        Logger.logInfo("SleepService:Performing alarm dismiss " + this.recorder);
        unscheduleAlarm();
        AccelSleepRecorder accelSleepRecorder = this.recorder;
        if (accelSleepRecorder != null && accelSleepRecorder.isStarted()) {
            Logger.logInfo("SleepService:Stopping accelerometer recorder");
            this.recorder.stop();
            SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
            if (record != null) {
                Logger.logInfo("SleepService:Current record not null. Finished: " + record.isFinished());
                SharedApplicationContext.getInstance().getSleepRestarter().disableRestarting();
                if (!isStartedManually()) {
                    Tag tag = Tag.AUTO;
                    if (!record.hasTag(tag)) {
                        Logger.logInfo("SleepService: Adding #auto tag");
                        record.addTag(tag);
                    }
                }
                saveAndInvalidateRecord(false);
                if (str.equals("com.urbandroid.sleep.alarmclock.cancel_snooze_finished") || str.equals("com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK")) {
                    RatingActivity.showRatingIfEnabled(context, record, true);
                }
            }
            LullabyVolumeDown lullabyVolumeDown = this.lullabyVolumeDown;
            if (lullabyVolumeDown != null) {
                lullabyVolumeDown.finish();
            }
        }
        this.lockManager.releaseOnAlarmFinished();
        Logger.logInfo("SleepService:Stopping service");
        stopSelf();
        reset();
        setRunningTimely(false);
        this.awakeDetector.stop();
        awake = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void timeChanged(long j) {
        if (CurrentSleepRecord.getInstance().getRecord() == null) {
            return;
        }
        Logger.logDebug("SleepService:Estimated delta max: " + j);
        boolean z = Math.abs(j) > 120000;
        if (z) {
            if (this.recorder != null) {
                zza$$ExternalSyntheticOutline0.m("SleepService:Auto-filling of missing points disabled due to time change. Large delta: ", z);
                this.recorder.disableFilling();
            }
            SleepRecordNoiseLevelRecorder sleepRecordNoiseLevelRecorder = this.noiseLevelRecorder;
            if (sleepRecordNoiseLevelRecorder != null) {
                sleepRecordNoiseLevelRecorder.disableFilling();
            }
        }
    }

    private void unmuteAlerts() {
        try {
            Settings settings = new Settings(this);
            if (SharedApplicationContext.getSettings().isMuteAlerts()) {
                if (!settings.isRevertDnd()) {
                    Logger.logInfo("SleepService: unmute Doing nothing - not waiting for revert");
                    return;
                }
                Logger.logInfo("SleepService: unmute");
                settings.setRevertDnd(false);
                AudioManager audioManager = (AudioManager) getSystemService("audio");
                int ringerMode = audioManager.getRingerMode();
                int lastRingerMode = settings.getLastRingerMode();
                boolean z = SharedApplicationContext.getSettings().isPriorityMode() || Experiments.getInstance().isNewDndExperiment();
                Logger.logInfo("SleepService: Unmuting ringer, current mode " + ringerMode + " " + lastRingerMode);
                if (!z) {
                    if (lastRingerMode == ringerMode || lastRingerMode == 0) {
                        return;
                    }
                    Logger.logInfo("SleepService: Restoring ringer mode to " + lastRingerMode);
                    audioManager.setRingerMode(lastRingerMode);
                    Logger.logInfo("SleepService:After restore ringer, current mode " + audioManager.getRingerMode());
                    return;
                }
                NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
                if (notificationManager == null || !notificationManager.isNotificationPolicyAccessGranted()) {
                    return;
                }
                try {
                    int lastDndMode = SharedApplicationContext.getSettings().getLastDndMode();
                    int i = settings.isPriorityMode() ? 2 : 4;
                    Logger.logInfo("SleepService: last DND mode: " + lastDndMode + " target=" + i);
                    if (Build.VERSION.SDK_INT < 29) {
                        StringBuilder sb = new StringBuilder("SleepService: DND reverting to: ");
                        sb.append(lastDndMode >= 0 ? lastDndMode : 1);
                        Logger.logInfo(sb.toString());
                        notificationManager.setInterruptionFilter(lastDndMode >= 0 ? lastDndMode : 1);
                    } else if (lastDndMode < i) {
                        Logger.logInfo("SleepService: disable DND on Android Q, lastMode=" + lastDndMode);
                        notificationManager.setInterruptionFilter(lastDndMode);
                    } else {
                        Logger.logInfo("SleepService: revert DND, Android Q doing nothing " + lastDndMode);
                    }
                } catch (Exception e) {
                    Logger.logSevere("SleepService: Cannot revert DND ", e);
                }
            }
        } catch (Exception e2) {
            Logger.logSevere("SleepService: cannot turn off silent or DND", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unscheduleAlarm() {
        createPendingIntent().cancelAlarmBroadcast();
    }

    private void updateNotification() {
        NotificationsKt.notify(this, 34321266, prepareNotification());
    }

    public void disableOffScreenTrackingDueToLargeNumberOfZeros() {
        Logger.logInfo("SleepService:Too many zero values, disabling screen off tracking.");
        SuspensionSupportDetector.SuspendSupport suspendSupport = SuspensionSupportDetector.SuspendSupport.BROKEN;
        SuspensionSupportDetector.setSuspendSupportMode(this, suspendSupport);
        this.lockManager.updateSuspendedSupport(suspendSupport);
        boolean zIsUsingCpuOnlyLock = this.lockManager.isUsingCpuOnlyLock();
        this.isInOffScreenTrackingMode = zIsUsingCpuOnlyLock;
        if (zIsUsingCpuOnlyLock) {
            Logger.logInfo("SleepService:Too many zeros detected, but we still pretend we support off screen tracking. Likely set to stand-by always.");
            return;
        }
        AccelSleepRecorder accelSleepRecorder = this.recorder;
        if (accelSleepRecorder == null || !accelSleepRecorder.isStarted()) {
            StringBuilder sb = new StringBuilder("SleepService:Not scheduling restart.. Recorder: ");
            sb.append(this.recorder);
            sb.append(" Started: ");
            AccelSleepRecorder accelSleepRecorder2 = this.recorder;
            sb.append(accelSleepRecorder2 != null ? String.valueOf(accelSleepRecorder2.isStarted()) : "n/a");
            Logger.logInfo(sb.toString());
        } else {
            scheduleAlarm();
        }
        this.lockManager.releaseOnStop();
        if (this.isActivityRunning) {
            this.lockManager.acquireLockOnResume();
        }
    }

    @Override // com.urbandroid.sleep.ISleepService
    public void doExplicitRecording() {
        AudioRecorder audioRecorder2 = audioRecorder;
        if (audioRecorder2 != null) {
            audioRecorder2.explicitRecording();
        }
    }

    public void forceOffScreenTrackingForSmartWatch() {
        Logger.logInfo("SleepService:Forcing WORKS mode for SmartWatch track ");
        this.lockManager.setTemporaryLock(true);
        this.lockManager.releaseOnStop();
        this.lockManager.updateSuspendedSupport(SuspensionSupportDetector.SuspendSupport.WORKS);
        this.lockManager.acquireLockOnResume();
        this.lockManager.setTemporaryLock(false);
    }

    @Override // com.urbandroid.sleep.ISleepService
    public AwakeDetector getAwakeDetector() {
        return this.awakeDetector;
    }

    @Override // com.urbandroid.sleep.ISleepService
    public long getRemainingPauseMillis() {
        AccelSleepRecorder accelSleepRecorder = this.recorder;
        if (accelSleepRecorder == null) {
            return 0L;
        }
        return accelSleepRecorder.getRemainingPauseMillis();
    }

    @Override // com.urbandroid.common.ForegroundService
    public int getType() {
        int i;
        Settings settings = new Settings(this);
        Logger.logSevere("SleepService: FGS type health");
        if (settings.isUltrasonicTracking()) {
            Logger.logSevere("SleepService: FGS type +media");
            i = 258;
        } else {
            i = 256;
        }
        if (PermissionChecker.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
            return i;
        }
        int i2 = i | 128;
        Logger.logSevere("SleepService: FGS type +mic");
        return i2;
    }

    @Override // com.urbandroid.sleep.ISleepService
    public boolean isAwakePaused() {
        return awake;
    }

    @Override // com.urbandroid.sleep.ISleepService
    public boolean isDisabled() {
        return this.lockManager.isDisabled();
    }

    public boolean isInSmartPeriod() {
        Alarm alarm = this.alarm;
        boolean z = false;
        if (alarm == null) {
            return false;
        }
        if ((this.alarmStartedRingingId == alarm.id && this.alarmStartedRingingTs != -1 && System.currentTimeMillis() - this.alarmStartedRingingTs < 3600000) || !isActOnTargetSleepFullFilled()) {
            return false;
        }
        boolean zIsSnoozing = Alarms.isSnoozing(this);
        int iResolveSmartPeriod = Alarm.resolveSmartPeriod(this, this.alarm);
        if (!zIsSnoozing && iResolveSmartPeriod > 0 && System.currentTimeMillis() + ((long) (60000 * iResolveSmartPeriod)) > this.alarm.time) {
            z = true;
        }
        if (z) {
            try {
                Logger.logInfo("Smart: isInSmartPeriod(window = " + iResolveSmartPeriod + ", alarmTime = " + new Date(this.alarm.time) + ", snooze = " + zIsSnoozing + ", lightPhase = " + this.recorder.getSleepPhase().isLightSleep() + ") = true ");
            } catch (Exception unused) {
            }
        }
        if (this.isSmartPeriod != z) {
            this.isSmartPeriod = z;
            zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.SMART_PERIOD");
        }
        return z;
    }

    public boolean isPausedTracking() {
        AccelSleepRecorder accelSleepRecorder = this.recorder;
        return accelSleepRecorder != null && accelSleepRecorder.isPaused();
    }

    @Override // com.urbandroid.sleep.ISleepService
    public boolean isUsingSmartwatch() {
        return this.smartWatch != null;
    }

    @Override // com.urbandroid.common.LoggingService, android.app.Service
    public IBinder onBind(Intent intent) {
        return this.serviceBinder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbandroid.common.ForegroundService, android.app.Service
    public void onCreate() {
        GlobalInitializator.initializeIfRequired(this);
        super.onCreate();
        SONAR_INITIAL_VOLUME = -1;
        new Settings(getApplicationContext());
        this.h = new Handler();
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventSleepTrackingStarted(this);
        setRunning(true);
        setRunningTimely(true);
        DroidWidget.refresh(this);
        this.lastKnownTimestamp = System.currentTimeMillis();
        this.lockManager = SharedApplicationContext.getInstance().getLockManager();
        IntentFilter intentFilter = new IntentFilter("com.urbandroid.sleep.alarmclock.alarm_killed");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE_CLICKED_ACTION");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_DISMISS");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CLICKED_ACTION");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.TIME_CHANGED");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_CHECK_TRACKING_IS_AWAKE");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_TRACKING_PAUSED");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_TRACKING_RESUMED");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_TRACKING_STARTED");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_TRACKING_STOPPED");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_RESCHEDULED");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_ALERT");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_ALERT_START_INTERNAL");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_DONE");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_PAUSE_RECORDING");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_RESUME_RECORDING");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_LULLABY_START_PLAYBACK");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.cancel_snooze_finished");
        intentFilter.addAction("com.urbanroid.sleep.SLEEP_LOW_BATTERY");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_PAUSE_TRACKING");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_PAUSE_TRACKING_CAP");
        intentFilter.addAction("com.urbandroid.sleep.ACTION_RESUME_TRACKING");
        intentFilter.addAction("com.urbandroid.sleep.LUCID_CUE_ACTION");
        intentFilter.addAction(SnoringReceiver.ANTISNORING_ACTION);
        intentFilter.addAction("com.urbandroid.sleep.ACCEL_GESTURE_FLIP_ACTION");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.SLEEP_TRACKING_ENABLE");
        intentFilter.addAction("com.urbandroid.sleep.USER_AWAKE");
        intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        ContextCompat.registerReceiver(this, this.receiver, intentFilter, 2);
        this.phoneStateListener = new SleepServicePhoneStateListener(this, 0 == true ? 1 : 0);
        if (SleepPermissionCompat.INSTANCE.isPermissionGranted(this, "android.permission.READ_PHONE_STATE")) {
            ((TelephonyManager) getSystemService("phone")).listen(this.phoneStateListener, 32);
        }
        registerScreenStateMonitor();
        this.lockManager.initialize();
        this.isInOffScreenTrackingMode = this.lockManager.isUsingCpuOnlyLock();
        this.ignoreScreenOffSupport = SharedApplicationContext.getSettings().getDimMode() == 5;
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("SleepService:onCreate() - in offscreen: "), this.isInOffScreenTrackingMode);
        scheduleAlarm();
        muteAlerts();
        this.isScreenOff = true ^ this.lockManager.isScreenOn();
        ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.alarmclock.SLEEP_TRACKING_STARTED"));
        Alarms.setNextAlert(this);
        BluetoothHrService.INSTANCE.start(getApplicationContext());
        Logger.logInfo("SleepService: DOZE ignoring battery opts: " + PowerManagerCompat.isIgnoringBatteryOptimizations(this));
        Logger.logInfo("SleepService: DOZE using foreground hack: " + Experiments.getInstance().useAndroidMDozeHackForegroundService());
        if (Experiments.getInstance().isAliveLoggingExperiment()) {
            Runnable runnable = new Runnable() { // from class: com.urbandroid.sleep.SleepService.2
                private final MemoryStats memStats;
                private int counter1 = -1;
                private int counter2 = -1;
                private long ts = System.currentTimeMillis();

                {
                    this.memStats = new MemoryStats(SleepService.this.getApplicationContext());
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.counter1++;
                    this.counter2++;
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.ts;
                    if (jCurrentTimeMillis > 60000) {
                        if (this.counter1 != 60 || jCurrentTimeMillis / 1000 != 60) {
                            Logger.logInfo("DOZE logger main " + this.counter1 + "t / " + (jCurrentTimeMillis / 60000) + "s");
                        }
                        this.counter1 = 0;
                        this.ts = System.currentTimeMillis();
                    }
                    if (this.counter2 % 300 == 0) {
                        Logger.logInfo("Memory statistics: " + this.memStats.getStats());
                    }
                    SleepService.this.h.postDelayed(this, 1000L);
                }
            };
            this.mainThreadLoggingRunnable = runnable;
            this.h.post(runnable);
            Thread thread = new Thread() { // from class: com.urbandroid.sleep.SleepService.3
                private int counter = -1;
                private long ts = System.currentTimeMillis();

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!Thread.interrupted()) {
                        this.counter++;
                        long jCurrentTimeMillis = System.currentTimeMillis() - this.ts;
                        if (jCurrentTimeMillis > 60000) {
                            if (this.counter != 60 || jCurrentTimeMillis / 1000 != 60) {
                                Logger.logInfo("DOZE logger other " + this.counter + "t / " + (jCurrentTimeMillis / 1000) + "s");
                            }
                            this.counter = 0;
                            this.ts = System.currentTimeMillis();
                        }
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
            };
            this.otherThreadLoggingRunnable = thread;
            thread.start();
        }
    }

    @Override // com.urbandroid.common.ForegroundService, com.urbandroid.common.LoggingService, android.app.Service
    public void onDestroy() {
        Logger.logInfo("SleepService:Destroying SleepService");
        super.onDestroy();
        SONAR_INITIAL_VOLUME = -1;
        if (SharedApplicationContext.getSettings().isAirplaneModeAutomatic() && Experiments.getInstance().isEnableWiFiInMorningExperiment()) {
            Logger.logInfo("WifiEnabler: reverting airplane or wifi");
            AirplaneModeUtil.revertAirplaneMode(getApplicationContext());
        }
        Runnable runnable = this.mainThreadLoggingRunnable;
        if (runnable != null) {
            this.h.removeCallbacks(runnable);
            this.mainThreadLoggingRunnable = null;
        }
        Thread thread = this.otherThreadLoggingRunnable;
        if (thread != null) {
            thread.interrupt();
            this.otherThreadLoggingRunnable = null;
        }
        AutoTrackingSoundReceiver autoTrackingSoundReceiver = this.autoTrackingSoundReceiver;
        if (autoTrackingSoundReceiver != null) {
            autoTrackingSoundReceiver.destroy();
            this.autoTrackingSoundReceiver = null;
        }
        setRunning(false);
        setRunningTimely(false);
        LAST_FINISHED_TIME = System.currentTimeMillis();
        DroidWidget.refresh(this);
        SharedApplicationContext.getInstance().getSleepRestarter().disableRestarting();
        SleepRecordTemporaryPersister.deleteLastTemporaryRecord();
        AudioRecorder audioRecorder2 = audioRecorder;
        if (audioRecorder2 != null) {
            audioRecorder2.pause(AudioRecorder.PauseReason.TERMINATING);
            audioRecorder.stop();
            audioRecorder = null;
        }
        unscheduleAlarm();
        if (CurrentSleepRecord.getInstance().getRecord() != null) {
            ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "!! Current record still not-null !!", 1);
        }
        setStarted(false);
        stopForeground(true);
        unregisterReceiver(this.receiver);
        if (SleepPermissionCompat.INSTANCE.isPermissionGranted(this, "android.permission.READ_PHONE_STATE")) {
            ((TelephonyManager) getSystemService("phone")).listen(this.phoneStateListener, 0);
        }
        deregisterScreenStateMonitor();
        this.h.removeCallbacks(this.sleepWatcher);
        stopJetLag();
        AccelSleepRecorder accelSleepRecorder = this.recorder;
        if (accelSleepRecorder != null) {
            accelSleepRecorder.stop();
        }
        SmartWatch smartWatch = this.smartWatch;
        if (smartWatch != null) {
            smartWatch.stopTracking();
        }
        unmuteAlerts();
        if (SuspensionSupportDetector.getSuspendSupportMode(this) == SuspensionSupportDetector.SuspendSupport.BROKEN || SuspensionSupportDetector.getSuspendSupportMode(this) == SuspensionSupportDetector.SuspendSupport.UNKNOWN) {
            SuspensionSupportDetector.initializeSuspensionDetectionIfRequired(getApplicationContext());
        }
        LullabyVolumeDown lullabyVolumeDown = this.lullabyVolumeDown;
        if (lullabyVolumeDown != null) {
            lullabyVolumeDown.finish();
        }
        this.lockManager.releaseOnStop();
        this.lockManager.terminate();
        try {
            if (SharedApplicationContext.getSettings().isTimeToBackup()) {
                new BackupManager(this).dataChanged();
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        Alarms.setNextAlert(this);
        zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.alarmclock.SLEEP_TRACKING_STOPPED");
        BluetoothHrService.INSTANCE.stop(getApplicationContext());
        SmartWatchProvider.releaseSmartwatch();
        EnsembleExtraDataCollector ensembleExtraDataCollector = this.dataCollector;
        if (ensembleExtraDataCollector != null) {
            ensembleExtraDataCollector.stop();
            this.dataCollector = null;
        }
        SmartLight smartLight = this.smartLight;
        if (smartLight != null) {
            smartLight.close();
            this.smartLight = null;
        }
        withoutWatch = false;
        startedManually = false;
    }

    @Override // com.urbandroid.common.LoggingService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        long longExtra;
        boolean z;
        super.onStartCommand(intent, i, i2);
        boolean z2 = started;
        Settings settings = new Settings(getApplicationContext());
        if (intent != null && !startedManually) {
            startedManually = intent.getBooleanExtra("MANUALY_STARTED", false);
            zza$$ExternalSyntheticOutline0.m(new StringBuilder("SleepService: manually started "), startedManually);
        }
        if (intent != null && !withoutWatch) {
            withoutWatch = intent.getBooleanExtra("track_without_smartwatch", false);
            zza$$ExternalSyntheticOutline0.m(new StringBuilder("SleepService: without smartwatch "), withoutWatch);
        }
        if (intent != null && intent.getAction() != null && intent.getAction().equals("com.urbandroid.sleep.ACTION_PAUSE_TRACKING")) {
            pauseTracking(300000L);
        }
        if (intent != null && intent.getAction() != null && intent.getAction().equals("com.urbandroid.sleep.ACTION_RESUME_TRACKING")) {
            resumeTracking();
        }
        if (this.expectedTrackingRage == null && intent != null) {
            this.expectedTrackingRage = ExpectedTrackingRange.from(intent);
        }
        if (this.dataCollector == null) {
            EnsembleExtraDataCollector ensembleExtraDataCollector = new EnsembleExtraDataCollector(this);
            this.dataCollector = ensembleExtraDataCollector;
            ensembleExtraDataCollector.start();
        }
        if (!this.awakeDetector.hasDetector(AwakeWhenUsingPhoneDetector.class) && (settings.isAwakeDetectionWhenUsingPhone() || settings.getAutoStartMode() == 1)) {
            Logger.logInfo("Awake: when using phone ENABLED");
            this.awakeDetector.add(new AwakeWhenUsingPhoneDetector(getApplicationContext(), this.expectedTrackingRage));
        }
        if (!this.awakeDetector.hasDetector(AwakeWhenLightsOn.class) && (settings.isAwakeDetectionLight() || settings.getAutoStartMode() == 1)) {
            Logger.logInfo("Awake: when light ENABLED");
            this.awakeDetector.add(new AwakeWhenLightsOn(getApplicationContext(), this.expectedTrackingRage));
        }
        if (!this.awakeDetector.hasDetector(AwakeWhenHighActivity.class) && (settings.isAwakeDetectionHighActivity() || settings.getAutoStartMode() == 1)) {
            Logger.logInfo("Awake: when high activity ENABLED");
            this.awakeDetector.add(new AwakeWhenHighActivity(getApplicationContext(), this.expectedTrackingRage));
        }
        if (!this.awakeDetector.hasDetector(AwakeWhenHighActivityFrequency.class) && Experiments.getInstance().isActigraphyImprovementsExperiment2() && (settings.isAwakeDetectionHighActivity() || settings.getAutoStartMode() == 1)) {
            Logger.logInfo("Awake: when high activity frequency ENABLED");
            this.awakeDetector.add(new AwakeWhenHighActivityFrequency(getApplicationContext(), this.expectedTrackingRage));
        }
        if (this.lockManager.isScreenOn()) {
            Logger.logInfo("Awake: screen on at start");
            this.awakeDetector.onScreenOn();
        }
        awake = true;
        if (!z2 && !startTracking()) {
            stopForegroundSelf();
            setRunningTimely(false);
            this.firstStart = false;
            return 2;
        }
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        this.actOnTargetSleepTime = new Settings(this).isNotBeforeIdeal();
        this.idealSleepDurationMin = new Settings(this).getPerAlarmIdealSleepMinutes(this.alarm);
        if (!z2 && record != null) {
            ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.ACTION_TRACKING_STARTED"));
            this.startedInWorksMode = SuspensionSupportDetector.getSuspendSupportMode(this) == SuspensionSupportDetector.SuspendSupport.WORKS;
            boolean zIsRecordRestored = CurrentSleepRecord.getInstance().isRecordRestored();
            if (intent != null && intent.hasExtra("initial_pause") && !zIsRecordRestored) {
                longExtra = intent.getLongExtra("initial_pause", 5000L);
            } else if (!startedManually || settings.getTrackingDelay() <= 0) {
                longExtra = 0;
            } else {
                long trackingDelay = SharedApplicationContext.getSettings().getTrackingDelay();
                long jCurrentTimeMillis = System.currentTimeMillis() - record.getFrom().getTime();
                if (jCurrentTimeMillis < 0) {
                    jCurrentTimeMillis = 0;
                }
                longExtra = trackingDelay - jCurrentTimeMillis;
                Logger.logInfo("SleepService:Initial delay when started from watch: " + longExtra);
            }
            if (this.smartLight == null) {
                this.smartLight = SmartLightProvider.getSmartLight(this);
                z = true;
            } else {
                z = false;
            }
            zza$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m("SleepService:Starting with initial delay: ", " ", longExtra), startedManually);
            if (longExtra > 0) {
                Logger.logInfo("SleepService:Starting with initial delay: " + longExtra);
                pauseTracking(longExtra);
            }
            if (intent != null && intent.hasExtra("start_in_battery_saving")) {
                Logger.logInfo("SleepService: setDisabled");
                setDisabled(true);
            }
            if (z) {
                StringBuilder sb = new StringBuilder("SleepService: turn off light ");
                sb.append(!isPausedTracking());
                sb.append(" ");
                sb.append(this.smartLight != null);
                sb.append(" ");
                sb.append(startedManually);
                sb.append(" ");
                sb.append(!AlarmKlaxon.isRunning());
                Logger.logInfo(sb.toString());
                if ((!isPausedTracking() || settings.getSmartlightPeelightTime() == -1) && this.smartLight != null && startedManually && !AlarmKlaxon.isRunning()) {
                    Logger.logInfo("SleepService: turn off light");
                    this.smartLight.off();
                    this.smartLightOn = false;
                }
            }
            if (this.sonarConsumer == null || SharedApplicationContext.getSettings().getSonarStream() != 3) {
                this.lullabyVolumeDown = new LullabyVolumeDown(this, 3, SharedApplicationContext.getSettings().getLullabyVolumeDownAfter());
            }
            SharedApplicationContext.getInstance().getSleepRestarter().enableRestarting(record);
            if (record.getHistory().size() == 0 && !TrialFilter.getInstance().isTrackingEnabledForRecord(record)) {
                record.setHideSleepAnalysis(true);
            }
        }
        this.firstStart = false;
        return 2;
    }

    public void pauseNoiseRecording(AudioRecorder.PauseReason pauseReason) {
        if (audioRecorder != null) {
            Logger.logInfo("SleepService:Pause noise recording " + pauseReason);
            audioRecorder.pauseAsync(pauseReason);
        }
    }

    @Override // com.urbandroid.sleep.ISleepService
    public void pauseTracking(long j) {
        boolean zIsPausedTracking = isPausedTracking();
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (record != null && !this.pauseRecordingWithoutResumeCalled) {
            record.addEventLabel(EventLabel.TRACKING_PAUSED, System.currentTimeMillis());
        }
        AccelSleepRecorder accelSleepRecorder = this.recorder;
        if (accelSleepRecorder != null) {
            accelSleepRecorder.addPause(j);
        }
        pauseNoiseRecording(AudioRecorder.PauseReason.USER_PAUSED);
        this.pauseRecordingWithoutResumeCalled = true;
        if (this.smartLight != null && startedManually && !AlarmKlaxon.isRunning()) {
            int smartlightPeelightTime = SharedApplicationContext.getSettings().getSmartlightPeelightTime();
            if (!AlarmKlaxon.isRunning() && smartlightPeelightTime > -1) {
                if (smartlightPeelightTime >= 1000) {
                    smartlightPeelightTime = -1;
                }
                this.smartLight.nightLight(smartlightPeelightTime);
                if (smartlightPeelightTime > -1) {
                    this.h.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.SleepService.4
                        @Override // java.lang.Runnable
                        public void run() {
                            SleepService.this.smartLightOn = false;
                        }
                    }, smartlightPeelightTime);
                }
            }
            this.smartLightOn = true;
        }
        stopJetLag();
        if (zIsPausedTracking) {
            return;
        }
        zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.ACTION_TRACKING_USER_PAUSED");
        updateNotification();
    }

    @Override // com.urbandroid.sleep.ISleepService
    public void postponeAwake() {
    }

    public void restartSleepActivity() {
        if (this.isInOffScreenTrackingMode) {
            return;
        }
        if (this.lockManager.shouldBeInStandByMode() || this.lockManager.isDisabled()) {
            unscheduleAlarm();
            return;
        }
        if (!this.isScreenOff || this.isActivityRunning || this.isAlarmRinging || this.lockManager.isAlwaysStandBySet()) {
            return;
        }
        StringBuilder sb = new StringBuilder("SleepService:Restarting Sleep Activity SCREEN OFF ");
        sb.append(this.isScreenOff);
        sb.append(" ACTIVITY BOUND ");
        sb.append(this.isActivityRunning);
        sb.append(" ALARM RING ");
        sb.append(this.isAlarmRinging);
        sb.append(" (not) Should stand by ");
        sb.append(!this.lockManager.shouldBeInStandByMode());
        sb.append(" ALWAYS STAND-BY ");
        zza$$ExternalSyntheticOutline0.m(sb, !this.lockManager.isAlwaysStandBySet());
        this.lockManager.turnScreenOn();
        Intent intent = new Intent(SharedApplicationContext.getInstance().getContext(), (Class<?>) Sleep.class);
        intent.setFlags(805306368);
        intent.putExtra("NOTIFICATION_STARTED", false);
        startActivity(intent);
    }

    public void resumeNoiseRecording(AudioRecorder.PauseReason pauseReason) {
        if (audioRecorder != null) {
            Logger.logInfo("SleepService:Resuming noise recording " + pauseReason);
            audioRecorder.resumeAsync(pauseReason);
            zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.ACTION_RECORDING_RESUMED");
        }
    }

    @Override // com.urbandroid.sleep.ISleepService
    public void resumeTracking() {
        this.awakeDetector.forceNotAwake();
        awake = false;
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (record != null && this.pauseRecordingWithoutResumeCalled) {
            record.addEventLabel(EventLabel.TRACKING_RESUMED, System.currentTimeMillis());
        }
        AccelSleepRecorder accelSleepRecorder = this.recorder;
        if (accelSleepRecorder != null) {
            accelSleepRecorder.finishPause();
        }
        resumeNoiseRecording(AudioRecorder.PauseReason.USER_PAUSED);
        this.pauseRecordingWithoutResumeCalled = false;
        if (this.smartLight != null && startedManually && !AlarmKlaxon.isRunning()) {
            this.smartLight.off();
            this.smartLightOn = false;
        }
        startJetLag();
        zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.ACTION_TRACKING_USER_RESUMED");
        updateNotification();
    }

    @Override // com.urbandroid.sleep.ISleepService
    public void saveAndInvalidateRecord(boolean z) {
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        Logger.logInfo("Awake: at SleepService termination ");
        EventsUtil.getIntervals(record.getEvents().getCopiedEvents(), new EventPair(EventLabel.AWAKE_START, EventLabel.AWAKE_END));
        CurrentSleepRecord.getInstance().invalidate();
        if (!record.isFinished()) {
            SleepRecordNoiseLevelRecorder sleepRecordNoiseLevelRecorder = this.noiseLevelRecorder;
            if (sleepRecordNoiseLevelRecorder != null) {
                sleepRecordNoiseLevelRecorder.backfillPointsIfRequired();
            }
            AccelSleepRecorder accelSleepRecorder = this.recorder;
            if (accelSleepRecorder != null) {
                try {
                    accelSleepRecorder.flush();
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
                this.recorder.backfillPointsIfRequired(0, true);
            }
            record.computeLenAdjust();
            Logger.logDebug("SleepService:Finishing current record");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.pauseRecordingWithoutResumeCalled) {
                Logger.logInfo("SleepService:Adding resume label " + jCurrentTimeMillis);
                record.addEventLabel(EventLabel.TRACKING_RESUMED, jCurrentTimeMillis);
            }
            if (z) {
                record.addEventLabel(EventLabel.TRACKING_STOPPED_BY_USER, jCurrentTimeMillis + 1);
            }
            record.finish(new Date());
            int i = Experiments.getInstance().isMoreDebuggingExperiment() ? 500 : 50;
            record.logLatestValuesReverse(i, true);
            record.logLatestValuesReverse(i, false);
            new Settings(getApplicationContext()).incRecordsCount();
            SharedApplicationContext.getInstance().saveNewSleepRecord(record, null);
            Logger.logInfo("RateLate: terminate " + SharedApplicationContext.getSettings().isRateSleepLater());
            if (SharedApplicationContext.getSettings().isRateSleepLater()) {
                Alarms.scheduleRateSleepLater(getApplicationContext(), record, SharedApplicationContext.getSettings().getRateSleepLater());
            }
            zza$$ExternalSyntheticOutline0.m(getApplicationContext(), "com.urbandroid.sleep.REQUEST_SYNC");
        }
        setRunningTimely(false);
    }

    @Override // com.urbandroid.sleep.ISleepService
    public void setDimStatus(boolean z) {
    }

    @Override // com.urbandroid.sleep.ISleepService
    public void setDisabled(boolean z) {
        zza$$ExternalSyntheticOutline0.m("SleepService:Disabling service: ", z);
        if (z == this.lockManager.isDisabled()) {
            Logger.logInfo("SleepService:Ignored, state already set.");
            return;
        }
        if (!z && this.lockManager.isCannotLockBecauseBatteryStatus()) {
            Logger.logInfo("SleepService:Cannot turn off disabled mode in a low battery mode");
            return;
        }
        if (z) {
            AudioRecorder audioRecorder2 = audioRecorder;
            if (audioRecorder2 != null) {
                audioRecorder2.pause(AudioRecorder.PauseReason.BATTERY_SAVING_MODE);
            }
            SharedApplicationContext.getInstance().getSleepRestarter().disableRestarting();
        } else {
            AudioRecorder audioRecorder3 = audioRecorder;
            if (audioRecorder3 != null) {
                audioRecorder3.resume(AudioRecorder.PauseReason.BATTERY_SAVING_MODE);
            }
            if (CurrentSleepRecord.getInstance().getRecord() != null) {
                SharedApplicationContext.getInstance().getSleepRestarter().enableRestarting(CurrentSleepRecord.getInstance().getRecord());
            }
        }
        this.lockManager.setDisabled(z);
        AccelSleepRecorder accelSleepRecorder = this.recorder;
        if (accelSleepRecorder != null) {
            accelSleepRecorder.setDisabled(z);
        }
        if (z) {
            return;
        }
        this.lockManager.acquireLockOnResume();
    }

    @Override // com.urbandroid.sleep.ISleepService
    public void toggleSmartLight() {
        SmartLight smartLight = this.smartLight;
        if (smartLight != null) {
            if (this.smartLightOn) {
                smartLight.off();
                this.smartLightOn = false;
            } else {
                smartLight.nightLight(-1);
                this.smartLightOn = true;
            }
        }
    }

    public class SleepServicePhoneStateListener extends PhoneStateListener {
        private Boolean lastStateWasPaused;

        private SleepServicePhoneStateListener() {
        }

        public boolean isPausedState(int i) {
            return i != 0;
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            zza$$ExternalSyntheticOutline0.m(i, "SleepService:Call state change to: ");
            boolean zIsPausedState = isPausedState(i);
            Boolean bool = this.lastStateWasPaused;
            if (bool == null || zIsPausedState != bool.booleanValue()) {
                if (zIsPausedState) {
                    SleepService.this.pauseNoiseRecording(AudioRecorder.PauseReason.PHONE_CALL);
                } else if (this.lastStateWasPaused != null) {
                    SleepService.this.resumeNoiseRecording(AudioRecorder.PauseReason.PHONE_CALL);
                }
                this.lastStateWasPaused = Boolean.valueOf(zIsPausedState);
            }
        }

        public /* synthetic */ SleepServicePhoneStateListener(SleepService sleepService, int i) {
            this();
        }
    }
}
