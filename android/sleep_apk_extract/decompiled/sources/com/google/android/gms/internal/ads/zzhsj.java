package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhsj extends zziee implements zzifq {
    private static final zzhsj zze;
    private static volatile zzifx zzf;
    private int zza;
    private int zzb;
    private zzhsn zzc;
    private zzida zzd = zzida.zza;

    static {
        zzhsj zzhsjVar = new zzhsj();
        zze = zzhsjVar;
        zziee.zzbu(zzhsj.class, zzhsjVar);
    }

    private zzhsj() {
    }

    public static zzhsj zzd(zzida zzidaVar, zzido zzidoVar) {
        return (zzhsj) zziee.zzbT(zze, zzidaVar, zzidoVar);
    }

    public static zzhsi zze() {
        return (zzhsi) zze.zzbn();
    }

    public static zzhsj zzg() {
        return zze;
    }

    public static zzifx zzh() {
        return zze.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhsn zzb() {
        zzhsn zzhsnVar = this.zzc;
        return zzhsnVar == null ? zzhsn.zzd() : zzhsnVar;
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
            return zziee.zzbv(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhsj();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhsi(bArr);
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
        synchronized (zzhsj.class) {
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

    public final /* synthetic */ void zzi(zzhsn zzhsnVar) {
        zzhsnVar.getClass();
        this.zzc = zzhsnVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzj(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzd = zzidaVar;
    }
}
