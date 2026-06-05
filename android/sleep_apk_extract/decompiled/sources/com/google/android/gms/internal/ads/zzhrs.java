package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhrs extends zziee implements zzifq {
    private static final zzhrs zzd;
    private static volatile zzifx zze;
    private int zza;
    private zzhru zzb;
    private int zzc;

    static {
        zzhrs zzhrsVar = new zzhrs();
        zzd = zzhrsVar;
        zziee.zzbu(zzhrs.class, zzhrsVar);
    }

    private zzhrs() {
    }

    public static zzhrs zzb(zzida zzidaVar, zzido zzidoVar) {
        return (zzhrs) zziee.zzbT(zzd, zzidaVar, zzidoVar);
    }

    public static zzhrr zzc() {
        return (zzhrr) zzd.zzbn();
    }

    public final zzhru zza() {
        zzhru zzhruVar = this.zzb;
        return zzhruVar == null ? zzhru.zzc() : zzhruVar;
    }

    public final /* synthetic */ void zzd(zzhru zzhruVar) {
        zzhruVar.getClass();
        this.zzb = zzhruVar;
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
            return zziee.zzbv(zzd, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002ဉ\u0000\u0003\u000b", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhrs();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhrr(bArr);
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
        synchronized (zzhrs.class) {
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
