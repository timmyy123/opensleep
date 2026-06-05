package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhtf extends zziee implements zzifq {
    private static final zzhtf zzd;
    private static volatile zzifx zze;
    private int zza;
    private int zzb;
    private zzhth zzc;

    static {
        zzhtf zzhtfVar = new zzhtf();
        zzd = zzhtfVar;
        zziee.zzbu(zzhtf.class, zzhtfVar);
    }

    private zzhtf() {
    }

    public static zzhtf zzc(zzida zzidaVar, zzido zzidoVar) {
        return (zzhtf) zziee.zzbT(zzd, zzidaVar, zzidoVar);
    }

    public static zzhte zzd() {
        return (zzhte) zzd.zzbn();
    }

    public static zzifx zze() {
        return zzd.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhth zzb() {
        zzhth zzhthVar = this.zzc;
        return zzhthVar == null ? zzhth.zzd() : zzhthVar;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhtf();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhte(bArr);
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
        synchronized (zzhtf.class) {
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

    public final /* synthetic */ void zzg(zzhth zzhthVar) {
        zzhthVar.getClass();
        this.zzc = zzhthVar;
        this.zza |= 1;
    }
}
