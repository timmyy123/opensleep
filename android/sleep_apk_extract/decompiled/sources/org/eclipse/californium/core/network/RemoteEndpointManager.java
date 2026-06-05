package org.eclipse.californium.core.network;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.network.stack.ReliabilityLayerParameters;

/* JADX INFO: loaded from: classes5.dex */
public class RemoteEndpointManager {
    private final ReliabilityLayerParameters defaultReliabilityLayerParameters;
    private final int MAX_REMOTE_ENDPOINTS = 10;
    private LimitedRemoteEndpointHashmap<InetAddress, RemoteEndpoint> remoteEndpointsList = new LimitedRemoteEndpointHashmap<>(10);

    public class LimitedRemoteEndpointHashmap<K, V> extends LinkedHashMap<K, V> {
        private static final long serialVersionUID = -7855412701242966797L;
        private final int maxSize;

        public LimitedRemoteEndpointHashmap(int i) {
            this.maxSize = i;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > this.maxSize;
        }
    }

    public RemoteEndpointManager(NetworkConfig networkConfig) {
        this.defaultReliabilityLayerParameters = ReliabilityLayerParameters.builder().applyConfig(networkConfig).build();
    }

    public RemoteEndpoint getRemoteEndpoint(Exchange exchange) {
        InetSocketAddress peerAddress = exchange.getRequest().getDestinationContext().getPeerAddress();
        InetAddress address = peerAddress.getAddress();
        int port = peerAddress.getPort();
        if (!this.remoteEndpointsList.containsKey(address)) {
            ReliabilityLayerParameters reliabilityLayerParameters = exchange.getRequest().getReliabilityLayerParameters();
            if (reliabilityLayerParameters == null) {
                reliabilityLayerParameters = this.defaultReliabilityLayerParameters;
            }
            this.remoteEndpointsList.put(address, new RemoteEndpoint(port, address, reliabilityLayerParameters));
        }
        return this.remoteEndpointsList.get(address);
    }
}
