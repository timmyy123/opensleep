package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaef extends zzzg implements zzaar {
    private static final zzaef zzd;
    private static volatile zzaay zze;
    private int zza;
    private zzadr zzb;
    private zzadx zzc;

    static {
        zzaef zzaefVar = new zzaef();
        zzd = zzaefVar;
        zzzg.registerDefaultInstance(zzaef.class, zzaefVar);
    }

    private zzaef() {
    }

    public static zzaee zza() {
        return (zzaee) zzd.createBuilder();
    }

    public static zzaay zzb() {
        return zzd.getParserForType();
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzd, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzaef();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzaee(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zze;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzaef.class) {
            try {
                zzyzVar = zze;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zzd);
                    zze = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }

    public final /* synthetic */ void zzc(zzadr zzadrVar) {
        zzadrVar.getClass();
        this.zzb = zzadrVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void zzd(zzadx zzadxVar) {
        zzadxVar.getClass();
        this.zzc = zzadxVar;
        this.zza |= 2;
    }
}
