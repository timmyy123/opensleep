package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbdo extends zziee implements zzifq {
    private static final zzbdo zzc;
    private static volatile zzifx zzd;
    private int zza;
    private zzawq zzb;

    static {
        zzbdo zzbdoVar = new zzbdo();
        zzc = zzbdoVar;
        zziee.zzbu(zzbdo.class, zzbdoVar);
    }

    private zzbdo() {
    }

    public static zzbdn zza() {
        return (zzbdn) zzc.zzbn();
    }

    public final /* synthetic */ void zzb(zzawq zzawqVar) {
        zzawqVar.getClass();
        this.zzb = zzawqVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzc, "\u0004\u0001\u0000\u0001\u0012\u0012\u0001\u0000\u0000\u0000\u0012ဉ\u0000", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzbdo();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzbdn(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzd;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbdo.class) {
            try {
                zzidzVar = zzd;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzc);
                    zzd = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
