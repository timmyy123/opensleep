package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import org.eclipse.californium.elements.util.Bytes;

/* JADX INFO: loaded from: classes5.dex */
public final class ServerHelloDone extends HandshakeMessage {
    public ServerHelloDone(InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        return Bytes.EMPTY;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return 0;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public HandshakeType getMessageType() {
        return HandshakeType.SERVER_HELLO_DONE;
    }
}
