package com.google.android.gms.internal.measurement;

import java.util.concurrent.Executor;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzlz {
    public static final void zza(Level level, Executor executor, String str, Object... objArr) {
        zzc(level, executor, null, str, objArr);
    }

    public static final void zzb(Level level, Executor executor, Throwable th, String str, Object... objArr) {
        zzc(level, executor, th, str, objArr);
    }

    private static final void zzc(final Level level, Executor executor, final Throwable th, final String str, final Object... objArr) {
        executor.execute(zzxa.zza(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzly
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                ((zzxp) ((zzxp) zzlx.zza.zze(level).zzo(th)).zzn("com/google/android/libraries/phenotype/client/Phlogger", "logInternal", 44, "Phlogger.java")).zzp(str, objArr);
            }
        }));
    }
}
