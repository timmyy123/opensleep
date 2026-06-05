package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdod implements zzimu {
    private final zzind zza;

    private zzdod(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdod zza(zzind zzindVar) {
        return new zzdod(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = ((zzdoa) this.zza).zza().zzd() != null ? Collections.singleton("banner") : Collections.EMPTY_SET;
        zzinc.zzb(setSingleton);
        return setSingleton;
    }
}
