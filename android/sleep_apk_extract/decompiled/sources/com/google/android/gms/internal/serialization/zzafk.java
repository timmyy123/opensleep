package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzafk extends zzzg implements zzaar {
    private static final zzafk zzg;
    private static volatile zzaay zzh;
    private int zza;
    private String zzb = "";
    private String zzc = "";
    private String zzd = "";
    private String zze = "";
    private boolean zzf;

    static {
        zzafk zzafkVar = new zzafk();
        zzg = zzafkVar;
        zzzg.registerDefaultInstance(zzafk.class, zzafkVar);
    }

    private zzafk() {
    }

    public static zzafk zzf(byte[] bArr) {
        return (zzafk) zzzg.parseFrom(zzg, bArr);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzg, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003ለ\u0002\u0004ለ\u0003\u0005ဇ\u0004", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzafk();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzafj(bArr);
        }
        if (iOrdinal == 5) {
            return zzg;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zzh;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzafk.class) {
            try {
                zzyzVar = zzh;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zzg);
                    zzh = zzyzVar;
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

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return this.zzf;
    }
}
