package com.urbandroid.sleep.trial;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsResult;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.PreferencesUtils;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.AlarmClock$$ExternalSyntheticLambda2;
import com.urbandroid.sleep.alarmclock.UnlockFlow;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.share.analytics.FacebookAnalytics;
import com.urbandroid.sleep.trial.Billing;
import com.urbandroid.sleep.trial.IBillingStatusListener;
import java.util.LinkedHashSet;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.mp4parser.boxes.iso14496.part12.SubSampleInformationBox;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001)B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0017\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00132\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u0017\u0010 \u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/urbandroid/sleep/trial/JavaBilling;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/app/Activity;", "activity", "Lcom/urbandroid/sleep/trial/IBillingStatusListener;", "billingListener", "Lcom/urbandroid/sleep/trial/IBillingServiceStatusListener;", "serviceStatusListener", "<init>", "(Landroid/app/Activity;Lcom/urbandroid/sleep/trial/IBillingStatusListener;Lcom/urbandroid/sleep/trial/IBillingServiceStatusListener;)V", "", "connect", "()V", "refreshSleepPurchaseState", "refreshCloudSubscriptionState", "Lcom/urbandroid/sleep/trial/Billing$PurchaseType;", "purchaseType", "startPurchaseFlow", "(Lcom/urbandroid/sleep/trial/Billing$PurchaseType;)V", "", "purchaseTypes", "Lcom/urbandroid/sleep/trial/JavaBilling$SkuDetailListener;", "listener", "resolveSkuDetails", "(Ljava/util/List;Lcom/urbandroid/sleep/trial/JavaBilling$SkuDetailListener;)V", "destroy", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Lcom/urbandroid/sleep/trial/IBillingStatusListener;", "Lcom/urbandroid/sleep/trial/IBillingServiceStatusListener;", "Lcom/urbandroid/sleep/trial/Billing;", "billing", "Lcom/urbandroid/sleep/trial/Billing;", "getBilling", "()Lcom/urbandroid/sleep/trial/Billing;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "SkuDetailListener", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JavaBilling implements CoroutineScope {
    private final Activity activity;
    private final Billing billing;
    private final IBillingStatusListener billingListener;
    private final CoroutineContext coroutineContext;
    private final IBillingServiceStatusListener serviceStatusListener;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/trial/JavaBilling$SkuDetailListener;", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface SkuDetailListener {
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.JavaBilling$connect$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.JavaBilling$connect$1", f = "Billing.kt", l = {1117, 1125}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return JavaBilling.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00d1 A[Catch: all -> 0x0025, TryCatch #0 {all -> 0x0025, blocks: (B:7:0x0020, B:37:0x00c9, B:39:0x00d1, B:44:0x00db, B:45:0x00de), top: B:51:0x0020 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Billing billing;
            JavaBilling javaBilling;
            Mutex mutex;
            int i;
            int i2;
            Mutex mutex2;
            JavaBilling javaBilling2;
            IBillingServiceStatusListener iBillingServiceStatusListener;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    billing = JavaBilling.this.getBilling();
                    javaBilling = JavaBilling.this;
                    mutex = billing.getMutex();
                    this.L$0 = billing;
                    this.L$1 = javaBilling;
                    this.L$2 = mutex;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                        i = 0;
                        i2 = 0;
                    }
                    return coroutine_suspended;
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    mutex2 = (Mutex) this.L$2;
                    javaBilling2 = (JavaBilling) this.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        BillingResult billingResult = (BillingResult) obj;
                        iBillingServiceStatusListener = javaBilling2.serviceStatusListener;
                        if (iBillingServiceStatusListener != null) {
                            if (billingResult.getResponseCode() != 0) {
                                iBillingServiceStatusListener = null;
                            }
                            if (iBillingServiceStatusListener != null) {
                                iBillingServiceStatusListener.onServiceConnected();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                int i4 = this.I$1;
                int i5 = this.I$0;
                Mutex mutex3 = (Mutex) this.L$2;
                JavaBilling javaBilling3 = (JavaBilling) this.L$1;
                billing = (Billing) this.L$0;
                ResultKt.throwOnFailure(obj);
                i = i4;
                mutex = mutex3;
                i2 = i5;
                javaBilling = javaBilling3;
                if (billing.getClient().isReady()) {
                    BillingResult billingResult2 = BillingKt.billingResult(0, "Connected");
                    IBillingServiceStatusListener iBillingServiceStatusListener2 = javaBilling.serviceStatusListener;
                    if (iBillingServiceStatusListener2 != null) {
                        if (billingResult2.getResponseCode() != 0) {
                            iBillingServiceStatusListener2 = null;
                        }
                        if (iBillingServiceStatusListener2 != null) {
                            iBillingServiceStatusListener2.onServiceConnected();
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    mutex.unlock(null);
                    return Unit.INSTANCE;
                }
                long secondsInMillis = Utils.getSecondsInMillis(10);
                Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1 billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1 = new Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1(null, billing);
                this.L$0 = SpillingKt.nullOutSpilledVariable(billing);
                this.L$1 = javaBilling;
                this.L$2 = mutex;
                this.L$3 = SpillingKt.nullOutSpilledVariable(this);
                this.I$0 = i2;
                this.I$1 = i;
                this.I$2 = 0;
                this.J$0 = secondsInMillis;
                this.I$3 = 0;
                this.label = 2;
                Object objWithTimeout = TimeoutKt.withTimeout(secondsInMillis, billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1, this);
                if (objWithTimeout != coroutine_suspended) {
                    mutex2 = mutex;
                    javaBilling2 = javaBilling;
                    obj = objWithTimeout;
                    BillingResult billingResult3 = (BillingResult) obj;
                    iBillingServiceStatusListener = javaBilling2.serviceStatusListener;
                    if (iBillingServiceStatusListener != null) {
                    }
                    Unit unit3 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th2) {
                th = th2;
                mutex2 = mutex;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.JavaBilling$refreshCloudSubscriptionState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.JavaBilling$refreshCloudSubscriptionState$1", f = "Billing.kt", l = {979, 980}, m = "invokeSuspend", v = 2)
    public static final class C22231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        public C22231(Continuation<? super C22231> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return JavaBilling.this.new C22231(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IBillingStatusListener.Status status;
            String str;
            IBillingStatusListener.Status status2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Billing billing = JavaBilling.this.getBilling();
                String pkg = Billing.PurchaseType.STANDARD_SUBSCRIPTION.getPkg();
                this.label = 1;
                obj = billing.refreshPurchaseState(SubSampleInformationBox.TYPE, pkg, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                str = (String) this.L$1;
                status = (IBillingStatusListener.Status) this.L$0;
                ResultKt.throwOnFailure(obj);
                Billing.RefreshPurchaseState refreshPurchaseState = (Billing.RefreshPurchaseState) obj;
                IBillingStatusListener.Status status3 = refreshPurchaseState.getStatus();
                String sku = refreshPurchaseState.getSku();
                Logger.logDebug("refreshStandardSubscriptionState: " + str + " " + status, null);
                Logger.logDebug("refreshCloudSubscriptionState: " + sku + " " + status3, null);
                Context context = SharedApplicationContext.getInstance().getContext();
                status2 = IBillingStatusListener.Status.OWNED;
                if (status != status2 && status3 != status2) {
                    z = false;
                }
                PreferencesUtils.storeCloudPremiumStatus(context, z);
                JavaBilling.this.billingListener.onStatusDetected(sku, status3);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            Billing.RefreshPurchaseState refreshPurchaseState2 = (Billing.RefreshPurchaseState) obj;
            status = refreshPurchaseState2.getStatus();
            String sku2 = refreshPurchaseState2.getSku();
            Billing billing2 = JavaBilling.this.getBilling();
            this.L$0 = status;
            this.L$1 = sku2;
            this.label = 2;
            Object objRefreshPurchaseState = billing2.refreshPurchaseState(SubSampleInformationBox.TYPE, "sleep.cloud", this);
            if (objRefreshPurchaseState != coroutine_suspended) {
                str = sku2;
                obj = objRefreshPurchaseState;
                Billing.RefreshPurchaseState refreshPurchaseState3 = (Billing.RefreshPurchaseState) obj;
                IBillingStatusListener.Status status32 = refreshPurchaseState3.getStatus();
                String sku3 = refreshPurchaseState3.getSku();
                Logger.logDebug("refreshStandardSubscriptionState: " + str + " " + status, null);
                Logger.logDebug("refreshCloudSubscriptionState: " + sku3 + " " + status32, null);
                Context context2 = SharedApplicationContext.getInstance().getContext();
                status2 = IBillingStatusListener.Status.OWNED;
                if (status != status2) {
                    z = false;
                }
                PreferencesUtils.storeCloudPremiumStatus(context2, z);
                JavaBilling.this.billingListener.onStatusDetected(sku3, status32);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.JavaBilling$refreshSleepPurchaseState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.JavaBilling$refreshSleepPurchaseState$1", f = "Billing.kt", l = {961, 964}, m = "invokeSuspend", v = 2)
    public static final class C22241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        public C22241(Continuation<? super C22241> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return JavaBilling.this.new C22241(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            IBillingStatusListener.Status status;
            String str;
            String sku;
            IBillingStatusListener.Status status2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Billing billing = JavaBilling.this.getBilling();
                this.label = 1;
                obj = billing.refreshPurchaseState("inapp", "sleep.unlock", this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                str = (String) this.L$1;
                status = (IBillingStatusListener.Status) this.L$0;
                ResultKt.throwOnFailure(obj);
                Billing.RefreshPurchaseState refreshPurchaseState = (Billing.RefreshPurchaseState) obj;
                IBillingStatusListener.Status status3 = refreshPurchaseState.getStatus();
                sku = refreshPurchaseState.getSku();
                Logger.logDebug("refreshSleepPurchaseState: subs " + status3 + " " + sku, null);
                status2 = IBillingStatusListener.Status.OWNED;
                if (status != status2 || status3 == status2) {
                    IBillingStatusListener iBillingStatusListener = JavaBilling.this.billingListener;
                    if (sku != null) {
                        str = sku;
                    }
                    iBillingStatusListener.onStatusDetected(str, status2);
                } else {
                    IBillingStatusListener.Status status4 = IBillingStatusListener.Status.NOT_OWNED;
                    if (status == status4 && status3 == status4) {
                        IBillingStatusListener iBillingStatusListener2 = JavaBilling.this.billingListener;
                        if (sku != null) {
                            str = sku;
                        }
                        iBillingStatusListener2.onStatusDetected(str, status4);
                    } else {
                        IBillingStatusListener.Status status5 = IBillingStatusListener.Status.PURCHASE_ERROR;
                        if (status == status5 || status3 == status5) {
                            IBillingStatusListener iBillingStatusListener3 = JavaBilling.this.billingListener;
                            if (sku != null) {
                                str = sku;
                            }
                            iBillingStatusListener3.onStatusDetected(str, status5);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            Billing.RefreshPurchaseState refreshPurchaseState2 = (Billing.RefreshPurchaseState) obj;
            status = refreshPurchaseState2.getStatus();
            String sku2 = refreshPurchaseState2.getSku();
            Logger.logDebug("refreshSleepPurchaseState: inapp " + sku2 + " " + status, null);
            Billing billing2 = JavaBilling.this.getBilling();
            this.L$0 = status;
            this.L$1 = sku2;
            this.label = 2;
            Object objRefreshPurchaseState = billing2.refreshPurchaseState(SubSampleInformationBox.TYPE, "sleep.unlock", this);
            if (objRefreshPurchaseState != coroutine_suspended) {
                str = sku2;
                obj = objRefreshPurchaseState;
                Billing.RefreshPurchaseState refreshPurchaseState3 = (Billing.RefreshPurchaseState) obj;
                IBillingStatusListener.Status status32 = refreshPurchaseState3.getStatus();
                sku = refreshPurchaseState3.getSku();
                Logger.logDebug("refreshSleepPurchaseState: subs " + status32 + " " + sku, null);
                status2 = IBillingStatusListener.Status.OWNED;
                if (status != status2) {
                    IBillingStatusListener iBillingStatusListener4 = JavaBilling.this.billingListener;
                    if (sku != null) {
                    }
                    iBillingStatusListener4.onStatusDetected(str, status2);
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.JavaBilling$resolveSkuDetails$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.JavaBilling$resolveSkuDetails$1", f = "Billing.kt", l = {1058, 1060}, m = "invokeSuspend", v = 2)
    public static final class C22251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SkuDetailListener $listener;
        final /* synthetic */ List<Billing.PurchaseType> $purchaseTypes;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C22251(List<? extends Billing.PurchaseType> list, SkuDetailListener skuDetailListener, Continuation<? super C22251> continuation) {
            super(2, continuation);
            this.$purchaseTypes = list;
            this.$listener = skuDetailListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence invokeSuspend$lambda$0$0(String str) {
            return FileInsert$$ExternalSyntheticOutline0.m$1(str, ",");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence invokeSuspend$lambda$1(String str) {
            return FileInsert$$ExternalSyntheticOutline0.m$1(str, ",");
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return JavaBilling.this.new C22251(this.$purchaseTypes, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            List list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Logger.logInfo("Purchase resolveSkuDetails", null);
                Billing billing = JavaBilling.this.getBilling();
                List<Billing.PurchaseType> list2 = this.$purchaseTypes;
                this.label = 1;
                obj = billing.resolveSkuDetails(list2, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (PurchaseHistoryRecord purchaseHistoryRecord : (List) obj) {
                    List<String> products = purchaseHistoryRecord.getProducts();
                    products.getClass();
                    Logger.logInfo("Purchase history " + CollectionsKt.joinToString$default(products, null, null, null, new Billing$$ExternalSyntheticLambda1(5), 31), null);
                    List<String> products2 = purchaseHistoryRecord.getProducts();
                    Billing.PurchaseType purchaseType = Billing.PurchaseType.YEARLY_50_SUBSCRIPTION;
                    if (products2.contains(purchaseType.getPkg())) {
                        linkedHashSet.add(purchaseType.getPkg());
                    } else {
                        List<String> products3 = purchaseHistoryRecord.getProducts();
                        Billing.PurchaseType purchaseType2 = Billing.PurchaseType.YEARLY_70_SUBSCRIPTION;
                        if (products3.contains(purchaseType2.getPkg())) {
                            linkedHashSet.add(purchaseType2.getPkg());
                        } else {
                            List<String> products4 = purchaseHistoryRecord.getProducts();
                            Billing.PurchaseType purchaseType3 = Billing.PurchaseType.YEARLY_25_SUBSCRIPTION;
                            if (products4.contains(purchaseType3.getPkg())) {
                                linkedHashSet.add(purchaseType3.getPkg());
                            } else {
                                List<String> products5 = purchaseHistoryRecord.getProducts();
                                Billing.PurchaseType purchaseType4 = Billing.PurchaseType.YEARLY_35_SUBSCRIPTION;
                                if (products5.contains(purchaseType4.getPkg())) {
                                    linkedHashSet.add(purchaseType4.getPkg());
                                }
                            }
                        }
                    }
                }
                Logger.logInfo("Purchase filter " + CollectionsKt.joinToString$default(linkedHashSet, null, null, null, new Billing$$ExternalSyntheticLambda1(6), 31), null);
                AlarmClock$$ExternalSyntheticLambda2 alarmClock$$ExternalSyntheticLambda2 = (AlarmClock$$ExternalSyntheticLambda2) this.$listener;
                ((UnlockFlow) alarmClock$$ExternalSyntheticLambda2.f$0).lambda$loadPrices$22((JavaBilling) alarmClock$$ExternalSyntheticLambda2.f$1, list, linkedHashSet);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            List list3 = (List) obj;
            Billing billing2 = JavaBilling.this.getBilling();
            this.L$0 = list3;
            this.label = 2;
            Object objQueryPurchaseHistory = billing2.queryPurchaseHistory(SubSampleInformationBox.TYPE, this);
            if (objQueryPurchaseHistory != coroutine_suspended) {
                list = list3;
                obj = objQueryPurchaseHistory;
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                while (r13.hasNext()) {
                }
                Logger.logInfo("Purchase filter " + CollectionsKt.joinToString$default(linkedHashSet2, null, null, null, new Billing$$ExternalSyntheticLambda1(6), 31), null);
                AlarmClock$$ExternalSyntheticLambda2 alarmClock$$ExternalSyntheticLambda22 = (AlarmClock$$ExternalSyntheticLambda2) this.$listener;
                ((UnlockFlow) alarmClock$$ExternalSyntheticLambda22.f$0).lambda$loadPrices$22((JavaBilling) alarmClock$$ExternalSyntheticLambda22.f$1, list, linkedHashSet2);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.JavaBilling$startPurchaseFlow$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.JavaBilling$startPurchaseFlow$1", f = "Billing.kt", l = {994, 1007, 1014}, m = "invokeSuspend", v = 2)
    public static final class C22261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Billing.PurchaseType $purchaseType;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22261(Billing.PurchaseType purchaseType, Continuation<? super C22261> continuation) {
            super(2, continuation);
            this.$purchaseType = purchaseType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return JavaBilling.this.new C22261(this.$purchaseType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22261) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0153  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0179  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x01ce  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x01fb  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objPurchase;
            BillingResult billingResultComponent1;
            int responseCode;
            Billing.PurchaseType purchaseType;
            int i;
            Object objAcknowledge;
            Purchase purchase;
            JavaBilling javaBilling;
            Billing billing;
            int responseCode2;
            Object objQuerySkuDetails;
            Purchase purchase2;
            Billing.PurchaseType purchaseType2;
            int i2;
            List<SkuDetails> skuDetailsList;
            SkuDetails skuDetails;
            String orderId;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                Billing billing2 = JavaBilling.this.getBilling();
                Billing.PurchaseType purchaseType3 = this.$purchaseType;
                this.label = 1;
                objPurchase = billing2.purchase(purchaseType3, this);
                if (objPurchase != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    i2 = this.I$2;
                    javaBilling = (JavaBilling) this.L$3;
                    purchaseType2 = (Billing.PurchaseType) this.L$2;
                    purchase2 = (Purchase) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    objQuerySkuDetails = obj;
                    skuDetailsList = ((SkuDetailsResult) objQuerySkuDetails).getSkuDetailsList();
                    if (skuDetailsList != null && (skuDetails = (SkuDetails) CollectionsKt.firstOrNull((List) skuDetailsList)) != null) {
                        FacebookAnalytics.Companion companion = FacebookAnalytics.INSTANCE;
                        Context context = SharedApplicationContext.getInstance().getContext();
                        context.getClass();
                        String sku = skuDetails.getSku();
                        sku.getClass();
                        orderId = purchase2.getOrderId();
                        if (orderId == null) {
                            orderId = String.valueOf(i2);
                        }
                        String priceCurrencyCode = skuDetails.getPriceCurrencyCode();
                        priceCurrencyCode.getClass();
                        Billing.PurchaseType.Companion companion2 = Billing.PurchaseType.INSTANCE;
                        companion.logPurchase(context, sku, orderId, priceCurrencyCode, companion2.getPriceAmount(skuDetails));
                        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventUnlockPurchased(skuDetails.getSku(), TrialFilter.getInstance().daysUsed(), Billing.PurchaseType.Companion.getPriceAmountInBaseCurrency$default(companion2, skuDetails, 0.0f, 2, (Object) null), skuDetails.getPriceCurrencyCode(), companion2.getPriceAmount(skuDetails));
                    }
                    javaBilling.billingListener.onStatusDetected(purchaseType2.getPkg(), IBillingStatusListener.Status.OWNED);
                    BillingKt.showPurchaseThanks(javaBilling.getActivity(), purchaseType2.getPkg());
                    return Unit.INSTANCE;
                }
                int i4 = this.I$1;
                int i5 = this.I$0;
                Billing billing3 = (Billing) this.L$4;
                JavaBilling javaBilling2 = (JavaBilling) this.L$3;
                Billing.PurchaseType purchaseType4 = (Billing.PurchaseType) this.L$2;
                Purchase purchase3 = (Purchase) this.L$1;
                billingResultComponent1 = (BillingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                i = i4;
                javaBilling = javaBilling2;
                purchaseType = purchaseType4;
                billing = billing3;
                responseCode = i5;
                purchase = purchase3;
                objAcknowledge = obj;
                responseCode2 = ((BillingResult) objAcknowledge).getResponseCode();
                if (responseCode2 != 0) {
                    String strM = FileInsert$$ExternalSyntheticOutline0.m("acknowledged ", purchaseType.getPkg());
                    Logger.logDebug(Logger.defaultTag, billing.getTag() + ": " + strM, null);
                } else {
                    String str = "acknowledge failed " + purchaseType.getPkg() + " result=" + responseCode2;
                    Logger.logWarning(Logger.defaultTag, billing.getTag() + ": " + str, null);
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(billingResultComponent1);
                this.L$1 = purchase;
                this.L$2 = purchaseType;
                this.L$3 = javaBilling;
                this.L$4 = SpillingKt.nullOutSpilledVariable(billing);
                this.I$0 = responseCode;
                this.I$1 = i;
                this.I$2 = responseCode2;
                this.label = 3;
                objQuerySkuDetails = billing.querySkuDetails(purchaseType, this);
                if (objQuerySkuDetails != coroutine_suspended) {
                    purchase2 = purchase;
                    purchaseType2 = purchaseType;
                    i2 = responseCode2;
                    skuDetailsList = ((SkuDetailsResult) objQuerySkuDetails).getSkuDetailsList();
                    if (skuDetailsList != null) {
                        FacebookAnalytics.Companion companion3 = FacebookAnalytics.INSTANCE;
                        Context context2 = SharedApplicationContext.getInstance().getContext();
                        context2.getClass();
                        String sku2 = skuDetails.getSku();
                        sku2.getClass();
                        orderId = purchase2.getOrderId();
                        if (orderId == null) {
                        }
                        String priceCurrencyCode2 = skuDetails.getPriceCurrencyCode();
                        priceCurrencyCode2.getClass();
                        Billing.PurchaseType.Companion companion22 = Billing.PurchaseType.INSTANCE;
                        companion3.logPurchase(context2, sku2, orderId, priceCurrencyCode2, companion22.getPriceAmount(skuDetails));
                        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventUnlockPurchased(skuDetails.getSku(), TrialFilter.getInstance().daysUsed(), Billing.PurchaseType.Companion.getPriceAmountInBaseCurrency$default(companion22, skuDetails, 0.0f, 2, (Object) null), skuDetails.getPriceCurrencyCode(), companion22.getPriceAmount(skuDetails));
                    }
                    javaBilling.billingListener.onStatusDetected(purchaseType2.getPkg(), IBillingStatusListener.Status.OWNED);
                    BillingKt.showPurchaseThanks(javaBilling.getActivity(), purchaseType2.getPkg());
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
            ResultKt.throwOnFailure(obj);
            objPurchase = obj;
            PurchaseResult purchaseResult = (PurchaseResult) objPurchase;
            billingResultComponent1 = purchaseResult.getBillingResult();
            Purchase purchaseComponent2 = purchaseResult.getPurchase();
            responseCode = billingResultComponent1.getResponseCode();
            Logger.logInfo("startPurchaseFlow launch - " + this.$purchaseType + " ... " + responseCode, null);
            if (responseCode == 7) {
                JavaBilling.this.billingListener.onStatusDetected(this.$purchaseType.getPkg(), IBillingStatusListener.Status.OWNED);
                return Unit.INSTANCE;
            }
            if (responseCode != 0) {
                Billing.PurchaseType purchaseType5 = this.$purchaseType;
                if (responseCode != 1) {
                    Logger.logWarning("purchase failed " + purchaseType5.getPkg() + " result=" + billingResultComponent1.getResponseCode(), null);
                    JavaBilling.this.billingListener.onStatusDetected(this.$purchaseType.getPkg(), IBillingStatusListener.Status.PURCHASE_ERROR);
                } else {
                    Logger.logWarning("purchase use cancelled " + purchaseType5.getPkg(), null);
                    JavaBilling.this.billingListener.onStatusDetected(this.$purchaseType.getPkg(), IBillingStatusListener.Status.USER_CANCELLED);
                }
            } else {
                if (purchaseComponent2 != null) {
                    Billing billing4 = JavaBilling.this.getBilling();
                    purchaseType = this.$purchaseType;
                    JavaBilling javaBilling3 = JavaBilling.this;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(billingResultComponent1);
                    this.L$1 = purchaseComponent2;
                    this.L$2 = purchaseType;
                    this.L$3 = javaBilling3;
                    this.L$4 = billing4;
                    this.I$0 = responseCode;
                    i = 0;
                    this.I$1 = 0;
                    this.label = 2;
                    objAcknowledge = billing4.acknowledge(purchaseComponent2, this);
                    if (objAcknowledge != coroutine_suspended) {
                        purchase = purchaseComponent2;
                        javaBilling = javaBilling3;
                        billing = billing4;
                        responseCode2 = ((BillingResult) objAcknowledge).getResponseCode();
                        if (responseCode2 != 0) {
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(billingResultComponent1);
                        this.L$1 = purchase;
                        this.L$2 = purchaseType;
                        this.L$3 = javaBilling;
                        this.L$4 = SpillingKt.nullOutSpilledVariable(billing);
                        this.I$0 = responseCode;
                        this.I$1 = i;
                        this.I$2 = responseCode2;
                        this.label = 3;
                        objQuerySkuDetails = billing.querySkuDetails(purchaseType, this);
                        if (objQuerySkuDetails != coroutine_suspended) {
                        }
                    }
                    return coroutine_suspended;
                }
                Logger.logSevere("Purchase code is OK but no purchase found", null);
            }
            return Unit.INSTANCE;
        }
    }

    public JavaBilling(Activity activity, IBillingStatusListener iBillingStatusListener, IBillingServiceStatusListener iBillingServiceStatusListener) {
        activity.getClass();
        iBillingStatusListener.getClass();
        this.activity = activity;
        this.billingListener = iBillingStatusListener;
        this.serviceStatusListener = iBillingServiceStatusListener;
        this.billing = new Billing(activity);
        this.coroutineContext = SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()).plus(new JavaBilling$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE));
    }

    public final void connect() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(null), 3, null);
    }

    public final void destroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        this.billing.disconnect();
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Billing getBilling() {
        return this.billing;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final void refreshCloudSubscriptionState() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C22231(null), 3, null);
    }

    public final void refreshSleepPurchaseState() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C22241(null), 3, null);
    }

    public final void resolveSkuDetails(List<? extends Billing.PurchaseType> purchaseTypes, SkuDetailListener listener) {
        purchaseTypes.getClass();
        listener.getClass();
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C22251(purchaseTypes, listener, null), 3, null);
    }

    public final void startPurchaseFlow(Billing.PurchaseType purchaseType) {
        purchaseType.getClass();
        Logger.logInfo("startPurchaseFlow - " + purchaseType + " ...", null);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C22261(purchaseType, null), 3, null);
    }
}
