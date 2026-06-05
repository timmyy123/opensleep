package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbeb extends zziee implements zzifq {
    private static final zzbeb zzg;
    private static volatile zzifx zzh;
    private int zza;
    private String zzb = "";
    private String zzc = "";
    private long zzd;
    private long zze;
    private long zzf;

    static {
        zzbeb zzbebVar = new zzbeb();
        zzg = zzbebVar;
        zziee.zzbu(zzbeb.class, zzbebVar);
    }

    private zzbeb() {
    }

    public static zzbeb zzg(zzida zzidaVar) {
        return (zzbeb) zziee.zzbS(zzg, zzidaVar);
    }

    public static zzbeb zzh(zzida zzidaVar, zzido zzidoVar) {
        return (zzbeb) zziee.zzbT(zzg, zzidaVar, zzidoVar);
    }

    public static zzbea zzi() {
        return (zzbea) zzg.zzbn();
    }

    public static zzbeb zzj() {
        return zzg;
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzc;
    }

    public final long zzc() {
        return this.zzd;
    }

    public final long zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzg, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzbeb();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzbea(bArr);
        }
        if (iOrdinal == 5) {
            return zzg;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzh;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbeb.class) {
            try {
                zzidzVar = zzh;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzg);
                    zzh = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final long zze() {
        return this.zzf;
    }

    public final /* synthetic */ void zzk(String str) {
        str.getClass();
        this.zza |= 1;
        this.zzb = str;
    }

    public final /* synthetic */ void zzl(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzc = str;
    }

    public final /* synthetic */ void zzm(long j) {
        this.zza |= 4;
        this.zzd = j;
    }

    public final /* synthetic */ void zzn(long j) {
        this.zza |= 8;
        this.zze = j;
    }

    public final /* synthetic */ void zzo(long j) {
        this.zza |= 16;
        this.zzf = j;
    }
}
