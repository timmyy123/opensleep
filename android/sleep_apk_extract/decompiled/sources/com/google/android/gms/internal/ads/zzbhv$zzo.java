package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzo extends zziee<zzbhv$zzo, zza> implements zzifq {
    public static final int zza = 5;
    public static final int zzb = 6;
    public static final int zzc = 7;
    public static final int zzd = 8;
    private static final zzbhv$zzo zzj;
    private static volatile zzifx<zzbhv$zzo> zzk;
    private int zze;
    private int zzf;
    private zzbhv$zzar zzg;
    private String zzh = "";
    private String zzi = "";

    public enum zzb implements zziei {
        PLATFORM_UNSPECIFIED(0),
        IOS(1),
        ANDROID(2);

        private static final zziej<zzb> zzg = new zziej<zzb>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzo.zzb.1
        };
        private final int zzh;

        final class zza implements zziek {
            static final zziek zza = new zza();

            private zza() {
            }

            @Override // com.google.android.gms.internal.ads.zziek
            public boolean zza(int i) {
                return zzb.zzc(i) != null;
            }
        }

        zzb(int i) {
            this.zzh = i;
        }

        public static zzb zzc(int i) {
            if (i == 0) {
                return PLATFORM_UNSPECIFIED;
            }
            if (i == 1) {
                return IOS;
            }
            if (i != 2) {
                return null;
            }
            return ANDROID;
        }

        public static zziek zze() {
            return zza.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(this.zzh);
        }

        @Override // com.google.android.gms.internal.ads.zziei
        public final int zza() {
            return this.zzh;
        }
    }

    static {
        zzbhv$zzo zzbhv_zzo = new zzbhv$zzo();
        zzj = zzbhv_zzo;
        zziee.zzbu(zzbhv$zzo.class, zzbhv_zzo);
    }

    private zzbhv$zzo() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzj, "\u0004\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005᠌\u0000\u0006ဉ\u0001\u0007ဈ\u0002\bဈ\u0003", new Object[]{"zze", "zzf", zzb.zze(), "zzg", "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzo();
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
        zzifx<zzbhv$zzo> zzifxVar = zzk;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzo.class) {
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

    public final class zza extends zzidy<zzbhv$zzo, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzo.zzj);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
