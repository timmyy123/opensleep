package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzk extends zziee<zzbhv$zzk, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    public static final int zzd = 4;
    public static final int zze = 5;
    public static final int zzf = 6;
    private static final zzbhv$zzk zzn;
    private static volatile zzifx<zzbhv$zzk> zzo;
    private int zzg;
    private int zzh;
    private zzbhv$zzap zzi;
    private zzbhv$zzap zzj;
    private zzbhv$zzap zzk;
    private zzieq<zzbhv$zzap> zzl = zziee.zzbM();
    private int zzm;

    static {
        zzbhv$zzk zzbhv_zzk = new zzbhv$zzk();
        zzn = zzbhv_zzk;
        zziee.zzbu(zzbhv$zzk.class, zzbhv_zzk);
    }

    private zzbhv$zzk() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzn, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005\u001b\u0006င\u0004", new Object[]{"zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzbhv$zzap.class, "zzm"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzk();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zza(bArr);
        }
        if (iOrdinal == 5) {
            return zzn;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzk> zzifxVar = zzo;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzk.class) {
            try {
                zzidzVar = zzo;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzn);
                    zzo = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final class zza extends zzidy<zzbhv$zzk, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzk.zzn);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
