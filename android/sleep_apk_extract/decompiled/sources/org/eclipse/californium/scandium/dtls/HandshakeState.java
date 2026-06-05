package org.eclipse.californium.scandium.dtls;

import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes5.dex */
public class HandshakeState {
    private final ContentType contentType;
    private final HandshakeType handshakeType;
    private final boolean optional;

    private HandshakeState(ContentType contentType, HandshakeType handshakeType, boolean z) {
        this.contentType = contentType;
        this.handshakeType = handshakeType;
        this.optional = z;
    }

    private static String toString(ContentType contentType, HandshakeType handshakeType) {
        if (handshakeType == null) {
            return contentType.name();
        }
        return contentType.name() + MqttTopic.TOPIC_LEVEL_SEPARATOR + handshakeType.name();
    }

    public boolean expect(DTLSMessage dTLSMessage) {
        if (dTLSMessage.getContentType() != this.contentType) {
            return false;
        }
        return !(dTLSMessage instanceof HandshakeMessage) || ((HandshakeMessage) dTLSMessage).getMessageType() == this.handshakeType;
    }

    public boolean isOptional() {
        return this.optional;
    }

    public HandshakeState(HandshakeType handshakeType) {
        this(ContentType.HANDSHAKE, handshakeType, false);
    }

    public HandshakeState(HandshakeType handshakeType, boolean z) {
        this(ContentType.HANDSHAKE, handshakeType, z);
    }

    public HandshakeState(ContentType contentType) {
        this(contentType, null, false);
    }

    public static String toString(DTLSMessage dTLSMessage) {
        if (dTLSMessage instanceof HandshakeMessage) {
            return toString(dTLSMessage.getContentType(), ((HandshakeMessage) dTLSMessage).getMessageType());
        }
        return toString(dTLSMessage.getContentType(), null);
    }

    public String toString() {
        return toString(this.contentType, this.handshakeType);
    }
}
