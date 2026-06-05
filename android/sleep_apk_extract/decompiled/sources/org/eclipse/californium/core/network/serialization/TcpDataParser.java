package org.eclipse.californium.core.network.serialization;

import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MessageFormatException;
import org.eclipse.californium.core.coap.Token;
import org.eclipse.californium.elements.util.DatagramReader;

/* JADX INFO: loaded from: classes5.dex */
public final class TcpDataParser extends DataParser {
    @Override // org.eclipse.californium.core.network.serialization.DataParser
    public MessageHeader parseHeader(DatagramReader datagramReader) {
        if (!datagramReader.bytesAvailable(1)) {
            throw new MessageFormatException("TCP Message too short! " + (datagramReader.bitsLeft() / 8) + " must be at least 1 byte!");
        }
        int i = datagramReader.read(4);
        int i2 = datagramReader.read(4);
        DataParser.assertValidTokenLength(i2);
        int i3 = i != 13 ? i == 14 ? 2 : i == 15 ? 4 : 0 : 1;
        int i4 = i3 + 1 + i2;
        if (datagramReader.bytesAvailable(i4)) {
            datagramReader.readBytes(i3);
            return new MessageHeader(1, CoAP.Type.CON, Token.fromProvider(datagramReader.readBytes(i2)), datagramReader.read(8), -1, 0);
        }
        throw new MessageFormatException("TCP Message too short! " + (datagramReader.bitsLeft() / 8) + " must be at least " + i4 + " bytes!");
    }
}
