package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdai implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdai(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdai zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdai(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzdhi) this.zza.zzb(), (Executor) this.zzb.zzb());
    }
}
