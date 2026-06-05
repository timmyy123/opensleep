package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class zziji extends zziee implements zzifq {
    private static final zziji zze;
    private static volatile zzifx zzf;
    private int zza;
    private int zzb;
    private zzijh zzc;
    private zzijh zzd;

    static {
        zziji zzijiVar = new zziji();
        zze = zzijiVar;
        zziee.zzbu(zziji.class, zzijiVar);
    }

    private zziji() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zze, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zza", "zzb", zzijf.zza, "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zziji();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzije(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzf;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zziji.class) {
            try {
                zzidzVar = zzf;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zze);
                    zzf = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
