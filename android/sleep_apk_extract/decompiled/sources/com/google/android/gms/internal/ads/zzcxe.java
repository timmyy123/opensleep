package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcxe implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcxe(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzcxe zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzcxe(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcxd zzb() {
        return new zzcxd(((zzcwj) this.zza).zza(), (Executor) this.zzb.zzb());
    }
}
