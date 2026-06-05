package org.eclipse.californium.core.network.serialization;

import org.eclipse.californium.elements.util.DatagramWriter;

/* JADX INFO: loaded from: classes5.dex */
public final class TcpDataSerializer extends DataSerializer {
    @Override // org.eclipse.californium.core.network.serialization.DataSerializer
    public void serializeHeader(DatagramWriter datagramWriter, MessageHeader messageHeader) {
        if (messageHeader.getBodyLength() < 13) {
            datagramWriter.write(messageHeader.getBodyLength(), 4);
            datagramWriter.write(messageHeader.getToken().length(), 4);
        } else if (messageHeader.getBodyLength() < 269) {
            datagramWriter.write(13, 4);
            datagramWriter.write(messageHeader.getToken().length(), 4);
            datagramWriter.write(messageHeader.getBodyLength() - 13, 8);
        } else if (messageHeader.getBodyLength() < 65805) {
            datagramWriter.write(14, 4);
            datagramWriter.write(messageHeader.getToken().length(), 4);
            datagramWriter.write(messageHeader.getBodyLength() - 269, 16);
        } else {
            datagramWriter.write(15, 4);
            datagramWriter.write(messageHeader.getToken().length(), 4);
            datagramWriter.write(messageHeader.getBodyLength() - 65805, 32);
        }
        datagramWriter.write(messageHeader.getCode(), 8);
        datagramWriter.writeBytes(messageHeader.getToken().getBytes());
    }
}
