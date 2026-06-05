package com.google.android.gms.internal.serialization;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaed extends zzzg implements zzaar {
    private static final zzaed zzb;
    private static volatile zzaay zzc;
    private zzzs zza = zzzg.emptyProtobufList();

    static {
        zzaed zzaedVar = new zzaed();
        zzb = zzaedVar;
        zzzg.registerDefaultInstance(zzaed.class, zzaedVar);
    }

    private zzaed() {
    }

    public static zzaay zzb() {
        return zzb.getParserForType();
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzadv.class});
        }
        if (iOrdinal == 3) {
            return new zzaed();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzaec(bArr);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zzc;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzaed.class) {
            try {
                zzyzVar = zzc;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zzb);
                    zzc = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }

    public final List zza() {
        return this.zza;
    }
}
