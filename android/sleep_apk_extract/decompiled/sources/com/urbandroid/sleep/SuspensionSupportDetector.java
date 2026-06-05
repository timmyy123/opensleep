package com.urbandroid.sleep;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.CryptoUtil;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.sensor.AccelManager;
import com.urbandroid.sleep.suspensiondetector.AfterScreenOffModeDetector;
import com.urbandroid.sleep.suspensiondetector.DelayNormalModeDetector;
import com.urbandroid.sleep.suspensiondetector.ISingleModeDetector;
import com.urbandroid.sleep.suspensiondetector.StandardModeDetector;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes4.dex */
public class SuspensionSupportDetector {
    private static SuspendSupport cachedSuspendMode;
    private static SuspensionSupportDetector currentlyRunningInstance;
    private final AccelManager accelManager;
    private final Context context;
    private PowerManager.WakeLock cpuLock;
    private LinkedList<ISingleModeDetector> detectors = new LinkedList<>();
    private Boolean isScreenOn;
    private Thread resultPollingThread;
    private ScreenStateBroadcastReceiver screenStateBroadcastReceiver;

    public class PollForResult implements Runnable {
        public PollForResult() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                synchronized (SuspensionSupportDetector.this) {
                    try {
                        ISingleModeDetector currentDetector = SuspensionSupportDetector.this.getCurrentDetector();
                        if (currentDetector == null) {
                            SuspensionSupportDetector.this.finishAndSetMode(SuspendSupport.BROKEN);
                            return;
                        }
                        Boolean boolIsSupported = currentDetector.isSupported();
                        if (boolIsSupported != null) {
                            Logger.logDebug("Detection form mode: " + currentDetector.getMode() + " finished with result: " + boolIsSupported);
                            boolean zBooleanValue = boolIsSupported.booleanValue();
                            SuspensionSupportDetector suspensionSupportDetector = SuspensionSupportDetector.this;
                            if (zBooleanValue) {
                                suspensionSupportDetector.finishAndSetMode(currentDetector.getMode());
                                return;
                            }
                            suspensionSupportDetector.detectors.removeFirst();
                            ISingleModeDetector currentDetector2 = SuspensionSupportDetector.this.getCurrentDetector();
                            if (currentDetector2 != null) {
                                currentDetector2.start(SuspensionSupportDetector.this.isScreenOn());
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }

    public class ScreenStateBroadcastReceiver extends LoggingReceiver {
        public ScreenStateBroadcastReceiver() {
        }

        @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                Logger.logInfo("Screen off detected");
                SuspensionSupportDetector.this.onScreenOff();
            } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                Logger.logInfo("Screen on detected");
                SuspensionSupportDetector.this.onScreenOn();
            } else {
                Logger.logSevere("Unexpected intent: " + intent);
            }
        }
    }

    public enum SuspendSupport {
        UNKNOWN,
        WORKS,
        BROKEN,
        IGNORE,
        WORKS_WITH_START_AFTER_SCREEN_OFF,
        WORKS_WITH_ZEROS,
        WORKS_WITH_DELAY_NORMAL
    }

    private SuspensionSupportDetector(Context context) {
        this.isScreenOn = Boolean.FALSE;
        this.context = context;
        Boolean boolIsScreenOn = Environment.isScreenOn(context);
        this.isScreenOn = boolIsScreenOn;
        if (boolIsScreenOn == null) {
            Logger.logInfo("Screen on detection unsupported -> assuming on");
            this.isScreenOn = Boolean.TRUE;
        }
        Logger.logInfo("Suspension detector created. Screen state: " + this.isScreenOn);
        AccelManager accelManager = new AccelManager(context, false, 0, false);
        this.accelManager = accelManager;
        this.detectors.addLast(new StandardModeDetector(accelManager));
        this.detectors.addLast(new AfterScreenOffModeDetector(accelManager));
        this.detectors.addLast(new DelayNormalModeDetector(accelManager));
        getCurrentDetector().start(this.isScreenOn.booleanValue());
        registerScreenStateMonitor();
        setCpuWakeLock(true);
    }

