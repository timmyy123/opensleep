package org.eclipse.californium.core.network.stack;

import org.eclipse.californium.core.network.Outbox;
import org.eclipse.californium.core.network.config.NetworkConfig;

/* JADX INFO: loaded from: classes5.dex */
public class CoapTcpStack extends BaseCoapStack {
    public CoapTcpStack(NetworkConfig networkConfig, Outbox outbox) {
        super(outbox);
        setLayers(new Layer[]{new TcpExchangeCleanupLayer(), new TcpObserveLayer(networkConfig), new BlockwiseLayer(networkConfig), new TcpAdaptionLayer()});
    }
}
