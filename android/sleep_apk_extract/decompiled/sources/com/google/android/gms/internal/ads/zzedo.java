package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzedo extends com.google.android.gms.ads.internal.client.zzds {
    final Map zza = new HashMap();
    private final Context zzb;
    private final WeakReference zzc;
    private final zzedc zzd;
    private final zzhcg zze;
    private zzecr zzf;

    public zzedo(Context context, WeakReference weakReference, zzedc zzedcVar, zzedq zzedqVar, zzhcg zzhcgVar) {
        this.zzb = context;
        this.zzc = weakReference;
        this.zzd = zzedcVar;
        this.zze = zzhcgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzg(String str) {
        try {
            zzhbw.zzr(this.zzf.zzn(str), new zzedj(this), this.zze);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "OutOfContextTester.setAdAsOutOfContext");
            this.zzd.zzn();
        }
    }

    private final synchronized void zzk(String str) {
        try {
            zzhbw.zzr(this.zzf.zzn(str), new zzedk(this), this.zze);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "OutOfContextTester.setAdAsShown");
            this.zzd.zzn();
        }
    }

    private final Context zzl() {
        Context context = (Context) this.zzc.get();
        return context == null ? this.zzb : context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzm(Object obj) {
        ResponseInfo responseInfo;
        com.google.android.gms.ads.internal.client.zzdx zzdxVarZzd;
        if (obj instanceof LoadAdError) {
            responseInfo = ((LoadAdError) obj).getResponseInfo();
        } else if (obj instanceof AppOpenAd) {
            responseInfo = ((AppOpenAd) obj).getResponseInfo();
        } else if (obj instanceof InterstitialAd) {
            responseInfo = ((InterstitialAd) obj).getResponseInfo();
        } else if (obj instanceof RewardedAd) {
            responseInfo = ((RewardedAd) obj).getResponseInfo();
        } else if (obj instanceof RewardedInterstitialAd) {
            responseInfo = ((RewardedInterstitialAd) obj).getResponseInfo();
        } else if (obj instanceof AdView) {
            responseInfo = ((AdView) obj).getResponseInfo();
        } else {
            if (!(obj instanceof NativeAd)) {
                return "";
            }
            responseInfo = ((NativeAd) obj).getResponseInfo();
        }
        if (responseInfo == null || (zzdxVarZzd = responseInfo.zzd()) == null) {
            return "";
        }
        try {
            return zzdxVarZzd.zzj();
        } catch (RemoteException unused) {
            return "";
        }
    }

    public final void zzb(zzecr zzecrVar) {
        this.zzf = zzecrVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final synchronized void zzc(zzedp zzedpVar) {
        try {
            String strZzb = zzedpVar.zzb();
            switch (strZzb.hashCode()) {
                case -1999289321:
                    if (strZzb.equals("NATIVE")) {
                        final String strZza = zzedpVar.zza();
                        AdLoader.Builder builder = new AdLoader.Builder(zzl(), strZza);
                        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.google.android.gms.internal.ads.zzedm
                            @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
                            public final /* synthetic */ void onNativeAdLoaded(NativeAd nativeAd) {
                                this.zza.zzf(strZza, nativeAd);
                            }
                        });
                        builder.withAdListener(new zzedi(this));
                        NativeAdOptions nativeAdOptionsZze = zzedpVar.zze();
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkO)).booleanValue() && nativeAdOptionsZze != null) {
                            builder.withNativeAdOptions(nativeAdOptionsZze);
                        }
                        builder.build().loadAd(zzedpVar.zzc());
                        return;
                    }
                    break;
                case -1372958932:
                    if (strZzb.equals("INTERSTITIAL")) {
                        String strZza2 = zzedpVar.zza();
                        InterstitialAd.load(zzl(), strZza2, zzedpVar.zzc(), new zzedf(this, strZza2));
                        return;
                    }
                    break;
                case -428325382:
                    if (strZzb.equals("APP_OPEN_AD")) {
                        String strZza3 = zzedpVar.zza();
                        AppOpenAd.load(zzl(), strZza3, zzedpVar.zzc(), new zzedd(this, strZza3));
                        return;
                    }
                    break;
                case 543046670:
                    if (strZzb.equals("REWARDED")) {
                        String strZza4 = zzedpVar.zza();
                        RewardedAd.load(zzl(), strZza4, zzedpVar.zzc(), new zzedg(this, strZza4));
                        return;
                    }
                    break;
                case 1854800829:
                    if (strZzb.equals("REWARDED_INTERSTITIAL")) {
                        String strZza5 = zzedpVar.zza();
                        RewardedInterstitialAd.load(zzl(), strZza5, zzedpVar.zzc(), new zzedh(this, strZza5));
                        return;
                    }
                    break;
                case 1951953708:
                    if (strZzb.equals("BANNER")) {
                        String strZza6 = zzedpVar.zza();
                        zzbih zzbihVar = zzbiq.zzkO;
                        BaseAdView adManagerAdView = (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue() && zzedpVar.zzg()) ? new AdManagerAdView(zzl()) : new AdView(zzl());
                        adManagerAdView.setAdSize(zzedpVar.zzd());
                        adManagerAdView.setAdUnitId(strZza6);
                        adManagerAdView.setAdListener(new zzede(this, strZza6, adManagerAdView));
                        VideoOptions videoOptionsZzf = zzedpVar.zzf();
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue() && zzedpVar.zzg() && videoOptionsZzf != null) {
                            ((AdManagerAdView) adManagerAdView).setVideoOptions(videoOptionsZzf);
                        }
                        adManagerAdView.loadAd(zzedpVar.zzc());
                        return;
                    }
                    break;
            }
        } finally {
        }
    }

    public final synchronized void zzd(String str) {
        Map map;
        Object obj;
        try {
            Activity activityZzo = this.zzd.zzo();
            if (activityZzo != null && (obj = (map = this.zza).get(str)) != null) {
                zzbih zzbihVar = zzbiq.zzkN;
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue() || (obj instanceof AppOpenAd) || (obj instanceof InterstitialAd) || (obj instanceof RewardedAd) || (obj instanceof RewardedInterstitialAd)) {
                    map.remove(str);
                }
                zzk(zzm(obj));
                if (obj instanceof AppOpenAd) {
                    ((AppOpenAd) obj).show(activityZzo);
                    return;
                }
                if (obj instanceof InterstitialAd) {
                    ((InterstitialAd) obj).show(activityZzo);
                    return;
                }
                if (obj instanceof RewardedAd) {
                    ((RewardedAd) obj).show(activityZzo, zzedn.zza);
                    return;
                }
                if (obj instanceof RewardedInterstitialAd) {
                    ((RewardedInterstitialAd) obj).show(activityZzo, zzedl.zza);
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue() && ((obj instanceof AdView) || (obj instanceof NativeAd))) {
                    Intent intent = new Intent();
                    Context contextZzl = zzl();
                    intent.setClassName(contextZzl, "com.google.android.gms.ads.OutOfContextTestingActivity");
                    intent.putExtra("adUnit", str);
                    com.google.android.gms.ads.internal.zzt.zzc();
                    com.google.android.gms.ads.internal.util.zzs.zzY(contextZzl, intent);
                }
            }
        } finally {
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdt
    public final void zze(String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        ViewGroup viewGroup = (ViewGroup) ObjectWrapper.unwrap(iObjectWrapper2);
        if (context == null || viewGroup == null) {
            return;
        }
        Map map = this.zza;
        Object obj = map.get(str);
        if (obj != null) {
            map.remove(str);
        }
        if (obj instanceof AdView) {
            zzedq.zza(context, viewGroup, (AdView) obj);
        } else if (obj instanceof NativeAd) {
            zzedq.zzb(context, viewGroup, (NativeAd) obj);
        }
    }

    public final synchronized void zzf(String str, Object obj) {
        this.zza.put(str, obj);
        zzg(zzm(obj));
    }

    public final /* synthetic */ zzedc zzi() {
        return this.zzd;
    }
}
