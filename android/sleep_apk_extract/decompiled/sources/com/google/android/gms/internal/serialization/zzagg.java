package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes4.dex */
public final class zzagg extends zzzg implements zzaar {
    private static final zzagg zze;
    private static volatile zzaay zzf;
    private int zza;
    private int zzb;
    private int zzc;
    private int zzd;

    static {
        zzagg zzaggVar = new zzagg();
        zze = zzaggVar;
        zzzg.registerDefaultInstance(zzagg.class, zzaggVar);
    }

    private zzagg() {
    }

    public static zzagg zzg() {
        return zze;
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zze, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\u0004\u0004\u0004", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzagg();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzagf(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zzf;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzagg.class) {
            try {
                zzyzVar = zzf;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zze);
                    zzf = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }
}
