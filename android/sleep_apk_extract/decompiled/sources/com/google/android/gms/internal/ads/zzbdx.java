package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbdx extends zziee implements zzifq {
    private static final zzbdx zzd;
    private static volatile zzifx zze;
    private int zza;
    private zzbdz zzb;
    private zzida zzc = zzida.zza;

    static {
        zzbdx zzbdxVar = new zzbdx();
        zzd = zzbdxVar;
        zziee.zzbu(zzbdx.class, zzbdxVar);
    }

    private zzbdx() {
    }

    public static zzbdx zze() {
        return zzd;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final zzbdz zzb() {
        zzbdz zzbdzVar = this.zzb;
        return zzbdzVar == null ? zzbdz.zzd() : zzbdzVar;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final zzida zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzd, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzbdx();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzbdw(bArr);
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
        synchronized (zzbdx.class) {
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
