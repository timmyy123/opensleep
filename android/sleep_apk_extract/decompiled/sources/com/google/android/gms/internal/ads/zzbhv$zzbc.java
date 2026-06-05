package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzbc extends zziee<zzbhv$zzbc, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    private static final zzbhv$zzbc zzh;
    private static volatile zzifx<zzbhv$zzbc> zzi;
    private int zzd;
    private int zze = 1000;
    private zzbhv$zzaw zzf;
    private zzbhv$zzap zzg;

    static {
        zzbhv$zzbc zzbhv_zzbc = new zzbhv$zzbc();
        zzh = zzbhv_zzbc;
        zziee.zzbu(zzbhv$zzbc.class, zzbhv_zzbc);
    }

    private zzbhv$zzbc() {
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
            return new zzbhv$zzbc();
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
        zzifx<zzbhv$zzbc> zzifxVar = zzi;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzbc.class) {
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

    public final class zza extends zzidy<zzbhv$zzbc, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzbc.zzh);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
