package org.eclipse.californium.core.network.stack;

import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class ObserveLayer extends AbstractLayer {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) ObserveLayer.class);

    public ObserveLayer(NetworkConfig networkConfig) {
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
        if (emptyMessage.getType() == CoAP.Type.RST && exchange.getOrigin() == Exchange.Origin.REMOTE) {
            exchange.getRelation();
        }
        upper().receiveEmptyMessage(exchange, emptyMessage);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveResponse(Exchange exchange, Response response) {
        if (!response.isNotification() || !exchange.getRequest().isCanceled()) {
            upper().receiveResponse(exchange, response);
        } else {
            LOGGER.debug("rejecting notification for canceled Exchange");
            sendEmptyMessage(exchange, EmptyMessage.newRST(response));
        }
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void sendResponse(Exchange exchange, Response response) {
        exchange.getRelation();
        lower().sendResponse(exchange, response);
    }
}
