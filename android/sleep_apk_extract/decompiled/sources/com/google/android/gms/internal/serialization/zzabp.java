package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzabp extends zzzg implements zzaar {
    private static final zzabp zzc;
    private static volatile zzaay zzd;
    private long zza;
    private int zzb;

    static {
        zzabp zzabpVar = new zzabp();
        zzc = zzabpVar;
        zzzg.registerDefaultInstance(zzabp.class, zzabpVar);
    }

    private zzabp() {
    }

    public static zzabo zzc() {
        return (zzabo) zzc.createBuilder();
    }

    public static zzabp zzd() {
        return zzc;
    }

    public static zzaay zze() {
        return zzc.getParserForType();
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzabp();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzabo(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zzd;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzabp.class) {
            try {
                zzyzVar = zzd;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zzc);
                    zzd = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }

    public final long zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final /* synthetic */ void zzf(long j) {
        this.zza = j;
    }

    public final /* synthetic */ void zzg(int i) {
        this.zzb = i;
    }
}
