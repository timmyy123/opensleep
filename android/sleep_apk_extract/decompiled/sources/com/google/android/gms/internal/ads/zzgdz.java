package com.google.android.gms.internal.ads;

import com.facebook.AuthenticationTokenClaims;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgdz extends zziee implements zzifq {
    private static final zzgdz zzl;
    private static volatile zzifx zzm;
    private int zza;
    private boolean zzc;
    private boolean zzd;
    private long zzh;
    private boolean zzi;
    private boolean zzb = true;
    private long zze = AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED;
    private long zzf = 3600000;
    private String zzg = "https://pagead2.googlesyndication.com/mads/asp";
    private long zzj = 5;
    private long zzk = 60000;

    static {
        zzgdz zzgdzVar = new zzgdz();
        zzl = zzgdzVar;
        zziee.zzbu(zzgdz.class, zzgdzVar);
    }

    private zzgdz() {
    }

    public static zzgdy zzi() {
        return (zzgdy) zzl.zzbn();
    }

    public static zzgdz zzj() {
        return zzl;
    }

    public final boolean zza() {
        return this.zzd;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final long zzd() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzl, "\u0004\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဈ\u0005\u0007ဂ\u0006\bဇ\u0007\tဂ\b\nဂ\t", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (iOrdinal == 3) {
            return new zzgdz();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzgdy(bArr);
        }
        if (iOrdinal == 5) {
            return zzl;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzm;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzgdz.class) {
            try {
                zzidzVar = zzm;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzl);
                    zzm = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final boolean zze() {
        return this.zzi;
    }

    public final long zzg() {
        return this.zzj;
    }

    public final long zzh() {
        return this.zzk;
    }

    public final /* synthetic */ void zzk(boolean z) {
        this.zza |= 4;
        this.zzd = z;
    }

    public final /* synthetic */ void zzl(long j) {
        this.zza |= 64;
        this.zzh = j;
    }
}
