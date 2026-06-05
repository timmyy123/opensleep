package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhqw extends zziee implements zzifq {
    private static final zzhqw zzd;
    private static volatile zzifx zze;
    private int zza;
    private zzhqy zzb;
    private int zzc;

    static {
        zzhqw zzhqwVar = new zzhqw();
        zzd = zzhqwVar;
        zziee.zzbu(zzhqw.class, zzhqwVar);
    }

    private zzhqw() {
    }

    public static zzhqv zzc() {
        return (zzhqv) zzd.zzbn();
    }

    public static zzhqw zzd() {
        return zzd;
    }

    public final zzhqy zza() {
        zzhqy zzhqyVar = this.zzb;
        return zzhqyVar == null ? zzhqy.zzc() : zzhqyVar;
    }

    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhqw();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhqv(bArr);
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
        synchronized (zzhqw.class) {
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

    public final /* synthetic */ void zze(zzhqy zzhqyVar) {
        zzhqyVar.getClass();
        this.zzb = zzhqyVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzg(int i) {
        this.zzc = i;
    }
}
