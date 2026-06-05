package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.SystemClock;
import java.io.File;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzry {
    public static File zza(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir;
        }
        SystemClock.sleep(100L);
        File filesDir2 = context.getFilesDir();
        if (filesDir2 != null) {
            return filesDir2;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("getFilesDir returned null twice.");
        return null;
    }
}
