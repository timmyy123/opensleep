package com.urbandroid.sleep.suspensiondetector;

import android.os.Handler;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SuspensionSupportDetector;
import com.urbandroid.sleep.sensor.AccelManager;

/* JADX INFO: loaded from: classes5.dex */
public class StandardModeDetector extends BaseModeDetector {
    public StandardModeDetector(AccelManager accelManager) {
        super(accelManager);
    }

    @Override // com.urbandroid.sleep.suspensiondetector.BaseModeDetector
    public void doStart() {
        if (isScreenOn()) {
            startAccelerometer();
        }
    }

    @Override // com.urbandroid.sleep.suspensiondetector.ISingleModeDetector
    public SuspensionSupportDetector.SuspendSupport getMode() {
        return SuspensionSupportDetector.SuspendSupport.WORKS;
    }

    @Override // com.urbandroid.sleep.suspensiondetector.BaseModeDetector
    public String getName() {
        return "StandardModeDetector";
    }

    @Override // com.urbandroid.sleep.suspensiondetector.BaseModeDetector, com.urbandroid.sleep.suspensiondetector.ISingleModeDetector
    public synchronized void onScreenOn() {
        super.onScreenOn();
        if (!isAccelStarted()) {
            Logger.logInfo("Starting delayed accel in screen on mode");
            new Handler().postDelayed(new Runnable() { // from class: com.urbandroid.sleep.suspensiondetector.StandardModeDetector.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (StandardModeDetector.this) {
                        try {
                            if (StandardModeDetector.this.isScreenOn() && !StandardModeDetector.this.isAccelStarted()) {
                                StandardModeDetector.this.startAccelerometer();
                                Logger.logInfo("Starting delayed accel in screen on mode");
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }, 5000L);
        }
    }
}
