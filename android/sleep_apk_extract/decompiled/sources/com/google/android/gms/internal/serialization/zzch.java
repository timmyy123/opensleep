package com.google.android.gms.internal.serialization;

import android.os.Build;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzch {
    public static boolean zza() {
        return Build.VERSION.SDK_INT >= 27;
    }

    public static ApiException zzb() {
        return new ApiException(new Status(10, "API is not supported on this platform. Requires API 27 or higher."));
    }
}
