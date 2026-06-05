package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzd extends zziee<zzbhv$zzd, zzb> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    private static final zzbhv$zzd zzf;
    private static volatile zzifx<zzbhv$zzd> zzg;
    private int zzc;
    private int zzd;
    private zzbhv$zzal zze;

    public enum zza implements zziei {
        AD_FORMAT_TYPE_UNSPECIFIED(0),
        BANNER(1),
        INTERSTITIAL(2),
        NATIVE_EXPRESS(3),
        NATIVE_CONTENT(4),
        NATIVE_APP_INSTALL(5),
        NATIVE_CUSTOM_TEMPLATE(6),
        DFP_BANNER(7),
        DFP_INTERSTITIAL(8),
        REWARD_BASED_VIDEO_AD(9),
        BANNER_SEARCH_ADS(10);

        private static final zziej<zza> zzw = new zziej<zza>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzd.zza.1
        };
        private final int zzx;

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zzd$zza$zza, reason: collision with other inner class name */
        final class C0006zza implements zziek {
            static final zziek zza = new C0006zza();

            private C0006zza() {
            }

            @Override // com.google.android.gms.internal.ads.zziek
            public boolean zza(int i) {
                return zza.zzc(i) != null;
            }
        }

        zza(int i) {
            this.zzx = i;
        }

        public static zza zzc(int i) {
            switch (i) {
                case 0:
                    return AD_FORMAT_TYPE_UNSPECIFIED;
                case 1:
                    return BANNER;
                case 2:
                    return INTERSTITIAL;
                case 3:
                    return NATIVE_EXPRESS;
                case 4:
                    return NATIVE_CONTENT;
                case 5:
                    return NATIVE_APP_INSTALL;
                case 6:
                    return NATIVE_CUSTOM_TEMPLATE;
                case 7:
                    return DFP_BANNER;
                case 8:
                    return DFP_INTERSTITIAL;
                case 9:
                    return REWARD_BASED_VIDEO_AD;
                case 10:
                    return BANNER_SEARCH_ADS;
                default:
                    return null;
            }
        }

        public static zziek zze() {
            return C0006zza.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(this.zzx);
        }

        @Override // com.google.android.gms.internal.ads.zziei
        public final int zza() {
            return this.zzx;
        }
    }

    static {
        zzbhv$zzd zzbhv_zzd = new zzbhv$zzd();
        zzf = zzbhv_zzd;
        zziee.zzbu(zzbhv$zzd.class, zzbhv_zzd);
    }

    private zzbhv$zzd() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", zza.zze(), "zze"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzd();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzb(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzd> zzifxVar = zzg;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzd.class) {
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

    public final class zzb extends zzidy<zzbhv$zzd, zzb> implements zzifq {
        private zzb() {
            super(zzbhv$zzd.zzf);
        }

        public /* synthetic */ zzb(byte[] bArr) {
            this();
        }
    }
}
