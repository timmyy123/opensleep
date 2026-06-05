package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzafw extends zzzg implements zzaar {
    private static final zzafw zzd;
    private static volatile zzaay zze;
    private int zza;
    private String zzb = "";
    private String zzc = "";

    static {
        zzafw zzafwVar = new zzafw();
        zzd = zzafwVar;
        zzzg.registerDefaultInstance(zzafw.class, zzafwVar);
    }

    private zzafw() {
    }

    public static zzafw zzc(byte[] bArr) {
        return (zzafw) zzzg.parseFrom(zzd, bArr);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzd, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzafw();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzafv(bArr);
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
        synchronized (zzafw.class) {
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

    public final String zzb() {
        return this.zzc;
    }
}
