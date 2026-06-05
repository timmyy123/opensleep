package com.google.android.gms.internal.serialization;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadx extends zzzg implements zzaar {
    private static final zzadx zzb;
    private static volatile zzaay zzc;
    private zzzs zza = zzzg.emptyProtobufList();

    static {
        zzadx zzadxVar = new zzadx();
        zzb = zzadxVar;
        zzzg.registerDefaultInstance(zzadx.class, zzadxVar);
    }

    private zzadx() {
    }

    public static zzadw zzb() {
        return (zzadw) zzb.createBuilder();
    }

    @Override // com.google.android.gms.internal.serialization.zzzg
    public final Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2) {
        zzaay zzyzVar;
        int iOrdinal = zzzfVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzzg.newMessageInfo(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzadx();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzadw(bArr);
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
        synchronized (zzadx.class) {
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

    public final List zza() {
        return this.zza;
    }

    public final /* synthetic */ void zzc(Iterable iterable) {
        zzzs zzzsVar = this.zza;
        if (!zzzsVar.zza()) {
            this.zza = zzzg.mutableCopy(zzzsVar);
        }
        zzvy.addAll(iterable, this.zza);
    }
}
