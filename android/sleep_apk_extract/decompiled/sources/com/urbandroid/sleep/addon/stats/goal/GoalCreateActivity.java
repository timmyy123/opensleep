package com.urbandroid.sleep.addon.stats.goal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsResult;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.tabs.TabLayout;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.sleep.gui.GraphListClickHandler$$ExternalSyntheticLambda2;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.trial.Billing;
import com.urbandroid.sleep.trial.BillingKt;
import com.urbandroid.sleep.trial.PurchaseResult;
import com.urbandroid.util.EdgeToEdgeUtil;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 :2\u00020\u00012\u00020\u00022\u00020\u0003:\u00029:B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0002J\u0012\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010#\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020\u0015H\u0014J\u0006\u0010-\u001a\u00020\u0015J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u0015H\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u000206X\u0096\u0005¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/goal/GoalCreateActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "rotate", "Landroid/view/animation/Animation;", "fab", "Lcom/google/android/material/button/MaterialButton;", "goal", "Lcom/urbandroid/sleep/domain/goal/Goal;", "extractor", "Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;", "initialGoalType", "Lcom/urbandroid/sleep/domain/goal/Goal$Type;", "onSaveInstanceState", "", "outState", "Landroid/os/Bundle;", "purchase", "", "sku", "onCreateDialog", "Landroid/app/Dialog;", "id", "", "showDurationIdealDialog", "updateTarget", "onCreate", "savedInstanceState", "createNewGoal", "addPercentageToGoal", "addition", "", "update", "createGoal", "type", "listener", "Lcom/urbandroid/sleep/addon/stats/goal/GoalCreateActivity$GoalListener;", "onStart", "rotateAnimation", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onDestroy", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "GoalListener", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoalCreateActivity extends BaseActivity implements FeatureLogger, CoroutineScope {
    private IValueExtractor extractor;
    private MaterialButton fab;
    private Goal goal;
    private Goal.Type initialGoalType;
    private Animation rotate;
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.MainScope();
    private final String tag = "Goal";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/goal/GoalCreateActivity$GoalListener;", "", "onCreated", "", "goal", "Lcom/urbandroid/sleep/domain/goal/Goal;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface GoalListener {
        void onCreated(Goal goal);
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$createGoal$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$createGoal$1", f = "GoalCreateActivity.kt", l = {392}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GoalListener $listener;
        final /* synthetic */ Goal.Type $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Goal.Type type, GoalListener goalListener, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$type = type;
            this.$listener = goalListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoalCreateActivity.this.new AnonymousClass1(this.$type, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objWithContext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            Animation animation = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                View viewFindViewById = GoalCreateActivity.this.findViewById(R.id.goal_progress);
                GoalCreateActivity goalCreateActivity = GoalCreateActivity.this;
                ProgressBar progressBar = (ProgressBar) viewFindViewById;
                progressBar.setProgress(50);
                Animation animation2 = goalCreateActivity.rotate;
                if (animation2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rotate");
                    animation2 = null;
                }
                progressBar.startAnimation(animation2);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                GoalCreateActivity$createGoal$1$base$1 goalCreateActivity$createGoal$1$base$1 = new GoalCreateActivity$createGoal$1$base$1(GoalCreateActivity.this, this.$type, null);
                this.label = 1;
                objWithContext = BuildersKt.withContext(io2, goalCreateActivity$createGoal$1$base$1, this);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                objWithContext = obj;
            }
            Goal goal = new Goal(((Number) objWithContext).doubleValue(), this.$type, 0L, 0L, 12, null);
            GoalCreateActivity.this.goal = goal;
            this.$listener.onCreated(goal);
            Animation animation3 = GoalCreateActivity.this.rotate;
            if (animation3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rotate");
            } else {
                animation = animation3;
            }
            animation.cancel();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$purchase$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$purchase$1", f = "GoalCreateActivity.kt", l = {76}, m = "invokeSuspend", v = 2)
    public static final class C20821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $sku;
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$purchase$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/sleep/trial/Billing;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$purchase$1$1", f = "GoalCreateActivity.kt", l = {77, 98, 102}, m = "invokeSuspend", v = 2)
        public static final class C00251 extends SuspendLambda implements Function2<Billing, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $sku;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;
            final /* synthetic */ GoalCreateActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00251(String str, GoalCreateActivity goalCreateActivity, Continuation<? super C00251> continuation) {
                super(2, continuation);
                this.$sku = str;
                this.this$0 = goalCreateActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00251 c00251 = new C00251(this.$sku, this.this$0, continuation);
                c00251.L$0 = obj;
                return c00251;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Billing billing, Continuation<? super Unit> continuation) {
                return ((C00251) create(billing, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:33:0x0158, code lost:
            
                if (r0 != r2) goto L35;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object objPurchase;
                BillingResult billingResultComponent1;
                String str;
                Purchase purchase;
                String str2;
                Settings settings;
                Object objQuerySkuDetails;
                SkuDetails skuDetails;
                Billing billing = (Billing) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                price = null;
                String price = null;
                try {
                } catch (Exception e) {
                    Logger.logSevere(e);
                }
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    String str3 = this.$sku;
                    this.L$0 = billing;
                    this.label = 1;
                    objPurchase = billing.purchase(str3, "inapp", this);
                    if (objPurchase != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    objPurchase = obj;
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        Settings settings2 = (Settings) this.L$5;
                        ResultKt.throwOnFailure(obj);
                        settings = settings2;
                        objQuerySkuDetails = obj;
                        List<SkuDetails> skuDetailsList = ((SkuDetailsResult) objQuerySkuDetails).getSkuDetailsList();
                        if (skuDetailsList != null && (skuDetails = (SkuDetails) CollectionsKt.getOrNull(skuDetailsList, 0)) != null) {
                            price = skuDetails.getPrice();
                        }
                        settings.setCurrentGoalPrice(price);
                        GoalCreateActivity goalCreateActivity = this.this$0;
                        goalCreateActivity.createNewGoal(goalCreateActivity.goal);
                        return Unit.INSTANCE;
                    }
                    str2 = (String) this.L$4;
                    str = (String) this.L$3;
                    purchase = (Purchase) this.L$2;
                    billingResultComponent1 = (BillingResult) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    ContextExtKt.getSettings(this.this$0).setCurrentGoalPrice(null);
                    settings = ContextExtKt.getSettings(this.this$0);
                    String str4 = this.$sku;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(billing);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(billingResultComponent1);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(purchase);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(str);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(str2);
                    this.L$5 = settings;
                    this.label = 3;
                    objQuerySkuDetails = billing.querySkuDetails(str4, "inapp", this);
                }
                PurchaseResult purchaseResult = (PurchaseResult) objPurchase;
                billingResultComponent1 = purchaseResult.getBillingResult();
                Purchase purchaseComponent2 = purchaseResult.getPurchase();
                String str5 = "purchase result: " + BillingKt.pretty(billingResultComponent1) + " " + purchaseComponent2;
                Logger.logInfo(Logger.defaultTag, billing.getTag() + ": " + str5, null);
                if (purchaseComponent2 == null || billingResultComponent1.getResponseCode() != 0) {
                    Goal goal = this.this$0.goal;
                    Goal.Type type = goal != null ? goal.type : null;
                    Goal.Type type2 = Goal.Type.DURATION;
                    GoalCreateActivity goalCreateActivity2 = this.this$0;
                    if (type == type2) {
                        goalCreateActivity2.showDurationIdealDialog();
                    } else {
                        goalCreateActivity2.createNewGoal(goalCreateActivity2.goal);
                    }
                    Toast.makeText(this.this$0, R.string.general_unspecified_error, 1).show();
                    return Unit.INSTANCE;
                }
                String orderId = purchaseComponent2.getOrderId();
                String purchaseToken = purchaseComponent2.getPurchaseToken();
                purchaseToken.getClass();
                String strM = Fragment$$ExternalSyntheticOutline1.m("purchased ", this.$sku, " orderId ", orderId);
                Logger.logInfo(Logger.defaultTag, billing.getTag() + ": " + strM, null);
                Goal goal2 = this.this$0.goal;
                if (goal2 != null) {
                    goal2.setSubscriptionId(this.$sku);
                    goal2.setSubscriptionToken(purchaseToken);
                    goal2.setOrderId(orderId);
                }
                this.L$0 = billing;
                this.L$1 = SpillingKt.nullOutSpilledVariable(billingResultComponent1);
                this.L$2 = SpillingKt.nullOutSpilledVariable(purchaseComponent2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(orderId);
                this.L$4 = SpillingKt.nullOutSpilledVariable(purchaseToken);
                this.label = 2;
                if (billing.consume(purchaseComponent2, this) != coroutine_suspended) {
                    str = orderId;
                    purchase = purchaseComponent2;
                    str2 = purchaseToken;
                    ContextExtKt.getSettings(this.this$0).setCurrentGoalPrice(null);
                    settings = ContextExtKt.getSettings(this.this$0);
                    String str42 = this.$sku;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(billing);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(billingResultComponent1);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(purchase);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(str);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(str2);
                    this.L$5 = settings;
                    this.label = 3;
                    objQuerySkuDetails = billing.querySkuDetails(str42, "inapp", this);
                }
                return coroutine_suspended;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20821(String str, Continuation<? super C20821> continuation) {
            super(2, continuation);
            this.$sku = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoalCreateActivity.this.new C20821(this.$sku, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C20821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                GoalCreateActivity goalCreateActivity = GoalCreateActivity.this;
                C00251 c00251 = new C00251(this.$sku, goalCreateActivity, null);
                this.label = 1;
                if (BillingKt.billingFlow(goalCreateActivity, c00251, this) == coroutine_suspended) {
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

    private final void addPercentageToGoal(Goal goal, double addition) {
        double percentage = goal.getPercentage();
        double percentage2 = goal.getPercentage() + addition;
        double step = goal.type.getStep();
        double d = step * 100.0d;
        double dRound = (Math.round(d) * (Math.round(percentage2 * 100.0d) / Math.round(d))) / 100.0d;
        if (Math.round(100.0d * dRound) == 0) {
            if (goal.type.getMode() == 0) {
                step = -step;
                String str = Logger.defaultTag;
                Logger.logInfo(str, getTag() + ": " + ("adjust " + step), null);
                dRound = step;
            } else {
                step = -step;
                String str2 = Logger.defaultTag;
                Logger.logInfo(str2, getTag() + ": " + ("adjust " + step), null);
                dRound = step;
            }
        }
        double d2 = goal.target;
        goal.calculateTarget(dRound);
        goal.validateAndFix(d2);
        if (goal.target > goal.type.getMax()) {
            goal.calculateTarget(percentage);
            goal.validateAndFix(d2);
            String str3 = "Over max " + dRound + "% + " + addition + " target " + goal.target + " orig " + percentage;
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str3, null);
        }
        String str4 = dRound + "% + " + addition + " target " + goal.target;
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + str4, null);
        update(goal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createNewGoal(Goal goal) {
        rotateAnimation();
        if (goal != null) {
            goal.updateStatus();
        }
        new Settings(getApplicationContext()).setCurrentGoal(goal);
        String str = Logger.defaultTag;
        Logger.logInfo(str, getTag() + ": " + ("adding " + goal), null);
        GoalDetailActivity.Companion companion = GoalDetailActivity.INSTANCE;
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        GoalDetailActivity.Companion.start$default(companion, applicationContext, null, 2, null);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(GoalCreateActivity goalCreateActivity, TabLayout.Tab tab, View view) {
        new MaterialAlertDialogBuilder(goalCreateActivity).setTitle(R.string.motivation).setMessage(R.string.goal_subscription_justification).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new GoalDetailActivity$$ExternalSyntheticLambda0(1)).setNegativeButton(R.string.botton_free, (DialogInterface.OnClickListener) new GraphListClickHandler$$ExternalSyntheticLambda2(goalCreateActivity, tab, 1)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1$0(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1$1(GoalCreateActivity goalCreateActivity, TabLayout.Tab tab, DialogInterface dialogInterface, int i) {
        ((TabLayout) goalCreateActivity.findViewById(R.id.motivationGroup)).selectTab(tab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(GoalCreateActivity goalCreateActivity, View view) {
        Goal goal = goalCreateActivity.goal;
        if (goal != null) {
            goalCreateActivity.addPercentageToGoal(goal, goal.type.getStep());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(GoalCreateActivity goalCreateActivity, View view) {
        Goal goal = goalCreateActivity.goal;
        if (goal != null) {
            goalCreateActivity.addPercentageToGoal(goal, -goal.type.getStep());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$5(EditText editText, View view, MotionEvent motionEvent) {
        editText.clearFocus();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6(GoalCreateActivity goalCreateActivity, View view, boolean z) {
        String str = Logger.defaultTag;
        Logger.logInfo(str, goalCreateActivity.getTag() + ": " + ("focus " + z), null);
        if (z) {
            return;
        }
        goalCreateActivity.updateTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$7(GoalCreateActivity goalCreateActivity, View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 66) {
            return false;
        }
        String str = "key " + i + " " + keyEvent;
        Logger.logInfo(Logger.defaultTag, goalCreateActivity.getTag() + ": " + str, null);
        goalCreateActivity.updateTarget();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$8(GoalCreateActivity goalCreateActivity, View view) {
        goalCreateActivity.findViewById(R.id.goal_target).clearFocus();
        if (((TabLayout) goalCreateActivity.findViewById(R.id.motivationGroup)).getSelectedTabPosition() > 0) {
            goalCreateActivity.showDialog(42);
        } else {
            goalCreateActivity.createNewGoal(goalCreateActivity.goal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$9(GoalCreateActivity goalCreateActivity, View view) {
        new MaterialAlertDialogBuilder(goalCreateActivity).setTitle(R.string.stats_caption_sleep).setMessage(R.string.goal_time_to_finish).setPositiveButton((CharSequence) FileInsert$$ExternalSyntheticOutline0.m("1 ", goalCreateActivity.getResources().getString(R.string.week)), (DialogInterface.OnClickListener) new GoalCreateActivity$$ExternalSyntheticLambda10(goalCreateActivity, 2)).setNegativeButton((CharSequence) FileInsert$$ExternalSyntheticOutline0.m("1 ", goalCreateActivity.getResources().getString(R.string.month)), (DialogInterface.OnClickListener) new GoalCreateActivity$$ExternalSyntheticLambda10(goalCreateActivity, 3)).setNeutralButton(R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$9$0(GoalCreateActivity goalCreateActivity, DialogInterface dialogInterface, int i) {
        Goal goal = goalCreateActivity.goal;
        if (goal != null) {
            goal.setDurationWeek();
        }
        ((TextView) goalCreateActivity.findViewById(R.id.goal_time)).setText("1 " + goalCreateActivity.getResources().getString(R.string.week));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$9$1(GoalCreateActivity goalCreateActivity, DialogInterface dialogInterface, int i) {
        Goal goal = goalCreateActivity.goal;
        if (goal != null) {
            goal.setDurationMonth();
        }
        ((TextView) goalCreateActivity.findViewById(R.id.goal_time)).setText("1 " + goalCreateActivity.getResources().getString(R.string.month));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(GoalCreateActivity goalCreateActivity, DialogInterface dialogInterface, int i) {
        goalCreateActivity.purchase(((TabLayout) goalCreateActivity.findViewById(R.id.motivationGroup)).getSelectedTabPosition() == 2 ? "goal_motivation_fee_2" : "goal_motivation_fee_1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(GoalCreateActivity goalCreateActivity, DialogInterface dialogInterface, int i) {
        Goal goal = goalCreateActivity.goal;
        if ((goal != null ? goal.type : null) == Goal.Type.DURATION) {
            goalCreateActivity.showDurationIdealDialog();
        } else {
            goalCreateActivity.createNewGoal(goal);
        }
    }

    private final boolean purchase(String sku) {
        String strM = FileInsert$$ExternalSyntheticOutline0.m("purchase ", sku);
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C20821(sku, null), 3, null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rotateAnimation$lambda$0(GoalCreateActivity goalCreateActivity) {
        ProgressBar progressBar = (ProgressBar) goalCreateActivity.findViewById(R.id.goal_progress);
        Animation animation = goalCreateActivity.rotate;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotate");
            animation = null;
        }
        progressBar.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rotateAnimation$lambda$1(GoalCreateActivity goalCreateActivity) {
        Animation animation = goalCreateActivity.rotate;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rotate");
            animation = null;
        }
        animation.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDurationIdealDialog() {
        try {
            Goal goal = this.goal;
            if (goal == null) {
                return;
            }
            new MaterialAlertDialogBuilder(this).setTitle(R.string.target_sleep_time_notify_title).setMessage(R.string.goal_duration_ideal).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new GoalCreateActivity$$ExternalSyntheticLambda14(goal, this)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new GoalCreateActivity$$ExternalSyntheticLambda14(this, goal)).show();
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDurationIdealDialog$lambda$0(Goal goal, GoalCreateActivity goalCreateActivity, DialogInterface dialogInterface, int i) {
        SharedApplicationContext.getSettings().setIdealSleepMinutes(((int) Math.round(goal.target * 6.0d)) * 10);
        SharedApplicationContext.getSettings().forceTimeToBedBeforeIfDisabled();
        goalCreateActivity.createNewGoal(goal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void update(Goal goal) {
        String strM;
        this.goal = goal;
        goal.validateAndFix(goal.target);
        int iRound = (int) Math.round(goal.getPercentage() * 100.0d);
        IValueExtractor iValueExtractor = this.extractor;
        IValueExtractor iValueExtractor2 = null;
        if (iValueExtractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extractor");
            iValueExtractor = null;
        }
        String unit = iValueExtractor.getUnit();
        if (iRound > 0) {
            strM = Fragment$$ExternalSyntheticOutline1.m(iRound, MqttTopic.SINGLE_LEVEL_WILDCARD, "%");
        } else {
            strM = iRound + "%";
        }
        IValueExtractor iValueExtractor3 = this.extractor;
        if (iValueExtractor3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extractor");
            iValueExtractor3 = null;
        }
        ((TextView) findViewById(R.id.goal_percent)).setText(Html.fromHtml(FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m6m("<small><small>", iValueExtractor3.getValuePresentation(goal.base), " <small><small>", unit, "</small></small></small></small><br/><b>"), strM, "</b><small><small> = </small></small>")));
        TextView textView = (TextView) findViewById(R.id.goal_target);
        IValueExtractor iValueExtractor4 = this.extractor;
        if (iValueExtractor4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extractor");
        } else {
            iValueExtractor2 = iValueExtractor4;
        }
        textView.setText(iValueExtractor2.getValuePresentation(goal.target));
        ((TextView) findViewById(R.id.goal_unit)).setText(unit);
        ((ProgressBar) findViewById(R.id.goal_progress)).setProgress((int) Math.abs(goal.getPercentage() * 200.0d));
        if (goal.getGoalDays() < 25) {
            ((TextView) findViewById(R.id.goal_time)).setText("1 " + getResources().getString(R.string.week));
            return;
        }
        ((TextView) findViewById(R.id.goal_time)).setText("1 " + getResources().getString(R.string.month));
    }

    private final void updateTarget() {
        Goal goal = this.goal;
        if (goal == null) {
            return;
        }
        String string = ((TextView) findViewById(R.id.goal_target)).getText().toString();
        try {
            IValueExtractor iValueExtractor = this.extractor;
            if (iValueExtractor == null) {
                Intrinsics.throwUninitializedPropertyAccessException("extractor");
                iValueExtractor = null;
            }
            double valueFromPresentation = iValueExtractor.parseValueFromPresentation(string);
            double d = goal.target;
            if (valueFromPresentation == d) {
                return;
            }
            goal.target = valueFromPresentation;
            goal.validateAndFix(d);
            update(goal);
        } catch (NumberFormatException e) {
            update(goal);
            Logger.logSevere(Logger.defaultTag, getTag(), e);
        }
    }

    public final void createGoal(Goal.Type type, GoalListener listener) {
        type.getClass();
        listener.getClass();
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(type, listener, null), 3, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_goal_create);
        ToolbarUtil.apply(this);
        TintUtil.tint(this);
        ActionBar supportActionBar = getSupportActionBar();
        final int i = 1;
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
        }
        final int i2 = 0;
        EdgeToEdgeUtil.Companion.insetsBottom$default(EdgeToEdgeUtil.INSTANCE, findViewById(R.id.buttons), 0, false, 6, null);
        TabLayout.Tab tabAt = ((TabLayout) findViewById(R.id.motivationGroup)).getTabAt(1);
        TabLayout.Tab tabAt2 = ((TabLayout) findViewById(R.id.motivationGroup)).getTabAt(0);
        ((TabLayout) findViewById(R.id.motivationGroup)).selectTab(tabAt);
        ImageButton imageButton = (ImageButton) findViewById(R.id.help);
        if (imageButton != null) {
            imageButton.setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(this, tabAt2, 7));
        }
        MaterialButton materialButton = null;
        if (getIntent() != null && getIntent().hasExtra("extra_goal_type")) {
            try {
                String stringExtra = getIntent().getStringExtra("extra_goal_type");
                if (stringExtra == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                Goal.Type typeValueOf = Goal.Type.valueOf(stringExtra);
                this.initialGoalType = typeValueOf;
                if (typeValueOf != null) {
                    TextView textView = (TextView) findViewById(R.id.goalFunnyName);
                    Goal.Companion companion = Goal.INSTANCE;
                    textView.setText(companion.getGoalFunnyName(typeValueOf));
                    ((ImageView) findViewById(R.id.goalFunnyImage)).setImageResource(companion.getGoalIcon(typeValueOf));
                    findViewById(R.id.goal_target).clearFocus();
                    this.extractor = companion.createExtractor(this, typeValueOf);
                    ActionBar supportActionBar2 = getSupportActionBar();
                    if (supportActionBar2 != null) {
                        IValueExtractor iValueExtractor = this.extractor;
                        if (iValueExtractor == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("extractor");
                            iValueExtractor = null;
                        }
                        supportActionBar2.setTitle(companion.getGoalTitle(this, iValueExtractor));
                    }
                    createGoal(typeValueOf, new GoalListener() { // from class: com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$onCreate$3$1
                        @Override // com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity.GoalListener
                        public void onCreated(Goal goal) {
                            if (goal != null) {
                                this.this$0.update(goal);
                            }
                        }
                    });
                }
            } catch (IllegalArgumentException e) {
                Logger.logSevere(Logger.defaultTag, getTag(), e);
            }
        }
        this.h = new Handler();
        View viewFindViewById = findViewById(R.id.fab);
        viewFindViewById.getClass();
        this.fab = (MaterialButton) viewFindViewById;
        if (savedInstanceState != null) {
            String string = savedInstanceState.getString("Goal");
            String strM = FileInsert$$ExternalSyntheticOutline0.m("saved ", string);
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
            Goal.Companion companion2 = Goal.INSTANCE;
            Goal goalFromSerialized = companion2.fromSerialized(string);
            if (goalFromSerialized == null) {
                finish();
                return;
            } else {
                this.goal = goalFromSerialized;
                this.extractor = companion2.createExtractor(this, goalFromSerialized.type);
                update(goalFromSerialized);
            }
        }
        if (this.rotate == null) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forever);
            animationLoadAnimation.getClass();
            this.rotate = animationLoadAnimation;
        }
        findViewById(R.id.goal_plus).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$$ExternalSyntheticLambda3
            public final /* synthetic */ GoalCreateActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i2;
                GoalCreateActivity goalCreateActivity = this.f$0;
                switch (i3) {
                    case 0:
                        GoalCreateActivity.onCreate$lambda$3(goalCreateActivity, view);
                        break;
                    case 1:
                        GoalCreateActivity.onCreate$lambda$4(goalCreateActivity, view);
                        break;
                    case 2:
                        GoalCreateActivity.onCreate$lambda$8(goalCreateActivity, view);
                        break;
                    default:
                        GoalCreateActivity.onCreate$lambda$9(goalCreateActivity, view);
                        break;
                }
            }
        });
        findViewById(R.id.goal_minus).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$$ExternalSyntheticLambda3
            public final /* synthetic */ GoalCreateActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i;
                GoalCreateActivity goalCreateActivity = this.f$0;
                switch (i3) {
                    case 0:
                        GoalCreateActivity.onCreate$lambda$3(goalCreateActivity, view);
                        break;
                    case 1:
                        GoalCreateActivity.onCreate$lambda$4(goalCreateActivity, view);
                        break;
                    case 2:
                        GoalCreateActivity.onCreate$lambda$8(goalCreateActivity, view);
                        break;
                    default:
                        GoalCreateActivity.onCreate$lambda$9(goalCreateActivity, view);
                        break;
                }
            }
        });
        final EditText editText = (EditText) findViewById(R.id.goal_target);
        findViewById(R.id.content).setOnTouchListener(new View.OnTouchListener() { // from class: com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return GoalCreateActivity.onCreate$lambda$5(editText, view, motionEvent);
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                GoalCreateActivity.onCreate$lambda$6(this.f$0, view, z);
            }
        });
        editText.setOnKeyListener(new View.OnKeyListener() { // from class: com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                return GoalCreateActivity.onCreate$lambda$7(this.f$0, view, i3, keyEvent);
            }
        });
        MaterialButton materialButton2 = this.fab;
        if (materialButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fab");
        } else {
            materialButton = materialButton2;
        }
        final int i3 = 2;
        materialButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$$ExternalSyntheticLambda3
            public final /* synthetic */ GoalCreateActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32 = i3;
                GoalCreateActivity goalCreateActivity = this.f$0;
                switch (i32) {
                    case 0:
                        GoalCreateActivity.onCreate$lambda$3(goalCreateActivity, view);
                        break;
                    case 1:
                        GoalCreateActivity.onCreate$lambda$4(goalCreateActivity, view);
                        break;
                    case 2:
                        GoalCreateActivity.onCreate$lambda$8(goalCreateActivity, view);
                        break;
                    default:
                        GoalCreateActivity.onCreate$lambda$9(goalCreateActivity, view);
                        break;
                }
            }
        });
        final int i4 = 3;
        ((TextView) findViewById(R.id.goal_time)).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$$ExternalSyntheticLambda3
            public final /* synthetic */ GoalCreateActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32 = i4;
                GoalCreateActivity goalCreateActivity = this.f$0;
                switch (i32) {
                    case 0:
                        GoalCreateActivity.onCreate$lambda$3(goalCreateActivity, view);
                        break;
                    case 1:
                        GoalCreateActivity.onCreate$lambda$4(goalCreateActivity, view);
                        break;
                    case 2:
                        GoalCreateActivity.onCreate$lambda$8(goalCreateActivity, view);
                        break;
                    default:
                        GoalCreateActivity.onCreate$lambda$9(goalCreateActivity, view);
                        break;
                }
            }
        });
        Goal goal = this.goal;
        if (goal == null || Integer.valueOf(goal.getGoalDays()).intValue() >= 30) {
            ((TextView) findViewById(R.id.goal_time)).setText("1 " + getResources().getString(R.string.month));
            return;
        }
        ((TextView) findViewById(R.id.goal_time)).setText("1 " + getResources().getString(R.string.week));
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int id) {
        if (id == 42) {
            AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(this).setTitle(R.string.motivation).setMessage(R.string.goal_subscription_justification).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new GoalCreateActivity$$ExternalSyntheticLambda10(this, 0)).setNegativeButton(R.string.botton_free, (DialogInterface.OnClickListener) new GoalCreateActivity$$ExternalSyntheticLambda10(this, 1)).create();
            alertDialogCreate.getClass();
            return alertDialogCreate;
        }
        Dialog dialogOnCreateDialog = super.onCreateDialog(id);
        dialogOnCreateDialog.getClass();
        return dialogOnCreateDialog;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.getClass();
        getMenuInflater().inflate(R.menu.doc_menu, menu);
        MenuUtil.INSTANCE.showIcons(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        item.getClass();
        int itemId = item.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.menu_doc) {
            return true;
        }
        ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//sleep/goals.html");
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        outState.getClass();
        super.onSaveInstanceState(outState);
        Goal goal = this.goal;
        if (goal != null) {
            outState.putString("Goal", String.valueOf(goal));
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        rotateAnimation();
    }

    public final void rotateAnimation() {
        final int i = 0;
        this.h.postDelayed(new Runnable(this) { // from class: com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ GoalCreateActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i2 = i;
                GoalCreateActivity goalCreateActivity = this.f$0;
                switch (i2) {
                    case 0:
                        GoalCreateActivity.rotateAnimation$lambda$0(goalCreateActivity);
                        break;
                    default:
                        GoalCreateActivity.rotateAnimation$lambda$1(goalCreateActivity);
                        break;
                }
            }
        }, 100L);
        final int i2 = 1;
        this.h.postDelayed(new Runnable(this) { // from class: com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ GoalCreateActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i22 = i2;
                GoalCreateActivity goalCreateActivity = this.f$0;
                switch (i22) {
                    case 0:
                        GoalCreateActivity.rotateAnimation$lambda$0(goalCreateActivity);
                        break;
                    default:
                        GoalCreateActivity.rotateAnimation$lambda$1(goalCreateActivity);
                        break;
                }
            }
        }, 1000L);
    }
}
