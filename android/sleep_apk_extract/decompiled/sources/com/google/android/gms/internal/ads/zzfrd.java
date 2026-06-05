package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfrd extends zziee implements zzifq {
    private static final zzfrd zzc;
    private static volatile zzifx zzd;
    private zzieq zza = zziee.zzbM();
    private long zzb;

    static {
        zzfrd zzfrdVar = new zzfrd();
        zzc = zzfrdVar;
        zziee.zzbu(zzfrd.class, zzfrdVar);
    }

    private zzfrd() {
    }

    public static zzfrc zza() {
        return (zzfrc) zzc.zzbn();
    }

    public final /* synthetic */ void zzb(zzfpv zzfpvVar) {
        zzfpvVar.getClass();
        zzieq zzieqVar = this.zza;
        if (!zzieqVar.zza()) {
            this.zza = zziee.zzbN(zzieqVar);
        }
        this.zza.add(zzfpvVar);
    }

    public final /* synthetic */ void zzc(long j) {
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzc, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0002", new Object[]{"zza", zzfpv.class, "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzfrd();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfrc(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzd;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzfrd.class) {
            try {
                zzidzVar = zzd;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzc);
                    zzd = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
