package org.eclipse.californium.core;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.coap.BlockOption;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MessageObserverAdapter;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Endpoint;
import org.eclipse.californium.core.network.EndpointManager;
import org.eclipse.californium.elements.EndpointContext;
import org.eclipse.californium.elements.exception.ConnectorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class CoapClient {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) CoapClient.class);
    private Endpoint endpoint;
    private ExecutorService executor;
    private Long timeout;
    private String uri;
    private final AtomicReference<EndpointContext> destinationContext = new AtomicReference<>();
    private CoAP.Type type = CoAP.Type.CON;
    private int blockwise = 0;

    /* JADX INFO: renamed from: org.eclipse.californium.core.CoapClient$1, reason: invalid class name */
    abstract class AnonymousClass1 implements Runnable {
    }

    public CoapClient(String str) {
        this.uri = str;
    }

    private Request applyRequestType(Request request) {
        request.setType(this.type);
        return request;
    }

    private Request assignClientUriIfEmpty(Request request) {
        EndpointContext endpointContext = this.destinationContext.get();
        if (endpointContext != null && request.getDestinationContext() == null) {
            request.setDestinationContext(endpointContext);
            request.setURI(this.uri);
            return request;
        }
        if (!request.hasURI() && !request.hasProxyURI()) {
            request.setURI(this.uri);
        }
        return request;
    }

    private void asynchronous(Request request, CoapHandler coapHandler) {
        request.addMessageObserver(new MessageObserverImpl(this, coapHandler, request.isMulticast(), null));
        send(request);
    }

    private Request newGet() {
        return applyRequestType(Request.newGet());
    }

    private Request newPost() {
        return applyRequestType(Request.newPost());
    }

    private Request newPut() {
        return applyRequestType(Request.newPut());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestinationContextFromResponse(Response response) {
        if (response != null) {
            AtomicReference<EndpointContext> atomicReference = this.destinationContext;
            EndpointContext sourceContext = response.getSourceContext();
            while (!atomicReference.compareAndSet(null, sourceContext) && atomicReference.get() == null) {
            }
        }
    }

    private CoapResponse synchronous(Request request, Endpoint endpoint) throws ConnectorException, IOException {
        try {
            Long timeout = getTimeout();
            if (timeout == null) {
                timeout = Long.valueOf(endpoint.getConfig().getLong("EXCHANGE_LIFETIME"));
            }
            Response responseWaitForResponse = send(request, endpoint).waitForResponse(timeout.longValue());
            if (responseWaitForResponse != null) {
                if (!request.isMulticast()) {
                    setDestinationContextFromResponse(responseWaitForResponse);
                }
                return new CoapResponse(responseWaitForResponse);
            }
            request.cancel();
            Throwable sendError = request.getSendError();
            if (sendError == null) {
                return null;
            }
            if (sendError instanceof ConnectorException) {
                throw ((ConnectorException) sendError);
            }
            throw new IOException(sendError);
        } catch (InterruptedException e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    public void execute(Runnable runnable) {
        ExecutorService executorService;
        synchronized (this) {
            executorService = this.executor;
        }
        if (executorService == null) {
            runnable.run();
            return;
        }
        try {
            executorService.execute(runnable);
        } catch (RejectedExecutionException unused) {
            if (executorService.isShutdown()) {
                return;
            }
            LOGGER.warn("failed to execute job!");
        }
    }

    public CoapResponse get() {
        Request requestNewGet = newGet();
        assignClientUriIfEmpty(requestNewGet);
        return synchronous(requestNewGet);
    }

    public Endpoint getEffectiveEndpoint(Request request) {
        Endpoint endpoint = getEndpoint();
        return endpoint != null ? endpoint : EndpointManager.getEndpointManager().getDefaultEndpoint(request.getScheme());
    }

    public synchronized Endpoint getEndpoint() {
        return this.endpoint;
    }

    public Long getTimeout() {
        return this.timeout;
    }

    public void post(CoapHandler coapHandler, String str, int i) {
        Request requestNewPost = newPost();
        requestNewPost.setPayload(str);
        requestNewPost.getOptions().setContentFormat(i);
        assignClientUriIfEmpty(requestNewPost);
        asynchronous(requestNewPost, coapHandler);
    }

    public CoapResponse put(String str, int i) {
        Request requestNewPut = newPut();
        requestNewPut.setPayload(str);
        requestNewPut.getOptions().setContentFormat(i);
        assignClientUriIfEmpty(requestNewPut);
        return synchronous(requestNewPut);
    }

    public Request send(Request request, Endpoint endpoint) {
        if (this.blockwise != 0) {
            request.getOptions().setBlock2(new BlockOption(BlockOption.size2Szx(this.blockwise), false, 0));
        }
        endpoint.sendRequest(request);
        return request;
    }

    public CoapClient setEndpoint(Endpoint endpoint) {
        synchronized (this) {
            this.endpoint = endpoint;
        }
        if (!endpoint.isStarted()) {
            try {
                endpoint.start();
                LOGGER.info("started set client endpoint {}", endpoint.getAddress());
                return this;
            } catch (IOException e) {
                LOGGER.error("could not set and start client endpoint", (Throwable) e);
            }
        }
        return this;
    }

    public CoapClient setTimeout(Long l) {
        this.timeout = l;
        return this;
    }

    public CoapClient useCONs() {
        this.type = CoAP.Type.CON;
        return this;
    }

    public CoapClient useNONs() {
        this.type = CoAP.Type.NON;
        return this;
    }

    public class MessageObserverImpl extends MessageObserverAdapter {
        protected final CoapHandler handler;
        private final boolean multicast;

        private MessageObserverImpl(CoapHandler coapHandler, boolean z) {
            this.handler = coapHandler;
            this.multicast = z;
        }

        public void deliver(CoapResponse coapResponse) {
            this.handler.onLoad(coapResponse);
        }

        @Override // org.eclipse.californium.core.coap.MessageObserverAdapter
        public void failed() {
            CoapClient.this.execute(new Runnable() { // from class: org.eclipse.californium.core.CoapClient.MessageObserverImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MessageObserverImpl.this.handler.onError();
                    } catch (Throwable th) {
                        CoapClient.LOGGER.warn("exception while handling failure", th);
                    }
                }
            });
        }

        @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
        public void onResponse(Response response) {
            if (!this.multicast) {
                CoapClient.this.setDestinationContextFromResponse(response);
            }
            succeeded(response != null ? new CoapResponse(response) : null);
        }

        public void succeeded(final CoapResponse coapResponse) {
            CoapClient.this.execute(new Runnable() { // from class: org.eclipse.californium.core.CoapClient.MessageObserverImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MessageObserverImpl.this.deliver(coapResponse);
                    } catch (Throwable th) {
                        CoapClient.LOGGER.warn("exception while handling response", th);
                    }
                }
            });
        }

        public /* synthetic */ MessageObserverImpl(CoapClient coapClient, CoapHandler coapHandler, boolean z, AnonymousClass1 anonymousClass1) {
            this(coapHandler, z);
        }
    }

    public void get(CoapHandler coapHandler) {
        Request requestNewGet = newGet();
        assignClientUriIfEmpty(requestNewGet);
        asynchronous(requestNewGet, coapHandler);
    }

    public Request send(Request request) {
        return send(request, getEffectiveEndpoint(request));
    }

    private CoapResponse synchronous(Request request) {
        return synchronous(request, getEffectiveEndpoint(request));
    }
}
