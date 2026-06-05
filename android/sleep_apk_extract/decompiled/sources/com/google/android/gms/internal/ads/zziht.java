package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zziht extends zziee implements zzifq {
    private static final zziht zzc;
    private static volatile zzifx zzd;
    private zziem zza = zziee.zzbC();
    private zziem zzb = zziee.zzbC();

    static {
        zziht zzihtVar = new zziht();
        zzc = zzihtVar;
        zziee.zzbu(zziht.class, zzihtVar);
    }

    private zziht() {
    }

    public static zziht zzc(byte[] bArr, zzido zzidoVar) {
        return (zziht) zziee.zzbV(zzc, bArr, zzidoVar);
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzc, "\u0004\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0002\u0000\u0001\u0016\u0003\u0016", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zziht();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzihs(bArr);
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
        synchronized (zziht.class) {
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
