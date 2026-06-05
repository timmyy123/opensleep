package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzijc extends zziee implements zzifq {
    private static final zzijc zze;
    private static volatile zzifx zzf;
    private int zza;
    private int zzb;
    private zzida zzc;
    private zzida zzd;

    static {
        zzijc zzijcVar = new zzijc();
        zze = zzijcVar;
        zziee.zzbu(zzijc.class, zzijcVar);
    }

    private zzijc() {
        zzida zzidaVar = zzida.zza;
        this.zzc = zzidaVar;
        this.zzd = zzidaVar;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zze, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzijc();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzijb(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzf;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzijc.class) {
            try {
                zzidzVar = zzf;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zze);
                    zzf = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
