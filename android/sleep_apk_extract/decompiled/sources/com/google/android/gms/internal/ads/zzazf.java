package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzazf extends zziee implements zzifq {
    private static final zzazf zzf;
    private static volatile zzifx zzg;
    private int zza;
    private zzieq zzb = zziee.zzbM();
    private zzida zzc = zzida.zza;
    private int zzd = 1;
    private int zze = 1;

    static {
        zzazf zzazfVar = new zzazf();
        zzf = zzazfVar;
        zziee.zzbu(zzazf.class, zzazfVar);
    }

    private zzazf() {
    }

    public static zzaze zza() {
        return (zzaze) zzf.zzbn();
    }

    public final /* synthetic */ void zzb(zzida zzidaVar) {
        zzidaVar.getClass();
        zzieq zzieqVar = this.zzb;
        if (!zzieqVar.zza()) {
            this.zzb = zziee.zzbN(zzieqVar);
        }
        this.zzb.add(zzidaVar);
    }

    public final /* synthetic */ void zzc(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zza |= 1;
        this.zzc = zzidaVar;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zza", "zzb", "zzc", "zzd", zzayz.zza, "zze", zzayv.zza});
        }
        if (iOrdinal == 3) {
            return new zzazf();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzaze(bArr);
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
        synchronized (zzazf.class) {
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

    public final /* synthetic */ void zze(int i) {
        this.zzd = 4;
        this.zza |= 2;
    }

    public final /* synthetic */ void zzg(int i) {
        this.zze = i - 1;
        this.zza |= 4;
    }
}
