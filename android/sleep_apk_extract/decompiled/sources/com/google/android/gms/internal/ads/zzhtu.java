package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhtu extends zziee implements zzifq {
    private static final zzhtu zzj;
    private static volatile zzifx zzk;
    private int zza;
    private int zzb;
    private zzhtw zzc;
    private zzida zzd;
    private zzida zze;
    private zzida zzf;
    private zzida zzg;
    private zzida zzh;
    private zzida zzi;

    static {
        zzhtu zzhtuVar = new zzhtu();
        zzj = zzhtuVar;
        zziee.zzbu(zzhtu.class, zzhtuVar);
    }

    private zzhtu() {
        zzida zzidaVar = zzida.zza;
        this.zzd = zzidaVar;
        this.zze = zzidaVar;
        this.zzf = zzidaVar;
        this.zzg = zzidaVar;
        this.zzh = zzidaVar;
        this.zzi = zzidaVar;
    }

    public static zzhtu zzj(zzida zzidaVar, zzido zzidoVar) throws zziet {
        return (zzhtu) zziee.zzbT(zzj, zzidaVar, zzidoVar);
    }

    public static zzhtt zzk() {
        return (zzhtt) zzj.zzbn();
    }

    public static zzifx zzl() {
        return zzj.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhtw zzb() {
        zzhtw zzhtwVar = this.zzc;
        return zzhtwVar == null ? zzhtw.zzh() : zzhtwVar;
    }

    public final zzida zzc() {
        return this.zzd;
    }

    public final zzida zzd() {
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
            return zziee.zzbv(zzj, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n\u0005\n\u0006\n\u0007\n\b\n", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzhtu();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhtt(bArr);
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
        synchronized (zzhtu.class) {
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

    public final zzida zze() {
        return this.zzf;
    }

    public final zzida zzg() {
        return this.zzg;
    }

    public final zzida zzh() {
        return this.zzh;
    }

    public final zzida zzi() {
        return this.zzi;
    }

    public final /* synthetic */ void zzm(int i) {
        this.zzb = 0;
    }

    public final /* synthetic */ void zzn(zzhtw zzhtwVar) {
        zzhtwVar.getClass();
        this.zzc = zzhtwVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzo(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzd = zzidaVar;
    }

    public final /* synthetic */ void zzp(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zze = zzidaVar;
    }

    public final /* synthetic */ void zzq(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzf = zzidaVar;
    }

    public final /* synthetic */ void zzr(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzg = zzidaVar;
    }

    public final /* synthetic */ void zzs(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzh = zzidaVar;
    }

    public final /* synthetic */ void zzt(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzi = zzidaVar;
    }
}
