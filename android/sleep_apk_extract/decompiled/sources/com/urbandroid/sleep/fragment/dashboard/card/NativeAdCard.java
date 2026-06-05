package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.work.impl.utils.WorkProgressUpdater$$ExternalSyntheticLambda0;
import com.facebook.GraphResponse;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.facebook.login.LoginManager$$ExternalSyntheticLambda1;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.firebase.ai.type.Tool$$ExternalSyntheticLambda0;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ads.AdMobController$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.ads.SleepAdRequestBuilder;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.trial.Billing;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J4\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016H\u0002J\u0014\u0010\u0018\u001a\u00020\u000b2\n\u0010\u0019\u001a\u00060\u0002R\u00020\u0000H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\t\u0010\u001f\u001a\u00020\u000bH\u0096\u0002J\b\u0010 \u001a\u00020\u000bH\u0016¨\u0006\""}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/NativeAdCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/PageAwareDashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/NativeAdCard$NativeAdViewHolder;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "createViewHolder", "v", "Landroid/view/View;", "onCardClicked", "", ViewHierarchyConstants.VIEW_KEY, "getNameResource", "", "createAdBuilder", "Lcom/google/android/gms/ads/AdLoader;", "pubId", "", "parent", "Landroid/view/ViewGroup;", GraphResponse.SUCCESS_KEY, "Lkotlin/Function0;", "fail", "bindView", "viewHolder", "setRemoved", "removed", "", "isRemovable", "isPinnable", "next", "prev", "NativeAdViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NativeAdCard extends PageAwareDashboardCard<NativeAdViewHolder> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/NativeAdCard$NativeAdViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Lcom/urbandroid/sleep/fragment/dashboard/card/NativeAdCard;Landroid/view/View;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class NativeAdViewHolder extends LayeredViewHolder {
        final /* synthetic */ NativeAdCard this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NativeAdViewHolder(NativeAdCard nativeAdCard, View view) {
            super(view);
            view.getClass();
            this.this$0 = nativeAdCard;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAdCard(Activity activity) {
        super(activity, DashboardCard.Type.NATIVE_AD, R.layout.card_native_ad);
        activity.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindView$lambda$0(NativeAdCard nativeAdCard, NativeAdViewHolder nativeAdViewHolder) {
        Activity context = nativeAdCard.getContext();
        View view = nativeAdViewHolder.itemView;
        view.getClass();
        nativeAdCard.setCardVisibility(context, (ViewGroup) view, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindView$lambda$1(NativeAdCard nativeAdCard, ViewGroup viewGroup, NativeAdViewHolder nativeAdViewHolder) {
        nativeAdCard.createAdBuilder("ca-app-pub-1970766161278534/4091696745", viewGroup, new NativeAdCard$$ExternalSyntheticLambda0(nativeAdCard, nativeAdViewHolder, 1), new Tool$$ExternalSyntheticLambda0(29)).loadAd(SleepAdRequestBuilder.build(nativeAdCard.getContext()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindView$lambda$1$0(NativeAdCard nativeAdCard, NativeAdViewHolder nativeAdViewHolder) {
        Activity context = nativeAdCard.getContext();
        View view = nativeAdViewHolder.itemView;
        view.getClass();
        nativeAdCard.setCardVisibility(context, (ViewGroup) view, true);
        return Unit.INSTANCE;
    }

    private final AdLoader createAdBuilder(String pubId, ViewGroup parent, Function0<Unit> success, final Function0<Unit> fail) {
        Logger.logInfo("ADS ADMOB: loading  " + pubId);
        AdLoader adLoaderBuild = new AdLoader.Builder(getContext(), pubId).withNativeAdOptions(new NativeAdOptions.Builder().setAdChoicesPlacement(1).build()).forNativeAd(new LoginManager$$ExternalSyntheticLambda1(this, parent, (Function0) success, pubId)).withAdListener(new AdListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.NativeAdCard.createAdBuilder.2
            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError p0) {
                p0.getClass();
                super.onAdFailedToLoad(p0);
                zza$$ExternalSyntheticOutline0.m(p0.getCode(), "ADS ADMOB: failed ");
                fail.invoke();
            }
        }).withNativeAdOptions(new NativeAdOptions.Builder().build()).build();
        adLoaderBuild.getClass();
        return adLoaderBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAdBuilder$lambda$0(final NativeAdCard nativeAdCard, ViewGroup viewGroup, Function0 function0, String str, NativeAd nativeAd) {
        String price;
        String string;
        nativeAd.getClass();
        Logger.logInfo("ADS ADMOB: app install loaded ");
        InflatorUtil.Companion companion = InflatorUtil.INSTANCE;
        Activity context = nativeAdCard.getContext();
        context.getClass();
        NativeAdView nativeAdView = (NativeAdView) companion.get(context).inflate(R.layout.card_native_ad_unified, viewGroup, false).findViewById(R.id.native_ad);
        TextView textView = (TextView) nativeAdView.findViewById(R.id.nativead_headline);
        textView.setText(nativeAd.getHeadline());
        nativeAdView.setHeadlineView(textView);
        TextView textView2 = (TextView) nativeAdView.findViewById(R.id.nativead_body);
        if (nativeAd.getBody() != null) {
            textView2.setText(nativeAd.getBody());
            nativeAdView.setBodyView(textView2);
        } else {
            textView2.setVisibility(8);
        }
        TextView textView3 = (TextView) nativeAdView.findViewById(R.id.nativead_call_to_action);
        textView3.setText(nativeAd.getCallToAction());
        nativeAdView.setCallToActionView(textView3);
        ImageView imageView = (ImageView) nativeAdView.findViewById(R.id.nativead_app_icon);
        NativeAd.Image icon = nativeAd.getIcon();
        if (icon != null) {
            imageView.setImageDrawable(icon.getDrawable());
            nativeAdView.setIconView(imageView);
            imageView.setVisibility(0);
        }
        if (nativeAd.getIcon() == null) {
            imageView.setVisibility(8);
        }
        TextView textView4 = (TextView) nativeAdView.findViewById(R.id.nativead_store);
        if (nativeAd.getStore() != null) {
            textView4.setText(nativeAd.getStore());
            nativeAdView.setStoreView(textView4);
            textView4.setVisibility(0);
        } else {
            textView4.setVisibility(8);
        }
        TextView textView5 = (TextView) nativeAdView.findViewById(R.id.nativead_price);
        String price2 = nativeAd.getPrice();
        if (price2 != null && StringsKt.trim(price2).toString().length() > 0) {
            textView5.setText(nativeAd.getPrice());
            nativeAdView.setPriceView(textView5);
            textView5.setVisibility(0);
        }
        if (nativeAd.getPrice() == null || ((price = nativeAd.getPrice()) != null && (string = StringsKt.trim(price).toString()) != null && string.length() > 0)) {
            textView5.setVisibility(8);
        }
        RatingBar ratingBar = (RatingBar) nativeAdView.findViewById(R.id.nativead_stars);
        Double starRating = nativeAd.getStarRating();
        if (starRating != null) {
            ratingBar.setRating((float) starRating.doubleValue());
            nativeAdView.setStarRatingView(ratingBar);
            ratingBar.setVisibility(0);
        }
        if (nativeAd.getStarRating() == null) {
            ratingBar.setVisibility(8);
        }
        MediaView mediaView = (MediaView) nativeAdView.findViewById(R.id.nativead_media);
        nativeAdView.setMediaView(mediaView);
        MediaContent mediaContent = nativeAd.getMediaContent();
        if (mediaContent != null) {
            mediaView.setMediaContent(mediaContent);
        }
        nativeAd.setOnPaidEventListener(new AdMobController$$ExternalSyntheticLambda0(str, 2));
        mediaView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.NativeAdCard$createAdBuilder$1$6
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View parent, View child) {
                parent.getClass();
                child.getClass();
                int i = (int) ((175.0f * this.this$0.getContext().getResources().getDisplayMetrics().density) + 0.5f);
                if (child instanceof ImageView) {
                    ImageView imageView2 = (ImageView) child;
                    imageView2.setAdjustViewBounds(true);
                    imageView2.setMaxHeight(i);
                } else {
                    ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                    layoutParams.height = i;
                    child.setLayoutParams(layoutParams);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View parent, View child) {
                parent.getClass();
                child.getClass();
            }
        });
        nativeAdView.setNativeAd(nativeAd);
        viewGroup.removeAllViews();
        viewGroup.addView(nativeAdView);
        viewGroup.findViewById(R.id.remove_ads_button).setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(nativeAdCard, 13));
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventAdShown(2, String.valueOf(nativeAd.getPlacementId()));
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAdBuilder$lambda$0$4(String str, AdValue adValue) {
        adValue.getClass();
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventAdPaid(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, str, Billing.PurchaseType.Companion.getPriceAmountInBaseCurrency$default(Billing.PurchaseType.INSTANCE, adValue, 0.0f, 2, (Object) null), adValue.getValueMicros(), adValue.getCurrencyCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAdBuilder$lambda$0$5(NativeAdCard nativeAdCard, View view) {
        Activity context = nativeAdCard.getContext();
        context.getClass();
        ((AlarmClock) context).startUnlockFlow();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(NativeAdViewHolder viewHolder) {
        viewHolder.getClass();
        Activity context = getContext();
        View view = viewHolder.itemView;
        view.getClass();
        setCardVisibility(context, (ViewGroup) view, false);
        View viewFindViewById = viewHolder.itemView.findViewById(R.id.foreground);
        viewFindViewById.getClass();
        ViewGroup viewGroup = (ViewGroup) viewFindViewById;
        createAdBuilder("ca-app-pub-1970766161278534/1820756622", viewGroup, new NativeAdCard$$ExternalSyntheticLambda0(this, viewHolder, 0), new WorkProgressUpdater$$ExternalSyntheticLambda0(this, viewGroup, viewHolder, 2)).loadAd(SleepAdRequestBuilder.build(getContext()));
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public NativeAdViewHolder createViewHolder(View v) {
        v.getClass();
        return new NativeAdViewHolder(this, v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.no_ads;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isPinnable() {
        return super.isPinnable();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isRemovable() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.PageAwareDashboardCard
    public void next() {
        refresh();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.PageAwareDashboardCard
    public void prev() {
        next();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void setRemoved(boolean removed) {
    }
}
