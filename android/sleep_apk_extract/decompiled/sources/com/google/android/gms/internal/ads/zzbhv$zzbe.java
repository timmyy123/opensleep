package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzbe extends zziee<zzbhv$zzbe, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    public static final int zzd = 4;
    public static final int zze = 5;
    public static final int zzf = 6;
    private static final zzbhv$zzbe zzn;
    private static volatile zzifx<zzbhv$zzbe> zzo;
    private int zzg;
    private int zzh = 1000;
    private zzbhv$zzaw zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;

    static {
        zzbhv$zzbe zzbhv_zzbe = new zzbhv$zzbe();
        zzn = zzbhv_zzbe;
        zziee.zzbu(zzbhv$zzbe.class, zzbhv_zzbe);
    }

    private zzbhv$zzbe() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzn, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006ဃ\u0005", new Object[]{"zzg", "zzh", zzbhv$zzq.zze(), "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzbe();
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
        zzifx<zzbhv$zzbe> zzifxVar = zzo;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzbe.class) {
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

    public final class zza extends zzidy<zzbhv$zzbe, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzbe.zzn);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
