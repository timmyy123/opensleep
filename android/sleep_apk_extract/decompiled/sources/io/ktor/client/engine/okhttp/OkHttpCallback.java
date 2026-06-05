package io.ktor.client.engine.okhttp;

import io.ktor.client.request.HttpRequestData;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpCallback;", "Lokhttp3/Callback;", "Lio/ktor/client/request/HttpRequestData;", "requestData", "Lkotlinx/coroutines/CancellableContinuation;", "Lokhttp3/Response;", "continuation", "<init>", "(Lio/ktor/client/request/HttpRequestData;Lkotlinx/coroutines/CancellableContinuation;)V", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "(Lokhttp3/Call;Ljava/io/IOException;)V", "response", "onResponse", "(Lokhttp3/Call;Lokhttp3/Response;)V", "Lio/ktor/client/request/HttpRequestData;", "Lkotlinx/coroutines/CancellableContinuation;", "ktor-client-okhttp"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class OkHttpCallback implements Callback {
    private final CancellableContinuation<Response> continuation;
    private final HttpRequestData requestData;

    /* JADX WARN: Multi-variable type inference failed */
    public OkHttpCallback(HttpRequestData httpRequestData, CancellableContinuation<? super Response> cancellableContinuation) {
        httpRequestData.getClass();
        cancellableContinuation.getClass();
        this.requestData = httpRequestData;
        this.continuation = cancellableContinuation;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e) {
        call.getClass();
        e.getClass();
        if (this.continuation.isCancelled()) {
            return;
        }
        CancellableContinuation<Response> cancellableContinuation = this.continuation;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m2357constructorimpl(ResultKt.createFailure(OkUtilsKt.mapOkHttpException(this.requestData, e))));
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        call.getClass();
        response.getClass();
        if (call.getCanceled()) {
            return;
        }
        this.continuation.resumeWith(Result.m2357constructorimpl(response));
    }
}
