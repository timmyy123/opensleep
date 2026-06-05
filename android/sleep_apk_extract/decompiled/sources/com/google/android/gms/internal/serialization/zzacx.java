package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzacx extends zzzg implements zzaar {
    private static final zzacx zzf;
    private static volatile zzaay zzg;
    private int zza;
    private String zzb = "";
    private zzaep zzc;
    private boolean zzd;
    private zzadk zze;

    static {
        zzacx zzacxVar = new zzacx();
        zzf = zzacxVar;
        zzzg.registerDefaultInstance(zzacx.class, zzacxVar);
    }

    private zzacx() {
    }

    public static zzacw zza() {
        return (zzacw) zzf.createBuilder();
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzf, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဇ\u0001\u0004ဉ\u0002", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzacx();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzacw(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zzg;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzacx.class) {
            try {
                zzyzVar = zzg;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zzf);
                    zzg = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }

    public final /* synthetic */ void zzb(String str) {
        str.getClass();
        this.zzb = str;
    }

    public final /* synthetic */ void zzc(zzaep zzaepVar) {
        zzaepVar.getClass();
        this.zzc = zzaepVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzd(boolean z) {
        this.zza |= 2;
        this.zzd = z;
    }
}
