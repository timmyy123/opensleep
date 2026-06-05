package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhsb extends zziee implements zzifq {
    private static final zzhsb zzb;
    private static volatile zzifx zzc;
    private int zza;

    static {
        zzhsb zzhsbVar = new zzhsb();
        zzb = zzhsbVar;
        zziee.zzbu(zzhsb.class, zzhsbVar);
    }

    private zzhsb() {
    }

    public static zzhsb zzb(zzida zzidaVar, zzido zzidoVar) {
        return (zzhsb) zziee.zzbT(zzb, zzidaVar, zzidoVar);
    }

    public static zzhsb zzc() {
        return zzb;
    }

    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzhsb();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhsa(bArr);
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
        synchronized (zzhsb.class) {
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
