package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgfi implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;
    private final zzind zze;

    private zzgfi(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
        this.zze = zzindVar5;
    }

    public static zzgfi zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4, zzind zzindVar5) {
        return new zzgfi(zzindVar, zzindVar2, zzindVar3, zzindVar4, zzindVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* synthetic */ Object zzb() {
        Context context = (Context) this.zza.zzb();
        zzgel zzgelVar = (zzgel) this.zzb.zzb();
        ExecutorService executorService = (ExecutorService) this.zzc.zzb();
        zzgee zzgeeVar = (zzgee) this.zzd.zzb();
        zzgdf zzgdfVar = (zzgdf) this.zze.zzb();
        return new zzgfm(context, zzgelVar, executorService, zzgeeVar, new Random(), zzgdfVar.zzg().zza(), zzgdfVar.zzg().zzc(), zzgdfVar.zzg().zzd(), zzgdfVar.zzg().zzb(), zzgdfVar.zzd(), zzgdfVar.zzI(), zzgdfVar.zzG() - 1);
    }
}
