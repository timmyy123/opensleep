package com.urbandroid.sleep.alarmclock;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.appfunctions.AppFunctionException;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.impl.Processor$$ExternalSyntheticLambda2;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.ForegroundService;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.wifi.WifiContext;
import com.urbandroid.common.wifi.WifiEnabler;
import com.urbandroid.sleep.CaptchaAntiCheatingAccessibilityService;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepLockManager;
import com.urbandroid.sleep.SleepUtils;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.volume.GentleAlarmRunnable;
import com.urbandroid.sleep.alarmclock.volume.IVolumeControlRunnable;
import com.urbandroid.sleep.alarmclock.volume.VolumeControlRunnable;
import com.urbandroid.sleep.captcha.AbstractCaptchaActivity;
import com.urbandroid.sleep.captcha.BaseCaptchaManager;
import com.urbandroid.sleep.captcha.CaptchaCallbackReceiver;
import com.urbandroid.sleep.captcha.IntentIntegrator;
import com.urbandroid.sleep.captcha.NFCCaptcha;
import com.urbandroid.sleep.captcha.NFCScanner;
import com.urbandroid.sleep.captcha.NFCUtil;
import com.urbandroid.sleep.captcha.cheating.LockView;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.achievement.Achievement;
import com.urbandroid.sleep.gui.KeyguardUtil;
import com.urbandroid.sleep.media.MultipleMediaUriUtil;
import com.urbandroid.sleep.media.googlemusic.GoogleMusicPlayer;
import com.urbandroid.sleep.media.googlemusic.GoogleMusicPlayerKt;
import com.urbandroid.sleep.media.lullaby.BinauralGenerator;
import com.urbandroid.sleep.media.mode.RingerModeUtil;
import com.urbandroid.sleep.media.player.PlaybackListener;
import com.urbandroid.sleep.media.spotify.ISpotifyPlayer;
import com.urbandroid.sleep.sensor.AccelManager;
import com.urbandroid.sleep.service.IFlashlightService;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.WakefulForegroundBroadcastReceiver;
import com.urbandroid.sleep.smartlight.SmartLight;
import com.urbandroid.sleep.smartlight.SmartLightProvider;
import com.urbandroid.sleep.smartwatch.AbstractConnectivityCallback;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.SleepPermissionCompat;
import com.urbandroid.util.TtsService;
import com.urbandroid.util.VolumeUtil;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class AlarmKlaxon extends ForegroundService {
    public static volatile Alarm currentAlarm;
    private static long resumeTime;
    public static SmartLight smartLight;
    private AccelManager accelManager;
    private int alarmAudioStream;
    private Class alarmClass;
    private BinauralGenerator binauralPlayer;
    private List<CaptchaInfo> captchaInfos;
    private Runnable checkCaptchaEscapeRunnable;
    private Runnable checkForegroundRunnable;
    private Boolean doGradualVolumeUp;
    private boolean flipToSnooze;
    private GoogleMusicPlayer googleMusicPlayer;
    private Handler handler;
    private boolean hideSystemDialogs;
    private boolean isDefaultRingtone;
    private Boolean isFixedSystemVolume;
    private boolean isSnoozedAlarm;
    private LockView lockView;
    private int lockViewCount;
    private Handler mHandler;
    private int mInitialCallState;
    private PhoneStateListener mPhoneStateListener;
    private long mStartTime;
    private TelephonyManager mTelephonyManager;
    private MediaPlayer mediaPlayer;
    private Integer nonGradualAlarmVolume;
    private Integer originalVolume;
    private long position;
    private boolean reacted;
    private long reactedTs;
    private BroadcastReceiver receiver;
    private boolean ringerModeChanged;
    private SleepLockManager screenLockManager;
    private ScreenStateBroadcastReceiver screenStateBroadcastReceiver;
    private int sirenaTimeoutSeconds;
    private Runnable smartLightRunnable;
    private SmartWatch smartWatch;
    private ISpotifyPlayer spotifyPlayer;
    private boolean statePaused;
    private boolean statePlaying;
    private long sunriseEnd;
    private long sunriseStart;
    private boolean sunriseStarted;
    private BroadcastReceiver timelyForegroundCheckReceiver;
    private int timeoutSeconds;
    private Runnable ttsRunnable;
    private boolean useFlashlight;
    private boolean useScreenLight;
    private Vibrator vibrator;
    private IVolumeControlRunnable volumeControlRunnable;
    private final AtomicReference<WifiContext> wifiContext;
    public static final long[] sVibratePattern = {100, 100, 5000, 100, 5000, 100, 5000, 200, 4000, 300, 3000, 400, 2000, 500, 1000, 500, 500};
    public static final long[] sVibratePatternResume = {500, 500};
    private static boolean isRunning = false;
    public static long LAST_FINISHED_TIME = 0;
    public static boolean restartRequested = false;

    public class ScreenStateBroadcastReceiver extends LoggingReceiver {
        public ScreenStateBroadcastReceiver() {
        }

        @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                Logger.logDebug("AlarmKlaxon: screen off");
                AlarmKlaxon.this.screenStateChanged();
            } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                Logger.logDebug("AlarmKlaxon: screen on");
                AlarmKlaxon.this.screenStateChanged();
            }
        }
    }

    public AlarmKlaxon() {
        super("alarmNormalChannel", 34377266, R.drawable.ic_alarm_white);
        this.isSnoozedAlarm = false;
        this.timeoutSeconds = 1200;
        this.sirenaTimeoutSeconds = 60;
        this.statePlaying = false;
        this.statePaused = false;
        this.isDefaultRingtone = false;
        this.useFlashlight = false;
        this.alarmAudioStream = 4;
        this.position = 0L;
        this.reacted = false;
        this.reactedTs = -1L;
        this.ringerModeChanged = false;
        this.sunriseStart = -1L;
        this.sunriseEnd = -1L;
        this.useScreenLight = false;
        this.wifiContext = new AtomicReference<>();
        this.mHandler = new Handler() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1000:
                        Logger.logInfo("*********** Alarm killer triggered ***********");
                        AlarmKlaxon.this.sendKillBroadcast((Alarm) message.obj);
                        AlarmKlaxon.this.stopForegroundSelf();
                        break;
                    case 1001:
                        AlarmKlaxon.this.resumeAlarm();
                        break;
                    case 1002:
                        Logger.logInfo("*********** Alarm sirena triggered ***********");
                        AlarmKlaxon.this.playSirena(false);
                        AlarmKlaxon.this.enablePostSirenaKiller((Alarm) message.obj);
                        break;
                    case AppFunctionException.ERROR_FUNCTION_NOT_FOUND /* 1003 */:
                        AlarmKlaxon.this.switchFlashlight();
                        break;
                }
            }
        };
        this.mPhoneStateListener = new PhoneStateListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.2
            @Override // android.telephony.PhoneStateListener
            public void onCallStateChanged(int i, String str) {
                Logger.logInfo("AlarmKlaxon: Call state change: " + i + " " + str);
                if (i != 0 && i != AlarmKlaxon.this.mInitialCallState) {
                    if (i != 2 && i != 1) {
                        Logger.logWarning("Unexpected call state...");
                        AlarmKlaxon.this.resumeAlarm();
                        return;
                    }
                    AlarmKlaxon.this.suspendAlarm(0, false);
                }
                if (i == 0) {
                    AlarmKlaxon.this.resumeAlarm();
                }
            }
        };
        this.flipToSnooze = false;
        this.isFixedSystemVolume = Boolean.FALSE;
        this.checkForegroundRunnable = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.16
            @Override // java.lang.Runnable
            public void run() {
                AlarmKlaxon.this.doCheckForeground();
            }
        };
        this.lockViewCount = 0;
        this.hideSystemDialogs = true;
        this.checkCaptchaEscapeRunnable = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.17
            @Override // java.lang.Runnable
            public void run() {
                if (AlarmKlaxon.this.hideSystemDialogs && Build.VERSION.SDK_INT < 31) {
                    try {
                        AlarmKlaxon.this.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                    } catch (Exception unused) {
                    }
                }
                if (AlarmKlaxon.this.lockView != null) {
                    if (AlarmAlertFullScreen.SHOWN || AbstractCaptchaActivity.SHOWN || BaseActivity.SHOWN || AlarmAlertFullScreen.CAPTCHA_IN_PROGRESS) {
                        AlarmKlaxon.this.lockView.cloak();
                        AlarmKlaxon.this.lockViewCount = 0;
                    } else {
                        if (Build.VERSION.SDK_INT <= 31 || !KeyguardUtil.isKeyguard(AlarmKlaxon.this)) {
                            AlarmKlaxon.this.lockViewCount++;
                        }
                        if (AlarmKlaxon.this.lockViewCount == 1) {
                            AlarmKlaxon.this.lockView.uncloak();
                        }
                        if (AlarmKlaxon.this.lockViewCount == 4) {
                            try {
                                Intent intent = new Intent("android.intent.action.MAIN");
                                intent.addCategory("android.intent.category.HOME");
                                intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
                                AlarmKlaxon.this.startActivity(intent);
                            } catch (Exception e) {
                                Logger.logSevere(e);
                            }
                        }
                        if (AlarmKlaxon.this.lockViewCount > 5) {
                            Intent intent2 = new Intent(AlarmKlaxon.this.getApplicationContext(), (Class<?>) AlarmAlertFullScreen.class);
                            intent2.setFlags(ClientDefaults.MAX_MSG_SIZE);
                            AlarmKlaxon.this.startActivity(intent2);
                            AlarmKlaxon.this.lockViewCount = 0;
                        }
                    }
                }
                AlarmKlaxon.this.handler.postDelayed(this, 500L);
            }
        };
        this.ttsRunnable = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.18
            @Override // java.lang.Runnable
            public void run() {
                AlarmKlaxon alarmKlaxon = AlarmKlaxon.this;
                alarmKlaxon.doTts(alarmKlaxon.volumeControlRunnable != null ? AlarmKlaxon.this.volumeControlRunnable.getVolume() : 0.7f);
            }
        };
        this.sunriseStarted = false;
        this.smartLightRunnable = new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.19
            @Override // java.lang.Runnable
            public void run() {
                int iMin = Math.min(Math.round((Math.max(0L, System.currentTimeMillis() - AlarmKlaxon.this.sunriseStart) * 100.0f) / (AlarmKlaxon.this.sunriseEnd - AlarmKlaxon.this.sunriseStart)), 100);
                if (AlarmKlaxon.smartLight != null) {
                    StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(iMin, "SmartLight: Sunrise progress ", " light ");
                    sbM65m.append(AlarmKlaxon.smartLight.getClass().getSimpleName());
                    Logger.logInfo(sbM65m.toString());
                    if (!AlarmKlaxon.this.sunriseStarted) {
                        AlarmKlaxon.smartLight.sunriseStart();
                        AlarmKlaxon.this.sunriseStarted = true;
                    }
                    AlarmKlaxon.smartLight.sunrise(iMin, 100);
                }
                if (AlarmKlaxon.this.useScreenLight) {
                    Intent intent = new Intent("com.urbandroid.sleep.SCREENLIGHT_ACTION");
                    intent.putExtra("com.urbandroid.sleep.SCREENLIGHT_PROGRESS_EXTRA", iMin);
                    zza$$ExternalSyntheticOutline0.m(iMin, "Screenlight sending ");
                    ContextExtKt.sendExplicitBroadcast(AlarmKlaxon.this.getApplicationContext(), intent);
                }
                if (iMin >= 100) {
                    SharedApplicationContext.getSettings().addAchievement(Achievement.Type.SMARTLIGHT, 1);
                } else {
                    AlarmKlaxon.this.handler.removeCallbacks(this);
                    AlarmKlaxon.this.handler.postDelayed(this, 5000L);
                }
            }
        };
        this.timelyForegroundCheckReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.20
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                AlarmKlaxon.this.handler.removeCallbacks(AlarmKlaxon.this.checkCaptchaEscapeRunnable);
                AlarmKlaxon.this.checkCaptchaEscapeRunnable.run();
            }
        };
    }

    private void deregisterScreenStateMonitor() {
        ScreenStateBroadcastReceiver screenStateBroadcastReceiver = this.screenStateBroadcastReceiver;
        if (screenStateBroadcastReceiver != null) {
            unregisterReceiver(screenStateBroadcastReceiver);
        }
        this.screenStateBroadcastReceiver = null;
    }

    private void disablePendingMessages() {
        this.mHandler.removeMessages(1002);
        this.mHandler.removeMessages(1000);
        this.mHandler.removeMessages(5);
    }

    private void disableResumer() {
        this.mHandler.removeMessages(1001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCheckForeground() {
        if (Environment.isLollipopOrGreater()) {
            return;
        }
        try {
            try {
                ComponentName topComponent = getTopComponent();
                if (topComponent != null && isAllowed(topComponent.getClassName())) {
                    this.reacted = false;
                    this.reactedTs = -1L;
                } else if (!this.reacted || (this.reactedTs != -1 && System.currentTimeMillis() - this.reactedTs > 5000)) {
                    restartRequested = true;
                    Class cls = AlarmAlertFullScreen.currentClass;
                    if (cls == null) {
                        cls = this.alarmClass;
                    }
                    Intent intent = new Intent(getApplicationContext(), (Class<?>) cls);
                    intent.putExtra("CREATION_SOURCE", "AlarmKlaxon-Restarting");
                    intent.putExtra("intent.extra.alarm_raw", currentAlarm.serializeToArray());
                    intent.putExtra("klaxon_restart", true);
                    intent.setFlags(872415232);
                    startActivity(intent);
                    Logger.logDebug("AlarmKlaxon: Restarting " + topComponent + " Class to use: " + cls);
                    this.reacted = true;
                    this.reactedTs = System.currentTimeMillis();
                }
                scheduleCheckForeground();
            } catch (Throwable th) {
                scheduleCheckForeground();
                throw th;
            }
        } catch (Exception unused) {
            scheduleCheckForeground();
        }
    }

    private boolean doNoEscape(Context context, Alarm alarm) {
        Settings settings = new Settings(context);
        if (!settings.isCaptchaNoEscape()) {
            return false;
        }
        StringBuilder sb = new StringBuilder("CAPTCHA Cheating NFC: ");
        sb.append(settings.getCaptchaId(alarm) == 6);
        sb.append(" keyguard: ");
        sb.append(KeyguardUtil.isKeyguard(context));
        sb.append(" doing noEscape: ");
        sb.append((settings.getCaptchaId(alarm) == 6 && KeyguardUtil.isKeyguard(context)) ? false : true);
        Logger.logInfo(sb.toString());
        return (settings.getCaptchaId(alarm) == 6 && KeyguardUtil.isKeyguard(context)) ? false : true;
    }

    private void enableKillerOrSirena(Alarm alarm) {
        boolean zIsSirenaSilent = isSirenaSilent();
        Handler handler = this.mHandler;
        if (zIsSirenaSilent) {
            handler.sendMessageDelayed(handler.obtainMessage(1000, alarm), this.timeoutSeconds * 1000);
        } else {
            handler.sendMessageDelayed(handler.obtainMessage(1002, alarm), this.timeoutSeconds * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enablePostSirenaKiller(Alarm alarm) {
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(1000, alarm), this.sirenaTimeoutSeconds * 1000);
    }

    private void enableResumer(long j) {
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(1001, null), j);
        resumeTime = System.currentTimeMillis() + j;
        Logger.logInfo("AlarmKlaxon: Resume time " + resumeTime);
    }

    public static Spannable getActionText(Context context, int i, int i2) {
        SpannableString spannableString = new SpannableString(context.getText(i));
        if (Build.VERSION.SDK_INT >= 25) {
            spannableString.setSpan(new ForegroundColorSpan(context.getColor(i2)), 0, spannableString.length(), 0);
        }
        return spannableString;
    }

    private float getBatteryLevel() {
        Intent intentRegisterReceiver = ContextCompat.registerReceiver(this, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 2);
        int intExtra = -1;
        int intExtra2 = 1;
        if (intentRegisterReceiver != null) {
            intExtra = intentRegisterReceiver.getIntExtra("level", -1);
            intExtra2 = intentRegisterReceiver.getIntExtra("scale", 1);
        }
        return (intExtra / intExtra2) * 100.0f;
    }

    private ComponentName getTopComponent() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) getSystemService("activity")).getRunningTasks(1);
        if (runningTasks == null || runningTasks.size() < 1) {
            return null;
        }
        return runningTasks.get(0).topActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void incPosition() {
        this.position++;
        SharedApplicationContext.getSettings().setPlaylistPosition(this.position);
        Logger.logInfo("AlarmKlaxon: position " + this.position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeVolumeControlThread(boolean z, boolean z2, boolean z3, int i, boolean z4, boolean z5, boolean z6) {
        VolumeControlRunnable volumeControlRunnable;
        int gradualVolumeIncrease = currentAlarm.getGradualVolumeIncrease(this);
        int iConvertIncreaseDurationToIncreaseSpeed = VolumeControlRunnable.convertIncreaseDurationToIncreaseSpeed(this, gradualVolumeIncrease, this.alarmAudioStream);
        StringBuilder sb = new StringBuilder("AlarmKlaxon: initialize VolumeControlRunnable gentle ");
        sb.append(z);
        sb.append(" increase ");
        sb.append(iConvertIncreaseDurationToIncreaseSpeed);
        sb.append(" fixed ");
        zza$$ExternalSyntheticOutline0.m(sb, z5);
        if (z) {
            Logger.logInfo("AlarmKlaxon: fixed volume " + z5 + " increase " + gradualVolumeIncrease);
            MediaPlayer mediaPlayer = this.mediaPlayer;
            Vibrator vibrator = z2 ? this.vibrator : null;
            int i2 = z5 ? AppFunctionException.ERROR_RESOURCE_NOT_FOUND : gradualVolumeIncrease;
            if (!z5 && gradualVolumeIncrease > 30000) {
                i = this.alarmAudioStream;
            }
            this.volumeControlRunnable = new GentleAlarmRunnable(this, mediaPlayer, vibrator, i2, i, z3, i, this.originalVolume.intValue(), Alarm.resolveSoundDelay(this, currentAlarm, this.isSnoozedAlarm), z4, z6);
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setVolume(0.0f, 0.0f);
            }
            BinauralGenerator binauralGenerator = this.binauralPlayer;
            if (binauralGenerator != null) {
                ((GentleAlarmRunnable) this.volumeControlRunnable).addVolumeListener(binauralGenerator);
            }
        } else {
            long jResolveSoundDelay = Alarm.resolveSoundDelay(this, currentAlarm, this.isSnoozedAlarm);
            Logger.logInfo("AlarmKlaxon: falling back to VolumeControlRunnable, sound delay " + jResolveSoundDelay);
            int iIntValue = (jResolveSoundDelay > 0 || !z5) ? 0 : this.nonGradualAlarmVolume.intValue();
            int iIntValue2 = (z5 || gradualVolumeIncrease <= 30000) ? this.nonGradualAlarmVolume.intValue() : -1;
            if (z2) {
                Logger.logInfo("AlarmKlaxon: VolumeControlRunnable create vibrate");
                volumeControlRunnable = new VolumeControlRunnable(this, this.mediaPlayer, iConvertIncreaseDurationToIncreaseSpeed, true, this.alarmAudioStream, z3, this.vibrator, this.originalVolume.intValue(), iIntValue, iIntValue2, i, jResolveSoundDelay);
            } else {
                Logger.logInfo("AlarmKlaxon: VolumeControlRunnable create");
                volumeControlRunnable = new VolumeControlRunnable(this, this.mediaPlayer, iConvertIncreaseDurationToIncreaseSpeed, true, this.alarmAudioStream, z3, this.originalVolume.intValue(), iIntValue, iIntValue2, jResolveSoundDelay);
            }
            this.volumeControlRunnable = volumeControlRunnable;
        }
        Logger.logInfo("AlarmKlaxon: VolumeControlRunnable thread start");
        new Thread(this.volumeControlRunnable, "Alarm increasing volume").start();
    }

    private boolean isAllowed(String str) {
        CaptchaInfo captchaInfo;
        if (!str.startsWith(getPackageName())) {
            Iterator<String> it = IntentIntegrator.TARGET_ALL_KNOWN.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next())) {
                    return true;
                }
            }
            if (str.startsWith("com.android.phone") || str.equals("com.android.incallui.InCallActivity") || str.equals("com.android.vending") || str.equals("com.android.internal.app.ResolverActivity")) {
                return true;
            }
            return (currentAlarm == null || (captchaInfo = SharedApplicationContext.getSettings().getCaptchaInfo(currentAlarm)) == null || !NFCCaptcha.class.getName().equals(captchaInfo.getActivityName()) || NFCUtil.isNfcEnabled(this) || !str.startsWith("com.android.settings")) ? false : true;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(NFCScanner.class.getName());
        linkedHashSet.add(AlarmAlertFullScreen.class.getName());
        linkedHashSet.add(AlarmAlert.class.getName());
        if (this.captchaInfos == null) {
            this.captchaInfos = new BaseCaptchaManager(getApplicationContext()).getFinder().lookup(null);
        }
        Iterator<CaptchaInfo> it2 = this.captchaInfos.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(it2.next().getActivityName());
        }
        try {
            Class.forName(str);
            return linkedHashSet.contains(str);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean isLocalAlert(Uri uri) {
        return uri.toString().startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR) || uri.toString().startsWith("android") || uri.toString().startsWith(ShareInternalUtility.STAGING_PARAM) || uri.toString().startsWith("content") || "silent".equals(uri.toString());
    }

    public static synchronized boolean isRunning() {
        return isRunning;
    }

    private boolean isSirenaSilent() {
        try {
            return SharedApplicationContext.getSettings().getSirenRingtone().equals("silent");
        } catch (Exception e) {
            Logger.logWarning("AlarmKlaxon: Failed to parse sirena alert.", e);
            return true;
        }
    }

    private boolean isSpotifyAlarm(Alarm alarm) {
        Uri uri;
        if (alarm == null || alarm.silent || (uri = alarm.alert) == null) {
            return false;
        }
        if (MultipleMediaUriUtil.hasSpotify(uri)) {
            return true;
        }
        return ISpotifyPlayer.INSTANCE.isSpotifyUri(uri.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isStreaming(Uri uri) {
        return (uri == null || uri.getScheme() == null || !uri.getScheme().toLowerCase().startsWith("http")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAlarm$1(MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2) {
        Logger.logInfo("AlarmKlaxon: Async prepare ready.");
        mediaPlayer.start();
        IVolumeControlRunnable iVolumeControlRunnable = this.volumeControlRunnable;
        if (iVolumeControlRunnable == null || !(iVolumeControlRunnable instanceof GentleAlarmRunnable)) {
            return;
        }
        mediaPlayer.setVolume(0.0f, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startKlaxon$0(Alarm alarm, boolean z) {
        boolean z2 = currentAlarm != null;
        Logger.logDebug("AlarmKlaxon: Going to play alarm: " + z2);
        if (z2) {
            playInitialAlarm(alarm, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$stop$2(IVolumeControlRunnable iVolumeControlRunnable) {
        Logger.logInfo("AlarmKlaxon: delayed VolumeControlRunnable stop");
        iVolumeControlRunnable.reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$stop$3(IVolumeControlRunnable iVolumeControlRunnable) {
        Logger.logInfo("AlarmKlaxon: delayed VolumeControlRunnable stop");
        iVolumeControlRunnable.reset();
    }

    private void play(final Uri uri, final boolean z, final boolean z2, final boolean z3, boolean z4) {
        Uri uriDecodePosition;
        stop();
        Logger.logInfo("AlarmKlaxon: play, vibrate " + z + " silent " + z2 + " force max " + z3 + " uri " + uri);
        this.useFlashlight = SharedApplicationContext.getSettings().isUseFlashlight();
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("Flashlight: "), this.useFlashlight);
        Uri uri2 = null;
        if (this.useFlashlight) {
            Logger.logInfo("Flashlight: in use");
            SharedApplicationContext.getInstance().getFlashlightService().turnOn();
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(AppFunctionException.ERROR_FUNCTION_NOT_FOUND, null), 5000L);
        }
        final int smartwatchAlarmDelay = SharedApplicationContext.getSettings().getSmartwatchAlarmDelay(currentAlarm, this.isSnoozedAlarm, this, true);
        if (this.smartWatch != null) {
            zza$$ExternalSyntheticOutline0.m(smartwatchAlarmDelay, "AlarmKlaxon: Starting synchronous smartwatch alarm with delay: ");
            this.smartWatch.startAlarm(smartwatchAlarmDelay);
        } else {
            SmartWatchProvider.asyncSmartwatchConnect(this, new AbstractConnectivityCallback() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.10
                @Override // com.urbandroid.sleep.smartwatch.AbstractConnectivityCallback
                public void doStatus(SmartWatch smartWatch, boolean z5) {
                    if (!z5 || smartWatch == null) {
                        return;
                    }
                    zza$$ExternalSyntheticOutline0.m(new StringBuilder("AlarmKlaxon: Starting smartwatch alarm with delay: "), smartwatchAlarmDelay);
                    smartWatch.startAlarm(smartwatchAlarmDelay);
                }
            }, 30000L, false);
        }
        this.doGradualVolumeUp = Boolean.valueOf(currentAlarm.isGradualVolumeIncrease(this));
        this.isFixedSystemVolume = Boolean.valueOf(currentAlarm.isFixedSystemVolume(this));
        if (!z2) {
            if (shouldPlayInLoop()) {
                uriDecodePosition = MultipleMediaUriUtil.randomUriIfMultiple(uri);
            } else {
                uriDecodePosition = MultipleMediaUriUtil.decodePosition(uri, this.position);
                incPosition();
            }
            Logger.logDebug("AlarmKlaxon: In order playlist " + uriDecodePosition + " position " + this.position);
            if (uriDecodePosition == null) {
                uriDecodePosition = SleepUtils.getActualDefaultRingtoneUri(getApplicationContext());
                Logger.logDebug("AlarmKlaxon: Using default alarm: " + uriDecodePosition);
            }
            final Uri uri3 = uriDecodePosition;
            if (TrialFilter.getInstance().isSpotify() && uri3 != null && ISpotifyPlayer.INSTANCE.isSpotifyUri(uri3.toString())) {
                if (this.doGradualVolumeUp.booleanValue()) {
                    Logger.logDebug("AlarmKlaxon: VolumeControlRunnable setVolumeStream() 0 stream: " + this.alarmAudioStream);
                    VolumeUtil.setStreamVolume(getApplicationContext(), this.alarmAudioStream, 0);
                }
                Logger.logInfo("AlarmKlaxon: playing spotify");
                playSpotify(uri3, z, z2, z3, false);
            } else if (uri3 != null && GoogleMusicPlayerKt.isGoogleMusicPlaylistUri(uri3.toString())) {
                playGoogleMusic(uri3, z, z2, z3, z4);
            } else if (uri3 != null) {
                Logger.logInfo("AlarmKlaxon: Alert not null going to create mPlayer " + uri3);
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.mediaPlayer = mediaPlayer;
                uri2 = uri3;
                mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.11
                    private int failureCounter = 0;

                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                        Logger.logSevere("AlarmKlaxon: Error occurred while playing alarm. What: " + i + " Extra: " + i2);
                        while (true) {
                            int i3 = this.failureCounter;
                            if (i3 >= 3) {
                                Logger.logSevere("AlarmKlaxon: Max failure reached -> Stopping");
                                if (AlarmKlaxon.this.volumeControlRunnable != null) {
                                    AlarmKlaxon.this.volumeControlRunnable.reset();
                                }
                                if (AlarmKlaxon.this.volumeControlRunnable instanceof GentleAlarmRunnable) {
                                    AlarmKlaxon.this.volumeControlRunnable = null;
                                    AlarmKlaxon.this.initializeVolumeControlThread(false, z, z3, 0, z2, !r2.doGradualVolumeUp.booleanValue(), AlarmKlaxon.this.isStreaming(uri3));
                                    ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "!! Failed to play alarm - falling back to old volume increase !!", 20);
                                    return false;
                                }
                                mediaPlayer2.stop();
                                mediaPlayer2.release();
                                AlarmKlaxon.this.mediaPlayer = null;
                                ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "!! Failed to play alarm with old volume increase!!", 20);
                                return true;
                            }
                            this.failureCounter = i3 + 1;
                            try {
                                mediaPlayer2.reset();
                                if (this.failureCounter == 2) {
                                    Logger.logSevere("AlarmKlaxon: Error RETRY: " + this.failureCounter + " data source: fallback");
                                    AlarmKlaxon alarmKlaxon = AlarmKlaxon.this;
                                    alarmKlaxon.setDataSourceFromResource(alarmKlaxon.getResources(), AlarmKlaxon.this.mediaPlayer, R.raw.fallbackring);
                                    AlarmKlaxon alarmKlaxon2 = AlarmKlaxon.this;
                                    alarmKlaxon2.startAlarm(alarmKlaxon2.mediaPlayer, true);
                                } else {
                                    Logger.logSevere("AlarmKlaxon: Error RETRY: " + this.failureCounter + " data source: " + uri3);
                                    AlarmKlaxon.this.setDataSource(uri3);
                                }
                                return false;
                            } catch (Exception e) {
                                Logger.logWarning("AlarmKlaxon: MediaPlayer reset has failed.", e);
                            }
                        }
                    }
                });
                if (!shouldPlayInLoop()) {
                    Logger.logInfo("AlarmKlaxon: Starting NON-looping alarm.");
                    this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.12
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer2) {
                            Logger.logInfo("AlarmKlaxon: Alarm complete, going to next song. Playing: " + AlarmKlaxon.this.statePlaying);
                            if (AlarmKlaxon.this.statePlaying) {
                                AlarmKlaxon.this.mediaPlayer.reset();
                                final Uri uriDecodePosition2 = MultipleMediaUriUtil.decodePosition(uri, AlarmKlaxon.this.position);
                                Logger.logDebug("AlarmKlaxon: In order playlist " + uriDecodePosition2);
                                AlarmKlaxon.this.incPosition();
                                Logger.logDebug("AlarmKlaxon: next song " + uriDecodePosition2);
                                if (uriDecodePosition2 == null || !ISpotifyPlayer.INSTANCE.isSpotifyUri(uriDecodePosition2.toString())) {
                                    if (uriDecodePosition2 == null) {
                                        uriDecodePosition2 = SleepUtils.getActualDefaultRingtoneUri(AlarmKlaxon.this.getApplicationContext());
                                        Logger.logDebug("AlarmKlaxon: Using default alarm: " + uriDecodePosition2.toString());
                                    }
                                    AlarmKlaxon.this.setDataSource(uriDecodePosition2);
                                    return;
                                }
                                Logger.logDebug("AlarmKlaxon: stopping mMediaPlayer ...");
                                if (AlarmKlaxon.this.mediaPlayer.isPlaying()) {
                                    AlarmKlaxon.this.mediaPlayer.stop();
                                }
                                AlarmKlaxon.this.mediaPlayer.reset();
                                AlarmKlaxon.this.mediaPlayer.release();
                                AlarmKlaxon.this.mediaPlayer = null;
                                AlarmKlaxon.this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.12.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Logger.logDebug("AlarmKlaxon: starting spotify ...");
                                        AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                                        AlarmKlaxon.this.playSpotify(uriDecodePosition2, z, z2, z3, true);
                                    }
                                }, 2000L);
                            }
                        }
                    });
                }
                boolean z5 = this.spotifyPlayer == null && this.googleMusicPlayer == null && !MultipleMediaUriUtil.hasSpotify(uri);
                if (this.doGradualVolumeUp.booleanValue() && (!this.isFixedSystemVolume.booleanValue() || !z5)) {
                    Logger.logDebug("AlarmKlaxon: setVolumeStream() 0");
                    VolumeUtil.setStreamVolume(getApplicationContext(), this.alarmAudioStream, 0);
                }
                setDataSource(uri2);
            } else {
                uri2 = uri3;
                Logger.logWarning("AlarmKlaxon: alarm alert is NULL");
            }
            uri2 = uri3;
        }
        int iResolveVibrationStart = resolveVibrationStart(z);
        Logger.logInfo("AlarmKlaxon: initialize VolumeControlRunnable");
        initializeVolumeControlThread(this.spotifyPlayer == null && this.googleMusicPlayer == null && !MultipleMediaUriUtil.hasSpotify(uri), z, z3, iResolveVibrationStart, z2, !this.doGradualVolumeUp.booleanValue(), isStreaming(uri2));
        this.statePlaying = true;
        TelephonyManager telephonyManager = this.mTelephonyManager;
        if (telephonyManager == null || telephonyManager.getCallState() == 0) {
            return;
        }
        suspendAlarm(1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playFallback(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.reset();
            Logger.logInfo("AlarmKlaxon: play fallback");
            setDataSourceFromResource(getResources(), mediaPlayer, R.raw.fallbackring);
            startAlarm(mediaPlayer, true);
        } catch (Exception e) {
            Logger.logSevere("AlarmKlaxon: Failed to play fallback ringtone", e);
        }
    }

    private void playGoogleMusic(Uri uri, boolean z, boolean z2, boolean z3, boolean z4) {
        GoogleMusicPlayer googleMusicPlayer = new GoogleMusicPlayer(getApplicationContext(), true, true, z4, new SharedPlaybackListener(this, "GoogleMusicPlayer", z, z2, z3, false, 0));
        this.googleMusicPlayer = googleMusicPlayer;
        googleMusicPlayer.play(uri.toString());
    }

    private void playInitialAlarm(Alarm alarm, boolean z) {
        Uri uri;
        Logger.logDebug("AlarmKlaxon: Resolved alert " + alarm.alert + " Alarm should vibrate: " + alarm.shouldVibrate(this));
        startBinuaralBeats();
        if (alarm.silent && Environment.isLollipopOrGreater() && !SharedApplicationContext.getSettings().isSmartlightEnabled() && !SharedApplicationContext.getSettings().isSmartwatchEnabled()) {
            Logger.logInfo("AlarmKlaxon: check for power save mode, alarm is silent");
            try {
                if (((PowerManager) getSystemService("power")).isPowerSaveMode()) {
                    Logger.logInfo("AlarmKlaxon: power save mode enabled");
                    alarm.silent = false;
                }
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        if (this.isDefaultRingtone && SharedApplicationContext.getSettings().isAlarmPlaylistOrdered()) {
            this.position = SharedApplicationContext.getSettings().getPlaylistPosition();
            Logger.logInfo("AlarmKlaxon: resolved position " + this.position);
        }
        if (!alarm.silent && (uri = alarm.alert) != null && "silent".equals(uri.toString())) {
            Logger.logInfo("AlarmKlaxon: fixing alarm silent not set ");
            alarm.silent = true;
        }
        boolean zIsAlarmPlaylistShuffle = SharedApplicationContext.getSettings().isAlarmPlaylistShuffle();
        Uri uriShuffle = alarm.alert;
        if (zIsAlarmPlaylistShuffle) {
            uriShuffle = MultipleMediaUriUtil.shuffle(uriShuffle);
        }
        play(uriShuffle, shouldVibrate(), alarm.silent, false, z);
        this.mStartTime = System.currentTimeMillis();
        enableKillerOrSirena(alarm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playSirena(boolean z) {
        Uri uri;
        String sirenRingtone;
        Logger.logInfo("AlarmKlaxon.playSirena()");
        try {
            sirenRingtone = SharedApplicationContext.getSettings().getSirenRingtone();
        } catch (Exception e) {
            Logger.logWarning("AlarmKlaxon: Failed to parse sirena alert.", e);
            uri = null;
        }
        if (sirenRingtone.equals("silent")) {
            Logger.logInfo("AlarmKlaxon: Sirena set to silent.");
            return;
        }
        uri = Uri.parse(sirenRingtone);
        Uri uri2 = uri;
        if (uri2 == null) {
            Logger.logInfo("AlarmKlaxon: Sirena ignored due to null alert.");
            return;
        }
        Logger.logInfo("AlarmKlaxon: Forcing STREAM_ALARM");
        this.alarmAudioStream = 4;
        play(uri2, true, false, true, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playSpotify(Uri uri, boolean z, boolean z2, boolean z3, boolean z4) {
        Logger.logInfo("Play Spotify");
        ISpotifyPlayer spotifyPlayer = ISpotifyPlayer.INSTANCE.getSpotifyPlayer(this, new SharedPlaybackListener(this, "SpotifyPlayer", z, z2, z3, z4, 0), this.alarmAudioStream);
        this.spotifyPlayer = spotifyPlayer;
        spotifyPlayer.setForcePlay().play(uri.toString());
    }

    public static Notification prepareHeadsUpNotification(Context context, Alarm alarm, Class cls, boolean z) {
        Intent intent = new Intent(context, (Class<?>) cls);
        intent.setFlags(131072);
        intent.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        intent.putExtra("CREATION_SOURCE", "AlarmKlaxon-HeadsUp-Body");
        PendingIntent activity = PendingIntentBuilder.get(context, alarm.id, intent, 134217728).getActivity();
        Intent intent2 = new Intent(intent);
        intent2.putExtra("headsup_notif_clicked", true);
        PendingIntent activity2 = PendingIntentBuilder.get(context, alarm.id + 10000000, intent2, 134217728).getActivity();
        Intent intent3 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_NOTIF_SNOOZE");
        intent3.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        PendingIntent explicitBroadcast = PendingIntentBuilder.get(context, 878202180, intent3, 134217728).getExplicitBroadcast();
        Intent intent4 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_NOTIF_DISMISS");
        Intent intent5 = new Intent(context, (Class<?>) DummyBroadcastActivity.class);
        intent5.setFlags(ClientDefaults.MAX_MSG_SIZE);
        intent5.putExtra("extra_broadcast_action", intent4.getAction());
        intent4.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        intent5.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        PendingIntent explicitBroadcast2 = PendingIntentBuilder.get(context, 328487, intent4, 134217728).getExplicitBroadcast();
        if (Build.VERSION.SDK_INT >= 31) {
            explicitBroadcast2 = PendingIntentBuilder.get(context, 328487, intent5, 134217728).getActivity();
        }
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(context, "alarmChannel").setContentIntent(activity2).setContentTitle(alarm.getLabelOrDefault(context)).setWhen(alarm.time).setColor(ColorUtil.i(context, R.color.tint_notification)).setDefaults(4).setLights(Color.GREEN, 200, 200).setVisibility(1).setCategory("alarm").setPriority(2).setOngoing(true).setLocalOnly(true).setSmallIcon(R.drawable.ic_alarm_white).setContentText(context.getString(R.string.touch_to_stop));
        if (!z) {
            if (Alarm.isSnoozeEnabled(alarm)) {
                if (Experiments.getInstance().isColoredActionsExperiment()) {
                    contentText.addAction(new NotificationCompat.Action.Builder(R.drawable.ic_action_cancel, getActionText(context, R.string.alarm_alert_snooze_text, R.color.positive_dark), explicitBroadcast).build());
                } else {
                    contentText.addAction(R.drawable.ic_action_snooze, context.getString(R.string.alarm_alert_snooze_text), explicitBroadcast);
                }
            }
            if (Experiments.getInstance().isColoredActionsExperiment()) {
                contentText.addAction(new NotificationCompat.Action.Builder(R.drawable.ic_action_cancel, getActionText(context, R.string.alarm_alert_dismiss_text, R.color.negative_dark), explicitBroadcast2).build());
            } else {
                contentText.addAction(R.drawable.ic_action_cancel, context.getString(R.string.alarm_alert_dismiss_text), explicitBroadcast2);
            }
            contentText.setFullScreenIntent(activity, true);
        }
        return contentText.build();
    }

    public static Notification prepareStandardNotification(Context context, Alarm alarm, Class cls) {
        Intent intent = new Intent(context, (Class<?>) cls);
        intent.setFlags(131072);
        intent.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        intent.putExtra("CREATION_SOURCE", "AlarmKlaxon-Standard-Body");
        PendingIntent activity = PendingIntentBuilder.get(context, alarm.id, intent, 134217728).getActivity();
        Intent intent2 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE");
        intent2.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        PendingIntent explicitBroadcast = PendingIntentBuilder.get(context, 878202180, intent2, 134217728).getExplicitBroadcast();
        Intent intent3 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CAPTCHA");
        intent3.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        PendingIntent explicitBroadcast2 = PendingIntentBuilder.get(context, 328487, intent3, 134217728).getExplicitBroadcast();
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(context, "alarmNormalChannel").setContentIntent(activity).setContentTitle(alarm.getLabelOrDefault(context)).setWhen(alarm.time).setColor(ColorUtil.i(context, R.color.tint_notification)).setDefaults(4).setCategory("alarm").setVisibility(1).setLights(Color.GREEN, 200, 200).setSmallIcon(R.drawable.ic_alarm_white).setLocalOnly(true).setContentText(context.getString(R.string.touch_to_stop));
        if (Alarm.isSnoozeEnabled(alarm)) {
            if (Experiments.getInstance().isColoredActionsExperiment()) {
                contentText.addAction(new NotificationCompat.Action.Builder(R.drawable.ic_action_cancel, getActionText(context, R.string.alarm_alert_snooze_text, R.color.positive_dark), explicitBroadcast2).build());
            } else {
                contentText.addAction(R.drawable.ic_action_snooze, context.getString(R.string.alarm_alert_snooze_text), explicitBroadcast);
            }
        }
        if (Experiments.getInstance().isColoredActionsExperiment()) {
            contentText.addAction(new NotificationCompat.Action.Builder(R.drawable.ic_action_cancel, getActionText(context, R.string.alarm_alert_dismiss_text, R.color.negative_dark), explicitBroadcast2).build());
        } else {
            contentText.addAction(R.drawable.ic_action_cancel, context.getString(R.string.alarm_alert_dismiss_text), explicitBroadcast2);
        }
        return contentText.build();
    }

    private void registerScreenStateMonitor() {
        this.screenStateBroadcastReceiver = new ScreenStateBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        ContextCompat.registerReceiver(this, this.screenStateBroadcastReceiver, intentFilter, 2);
    }

    private void renewVibration() {
        if (this.volumeControlRunnable == null || this.statePaused || !shouldVibrate()) {
            return;
        }
        Logger.logDebug("AlarmKlaxon: Renewing vibrations on screen switch. Current alarm vibrating: " + shouldVibrate() + " GVU: " + this.doGradualVolumeUp);
        this.volumeControlRunnable.renewVibration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetResumer(long j) {
        Logger.logInfo("AlarmKlaxon: Resetting resumer " + resumeTime);
        this.mHandler.removeMessages(1001);
        enableResumer(j * 1000);
    }

    private int resolveVibrationStart(boolean z) {
        int iResolveVibrationSetting = Alarm.resolveVibrationSetting(this, currentAlarm, this.isSnoozedAlarm);
        if (iResolveVibrationSetting != -1 || !z) {
            return iResolveVibrationSetting;
        }
        Logger.logInfo("AlarmKlaxon: Forcing vibration start to be at 0 time (from: " + iResolveVibrationSetting + ")");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeAlarm() {
        boolean z = currentAlarm != null ? currentAlarm.silent : false;
        StringBuilder sb = new StringBuilder("Resuming alarm state ");
        sb.append(this.statePlaying);
        sb.append(" player ");
        zza$$ExternalSyntheticOutline0.m(sb, (this.mediaPlayer == null && this.spotifyPlayer == null && this.googleMusicPlayer == null && !z) ? false : true);
        if (this.statePlaying) {
            if (!(this.mediaPlayer == null && this.spotifyPlayer == null && this.googleMusicPlayer == null && !z) && this.statePaused) {
                TelephonyManager telephonyManager = this.mTelephonyManager;
                if (telephonyManager != null && telephonyManager.getCallState() != 0) {
                    Logger.logInfo("Extending alarm suspension. Current call state still not idle: " + this.mTelephonyManager.getCallState());
                    enableResumer();
                    return;
                }
                Logger.logInfo("AlarmKlaxon: Resuming klaxon");
                disableResumer();
                this.statePaused = false;
                IVolumeControlRunnable iVolumeControlRunnable = this.volumeControlRunnable;
                if (iVolumeControlRunnable != null) {
                    iVolumeControlRunnable.resume();
                }
            }
        }
    }

    private void scheduleCheckEscapeCaptcha() {
        LocalBroadcastManager.getInstance(this).registerReceiver(this.timelyForegroundCheckReceiver, new IntentFilter(CaptchaCallbackReceiver.CAPTCHA_ACTION_UPDATE));
        Logger.logInfo("PreventEscapingCaptcha: scheduleCheckEscapeCaptcha");
        try {
            this.handler.removeCallbacks(this.checkCaptchaEscapeRunnable);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        this.handler.postDelayed(this.checkCaptchaEscapeRunnable, 300L);
    }

    private void scheduleCheckForeground() {
        try {
            this.handler.removeCallbacks(this.checkForegroundRunnable);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        this.handler.postDelayed(this.checkForegroundRunnable, 3000L);
    }

    private void scheduleTtsRunnable() {
        try {
            this.handler.removeCallbacks(this.ttsRunnable);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        this.handler.postDelayed(this.ttsRunnable, 60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void screenStateChanged() {
        renewVibration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendKillBroadcast(Alarm alarm) {
        Logger.logInfo("AlarmKlaxon: Broadcasting kill message");
        int iRound = (int) Math.round((System.currentTimeMillis() - this.mStartTime) / 60000.0d);
        Intent intent = new Intent("com.urbandroid.sleep.alarmclock.alarm_killed");
        intent.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
        intent.putExtra("alarm_killed_timeout", iRound);
        ContextExtKt.sendExplicitBroadcast(getApplicationContext(), intent);
    }

    private void setDataSource(final Uri uri, boolean z) {
        try {
            try {
                if (this.mediaPlayer != null) {
                    this.mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(this.alarmAudioStream == 3 ? 1 : 4).setLegacyStreamType(this.alarmAudioStream).build());
                }
            } catch (Exception e) {
                Logger.logSevere(e);
            }
            if (uri == null) {
                Logger.logInfo("AlarmKlaxon: alert null doing fallback");
                setDataSourceFromResource(getResources(), this.mediaPlayer, R.raw.fallbackring);
                startAlarm(this.mediaPlayer, true);
                return;
            }
            boolean zIsLocalAlert = isLocalAlert(uri);
            Logger.logInfo("AlarmKlaxon:setDataSource(" + uri + "), local: " + zIsLocalAlert);
            TelephonyManager telephonyManager = this.mTelephonyManager;
            if (telephonyManager != null && telephonyManager.getCallState() != 0) {
                Logger.logDebug("AlarmKlaxon: Using the in-call alarm");
                setDataSourceFromResource(getResources(), this.mediaPlayer, R.raw.in_call_alarm);
                startAlarm(this.mediaPlayer, zIsLocalAlert);
                return;
            }
            if (zIsLocalAlert && !z) {
                Logger.logDebug("AlarmKlaxon: DataSource " + uri);
                this.mediaPlayer.setDataSource(this, uri);
                startAlarm(this.mediaPlayer, true);
                return;
            }
            Logger.logDebug("AlarmKlaxon: Online DataSource " + uri);
            final AsyncTask<Void, Void, Boolean> asyncTask = new AsyncTask<Void, Void, Boolean>() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.8
                @Override // android.os.AsyncTask
                public Boolean doInBackground(Void... voidArr) {
                    try {
                        boolean zEqualsIgnoreCase = "content".equalsIgnoreCase(uri.getScheme());
                        AlarmKlaxon alarmKlaxon = AlarmKlaxon.this;
                        if (zEqualsIgnoreCase) {
                            alarmKlaxon.mediaPlayer.setDataSource(AlarmKlaxon.this.getApplicationContext(), uri);
                        } else {
                            alarmKlaxon.mediaPlayer.setDataSource(uri.toString());
                        }
                        return Boolean.TRUE;
                    } catch (Exception e2) {
                        Logger.logInfo("AlarmKlaxon: Using the fallback ringtone", e2);
                        return Boolean.FALSE;
                    }
                }

                @Override // android.os.AsyncTask
                public void onPostExecute(Boolean bool) {
                    boolean zBooleanValue = bool.booleanValue();
                    AlarmKlaxon alarmKlaxon = AlarmKlaxon.this;
                    if (!zBooleanValue) {
                        alarmKlaxon.playFallback(alarmKlaxon.mediaPlayer);
                        return;
                    }
                    try {
                        alarmKlaxon.startAlarm(alarmKlaxon.mediaPlayer, false);
                    } catch (IOException unused) {
                        AlarmKlaxon alarmKlaxon2 = AlarmKlaxon.this;
                        alarmKlaxon2.playFallback(alarmKlaxon2.mediaPlayer);
                    }
                }
            };
            if (WifiEnabler.getInstance().isAnyNetworkConnected() && (!WifiEnabler.getInstance().isAnyNetworkConnected() || !WifiEnabler.getInstance().isWifiConnected())) {
                Logger.logInfo("AlarmKlaxon: Connectivity enabled, starting online source");
                asyncTask.execute(new Void[0]);
                return;
            }
            this.wifiContext.set(WifiEnabler.getInstance().enable(MediaPlayer.class, 90, new WifiEnabler.OnConnectListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.9
                @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
                public void connected(WifiContext wifiContext) {
                    Logger.logInfo("AlarmKlaxon: Wifi enabled, starting online source");
                    asyncTask.execute(new Void[0]);
                }

                @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
                public void failed() {
                    Logger.logInfo("AlarmKlaxon: Wifi failed, doing fallback");
                    AlarmKlaxon alarmKlaxon = AlarmKlaxon.this;
                    alarmKlaxon.playFallback(alarmKlaxon.mediaPlayer);
                }

                @Override // com.urbandroid.common.wifi.WifiEnabler.OnConnectListener
                public void timeouted() {
                    Logger.logInfo("AlarmKlaxon: Wifi timeouted, doing fallback");
                    AlarmKlaxon alarmKlaxon = AlarmKlaxon.this;
                    alarmKlaxon.playFallback(alarmKlaxon.mediaPlayer);
                }
            }));
        } catch (Exception e2) {
            Logger.logInfo("AlarmKlaxon: forceWifi: " + z);
            Logger.logInfo("AlarmKlaxon: Using the fallback ringtone", e2);
            if (z || e2.getMessage() == null || !e2.getMessage().startsWith("setDataSource failed.: status=0x80000000")) {
                playFallback(this.mediaPlayer);
                return;
            }
            if (this.mediaPlayer.isPlaying()) {
                this.mediaPlayer.stop();
            }
            this.mediaPlayer.reset();
            setDataSource(uri, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataSourceFromResource(Resources resources, MediaPlayer mediaPlayer, int i) throws IOException {
        AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = resources.openRawResourceFd(i);
        if (assetFileDescriptorOpenRawResourceFd != null) {
            mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
            assetFileDescriptorOpenRawResourceFd.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFallbackDefaultDataSource(Context context, MediaPlayer mediaPlayer) throws IOException {
        mediaPlayer.setDataSource(context, SleepUtils.getActualDefaultRingtoneUri(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFallbackResourceDataSource(Context context, MediaPlayer mediaPlayer) throws IOException {
        setDataSourceFromResource(context.getResources(), mediaPlayer, R.raw.fallbackring);
    }

    public static synchronized void setRunning(boolean z) {
        isRunning = z;
    }

    private boolean shouldPlayInLoop() {
        return currentAlarm == null || !MultipleMediaUriUtil.isMultipleUri(currentAlarm.alert) || SharedApplicationContext.getSettings().isAlarmPlaylistLooping();
    }

    private boolean shouldVibrate() {
        return currentAlarm == null || currentAlarm.shouldVibrate(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAlarm(final MediaPlayer mediaPlayer, boolean z) throws IOException {
        if (mediaPlayer == null) {
            Logger.logSevere("AlarmKlaxon: player is null");
            return;
        }
        Logger.logSevere("AlarmKlaxon: media player stream type ".concat(this.alarmAudioStream == 3 ? "MUSIC" : "ALARM"));
        mediaPlayer.setAudioStreamType(this.alarmAudioStream);
        if (shouldPlayInLoop()) {
            mediaPlayer.setLooping(true);
        }
        if (z && !Experiments.getInstance().isAlarmAsyncPrepareExperiment()) {
            Logger.logInfo("AlarmKlaxon: using mp.prepare()");
            mediaPlayer.prepare();
            mediaPlayer.start();
            return;
        }
        Logger.logInfo("AlarmKlaxon: using mp.prepareAsync()");
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon$$ExternalSyntheticLambda3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer2) {
                this.f$0.lambda$startAlarm$1(mediaPlayer, mediaPlayer2);
            }
        });
        try {
            mediaPlayer.prepareAsync();
        } catch (IllegalStateException e) {
            Logger.logSevere(e);
            try {
                ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "!! prepareAsync failed in alarm !!", 10);
            } catch (Exception unused) {
            }
        }
    }

    private void startBinuaralBeats() {
        int binauralAlarm = SharedApplicationContext.getSettings().getBinauralAlarm();
        if (binauralAlarm <= 0 || VolumeUtil.getHeadsetState(this) <= 0) {
            return;
        }
        Logger.logInfo("AlarmKlaxon: Starting binaural beats in alarm");
        this.binauralPlayer = new BinauralGenerator(4, binauralAlarm == 1 ? 20 : 40, binauralAlarm == 1 ? 5 : 10, this.alarmAudioStream, true);
        new Handler().postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.13
            @Override // java.lang.Runnable
            public void run() {
                if (AlarmKlaxon.this.binauralPlayer != null) {
                    AlarmKlaxon.this.binauralPlayer.play();
                }
            }
        }, 5000L);
    }

    private int startKlaxon(Intent intent, boolean z) {
        Uri uri;
        Uri uri2;
        Logger.logInfo("AlarmKlaxon: Klaxon being started. Is restart: " + z);
        Alarm fromIntent = Alarm.parseFromIntent(intent);
        Logger.logInfo("AlarmKlaxon: alarm from intent : " + fromIntent);
        final Settings settings = new Settings(this);
        settings.updateLastNonSnoozeAlarm(System.currentTimeMillis());
        int i = 1;
        if (SharedApplicationContext.getSettings().isAlarmInSilent() && fromIntent != null && (uri2 = fromIntent.alert) != null && !"silent".equals(uri2.toString())) {
            if (!Environment.isMOrGreater() && Environment.isLollipopOrGreater()) {
                AudioManager audioManager = (AudioManager) getSystemService("audio");
                if (audioManager.getRingerMode() == 0) {
                    Logger.logInfo("AlarmKlaxon: Unmuting ringer, for alarm ");
                    audioManager.setRingerMode(2);
                    this.ringerModeChanged = true;
                } else {
                    this.ringerModeChanged = false;
                }
            } else if (Environment.isMOrGreater() && !VolumeUtil.cancelDndAll(getApplicationContext())) {
                Logger.logInfo("Cannot cancel DND all - alarm may not play - we rely here on backup alarm");
            }
        }
        if (fromIntent == null) {
            Logger.logDebug("AlarmKlaxon failed to parse the alarm from the intent");
            stopForegroundSelf();
            return 2;
        }
        Logger.logInfo("AlarmKlaxon.start() " + fromIntent.id + " alert " + fromIntent.alert);
        Uri uri3 = fromIntent.alert;
        this.isDefaultRingtone = uri3 == null || uri3.toString().equals("android.resource://com.urbandroid.sleep/raw/default");
        fromIntent.alert = Alarms.resolveAlarmAlert(fromIntent);
        Logger.logInfo("AlarmKlaxon resolved alert " + fromIntent.alert);
        this.alarmAudioStream = SharedApplicationContext.getSettings().getAlarmOutput() == 1 ? 3 : 4;
        if (isSpotifyAlarm(fromIntent)) {
            Logger.logInfo("AlarmKlaxon STREAM " + settings.isSpotifyPremium() + " " + settings.isSpotifyAppRemoteScopeAllowed() + " " + fromIntent.alert);
            if (!settings.isSpotifyPremium() || !settings.isSpotifyAppRemoteScopeAllowed() || (uri = fromIntent.alert) == null || "spotify-play-last-song".equals(uri.toString())) {
                Logger.logInfo("AlarmKlaxon Spotify stream MUSIC ");
                this.alarmAudioStream = 3;
            } else {
                Logger.logInfo("AlarmKlaxon STREAM " + settings.isSpotifyPremium() + " " + settings.isSpotifyAppRemoteScopeAllowed() + " " + fromIntent.alert);
                int i2 = (settings.getAlarmOutput() > 0 || Alarm.resolveSoundDelay(this, fromIntent, this.isSnoozedAlarm) > 0) ? 3 : 4;
                this.alarmAudioStream = i2;
                Logger.logInfo("AlarmKlaxon Spotify stream ".concat(i2 == 3 ? "MUSIC" : "ALARM"));
            }
        }
        Logger.logInfo("AlarmKlaxon: Klaxon output: ".concat(this.alarmAudioStream == 3 ? "MUSIC" : "ALARM"));
        setRunning(true);
        if (Experiments.getInstance().isRestartingAlarmDialogExperiment()) {
            scheduleCheckForeground();
        }
        if (settings.isTextToSpeech()) {
            scheduleTtsRunnable();
        }
        if (doNoEscape(this, fromIntent)) {
            scheduleCheckEscapeCaptcha();
        } else if (this.lockView != null) {
            Logger.logInfo("CAPTCHA Cheating: hiding lock view");
            this.lockView.hide();
        }
        Class<AlarmAlertFullScreen> cls = AlarmAlertFullScreen.currentClass;
        if (cls == null) {
            cls = AlarmAlertFullScreen.class;
        }
        this.alarmClass = cls;
        boolean booleanExtra = intent.getBooleanExtra("use_headsup_extra", false);
        zza$$ExternalSyntheticOutline0.m("AlarmKlaxon: use heads up: ", booleanExtra);
        Class cls2 = this.alarmClass;
        if (booleanExtra) {
            startForegroundOnce(prepareHeadsUpNotification(this, fromIntent, cls2));
        } else {
            startForegroundOnce(prepareStandardNotification(this, fromIntent, cls2));
        }
        if (currentAlarm == null) {
            new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.7
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    settings.setAlarmRunningForDirectBoot(true);
                    return null;
                }
            }.execute(new Void[0]);
            this.isSnoozedAlarm = SharedApplicationContext.getSettings().getSnoozeRepeat() > 0;
            if (Experiments.getInstance().isReplaceRestarting()) {
                settings.setCurrentAlarm(fromIntent.id, System.currentTimeMillis());
            }
            restartRequested = false;
            if (z) {
                Intent intent2 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_ALERT");
                intent2.putExtra("intent.extra.alarm", (Parcelable) fromIntent);
                intent2.putExtra("intent.extra.alarm_restarted", true);
                ContextExtKt.sendExplicitBroadcast(getApplicationContext(), intent2);
            }
            currentAlarm = fromIntent;
            if (settings.hasPendingActiveAlarm()) {
                settings.setCaptchaAvoided(true);
            }
            if (getBatteryLevel() <= 0.05f || !Alarms.hasCaptcha(this, currentAlarm)) {
                settings.clearActiveAlarm();
            } else {
                settings.setActiveAlarm(currentAlarm);
            }
            TelephonyManager telephonyManager = this.mTelephonyManager;
            if (telephonyManager != null) {
                this.mInitialCallState = telephonyManager.getCallState();
            }
            this.originalVolume = Integer.valueOf(((AudioManager) getSystemService("audio")).getStreamVolume(this.alarmAudioStream));
            Logger.logInfo("AlarmKlaxon: Original volume " + this.originalVolume);
            Integer num = this.originalVolume;
            this.nonGradualAlarmVolume = num;
            if (num.intValue() == 0) {
                this.nonGradualAlarmVolume = 1;
            }
            new Handler().postDelayed(new Processor$$ExternalSyntheticLambda2(this, fromIntent, booleanExtra, i), 2000L);
            RingerModeUtil.resetAlarmSilentSettings(getApplicationContext(), SharedApplicationContext.getSettings(), this.alarmAudioStream);
            if ((smartLight != null || this.useScreenLight) && this.sunriseStart == -1) {
                int iResolveSoundDelay = Alarm.resolveSoundDelay(this, currentAlarm, this.isSnoozedAlarm);
                if ((settings.isSoundDelayAfterSnooze() || !this.isSnoozedAlarm) && iResolveSoundDelay < 60000) {
                    iResolveSoundDelay = currentAlarm.getGradualVolumeIncrease(this);
                }
                int iMax = Math.max(iResolveSoundDelay, 60000);
                Logger.logInfo("SmartLight: starting sunrise " + iMax);
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.sunriseStart = jCurrentTimeMillis;
                this.sunriseEnd = jCurrentTimeMillis + ((long) iMax);
                this.handler.removeCallbacks(this.smartLightRunnable);
                this.handler.post(this.smartLightRunnable);
                return 3;
            }
            Logger.logInfo("AlarmKlaxon: SmartLight no sunrise " + smartLight + " " + this.sunriseStart);
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void suspendAlarm(int i, boolean z) {
        StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i, "Suspending alarm  ", " state ");
        sbM65m.append(this.statePlaying);
        sbM65m.append(" player ");
        zza$$ExternalSyntheticOutline0.m(sbM65m, (this.mediaPlayer == null && this.spotifyPlayer == null && this.googleMusicPlayer == null && !currentAlarm.silent) ? false : true);
        if (this.binauralPlayer != null) {
            Logger.logInfo("Stopping binaural player ");
            this.binauralPlayer.stop();
            this.binauralPlayer = null;
        }
        if (this.statePlaying) {
            if ((this.mediaPlayer == null && this.spotifyPlayer == null && this.googleMusicPlayer == null && !currentAlarm.silent) || this.statePaused) {
                return;
            }
            Logger.logInfo("Suspending klaxon");
            enableResumer();
            this.statePaused = true;
            if (this.volumeControlRunnable != null) {
                Logger.logInfo("Suspending calling suspend " + this.volumeControlRunnable.getClass());
                this.volumeControlRunnable.suspend(i, z);
            }
            IFlashlightService flashlightService = SharedApplicationContext.getInstance().getFlashlightService();
            if (SharedApplicationContext.getSettings().isUseFlashlight()) {
                this.mHandler.removeMessages(5);
                if (flashlightService.isTurnedOn()) {
                    Logger.logDebug("Switching flashlight off on alarm suspend.");
                    SharedApplicationContext.getInstance().getFlashlightService().turnOff();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchFlashlight() {
        if (this.statePaused) {
            return;
        }
        if (currentAlarm != null) {
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(AppFunctionException.ERROR_FUNCTION_NOT_FOUND, null), 5000L);
        }
        IFlashlightService flashlightService = SharedApplicationContext.getInstance().getFlashlightService();
        Logger.logDebug("AlarmKaxon: Switching flashlight. Currently: " + flashlightService.isTurnedOn());
        if (flashlightService.isTurnedOn()) {
            SharedApplicationContext.getInstance().getFlashlightService().turnOff();
        } else if (currentAlarm != null) {
            SharedApplicationContext.getInstance().getFlashlightService().turnOn();
        }
    }

    private void unscheduleCheckEscapeCaptcha() {
        Logger.logInfo("PreventEscapingCaptcha: unscheduleCheckEscapeCaptcha");
        try {
            this.handler.removeCallbacks(this.checkCaptchaEscapeRunnable);
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.timelyForegroundCheckReceiver);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    private void unscheduleCheckForeground() {
        try {
            this.handler.removeCallbacks(this.checkForegroundRunnable);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    private void unscheduleTtsRunnable() {
        try {
            this.handler.removeCallbacks(this.ttsRunnable);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    public void doTts(float f) {
        if (currentAlarm != null) {
            try {
                TtsService.speak(this, getString(R.string.wake_up) + " " + DateUtil.formatTimeShortHumanTts(this, new Date().getTime()), f, this.alarmAudioStream);
                if (currentAlarm.label != null && currentAlarm.label.length() > 1) {
                    TtsService.speak(this, currentAlarm.label, f, this.alarmAudioStream);
                }
            } finally {
                scheduleTtsRunnable();
            }
        }
    }

    @Override // com.urbandroid.common.LoggingService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.urbandroid.common.ForegroundService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.handler = new Handler();
        this.vibrator = (Vibrator) getSystemService("vibrator");
        if (SleepPermissionCompat.INSTANCE.isPermissionGranted(this, "android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
            this.mTelephonyManager = telephonyManager;
            telephonyManager.listen(this.mPhoneStateListener, 32);
        }
        AlarmAlertWakeLock.acquireCpuWakeLock(this);
        this.timeoutSeconds = SharedApplicationContext.getSettings().getAlarmTimeout();
        this.sirenaTimeoutSeconds = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this).getString("siren_kill_time", Integer.toString(60)));
        Settings settings = new Settings(this);
        registerScreenStateMonitor();
        Logger.logInfo("Klaxon initialized " + new Date());
        this.smartWatch = SmartWatchProvider.getSmartWatch(this);
        Logger.logInfo("AlarmKlaxon: smartwatch " + this.smartWatch);
        smartLight = SmartLightProvider.getSmartLight(this);
        Logger.logInfo("AlarmKlaxon: SmartLight: " + smartLight);
        this.useScreenLight = SharedApplicationContext.getSettings().isScreenLight();
        this.receiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intent intent2;
                Settings settings2 = new Settings(context);
                if (intent != null) {
                    if ("com.urbandroid.sleep.ACTION_DELAY_RESUMER".equals(intent.getAction())) {
                        long intExtra = intent.getIntExtra("timeAddInSeconds", 60);
                        Logger.logInfo("Resume timeAddInSeconds: " + intExtra);
                        if (intExtra < 5 || intExtra > 180) {
                            Logger.logWarning("Resume timeAddInSeconds out of range[5, 180]: " + intExtra);
                            intExtra = 60;
                        }
                        AlarmKlaxon.this.resetResumer(intExtra);
                        if (AlarmKlaxon.this.statePaused) {
                            return;
                        }
                        AlarmKlaxon.this.suspendAlarm(SharedApplicationContext.getSettings().getCaptchaSuppressMode(AlarmKlaxon.currentAlarm), false);
                        return;
                    }
                    if ("com.urbandroid.sleep.alarmclock.ALARM_SUSPEND".equals(intent.getAction())) {
                        int captchaSuppressMode = SharedApplicationContext.getSettings().getCaptchaSuppressMode(AlarmKlaxon.currentAlarm);
                        if (AlarmKlaxon.currentAlarm != null) {
                            AlarmKlaxon.this.suspendAlarm(captchaSuppressMode, false);
                            return;
                        } else {
                            Logger.logInfo("No alarm no SUSPEND");
                            return;
                        }
                    }
                    if ("com.urbandroid.sleep.ACCEL_GESTURE_FLIP_ACTION".equals(intent.getAction())) {
                        if (settings2.isFlipToSnooze()) {
                            settings2.resetAutoSnoozeRepeat();
                            Intent intent3 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE");
                            intent3.putExtra("intent.extra.alarm_raw", AlarmKlaxon.currentAlarm.serializeToArray());
                            ContextExtKt.sendExplicitBroadcast(AlarmKlaxon.this, intent3);
                            return;
                        }
                        return;
                    }
                    if ("android.intent.action.SNOOZE_ALARM".equals(intent.getAction())) {
                        Logger.logInfo("AlarmKlaxon: AlarmClock.ACTION_SNOOZE_ALARM");
                        settings2.resetAutoSnoozeRepeat();
                        Intent intent4 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE");
                        if (AlarmKlaxon.currentAlarm != null && intent.hasExtra("android.intent.extra.alarm.SNOOZE_DURATION")) {
                            intent4.putExtra("extra_snooze_time", intent.getIntExtra("android.intent.extra.alarm.SNOOZE_DURATION", settings2.getSnoozeDuration(AlarmKlaxon.currentAlarm)));
                        }
                        intent4.putExtra("intent.extra.alarm_raw", AlarmKlaxon.currentAlarm.serializeToArray());
                        ContextExtKt.sendExplicitBroadcast(AlarmKlaxon.this, intent4);
                        return;
                    }
                    if (!"android.intent.action.DISMISS_ALARM".equals(intent.getAction())) {
                        if ("com.urbandroid.sleep.alarmclock.ALARM_RESUME".equals(intent.getAction())) {
                            if (AlarmKlaxon.currentAlarm != null) {
                                AlarmKlaxon.this.resumeAlarm();
                                return;
                            } else {
                                Logger.logInfo("No alarm no RESUME");
                                AlarmKlaxon.this.stopForegroundSelf();
                                return;
                            }
                        }
                        return;
                    }
                    Logger.logInfo("AlarmKlaxon: AlarmClock.ACTION_DISMISS_ALARM " + AlarmKlaxon.currentAlarm);
                    if (AlarmKlaxon.currentAlarm == null || settings2.getCaptchaInfo(AlarmKlaxon.currentAlarm).getId() == 0) {
                        intent2 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_DISMISS");
                        Logger.logInfo("AlarmKlaxon: ALARM_DISMISS_ACTION");
                    } else {
                        intent2 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CAPTCHA");
                        ContextExtKt.sendExplicitBroadcast(AlarmKlaxon.this, intent2);
                        Logger.logInfo("AlarmKlaxon: ALARM_DISMISS_CAPTCHA_ACTION");
                    }
                    if (AlarmKlaxon.currentAlarm != null) {
                        intent2.putExtra("intent.extra.alarm_raw", AlarmKlaxon.currentAlarm.serializeToArray());
                    }
                    ContextExtKt.sendExplicitBroadcast(AlarmKlaxon.this, intent2);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("com.urbandroid.sleep.ACTION_DELAY_RESUMER");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_SUSPEND");
        intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_RESUME");
        intentFilter.addAction("com.urbandroid.sleep.ACCEL_GESTURE_FLIP_ACTION");
        intentFilter.addAction("android.intent.action.DISMISS_ALARM");
        intentFilter.addAction("android.intent.action.SNOOZE_ALARM");
        ContextCompat.registerReceiver(this, this.receiver, intentFilter, 2);
        try {
            BedtimeReceiver.cancelRepeatNotification(getApplicationContext());
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        NotificationManagerCompat.from(this).cancel(28777382);
        this.screenLockManager = new SleepLockManager(this);
        boolean zIsScreenLight = settings.isScreenLight();
        SleepLockManager sleepLockManager = this.screenLockManager;
        if (zIsScreenLight) {
            sleepLockManager.turnScreenOn(300000);
        } else {
            sleepLockManager.turnScreenOn(120000);
        }
        boolean zIsFlipToSnooze = settings.isFlipToSnooze();
        this.flipToSnooze = zIsFlipToSnooze;
        if (zIsFlipToSnooze && !settings.isFlipDetectionRunning()) {
            AccelManager accelManager = new AccelManager(this, false, 0);
            this.accelManager = accelManager;
            accelManager.start();
        }
        try {
            if ((android.provider.Settings.canDrawOverlays(this) || CaptchaAntiCheatingAccessibilityService.getInstance() != null) && settings.isCaptchaNoEscape()) {
                LockView lockView = new LockView(CaptchaAntiCheatingAccessibilityService.getInstance() != null ? CaptchaAntiCheatingAccessibilityService.getInstance() : this);
                this.lockView = lockView;
                lockView.show();
            }
        } catch (Exception unused) {
            this.lockView = null;
            Logger.logInfo("AlarmKlaxon: cannot initialize overlay");
        }
        this.hideSystemDialogs = settings.isCaptchaNoEscapeForceStop();
    }

    @Override // com.urbandroid.common.ForegroundService, com.urbandroid.common.LoggingService, android.app.Service
    public void onDestroy() {
        Logger.logInfo("AlarmKlaxon: Destroying Klaxon");
        LAST_FINISHED_TIME = System.currentTimeMillis();
        LockView lockView = this.lockView;
        if (lockView != null) {
            lockView.hide();
            this.lockView = null;
        }
        final Settings settings = SharedApplicationContext.getSettings();
        if (settings.isCaptchaNoEscape()) {
            unscheduleCheckEscapeCaptcha();
        }
        if (Experiments.getInstance().isRestartingAlarmDialogExperiment()) {
            unscheduleCheckForeground();
        }
        if (Experiments.getInstance().isReplaceRestarting()) {
            SharedApplicationContext.getSettings().setCurrentAlarm(-1, 0L);
        }
        unscheduleTtsRunnable();
        this.handler.removeCallbacks(this.smartLightRunnable);
        currentAlarm = null;
        settings.clearActiveAlarm();
        setRunning(false);
        new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.4
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                settings.setAlarmRunningForDirectBoot(false);
                return null;
            }
        }.execute(new Void[0]);
        stopForeground(true);
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(this);
        notificationManagerCompatFrom.cancel(34377266);
        notificationManagerCompatFrom.cancel(28777382);
        notificationManagerCompatFrom.cancel(6305);
        if (this.statePlaying) {
            ContextExtKt.sendExplicitBroadcast(this, new Intent("com.urbandroid.sleep.alarmclock.ALARM_DONE"));
        }
        stop();
        disableResumer();
        disablePendingMessages();
        TelephonyManager telephonyManager = this.mTelephonyManager;
        if (telephonyManager != null) {
            telephonyManager.listen(this.mPhoneStateListener, 0);
        }
        AlarmAlertWakeLock.releaseCpuLock();
        deregisterScreenStateMonitor();
        SmartWatch smartWatch = this.smartWatch;
        if (smartWatch != null) {
            smartWatch.stopAlarm();
        } else {
            SmartWatchProvider.asyncSmartwatchConnect(this, new AbstractConnectivityCallback() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.5
                @Override // com.urbandroid.sleep.smartwatch.AbstractConnectivityCallback
                public void doStatus(SmartWatch smartWatch2, boolean z) {
                    if (!z || smartWatch2 == null) {
                        return;
                    }
                    smartWatch2.stopAlarm();
                }
            }, 30000L, false);
        }
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        if (this.ringerModeChanged && Environment.isLollipopOrGreater() && !Environment.isMOrGreater()) {
            AudioManager audioManager = (AudioManager) getSystemService("audio");
            Logger.logInfo("AlarmKlaxon: restoring silent mode.");
            audioManager.setRingerMode(0);
        }
        SleepLockManager sleepLockManager = this.screenLockManager;
        if (sleepLockManager != null) {
            sleepLockManager.releaseScreenOnLock();
            this.screenLockManager = null;
        }
        AccelManager accelManager = this.accelManager;
        if (accelManager != null) {
            accelManager.stop();
        }
        if (smartLight != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.6
                @Override // java.lang.Runnable
                public void run() {
                    Logger.logInfo("AlarmKlaxon: removing smartLight");
                    AlarmKlaxon.smartLight.close();
                    AlarmKlaxon.smartLight = null;
                }
            }, 5000L);
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        onStartCommand(intent, 0, i);
    }

    @Override // com.urbandroid.common.LoggingService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null || intent.getAction() == null) {
            Logger.logDebug("AlarmKlaxon: No Intent => Ignoring");
            stopForegroundSelf();
            return 1;
        }
        Intent intent2 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_ALERT");
        intent2.setPackage(getPackageName());
        Logger.logInfo("AlarmKlaxon: Intent " + intent.getAction() + " " + intent.getComponent() + " " + intent.getData() + " " + intent.getType() + " " + intent.getPackage() + " " + intent.filterEquals(intent2));
        Set<String> categories = intent.getCategories();
        if (categories != null) {
            Iterator<String> it = categories.iterator();
            while (it.hasNext()) {
                zza$$ExternalSyntheticOutline0.m("AlarmKlaxon: Intent category ", it.next());
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str : extras.keySet()) {
                StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("AlarmKlaxon: Intent extra ", str, "=");
                sbM5m.append(extras.get(str));
                Logger.logInfo(sbM5m.toString());
            }
        }
        if (!intent.getAction().equals("com.urbandroid.sleep.alarmclock.ALARM_ALERT")) {
            setDummyForegroundIfForegroundNotCalled();
            Logger.logInfo("Handled.. " + intent.getAction() + " Start id: " + i2);
            return 1;
        }
        if (Experiments.getInstance().isReliableAlarmExperiment()) {
            Logger.logInfo("AlarmKlaxon: bypassing AlarmReceiver startService");
            Alarm fromIntent = Alarm.parseFromIntent(intent);
            if (fromIntent != null) {
                fromIntent.recompteOffsetOnAlarmFired(getApplicationContext());
                long jCurrentTimeMillis = System.currentTimeMillis();
                Logger.logDebug("AlarmKlaxon: onReceive() id " + fromIntent.id + " setFor " + new SimpleDateFormat("HH:mm:ss.SSS aaa").format(new Date(fromIntent.time)));
                if (jCurrentTimeMillis > fromIntent.time + 1800000) {
                    Logger.logDebug("AlarmReceiver: ignoring stale alarm");
                    stopForegroundSelf();
                    return 2;
                }
                SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
                if (record != null) {
                    record.addEventLabel(EventLabel.ALARM_STARTED, System.currentTimeMillis());
                }
                if (Build.VERSION.SDK_INT < 31) {
                    try {
                        sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                    } catch (Exception unused) {
                    }
                }
                if (AlarmReceiver.useHeadupsNotification(getApplicationContext(), new Settings(getApplicationContext()), fromIntent)) {
                    intent.putExtra("use_headsup_extra", true);
                    Logger.logDebug("AlarmKlaxon: Do not show AlarmActivity with headsup");
                } else {
                    Intent intent3 = new Intent(getApplicationContext(), (Class<?>) AlarmAlertFullScreen.class);
                    intent3.putExtra("intent.extra.alarm", (Serializable) fromIntent);
                    intent3.putExtra("CREATION_SOURCE", "AlarmKlaxon-Main-Code");
                    intent3.setFlags(268697600);
                    Logger.logDebug("AlarmKlaxon: Starting alarm alert service of class: " + AlarmAlertFullScreen.class);
                    getApplicationContext().startActivity(intent3);
                    Logger.logDebug("AlarmKlaxon: Starting alarm alert service of class: " + AlarmAlertFullScreen.class + " - Finished ");
                }
                Alarms.disableSnoozeAlert(getApplicationContext(), fromIntent.id);
                Alarms.scheduleNewAlertAfterOldFinished(getApplicationContext(), fromIntent);
                Logger.logInfo("AlarmKlaxon: ALARM START");
                Intent intent4 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_ALERT_START");
                intent4.putExtra("alarm_id", fromIntent.id);
                ContextExtKt.sendExplicitBroadcast(getApplicationContext(), intent4);
                Intent intent5 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_ALERT_START_INTERNAL");
                intent5.putExtra("intent.extra.alarm", (Serializable) fromIntent);
                ContextExtKt.sendExplicitBroadcast(getApplicationContext(), intent5);
                AlarmStatusReceiver.alarmIsRinging = true;
            }
        }
        boolean z = (i & 1) != 0;
        WakefulForegroundBroadcastReceiver.INSTANCE.completeWakefulIntent(intent);
        return startKlaxon(intent, z);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        Logger.logInfo("AlarmKlaxon: Removing AlarmKlaxon task");
        Logger.syncPersistBuffer();
    }

    public void stop() {
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("AlarmKlaxon.stop().. Playing at the moment: "), this.statePlaying);
        if (this.useFlashlight) {
            SharedApplicationContext.getInstance().getFlashlightService().turnOff();
        }
        StringBuilder sb = new StringBuilder("AlarmKlaxon: Stopping VolumeControlRunnable ");
        sb.append(this.statePlaying);
        sb.append(" ");
        final int i = 1;
        final int i2 = 0;
        zza$$ExternalSyntheticOutline0.m(sb, this.spotifyPlayer != null);
        if (this.statePlaying) {
            this.statePlaying = false;
            Logger.logInfo("AlarmKlaxon: Stopping VolumeControlRunnable " + this.volumeControlRunnable);
            if (this.volumeControlRunnable != null) {
                Logger.logInfo("AlarmKlaxon: Stopping VolumeControlRunnable " + this.volumeControlRunnable.getClass());
                final IVolumeControlRunnable iVolumeControlRunnable = this.volumeControlRunnable;
                if (iVolumeControlRunnable instanceof VolumeControlRunnable) {
                    Logger.logInfo("AlarmKlaxon: Stopping VolumeControlRunnable delayed");
                    final IVolumeControlRunnable iVolumeControlRunnable2 = this.volumeControlRunnable;
                    this.volumeControlRunnable = null;
                    this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i3 = i2;
                            IVolumeControlRunnable iVolumeControlRunnable3 = iVolumeControlRunnable2;
                            switch (i3) {
                                case 0:
                                    AlarmKlaxon.lambda$stop$2(iVolumeControlRunnable3);
                                    break;
                                default:
                                    AlarmKlaxon.lambda$stop$3(iVolumeControlRunnable3);
                                    break;
                            }
                        }
                    }, 3000L);
                } else {
                    this.volumeControlRunnable = null;
                    this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i3 = i;
                            IVolumeControlRunnable iVolumeControlRunnable3 = iVolumeControlRunnable;
                            switch (i3) {
                                case 0:
                                    AlarmKlaxon.lambda$stop$2(iVolumeControlRunnable3);
                                    break;
                                default:
                                    AlarmKlaxon.lambda$stop$3(iVolumeControlRunnable3);
                                    break;
                            }
                        }
                    }, 1000L);
                }
            }
            BinauralGenerator binauralGenerator = this.binauralPlayer;
            if (binauralGenerator != null) {
                binauralGenerator.stop();
                this.binauralPlayer = null;
            }
            ISpotifyPlayer iSpotifyPlayer = this.spotifyPlayer;
            if (iSpotifyPlayer != null) {
                iSpotifyPlayer.stop();
                this.spotifyPlayer = null;
            }
            GoogleMusicPlayer googleMusicPlayer = this.googleMusicPlayer;
            if (googleMusicPlayer != null) {
                googleMusicPlayer.stop();
                this.googleMusicPlayer = null;
            }
            if (this.mediaPlayer != null) {
                Logger.logDebug("AlarmKlaxon: Going to stop mPlayer");
                this.mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.14
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        Logger.logInfo("AlarmKlaxon: Prepared but stopped, ignoring onPrepared()");
                    }
                });
                MediaPlayer mediaPlayer = this.mediaPlayer;
                this.mediaPlayer = null;
                try {
                    try {
                        try {
                            mediaPlayer.stop();
                            Logger.logDebug("AlarmKlaxon: mPlayer stop()");
                            mediaPlayer.release();
                        } catch (Exception e) {
                            Logger.logSevere(e);
                            mediaPlayer.release();
                        }
                        Logger.logDebug("AlarmKlaxon: mPlayer release()");
                    } catch (Exception e2) {
                        Logger.logSevere(e2);
                    }
                    if (this.wifiContext.get() != null) {
                        this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.alarmclock.AlarmKlaxon.15
                            @Override // java.lang.Runnable
                            public void run() {
                                WifiContext wifiContext = (WifiContext) AlarmKlaxon.this.wifiContext.get();
                                if (wifiContext != null) {
                                    wifiContext.disable();
                                    AlarmKlaxon.this.wifiContext.set(null);
                                }
                            }
                        }, 15000L);
                    }
                } catch (Throwable th) {
                    try {
                        mediaPlayer.release();
                        Logger.logDebug("AlarmKlaxon: mPlayer release()");
                    } catch (Exception e3) {
                        Logger.logSevere(e3);
                    }
                    throw th;
                }
            }
        }
    }

    public class SharedPlaybackListener implements PlaybackListener {
        private final boolean forceMaxVolume;
        private final boolean playList;
        private final String playerName;
        private final boolean silent;
        private final boolean vibrate;

        private SharedPlaybackListener(String str, boolean z, boolean z2, boolean z3, boolean z4) {
            this.playerName = str;
            this.vibrate = z;
            this.silent = z2;
            this.forceMaxVolume = z3;
            this.playList = z4;
        }

        @Override // com.urbandroid.sleep.media.player.PlaybackListener
        public void fail(int i) {
            try {
                Logger.logSevere("AlarmKlaxon: Error play " + this.playerName + " [reason: " + i + "]: switching to fallback");
                if (AlarmKlaxon.isRunning()) {
                    if (AlarmKlaxon.this.volumeControlRunnable != null) {
                        AlarmKlaxon.this.volumeControlRunnable.reset();
                    }
                    AlarmKlaxon.this.spotifyPlayer = null;
                    AlarmKlaxon.this.mediaPlayer = new MediaPlayer();
                    AlarmKlaxon.this.volumeControlRunnable = null;
                    if (AlarmKlaxon.currentAlarm != null) {
                        AlarmKlaxon.this.initializeVolumeControlThread(true, this.vibrate, this.forceMaxVolume, 0, this.silent, false, false);
                    }
                    AlarmKlaxon alarmKlaxon = AlarmKlaxon.this;
                    alarmKlaxon.setFallbackDefaultDataSource(alarmKlaxon.getApplicationContext(), AlarmKlaxon.this.mediaPlayer);
                    AlarmKlaxon.this.mediaPlayer.setLooping(true);
                    AlarmKlaxon alarmKlaxon2 = AlarmKlaxon.this;
                    alarmKlaxon2.startAlarm(alarmKlaxon2.mediaPlayer, true);
                }
            } catch (Exception e) {
                Logger.logWarning("AlarmKlaxon: " + this.playerName + " reset to DEFAULT has failed.", e);
                try {
                    MediaPlayer mediaPlayer = AlarmKlaxon.this.mediaPlayer;
                    AlarmKlaxon alarmKlaxon3 = AlarmKlaxon.this;
                    if (mediaPlayer != null) {
                        try {
                            alarmKlaxon3.mediaPlayer.reset();
                        } catch (Exception e2) {
                            Logger.logSevere(e2);
                        }
                    } else {
                        alarmKlaxon3.mediaPlayer = new MediaPlayer();
                    }
                    AlarmKlaxon alarmKlaxon4 = AlarmKlaxon.this;
                    alarmKlaxon4.setFallbackResourceDataSource(alarmKlaxon4.getApplicationContext(), AlarmKlaxon.this.mediaPlayer);
                    AlarmKlaxon.this.mediaPlayer.setLooping(true);
                    AlarmKlaxon alarmKlaxon5 = AlarmKlaxon.this;
                    alarmKlaxon5.startAlarm(alarmKlaxon5.mediaPlayer, true);
                } catch (Exception e3) {
                    Logger.logWarning("AlarmKlaxon: " + this.playerName + " reset RAW RESOURCE has failed.", e3);
                }
            }
        }

        @Override // com.urbandroid.sleep.media.player.PlaybackListener
        public void playbackStarted() {
            if (this.playList || AlarmKlaxon.this.volumeControlRunnable == null) {
                return;
            }
            if (AlarmKlaxon.this.doGradualVolumeUp == null || AlarmKlaxon.this.doGradualVolumeUp.booleanValue()) {
                Logger.logWarning("AlarmKlaxon: VolumeControlRunnable " + this.playerName + " mute.");
                AlarmKlaxon.this.volumeControlRunnable.mute();
            }
        }

        public /* synthetic */ SharedPlaybackListener(AlarmKlaxon alarmKlaxon, String str, boolean z, boolean z2, boolean z3, boolean z4, int i) {
            this(str, z, z2, z3, z4);
        }
    }

    private void enableResumer() {
        enableResumer(60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataSource(Uri uri) {
        setDataSource(uri, false);
    }

    public static Notification prepareHeadsUpNotification(Context context, Alarm alarm, Class cls) {
        return prepareHeadsUpNotification(context, alarm, cls, false);
    }
}
