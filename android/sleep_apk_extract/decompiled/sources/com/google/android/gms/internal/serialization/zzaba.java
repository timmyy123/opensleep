package com.google.android.gms.internal.serialization;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes3.dex */
final class zzaba {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzaba zzb = new zzaba();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzabf zzc = new zzaah();

    private zzaba() {
    }

    public static zzaba zza() {
        return zzb;
    }

    public final zzabe zzb(Class cls) {
        zzzt.zza(cls, "messageType");
        zzabe zzabeVar = (zzabe) this.zzd.get(cls);
        if (zzabeVar != null) {
            return zzabeVar;
        }
        zzabe zzabeVarZza = this.zzc.zza(cls);
        zzzt.zza(cls, "messageType");
        zzabe zzabeVar2 = (zzabe) this.zzd.putIfAbsent(cls, zzabeVarZza);
        return zzabeVar2 == null ? zzabeVarZza : zzabeVar2;
    }
}
