package com.google.android.gms.vision.clearcut;

/* JADX INFO: loaded from: classes4.dex */
public final class zzb {
    private final Object zzb = new Object();
    private long zzc = Long.MIN_VALUE;
    private final long zza = Math.round(30000.0d);

    public zzb(double d) {
    }

    public final boolean zza() {
        synchronized (this.zzb) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.zzc + this.zza > jCurrentTimeMillis) {
                    return false;
                }
                this.zzc = jCurrentTimeMillis;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
