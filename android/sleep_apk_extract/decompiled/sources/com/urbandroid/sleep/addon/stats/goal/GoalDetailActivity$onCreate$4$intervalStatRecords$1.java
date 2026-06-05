package com.urbandroid.sleep.addon.stats.goal;

import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.sleep.service.GoalUpdateIntentService;
import java.util.Date;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity$onCreate$4$intervalStatRecords$1", f = "GoalDetailActivity.kt", l = {}, m = "invokeSuspend", v = 2)
public final class GoalDetailActivity$onCreate$4$intervalStatRecords$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends StatRecord>>, Object> {
    final /* synthetic */ Goal $currentGoal;
    final /* synthetic */ Date $from;
    int label;
    final /* synthetic */ GoalDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoalDetailActivity$onCreate$4$intervalStatRecords$1(GoalDetailActivity goalDetailActivity, Date date, Goal goal, Continuation<? super GoalDetailActivity$onCreate$4$intervalStatRecords$1> continuation) {
        super(2, continuation);
        this.this$0 = goalDetailActivity;
        this.$from = date;
        this.$currentGoal = goal;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoalDetailActivity$onCreate$4$intervalStatRecords$1(this.this$0, this.$from, this.$currentGoal, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends StatRecord>> continuation) {
        return ((GoalDetailActivity$onCreate$4$intervalStatRecords$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        StatRepo statRepo = new StatRepo();
        try {
            statRepo.initialize(this.this$0.getApplicationContext(), this.$from);
            GoalUpdateIntentService.updateGoalProgress(this.this$0.getApplicationContext(), this.$currentGoal);
            return statRepo.getMergedStatRecords();
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }
}
