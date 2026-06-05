package com.urbandroid.sleep.addon.stats.goal;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.urbandroid.sleep.domain.goal.Goal;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.addon.stats.goal.GoalSelectFragment$onCreateView$1$1", f = "GoalSelectFragment.kt", l = {64}, m = "invokeSuspend", v = 2)
public final class GoalSelectFragment$onCreateView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $fragmentActivity;
    final /* synthetic */ RecyclerView $view;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ GoalSelectFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoalSelectFragment$onCreateView$1$1(GoalSelectFragment goalSelectFragment, FragmentActivity fragmentActivity, RecyclerView recyclerView, Continuation<? super GoalSelectFragment$onCreateView$1$1> continuation) {
        super(2, continuation);
        this.this$0 = goalSelectFragment;
        this.$fragmentActivity = fragmentActivity;
        this.$view = recyclerView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoalSelectFragment$onCreateView$1$1(this.this$0, this.$fragmentActivity, this.$view, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GoalSelectFragment$onCreateView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x005d -> B:20:0x00b0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0084 -> B:6:0x0030). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Goal.Type[] typeArr;
        GoalSelectFragment goalSelectFragment;
        FragmentActivity fragmentActivity;
        int length;
        int i;
        int i2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        GoalRecyclerViewAdapter goalRecyclerViewAdapter = null;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.adapter = new GoalRecyclerViewAdapter(this.$fragmentActivity);
            Goal.Type[] typeArrValues = Goal.Type.values();
            typeArr = typeArrValues;
            goalSelectFragment = this.this$0;
            fragmentActivity = this.$fragmentActivity;
            length = typeArrValues.length;
            i = 0;
            i2 = 0;
            if (i >= length) {
            }
        } else {
            if (i3 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            length = this.I$2;
            i = this.I$1;
            i2 = this.I$0;
            Goal.Type type = (Goal.Type) this.L$4;
            fragmentActivity = (FragmentActivity) this.L$2;
            goalSelectFragment = (GoalSelectFragment) this.L$1;
            typeArr = (Goal.Type[]) this.L$0;
            ResultKt.throwOnFailure(obj);
            Object objWithContext = obj;
            Goal goal = new Goal(((Number) objWithContext).doubleValue(), type, 0L, 0L, 12, null);
            GoalRecyclerViewAdapter goalRecyclerViewAdapter2 = goalSelectFragment.adapter;
            if (goalRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                goalRecyclerViewAdapter2 = null;
            }
            goalRecyclerViewAdapter2.getItems().add(new GoalItem(fragmentActivity, goal));
            i++;
            if (i >= length) {
                RecyclerView recyclerView = this.$view;
                GoalRecyclerViewAdapter goalRecyclerViewAdapter3 = this.this$0.adapter;
                if (goalRecyclerViewAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    goalRecyclerViewAdapter = goalRecyclerViewAdapter3;
                }
                recyclerView.setAdapter(goalRecyclerViewAdapter);
                this.$view.setNestedScrollingEnabled(true);
                return Unit.INSTANCE;
            }
            type = typeArr[i];
            if (type != Goal.Type.IRREGULARITY) {
                CoroutineDispatcher io2 = Dispatchers.getIO();
                GoalSelectFragment$onCreateView$1$1$1$base$1 goalSelectFragment$onCreateView$1$1$1$base$1 = new GoalSelectFragment$onCreateView$1$1$1$base$1(goalSelectFragment, type, null);
                this.L$0 = typeArr;
                this.L$1 = goalSelectFragment;
                this.L$2 = fragmentActivity;
                this.L$3 = SpillingKt.nullOutSpilledVariable(type);
                this.L$4 = type;
                this.I$0 = i2;
                this.I$1 = i;
                this.I$2 = length;
                this.I$3 = 0;
                this.label = 1;
                objWithContext = BuildersKt.withContext(io2, goalSelectFragment$onCreateView$1$1$1$base$1, this);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Goal goal2 = new Goal(((Number) objWithContext).doubleValue(), type, 0L, 0L, 12, null);
                GoalRecyclerViewAdapter goalRecyclerViewAdapter22 = goalSelectFragment.adapter;
                if (goalRecyclerViewAdapter22 == null) {
                }
                goalRecyclerViewAdapter22.getItems().add(new GoalItem(fragmentActivity, goal2));
            }
            i++;
            if (i >= length) {
            }
        }
    }
}
