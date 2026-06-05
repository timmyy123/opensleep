package com.google.android.gms.internal.serialization;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadv extends zzzg implements zzaar {
    private static final zzadv zze;
    private static volatile zzaay zzf;
    private int zza;
    private String zzb = "";
    private zzzs zzc = zzzg.emptyProtobufList();
    private boolean zzd;

    static {
        zzadv zzadvVar = new zzadv();
        zze = zzadvVar;
        zzzg.registerDefaultInstance(zzadv.class, zzadvVar);
    }

    private zzadv() {
    }

    public static zzadv zze() {
        return zze;
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zze, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003ဇ\u0000", new Object[]{"zza", "zzb", "zzc", zzaep.class, "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzadv();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzadu(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zzf;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzadv.class) {
            try {
                zzyzVar = zzf;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zze);
                    zzf = zzyzVar;
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

    public final List zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zzd;
    }
}
