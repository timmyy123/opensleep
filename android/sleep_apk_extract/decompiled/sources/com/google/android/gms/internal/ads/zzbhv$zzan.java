package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzan extends zziee<zzbhv$zzan, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    private static final zzbhv$zzan zzh;
    private static volatile zzifx<zzbhv$zzan> zzi;
    private int zzd;
    private String zze = "";
    private int zzf;
    private zzbhv$zzap zzg;

    static {
        zzbhv$zzan zzbhv_zzan = new zzbhv$zzan();
        zzh = zzbhv_zzan;
        zziee.zzbu(zzbhv$zzan.class, zzbhv_zzan);
    }

    private zzbhv$zzan() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", zzbhv$zzq.zze(), "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzan();
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
        zzifx<zzbhv$zzan> zzifxVar = zzi;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzan.class) {
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

    public final class zza extends zzidy<zzbhv$zzan, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzan.zzh);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
