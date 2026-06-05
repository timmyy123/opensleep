package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzm extends zziee<zzbhv$zzm, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    public static final int zzd = 4;
    public static final int zze = 5;
    public static final int zzf = 6;
    public static final int zzg = 7;
    public static final int zzh = 8;
    private static final zzbhv$zzm zzv;
    private static volatile zzifx<zzbhv$zzm> zzw;
    private int zzi;
    private zzbhv$zzap zzk;
    private int zzl;
    private zzbhv$zzar zzm;
    private int zzn;
    private String zzj = "";
    private int zzo = 1000;
    private int zzp = 1000;
    private int zzu = 1000;

    static {
        zzbhv$zzm zzbhv_zzm = new zzbhv$zzm();
        zzv = zzbhv_zzm;
        zziee.zzbu(zzbhv$zzm.class, zzbhv_zzm);
    }

    private zzbhv$zzm() {
    }

    public static zzbhv$zzm zzC() {
        return zzv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzac, reason: merged with bridge method [inline-methods] */
    public void zzG(String str) {
        str.getClass();
        this.zzi |= 1;
        this.zzj = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzak, reason: merged with bridge method [inline-methods] */
    public void zzQ(zzbhv$zzar zzbhv_zzar) {
        zzbhv_zzar.getClass();
        this.zzm = zzbhv_zzar;
        this.zzi |= 8;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzv, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ဉ\u0003\u0005င\u0004\u0006᠌\u0005\u0007᠌\u0006\b᠌\u0007", new Object[]{"zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzbhv$zzq.zze(), "zzp", zzbhv$zzq.zze(), "zzu", zzbhv$zzq.zze()});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzm();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zza(bArr);
        }
        if (iOrdinal == 5) {
            return zzv;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzm> zzifxVar = zzw;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzm.class) {
            try {
                zzidzVar = zzw;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzv);
                    zzw = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final class zza extends zzidy<zzbhv$zzm, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzm.zzv);
        }

        public zza zzd(String str) {
            zzbg();
            ((zzbhv$zzm) this.zza).zzG(str);
            return this;
        }

        public zza zzs(zzbhv$zzar zzbhv_zzar) {
            zzbg();
            ((zzbhv$zzm) this.zza).zzQ(zzbhv_zzar);
            return this;
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
