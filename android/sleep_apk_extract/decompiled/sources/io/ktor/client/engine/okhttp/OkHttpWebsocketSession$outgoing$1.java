package io.ktor.client.engine.okhttp;

import io.ktor.websocket.CloseReason;
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
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.channels.ActorScope;
import kotlinx.coroutines.channels.ChannelIterator;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ActorScope;", "Lio/ktor/websocket/Frame;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpWebsocketSession$outgoing$1", f = "OkHttpWebsocketSession.kt", l = {64, 68}, m = "invokeSuspend")
public final class OkHttpWebsocketSession$outgoing$1 extends SuspendLambda implements Function2<ActorScope<Frame>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Request $engineRequest;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ OkHttpWebsocketSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpWebsocketSession$outgoing$1(OkHttpWebsocketSession okHttpWebsocketSession, Request request, Continuation<? super OkHttpWebsocketSession$outgoing$1> continuation) {
        super(2, continuation);
        this.this$0 = okHttpWebsocketSession;
        this.$engineRequest = request;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OkHttpWebsocketSession$outgoing$1 okHttpWebsocketSession$outgoing$1 = new OkHttpWebsocketSession$outgoing$1(this.this$0, this.$engineRequest, continuation);
        okHttpWebsocketSession$outgoing$1.L$0 = obj;
        return okHttpWebsocketSession$outgoing$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ActorScope<Frame> actorScope, Continuation<? super Unit> continuation) {
        return ((OkHttpWebsocketSession$outgoing$1) create(actorScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007f, code lost:
    
        if (r10 != r0) goto L24;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007f -> B:24:0x0082). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        ActorScope actorScope;
        Request request;
        WebSocket.Factory factory;
        WebSocket webSocketNewWebSocket;
        CloseReason closeReason;
        WebSocket webSocket;
        ChannelIterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                actorScope = (ActorScope) this.L$0;
                WebSocket.Factory factory2 = this.this$0.webSocketFactory;
                request = this.$engineRequest;
                CompletableDeferred completableDeferred = this.this$0.self;
                this.L$0 = actorScope;
                this.L$1 = factory2;
                this.L$2 = request;
                this.label = 1;
                Object objAwait = completableDeferred.await(this);
                if (objAwait != coroutine_suspended) {
                    factory = factory2;
                    obj = objAwait;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                request = (Request) this.L$2;
                factory = (WebSocket.Factory) this.L$1;
                actorScope = (ActorScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                it = (ChannelIterator) this.L$2;
                closeReason = (CloseReason) this.L$1;
                webSocket = (WebSocket) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        try {
                            webSocket.close(closeReason.getCode(), closeReason.getMessage());
                            return Unit.INSTANCE;
                        } finally {
                        }
                    }
                    Frame frame = (Frame) it.next();
                    if (frame instanceof Frame.Binary) {
                        webSocket.send(ByteString.INSTANCE.of(frame.getData(), 0, frame.getData().length));
                    } else {
                        if (!(frame instanceof Frame.Text)) {
                            if (!(frame instanceof Frame.Close)) {
                                throw new UnsupportedFrameTypeException(frame);
                            }
                            CloseReason reason = FrameCommonKt.readReason((Frame.Close) frame);
                            reason.getClass();
                            if (!OkHttpWebsocketSessionKt.isReserved(reason)) {
                                closeReason = reason;
                            }
                            Unit unit = Unit.INSTANCE;
                            try {
                                webSocket.close(closeReason.getCode(), closeReason.getMessage());
                                return unit;
                            } finally {
                            }
                        }
                        webSocket.send(new String(frame.getData(), Charsets.UTF_8));
                    }
                    this.L$0 = webSocket;
                    this.L$1 = closeReason;
                    this.L$2 = it;
                    this.label = 2;
                    obj = it.hasNext(this);
                } catch (Throwable th) {
                    th = th;
                    try {
                        webSocket.close(closeReason.getCode(), closeReason.getMessage());
                        throw th;
                    } finally {
                    }
                }
            }
            it = actorScope.getChannel().iterator();
            webSocket = webSocketNewWebSocket;
            this.L$0 = webSocket;
            this.L$1 = closeReason;
            this.L$2 = it;
            this.label = 2;
            obj = it.hasNext(this);
        } catch (Throwable th2) {
            th = th2;
            webSocket = webSocketNewWebSocket;
            webSocket.close(closeReason.getCode(), closeReason.getMessage());
            throw th;
        }
        webSocketNewWebSocket = factory.newWebSocket(request, (WebSocketListener) obj);
        closeReason = OkHttpWebsocketSessionKt.DEFAULT_CLOSE_REASON_ERROR;
    }
}
