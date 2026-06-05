package com.google.android.gms.common.util;

import android.os.StrictMode;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzc {
    public static StrictMode.VmPolicy.Builder zza(StrictMode.VmPolicy.Builder builder) {
        return builder.permitUnsafeIntentLaunch();
    }
}
