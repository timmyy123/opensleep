package org.eclipse.californium.core.network.stack.congestioncontrol;

import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.RemoteEndpoint;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.network.stack.CongestionControlLayer;

/* JADX INFO: loaded from: classes5.dex */
public class BasicRto extends CongestionControlLayer {
    public BasicRto(NetworkConfig networkConfig) {
        super(networkConfig);
    }

    @Override // org.eclipse.californium.core.network.stack.CongestionControlLayer
    public void processRTTmeasurement(long j, Exchange exchange, int i) {
        RemoteEndpoint remoteEndpoint = getRemoteEndpoint(exchange);
        int exchangeEstimatorState = remoteEndpoint.getExchangeEstimatorState(exchange);
        remoteEndpoint.setBlindStrong(false);
        remoteEndpoint.setBlindWeak(false);
        updateEstimator(j, exchangeEstimatorState, remoteEndpoint);
    }

    public void updateEstimator(long j, int i, RemoteEndpoint remoteEndpoint) {
        remoteEndpoint.updateRTO(j);
    }
}
