package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzikr extends zziee implements zzifq {
    private static final zzikr zzh;
    private static volatile zzifx zzi;
    private int zza;
    private int zzb;
    private int zze;
    private String zzc = "";
    private zziem zzd = zziee.zzbC();
    private zzieq zzf = zziee.zzbM();
    private zzida zzg = zzida.zza;

    static {
        zzikr zzikrVar = new zzikr();
        zzh = zzikrVar;
        zziee.zzbu(zzikr.class, zzikrVar);
    }

    private zzikr() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzh, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0002\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u0016\u0005င\u0002\u0006\u001b\u0007ည\u0003", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", zzikp.class, "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzikr();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzikq(bArr);
        }
        if (iOrdinal == 5) {
            return zzh;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzi;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzikr.class) {
            try {
                zzidzVar = zzi;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzh);
                    zzi = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
