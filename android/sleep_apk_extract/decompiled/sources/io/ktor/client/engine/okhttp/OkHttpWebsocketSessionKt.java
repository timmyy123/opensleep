package io.ktor.client.engine.okhttp;

import io.ktor.websocket.CloseReason;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lio/ktor/websocket/CloseReason;", "", "isReserved", "(Lio/ktor/websocket/CloseReason;)Z", "DEFAULT_CLOSE_REASON_ERROR", "Lio/ktor/websocket/CloseReason;", "ktor-client-okhttp"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class OkHttpWebsocketSessionKt {
    private static final CloseReason DEFAULT_CLOSE_REASON_ERROR = new CloseReason(CloseReason.Codes.INTERNAL_ERROR, "Client failure");

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isReserved(CloseReason closeReason) {
        CloseReason.Codes codesByCode = CloseReason.Codes.INSTANCE.byCode(closeReason.getCode());
        return codesByCode == null || codesByCode == CloseReason.Codes.CLOSED_ABNORMALLY;
    }
}
