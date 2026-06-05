package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadz extends zzzg implements zzaar {
    private static final zzadz zzd;
    private static volatile zzaay zze;
    private int zza;
    private zzadr zzb;
    private zzadx zzc;

    static {
        zzadz zzadzVar = new zzadz();
        zzd = zzadzVar;
        zzzg.registerDefaultInstance(zzadz.class, zzadzVar);
    }

    private zzadz() {
    }

    public static zzady zza() {
        return (zzady) zzd.createBuilder();
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
            return new zzadz();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzady(bArr);
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
        synchronized (zzadz.class) {
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
}
