package com.google.android.gms.common.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Preconditions {
    public static void checkArgument(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkHandlerThread(Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + String.valueOf(name2).length() + 35 + 1);
            FileInsert$$ExternalSyntheticOutline0.m(sb, "Must be called on ", name2, " thread, but got ", name);
            FacebookSdk$$ExternalSyntheticLambda1.m(sb, (Object) ".");
        }
    }

    public static void checkMainThread(String str) {
        if (com.google.android.gms.common.util.zze.zza()) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(str);
    }

    public static String checkNotEmpty(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    public static void checkNotGoogleApiHandlerThread(String str) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null || !java.util.Objects.equals(looperMyLooper.getThread().getName(), "GoogleApiHandler")) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(str);
    }

    public static void checkNotMainThread(String str) {
        if (com.google.android.gms.common.util.zze.zza()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(str);
        }
    }

    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static long checkNotZero(long j) {
        if (j != 0) {
            return j;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Given Long is zero");
        return 0L;
    }

    public static void checkState(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkNotMainThread() {
        checkNotMainThread("Must not be called on the main application thread");
    }

    public static void checkArgument(boolean z) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3();
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("null reference");
        return null;
    }

    public static void checkState(boolean z) {
        if (z) {
            return;
        }
        Home$$ExternalSyntheticBUOutline0.m$2();
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static int checkNotZero(int i, Object obj) {
        if (i != 0) {
            return i;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static int checkNotZero(int i) {
        if (i != 0) {
            return i;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Given Integer is zero");
        return 0;
    }

    public static String checkNotEmpty(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Given String is empty or null");
        return null;
    }

    public static void checkNotGoogleApiHandlerThread() {
        checkNotGoogleApiHandlerThread("Must not be called on GoogleApiHandler thread.");
    }

    public static void checkHandlerThread(Handler handler, String str) {
        if (Looper.myLooper() == handler.getLooper()) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(str);
    }
}
