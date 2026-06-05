package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhtq extends zziee implements zzifq {
    private static final zzhtq zze;
    private static volatile zzifx zzf;
    private int zza;
    private zzhts zzb;
    private int zzc;
    private zzida zzd = zzida.zza;

    static {
        zzhtq zzhtqVar = new zzhtq();
        zze = zzhtqVar;
        zziee.zzbu(zzhtq.class, zzhtqVar);
    }

    private zzhtq() {
    }

    public static zzhtq zzd(zzida zzidaVar, zzido zzidoVar) {
        return (zzhtq) zziee.zzbT(zze, zzidaVar, zzidoVar);
    }

    public static zzhtp zze() {
        return (zzhtp) zze.zzbn();
    }

    public final zzhts zza() {
        zzhts zzhtsVar = this.zzb;
        return zzhtsVar == null ? zzhts.zzc() : zzhtsVar;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final zzida zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\n", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhtq();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhtp(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzf;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzhtq.class) {
            try {
                zzidzVar = zzf;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zze);
                    zzf = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final /* synthetic */ void zzg(zzhts zzhtsVar) {
        zzhtsVar.getClass();
        this.zzb = zzhtsVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzh(int i) {
        this.zzc = i;
    }

    public final /* synthetic */ void zzi(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zzd = zzidaVar;
    }
}
