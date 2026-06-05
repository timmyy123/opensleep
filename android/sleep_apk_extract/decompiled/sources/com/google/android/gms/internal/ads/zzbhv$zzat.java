package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzat extends zziee<zzbhv$zzat, zza> implements zzifq {
    private static final zzbhv$zzat zzL;
    private static volatile zzifx<zzbhv$zzat> zzM = null;
    public static final int zza = 5;
    public static final int zzb = 6;
    public static final int zzc = 7;
    public static final int zzd = 8;
    public static final int zze = 9;
    public static final int zzf = 10;
    public static final int zzg = 11;
    public static final int zzh = 12;
    public static final int zzi = 13;
    public static final int zzj = 14;
    public static final int zzk = 15;
    public static final int zzl = 16;
    public static final int zzm = 17;
    public static final int zzn = 18;
    public static final int zzo = 19;
    public static final int zzp = 20;
    private zzbhv$zzbc zzA;
    private zzbhv$zzay zzB;
    private int zzC;
    private int zzD;
    private zzbhv$zzap zzE;
    private int zzF;
    private int zzG;
    private int zzH;
    private int zzI;
    private int zzJ;
    private long zzK;
    private int zzu;
    private zzbhv$zzba zzv;
    private zzbhv$zzbe zzw;
    private zzbhv$zzbg zzx;
    private zzbhv$zzbj zzy;
    private zzbhv$zzau zzz;

    static {
        zzbhv$zzat zzbhv_zzat = new zzbhv$zzat();
        zzL = zzbhv_zzat;
        zziee.zzbu(zzbhv$zzat.class, zzbhv_zzat);
    }

    private zzbhv$zzat() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzL, "\u0004\u0010\u0000\u0001\u0005\u0014\u0010\u0000\u0000\u0000\u0005ဉ\u0000\u0006ဉ\u0001\u0007ဉ\u0002\bဉ\u0003\tဉ\u0004\nဉ\u0005\u000bဉ\u0006\fင\u0007\rင\b\u000eဉ\t\u000fင\n\u0010င\u000b\u0011င\f\u0012င\r\u0013င\u000e\u0014ဃ\u000f", new Object[]{"zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzF", "zzG", "zzH", "zzI", "zzJ", "zzK"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzat();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zza(bArr);
        }
        if (iOrdinal == 5) {
            return zzL;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzat> zzifxVar = zzM;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzat.class) {
            try {
                zzidzVar = zzM;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzL);
                    zzM = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final class zza extends zzidy<zzbhv$zzat, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzat.zzL);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
