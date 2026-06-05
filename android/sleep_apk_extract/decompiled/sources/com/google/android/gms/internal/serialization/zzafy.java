package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzafy extends zzzg implements zzaar {
    private static final zzafy zzc;
    private static volatile zzaay zzd;
    private int zza;
    private String zzb = "";

    static {
        zzafy zzafyVar = new zzafy();
        zzc = zzafyVar;
        zzzg.registerDefaultInstance(zzafy.class, zzafyVar);
    }

    private zzafy() {
    }

    public static zzafy zzb(byte[] bArr) {
        return (zzafy) zzzg.parseFrom(zzc, bArr);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzc, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ለ\u0000", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzafy();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzafx(bArr);
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
        synchronized (zzafy.class) {
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
        return this.zzb;
    }
}
