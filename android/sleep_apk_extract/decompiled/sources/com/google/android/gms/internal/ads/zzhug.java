package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhug extends zziee implements zzifq {
    private static final zzhug zze;
    private static volatile zzifx zzf;
    private int zza;
    private int zzb;
    private zzhuk zzc;
    private zzida zzd = zzida.zza;

    static {
        zzhug zzhugVar = new zzhug();
        zze = zzhugVar;
        zziee.zzbu(zzhug.class, zzhugVar);
    }

    private zzhug() {
    }

    public static zzhug zzd(zzida zzidaVar, zzido zzidoVar) {
        return (zzhug) zziee.zzbT(zze, zzidaVar, zzidoVar);
    }

    public static zzhuf zze() {
        return (zzhuf) zze.zzbn();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhuk zzb() {
        zzhuk zzhukVar = this.zzc;
        return zzhukVar == null ? zzhuk.zzc() : zzhukVar;
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
            return new zzhug();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhuf(bArr);
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
        synchronized (zzhug.class) {
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

    public final /* synthetic */ void zzg(zzhuk zzhukVar) {
        zzhukVar.getClass();
        this.zzc = zzhukVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzh(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzd = zzidaVar;
    }
}
