package org.eclipse.californium.core.network.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.ByteArrayInputStream;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAPMessageFormatException;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Message;
import org.eclipse.californium.core.coap.MessageFormatException;
import org.eclipse.californium.core.coap.Option;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.elements.RawData;
import org.eclipse.californium.elements.util.DatagramReader;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DataParser {
    public static final void assertValidTokenLength(int i) {
        if (i > 8) {
            throw new MessageFormatException(FileInsert$$ExternalSyntheticOutline0.m(i, "Message has invalid token length (> 8)"));
        }
    }

    private static int calculateNextOptionNumber(DatagramReader datagramReader, int i, int i2, Message message) {
        return i + determineValueFromNibble(datagramReader, i2, message);
    }

    private static int determineValueFromNibble(DatagramReader datagramReader, int i, Message message) {
        if (i <= 12) {
            return i;
        }
        if (i == 13) {
            return datagramReader.read(8) + 13;
        }
        if (i == 14) {
            return datagramReader.read(16) + 269;
        }
        throw new CoAPMessageFormatException(FileInsert$$ExternalSyntheticOutline0.m(i, "Message contains illegal option delta/length: "), message.getToken(), message.getMID(), message.getRawCode(), message.isConfirmable());
    }

    public static void parseOptionsAndPayload(DatagramReader datagramReader, Message message) {
        if (datagramReader == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("reader must not be null!");
            return;
        }
        if (message == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("message must not be null!");
            return;
        }
        byte nextByte = 0;
        int iCalculateNextOptionNumber = 0;
        while (datagramReader.bytesAvailable() && (nextByte = datagramReader.readNextByte()) != -1) {
            iCalculateNextOptionNumber = calculateNextOptionNumber(datagramReader, iCalculateNextOptionNumber, (nextByte & 240) >> 4, message);
            int iDetermineValueFromNibble = determineValueFromNibble(datagramReader, nextByte & 15, message);
            if (!datagramReader.bytesAvailable(iDetermineValueFromNibble)) {
                throw new CoAPMessageFormatException(String.format("Message contains option of length %d with only fewer bytes left in the message", Integer.valueOf(iDetermineValueFromNibble)), message.getToken(), message.getMID(), message.getRawCode(), message.isConfirmable());
            }
            try {
                Option option = new Option(iCalculateNextOptionNumber);
                option.setValue(datagramReader.readBytes(iDetermineValueFromNibble));
                if (iCalculateNextOptionNumber == 12) {
                    message.getOptions().setContentFormat(option.getIntegerValue());
                    if (!message.getOptions().hasContentFormat()) {
                        throw new IllegalArgumentException("Content Format option must be between 0 and 65535 (2 bytes) inclusive");
                    }
                } else {
                    message.getOptions().addOption(option);
                }
            } catch (IllegalArgumentException e) {
                throw new CoAPMessageFormatException(e.getMessage(), message.getToken(), message.getMID(), message.getRawCode(), message.isConfirmable());
            }
        }
        if (nextByte != -1) {
            message.setPayload((String) null);
        } else {
            if (!datagramReader.bytesAvailable()) {
                throw new CoAPMessageFormatException("Found payload marker (0xFF) but message contains no payload", message.getToken(), message.getMID(), message.getRawCode(), message.isConfirmable());
            }
            if (!message.isIntendedPayload()) {
                message.setUnintendedPayload();
            }
            message.setPayload(datagramReader.readBytesLeft());
        }
    }

    public abstract MessageHeader parseHeader(DatagramReader datagramReader);

    public final Message parseMessage(byte[] bArr) {
        String message;
        DatagramReader datagramReader = new DatagramReader(new ByteArrayInputStream(bArr));
        MessageHeader header = parseHeader(datagramReader);
        try {
            Message message2 = CoAP.isRequest(header.getCode()) ? parseMessage(datagramReader, header, new Request(CoAP.Code.valueOf(header.getCode()))) : CoAP.isResponse(header.getCode()) ? parseMessage(datagramReader, header, new Response(CoAP.ResponseCode.valueOf(header.getCode()))) : CoAP.isEmptyMessage(header.getCode()) ? parseMessage(datagramReader, header, new EmptyMessage(header.getType())) : null;
            if (message2 != null) {
                message2.setBytes(bArr);
                return message2;
            }
            message = "illegal message code";
        } catch (MessageFormatException e) {
            message = e.getMessage();
        }
        throw new CoAPMessageFormatException(message, header.getToken(), header.getMID(), header.getCode(), CoAP.Type.CON == header.getType());
    }

    public final Message parseMessage(RawData rawData) {
        if (rawData != null) {
            Message message = parseMessage(rawData.getBytes());
            message.setSourceContext(rawData.getEndpointContext());
            message.setNanoTimestamp(rawData.getReceiveNanoTimestamp());
            return message;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("raw-data must not be null!");
        return null;
    }

    public Message parseMessage(DatagramReader datagramReader, MessageHeader messageHeader, Message message) {
        message.setMID(messageHeader.getMID());
        message.setType(messageHeader.getType());
        message.setToken(messageHeader.getToken());
        parseOptionsAndPayload(datagramReader, message);
        return message;
    }
}
