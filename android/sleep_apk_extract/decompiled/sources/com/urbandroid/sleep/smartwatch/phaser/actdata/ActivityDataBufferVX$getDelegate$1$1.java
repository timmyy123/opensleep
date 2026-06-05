package com.urbandroid.sleep.smartwatch.phaser.actdata;

import com.urbandroid.sleep.smartwatch.phaser.CoroutineRunnerKt;
import com.urbandroid.sleep.smartwatch.phaser.protocol.ActigraphyResult;
import com.urbandroid.sleep.smartwatch.phaser.protocol.SleepPhaserBLEClient;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/ActigraphyResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBufferVX$getDelegate$1$1", f = "ActivityDataBufferVX.kt", l = {47}, m = "invokeSuspend", v = 2)
public final class ActivityDataBufferVX$getDelegate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ActigraphyResult>, Object> {
    int label;
    final /* synthetic */ ActivityDataBufferVX this$0;

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBufferVX$getDelegate$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/smartwatch/phaser/protocol/ActigraphyResult;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartwatch.phaser.actdata.ActivityDataBufferVX$getDelegate$1$1$1", f = "ActivityDataBufferVX.kt", l = {48}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super ActigraphyResult>, Object> {
        int label;
        final /* synthetic */ ActivityDataBufferVX this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ActivityDataBufferVX activityDataBufferVX, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.this$0 = activityDataBufferVX;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ActigraphyResult> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
            SleepPhaserBLEClient sleepPhaserBLEClient = this.this$0.phaser;
            this.label = 1;
            Object objFetchAggregatedData = sleepPhaserBLEClient.fetchAggregatedData(this);
            return objFetchAggregatedData == coroutine_suspended ? coroutine_suspended : objFetchAggregatedData;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityDataBufferVX$getDelegate$1$1(ActivityDataBufferVX activityDataBufferVX, Continuation<? super ActivityDataBufferVX$getDelegate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = activityDataBufferVX;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ActivityDataBufferVX$getDelegate$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ActigraphyResult> continuation) {
        return ((ActivityDataBufferVX$getDelegate$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        SleepPhaserBLEClient sleepPhaserBLEClient = this.this$0.phaser;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        Object objRetryWithReconnect = CoroutineRunnerKt.retryWithReconnect(sleepPhaserBLEClient, 1, anonymousClass1, this);
        return objRetryWithReconnect == coroutine_suspended ? coroutine_suspended : objRetryWithReconnect;
    }
}
