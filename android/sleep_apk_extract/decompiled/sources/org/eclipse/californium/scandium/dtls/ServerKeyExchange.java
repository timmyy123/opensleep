package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ServerKeyExchange extends HandshakeMessage {
    public ServerKeyExchange(InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public final HandshakeType getMessageType() {
        return HandshakeType.SERVER_KEY_EXCHANGE;
    }
}
