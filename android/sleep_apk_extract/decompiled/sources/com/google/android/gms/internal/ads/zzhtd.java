package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhtd extends zziee implements zzifq {
    private static final zzhtd zzc;
    private static volatile zzifx zzd;
    private int zza;
    private zzieq zzb = zziee.zzbM();

    static {
        zzhtd zzhtdVar = new zzhtd();
        zzc = zzhtdVar;
        zziee.zzbu(zzhtd.class, zzhtdVar);
    }

    private zzhtd() {
    }

    public static zzhta zza() {
        return (zzhta) zzc.zzbn();
    }

    public final /* synthetic */ void zzb(int i) {
        this.zza = i;
    }

    public final /* synthetic */ void zzc(zzhtc zzhtcVar) {
        zzhtcVar.getClass();
        zzieq zzieqVar = this.zzb;
        if (!zzieqVar.zza()) {
            this.zzb = zziee.zzbN(zzieqVar);
        }
        this.zzb.add(zzhtcVar);
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zza", "zzb", zzhtc.class});
        }
        if (iOrdinal == 3) {
            return new zzhtd();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhta(bArr);
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
        synchronized (zzhtd.class) {
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
