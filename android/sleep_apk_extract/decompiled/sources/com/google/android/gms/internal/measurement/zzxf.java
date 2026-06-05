package com.google.android.gms.internal.measurement;

import android.os.SystemClock;
import com.google.common.base.Ticker;

/* JADX INFO: loaded from: classes3.dex */
final class zzxf extends Ticker {
    @Override // com.google.common.base.Ticker
    public final long read() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
