package org.eclipse.californium.core.network.stack;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.InternalMessageObserverAdapter;
import org.eclipse.californium.core.coap.Message;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.elements.EndpointContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class ReliabilityLayer extends AbstractLayer {
    protected static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) ReliabilityLayer.class);
    private final ReliabilityLayerParameters defaultReliabilityLayerParameters;
    private final Random rand = new Random();
    private final AtomicInteger counter = new AtomicInteger();

    public abstract class RetransmissionTask implements Runnable {
        private final Exchange exchange;
        private final Message message;

        public RetransmissionTask(Exchange exchange, Message message) {
            this.exchange = exchange;
            this.message = message;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void retry() {
            try {
                this.exchange.setRetransmissionHandle(null);
                if (this.exchange.isComplete()) {
                    ReliabilityLayer.LOGGER.debug("Timeout: for {}, {}", this.exchange, this.message);
                    return;
                }
                int failedTransmissionCount = this.exchange.getFailedTransmissionCount() + 1;
                if (failedTransmissionCount == 1) {
                    this.message.setEffectiveDestinationContext(EndpointContextUtil.getFollowUpEndpointContext(this.message.getDestinationContext(), this.exchange.getEndpointContext()));
                }
                this.exchange.setFailedTransmissionCount(failedTransmissionCount);
                Logger logger = ReliabilityLayer.LOGGER;
                logger.debug("Timeout: for {} retry {} of {}", this.exchange, Integer.valueOf(failedTransmissionCount), this.message);
                if (this.message.isAcknowledged()) {
                    logger.trace("Timeout: for {} message already acknowledged, cancel retransmission of {}", this.exchange, this.message);
                    return;
                }
                if (this.message.isRejected()) {
                    logger.trace("Timeout: for {} message already rejected, cancel retransmission of {}", this.exchange, this.message);
                    return;
                }
                if (this.message.isCanceled()) {
                    logger.trace("Timeout: for {}, {} is canceled, do not retransmit", this.exchange, this.message);
                    return;
                }
                if (failedTransmissionCount > getReliabilityLayerParameters().getMaxRetransmit()) {
                    logger.debug("Timeout: for {} retransmission limit reached, exchange failed, message: {}", this.exchange, this.message);
                    this.exchange.setTimedOut(this.message);
                    return;
                }
                logger.debug("Timeout: for {} retransmit message, failed: {}, message: {}", this.exchange, Integer.valueOf(failedTransmissionCount), this.message);
                this.message.retransmitting();
                if (this.message.isCanceled()) {
                    logger.trace("Timeout: for {}, {} got canceled, do not retransmit", this.exchange, this.message);
                } else if (this.exchange.isComplete()) {
                    logger.debug("Timeout: for {}, {} got completed, do not retransmit", this.exchange, this.message);
                } else {
                    retransmit();
                }
            } catch (Exception e) {
                ReliabilityLayer.LOGGER.error("Exception for {} in MessageObserver: {}", this.exchange, e.getMessage(), e);
            }
        }

        public ReliabilityLayerParameters getReliabilityLayerParameters() {
            ReliabilityLayerParameters reliabilityLayerParameters = this.message.getReliabilityLayerParameters();
            return reliabilityLayerParameters == null ? ReliabilityLayer.this.defaultReliabilityLayerParameters : reliabilityLayerParameters;
        }

        public abstract void retransmit();

        @Override // java.lang.Runnable
        public void run() {
            this.exchange.execute(new Runnable() { // from class: org.eclipse.californium.core.network.stack.ReliabilityLayer.RetransmissionTask.1
                @Override // java.lang.Runnable
                public void run() {
                    RetransmissionTask.this.retry();
                }
            });
        }

        public void startTimer() {
            if (this.exchange.isComplete()) {
                return;
            }
            this.exchange.setRetransmissionHandle(ReliabilityLayer.this.executor.schedule(this, this.exchange.getCurrentTimeout(), TimeUnit.MILLISECONDS));
        }
    }

    public ReliabilityLayer(NetworkConfig networkConfig) {
        ReliabilityLayerParameters reliabilityLayerParametersBuild = ReliabilityLayerParameters.builder().applyConfig(networkConfig).build();
        this.defaultReliabilityLayerParameters = reliabilityLayerParametersBuild;
        LOGGER.info("ReliabilityLayer uses ACK_TIMEOUT={}, ACK_RANDOM_FACTOR={}, and ACK_TIMEOUT_SCALE={} as default", Integer.valueOf(reliabilityLayerParametersBuild.getAckTimeout()), Float.valueOf(reliabilityLayerParametersBuild.getAckRandomFactor()), Float.valueOf(reliabilityLayerParametersBuild.getAckTimeoutScale()));
    }

    private void prepareRetransmission(final Exchange exchange, final RetransmissionTask retransmissionTask) {
        if (this.executor.isShutdown()) {
            LOGGER.info("Endpoint is being destroyed: skipping retransmission");
            return;
        }
        exchange.setRetransmissionHandle(null);
        updateRetransmissionTimeout(exchange, retransmissionTask.getReliabilityLayerParameters());
        retransmissionTask.message.addMessageObserver(new InternalMessageObserverAdapter() { // from class: org.eclipse.californium.core.network.stack.ReliabilityLayer.3
            @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
            public void onSent(boolean z) {
                retransmissionTask.message.removeMessageObserver(this);
                if (exchange.isComplete()) {
                    return;
                }
                exchange.execute(new Runnable() { // from class: org.eclipse.californium.core.network.stack.ReliabilityLayer.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        retransmissionTask.startTimer();
                    }
                });
            }
        });
    }

    public int getRandomTimeout(int i, float f) {
        int iNextInt;
        if (f <= 1.0d) {
            return i;
        }
        int i2 = ((int) (i * f)) - i;
        synchronized (this.rand) {
            iNextInt = i + this.rand.nextInt(i2 + 1);
        }
        return iNextInt;
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
        Message currentResponse;
        String str;
        exchange.setFailedTransmissionCount(0);
        exchange.setRetransmissionHandle(null);
        if (exchange.isOfLocalOrigin()) {
            currentResponse = exchange.getCurrentRequest();
            str = "request";
        } else {
            currentResponse = exchange.getCurrentResponse();
            str = "response";
        }
        int size = currentResponse.getMessageObservers().size();
        if (emptyMessage.getType() == CoAP.Type.ACK) {
            LOGGER.debug("{} acknowledge {} for {} {} ({} msg observer)", exchange, emptyMessage, str, currentResponse, Integer.valueOf(size));
            currentResponse.setAcknowledged(true);
        } else if (emptyMessage.getType() != CoAP.Type.RST) {
            LOGGER.warn("{} received empty message that is neither ACK nor RST: {}", exchange, emptyMessage);
            return;
        } else {
            LOGGER.debug("{} reject {} for {} {} ({} msg observer)", exchange, emptyMessage, str, currentResponse, Integer.valueOf(size));
            currentResponse.setRejected(true);
        }
        upper().receiveEmptyMessage(exchange, emptyMessage);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveRequest(Exchange exchange, Request request) {
        if (!request.isDuplicate()) {
            exchange.setCurrentRequest(request);
            upper().receiveRequest(exchange, request);
            return;
        }
        long sendNanoTimestamp = exchange.getSendNanoTimestamp();
        if (sendNanoTimestamp == 0 || sendNanoTimestamp - request.getNanoTimestamp() > 0) {
            LOGGER.debug("{}: {} duplicate request {}, server sent response delayed, ignore request", Integer.valueOf(this.counter.incrementAndGet()), exchange, request);
            return;
        }
        exchange.retransmitResponse();
        Response currentResponse = exchange.getCurrentResponse();
        if (currentResponse == null) {
            if (exchange.getCurrentRequest().isAcknowledged()) {
                LOGGER.debug("{} duplicate request was acknowledged but no response computed yet. Retransmit ACK", exchange);
                sendEmptyMessage(exchange, EmptyMessage.newACK(request));
                return;
            } else if (!exchange.getCurrentRequest().isRejected()) {
                LOGGER.debug("{} server has not yet decided what to do with the request. We ignore the duplicate.", exchange);
                return;
            } else {
                LOGGER.debug("{} duplicate request was rejected. Reject again", exchange);
                sendEmptyMessage(exchange, EmptyMessage.newRST(request));
                return;
            }
        }
        CoAP.Type type = currentResponse.getType();
        if (type == CoAP.Type.NON || type == CoAP.Type.CON) {
            if (request.isConfirmable() && request.acknowledge()) {
                sendEmptyMessage(exchange, EmptyMessage.newACK(request));
            }
            if (type == CoAP.Type.CON) {
                if (currentResponse.isAcknowledged()) {
                    LOGGER.debug("{} request duplicate: ignore, response already acknowledged!", exchange);
                    return;
                }
                int failedTransmissionCount = exchange.getFailedTransmissionCount() + 1;
                exchange.setFailedTransmissionCount(failedTransmissionCount);
                LOGGER.debug("{} request duplicate: retransmit response, failed: {}, response: {}", exchange, Integer.valueOf(failedTransmissionCount), currentResponse);
                currentResponse.retransmitting();
                sendResponse(exchange, currentResponse);
                return;
            }
            if (currentResponse.isNotification()) {
                exchange.setFailedTransmissionCount(exchange.getFailedTransmissionCount() + 1);
            }
        }
        LOGGER.debug("{} respond with the current response to the duplicate request", exchange);
        lower().sendResponse(exchange, currentResponse);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveResponse(Exchange exchange, Response response) {
        EmptyMessage emptyMessageNewACK;
        exchange.setFailedTransmissionCount(0);
        exchange.setRetransmissionHandle(null);
        CoAP.Type type = response.getType();
        CoAP.Type type2 = CoAP.Type.CON;
        if (type == type2) {
            if (response.isDuplicate()) {
                long sendNanoTimestamp = exchange.getSendNanoTimestamp();
                if (sendNanoTimestamp == 0 || sendNanoTimestamp - response.getNanoTimestamp() > 0) {
                    LOGGER.debug("{}: {} duplicate response {}, server sent ACK delayed, ignore response", Integer.valueOf(this.counter.incrementAndGet()), exchange, response);
                    return;
                } else if (response.isRejected()) {
                    LOGGER.debug("{} reject duplicate CON response, request canceled.", exchange);
                    emptyMessageNewACK = EmptyMessage.newRST(response);
                    response.setRejected(true);
                } else {
                    LOGGER.debug("{} acknowledging duplicate CON response", exchange);
                    emptyMessageNewACK = EmptyMessage.newACK(response);
                    response.setAcknowledged(true);
                }
            } else if (exchange.getRequest().isCanceled()) {
                LOGGER.debug("{} reject CON response, request canceled.", exchange);
                emptyMessageNewACK = EmptyMessage.newRST(response);
                response.setRejected(true);
            } else {
                LOGGER.debug("{} acknowledging CON response", exchange);
                emptyMessageNewACK = EmptyMessage.newACK(response);
                response.setAcknowledged(true);
            }
            sendEmptyMessage(exchange, emptyMessageNewACK);
        }
        if (response.isDuplicate()) {
            if (response.getType() != type2) {
                LOGGER.debug("{} ignoring duplicate response", exchange);
            }
        } else {
            exchange.getCurrentRequest().setAcknowledged(true);
            exchange.setCurrentResponse(response);
            upper().receiveResponse(exchange, response);
        }
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void sendRequest(final Exchange exchange, final Request request) {
        ReliabilityLayer reliabilityLayer;
        Exchange exchange2;
        Request request2;
        Logger logger = LOGGER;
        logger.debug("{} send request, failed transmissions: {}", exchange, Integer.valueOf(exchange.getFailedTransmissionCount()));
        if (request.getType() == null) {
            request.setType(CoAP.Type.CON);
        }
        if (request.getType() == CoAP.Type.CON) {
            logger.debug("{} prepare retransmission for {}", exchange, request);
            reliabilityLayer = this;
            exchange2 = exchange;
            request2 = request;
            reliabilityLayer.prepareRetransmission(exchange2, new RetransmissionTask(exchange2, request2) { // from class: org.eclipse.californium.core.network.stack.ReliabilityLayer.1
                @Override // org.eclipse.californium.core.network.stack.ReliabilityLayer.RetransmissionTask
                public void retransmit() {
                    ReliabilityLayer.this.sendRequest(exchange, request);
                }
            });
        } else {
            reliabilityLayer = this;
            exchange2 = exchange;
            request2 = request;
        }
        reliabilityLayer.lower().sendRequest(exchange2, request2);
    }

    @Override // org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void sendResponse(final Exchange exchange, final Response response) {
        ReliabilityLayer reliabilityLayer;
        Exchange exchange2;
        Response response2;
        Logger logger = LOGGER;
        logger.debug("{} send response {}, failed transmissions: {}", exchange, response, Integer.valueOf(exchange.getFailedTransmissionCount()));
        CoAP.Type type = response.getType();
        if (type == null) {
            CoAP.Type type2 = exchange.getCurrentRequest().getType();
            if (exchange.getCurrentRequest().acknowledge()) {
                response.setType(CoAP.Type.ACK);
                response.setMID(exchange.getCurrentRequest().getMID());
            } else {
                response.setType(type2);
            }
            logger.trace("{} switched response message type from {} to {} (request was {})", exchange, type, response.getType(), type2);
        } else if (type == CoAP.Type.ACK || type == CoAP.Type.RST) {
            response.setMID(exchange.getCurrentRequest().getMID());
        }
        if (response.getType() == CoAP.Type.CON) {
            logger.debug("{} prepare retransmission for {}", exchange, response);
            reliabilityLayer = this;
            exchange2 = exchange;
            response2 = response;
            reliabilityLayer.prepareRetransmission(exchange2, new RetransmissionTask(exchange2, response2) { // from class: org.eclipse.californium.core.network.stack.ReliabilityLayer.2
                @Override // org.eclipse.californium.core.network.stack.ReliabilityLayer.RetransmissionTask
                public void retransmit() {
                    ReliabilityLayer.this.sendResponse(exchange, response);
                }
            });
        } else {
            reliabilityLayer = this;
            exchange2 = exchange;
            response2 = response;
        }
        reliabilityLayer.lower().sendResponse(exchange2, response2);
    }

    public void updateRetransmissionTimeout(Exchange exchange, ReliabilityLayerParameters reliabilityLayerParameters) {
        exchange.setCurrentTimeout(exchange.getFailedTransmissionCount() == 0 ? getRandomTimeout(reliabilityLayerParameters.getAckTimeout(), reliabilityLayerParameters.getAckRandomFactor()) : (int) (reliabilityLayerParameters.getAckTimeoutScale() * exchange.getCurrentTimeout()));
    }
}
