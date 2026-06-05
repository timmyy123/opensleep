package com.urbandroid.sleep.alarmclock.settings;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsResult;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.google.home.platform.traits.ValidationIssue;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.SleepDeviceAdminReceiver;
import com.urbandroid.sleep.gui.ListPreferenceWithButton;
import com.urbandroid.sleep.gui.MaterialDialogListPreference;
import com.urbandroid.sleep.gui.PreferenceActivity;
import com.urbandroid.sleep.gui.dialog.CaptchaAvoidedDialogFragment;
import com.urbandroid.sleep.gui.dialog.OnDismissedListener;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.trial.Billing;
import com.urbandroid.sleep.trial.BillingKt;
import com.urbandroid.sleep.trial.PurchaseResult;
import com.urbandroid.util.VolumeUtil$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 :2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001:B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0014J\u001e\u0010\u0018\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u000f\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0014J$\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001d2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\bH\u0002J\u001e\u0010*\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\bH\u0002J&\u0010,\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\b2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010/\u001a\u00020$H\u0002J\u0012\u00100\u001a\u00020\u00122\b\b\u0002\u0010/\u001a\u00020$H\u0002J\b\u00101\u001a\u00020\u0012H\u0002J\b\u00102\u001a\u00020\u0012H\u0014J\b\u00103\u001a\u00020\u0012H\u0002J\b\u00104\u001a\u00020\u0012H\u0002J\b\u00105\u001a\u00020\u0012H\u0002R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0012\u00106\u001a\u000207X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006;"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/CaptchaCheatingSettingsActivity;", "Lcom/urbandroid/sleep/alarmclock/settings/SimpleSettingsActivity;", "Lcom/urbandroid/sleep/gui/dialog/OnDismissedListener;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "refundButton", "Landroid/widget/Button;", "settings", "Lcom/urbandroid/sleep/service/Settings;", "getSettings", "()Lcom/urbandroid/sleep/service/Settings;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreference", "paramBundle", "onDestroy", "onDismiss", "type", "Ljava/lang/Class;", "Landroidx/fragment/app/DialogFragment;", "result", "", "getTitleResource", "getDocumentationUrl", "refresh", "preferenceActivity", "Lcom/urbandroid/sleep/gui/PreferenceActivity;", "searchMode", "", "setPhoneSwitchOffPrefSummary", "pref", "Landroid/preference/Preference;", "entry", "price", "refreshPhoneSwitchOffPref", "sku", "startWagerPurchase", "skuType", "Lcom/urbandroid/sleep/trial/Billing$PurchaseType;", "retry", "startWagerRefundFlow", "showNoEscapeDialog", "onResume", "resetPhoneSwitchOff", "showRefundErrorDispute", "showRefundErrorTryAgain", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CaptchaCheatingSettingsActivity extends SimpleSettingsActivity implements OnDismissedListener, CoroutineScope, FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Button refundButton;
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.MainScope();
    private final String tag = "CaptchaCheating";
    private final Settings settings = new Settings(this);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/CaptchaCheatingSettingsActivity$Companion;", "", "<init>", "()V", "EXTRA_START_PURCHASE", "", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "startPurchase", "startDispute", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(Context context) {
            context.getClass();
            context.startActivity(new Intent(context, (Class<?>) CaptchaCheatingSettingsActivity.class));
        }

        public final void startDispute(Context context) {
            context.getClass();
            ViewIntent.sendTo(context, "support@urbandroid.org", Fragment$$ExternalSyntheticOutline1.m(context.getString(R.string.wakeup_motivation), " ", context.getString(R.string.dispute), " ", ContextExtKt.getSettings(context).getCaptchaAvoidedOrderId()), FileInsert$$ExternalSyntheticOutline0.m("Refund my wake up motivation wager, order id: ", new Settings(context).getCaptchaAvoidedOrderId(), ". I did not cheat CAPTCHA!"));
        }

        public final void startPurchase(Context context) {
            context.getClass();
            Intent intent = new Intent(context, (Class<?>) CaptchaCheatingSettingsActivity.class);
            intent.putExtra("start_purchase", true);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.alarmclock.settings.CaptchaCheatingSettingsActivity$startWagerPurchase$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.alarmclock.settings.CaptchaCheatingSettingsActivity$startWagerPurchase$1", f = "CaptchaCheatingSettingsActivity.kt", l = {ValidationIssue.UNSUPPORTED_ENTITY_EVENT_FIELD_NUMBER}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Billing.PurchaseType $purchaseType;
        final /* synthetic */ boolean $retry;
        final /* synthetic */ String $sku;
        final /* synthetic */ Billing.PurchaseType $skuType;
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.alarmclock.settings.CaptchaCheatingSettingsActivity$startWagerPurchase$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/sleep/trial/Billing;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.alarmclock.settings.CaptchaCheatingSettingsActivity$startWagerPurchase$1$1", f = "CaptchaCheatingSettingsActivity.kt", l = {ValidationIssue.UNSUPPORTED_ENTITY_COMMAND_FIELD_NUMBER, 210, 214, 230, 232}, m = "invokeSuspend", v = 2)
        public static final class C00321 extends SuspendLambda implements Function2<Billing, Continuation<? super Unit>, Object> {
            final /* synthetic */ Billing.PurchaseType $purchaseType;
            final /* synthetic */ boolean $retry;
            final /* synthetic */ String $sku;
            final /* synthetic */ Billing.PurchaseType $skuType;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;
            final /* synthetic */ CaptchaCheatingSettingsActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00321(Billing.PurchaseType purchaseType, boolean z, String str, CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity, Billing.PurchaseType purchaseType2, Continuation<? super C00321> continuation) {
                super(2, continuation);
                this.$purchaseType = purchaseType;
                this.$retry = z;
                this.$sku = str;
                this.this$0 = captchaCheatingSettingsActivity;
                this.$skuType = purchaseType2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00321 c00321 = new C00321(this.$purchaseType, this.$retry, this.$sku, this.this$0, this.$skuType, continuation);
                c00321.L$0 = obj;
                return c00321;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Billing billing, Continuation<? super Unit> continuation) {
                return ((C00321) create(billing, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:25:0x0109, code lost:
            
                if (r1.consumeSku("inapp", r5, r16) == r2) goto L44;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0152, code lost:
            
                if (r1.consume(r3, r16) == r2) goto L44;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x01f4, code lost:
            
                if (r3 != r2) goto L45;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object objPurchase;
                String orderId;
                Purchase purchase;
                String str;
                BillingResult billingResult;
                Object objQuerySkuDetails;
                SkuDetails skuDetails;
                Billing billing = (Billing) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Billing.PurchaseType purchaseType = this.$purchaseType;
                    this.L$0 = billing;
                    this.label = 1;
                    objPurchase = billing.purchase(purchaseType, this);
                    if (objPurchase != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    objPurchase = obj;
                } else {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity = this.this$0;
                        Toast.makeText(captchaCheatingSettingsActivity, captchaCheatingSettingsActivity.getString(R.string.general_unspecified_error) + ". " + this.this$0.getString(R.string.try_again), 1).show();
                        return Unit.INSTANCE;
                    }
                    if (i == 3) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.startWagerPurchase(this.$sku, this.$skuType, true);
                        return Unit.INSTANCE;
                    }
                    if (i != 4) {
                        if (i != 5) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        objQuerySkuDetails = obj;
                        List<SkuDetails> skuDetailsList = ((SkuDetailsResult) objQuerySkuDetails).getSkuDetailsList();
                        String price = (skuDetailsList == null || (skuDetails = (SkuDetails) CollectionsKt.firstOrNull((List) skuDetailsList)) == null) ? null : skuDetails.getPrice();
                        String strM = FileInsert$$ExternalSyntheticOutline0.m("price ", price);
                        Logger.logInfo(Logger.defaultTag, billing.getTag() + ": " + strM, null);
                        this.this$0.getSettings().setCaptchaAvoidedPrice(price);
                        this.this$0.refreshPhoneSwitchOffPref(this.$sku, price);
                        return Unit.INSTANCE;
                    }
                    str = (String) this.L$4;
                    orderId = (String) this.L$3;
                    purchase = (Purchase) this.L$2;
                    billingResult = (BillingResult) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    Billing.PurchaseType purchaseType2 = this.$purchaseType;
                    this.L$0 = billing;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(billingResult);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(purchase);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(orderId);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                    this.label = 5;
                    objQuerySkuDetails = billing.querySkuDetails(purchaseType2, this);
                }
                PurchaseResult purchaseResult = (PurchaseResult) objPurchase;
                BillingResult billingResultComponent1 = purchaseResult.getBillingResult();
                Purchase purchaseComponent2 = purchaseResult.getPurchase();
                String str2 = "purchase result: " + BillingKt.pretty(billingResultComponent1) + " " + purchaseComponent2;
                Logger.logInfo(Logger.defaultTag, billing.getTag() + ": " + str2, null);
                if (this.$retry || billingResultComponent1.getResponseCode() != 7) {
                    if (billingResultComponent1.getResponseCode() != 0 || purchaseComponent2 == null) {
                        if (billingResultComponent1.getResponseCode() != 1) {
                            Toast.makeText(this.this$0, R.string.general_unspecified_error, 1).show();
                        }
                        return Unit.INSTANCE;
                    }
                    orderId = purchaseComponent2.getOrderId();
                    String purchaseToken = purchaseComponent2.getPurchaseToken();
                    purchaseToken.getClass();
                    this.this$0.getSettings().saveCaptchaAvoidedPurchase(this.$sku, orderId, purchaseToken);
                    String str3 = Logger.defaultTag;
                    Logger.logInfo(str3, billing.getTag() + ": " + ("consumePurchase " + purchaseToken), null);
                    this.L$0 = billing;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(billingResultComponent1);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(purchaseComponent2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(orderId);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(purchaseToken);
                    this.label = 4;
                    if (billing.consume(purchaseComponent2, this) != coroutine_suspended) {
                        purchase = purchaseComponent2;
                        str = purchaseToken;
                        billingResult = billingResultComponent1;
                        Billing.PurchaseType purchaseType22 = this.$purchaseType;
                        this.L$0 = billing;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(billingResult);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(purchase);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(orderId);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                        this.label = 5;
                        objQuerySkuDetails = billing.querySkuDetails(purchaseType22, this);
                    }
                } else if (purchaseComponent2 == null) {
                    Logger.logWarning(Logger.defaultTag, billing.getTag() + ": purchase already owned but purchase is null", null);
                    String str4 = this.$sku;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(billing);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(billingResultComponent1);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(purchaseComponent2);
                    this.label = 2;
                } else {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(billing);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(billingResultComponent1);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(purchaseComponent2);
                    this.label = 3;
                }
                return coroutine_suspended;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Billing.PurchaseType purchaseType, boolean z, String str, Billing.PurchaseType purchaseType2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$purchaseType = purchaseType;
            this.$retry = z;
            this.$sku = str;
            this.$skuType = purchaseType2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptchaCheatingSettingsActivity.this.new AnonymousClass1(this.$purchaseType, this.$retry, this.$sku, this.$skuType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity = CaptchaCheatingSettingsActivity.this;
                C00321 c00321 = new C00321(this.$purchaseType, this.$retry, this.$sku, captchaCheatingSettingsActivity, this.$skuType, null);
                this.label = 1;
                if (BillingKt.billingFlow(captchaCheatingSettingsActivity, c00321, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.alarmclock.settings.CaptchaCheatingSettingsActivity$startWagerRefundFlow$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.alarmclock.settings.CaptchaCheatingSettingsActivity$startWagerRefundFlow$1", f = "CaptchaCheatingSettingsActivity.kt", l = {253}, m = "invokeSuspend", v = 2)
    public static final class C20841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $retry;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20841(boolean z, Continuation<? super C20841> continuation) {
            super(2, continuation);
            this.$retry = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptchaCheatingSettingsActivity.this.new C20841(this.$retry, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C20841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00e1  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            boolean zBooleanValue;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (CaptchaCheatingSettingsActivity.this.getSettings().getCaptchaAvoidedSku() == null || CaptchaCheatingSettingsActivity.this.getSettings().getCaptchaAvoidedOrderId() == null) {
                    zBooleanValue = true;
                } else {
                    String captchaAvoidedToken = CaptchaCheatingSettingsActivity.this.getSettings().getCaptchaAvoidedToken();
                    if (captchaAvoidedToken == null) {
                        CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity = CaptchaCheatingSettingsActivity.this;
                        String strM = Fragment$$ExternalSyntheticOutline1.m("token not found - ", captchaCheatingSettingsActivity.getSettings().getCaptchaAvoidedSku(), ", ", CaptchaCheatingSettingsActivity.this.getSettings().getCaptchaAvoidedOrderId());
                        Logger.logWarning(Logger.defaultTag, captchaCheatingSettingsActivity.getTag() + ": " + strM, null);
                        zBooleanValue = false;
                    } else {
                        CoroutineDispatcher io2 = Dispatchers.getIO();
                        CaptchaCheatingSettingsActivity$startWagerRefundFlow$1$result$1 captchaCheatingSettingsActivity$startWagerRefundFlow$1$result$1 = new CaptchaCheatingSettingsActivity$startWagerRefundFlow$1$result$1(CaptchaCheatingSettingsActivity.this, captchaAvoidedToken, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(captchaAvoidedToken);
                        this.label = 1;
                        obj = BuildersKt.withContext(io2, captchaCheatingSettingsActivity$startWagerRefundFlow$1$result$1, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity2 = CaptchaCheatingSettingsActivity.this;
                String str = Logger.defaultTag;
                Logger.logInfo(str, captchaCheatingSettingsActivity2.getTag() + ": " + ("refund " + zBooleanValue), null);
                if (zBooleanValue) {
                    boolean z = this.$retry;
                    CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity3 = CaptchaCheatingSettingsActivity.this;
                    if (z) {
                        Logger.logInfo(Logger.defaultTag, captchaCheatingSettingsActivity3.getTag() + ": showRefundErrorTryAgain()", null);
                        CaptchaCheatingSettingsActivity.this.showRefundErrorTryAgain();
                    } else {
                        Logger.logInfo(Logger.defaultTag, captchaCheatingSettingsActivity3.getTag() + ": showRefundErrorDispute()", null);
                        CaptchaCheatingSettingsActivity.this.showRefundErrorDispute();
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    CaptchaCheatingSettingsActivity.this.resetPhoneSwitchOff();
                    Toast.makeText(CaptchaCheatingSettingsActivity.this, R.string.goal_subscription_cancelled, 1).show();
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            zBooleanValue = ((Boolean) obj).booleanValue();
            CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity22 = CaptchaCheatingSettingsActivity.this;
            String str2 = Logger.defaultTag;
            Logger.logInfo(str2, captchaCheatingSettingsActivity22.getTag() + ": " + ("refund " + zBooleanValue), null);
            if (zBooleanValue) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$0(CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity, DevicePolicyManager devicePolicyManager, ComponentName componentName, Preference preference, Preference preference2, Object obj) {
        String str = "pref changed " + obj + " " + devicePolicyManager.isAdminActive(componentName);
        Logger.logInfo(Logger.defaultTag, captchaCheatingSettingsActivity.getTag() + ": " + str, null);
        obj.getClass();
        if (((Boolean) obj).booleanValue()) {
            captchaCheatingSettingsActivity.showNoEscapeDialog();
            return true;
        }
        try {
            devicePolicyManager.removeActiveAdmin(componentName);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        preference.getClass();
        ((CheckBoxPreference) preference).setChecked(false);
        SharedApplicationContext.getSettings().setCaptchaNoEscapeUninstall(Boolean.FALSE);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$1(CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity, Preference preference, DevicePolicyManager devicePolicyManager, ComponentName componentName, Preference preference2, Object obj) {
        obj.getClass();
        if (!((Boolean) obj).booleanValue()) {
            return true;
        }
        captchaCheatingSettingsActivity.showNoEscapeDialog();
        preference.getClass();
        ((CheckBoxPreference) preference).setChecked(devicePolicyManager.isAdminActive(componentName));
        captchaCheatingSettingsActivity.settings.setCaptchaNoEscapeUninstall(Boolean.valueOf(devicePolicyManager.isAdminActive(componentName)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$2$0(CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity, Preference preference, Object obj) {
        String str = Logger.defaultTag;
        Logger.logDebug(str, captchaCheatingSettingsActivity.getTag() + ": " + ("value " + obj + " "), null);
        if (!Intrinsics.areEqual(obj, "disable")) {
            startWagerPurchase$default(captchaCheatingSettingsActivity, obj.toString(), null, false, 6, null);
        } else if (captchaCheatingSettingsActivity.settings.getCaptchaAvoidedSku() != null) {
            startWagerRefundFlow$default(captchaCheatingSettingsActivity, false, 1, null);
        } else {
            captchaCheatingSettingsActivity.resetPhoneSwitchOff();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refresh$lambda$3(PreferenceActivity preferenceActivity, Preference preference) {
        ViewIntent.urlCustomTab(preferenceActivity, "https://sleep.urbandroid.org/docs//alarms/captcha.html#alarm-avoiding-protection");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshPhoneSwitchOffPref(String sku, String price) {
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        MaterialDialogListPreference materialDialogListPreference = null;
        if (preferenceScreen != null) {
            Preference preferenceFindPreference = preferenceScreen.findPreference("captcha_no_escape_phone_switchoff");
            materialDialogListPreference = (MaterialDialogListPreference) (preferenceFindPreference instanceof MaterialDialogListPreference ? preferenceFindPreference : null);
        }
        if (materialDialogListPreference == null) {
            return;
        }
        if (Intrinsics.areEqual(sku, "refundable_wakeup_motivation_1") || Intrinsics.areEqual(sku, "refundable_wakeup_motivation_2")) {
            materialDialogListPreference.setValue(sku);
            setPhoneSwitchOffPrefSummary(materialDialogListPreference, Intrinsics.areEqual(sku, "refundable_wakeup_motivation_1") ? R.string.motivation_normal : R.string.motivation_high, price);
            Button button = this.refundButton;
            if (button != null) {
                button.setVisibility(0);
                return;
            }
            return;
        }
        if (sku == null) {
            materialDialogListPreference.setValueIndex(0);
            materialDialogListPreference.setSummary(R.string.alarm_avoid_wakeup_motivation_justification);
            Button button2 = this.refundButton;
            if (button2 != null) {
                button2.setVisibility(8);
            }
        }
    }

    public static /* synthetic */ void refreshPhoneSwitchOffPref$default(CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        captchaCheatingSettingsActivity.refreshPhoneSwitchOffPref(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetPhoneSwitchOff() {
        this.settings.clearCaptchaAvoidedPurchase();
        refreshPhoneSwitchOffPref$default(this, null, null, 2, null);
    }

    private final void setPhoneSwitchOffPrefSummary(Preference pref, int entry, String price) {
        pref.setSummary(getString(entry) + " " + ((price == null || price.length() <= 0) ? "" : FileInsert$$ExternalSyntheticOutline0.m("(", price, ")")));
    }

    private final void showNoEscapeDialog() {
        try {
            NoEscapeManager noEscapeManager = new NoEscapeManager(this);
            new Settings(this);
            Logger.logInfo("CAPTCHA: showNoEscapeDialog " + noEscapeManager.isNoEscapeFullyConfigured());
            if (noEscapeManager.isNoEscapeFullyConfigured()) {
                return;
            }
            new MaterialAlertDialogBuilder(this).setTitle(R.string.no_escape_we_can_do_more).setMessage(R.string.alarm_avoid_tip).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(this, 4)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNoEscapeDialog$lambda$0(CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(captchaCheatingSettingsActivity, (Class<?>) NoEscapeActivity.class);
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        captchaCheatingSettingsActivity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRefundErrorDispute() {
        Snackbar.make(findViewById(R.id.root), R.string.goal_subscription_cancel_failed, -2).setAction(R.string.dispute, new CaptchaCheatingSettingsActivity$$ExternalSyntheticLambda5(this, 1)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRefundErrorDispute$lambda$0(CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity, View view) {
        INSTANCE.startDispute(captchaCheatingSettingsActivity);
        captchaCheatingSettingsActivity.resetPhoneSwitchOff();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRefundErrorTryAgain() {
        Snackbar.make(findViewById(R.id.root), R.string.goal_subscription_cancel_failed, 0).setAction(R.string.try_again, new CaptchaCheatingSettingsActivity$$ExternalSyntheticLambda5(this, 0)).show();
    }

    public static final void start(Context context) {
        INSTANCE.start(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startWagerPurchase(String sku, Billing.PurchaseType skuType, boolean retry) {
        Billing.PurchaseType purchaseType;
        if (skuType == null) {
            Billing.PurchaseType purchaseTypeFindOrNull = Billing.PurchaseType.INSTANCE.findOrNull(sku);
            if (purchaseTypeFindOrNull == null) {
                String strM = FileInsert$$ExternalSyntheticOutline0.m("startPurchase failure purchase type: ", sku, " not found");
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
                return;
            }
            purchaseType = purchaseTypeFindOrNull;
        } else {
            purchaseType = skuType;
        }
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(purchaseType, retry, sku, skuType, null), 3, null);
    }

    public static /* synthetic */ void startWagerPurchase$default(CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity, String str, Billing.PurchaseType purchaseType, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            purchaseType = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        captchaCheatingSettingsActivity.startWagerPurchase(str, purchaseType, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startWagerRefundFlow(boolean retry) {
        Toast.makeText(this, R.string.please_wait, 1).show();
        String strM = Fragment$$ExternalSyntheticOutline1.m(this.settings.getCaptchaAvoidedSku(), ", ", this.settings.getCaptchaAvoidedOrderId(), ", ", this.settings.getCaptchaAvoidedToken());
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + strM, null);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C20841(retry, null), 3, null);
    }

    public static /* synthetic */ void startWagerRefundFlow$default(CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        captchaCheatingSettingsActivity.startWagerRefundFlow(z);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public String getDocumentationUrl() {
        return "https://sleep.urbandroid.org/docs//alarms/captcha.html#alarm-avoiding-protection";
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getSettings() {
        return R.xml.settings_captcha_cheating;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public int getTitleResource() {
        return R.string.captcha_no_escape;
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.settings.isCaptchaAvoided() && this.settings.getCaptchaAvoidedOrderId() != null) {
            new CaptchaAvoidedDialogFragment().show(getSupportFragmentManager(), "avoided");
        }
        if (this.settings.isCaptchaNoEscape()) {
            showNoEscapeDialog();
        }
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity
    public void onCreatePreference(Bundle paramBundle) {
        MaterialDialogListPreference materialDialogListPreference;
        super.onCreatePreference(paramBundle);
        if (!getIntent().hasExtra("start_purchase") || (materialDialogListPreference = (MaterialDialogListPreference) findPreference("captcha_no_escape_phone_switchoff")) == null) {
            return;
        }
        materialDialogListPreference.show();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        super.onDestroy();
    }

    @Override // com.urbandroid.sleep.gui.dialog.OnDismissedListener
    public void onDismiss(Class<DialogFragment> type, int result) {
        type.getClass();
        Logger.logDebug(Logger.defaultTag, getTag() + ": onDismiss() ", null);
        this.settings.setCaptchaAvoided(false);
        resetPhoneSwitchOff();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity, com.urbandroid.sleep.gui.PreferenceActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity
    public void refresh(PreferenceActivity preferenceActivity, boolean searchMode) {
        CaptchaCheatingSettingsActivity captchaCheatingSettingsActivity;
        preferenceActivity.getClass();
        PreferenceScreen preferenceScreen = preferenceActivity.getPreferenceScreen();
        Object systemService = preferenceActivity.getSystemService("device_policy");
        systemService.getClass();
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) systemService;
        ComponentName componentName = new ComponentName(preferenceActivity, (Class<?>) SleepDeviceAdminReceiver.class);
        Preference preferenceFindPreference = preferenceScreen != null ? preferenceScreen.findPreference("captcha_no_escape_uninstall") : null;
        if (preferenceFindPreference != null) {
            String str = "pref " + this.settings.isInitializedCaptchaNoEscapeUninstall() + " " + devicePolicyManager.isAdminActive(componentName);
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preferenceFindPreference;
            checkBoxPreference.setChecked(devicePolicyManager.isAdminActive(componentName));
            this.settings.setCaptchaNoEscapeUninstall(Boolean.valueOf(devicePolicyManager.isAdminActive(componentName)));
            captchaCheatingSettingsActivity = this;
            checkBoxPreference.setOnPreferenceChangeListener(new AutomationSettingsActivity$$ExternalSyntheticLambda7(captchaCheatingSettingsActivity, devicePolicyManager, componentName, preferenceFindPreference, 1));
        } else {
            captchaCheatingSettingsActivity = this;
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) preferenceActivity.findPreference("captcha_no_escape");
        if (checkBoxPreference2 != null) {
            Preference preference = preferenceFindPreference;
            AutomationSettingsActivity$$ExternalSyntheticLambda7 automationSettingsActivity$$ExternalSyntheticLambda7 = new AutomationSettingsActivity$$ExternalSyntheticLambda7(captchaCheatingSettingsActivity, preference, devicePolicyManager, componentName, 2);
            preferenceFindPreference = preference;
            devicePolicyManager = devicePolicyManager;
            componentName = componentName;
            checkBoxPreference2.setOnPreferenceChangeListener(automationSettingsActivity$$ExternalSyntheticLambda7);
        }
        if (!devicePolicyManager.isAdminActive(componentName) && preferenceFindPreference != null) {
            ((CheckBoxPreference) preferenceFindPreference).setChecked(false);
            captchaCheatingSettingsActivity.settings.setCaptchaNoEscapeUninstall(Boolean.FALSE);
        }
        Preference preferenceFindPreference2 = preferenceScreen != null ? preferenceScreen.findPreference("captcha_no_escape_phone_switchoff") : null;
        ListPreferenceWithButton listPreferenceWithButton = preferenceFindPreference2 instanceof ListPreferenceWithButton ? (ListPreferenceWithButton) preferenceFindPreference2 : null;
        if (listPreferenceWithButton != null) {
            captchaCheatingSettingsActivity.refreshPhoneSwitchOffPref(captchaCheatingSettingsActivity.settings.getCaptchaAvoidedSku(), captchaCheatingSettingsActivity.settings.getCaptchaAvoidedPrice());
            listPreferenceWithButton.setBindListener(new CaptchaCheatingSettingsActivity$refresh$3$1(captchaCheatingSettingsActivity, listPreferenceWithButton));
            listPreferenceWithButton.setOnPreferenceChangeListener(new BedtimeSettingsActivity$$ExternalSyntheticLambda1(captchaCheatingSettingsActivity, 2));
        }
        Preference preferenceFindPreference3 = preferenceScreen != null ? preferenceScreen.findPreference("alarm_avoid_tip") : null;
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new MiscSettingsActivity$$ExternalSyntheticLambda1(preferenceActivity, 10));
        }
    }

    public final Settings getSettings() {
        return this.settings;
    }
}
