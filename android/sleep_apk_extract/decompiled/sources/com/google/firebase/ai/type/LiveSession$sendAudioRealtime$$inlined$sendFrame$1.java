package com.google.firebase.ai.type;

import com.google.firebase.ai.common.APIControllerKt;
import com.google.firebase.ai.type.LiveSession;
import io.ktor.client.plugins.websocket.DefaultClientWebSocketSession;
import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.json.Json;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¨\u0006\u0002"}, d2 = {"<anonymous>", "", "com/google/firebase/ai/type/LiveSession$sendFrame$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.ai.type.LiveSession$sendFrame$2", f = "LiveSession.kt", l = {462}, m = "invokeSuspend")
public final class LiveSession$sendAudioRealtime$$inlined$sendFrame$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $data;
    int label;
    final /* synthetic */ LiveSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveSession$sendAudioRealtime$$inlined$sendFrame$1(Object obj, LiveSession liveSession, Continuation continuation) {
        super(1, continuation);
        this.$data = obj;
        this.this$0 = liveSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new LiveSession$sendAudioRealtime$$inlined$sendFrame$1(this.$data, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((LiveSession$sendAudioRealtime$$inlined$sendFrame$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Json json = APIControllerKt.getJSON();
            Object obj2 = this.$data;
            json.getSerializersModule();
            String strEncodeToString = json.encodeToString(LiveSession.BidiGenerateContentRealtimeInputSetup.Internal.INSTANCE.serializer(), obj2);
            DefaultClientWebSocketSession defaultClientWebSocketSession = this.this$0.session;
            Frame.Text text = new Frame.Text(strEncodeToString);
            this.label = 1;
            if (defaultClientWebSocketSession.send(text, this) == coroutine_suspended) {
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
