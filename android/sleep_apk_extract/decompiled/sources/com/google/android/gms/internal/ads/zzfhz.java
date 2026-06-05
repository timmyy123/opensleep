package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfhz implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzfhz(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzfhz zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzfhz(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfhw zzb() {
        Context context = (Context) this.zza.zzb();
        zzfmj zzfmjVar = (zzfmj) this.zzb.zzb();
        zzfnb zzfnbVar = (zzfnb) this.zzc.zzb();
        zzcey zzceyVarZzi = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhm)).booleanValue() ? com.google.android.gms.ads.internal.zzt.zzh().zzo().zzi() : com.google.android.gms.ads.internal.zzt.zzh().zzo().zzj();
        boolean z = false;
        if (zzceyVarZzi != null && zzceyVarZzi.zzi()) {
            z = true;
        }
        if (((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzho)).intValue() > 0) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhl)).booleanValue() || z) {
                zzfna zzfnaVarZza = zzfnbVar.zza(zzfmr.Rewarded, context, zzfmjVar, new zzfgz(new zzfgy()));
                zzfhn zzfhnVar = new zzfhn(new zzfhm());
                zzfmn zzfmnVar = zzfnaVarZza.zza;
                zzhcg zzhcgVar = zzcfr.zza;
                return new zzfhd(zzfhnVar, new zzfhj(zzfmnVar, zzhcgVar), zzfnaVarZza.zzb, zzfmnVar.zze().zzf, zzhcgVar);
            }
        }
        return new zzfhm();
    }
}
