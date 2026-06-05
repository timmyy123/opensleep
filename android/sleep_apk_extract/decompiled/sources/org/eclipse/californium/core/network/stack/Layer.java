package org.eclipse.californium.core.network.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;

/* JADX INFO: loaded from: classes5.dex */
public interface Layer {

    public static final class TopDownBuilder {
        private Layer bottom;
        private final List<Layer> stack = new ArrayList();

        public TopDownBuilder add(Layer layer) {
            Layer layer2 = this.bottom;
            if (layer2 != null) {
                layer2.setLowerLayer(layer);
            }
            this.stack.add(layer);
            this.bottom = layer;
            return this;
        }

        public List<Layer> create() {
            return Collections.unmodifiableList(new ArrayList(this.stack));
        }
    }

    void receiveEmptyMessage(Exchange exchange, EmptyMessage emptyMessage);

    void receiveRequest(Exchange exchange, Request request);

    void receiveResponse(Exchange exchange, Response response);

    void sendEmptyMessage(Exchange exchange, EmptyMessage emptyMessage);

    void sendRequest(Exchange exchange, Request request);

    void sendResponse(Exchange exchange, Response response);

    void setExecutors(ScheduledExecutorService scheduledExecutorService, ScheduledExecutorService scheduledExecutorService2);

    void setLowerLayer(Layer layer);

    void setUpperLayer(Layer layer);

    void start();
}
