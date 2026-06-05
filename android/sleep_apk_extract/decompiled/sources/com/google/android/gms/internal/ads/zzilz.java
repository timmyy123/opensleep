package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzilz extends zziee implements zzifq {
    private static final zzilz zzd;
    private static volatile zzifx zze;
    private int zza;
    private String zzb = "";
    private zzieq zzc = zziee.zzbM();

    static {
        zzilz zzilzVar = new zzilz();
        zzd = zzilzVar;
        zziee.zzbu(zzilz.class, zzilzVar);
    }

    private zzilz() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zza", "zzb", "zzc", zzilx.class});
        }
        if (iOrdinal == 3) {
            return new zzilz();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzily(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zze;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzilz.class) {
            try {
                zzidzVar = zze;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzd);
                    zze = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
