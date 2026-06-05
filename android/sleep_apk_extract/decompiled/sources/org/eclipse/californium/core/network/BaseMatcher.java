package org.eclipse.californium.core.network;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.InternalMessageObserverAdapter;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.coap.Token;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.TokenGenerator;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.observe.NotificationListener;
import org.eclipse.californium.core.observe.Observation;
import org.eclipse.californium.core.observe.ObservationStore;
import org.eclipse.californium.elements.EndpointContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseMatcher implements Matcher {
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) BaseMatcher.class);
    protected final NetworkConfig config;
    protected final MessageExchangeStore exchangeStore;
    protected final Executor executor;
    private final NotificationListener notificationListener;
    protected final ObservationStore observationStore;
    protected boolean running = false;
    protected final TokenGenerator tokenGenerator;

    public class ObservationObserverAdapter extends InternalMessageObserverAdapter {
        protected final AtomicBoolean removed = new AtomicBoolean();
        protected final Token token;

        public ObservationObserverAdapter(Token token) {
            this.token = token;
        }

        @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
        public void onResponse(Response response) {
            if (BaseMatcher.this.observationStore.get(this.token) != null) {
                if (response.isError() || !response.isNotification()) {
                    BaseMatcher.LOG.debug("observation with token {} not established, removing from observation store", this.token);
                    remove();
                }
            }
        }

        public void remove() {
            if (this.removed.compareAndSet(false, true)) {
                BaseMatcher.this.observationStore.remove(this.token);
            }
        }
    }

    public BaseMatcher(NetworkConfig networkConfig, NotificationListener notificationListener, TokenGenerator tokenGenerator, ObservationStore observationStore, MessageExchangeStore messageExchangeStore, Executor executor) {
        if (networkConfig == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Config must not be null");
            throw null;
        }
        if (notificationListener == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("NotificationListener must not be null");
            throw null;
        }
        if (tokenGenerator == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("TokenGenerator must not be null");
            throw null;
        }
        if (messageExchangeStore == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("MessageExchangeStore must not be null");
            throw null;
        }
        if (observationStore == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("ObservationStore must not be null");
            throw null;
        }
        this.config = networkConfig;
        this.notificationListener = notificationListener;
        this.exchangeStore = messageExchangeStore;
        this.observationStore = observationStore;
        this.tokenGenerator = tokenGenerator;
        this.executor = executor;
    }

    public void clear() {
    }

    public final Exchange matchNotifyResponse(Response response) {
        Token token;
        Observation observation;
        if ((CoAP.ResponseCode.isSuccess(response.getCode()) && !response.getOptions().hasObserve()) || (observation = this.observationStore.get((token = response.getToken()))) == null) {
            return null;
        }
        final Request request = observation.getRequest();
        Exchange exchange = new Exchange(request, Exchange.Origin.LOCAL, this.executor, observation.getContext(), true);
        LOG.debug("re-created exchange from original observe request: {}", request);
        request.addMessageObserver(new ObservationObserverAdapter(token) { // from class: org.eclipse.californium.core.network.BaseMatcher.2
            @Override // org.eclipse.californium.core.network.BaseMatcher.ObservationObserverAdapter, org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
            public void onResponse(Response response2) {
                try {
                    BaseMatcher.this.notificationListener.onNotification(request, response2);
                } finally {
                    if (!response2.isNotification()) {
                        BaseMatcher.LOG.debug("observation with token {} removed, removing from observation store", this.token);
                        remove();
                    }
                }
            }
        });
        return exchange;
    }

    public final void registerObserve(Request request) {
        if (!request.getOptions().hasBlock2() || request.getOptions().getBlock2().getNum() == 0) {
            LOG.debug("registering observe request {}", request);
            Token token = request.getToken();
            if (token == null) {
                do {
                    token = this.tokenGenerator.createToken(TokenGenerator.Scope.LONG_TERM);
                    request.setToken(token);
                } while (this.observationStore.putIfAbsent(token, new Observation(request, null)) != null);
            } else {
                this.observationStore.put(token, new Observation(request, null));
            }
            request.addMessageObserver(new ObservationObserverAdapter(token) { // from class: org.eclipse.californium.core.network.BaseMatcher.1
                @Override // org.eclipse.californium.core.coap.MessageObserverAdapter
                public void failed() {
                    remove();
                }

                @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
                public void onCancel() {
                    remove();
                }

                @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
                public void onContextEstablished(EndpointContext endpointContext) {
                    BaseMatcher.this.observationStore.setContext(this.token, endpointContext);
                }
            });
        }
    }

    @Override // org.eclipse.californium.core.network.Matcher
    public synchronized void start() {
        if (!this.running) {
            this.exchangeStore.start();
            this.observationStore.start();
            this.running = true;
        }
    }

    @Override // org.eclipse.californium.core.network.Matcher
    public synchronized void stop() {
        if (this.running) {
            this.exchangeStore.stop();
            this.observationStore.stop();
            clear();
            this.running = false;
        }
    }
}
