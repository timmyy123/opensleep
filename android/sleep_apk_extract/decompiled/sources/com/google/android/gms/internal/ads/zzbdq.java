package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbdq extends zziee implements zzifq {
    private static final zzbdq zzd;
    private static volatile zzifx zze;
    private int zza;
    private zzieq zzb = zziee.zzbM();
    private zzihr zzc;

    static {
        zzbdq zzbdqVar = new zzbdq();
        zzd = zzbdqVar;
        zziee.zzbu(zzbdq.class, zzbdqVar);
    }

    private zzbdq() {
    }

    public static zzbdp zza() {
        return (zzbdp) zzd.zzbn();
    }

    public final /* synthetic */ void zzb(zzbdo zzbdoVar) {
        zzbdoVar.getClass();
        zzieq zzieqVar = this.zzb;
        if (!zzieqVar.zza()) {
            this.zzb = zziee.zzbN(zzieqVar);
        }
        this.zzb.add(zzbdoVar);
    }

    public final /* synthetic */ void zzc(zzihr zzihrVar) {
        zzihrVar.getClass();
        this.zzc = zzihrVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzd, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zza", "zzb", zzbdo.class, "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzbdq();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzbdp(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zze;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbdq.class) {
            try {
                zzidzVar = zze;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzd);
                    zze = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
