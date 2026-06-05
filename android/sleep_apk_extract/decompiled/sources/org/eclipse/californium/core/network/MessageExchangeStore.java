package org.eclipse.californium.core.network;

import java.util.concurrent.ScheduledExecutorService;
import org.eclipse.californium.core.coap.Message;

/* JADX INFO: loaded from: classes5.dex */
public interface MessageExchangeStore {
    int assignMessageId(Message message);

    Exchange find(KeyMID keyMID);

    Exchange findPrevious(KeyMID keyMID, Exchange exchange);

    Exchange get(KeyMID keyMID);

    Exchange get(KeyToken keyToken);

    boolean registerOutboundRequest(Exchange exchange);

    boolean registerOutboundRequestWithTokenOnly(Exchange exchange);

    boolean registerOutboundResponse(Exchange exchange);

    Exchange remove(KeyMID keyMID, Exchange exchange);

    void remove(KeyToken keyToken, Exchange exchange);

    boolean replacePrevious(KeyMID keyMID, Exchange exchange, Exchange exchange2);

    void setExecutor(ScheduledExecutorService scheduledExecutorService);

    void start();

    void stop();
}
