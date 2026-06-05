package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzbl extends zziee<zzbhv$zzbl, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    private static final zzbhv$zzbl zzf;
    private static volatile zzifx<zzbhv$zzbl> zzg;
    private int zzc;
    private boolean zzd;
    private int zze;

    static {
        zzbhv$zzbl zzbhv_zzbl = new zzbhv$zzbl();
        zzf = zzbhv_zzbl;
        zziee.zzbu(zzbhv$zzbl.class, zzbhv_zzbl);
    }

    private zzbhv$zzbl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzB, reason: merged with bridge method [inline-methods] */
    public void zzw(int i) {
        this.zzc |= 2;
        this.zze = i;
    }

    public static zza zzq() {
        return (zza) zzf.zzbn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public void zzu(boolean z) {
        this.zzc |= 1;
        this.zzd = z;
    }

    public boolean zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzbl();
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
        zzifx<zzbhv$zzbl> zzifxVar = zzg;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzbl.class) {
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

    public final class zza extends zzidy<zzbhv$zzbl, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzbl.zzf);
        }

        public boolean zzb() {
            return ((zzbhv$zzbl) this.zza).zzb();
        }

        public zza zzc(boolean z) {
            zzbg();
            ((zzbhv$zzbl) this.zza).zzu(z);
            return this;
        }

        public zza zzg(int i) {
            zzbg();
            ((zzbhv$zzbl) this.zza).zzw(i);
            return this;
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
