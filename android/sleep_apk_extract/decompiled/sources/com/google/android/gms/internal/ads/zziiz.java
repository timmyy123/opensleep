package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zziiz extends zziee implements zzifq {
    private static final zziiz zzh;
    private static volatile zzifx zzi;
    private int zza;
    private zziiy zzb;
    private zzida zzd;
    private zzida zze;
    private int zzf;
    private byte zzg = 2;
    private zzieq zzc = zziee.zzbM();

    static {
        zziiz zziizVar = new zziiz();
        zzh = zziizVar;
        zziee.zzbu(zziiz.class, zziizVar);
    }

    private zziiz() {
        zzida zzidaVar = zzida.zza;
        this.zzd = zzidaVar;
        this.zze = zzidaVar;
    }

    public static zziiw zzc() {
        return (zziiw) zzh.zzbn();
    }

    public final /* synthetic */ void zzd(zziiv zziivVar) {
        zziivVar.getClass();
        zzieq zzieqVar = this.zzc;
        if (!zzieqVar.zza()) {
            this.zzc = zziee.zzbN(zzieqVar);
        }
        this.zzc.add(zziivVar);
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        byte[] bArr = null;
        switch (zziedVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzg);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzg = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zziee.zzbv(zzh, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zza", "zzb", "zzc", zziiv.class, "zzd", "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zziiz();
            case NEW_BUILDER:
                return new zziiw(bArr);
            case GET_DEFAULT_INSTANCE:
                return zzh;
            case GET_PARSER:
                zzifx zzifxVar = zzi;
                if (zzifxVar != null) {
                    return zzifxVar;
                }
                synchronized (zziiz.class) {
                    try {
                        zzidzVar = zzi;
                        if (zzidzVar == null) {
                            zzidzVar = new zzidz(zzh);
                            zzi = zzidzVar;
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
