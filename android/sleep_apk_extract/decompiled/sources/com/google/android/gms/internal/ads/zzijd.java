package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzijd extends zziee implements zzifq {
    private static final zzijd zzi;
    private static volatile zzifx zzj;
    private int zza;
    private zzijc zzb;
    private zzida zzd;
    private zzida zze;
    private int zzf;
    private zzida zzg;
    private byte zzh = 2;
    private zzieq zzc = zziee.zzbM();

    static {
        zzijd zzijdVar = new zzijd();
        zzi = zzijdVar;
        zziee.zzbu(zzijd.class, zzijdVar);
    }

    private zzijd() {
        zzida zzidaVar = zzida.zza;
        this.zzd = zzidaVar;
        this.zze = zzidaVar;
        this.zzg = zzidaVar;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        byte[] bArr = null;
        switch (zziedVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzh);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzh = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zziee.zzbv(zzi, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zza", "zzb", "zzc", zziiv.class, "zzd", "zze", "zzf", "zzg"});
            case NEW_MUTABLE_INSTANCE:
                return new zzijd();
            case NEW_BUILDER:
                return new zzija(bArr);
            case GET_DEFAULT_INSTANCE:
                return zzi;
            case GET_PARSER:
                zzifx zzifxVar = zzj;
                if (zzifxVar != null) {
                    return zzifxVar;
                }
                synchronized (zzijd.class) {
                    try {
                        zzidzVar = zzj;
                        if (zzidzVar == null) {
                            zzidzVar = new zzidz(zzi);
                            zzj = zzidzVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return zzidzVar;
            default:
                throw null;
        }
    }
}
