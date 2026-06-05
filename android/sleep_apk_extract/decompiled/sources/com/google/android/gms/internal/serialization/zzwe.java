package com.google.android.gms.internal.serialization;

/* JADX INFO: loaded from: classes3.dex */
public final class zzwe extends zzzg implements zzaar {
    private static final zzwe zzc;
    private static volatile zzaay zzd;
    private String zza = "";
    private zzwr zzb = zzwr.zzb;

    static {
        zzwe zzweVar = new zzwe();
        zzc = zzweVar;
        zzzg.registerDefaultInstance(zzwe.class, zzweVar);
    }

    private zzwe() {
    }

    public static zzwd zzc() {
        return (zzwd) zzc.createBuilder();
    }

    public static zzwe zzd() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzwe();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzwd(bArr);
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
        synchronized (zzwe.class) {
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

    public final String zza() {
        return this.zza;
    }

    public final zzwr zzb() {
        return this.zzb;
    }

    public final /* synthetic */ void zze(String str) {
        str.getClass();
        this.zza = str;
    }

    public final /* synthetic */ void zzf(zzwr zzwrVar) {
        this.zzb = zzwrVar;
    }
}
