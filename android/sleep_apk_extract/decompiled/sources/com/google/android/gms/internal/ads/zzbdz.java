package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbdz extends zziee implements zzifq {
    private static final zzbdz zzf;
    private static volatile zzifx zzg;
    private int zza;
    private zzbed zzb;
    private zzida zzc = zzida.zza;
    private long zzd;
    private long zze;

    static {
        zzbdz zzbdzVar = new zzbdz();
        zzf = zzbdzVar;
        zziee.zzbu(zzbdz.class, zzbdzVar);
    }

    private zzbdz() {
    }

    public static zzbdz zzd() {
        return zzf;
    }

    public final zzbed zza() {
        zzbed zzbedVar = this.zzb;
        return zzbedVar == null ? zzbed.zzc() : zzbedVar;
    }

    public final zzida zzb() {
        return this.zzc;
    }

    public final long zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzf, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ဂ\u0002\u0004ဂ\u0003", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzbdz();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzbdy(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzg;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbdz.class) {
            try {
                zzidzVar = zzg;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzf);
                    zzg = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
