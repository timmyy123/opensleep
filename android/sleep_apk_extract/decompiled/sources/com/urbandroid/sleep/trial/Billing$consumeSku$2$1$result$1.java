package com.urbandroid.sleep.trial;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientKotlinKt;
import com.android.billingclient.api.PurchasesResult;
import com.android.billingclient.api.QueryPurchasesParams;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/android/billingclient/api/PurchasesResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.trial.Billing$consumeSku$2$1$result$1", f = "Billing.kt", l = {653}, m = "invokeSuspend", v = 2)
public final class Billing$consumeSku$2$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PurchasesResult>, Object> {
    final /* synthetic */ String $type;
    int label;
    final /* synthetic */ Billing this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Billing$consumeSku$2$1$result$1(Billing billing, String str, Continuation<? super Billing$consumeSku$2$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = billing;
        this.$type = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Billing$consumeSku$2$1$result$1(this.this$0, this.$type, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PurchasesResult> continuation) {
        return ((Billing$consumeSku$2$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BillingClient client = this.this$0.getClient();
        QueryPurchasesParams queryPurchasesParamsBuild = QueryPurchasesParams.newBuilder().setProductType(this.$type).build();
        queryPurchasesParamsBuild.getClass();
        this.label = 1;
        Object objQueryPurchasesAsync = BillingClientKotlinKt.queryPurchasesAsync(client, queryPurchasesParamsBuild, this);
        return objQueryPurchasesAsync == coroutine_suspended ? coroutine_suspended : objQueryPurchasesAsync;
    }
}
