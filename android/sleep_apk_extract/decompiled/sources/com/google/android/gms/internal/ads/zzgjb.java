package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgjb implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;
    private final zzind zze;

    private zzgjb(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
        this.zze = zzindVar5;
    }

    public static zzgjb zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5) {
        return new zzgjb(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzgja((zzaxm) this.zza.zzb(), (zzght) this.zzb.zzb(), (Map) this.zzc.zzb(), (DisplayMetrics) this.zzd.zzb(), (zzgqh) this.zze.zzb());
    }
}
