package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgfq extends zziee implements zzifq {
    private static final zzgfq zzf;
    private static volatile zzifx zzg;
    private int zza;
    private Object zzc;
    private int zzd;
    private int zzb = 0;
    private zziem zze = zziee.zzbC();

    static {
        zzgfq zzgfqVar = new zzgfq();
        zzf = zzgfqVar;
        zziee.zzbu(zzgfq.class, zzgfqVar);
    }

    private zzgfq() {
    }

    public static zzgfq zze(zzida zzidaVar) {
        return (zzgfq) zziee.zzbS(zzf, zzidaVar);
    }

    public static zzgfp zzg() {
        return (zzgfp) zzf.zzbn();
    }

    public static zzgfq zzh() {
        return zzf;
    }

    public final zzbeb zza() {
        return this.zzb == 1 ? (zzbeb) this.zzc : zzbeb.zzj();
    }

    public final zzbdz zzb() {
        return this.zzb == 2 ? (zzbdz) this.zzc : zzbdz.zzd();
    }

    public final zzbds zzc() {
        zzbds zzbdsVarZzb = zzbds.zzb(this.zzd);
        return zzbdsVarZzb == null ? zzbds.UNSUPPORTED : zzbdsVarZzb;
    }

    public final List zzd() {
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
            return zziee.zzbv(zzf, "\u0004\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001<\u0000\u0002<\u0000\u0003᠌\u0000\u0004'", new Object[]{"zzc", "zzb", "zza", zzbeb.class, zzbdz.class, "zzd", zzbds.zzc(), "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgfq();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzgfp(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzg;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzgfq.class) {
            try {
                zzidzVar = zzg;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzf);
                    zzg = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final /* synthetic */ void zzi(zzbeb zzbebVar) {
        zzbebVar.getClass();
        this.zzc = zzbebVar;
        this.zzb = 1;
    }

    public final /* synthetic */ void zzj(zzbdz zzbdzVar) {
        zzbdzVar.getClass();
        this.zzc = zzbdzVar;
        this.zzb = 2;
    }

    public final /* synthetic */ void zzk(zzbds zzbdsVar) {
        this.zzd = zzbdsVar.zza();
        this.zza |= 1;
    }

    public final /* synthetic */ void zzl(Iterable iterable) {
        zziem zziemVar = this.zze;
        if (!zziemVar.zza()) {
            this.zze = zziee.zzbD(zziemVar);
        }
        zzicj.zzaW(iterable, this.zze);
    }
}
