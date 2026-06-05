package com.google.android.gms.internal.aicore;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes3.dex */
final class zzgh {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzgh zzb = new zzgh();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzgl zzc = new zzfs();

    private zzgh() {
    }

    public static zzgh zza() {
        return zzb;
    }

    public final zzgk zzb(Class cls) {
        zzfh.zza(cls, "messageType");
        ConcurrentMap concurrentMap = this.zzd;
        zzgk zzgkVar = (zzgk) concurrentMap.get(cls);
        if (zzgkVar != null) {
            return zzgkVar;
        }
        zzgk zzgkVarZza = this.zzc.zza(cls);
        zzfh.zza(cls, "messageType");
        zzgk zzgkVar2 = (zzgk) concurrentMap.putIfAbsent(cls, zzgkVarZza);
        return zzgkVar2 != null ? zzgkVar2 : zzgkVarZza;
    }
}
