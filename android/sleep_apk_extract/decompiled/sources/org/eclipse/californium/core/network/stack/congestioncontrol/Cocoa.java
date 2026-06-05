package org.eclipse.californium.core.network.stack.congestioncontrol;

import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.RemoteEndpoint;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.network.stack.CongestionControlLayer;

/* JADX INFO: loaded from: classes5.dex */
public class Cocoa extends CongestionControlLayer {
    private int[] kValue;
    private double[] weighting;

    public Cocoa(NetworkConfig networkConfig) {
        super(networkConfig);
        this.kValue = new int[]{4, 1};
        this.weighting = new double[]{0.5d, 0.25d};
        setDithering(true);
    }

    @Override // org.eclipse.californium.core.network.stack.CongestionControlLayer
    public double calculateVBF(long j, RemoteEndpoint remoteEndpoint) {
        if (j > 3000) {
            return 1.5d;
        }
        if (j < 1000) {
            return 3.0d;
        }
        return remoteEndpoint.getReliabilityLayerParameters().getAckTimeoutScale();
    }

    @Override // org.eclipse.californium.core.network.stack.CongestionControlLayer
    public void checkAging(Exchange exchange) {
        long jCurrentTimeMillis = System.currentTimeMillis() - getRemoteEndpoint(exchange).getRTOtimestamp(0);
        while (jCurrentTimeMillis > getRemoteEndpoint(exchange).getRTO() * 16 && getRemoteEndpoint(exchange).getRTO() < 1000) {
            jCurrentTimeMillis -= getRemoteEndpoint(exchange).getRTO() * 16;
            getRemoteEndpoint(exchange).boostRTOvalue();
            getRemoteEndpoint(exchange).setRTOtimestamp(System.currentTimeMillis(), 0);
        }
        while (jCurrentTimeMillis > getRemoteEndpoint(exchange).getRTO() * 4 && getRemoteEndpoint(exchange).getRTO() > 3000) {
            jCurrentTimeMillis -= getRemoteEndpoint(exchange).getRTO() * 4;
            getRemoteEndpoint(exchange).reduceRTOvalue();
            getRemoteEndpoint(exchange).setRTOtimestamp(System.currentTimeMillis(), 0);
        }
    }

    public void initializeRTOEstimators(long j, int i, RemoteEndpoint remoteEndpoint) {
        long j2 = j / 2;
        int i2 = i - 1;
        long j3 = (((long) this.kValue[i2]) * j2) + j;
        long jRound = Math.round((j3 * this.weighting[i2]) + Math.round((1.0d - this.weighting[i2]) * remoteEndpoint.getRTO()));
        remoteEndpoint.setEstimatorValues(j3, j, j2, i);
        remoteEndpoint.setRTOtimestamp(System.currentTimeMillis(), i);
        remoteEndpoint.setRTOtimestamp(System.currentTimeMillis(), 0);
        remoteEndpoint.updateRTO(jRound);
    }

    @Override // org.eclipse.californium.core.network.stack.CongestionControlLayer
    public void processRTTmeasurement(long j, Exchange exchange, int i) {
        RemoteEndpoint remoteEndpoint = getRemoteEndpoint(exchange);
        int exchangeEstimatorState = remoteEndpoint.getExchangeEstimatorState(exchange);
        if (exchangeEstimatorState == 3) {
            return;
        }
        remoteEndpoint.matchCurrentRTO();
        if (remoteEndpoint.isBlindWeak() && exchangeEstimatorState == 2) {
            remoteEndpoint.setBlindWeak(false);
            initializeRTOEstimators(j, 2, remoteEndpoint);
        } else if (!remoteEndpoint.isBlindStrong() || exchangeEstimatorState != 1) {
            updateEstimator(j, exchangeEstimatorState, remoteEndpoint);
        } else {
            remoteEndpoint.setBlindStrong(false);
            initializeRTOEstimators(j, 1, remoteEndpoint);
        }
    }

    public void updateEstimator(long j, int i, RemoteEndpoint remoteEndpoint) {
        long jRound = Math.round(Math.abs(remoteEndpoint.getxRTT(i) - j) * 0.125d) + Math.round(remoteEndpoint.getxRTTVAR(i) * 0.875d);
        long jRound2 = Math.round(j * 0.25d) + Math.round(remoteEndpoint.getxRTT(i) * 0.75d);
        int i2 = i - 1;
        long j2 = (((long) this.kValue[i2]) * jRound) + jRound2;
        long jRound3 = Math.round((j2 * this.weighting[i2]) + Math.round((1.0d - this.weighting[i2]) * remoteEndpoint.getRTO()));
        remoteEndpoint.setEstimatorValues(j2, jRound2, jRound, i);
        remoteEndpoint.setRTOtimestamp(System.currentTimeMillis(), i);
        remoteEndpoint.setRTOtimestamp(System.currentTimeMillis(), 0);
        remoteEndpoint.updateRTO(jRound3);
    }
}
