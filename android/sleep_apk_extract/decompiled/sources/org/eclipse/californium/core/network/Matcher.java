package org.eclipse.californium.core.network;

import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;

/* JADX INFO: loaded from: classes5.dex */
public interface Matcher {
    void receiveEmptyMessage(EmptyMessage emptyMessage, EndpointReceiver endpointReceiver);

    void receiveRequest(Request request, EndpointReceiver endpointReceiver);

    void receiveResponse(Response response, EndpointReceiver endpointReceiver);

    void sendEmptyMessage(Exchange exchange, EmptyMessage emptyMessage);

    void sendRequest(Exchange exchange);

    void sendResponse(Exchange exchange);

    void start();

    void stop();
}
