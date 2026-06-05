package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgdf extends zziee implements zzifq {
    private static final zzgdf zzD;
    private static volatile zzifx zzE;
    private boolean zzC;
    private int zza;
    private int zzb;
    private boolean zze;
    private boolean zzf;
    private int zzh;
    private zzgdx zzj;
    private boolean zzk;
    private zzgdz zzn;
    private int zzc = 1;
    private boolean zzd = true;
    private String zzg = "unknown_host";
    private boolean zzi = true;
    private long zzl = 100;
    private long zzm = 2000;
    private long zzo = 10;
    private long zzp = 100;
    private long zzu = 20000;
    private String zzv = "";
    private String zzw = "";
    private long zzx = 500;
    private long zzy = 3000;
    private boolean zzz = true;
    private boolean zzA = true;
    private boolean zzB = true;

    static {
        zzgdf zzgdfVar = new zzgdf();
        zzD = zzgdfVar;
        zziee.zzbu(zzgdf.class, zzgdfVar);
    }

    private zzgdf() {
    }

    public static zzgdd zzw() {
        return (zzgdd) zzD.zzbn();
    }

    public final /* synthetic */ void zzA(long j) {
        this.zza |= 1024;
        this.zzl = j;
    }

    public final /* synthetic */ void zzB(long j) {
        this.zza |= 2048;
        this.zzm = j;
    }

    public final /* synthetic */ void zzC(zzgdz zzgdzVar) {
        zzgdzVar.getClass();
        this.zzn = zzgdzVar;
        this.zza |= 4096;
    }

    public final /* synthetic */ void zzD(long j) {
        this.zza |= 524288;
        this.zzy = j;
    }

    public final /* synthetic */ void zzE(boolean z) {
        this.zza |= 1048576;
        this.zzz = z;
    }

    public final int zzG() {
        int iZza = zzgdh.zza(this.zzb);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public final int zzH() {
        int iZza = zzgdh.zza(this.zzc);
        if (iZza == 0) {
            return 2;
        }
        return iZza;
    }

    public final int zzI() {
        int i = this.zzh;
        int i2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? 0 : 5 : 4 : 3 : 2;
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    public final /* synthetic */ void zzJ(int i) {
        this.zzb = i - 1;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzK(int i) {
        this.zzh = zzgde.zza(3);
        this.zza |= 64;
    }

    public final boolean zza() {
        return this.zzd;
    }

    public final boolean zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            zziek zziekVar = zzgdg.zza;
            return zziee.zzbv(zzD, "\u0004\u0018\u0000\u0001\u0001\u0019\u0018\u0000\u0000\u0000\u0001᠌\u0000\u0003ဈ\u0005\u0004ဇ\u0007\u0005ဉ\b\u0006ဇ\t\u0007ဂ\u000b\bဉ\f\tဇ\u0002\nဂ\r\u000bဂ\u000e\fဂ\u000f\rဈ\u0010\u000eဈ\u0011\u000fဂ\u0012\u0010ဂ\u0013\u0011ဇ\u0014\u0012ဂ\n\u0013ဇ\u0015\u0014ဇ\u0016\u0015ဇ\u0017\u0016᠌\u0001\u0017ဇ\u0003\u0018ဇ\u0004\u0019ဌ\u0006", new Object[]{"zza", "zzb", zziekVar, "zzg", "zzi", "zzj", "zzk", "zzm", "zzn", "zzd", "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzl", "zzA", "zzB", "zzC", "zzc", zziekVar, "zze", "zzf", "zzh"});
        }
        if (iOrdinal == 3) {
            return new zzgdf();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzgdd(bArr);
        }
        if (iOrdinal == 5) {
            return zzD;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzE;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzgdf.class) {
            try {
                zzidzVar = zzE;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzD);
                    zzE = zzidzVar;
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

    public final zzgdx zzg() {
        zzgdx zzgdxVar = this.zzj;
        return zzgdxVar == null ? zzgdx.zzg() : zzgdxVar;
    }

    public final boolean zzh() {
        return this.zzk;
    }

    public final long zzi() {
        return this.zzl;
    }

    public final long zzj() {
        return this.zzm;
    }

    public final zzgdz zzk() {
        zzgdz zzgdzVar = this.zzn;
        return zzgdzVar == null ? zzgdz.zzj() : zzgdzVar;
    }

    public final long zzl() {
        return this.zzo;
    }

    public final long zzm() {
        return this.zzp;
    }

    public final long zzn() {
        return this.zzu;
    }

    public final String zzo() {
        return this.zzv;
    }

    public final String zzp() {
        return this.zzw;
    }

    public final long zzq() {
        return this.zzx;
    }

    public final long zzr() {
        return this.zzy;
    }

    public final boolean zzs() {
        return this.zzz;
    }

    public final boolean zzt() {
        return this.zzA;
    }

    public final boolean zzu() {
        return this.zzB;
    }

    public final boolean zzv() {
        return this.zzC;
    }

    public final /* synthetic */ void zzx(boolean z) {
        this.zza |= 4;
        this.zzd = z;
    }

    public final /* synthetic */ void zzy(String str) {
        str.getClass();
        this.zza |= 32;
        this.zzg = str;
    }

    public final /* synthetic */ void zzz(zzgdx zzgdxVar) {
        zzgdxVar.getClass();
        this.zzj = zzgdxVar;
        this.zza |= 256;
    }
}
