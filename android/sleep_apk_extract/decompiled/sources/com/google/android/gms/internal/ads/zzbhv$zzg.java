package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzg extends zziee<zzbhv$zzg, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    private static final zzbhv$zzg zzh;
    private static volatile zzifx<zzbhv$zzg> zzi;
    private int zzd;
    private String zze = "";
    private zzieq<zzbhv$zzd> zzf = zziee.zzbM();
    private int zzg;

    static {
        zzbhv$zzg zzbhv_zzg = new zzbhv$zzg();
        zzh = zzbhv_zzg;
        zziee.zzbu(zzbhv$zzg.class, zzbhv_zzg);
    }

    private zzbhv$zzg() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001", new Object[]{"zzd", "zze", "zzf", zzbhv$zzd.class, "zzg", zzbhv$zzq.zze()});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzg();
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
        zzifx<zzbhv$zzg> zzifxVar = zzi;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzg.class) {
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

    public final class zza extends zzidy<zzbhv$zzg, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzg.zzh);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
