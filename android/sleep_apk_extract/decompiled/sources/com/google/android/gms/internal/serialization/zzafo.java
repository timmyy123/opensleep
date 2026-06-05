package com.google.android.gms.internal.serialization;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzafo extends zzzg implements zzaar {
    private static final zzafo zzd;
    private static volatile zzaay zze;
    private long zza;
    private zzzo zzb = zzzg.emptyIntList();
    private long zzc;

    static {
        zzafo zzafoVar = new zzafo();
        zzd = zzafoVar;
        zzzg.registerDefaultInstance(zzafo.class, zzafoVar);
    }

    private zzafo() {
    }

    public static zzafo zzd(byte[] bArr) {
        return (zzafo) zzzg.parseFrom(zzd, bArr);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzd, "\u0004\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0003\u0002+\u0003\u0003", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzafo();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzafn(bArr);
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
        synchronized (zzafo.class) {
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

    public final long zza() {
        return this.zza;
    }

    public final List zzb() {
        return this.zzb;
    }

    public final long zzc() {
        return this.zzc;
    }
}
