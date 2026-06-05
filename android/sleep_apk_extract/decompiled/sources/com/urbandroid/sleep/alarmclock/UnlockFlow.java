package com.urbandroid.sleep.alarmclock;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.work.impl.Processor$$ExternalSyntheticLambda1;
import com.facebook.login.LoginManager$$ExternalSyntheticLambda1;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ColorUtil;
import com.urbandroid.common.util.DecimalUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.UnlockReviewProvider;
import com.urbandroid.sleep.ads.SleepAdRequestBuilder;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.trial.Billing;
import com.urbandroid.sleep.trial.IBillingStatusListener;
import com.urbandroid.sleep.trial.JavaBilling;
import com.urbandroid.sleep.trial.RestoreInAppPreviewActivity;
import com.urbandroid.sleep.trial.RestoreUnlockPreviewActivity;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class UnlockFlow {
    private Animation attentionAnim;
    private JavaBilling billing;
    private Activity c;
    private Animation hideAnim;
    private UnlockFlowListener listener;
    private ViewGroup v;
    private boolean externalBillingServiceHelper = true;
    private String analyticsEvent = null;
    private double unlockPrice = -1.0d;
    private Handler h = new Handler();

    /* JADX INFO: renamed from: com.urbandroid.sleep.alarmclock.UnlockFlow$1, reason: invalid class name */
    public class AnonymousClass1 extends RewardedAdLoadCallback {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onAdLoaded$0(AdValue adValue) {
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventAdPaid("rewarded", "ca-app-pub-1970766161278534/5566800524", Billing.PurchaseType.getPriceAmountInBaseCurrency(adValue), adValue.getValueMicros(), adValue.getCurrencyCode());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAdLoaded$1(RewardItem rewardItem) {
            Logger.logInfo("Reward: rewarded " + rewardItem.getType() + " amount " + rewardItem.getAmount());
            new Settings(UnlockFlow.this.c).addExtendTrialHours(rewardItem.getAmount());
            TrialFilter.getInstance().refresh();
            Toast.makeText(UnlockFlow.this.c, MqttTopic.SINGLE_LEVEL_WILDCARD + UnlockFlow.this.c.getString(R.string.hours, String.valueOf(rewardItem.getAmount())) + ". " + TrialFilter.getTrialProgressText(UnlockFlow.this.c) + ".", 1).show();
            UnlockFlow.this.listener.onBackButton();
            UnlockFlow.this.c.recreate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAdLoaded$2(RewardedAd rewardedAd, View view) {
            rewardedAd.show(UnlockFlow.this.c, new UnlockFlow$1$$ExternalSyntheticLambda2(this));
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdLoaded(RewardedAd rewardedAd) {
            super.onAdLoaded(rewardedAd);
            rewardedAd.setOnPaidEventListener(new UnlockFlow$1$$ExternalSyntheticLambda0());
            int amount = rewardedAd.getRewardItem().getAmount();
            UnlockFlow.this.v.findViewById(R.id.rewarded_card).setVisibility(0);
            ((TextView) UnlockFlow.this.v.findViewById(R.id.rewarded_title)).setText(UnlockFlow.this.c.getString(R.string.hours, String.valueOf(Math.max(amount, 12))));
            UnlockFlow.this.v.findViewById(R.id.rewarded_card).setOnClickListener(new SetAlarm$$ExternalSyntheticLambda11(this, rewardedAd, 2));
        }
    }

    public interface UnlockFlowListener extends Serializable {
        void onBackButton();
    }

    public UnlockFlow(Activity activity, ViewGroup viewGroup, UnlockFlowListener unlockFlowListener) {
        this.c = activity;
        this.v = viewGroup;
        this.attentionAnim = AnimationUtils.loadAnimation(activity, R.anim.blow);
        this.hideAnim = AnimationUtils.loadAnimation(activity, R.anim.hide_short);
        this.listener = unlockFlowListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadPrices$19(JavaBilling javaBilling, View view) {
        javaBilling.startPurchaseFlow(Billing.PurchaseType.detectYearly());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPrices$20(JavaBilling javaBilling, View view) {
        Logger.logInfo("Unlock: LT action " + javaBilling);
        if (javaBilling != null) {
            javaBilling.startPurchaseFlow(Billing.PurchaseType.detectLifetime());
            return;
        }
        ViewIntent.market(this.c, "com.urbandroid.sleep.full.key");
        if (this.unlockPrice > 0.0d) {
            SharedApplicationContext.getSettings().setUnlockPrice((float) this.unlockPrice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPrices$21(List list, JavaBilling javaBilling) {
        Iterator it;
        String str;
        Logger.logInfo("Unlock: load prices found " + list.size());
        View viewFindViewById = this.v.findViewById(R.id.yearly_card);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda8(javaBilling, 2));
        }
        View viewFindViewById2 = this.v.findViewById(R.id.lifetime_card);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new SetAlarm$$ExternalSyntheticLambda11(this, javaBilling, 4));
            viewFindViewById2.setVisibility(0);
        }
        Iterator it2 = list.iterator();
        String price = null;
        String price2 = null;
        while (it2.hasNext()) {
            Billing.LoadedSkuDetail loadedSkuDetail = (Billing.LoadedSkuDetail) it2.next();
            Logger.logInfo("Unlock: load prices SKU " + loadedSkuDetail.getDetail().getSku() + " detect LT " + Billing.PurchaseType.detectLifetime() + " detect Y " + Billing.PurchaseType.detectYearly() + " detect M " + Billing.PurchaseType.detectMonthly());
            int iDetectSalePercentage = Billing.PurchaseType.detectSalePercentage();
            int iDetectYearlySalePercentage = Billing.PurchaseType.detectYearlySalePercentage();
            int iDetectFirstYearSalePercentage = Billing.PurchaseType.detectFirstYearSalePercentage();
            if (Billing.PurchaseType.detectLifetimeBase().getPkg().equals(loadedSkuDetail.getDetail().getSku())) {
                price2 = loadedSkuDetail.getDetail().getPrice();
            }
            String price3 = Billing.PurchaseType.detectYearlyBase().getPkg().equals(loadedSkuDetail.getDetail().getSku()) ? loadedSkuDetail.getDetail().getPrice() : null;
            if (Billing.PurchaseType.detectLifetimeBase().getPkg().equals(loadedSkuDetail.getDetail().getSku())) {
                price2 = loadedSkuDetail.getDetail().getPrice();
            }
            if (Billing.PurchaseType.detectLifetime().getPkg().equals(loadedSkuDetail.getDetail().getSku())) {
                ((TextView) this.v.findViewById(R.id.price_unlock)).setText(price2);
                if (this.unlockPrice == -1.0d) {
                    this.unlockPrice = Billing.PurchaseType.INSTANCE.getPriceAmountInBaseCurrency(loadedSkuDetail.getDetail());
                }
                if (iDetectSalePercentage > 0) {
                    ((TextView) this.v.findViewById(R.id.price_unlock_sale)).setText(this.c.getString(R.string.sale, iDetectSalePercentage + "%"));
                    price = loadedSkuDetail.getDetail().getPrice();
                }
                StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Unlock: LT ", price, " <--sale-- ", price2, " ");
                sbM6m.append(iDetectSalePercentage);
                sbM6m.append(" % ");
                Logger.logInfo(sbM6m.toString());
            } else if (Billing.PurchaseType.detectMonthly().getPkg().equals(loadedSkuDetail.getDetail().getSku())) {
                ((TextView) this.v.findViewById(R.id.price_sub)).setText(loadedSkuDetail.getDetail().getPrice());
            } else {
                if (Billing.PurchaseType.detectYearly().getPkg().equals(loadedSkuDetail.getDetail().getSku())) {
                    float priceAmountMicros = loadedSkuDetail.getDetail().getPriceAmountMicros() / 1000000.0f;
                    String price4 = loadedSkuDetail.getDetail().getPrice();
                    ((TextView) this.v.findViewById(R.id.price_ysub)).setText(price4);
                    String introductoryPrice = loadedSkuDetail.getDetail().getIntroductoryPrice();
                    it = it2;
                    this.v.findViewById(R.id.ysub_promo_bar).setVisibility(8);
                    this.v.findViewById(R.id.ysub_promo_bar_time_limited).setVisibility(8);
                    if (iDetectYearlySalePercentage > 0) {
                        str = price2;
                        ((TextView) this.v.findViewById(R.id.ysub_promo_bar)).setText(this.c.getString(R.string.sale, iDetectYearlySalePercentage + "%"));
                        this.v.findViewById(R.id.ysub_promo_bar).setVisibility(0);
                        this.v.findViewById(R.id.ysub_promo_bar_time_limited).setVisibility(0);
                        ViewGroup viewGroup = this.v;
                        if (price3 != null) {
                            viewGroup.findViewById(R.id.ysub_price_before_sale).setVisibility(0);
                            ((TextView) this.v.findViewById(R.id.ysub_price_before_sale)).setPaintFlags(16);
                            ((TextView) this.v.findViewById(R.id.ysub_price_before_sale)).setText(price3);
                        } else {
                            viewGroup.findViewById(R.id.ysub_price_before_sale).setVisibility(8);
                        }
                    } else {
                        str = price2;
                    }
                    ViewGroup viewGroup2 = this.v;
                    if (iDetectFirstYearSalePercentage > 0) {
                        viewGroup2.findViewById(R.id.price_ysub_first_year_promo).setVisibility(0);
                        TextView textView = (TextView) this.v.findViewById(R.id.price_ysub_first_year_promo);
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.c.getString(R.string.sale, iDetectFirstYearSalePercentage + "%"));
                        sb.append(" / ");
                        sb.append(this.c.getString(R.string.first_year));
                        textView.setText(sb.toString());
                        if (introductoryPrice == null || introductoryPrice.isEmpty()) {
                            introductoryPrice = DecimalUtil.formatAlways2Decimal(((100 - iDetectFirstYearSalePercentage) / 100.0f) * priceAmountMicros) + " " + loadedSkuDetail.getDetail().getPriceCurrencyCode();
                        }
                        ((TextView) this.v.findViewById(R.id.price_ysub)).setText(Html.fromHtml("<small><small>" + this.c.getString(R.string.first_year) + "</small></small><br/>" + introductoryPrice, 0));
                        this.v.findViewById(R.id.price_ysub_more).setVisibility(0);
                        ((TextView) this.v.findViewById(R.id.price_ysub_more)).setTextColor(ColorUtil.i(this.c, R.color.tertiary));
                        ((TextView) this.v.findViewById(R.id.price_ysub_more)).setText(Html.fromHtml("<small>" + this.c.getString(R.string.next_year) + "</small><br/>" + price4, 0));
                    } else {
                        viewGroup2.findViewById(R.id.price_ysub_more).setVisibility(0);
                        ((TextView) this.v.findViewById(R.id.price_ysub_more)).setTextColor(ColorUtil.i(this.c, R.color.quaternary));
                        String str2 = loadedSkuDetail.getDetail().getPriceCurrencyCode() + " " + DecimalUtil.formatAlways2Decimal(priceAmountMicros / 12.0f);
                        TextView textView2 = (TextView) this.v.findViewById(R.id.price_ysub_more);
                        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(str2, " / ");
                        sbM.append(this.c.getString(R.string.month));
                        textView2.setText(sbM.toString());
                    }
                    StringBuilder sbM6m2 = FileInsert$$ExternalSyntheticOutline0.m6m("Unlock: Y ", introductoryPrice, " <--sale-- ", price4, " ");
                    sbM6m2.append(iDetectYearlySalePercentage);
                    sbM6m2.append(" % 1.Y ");
                    sbM6m2.append(iDetectFirstYearSalePercentage);
                    sbM6m2.append(" % ");
                    Logger.logInfo(sbM6m2.toString());
                }
                it2 = it;
                price2 = str;
            }
            it = it2;
            str = price2;
            it2 = it;
            price2 = str;
        }
        ViewGroup viewGroup3 = this.v;
        if (price != null) {
            viewGroup3.findViewById(R.id.unlock_outline).setBackground(ContextCompat.getDrawable(this.c, R.drawable.card_outline_special));
            this.v.findViewById(R.id.price_unlock_sale).setVisibility(0);
            this.v.findViewById(R.id.price_unlock_sale_time_limited).setVisibility(0);
            boolean zEquals = price.equals(price2);
            ViewGroup viewGroup4 = this.v;
            if (zEquals || price2 == null) {
                viewGroup4.findViewById(R.id.price_unlock_price_before_sale).setVisibility(8);
            } else {
                viewGroup4.findViewById(R.id.price_unlock_price_before_sale).setVisibility(0);
                ((TextView) this.v.findViewById(R.id.price_unlock_price_before_sale)).setPaintFlags(16);
                ((TextView) this.v.findViewById(R.id.price_unlock_price_before_sale)).setText(price2);
            }
            ((TextView) this.v.findViewById(R.id.price_unlock)).setText(price);
        } else {
            viewGroup3.findViewById(R.id.price_unlock_sale).setVisibility(8);
            this.v.findViewById(R.id.price_unlock_sale_time_limited).setVisibility(8);
            ((TextView) this.v.findViewById(R.id.price_unlock_price_before_sale)).setPaintFlags(0);
            this.v.findViewById(R.id.unlock_outline).setBackground(ContextCompat.getDrawable(this.c, R.drawable.card_outline));
            this.v.findViewById(R.id.price_unlock_price_before_sale).setVisibility(8);
        }
        this.v.findViewById(R.id.ysub_outline).setBackground(ContextCompat.getDrawable(this.c, R.drawable.card_outline_special));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPrices$22(JavaBilling javaBilling, List list, Set set) {
        this.h.post(new Processor$$ExternalSyntheticLambda1(this, list, javaBilling, 6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$10(View view) {
        UnlockFlowListener unlockFlowListener = this.listener;
        if (unlockFlowListener != null) {
            unlockFlowListener.onBackButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$11(View view) {
        ViewIntent.url(view.getContext(), "https://sleep.urbandroid.org/docs//general/plan.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        Logger.logInfo("Unlock: Unlock onClick() " + this.billing);
        JavaBilling javaBilling = this.billing;
        if (javaBilling != null) {
            javaBilling.startPurchaseFlow(Billing.PurchaseType.detectLifetime());
            return;
        }
        ViewIntent.market(this.c, "com.urbandroid.sleep.full.key");
        if (this.unlockPrice > 0.0d) {
            SharedApplicationContext.getSettings().setUnlockPrice((float) this.unlockPrice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(DialogInterface dialogInterface, int i) {
        this.c.showDialog(64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.c.startActivityForResult(new Intent(this.c, (Class<?>) RestoreInAppPreviewActivity.class), 1);
        } else {
            if (i != 1) {
                return;
            }
            this.c.startActivityForResult(new Intent(this.c, (Class<?>) RestoreUnlockPreviewActivity.class), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this.c);
        materialAlertDialogBuilder.setTitle(R.string.unlock_restore_how);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.c, R.layout.simple_list_item_centered);
        arrayAdapter.add(this.c.getResources().getString(R.string.trial_unlock_inapp));
        arrayAdapter.add(this.c.getResources().getString(R.string.trial_unlock));
        materialAlertDialogBuilder.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        final int i = 0;
        materialAlertDialogBuilder.setNeutralButton(R.string.get_support, new DialogInterface.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.UnlockFlow$$ExternalSyntheticLambda21
            public final /* synthetic */ UnlockFlow f$0;

            {
                this.f$0 = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                int i3 = i;
                UnlockFlow unlockFlow = this.f$0;
                switch (i3) {
                    case 0:
                        unlockFlow.lambda$onCreate$4(dialogInterface, i2);
                        break;
                    default:
                        unlockFlow.lambda$onCreate$5(dialogInterface, i2);
                        break;
                }
            }
        });
        final int i2 = 1;
        materialAlertDialogBuilder.setAdapter((ListAdapter) arrayAdapter, new DialogInterface.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.UnlockFlow$$ExternalSyntheticLambda21
            public final /* synthetic */ UnlockFlow f$0;

            {
                this.f$0 = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i22) {
                int i3 = i2;
                UnlockFlow unlockFlow = this.f$0;
                switch (i3) {
                    case 0:
                        unlockFlow.lambda$onCreate$4(dialogInterface, i22);
                        break;
                    default:
                        unlockFlow.lambda$onCreate$5(dialogInterface, i22);
                        break;
                }
            }
        });
        materialAlertDialogBuilder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$onCreate$7(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(View view) {
        this.c.startActivity(new Intent(this.c, (Class<?>) UnlockFlowFeaturesActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$9(View view) {
        UnlockFlowListener unlockFlowListener = this.listener;
        if (unlockFlowListener != null) {
            unlockFlowListener.onBackButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$12(View view) {
        this.billing.startPurchaseFlow(Billing.PurchaseType.detectMonthly());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$13(View view) {
        this.billing.startPurchaseFlow(Billing.PurchaseType.detectYearly());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$14(View view) {
        this.billing.startPurchaseFlow(Billing.PurchaseType.detectLifetime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$15(View view, View view2, View view3, String str, IBillingStatusListener.Status status) {
        Logger.logInfo("Unlock: Billing status " + status.name());
        if (view != null) {
            view.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda1(this, 6));
            view.setVisibility(0);
        }
        if (view2 != null) {
            view2.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda1(this, 7));
            view2.setVisibility(0);
        }
        if (view3 != null) {
            view3.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda1(this, 8));
            view3.setVisibility(0);
        }
        loadPrices(this.billing);
        this.billing.refreshSleepPurchaseState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$16(View view) {
        JavaBilling javaBilling = this.billing;
        if (javaBilling != null) {
            javaBilling.startPurchaseFlow(Billing.PurchaseType.MONTHLY_SUBSCRIPTION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$17(View view) {
        JavaBilling javaBilling = this.billing;
        if (javaBilling != null) {
            javaBilling.startPurchaseFlow(Billing.PurchaseType.detectYearly());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$18(View view) {
        JavaBilling javaBilling = this.billing;
        if (javaBilling != null) {
            javaBilling.startPurchaseFlow(Billing.PurchaseType.detectLifetime());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setBilling$0(JavaBilling javaBilling, View view) {
        javaBilling.startPurchaseFlow(Billing.PurchaseType.detectMonthly());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setBilling$1(JavaBilling javaBilling, View view) {
        javaBilling.startPurchaseFlow(Billing.PurchaseType.detectYearly());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setBilling$2(JavaBilling javaBilling, View view) {
        javaBilling.startPurchaseFlow(Billing.PurchaseType.detectLifetime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showUnlockDialog$23(Activity activity, DialogInterface dialogInterface, int i) {
        activity.finish();
        AlarmClock.startPurchaseFlow(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showUnlockDialog$24(boolean z, Activity activity, DialogInterface dialogInterface) {
        if (z) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showUnlockDialog$25(boolean z, Activity activity, DialogInterface dialogInterface) {
        if (z) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showUnlockDialog$26(boolean z, Activity activity, DialogInterface dialogInterface, int i) {
        if (z) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showWarningDialog$27(boolean z, Activity activity, DialogInterface dialogInterface, int i) {
        if (z) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showWarningDialog$28(boolean z, Activity activity, DialogInterface dialogInterface) {
        if (z) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showWarningDialog$29(boolean z, Activity activity, DialogInterface dialogInterface) {
        if (z) {
            activity.finish();
        }
    }

    private void loadPrices(JavaBilling javaBilling) {
        Logger.logInfo("Unlock: load prices " + javaBilling);
        javaBilling.resolveSkuDetails(Billing.PurchaseType.activeProducts(), new AlarmClock$$ExternalSyntheticLambda2(this, javaBilling));
    }

    public static void showUnlockDialog(Activity activity, boolean z) {
        int i = 0;
        new MaterialAlertDialogBuilder(activity).setMessage((CharSequence) activity.getString(R.string.unlock_text)).setTitle(R.string.app_name_long_unlock).setIcon(R.drawable.ic_lock_unlock).setPositiveButton(R.string.trial_unlock, (DialogInterface.OnClickListener) new UnlockFlow$$ExternalSyntheticLambda4(activity, i)).setOnDismissListener((DialogInterface.OnDismissListener) new UnlockFlow$$ExternalSyntheticLambda5(activity, i, z)).setOnCancelListener((DialogInterface.OnCancelListener) new UnlockFlow$$ExternalSyntheticLambda6(activity, i, z)).setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) new UnlockFlow$$ExternalSyntheticLambda7(activity, i, z)).show();
    }

    public static void showWarningDialog(Activity activity, String str, boolean z) {
        Logger.logInfo("Warning dialog: " + str);
        int i = 1;
        new MaterialAlertDialogBuilder(activity).setMessage((CharSequence) str).setIcon(R.drawable.ic_lock_unlock).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new UnlockFlow$$ExternalSyntheticLambda7(activity, i, z)).setOnDismissListener((DialogInterface.OnDismissListener) new UnlockFlow$$ExternalSyntheticLambda5(activity, i, z)).setOnCancelListener((DialogInterface.OnCancelListener) new UnlockFlow$$ExternalSyntheticLambda6(activity, i, z)).show();
    }

    public void back() {
        UnlockFlowListener unlockFlowListener = this.listener;
        if (unlockFlowListener != null) {
            unlockFlowListener.onBackButton();
        }
    }

    public void onCreate() {
        Logger.logInfo("Unlock: create()");
        ((TextView) this.v.findViewById(R.id.price_ysub_promo)).setText(this.c.getString(R.string.subscription_free_period, "7"));
        ((TextView) this.v.findViewById(R.id.ysub_summary)).setText(this.v.getContext().getString(R.string.subscription_yearly) + ", " + this.v.getContext().getString(R.string.cancel_any_time).toLowerCase());
        ((TextView) this.v.findViewById(R.id.sub_summary)).setText(this.v.getContext().getString(R.string.subscription_monthly) + ", " + this.v.getContext().getString(R.string.cancel_any_time).toLowerCase());
        TextView textView = (TextView) this.v.findViewById(R.id.new_sounds);
        if (textView != null) {
            textView.setText(this.c.getString(R.string.ringtone_nature_WHALE) + ", " + this.c.getString(R.string.ringtone_nature_STREAM) + ", " + this.c.getString(R.string.ringtone_nature_SEA) + ", " + this.c.getString(R.string.ringtone_sleepyheads_HORN) + ", " + this.c.getString(R.string.ringtone_sleepyheads_BELLS));
        }
        TextView textView2 = (TextView) this.v.findViewById(R.id.new_lullabies);
        if (textView2 != null) {
            textView2.setText(this.c.getString(R.string.lullaby_name_SEA) + ", " + this.c.getString(R.string.lullaby_name_FIREPLACE) + ", " + this.c.getString(R.string.lullaby_name_WIND) + ", " + this.c.getString(R.string.lullaby_name_TIBET) + ", " + this.c.getString(R.string.lullaby_name_CAVE) + ", " + this.c.getString(R.string.lullaby_name_CLOCK));
        }
        this.v.findViewById(R.id.lifetime_card).setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda1(this, 1));
        View viewFindViewById = this.v.findViewById(R.id.restore_purchase_layout);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda1(this, 2));
        }
        this.v.setOnTouchListener(new UnlockFlow$$ExternalSyntheticLambda16());
        this.v.findViewById(R.id.extend_layout).setVisibility(8);
        if (TrialFilter.getInstance().canExtendTrial()) {
            Activity activity = this.c;
            RewardedAd.load(activity, "ca-app-pub-1970766161278534/5566800524", SleepAdRequestBuilder.build(activity), new AnonymousClass1());
        } else {
            Logger.logInfo("Reward: cannot extend ");
        }
        View viewFindViewById2 = this.v.findViewById(R.id.read_more);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda1(this, 3));
        }
        View viewFindViewById3 = this.v.findViewById(R.id.use_free);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda1(this, 4));
        }
        View viewFindViewById4 = this.v.findViewById(R.id.back_button);
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda1(this, 5));
        }
        View viewFindViewById5 = this.v.findViewById(R.id.help_button);
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda20());
        }
        new UnlockReviewProvider(this.c).addReviewsToView((LinearLayoutCompat) this.v.findViewById(R.id.reviews));
    }

    public void onStart() {
        Logger.logInfo("Unlock: start()");
        View viewFindViewById = this.v.findViewById(R.id.monthly_card);
        View viewFindViewById2 = this.v.findViewById(R.id.yearly_card);
        View viewFindViewById3 = this.v.findViewById(R.id.lifetime_card);
        int i = 0;
        if (viewFindViewById != null && this.billing == null) {
            Logger.logInfo("Unlock: no billing");
            try {
                Logger.logInfo("Unlock: UnlockPreview get billing service");
                this.externalBillingServiceHelper = false;
                this.billing = new JavaBilling(this.c, new LoginManager$$ExternalSyntheticLambda1(this, viewFindViewById, viewFindViewById2, viewFindViewById3), null);
                return;
            } catch (Exception e) {
                Logger.logWarning("BSH creation failed.", e);
                return;
            }
        }
        Logger.logInfo("Unlock: load prices");
        loadPrices(this.billing);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda1(this, i));
            viewFindViewById.setVisibility(0);
        }
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda1(this, 9));
            viewFindViewById2.setVisibility(0);
        }
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda1(this, 10));
            viewFindViewById3.setVisibility(0);
        }
    }

    public void onStop() {
        Logger.logInfo("Unlock: stop()");
        this.v.findViewById(R.id.activity_unlock).startAnimation(this.hideAnim);
        JavaBilling javaBilling = this.billing;
        if (javaBilling != null && !this.externalBillingServiceHelper) {
            javaBilling.destroy();
        }
        this.billing = null;
    }

    public void setBilling(JavaBilling javaBilling) {
        this.billing = javaBilling;
        if (javaBilling != null) {
            Logger.logInfo("Unlock: setBilling " + javaBilling);
            View viewFindViewById = this.v.findViewById(R.id.monthly_card);
            int i = 0;
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda8(javaBilling, i));
                viewFindViewById.setVisibility(0);
            }
            View viewFindViewById2 = this.v.findViewById(R.id.yearly_card);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda8(javaBilling, 3));
                viewFindViewById2.setVisibility(0);
            }
            View viewFindViewById3 = this.v.findViewById(R.id.lifetime_card);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setOnClickListener(new UnlockFlow$$ExternalSyntheticLambda8(javaBilling, 1));
                viewFindViewById3.setVisibility(0);
            }
        }
    }
}
