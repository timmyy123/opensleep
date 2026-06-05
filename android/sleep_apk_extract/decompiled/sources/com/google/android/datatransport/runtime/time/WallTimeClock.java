package com.google.android.datatransport.runtime.time;

/* JADX INFO: loaded from: classes3.dex */
public class WallTimeClock implements Clock {
    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return System.currentTimeMillis();
    }
}
