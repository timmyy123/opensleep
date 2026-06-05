package com.urbandroid.sleep.ads;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.trial.Billing;

/* JADX INFO: loaded from: classes4.dex */
public class AdMobController implements IAdsController {
    private Activity activity;
    private AdView currentAdView;
    private ViewGroup parent;

    public AdMobController(Activity activity, int i) {
        this.activity = activity;
        this.parent = (ViewGroup) activity.findViewById(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdSize getAdSize() {
        this.activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        float width = this.parent.getWidth();
        if (width == 0.0f && Build.VERSION.SDK_INT >= 30) {
            width = this.activity.getWindowManager().getCurrentWindowMetrics().getBounds().width();
        }
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this.parent.getContext(), (int) (width / this.parent.getContext().getResources().getDisplayMetrics().density));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$load$0(String str, AdValue adValue) {
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventAdPaid("banner", str, Billing.PurchaseType.INSTANCE.getPriceAmountInBaseCurrency(adValue, 1.0f), adValue.getValueMicros(), adValue.getCurrencyCode());
    }

    @Override // com.urbandroid.sleep.ads.IAdsController
    public void destroy() {
        AdView adView = this.currentAdView;
        if (adView != null) {
            adView.destroy();
        }
    }

    @Override // com.urbandroid.sleep.ads.IAdsController
    public void hide() {
        if (this.currentAdView != null) {
            Logger.logDebug("ADS ADMOB: Hiding ADMOB view");
            this.currentAdView.setVisibility(8);
        }
    }

    public void load(final String str, final String str2, final Object obj) {
        if (this.activity.getResources().getConfiguration().orientation == 2) {
            Logger.logInfo("ADS ADMOB: Not Loading in landscape" + str + " fallback " + str2);
            return;
        }
        Logger.logInfo("ADS ADMOB: Loading " + str + " fallback " + str2);
        AdView adView = this.currentAdView;
        if (adView != null) {
            adView.destroy();
        }
        this.currentAdView = new AdView(this.parent.getContext());
        this.parent.removeAllViews();
        this.parent.addView(this.currentAdView);
        this.currentAdView.setOnPaidEventListener(new AdMobController$$ExternalSyntheticLambda0(str, 0));
        this.parent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.urbandroid.sleep.ads.AdMobController.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Logger.logInfo("ADS ADMOB: tree observer " + AdMobController.this.currentAdView.getAdUnitId() + " " + AdMobController.this.currentAdView);
                try {
                    AdMobController.this.currentAdView.setAdUnitId(str);
                    AdMobController.this.currentAdView.setAdSize(AdMobController.this.getAdSize());
                    AdMobController.this.currentAdView.loadAd(SleepAdRequestBuilder.build(AdMobController.this.parent.getContext()));
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
                AdMobController.this.parent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        this.currentAdView.setAdListener(new AdListener() { // from class: com.urbandroid.sleep.ads.AdMobController.2
            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                if (str2 != null && loadAdError.getCode() == 3) {
                    Logger.logInfo("ADS ADMOB: Loading ADMOB no fill doing fallback");
                    AdMobController.this.load(str2);
                } else {
                    Object obj2 = obj;
                    if (obj2 != null) {
                        ((AdListener) obj2).onAdFailedToLoad(loadAdError);
                    }
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Logger.logInfo("ADS ADMOB: Loaded adunit " + AdMobController.this.currentAdView.getAdUnitId());
                AdMobController.this.currentAdView.setVisibility(0);
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventAdShown(1, AdMobController.this.currentAdView.getAdUnitId());
                Object obj2 = obj;
                if (obj2 != null) {
                    ((AdListener) obj2).onAdLoaded();
                }
            }
        });
    }

    @Override // com.urbandroid.sleep.ads.IAdsController
    public void pause() {
        AdView adView = this.currentAdView;
        if (adView != null) {
            adView.pause();
        }
    }

    @Override // com.urbandroid.sleep.ads.IAdsController
    public void resume() {
        AdView adView = this.currentAdView;
        if (adView != null) {
            adView.resume();
        }
    }

    @Override // com.urbandroid.sleep.ads.IAdsController
    public void load(String str, String str2) {
        load(str, str2, null);
    }

    public void load(String str) {
        load(str, null);
    }
}
