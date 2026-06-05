package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgat extends zziee implements zzifq {
    private static final zzgat zzn;
    private static volatile zzifx zzo;
    private int zza;
    private long zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private String zzb = "";
    private zziep zzk = zziee.zzbE();
    private zziep zzl = zziee.zzbE();
    private zziep zzm = zziee.zzbE();

    static {
        zzgat zzgatVar = new zzgat();
        zzn = zzgatVar;
        zziee.zzbu(zzgat.class, zzgatVar);
    }

    private zzgat() {
    }

    public static zzgat zzp() {
        return zzn;
    }

    public final /* synthetic */ void zzA(long j) {
        zziep zziepVar = this.zzl;
        if (!zziepVar.zza()) {
            this.zzl = zziee.zzbF(zziepVar);
        }
        this.zzl.zzd(j);
    }

    public final /* synthetic */ void zzB(long j) {
        zziep zziepVar = this.zzm;
        if (!zziepVar.zza()) {
            this.zzm = zziee.zzbF(zziepVar);
        }
        this.zzm.zzd(j);
    }

    public final /* synthetic */ void zzC() {
        this.zzm = zziee.zzbE();
    }

    public final String zza() {
        return this.zzb;
    }

    public final long zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
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
            return zziee.zzbv(zzn, "\u0004\f\u0000\u0001\u0001\f\f\u0000\u0003\u0000\u0001Ȉ\u0002ဂ\u0000\u0003င\u0001\u0004ဇ\u0002\u0005ဇ\u0003\u0006ဂ\u0004\u0007\u0002\bဂ\u0005\tဂ\u0006\n%\u000b%\f%", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (iOrdinal == 3) {
            return new zzgat();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzgas(bArr);
        }
        if (iOrdinal == 5) {
            return zzn;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzo;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzgat.class) {
            try {
                zzidzVar = zzo;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzn);
                    zzo = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final boolean zze() {
        return this.zzf;
    }

    public final long zzg() {
        return this.zzg;
    }

    public final long zzh() {
        return this.zzh;
    }

    public final long zzi() {
        return this.zzi;
    }

    public final boolean zzj() {
        return (this.zza & 64) != 0;
    }

    public final List zzk() {
        return this.zzk;
    }

    public final int zzl() {
        return this.zzk.size();
    }

    public final int zzm() {
        return this.zzl.size();
    }

    public final List zzn() {
        return this.zzm;
    }

    public final int zzo() {
        return this.zzm.size();
    }

    public final /* synthetic */ void zzq(String str) {
        str.getClass();
        this.zzb = str;
    }

    public final /* synthetic */ void zzr(long j) {
        this.zza |= 1;
        this.zzc = j;
    }

    public final /* synthetic */ void zzs(int i) {
        this.zza |= 2;
        this.zzd = i;
    }

    public final /* synthetic */ void zzt(boolean z) {
        this.zza |= 4;
        this.zze = true;
    }

    public final /* synthetic */ void zzu(boolean z) {
        this.zza |= 8;
        this.zzf = true;
    }

    public final /* synthetic */ void zzv(long j) {
        this.zza |= 16;
        this.zzg = j;
    }

    public final /* synthetic */ void zzw(long j) {
        this.zzh = j;
    }

    public final /* synthetic */ void zzx(long j) {
        this.zza |= 32;
        this.zzi = j;
    }

    public final /* synthetic */ void zzy(long j) {
        this.zza |= 64;
        this.zzj = j;
    }

    public final /* synthetic */ void zzz(long j) {
        zziep zziepVar = this.zzk;
        if (!zziepVar.zza()) {
            this.zzk = zziee.zzbF(zziepVar);
        }
        this.zzk.zzd(j);
    }
}
