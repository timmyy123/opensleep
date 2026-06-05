package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zziio extends zziee implements zzifq {
    private static final zziio zzc;
    private static volatile zzifx zzd;
    private int zza;
    private zzida zzb = zzida.zza;

    static {
        zziio zziioVar = new zziio();
        zzc = zziioVar;
        zziee.zzbu(zziio.class, zziioVar);
    }

    private zziio() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzc, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ည\u0000", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zziio();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zziin(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzd;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zziio.class) {
            try {
                zzidzVar = zzd;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzc);
                    zzd = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
