package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzab extends zziee<zzbhv$zzab, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    private static final zzbhv$zzab zzf;
    private static volatile zzifx<zzbhv$zzab> zzg;
    private int zzc;
    private int zzd;
    private int zze;

    public enum zzb implements zziei {
        CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
        TWO_G(1),
        THREE_G(2),
        LTE(4);

        private static final zziej<zzb> zzi = new zziej<zzb>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzab.zzb.1
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
                return CELLULAR_NETWORK_TYPE_UNSPECIFIED;
            }
            if (i == 1) {
                return TWO_G;
            }
            if (i == 2) {
                return THREE_G;
            }
            if (i != 4) {
                return null;
            }
            return LTE;
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

    public enum zzc implements zziei {
        NETWORKTYPE_UNSPECIFIED(0),
        CELL(1),
        WIFI(2);

        private static final zziej<zzc> zzg = new zziej<zzc>() { // from class: com.google.android.gms.internal.ads.zzbhv.zzab.zzc.1
        };
        private final int zzh;

        final class zza implements zziek {
            static final zziek zza = new zza();

            private zza() {
            }

            @Override // com.google.android.gms.internal.ads.zziek
            public boolean zza(int i) {
                return zzc.zzc(i) != null;
            }
        }

        zzc(int i) {
            this.zzh = i;
        }

        public static zzc zzc(int i) {
            if (i == 0) {
                return NETWORKTYPE_UNSPECIFIED;
            }
            if (i == 1) {
                return CELL;
            }
            if (i != 2) {
                return null;
            }
            return WIFI;
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
        zzbhv$zzab zzbhv_zzab = new zzbhv$zzab();
        zzf = zzbhv_zzab;
        zziee.zzbu(zzbhv$zzab.class, zzbhv_zzab);
    }

    private zzbhv$zzab() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzB, reason: merged with bridge method [inline-methods] */
    public void zzw(zzb zzbVar) {
        this.zze = zzbVar.zza();
        this.zzc |= 2;
    }

    public static zza zzq() {
        return (zza) zzf.zzbn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public void zzu(zzc zzcVar) {
        this.zzd = zzcVar.zza();
        this.zzc |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzc", "zzd", zzc.zze(), "zze", zzb.zze()});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzab();
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
        zzifx<zzbhv$zzab> zzifxVar = zzg;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzab.class) {
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

    public final class zza extends zzidy<zzbhv$zzab, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzab.zzf);
        }

        public zza zzc(zzc zzcVar) {
            zzbg();
            ((zzbhv$zzab) this.zza).zzu(zzcVar);
            return this;
        }

        public zza zzg(zzb zzbVar) {
            zzbg();
            ((zzbhv$zzab) this.zza).zzw(zzbVar);
            return this;
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
