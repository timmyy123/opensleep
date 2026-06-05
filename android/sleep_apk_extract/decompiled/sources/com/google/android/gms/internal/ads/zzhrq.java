package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhrq extends zziee implements zzifq {
    private static final zzhrq zza;
    private static volatile zzifx zzb;

    static {
        zzhrq zzhrqVar = new zzhrq();
        zza = zzhrqVar;
        zziee.zzbu(zzhrq.class, zzhrqVar);
    }

    private zzhrq() {
    }

    public static zzhrq zza(zzida zzidaVar, zzido zzidoVar) {
        return (zzhrq) zziee.zzbT(zza, zzidaVar, zzidoVar);
    }

    public static zzhrq zzb() {
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        byte[] bArr = null;
        if (iOrdinal == 2) {
            return zziee.zzbv(zza, "\u0000\u0000", null);
        }
        if (iOrdinal == 3) {
            return new zzhrq();
        }
        if (iOrdinal == 4) {
            return new zzhrp(bArr);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzb;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzhrq.class) {
            try {
                zzidzVar = zzb;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zza);
                    zzb = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
