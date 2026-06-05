package org.eclipse.californium.core.network.stack;

import java.util.concurrent.ScheduledExecutorService;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractLayer implements Layer {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) AbstractLayer.class);
    protected ScheduledExecutorService executor;
    protected ScheduledExecutorService secondaryExecutor;
    private Layer upperLayer = LogOnlyLayer.getInstance();
    private Layer lowerLayer = LogOnlyLayer.getInstance();

    public static final class LogOnlyLayer implements Layer {
        private static final LogOnlyLayer INSTANCE = new LogOnlyLayer();

        public static LogOnlyLayer getInstance() {
            return INSTANCE;
        }

        @Override // org.eclipse.californium.core.network.stack.Layer
        public void receiveEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
            AbstractLayer.LOGGER.error("No lower layer set for receiving empty message [{}]", emptyMessage);
        }

        @Override // org.eclipse.californium.core.network.stack.Layer
        public void receiveRequest(Exchange exchange, Request request) {
            AbstractLayer.LOGGER.error("No upper layer set for receiving request [{}]", request);
        }

        @Override // org.eclipse.californium.core.network.stack.Layer
        public void receiveResponse(Exchange exchange, Response response) {
            AbstractLayer.LOGGER.error("No lower layer set for receiving response [{}]", response);
        }

        @Override // org.eclipse.californium.core.network.stack.Layer
        public void sendEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
            AbstractLayer.LOGGER.error("No lower layer set for sending empty message [{}]", emptyMessage);
        }

        @Override // org.eclipse.californium.core.network.stack.Layer
        public void sendRequest(Exchange exchange, Request request) {
            AbstractLayer.LOGGER.error("No lower layer set for sending request [{}]", request);
        }

        @Override // org.eclipse.californium.core.network.stack.Layer
        public void sendResponse(Exchange exchange, Response response) {
            AbstractLayer.LOGGER.error("No lower layer set for sending response [{}]", response);
        }

        @Override // org.eclipse.californium.core.network.stack.Layer
        public void setExecutors(ScheduledExecutorService scheduledExecutorService, ScheduledExecutorService scheduledExecutorService2) {
        }

        @Override // org.eclipse.californium.core.network.stack.Layer
        public void setLowerLayer(Layer layer) {
        }

        @Override // org.eclipse.californium.core.network.stack.Layer
        public void setUpperLayer(Layer layer) {
        }

        @Override // org.eclipse.californium.core.network.stack.Layer
        public void start() {
        }
    }

    public final Layer lower() {
        return this.lowerLayer;
    }

    @Override // org.eclipse.californium.core.network.stack.Layer
    public void receiveEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
        this.upperLayer.receiveEmptyMessage(exchange, emptyMessage);
    }

    @Override // org.eclipse.californium.core.network.stack.Layer
    public void receiveRequest(Exchange exchange, Request request) {
        this.upperLayer.receiveRequest(exchange, request);
    }

    @Override // org.eclipse.californium.core.network.stack.Layer
    public void receiveResponse(Exchange exchange, Response response) {
        this.upperLayer.receiveResponse(exchange, response);
    }

    @Override // org.eclipse.californium.core.network.stack.Layer
    public void sendEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
        this.lowerLayer.sendEmptyMessage(exchange, emptyMessage);
    }

    @Override // org.eclipse.californium.core.network.stack.Layer
    public void sendRequest(Exchange exchange, Request request) {
        this.lowerLayer.sendRequest(exchange, request);
    }

    @Override // org.eclipse.californium.core.network.stack.Layer
    public void sendResponse(Exchange exchange, Response response) {
        this.lowerLayer.sendResponse(exchange, response);
    }

    @Override // org.eclipse.californium.core.network.stack.Layer
    public final void setExecutors(ScheduledExecutorService scheduledExecutorService, ScheduledExecutorService scheduledExecutorService2) {
        this.executor = scheduledExecutorService;
        this.secondaryExecutor = scheduledExecutorService2;
    }

    @Override // org.eclipse.californium.core.network.stack.Layer
    public final void setLowerLayer(Layer layer) {
        Layer layer2 = this.lowerLayer;
        if (layer2 != layer) {
            if (layer2 != null) {
                layer2.setUpperLayer(null);
            }
            this.lowerLayer = layer;
            layer.setUpperLayer(this);
        }
    }

    @Override // org.eclipse.californium.core.network.stack.Layer
    public final void setUpperLayer(Layer layer) {
        Layer layer2 = this.upperLayer;
        if (layer2 != layer) {
            if (layer2 != null) {
                layer2.setLowerLayer(null);
            }
            this.upperLayer = layer;
            layer.setLowerLayer(this);
        }
    }

    @Override // org.eclipse.californium.core.network.stack.Layer
    public void start() {
    }

    public final Layer upper() {
        return this.upperLayer;
    }
}
