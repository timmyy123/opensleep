package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzils extends zziee implements zzifq {
    private static final zzils zzj;
    private static volatile zzifx zzk;
    private int zza;
    private zzilb zzh;
    private String zzb = "";
    private String zzc = "";
    private zzieq zzd = zziee.zzbM();
    private zzieq zze = zziee.zzbM();
    private zzieq zzf = zziee.zzbM();
    private int zzg = -1;
    private String zzi = "";

    static {
        zzils zzilsVar = new zzils();
        zzj = zzilsVar;
        zziee.zzbu(zzils.class, zzilsVar);
    }

    private zzils() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzj, "\u0001\b\u0000\u0001\u0001\n\b\u0000\u0003\u0000\u0001ဈ\u0001\u0002\u001b\u0003\u001b\u0004င\u0002\u0005ဈ\u0000\b\u001b\tဈ\u0004\nဉ\u0003", new Object[]{"zza", "zzc", "zzd", zzilf.class, "zze", zzilm.class, "zzg", "zzb", "zzf", zzilz.class, "zzi", "zzh"});
        }
        if (iOrdinal == 3) {
            return new zzils();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzilr(bArr);
        }
        if (iOrdinal == 5) {
            return zzj;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzk;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzils.class) {
            try {
                zzidzVar = zzk;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzj);
                    zzk = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
