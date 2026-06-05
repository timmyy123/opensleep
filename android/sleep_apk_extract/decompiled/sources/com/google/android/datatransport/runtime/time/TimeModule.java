package com.google.android.datatransport.runtime.time;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TimeModule {
    public static Clock eventClock() {
        return new WallTimeClock();
    }

    public static Clock uptimeClock() {
        return new UptimeClock();
    }
}
