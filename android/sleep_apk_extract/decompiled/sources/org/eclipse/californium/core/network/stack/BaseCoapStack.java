package org.eclipse.californium.core.network.stack;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import org.eclipse.californium.core.coap.BlockOption;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Outbox;
import org.eclipse.californium.core.network.stack.Layer;
import org.eclipse.californium.core.server.MessageDeliverer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseCoapStack implements CoapStack {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) BaseCoapStack.class);
    private final StackBottomAdapter bottom;
    private MessageDeliverer deliverer;
    private List<Layer> layers;
    private final Outbox outbox;
    private final StackTopAdapter top;

    public class StackBottomAdapter extends AbstractLayer {
        private StackBottomAdapter() {
        }

        @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
        public void sendEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
            BaseCoapStack.this.outbox.sendEmptyMessage(exchange, emptyMessage);
        }

        @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
        public void sendRequest(Exchange exchange, Request request) {
            BaseCoapStack.this.outbox.sendRequest(exchange, request);
        }

        @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
        public void sendResponse(Exchange exchange, Response response) {
            BaseCoapStack.this.outbox.sendResponse(exchange, response);
            BlockOption block2 = response.getOptions().getBlock2();
            if (block2 == null || !block2.isM()) {
                response.onComplete();
            }
        }
    }

    public class StackTopAdapter extends AbstractLayer {
        private StackTopAdapter() {
        }

        @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
        public void receiveEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
        }

        @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
        public void receiveRequest(Exchange exchange, Request request) {
            if (exchange.getRequest() == null) {
                exchange.setRequest(request);
            }
            if (BaseCoapStack.this.hasDeliverer()) {
                BaseCoapStack.this.deliverer.deliverRequest(exchange);
            } else {
                BaseCoapStack.LOGGER.error("Top of CoAP stack has no deliverer to deliver request");
            }
        }

        @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
        public void receiveResponse(Exchange exchange, Response response) {
            if (BaseCoapStack.this.hasDeliverer()) {
                BaseCoapStack.this.deliverer.deliverResponse(exchange, response);
            } else {
                BaseCoapStack.LOGGER.error("Top of CoAP stack has no deliverer to deliver response");
            }
        }

        @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
        public void sendRequest(Exchange exchange, Request request) {
            exchange.setRequest(request);
            lower().sendRequest(exchange, request);
        }

        @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
        public void sendResponse(Exchange exchange, Response response) {
            exchange.setResponse(response);
            lower().sendResponse(exchange, response);
        }
    }

    public BaseCoapStack(Outbox outbox) {
        this.top = new StackTopAdapter();
        this.bottom = new StackBottomAdapter();
        this.outbox = outbox;
    }

    @Override // org.eclipse.californium.core.network.stack.CoapStack
    public final boolean hasDeliverer() {
        return this.deliverer != null;
    }

    @Override // org.eclipse.californium.core.network.stack.CoapStack
    public void receiveEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
        this.bottom.receiveEmptyMessage(exchange, emptyMessage);
    }

    @Override // org.eclipse.californium.core.network.stack.CoapStack
    public void receiveRequest(Exchange exchange, Request request) {
        this.bottom.receiveRequest(exchange, request);
    }

    @Override // org.eclipse.californium.core.network.stack.CoapStack
    public void receiveResponse(Exchange exchange, Response response) {
        this.bottom.receiveResponse(exchange, response);
    }

    @Override // org.eclipse.californium.core.network.stack.CoapStack
    public void sendEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
        try {
            this.top.sendEmptyMessage(exchange, emptyMessage);
        } catch (RuntimeException e) {
            LOGGER.warn("error send empty message {}", emptyMessage, e);
            emptyMessage.setSendError(e);
        }
    }

    @Override // org.eclipse.californium.core.network.stack.CoapStack
    public void sendRequest(Exchange exchange, Request request) {
        try {
            this.top.sendRequest(exchange, request);
        } catch (RuntimeException e) {
            LOGGER.warn("error send request {}", request, e);
            request.setSendError(e);
        }
    }

    @Override // org.eclipse.californium.core.network.stack.CoapStack
    public final void setDeliverer(MessageDeliverer messageDeliverer) {
        this.deliverer = messageDeliverer;
    }

    @Override // org.eclipse.californium.core.network.stack.CoapStack
    public final void setExecutors(ScheduledExecutorService scheduledExecutorService, ScheduledExecutorService scheduledExecutorService2) {
        Iterator<Layer> it = this.layers.iterator();
        while (it.hasNext()) {
            it.next().setExecutors(scheduledExecutorService, scheduledExecutorService2);
        }
    }

    public final void setLayers(Layer[] layerArr) {
        Layer.TopDownBuilder topDownBuilderAdd = new Layer.TopDownBuilder().add(this.top);
        for (Layer layer : layerArr) {
            topDownBuilderAdd.add(layer);
        }
        topDownBuilderAdd.add(this.bottom);
        this.layers = topDownBuilderAdd.create();
    }

    @Override // org.eclipse.californium.core.network.stack.CoapStack
    public void start() {
        Iterator<Layer> it = this.layers.iterator();
        while (it.hasNext()) {
            it.next().start();
        }
    }
}
