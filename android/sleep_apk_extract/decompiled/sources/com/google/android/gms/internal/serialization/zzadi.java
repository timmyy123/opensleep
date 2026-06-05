package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadi extends zzzg implements zzaar {
    private static final zzadi zzg;
    private static volatile zzaay zzh;
    private int zza;
    private int zzb;
    private zzadd zzd;
    private int zzf;
    private String zzc = "";
    private String zze = "";

    static {
        zzadi zzadiVar = new zzadi();
        zzg = zzadiVar;
        zzzg.registerDefaultInstance(zzadi.class, zzadiVar);
    }

    private zzadi() {
    }

    public static zzaay zzb() {
        return zzg.getParserForType();
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzg, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003ဉ\u0000\u0004ለ\u0001\u0005ဌ\u0002", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzadi();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzadh(bArr);
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
        synchronized (zzadi.class) {
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

    public final zzadd zza() {
        zzadd zzaddVar = this.zzd;
        return zzaddVar == null ? zzadd.zzc() : zzaddVar;
    }

    public final int zzd() {
        int i = this.zzb;
        int i2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? 0 : 5 : 4 : 3 : 2;
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
