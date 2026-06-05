package com.google.android.gms.internal.measurement;

import android.os.SystemClock;
import com.google.common.base.Ticker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzxh {
    private static final Ticker zza;

    static {
        Ticker zzxgVar;
        try {
            SystemClock.elapsedRealtimeNanos();
            zzxgVar = new zzxf();
        } catch (Throwable unused) {
            SystemClock.elapsedRealtime();
            zzxgVar = new zzxg();
        }
        zza = zzxgVar;
    }

    public static Ticker zza() {
        return zza;
    }
}
