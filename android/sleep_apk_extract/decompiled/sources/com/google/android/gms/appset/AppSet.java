package com.google.android.gms.appset;

import android.content.Context;
import com.google.android.gms.internal.appset.zzr;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AppSet {
    public static AppSetIdClient getClient(Context context) {
        return new zzr(context);
    }
}
