package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzaw extends zziee<zzbhv$zzaw, zza> implements zzifq {
    public static final int zza = 1;
    private static final zzbhv$zzaw zzd;
    private static volatile zzifx<zzbhv$zzaw> zze;
    private int zzb;
    private int zzc;

    public enum zzb implements zziei {
        VIDEO_ERROR_CODE_UNSPECIFIED(0),
        OPENGL_RENDERING_FAILED(1),
        CACHE_LOAD_FAILED(2),
        ANDROID_TARGET_API_TOO_LOW(3);

        private static final zziej<zzb> zzi = new zziej<zzb>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzaw.zzb.1
        };
        private final int zzj;

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
            this.zzj = i;
        }

        public static zzb zzc(int i) {
            if (i == 0) {
                return VIDEO_ERROR_CODE_UNSPECIFIED;
            }
            if (i == 1) {
                return OPENGL_RENDERING_FAILED;
            }
            if (i == 2) {
                return CACHE_LOAD_FAILED;
            }
            if (i != 3) {
                return null;
            }
            return ANDROID_TARGET_API_TOO_LOW;
        }

        public static zziek zze() {
            return zza.zza;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(this.zzj);
        }

        @Override // com.google.android.gms.internal.ads.zziei
        public final int zza() {
            return this.zzj;
        }
    }

    static {
        zzbhv$zzaw zzbhv_zzaw = new zzbhv$zzaw();
        zzd = zzbhv_zzaw;
        zziee.zzbu(zzbhv$zzaw.class, zzbhv_zzaw);
    }

    private zzbhv$zzaw() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzd, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzb", "zzc", zzb.zze()});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzaw();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zza(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzaw> zzifxVar = zze;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzaw.class) {
            try {
                zzidzVar = zze;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzd);
                    zze = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final class zza extends zzidy<zzbhv$zzaw, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzaw.zzd);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
