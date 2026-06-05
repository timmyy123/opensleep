package com.samsung.android.sdk.internal.healthdata;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ErrorUtil {
    public static String getRemoteExceptionMessage(Exception exc) {
        return "A remote-invocation error occurs on the connection: " + exc.toString();
    }
}
