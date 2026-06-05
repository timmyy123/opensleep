package com.urbandroid.sleep;

import com.urbandroid.sleep.service.awake.AwakeDetector;

/* JADX INFO: loaded from: classes4.dex */
public interface ISleepService {
    void doExplicitRecording();

    AwakeDetector getAwakeDetector();

    long getRemainingPauseMillis();

    boolean isAwakePaused();

    boolean isDisabled();

    boolean isUsingSmartwatch();

    void pauseTracking(long j);

    void postponeAwake();

    void resumeTracking();

    void saveAndInvalidateRecord(boolean z);

    void setDimStatus(boolean z);

    void setDisabled(boolean z);

    void toggleSmartLight();
}
