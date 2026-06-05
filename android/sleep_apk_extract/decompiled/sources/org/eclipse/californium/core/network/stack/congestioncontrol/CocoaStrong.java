package org.eclipse.californium.core.network.stack.congestioncontrol;

import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.RemoteEndpoint;
import org.eclipse.californium.core.network.config.NetworkConfig;

/* JADX INFO: loaded from: classes5.dex */
public class CocoaStrong extends Cocoa {
    public CocoaStrong(NetworkConfig networkConfig) {
        super(networkConfig);
        setDithering(true);
    }

    @Override // org.eclipse.californium.core.network.stack.congestioncontrol.Cocoa, org.eclipse.californium.core.network.stack.CongestionControlLayer
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
            initializeRTOEstimators(j, 1, remoteEndpoint);
        }
    }
}
