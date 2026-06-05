package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzawo extends zziee implements zzifq {
    private static final zzawo zzj;
    private static volatile zzifx zzk;
    private int zza;
    private int zzb;
    private boolean zze;
    private zzaxf zzg;
    private zzaxl zzh;
    private boolean zzi;
    private boolean zzc = true;
    private String zzd = "unknown_host";
    private boolean zzf = true;

    static {
        zzawo zzawoVar = new zzawo();
        zzj = zzawoVar;
        zziee.zzbu(zzawo.class, zzawoVar);
    }

    private zzawo() {
    }

    public static zzawn zze() {
        return (zzawn) zzj.zzbn();
    }

    public final String zza() {
        return this.zzd;
    }

    @Deprecated
    public final boolean zzb() {
        return this.zze;
    }

    public final zzaxf zzc() {
        zzaxf zzaxfVar = this.zzg;
        return zzaxfVar == null ? zzaxf.zzd() : zzaxfVar;
    }

    public final zzaxl zzd() {
        zzaxl zzaxlVar = this.zzh;
        return zzaxlVar == null ? zzaxl.zza() : zzaxlVar;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzj, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဇ\u0007", new Object[]{"zza", "zzb", zzawr.zza, "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzawo();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzawn(bArr);
        }
        if (iOrdinal == 5) {
            return zzj;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzk;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzawo.class) {
            try {
                zzidzVar = zzk;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzj);
                    zzk = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final /* synthetic */ void zzg(String str) {
        str.getClass();
        this.zza |= 4;
        this.zzd = str;
    }

    public final /* synthetic */ void zzh(boolean z) {
        this.zza |= 8;
        this.zze = z;
    }
}
