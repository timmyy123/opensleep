package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaff extends zzzg implements zzaar {
    private static final zzaff zzc;
    private static volatile zzaay zzd;
    private int zza;
    private int zzb;

    static {
        zzaff zzaffVar = new zzaff();
        zzc = zzaffVar;
        zzzg.registerDefaultInstance(zzaff.class, zzaffVar);
    }

    private zzaff() {
    }

    public static zzaff zzb(byte[] bArr) {
        return (zzaff) zzzg.parseFrom(zzc, bArr);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzc, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzaff();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzafd(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zzd;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzaff.class) {
            try {
                zzyzVar = zzd;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zzc);
                    zzd = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }

    public final zzafe zza() {
        int i = this.zzb;
        zzafe zzafeVar = i != 0 ? i != 1 ? i != 2 ? null : zzafe.CONNECTED : zzafe.NOT_CONNECTED : zzafe.UNKNOWN;
        return zzafeVar == null ? zzafe.UNRECOGNIZED : zzafeVar;
    }
}
