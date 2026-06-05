package com.urbandroid.sleep.addon.stats.goal;

import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.sleep.service.GoalUpdateIntentService;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.addon.stats.goal.GoalCreateActivity$createGoal$1$base$1", f = "GoalCreateActivity.kt", l = {}, m = "invokeSuspend", v = 2)
public final class GoalCreateActivity$createGoal$1$base$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Double>, Object> {
    final /* synthetic */ Goal.Type $type;
    int label;
    final /* synthetic */ GoalCreateActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoalCreateActivity$createGoal$1$base$1(GoalCreateActivity goalCreateActivity, Goal.Type type, Continuation<? super GoalCreateActivity$createGoal$1$base$1> continuation) {
        super(2, continuation);
        this.this$0 = goalCreateActivity;
        this.$type = type;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoalCreateActivity$createGoal$1$base$1(this.this$0, this.$type, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Double> continuation) {
        return ((GoalCreateActivity$createGoal$1$base$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxDouble(GoalUpdateIntentService.getCurrentGoalValue(this.this$0.getApplicationContext(), new Goal(0.0d, this.$type, 0L, 0L, 12, null)));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
        return null;
    }
}
