package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzacz extends zzzg implements zzaar {
    private static final zzacz zzd;
    private static volatile zzaay zze;
    private Object zzb;
    private int zza = 0;
    private String zzc = "";

    static {
        zzacz zzaczVar = new zzacz();
        zzd = zzaczVar;
        zzzg.registerDefaultInstance(zzacz.class, zzaczVar);
    }

    private zzacz() {
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzd, "\u0004\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000\u0003<\u0000", new Object[]{"zzb", "zza", "zzc", zzadb.class, zzaep.class});
        }
        if (iOrdinal == 3) {
            return new zzacz();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzacy(bArr);
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
        synchronized (zzacz.class) {
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
        return this.zzc;
    }

    public final boolean zzb() {
        return this.zza == 2;
    }

    public final zzadb zzc() {
        return this.zza == 2 ? (zzadb) this.zzb : zzadb.zzc();
    }

    public final zzaep zzd() {
        return this.zza == 3 ? (zzaep) this.zzb : zzaep.zzg();
    }
}
