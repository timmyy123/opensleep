package org.eclipse.californium.core.network;

import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Message;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;

/* JADX INFO: loaded from: classes5.dex */
public interface EndpointReceiver {
    void receiveEmptyMessage(Exchange exchange, EmptyMessage emptyMessage);

    void receiveRequest(Exchange exchange, Request request);

    void receiveResponse(Exchange exchange, Response response);

    void reject(Message message);
}
