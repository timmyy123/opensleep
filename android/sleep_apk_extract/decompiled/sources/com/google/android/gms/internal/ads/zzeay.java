package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeay {
    private final zzbqq zza;

    public zzeay(zzbqq zzbqqVar) {
        this.zza = zzbqqVar;
    }

    private final void zzs(zzeax zzeaxVar) {
        String strZza = zzeaxVar.zza();
        String strConcat = "Dispatching AFMA event on publisher webview: ".concat(strZza);
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzh(strConcat);
        this.zza.zzb(strZza);
    }

    public final void zza() {
        zzs(new zzeax("initialize", null));
    }

    public final void zzb(long j) {
        zzeax zzeaxVar = new zzeax("creation", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("nativeObjectCreated");
        zzs(zzeaxVar);
    }

    public final void zzc(long j) {
        zzeax zzeaxVar = new zzeax("creation", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("nativeObjectNotCreated");
        zzs(zzeaxVar);
    }

    public final void zzd(long j) {
        zzeax zzeaxVar = new zzeax("interstitial", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onNativeAdObjectNotAvailable");
        zzs(zzeaxVar);
    }

    public final void zze(long j) {
        zzeax zzeaxVar = new zzeax("interstitial", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onAdLoaded");
        zzs(zzeaxVar);
    }

    public final void zzf(long j, int i) {
        zzeax zzeaxVar = new zzeax("interstitial", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onAdFailedToLoad");
        zzeaxVar.zzd(Integer.valueOf(i));
        zzs(zzeaxVar);
    }

    public final void zzg(long j) {
        zzeax zzeaxVar = new zzeax("interstitial", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onAdOpened");
        zzs(zzeaxVar);
    }

    public final void zzh(long j) {
        zzeax zzeaxVar = new zzeax("interstitial", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onAdClicked");
        this.zza.zzb(zzeaxVar.zza());
    }

    public final void zzi(long j) {
        zzeax zzeaxVar = new zzeax("interstitial", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onAdClosed");
        zzs(zzeaxVar);
    }

    public final void zzj(long j) {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onNativeAdObjectNotAvailable");
        zzs(zzeaxVar);
    }

    public final void zzk(long j) {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onRewardedAdLoaded");
        zzs(zzeaxVar);
    }

    public final void zzl(long j, int i) {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onRewardedAdFailedToLoad");
        zzeaxVar.zzd(Integer.valueOf(i));
        zzs(zzeaxVar);
    }

    public final void zzm(long j) {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onRewardedAdOpened");
        zzs(zzeaxVar);
    }

    public final void zzn(long j, int i) {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onRewardedAdFailedToShow");
        zzeaxVar.zzd(Integer.valueOf(i));
        zzs(zzeaxVar);
    }

    public final void zzo(long j) {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onRewardedAdClosed");
        zzs(zzeaxVar);
    }

    public final void zzp(long j, zzccf zzccfVar) {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onUserEarnedReward");
        zzeaxVar.zze(zzccfVar.zze());
        zzeaxVar.zzf(Integer.valueOf(zzccfVar.zzf()));
        zzs(zzeaxVar);
    }

    public final void zzq(long j) {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onAdImpression");
        zzs(zzeaxVar);
    }

    public final void zzr(long j) {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j));
        zzeaxVar.zzc("onAdClicked");
        zzs(zzeaxVar);
    }
}
