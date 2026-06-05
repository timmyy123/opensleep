package org.eclipse.californium.core.network.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Message;
import org.eclipse.californium.core.coap.Option;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.elements.MessageCallback;
import org.eclipse.californium.elements.RawData;
import org.eclipse.californium.elements.util.DatagramWriter;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DataSerializer {
    private static int getOptionNibble(int i) {
        if (i <= 12) {
            return i;
        }
        if (i <= 268) {
            return 13;
        }
        if (i <= 65804) {
            return 14;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "Unsupported option delta "));
        return 0;
    }

    public static void serializeOptionsAndPayload(DatagramWriter datagramWriter, OptionSet optionSet, byte[] bArr) {
        if (datagramWriter == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("writer must not be null!");
            return;
        }
        if (optionSet == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("option-set must not be null!");
            return;
        }
        int i = 0;
        for (Option option : optionSet.asSortedList()) {
            byte[] value = option.getValue();
            int number = option.getNumber();
            int i2 = number - i;
            int optionNibble = getOptionNibble(i2);
            datagramWriter.write(optionNibble, 4);
            int length = value.length;
            int optionNibble2 = getOptionNibble(length);
            datagramWriter.write(optionNibble2, 4);
            if (optionNibble == 13) {
                datagramWriter.write(i2 - 13, 8);
            } else if (optionNibble == 14) {
                datagramWriter.write(i2 - 269, 16);
            }
            if (optionNibble2 == 13) {
                datagramWriter.write(length - 13, 8);
            } else if (optionNibble2 == 14) {
                datagramWriter.write(length - 269, 16);
            }
            datagramWriter.writeBytes(value);
            i = number;
        }
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        datagramWriter.writeByte((byte) -1);
        datagramWriter.writeBytes(bArr);
    }

    public final byte[] getByteArray(Message message) {
        if (message == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("message must not be null!");
            return null;
        }
        if (message.getRawCode() != 0) {
            DatagramWriter datagramWriter = new DatagramWriter();
            serializeMessage(datagramWriter, message);
            return datagramWriter.toByteArray();
        }
        if (message.getType() == CoAP.Type.NON) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("NON message must not use code 0 (empty message)!");
            return null;
        }
        if (!message.getToken().isEmpty()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Empty messages must not use a token!");
            return null;
        }
        if (message.getPayloadSize() > 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Empty messages must not contain payload!");
            return null;
        }
        DatagramWriter datagramWriter2 = new DatagramWriter(4);
        serializeEmpytMessage(datagramWriter2, message);
        return datagramWriter2.toByteArray();
    }

    public final RawData serializeEmptyMessage(EmptyMessage emptyMessage, MessageCallback messageCallback) {
        if (emptyMessage == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("empty-message must not be null!");
            return null;
        }
        if (emptyMessage.getBytes() == null) {
            emptyMessage.setBytes(getByteArray(emptyMessage));
        }
        return RawData.outbound(emptyMessage.getBytes(), emptyMessage.getEffectiveDestinationContext(), messageCallback, false);
    }

    public void serializeEmpytMessage(DatagramWriter datagramWriter, Message message) {
        serializeHeader(datagramWriter, new MessageHeader(1, message.getType(), message.getToken(), 0, message.getMID(), 0));
        datagramWriter.writeCurrentByte();
    }

    public abstract void serializeHeader(DatagramWriter datagramWriter, MessageHeader messageHeader);

    public void serializeMessage(DatagramWriter datagramWriter, Message message) {
        DatagramWriter datagramWriter2 = new DatagramWriter();
        serializeOptionsAndPayload(datagramWriter2, message.getOptions(), message.getPayload());
        datagramWriter2.writeCurrentByte();
        serializeHeader(datagramWriter, new MessageHeader(1, message.getType(), message.getToken(), message.getRawCode(), message.getMID(), datagramWriter2.size()));
        datagramWriter.writeCurrentByte();
        datagramWriter.write(datagramWriter2);
    }

    public final RawData serializeRequest(Request request, MessageCallback messageCallback) {
        if (request == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("request must not be null!");
            return null;
        }
        if (request.getBytes() == null) {
            request.setBytes(getByteArray(request));
        }
        return RawData.outbound(request.getBytes(), request.getEffectiveDestinationContext(), messageCallback, request.isMulticast());
    }

    public final RawData serializeResponse(Response response, MessageCallback messageCallback) {
        if (response == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("response must not be null!");
            return null;
        }
        if (response.getBytes() == null) {
            response.setBytes(getByteArray(response));
        }
        return RawData.outbound(response.getBytes(), response.getEffectiveDestinationContext(), messageCallback, false);
    }
}
