package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeae implements zzimu {
    private final zzeaa zza;
    private final zzind zzb;

    private zzeae(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzeaaVar;
        this.zzb = zzindVar;
    }

    public static zzeae zza(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        return new zzeae(zzeaaVar, zzindVar, zzindVar2);
    }

    public static Set zzc(zzeaa zzeaaVar, zzeak zzeakVar, Executor executor) {
        Set setZzd = zzeaa.zzd(zzeakVar, executor);
        zzinc.zzb(setZzd);
        return setZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzc(this.zza, (zzeak) this.zzb.zzb(), zzfoa.zzc());
    }
}
