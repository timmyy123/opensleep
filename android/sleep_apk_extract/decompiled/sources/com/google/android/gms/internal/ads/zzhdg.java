package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhdg extends zziee implements zzifq {
    private static final zzhdg zzf;
    private static volatile zzifx zzg;
    private int zza;
    private zzhdd zzb;
    private zzigr zzc;
    private zzieq zzd = zziee.zzbM();
    private zziep zze = zziee.zzbE();

    static {
        zzhdg zzhdgVar = new zzhdg();
        zzf = zzhdgVar;
        zziee.zzbu(zzhdg.class, zzhdgVar);
    }

    private zzhdg() {
    }

    public static zzhdf zza() {
        return (zzhdf) zzf.zzbn();
    }

    public final /* synthetic */ void zzb(zzhdd zzhddVar) {
        zzhddVar.getClass();
        this.zzb = zzhddVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzc(Iterable iterable) {
        zziep zziepVar = this.zze;
        if (!zziepVar.zza()) {
            this.zze = zziee.zzbF(zziepVar);
        }
        zzicj.zzaW(iterable, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004%", new Object[]{"zza", "zzb", "zzc", "zzd", zzigr.class, "zze"});
        }
        if (iOrdinal == 3) {
            return new zzhdg();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhdf(bArr);
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
        synchronized (zzhdg.class) {
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
}
