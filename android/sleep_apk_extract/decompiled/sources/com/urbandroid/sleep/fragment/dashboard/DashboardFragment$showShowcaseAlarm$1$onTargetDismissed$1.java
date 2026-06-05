package com.urbandroid.sleep.fragment.dashboard;

import android.app.Activity;
import android.view.View;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.fragment.dashboard.DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1", f = "DashboardFragment.kt", l = {365}, m = "invokeSuspend", v = 2)
public final class DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $context;
    int label;
    final /* synthetic */ DashboardFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1(DashboardFragment dashboardFragment, Activity activity, Continuation<? super DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1> continuation) {
        super(2, continuation);
        this.this$0 = dashboardFragment;
        this.$context = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ExecutorCoroutineDispatcher executorCoroutineDispatcher = this.this$0.loadDataDispatcher;
            DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1$recordCount$1 dashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1$recordCount$1 = new DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1$recordCount$1(null);
            this.label = 1;
            obj = BuildersKt.withContext(executorCoroutineDispatcher, dashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1$recordCount$1, this);
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
        if (((Number) obj).intValue() <= 0 && ContextExtKt.getSettings(this.$context).showShowCaseIfNotShown("sc_dashboard_track")) {
            DashboardFragment dashboardFragment = this.this$0;
            Activity activity = this.$context;
            View viewFindViewById = activity.findViewById(R.id.fab);
            viewFindViewById.getClass();
            dashboardFragment.showShowcaseTrack(activity, viewFindViewById);
        }
        return Unit.INSTANCE;
    }
}
