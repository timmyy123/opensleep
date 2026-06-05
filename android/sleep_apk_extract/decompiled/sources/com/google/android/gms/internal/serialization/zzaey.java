package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaey extends zzzg implements zzaar {
    private static final zzaey zzc;
    private static volatile zzaay zzd;
    private zzzs zza = zzzg.emptyProtobufList();
    private zzzs zzb = zzzg.emptyProtobufList();

    static {
        zzaey zzaeyVar = new zzaey();
        zzc = zzaeyVar;
        zzzg.registerDefaultInstance(zzaey.class, zzaeyVar);
    }

    private zzaey() {
    }

    public static zzaay zzc() {
        return zzc.getParserForType();
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzc, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zza", zzadv.class, "zzb", zzadk.class});
        }
        if (iOrdinal == 3) {
            return new zzaey();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzaex(bArr);
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
        synchronized (zzaey.class) {
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
}
