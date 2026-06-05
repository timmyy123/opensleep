package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadg extends zzzg implements zzaar {
    private static final zzadg zzg;
    private static volatile zzaay zzh;
    private int zza;
    private int zzb = 0;
    private Object zzc;
    private zzaep zzd;
    private int zze;
    private long zzf;

    static {
        zzadg zzadgVar = new zzadg();
        zzg = zzadgVar;
        zzzg.registerDefaultInstance(zzadg.class, zzadgVar);
    }

    private zzadg() {
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzg, "\u0004\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002ဉ\u0000\u0003\f\u0004ဃ\u0001", new Object[]{"zzc", "zzb", "zza", zzabp.class, "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzadg();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzadf(bArr);
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
        synchronized (zzadg.class) {
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

    public final zzabp zza() {
        return this.zzb == 1 ? (zzabp) this.zzc : zzabp.zzd();
    }

    public final zzaep zzb() {
        zzaep zzaepVar = this.zzd;
        return zzaepVar == null ? zzaep.zzg() : zzaepVar;
    }

    public final zzade zzc() {
        int i = this.zze;
        zzade zzadeVar = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : zzade.EVENT_IMPORTANCE_DEBUG : zzade.EVENT_IMPORTANCE_INFO : zzade.EVENT_IMPORTANCE_PRODUCTION_STANDARD : zzade.EVENT_IMPORTANCE_PRODUCTION_CRITICAL : zzade.EVENT_IMPORTANCE_UNSPECIFIED;
        return zzadeVar == null ? zzade.UNRECOGNIZED : zzadeVar;
    }

    public final long zzd() {
        return this.zzf;
    }
}
