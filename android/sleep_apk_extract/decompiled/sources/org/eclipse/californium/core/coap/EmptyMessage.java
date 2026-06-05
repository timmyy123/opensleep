package org.eclipse.californium.core.coap;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.elements.EndpointContext;

/* JADX INFO: loaded from: classes5.dex */
public class EmptyMessage extends Message {
    public EmptyMessage(CoAP.Type type) {
        super(type);
        setProtectFromOffload();
    }

    public static EmptyMessage newACK(Message message, EndpointContext endpointContext) {
        EmptyMessage emptyMessage = new EmptyMessage(CoAP.Type.ACK);
        emptyMessage.setDestinationContext(endpointContext);
        emptyMessage.setMID(message.getMID());
        return emptyMessage;
    }

    public static EmptyMessage newRST(Message message, EndpointContext endpointContext) {
        EmptyMessage emptyMessage = new EmptyMessage(CoAP.Type.RST);
        emptyMessage.setDestinationContext(endpointContext);
        emptyMessage.setMID(message.getMID());
        return emptyMessage;
    }

    @Override // org.eclipse.californium.core.coap.Message
    public int getRawCode() {
        return 0;
    }

    @Override // org.eclipse.californium.core.coap.Message
    public boolean isIntendedPayload() {
        return false;
    }

    public String toString() {
        String strM;
        String str;
        if (!hasEmptyToken() || getOptions().asSortedList().size() > 0 || getPayloadSize() > 0) {
            String payloadString = getPayloadString();
            if (payloadString == null) {
                strM = "no payload";
            } else {
                int length = payloadString.length();
                if (payloadString.indexOf("\n") != -1) {
                    payloadString = payloadString.substring(0, payloadString.indexOf("\n"));
                }
                if (payloadString.length() > 24) {
                    payloadString = payloadString.substring(0, 20);
                }
                strM = FileInsert$$ExternalSyntheticOutline0.m("\"", payloadString, "\"");
                if (strM.length() != length + 2) {
                    StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(strM, ".. ");
                    sbM.append(strM.length());
                    sbM.append(" bytes");
                    strM = sbM.toString();
                }
            }
            str = " NON-EMPTY: Token=" + getTokenString() + ", " + getOptions() + ", " + strM;
        } else {
            str = "";
        }
        return String.format("%s        MID=%5d%s", getType(), Integer.valueOf(getMID()), str);
    }

    public static EmptyMessage newACK(Message message) {
        return newACK(message, message.getSourceContext());
    }

    public static EmptyMessage newRST(Message message) {
        return newRST(message, message.getSourceContext());
    }
}
