package com.urbandroid.sleep.suspensiondetector;

import com.urbandroid.sleep.SuspensionSupportDetector;
import com.urbandroid.sleep.sensor.AccelManager;

/* JADX INFO: loaded from: classes4.dex */
public class DelayNormalModeDetector extends AfterScreenOffModeDetector {
    public DelayNormalModeDetector(AccelManager accelManager) {
        super(accelManager);
    }

    @Override // com.urbandroid.sleep.suspensiondetector.AfterScreenOffModeDetector, com.urbandroid.sleep.suspensiondetector.ISingleModeDetector
    public SuspensionSupportDetector.SuspendSupport getMode() {
        return SuspensionSupportDetector.SuspendSupport.WORKS_WITH_DELAY_NORMAL;
    }

    @Override // com.urbandroid.sleep.suspensiondetector.AfterScreenOffModeDetector, com.urbandroid.sleep.suspensiondetector.BaseModeDetector
    public String getName() {
        return "DelayNormalModeDetector";
    }

    @Override // com.urbandroid.sleep.suspensiondetector.BaseModeDetector
    public int getSensorDelay() {
        return 3;
    }
}
