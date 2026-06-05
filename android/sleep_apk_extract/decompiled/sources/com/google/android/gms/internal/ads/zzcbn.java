package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcbn extends ContextWrapper {
    public static Context zza(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }
}
