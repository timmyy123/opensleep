package com.urbandroid.sleep;

import android.content.Context;
import android.content.IntentFilter;
import android.hardware.display.DisplayManager;
import android.os.PowerManager;
import android.view.Display;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.internal.ServerProtocol;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.SuspensionSupportDetector;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.SleepPermissionCompat;

/* JADX INFO: loaded from: classes4.dex */
public class SleepLockManager {
    private final Context context;
    private PowerManager.WakeLock cpuLock;
    private int dimMode;
    private PowerManager.WakeLock screenLock;
    private SoundPoolLock soundPoolLock;
    private SuspensionSupportDetector.SuspendSupport suspendSupport;
    private PowerManager.WakeLock temporaryLock;
    private PowerManager.WakeLock turnOnScreenLock;
    private int wakeLockSetting = 4;
    private boolean pluggedIn = false;
    private int batteryLevel = 0;
    private boolean firstBatteryUpdate = true;
    private boolean disabled = false;

    public SleepLockManager(Context context) {
        this.context = context;
        initialize();
    }

    private boolean canAquireWakeLock() {
        return CurrentSleepRecord.getInstance().getRecord() != null;
    }

    public static String getWakeLockTag(Context context, String str) {
        return context.getPackageName() + ":" + str;
    }

    private boolean isBatteryBellowWakeThreshold() {
        int i = this.wakeLockSetting;
        if (i == 3 && this.batteryLevel < 20) {
            return true;
        }
        if (i != 4 || this.batteryLevel >= 10) {
            return i == 5 && this.batteryLevel < 5;
        }
        return true;
    }

    private static boolean isLikelyWorkingDevice() {
        return Environment.getAPILevel() >= 14;
    }

    private boolean isLockBatteryDependent() {
        int i = this.wakeLockSetting;
        return i == 3 || i == 4 || i == 5;
    }

    public static boolean isPluggedIn(Context context) {
        int intExtra = ContextCompat.registerReceiver(context, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 2).getIntExtra("plugged", -1);
        return intExtra == 1 || intExtra == 2 || intExtra == 4;
    }

    private void setCpuWakeLock(boolean z) {
        Logger.logInfo("LockManager: Setting CPU WL: " + z);
        if (SharedApplicationContext.getSettings().doSensorBatching(this.context)) {
            Logger.logInfo("LockManager: Ignoring CPU wake lock in sensor batching.");
            return;
        }
        if (z && this.disabled) {
            Logger.logInfo("LockManager: Ignoring lock request due to disabled mode");
            return;
        }
        if (this.cpuLock == null) {
            this.cpuLock = ((PowerManager) this.context.getSystemService("power")).newWakeLock(1, getWakeLockTag(this.context, "SleepTracking"));
        }
        if (this.soundPoolLock == null && Experiments.getInstance().useAndroidMDozeHackWakeLock(this.context) && !SleepPermissionCompat.INSTANCE.isPermissionGranted(this.context, "android.permission.RECORD_AUDIO") && !SharedApplicationContext.getSettings().doSensorBatching(this.context)) {
            Logger.logInfo("LockManager: SoundPoolLock new");
            this.soundPoolLock = new SoundPoolLock(this.context);
        }
        if (!z || !canAquireWakeLock()) {
            if (this.cpuLock.isHeld()) {
                Logger.logInfo("LockManager: CPU lock released");
                this.cpuLock.release();
            }
            SoundPoolLock soundPoolLock = this.soundPoolLock;
            if (soundPoolLock != null) {
                soundPoolLock.release();
                return;
            }
            return;
        }
        if (!this.cpuLock.isHeld()) {
            Logger.logInfo("LockManager: CPU lock aquired");
            this.cpuLock.acquire();
        }
        SoundPoolLock soundPoolLock2 = this.soundPoolLock;
        if (soundPoolLock2 == null || soundPoolLock2.isHeld()) {
            return;
        }
        Logger.logInfo("LockManager: SoundPoolLock aquiring..");
        this.soundPoolLock.acquire();
    }

