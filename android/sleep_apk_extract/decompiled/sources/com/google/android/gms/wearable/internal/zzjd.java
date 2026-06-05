package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzjd {
    public static IntentFilter zza(String str) {
        IntentFilter intentFilter = new IntentFilter(str);
        intentFilter.addDataScheme("wear");
        intentFilter.addDataAuthority("*", null);
        return intentFilter;
    }
}
