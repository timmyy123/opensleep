package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class GenericHandshakeMessage extends HandshakeMessage {
    private final HandshakeType type;

    public GenericHandshakeMessage(HandshakeType handshakeType, InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.type = handshakeType;
    }

    public static GenericHandshakeMessage fromByteArray(HandshakeType handshakeType, InetSocketAddress inetSocketAddress) {
        return new GenericHandshakeMessage(handshakeType, inetSocketAddress);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        byte[] rawMessage = getRawMessage();
        return Arrays.copyOfRange(rawMessage, 12, rawMessage.length);
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return getRawMessage().length - 12;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public HandshakeType getMessageType() {
        return this.type;
    }
}
