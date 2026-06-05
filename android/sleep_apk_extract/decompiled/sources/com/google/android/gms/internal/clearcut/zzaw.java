package com.google.android.gms.internal.clearcut;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzaw {
    private static final Class<?> zzfb = zze("libcore.io.Memory");
    private static final boolean zzfc;

    static {
        zzfc = zze("org.robolectric.Robolectric") != null;
    }

    private static <T> Class<T> zze(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zzx() {
        return (zzfb == null || zzfc) ? false : true;
    }

    public static Class<?> zzy() {
        return zzfb;
    }
}
