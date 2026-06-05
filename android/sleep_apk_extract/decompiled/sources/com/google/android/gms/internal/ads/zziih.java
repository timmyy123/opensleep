package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zziih extends zziee implements zzifq {
    private static final zziih zzy;
    private static volatile zzifx zzz;
    private int zza;
    private int zzb;
    private boolean zzc;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzp;
    private long zzu;
    private boolean zzw;
    private String zzd = "";
    private zzieq zze = zziee.zzbM();
    private String zzj = "";
    private zzieq zzo = zziee.zzbM();
    private zziem zzv = zziee.zzbC();
    private zziem zzx = zziee.zzbC();

    static {
        zziih zziihVar = new zziih();
        zzy = zziihVar;
        zziee.zzbu(zziih.class, zziihVar);
    }

    private zziih() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzy, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0004\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004\u001a\u0005᠌\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006\tဈ\u0007\nင\b\u000bင\t\fင\n\rဇ\u000b\u000e\u001b\u000fဇ\f\u0010ဂ\r\u0011ࠬ\u0012ဇ\u000e\u0013ࠬ", new Object[]{"zza", "zzb", zziig.zza, "zzc", "zzd", "zze", "zzf", zziie.zza, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zziid.class, "zzp", "zzu", "zzv", zzihv.zza(), "zzw", "zzx", zziif.zza});
        }
        if (iOrdinal == 3) {
            return new zziih();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zziia(bArr);
        }
        if (iOrdinal == 5) {
            return zzy;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzz;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zziih.class) {
            try {
                zzidzVar = zzz;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzy);
                    zzz = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
