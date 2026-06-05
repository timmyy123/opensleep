package org.eclipse.californium.core.network.stack;

import com.facebook.internal.Utility;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.californium.core.coap.BlockOption;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.Message;
import org.eclipse.californium.core.coap.MessageObserver;
import org.eclipse.californium.core.coap.MessageObserverAdapter;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.coap.Token;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.elements.util.LeastRecentlyUsedCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class BlockwiseLayer extends AbstractLayer {
    private static final Logger HEALTH_LOGGER;
    private static final Logger LOGGER;
    private final LeastRecentlyUsedCache<KeyUri, Block1BlockwiseStatus> block1Transfers;
    private final LeastRecentlyUsedCache<KeyUri, Block2BlockwiseStatus> block2Transfers;
    private int blockTimeout;
    private boolean enableAutoFailoverOn413;
    private volatile boolean enableStatus;
    private int healthStatusInterval;
    private final AtomicInteger ignoredBlock2 = new AtomicInteger();
    private int maxMessageSize;
    private int maxResourceBodySize;
    private int preferredBlockSize;
    private int preferredBlockSzx;
    private ScheduledFuture<?> statusLogger;
    private boolean strictBlock2Option;

    /* JADX INFO: renamed from: org.eclipse.californium.core.network.stack.BlockwiseLayer$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$core$coap$CoAP$ResponseCode;

        static {
            int[] iArr = new int[CoAP.ResponseCode.values().length];
            $SwitchMap$org$eclipse$californium$core$coap$CoAP$ResponseCode = iArr;
            try {
                iArr[CoAP.ResponseCode.REQUEST_ENTITY_INCOMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$core$coap$CoAP$ResponseCode[CoAP.ResponseCode.REQUEST_ENTITY_TOO_LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        Logger logger = LoggerFactory.getLogger((Class<?>) BlockwiseLayer.class);
        LOGGER = logger;
        HEALTH_LOGGER = LoggerFactory.getLogger(logger.getName() + ".health");
    }

    public BlockwiseLayer(NetworkConfig networkConfig) {
        this.maxMessageSize = networkConfig.getInt("MAX_MESSAGE_SIZE", 1024);
        int i = networkConfig.getInt("PREFERRED_BLOCK_SIZE", 512);
        this.preferredBlockSize = i;
        this.preferredBlockSzx = BlockOption.size2Szx(i);
        this.blockTimeout = networkConfig.getInt("BLOCKWISE_STATUS_LIFETIME", 300000);
        this.maxResourceBodySize = networkConfig.getInt("MAX_RESOURCE_BODY_SIZE", Utility.DEFAULT_STREAM_BUFFER_SIZE);
        int i2 = networkConfig.getInt("MAX_ACTIVE_PEERS", 150000);
        LeastRecentlyUsedCache<KeyUri, Block1BlockwiseStatus> leastRecentlyUsedCache = new LeastRecentlyUsedCache<>(i2, ((long) this.blockTimeout) / 1000);
        this.block1Transfers = leastRecentlyUsedCache;
        leastRecentlyUsedCache.setEvictingOnReadAccess(false);
        LeastRecentlyUsedCache<KeyUri, Block2BlockwiseStatus> leastRecentlyUsedCache2 = new LeastRecentlyUsedCache<>(i2, ((long) this.blockTimeout) / 1000);
        this.block2Transfers = leastRecentlyUsedCache2;
        leastRecentlyUsedCache2.setEvictingOnReadAccess(false);
        this.strictBlock2Option = networkConfig.getBoolean("BLOCKWISE_STRICT_BLOCK2_OPTION", false);
        this.healthStatusInterval = networkConfig.getInt("HEALTH_STATUS_INTERVAL", 60);
        this.enableAutoFailoverOn413 = networkConfig.getBoolean("BLOCKWISE_ENTITY_TOO_LARGE_AUTO_FAILOVER", true);
        LOGGER.info("BlockwiseLayer uses MAX_MESSAGE_SIZE={}, PREFERRED_BLOCK_SIZE={}, BLOCKWISE_STATUS_LIFETIME={}, MAX_RESOURCE_BODY_SIZE={}, BLOCKWISE_STRICT_BLOCK2_OPTION={}", Integer.valueOf(this.maxMessageSize), Integer.valueOf(this.preferredBlockSize), Integer.valueOf(this.blockTimeout), Integer.valueOf(this.maxResourceBodySize), Boolean.valueOf(this.strictBlock2Option));
    }

    private MessageObserver addBlock1CleanUpObserver(Request request, final KeyUri keyUri, final Block1BlockwiseStatus block1BlockwiseStatus) {
        MessageObserverAdapter messageObserverAdapter = new MessageObserverAdapter() { // from class: org.eclipse.californium.core.network.stack.BlockwiseLayer.4
            @Override // org.eclipse.californium.core.coap.MessageObserverAdapter
            public void failed() {
                BlockwiseLayer.this.clearBlock1Status(keyUri, block1BlockwiseStatus);
            }

            @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
            public void onCancel() {
                BlockwiseLayer.this.clearBlock1Status(keyUri, block1BlockwiseStatus);
            }
        };
        request.addMessageObserver(messageObserverAdapter);
        return messageObserverAdapter;
    }

    private MessageObserver addBlock2CleanUpObserver(Request request, final KeyUri keyUri, final Block2BlockwiseStatus block2BlockwiseStatus) {
        MessageObserverAdapter messageObserverAdapter = new MessageObserverAdapter() { // from class: org.eclipse.californium.core.network.stack.BlockwiseLayer.5
            @Override // org.eclipse.californium.core.coap.MessageObserverAdapter
            public void failed() {
                BlockwiseLayer.this.clearBlock2Status(keyUri, block2BlockwiseStatus);
            }

            @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
            public void onCancel() {
                BlockwiseLayer.this.clearBlock2Status(keyUri, block2BlockwiseStatus);
            }
        };
        request.addMessageObserver(messageObserverAdapter);
        return messageObserverAdapter;
    }

    private KeyUri addRandomAccessBlock2Status(Exchange exchange, Request request) {
        int size;
        KeyUri key = getKey(exchange, request);
        Block2BlockwiseStatus block2BlockwiseStatusForRandomAccessRequest = Block2BlockwiseStatus.forRandomAccessRequest(exchange, request);
        synchronized (this.block2Transfers) {
            this.block2Transfers.put(key, block2BlockwiseStatusForRandomAccessRequest);
            size = this.block1Transfers.size();
        }
        this.enableStatus = true;
        addBlock2CleanUpObserver(request, key, block2BlockwiseStatusForRandomAccessRequest);
        LOGGER.debug("created tracker for random access block2 retrieval {}, transfers in progress: {}", block2BlockwiseStatusForRandomAccessRequest, Integer.valueOf(size));
        return key;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Block1BlockwiseStatus clearBlock1Status(KeyUri keyUri, Block1BlockwiseStatus block1BlockwiseStatus) {
        Block1BlockwiseStatus block1BlockwiseStatusRemove;
        int size;
        synchronized (this.block1Transfers) {
            block1BlockwiseStatusRemove = this.block1Transfers.remove(keyUri, block1BlockwiseStatus);
            size = this.block1Transfers.size();
        }
        if (block1BlockwiseStatusRemove != null) {
            LOGGER.debug("removing block1 tracker [{}], block1 transfers still in progress: {}", keyUri, Integer.valueOf(size));
            block1BlockwiseStatusRemove.setComplete(true);
        }
        return block1BlockwiseStatusRemove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Block2BlockwiseStatus clearBlock2Status(KeyUri keyUri, Block2BlockwiseStatus block2BlockwiseStatus) {
        Block2BlockwiseStatus block2BlockwiseStatusRemove;
        int size;
        synchronized (this.block2Transfers) {
            block2BlockwiseStatusRemove = this.block2Transfers.remove(keyUri, block2BlockwiseStatus);
            size = this.block2Transfers.size();
        }
        if (block2BlockwiseStatusRemove != null) {
            LOGGER.debug("removing block2 tracker [{}], block2 transfers still in progress: {}", keyUri, Integer.valueOf(size));
            block2BlockwiseStatusRemove.setComplete(true);
        }
        return block2BlockwiseStatusRemove;
    }

    private boolean discardBlock2(KeyUri keyUri, Block2BlockwiseStatus block2BlockwiseStatus, Exchange exchange, Response response) {
        BlockOption block2 = response.getOptions().getBlock2();
        if (block2BlockwiseStatus == null) {
            if (block2 == null || block2.getNum() == 0) {
                return false;
            }
            LOGGER.debug("discarding stale block2 response [{}, {}] received without ongoing block2 transfer for {}", exchange.getNotificationNumber(), response, keyUri);
            exchange.setComplete();
            return true;
        }
        if (block2 != null && block2.getNum() != 0) {
            if (block2BlockwiseStatus.matchTransfer(exchange)) {
                return false;
            }
            LOGGER.debug("discarding outdate block2 response [{}, {}] received during ongoing block2 transfer {}", exchange.getNotificationNumber(), response, block2BlockwiseStatus.getObserve());
            block2BlockwiseStatus.completeNewTranfer(exchange);
            return true;
        }
        if (!block2BlockwiseStatus.isNew(response)) {
            LOGGER.debug("discarding old block2 transfer [{}], received during ongoing block2 transfer {}", response, block2BlockwiseStatus.getObserve());
            block2BlockwiseStatus.completeNewTranfer(exchange);
            return true;
        }
        LOGGER.debug("discarding outdated block2 transfer {}, current is [{}]", block2BlockwiseStatus.getObserve(), response);
        clearBlock2Status(keyUri, block2BlockwiseStatus);
        block2BlockwiseStatus.completeOldTransfer(exchange);
        return false;
    }

    private Block1BlockwiseStatus getBlock1Status(KeyUri keyUri) {
        Block1BlockwiseStatus block1BlockwiseStatus;
        synchronized (this.block1Transfers) {
            block1BlockwiseStatus = this.block1Transfers.get(keyUri);
        }
        return block1BlockwiseStatus;
    }

    private Block2BlockwiseStatus getBlock2Status(KeyUri keyUri) {
        Block2BlockwiseStatus block2BlockwiseStatus;
        synchronized (this.block2Transfers) {
            block2BlockwiseStatus = this.block2Transfers.get(keyUri);
        }
        return block2BlockwiseStatus;
    }

    private Block1BlockwiseStatus getInboundBlock1Status(KeyUri keyUri, Exchange exchange, Request request) {
        Block1BlockwiseStatus block1BlockwiseStatusForInboundRequest;
        int maxResourceBodySize = getMaxResourceBodySize(request);
        synchronized (this.block1Transfers) {
            try {
                block1BlockwiseStatusForInboundRequest = this.block1Transfers.get(keyUri);
                if (block1BlockwiseStatusForInboundRequest == null) {
                    block1BlockwiseStatusForInboundRequest = Block1BlockwiseStatus.forInboundRequest(exchange, request, maxResourceBodySize);
                    this.block1Transfers.put(keyUri, block1BlockwiseStatusForInboundRequest);
                    this.enableStatus = true;
                    LOGGER.debug("created tracker for inbound block1 transfer {}, transfers in progress: {}", block1BlockwiseStatusForInboundRequest, Integer.valueOf(this.block1Transfers.size()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        prepareBlock1Cleanup(block1BlockwiseStatusForInboundRequest, keyUri);
        return block1BlockwiseStatusForInboundRequest;
    }

    private Block2BlockwiseStatus getInboundBlock2Status(KeyUri keyUri, Exchange exchange, Response response) {
        Block2BlockwiseStatus block2BlockwiseStatusForInboundResponse;
        int maxResourceBodySize = getMaxResourceBodySize(response);
        synchronized (this.block2Transfers) {
            try {
                block2BlockwiseStatusForInboundResponse = this.block2Transfers.get(keyUri);
                if (block2BlockwiseStatusForInboundResponse == null) {
                    block2BlockwiseStatusForInboundResponse = Block2BlockwiseStatus.forInboundResponse(exchange, response, maxResourceBodySize);
                    this.block2Transfers.put(keyUri, block2BlockwiseStatusForInboundResponse);
                    this.enableStatus = true;
                    LOGGER.debug("created tracker for {} inbound block2 transfer {}, transfers in progress: {}, {}", keyUri, block2BlockwiseStatusForInboundResponse, Integer.valueOf(this.block2Transfers.size()), response);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return block2BlockwiseStatusForInboundResponse;
    }

    private static KeyUri getKey(Exchange exchange, Response response) {
        return exchange.isOfLocalOrigin() ? KeyUri.fromInboundResponse(exchange.getRequest(), response) : KeyUri.fromOutboundResponse(exchange.getRequest(), response);
    }

    private int getMaxResourceBodySize(Message message) {
        int maxResourceBodySize = message.getMaxResourceBodySize();
        return maxResourceBodySize == 0 ? this.maxResourceBodySize : maxResourceBodySize;
    }

    private Block1BlockwiseStatus getOutboundBlock1Status(KeyUri keyUri, Exchange exchange, Request request, int i) {
        Block1BlockwiseStatus block1BlockwiseStatusForOutboundRequest;
        synchronized (this.block1Transfers) {
            try {
                block1BlockwiseStatusForOutboundRequest = this.block1Transfers.get(keyUri);
                if (block1BlockwiseStatusForOutboundRequest == null) {
                    block1BlockwiseStatusForOutboundRequest = Block1BlockwiseStatus.forOutboundRequest(exchange, request, i);
                    this.block1Transfers.put(keyUri, block1BlockwiseStatusForOutboundRequest);
                    this.enableStatus = true;
                    LOGGER.debug("created tracker for outbound block1 transfer {}, transfers in progress: {}", block1BlockwiseStatusForOutboundRequest, Integer.valueOf(this.block1Transfers.size()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return block1BlockwiseStatusForOutboundRequest;
    }

    private Block2BlockwiseStatus getOutboundBlock2Status(KeyUri keyUri, Exchange exchange, Response response) {
        Block2BlockwiseStatus block2BlockwiseStatusForOutboundResponse;
        synchronized (this.block2Transfers) {
            try {
                block2BlockwiseStatusForOutboundResponse = this.block2Transfers.get(keyUri);
                if (block2BlockwiseStatusForOutboundResponse == null) {
                    block2BlockwiseStatusForOutboundResponse = Block2BlockwiseStatus.forOutboundResponse(exchange, response, this.preferredBlockSize);
                    this.block2Transfers.put(keyUri, block2BlockwiseStatusForOutboundResponse);
                    this.enableStatus = true;
                    LOGGER.debug("created tracker for outbound block2 transfer {}, transfers in progress: {}", block2BlockwiseStatusForOutboundResponse, Integer.valueOf(this.block2Transfers.size()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        prepareBlock2Cleanup(block2BlockwiseStatusForOutboundResponse, keyUri);
        return block2BlockwiseStatusForOutboundResponse;
    }

    private void handleBlock1Response(Exchange exchange, Response response) {
        BlockOption block1 = response.getOptions().getBlock1();
        Logger logger = LOGGER;
        logger.debug("received response acknowledging block1 {}", block1);
        KeyUri key = getKey(exchange, exchange.getRequest());
        Block1BlockwiseStatus block1Status = getBlock1Status(key);
        if (block1Status == null) {
            logger.debug("discarding unexpected block1 response: {}", response);
            return;
        }
        if (!block1Status.hasMatchingToken(response)) {
            logger.debug("discarding obsolete block1 response: {}", response);
            return;
        }
        if (exchange.getRequest().isCanceled()) {
            clearBlock1Status(key, block1Status);
            return;
        }
        if (block1Status.isComplete()) {
            clearBlock1Status(key, block1Status);
            if (response.getOptions().hasBlock2()) {
                logger.debug("Block1 followed by Block2 transfer");
                return;
            } else {
                exchange.setResponse(response);
                upper().receiveResponse(exchange, response);
                return;
            }
        }
        if (!block1.isM()) {
            sendNextBlock(exchange, response, key, block1Status);
        } else if (response.getCode() == CoAP.ResponseCode.CONTINUE) {
            sendNextBlock(exchange, response, key, block1Status);
        } else {
            clearBlock1Status(key, block1Status);
            exchange.getRequest().setRejected(true);
        }
    }

    private void handleBlock2Response(Exchange exchange, Response response) {
        BlockOption block2 = response.getOptions().getBlock2();
        KeyUri key = getKey(exchange, response);
        if (exchange.getRequest().isCanceled()) {
            Block2BlockwiseStatus block2Status = getBlock2Status(key);
            if (block2Status != null) {
                clearBlock2Status(key, block2Status);
            }
            if (response.isNotification()) {
                upper().receiveResponse(exchange, response);
                return;
            }
            return;
        }
        if (responseExceedsMaxBodySize(response)) {
            String str = String.format("requested resource body [%d bytes] exceeds max buffer size [%d bytes], aborting request", response.getOptions().getSize2(), Integer.valueOf(getMaxResourceBodySize(response)));
            LOGGER.debug(str);
            exchange.getRequest().setOnResponseError(new IllegalStateException(str));
            exchange.getRequest().cancel();
            return;
        }
        synchronized (this.block2Transfers) {
            try {
                if (discardBlock2(key, getBlock2Status(key), exchange, response)) {
                    return;
                }
                Block2BlockwiseStatus inboundBlock2Status = getInboundBlock2Status(key, exchange, response);
                if (block2.getNum() != inboundBlock2Status.getCurrentNum()) {
                    this.ignoredBlock2.incrementAndGet();
                    LOGGER.warn("ignoring block2 response with wrong block number {} (expected {}) - {}: {}", Integer.valueOf(block2.getNum()), Integer.valueOf(inboundBlock2Status.getCurrentNum()), exchange.getCurrentRequest().getToken(), response);
                    return;
                }
                Logger logger = LOGGER;
                logger.debug("processing incoming block2 response [num={}]: {}", Integer.valueOf(block2.getNum()), response);
                if (inboundBlock2Status.isRandomAccess()) {
                    exchange.setResponse(response);
                    clearBlock2Status(key, inboundBlock2Status);
                    upper().receiveResponse(exchange, response);
                    return;
                }
                if (!inboundBlock2Status.addBlock(response)) {
                    logger.debug("cannot process payload of block2 response, aborting request");
                    exchange.getRequest().setOnResponseError(new IllegalStateException("cannot process payload of block2 response, aborting request"));
                    exchange.getRequest().cancel();
                } else {
                    if (block2.isM()) {
                        requestNextBlock(exchange, response, key, inboundBlock2Status);
                        return;
                    }
                    logger.debug("all {} blocks have been retrieved, assembling response and delivering to application layer", Integer.valueOf(inboundBlock2Status.getBlockCount()));
                    Response response2 = new Response(response.getCode());
                    inboundBlock2Status.assembleReceivedMessage(response2);
                    response2.setRTT(exchange.calculateRTT());
                    clearBlock2Status(key, inboundBlock2Status);
                    logger.debug("assembled response: {}", response2);
                    exchange.setCurrentRequest(exchange.getRequest());
                    exchange.setResponse(response2);
                    upper().receiveResponse(exchange, response2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean handleEntityTooLarge(Exchange exchange, Response response) {
        Block1BlockwiseStatus block1Status;
        if (!this.enableAutoFailoverOn413) {
            return false;
        }
        Request requestStartBlockwiseUpload = null;
        if (!response.getOptions().hasBlock1()) {
            if (exchange.getRequest().isCanceled()) {
                return false;
            }
            synchronized (this.block1Transfers) {
                try {
                    if (getBlock1Status(getKey(exchange, exchange.getRequest())) == null) {
                        Request request = exchange.getRequest();
                        Integer numValueOf = (!response.getOptions().hasSize1() || response.getOptions().getSize1().intValue() < 16 || response.getOptions().getSize1().intValue() >= request.getPayloadSize()) ? request.getPayloadSize() > 16 ? Integer.valueOf(request.getPayloadSize() - 1) : null : response.getOptions().getSize1();
                        if (numValueOf != null) {
                            requestStartBlockwiseUpload = startBlockwiseUpload(exchange, request, Math.min(Integer.highestOneBit(numValueOf.intValue()), this.preferredBlockSize));
                        }
                    }
                } finally {
                }
            }
            if (requestStartBlockwiseUpload == null) {
                return false;
            }
            exchange.setCurrentRequest(requestStartBlockwiseUpload);
            lower().sendRequest(exchange, requestStartBlockwiseUpload);
            return true;
        }
        BlockOption block1 = response.getOptions().getBlock1();
        KeyUri key = getKey(exchange, exchange.getRequest());
        synchronized (this.block1Transfers) {
            try {
                block1Status = getBlock1Status(key);
                if (block1Status == null) {
                    Request request2 = exchange.getRequest();
                    if (!exchange.getRequest().isCanceled() && block1.getNum() == 0 && block1.getSize() < request2.getPayloadSize()) {
                        requestStartBlockwiseUpload = startBlockwiseUpload(exchange, request2, Math.min(block1.getSize(), this.preferredBlockSize));
                    }
                }
            } finally {
            }
        }
        if (block1Status == null) {
            if (requestStartBlockwiseUpload == null) {
                return false;
            }
            exchange.setCurrentRequest(requestStartBlockwiseUpload);
            lower().sendRequest(exchange, requestStartBlockwiseUpload);
            return true;
        }
        if (!block1Status.hasMatchingToken(response)) {
            LOGGER.debug("discarding obsolete block1 response: {}", response);
            return true;
        }
        if (exchange.getRequest().isCanceled()) {
            clearBlock1Status(key, block1Status);
            return true;
        }
        if (block1Status.getCurrentNum() != 0 || block1.getSize() >= block1Status.getCurrentSize()) {
            return false;
        }
        sendBlock(exchange, response, key, block1Status, 0, block1.getSzx());
        return true;
    }

    private void handleInboundBlockwiseUpload(Exchange exchange, Request request) {
        if (requestExceedsMaxBodySize(request)) {
            int maxResourceBodySize = getMaxResourceBodySize(request);
            Response responseCreateResponse = Response.createResponse(request, CoAP.ResponseCode.REQUEST_ENTITY_TOO_LARGE);
            responseCreateResponse.setPayload(String.format("body too large, can process %d bytes max", Integer.valueOf(maxResourceBodySize)));
            responseCreateResponse.getOptions().setSize1(maxResourceBodySize);
            exchange.setCurrentResponse(responseCreateResponse);
            lower().sendResponse(exchange, responseCreateResponse);
            return;
        }
        BlockOption block1 = request.getOptions().getBlock1();
        Logger logger = LOGGER;
        logger.debug("inbound request contains block1 option {}", block1);
        KeyUri key = getKey(exchange, request);
        Block1BlockwiseStatus inboundBlock1Status = getInboundBlock1Status(key, exchange, request);
        if (block1.getNum() == 0 && inboundBlock1Status.getCurrentNum() > 0) {
            inboundBlock1Status = resetInboundBlock1Status(key, exchange, request);
        }
        Block1BlockwiseStatus block1BlockwiseStatus = inboundBlock1Status;
        if (block1.getNum() != block1BlockwiseStatus.getCurrentNum()) {
            logger.warn("peer sent wrong block, expected no. {} but got {}. Responding with 4.08 (Request Entity Incomplete)", Integer.valueOf(block1BlockwiseStatus.getCurrentNum()), Integer.valueOf(block1.getNum()));
            sendBlock1ErrorResponse(key, block1BlockwiseStatus, exchange, request, CoAP.ResponseCode.REQUEST_ENTITY_INCOMPLETE, "wrong block number");
            return;
        }
        if (!block1BlockwiseStatus.hasContentFormat(request.getOptions().getContentFormat())) {
            sendBlock1ErrorResponse(key, block1BlockwiseStatus, exchange, request, CoAP.ResponseCode.REQUEST_ENTITY_INCOMPLETE, "unexpected Content-Format");
            return;
        }
        if (!block1BlockwiseStatus.addBlock(request.getPayload())) {
            sendBlock1ErrorResponse(key, block1BlockwiseStatus, exchange, request, CoAP.ResponseCode.REQUEST_ENTITY_TOO_LARGE, "body exceeded expected size " + block1BlockwiseStatus.getBufferSize());
            return;
        }
        block1BlockwiseStatus.setCurrentNum(block1BlockwiseStatus.getCurrentNum() + 1);
        if (block1.isM()) {
            logger.debug("acknowledging incoming block1 [num={}], expecting more blocks to come", Integer.valueOf(block1.getNum()));
            Response responseCreateResponse2 = Response.createResponse(request, CoAP.ResponseCode.CONTINUE);
            responseCreateResponse2.getOptions().setBlock1(block1.getSzx(), true, block1.getNum());
            exchange.setCurrentResponse(responseCreateResponse2);
            lower().sendResponse(exchange, responseCreateResponse2);
            return;
        }
        logger.debug("peer has sent last block1 [num={}], delivering request to application layer", Integer.valueOf(block1.getNum()));
        exchange.setBlock1ToAck(block1);
        Request request2 = new Request(request.getCode());
        block1BlockwiseStatus.assembleReceivedMessage(request2);
        request2.setMID(request.getMID());
        request2.setToken(request.getToken());
        request2.setScheme(request.getScheme());
        request2.getOptions().setBlock2(request.getOptions().getBlock2());
        clearBlock1Status(key, block1BlockwiseStatus);
        exchange.setRequest(request2);
        upper().receiveRequest(exchange, request2);
    }

    private void handleInboundRequestForNextBlock(Exchange exchange, Request request, KeyUri keyUri, Block2BlockwiseStatus block2BlockwiseStatus) {
        Response nextResponseBlock;
        boolean zIsComplete;
        synchronized (block2BlockwiseStatus) {
            try {
                nextResponseBlock = block2BlockwiseStatus.getNextResponseBlock(request.getOptions().getBlock2());
                zIsComplete = block2BlockwiseStatus.isComplete();
                if (!zIsComplete) {
                    prepareBlock2Cleanup(block2BlockwiseStatus, keyUri);
                    LOGGER.debug("peer has requested intermediary block of blockwise transfer: {}", block2BlockwiseStatus);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zIsComplete) {
            LOGGER.debug("peer has requested last block of blockwise transfer: {}", block2BlockwiseStatus);
            clearBlock2Status(keyUri, block2BlockwiseStatus);
        }
        exchange.setCurrentResponse(nextResponseBlock);
        lower().sendResponse(exchange, nextResponseBlock);
    }

    private boolean isTransparentBlockwiseHandlingEnabled() {
        return this.maxResourceBodySize > 0;
    }

    private boolean requestExceedsMaxBodySize(Request request) {
        return request.getOptions().hasSize1() && request.getOptions().getSize1().intValue() > getMaxResourceBodySize(request);
    }

    private void requestNextBlock(Exchange exchange, Response response, KeyUri keyUri, Block2BlockwiseStatus block2BlockwiseStatus) {
        int i;
        int currentSize = block2BlockwiseStatus.getCurrentSize();
        int szx = response.getOptions().getBlock2().getSzx();
        int currentSzx = this.preferredBlockSzx;
        if (szx > currentSzx) {
            i = this.preferredBlockSize;
        } else {
            currentSzx = block2BlockwiseStatus.getCurrentSzx();
            i = currentSize;
        }
        int currentNum = (currentSize / i) + block2BlockwiseStatus.getCurrentNum();
        Request request = exchange.getRequest();
        Request request2 = new Request(request.getCode());
        try {
            request2.setType(request.getType());
            request2.setDestinationContext(block2BlockwiseStatus.getFollowUpEndpointContext(response.getSourceContext()));
            if (!response.isNotification()) {
                request2.setToken(response.getToken());
            } else if (exchange.isNotification()) {
                request.addMessageObserver(new CleanupMessageObserver(exchange));
            }
            request2.setOptions(new OptionSet(request.getOptions()));
            request2.getOptions().setBlock2(currentSzx, false, currentNum);
            request2.getOptions().removeObserve();
            request2.addMessageObservers(request.getMessageObservers());
            addBlock2CleanUpObserver(request2, keyUri, block2BlockwiseStatus);
            block2BlockwiseStatus.setCurrentNum(currentNum);
            if (block2BlockwiseStatus.isComplete()) {
                LOGGER.debug("stopped block2 transfer, droping response.");
                return;
            }
            LOGGER.debug("requesting next Block2 [num={}]: {}", Integer.valueOf(currentNum), request2);
            exchange.setCurrentRequest(request2);
            prepareBlock2Cleanup(block2BlockwiseStatus, keyUri);
            lower().sendRequest(exchange, request2);
        } catch (RuntimeException e) {
            LOGGER.warn("cannot process next block request, aborting request!", (Throwable) e);
            request2.setSendError(e);
        }
    }

    private boolean requiresBlockwise(Exchange exchange, Response response, BlockOption blockOption) {
        boolean z = response.getPayloadSize() > this.maxMessageSize;
        if (blockOption != null) {
            z = z || this.strictBlock2Option || response.getPayloadSize() > blockOption.getSize();
        }
        if (z) {
            LOGGER.debug("response body [{}/{}] requires blockwise transfer", Integer.valueOf(response.getPayloadSize()), Integer.valueOf(this.maxMessageSize));
        }
        return z;
    }

    private Block1BlockwiseStatus resetInboundBlock1Status(KeyUri keyUri, Exchange exchange, Request request) {
        Block1BlockwiseStatus block1BlockwiseStatusRemove;
        Block1BlockwiseStatus inboundBlock1Status;
        synchronized (this.block1Transfers) {
            block1BlockwiseStatusRemove = this.block1Transfers.remove(keyUri);
            LOGGER.debug("inbound block1 transfer reset at {} by peer: {}", block1BlockwiseStatusRemove, request);
            inboundBlock1Status = getInboundBlock1Status(keyUri, exchange, request);
        }
        if (block1BlockwiseStatusRemove != null) {
            block1BlockwiseStatusRemove.setComplete(true);
        }
        return inboundBlock1Status;
    }

    private Block2BlockwiseStatus resetOutboundBlock2Status(KeyUri keyUri, Exchange exchange, Response response) {
        Block2BlockwiseStatus block2BlockwiseStatusRemove;
        Block2BlockwiseStatus outboundBlock2Status;
        synchronized (this.block2Transfers) {
            block2BlockwiseStatusRemove = this.block2Transfers.remove(keyUri);
            outboundBlock2Status = getOutboundBlock2Status(keyUri, exchange, response);
        }
        if (block2BlockwiseStatusRemove == null || block2BlockwiseStatusRemove.isComplete()) {
            LOGGER.debug("block transfer {} for {}", keyUri, response);
            return outboundBlock2Status;
        }
        LOGGER.debug("stop previous block transfer {} {} for new {}", keyUri, block2BlockwiseStatusRemove, response);
        block2BlockwiseStatusRemove.completeResponse();
        return outboundBlock2Status;
    }

    private boolean responseExceedsMaxBodySize(Response response) {
        return response.getOptions().hasSize2() && response.getOptions().getSize2().intValue() > getMaxResourceBodySize(response);
    }

    private ScheduledFuture<?> scheduleBlockCleanupTask(Runnable runnable) {
        if (!this.executor.isShutdown()) {
            return this.executor.schedule(runnable, this.blockTimeout, TimeUnit.MILLISECONDS);
        }
        LOGGER.info("Endpoint is being destroyed: skipping block clean-up");
        return null;
    }

    private void sendBlock(Exchange exchange, Response response, KeyUri keyUri, Block1BlockwiseStatus block1BlockwiseStatus, int i, int i2) {
        Logger logger = LOGGER;
        logger.trace("sending Block1 num={}", Integer.valueOf(i));
        Message message = null;
        try {
            if (block1BlockwiseStatus.isComplete()) {
                logger.debug("stopped block1 transfer, droping request.");
                return;
            }
            Request nextRequestBlock = block1BlockwiseStatus.getNextRequestBlock(i, i2);
            nextRequestBlock.setToken(response.getToken());
            nextRequestBlock.setDestinationContext(block1BlockwiseStatus.getFollowUpEndpointContext(response.getSourceContext()));
            addBlock1CleanUpObserver(nextRequestBlock, keyUri, block1BlockwiseStatus);
            logger.debug("sending (next) Block1 [num={}]: {}", Integer.valueOf(i), nextRequestBlock);
            exchange.setCurrentRequest(nextRequestBlock);
            prepareBlock1Cleanup(block1BlockwiseStatus, keyUri);
            lower().sendRequest(exchange, nextRequestBlock);
        } catch (RuntimeException e) {
            LOGGER.warn("cannot process next block request, aborting request!", (Throwable) e);
            if (0 != 0) {
                message.setSendError(e);
            } else {
                exchange.getRequest().setSendError(e);
            }
        }
    }

    private void sendBlock1ErrorResponse(KeyUri keyUri, Block1BlockwiseStatus block1BlockwiseStatus, Exchange exchange, Request request, CoAP.ResponseCode responseCode, String str) {
        BlockOption block1 = request.getOptions().getBlock1();
        Response responseCreateResponse = Response.createResponse(request, responseCode);
        responseCreateResponse.getOptions().setBlock1(block1.getSzx(), block1.isM(), block1.getNum());
        responseCreateResponse.setPayload(str);
        clearBlock1Status(keyUri, block1BlockwiseStatus);
        exchange.setCurrentResponse(responseCreateResponse);
        lower().sendResponse(exchange, responseCreateResponse);
    }

    private void sendNextBlock(Exchange exchange, Response response, KeyUri keyUri, Block1BlockwiseStatus block1BlockwiseStatus) {
        int currentSzx;
        BlockOption block1 = response.getOptions().getBlock1();
        int currentSize = block1BlockwiseStatus.getCurrentSize();
        if (block1.getSize() < currentSize) {
            currentSize = block1.getSize();
            currentSzx = block1.getSzx();
        } else {
            currentSzx = block1BlockwiseStatus.getCurrentSzx();
        }
        int i = currentSzx;
        sendBlock(exchange, response, keyUri, block1BlockwiseStatus, (block1BlockwiseStatus.getCurrentSize() * (block1BlockwiseStatus.getCurrentNum() + 1)) / currentSize, i);
    }

    private Request startBlockwiseUpload(Exchange exchange, final Request request, int i) {
        final Request nextRequestBlock;
        KeyUri key = getKey(exchange, request);
        synchronized (this.block1Transfers) {
            try {
                Block1BlockwiseStatus block1Status = getBlock1Status(key);
                if (block1Status != null) {
                    block1Status.cancelRequest();
                    clearBlock1Status(key, block1Status);
                }
                Block1BlockwiseStatus outboundBlock1Status = getOutboundBlock1Status(key, exchange, request, i);
                nextRequestBlock = outboundBlock1Status.getNextRequestBlock();
                nextRequestBlock.setDestinationContext(request.getDestinationContext());
                Token token = request.getToken();
                if (token != null) {
                    nextRequestBlock.setToken(token);
                }
                nextRequestBlock.addMessageObserver(new MessageObserverAdapter() { // from class: org.eclipse.californium.core.network.stack.BlockwiseLayer.2
                    @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
                    public void onReadyToSend() {
                        if (request.getToken() == null) {
                            request.setToken(nextRequestBlock.getToken());
                        }
                        if (request.hasMID()) {
                            return;
                        }
                        request.setMID(nextRequestBlock.getMID());
                    }
                });
                addBlock1CleanUpObserver(nextRequestBlock, key, outboundBlock1Status);
                prepareBlock1Cleanup(outboundBlock1Status, key);
            } catch (Throwable th) {
                throw th;
            }
        }
        return nextRequestBlock;
    }

    public void prepareBlock1Cleanup(final Block1BlockwiseStatus block1BlockwiseStatus, final KeyUri keyUri) {
        LOGGER.debug("scheduling clean up task for block1 transfer {}", keyUri);
        block1BlockwiseStatus.setBlockCleanupHandle(scheduleBlockCleanupTask(new Runnable() { // from class: org.eclipse.californium.core.network.stack.BlockwiseLayer.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!block1BlockwiseStatus.isComplete()) {
                        BlockwiseLayer.LOGGER.debug("block1 transfer timed out: {}", keyUri);
                        block1BlockwiseStatus.timeoutCurrentTranfer();
                    }
                    BlockwiseLayer.this.clearBlock1Status(keyUri, block1BlockwiseStatus);
                } catch (Exception e) {
                    BlockwiseLayer.LOGGER.debug("Unexcepted error while block1 cleaning", (Throwable) e);
                }
            }
        }));
    }

    public void prepareBlock2Cleanup(final Block2BlockwiseStatus block2BlockwiseStatus, final KeyUri keyUri) {
        LOGGER.debug("scheduling clean up task for block2 transfer {}", keyUri);
        block2BlockwiseStatus.setBlockCleanupHandle(scheduleBlockCleanupTask(new Runnable() { // from class: org.eclipse.californium.core.network.stack.BlockwiseLayer.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!block2BlockwiseStatus.isComplete()) {
                        BlockwiseLayer.LOGGER.debug("block2 transfer timed out: {}", keyUri);
                        block2BlockwiseStatus.timeoutCurrentTranfer();
                    }
                    BlockwiseLayer.this.clearBlock2Status(keyUri, block2BlockwiseStatus);
                } catch (Exception e) {
                    BlockwiseLayer.LOGGER.debug("Unexcepted error while block2 cleaning", (Throwable) e);
                }
            }
        }));
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveRequest(Exchange exchange, Request request) {
        if (!isTransparentBlockwiseHandlingEnabled()) {
            exchange.setRequest(request);
            upper().receiveRequest(exchange, request);
            return;
        }
        BlockOption block2 = request.getOptions().getBlock2();
        if (request.getOptions().hasBlock1()) {
            handleInboundBlockwiseUpload(exchange, request);
            return;
        }
        if (block2 == null || block2.getNum() <= 0) {
            exchange.setRequest(request);
            upper().receiveRequest(exchange, request);
            return;
        }
        KeyUri key = getKey(exchange, request);
        Block2BlockwiseStatus block2Status = getBlock2Status(key);
        if (block2Status != null) {
            handleInboundRequestForNextBlock(exchange, request, key, block2Status);
            return;
        }
        LOGGER.debug("peer wants to retrieve individual block2 {} of {}, delivering request to application layer", block2, key);
        exchange.setRequest(request);
        upper().receiveRequest(exchange, request);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveResponse(Exchange exchange, Response response) {
        if (!isTransparentBlockwiseHandlingEnabled() || exchange.getRequest().isMulticast()) {
            exchange.setResponse(response);
            upper().receiveResponse(exchange, response);
            return;
        }
        if (!response.isError()) {
            if (response.getMaxResourceBodySize() == 0) {
                response.setMaxResourceBodySize(exchange.getRequest().getMaxResourceBodySize());
            }
            KeyUri key = getKey(exchange, response);
            if (discardBlock2(key, getBlock2Status(key), exchange, response)) {
                return;
            }
            if (!response.hasBlockOption()) {
                exchange.setResponse(response);
                upper().receiveResponse(exchange, response);
                return;
            }
            if (response.getOptions().hasBlock1()) {
                handleBlock1Response(exchange, response);
            }
            if (response.getOptions().hasBlock2()) {
                handleBlock2Response(exchange, response);
                return;
            }
            return;
        }
        int i = AnonymousClass7.$SwitchMap$org$eclipse$californium$core$coap$CoAP$ResponseCode[response.getCode().ordinal()];
        if (i == 1 || i == 2) {
            if (handleEntityTooLarge(exchange, response)) {
                return;
            }
            KeyUri key2 = getKey(exchange, exchange.getCurrentRequest());
            Block1BlockwiseStatus block1Status = getBlock1Status(key2);
            if (block1Status != null) {
                clearBlock1Status(key2, block1Status);
            }
        }
        if (exchange.getRequest() == exchange.getCurrentRequest()) {
            upper().receiveResponse(exchange, response);
            return;
        }
        Response response2 = new Response(response.getCode());
        response2.setToken(exchange.getRequest().getToken());
        if (exchange.getRequest().getType() == CoAP.Type.CON) {
            response2.setType(CoAP.Type.ACK);
            response2.setMID(exchange.getRequest().getMID());
        } else {
            response2.setType(CoAP.Type.NON);
        }
        response2.setSourceContext(response.getSourceContext());
        response2.setPayload(response.getPayload());
        response2.setOptions(response.getOptions());
        response2.setRTT(exchange.calculateRTT());
        exchange.setResponse(response2);
        upper().receiveResponse(exchange, response2);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void sendRequest(Exchange exchange, Request request) {
        if (isTransparentBlockwiseHandlingEnabled() && !request.isMulticast()) {
            BlockOption block2 = request.getOptions().getBlock2();
            if (block2 == null || block2.getNum() <= 0) {
                KeyUri key = getKey(exchange, request);
                Block2BlockwiseStatus block2Status = getBlock2Status(key);
                if (block2Status != null) {
                    clearBlock2Status(key, block2Status);
                    block2Status.completeOldTransfer(null);
                }
                if (requiresBlockwise(request)) {
                    request = startBlockwiseUpload(exchange, request, this.preferredBlockSize);
                }
            } else {
                LOGGER.debug("outbound request contains block2 option, creating random-access blockwise status");
                addRandomAccessBlock2Status(exchange, request);
            }
        }
        exchange.setCurrentRequest(request);
        lower().sendRequest(exchange, request);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void sendResponse(Exchange exchange, Response response) {
        if (isTransparentBlockwiseHandlingEnabled()) {
            BlockOption block2 = exchange.getRequest().getOptions().getBlock2();
            BlockOption block22 = response.getOptions().getBlock2();
            if (block2 == null || block2.getNum() <= 0) {
                if (requiresBlockwise(exchange, response, block2)) {
                    Block2BlockwiseStatus block2BlockwiseStatusResetOutboundBlock2Status = resetOutboundBlock2Status(getKey(exchange, response), exchange, response);
                    if (block2 == null) {
                        block2 = new BlockOption(this.preferredBlockSzx, false, 0);
                    }
                    response = block2BlockwiseStatusResetOutboundBlock2Status.getNextResponseBlock(block2);
                }
            } else if (block22 != null) {
                if (block2.getNum() != block22.getNum()) {
                    LOGGER.warn("resource [{}] implementation error, peer requested block {} but resource returned block {}", exchange.getRequest().getURI(), Integer.valueOf(block2.getNum()), Integer.valueOf(block22.getNum()));
                    Response responseCreateResponse = Response.createResponse(exchange.getRequest(), CoAP.ResponseCode.INTERNAL_SERVER_ERROR);
                    responseCreateResponse.setType(response.getType());
                    responseCreateResponse.setMID(response.getMID());
                    responseCreateResponse.addMessageObservers(response.getMessageObservers());
                    response = responseCreateResponse;
                }
            } else if (response.hasBlock(block2)) {
                Block2BlockwiseStatus.crop(response, block2);
            } else {
                Response responseCreateResponse2 = Response.createResponse(exchange.getRequest(), CoAP.ResponseCode.BAD_OPTION);
                responseCreateResponse2.setType(response.getType());
                responseCreateResponse2.setMID(response.getMID());
                responseCreateResponse2.getOptions().setBlock2(block2);
                responseCreateResponse2.addMessageObservers(response.getMessageObservers());
                response = responseCreateResponse2;
            }
            BlockOption block1ToAck = exchange.getBlock1ToAck();
            if (block1ToAck != null) {
                exchange.setBlock1ToAck(null);
                response.getOptions().setBlock1(block1ToAck);
            }
        }
        exchange.setCurrentResponse(response);
        lower().sendResponse(exchange, response);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void start() {
        if (this.healthStatusInterval > 0 && HEALTH_LOGGER.isDebugEnabled() && this.statusLogger == null) {
            ScheduledExecutorService scheduledExecutorService = this.secondaryExecutor;
            Runnable runnable = new Runnable() { // from class: org.eclipse.californium.core.network.stack.BlockwiseLayer.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BlockwiseLayer.this.enableStatus) {
                        BlockwiseLayer.HEALTH_LOGGER.debug("{} block1 transfers", Integer.valueOf(BlockwiseLayer.this.block1Transfers.size()));
                        Iterator itValuesIterator = BlockwiseLayer.this.block1Transfers.valuesIterator();
                        int i = 5;
                        int i2 = 5;
                        while (itValuesIterator.hasNext()) {
                            BlockwiseLayer.HEALTH_LOGGER.debug("   block1 {}", itValuesIterator.next());
                            i2--;
                            if (i2 == 0) {
                                break;
                            }
                        }
                        BlockwiseLayer.HEALTH_LOGGER.debug("{} block2 transfers", Integer.valueOf(BlockwiseLayer.this.block2Transfers.size()));
                        Iterator itValuesIterator2 = BlockwiseLayer.this.block2Transfers.valuesIterator();
                        while (itValuesIterator2.hasNext()) {
                            BlockwiseLayer.HEALTH_LOGGER.debug("   block2 {}", itValuesIterator2.next());
                            i--;
                            if (i == 0) {
                                break;
                            }
                        }
                        BlockwiseLayer.HEALTH_LOGGER.debug("{} block2 responses ignored", Integer.valueOf(BlockwiseLayer.this.ignoredBlock2.get()));
                    }
                }
            };
            int i = this.healthStatusInterval;
            this.statusLogger = scheduledExecutorService.scheduleAtFixedRate(runnable, i, i, TimeUnit.SECONDS);
        }
    }

    private static KeyUri getKey(Exchange exchange, Request request) {
        if (exchange.isOfLocalOrigin()) {
            return KeyUri.fromOutboundRequest(request);
        }
        return KeyUri.fromInboundRequest(request);
    }

    private boolean requiresBlockwise(Request request) {
        boolean z = request.getPayloadSize() > this.maxMessageSize;
        if (z) {
            LOGGER.debug("request body [{}/{}] requires blockwise transfer", Integer.valueOf(request.getPayloadSize()), Integer.valueOf(this.maxMessageSize));
        }
        return z;
    }
}
