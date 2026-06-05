package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zziid extends zziee implements zzifq {
    private static final zziid zze;
    private static volatile zzifx zzf;
    private int zza;
    private int zzb;
    private long zzc;
    private zzida zzd = zzida.zza;

    static {
        zziid zziidVar = new zziid();
        zze = zziidVar;
        zziee.zzbu(zziid.class, zziidVar);
    }

    private zziid() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zze, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ည\u0002", new Object[]{"zza", "zzb", zziic.zza, "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zziid();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zziib(bArr);
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
        synchronized (zziid.class) {
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
