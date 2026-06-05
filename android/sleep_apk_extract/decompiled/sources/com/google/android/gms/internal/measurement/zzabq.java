package com.google.android.gms.internal.measurement;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzabq {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzabu zzb;

    static {
        zzabu zzabvVar;
        int i = 0;
        while (true) {
            if (i >= 2) {
                zzabvVar = new zzabv();
                break;
            }
            zzabvVar = null;
            try {
                zzabvVar = (zzabu) Class.forName(zza[i]).asSubclass(zzabu.class).getDeclaredConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
            if (zzabvVar != null) {
                break;
            } else {
                i++;
            }
        }
        zzb = zzabvVar;
    }

    public static StackTraceElement[] zzb(Class cls, int i, int i2) {
        if (i > 0 || i == -1) {
            return zzb.zzb(cls, i, 2);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("invalid maximum depth: 0");
        return null;
    }
}
