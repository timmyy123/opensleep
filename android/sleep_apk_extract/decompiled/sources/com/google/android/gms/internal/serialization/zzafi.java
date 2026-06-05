package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzafi extends zzzg implements zzaar {
    private static final zzafi zzb;
    private static volatile zzaay zzc;
    private int zza;

    static {
        zzafi zzafiVar = new zzafi();
        zzb = zzafiVar;
        zzzg.registerDefaultInstance(zzafi.class, zzafiVar);
    }

    private zzafi() {
    }

    public static zzafi zzb(byte[] bArr) {
        return (zzafi) zzzg.parseFrom(zzb, bArr);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzafi();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzafh(bArr);
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
        synchronized (zzafi.class) {
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

    public final zzafg zza() {
        int i = this.zza;
        zzafg zzafgVar = i != 0 ? i != 1 ? i != 2 ? null : zzafg.AUTH_STATE_UNAUTHENTICATED : zzafg.AUTH_STATE_AUTHENTICATED : zzafg.AUTH_STATE_UNSPECIFIED;
        return zzafgVar == null ? zzafg.UNRECOGNIZED : zzafgVar;
    }
}
