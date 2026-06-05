package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzemi implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzemi(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzemi zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzemi(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzemh((Context) this.zza.zzb(), (zzcuz) this.zzb.zzb(), zzfoa.zzc());
    }
}
