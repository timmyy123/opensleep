package com.google.android.gms.internal.serialization;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzge extends zzgh {
    private final Map zza;
    private final Map zzb;
    private final zzgg zzc;
    private final zzgf zzd;

    public /* synthetic */ zzge(zzgd zzgdVar, byte[] bArr) {
        HashMap map = new HashMap();
        this.zza = map;
        HashMap map2 = new HashMap();
        this.zzb = map2;
        map.putAll(zzgdVar.zzd());
        map2.putAll(zzgdVar.zze());
        this.zzc = zzgdVar.zzf();
        this.zzd = zzgdVar.zzg();
    }
}