    private void setWakeLock(boolean z) {
        Logger.logInfo("LockManager: Setting DIM WL: " + z);
        if (SharedApplicationContext.getSettings().doSensorBatching(this.context)) {
            Logger.logInfo("LockManager: Ignoring DIM wake lock in sensor batching experiment.");
            return;
        }
        if (z && this.disabled) {
            Logger.logInfo("LockManager: Ignoring lock request due to disabled mode");
            return;
        }
        if (z && shouldUseCpuOnlyLock()) {
            Logger.logInfo("LockManager: Ignored becasue we use CPU lock only");
            return;
        }
        if (this.screenLock == null) {
            this.screenLock = ((PowerManager) this.context.getSystemService("power")).newWakeLock(6, getWakeLockTag(this.context, "SleepTrackingScreenLock"));
        }
        if (!z) {
            if (this.screenLock.isHeld()) {
                this.screenLock.release();
            }
        } else if (!canAquireWakeLock()) {
            Logger.logInfo("LockManager: Not aquiring wake lock as no tracking is in progress.");
        } else {
            if (this.screenLock.isHeld()) {
                return;
            }
            this.screenLock.acquire();
        }
    }

    private boolean shouldUseCpuOnlyLock() {
        if (this.dimMode == 5) {
            return false;
        }
        SuspensionSupportDetector.SuspendSupport suspendSupport = this.suspendSupport;
        if (suspendSupport == SuspensionSupportDetector.SuspendSupport.WORKS || suspendSupport == SuspensionSupportDetector.SuspendSupport.WORKS_WITH_START_AFTER_SCREEN_OFF || suspendSupport == SuspensionSupportDetector.SuspendSupport.WORKS_WITH_DELAY_NORMAL || suspendSupport == SuspensionSupportDetector.SuspendSupport.WORKS_WITH_ZEROS) {
            return true;
        }
        return suspendSupport == SuspensionSupportDetector.SuspendSupport.UNKNOWN && isLikelyWorkingDevice();
    }

