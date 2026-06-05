package org.eclipse.californium.core.network;

import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.coap.Token;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.observe.NotificationListener;
import org.eclipse.californium.core.observe.ObservationStore;
import org.eclipse.californium.elements.EndpointContext;
import org.eclipse.californium.elements.EndpointContextMatcher;
import org.eclipse.californium.elements.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public final class UdpMatcher extends BaseMatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) UdpMatcher.class);
    private final EndpointContextMatcher endpointContextMatcher;
    private final RemoveHandler exchangeRemoveHandler;

    public class RemoveHandlerImpl implements RemoveHandler {
        private RemoveHandlerImpl() {
        }

        @Override // org.eclipse.californium.core.network.RemoveHandler
        public void remove(Exchange exchange, KeyToken keyToken, KeyMID keyMID) {
            if (keyToken != null) {
                UdpMatcher.this.exchangeStore.remove(keyToken, exchange);
            }
            if (keyMID != null) {
                UdpMatcher.this.exchangeStore.remove(keyMID, exchange);
            }
        }
    }

    public UdpMatcher(NetworkConfig networkConfig, NotificationListener notificationListener, TokenGenerator tokenGenerator, ObservationStore observationStore, MessageExchangeStore messageExchangeStore, Executor executor, EndpointContextMatcher endpointContextMatcher) {
        super(networkConfig, notificationListener, tokenGenerator, observationStore, messageExchangeStore, executor);
        this.exchangeRemoveHandler = new RemoveHandlerImpl();
        this.endpointContextMatcher = endpointContextMatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel(Response response, EndpointReceiver endpointReceiver) {
        response.setCanceled(true);
        endpointReceiver.receiveResponse(null, response);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reject(Response response, EndpointReceiver endpointReceiver) {
        if (response.getType() != CoAP.Type.ACK && response.hasMID()) {
            endpointReceiver.reject(response);
        }
        cancel(response, endpointReceiver);
    }

    @Override // org.eclipse.californium.core.network.Matcher
    public void receiveEmptyMessage(final EmptyMessage emptyMessage, final EndpointReceiver endpointReceiver) {
        final KeyMID keyMID = new KeyMID(emptyMessage.getMID(), this.endpointContextMatcher.getEndpointIdentity(emptyMessage.getSourceContext()));
        final Exchange exchange = this.exchangeStore.get(keyMID);
        if (exchange != null) {
            exchange.execute(new Runnable() { // from class: org.eclipse.californium.core.network.UdpMatcher.5
                @Override // java.lang.Runnable
                public void run() {
                    if (exchange.getCurrentRequest().isMulticast()) {
                        UdpMatcher.LOGGER.debug("ignoring {} message for multicast request {}", emptyMessage.getType(), keyMID);
                        UdpMatcher.this.cancel(emptyMessage, endpointReceiver);
                        return;
                    }
                    Exchange exchange2 = UdpMatcher.this.exchangeStore.get(keyMID);
                    Exchange exchange3 = exchange;
                    UdpMatcher udpMatcher = UdpMatcher.this;
                    if (exchange2 != exchange3) {
                        if (udpMatcher.running) {
                            UdpMatcher.LOGGER.debug("ignoring {} message not longer matching by {}", emptyMessage.getType(), keyMID);
                        }
                        UdpMatcher.this.cancel(emptyMessage, endpointReceiver);
                        return;
                    }
                    try {
                    } catch (RuntimeException e) {
                        UdpMatcher.LOGGER.warn("error receiving {} message for {}", emptyMessage.getType(), exchange, e);
                    }
                    if (!udpMatcher.endpointContextMatcher.isResponseRelatedToRequest(exchange.getEndpointContext(), emptyMessage.getSourceContext())) {
                        UdpMatcher.LOGGER.debug("ignoring potentially forged {} reply for {} with non-matching endpoint context", emptyMessage.getType(), keyMID);
                        UdpMatcher.this.cancel(emptyMessage, endpointReceiver);
                    } else {
                        UdpMatcher.this.exchangeStore.remove(keyMID, exchange);
                        UdpMatcher.LOGGER.debug("received expected {} reply for {}", emptyMessage.getType(), keyMID);
                        endpointReceiver.receiveEmptyMessage(exchange, emptyMessage);
                    }
                }
            });
        } else {
            LOGGER.debug("ignoring {} message unmatchable by {}", emptyMessage.getType(), keyMID);
            cancel(emptyMessage, endpointReceiver);
        }
    }

    @Override // org.eclipse.californium.core.network.Matcher
    public void receiveRequest(final Request request, final EndpointReceiver endpointReceiver) {
        KeyMID keyMID = new KeyMID(request.getMID(), this.endpointContextMatcher.getEndpointIdentity(request.getSourceContext()));
        Exchange.Origin origin = Exchange.Origin.REMOTE;
        final Exchange exchange = new Exchange(request, origin, this.executor);
        final Exchange exchangeFindPrevious = this.exchangeStore.findPrevious(keyMID, exchange);
        boolean zIsToBeSent = exchangeFindPrevious != null;
        if (zIsToBeSent) {
            EndpointContext sourceContext = request.getSourceContext();
            Request currentRequest = exchangeFindPrevious.getCurrentRequest();
            zIsToBeSent = this.endpointContextMatcher.isToBeSent(exchangeFindPrevious.getOrigin() == origin ? currentRequest.getSourceContext() : currentRequest.getDestinationContext(), sourceContext);
            if (zIsToBeSent) {
                if (currentRequest.isMulticast() || request.isMulticast()) {
                    InetSocketAddress peerAddress = request.getDestinationContext() == null ? null : request.getDestinationContext().getPeerAddress();
                    InetSocketAddress peerAddress2 = currentRequest.getDestinationContext() != null ? currentRequest.getDestinationContext().getPeerAddress() : null;
                    if (peerAddress != peerAddress2 && (peerAddress == null || !peerAddress.equals(peerAddress2))) {
                        LOGGER.warn("received request {} via different multicast groups ({} != {})!", request, StringUtil.toString(peerAddress), StringUtil.toString(peerAddress2));
                    }
                }
            } else if (this.exchangeStore.replacePrevious(keyMID, exchangeFindPrevious, exchange)) {
                LOGGER.debug("replaced request {} by new request {}!", currentRequest, request);
            } else {
                LOGGER.warn("new request {} could not be registered! Deduplication disabled!", request);
            }
        }
        if (!zIsToBeSent) {
            exchange.setRemoveHandler(this.exchangeRemoveHandler);
            exchange.execute(new Runnable() { // from class: org.eclipse.californium.core.network.UdpMatcher.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        endpointReceiver.receiveRequest(exchange, request);
                    } catch (RuntimeException e) {
                        UdpMatcher.LOGGER.warn("error receiving request {}", request, e);
                        if (request.isMulticast()) {
                            return;
                        }
                        endpointReceiver.reject(request);
                    }
                }
            });
        } else {
            LOGGER.trace("duplicate request: {}", request);
            request.setDuplicate(true);
            exchangeFindPrevious.execute(new Runnable() { // from class: org.eclipse.californium.core.network.UdpMatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        endpointReceiver.receiveRequest(exchangeFindPrevious, request);
                    } catch (RuntimeException e) {
                        UdpMatcher.LOGGER.warn("error receiving request {} again!", request, e);
                        if (request.isMulticast()) {
                            return;
                        }
                        endpointReceiver.reject(request);
                    }
                }
            });
        }
    }

    @Override // org.eclipse.californium.core.network.Matcher
    public void receiveResponse(final Response response, final EndpointReceiver endpointReceiver) {
        final Object endpointIdentity = this.endpointContextMatcher.getEndpointIdentity(response.getSourceContext());
        final KeyToken keyToken = this.tokenGenerator.getKeyToken(response.getToken(), endpointIdentity);
        Logger logger = LOGGER;
        logger.trace("received response {} from {}", response, response.getSourceContext());
        Exchange exchangeMatchNotifyResponse = this.exchangeStore.get(keyToken);
        if (exchangeMatchNotifyResponse == null) {
            CoAP.Type type = response.getType();
            CoAP.Type type2 = CoAP.Type.ACK;
            if (type != type2) {
                final Exchange exchangeFind = this.exchangeStore.find(new KeyMID(response.getMID(), endpointIdentity));
                if (exchangeFind != null) {
                    exchangeFind.execute(new Runnable() { // from class: org.eclipse.californium.core.network.UdpMatcher.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (exchangeFind.getCurrentRequest().isMulticast()) {
                                UdpMatcher.LOGGER.debug("Ignore delayed response {} to multicast request {}", response, exchangeFind.getCurrentRequest().getDestinationContext().getPeerAddress());
                                UdpMatcher.this.cancel(response, endpointReceiver);
                                return;
                            }
                            try {
                            } catch (RuntimeException e) {
                                UdpMatcher.LOGGER.warn("error receiving response {} for {}", response, exchangeFind, e);
                            }
                            if (!UdpMatcher.this.endpointContextMatcher.isResponseRelatedToRequest(exchangeFind.getEndpointContext(), response.getSourceContext())) {
                                UdpMatcher.LOGGER.debug("ignoring potentially forged response {} for already completed {}", response, exchangeFind);
                                UdpMatcher.this.reject(response, endpointReceiver);
                                return;
                            }
                            UdpMatcher.LOGGER.trace("received response {} for already completed {}", response, exchangeFind);
                            response.setDuplicate(true);
                            Response currentResponse = exchangeFind.getCurrentResponse();
                            if (currentResponse != null) {
                                response.setRejected(currentResponse.isRejected());
                            }
                            endpointReceiver.receiveResponse(exchangeFind, response);
                        }
                    });
                    return;
                }
            }
            exchangeMatchNotifyResponse = matchNotifyResponse(response);
            if (exchangeMatchNotifyResponse == null) {
                if (response.getType() == type2) {
                    logger.trace("discarding by [{}] unmatchable piggy-backed response from [{}]: {}", keyToken, response.getSourceContext(), response);
                    cancel(response, endpointReceiver);
                    return;
                } else {
                    logger.trace("discarding by [{}] unmatchable response from [{}]: {}", keyToken, response.getSourceContext(), response);
                    reject(response, endpointReceiver);
                    return;
                }
            }
        }
        final Exchange exchange = exchangeMatchNotifyResponse;
        exchange.execute(new Runnable() { // from class: org.eclipse.californium.core.network.UdpMatcher.4
            @Override // java.lang.Runnable
            public void run() {
                if ((!exchange.isNotification() || exchange.getRequest() != exchange.getCurrentRequest()) && UdpMatcher.this.exchangeStore.get(keyToken) != exchange) {
                    if (UdpMatcher.this.running) {
                        UdpMatcher.LOGGER.debug("ignoring response {}, exchange not longer matching!", response);
                    }
                    UdpMatcher.this.cancel(response, endpointReceiver);
                    return;
                }
                EndpointContext endpointContext = exchange.getEndpointContext();
                if (endpointContext == null) {
                    UdpMatcher.LOGGER.debug("ignoring response {}, request pending to sent!", response);
                    UdpMatcher.this.cancel(response, endpointReceiver);
                    return;
                }
                try {
                } catch (RuntimeException e) {
                    UdpMatcher.LOGGER.warn("error receiving response {} for {}", response, exchange, e);
                }
                if (!UdpMatcher.this.endpointContextMatcher.isResponseRelatedToRequest(endpointContext, response.getSourceContext())) {
                    UdpMatcher.LOGGER.debug("ignoring potentially forged response for token {} with non-matching endpoint context", keyToken);
                    UdpMatcher.this.reject(response, endpointReceiver);
                    return;
                }
                CoAP.Type type3 = response.getType();
                Request currentRequest = exchange.getCurrentRequest();
                int mid = currentRequest.getMID();
                if (currentRequest.isMulticast()) {
                    if (type3 != CoAP.Type.NON) {
                        UdpMatcher.LOGGER.debug("ignoring response of type {} for multicast request with token [{}], from {}", response.getType(), response.getTokenString(), response.getSourceContext().getPeerAddress());
                        UdpMatcher.this.cancel(response, endpointReceiver);
                        return;
                    }
                } else if (type3 == CoAP.Type.ACK && mid != response.getMID()) {
                    UdpMatcher.LOGGER.debug("ignoring ACK, possible MID reuse before lifetime end for token {}, expected MID {} but received {}", response.getTokenString(), Integer.valueOf(mid), Integer.valueOf(response.getMID()));
                    UdpMatcher.this.cancel(response, endpointReceiver);
                    return;
                }
                if (type3 != CoAP.Type.ACK && !exchange.isNotification() && response.isNotification() && currentRequest.isObserveCancel()) {
                    UdpMatcher.LOGGER.debug("ignoring notify for pending cancel {}!", response);
                    UdpMatcher.this.cancel(response, endpointReceiver);
                    return;
                }
                if (type3 == CoAP.Type.CON || type3 == CoAP.Type.NON) {
                    Exchange exchangeFindPrevious = UdpMatcher.this.exchangeStore.findPrevious(new KeyMID(response.getMID(), endpointIdentity), exchange);
                    if (exchangeFindPrevious != null) {
                        UdpMatcher.LOGGER.trace("received duplicate response for open {}: {}", exchange, response);
                        response.setDuplicate(true);
                        Response currentResponse = exchangeFindPrevious.getCurrentResponse();
                        if (currentResponse != null) {
                            response.setRejected(currentResponse.isRejected());
                        }
                    }
                }
                endpointReceiver.receiveResponse(exchange, response);
            }
        });
    }

    @Override // org.eclipse.californium.core.network.Matcher
    public void sendEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
        emptyMessage.setToken(Token.EMPTY);
        if (emptyMessage.getType() != CoAP.Type.RST || exchange == null) {
            return;
        }
        exchange.executeComplete();
    }

    @Override // org.eclipse.californium.core.network.Matcher
    public void sendRequest(Exchange exchange) {
        Request currentRequest = exchange.getCurrentRequest();
        if (currentRequest.isObserve() && exchange.getFailedTransmissionCount() == 0) {
            if (this.exchangeStore.assignMessageId(currentRequest) == -1) {
                LOGGER.warn("message IDs exhausted, could not register outbound observe request for tracking");
                currentRequest.setSendError(new IllegalStateException("automatic message IDs exhausted"));
                return;
            }
            registerObserve(currentRequest);
        }
        try {
            if (this.exchangeStore.registerOutboundRequest(exchange)) {
                exchange.setRemoveHandler(this.exchangeRemoveHandler);
                LOGGER.debug("tracking open request [{}, {}]", exchange.getKeyMID(), exchange.getKeyToken());
            } else {
                LOGGER.warn("message IDs exhausted, could not register outbound request for tracking");
                currentRequest.setSendError(new IllegalStateException("automatic message IDs exhausted"));
            }
        } catch (IllegalArgumentException e) {
            currentRequest.setSendError(e);
        }
    }

    @Override // org.eclipse.californium.core.network.Matcher
    public void sendResponse(Exchange exchange) {
        Response currentResponse = exchange.getCurrentResponse();
        currentResponse.ensureToken(exchange.getCurrentRequest().getToken());
        if (currentResponse.getType() == CoAP.Type.CON) {
            exchange.removeNotifications();
            this.exchangeStore.registerOutboundResponse(exchange);
            LOGGER.debug("tracking open response [{}]", exchange.getKeyMID());
            return;
        }
        if (currentResponse.getType() == CoAP.Type.NON) {
            boolean zIsNotification = currentResponse.isNotification();
            MessageExchangeStore messageExchangeStore = this.exchangeStore;
            if (zIsNotification) {
                messageExchangeStore.registerOutboundResponse(exchange);
                return;
            }
            messageExchangeStore.assignMessageId(currentResponse);
        }
        exchange.setComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel(EmptyMessage emptyMessage, EndpointReceiver endpointReceiver) {
        emptyMessage.setCanceled(true);
        endpointReceiver.receiveEmptyMessage(null, emptyMessage);
    }
}
