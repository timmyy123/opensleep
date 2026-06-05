package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfqu extends zziee implements zzifq {
    private static final zzfqu zzi;
    private static volatile zzifx zzj;
    private long zzb;
    private long zzc;
    private boolean zzd;
    private long zze;
    private long zzf;
    private int zzh;
    private String zza = "";
    private String zzg = "";

    static {
        zzfqu zzfquVar = new zzfqu();
        zzi = zzfquVar;
        zziee.zzbu(zzfqu.class, zzfquVar);
    }

    private zzfqu() {
    }

    public static zzfqt zza() {
        return (zzfqt) zzi.zzbn();
    }

    public final /* synthetic */ void zzb(String str) {
        str.getClass();
        this.zza = str;
    }

    public final /* synthetic */ void zzc(long j) {
        this.zzb = j;
    }

    public final /* synthetic */ void zzd(long j) {
        this.zzc = j;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzi, "\u0004\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\u0002\u0004\u0007\u0005\u0002\u0006\u0002\u0007Ȉ\b\f", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (iOrdinal == 3) {
            return new zzfqu();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfqt(bArr);
        }
        if (iOrdinal == 5) {
            return zzi;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzj;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzfqu.class) {
            try {
                zzidzVar = zzj;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzi);
                    zzj = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final /* synthetic */ void zze(boolean z) {
        this.zzd = z;
    }

    public final /* synthetic */ void zzg(long j) {
        this.zze = j;
    }

    public final /* synthetic */ void zzh(long j) {
        this.zzf = j;
    }

    public final /* synthetic */ void zzi(String str) {
        str.getClass();
        this.zzg = str;
    }

    public final /* synthetic */ void zzk(int i) {
        this.zzh = i - 2;
    }
}
