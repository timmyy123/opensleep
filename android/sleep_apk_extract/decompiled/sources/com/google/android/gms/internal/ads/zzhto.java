package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class zzhto extends zziee implements zzifq {
    public static final /* synthetic */ int zza = 0;
    private static final zzhto zzd;
    private static volatile zzifx zze;
    private String zzb = "";
    private zzieq zzc = zziee.zzbM();

    static {
        zzhto zzhtoVar = new zzhto();
        zzd = zzhtoVar;
        zziee.zzbu(zzhto.class, zzhtoVar);
    }

    private zzhto() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzd, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzb", "zzc", zzhsv.class});
        }
        if (iOrdinal == 3) {
            return new zzhto();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhtn(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zze;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzhto.class) {
            try {
                zzidzVar = zze;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzd);
                    zze = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
