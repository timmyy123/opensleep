package com.google.firebase.ai.type;

import com.google.firebase.ai.common.APIControllerKt;
import io.ktor.websocket.Frame;
import io.ktor.websocket.FrameCommonKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.Charsets;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.json.Json;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/google/firebase/ai/type/LiveServerMessage;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.ai.type.LiveSession$receive$1$1", f = "LiveSession.kt", l = {325, 328}, m = "invokeSuspend")
public final class LiveSession$receive$1$1 extends SuspendLambda implements Function2<FlowCollector<? super LiveServerMessage>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LiveSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveSession$receive$1$1(LiveSession liveSession, Continuation<? super LiveSession$receive$1$1> continuation) {
        super(2, continuation);
        this.this$0 = liveSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LiveSession$receive$1$1 liveSession$receive$1$1 = new LiveSession$receive$1$1(this.this$0, continuation);
        liveSession$receive$1$1.L$0 = obj;
        return liveSession$receive$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super LiveServerMessage> flowCollector, Continuation<? super Unit> continuation) {
        return ((LiveSession$receive$1$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Path cross not found for [B:18:0x0056, B:23:0x0085], limit reached: 26 */
    /* JADX WARN: Path cross not found for [B:20:0x0076, B:23:0x0085], limit reached: 26 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008f -> B:11:0x002d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
        } else {
            if (i == 1) {
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = flowCollector;
                this.label = 2;
                if (DelayKt.delay(0L, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Object objMo2580tryReceivePtdJZtk = this.this$0.session.getIncoming().mo2580tryReceivePtdJZtk();
        if (!ChannelResult.m2590isClosedimpl(objMo2580tryReceivePtdJZtk) || !this.this$0.startedReceiving.get()) {
            return Unit.INSTANCE;
        }
        Frame frame = (Frame) ChannelResult.m2587getOrNullimpl(objMo2580tryReceivePtdJZtk);
        if (frame != null) {
            Json json = APIControllerKt.getJSON();
            String str = new String(FrameCommonKt.readBytes(frame), Charsets.UTF_8);
            json.getSerializersModule();
            InternalLiveServerMessage internalLiveServerMessage = (InternalLiveServerMessage) json.decodeFromString(InternalLiveServerMessage.INSTANCE.serializer(), str);
            if (internalLiveServerMessage != null) {
                LiveServerMessage liveServerMessage = internalLiveServerMessage.toPublic();
                this.L$0 = flowCollector;
                this.label = 1;
                if (flowCollector.emit(liveServerMessage, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        }
        this.L$0 = flowCollector;
        this.label = 2;
        if (DelayKt.delay(0L, this) != coroutine_suspended) {
            Object objMo2580tryReceivePtdJZtk2 = this.this$0.session.getIncoming().mo2580tryReceivePtdJZtk();
            if (!ChannelResult.m2590isClosedimpl(objMo2580tryReceivePtdJZtk2)) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
