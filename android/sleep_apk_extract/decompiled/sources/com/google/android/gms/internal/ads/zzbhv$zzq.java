package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public enum zzbhv$zzq implements zziei {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);

    private static final zziej<zzbhv$zzq> zzg = new zziej<zzbhv$zzq>() { // from class: com.google.android.gms.internal.ads.zzbhv$zzq.1
    };
    private final int zzh;

    final class zza implements zziek {
        static final zziek zza = new zza();

        private zza() {
        }

        @Override // com.google.android.gms.internal.ads.zziek
        public boolean zza(int i) {
            return zzbhv$zzq.zzc(i) != null;
        }
    }

    zzbhv$zzq(int i) {
        this.zzh = i;
    }

    public static zzbhv$zzq zzc(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
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
