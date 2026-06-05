package org.eclipse.californium.core.network.serialization;

import org.eclipse.californium.core.coap.Message;
import org.eclipse.californium.elements.util.DatagramWriter;

/* JADX INFO: loaded from: classes5.dex */
public final class UdpDataSerializer extends DataSerializer {
    @Override // org.eclipse.californium.core.network.serialization.DataSerializer
    public void serializeHeader(DatagramWriter datagramWriter, MessageHeader messageHeader) {
        datagramWriter.write(1, 2);
        datagramWriter.write(messageHeader.getType().value, 2);
        datagramWriter.write(messageHeader.getToken().length(), 4);
        datagramWriter.write(messageHeader.getCode(), 8);
        datagramWriter.write(messageHeader.getMID(), 16);
        datagramWriter.writeBytes(messageHeader.getToken().getBytes());
    }

    @Override // org.eclipse.californium.core.network.serialization.DataSerializer
    public void serializeMessage(DatagramWriter datagramWriter, Message message) {
        serializeHeader(datagramWriter, new MessageHeader(1, message.getType(), message.getToken(), message.getRawCode(), message.getMID(), -1));
        datagramWriter.writeCurrentByte();
        DataSerializer.serializeOptionsAndPayload(datagramWriter, message.getOptions(), message.getPayload());
    }
}
