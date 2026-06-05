package com.urbandroid.sleep.hr.berry;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.hr.berry.BerryOximeterBLEClient$timeoutGuard$1", f = "BerryOximeterBLEClient.kt", l = {44}, m = "invokeSuspend", v = 2)
public final class BerryOximeterBLEClient$timeoutGuard$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BerryOximeterBLEClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BerryOximeterBLEClient$timeoutGuard$1(BerryOximeterBLEClient berryOximeterBLEClient, Continuation<? super BerryOximeterBLEClient$timeoutGuard$1> continuation) {
        super(1, continuation);
        this.this$0 = berryOximeterBLEClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new BerryOximeterBLEClient$timeoutGuard$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((BerryOximeterBLEClient$timeoutGuard$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BerryOximeterBLEClient berryOximeterBLEClient = this.this$0;
            this.label = 1;
            if (berryOximeterBLEClient.handleNotificationsTimeout(this) == coroutine_suspended) {
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
