package org.eclipse.californium.core.network.stack;

import org.eclipse.californium.core.coap.InternalMessageObserverAdapter;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class CleanupMessageObserver extends InternalMessageObserverAdapter {
    protected static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) CleanupMessageObserver.class);
    protected final Exchange exchange;

    public CleanupMessageObserver(Exchange exchange) {
        this.exchange = exchange;
    }

    public void complete(String str) {
        if (this.exchange.executeComplete()) {
            boolean zIsOfLocalOrigin = this.exchange.isOfLocalOrigin();
            Exchange exchange = this.exchange;
            if (zIsOfLocalOrigin) {
                Request currentRequest = exchange.getCurrentRequest();
                LOGGER.debug("{}, {} request [MID={}, {}]", str, this.exchange, Integer.valueOf(currentRequest.getMID()), currentRequest.getToken());
            } else {
                Response currentResponse = exchange.getCurrentResponse();
                LOGGER.debug("{}, {} response [MID={}, {}]", str, this.exchange, Integer.valueOf(currentResponse.getMID()), currentResponse.getToken());
            }
        }
    }

    @Override // org.eclipse.californium.core.coap.MessageObserverAdapter
    public void failed() {
        complete("failed");
    }

    @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
    public void onCancel() {
        complete("canceled");
    }
}
