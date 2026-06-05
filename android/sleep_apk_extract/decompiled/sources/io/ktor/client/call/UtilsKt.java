package io.ktor.client.call;

import io.ktor.http.HttpMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a)\u0010\u0006\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "contentLength", "bodySize", "Lio/ktor/http/HttpMethod;", "method", "", "checkContentLength", "(Ljava/lang/Long;JLio/ktor/http/HttpMethod;)V", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class UtilsKt {
    public static final void checkContentLength(Long l, long j, HttpMethod httpMethod) {
        httpMethod.getClass();
        if (l == null || l.longValue() < 0 || Intrinsics.areEqual(httpMethod, HttpMethod.INSTANCE.getHead()) || l.longValue() == j) {
            return;
        }
        throw new IllegalStateException("Content-Length mismatch: expected " + l + " bytes, but received " + j + " bytes");
    }
}
