package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzba extends zziee<zzbhv$zzba, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    public static final int zzd = 4;
    public static final int zze = 5;
    private static final zzbhv$zzba zzl;
    private static volatile zzifx<zzbhv$zzba> zzm;
    private int zzf;
    private int zzg = 1000;
    private zzbhv$zzaw zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    static {
        zzbhv$zzba zzbhv_zzba = new zzbhv$zzba();
        zzl = zzbhv_zzba;
        zziee.zzbu(zzbhv$zzba.class, zzbhv_zzba);
    }

    private zzbhv$zzba() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzl, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzf", "zzg", zzbhv$zzq.zze(), "zzh", "zzi", "zzj", "zzk"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzba();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zza(bArr);
        }
        if (iOrdinal == 5) {
            return zzl;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzba> zzifxVar = zzm;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzba.class) {
            try {
                zzidzVar = zzm;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzl);
                    zzm = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final class zza extends zzidy<zzbhv$zzba, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzba.zzl);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
