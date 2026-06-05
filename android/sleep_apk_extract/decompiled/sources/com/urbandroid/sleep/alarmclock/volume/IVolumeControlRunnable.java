package com.urbandroid.sleep.alarmclock.volume;

/* JADX INFO: loaded from: classes4.dex */
public interface IVolumeControlRunnable extends Runnable {
    float getVolume();

    void mute();

    void renewVibration();

    void reset();

    void resume();

    void suspend(int i, boolean z);
}
