package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaga extends zzzg implements zzaar {
    private static final zzaga zze;
    private static volatile zzaay zzf;
    private int zza;
    private int zzb;
    private int zzc;
    private String zzd = "";

    static {
        zzaga zzagaVar = new zzaga();
        zze = zzagaVar;
        zzzg.registerDefaultInstance(zzaga.class, zzagaVar);
    }

    private zzaga() {
    }

    public static zzaga zzd() {
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
            return zzzg.newMessageInfo(zze, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003ለ\u0000", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzaga();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzafz(bArr);
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
        synchronized (zzaga.class) {
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
        return this.zzb;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zzd;
    }
}
