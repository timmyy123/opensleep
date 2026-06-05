package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzecg implements zzimu {
    private final zzind zza;

    private zzecg(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzecg zza(zzind zzindVar, zzind zzindVar2) {
        return new zzecg(zzindVar, zzindVar2);
    }

    public static zzdkq zzc(zzecf zzecfVar, Executor executor) {
        return new zzdkq(zzecfVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzc((zzecf) this.zza.zzb(), zzfoa.zzc());
    }
}
