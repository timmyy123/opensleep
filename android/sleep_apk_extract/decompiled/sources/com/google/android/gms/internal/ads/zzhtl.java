package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhtl extends zziee implements zzifq {
    private static final zzhtl zzd;
    private static volatile zzifx zze;
    private int zza;
    private String zzb = "";
    private zzhst zzc;

    static {
        zzhtl zzhtlVar = new zzhtl();
        zzd = zzhtlVar;
        zziee.zzbu(zzhtl.class, zzhtlVar);
    }

    private zzhtl() {
    }

    public static zzhtl zzc(zzida zzidaVar, zzido zzidoVar) {
        return (zzhtl) zziee.zzbT(zzd, zzidaVar, zzidoVar);
    }

    public static zzhtk zzd() {
        return (zzhtk) zzd.zzbn();
    }

    public static zzhtl zze() {
        return zzd;
    }

    public final String zza() {
        return this.zzb;
    }

    public final zzhst zzb() {
        zzhst zzhstVar = this.zzc;
        return zzhstVar == null ? zzhst.zzh() : zzhstVar;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhtl();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhtk(bArr);
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
        synchronized (zzhtl.class) {
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

    public final /* synthetic */ void zzg(String str) {
        str.getClass();
        this.zzb = str;
    }

    public final /* synthetic */ void zzh(zzhst zzhstVar) {
        zzhstVar.getClass();
        this.zzc = zzhstVar;
        this.zza |= 1;
    }
}
