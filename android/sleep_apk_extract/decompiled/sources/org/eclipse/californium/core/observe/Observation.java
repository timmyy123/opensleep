package org.eclipse.californium.core.observe;

import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.elements.EndpointContext;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class Observation {
    private final EndpointContext context;
    private final Request request;

    public Observation(Request request, EndpointContext endpointContext) {
        if (request == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("request must not be null");
            throw null;
        }
        if (!request.isObserve()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("request has no observe=0 option");
            throw null;
        }
        this.request = request;
        this.context = endpointContext;
    }

    public EndpointContext getContext() {
        return this.context;
    }

    public Request getRequest() {
        return this.request;
    }

    public String toString() {
        return this.request.toString();
    }
}
