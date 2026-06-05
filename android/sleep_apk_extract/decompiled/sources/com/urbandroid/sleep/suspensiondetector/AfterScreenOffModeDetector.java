package com.urbandroid.sleep.suspensiondetector;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SuspensionSupportDetector;
import com.urbandroid.sleep.sensor.AccelManager;

/* JADX INFO: loaded from: classes5.dex */
public class AfterScreenOffModeDetector extends BaseModeDetector {
    public AfterScreenOffModeDetector(AccelManager accelManager) {
        super(accelManager);
    }

    private void delayedStartMeasuring() {
        getHandler().postDelayed(new Runnable() { // from class: com.urbandroid.sleep.suspensiondetector.AfterScreenOffModeDetector.1
            @Override // java.lang.Runnable
            public void run() {
                if (AfterScreenOffModeDetector.this.isScreenOn() || AfterScreenOffModeDetector.this.isAccelStarted()) {
                    return;
                }
                AfterScreenOffModeDetector.this.startAccelerometer();
                Logger.logInfo("AfterScreenOffModeDetector starting delayed accel in screen off mode");
                AfterScreenOffModeDetector.this.startNewMeasuring();
            }
        }, 10000L);
    }

    @Override // com.urbandroid.sleep.suspensiondetector.BaseModeDetector
    public void doStart() {
        if (isScreenOn()) {
            return;
        }
        delayedStartMeasuring();
    }

    @Override // com.urbandroid.sleep.suspensiondetector.ISingleModeDetector
    public SuspensionSupportDetector.SuspendSupport getMode() {
        return SuspensionSupportDetector.SuspendSupport.WORKS_WITH_START_AFTER_SCREEN_OFF;
    }

    @Override // com.urbandroid.sleep.suspensiondetector.BaseModeDetector
    public String getName() {
        return "AfterScreenOffModeDetector";
    }

    @Override // com.urbandroid.sleep.suspensiondetector.BaseModeDetector, com.urbandroid.sleep.suspensiondetector.ISingleModeDetector
    public synchronized void onScreenOff() {
        super.onScreenOff();
        if (!isAccelStarted()) {
            delayedStartMeasuring();
        }
    }

    @Override // com.urbandroid.sleep.suspensiondetector.BaseModeDetector, com.urbandroid.sleep.suspensiondetector.ISingleModeDetector
    public synchronized void onScreenOn() {
        super.onScreenOn();
        stopAccelerometer();
    }
}
