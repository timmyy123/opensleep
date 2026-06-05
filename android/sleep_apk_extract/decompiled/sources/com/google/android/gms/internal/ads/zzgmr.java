package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgmr implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;
    private final zzind zze;
    private final zzind zzf;

    private zzgmr(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
        this.zze = zzindVar5;
        this.zzf = zzindVar6;
    }

    public static zzgmr zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5, zzind zzindVar6) {
        return new zzgmr(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5, zzindVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzgmq((Context) this.zza.zzb(), (ExecutorService) this.zzb.zzb(), (zzgdf) this.zzc.zzb(), (zzgee) this.zzd.zzb(), (zzgqh) this.zze.zzb(), (zzgms) this.zzf.zzb());
    }
}
