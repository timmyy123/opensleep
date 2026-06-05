package com.google.android.gms.common.util;

import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zze {
    public static boolean zza() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
