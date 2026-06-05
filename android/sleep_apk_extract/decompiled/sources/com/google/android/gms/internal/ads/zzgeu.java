package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgeu implements zzimu {
    private final zzind zza;

    private zzgeu(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgeu zza(zzind zzindVar) {
        return new zzgeu(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzgfc((ExecutorService) this.zza.zzb());
    }
}
