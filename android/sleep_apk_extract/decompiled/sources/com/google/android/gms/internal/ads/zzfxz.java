package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfxz extends zziee implements zzifq {
    private static final zzfxz zzf;
    private static volatile zzifx zzg;
    private int zza;
    private zziem zzb = zziee.zzbC();
    private String zzc = "";
    private String zzd = "";
    private String zze = "";

    static {
        zzfxz zzfxzVar = new zzfxz();
        zzf = zzfxzVar;
        zziee.zzbu(zzfxz.class, zzfxzVar);
    }

    private zzfxz() {
    }

    public static zzfxy zza() {
        return (zzfxy) zzf.zzbn();
    }

    public final /* synthetic */ void zzb(String str) {
        str.getClass();
        this.zza |= 1;
        this.zzc = str;
    }

    public final /* synthetic */ void zzd(int i) {
        zziem zziemVar = this.zzb;
        if (!zziemVar.zza()) {
            this.zzb = zziee.zzbD(zziemVar);
        }
        this.zzb.zzi(2);
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ࠞ\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zza", "zzb", zzfxx.zza, "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzfxz();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfxy(bArr);
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
        synchronized (zzfxz.class) {
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
