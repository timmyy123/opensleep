package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzai extends zziee<zzbhv$zzai, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    private static final zzbhv$zzai zzf;
    private static volatile zzifx<zzbhv$zzai> zzg;
    private int zzc;
    private int zzd;
    private int zze;

    static {
        zzbhv$zzai zzbhv_zzai = new zzbhv$zzai();
        zzf = zzbhv_zzai;
        zziee.zzbu(zzbhv$zzai.class, zzbhv_zzai);
    }

    private zzbhv$zzai() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzai();
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
        zzifx<zzbhv$zzai> zzifxVar = zzg;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzai.class) {
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

    public final class zza extends zzidy<zzbhv$zzai, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzai.zzf);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
