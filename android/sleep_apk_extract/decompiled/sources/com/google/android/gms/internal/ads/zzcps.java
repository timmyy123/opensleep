package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
final class zzcps implements zzfil {
    final zzind zza;
    final zzind zzb;
    final zzind zzc;
    final zzind zzd;
    final zzind zze;
    final zzind zzf;
    final zzind zzg;
    private final zzcox zzh;

    public zzcps(zzcox zzcoxVar, Context context, String str, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzh = zzcoxVar;
        zzimu zzimuVarZza = zzimv.zza(context);
        this.zza = zzimuVarZza;
        zzimu zzimuVarZza2 = zzimv.zza(zzrVar);
        this.zzb = zzimuVarZza2;
        zzimu zzimuVarZza3 = zzimv.zza(str);
        this.zzc = zzimuVarZza3;
        zzind zzindVar = zzcoxVar.zzp;
        zzind zzindVarZza = zzimt.zza(zzetd.zza(zzindVar));
        this.zzd = zzindVarZza;
        zzind zzindVarZza2 = zzimt.zza(zzfjk.zza(zzcoxVar.zzby));
        this.zze = zzindVarZza2;
        zzind zzindVarZza3 = zzimt.zza(zzfij.zza(zzimuVarZza, zzcoxVar.zza, zzcoxVar.zzaf, zzindVarZza, zzindVarZza2, zzfla.zza()));
        this.zzf = zzindVarZza3;
        this.zzg = zzimt.zza(zzetl.zza(zzimuVarZza, zzimuVarZza2, zzimuVarZza3, zzindVarZza3, zzindVarZza, zzindVarZza2, zzcoxVar.zzi, zzcoxVar.zzai, zzindVar));
    }

    @Override // com.google.android.gms.internal.ads.zzfil
    public final zzetk zza() {
        return (zzetk) this.zzg.zzb();
    }
}
