package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadn extends zzzg implements zzaar {
    private static final zzadn zzg;
    private static volatile zzaay zzh;
    private int zza;
    private Object zzc;
    private int zzd;
    private int zzb = 0;
    private String zze = "";
    private String zzf = "";

    static {
        zzadn zzadnVar = new zzadn();
        zzg = zzadnVar;
        zzzg.registerDefaultInstance(zzadn.class, zzadnVar);
    }

    private zzadn() {
    }

    public static zzadl zza() {
        return (zzadl) zzg.createBuilder();
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzg, "\u0004\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002Ȼ\u0000\u0003Ȼ\u0000\u0004ለ\u0001\u0005ለ\u0002", new Object[]{"zzc", "zzb", "zza", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzadn();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzadl(bArr);
        }
        if (iOrdinal == 5) {
            return zzg;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zzh;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzadn.class) {
            try {
                zzyzVar = zzh;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zzg);
                    zzh = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }

    public final /* synthetic */ void zzb(zzadm zzadmVar) {
        this.zzd = zzadmVar.getNumber();
        this.zza |= 1;
    }

    public final /* synthetic */ void zzc(String str) {
        this.zzb = 2;
        this.zzc = str;
    }

    public final /* synthetic */ void zzd(String str) {
        this.zzb = 3;
        this.zzc = "home.internal.types.Component";
    }
}
