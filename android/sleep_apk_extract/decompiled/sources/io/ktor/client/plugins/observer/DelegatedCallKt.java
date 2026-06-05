package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/client/call/HttpClientCall;", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "block", "wrapWithContent", "(Lio/ktor/client/call/HttpClientCall;Lkotlin/jvm/functions/Function0;)Lio/ktor/client/call/HttpClientCall;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class DelegatedCallKt {
    public static final HttpClientCall wrapWithContent(HttpClientCall httpClientCall, Function0<? extends ByteReadChannel> function0) {
        httpClientCall.getClass();
        function0.getClass();
        return new DelegatedCall(httpClientCall.getClient(), function0, httpClientCall, null, 8, null);
    }
}
