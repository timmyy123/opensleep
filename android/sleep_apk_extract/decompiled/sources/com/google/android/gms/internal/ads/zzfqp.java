package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfqp extends zziee implements zzifq {
    private static final zzfqp zzc;
    private static volatile zzifx zzd;
    private int zza;
    private zzfqm zzb;

    static {
        zzfqp zzfqpVar = new zzfqp();
        zzc = zzfqpVar;
        zziee.zzbu(zzfqp.class, zzfqpVar);
    }

    private zzfqp() {
    }

    public static zzfqo zza() {
        return (zzfqo) zzc.zzbn();
    }

    public final /* synthetic */ void zzb(zzfqm zzfqmVar) {
        zzfqmVar.getClass();
        this.zzb = zzfqmVar;
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
            return zziee.zzbv(zzc, "\u0004\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0000\u0006ဉ\u0000", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzfqp();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfqo(bArr);
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
        synchronized (zzfqp.class) {
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
