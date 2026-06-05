package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzz extends zziee<zzbhv$zzz, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    public static final int zzd = 4;
    private static final zzbhv$zzz zzj;
    private static volatile zzifx<zzbhv$zzz> zzk;
    private int zze;
    private zzbhv$zzv zzf;
    private zzieq<zzbhv$zzan> zzg = zziee.zzbM();
    private int zzh;
    private zzbhv$zzap zzi;

    static {
        zzbhv$zzz zzbhv_zzz = new zzbhv$zzz();
        zzj = zzbhv_zzz;
        zziee.zzbu(zzbhv$zzz.class, zzbhv_zzz);
    }

    private zzbhv$zzz() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzj, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003᠌\u0001\u0004ဉ\u0002", new Object[]{"zze", "zzf", "zzg", zzbhv$zzan.class, "zzh", zzbhv$zzq.zze(), "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzz();
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
        zzifx<zzbhv$zzz> zzifxVar = zzk;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzz.class) {
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

    public final class zza extends zzidy<zzbhv$zzz, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzz.zzj);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
