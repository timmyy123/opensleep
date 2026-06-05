package io.ktor.client.network.sockets;

import java.net.SocketTimeoutException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007*\f\b\u0000\u0010\t\"\u00020\b2\u00020\b*\n\u0010\u0006\"\u00020\u00042\u00020\u0004¨\u0006\n"}, d2 = {"", "message", "", "cause", "Ljava/net/SocketTimeoutException;", "Lio/ktor/client/network/sockets/SocketTimeoutException;", "SocketTimeoutException", "(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/net/SocketTimeoutException;", "Ljava/io/InterruptedIOException;", "InterruptedIOException", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class TimeoutExceptionsKt {
    public static final SocketTimeoutException SocketTimeoutException(String str, Throwable th) {
        str.getClass();
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException(str);
        socketTimeoutException.initCause(th);
        return socketTimeoutException;
    }
}
