package com.google.android.gms.internal.consent_sdk;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzrx {
    private static final zzrx zza = new zzrx();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzsb zzb = new zzrh();

    private zzrx() {
    }

    public static zzrx zza() {
        return zza;
    }

    public final zzsa zzb(Class cls) {
        byte[] bArr = zzqs.zzb;
        if (cls == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("messageType");
            return null;
        }
        ConcurrentMap concurrentMap = this.zzc;
        zzsa zzsaVar = (zzsa) concurrentMap.get(cls);
        if (zzsaVar != null) {
            return zzsaVar;
        }
        zzsa zzsaVarZza = this.zzb.zza(cls);
        zzsa zzsaVar2 = (zzsa) concurrentMap.putIfAbsent(cls, zzsaVarZza);
        return zzsaVar2 != null ? zzsaVar2 : zzsaVarZza;
    }
}
