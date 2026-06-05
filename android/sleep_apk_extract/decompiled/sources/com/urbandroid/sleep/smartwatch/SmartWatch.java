package com.urbandroid.sleep.smartwatch;

import com.urbandroid.sleep.sensor.IAccelManager;

/* JADX INFO: loaded from: classes5.dex */
public interface SmartWatch {
    IAccelManager getAccelManager();

    String getPlatform();

    void hint(int i);

    void setBatchSize(int i);

    void setSuspended(boolean z);

    void startAlarm(int i);

    void startTracking(SmartWatchListener smartWatchListener);

    void stopAlarm();

    void stopTracking();

    void updateAlarm(long j);

    void updatePause(long j);
}
