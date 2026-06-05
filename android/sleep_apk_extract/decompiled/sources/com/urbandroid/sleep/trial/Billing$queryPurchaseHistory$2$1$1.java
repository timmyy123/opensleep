package com.urbandroid.sleep.trial;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientKotlinKt;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.PurchaseHistoryResult;
import com.android.billingclient.api.QueryPurchaseHistoryParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.trial.Billing$queryPurchaseHistory$2$1$1", f = "Billing.kt", l = {616}, m = "invokeSuspend", v = 2)
public final class Billing$queryPurchaseHistory$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PurchaseHistoryRecord>>, Object> {
    final /* synthetic */ String $type;
    int label;
    final /* synthetic */ Billing this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Billing$queryPurchaseHistory$2$1$1(Billing billing, String str, Continuation<? super Billing$queryPurchaseHistory$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = billing;
        this.$type = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Billing$queryPurchaseHistory$2$1$1(this.this$0, this.$type, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends PurchaseHistoryRecord>> continuation) {
        return ((Billing$queryPurchaseHistory$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BillingClient client = this.this$0.getClient();
            QueryPurchaseHistoryParams queryPurchaseHistoryParamsBuild = QueryPurchaseHistoryParams.newBuilder().setProductType(this.$type).build();
            queryPurchaseHistoryParamsBuild.getClass();
            this.label = 1;
            obj = BillingClientKotlinKt.queryPurchaseHistory(client, queryPurchaseHistoryParamsBuild, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        PurchaseHistoryResult purchaseHistoryResult = (PurchaseHistoryResult) obj;
        if (purchaseHistoryResult.getZza().getResponseCode() != 0) {
            return CollectionsKt.emptyList();
        }
        List<PurchaseHistoryRecord> purchaseHistoryRecordList = purchaseHistoryResult.getPurchaseHistoryRecordList();
        return purchaseHistoryRecordList == null ? CollectionsKt.emptyList() : purchaseHistoryRecordList;
    }
}
