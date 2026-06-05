package org.eclipse.californium.core.network.stack.congestioncontrol;

import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.RemoteEndpoint;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.network.stack.CongestionControlLayer;

/* JADX INFO: loaded from: classes5.dex */
public class PeakhopperRto extends CongestionControlLayer {
    private int currentRtt;

    public PeakhopperRto(NetworkConfig networkConfig) {
        super(networkConfig);
        this.currentRtt = 0;
    }

    public long getMaxRtt(RemoteEndpoint remoteEndpoint) {
        long[] jArr = remoteEndpoint.RTT_sample;
        long j = jArr[0];
        long j2 = jArr[1];
        return j > j2 ? j : j2;
    }

    public void initializeRTOEstimators(long j, int i, RemoteEndpoint remoteEndpoint) {
        storeRttValue(remoteEndpoint, j);
        remoteEndpoint.updateRTO((long) (j * 1.75d));
    }

    @Override // org.eclipse.californium.core.network.stack.CongestionControlLayer
    public void processRTTmeasurement(long j, Exchange exchange, int i) {
        RemoteEndpoint remoteEndpoint = getRemoteEndpoint(exchange);
        int exchangeEstimatorState = remoteEndpoint.getExchangeEstimatorState(exchange);
        if (exchangeEstimatorState == 3 || exchangeEstimatorState == 2) {
            return;
        }
        remoteEndpoint.matchCurrentRTO();
        if (!remoteEndpoint.isBlindStrong() || exchangeEstimatorState != 1) {
            updateEstimator(j, exchangeEstimatorState, remoteEndpoint);
        } else {
            remoteEndpoint.setBlindStrong(false);
            initializeRTOEstimators(j, exchangeEstimatorState, remoteEndpoint);
        }
    }

    public void storeRttValue(RemoteEndpoint remoteEndpoint, long j) {
        long[] jArr = remoteEndpoint.RTT_sample;
        int i = this.currentRtt;
        jArr[i] = j;
        this.currentRtt = (i + 1) % 2;
    }

    public void updateEstimator(long j, int i, RemoteEndpoint remoteEndpoint) {
        storeRttValue(remoteEndpoint, j);
        double dAbs = Math.abs((j - remoteEndpoint.RTT_previous) / j);
        remoteEndpoint.delta = dAbs;
        remoteEndpoint.B_value = Math.min(Math.max(dAbs * 2.0d, remoteEndpoint.B_value * 0.9583333333333334d), 1.0d);
        remoteEndpoint.RTT_max = Math.max(j, remoteEndpoint.RTT_previous);
        remoteEndpoint.RTO_min = getMaxRtt(remoteEndpoint) + 100;
        long jMax = Math.max(Math.max((long) Math.max(remoteEndpoint.getRTO() * 0.9583333333333334d, (remoteEndpoint.B_value + 1.0d) * remoteEndpoint.RTT_max), remoteEndpoint.RTT_max + 100), remoteEndpoint.RTO_min);
        remoteEndpoint.printPeakhopperStats();
        remoteEndpoint.RTT_previous = j;
        remoteEndpoint.updateRTO(jMax);
    }
}
