package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzls {
    private static final Object zza = new Object();
    private static volatile zzlr zzc = null;
    private static volatile boolean zzd = false;
    private static volatile zzlr zze;

    public static void zza() {
        zzd = true;
    }

    public static boolean zzb() {
        synchronized (zza) {
        }
        return false;
    }

    public static void zzc() {
        if (zze == null) {
            zze = new zzlr(null);
        }
    }

    public static void zzd() {
        if (zzc == null) {
            zzc = new zzlr(null);
        }
    }
}
