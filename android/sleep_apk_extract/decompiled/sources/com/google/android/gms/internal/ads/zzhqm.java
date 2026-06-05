package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhqm extends zziee implements zzifq {
    private static final zzhqm zzd;
    private static volatile zzifx zze;
    private int zza;
    private int zzb;
    private zzhqo zzc;

    static {
        zzhqm zzhqmVar = new zzhqm();
        zzd = zzhqmVar;
        zziee.zzbu(zzhqm.class, zzhqmVar);
    }

    private zzhqm() {
    }

    public static zzhqm zzc(zzida zzidaVar, zzido zzidoVar) {
        return (zzhqm) zziee.zzbT(zzd, zzidaVar, zzidoVar);
    }

    public static zzhql zzd() {
        return (zzhql) zzd.zzbn();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhqo zzb() {
        zzhqo zzhqoVar = this.zzc;
        return zzhqoVar == null ? zzhqo.zzc() : zzhqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhqm();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhql(bArr);
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
        synchronized (zzhqm.class) {
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

    public final /* synthetic */ void zze(int i) {
        this.zzb = i;
    }

    public final /* synthetic */ void zzg(zzhqo zzhqoVar) {
        zzhqoVar.getClass();
        this.zzc = zzhqoVar;
        this.zza |= 1;
    }
}
