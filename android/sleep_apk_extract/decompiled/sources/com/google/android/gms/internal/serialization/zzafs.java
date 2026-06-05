package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzafs extends zzzg implements zzaar {
    private static final zzafs zzb;
    private static volatile zzaay zzc;
    private String zza = "";

    static {
        zzafs zzafsVar = new zzafs();
        zzb = zzafsVar;
        zzzg.registerDefaultInstance(zzafs.class, zzafsVar);
    }

    private zzafs() {
    }

    public static zzafr zza() {
        return (zzafr) zzb.createBuilder();
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzafs();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzafr(bArr);
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
        synchronized (zzafs.class) {
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

    public final /* synthetic */ void zzb(String str) {
        str.getClass();
        this.zza = str;
    }
}
