package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcz {
    public static final Handler zza = new Handler(Looper.getMainLooper());
    public static final Executor zzb = new zzcy("Google consent worker");

    public static void zza() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Method must be call on main thread.");
    }
}
