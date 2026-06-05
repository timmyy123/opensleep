package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdbq implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdbq(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdbq zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzdbq(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdbp((Context) this.zza.zzb(), ((zzcyk) this.zzb).zza(), new zzbzg());
    }
}
