package com.urbandroid.sleep.fragment;

import com.urbandroid.sleep.addon.stats.FilterAdapter;
import com.urbandroid.sleep.fragment.StatsFragmentNew;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.fragment.StatsFragmentNew$ScoreAdapter$Holder$bind$1$2$2$onItemSelected$1", f = "StatsFragmentNew.kt", l = {263}, m = "invokeSuspend", v = 2)
public final class StatsFragmentNew$ScoreAdapter$Holder$bind$1$2$2$onItemSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FilterAdapter $filterAdapter;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ StatsFragmentNew this$0;
    final /* synthetic */ StatsFragmentNew.ScoreAdapter this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatsFragmentNew$ScoreAdapter$Holder$bind$1$2$2$onItemSelected$1(StatsFragmentNew statsFragmentNew, StatsFragmentNew.ScoreAdapter scoreAdapter, FilterAdapter filterAdapter, int i, Continuation<? super StatsFragmentNew$ScoreAdapter$Holder$bind$1$2$2$onItemSelected$1> continuation) {
        super(2, continuation);
        this.this$0 = statsFragmentNew;
        this.this$1 = scoreAdapter;
        this.$filterAdapter = filterAdapter;
        this.$position = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StatsFragmentNew$ScoreAdapter$Holder$bind$1$2$2$onItemSelected$1(this.this$0, this.this$1, this.$filterAdapter, this.$position, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StatsFragmentNew$ScoreAdapter$Holder$bind$1$2$2$onItemSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StatsFragmentNew statsFragmentNew = this.this$0;
            int i2 = this.this$1.periodPosition;
            StatsFragmentNew.FilterHolder filterHolder = this.this$1.toFilterHolder(this.$filterAdapter, this.$position);
            this.label = 1;
            if (statsFragmentNew.loadData(i2, filterHolder, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
