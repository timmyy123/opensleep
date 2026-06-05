package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzikx extends zziee implements zzifq {
    private static final zzikx zzp;
    private static volatile zzifx zzu;
    private int zza;
    private boolean zzh;
    private double zzi;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private String zzb = "";
    private String zzc = "";
    private int zzd = 4;
    private zzieq zze = zziee.zzbM();
    private String zzf = "";
    private String zzg = "";
    private zzieq zzj = zziee.zzbM();

    static {
        zzikx zzikxVar = new zzikx();
        zzp = zzikxVar;
        zziee.zzbu(zzikx.class, zzikxVar);
    }

    private zzikx() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzp, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0002\u0003\u001a\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007က\u0006\b\u001b\tဈ\u0001\n᠌\u0007\u000bဇ\b\fဇ\t\rဇ\n\u000eဇ\u000b", new Object[]{"zza", "zzb", "zzd", zzikw.zza, "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzikv.class, "zzc", "zzk", zzikt.zza, "zzl", "zzm", "zzn", "zzo"});
        }
        if (iOrdinal == 3) {
            return new zzikx();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zziks(bArr);
        }
        if (iOrdinal == 5) {
            return zzp;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzu;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzikx.class) {
            try {
                zzidzVar = zzu;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzp);
                    zzu = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
