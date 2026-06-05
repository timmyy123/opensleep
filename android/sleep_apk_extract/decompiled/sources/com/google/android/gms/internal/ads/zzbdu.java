package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbdu extends zziee implements zzifq {
    private static final zzbdu zze;
    private static volatile zzifx zzf;
    private int zza;
    private zzbeb zzb;
    private zzida zzc;
    private zzida zzd;

    static {
        zzbdu zzbduVar = new zzbdu();
        zze = zzbduVar;
        zziee.zzbu(zzbdu.class, zzbduVar);
    }

    private zzbdu() {
        zzida zzidaVar = zzida.zza;
        this.zzc = zzidaVar;
        this.zzd = zzidaVar;
    }

    public static zzbdu zzd(zzida zzidaVar, zzido zzidoVar) {
        return (zzbdu) zziee.zzbT(zze, zzidaVar, zzidoVar);
    }

    public static zzbdu zze(byte[] bArr, zzido zzidoVar) {
        return (zzbdu) zziee.zzbV(zze, bArr, zzidoVar);
    }

    public final zzbeb zza() {
        zzbeb zzbebVar = this.zzb;
        return zzbebVar == null ? zzbeb.zzj() : zzbebVar;
    }

    public final zzida zzb() {
        return this.zzc;
    }

    public final zzida zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zze, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzbdu();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzbdt(bArr);
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
        synchronized (zzbdu.class) {
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
