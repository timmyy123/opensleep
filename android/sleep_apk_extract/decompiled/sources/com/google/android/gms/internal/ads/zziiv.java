package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zziiv extends zziee implements zzifq {
    private static final zziiv zze;
    private static volatile zzifx zzf;
    private int zza;
    private zzida zzb;
    private zzida zzc;
    private byte zzd = 2;

    static {
        zziiv zziivVar = new zziiv();
        zze = zziivVar;
        zziee.zzbu(zziiv.class, zziivVar);
    }

    private zziiv() {
        zzida zzidaVar = zzida.zza;
        this.zzb = zzidaVar;
        this.zzc = zzidaVar;
    }

    public static zziiu zzc() {
        return (zziiu) zze.zzbn();
    }

    public final /* synthetic */ void zzd(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zza |= 1;
        this.zzb = zzidaVar;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        byte[] bArr = null;
        switch (zziedVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzd);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzd = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zziee.zzbv(zze, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zza", "zzb", "zzc"});
            case NEW_MUTABLE_INSTANCE:
                return new zziiv();
            case NEW_BUILDER:
                return new zziiu(bArr);
            case GET_DEFAULT_INSTANCE:
                return zze;
            case GET_PARSER:
                zzifx zzifxVar = zzf;
                if (zzifxVar != null) {
                    return zzifxVar;
                }
                synchronized (zziiv.class) {
                    try {
                        zzidzVar = zzf;
                        if (zzidzVar == null) {
                            zzidzVar = new zzidz(zze);
                            zzf = zzidzVar;
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

    public final /* synthetic */ void zze(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zza |= 2;
        this.zzc = zzidaVar;
    }
}
