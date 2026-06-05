package com.urbandroid.sleep.suspensiondetector;

import com.urbandroid.sleep.SuspensionSupportDetector;

/* JADX INFO: loaded from: classes4.dex */
public interface ISingleModeDetector {
    SuspensionSupportDetector.SuspendSupport getMode();

    void interrupt();

    Boolean isSupported();

    void onScreenOff();

    void onScreenOn();

    void start(boolean z);
}
