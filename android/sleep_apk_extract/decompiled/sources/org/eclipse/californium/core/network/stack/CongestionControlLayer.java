package org.eclipse.californium.core.network.stack;

import java.util.concurrent.TimeUnit;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Message;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.RemoteEndpoint;
import org.eclipse.californium.core.network.RemoteEndpointManager;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.network.stack.congestioncontrol.BasicRto;
import org.eclipse.californium.core.network.stack.congestioncontrol.Cocoa;
import org.eclipse.californium.core.network.stack.congestioncontrol.CocoaStrong;
import org.eclipse.californium.core.network.stack.congestioncontrol.LinuxRto;
import org.eclipse.californium.core.network.stack.congestioncontrol.PeakhopperRto;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CongestionControlLayer extends ReliabilityLayer {
    private boolean appliesDithering;
    protected NetworkConfig config;
    private RemoteEndpointManager remoteEndpointmanager;

    public class BucketThread implements Runnable {
        RemoteEndpoint endpoint;

        public BucketThread(RemoteEndpoint remoteEndpoint) {
            this.endpoint = remoteEndpoint;
        }

        @Override // java.lang.Runnable
        public void run() {
            final Exchange exchangePoll = this.endpoint.getNonConfirmableQueue().poll();
            RemoteEndpoint remoteEndpoint = this.endpoint;
            if (exchangePoll == null) {
                remoteEndpoint.setProcessingNON(false);
                return;
            }
            remoteEndpoint.setProcessingNON(true);
            if (this.endpoint.getNonConfirmableCounter() <= 7) {
                this.endpoint.increaseNonConfirmableCounter();
                exchangePoll.execute(new Runnable() { // from class: org.eclipse.californium.core.network.stack.CongestionControlLayer.BucketThread.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (exchangePoll.getCurrentRequest().getDestinationContext().getPeerAddress().getPort() != 0) {
                            CongestionControlLayer congestionControlLayer = CongestionControlLayer.this;
                            Exchange exchange = exchangePoll;
                            congestionControlLayer.sendBucketRequest(exchange, exchange.getCurrentRequest());
                        } else if (exchangePoll.getCurrentResponse() != null) {
                            CongestionControlLayer congestionControlLayer2 = CongestionControlLayer.this;
                            Exchange exchange2 = exchangePoll;
                            congestionControlLayer2.sendBucketResponse(exchange2, exchange2.getCurrentResponse());
                        }
                    }
                });
            }
            CongestionControlLayer congestionControlLayer = CongestionControlLayer.this;
            congestionControlLayer.executor.schedule(congestionControlLayer.new BucketThread(this.endpoint), this.endpoint.getRTO(), TimeUnit.MILLISECONDS);
        }
    }

    public class SweepCheckTask implements Runnable {
        final RemoteEndpoint endpoint;
        final Exchange exchange;

        public SweepCheckTask(RemoteEndpoint remoteEndpoint, Exchange exchange) {
            this.endpoint = remoteEndpoint;
            this.exchange = exchange;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.endpoint.removeExchangeInfo(this.exchange)) {
                CongestionControlLayer.this.checkRemoteEndpointQueue(this.exchange);
            }
        }
    }

    public CongestionControlLayer(NetworkConfig networkConfig) {
        super(networkConfig);
        this.config = networkConfig;
        this.remoteEndpointmanager = new RemoteEndpointManager(networkConfig);
        setDithering(false);
    }

    private void calculateRTT(Exchange exchange) {
        long exchangeTimestamp = getRemoteEndpoint(exchange).getExchangeTimestamp(exchange);
        if (exchangeTimestamp != 0) {
            processRTTmeasurement(System.currentTimeMillis() - exchangeTimestamp, exchange, exchange.getFailedTransmissionCount());
            getRemoteEndpoint(exchange).removeExchangeInfo(exchange);
        }
    }

    private boolean checkNSTART(Exchange exchange) {
        RemoteEndpoint remoteEndpoint = getRemoteEndpoint(exchange);
        remoteEndpoint.checkForDeletedExchanges();
        if (remoteEndpoint.getNumberOfOngoingExchanges(exchange) < remoteEndpoint.getReliabilityLayerParameters().getNstart()) {
            remoteEndpoint.registerExchange(exchange, calculateVBF(remoteEndpoint.getRTO(), remoteEndpoint));
            this.executor.schedule(new SweepCheckTask(remoteEndpoint, exchange), 255000L, TimeUnit.MILLISECONDS);
            return true;
        }
        if (remoteEndpoint.getConfirmableQueue().size() == 50) {
            return false;
        }
        remoteEndpoint.getConfirmableQueue().add(exchange);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRemoteEndpointQueue(Exchange exchange) {
        final Exchange exchangePoll = getRemoteEndpoint(exchange).getConfirmableQueue().poll();
        if (exchangePoll != null) {
            exchangePoll.execute(new Runnable() { // from class: org.eclipse.californium.core.network.stack.CongestionControlLayer.1
                @Override // java.lang.Runnable
                public void run() {
                    if (exchangePoll.getCurrentResponse() != null) {
                        CongestionControlLayer congestionControlLayer = CongestionControlLayer.this;
                        Exchange exchange2 = exchangePoll;
                        congestionControlLayer.sendResponse(exchange2, exchange2.getCurrentResponse());
                    } else if (exchangePoll.getCurrentRequest() != null) {
                        CongestionControlLayer congestionControlLayer2 = CongestionControlLayer.this;
                        Exchange exchange3 = exchangePoll;
                        congestionControlLayer2.sendRequest(exchange3, exchange3.getCurrentRequest());
                    }
                }
            });
        }
    }

    public static CongestionControlLayer newImplementation(NetworkConfig networkConfig) {
        String string = networkConfig.getString("CONGESTION_CONTROL_ALGORITHM", "Cocoa");
        string.getClass();
        switch (string) {
            case "BasicRto":
                return new BasicRto(networkConfig);
            case "CocoaStrong":
                return new CocoaStrong(networkConfig);
            case "Cocoa":
                return new Cocoa(networkConfig);
            case "PeakhopperRto":
                return new PeakhopperRto(networkConfig);
            case "LinuxRto":
                return new LinuxRto(networkConfig);
            default:
                ReliabilityLayer.LOGGER.info("configuration contains unsupported {}, using Cocoa", "CONGESTION_CONTROL_ALGORITHM");
                return new Cocoa(networkConfig);
        }
    }

    private boolean processMessage(Exchange exchange, Message message) {
        CoAP.Type type = message.getType();
        CoAP.Type type2 = CoAP.Type.CON;
        if (type == type2) {
            return checkNSTART(exchange);
        }
        RemoteEndpoint remoteEndpoint = getRemoteEndpoint(exchange);
        if (remoteEndpoint.getNonConfirmableCounter() > 7) {
            if (exchange.getCurrentRequest().getDestinationContext().getPeerAddress().getPort() != 0) {
                exchange.getCurrentRequest().setType(type2);
            } else if (exchange.getCurrentResponse() != null) {
                exchange.getCurrentResponse().setType(type2);
            }
            remoteEndpoint.resetNonConfirmableCounter();
            return checkNSTART(exchange);
        }
        if (remoteEndpoint.getNonConfirmableQueue().size() == 50) {
            return false;
        }
        remoteEndpoint.getNonConfirmableQueue().add(exchange);
        if (remoteEndpoint.getProcessingNON()) {
            return false;
        }
        this.executor.schedule(new BucketThread(remoteEndpoint), 0L, TimeUnit.MILLISECONDS);
        return false;
    }

    public boolean appliesDithering() {
        return this.appliesDithering;
    }

    public double calculateVBF(long j, RemoteEndpoint remoteEndpoint) {
        return remoteEndpoint.getReliabilityLayerParameters().getAckTimeoutScale();
    }

    public void checkAging(Exchange exchange) {
    }

    public RemoteEndpoint getRemoteEndpoint(Exchange exchange) {
        return this.remoteEndpointmanager.getRemoteEndpoint(exchange);
    }

    public abstract void processRTTmeasurement(long j, Exchange exchange, int i);

    @Override // org.eclipse.californium.core.network.stack.ReliabilityLayer, org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveEmptyMessage(Exchange exchange, EmptyMessage emptyMessage) {
        if (exchange.getFailedTransmissionCount() != 0) {
            getRemoteEndpoint(exchange).setEstimatorState(exchange);
        }
        super.receiveEmptyMessage(exchange, emptyMessage);
        calculateRTT(exchange);
        checkRemoteEndpointQueue(exchange);
    }

    @Override // org.eclipse.californium.core.network.stack.ReliabilityLayer, org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void receiveResponse(Exchange exchange, Response response) {
        if (exchange.getFailedTransmissionCount() != 0) {
            getRemoteEndpoint(exchange).setEstimatorState(exchange);
        }
        super.receiveResponse(exchange, response);
        calculateRTT(exchange);
        checkRemoteEndpointQueue(exchange);
    }

    public void sendBucketRequest(Exchange exchange, Request request) {
        super.sendRequest(exchange, request);
    }

    public void sendBucketResponse(Exchange exchange, Response response) {
        super.sendResponse(exchange, response);
    }

    @Override // org.eclipse.californium.core.network.stack.ReliabilityLayer, org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void sendRequest(Exchange exchange, Request request) {
        if (exchange.getFailedTransmissionCount() > 0) {
            super.sendRequest(exchange, request);
        } else if (processMessage(exchange, request)) {
            checkAging(exchange);
            super.sendRequest(exchange, request);
        }
    }

    @Override // org.eclipse.californium.core.network.stack.ReliabilityLayer, org.eclipse.californium.core.network.stack.AbstractLayer, org.eclipse.californium.core.network.stack.Layer
    public void sendResponse(Exchange exchange, Response response) {
        if (exchange.getFailedTransmissionCount() > 0) {
            super.sendResponse(exchange, response);
        } else if (processMessage(exchange, response)) {
            checkAging(exchange);
            super.sendResponse(exchange, response);
        }
    }

    public void setDithering(boolean z) {
        this.appliesDithering = z;
    }

    @Override // org.eclipse.californium.core.network.stack.ReliabilityLayer
    public void updateRetransmissionTimeout(Exchange exchange, ReliabilityLayerParameters reliabilityLayerParameters) {
        int rto;
        RemoteEndpoint remoteEndpoint = getRemoteEndpoint(exchange);
        if (exchange.getFailedTransmissionCount() == 0) {
            rto = (int) remoteEndpoint.getRTO();
            if (appliesDithering()) {
                remoteEndpoint.matchCurrentRTO();
                rto = getRandomTimeout((int) remoteEndpoint.getRTO(), reliabilityLayerParameters.getAckRandomFactor());
            }
        } else {
            int exchangeVBF = (int) (remoteEndpoint.getExchangeVBF(exchange) * ((double) exchange.getCurrentTimeout()));
            rto = exchangeVBF < 60000 ? exchangeVBF : 60000;
            remoteEndpoint.setCurrentRTO(rto);
        }
        exchange.setCurrentTimeout(rto);
    }
}
