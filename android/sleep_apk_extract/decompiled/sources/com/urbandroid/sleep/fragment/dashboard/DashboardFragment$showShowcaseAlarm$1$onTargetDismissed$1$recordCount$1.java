package com.urbandroid.sleep.fragment.dashboard;

import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.sleep.service.SharedApplicationContext;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.fragment.dashboard.DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1$recordCount$1", f = "DashboardFragment.kt", l = {}, m = "invokeSuspend", v = 2)
public final class DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1$recordCount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    int label;

    public DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1$recordCount$1(Continuation<? super DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1$recordCount$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1$recordCount$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((DashboardFragment$showShowcaseAlarm$1$onTargetDismissed$1$recordCount$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        DbSleepRecordRepository sleepRecordRepository = SharedApplicationContext.getInstance().getSleepRecordRepository();
        sleepRecordRepository.getClass();
        return Boxing.boxInt(sleepRecordRepository.getSleepRecordsCount());
    }
}
