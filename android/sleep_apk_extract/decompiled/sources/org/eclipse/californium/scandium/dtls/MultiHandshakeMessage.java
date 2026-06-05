package org.eclipse.californium.scandium.dtls;

import androidx.appfunctions.AppFunctionException;
import java.net.InetSocketAddress;
import org.eclipse.californium.elements.util.DatagramWriter;

/* JADX INFO: loaded from: classes5.dex */
public class MultiHandshakeMessage extends HandshakeMessage {
    private int count;
    private int length;
    private HandshakeMessage tail;

    public MultiHandshakeMessage(InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
        this.tail = this;
    }

    public void add(HandshakeMessage handshakeMessage) {
        this.tail.setNextHandshakeMessage(handshakeMessage);
        this.tail = handshakeMessage;
        this.length = handshakeMessage.size() + this.length;
        this.count++;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public byte[] fragmentToByteArray() {
        throw new RuntimeException("not supported!");
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public int getMessageLength() {
        return this.length - 12;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage
    public HandshakeType getMessageType() {
        HandshakeMessage nextHandshakeMessage = getNextHandshakeMessage();
        if (nextHandshakeMessage == null) {
            return null;
        }
        return nextHandshakeMessage.getMessageType();
    }

    public int getNumberOfHandshakeMessages() {
        return this.count;
    }

    @Override // org.eclipse.californium.scandium.dtls.HandshakeMessage, org.eclipse.californium.scandium.dtls.DTLSMessage
    public byte[] toByteArray() {
        DatagramWriter datagramWriter = new DatagramWriter(AppFunctionException.ERROR_RESOURCE_NOT_FOUND);
        for (HandshakeMessage nextHandshakeMessage = getNextHandshakeMessage(); nextHandshakeMessage != null; nextHandshakeMessage = nextHandshakeMessage.getNextHandshakeMessage()) {
            nextHandshakeMessage.writeTo(datagramWriter);
        }
        return datagramWriter.toByteArray();
    }
}