    private void deregisterScreenStateMonitor() {
        Logger.logInfo("Unregistering screen state reciever.");
        ScreenStateBroadcastReceiver screenStateBroadcastReceiver = this.screenStateBroadcastReceiver;
        if (screenStateBroadcastReceiver != null) {
            try {
                this.context.unregisterReceiver(screenStateBroadcastReceiver);
            } catch (Exception unused) {
            }
        }
        this.screenStateBroadcastReceiver = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void finishAndSetMode(SuspendSupport suspendSupport) {
        deregisterScreenStateMonitor();
        setSuspendSupportMode(this.context, suspendSupport);
        currentlyRunningInstance = null;
        setCpuWakeLock(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ISingleModeDetector getCurrentDetector() {
        if (this.detectors.isEmpty()) {
            return null;
        }
        return this.detectors.getFirst();
    }

    private static String getSuspendModePreferenceFinalName() {
        return "SuspendSupportPref-Final";
    }

    @Deprecated
    private static String getSuspendModePreferenceName() {
        return "SuspendSupportPref-" + CryptoUtil.md5(Build.FINGERPRINT);
    }

    public static synchronized SuspendSupport getSuspendSupportMode(Context context) {
        try {
            if (cachedSuspendMode == null) {
                if (isKnownWorkingDevice()) {
                    cachedSuspendMode = SuspendSupport.WORKS;
                } else {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("LockManagerPreferences", 0);
                    int i = sharedPreferences.getInt(getSuspendModePreferenceName(), 0);
                    int i2 = sharedPreferences.getInt(getSuspendModePreferenceFinalName(), 0);
                    if (i2 != 0) {
                        i = i2;
                    }
                    cachedSuspendMode = SuspendSupport.values()[i];
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return cachedSuspendMode;
    }

    public static void initializeSuspensionDetectionIfRequired(Context context) {
        SuspendSupport suspendSupportMode = getSuspendSupportMode(context);
        if (currentlyRunningInstance != null || isKnownWorkingDevice()) {
            return;
        }
        Logger.logInfo("SuspensionSupportDetector: Suspend mode: " + suspendSupportMode);
        if (suspendSupportMode == SuspendSupport.UNKNOWN || suspendSupportMode == SuspendSupport.BROKEN) {
            SuspensionSupportDetector suspensionSupportDetector = new SuspensionSupportDetector(context);
            currentlyRunningInstance = suspensionSupportDetector;
            suspensionSupportDetector.start();
        }
    }

    public static synchronized void interruptSuspensionDetection() {
        try {
            StringBuilder sb = new StringBuilder("Interrupting suspension detection. Running: ");
            sb.append(currentlyRunningInstance != null);
            Logger.logDebug(sb.toString());
            SuspensionSupportDetector suspensionSupportDetector = currentlyRunningInstance;
            if (suspensionSupportDetector != null) {
                ISingleModeDetector currentDetector = suspensionSupportDetector.getCurrentDetector();
                if (currentDetector != null) {
                    currentDetector.interrupt();
                }
                currentlyRunningInstance.deregisterScreenStateMonitor();
                Thread thread = currentlyRunningInstance.resultPollingThread;
                if (thread != null) {
                    thread.interrupt();
                    currentlyRunningInstance.resultPollingThread = null;
                }
                currentlyRunningInstance.setCpuWakeLock(false);
                currentlyRunningInstance = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static synchronized boolean isKnownWorkingDevice() {
        return Build.VERSION.SDK_INT >= 27;
    }

    private void registerScreenStateMonitor() {
        Logger.logInfo("Registering screen state reciever.");
        this.screenStateBroadcastReceiver = new ScreenStateBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        ContextCompat.registerReceiver(this.context, this.screenStateBroadcastReceiver, intentFilter, 2);
    }

    private synchronized void setCpuWakeLock(boolean z) {
        Logger.logInfo("Detector CPU WL: " + z);
        if (this.cpuLock == null) {
            this.cpuLock = ((PowerManager) this.context.getSystemService("power")).newWakeLock(1, SleepLockManager.getWakeLockTag(this.context, "SuspensionDetector"));
        }
        PowerManager.WakeLock wakeLock = this.cpuLock;
        if (z) {
            if (!wakeLock.isHeld()) {
                this.cpuLock.acquire();
            }
        } else if (wakeLock.isHeld()) {
            this.cpuLock.release();
        }
    }

    public static synchronized void setSuspendSupportMode(Context context, SuspendSupport suspendSupport) {
        if (!isKnownWorkingDevice()) {
            Logger.logInfo("Setting suspend support mode: " + suspendSupport);
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("LockManagerPreferences", 0).edit();
            editorEdit.putInt(getSuspendModePreferenceName(), suspendSupport.ordinal());
            editorEdit.putInt(getSuspendModePreferenceFinalName(), suspendSupport.ordinal());
            editorEdit.apply();
            cachedSuspendMode = suspendSupport;
        }
    }

    private void start() {
        Thread thread = new Thread(new PollForResult());
        this.resultPollingThread = thread;
        thread.start();
    }

    public synchronized boolean isScreenOn() {
        return this.isScreenOn.booleanValue();
    }

    public synchronized void onScreenOff() {
        this.isScreenOn = Boolean.FALSE;
        ISingleModeDetector currentDetector = getCurrentDetector();
        if (currentDetector != null) {
            currentDetector.onScreenOff();
        }
    }

    public synchronized void onScreenOn() {
        this.isScreenOn = Boolean.TRUE;
        ISingleModeDetector currentDetector = getCurrentDetector();
        if (currentDetector != null) {
            currentDetector.onScreenOn();
        }
    }
}
