package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhrw extends zziee implements zzifq {
    private static final zzhrw zze;
    private static volatile zzifx zzf;
    private int zza;
    private int zzb;
    private zzhry zzc;
    private zzida zzd = zzida.zza;

    static {
        zzhrw zzhrwVar = new zzhrw();
        zze = zzhrwVar;
        zziee.zzbu(zzhrw.class, zzhrwVar);
    }

    private zzhrw() {
    }

    public static zzhrw zzd(zzida zzidaVar, zzido zzidoVar) {
        return (zzhrw) zziee.zzbT(zze, zzidaVar, zzidoVar);
    }

    public static zzhrv zze() {
        return (zzhrv) zze.zzbn();
    }

    public static zzifx zzg() {
        return zze.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhry zzb() {
        zzhry zzhryVar = this.zzc;
        return zzhryVar == null ? zzhry.zzh() : zzhryVar;
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
            return new zzhrw();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhrv(bArr);
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
        synchronized (zzhrw.class) {
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

    public final /* synthetic */ void zzh(zzhry zzhryVar) {
        zzhryVar.getClass();
        this.zzc = zzhryVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzi(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzd = zzidaVar;
    }
}
