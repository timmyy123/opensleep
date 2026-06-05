package com.google.android.datatransport.runtime.logging;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Logging {
    private static String concatTag(String str, String str2) {
        String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(str, str2);
        return strM$1.length() > 23 ? strM$1.substring(0, 23) : strM$1;
    }

    public static void d(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format(str2, obj));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 6)) {
            Log.e(tag, str2, th);
        }
    }

    private static String getTag(String str) {
        return Build.VERSION.SDK_INT < 26 ? concatTag("TRuntime.", str) : FileInsert$$ExternalSyntheticOutline0.m("TRuntime.", str);
    }

    public static void i(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 4)) {
            Log.i(tag, String.format(str2, obj));
        }
    }

    public static void w(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 5)) {
            Log.w(tag, String.format(str2, obj));
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format(str2, objArr));
        }
    }
}
