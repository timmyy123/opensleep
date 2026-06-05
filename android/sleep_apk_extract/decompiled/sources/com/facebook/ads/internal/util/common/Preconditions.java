package com.facebook.ads.internal.util.common;

import android.os.Looper;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public final class Preconditions {
    public static void checkIsOnMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        Types$$ExternalSyntheticBUOutline0.m$2("Must be called from the UiThread");
    }

    public static void checkIsTrue(boolean z, String str) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(str);
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(str);
        return null;
    }
}
