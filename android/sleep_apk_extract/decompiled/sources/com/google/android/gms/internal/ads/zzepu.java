package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzepu implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzepu(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzepu zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzepu(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzept zzb() {
        return new zzept((Context) this.zza.zzb(), (zzdvr) this.zzb.zzb());
    }
}
