package io.ktor.client;

import io.ktor.client.engine.HttpClientEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0016\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/client/engine/HttpClientEngine;", "engine", "Lkotlin/Function1;", "Lio/ktor/client/HttpClientConfig;", "", "block", "Lio/ktor/client/HttpClient;", "HttpClient", "(Lio/ktor/client/engine/HttpClientEngine;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/HttpClient;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class HttpClientKt {
    public static final HttpClient HttpClient(HttpClientEngine httpClientEngine, Function1<? super HttpClientConfig<?>, Unit> function1) {
        httpClientEngine.getClass();
        function1.getClass();
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        function1.invoke(httpClientConfig);
        return new HttpClient(httpClientEngine, httpClientConfig, false);
    }
}
