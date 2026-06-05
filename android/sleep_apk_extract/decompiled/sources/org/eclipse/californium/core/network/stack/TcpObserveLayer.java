package org.eclipse.californium.core.network.stack;

import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class TcpObserveLayer extends AbstractLayer {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) TcpObserveLayer.class);
    private static final Integer CANCEL = 1;

    public TcpObserveLayer(NetworkConfig networkConfig) {
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveResponse(Exchange exchange, Response response) {
        if (response.getOptions().hasObserve() && exchange.getRequest().isCanceled()) {
            LOGGER.debug("ignoring notification for canceled TCP Exchange");
        } else {
            upper().receiveResponse(exchange, response);
        }
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void sendRequest(Exchange exchange, Request request) {
        CANCEL.equals(request.getOptions().getObserve());
        lower().sendRequest(exchange, request);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void sendResponse(Exchange exchange, Response response) {
        exchange.getRelation();
        lower().sendResponse(exchange, response);
    }
}
