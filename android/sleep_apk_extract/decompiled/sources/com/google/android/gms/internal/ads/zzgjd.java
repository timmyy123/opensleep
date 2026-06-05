package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgjd implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;
    private final zzind zze;

    private zzgjd(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
        this.zze = zzindVar5;
    }

    public static zzgjd zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5) {
        return new zzgjd(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzgjc((zzaxm) this.zza.zzb(), (zzght) this.zzb.zzb(), (DisplayMetrics) this.zzc.zzb(), (View) this.zzd.zzb(), (zzgqh) this.zze.zzb());
    }
}
