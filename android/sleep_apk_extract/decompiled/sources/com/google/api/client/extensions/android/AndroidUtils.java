package com.google.api.client.extensions.android;

import android.os.Build;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AndroidUtils {
    public static boolean isMinimumSdkLevel(int i) {
        return Build.VERSION.SDK_INT >= i;
    }
}
