package com.google.android.gms.internal.serialization;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaeu extends zzzg implements zzaar {
    private static final zzaeu zzj;
    private static volatile zzaay zzk;
    private int zza;
    private int zzb;
    private zzadv zzd;
    private boolean zzg;
    private int zzh;
    private String zzc = "";
    private zzzs zze = zzzg.emptyProtobufList();
    private zzzs zzf = zzzg.emptyProtobufList();
    private String zzi = "";

    static {
        zzaeu zzaeuVar = new zzaeu();
        zzj = zzaeuVar;
        zzzg.registerDefaultInstance(zzaeu.class, zzaeuVar);
    }

    private zzaeu() {
    }

    public static zzaay zze() {
        return zzj.getParserForType();
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzj, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001\f\u0002Ȉ\u0003ဉ\u0000\u0004Ț\u0005Ț\u0006\u0007\u0007\f\bለ\u0001", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzaeu();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzaes(bArr);
        }
        if (iOrdinal == 5) {
            return zzj;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzaay zzaayVar = zzk;
        if (zzaayVar != null) {
            return zzaayVar;
        }
        synchronized (zzaeu.class) {
            try {
                zzyzVar = zzk;
                if (zzyzVar == null) {
                    zzyzVar = new zzyz(zzj);
                    zzk = zzyzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzyzVar;
    }

    public final zzadv zza() {
        zzadv zzadvVar = this.zzd;
        return zzadvVar == null ? zzadv.zze() : zzadvVar;
    }

    public final List zzb() {
        return this.zze;
    }

    public final List zzc() {
        return this.zzf;
    }

    public final zzaet zzd() {
        int i = this.zzh;
        zzaet zzaetVar = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : zzaet.CHANGE_TYPE_CONNECTIVITY_UPDATED : zzaet.CHANGE_TYPE_DATA_RECOMPUTATION_REQUIRED : zzaet.CHANGE_TYPE_PERMISSIONS_UPDATED : zzaet.CHANGE_TYPE_TRANSPORT_DISCONNECTED : zzaet.CHANGE_TYPE_UNSPECIFIED;
        return zzaetVar == null ? zzaet.UNRECOGNIZED : zzaetVar;
    }

    public final int zzg() {
        int i = this.zzb;
        int i2 = 2;
        if (i != 0) {
            if (i == 1) {
                i2 = 3;
            } else if (i != 2) {
                i2 = 5;
                if (i != 3) {
                    i2 = i != 4 ? i != 5 ? 0 : 7 : 6;
                }
            } else {
                i2 = 4;
            }
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
