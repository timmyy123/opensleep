package com.urbandroid.sleep.alarmclock;

import android.content.Context;
import android.os.PowerManager;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleepLockManager;

/* JADX INFO: loaded from: classes4.dex */
abstract class AlarmAlertWakeLock {
    private static PowerManager.WakeLock sCpuWakeLock;

    public static void acquireCpuWakeLock(Context context, int i) {
        Logger.logDebug("Acquiring cpu wake lock");
        if (sCpuWakeLock != null) {
            return;
        }
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(805306369, SleepLockManager.getWakeLockTag(context, "AlarmClock"));
        sCpuWakeLock = wakeLockNewWakeLock;
        if (i <= 0) {
            wakeLockNewWakeLock.acquire();
        } else {
            wakeLockNewWakeLock.acquire(i);
        }
    }

    public static void releaseCpuLock() {
        Logger.logDebug("Releasing cpu wake lock");
        PowerManager.WakeLock wakeLock = sCpuWakeLock;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        sCpuWakeLock.release();
        sCpuWakeLock = null;
    }

    public static void acquireCpuWakeLock(Context context) {
        acquireCpuWakeLock(context, -1);
    }
}
