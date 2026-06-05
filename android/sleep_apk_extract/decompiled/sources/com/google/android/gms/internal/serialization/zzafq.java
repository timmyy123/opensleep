package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzafq extends zzzg implements zzaar {
    private static final zzafq zzh;
    private static volatile zzaay zzi;
    private int zza;
    private int zzb;
    private int zzc;
    private int zzf;
    private String zzd = "";
    private String zze = "";
    private String zzg = "";

    static {
        zzafq zzafqVar = new zzafq();
        zzh = zzafqVar;
        zzzg.registerDefaultInstance(zzafq.class, zzafqVar);
    }

    private zzafq() {
    }

    public static zzafq zzg(byte[] bArr) {
        return (zzafq) zzzg.parseFrom(zzh, bArr);
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzh, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001\u0003ለ\u0002\u0004ለ\u0003\u0005ဋ\u0004\u0006ለ\u0005", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzafq();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzafp(bArr);
        }
        if (iOrdinal == 5) {
            return zzh;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zzi;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzafq.class) {
            try {
                zzyzVar = zzi;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zzh);
                    zzi = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zze;
    }

    public final int zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zzg;
    }
}
