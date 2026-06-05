package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcdb extends zzcco {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzcdc zzb;

    public zzcdb(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzcdc zzcdcVar) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzcdcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zze() {
        zzcdc zzcdcVar;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback == null || (zzcdcVar = this.zzb) == null) {
            return;
        }
        rewardedInterstitialAdLoadCallback.onAdLoaded(zzcdcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zzf(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zzeVar.zzb());
        }
    }
}
