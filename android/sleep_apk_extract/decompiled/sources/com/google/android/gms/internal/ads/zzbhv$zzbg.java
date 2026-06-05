package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzbg extends zziee<zzbhv$zzbg, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    private static final zzbhv$zzbg zzh;
    private static volatile zzifx<zzbhv$zzbg> zzi;
    private int zzd;
    private int zze = 1000;
    private zzbhv$zzaw zzf;
    private zzbhv$zzap zzg;

    static {
        zzbhv$zzbg zzbhv_zzbg = new zzbhv$zzbg();
        zzh = zzbhv_zzbg;
        zziee.zzbu(zzbhv$zzbg.class, zzbhv_zzbg);
    }

    private zzbhv$zzbg() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzbhv$zzq.zze(), "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzbg();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zza(bArr);
        }
        if (iOrdinal == 5) {
            return zzh;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzbg> zzifxVar = zzi;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzbg.class) {
            try {
                zzidzVar = zzi;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzh);
                    zzi = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final class zza extends zzidy<zzbhv$zzbg, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzbg.zzh);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
