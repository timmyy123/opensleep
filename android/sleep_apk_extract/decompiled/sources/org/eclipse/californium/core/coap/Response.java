package org.eclipse.californium.core.coap;

import androidx.fragment.app.Fragment$$ExternalSyntheticBUOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.coap.CoAP;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class Response extends Message {
    private final CoAP.ResponseCode code;
    private volatile Long rtt;

    public Response(CoAP.ResponseCode responseCode) {
        if (responseCode != null) {
            this.code = responseCode;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("ResponseCode must not be null!");
            throw null;
        }
    }

    public static Response createResponse(Request request, CoAP.ResponseCode responseCode) {
        if (request == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("received request must not be null!");
            return null;
        }
        if (request.getSourceContext() == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("received request must contain a source context.");
            return null;
        }
        Response response = new Response(responseCode);
        response.setDestinationContext(request.getSourceContext());
        return response;
    }

    public void ensureToken(Token token) {
        Token token2 = getToken();
        if (token2 == null) {
            setToken(token);
        } else {
            if (token2.equals(token)) {
                return;
            }
            Fragment$$ExternalSyntheticBUOutline0.m(token2, "!=", token, ")", "token mismatch! (");
        }
    }

    public CoAP.ResponseCode getCode() {
        return this.code;
    }

    @Override // org.eclipse.californium.core.coap.Message
    public int getRawCode() {
        return this.code.value;
    }

    public boolean hasBlockOption() {
        return getOptions().hasBlock1() || getOptions().hasBlock2();
    }

    public final boolean isClientError() {
        return CoAP.ResponseCode.isClientError(this.code);
    }

    public final boolean isError() {
        return isClientError() || isServerError();
    }

    public boolean isNotification() {
        return getOptions().hasObserve();
    }

    public final boolean isServerError() {
        return CoAP.ResponseCode.isServerError(this.code);
    }

    public void setRTT(long j) {
        this.rtt = Long.valueOf(j);
    }

    public String toString() {
        return toTracingString(this.code.toString());
    }
}
