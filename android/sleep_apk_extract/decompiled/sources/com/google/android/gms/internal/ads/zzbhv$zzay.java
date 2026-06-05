package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzay extends zziee<zzbhv$zzay, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    public static final int zzd = 4;
    private static final zzbhv$zzay zzj;
    private static volatile zzifx<zzbhv$zzay> zzk;
    private int zze;
    private zzbhv$zzar zzf;
    private int zzg = 1000;
    private zzbhv$zzaw zzh;
    private zzbhv$zzap zzi;

    static {
        zzbhv$zzay zzbhv_zzay = new zzbhv$zzay();
        zzj = zzbhv_zzay;
        zziee.zzbu(zzbhv$zzay.class, zzbhv_zzay);
    }

    private zzbhv$zzay() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzj, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zze", "zzf", "zzg", zzbhv$zzq.zze(), "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzay();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zza(bArr);
        }
        if (iOrdinal == 5) {
            return zzj;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzay> zzifxVar = zzk;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzay.class) {
            try {
                zzidzVar = zzk;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzj);
                    zzk = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final class zza extends zzidy<zzbhv$zzay, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzay.zzj);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
