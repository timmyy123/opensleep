package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzi extends zziee<zzbhv$zzi, zza> implements zzifq {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    public static final int zzd = 4;
    public static final int zze = 5;
    private static final zzbhv$zzi zzl;
    private static volatile zzifx<zzbhv$zzi> zzm;
    private int zzf;
    private String zzg = "";
    private zzieq<zzbhv$zzd> zzh = zziee.zzbM();
    private int zzi = 1000;
    private int zzj = 1000;
    private int zzk = 1000;

    static {
        zzbhv$zzi zzbhv_zzi = new zzbhv$zzi();
        zzl = zzbhv_zzi;
        zziee.zzbu(zzbhv$zzi.class, zzbhv_zzi);
    }

    private zzbhv$zzi() {
    }

    public static zzbhv$zzi zzD() {
        return zzl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzV, reason: merged with bridge method [inline-methods] */
    public void zzF(String str) {
        str.getClass();
        this.zzf |= 1;
        this.zzg = str;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzl, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003᠌\u0001\u0004᠌\u0002\u0005᠌\u0003", new Object[]{"zzf", "zzg", "zzh", zzbhv$zzd.class, "zzi", zzbhv$zzq.zze(), "zzj", zzbhv$zzq.zze(), "zzk", zzbhv$zzq.zze()});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzi();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zza(bArr);
        }
        if (iOrdinal == 5) {
            return zzl;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzi> zzifxVar = zzm;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzi.class) {
            try {
                zzidzVar = zzm;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzl);
                    zzm = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final class zza extends zzidy<zzbhv$zzi, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzi.zzl);
        }

        public zza zzd(String str) {
            zzbg();
            ((zzbhv$zzi) this.zza).zzF(str);
            return this;
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
