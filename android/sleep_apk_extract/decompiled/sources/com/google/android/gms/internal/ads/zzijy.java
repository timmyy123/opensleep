package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzijy extends zziee implements zzifq {
    private static final zzijy zzl;
    private static volatile zzifx zzm;
    private int zza;
    private int zzb;
    private zziiz zzd;
    private zzijd zze;
    private int zzf;
    private int zzi;
    private byte zzk = 2;
    private String zzc = "";
    private zziem zzg = zziee.zzbC();
    private String zzh = "";
    private zzieq zzj = zziee.zzbM();

    static {
        zzijy zzijyVar = new zzijy();
        zzl = zzijyVar;
        zziee.zzbu(zzijy.class, zzijyVar);
    }

    private zzijy() {
    }

    public static zzijx zze() {
        return (zzijx) zzl.zzbn();
    }

    public final String zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzj.size();
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        byte[] bArr = null;
        switch (zziedVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzk);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzk = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zziee.zzbv(zzl, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\b᠌\u0006\t\u001a", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzijv.zza, "zzj"});
            case NEW_MUTABLE_INSTANCE:
                return new zzijy();
            case NEW_BUILDER:
                return new zzijx(bArr);
            case GET_DEFAULT_INSTANCE:
                return zzl;
            case GET_PARSER:
                zzifx zzifxVar = zzm;
                if (zzifxVar != null) {
                    return zzifxVar;
                }
                synchronized (zzijy.class) {
                    try {
                        zzidzVar = zzm;
                        if (zzidzVar == null) {
                            zzidzVar = new zzidz(zzl);
                            zzm = zzidzVar;
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

    public final /* synthetic */ void zzg(int i) {
        this.zza |= 1;
        this.zzb = i;
    }

    public final /* synthetic */ void zzh(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzc = str;
    }

    public final /* synthetic */ void zzi(zziiz zziizVar) {
        zziizVar.getClass();
        this.zzd = zziizVar;
        this.zza |= 4;
    }

    public final /* synthetic */ void zzj(String str) {
        str.getClass();
        zzieq zzieqVar = this.zzj;
        if (!zzieqVar.zza()) {
            this.zzj = zziee.zzbN(zzieqVar);
        }
        this.zzj.add(str);
    }

    public final /* synthetic */ void zzl(int i) {
        this.zzi = i - 1;
        this.zza |= 64;
    }
}
