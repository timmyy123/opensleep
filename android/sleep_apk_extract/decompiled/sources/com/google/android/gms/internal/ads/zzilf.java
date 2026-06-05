package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzilf extends zziee implements zzifq {
    private static final zzilf zzn;
    private static volatile zzifx zzo;
    private int zza;
    private int zzd;
    private boolean zzf;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private zzilk zzk;
    private zzile zzm;
    private String zzb = "";
    private String zzc = "";
    private int zze = 1;
    private String zzg = "";
    private String zzl = "";

    static {
        zzilf zzilfVar = new zzilf();
        zzn = zzilfVar;
        zziee.zzbu(zzilf.class, zzilfVar);
    }

    private zzilf() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzn, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005ဇ\u0004\u0006ဈ\u0005\u0007ဇ\u0006\bင\u0007\t᠌\b\nဉ\t\u000bဈ\n\fဉ\u000b", new Object[]{"zza", "zzb", "zzc", "zzd", zzilo.zza, "zze", zziln.zza, "zzf", "zzg", "zzh", "zzi", "zzj", zzilg.zza, "zzk", "zzl", "zzm"});
        }
        if (iOrdinal == 3) {
            return new zzilf();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzilc(bArr);
        }
        if (iOrdinal == 5) {
            return zzn;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzo;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzilf.class) {
            try {
                zzidzVar = zzo;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzn);
                    zzo = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
