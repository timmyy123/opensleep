package com.urbandroid.common.util;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ThreadUtil {
    public static boolean isInUiThread() {
        return Thread.currentThread().getName().equals("main");
    }
}
