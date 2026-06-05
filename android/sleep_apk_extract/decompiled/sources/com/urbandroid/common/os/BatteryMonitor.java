package com.urbandroid.common.os;

/* JADX INFO: loaded from: classes5.dex */
public class BatteryMonitor {
    private boolean alreadyFired = false;
    private final Runnable excessAction;
    private final int temperatureThreshold;

    public BatteryMonitor(int i, Runnable runnable) {
        this.temperatureThreshold = i * 10;
        this.excessAction = runnable;
    }
}
