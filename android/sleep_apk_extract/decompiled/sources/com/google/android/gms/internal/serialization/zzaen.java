package com.google.android.gms.internal.serialization;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaen extends zzzg implements zzaar {
    private static final zzaen zzb;
    private static volatile zzaay zzc;
    private zzzs zza = zzzg.emptyProtobufList();

    static {
        zzaen zzaenVar = new zzaen();
        zzb = zzaenVar;
        zzzg.registerDefaultInstance(zzaen.class, zzaenVar);
    }

    private zzaen() {
    }

    public static zzaen zzb(byte[] bArr) {
        return (zzaen) zzzg.parseFrom(zzb, bArr);
    }

    public static zzaay zzc() {
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
            return zzzg.newMessageInfo(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzacz.class});
        }
        if (iOrdinal == 3) {
            return new zzaen();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzaem(bArr);
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
        synchronized (zzaen.class) {
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
