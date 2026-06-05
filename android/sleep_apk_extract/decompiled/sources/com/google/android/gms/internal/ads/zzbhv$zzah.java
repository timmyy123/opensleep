package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbhv$zzah extends zziee<zzbhv$zzah, zza> implements zzifq {
    private static final zzbhv$zzah zzB;
    private static volatile zzifx<zzbhv$zzah> zzC = null;
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    public static final int zzd = 4;
    public static final int zze = 5;
    public static final int zzf = 6;
    public static final int zzg = 7;
    public static final int zzh = 8;
    public static final int zzi = 9;
    public static final int zzj = 10;
    public static final int zzk = 11;
    private zzbhv$zzai zzA;
    private int zzl;
    private int zzm = 1000;
    private int zzn = 1000;
    private int zzo;
    private int zzp;
    private int zzu;
    private int zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private int zzz;

    static {
        zzbhv$zzah zzbhv_zzah = new zzbhv$zzah();
        zzB = zzbhv_zzah;
        zziee.zzbu(zzbhv$zzah.class, zzbhv_zzah);
    }

    private zzbhv$zzah() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzB, "\u0004\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nင\t\u000bဉ\n", new Object[]{"zzl", "zzm", zzbhv$zzq.zze(), "zzn", zzbhv$zzq.zze(), "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA"});
        }
        if (iOrdinal == 3) {
            return new zzbhv$zzah();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zza(bArr);
        }
        if (iOrdinal == 5) {
            return zzB;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx<zzbhv$zzah> zzifxVar = zzC;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbhv$zzah.class) {
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

    public final class zza extends zzidy<zzbhv$zzah, zza> implements zzifq {
        private zza() {
            super(zzbhv$zzah.zzB);
        }

        public /* synthetic */ zza(byte[] bArr) {
            this();
        }
    }
}
