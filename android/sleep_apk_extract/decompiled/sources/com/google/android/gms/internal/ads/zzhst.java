package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhst extends zziee implements zzifq {
    private static final zzhst zzd;
    private static volatile zzifx zze;
    private String zza = "";
    private zzida zzb = zzida.zza;
    private int zzc;

    static {
        zzhst zzhstVar = new zzhst();
        zzd = zzhstVar;
        zziee.zzbu(zzhst.class, zzhstVar);
    }

    private zzhst() {
    }

    public static zzhst zzd(byte[] bArr, zzido zzidoVar) {
        return (zzhst) zziee.zzbV(zzd, bArr, zzidoVar);
    }

    public static zzhss zze() {
        return (zzhss) zzd.zzbn();
    }

    public static zzhst zzh() {
        return zzd;
    }

    public final String zza() {
        return this.zza;
    }

    public final zzida zzb() {
        return this.zzb;
    }

    public final zzhtm zzc() {
        zzhtm zzhtmVarZzb = zzhtm.zzb(this.zzc);
        return zzhtmVarZzb == null ? zzhtm.UNRECOGNIZED : zzhtmVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzd, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhst();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhss(bArr);
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
        synchronized (zzhst.class) {
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

    public final /* synthetic */ void zzi(String str) {
        str.getClass();
        this.zza = str;
    }

    public final /* synthetic */ void zzj(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzb = zzidaVar;
    }

    public final /* synthetic */ void zzk(zzhtm zzhtmVar) {
        this.zzc = zzhtmVar.zza();
    }
}
