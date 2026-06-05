package okhttp3.sse;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lokhttp3/sse/EventSource;", "", "", "cancel", "()V", "Factory", "okhttp-sse"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface EventSource {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lokhttp3/sse/EventSource$Factory;", "", "okhttp-sse"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Factory {
    }

    void cancel();
}
