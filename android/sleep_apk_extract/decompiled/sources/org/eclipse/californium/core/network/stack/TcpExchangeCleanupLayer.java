package org.eclipse.californium.core.network.stack;

import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class TcpExchangeCleanupLayer extends AbstractLayer {
    static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) TcpExchangeCleanupLayer.class);

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveResponse(Exchange exchange, Response response) {
        exchange.setComplete();
        exchange.getRequest().onComplete();
        super.receiveResponse(exchange, response);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void sendRequest(Exchange exchange, Request request) {
        request.addMessageObserver(new CleanupMessageObserver(exchange));
        super.sendRequest(exchange, request);
    }
}
