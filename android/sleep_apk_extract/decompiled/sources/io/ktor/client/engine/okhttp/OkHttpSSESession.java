package io.ktor.client.engine.okhttp;

import io.ktor.client.plugins.sse.SSEClientException;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.sse.ServerSentEvent;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.SendChannel;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util$$ExternalSyntheticLambda2;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import okhttp3.sse.EventSources;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R \u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0&8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpSSESession;", "", "Lokhttp3/sse/EventSourceListener;", "Lokhttp3/OkHttpClient;", "engine", "Lokhttp3/Request;", "engineRequest", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Lkotlin/coroutines/CoroutineContext;)V", "Lokhttp3/Response;", "response", "Lio/ktor/client/plugins/sse/SSEClientException;", "mapException", "(Lokhttp3/Response;)Lio/ktor/client/plugins/sse/SSEClientException;", "Lokhttp3/sse/EventSource;", "eventSource", "", "onOpen", "(Lokhttp3/sse/EventSource;Lokhttp3/Response;)V", "", "id", "type", "data", "onEvent", "(Lokhttp3/sse/EventSource;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "t", "onFailure", "(Lokhttp3/sse/EventSource;Ljava/lang/Throwable;Lokhttp3/Response;)V", "onClosed", "(Lokhttp3/sse/EventSource;)V", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "serverSentEventsSource", "Lokhttp3/sse/EventSource;", "Lkotlinx/coroutines/CompletableDeferred;", "originResponse", "Lkotlinx/coroutines/CompletableDeferred;", "getOriginResponse$ktor_client_okhttp", "()Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/channels/Channel;", "Lio/ktor/sse/ServerSentEvent;", "_incoming", "Lkotlinx/coroutines/channels/Channel;", "ktor-client-okhttp"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OkHttpSSESession extends EventSourceListener implements CoroutineScope {
    private final Channel<ServerSentEvent> _incoming;
    private final CoroutineContext coroutineContext;
    private final CompletableDeferred<Response> originResponse;
    private final EventSource serverSentEventsSource;

    public OkHttpSSESession(OkHttpClient okHttpClient, Request request, CoroutineContext coroutineContext) {
        okHttpClient.getClass();
        request.getClass();
        coroutineContext.getClass();
        this.coroutineContext = coroutineContext;
        this.serverSentEventsSource = EventSources.createFactory$lambda$1((OkHttpClient) ((Util$$ExternalSyntheticLambda2) EventSources.createFactory(okHttpClient)).f$0, request, this);
        this.originResponse = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this._incoming = ChannelKt.Channel$default(8, null, null, 6, null);
    }

    private final SSEClientException mapException(Response response) {
        ContentType contentType;
        if (response == null) {
            return mapException$unexpectedError();
        }
        int code = response.getCode();
        HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
        if (code != companion.getOK().getValue()) {
            return new SSEClientException(null, null, "Expected status code " + companion.getOK().getValue() + " but was " + response.getCode(), 3, null);
        }
        Headers headers = response.getHeaders();
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        String str = headers.get(httpHeaders.getContentType());
        ContentType contentTypeWithoutParameters = (str == null || (contentType = ContentType.INSTANCE.parse(str)) == null) ? null : contentType.withoutParameters();
        ContentType.Text text = ContentType.Text.INSTANCE;
        if (Intrinsics.areEqual(contentTypeWithoutParameters, text.getEventStream())) {
            return mapException$unexpectedError();
        }
        return new SSEClientException(null, null, "Content type must be " + text.getEventStream() + " but was " + response.getHeaders().get(httpHeaders.getContentType()), 3, null);
    }

    private static final SSEClientException mapException$unexpectedError() {
        return new SSEClientException(null, null, "Unexpected error occurred in OkHttpSSESession", 3, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final CompletableDeferred<Response> getOriginResponse$ktor_client_okhttp() {
        return this.originResponse;
    }

    @Override // okhttp3.sse.EventSourceListener
    public void onClosed(EventSource eventSource) {
        eventSource.getClass();
        SendChannel.close$default(this._incoming, null, 1, null);
        this.serverSentEventsSource.cancel();
    }

    @Override // okhttp3.sse.EventSourceListener
    public void onEvent(EventSource eventSource, String id, String type, String data2) {
        eventSource.getClass();
        data2.getClass();
        ChannelsKt.trySendBlocking(this._incoming, new ServerSentEvent(data2, type, id, null, null, 24, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    @Override // okhttp3.sse.EventSourceListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFailure(EventSource eventSource, Throwable t, Response response) {
        SSEClientException sSEClientExceptionMapException;
        Headers headers;
        eventSource.getClass();
        Integer numValueOf = response != null ? Integer.valueOf(response.getCode()) : null;
        String str = (response == null || (headers = response.getHeaders()) == null) ? null : headers.get(HttpHeaders.INSTANCE.getContentType());
        if (response != null) {
            int value = HttpStatusCode.INSTANCE.getOK().getValue();
            if (numValueOf != null && numValueOf.intValue() == value && Intrinsics.areEqual(str, ContentType.Text.INSTANCE.getEventStream().toString())) {
                if (t != null) {
                    sSEClientExceptionMapException = new SSEClientException(null, t, "Exception during OkHttpSSESession: " + t.getMessage(), 1, null);
                } else {
                    sSEClientExceptionMapException = mapException(response);
                }
                this.originResponse.completeExceptionally(sSEClientExceptionMapException);
            } else {
                this.originResponse.complete(response);
            }
        }
        SendChannel.close$default(this._incoming, null, 1, null);
        this.serverSentEventsSource.cancel();
    }

    @Override // okhttp3.sse.EventSourceListener
    public void onOpen(EventSource eventSource, Response response) {
        eventSource.getClass();
        response.getClass();
        this.originResponse.complete(response);
    }
}
