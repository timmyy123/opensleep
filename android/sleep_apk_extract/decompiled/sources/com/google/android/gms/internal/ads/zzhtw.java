package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhtw extends zziee implements zzifq {
    private static final zzhtw zzf;
    private static volatile zzifx zzg;
    private int zza;
    private int zzb;
    private zzhts zzc;
    private zzida zzd;
    private zzida zze;

    static {
        zzhtw zzhtwVar = new zzhtw();
        zzf = zzhtwVar;
        zziee.zzbu(zzhtw.class, zzhtwVar);
    }

    private zzhtw() {
        zzida zzidaVar = zzida.zza;
        this.zzd = zzidaVar;
        this.zze = zzidaVar;
    }

    public static zzhtw zze(zzida zzidaVar, zzido zzidoVar) {
        return (zzhtw) zziee.zzbT(zzf, zzidaVar, zzidoVar);
    }

    public static zzhtv zzg() {
        return (zzhtv) zzf.zzbn();
    }

    public static zzhtw zzh() {
        return zzf;
    }

    public static zzifx zzi() {
        return zzf.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhts zzb() {
        zzhts zzhtsVar = this.zzc;
        return zzhtsVar == null ? zzhts.zzc() : zzhtsVar;
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
            return new zzhtw();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhtv(bArr);
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
        synchronized (zzhtw.class) {
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

    public final /* synthetic */ void zzj(zzhts zzhtsVar) {
        zzhtsVar.getClass();
        this.zzc = zzhtsVar;
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
