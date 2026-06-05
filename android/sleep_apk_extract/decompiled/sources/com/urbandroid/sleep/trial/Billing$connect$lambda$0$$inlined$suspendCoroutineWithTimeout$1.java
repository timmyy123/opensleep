package com.urbandroid.sleep.trial;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.trial.Billing;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {2, 3, 0})
@DebugMetadata(c = "com.urbandroid.sleep.trial.Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1", f = "Billing.kt", l = {177}, m = "invokeSuspend", v = 2)
public final class Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BillingResult>, Object> {
    int I$0;
    int label;
    final /* synthetic */ Billing this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1(Continuation continuation, Billing billing) {
        super(2, continuation);
        this.this$0 = billing;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1(continuation, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BillingResult> continuation) {
        return ((Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        this.I$0 = 0;
        this.label = 1;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
        cancellableContinuationImpl.initCancellability();
        final Billing.SafeResumeContinuation safeResumeContinuation = new Billing.SafeResumeContinuation(cancellableContinuationImpl);
        BillingClient client = this.this$0.getClient();
        final Billing billing = this.this$0;
        client.startConnection(new BillingClientStateListener() { // from class: com.urbandroid.sleep.trial.Billing$connect$2$result$1$1
            @Override // com.android.billingclient.api.BillingClientStateListener
            public void onBillingServiceDisconnected() {
                Billing billing2 = billing;
                Logger.logInfo(Logger.defaultTag, billing2.getTag() + ": onBillingServiceDisconnected", null);
                Billing.SafeResumeContinuation<BillingResult> safeResumeContinuation2 = safeResumeContinuation;
                Result.Companion companion = Result.INSTANCE;
                safeResumeContinuation2.resumeWith(Result.m2357constructorimpl(BillingKt.billingResult(-1, "BillingServiceDisconnected")));
            }

            @Override // com.android.billingclient.api.BillingClientStateListener
            public void onBillingSetupFinished(BillingResult billingResult) {
                billingResult.getClass();
                Billing billing2 = billing;
                String strM = FileInsert$$ExternalSyntheticOutline0.m("onBillingSetupFinished: ", BillingKt.pretty(billingResult));
                Logger.logInfo(Logger.defaultTag, billing2.getTag() + ": " + strM, null);
                safeResumeContinuation.resumeWith(Result.m2357constructorimpl(billingResult));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(this);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }
}
