package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhsl extends zziee implements zzifq {
    private static final zzhsl zze;
    private static volatile zzifx zzf;
    private int zza;
    private zzhsn zzb;
    private int zzc;
    private int zzd;

    static {
        zzhsl zzhslVar = new zzhsl();
        zze = zzhslVar;
        zziee.zzbu(zzhsl.class, zzhslVar);
    }

    private zzhsl() {
    }

    public static zzhsl zzd(zzida zzidaVar, zzido zzidoVar) {
        return (zzhsl) zziee.zzbT(zze, zzidaVar, zzidoVar);
    }

    public static zzhsk zze() {
        return (zzhsk) zze.zzbn();
    }

    public static zzhsl zzg() {
        return zze;
    }

    public final zzhsn zza() {
        zzhsn zzhsnVar = this.zzb;
        return zzhsnVar == null ? zzhsn.zzd() : zzhsnVar;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final int zzc() {
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
            return zziee.zzbv(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhsl();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhsk(bArr);
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
        synchronized (zzhsl.class) {
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

    public final /* synthetic */ void zzh(zzhsn zzhsnVar) {
        zzhsnVar.getClass();
        this.zzb = zzhsnVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzi(int i) {
        this.zzc = i;
    }
}
