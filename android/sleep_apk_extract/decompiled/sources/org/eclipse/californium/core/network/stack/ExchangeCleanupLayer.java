package org.eclipse.californium.core.network.stack;

import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class ExchangeCleanupLayer extends AbstractLayer {
    static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) ExchangeCleanupLayer.class);
    private final int multicastLifetime;

    public ExchangeCleanupLayer(NetworkConfig networkConfig) {
        this.multicastLifetime = networkConfig.getInt("MAX_SERVER_RESPONSE_DELAY") + networkConfig.getInt("MAX_LATENCY") + networkConfig.getInt("NON_LIFETIME");
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveResponse(Exchange exchange, Response response) {
        if (!exchange.getRequest().isMulticast()) {
            exchange.setComplete();
            exchange.getRequest().onComplete();
        }
        super.receiveResponse(exchange, response);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void sendRequest(Exchange exchange, Request request) {
        if (request.isMulticast()) {
            request.addMessageObserver(new MulticastCleanupMessageObserver(exchange, this.executor, this.multicastLifetime));
        } else {
            request.addMessageObserver(new CleanupMessageObserver(exchange));
        }
        super.sendRequest(exchange, request);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void sendResponse(Exchange exchange, Response response) {
        CoAP.Type type;
        if (!response.isNotification() && ((type = response.getType()) == null || type == CoAP.Type.CON)) {
            response.addMessageObserver(new CleanupMessageObserver(exchange));
        }
        super.sendResponse(exchange, response);
    }
}
