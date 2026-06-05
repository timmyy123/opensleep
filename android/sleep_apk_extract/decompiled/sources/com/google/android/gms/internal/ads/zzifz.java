package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
final class zzifz {
    private static final zzifz zza = new zzifz();
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();
    private final zzifg zzb = new zzifg();

    private zzifz() {
    }

    public static zzifz zza() {
        return zza;
    }

    private <T> zzigh<T> zzc(Class<T> cls) {
        ConcurrentHashMap concurrentHashMap = this.zzc;
        zzigh<T> zzighVarZza = this.zzb.zza(cls);
        zzigh<T> zzighVar = (zzigh) concurrentHashMap.putIfAbsent(cls, zzighVarZza);
        return zzighVar != null ? zzighVar : zzighVarZza;
    }

    public final zzigh zzb(Class cls) {
        Object obj = this.zzc.get(cls);
        return obj == null ? zzc(cls) : (zzigh) obj;
    }
}
