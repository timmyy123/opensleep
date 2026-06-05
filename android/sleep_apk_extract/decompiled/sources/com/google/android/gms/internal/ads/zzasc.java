package com.google.android.gms.internal.ads;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzasc {
    public static void zza(String str, String str2) {
        if (Log.isLoggable("InstallReferrerClient", 2)) {
            Log.v("InstallReferrerClient", str2);
        }
    }

    public static void zzb(String str, String str2) {
        if (Log.isLoggable("InstallReferrerClient", 5)) {
            Log.w("InstallReferrerClient", str2);
        }
    }
}
