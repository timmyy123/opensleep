package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhri extends zziee implements zzifq {
    private static final zzhri zzc;
    private static volatile zzifx zzd;
    private int zza;
    private int zzb;

    static {
        zzhri zzhriVar = new zzhri();
        zzc = zzhriVar;
        zziee.zzbu(zzhri.class, zzhriVar);
    }

    private zzhri() {
    }

    public static zzhri zzc(zzida zzidaVar, zzido zzidoVar) {
        return (zzhri) zziee.zzbT(zzc, zzidaVar, zzidoVar);
    }

    public static zzhrh zzd() {
        return (zzhrh) zzc.zzbn();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzc, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzhri();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhrh(bArr);
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
        synchronized (zzhri.class) {
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

    public final /* synthetic */ void zze(int i) {
        this.zza = i;
    }
}
