package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
final class zzcpc implements zzffh {
    final zzind zza;
    final zzind zzb;
    final zzind zzc;
    final zzind zzd;
    final zzind zze;
    final zzind zzf;
    private final zzcox zzg;

    public zzcpc(zzcox zzcoxVar, Context context, String str) {
        this.zzg = zzcoxVar;
        zzimu zzimuVarZza = zzimv.zza(context);
        this.zza = zzimuVarZza;
        zzimu zzimuVarZza2 = zzimv.zza(str);
        this.zzb = zzimuVarZza2;
        zzind zzindVar = zzcoxVar.zzby;
        zzfhy zzfhyVarZzc = zzfhy.zzc(zzimuVarZza, zzindVar, zzcoxVar.zzbz);
        this.zzc = zzfhyVarZzc;
        zzind zzindVarZza = zzimt.zza(zzfgf.zza(zzindVar));
        this.zzd = zzindVarZza;
        zzind zzindVar2 = zzcoxVar.zza;
        zzind zzindVar3 = zzcoxVar.zzaf;
        zzfla zzflaVarZza = zzfla.zza();
        zzind zzindVar4 = zzcoxVar.zzi;
        zzind zzindVarZza2 = zzimt.zza(zzfgh.zza(zzimuVarZza, zzindVar2, zzindVar3, zzfhyVarZzc, zzindVarZza, zzflaVarZza, zzindVar4));
        this.zze = zzindVarZza2;
        this.zzf = zzimt.zza(zzfgn.zza(zzindVar3, zzimuVarZza, zzimuVarZza2, zzindVarZza2, zzindVarZza, zzindVar4, zzcoxVar.zzp));
    }

    @Override // com.google.android.gms.internal.ads.zzffh
    public final zzfgm zza() {
        return (zzfgm) this.zzf.zzb();
    }
}
