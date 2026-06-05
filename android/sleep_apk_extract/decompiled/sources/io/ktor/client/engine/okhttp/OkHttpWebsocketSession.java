package io.ktor.client.engine.okhttp;

import io.ktor.client.plugins.websocket.WebSocketException;
import io.ktor.http.HttpStatusCode;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketExtension;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.Charsets;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.channels.ActorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00102\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001b\u0010\u001fJ'\u0010#\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001dH\u0016¢\u0006\u0004\b#\u0010$J'\u0010%\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001dH\u0016¢\u0006\u0004\b%\u0010$J)\u0010(\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010'\u001a\u00020&2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b*\u0010+J\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010,R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010-R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010.R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010/\u001a\u0004\b0\u00101R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0000028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R \u00105\u001a\b\u0012\u0004\u0012\u00020\u0015028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b5\u00104\u001a\u0004\b6\u00107R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u000209088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00104R&\u0010?\u001a\b\u0012\u0004\u0012\u0002090>8\u0016X\u0096\u0004¢\u0006\u0012\n\u0004\b?\u0010@\u0012\u0004\bC\u0010,\u001a\u0004\bA\u0010BR$\u0010J\u001a\u00020D2\u0006\u0010E\u001a\u00020D8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u0002090K8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010M¨\u0006O"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpWebsocketSession;", "Lio/ktor/websocket/DefaultWebSocketSession;", "Lokhttp3/WebSocketListener;", "Lokhttp3/OkHttpClient;", "engine", "Lokhttp3/WebSocket$Factory;", "webSocketFactory", "Lokhttp3/Request;", "engineRequest", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/WebSocket$Factory;Lokhttp3/Request;Lkotlin/coroutines/CoroutineContext;)V", "", "Lio/ktor/websocket/WebSocketExtension;", "negotiatedExtensions", "", "start", "(Ljava/util/List;)V", "Lokhttp3/WebSocket;", "webSocket", "Lokhttp3/Response;", "response", "onOpen", "(Lokhttp3/WebSocket;Lokhttp3/Response;)V", "Lokio/ByteString;", "bytes", "onMessage", "(Lokhttp3/WebSocket;Lokio/ByteString;)V", "", "text", "(Lokhttp3/WebSocket;Ljava/lang/String;)V", "", "code", "reason", "onClosed", "(Lokhttp3/WebSocket;ILjava/lang/String;)V", "onClosing", "", "t", "onFailure", "(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V", "flush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "()V", "Lokhttp3/OkHttpClient;", "Lokhttp3/WebSocket$Factory;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/CompletableDeferred;", "self", "Lkotlinx/coroutines/CompletableDeferred;", "originResponse", "getOriginResponse$ktor_client_okhttp", "()Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/Frame;", "_incoming", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/websocket/CloseReason;", "_closeReason", "Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing$annotations", "", "_", "getMaxFrameSize", "()J", "setMaxFrameSize", "(J)V", "maxFrameSize", "Lkotlinx/coroutines/channels/ReceiveChannel;", "getIncoming", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "incoming", "ktor-client-okhttp"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OkHttpWebsocketSession extends WebSocketListener implements DefaultWebSocketSession {
    private final CompletableDeferred<CloseReason> _closeReason;
    private final Channel<Frame> _incoming;
    private final CoroutineContext coroutineContext;
    private final OkHttpClient engine;
    private final CompletableDeferred<Response> originResponse;
    private final SendChannel<Frame> outgoing;
    private final CompletableDeferred<OkHttpWebsocketSession> self;
    private final WebSocket.Factory webSocketFactory;

    public OkHttpWebsocketSession(OkHttpClient okHttpClient, WebSocket.Factory factory, Request request, CoroutineContext coroutineContext) {
        okHttpClient.getClass();
        factory.getClass();
        request.getClass();
        coroutineContext.getClass();
        this.engine = okHttpClient;
        this.webSocketFactory = factory;
        this.coroutineContext = coroutineContext;
        this.self = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.originResponse = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this._incoming = ChannelKt.Channel$default(0, null, null, 7, null);
        this._closeReason = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.outgoing = ActorKt.actor$default(this, null, 0, null, null, new OkHttpWebsocketSession$outgoing$1(this, request, null), 15, null);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object flush(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public ReceiveChannel<Frame> getIncoming() {
        return this._incoming;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public long getMaxFrameSize() {
        return Long.MAX_VALUE;
    }

    public final CompletableDeferred<Response> getOriginResponse$ktor_client_okhttp() {
        return this.originResponse;
    }

    @Override // io.ktor.websocket.WebSocketSession
    public SendChannel<Frame> getOutgoing() {
        return this.outgoing;
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int code, String reason) {
        Object objValueOf;
        webSocket.getClass();
        reason.getClass();
        super.onClosed(webSocket, code, reason);
        short s = (short) code;
        this._closeReason.complete(new CloseReason(s, reason));
        SendChannel.close$default(this._incoming, null, 1, null);
        SendChannel<Frame> outgoing = getOutgoing();
        StringBuilder sb = new StringBuilder("WebSocket session closed with code ");
        CloseReason.Codes codesByCode = CloseReason.Codes.INSTANCE.byCode(s);
        if (codesByCode == null || (objValueOf = codesByCode.toString()) == null) {
            objValueOf = Integer.valueOf(code);
        }
        sb.append(objValueOf);
        sb.append('.');
        outgoing.close(new CancellationException(sb.toString()));
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.getClass();
        reason.getClass();
        super.onClosing(webSocket, code, reason);
        short s = (short) code;
        this._closeReason.complete(new CloseReason(s, reason));
        try {
            ChannelsKt.trySendBlocking(getOutgoing(), new Frame.Close(new CloseReason(s, reason)));
        } catch (Throwable unused) {
        }
        SendChannel.close$default(this._incoming, null, 1, null);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        webSocket.getClass();
        t.getClass();
        super.onFailure(webSocket, t, response);
        Integer numValueOf = response != null ? Integer.valueOf(response.getCode()) : null;
        int value = HttpStatusCode.INSTANCE.getUnauthorized().getValue();
        if (numValueOf != null && numValueOf.intValue() == value) {
            this.originResponse.complete(response);
            SendChannel.close$default(this._incoming, null, 1, null);
            SendChannel.close$default(getOutgoing(), null, 1, null);
        } else {
            this.originResponse.completeExceptionally(t);
            this._closeReason.completeExceptionally(t);
            this._incoming.close(t);
            getOutgoing().close(t);
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, String text) {
        webSocket.getClass();
        text.getClass();
        super.onMessage(webSocket, text);
        Channel<Frame> channel = this._incoming;
        byte[] bytes = text.getBytes(Charsets.UTF_8);
        bytes.getClass();
        ChannelsKt.trySendBlocking(channel, new Frame.Text(true, bytes));
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(WebSocket webSocket, Response response) {
        webSocket.getClass();
        response.getClass();
        super.onOpen(webSocket, response);
        this.originResponse.complete(response);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public Object send(Frame frame, Continuation<? super Unit> continuation) {
        return DefaultWebSocketSession.DefaultImpls.send(this, frame, continuation);
    }

    @Override // io.ktor.websocket.WebSocketSession
    public void setMaxFrameSize(long j) {
        throw new WebSocketException("Max frame size switch is not supported in OkHttp engine.");
    }

    @Override // io.ktor.websocket.DefaultWebSocketSession
    public void start(List<? extends WebSocketExtension<?>> negotiatedExtensions) {
        negotiatedExtensions.getClass();
        if (negotiatedExtensions.isEmpty()) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Extensions are not supported.");
    }

    public final void start() {
        this.self.complete(this);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        webSocket.getClass();
        bytes.getClass();
        super.onMessage(webSocket, bytes);
        ChannelsKt.trySendBlocking(this._incoming, new Frame.Binary(true, bytes.toByteArray()));
    }
}
