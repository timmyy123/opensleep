package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzar extends zziee<zzbhv$zzar, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    private static final zzbhv$zzar zzh;
    private static volatile zzifx<zzbhv$zzar> zzi;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzbhv$zzar zzbhv_zzar = new zzbhv$zzar();
        zzh = zzbhv_zzar;
        zziee.zzbu(zzbhv$zzar.class, zzbhv_zzar);
    }

    private zzbhv$zzar() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzD, reason: merged with bridge method [inline-methods] */
    public void zzw(int i) {
        this.zzd |= 1;
        this.zze = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzF, reason: merged with bridge method [inline-methods] */
    public void zzy(int i) {
        this.zzd |= 2;
        this.zzf = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public void zzA(int i) {
        this.zzd |= 4;
        this.zzg = i;
    }

    public static zza zzs() {
        return (zza) zzh.zzbn();
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzh, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzar();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zza(bArr);
        }
        if (iOrdinal == 5) {
            return zzh;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzar> zzifxVar = zzi;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzar.class) {
            try {
                zzidzVar = zzi;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzh);
                    zzi = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final class zza extends zzidy<zzbhv$zzar, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzar.zzh);
        }

        public zza zzc(int i) {
            zzbg();
            ((zzbhv$zzar) this.zza).zzw(i);
            return this;
        }

        public zza zzg(int i) {
            zzbg();
            ((zzbhv$zzar) this.zza).zzy(i);
            return this;
        }

        public zza zzk(int i) {
            zzbg();
            ((zzbhv$zzar) this.zza).zzA(i);
            return this;
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
