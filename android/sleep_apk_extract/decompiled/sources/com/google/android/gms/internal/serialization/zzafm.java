package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzafm extends zzzg implements zzaar {
    private static final zzafm zzd;
    private static volatile zzaay zze;
    private int zza;
    private String zzb = "";
    private int zzc;

    static {
        zzafm zzafmVar = new zzafm();
        zzd = zzafmVar;
        zzzg.registerDefaultInstance(zzafm.class, zzafmVar);
    }

    private zzafm() {
    }

    public static zzafm zzc(byte[] bArr) {
        return (zzafm) zzzg.parseFrom(zzd, bArr);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzd, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ለ\u0000\u0002ဋ\u0001", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzafm();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzafl(bArr);
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
        synchronized (zzafm.class) {
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

    public final String zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzc;
    }
}
