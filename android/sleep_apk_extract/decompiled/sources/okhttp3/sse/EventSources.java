package okhttp3.sse;

import kotlin.Metadata;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.Util$$ExternalSyntheticLambda2;
import okhttp3.internal.sse.RealEventSource;
import okhttp3.sse.EventSource;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/sse/EventSources;", "", "<init>", "()V", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/sse/EventSource$Factory;", "createFactory", "(Lokhttp3/OkHttpClient;)Lokhttp3/sse/EventSource$Factory;", "okhttp-sse"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EventSources {
    public static final EventSources INSTANCE = new EventSources();

    private EventSources() {
    }

    public static final EventSource.Factory createFactory(OkHttpClient client) {
        client.getClass();
        return new Util$$ExternalSyntheticLambda2(client, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventSource createFactory$lambda$1(OkHttpClient okHttpClient, Request request, EventSourceListener eventSourceListener) {
        okHttpClient.getClass();
        request.getClass();
        eventSourceListener.getClass();
        if (request.header("Accept") == null) {
            request = request.newBuilder().addHeader("Accept", "text/event-stream").build();
        }
        RealEventSource realEventSource = new RealEventSource(request, eventSourceListener);
        realEventSource.connect(okHttpClient);
        return realEventSource;
    }
}
