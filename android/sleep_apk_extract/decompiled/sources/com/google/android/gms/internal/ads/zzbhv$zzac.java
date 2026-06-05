package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzac extends zziee<zzbhv$zzac, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    private static final zzbhv$zzac zzf;
    private static volatile zzifx<zzbhv$zzac> zzg;
    private int zzc;
    private int zzd;
    private zzbhv$zzap zze;

    static {
        zzbhv$zzac zzbhv_zzac = new zzbhv$zzac();
        zzf = zzbhv_zzac;
        zziee.zzbu(zzbhv$zzac.class, zzbhv_zzac);
    }

    private zzbhv$zzac() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", zzbhv$zzq.zze(), "zze"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzac();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zza(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzac> zzifxVar = zzg;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzac.class) {
            try {
                zzidzVar = zzg;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzf);
                    zzg = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final class zza extends zzidy<zzbhv$zzac, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzac.zzf);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
