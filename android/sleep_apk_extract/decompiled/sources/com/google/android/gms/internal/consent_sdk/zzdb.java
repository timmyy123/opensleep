package com.google.android.gms.internal.consent_sdk;

import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzdb {
    public static boolean zza(boolean z) {
        if (Build.VERSION.SDK_INT < 31) {
            return Build.DEVICE.startsWith("generic");
        }
        String str = Build.FINGERPRINT;
        return str.contains("generic") || str.contains("emulator") || Build.HARDWARE.contains("ranchu");
    }
}
