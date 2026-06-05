package com.google.android.gms.internal.clearcut;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzcy {
    private static final zzcy zzlt;
    private static final zzcy zzlu;

    static {
        zzcz zzczVar = null;
        zzlt = new zzda();
        zzlu = new zzdb();
    }

    private zzcy() {
    }

    public static zzcy zzbv() {
        return zzlt;
    }

    public static zzcy zzbw() {
        return zzlu;
    }

    public abstract void zza(Object obj, long j);

    public abstract <L> void zza(Object obj, Object obj2, long j);
}
