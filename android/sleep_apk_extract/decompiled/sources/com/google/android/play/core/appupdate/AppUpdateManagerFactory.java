package com.google.android.play.core.appupdate;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public final class AppUpdateManagerFactory {
    private AppUpdateManagerFactory() {
    }

    public static AppUpdateManager create(Context context) {
        return zzb.zza(context).zza();
    }
}
