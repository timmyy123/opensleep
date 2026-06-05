package org.eclipse.californium.core.network.serialization;

import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.Token;

/* JADX INFO: loaded from: classes5.dex */
public class MessageHeader {
    private final int bodyLength;
    private final int code;
    private final int mid;
    private final Token token;
    private final CoAP.Type type;
    private final int version;

    public MessageHeader(int i, CoAP.Type type, Token token, int i2, int i3, int i4) {
        this.version = i;
        this.type = type;
        this.token = token;
        this.code = i2;
        this.mid = i3;
        this.bodyLength = i4;
    }

    public int getBodyLength() {
        int i = this.bodyLength;
        if (i >= 0) {
            return i;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("body length not available!");
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public int getMID() {
        return this.mid;
    }

    public Token getToken() {
        return this.token;
    }

    public CoAP.Type getType() {
        return this.type;
    }
}
