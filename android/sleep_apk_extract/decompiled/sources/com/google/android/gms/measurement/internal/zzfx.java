package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class zzfx {
    private static final Object zze = new Object();
    private final String zza;
    private final zzbo zzb;
    private final Object zzc;
    private final Object zzd = new Object();
    private volatile Object zzf = null;
    private volatile Object zzg = null;

    public /* synthetic */ zzfx(String str, Object obj, Object obj2, zzbo zzboVar, byte[] bArr) {
        this.zza = str;
        this.zzc = obj;
        this.zzb = zzboVar;
    }

    public final String zza() {
        return this.zza;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzb(Object obj) {
        zzbo zzboVar;
        synchronized (this.zzd) {
        }
        if (obj != null) {
            return obj;
        }
        if (zzfr.zza == null) {
            return this.zzc;
        }
        synchronized (zze) {
            try {
                if (zzae.zza()) {
                    return this.zzg == null ? this.zzc : this.zzg;
                }
                try {
                } catch (SecurityException unused) {
                }
                for (zzfx zzfxVar : zzfy.zzbk) {
                    if (zzae.zza()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    Object objZza = null;
                    try {
                        zzbo zzboVar2 = zzfxVar.zzb;
                        if (zzboVar2 != null) {
                            objZza = zzboVar2.zza();
                        }
                    } catch (IllegalStateException unused2) {
                    }
                    synchronized (zze) {
                        zzfxVar.zzg = objZza;
                    }
                    zzboVar = this.zzb;
                    if (zzboVar != null) {
                        try {
                            return zzboVar.zza();
                        } catch (IllegalStateException | SecurityException unused3) {
                        }
                    }
                    return this.zzc;
                }
                zzboVar = this.zzb;
                if (zzboVar != null) {
                }
                return this.zzc;
            } finally {
            }
        }
    }
}
