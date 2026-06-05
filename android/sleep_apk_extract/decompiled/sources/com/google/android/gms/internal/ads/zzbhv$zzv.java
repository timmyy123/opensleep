package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzv extends zziee<zzbhv$zzv, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    public static final int zzd = 4;
    private static final zzbhv$zzv zzj;
    private static volatile zzifx<zzbhv$zzv> zzk;
    private int zze;
    private int zzg;
    private zzbhv$zzap zzi;
    private String zzf = "";
    private zziem zzh = zziee.zzbC();

    static {
        zzbhv$zzv zzbhv_zzv = new zzbhv$zzv();
        zzj = zzbhv_zzv;
        zziee.zzbu(zzbhv$zzv.class, zzbhv_zzv);
    }

    private zzbhv$zzv() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzj, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003\u0016\u0004ဉ\u0002", new Object[]{"zze", "zzf", "zzg", zzbhv$zzq.zze(), "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzv();
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
        zzifx<zzbhv$zzv> zzifxVar = zzk;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzv.class) {
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

    public final class zza extends zzidy<zzbhv$zzv, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzv.zzj);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
