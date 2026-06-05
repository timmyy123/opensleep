package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhro extends zziee implements zzifq {
    private static final zzhro zzc;
    private static volatile zzifx zzd;
    private int zza;
    private zzida zzb = zzida.zza;

    static {
        zzhro zzhroVar = new zzhro();
        zzc = zzhroVar;
        zziee.zzbu(zzhro.class, zzhroVar);
    }

    private zzhro() {
    }

    public static zzhro zzc(zzida zzidaVar, zzido zzidoVar) {
        return (zzhro) zziee.zzbT(zzc, zzidaVar, zzidoVar);
    }

    public static zzhrn zzd() {
        return (zzhrn) zzc.zzbn();
    }

    public static zzifx zze() {
        return zzc.zzbd();
    }

    public final int zza() {
        return this.zza;
    }

    public final zzida zzb() {
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
            return zziee.zzbv(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzhro();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhrn(bArr);
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
        synchronized (zzhro.class) {
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

    public final /* synthetic */ void zzg(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzb = zzidaVar;
    }
}
