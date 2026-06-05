package org.eclipse.californium.core.network.stack;

import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class TcpAdaptionLayer extends AbstractLayer {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) TcpAdaptionLayer.class);

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
        LOGGER.info("discarding empty message received in TCP mode: {}", emptyMessage);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveRequest(Exchange exchange, Request request) {
        request.setAcknowledged(true);
        upper().receiveRequest(exchange, request);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveResponse(Exchange exchange, Response response) {
        response.setAcknowledged(true);
        upper().receiveResponse(exchange, response);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void sendEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
        if (emptyMessage.isConfirmable()) {
            lower().sendEmptyMessage(exchange, emptyMessage);
        } else if (exchange != null) {
            LOGGER.warn("attempting to send empty message ({}) in TCP mode {}", emptyMessage, exchange, new Throwable());
        } else {
            LOGGER.warn("attempting to send empty message ({}) in TCP mode.", emptyMessage, new Throwable());
        }
    }
}
