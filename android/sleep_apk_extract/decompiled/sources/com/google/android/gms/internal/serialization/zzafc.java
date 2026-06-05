package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzafc extends zzzg implements zzaar {
    private static final zzafc zzd;
    private static volatile zzaay zze;
    private int zza;
    private String zzb = "";
    private zzadb zzc;

    static {
        zzafc zzafcVar = new zzafc();
        zzd = zzafcVar;
        zzzg.registerDefaultInstance(zzafc.class, zzafcVar);
    }

    private zzafc() {
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzd, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzafc();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzafb(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zze;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzafc.class) {
            try {
                zzyzVar = zze;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zzd);
                    zze = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }
}
