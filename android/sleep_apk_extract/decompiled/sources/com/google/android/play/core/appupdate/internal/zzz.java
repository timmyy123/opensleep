package com.google.android.play.core.appupdate.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public final class zzz {
    public static Context zza(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }
}
