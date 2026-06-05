package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhsn extends zziee implements zzifq {
    private static final zzhsn zzc;
    private static volatile zzifx zzd;
    private int zza;
    private int zzb;

    static {
        zzhsn zzhsnVar = new zzhsn();
        zzc = zzhsnVar;
        zziee.zzbu(zzhsn.class, zzhsnVar);
    }

    private zzhsn() {
    }

    public static zzhsm zzc() {
        return (zzhsm) zzc.zzbn();
    }

    public static zzhsn zzd() {
        return zzc;
    }

    public final zzhsh zza() {
        zzhsh zzhshVarZzb = zzhsh.zzb(this.zza);
        return zzhshVarZzb == null ? zzhsh.UNRECOGNIZED : zzhshVarZzb;
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
            return zziee.zzbv(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzhsn();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhsm(bArr);
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
        synchronized (zzhsn.class) {
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

    public final /* synthetic */ void zze(zzhsh zzhshVar) {
        this.zza = zzhshVar.zza();
    }

    public final /* synthetic */ void zzg(int i) {
        this.zzb = i;
    }
}
