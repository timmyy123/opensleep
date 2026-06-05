package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgku implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzgku(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzgku zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzgku(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context context = (Context) this.zza.zzb();
        zzind zzindVar = this.zzc;
        return new zzgkz(context, context.getSharedPreferences("pcvmspf2", 0), zzimt.zzc(this.zzb), (zzgqh) zzindVar.zzb());
    }
}
