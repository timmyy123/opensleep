package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaep extends zzzg implements zzaar {
    private static final zzaep zzg;
    private static volatile zzaay zzh;
    private int zza;
    private String zzb = "";
    private String zzc = "";
    private long zzd;
    private long zze;
    private zzwe zzf;

    static {
        zzaep zzaepVar = new zzaep();
        zzg = zzaepVar;
        zzzg.registerDefaultInstance(zzaep.class, zzaepVar);
    }

    private zzaep() {
    }

    public static zzaeo zzf() {
        return (zzaeo) zzg.createBuilder();
    }

    public static zzaep zzg() {
        return zzg;
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzg, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ဃ\u0000\u0004ဃ\u0001\u0005ဉ\u0002", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzaep();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzaeo(bArr);
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
        synchronized (zzaep.class) {
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

    @Deprecated
    public final String zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final long zzd() {
        return this.zze;
    }

    public final zzwe zze() {
        zzwe zzweVar = this.zzf;
        return zzweVar == null ? zzwe.zzd() : zzweVar;
    }

    public final /* synthetic */ void zzh(String str) {
        str.getClass();
        this.zzb = str;
    }

    public final /* synthetic */ void zzi(String str) {
        str.getClass();
        this.zzc = str;
    }

    public final /* synthetic */ void zzj(long j) {
        this.zza |= 2;
        this.zze = j;
    }

    public final /* synthetic */ void zzk(zzwe zzweVar) {
        zzweVar.getClass();
        this.zzf = zzweVar;
        this.zza |= 4;
    }
}
