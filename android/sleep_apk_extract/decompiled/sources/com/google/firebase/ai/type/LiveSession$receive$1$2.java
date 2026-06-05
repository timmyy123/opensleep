package com.google.firebase.ai.type;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/google/firebase/ai/type/LiveServerMessage;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.ai.type.LiveSession$receive$1$2", f = "LiveSession.kt", l = {}, m = "invokeSuspend")
public final class LiveSession$receive$1$2 extends SuspendLambda implements Function3<FlowCollector<? super LiveServerMessage>, Throwable, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LiveSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveSession$receive$1$2(LiveSession liveSession, Continuation<? super LiveSession$receive$1$2> continuation) {
        super(3, continuation);
        this.this$0 = liveSession;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super LiveServerMessage> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        return new LiveSession$receive$1$2(this.this$0, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.stopAudioConversation();
        return Unit.INSTANCE;
    }
}
