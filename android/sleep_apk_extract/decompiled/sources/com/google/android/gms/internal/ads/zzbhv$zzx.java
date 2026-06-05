package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzx extends zziee<zzbhv$zzx, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    private static final zzbhv$zzx zzf;
    private static volatile zzifx<zzbhv$zzx> zzg;
    private int zzc;
    private int zzd;
    private zziem zze = zziee.zzbC();

    static {
        zzbhv$zzx zzbhv_zzx = new zzbhv$zzx();
        zzf = zzbhv_zzx;
        zziee.zzbu(zzbhv$zzx.class, zzbhv_zzx);
    }

    private zzbhv$zzx() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001᠌\u0000\u0002\u0016", new Object[]{"zzc", "zzd", zzbhv$zzq.zze(), "zze"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzx();
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
        zzifx<zzbhv$zzx> zzifxVar = zzg;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzx.class) {
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

    public final class zza extends zzidy<zzbhv$zzx, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzx.zzf);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
