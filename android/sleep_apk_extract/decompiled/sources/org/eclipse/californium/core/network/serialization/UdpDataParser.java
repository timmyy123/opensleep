package org.eclipse.californium.core.network.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAPMessageFormatException;
import org.eclipse.californium.core.coap.MessageFormatException;
import org.eclipse.californium.core.coap.Token;
import org.eclipse.californium.elements.util.DatagramReader;

/* JADX INFO: loaded from: classes5.dex */
public final class UdpDataParser extends DataParser {
    private void assertCorrectVersion(int i) {
        if (i != 1) {
            throw new MessageFormatException(FileInsert$$ExternalSyntheticOutline0.m(i, "Message has invalid version: "));
        }
    }

    @Override // org.eclipse.californium.core.network.serialization.DataParser
    public MessageHeader parseHeader(DatagramReader datagramReader) {
        if (!datagramReader.bytesAvailable(4)) {
            throw new MessageFormatException("UDP Message too short! " + (datagramReader.bitsLeft() / 8) + " must be at least 4 bytes!");
        }
        int i = datagramReader.read(2);
        assertCorrectVersion(i);
        int i2 = datagramReader.read(2);
        int i3 = datagramReader.read(4);
        DataParser.assertValidTokenLength(i3);
        int i4 = datagramReader.read(8);
        int i5 = datagramReader.read(16);
        if (datagramReader.bytesAvailable(i3)) {
            return new MessageHeader(i, CoAP.Type.valueOf(i2), Token.fromProvider(datagramReader.readBytes(i3)), i4, i5, 0);
        }
        throw new CoAPMessageFormatException("UDP Message too short for token! " + (datagramReader.bitsLeft() / 8) + " must be at least " + i3 + " bytes!", null, i5, i4, CoAP.Type.CON.value == i2);
    }
}
