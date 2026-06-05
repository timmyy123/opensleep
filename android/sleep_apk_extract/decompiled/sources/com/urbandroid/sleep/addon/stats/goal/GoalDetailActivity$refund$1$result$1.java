package com.urbandroid.sleep.addon.stats.goal;

import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.sleep.trial.OrderClient;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity$refund$1$result$1", f = "GoalDetailActivity.kt", l = {}, m = "invokeSuspend", v = 2)
public final class GoalDetailActivity$refund$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Goal $goal;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoalDetailActivity$refund$1$result$1(Goal goal, Continuation<? super GoalDetailActivity$refund$1$result$1> continuation) {
        super(2, continuation);
        this.$goal = goal;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoalDetailActivity$refund$1$result$1(this.$goal, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((GoalDetailActivity$refund$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean zRevokeSubscription;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        if (this.$goal.isInApp()) {
            OrderClient orderClient = new OrderClient();
            String subscriptionId = this.$goal.getSubscriptionId();
            subscriptionId.getClass();
            String orderId = this.$goal.getOrderId();
            orderId.getClass();
            String subscriptionToken = this.$goal.getSubscriptionToken();
            subscriptionToken.getClass();
            zRevokeSubscription = orderClient.refundInApp(subscriptionId, orderId, subscriptionToken);
        } else {
            OrderClient orderClient2 = new OrderClient();
            String subscriptionId2 = this.$goal.getSubscriptionId();
            subscriptionId2.getClass();
            String subscriptionToken2 = this.$goal.getSubscriptionToken();
            subscriptionToken2.getClass();
            zRevokeSubscription = orderClient2.revokeSubscription(subscriptionId2, subscriptionToken2);
        }
        return Boxing.boxBoolean(zRevokeSubscription);
    }
}
