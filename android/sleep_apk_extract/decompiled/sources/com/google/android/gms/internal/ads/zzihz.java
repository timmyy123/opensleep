package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzihz extends zziee implements zzifq {
    private static final zzihz zzb;
    private static volatile zzifx zzc;
    private zzieq zza = zziee.zzbM();

    static {
        zzihz zzihzVar = new zzihz();
        zzb = zzihzVar;
        zziee.zzbu(zzihz.class, zzihzVar);
    }

    private zzihz() {
    }

    public static zzihy zzc() {
        return (zzihy) zzb.zzbn();
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzihx.class});
        }
        if (iOrdinal == 3) {
            return new zzihz();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzihy(bArr);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzc;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzihz.class) {
            try {
                zzidzVar = zzc;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzb);
                    zzc = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
