package org.eclipse.californium.core.network;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.net.InetSocketAddress;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.coap.BlockOption;
import org.eclipse.californium.core.coap.Message;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.coap.Token;
import org.eclipse.californium.core.network.TokenGenerator;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.network.deduplication.Deduplicator;
import org.eclipse.californium.core.network.deduplication.DeduplicatorFactory;
import org.eclipse.californium.elements.EndpointIdentityResolver;
import org.eclipse.californium.elements.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class InMemoryMessageExchangeStore implements MessageExchangeStore {
    private static final Logger HEALTH_LOGGER;
    private static final Logger LOGGER;
    private final NetworkConfig config;
    private volatile Deduplicator deduplicator;
    private volatile boolean enableStatus;
    private final EndpointIdentityResolver endpointIdentityResolver;
    private ScheduledExecutorService executor;
    private volatile MessageIdProvider messageIdProvider;
    private ScheduledFuture<?> statusLogger;
    private final String tag;
    private final TokenGenerator tokenGenerator;
    private final ConcurrentMap<KeyMID, Exchange> exchangesByMID = new ConcurrentHashMap();
    private final ConcurrentMap<KeyToken, Exchange> exchangesByToken = new ConcurrentHashMap();
    private volatile boolean running = false;

    static {
        Logger logger = LoggerFactory.getLogger((Class<?>) InMemoryMessageExchangeStore.class);
        LOGGER = logger;
        HEALTH_LOGGER = LoggerFactory.getLogger(logger.getName() + ".health");
    }

    public InMemoryMessageExchangeStore(String str, NetworkConfig networkConfig, TokenGenerator tokenGenerator, EndpointIdentityResolver endpointIdentityResolver) {
        if (networkConfig == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Configuration must not be null");
            throw null;
        }
        if (tokenGenerator == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("TokenProvider must not be null");
            throw null;
        }
        if (endpointIdentityResolver == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("EndpointContextResolver must not be null");
            throw null;
        }
        this.tokenGenerator = tokenGenerator;
        this.endpointIdentityResolver = endpointIdentityResolver;
        this.config = networkConfig;
        this.tag = StringUtil.normalizeLoggingTag(str);
        LOGGER.debug("{}using TokenProvider {}", str, tokenGenerator.getClass().getName());
    }

    private String dumpCurrentLoadLevels() {
        return this.tag + "MessageExchangeStore contents: " + this.exchangesByMID.size() + " exchanges by MID, " + this.exchangesByToken.size() + " exchanges by token, " + this.deduplicator.size() + " MIDs.";
    }

    private <K> void dumpExchanges(int i, Set<Map.Entry<K, Exchange>> set) {
        for (Map.Entry<K, Exchange> entry : set) {
            Exchange value = entry.getValue();
            Request request = value.getRequest();
            Request currentRequest = value.getCurrentRequest();
            String str = value.getRetransmissionHandle() == null ? "" : "/pending";
            if (request == null || request == currentRequest || request.getToken().equals(currentRequest.getToken())) {
                HEALTH_LOGGER.debug("  {}, {}, retransmission {}{}, {}{}, {}", entry.getKey(), value, Integer.valueOf(value.getFailedTransmissionCount()), str, request == null ? "(missing origin request) " : "", currentRequest, value.getCurrentResponse());
            } else {
                HEALTH_LOGGER.debug("  {}, {}, retransmission {}{}, org {}, {}, {}", entry.getKey(), value, Integer.valueOf(value.getFailedTransmissionCount()), str, request.getToken(), currentRequest, value.getCurrentResponse());
            }
            Throwable caller = value.getCaller();
            if (caller != null) {
                HEALTH_LOGGER.trace("  ", caller);
            }
            i--;
            if (i <= 0) {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private KeyMID registerWithMessageId(Exchange exchange, Message message) {
        KeyMID keyMID;
        this.enableStatus = true;
        exchange.assertIncomplete(message);
        Object endpointIdentity = this.endpointIdentityResolver.getEndpointIdentity(message.getDestinationContext());
        int mid = message.getMID();
        KeyMID keyMID2 = null;
        if (-1 == mid) {
            int iAssignMessageId = assignMessageId(message);
            if (-1 != iAssignMessageId) {
                keyMID = new KeyMID(iAssignMessageId, endpointIdentity);
                if (this.exchangesByMID.putIfAbsent(keyMID, exchange) != null) {
                    Home$$ExternalSyntheticBUOutline0.m("generated mid [%d] already in use, cannot register %s", new Object[]{Integer.valueOf(iAssignMessageId), exchange});
                    return null;
                }
                LOGGER.debug("{}{} added with generated mid {}, {}", this.tag, exchange, keyMID, message);
            }
            if (keyMID2 != null) {
                exchange.setKeyMID(keyMID2);
            }
            return keyMID2;
        }
        keyMID = new KeyMID(mid, endpointIdentity);
        Exchange exchangePutIfAbsent = this.exchangesByMID.putIfAbsent(keyMID, exchange);
        if (exchangePutIfAbsent == null) {
            LOGGER.debug("{}{} added with {}, {}", this.tag, exchange, keyMID, message);
        } else {
            if (exchangePutIfAbsent != exchange) {
                Home$$ExternalSyntheticBUOutline0.m("mid [%d] already in use, cannot register %s", new Object[]{Integer.valueOf(mid), exchange});
                return null;
            }
            if (exchange.getFailedTransmissionCount() == 0) {
                Home$$ExternalSyntheticBUOutline0.m("message with already registered mid [%d] is not a re-transmission, cannot register %s", new Object[]{Integer.valueOf(mid), exchange});
                return null;
            }
        }
        keyMID2 = keyMID;
        if (keyMID2 != null) {
        }
        return keyMID2;
    }

    private void registerWithToken(Exchange exchange) {
        KeyToken keyToken;
        this.enableStatus = true;
        Request currentRequest = exchange.getCurrentRequest();
        exchange.assertIncomplete(currentRequest);
        Object endpointIdentity = this.endpointIdentityResolver.getEndpointIdentity(currentRequest.getDestinationContext());
        Token token = currentRequest.getToken();
        if (token == null) {
            TokenGenerator.Scope scope = currentRequest.isMulticast() ? TokenGenerator.Scope.SHORT_TERM : TokenGenerator.Scope.SHORT_TERM_CLIENT_LOCAL;
            do {
                Token tokenCreateToken = this.tokenGenerator.createToken(scope);
                currentRequest.setToken(tokenCreateToken);
                keyToken = this.tokenGenerator.getKeyToken(tokenCreateToken, endpointIdentity);
            } while (this.exchangesByToken.putIfAbsent(keyToken, exchange) != null);
            LOGGER.debug("{}{} added with generated token {}, {}", this.tag, exchange, keyToken, currentRequest);
        } else {
            if (token.isEmpty() && currentRequest.getCode() == null) {
                return;
            }
            keyToken = this.tokenGenerator.getKeyToken(token, endpointIdentity);
            Exchange exchangePut = this.exchangesByToken.put(keyToken, exchange);
            if (exchangePut == null) {
                BlockOption block2 = currentRequest.getOptions().getBlock2();
                String str = this.tag;
                if (block2 != null) {
                    LOGGER.debug("{}block2 {} for block {} add with token {}", str, exchange, Integer.valueOf(block2.getNum()), keyToken);
                } else {
                    LOGGER.debug("{}{} added with token {}, {}", str, exchange, keyToken, currentRequest);
                }
            } else if (exchangePut == exchange) {
                LOGGER.debug("{}{} keep for {}, {}", this.tag, exchange, keyToken, currentRequest);
            } else if (exchange.getFailedTransmissionCount() != 0 || currentRequest.getOptions().hasBlock1() || currentRequest.getOptions().hasBlock2() || currentRequest.getOptions().hasObserve()) {
                LOGGER.debug("{}{} replaced with token {}, {}", this.tag, exchange, keyToken, currentRequest);
            } else {
                LOGGER.warn("{}{} with manual token overrides existing {} with open request: {}", this.tag, exchange, exchangePut, keyToken);
            }
        }
        if (keyToken != null) {
            exchange.setKeyToken(keyToken);
        }
    }

    private void startStatusLogging() {
        ScheduledExecutorService scheduledExecutorService;
        int i = this.config.getInt("HEALTH_STATUS_INTERVAL", 0);
        if (i <= 0 || !HEALTH_LOGGER.isDebugEnabled() || (scheduledExecutorService = this.executor) == null) {
            return;
        }
        long j = i;
        this.statusLogger = scheduledExecutorService.scheduleAtFixedRate(new Runnable() { // from class: org.eclipse.californium.core.network.InMemoryMessageExchangeStore.1
            @Override // java.lang.Runnable
            public void run() {
                if (InMemoryMessageExchangeStore.this.enableStatus) {
                    InMemoryMessageExchangeStore.this.dump(5);
                }
            }
        }, j, j, TimeUnit.SECONDS);
    }

    @Override // org.eclipse.californium.core.network.MessageExchangeStore
    public int assignMessageId(Message message) {
        int mid = message.getMID();
        if (-1 != mid) {
            return mid;
        }
        InetSocketAddress peerAddress = message.getDestinationContext().getPeerAddress();
        int nextMessageId = this.messageIdProvider.getNextMessageId(peerAddress);
        if (-1 == nextMessageId) {
            LOGGER.warn("{}cannot send message to {}, all MIDs are in use", this.tag, peerAddress);
            return nextMessageId;
        }
        message.setMID(nextMessageId);
        return nextMessageId;
    }

    public void dump(int i) {
        Logger logger = HEALTH_LOGGER;
        if (logger.isDebugEnabled()) {
            logger.debug(dumpCurrentLoadLevels());
            if (i > 0) {
                if (!this.exchangesByMID.isEmpty()) {
                    dumpExchanges(i, this.exchangesByMID.entrySet());
                }
                if (this.exchangesByToken.isEmpty()) {
                    return;
                }
                dumpExchanges(i, this.exchangesByToken.entrySet());
            }
        }
    }

    @Override // org.eclipse.californium.core.network.MessageExchangeStore
    public Exchange find(KeyMID keyMID) {
        return this.deduplicator.find(keyMID);
    }

    @Override // org.eclipse.californium.core.network.MessageExchangeStore
    public Exchange findPrevious(KeyMID keyMID, Exchange exchange) {
        return this.deduplicator.findPrevious(keyMID, exchange);
    }

    @Override // org.eclipse.californium.core.network.MessageExchangeStore
    public Exchange get(KeyToken keyToken) {
        if (keyToken == null) {
            return null;
        }
        return this.exchangesByToken.get(keyToken);
    }

    @Override // org.eclipse.californium.core.network.MessageExchangeStore
    public boolean registerOutboundRequest(Exchange exchange) {
        if (exchange == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("exchange must not be null");
            return false;
        }
        if (exchange.getCurrentRequest() == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("exchange does not contain a request");
            return false;
        }
        Request currentRequest = exchange.getCurrentRequest();
        if (registerWithMessageId(exchange, currentRequest) == null) {
            return false;
        }
        registerWithToken(exchange);
        if (exchange.getCurrentRequest() == currentRequest) {
            return true;
        }
        throw new ConcurrentModificationException("Current request modified!");
    }

    @Override // org.eclipse.californium.core.network.MessageExchangeStore
    public boolean registerOutboundRequestWithTokenOnly(Exchange exchange) {
        if (exchange == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("exchange must not be null");
            return false;
        }
        if (exchange.getCurrentRequest() == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("exchange does not contain a request");
            return false;
        }
        Request currentRequest = exchange.getCurrentRequest();
        registerWithToken(exchange);
        if (exchange.getCurrentRequest() == currentRequest) {
            return true;
        }
        throw new ConcurrentModificationException("Current request modified!");
    }

    @Override // org.eclipse.californium.core.network.MessageExchangeStore
    public boolean registerOutboundResponse(Exchange exchange) {
        if (exchange == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("exchange must not be null");
            return false;
        }
        if (exchange.getCurrentResponse() == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("exchange does not contain a response");
            return false;
        }
        Response currentResponse = exchange.getCurrentResponse();
        if (registerWithMessageId(exchange, currentResponse) == null) {
            return false;
        }
        if (exchange.getCurrentResponse() == currentResponse) {
            return true;
        }
        throw new ConcurrentModificationException("Current response modified!");
    }

    @Override // org.eclipse.californium.core.network.MessageExchangeStore
    public Exchange remove(KeyMID keyMID, Exchange exchange) {
        ConcurrentMap<KeyMID, Exchange> concurrentMap = this.exchangesByMID;
        if (exchange == null) {
            exchange = concurrentMap.remove(keyMID);
        } else if (!concurrentMap.remove(keyMID, exchange)) {
            exchange = null;
        }
        if (exchange != null) {
            LOGGER.debug("{}removing {} for MID {}", this.tag, exchange, keyMID);
        }
        return exchange;
    }

    @Override // org.eclipse.californium.core.network.MessageExchangeStore
    public boolean replacePrevious(KeyMID keyMID, Exchange exchange, Exchange exchange2) {
        return this.deduplicator.replacePrevious(keyMID, exchange, exchange2);
    }

    @Override // org.eclipse.californium.core.network.MessageExchangeStore
    public synchronized void setExecutor(ScheduledExecutorService scheduledExecutorService) {
        if (this.running) {
            throw new IllegalStateException("Cannot set messageIdProvider when store is already started");
        }
        this.executor = scheduledExecutorService;
    }

    @Override // org.eclipse.californium.core.network.MessageExchangeStore
    public synchronized void start() {
        try {
            if (!this.running) {
                startStatusLogging();
                if (this.deduplicator == null) {
                    this.deduplicator = DeduplicatorFactory.getDeduplicatorFactory().createDeduplicator(this.config);
                }
                this.deduplicator.setExecutor(this.executor);
                this.deduplicator.start();
                if (this.messageIdProvider == null) {
                    LOGGER.debug("{}no MessageIdProvider set, using default {}", this.tag, InMemoryMessageIdProvider.class.getName());
                    this.messageIdProvider = new InMemoryMessageIdProvider(this.config);
                }
                this.running = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.eclipse.californium.core.network.MessageExchangeStore
    public synchronized void stop() {
        try {
            if (this.running) {
                this.running = false;
                Iterator<Exchange> it = this.exchangesByMID.values().iterator();
                while (it.hasNext()) {
                    it.next().getRequest().setCanceled(true);
                }
                ScheduledFuture<?> scheduledFuture = this.statusLogger;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                    this.statusLogger = null;
                }
                this.deduplicator.stop();
                this.exchangesByMID.clear();
                this.exchangesByToken.clear();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String toString() {
        return dumpCurrentLoadLevels();
    }

    @Override // org.eclipse.californium.core.network.MessageExchangeStore
    public Exchange get(KeyMID keyMID) {
        if (keyMID == null) {
            return null;
        }
        return this.exchangesByMID.get(keyMID);
    }

    @Override // org.eclipse.californium.core.network.MessageExchangeStore
    public void remove(KeyToken keyToken, Exchange exchange) {
        if (this.exchangesByToken.remove(keyToken, exchange)) {
            LOGGER.debug("{}removing {} for token {}", this.tag, exchange, keyToken);
        }
    }
}
