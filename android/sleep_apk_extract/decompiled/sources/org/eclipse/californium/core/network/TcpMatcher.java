package org.eclipse.californium.core.network;

import java.util.concurrent.Executor;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.MessageObserverAdapter;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.coap.Token;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.observe.NotificationListener;
import org.eclipse.californium.core.observe.ObservationStore;
import org.eclipse.californium.elements.EndpointContext;
import org.eclipse.californium.elements.EndpointContextMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public final class TcpMatcher extends BaseMatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) TcpMatcher.class);
    private final EndpointContextMatcher endpointContextMatcher;
    private final RemoveHandler exchangeRemoveHandler;

    /* JADX INFO: renamed from: org.eclipse.californium.core.network.TcpMatcher$1, reason: invalid class name */
    public class AnonymousClass1 extends MessageObserverAdapter {
    }

    public TcpMatcher(NetworkConfig networkConfig, NotificationListener notificationListener, TokenGenerator tokenGenerator, ObservationStore observationStore, MessageExchangeStore messageExchangeStore, Executor executor, EndpointContextMatcher endpointContextMatcher) {
        super(networkConfig, notificationListener, tokenGenerator, observationStore, messageExchangeStore, executor);
        this.exchangeRemoveHandler = new RemoveHandlerImpl(this, null);
        this.endpointContextMatcher = endpointContextMatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel(Response response, EndpointReceiver endpointReceiver) {
        response.setCanceled(true);
        endpointReceiver.receiveResponse(null, response);
    }

    @Override // org.eclipse.californium.core.network.Matcher
    public void receiveEmptyMessage(EmptyMessage emptyMessage, EndpointReceiver endpointReceiver) {
    }

    @Override // org.eclipse.californium.core.network.Matcher
    public void receiveRequest(final Request request, final EndpointReceiver endpointReceiver) {
        final Exchange exchange = new Exchange(request, Exchange.Origin.REMOTE, this.executor);
        exchange.setRemoveHandler(this.exchangeRemoveHandler);
        exchange.execute(new Runnable() { // from class: org.eclipse.californium.core.network.TcpMatcher.2
            @Override // java.lang.Runnable
            public void run() {
                endpointReceiver.receiveRequest(exchange, request);
            }
        });
    }

    @Override // org.eclipse.californium.core.network.Matcher
    public void receiveResponse(final Response response, final EndpointReceiver endpointReceiver) {
        final KeyToken keyToken = this.tokenGenerator.getKeyToken(response.getToken(), this.endpointContextMatcher.getEndpointIdentity(response.getSourceContext()));
        Exchange exchangeMatchNotifyResponse = this.exchangeStore.get(keyToken);
        if (exchangeMatchNotifyResponse == null) {
            exchangeMatchNotifyResponse = matchNotifyResponse(response);
        }
        final Exchange exchange = exchangeMatchNotifyResponse;
        if (exchange != null) {
            exchange.execute(new Runnable() { // from class: org.eclipse.californium.core.network.TcpMatcher.3
                @Override // java.lang.Runnable
                public void run() {
                    if ((!exchange.isNotification() || exchange.getRequest() != exchange.getCurrentRequest()) && TcpMatcher.this.exchangeStore.get(keyToken) != exchange) {
                        if (TcpMatcher.this.running) {
                            TcpMatcher.LOGGER.debug("ignoring response {}, exchange not longer matching!", response);
                        }
                        TcpMatcher.this.cancel(response, endpointReceiver);
                        return;
                    }
                    EndpointContext endpointContext = exchange.getEndpointContext();
                    if (endpointContext == null) {
                        TcpMatcher.LOGGER.error("ignoring response from [{}]: {}, request pending to sent!", response.getSourceContext(), response);
                        TcpMatcher.this.cancel(response, endpointReceiver);
                        return;
                    }
                    try {
                    } catch (Exception e) {
                        TcpMatcher.LOGGER.error("error receiving response from [{}]: {} for {}", response.getSourceContext(), response, exchange, e);
                    }
                    if (!TcpMatcher.this.endpointContextMatcher.isResponseRelatedToRequest(endpointContext, response.getSourceContext())) {
                        if (TcpMatcher.LOGGER.isDebugEnabled()) {
                            TcpMatcher.LOGGER.debug("ignoring potentially forged response from [{}]: {} for {} with non-matching endpoint context", TcpMatcher.this.endpointContextMatcher.toRelevantState(response.getSourceContext()), response, exchange);
                        }
                        TcpMatcher.this.cancel(response, endpointReceiver);
                        return;
                    }
                    Request currentRequest = exchange.getCurrentRequest();
                    if (!exchange.isNotification() || !response.isNotification() || !currentRequest.isObserveCancel()) {
                        endpointReceiver.receiveResponse(exchange, response);
                    } else {
                        TcpMatcher.LOGGER.debug("ignoring notify for pending cancel {}!", response);
                        TcpMatcher.this.cancel(response, endpointReceiver);
                    }
                }
            });
        } else {
            LOGGER.trace("discarding by [{}] unmatchable response from [{}]: {}", keyToken, response.getSourceContext(), response);
            cancel(response, endpointReceiver);
        }
    }

    @Override // org.eclipse.californium.core.network.Matcher
    public void sendEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
        if (emptyMessage.isConfirmable()) {
            emptyMessage.setToken(Token.EMPTY);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m("sending empty message (ACK/RST) over tcp is not supported!");
        }
    }

    @Override // org.eclipse.californium.core.network.Matcher
    public void sendRequest(Exchange exchange) {
        Request currentRequest = exchange.getCurrentRequest();
        if (currentRequest.isObserve()) {
            registerObserve(currentRequest);
        }
        exchange.setRemoveHandler(this.exchangeRemoveHandler);
        this.exchangeStore.registerOutboundRequestWithTokenOnly(exchange);
        LOGGER.debug("tracking open request using [{}]", exchange.getKeyToken());
    }

    @Override // org.eclipse.californium.core.network.Matcher
    public void sendResponse(Exchange exchange) {
        Response currentResponse = exchange.getCurrentResponse();
        exchange.getRelation();
        currentResponse.ensureToken(exchange.getCurrentRequest().getToken());
        exchange.setComplete();
    }

    public class RemoveHandlerImpl implements RemoveHandler {
        private RemoveHandlerImpl() {
        }

        @Override // org.eclipse.californium.core.network.RemoveHandler
        public void remove(Exchange exchange, KeyToken keyToken, KeyMID keyMID) {
            if (keyToken != null) {
                TcpMatcher.this.exchangeStore.remove(keyToken, exchange);
            }
        }

        public /* synthetic */ RemoveHandlerImpl(TcpMatcher tcpMatcher, AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
