package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhqu extends zziee implements zzifq {
    private static final zzhqu zze;
    private static volatile zzifx zzf;
    private int zza;
    private int zzb;
    private zzhqy zzc;
    private zzida zzd = zzida.zza;

    static {
        zzhqu zzhquVar = new zzhqu();
        zze = zzhquVar;
        zziee.zzbu(zzhqu.class, zzhquVar);
    }

    private zzhqu() {
    }

    public static zzhqt zzd() {
        return (zzhqt) zze.zzbn();
    }

    public static zzhqu zze() {
        return zze;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhqy zzb() {
        zzhqy zzhqyVar = this.zzc;
        return zzhqyVar == null ? zzhqy.zzc() : zzhqyVar;
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
            return new zzhqu();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhqt(bArr);
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
        synchronized (zzhqu.class) {
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

    public final /* synthetic */ void zzg(zzhqy zzhqyVar) {
        zzhqyVar.getClass();
        this.zzc = zzhqyVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzh(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzd = zzidaVar;
    }
}
