package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbhv$zzi;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zza extends zziee<zzbhv$zza, zzb> implements zzifq {
    private static final zzbhv$zza zzB;
    private static volatile zzifx<zzbhv$zza> zzC = null;
    public static final int zza = 7;
    public static final int zzb = 8;
    public static final int zzc = 9;
    public static final int zzd = 10;
    public static final int zze = 11;
    public static final int zzf = 12;
    public static final int zzg = 13;
    public static final int zzh = 14;
    public static final int zzi = 15;
    public static final int zzj = 16;
    public static final int zzk = 17;
    private int zzl;
    private int zzm;
    private zzbhv$zzg zzo;
    private zzbhv$zzi zzp;
    private zzbhv$zzk zzv;
    private zzbhv$zzah zzw;
    private zzbhv$zzac zzx;
    private zzbhv$zzx zzy;
    private zzbhv$zzz zzz;
    private int zzn = 1000;
    private zzieq<zzbhv$zzd> zzu = zziee.zzbM();
    private zzieq<zzbhv$zzat> zzA = zziee.zzbM();

    public enum zza implements zziei {
        AD_INITIATER_UNSPECIFIED(0),
        BANNER(1),
        DFP_BANNER(2),
        INTERSTITIAL(3),
        DFP_INTERSTITIAL(4),
        NATIVE_EXPRESS(5),
        AD_LOADER(6),
        REWARD_BASED_VIDEO_AD(7),
        BANNER_SEARCH_ADS(8),
        GOOGLE_MOBILE_ADS_SDK_ADAPTER(9),
        APP_OPEN(10),
        REWARDED_INTERSTITIAL(11);

        private static final zziej<zza> zzy = new zziej<zza>() { // from class: com.google.android.gms.internal.ads.zzbhv.zza.zza.1
        };
        private final int zzz;

        /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbhv$zza$zza$zza, reason: collision with other inner class name */
        final class C0003zza implements zziek {
            static final zziek zza = new C0003zza();

            private C0003zza() {
            }

            @Override // com.google.android.gms.internal.ads.zziek
            public boolean zza(int i) {
                return zza.zzc(i) != null;
            }
        }

        zza(int i) {
            this.zzz = i;
        }

        public static zza zzc(int i) {
            switch (i) {
                case 0:
                    return AD_INITIATER_UNSPECIFIED;
                case 1:
                    return BANNER;
                case 2:
                    return DFP_BANNER;
                case 3:
                    return INTERSTITIAL;
                case 4:
                    return DFP_INTERSTITIAL;
                case 5:
                    return NATIVE_EXPRESS;
                case 6:
                    return AD_LOADER;
                case 7:
                    return REWARD_BASED_VIDEO_AD;
                case 8:
                    return BANNER_SEARCH_ADS;
                case 9:
                    return GOOGLE_MOBILE_ADS_SDK_ADAPTER;
                case 10:
                    return APP_OPEN;
                case 11:
                    return REWARDED_INTERSTITIAL;
                default:
                    return null;
            }
        }

        public static zziek zze() {
            return C0003zza.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(this.zzz);
        }

        @Override // com.google.android.gms.internal.ads.zziei
        public final int zza() {
            return this.zzz;
        }
    }

    static {
        zzbhv$zza zzbhv_zza = new zzbhv$zza();
        zzB = zzbhv_zza;
        zziee.zzbu(zzbhv$zza.class, zzbhv_zza);
    }

    private zzbhv$zza() {
    }

    public static zzbhv$zza zzD() {
        return zzB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaE, reason: merged with bridge method [inline-methods] */
    public void zzF(zza zzaVar) {
        this.zzm = zzaVar.zza();
        this.zzl |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaL, reason: merged with bridge method [inline-methods] */
    public void zzQ(zzbhv$zzi zzbhv_zzi) {
        zzbhv_zzi.getClass();
        this.zzp = zzbhv_zzi;
        this.zzl |= 8;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzB, "\u0004\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007᠌\u0000\b᠌\u0001\tဉ\u0002\nဉ\u0003\u000b\u001b\fဉ\u0004\rဉ\u0005\u000eဉ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011\u001b", new Object[]{"zzl", "zzm", zza.zze(), "zzn", zzbhv$zzq.zze(), "zzo", "zzp", "zzu", zzbhv$zzd.class, "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", zzbhv$zzat.class});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zza();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzb(bArr);
        }
        if (iOrdinal == 5) {
            return zzB;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zza> zzifxVar = zzC;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zza.class) {
            try {
                zzidzVar = zzC;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzB);
                    zzC = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public zzbhv$zzi zzp() {
        zzbhv$zzi zzbhv_zzi = this.zzp;
        return zzbhv_zzi == null ? zzbhv$zzi.zzD() : zzbhv_zzi;
    }

    public final class zzb extends zzidy<zzbhv$zza, zzb> implements zzifq {
        private zzb() {
            super(zzbhv$zza.zzB);
        }

        public zzb zzc(zza zzaVar) {
            zzbg();
            ((zzbhv$zza) this.zza).zzF(zzaVar);
            return this;
        }

        public zzb zzr(zzbhv$zzi.zza zzaVar) {
            zzbg();
            ((zzbhv$zza) this.zza).zzQ(zzaVar.zzbm());
            return this;
        }

        public /* synthetic */ zzb(byte[] bArr) {
            this();
        }
    }
}
