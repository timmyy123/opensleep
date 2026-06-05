package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhty extends zziee implements zzifq {
    private static final zzhty zze;
    private static volatile zzifx zzf;
    private int zza;
    private zzhua zzb;
    private int zzc;
    private zzida zzd = zzida.zza;

    static {
        zzhty zzhtyVar = new zzhty();
        zze = zzhtyVar;
        zziee.zzbu(zzhty.class, zzhtyVar);
    }

    private zzhty() {
    }

    public static zzhty zzd(zzida zzidaVar, zzido zzidoVar) {
        return (zzhty) zziee.zzbT(zze, zzidaVar, zzidoVar);
    }

    public static zzhtx zze() {
        return (zzhtx) zze.zzbn();
    }

    public final zzhua zza() {
        zzhua zzhuaVar = this.zzb;
        return zzhuaVar == null ? zzhua.zze() : zzhuaVar;
    }

    public final int zzb() {
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
            return zziee.zzbv(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\n", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhty();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhtx(bArr);
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
        synchronized (zzhty.class) {
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

    public final /* synthetic */ void zzg(zzhua zzhuaVar) {
        zzhuaVar.getClass();
        this.zzb = zzhuaVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzh(int i) {
        this.zzc = i;
    }

    public final /* synthetic */ void zzi(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzd = zzidaVar;
    }
}
