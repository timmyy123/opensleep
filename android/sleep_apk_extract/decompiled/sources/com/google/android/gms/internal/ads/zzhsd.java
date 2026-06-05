package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhsd extends zziee implements zzifq {
    private static final zzhsd zze;
    private static volatile zzifx zzf;
    private int zza;
    private int zzb;
    private zzida zzc = zzida.zza;
    private zzhsf zzd;

    static {
        zzhsd zzhsdVar = new zzhsd();
        zze = zzhsdVar;
        zziee.zzbu(zzhsd.class, zzhsdVar);
    }

    private zzhsd() {
    }

    public static zzhsd zzd(zzida zzidaVar, zzido zzidoVar) {
        return (zzhsd) zziee.zzbT(zze, zzidaVar, zzidoVar);
    }

    public static zzhsc zze() {
        return (zzhsc) zze.zzbn();
    }

    public static zzifx zzg() {
        return zze.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzida zzb() {
        return this.zzc;
    }

    public final zzhsf zzc() {
        zzhsf zzhsfVar = this.zzd;
        return zzhsfVar == null ? zzhsf.zze() : zzhsfVar;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhsd();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhsc(bArr);
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
        synchronized (zzhsd.class) {
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

    public final /* synthetic */ void zzh(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzc = zzidaVar;
    }

    public final /* synthetic */ void zzi(zzhsf zzhsfVar) {
        zzhsfVar.getClass();
        this.zzd = zzhsfVar;
        this.zza |= 1;
    }
}
