package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ClientKeyExchange extends HandshakeMessage {
    public ClientKeyExchange(InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public final HandshakeType getMessageType() {
        return HandshakeType.CLIENT_KEY_EXCHANGE;
    }
}
