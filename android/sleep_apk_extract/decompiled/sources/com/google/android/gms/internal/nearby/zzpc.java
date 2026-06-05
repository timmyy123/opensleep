package com.google.android.gms.internal.nearby;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzpc {
    private static zzpb zza;

    public static synchronized zzpb zza() {
        try {
            if (zza == null) {
                zzb(new zzpg());
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }

    public static synchronized void zzb(zzpb zzpbVar) {
        if (zza != null) {
            throw new IllegalStateException("init() already called");
        }
        zza = zzpbVar;
    }
}
