package org.eclipse.californium.core.network;

import java.net.InetAddress;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.californium.core.network.stack.ReliabilityLayerParameters;

/* JADX INFO: loaded from: classes5.dex */
public class RemoteEndpoint {
    private InetAddress Address;
    public double B_value;
    private int Port;
    public long RTO_min;
    private long[] RTOupdateTimestamp;
    public long RTTVAR;
    public long RTT_max;
    public long RTT_previous;
    public long[] RTT_sample = new long[2];
    public long SRTT;
    private Queue<Exchange> confirmableQueue;
    private int currentArrayElement;
    private long currentRTO;
    public double delta;
    private final ReliabilityLayerParameters endpointReliabilityLayerParameters;
    private ConcurrentHashMap<Exchange, ExchangeInfo> exchangeInfoMap;
    private boolean isBlindStrong;
    private boolean isBlindWeak;
    public long mdev;
    public long mdev_max;
    private long meanOverallRTO;
    private int nonConfirmableCounter;
    private Queue<Exchange> nonConfirmableQueue;
    private long[] overallRTO;
    private boolean processingNON;
    private boolean usesBlindEstimator;
    private long[] xRTO;
    private long[] xRTT;
    private long[] xRTTVAR;

    public class ExchangeInfo {
        private int estimatorType = 1;
        private long timestamp;
        private double vbf;

        public ExchangeInfo(long j, double d) {
            this.timestamp = j;
            this.vbf = d;
        }

        public int getEstimatorType() {
            return this.estimatorType;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public double getVBF() {
            return this.vbf;
        }

        public void setTypeNoEstimator() {
            this.estimatorType = 3;
        }

        public void setTypeWeakEstimator() {
            this.estimatorType = 2;
        }
    }

    public RemoteEndpoint(int i, InetAddress inetAddress, ReliabilityLayerParameters reliabilityLayerParameters) {
        this.Address = inetAddress;
        this.Port = i;
        this.endpointReliabilityLayerParameters = reliabilityLayerParameters;
        int ackTimeout = reliabilityLayerParameters.getAckTimeout();
        this.overallRTO = new long[]{j};
        long j = ackTimeout;
        this.currentRTO = j;
        this.xRTO = new long[3];
        this.xRTT = new long[3];
        this.xRTTVAR = new long[3];
        this.RTOupdateTimestamp = new long[3];
        for (int i2 = 0; i2 <= 2; i2++) {
            setEstimatorValues(j, 0L, 0L, i2);
            setRTOtimestamp(System.currentTimeMillis(), i2);
        }
        this.meanOverallRTO = j;
        this.currentArrayElement = 0;
        this.nonConfirmableCounter = 7;
        this.usesBlindEstimator = true;
        this.isBlindStrong = true;
        this.isBlindWeak = true;
        this.processingNON = false;
        this.exchangeInfoMap = new ConcurrentHashMap<>();
        this.confirmableQueue = new LinkedList();
        this.nonConfirmableQueue = new LinkedList();
    }

    private void calculateMeanOverallRTO() {
        this.meanOverallRTO = this.overallRTO[0];
    }

    public void boostRTOvalue() {
        this.meanOverallRTO *= 2;
    }

    public void checkForDeletedExchanges() {
        for (Map.Entry<Exchange, ExchangeInfo> entry : this.exchangeInfoMap.entrySet()) {
            if (entry == null) {
                this.exchangeInfoMap.remove(entry);
            }
        }
    }

    public Queue<Exchange> getConfirmableQueue() {
        return this.confirmableQueue;
    }

    public int getExchangeEstimatorState(Exchange exchange) {
        this.exchangeInfoMap.isEmpty();
        if (this.exchangeInfoMap.get(exchange) != null) {
            return this.exchangeInfoMap.get(exchange).getEstimatorType();
        }
        return 0;
    }

    public long getExchangeTimestamp(Exchange exchange) {
        if (this.exchangeInfoMap.isEmpty() || this.exchangeInfoMap.get(exchange) == null) {
            return 0L;
        }
        return this.exchangeInfoMap.get(exchange).getTimestamp();
    }