    public synchronized void acquireLockOnResume() {
        try {
            if (!isUsingCpuOnlyLock()) {
                setWakeLock(true);
            } else if (this.batteryLevel == -1 || !isLockBatteryDependent() || this.pluggedIn || !isBatteryBellowWakeThreshold()) {
                setCpuWakeLock(true);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    public SuspensionSupportDetector.SuspendSupport getSuspensSupportMode() {
        return this.suspendSupport;
    }

    public void initialize() {
        Settings settings = new Settings(this.context);
        this.wakeLockSetting = settings.getWakeLockSettings();
        this.suspendSupport = SuspensionSupportDetector.getSuspendSupportMode(this.context);
        this.dimMode = settings.getDimMode();
        this.disabled = false;
        this.batteryLevel = -1;
        StringBuilder sb = new StringBuilder("LockManager: Lock manager initialized. Suspend mode: ");
        sb.append(this.suspendSupport.name());
        sb.append(" WL settings: ");
        zza$$ExternalSyntheticOutline0.m(sb, this.wakeLockSetting);
    }

    public boolean isAlwaysStandBySet() {
        return this.wakeLockSetting == 6;
    }

    public boolean isBatteryStatusKnown() {
        return this.batteryLevel != -1;
    }

    public boolean isCannotLockBecauseBatteryStatus() {
        if (isPluggedIn()) {
            return false;
        }
        if (isBatteryBellowWakeThreshold()) {
            return true;
        }
        return isNeverWhenChargedSet() && !shouldUseCpuOnlyLock();
    }

    public synchronized boolean isDisabled() {
        return this.disabled;
    }

    public boolean isNeverWhenChargedSet() {
        return this.wakeLockSetting == 2;
    }

    public boolean isScreenOn() {
        boolean z = true;
        for (Display display : ((DisplayManager) this.context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY)).getDisplays()) {
            if (display.getState() != 2) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isUsingCpuOnlyLock() {
        boolean z;
        if (SharedApplicationContext.getSettings().isForceScreenOff() || isAlwaysStandBySet()) {
            z = true;
        } else if (!shouldUseCpuOnlyLock()) {
            z = false;
        }
        return z;
    }

    public void onBatteryUpdate(int i, int i2, int i3) {
        boolean z = i2 > 0 || i == 2 || i == 5;
        if (isNeverWhenChargedSet() && (this.firstBatteryUpdate || z != this.pluggedIn)) {
            setWakeLock(z);
        }
        if (this.firstBatteryUpdate || z != this.pluggedIn || i3 != this.batteryLevel) {
            this.batteryLevel = i3;
            this.pluggedIn = z;
            Logger.logInfo("LockManager: Battery level " + i3 + " plug " + z);
            if (isLockBatteryDependent() && isBatteryBellowWakeThreshold()) {
                zza$$ExternalSyntheticOutline0.m(Fragment$$ExternalSyntheticOutline1.m65m(i3, "LockManager: Battery reached ", "% -> releasing wake-lock: "), !z);
                if (!z) {
                    zza$$ExternalSyntheticOutline0.m(this.context, "com.urbanroid.sleep.SLEEP_LOW_BATTERY");
                }
                if (shouldUseCpuOnlyLock()) {
                    setCpuWakeLock(z);
                } else {
                    setWakeLock(z);
                }
            }
        }
        this.firstBatteryUpdate = false;
    }

    public void releaseOnAlarmFinished() {
        Logger.logInfo("LockManager: Releasing on alarm fired.");
        setWakeLock(false);
        setCpuWakeLock(false);
    }

    public void releaseOnStop() {
        Logger.logInfo("LockManager: Releasing on stop.");
        setWakeLock(false);
        setCpuWakeLock(false);
    }

    public void releaseScreenOnLock() {
        PowerManager.WakeLock wakeLock = this.turnOnScreenLock;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        this.turnOnScreenLock.release();
        this.turnOnScreenLock = null;
    }

    public synchronized void setDisabled(boolean z) {
        Logger.logInfo("LockManager: Setting lock manager disabled mode: " + z);
        this.disabled = z;
        if (z) {
            setWakeLock(false);
            setCpuWakeLock(false);
        }
    }

    public void setTemporaryLock(boolean z) {
        zza$$ExternalSyntheticOutline0.m("LockManager: Setting Temp WL: ", z);
        if (this.temporaryLock == null) {
            this.temporaryLock = ((PowerManager) this.context.getSystemService("power")).newWakeLock(1, getWakeLockTag(this.context, "SleepTemp"));
        }
        PowerManager.WakeLock wakeLock = this.temporaryLock;
        if (z) {
            if (wakeLock.isHeld()) {
                return;
            }
            this.temporaryLock.acquire();
        } else if (wakeLock.isHeld()) {
            this.temporaryLock.release();
        }
    }

    public boolean shouldBeInStandByMode() {
        return isCannotLockBecauseBatteryStatus();
    }

    public void terminate() {
        Logger.logInfo("LockManager: Terminating lock manager.");
    }

    public void turnScreenOn(int i) {
        if (this.turnOnScreenLock == null) {
            this.turnOnScreenLock = ((PowerManager) this.context.getSystemService("power")).newWakeLock(805306394, getWakeLockTag(this.context, "TurnScreenOn"));
        }
        Logger.logInfo("LockManager: Forcing screen on");
        this.turnOnScreenLock.acquire(i);
    }

    public void updateSuspendedSupport(SuspensionSupportDetector.SuspendSupport suspendSupport) {
        this.suspendSupport = suspendSupport;
    }

    public boolean isPluggedIn() {
        return this.pluggedIn;
    }

    public void turnScreenOn() {
        turnScreenOn(10000);
    }
}
