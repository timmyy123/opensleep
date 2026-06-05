package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zziit extends zziee implements zzifq {
    private static final zziit zzf;
    private static volatile zzifx zzg;
    private int zza;
    private int zzb;
    private int zzc;
    private boolean zzd;
    private long zze;

    static {
        zziit zziitVar = new zziit();
        zzf = zziitVar;
        zziee.zzbu(zziit.class, zziitVar);
    }

    private zziit() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004ဂ\u0003", new Object[]{"zza", "zzb", zziis.zza, "zzc", zziiq.zza, "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zziit();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zziir(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzg;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zziit.class) {
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
}
