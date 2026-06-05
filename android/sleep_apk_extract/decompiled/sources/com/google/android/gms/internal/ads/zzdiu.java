package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdiu implements zzimu {
    private final zzdir zza;

    private zzdiu(zzdir zzdirVar) {
        this.zza = zzdirVar;
    }

    public static zzdiu zza(zzdir zzdirVar) {
        return new zzdiu(zzdirVar);
    }

    public static Set zzc(zzdir zzdirVar) {
        Set set = Collections.EMPTY_SET;
        zzinc.zzb(set);
        return set;
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
