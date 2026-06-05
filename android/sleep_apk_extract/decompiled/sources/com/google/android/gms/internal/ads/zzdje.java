package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdje implements zzimu {
    private final zzdir zza;

    private zzdje(zzdir zzdirVar) {
        this.zza = zzdirVar;
    }

    public static zzdje zza(zzdir zzdirVar) {
        return new zzdje(zzdirVar);
    }

    public static Set zzc(zzdir zzdirVar) {
        return zzdirVar.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        return this.zza.zzm();
    }
}