    public double getExchangeVBF(Exchange exchange) {
        if (this.exchangeInfoMap.isEmpty()) {
            return 0.0d;
        }
        if (this.exchangeInfoMap.get(exchange) != null) {
            return this.exchangeInfoMap.get(exchange).getVBF();
        }
        return 2.0d;
    }

    public int getNonConfirmableCounter() {
        return this.nonConfirmableCounter;
    }

    public Queue<Exchange> getNonConfirmableQueue() {
        return this.nonConfirmableQueue;
    }

    public int getNumberOfOngoingExchanges(Exchange exchange) {
        return this.exchangeInfoMap.size();
    }

    public boolean getProcessingNON() {
        return this.processingNON;
    }

    public long getRTO() {
        long size;
        if (this.usesBlindEstimator && this.isBlindStrong && this.isBlindWeak && this.exchangeInfoMap.size() > 1) {
            size = ((long) this.exchangeInfoMap.size()) * 2000;
        } else {
            size = this.meanOverallRTO;
            long j = this.currentRTO;
            if (size != j) {
                size = j;
            }
        }
        if (size < 32000) {
            return size;
        }
        return 32000L;
    }

    public long getRTOtimestamp(int i) {
        return this.RTOupdateTimestamp[i];
    }

    public ReliabilityLayerParameters getReliabilityLayerParameters() {
        return this.endpointReliabilityLayerParameters;
    }

    public long getxRTT(int i) {
        return this.xRTT[i];
    }

    public long getxRTTVAR(int i) {
        return this.xRTTVAR[i];
    }

    public void increaseNonConfirmableCounter() {
        this.nonConfirmableCounter++;
    }

    public boolean isBlindStrong() {
        return this.isBlindStrong;
    }

    public boolean isBlindWeak() {
        return this.isBlindWeak;
    }

    public void matchCurrentRTO() {
        this.currentRTO = this.meanOverallRTO;
    }

    public void printLinuxStats() {
        System.out.println("SRTT: " + this.SRTT + " RTTVAR: " + this.RTTVAR + " mdev: " + this.mdev + " mdev_max: " + this.mdev_max);
    }

    public void printPeakhopperStats() {
        System.out.println("Delta: " + this.delta + " D: 0.9583333333333334 B: " + this.B_value + " RTT_max: " + this.RTT_max);
    }

    public void reduceRTOvalue() {
        this.meanOverallRTO = (long) ((this.meanOverallRTO * 0.5d) + 1000.0d);
    }

    public void registerExchange(Exchange exchange, double d) {
        this.exchangeInfoMap.put(exchange, new ExchangeInfo(System.currentTimeMillis(), d));
    }

    public boolean removeExchangeInfo(Exchange exchange) {
        return this.exchangeInfoMap.remove(exchange) != null;
    }

    public void resetNonConfirmableCounter() {
        this.nonConfirmableCounter = 0;
    }

    public void setBlindStrong(boolean z) {
        this.isBlindStrong = z;
    }

    public void setBlindWeak(boolean z) {
        this.isBlindWeak = z;
    }

    public void setCurrentRTO(long j) {
        this.currentRTO = j;
    }

    public void setEstimatorState(Exchange exchange) {
        if (this.exchangeInfoMap.get(exchange) == null) {
            return;
        }
        if (exchange.getFailedTransmissionCount() == 1 || exchange.getFailedTransmissionCount() == 2) {
            this.exchangeInfoMap.get(exchange).setTypeWeakEstimator();
        } else {
            this.exchangeInfoMap.get(exchange).setTypeNoEstimator();
        }
    }

    public void setEstimatorValues(long j, long j2, long j3, int i) {
        this.xRTO[i] = j;
        this.xRTT[i] = j2;
        this.xRTTVAR[i] = j3;
    }

    public void setProcessingNON(boolean z) {
        this.processingNON = z;
    }

    public void setRTOtimestamp(long j, int i) {
        this.RTOupdateTimestamp[i] = j;
    }

    public void updateRTO(long j) {
        long[] jArr = this.overallRTO;
        int i = this.currentArrayElement;
        jArr[i] = j;
        this.currentArrayElement = (i + 1) % 1;
        calculateMeanOverallRTO();
        setCurrentRTO(j);
    }
}
