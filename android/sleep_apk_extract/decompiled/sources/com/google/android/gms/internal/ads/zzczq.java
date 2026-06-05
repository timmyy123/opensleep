package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzczq implements zzimu {
    private final zzind zza;

    private zzczq(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzczq zza(zzind zzindVar, zzind zzindVar2) {
        return new zzczq(zzindVar, zzindVar2);
    }

    public static zzdkq zzc(zzctv zzctvVar, Executor executor) {
        return new zzdkq(zzctvVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzc((zzctv) this.zza.zzb(), zzfoa.zzc());
    }
}
