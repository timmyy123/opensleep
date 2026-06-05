package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzceg implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzceg(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzceg zza(zzind zzindVar, zzind zzindVar2) {
        return new zzceg(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcef((Context) this.zza.zzb(), ((zzcdt) this.zzb).zzb());
    }
}
