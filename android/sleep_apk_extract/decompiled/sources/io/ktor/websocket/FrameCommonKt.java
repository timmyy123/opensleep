package io.ktor.websocket;

import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.websocket.Frame;
import java.util.Arrays;
import kotlin.Metadata;
import kotlinx.io.Buffer;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/websocket/Frame;", "", "readBytes", "(Lio/ktor/websocket/Frame;)[B", "Lio/ktor/websocket/Frame$Close;", "Lio/ktor/websocket/CloseReason;", "readReason", "(Lio/ktor/websocket/Frame$Close;)Lio/ktor/websocket/CloseReason;", "ktor-websockets"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class FrameCommonKt {
    public static final byte[] readBytes(Frame frame) {
        frame.getClass();
        byte[] data2 = frame.getData();
        return Arrays.copyOf(data2, data2.length);
    }

    public static final CloseReason readReason(Frame.Close close) {
        close.getClass();
        if (close.getData().length < 2) {
            return null;
        }
        Buffer buffer = new Buffer();
        BytePacketBuilderKt.writeFully$default(buffer, close.getData(), 0, 0, 6, null);
        return new CloseReason(buffer.readShort(), StringsKt.readText$default(buffer, null, 0, 3, null));
    }
}
