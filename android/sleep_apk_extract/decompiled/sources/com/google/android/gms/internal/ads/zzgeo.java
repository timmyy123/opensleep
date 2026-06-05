package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgeo implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzgeo(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzgeo zza(zzind zzindVar, zzind zzindVar2) {
        return new zzgeo(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzgen((Executor) this.zza.zzb(), (zzgcn) this.zzb.zzb());
    }
}
