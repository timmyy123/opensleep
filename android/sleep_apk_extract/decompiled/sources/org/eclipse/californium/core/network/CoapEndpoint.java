package org.eclipse.californium.core.network;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAPMessageFormatException;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.InternalMessageObserverAdapter;
import org.eclipse.californium.core.coap.Message;
import org.eclipse.californium.core.coap.MessageFormatException;
import org.eclipse.californium.core.coap.MessageObserver;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.EndpointManager;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.network.serialization.DataParser;
import org.eclipse.californium.core.network.serialization.DataSerializer;
import org.eclipse.californium.core.network.serialization.TcpDataParser;
import org.eclipse.californium.core.network.serialization.TcpDataSerializer;
import org.eclipse.californium.core.network.serialization.UdpDataParser;
import org.eclipse.californium.core.network.serialization.UdpDataSerializer;
import org.eclipse.californium.core.network.stack.CoapStack;
import org.eclipse.californium.core.network.stack.CoapTcpStack;
import org.eclipse.californium.core.network.stack.CoapUdpStack;
import org.eclipse.californium.core.observe.InMemoryObservationStore;
import org.eclipse.californium.core.observe.NotificationListener;
import org.eclipse.californium.core.observe.ObservationStore;
import org.eclipse.californium.core.server.MessageDeliverer;
import org.eclipse.californium.elements.Connector;
import org.eclipse.californium.elements.EndpointContext;
import org.eclipse.californium.elements.EndpointContextMatcher;
import org.eclipse.californium.elements.MessageCallback;
import org.eclipse.californium.elements.RawData;
import org.eclipse.californium.elements.RawDataChannel;
import org.eclipse.californium.elements.UDPConnector;
import org.eclipse.californium.elements.util.ClockUtil;
import org.eclipse.californium.elements.util.DaemonThreadFactory;
import org.eclipse.californium.elements.util.ExecutorsUtil;
import org.eclipse.californium.elements.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class CoapEndpoint implements Endpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) CoapEndpoint.class);
    public static final CoapStackFactory STANDARD_COAP_STACK_FACTORY = new CoapStackFactory() { // from class: org.eclipse.californium.core.network.CoapEndpoint.12
        @Override // org.eclipse.californium.core.network.CoapStackFactory
        public CoapStack createCoapStack(String str, NetworkConfig networkConfig, Outbox outbox, Object obj) {
            return CoAP.isTcpProtocol(str) ? new CoapTcpStack(networkConfig, outbox) : new CoapUdpStack(networkConfig, outbox);
        }
    };
    private static CoapStackFactory defaultCoapStackFactory;
    protected final CoapStack coapstack;
    private final NetworkConfig config;
    private final Connector connector;
    private final EndpointReceiver endpointStackReceiver;
    private final MessageExchangeStore exchangeStore;
    private ExecutorService executor;

    @Deprecated
    private final CoapEndpointHealth health;
    private List<Object> interceptors;
    private final Matcher matcher;
    private final int multicastBaseMid;
    private List<Connector> multicastReceivers;
    private List<NotificationListener> notificationListeners;
    private final ObservationStore observationStore;
    private List<EndpointObserver> observers;
    private final DataParser parser;
    private List<Object> postProcessInterceptors;

    @Deprecated
    private final MessageObserver rejectTransmission;

    @Deprecated
    private final MessageObserver requestTransmission;

    @Deprecated
    private final MessageObserver responseTransmission;
    private final String scheme;
    private ScheduledExecutorService secondaryExecutor;
    private final DataSerializer serializer;
    private volatile boolean started;
    private ScheduledFuture<?> statusLogger;
    private final String tag;
    private final boolean useRequestOffloading;

    public static class Builder {
        private CoapStackFactory coapStackFactory;
        private Object customStackArgument;
        private DataParser parser;
        private DataSerializer serializer;
        private String tag;
        private TokenGenerator tokenGenerator;
        private NetworkConfig config = null;
        private InetSocketAddress bindAddress = null;
        private boolean applyConfiguration = true;
        private Connector connector = null;
        private ObservationStore observationStore = null;
        private MessageExchangeStore exchangeStore = null;
        private EndpointContextMatcher endpointContextMatcher = null;

        public CoapEndpoint build() {
            if (this.config == null) {
                this.config = NetworkConfig.getStandard();
            }
            if (this.connector == null) {
                if (this.bindAddress == null) {
                    this.bindAddress = new InetSocketAddress(0);
                }
                this.connector = new UDPConnector(this.bindAddress);
            }
            if (this.tokenGenerator == null) {
                this.tokenGenerator = new RandomTokenGenerator(this.config);
            }
            if (this.observationStore == null) {
                this.observationStore = new InMemoryObservationStore(this.config);
            }
            if (this.endpointContextMatcher == null) {
                this.endpointContextMatcher = EndpointContextMatcherFactory.create(this.connector, this.config);
            }
            if (this.tag == null) {
                this.tag = CoAP.getSchemeForProtocol(this.connector.getProtocol());
            }
            this.tag = StringUtil.normalizeLoggingTag(this.tag);
            if (this.exchangeStore == null) {
                this.exchangeStore = new InMemoryMessageExchangeStore(this.tag, this.config, this.tokenGenerator, this.endpointContextMatcher);
            }
            if (this.coapStackFactory == null) {
                this.coapStackFactory = CoapEndpoint.getDefaultCoapStackFactory();
            }
            return new CoapEndpoint(this.connector, this.applyConfiguration, this.config, this.tokenGenerator, this.observationStore, this.exchangeStore, this.endpointContextMatcher, this.serializer, this.parser, this.tag, this.coapStackFactory, this.customStackArgument);
        }

        public Builder setConnector(Connector connector) {
            if (this.bindAddress != null || this.connector != null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("bind address already defined!");
                return null;
            }
            this.connector = connector;
            this.applyConfiguration = false;
            return this;
        }

        public Builder setNetworkConfig(NetworkConfig networkConfig) {
            this.config = networkConfig;
            return this;
        }
    }

    public static abstract class ExchangeCallback<T extends Message> extends SendingCallback<T> {
        protected final Exchange exchange;

        public ExchangeCallback(Exchange exchange, T t) {
            super(t);
            if (exchange != null) {
                this.exchange = exchange;
            } else {
                Types$$ExternalSyntheticBUOutline0.m$1("exchange must not be null");
                throw null;
            }
        }

        @Override // org.eclipse.californium.core.network.CoapEndpoint.SendingCallback
        public void onContextEstablished(EndpointContext endpointContext, long j) {
            Exchange exchange = this.exchange;
            if (j == 0) {
                j = -1;
            }
            exchange.setSendNanoTimestamp(j);
            this.exchange.setEndpointContext(endpointContext);
        }
    }

    public class InboxImpl implements RawDataChannel {
        private InboxImpl() {
        }

        private void receiveEmptyMessage(EmptyMessage emptyMessage) {
            CoapEndpoint coapEndpoint = CoapEndpoint.this;
            coapEndpoint.notifyReceive((List<Object>) coapEndpoint.interceptors, emptyMessage);
            if (emptyMessage.isCanceled()) {
                return;
            }
            if ((emptyMessage.getType() != CoAP.Type.CON && emptyMessage.getType() != CoAP.Type.NON) || !emptyMessage.hasMID()) {
                CoapEndpoint.this.matcher.receiveEmptyMessage(emptyMessage, CoapEndpoint.this.endpointStackReceiver);
            } else {
                CoapEndpoint.LOGGER.debug("{}responding to ping from {}", CoapEndpoint.this.tag, emptyMessage.getSourceContext());
                CoapEndpoint.this.endpointStackReceiver.reject(emptyMessage);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void receiveMessage(RawData rawData) {
            try {
                Message message = CoapEndpoint.this.parser.parseMessage(rawData);
                if (CoAP.isRequest(message.getRawCode())) {
                    receiveRequest((Request) message);
                    return;
                }
                if (CoAP.isResponse(message.getRawCode())) {
                    receiveResponse((Response) message);
                } else if (CoAP.isEmptyMessage(message.getRawCode())) {
                    receiveEmptyMessage((EmptyMessage) message);
                } else {
                    CoapEndpoint.LOGGER.debug("{}silently ignoring non-CoAP message from {}", CoapEndpoint.this.tag, rawData.getEndpointContext());
                }
            } catch (CoAPMessageFormatException e) {
                if (!e.isConfirmable() || !e.hasMid()) {
                    CoapEndpoint.LOGGER.debug("{}discarding malformed message from [{}]: {}", CoapEndpoint.this.tag, rawData.getEndpointContext(), e.getMessage());
                    return;
                }
                if (!CoAP.isRequest(e.getCode()) || e.getToken() == null) {
                    reject(rawData, e);
                    CoapEndpoint.LOGGER.debug("{}rejected malformed message from [{}], reason: {}", CoapEndpoint.this.tag, rawData.getEndpointContext(), e.getMessage());
                } else {
                    responseBadOption(rawData, e);
                    CoapEndpoint.LOGGER.debug("{}respond malformed request from [{}], reason: {}", CoapEndpoint.this.tag, rawData.getEndpointContext(), e.getMessage());
                }
            } catch (MessageFormatException e2) {
                CoapEndpoint.LOGGER.debug("{}discarding malformed message from [{}]: {}", CoapEndpoint.this.tag, rawData.getEndpointContext(), e2.getMessage());
            }
        }

        private void receiveRequest(Request request) {
            request.setScheme(CoapEndpoint.this.scheme);
            if (!CoapEndpoint.this.started) {
                CoapEndpoint.LOGGER.debug("{}not running, drop request {}", CoapEndpoint.this.tag, request);
                return;
            }
            CoapEndpoint coapEndpoint = CoapEndpoint.this;
            coapEndpoint.notifyReceive((List<Object>) coapEndpoint.interceptors, request);
            if (request.isCanceled()) {
                return;
            }
            CoapEndpoint.this.matcher.receiveRequest(request, CoapEndpoint.this.endpointStackReceiver);
        }

        private void receiveResponse(Response response) {
            CoapEndpoint coapEndpoint = CoapEndpoint.this;
            coapEndpoint.notifyReceive((List<Object>) coapEndpoint.interceptors, response);
            if (response.isCanceled()) {
                return;
            }
            CoapEndpoint.this.matcher.receiveResponse(response, CoapEndpoint.this.endpointStackReceiver);
        }

        private void reject(RawData rawData, CoAPMessageFormatException coAPMessageFormatException) {
            EmptyMessage emptyMessage = new EmptyMessage(CoAP.Type.RST);
            emptyMessage.setMID(coAPMessageFormatException.getMid());
            emptyMessage.setDestinationContext(rawData.getEndpointContext());
            if (CoapEndpoint.this.rejectTransmission != null) {
                emptyMessage.addMessageObserver(CoapEndpoint.this.rejectTransmission);
            }
            CoapEndpoint.this.coapstack.sendEmptyMessage(null, emptyMessage);
        }

        private void responseBadOption(RawData rawData, CoAPMessageFormatException coAPMessageFormatException) {
            Response response = new Response(CoAP.ResponseCode.BAD_OPTION);
            response.setDestinationContext(rawData.getEndpointContext());
            response.setToken(coAPMessageFormatException.getToken());
            response.setMID(coAPMessageFormatException.getMid());
            response.setType(CoAP.Type.ACK);
            response.setPayload(coAPMessageFormatException.getMessage());
            if (CoapEndpoint.this.responseTransmission != null) {
                response.addMessageObserver(CoapEndpoint.this.responseTransmission);
            }
            CoapEndpoint coapEndpoint = CoapEndpoint.this;
            coapEndpoint.notifySend((List<Object>) coapEndpoint.interceptors, response);
            response.setReadyToSend();
            if (!CoapEndpoint.this.started) {
                response.cancel();
            }
            CoapEndpoint.this.connector.send(CoapEndpoint.this.serializer.serializeResponse(response, new SendingCallback<Response>(response) { // from class: org.eclipse.californium.core.network.CoapEndpoint.InboxImpl.2
                @Override // org.eclipse.californium.core.network.CoapEndpoint.SendingCallback
                public void notifyPostProcess(Response response2) {
                    CoapEndpoint coapEndpoint2 = CoapEndpoint.this;
                    coapEndpoint2.notifySend((List<Object>) coapEndpoint2.postProcessInterceptors, response2);
                }
            }));
        }

        @Override // org.eclipse.californium.elements.RawDataChannel
        public void receiveData(final RawData rawData) {
            if (rawData.getEndpointContext() == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("received message that does not have a endpoint context");
                return;
            }
            if (rawData.getEndpointContext().getPeerAddress() == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("received message that does not have a source address");
            } else if (rawData.getEndpointContext().getPeerAddress().getPort() != 0) {
                CoapEndpoint.this.runInProtocolStage(new Runnable() { // from class: org.eclipse.californium.core.network.CoapEndpoint.InboxImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InboxImpl.this.receiveMessage(rawData);
                    }
                });
            } else {
                Utf8$$ExternalSyntheticBUOutline0.m$2("received message that does not have a source port");
            }
        }
    }

    public class NotificationDispatcher implements NotificationListener {
        private NotificationDispatcher() {
        }

        @Override // org.eclipse.californium.core.observe.NotificationListener
        public void onNotification(Request request, Response response) {
            Iterator it = CoapEndpoint.this.notificationListeners.iterator();
            while (it.hasNext()) {
                ((NotificationListener) it.next()).onNotification(request, response);
            }
        }
    }

    public class OutboxImpl implements Outbox {
        public OutboxImpl() {
        }

        private void assertMessageHasDestinationAddress(Message message) {
            if (message.getDestinationContext() != null) {
                return;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Message has no endpoint context");
        }

        @Override // org.eclipse.californium.core.network.Outbox
        public void sendEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
            assertMessageHasDestinationAddress(emptyMessage);
            CoapEndpoint.this.matcher.sendEmptyMessage(exchange, emptyMessage);
            CoapEndpoint coapEndpoint = CoapEndpoint.this;
            coapEndpoint.notifySend((List<Object>) coapEndpoint.interceptors, emptyMessage);
            emptyMessage.setReadyToSend();
            if (!CoapEndpoint.this.started) {
                emptyMessage.cancel();
            }
            if (emptyMessage.isCanceled() || emptyMessage.getSendError() != null) {
                if (exchange != null) {
                    exchange.executeComplete();
                }
            } else {
                CoapEndpoint coapEndpoint2 = CoapEndpoint.this;
                if (exchange != null) {
                    coapEndpoint2.connector.send(CoapEndpoint.this.serializer.serializeEmptyMessage(emptyMessage, new ExchangeCallback<EmptyMessage>(exchange, emptyMessage) { // from class: org.eclipse.californium.core.network.CoapEndpoint.OutboxImpl.3
                        @Override // org.eclipse.californium.core.network.CoapEndpoint.SendingCallback
                        public void notifyPostProcess(EmptyMessage emptyMessage2) {
                            CoapEndpoint coapEndpoint3 = CoapEndpoint.this;
                            coapEndpoint3.notifySend((List<Object>) coapEndpoint3.postProcessInterceptors, emptyMessage2);
                        }
                    }));
                } else {
                    coapEndpoint2.connector.send(CoapEndpoint.this.serializer.serializeEmptyMessage(emptyMessage, new SendingCallback<EmptyMessage>(emptyMessage) { // from class: org.eclipse.californium.core.network.CoapEndpoint.OutboxImpl.4
                        @Override // org.eclipse.californium.core.network.CoapEndpoint.SendingCallback
                        public void notifyPostProcess(EmptyMessage emptyMessage2) {
                            CoapEndpoint coapEndpoint3 = CoapEndpoint.this;
                            coapEndpoint3.notifySend((List<Object>) coapEndpoint3.postProcessInterceptors, emptyMessage2);
                        }
                    }));
                }
            }
        }

        @Override // org.eclipse.californium.core.network.Outbox
        public void sendRequest(Exchange exchange, Request request) {
            assertMessageHasDestinationAddress(request);
            exchange.setCurrentRequest(request);
            CoapEndpoint.this.matcher.sendRequest(exchange);
            CoapEndpoint coapEndpoint = CoapEndpoint.this;
            coapEndpoint.notifySend((List<Object>) coapEndpoint.interceptors, request);
            request.setReadyToSend();
            if (!CoapEndpoint.this.started) {
                request.cancel();
            }
            if (request.isCanceled() || request.getSendError() != null) {
                exchange.executeComplete();
            } else {
                CoapEndpoint.this.connector.send(CoapEndpoint.this.serializer.serializeRequest(request, new ExchangeCallback<Request>(exchange, request) { // from class: org.eclipse.californium.core.network.CoapEndpoint.OutboxImpl.1
                    @Override // org.eclipse.californium.core.network.CoapEndpoint.SendingCallback
                    public void notifyPostProcess(Request request2) {
                        CoapEndpoint coapEndpoint2 = CoapEndpoint.this;
                        coapEndpoint2.notifySend((List<Object>) coapEndpoint2.postProcessInterceptors, request2);
                    }
                }));
            }
        }

        @Override // org.eclipse.californium.core.network.Outbox
        public void sendResponse(Exchange exchange, Response response) {
            assertMessageHasDestinationAddress(response);
            exchange.setCurrentResponse(response);
            CoapEndpoint.this.matcher.sendResponse(exchange);
            CoapEndpoint coapEndpoint = CoapEndpoint.this;
            coapEndpoint.notifySend((List<Object>) coapEndpoint.interceptors, response);
            response.setReadyToSend();
            if (!CoapEndpoint.this.started) {
                response.cancel();
            }
            if (response.isCanceled() || response.getSendError() != null) {
                exchange.executeComplete();
            } else {
                CoapEndpoint.this.connector.send(CoapEndpoint.this.serializer.serializeResponse(response, new ExchangeCallback<Response>(exchange, response) { // from class: org.eclipse.californium.core.network.CoapEndpoint.OutboxImpl.2
                    @Override // org.eclipse.californium.core.network.CoapEndpoint.SendingCallback
                    public void notifyPostProcess(Response response2) {
                        CoapEndpoint coapEndpoint2 = CoapEndpoint.this;
                        coapEndpoint2.notifySend((List<Object>) coapEndpoint2.postProcessInterceptors, response2);
                        if (CoapEndpoint.this.useRequestOffloading) {
                            this.exchange.getCurrentRequest().offload(Message.OffloadMode.FULL);
                            response2.offload(Message.OffloadMode.PAYLOAD);
                        }
                    }
                }));
            }
        }
    }

    @Deprecated
    public CoapEndpoint(Connector connector, boolean z, NetworkConfig networkConfig, TokenGenerator tokenGenerator, ObservationStore observationStore, MessageExchangeStore messageExchangeStore, EndpointContextMatcher endpointContextMatcher, DataSerializer dataSerializer, DataParser dataParser, String str, CoapEndpointHealth coapEndpointHealth, CoapStackFactory coapStackFactory, Object obj) {
        CoapEndpointHealth coapEndpointHealthLogger;
        EndpointContextMatcher endpointContextMatcher2 = endpointContextMatcher;
        this.observers = new CopyOnWriteArrayList();
        this.interceptors = new CopyOnWriteArrayList();
        this.postProcessInterceptors = new CopyOnWriteArrayList();
        this.notificationListeners = new CopyOnWriteArrayList();
        this.multicastReceivers = new CopyOnWriteArrayList();
        this.endpointStackReceiver = new EndpointReceiver() { // from class: org.eclipse.californium.core.network.CoapEndpoint.1
            @Override // org.eclipse.californium.core.network.EndpointReceiver
            public void receiveEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
                if (exchange != null && !emptyMessage.isCanceled()) {
                    exchange.setEndpoint(CoapEndpoint.this);
                    if (CoapEndpoint.this.health != null && emptyMessage.getType() == CoAP.Type.RST) {
                        CoapEndpoint.this.health.receivedReject();
                    }
                    CoapEndpoint.this.coapstack.receiveEmptyMessage(exchange, emptyMessage);
                }
                CoapEndpoint coapEndpoint = CoapEndpoint.this;
                coapEndpoint.notifyReceive((List<Object>) coapEndpoint.postProcessInterceptors, emptyMessage);
            }

            @Override // org.eclipse.californium.core.network.EndpointReceiver
            public void receiveRequest(Exchange exchange, Request request) {
                exchange.setEndpoint(CoapEndpoint.this);
                if (CoapEndpoint.this.health != null) {
                    CoapEndpoint.this.health.receivedRequest(request.isDuplicate());
                }
                CoapEndpoint.this.coapstack.receiveRequest(exchange, request);
                CoapEndpoint coapEndpoint = CoapEndpoint.this;
                coapEndpoint.notifyReceive((List<Object>) coapEndpoint.postProcessInterceptors, request);
            }

            @Override // org.eclipse.californium.core.network.EndpointReceiver
            public void receiveResponse(Exchange exchange, Response response) {
                if (exchange != null && !response.isCanceled()) {
                    exchange.setEndpoint(CoapEndpoint.this);
                    response.setRTT(exchange.calculateRTT());
                    if (CoapEndpoint.this.health != null) {
                        CoapEndpoint.this.health.receivedResponse(response.isDuplicate());
                    }
                    CoapEndpoint.this.coapstack.receiveResponse(exchange, response);
                }
                CoapEndpoint coapEndpoint = CoapEndpoint.this;
                coapEndpoint.notifyReceive((List<Object>) coapEndpoint.postProcessInterceptors, response);
            }

            @Override // org.eclipse.californium.core.network.EndpointReceiver
            public void reject(Message message) {
                EmptyMessage emptyMessageNewRST = EmptyMessage.newRST(message);
                if (CoapEndpoint.this.rejectTransmission != null) {
                    emptyMessageNewRST.addMessageObserver(CoapEndpoint.this.rejectTransmission);
                }
                CoapEndpoint.this.coapstack.sendEmptyMessage(null, emptyMessageNewRST);
            }
        };
        this.config = networkConfig;
        this.connector = connector;
        connector.setRawDataReceiver(new InboxImpl());
        this.scheme = CoAP.getSchemeForProtocol(connector.getProtocol());
        this.multicastBaseMid = networkConfig.getInt("MULTICAST_BASE_MID");
        String strNormalizeLoggingTag = StringUtil.normalizeLoggingTag(str);
        this.tag = strNormalizeLoggingTag;
        TokenGenerator randomTokenGenerator = tokenGenerator == null ? new RandomTokenGenerator(networkConfig) : tokenGenerator;
        CoapStackFactory defaultCoapStackFactory2 = coapStackFactory == null ? getDefaultCoapStackFactory() : coapStackFactory;
        MessageExchangeStore inMemoryMessageExchangeStore = messageExchangeStore != null ? messageExchangeStore : new InMemoryMessageExchangeStore(strNormalizeLoggingTag, networkConfig, randomTokenGenerator, endpointContextMatcher2);
        this.exchangeStore = inMemoryMessageExchangeStore;
        ObservationStore inMemoryObservationStore = observationStore != null ? observationStore : new InMemoryObservationStore(networkConfig);
        this.observationStore = inMemoryObservationStore;
        EndpointContextMatcher endpointContextMatcherCreate = endpointContextMatcher2 == null ? EndpointContextMatcherFactory.create(connector, networkConfig) : endpointContextMatcher2;
        if (z) {
            if (!(connector instanceof UDPConnector)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Connector must be a UDPConnector to use apply configuration!");
                throw null;
            }
            UDPConnector uDPConnector = (UDPConnector) connector;
            uDPConnector.setReceiverThreadCount(networkConfig.getInt("NETWORK_STAGE_RECEIVER_THREAD_COUNT"));
            uDPConnector.setSenderThreadCount(networkConfig.getInt("NETWORK_STAGE_SENDER_THREAD_COUNT"));
            uDPConnector.setReceiveBufferSize(networkConfig.getInt("UDP_CONNECTOR_RECEIVE_BUFFER"));
            uDPConnector.setSendBufferSize(networkConfig.getInt("UDP_CONNECTOR_SEND_BUFFER"));
            uDPConnector.setReceiverPacketSize(networkConfig.getInt("UDP_CONNECTOR_DATAGRAM_SIZE"));
        }
        ObservationStore observationStore2 = inMemoryObservationStore;
        Executor executor = new Executor() { // from class: org.eclipse.californium.core.network.CoapEndpoint.2
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                ExecutorService executorService = CoapEndpoint.this.executor;
                if (executorService == null) {
                    CoapEndpoint.LOGGER.error("{}Executor not ready for exchanges!", CoapEndpoint.this.tag, new Throwable("exchange execution failed!"));
                } else {
                    executorService.execute(runnable);
                }
            }
        };
        connector.setEndpointContextMatcher(endpointContextMatcherCreate);
        LOGGER.info("{}{} uses {}", strNormalizeLoggingTag, getClass().getSimpleName(), endpointContextMatcherCreate.getName());
        this.coapstack = defaultCoapStackFactory2.createCoapStack(connector.getProtocol(), networkConfig, new OutboxImpl(), obj);
        boolean zIsEnabled = false;
        if (CoAP.isTcpProtocol(connector.getProtocol())) {
            this.useRequestOffloading = false;
            this.matcher = new TcpMatcher(networkConfig, new NotificationDispatcher(), randomTokenGenerator, observationStore2, inMemoryMessageExchangeStore, executor, endpointContextMatcherCreate);
            this.serializer = dataSerializer != null ? dataSerializer : new TcpDataSerializer();
            this.parser = dataParser != null ? dataParser : new TcpDataParser();
        } else {
            this.useRequestOffloading = networkConfig.getBoolean("USE_MESSAGE_OFFLOADING");
            this.matcher = new UdpMatcher(networkConfig, new NotificationDispatcher(), randomTokenGenerator, observationStore2, inMemoryMessageExchangeStore, executor, endpointContextMatcherCreate);
            this.serializer = dataSerializer != null ? dataSerializer : new UdpDataSerializer();
            this.parser = dataParser != null ? dataParser : new UdpDataParser();
        }
        if (networkConfig.getInt("HEALTH_STATUS_INTERVAL", 0) > 0) {
            coapEndpointHealthLogger = coapEndpointHealth == null ? new CoapEndpointHealthLogger() : coapEndpointHealth;
            zIsEnabled = coapEndpointHealthLogger.isEnabled();
        } else {
            coapEndpointHealthLogger = coapEndpointHealth;
        }
        if (zIsEnabled) {
            this.health = coapEndpointHealthLogger;
            this.requestTransmission = new InternalMessageObserverAdapter() { // from class: org.eclipse.californium.core.network.CoapEndpoint.3
                @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
                public void onSendError(Throwable th) {
                    CoapEndpoint.this.health.sendError();
                }

                @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
                public void onSent(boolean z2) {
                    CoapEndpoint.this.health.sentRequest(z2);
                }
            };
            this.responseTransmission = new InternalMessageObserverAdapter() { // from class: org.eclipse.californium.core.network.CoapEndpoint.4
                @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
                public void onSendError(Throwable th) {
                    CoapEndpoint.this.health.sendError();
                }

                @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
                public void onSent(boolean z2) {
                    CoapEndpoint.this.health.sentResponse(z2);
                }
            };
            this.rejectTransmission = new InternalMessageObserverAdapter() { // from class: org.eclipse.californium.core.network.CoapEndpoint.5
                @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
                public void onSendError(Throwable th) {
                    CoapEndpoint.this.health.sendError();
                }

                @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
                public void onSent(boolean z2) {
                    CoapEndpoint.this.health.sentReject();
                }
            };
            return;
        }
        this.health = null;
        this.requestTransmission = null;
        this.responseTransmission = null;
        this.rejectTransmission = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized CoapStackFactory getDefaultCoapStackFactory() {
        try {
            if (defaultCoapStackFactory == null) {
                defaultCoapStackFactory = STANDARD_COAP_STACK_FACTORY;
            }
        } catch (Throwable th) {
            throw th;
        }
        return defaultCoapStackFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyReceive(List<Object> list, Request request) {
        Iterator<Object> it = list.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySend(List<Object> list, Request request) {
        Iterator<Object> it = list.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runInProtocolStage(final Runnable runnable) {
        try {
            this.executor.execute(new Runnable() { // from class: org.eclipse.californium.core.network.CoapEndpoint.11
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        CoapEndpoint.LOGGER.error("{}exception in protocol stage thread: {}", CoapEndpoint.this.tag, th.getMessage(), th);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            LOGGER.debug("{} execute:", this.tag, e);
        }
    }

    public void addObserver(EndpointObserver endpointObserver) {
        this.observers.add(endpointObserver);
    }

    @Override // org.eclipse.californium.core.network.Endpoint
    public InetSocketAddress getAddress() {
        return this.connector.getAddress();
    }

    @Override // org.eclipse.californium.core.network.Endpoint
    public NetworkConfig getConfig() {
        return this.config;
    }

    @Override // org.eclipse.californium.core.network.Endpoint
    public URI getUri() {
        try {
            InetSocketAddress address = getAddress();
            return new URI(this.scheme, null, StringUtil.getUriHostname(address.getAddress()), address.getPort(), null, null, null);
        } catch (URISyntaxException e) {
            LOGGER.warn("{}URI", this.tag, e);
            return null;
        }
    }

    @Override // org.eclipse.californium.core.network.Endpoint
    public boolean isStarted() {
        return this.started;
    }

    @Override // org.eclipse.californium.core.network.Endpoint
    public void sendEmptyMessage(final Exchange exchange, final EmptyMessage emptyMessage) {
        if (!this.started) {
            emptyMessage.cancel();
            return;
        }
        if (this.rejectTransmission != null && emptyMessage.getType() == CoAP.Type.RST) {
            emptyMessage.addMessageObserver(this.rejectTransmission);
        }
        if (exchange.checkOwner()) {
            this.coapstack.sendEmptyMessage(exchange, emptyMessage);
        } else {
            exchange.execute(new Runnable() { // from class: org.eclipse.californium.core.network.CoapEndpoint.10
                @Override // java.lang.Runnable
                public void run() {
                    CoapEndpoint.this.coapstack.sendEmptyMessage(exchange, emptyMessage);
                }
            });
        }
    }

    @Override // org.eclipse.californium.core.network.Endpoint
    public void sendRequest(final Request request) {
        if (!this.started) {
            request.cancel();
            return;
        }
        request.prepareDestinationContext();
        InetSocketAddress peerAddress = request.getDestinationContext().getPeerAddress();
        boolean zIsMulticast = request.isMulticast();
        int i = this.multicastBaseMid;
        if (zIsMulticast) {
            if (i <= 0) {
                LOGGER.warn("{}multicast messaging to destination {} is not enabled! Please enable it configuring \"MULTICAST_BASE_MID\" greater than 0", this.tag, peerAddress);
                request.setSendError(new IllegalArgumentException("multicast is not enabled!"));
                return;
            } else if (request.getType() == CoAP.Type.CON) {
                LOGGER.warn("{}CON request to multicast destination {} is not allowed, as per RFC 7252, 8.1, a client MUST use NON message type for multicast requests ", this.tag, peerAddress);
                request.setSendError(new IllegalArgumentException("multicast is not supported for CON!"));
                return;
            } else if (request.hasMID() && request.getMID() < this.multicastBaseMid) {
                LOGGER.warn("{}multicast request to group {} has mid {} which is not in the MULTICAST_MID range [{}-65535]", this.tag, peerAddress, Integer.valueOf(request.getMID()), Integer.valueOf(this.multicastBaseMid));
                request.setSendError(new IllegalArgumentException(FileInsert$$ExternalSyntheticOutline0.m(this.multicastBaseMid, "-65535]", new StringBuilder("multicast mid is not in range ["))));
                return;
            }
        } else if (i > 0 && request.getMID() >= this.multicastBaseMid) {
            LOGGER.warn("{}request to {} has mid {}, which is in the MULTICAST_MID range [{}-65535]", this.tag, peerAddress, Integer.valueOf(request.getMID()), Integer.valueOf(this.multicastBaseMid));
            request.setSendError(new IllegalArgumentException(FileInsert$$ExternalSyntheticOutline0.m(this.multicastBaseMid, "-65535]", new StringBuilder("unicast mid is in multicast range ["))));
            return;
        }
        if (!peerAddress.isUnresolved()) {
            final Exchange exchange = new Exchange(request, Exchange.Origin.LOCAL, this.executor);
            exchange.execute(new Runnable() { // from class: org.eclipse.californium.core.network.CoapEndpoint.8
                @Override // java.lang.Runnable
                public void run() {
                    if (CoapEndpoint.this.requestTransmission != null) {
                        request.addMessageObserver(CoapEndpoint.this.requestTransmission);
                    }
                    CoapEndpoint.this.coapstack.sendRequest(exchange, request);
                }
            });
            return;
        }
        LOGGER.warn("{}request has unresolved destination address", this.tag, peerAddress);
        request.setSendError(new IllegalArgumentException(peerAddress + " is a unresolved address!"));
    }

    public void setExecutors(ScheduledExecutorService scheduledExecutorService, ScheduledExecutorService scheduledExecutorService2) {
        if (scheduledExecutorService == null || scheduledExecutorService2 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("executors must not be null");
            return;
        }
        if (this.executor == scheduledExecutorService && this.secondaryExecutor == scheduledExecutorService2) {
            return;
        }
        if (this.started) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("endpoint already started!");
            return;
        }
        this.executor = scheduledExecutorService;
        this.secondaryExecutor = scheduledExecutorService2;
        this.coapstack.setExecutors(scheduledExecutorService, scheduledExecutorService2);
        this.exchangeStore.setExecutor(this.secondaryExecutor);
        this.observationStore.setExecutor(this.secondaryExecutor);
    }

    public void setMessageDeliverer(MessageDeliverer messageDeliverer) {
        this.coapstack.setDeliverer(messageDeliverer);
    }

    @Override // org.eclipse.californium.core.network.Endpoint
    public synchronized void start() {
        if (this.started) {
            LOGGER.debug("{}Endpoint at {} is already started", this.tag, getUri());
            return;
        }
        if (!this.coapstack.hasDeliverer()) {
            setMessageDeliverer(new EndpointManager.ClientMessageDeliverer());
        }
        if (this.executor == null) {
            LOGGER.info("{}Endpoint [{}] requires an executor to start, using default single-threaded daemon executor", this.tag, getUri());
            final ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = ExecutorsUtil.newSingleThreadScheduledExecutor(new DaemonThreadFactory(":CoapEndpoint-" + this.connector + '#'));
            setExecutors(scheduledExecutorServiceNewSingleThreadScheduledExecutor, scheduledExecutorServiceNewSingleThreadScheduledExecutor);
            addObserver(new EndpointObserver() { // from class: org.eclipse.californium.core.network.CoapEndpoint.6
                @Override // org.eclipse.californium.core.network.EndpointObserver
                public void started(Endpoint endpoint) {
                }

                @Override // org.eclipse.californium.core.network.EndpointObserver
                public void stopped(Endpoint endpoint) {
                }
            });
        }
        try {
            LOGGER.debug("{}Starting endpoint at {}", this.tag, getUri());
            this.matcher.start();
            startMulticastReceivers();
            this.connector.start();
            this.coapstack.start();
            this.started = true;
            Iterator<EndpointObserver> it = this.observers.iterator();
            while (it.hasNext()) {
                it.next().started(this);
            }
            LOGGER.info("{}Started endpoint at {}", this.tag, getUri());
            if (this.health != null && this.secondaryExecutor != null) {
                long j = this.config.getInt("HEALTH_STATUS_INTERVAL", 0);
                this.statusLogger = this.secondaryExecutor.scheduleAtFixedRate(new Runnable() { // from class: org.eclipse.californium.core.network.CoapEndpoint.7
                    @Override // java.lang.Runnable
                    public void run() {
                        CoapEndpoint.this.health.dump(CoapEndpoint.this.tag);
                    }
                }, j, j, TimeUnit.SECONDS);
            }
        } catch (IOException e) {
            stop();
            throw e;
        }
    }

    public void startMulticastReceivers() {
        Iterator<Connector> it = this.multicastReceivers.iterator();
        while (it.hasNext()) {
            it.next().start();
        }
    }

    public synchronized void stop() {
        try {
            if (this.started) {
                LOGGER.info("{}Stopping endpoint at {}", this.tag, getUri());
                this.started = false;
                ScheduledFuture<?> scheduledFuture = this.statusLogger;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                    this.statusLogger = null;
                }
                Iterator<Connector> it = this.multicastReceivers.iterator();
                while (it.hasNext()) {
                    it.next().stop();
                }
                this.connector.stop();
                this.matcher.stop();
                Iterator<EndpointObserver> it2 = this.observers.iterator();
                while (it2.hasNext()) {
                    it2.next().stopped(this);
                }
            } else {
                LOGGER.info("{}Endpoint at {} is already stopped", this.tag, getUri());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static abstract class SendingCallback<T extends Message> implements MessageCallback {
        private final T message;

        public SendingCallback(T t) {
            if (t != null) {
                this.message = t;
            } else {
                Types$$ExternalSyntheticBUOutline0.m$1("message must not be null");
                throw null;
            }
        }

        public abstract void notifyPostProcess(T t);

        @Override // org.eclipse.californium.elements.MessageCallback
        public void onConnecting() {
            this.message.onConnecting();
        }

        @Override // org.eclipse.californium.elements.MessageCallback
        public final void onContextEstablished(EndpointContext endpointContext) {
            long jNanoRealtime = ClockUtil.nanoRealtime();
            this.message.setNanoTimestamp(jNanoRealtime);
            onContextEstablished(endpointContext, jNanoRealtime);
        }

        @Override // org.eclipse.californium.elements.MessageCallback
        public void onDtlsRetransmission(int i) {
            this.message.onDtlsRetransmission(i);
        }

        @Override // org.eclipse.californium.elements.MessageCallback
        public void onError(Throwable th) {
            this.message.setSendError(th);
            notifyPostProcess(this.message);
        }

        @Override // org.eclipse.californium.elements.MessageCallback
        public void onSent() {
            if (this.message.isSent()) {
                this.message.setDuplicate(true);
            }
            this.message.setSent(true);
            notifyPostProcess(this.message);
        }

        public void onContextEstablished(EndpointContext endpointContext, long j) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyReceive(List<Object> list, Response response) {
        Iterator<Object> it = list.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySend(List<Object> list, Response response) {
        Iterator<Object> it = list.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyReceive(List<Object> list, EmptyMessage emptyMessage) {
        Iterator<Object> it = list.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySend(List<Object> list, EmptyMessage emptyMessage) {
        Iterator<Object> it = list.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
    }

    public CoapEndpoint(Connector connector, boolean z, NetworkConfig networkConfig, TokenGenerator tokenGenerator, ObservationStore observationStore, MessageExchangeStore messageExchangeStore, EndpointContextMatcher endpointContextMatcher, DataSerializer dataSerializer, DataParser dataParser, String str, CoapStackFactory coapStackFactory, Object obj) {
        this(connector, z, networkConfig, tokenGenerator, observationStore, messageExchangeStore, endpointContextMatcher, dataSerializer, dataParser, str, null, coapStackFactory, obj);
    }
}
