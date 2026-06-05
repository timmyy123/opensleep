package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
final class zzcph implements zzfgv {
    final zzind zza;
    final zzind zzb;
    final zzind zzc;
    final zzind zzd;
    final zzind zze;
    final zzind zzf;
    private final Context zzg;
    private final com.google.android.gms.ads.internal.client.zzr zzh;
    private final String zzi;
    private final zzcox zzj;

    public zzcph(zzcox zzcoxVar, Context context, String str, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzj = zzcoxVar;
        this.zzg = context;
        this.zzh = zzrVar;
        this.zzi = str;
        zzimu zzimuVarZza = zzimv.zza(context);
        this.zza = zzimuVarZza;
        zzimu zzimuVarZza2 = zzimv.zza(zzrVar);
        this.zzb = zzimuVarZza2;
        zzind zzindVarZza = zzimt.zza(zzetd.zza(zzcoxVar.zzp));
        this.zzc = zzindVarZza;
        zzind zzindVarZza2 = zzimt.zza(zzeti.zza());
        this.zzd = zzindVarZza2;
        zzind zzindVarZza3 = zzimt.zza(zzdhz.zza());
        this.zze = zzindVarZza3;
        this.zzf = zzimt.zza(zzfgt.zza(zzimuVarZza, zzcoxVar.zza, zzimuVarZza2, zzcoxVar.zzaf, zzindVarZza, zzindVarZza2, zzfla.zza(), zzindVarZza3));
    }

    @Override // com.google.android.gms.internal.ads.zzfgv
    public final zzesg zza() {
        zzfgs zzfgsVar = (zzfgs) this.zzf.zzb();
        zzetc zzetcVar = (zzetc) this.zzc.zzb();
        zzcox zzcoxVar = this.zzj;
        zzind zzindVar = zzcoxVar.zzp;
        return new zzesg(this.zzg, this.zzh, this.zzi, zzfgsVar, zzetcVar, zzcoi.zzd(zzcoxVar.zzI()), (zzdzl) zzindVar.zzb());
    }
}
