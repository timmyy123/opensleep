package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes3.dex */
final class zzcdv extends zzcea {
    final zzind zza;
    final zzind zzb;
    final zzind zzc;
    final zzind zzd;
    final zzind zze;
    final zzind zzf;
    final zzind zzg;
    final zzind zzh;
    private final Clock zzj;

    public zzcdv(Context context, Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzcdz zzcdzVar) {
        this.zzj = clock;
        zzimu zzimuVarZza = zzimv.zza(context);
        this.zza = zzimuVarZza;
        zzimu zzimuVarZza2 = zzimv.zza(zzgVar);
        this.zzb = zzimuVarZza2;
        this.zzc = zzimt.zza(zzcdp.zza(zzimuVarZza, zzimuVarZza2));
        zzimu zzimuVarZza3 = zzimv.zza(clock);
        this.zzd = zzimuVarZza3;
        zzimu zzimuVarZza4 = zzimv.zza(zzcdzVar);
        this.zze = zzimuVarZza4;
        zzind zzindVarZza = zzimt.zza(zzcdr.zza(zzimuVarZza3, zzimuVarZza2, zzimuVarZza4));
        this.zzf = zzindVarZza;
        zzcdt zzcdtVarZzc = zzcdt.zzc(zzimuVarZza3, zzindVarZza);
        this.zzg = zzcdtVarZzc;
        this.zzh = zzimt.zza(zzceg.zza(zzimuVarZza, zzcdtVarZzc));
    }

    @Override // com.google.android.gms.internal.ads.zzcea
    public final zzcds zza() {
        return new zzcds(this.zzj, (zzcdq) this.zzf.zzb());
    }
}
