package org.eclipse.californium.core.network.stack.congestioncontrol;

import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.RemoteEndpoint;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.network.stack.CongestionControlLayer;

/* JADX INFO: loaded from: classes5.dex */
public class LinuxRto extends CongestionControlLayer {
    public LinuxRto(NetworkConfig networkConfig) {
        super(networkConfig);
    }

    public void initializeRTOEstimators(long j, int i, RemoteEndpoint remoteEndpoint) {
        remoteEndpoint.SRTT = j;
        long j2 = j / 2;
        remoteEndpoint.mdev = j2;
        long jMax = Math.max(j2, 50L);
        remoteEndpoint.mdev_max = jMax;
        remoteEndpoint.RTTVAR = jMax;
        long j3 = (jMax * 4) + remoteEndpoint.SRTT;
        remoteEndpoint.printLinuxStats();
        remoteEndpoint.updateRTO(j3);
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

    public void updateEstimator(long j, int i, RemoteEndpoint remoteEndpoint) {
        long jRound = Math.round((j - r0) * 0.125d) + remoteEndpoint.SRTT;
        remoteEndpoint.SRTT = jRound;
        long j2 = remoteEndpoint.mdev;
        if (j < jRound - j2) {
            remoteEndpoint.mdev = Math.round(Math.abs(j - remoteEndpoint.SRTT) * 0.03125d) + Math.round(j2 * 0.96875d);
        } else {
            remoteEndpoint.mdev = Math.round(Math.abs(j - remoteEndpoint.SRTT) * 0.25d) + Math.round(j2 * 0.75d);
        }
        long j3 = remoteEndpoint.mdev;
        if (j3 > remoteEndpoint.mdev_max) {
            remoteEndpoint.mdev_max = j3;
            if (j3 > remoteEndpoint.RTTVAR) {
                remoteEndpoint.RTTVAR = j3;
            }
        }
        long j4 = remoteEndpoint.mdev_max;
        long j5 = remoteEndpoint.RTTVAR;
        if (j4 < j5) {
            remoteEndpoint.RTTVAR = Math.round(remoteEndpoint.mdev_max * 0.25d) + Math.round(j5 * 0.75d);
        }
        remoteEndpoint.mdev_max = 50L;
        long j6 = (remoteEndpoint.RTTVAR * 4) + remoteEndpoint.SRTT;
        remoteEndpoint.printLinuxStats();
        remoteEndpoint.updateRTO(j6);
    }
}
