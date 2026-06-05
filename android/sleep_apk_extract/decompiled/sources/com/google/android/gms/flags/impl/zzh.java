package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzh extends zza<String> {
    public static String zza(SharedPreferences sharedPreferences, String str, String str2) {
        try {
            return (String) com.google.android.gms.internal.flags.zze.zza(new zzi(sharedPreferences, str, str2));
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
            return str2;
        }
    }
}
