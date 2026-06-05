package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhry extends zziee implements zzifq {
    private static final zzhry zzf;
    private static volatile zzifx zzg;
    private int zza;
    private int zzb;
    private zzhru zzc;
    private zzida zzd;
    private zzida zze;

    static {
        zzhry zzhryVar = new zzhry();
        zzf = zzhryVar;
        zziee.zzbu(zzhry.class, zzhryVar);
    }

    private zzhry() {
        zzida zzidaVar = zzida.zza;
        this.zzd = zzidaVar;
        this.zze = zzidaVar;
    }

    public static zzhry zze(zzida zzidaVar, zzido zzidoVar) {
        return (zzhry) zziee.zzbT(zzf, zzidaVar, zzidoVar);
    }

    public static zzhrx zzg() {
        return (zzhrx) zzf.zzbn();
    }

    public static zzhry zzh() {
        return zzf;
    }

    public static zzifx zzi() {
        return zzf.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhru zzb() {
        zzhru zzhruVar = this.zzc;
        return zzhruVar == null ? zzhru.zzc() : zzhruVar;
    }

    public final zzida zzc() {
        return this.zzd;
    }

    public final zzida zzd() {
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
            return zziee.zzbv(zzf, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzhry();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhrx(bArr);
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
        synchronized (zzhry.class) {
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

    public final /* synthetic */ void zzj(zzhru zzhruVar) {
        zzhruVar.getClass();
        this.zzc = zzhruVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzk(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzd = zzidaVar;
    }

    public final /* synthetic */ void zzl(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zze = zzidaVar;
    }
}
