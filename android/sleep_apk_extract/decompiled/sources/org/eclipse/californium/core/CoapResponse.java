package org.eclipse.californium.core;

import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.Response;

/* JADX INFO: loaded from: classes5.dex */
public class CoapResponse {
    private Response response;

    public CoapResponse(Response response) {
        this.response = response;
    }

    public CoAP.ResponseCode getCode() {
        return this.response.getCode();
    }

    public String getResponseText() {
        return this.response.getPayloadString();
    }

    public boolean isSuccess() {
        return CoAP.ResponseCode.isSuccess(this.response.getCode());
    }
}
