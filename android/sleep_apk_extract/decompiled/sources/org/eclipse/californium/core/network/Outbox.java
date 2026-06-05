package org.eclipse.californium.core.network;

import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;

/* JADX INFO: loaded from: classes5.dex */
public interface Outbox {
    void sendEmptyMessage(Exchange exchange, EmptyMessage emptyMessage);

    void sendRequest(Exchange exchange, Request request);

    void sendResponse(Exchange exchange, Response response);
}
