package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbhv$zza;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdvu implements zzimu {
    private final zzind zza;

    private zzdvu(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdvu zza(zzind zzindVar) {
        return new zzdvu(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbhv$zza.zza zzaVar = ((zzdci) this.zza).zza().zzp.zza == 3 ? zzbhv$zza.zza.REWARDED_INTERSTITIAL : zzbhv$zza.zza.REWARD_BASED_VIDEO_AD;
        zzinc.zzb(zzaVar);
        return zzaVar;
    }
}
