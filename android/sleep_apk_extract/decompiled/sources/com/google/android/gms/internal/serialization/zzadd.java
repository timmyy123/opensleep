package com.google.android.gms.internal.serialization;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadd extends zzzg implements zzaar {
    private static final zzadd zzc;
    private static volatile zzaay zzd;
    private String zza = "";
    private zzzs zzb = zzzg.emptyProtobufList();

    static {
        zzadd zzaddVar = new zzadd();
        zzc = zzaddVar;
        zzzg.registerDefaultInstance(zzadd.class, zzaddVar);
    }

    private zzadd() {
    }

    public static zzadd zzc() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzc, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zza", "zzb", zzadg.class});
        }
        if (iOrdinal == 3) {
            return new zzadd();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzadc(bArr);
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
        synchronized (zzadd.class) {
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

    public final String zza() {
        return this.zza;
    }

    public final List zzb() {
        return this.zzb;
    }
}
